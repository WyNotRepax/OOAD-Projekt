package de.enviado.akkuvita.shared.service;

import com.google.web.bindery.requestfactory.shared.ExtraTypes;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import de.enviado.akkuvita.domain.entity.AkkuEvent;
import de.enviado.akkuvita.shared.proxy.AkkuEventProxy;
import de.enviado.akkuvita.shared.proxy.AkkuPruefungsEventProxy;

@Service(AkkuEvent.class)
@ExtraTypes(AkkuPruefungsEventProxy.class)
public interface AkkuEventRequest extends RequestContext {
    InstanceRequest<AkkuEventProxy, Void> persist();
}
