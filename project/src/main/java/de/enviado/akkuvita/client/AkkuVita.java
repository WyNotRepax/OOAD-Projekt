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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.*;
import de.enviado.akkuvita.shared.AkkuVitaRequestFactory;

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

		VerticalPanel menuPanel = new VerticalPanel();
		VerticalPanel batteryListPanel = new VerticalPanel();
		VerticalPanel customerListPanel = new VerticalPanel();
		VerticalPanel newBatteryPanel = new VerticalPanel();

		Button batteryButton = new Button("Akku");
		Button customerButton = new Button("Kunde");
		Button newBatteryButton = new Button("Neuer Akku");

		batteryButton.setWidth("200px");
		customerButton.setWidth("200px");
		newBatteryButton.setWidth("200px");
		batteryButton.setHeight("100px");
		customerButton.setHeight("100px");
		newBatteryButton.setHeight("100px");

		HorizontalPanel wrapper = new HorizontalPanel();
		wrapper.add(menuPanel);

		batteryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				batteryListPanel.clear();
				FlexTable flexTable = createList();
				batteryListPanel.add(flexTable);
				wrapper.add(batteryListPanel);
				wrapper.remove(newBatteryPanel);
				wrapper.remove(customerListPanel);
			}
		});

		customerButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				wrapper.add(customerListPanel);
				wrapper.remove(batteryListPanel);
				wrapper.remove(newBatteryPanel);
			}
		});

		newBatteryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				wrapper.add(newBatteryPanel);
				wrapper.remove(batteryListPanel);
				wrapper.remove(customerListPanel);
			}
		});

		menuPanel.add(batteryButton);
		menuPanel.add(customerButton);
		menuPanel.add(newBatteryButton);

		RootPanel.get().add(wrapper);

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

	private FlexTable createList() {
		FlexTable t = new FlexTable();
		t.setBorderWidth(5);
		t.setCellPadding(5);
		t.setCellSpacing(3);
		//t.setWidth("1000px");
		
		TextBox snr = new TextBox();
		snr.setSize("300px", "50px");
		snr.setText("Akku Seriennummer");
		
		TextBox event= new TextBox();
		event.setSize("600px", "50px");
		event.setText("letztes Event");
		
		
		t.setWidget(0, 0, snr);
		t.setWidget(0, 1, event);
		
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j < 2; j++) {
				t.setText(i, j, "OK");
				testFill(t);
			}
		}
		return t;
	}

	private void testFill(FlexTable flexTable) {
		Button details = new Button("Weitere");
		details.setSize("120px", "60px");
		flexTable.setWidget(flexTable.getRowCount() - 1, 3, details);
	}

}
