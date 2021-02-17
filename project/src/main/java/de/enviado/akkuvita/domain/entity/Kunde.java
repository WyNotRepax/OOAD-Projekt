package de.enviado.akkuvita.domain.entity;

import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
public class Kunde {
    @Id
    @Column(name = "CUSTOMERID")
    @NotNull
    private Integer kundennummer;

    @Column(name="NAME")
    private String name;

    @Column(name = "ORGANISATION")
    private String firma;

    @OneToMany
    @NotNull
    private Set<AkkuPruefungsEvent> events;

    @NotNull
    @DecimalMin("0")
    @Column(name = "VERSION")
    private Integer version = 0;

    public Kunde(){
        events = new HashSet<>();
    }

    public Kunde(Kunde copyFrom){
        this();
        this.copyFrom(copyFrom);
    }

    private void copyFrom(Kunde copyFrom) {
        this.kundennummer = copyFrom.kundennummer;
        this.name = copyFrom.name;
        this.firma = copyFrom.firma;
        this.events = copyFrom.events;
        this.version = copyFrom.version;
    }

    public Integer getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(Integer kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    /**
     * Required by {@link de.enviado.akkuvita.shared.AkkuVitaRequestFactory}
     * Delegates via {@link Akku#getSeriennummer()} }
     * @return {@link Kunde#kundennummer}
     */
    public Integer getId() {
        return this.getKundennummer();
    }

    /**
     * Required by {@link de.enviado.akkuvita.shared.AkkuVitaRequestFactory}
     * Delegates via {@link Kunde#setKundennummer(Integer)} ()} }
     */
    public void setId(Integer id) {
        this.setKundennummer(id);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void persist() {
        Logger logger = Logger.getLogger("KundenLogger");
        logger.log(Level.INFO, "Persist called on " + this.toString());
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(this);
            session.getTransaction().commit();
        }
    }

    public static Kunde findKunde(Integer id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Kunde kunde = session.find(Kunde.class,id);
            session.getTransaction().commit();
            return kunde;
        }
    }

    public void addAkkuPruefungsEvent(AkkuPruefungsEvent akkuPruefungsEvent){
        this.events.add(akkuPruefungsEvent);
    }
}
