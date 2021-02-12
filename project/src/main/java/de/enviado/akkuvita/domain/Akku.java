package de.enviado.akkuvita.domain;


import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name="AKKU")
public class Akku implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="SERIAL")
    private String seriennummer;

    @NotNull
    @DecimalMin("0")
    @Column(name="VERSION")
    private Integer version = 0;

    public Akku(){
        this.seriennummer = "69";
    }

    protected Akku(Akku copyFrom){
        this.copyFrom(copyFrom);
    }

    public void copyFrom(Akku copyFrom){
        this.seriennummer = copyFrom.seriennummer;
        this.id = copyFrom.id;
        this.version = copyFrom.version;
    }

    /**
     * The RequestFactory requires a static finder method for each proxied type.
     * Soon it should allow you to customize how instances are found.
     */
    public static Akku findAkku(String id) {
        /*
         * TODO At the moment requestFactory requires a finder method per type It
         * should get more flexible soon.
         */
        return new Akku();
    }

    public void persist(){
        Logger logger = Logger.getLogger("AkkuLogger");
        logger.log(Level.INFO,"Persist called on " + this.toString());
        logger.log(Level.INFO, "Persist checkpoint 1");
        Session session = HibernateUtil.getSessionFactory().openSession();
        logger.log(Level.INFO, "Persist checkpoint 2");
        session.beginTransaction();
        logger.log(Level.INFO, "Persist checkpoint 3");
        session.saveOrUpdate(this);
        logger.log(Level.INFO, "Persist checkpoint 4");
        session.getTransaction().commit();
        logger.log(Level.INFO, "Persist checkpoint 5");
        session.close();
        logger.log(Level.INFO, "Persist checkpoint 6");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Akku createAkku(){
        return new Akku();
    }

    @Override
    public String toString() {
        return "Akku{" +
                "id='" + id + '\'' +
                ", seriennummer='" + seriennummer + '\'' +
                ", version=" + version +
                '}';
    }
}
