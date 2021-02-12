package de.enviado.akkuvita.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import de.enviado.akkuvita.domain.Akku;
import de.enviado.akkuvita.server.AkkuLocator;

@ProxyFor(value = Akku.class, locator = AkkuLocator.class)
public interface AkkuProxy extends EntityProxy {
    String getSeriennummer();
    void setSeriennummer(String seriennummer);

    Long getId();
}
