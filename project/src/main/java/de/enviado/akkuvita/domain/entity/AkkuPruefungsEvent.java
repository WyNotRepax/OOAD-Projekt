package de.enviado.akkuvita.domain.entity;

import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AkkuPruefungsEvent extends AkkuEvent {

    @Column(name = "NOTE")
    private String notiz;

    @Column(name = "CAPACITY")
    private Float kapazitaet;

    @Column(name = "TICKET")
    private Integer ticketnr;

    @Column(name = "CYCLES")
    private Integer ladezyklen;

    @ManyToOne
    @NotNull
    @JoinColumn(name="CUSTOMERID")
    private Kunde kunde;

    public AkkuPruefungsEvent() {
        super();
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }

    public Float getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(Float kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public Integer getTicketnr() {
        return ticketnr;
    }

    public void setTicketnr(Integer ticketnr) {
        this.ticketnr = ticketnr;
    }

    public Integer getLadezyklen() {
        return ladezyklen;
    }

    public void setLadezyklen(Integer ladezyklen) {
        this.ladezyklen = ladezyklen;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        kunde.addAkkuPruefungsEvent(this);
        this.kunde = kunde;
    }

    @Override
    public String toString() {
        return "AkkuPruefungsEvent{" +
                "notiz='" + notiz + '\'' +
                ", kapazitaet=" + kapazitaet +
                ", ticketnr=" + ticketnr +
                ", ladezyklen=" + ladezyklen +
                "} " + super.toString();
    }

    public static AkkuEvent findAkkuPruefungsEvent(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            AkkuEvent akkuEvent = session.find(AkkuPruefungsEvent.class,id);
            session.getTransaction().commit();
            return akkuEvent;
        }
    }
}
