/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.enviado.akkuvita.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.*;

import cern.colt.Arrays;
import de.enviado.akkuvita.domain.entity.Kunde;
import de.enviado.akkuvita.shared.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.enviado.akkuvita.shared.proxy.AkkuProxy;
import de.enviado.akkuvita.shared.proxy.AkkuPruefungsEventProxy;
import de.enviado.akkuvita.shared.proxy.KundeProxy;
import de.enviado.akkuvita.shared.service.AkkuEventRequest;
import de.enviado.akkuvita.shared.service.AkkuRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry point class which performs the initial loading of the AkkuVita
 * application.
 */
public class AkkuVita implements EntryPoint {

	private static final Logger log = Logger.getLogger(AkkuVita.class.getName());

	private EventBus eventBus = new SimpleEventBus();

	/**
	 * This method sets up the top-level services used by the application.
	 */
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		});

		createMenu();

		final AkkuVitaRequestFactory requests = GWT.create(AkkuVitaRequestFactory.class);
		requests.initialize(eventBus);

		// Fast test to see if the sample is not being run from devmode
		if (GWT.getHostPageBaseURL().startsWith("file:")) {
			log.log(Level.SEVERE,
					"The AkkuVita cannot be run without its"
							+ " server component.  If you are running the sample from a"
							+ " GWT distribution, use the 'ant devmode' target to launch" + " the Server.");
		}
	}

	private void createMenu() {
		VerticalPanel menuPanel = new VerticalPanel();
		VerticalPanel batteryListPanel = new VerticalPanel();
		VerticalPanel customerListPanel = new VerticalPanel();
		VerticalPanel newPanel = new VerticalPanel();
		HorizontalPanel filterButtons = new HorizontalPanel();
		HorizontalPanel wrapper = new HorizontalPanel();

		Button batteryButton = new Button("Akku");
		Button customerButton = new Button("Kunde");
		Button newBatteryButton = new Button("Neu");

		batteryButton.setWidth("200px");
		customerButton.setWidth("200px");
		newBatteryButton.setWidth("200px");
		batteryButton.setHeight("100px");
		customerButton.setHeight("100px");
		newBatteryButton.setHeight("100px");

		TextBox filterSN = new TextBox();
		TextBox filterCID = new TextBox();
		Button search = new Button("Suchen");

		wrapper.add(menuPanel);

		batteryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				batteryListPanel.clear();
				filterButtons.clear();
				FlexTable flexTable = createBatteryList();
				filterButtons.add(filterSN);
				filterButtons.add(search);
				batteryListPanel.add(filterButtons);
				batteryListPanel.add(flexTable);
				wrapper.add(batteryListPanel);
				wrapper.remove(newPanel);
				wrapper.remove(customerListPanel);
			}
		});

		customerButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				customerListPanel.clear();
				filterButtons.clear();
				filterButtons.add(filterCID);
				filterButtons.add(search);
				customerListPanel.add(filterButtons);
				customerListPanel.add(createCustomerList());
				wrapper.add(customerListPanel);
				wrapper.remove(batteryListPanel);
				wrapper.remove(newPanel);
			}
		});

		newBatteryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TabPanel tp = new TabPanel();
				tp.add(newBattery(), "Akku hinzufügen");
				tp.add(newCustomer(), "|   Kunde hinzufügen");
				tp.add(newEvent(), "|   Event hinzufügen");
				newPanel.clear();
				newPanel.add(tp);
				wrapper.add(newPanel);
				wrapper.remove(batteryListPanel);
				wrapper.remove(customerListPanel);
			}
		});

		menuPanel.add(batteryButton);
		menuPanel.add(customerButton);
		menuPanel.add(newBatteryButton);

		RootPanel.get().add(wrapper);

	}

	private HorizontalPanel newCustomer() {
		HorizontalPanel BatteryForm = new HorizontalPanel();
		FlexTable form = new FlexTable();
		form.setCellPadding(3);
		form.setCellSpacing(3);
		form.setText(0, 0, "Kunden ID");
		form.setText(1, 0, "Name");
		form.setText(2, 0, "Firma");

		TextBox kundenid = new TextBox();
		TextBox name = new TextBox();
		TextBox firma = new TextBox();

		Button save = new Button("speichern");

		form.setWidget(0, 1, kundenid);
		form.setWidget(1, 1, name);
		form.setWidget(2, 1, firma);
		form.setWidget(0, 3, save);
		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (kundenid.getText().toString().isEmpty()) {
					Window.alert("Daten sind nicht korrekt eingetragen");
				}
				// Hier Daten speichern
			}
		});
		{

		}
		BatteryForm.add(form);

		return BatteryForm;
	}

	private VerticalPanel newEvent() {
		VerticalPanel eventForm = new VerticalPanel();
		FlexTable form = new FlexTable();
		RadioButton pruefung = new RadioButton("EventGroup", "Pruefung");
		RadioButton reparatureingang = new RadioButton("EventGroup", "Reparatureingang");
		RadioButton reparaturausgang = new RadioButton("EventGroup", "Reparaturausgang");
		RadioButton ausmusterung = new RadioButton("EventGroup", "Ausmusterung");
		HorizontalPanel radioButtons = new HorizontalPanel();
		radioButtons.add(pruefung);
		radioButtons.add(reparaturausgang);
		radioButtons.add(reparatureingang);
		radioButtons.add(ausmusterung);
		form.setCellPadding(5);
		form.setCellSpacing(5);
		
		TextBox snr = new TextBox();
		TextBox kundenID = new TextBox();
		TextBox kapazitaet = new TextBox();
		TextBox ladezyklen = new TextBox();
		TextBox ticketNr = new TextBox();
		ListBox defekte = new ListBox();
		defekte.addItem("1 Does not charge");
		defekte.addItem("2 Charging socket defective/loose");
		defekte.addItem("3.1 sporadic error (Charging)");
		defekte.addItem("3.2 sporadic error (Bike)");
		defekte.addItem("4 casing front broken");
		defekte.addItem("5 casing back broken");
		defekte.addItem("6 Casing broken / defective");
		TextArea notiz = new TextArea();
		DatePicker reparaturausgangsdatum = new DatePicker();
		TextBox reparateur = new TextBox();
		DatePicker reparatureingangsdatum = new DatePicker();
		DatePicker ausmusterungsdatum = new DatePicker();
		Button save = new Button("speichern");

		pruefung.addClickHandler(new ClickHandler() {

			
			@Override
			public void onClick(ClickEvent event) {
				if (pruefung.isEnabled()) {
					form.removeAllRows();
					form.setText(0, 0, "Seriennummer");
					form.setWidget(0, 1, snr);
					form.setText(1, 0, "Kunden ID");
					form.setWidget(1, 1, kundenID);
					form.setText(2, 0, "Kapazität");
					form.setWidget(2, 1, kapazitaet);
					form.setText(3, 0, "Ladezyklen");
					form.setWidget(3, 1, ladezyklen);
					form.setText(4, 0, "Ticket Nr.");
					form.setWidget(4, 1, ticketNr);
					form.setText(5, 0, "Defekt");
					form.setWidget(5, 1, defekte);
					form.setText(6, 0, "Notizen");
					form.setWidget(6, 1, notiz);
				}
			}
		});

		reparaturausgang.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (reparaturausgang.isEnabled()) {
					form.removeAllRows();
					form.setText(0, 0, "Seriennummer");
					form.setWidget(0, 1, snr);
					form.setText(1, 0, "Reparaturausgangsdatum");
					form.setWidget(1, 1, reparaturausgangsdatum);
					form.setText(3, 0, "Reparateur");
					form.setWidget(3, 1, reparateur);
					form.setText(4, 0, "Notizen");
					form.setWidget(4, 1, notiz);
				}
			}

		});

		reparatureingang.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (reparatureingang.isEnabled()) {
					form.removeAllRows();
					form.setText(0, 0, "Seriennummer");
					form.setWidget(0, 1, snr);
					form.setText(1, 0, "Reparatureingangsdatum");
					form.setWidget(1, 1, reparatureingangsdatum);
					form.setText(3, 0, "Notizen");
					form.setWidget(3, 1, notiz);
				}
			}

		});

		ausmusterung.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (ausmusterung.isEnabled()) {
					form.removeAllRows();
					form.setText(0, 0, "Seriennummer");
					form.setWidget(0, 1, snr);
					form.setText(1, 0, "Ausmusterungsdatum");
					form.setWidget(1, 1, ausmusterungsdatum);
					form.setText(3, 0, "Notizen");
					form.setWidget(3, 1, notiz);
				}
			}

		});

		


		save.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(snr.getText().toString().isEmpty()) {
					Window.alert("Daten sind nicht korrekt eingegeben");
				}
			}
			
		});
		eventForm.add(radioButtons);
		eventForm.add(form);
		eventForm.add(save);

		return eventForm;
	}

	private HorizontalPanel newBattery() {

		HorizontalPanel BatteryForm = new HorizontalPanel();
		FlexTable form = new FlexTable();
		form.setCellPadding(3);
		form.setCellSpacing(3);
		form.setText(0, 0, "Seriennummer");
		form.setText(1, 0, "Produktionsdatum");
		form.setText(2, 0, "Reparaturanzahl");

		TextBox snr = new TextBox();
		DatePicker produktionsdatum = new DatePicker();
		TextBox reparaturanzahl = new TextBox();

		Button save = new Button("speichern");

		form.setWidget(0, 1, snr);
		form.setWidget(1, 1, produktionsdatum);
		form.setWidget(2, 1, reparaturanzahl);
		form.setWidget(0, 3, save);
		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (snr.getText().toString().isEmpty()) {
					Window.alert("Daten sind nicht korrekt eingetragen");
				}
				if (Integer.parseInt(reparaturanzahl.toString()) < 0) {
					Window.alert("Daten sind nicht korrekt eingetragen");
				}
				// Hier Daten speichern
			}
		});
		{

		}
		BatteryForm.add(form);

		return BatteryForm;
	}

	private FlexTable createCustomerList() {
		return createList("Kunden ID", "letztes Event");
	}

	private FlexTable createBatteryList() {
		return createList("Akku Seriennummer", "letztes Event");
	}

	private FlexTable createList(String h1, String h2) {
		FlexTable t = new FlexTable();
		t.setBorderWidth(5);
		t.setCellPadding(5);
		t.setCellSpacing(3);
		// t.setWidth("1000px");

		TextBox snr = new TextBox();
		snr.setSize("300px", "50px");
		snr.setText(h1);

		TextBox event = new TextBox();
		event.setSize("600px", "50px");
		event.setText(h2);

		t.setWidget(0, 0, snr);
		t.setWidget(0, 1, event);

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < 2; j++) {
				t.setText(i, j, "OK");
				generateButtons(t, i);
			}
		}
		return t;
	}

	private void generateButtons(FlexTable wrapperFlexTable, int counter) {
		Button moreButton = new Button("Weitere");
		moreButton.setSize("120px", "60px");
		wrapperFlexTable.setWidget(wrapperFlexTable.getRowCount() - 1, 2, moreButton);

		VerticalPanel moreEvents = new VerticalPanel();
		FlexTable events = new FlexTable();
		Button detailsButton = new Button("Details");
		Button addEventButten = new Button("Neues Event");
		HorizontalPanel buttons = new HorizontalPanel();
		buttons.add(detailsButton);
		buttons.add(addEventButten);

		moreButton.addClickHandler(new AkkuVitaRowClickHandler(counter) {

			@Override
			public void onClick(ClickEvent event) {
				moreEvents.clear();

				for (int i = 1; i <= 5; i++) {
					events.setText(i, 0, "OK");
				}
				moreEvents.add(events);
				moreEvents.add(buttons);
				wrapperFlexTable.setWidget(counter, 1, moreEvents);
			}

		});
	}

}
