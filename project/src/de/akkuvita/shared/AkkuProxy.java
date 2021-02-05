package de.akkuvita.shared;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import de.akkuvita.domain.Akku;

@ProxyFor(Akku.class)
public interface AkkuProxy extends ValueProxy {
    public String getSeriennummer();
    //public Date getProduktionsdatum();
    public int getReperaturanzahl();
}
