package org.example.rezerwacje;

import org.example.Table;

import java.io.Serializable;

public abstract class Reservation implements Serializable {   // klasa abstrakcyjna  bez instamcji z jedną metoda bez ciała
    protected Table table;
    int reservationNumber;  //enkapsulacja prywatne w amach pakietu

    public Reservation(Table table,  int reservationNumber ) {
        this.table = table;
        this.reservationNumber = reservationNumber;
    }

    public abstract void reserve(int reservationCounter);   // pusta metoda bez implementacji

    public int reservationNumber() { // metoda nie abstrakcyjna będzie taka sama dla dzieci
        return reservationNumber;
    }
}