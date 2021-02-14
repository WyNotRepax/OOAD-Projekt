package de.enviado.akkuvita.domain.entity;


import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AusmusterungsEvent extends AkkuEvent{
    @Column(name = "NOTE")
    private String notiz;

    public AusmusterungsEvent() {
        super();
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    public static AkkuEvent findReperaturEingangsEvent(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            AkkuEvent akkuEvent = session.find(AusmusterungsEvent.class,id);
            session.getTransaction().commit();
            return akkuEvent;
        }
    }

}
