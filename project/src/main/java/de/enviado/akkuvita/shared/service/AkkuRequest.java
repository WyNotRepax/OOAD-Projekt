package de.enviado.akkuvita.shared.service;

import com.google.web.bindery.requestfactory.shared.*;
import de.enviado.akkuvita.domain.entity.Akku;
import de.enviado.akkuvita.shared.proxy.AkkuProxy;


@Service(Akku.class)
public interface AkkuRequest extends RequestContext {
    InstanceRequest<AkkuProxy, Void> persist();
    Request<AkkuProxy> findAkku(String seriennummer);
}
