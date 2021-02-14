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
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.*;
import de.enviado.akkuvita.domain.entity.Kunde;
import de.enviado.akkuvita.shared.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import de.enviado.akkuvita.shared.proxy.AkkuProxy;
import de.enviado.akkuvita.shared.proxy.AkkuPruefungsEventProxy;
import de.enviado.akkuvita.shared.proxy.KundeProxy;
import de.enviado.akkuvita.shared.service.AkkuEventRequest;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry point class which performs the initial loading of the AkkuVita
 * application.
 */
public class AkkuVita implements EntryPoint {
  interface Binder extends UiBinder<Widget, AkkuVita> {
  }

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

    final AkkuVitaRequestFactory requests = GWT.create(AkkuVitaRequestFactory.class);
    requests.initialize(eventBus);


    AkkuEventRequest context2 = requests.akkuEventRequest();
    AkkuPruefungsEventProxy akkuEventProxy = context2.create(AkkuPruefungsEventProxy.class);
    KundeProxy kundeProxy = context2.create(KundeProxy.class);
    kundeProxy.setKundennummer(69);
    AkkuProxy akku2 = context2.create(AkkuProxy.class);
    akku2.setSeriennummer("ID");
    akkuEventProxy.setAkku(akku2);
    akkuEventProxy.setDate(new Date());
    akkuEventProxy.setLadezyklen(12);
    akkuEventProxy.setKunde(kundeProxy);
    Request<Void> voidRequest = context2.persist().using(akkuEventProxy);
    voidRequest.fire();


    // Fast test to see if the sample is not being run from devmode
    if (GWT.getHostPageBaseURL().startsWith("file:")) {
      log.log(Level.SEVERE, "The AkkuVita cannot be run without its"
          + " server component.  If you are running the sample from a"
          + " GWT distribution, use the 'ant devmode' target to launch"
          + " the DTRF server.");
    }
  }
}
