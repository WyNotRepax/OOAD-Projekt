package de.enviado.akkuvita.shared.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import de.enviado.akkuvita.domain.entity.AusmusterungsEvent;

@ProxyFor(AusmusterungsEvent.class)
public interface AusmusterungsEventProxy extends EntityProxy {
    String getNotiz();
    void setNotiz(String notiz);
}
