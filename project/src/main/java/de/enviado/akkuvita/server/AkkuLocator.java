package de.enviado.akkuvita.server;

import com.google.web.bindery.requestfactory.shared.Locator;
import de.enviado.akkuvita.domain.Akku;
import org.hibernate.Session;


public class AkkuLocator extends Locator<Akku,Long> {
    @Override
    public Akku create(Class<? extends Akku> clazz) {
        return new Akku();
    }

    @Override
    public Akku find(Class<? extends Akku> clazz, Long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Akku akku = session.find(clazz,id);
            session.getTransaction().commit();
            return akku;
        }
    }

    @Override
    public Class<Akku> getDomainType() {
        return Akku.class;
    }

    @Override
    public Long getId(Akku domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Akku domainObject) {
        return domainObject.getVersion();
    }
}
