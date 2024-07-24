package com.airportagency.entities.Revision.domain.entity;

import java.sql.Date;

public class Revision {
    private String id;
    private Date revisionDate;
    private String idPlane;
    private String idDetails;

    public Revision() {}
    
    public Revision(String id, Date revisionDate, String idPlane, String idDetails) {
        this.id = id;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
        this.idDetails = idDetails;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(String idPlane) {
        this.idPlane = idPlane;
    }

    public String getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(String idDetails) {
        this.idDetails = idDetails;
    }
}
