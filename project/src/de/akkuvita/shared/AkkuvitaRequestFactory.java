package de.akkuvita.shared;

import com.google.web.bindery.requestfactory.shared.*;
import de.akkuvita.domain.Akku;

public interface AkkuvitaRequestFactory extends RequestFactory {

    @Service(Akku.class)
    interface AkkuRequest extends RequestContext {
        InstanceRequest<AkkuProxy, Void> persist();
    }

    AkkuRequest akkuRequest();
}
