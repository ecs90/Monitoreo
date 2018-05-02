package edu.utn.monitoreo.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityUsage {
    @Id
    @GeneratedValue
    private long id;
    @Basic //Mapeo de columna implicito
    private String os;
    @Basic
    private String browser;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
