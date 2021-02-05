package de.akkuvita.domain;


import java.io.Serializable;


public class Akku implements Serializable {
    private Long id;
    private Long version = 0L;
    private String seriennummer;
    private int reperaturanzahl;

    public Akku(Long id){
        System.exit(1);
        this.id = id;
        this.seriennummer = "187";
        this.reperaturanzahl = 0;
    }

    public static Akku createAkku(){
        System.exit(2);
        return new Akku(1L);
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public int getReperaturanzahl() {
        return reperaturanzahl;
    }

    public void setReperaturanzahl(int reperaturanzahl) {
        this.reperaturanzahl = reperaturanzahl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
