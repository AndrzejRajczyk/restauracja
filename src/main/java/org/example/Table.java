package org.example;

import java.io.Serializable;

public class Table implements Serializable {
    private int seats;  //mejsca przy stolku - pojemnośc
    private boolean isReserved;  //stolik zajęty wo;ny
    private int tableNumber; // numer stolika
    private int reservationNumber; //numer rezerwacji

    public Table(int seats, int tableNumber) {
        this.seats = seats;
        this.isReserved = false;
        this.tableNumber = tableNumber;
        this.reservationNumber = reservationNumber;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void reserve(int reservationNumber) {
        setReservationNumber(reservationNumber);
        isReserved = true;
    }

    public void cancelReservation(int reservationNumber) {
        setReservationNumber(15071410);
        isReserved = false;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

}
