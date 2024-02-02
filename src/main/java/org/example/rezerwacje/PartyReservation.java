package org.example.rezerwacje;

import org.example.Table;

public class PartyReservation extends Reservation { // klasa analogiczna dla Copule Reservation zmaiana tylko w implemnetacji metody


    public PartyReservation(Table table, int reservationNumber) {
        super(table, reservationNumber);
    }

    @Override
    public void reserve(int reservationCounter) {
        table.reserve(reservationCounter);
        System.out.println("Zarezerwowano stolik dla kilku osób." + " Numer stolika to: " + table.getTableNumber());
        System.out.println("Numer rezerwacji to: " + reservationNumber() );
        System.out.println("Dziękujemy...");
    }
}