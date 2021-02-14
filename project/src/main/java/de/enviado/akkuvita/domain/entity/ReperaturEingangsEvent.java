package de.enviado.akkuvita.domain.entity;


import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ReperaturEingangsEvent extends AkkuEvent{
    @Column(name = "NOTE")
    private String notiz;

    public ReperaturEingangsEvent() {
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
            AkkuEvent akkuEvent = session.find(ReperaturEingangsEvent.class,id);
            session.getTransaction().commit();
            return akkuEvent;
        }
    }

}
