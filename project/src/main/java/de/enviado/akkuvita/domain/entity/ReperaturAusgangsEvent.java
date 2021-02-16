package de.enviado.akkuvita.domain.entity;


import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ReperaturAusgangsEvent extends AkkuEvent{
    @Column(name = "NOTE")
    private String notiz;

    public ReperaturAusgangsEvent() {
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
            AkkuEvent akkuEvent = session.find(ReperaturAusgangsEvent.class,id);
            session.getTransaction().commit();
            return akkuEvent;
        }
    }



}