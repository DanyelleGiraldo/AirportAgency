package com.airportagency.entities.TripBooking.domain.entity;

import java.time.LocalDate;

public class TripBooking {
     private String id;
    private LocalDate bookinDate;
    private String idTrip;
    private int idBookingStatus;
    private String idCustomer;

    public TripBooking() {}

    public TripBooking(String id, LocalDate bookinDate, String idTrip, int idBookingStatus, String idCustomer) {
        this.id = id;
        this.bookinDate = bookinDate;
        this.idTrip = idTrip;
        this.idBookingStatus = idBookingStatus;
        this.idCustomer = idCustomer;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookinDate;
    }

    public void setBookingDate(LocalDate bookinDate) {
        this.bookinDate = bookinDate;
    }

    public String getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(String idTrip) {
        this.idTrip = idTrip;
    }

    public int getIdBookingStatus() {
        return idBookingStatus;
    }

    public void setIdBookingStatus(int idBookingStatus) {
        this.idBookingStatus = idBookingStatus;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
}
