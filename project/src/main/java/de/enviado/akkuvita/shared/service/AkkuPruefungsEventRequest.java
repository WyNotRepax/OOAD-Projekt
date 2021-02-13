package de.enviado.akkuvita.shared.service;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import de.enviado.akkuvita.domain.entity.AkkuPruefungsEvent;
import de.enviado.akkuvita.shared.proxy.AkkuPruefungsEventProxy;

@Service(AkkuPruefungsEvent.class)
public interface AkkuPruefungsEventRequest extends RequestContext {
    InstanceRequest<AkkuPruefungsEventProxy, Void> persist();
}
