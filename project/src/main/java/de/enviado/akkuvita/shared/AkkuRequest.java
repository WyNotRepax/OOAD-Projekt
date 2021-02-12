package de.enviado.akkuvita.shared;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import de.enviado.akkuvita.domain.Akku;

@Service(Akku.class)
public interface AkkuRequest extends RequestContext {
    InstanceRequest<AkkuProxy, Void> persist();
}
