package org.example.rezerwacje;

import org.example.Table;

public class CoupleReservation extends Reservation {

    public CoupleReservation(Table table, int reservationNumber) {
        super(table, reservationNumber);
    }


    @Override
    public void reserve(int reservationCounter) {          //nadpisana metoda rezerwacji z ogólnej klasy Reservation
        table.reserve(reservationCounter);
        System.out.println("Zarezerwowano stolik dla 2 osób." + " Numer stolika to: " + table.getTableNumber());
        System.out.println("Numer rezerwacji to: " + reservationNumber() );
        System.out.println("Dziękujemy...");
    }
}