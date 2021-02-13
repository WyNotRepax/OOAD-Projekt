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
package de.enviado.akkuvita.shared;

import com.google.web.bindery.requestfactory.shared.*;
import de.enviado.akkuvita.shared.service.AkkuEventRequest;
import de.enviado.akkuvita.shared.service.AkkuPruefungsEventRequest;
import de.enviado.akkuvita.shared.service.AkkuRequest;

/**
 * Instantiate via
 * {@link com.google.gwt.core.client.GWT#create}.
 */
public interface AkkuVitaRequestFactory extends RequestFactory {
  AkkuRequest akkuRequest();
  AkkuEventRequest akkuEventRequest();
  AkkuPruefungsEventRequest akkuPruefungsEventRequest();
}