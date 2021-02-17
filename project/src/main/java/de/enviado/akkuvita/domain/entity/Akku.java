package de.enviado.akkuvita.domain.entity;


import de.enviado.akkuvita.server.HibernateUtil;
import de.enviado.akkuvita.shared.AkkuDefekt;
import org.hibernate.Session;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "AKKU")
public class Akku implements Serializable {
    @Id
    @NotNull
    @Column(name = "SERIAL", unique = true)
    private String seriennummer;

    @NotNull
    @DecimalMin("0")
    @Column(name = "VERSION")
    private Integer version = 0;

    @Column(name = "PRODUCTION_DATE")
    private Date produktionsdatum;


    @Column(name = "REPAIR_COUNT")
    @DecimalMin("0")
    @NotNull
    private Integer reperaturanzahl;

    @NotNull
    @OneToMany
    @JoinColumn(name="SERIAL")
    private Set<AkkuEvent> events;

    public Akku() {
        this.reperaturanzahl = 0;
        this.events = new HashSet<>();
    }

    protected Akku(Akku copyFrom) {
        this();
        this.copyFrom(copyFrom);
    }

    public void copyFrom(Akku copyFrom) {
        this.seriennummer = copyFrom.seriennummer;
        this.version = copyFrom.version;
        this.produktionsdatum = copyFrom.produktionsdatum;
        this.reperaturanzahl = copyFrom.reperaturanzahl;
        this.events = copyFrom.events;
    }


    /**
     * The RequestFactory requires a static finder method for each proxied type.
     * Soon it should allow you to customize how instances are found.
     */
    public static Akku findAkku(String id) {
        Logger logger = Logger.getLogger("FINDAKKU");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Akku akku = session.load(Akku.class, id);
            session.getTransaction().commit();
            logger.log(Level.INFO, "findAkku called with id "+ id +" returning " + akku.toString());
            return akku;
        }
    }

    public void persist() {
        Logger logger = Logger.getLogger("AkkuLogger");
        logger.log(Level.INFO, "Persist called on " + this.toString());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(this);
            session.getTransaction().commit();
        }
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static Akku createAkku() {
        return new Akku();
    }

    public Date getProduktionsdatum() {
        return produktionsdatum;
    }

    public void setProduktionsdatum(Date produktionsdatum) {
        this.produktionsdatum = produktionsdatum;
    }

    public Integer getReperaturanzahl() {
        return reperaturanzahl;
    }

    public void setReperaturanzahl(Integer reperaturanzahl) {
        this.reperaturanzahl = reperaturanzahl;
    }

    public void addEvent(AkkuEvent event) {
        events.add(event);
    }

    public Set<AkkuEvent> getEvents() {
        return events;
    }

    /**
     * Required by {@link de.enviado.akkuvita.shared.AkkuVitaRequestFactory}
     * Delegates via {@link Akku#getSeriennummer()} }
     * @return {@link Akku#seriennummer}
     */
    public String getId() {
        Logger logger = Logger.getLogger("GETID");
        logger.log(Level.INFO,"getId called on " + this.toString());
        return this.getSeriennummer();
    }

    /**
     * Required by {@link de.enviado.akkuvita.shared.AkkuVitaRequestFactory}
     * Delegates via {@link Akku#getSeriennummer()} }
     */
    public void setId(String id) {
        this.setSeriennummer(id);
    }
}
