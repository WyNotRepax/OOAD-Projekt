package de.enviado.akkuvita.domain.entity;

import de.enviado.akkuvita.server.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
public class AkkuEvent {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name="DATE")
    private Date date;

    @NotNull
    @DecimalMin("0")
    @Column(name="VERSION")
    private Integer version = 0;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "SERIAL")
    private Akku akku;

    public AkkuEvent(){

    }

    public AkkuEvent(AkkuEvent copyFrom){
        this();
        this.copyFrom(copyFrom);
    }

    protected void copyFrom(AkkuEvent copyFrom){
        this.id = copyFrom.id;
        this.date = copyFrom.date;
        this.version = copyFrom.version;
        this.akku = copyFrom.akku;
    }

    public void persist(){
        Logger logger = Logger.getLogger("AkkuLogger");
        logger.log(Level.INFO, "Persist called on " + this.toString());
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.saveOrUpdate(this.akku);
            session.saveOrUpdate(this);
            session.getTransaction().commit();
        }
    }

    public static AkkuEvent findAkkuEvent(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            AkkuEvent akkuEvent = session.find(AkkuEvent.class,id);
            session.getTransaction().commit();
            return akkuEvent;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Akku getAkku() {
        return akku;
    }

    public void setAkku(Akku akku) {
        this.akku = akku;
        akku.addEvent(this);
    }


}
