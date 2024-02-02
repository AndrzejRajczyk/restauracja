package org.example;

import org.example.rezerwacje.CoupleReservation;
import org.example.rezerwacje.PartyReservation;
import org.example.rezerwacje.Reservation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant  {  // główna klasa

    private static List<Table> tables = new ArrayList<>(); //tablica ze stolikami dodałem 2,4,i 10 osobowe
// wybrałem odpowiednio 10,2 oraz 5 jako liczby tolików początkowo dostępnch
    static List<Integer> reservationsList = new ArrayList<>();
    public static void main(String[] args) {


        int reservationCounter = 0; //liczniki rezerwacji i nnumerków stolika wraz z inicjacją zmiennej od 0
        int tableCounter = 0;
        // produkowanie  stołów i ich numerków
        for (int i = 0; i < 10; i++) {
            tableCounter++;
            tables.add(new Table(4, tableCounter));

        }
        for (int i = 0; i < 2; i++) {
            tableCounter++;
            tables.add(new Table(10, tableCounter));
        }
        for (int i = 0; i < 5; i++) {
            tableCounter++;
            tables.add(new Table(2, tableCounter));
        }
        System.out.println("Stoliki gotowe");
        // Interakcja z użytkownikiem
        Scanner scanner = new Scanner(System.in); // wczytywanie z klawiatury


        System.out.println("Wybierz opcję: 1 - Rezerwacja, 2 - Odwołanie rezerwacji, 3 - Wyjście");
        System.out.println("");
        int  optional = scanner.nextInt();
        while (true) {
          tables =  Storage.loadFromFile(tables,"restaurant_databse.dat");

            reservationsList = Storage.loadFromFileInt(reservationsList,"reservations_database.dat");
            reservationCounter = reservationsList.get(reservationsList.size()-1);
            switch (optional) {
                case 1:
                    System.out.println("Podaj liczbę osób (od 1 do 10):");
                     int seats = scanner.nextInt();
                     if (seats <= 2 ){seats=2;}                 //wybór stolika
                     if (seats>2 && seats<=4){seats=4;}
                     if (seats>4 && seats<=10){seats=10;}

                    Table table = findTable(seats);
                    if (table != null) {
                        Reservation reservation;
                        if (seats == 2 ) {
                            reservation = new CoupleReservation(table, ++reservationCounter);  //  polimorfizm
                            System.out.println("Stolik 2 osobowy");
                            reservation.reserve(reservationCounter);
                            reservationsList.add(reservationCounter);
                        }
                        if(seats==4){

                            reservation = new PartyReservation(table, ++reservationCounter);
                            System.out.println("Stolik 4 osobowy");
                            reservation.reserve(reservationCounter);
                            reservationsList.add(reservationCounter);

                        }
                        if (seats==10){
                            reservation = new PartyReservation(table, ++reservationCounter);
                            System.out.println("Stolik duży, 10  osobowy");
                            reservation.reserve(reservationCounter);
                            reservationsList.add(reservationCounter);
                        }

                        Storage.saveToFile(tables, "restaurant_databse.dat");
                        Storage.saveToFileInt(reservationsList ,"reservations_database.dat");


                    }
                    else {
                        System.out.println("Przepraszamy Brak dostępnych stolików");
                    }
                    showReservations();
                    System.out.println("Wybierz opcję: 1 - Rezerwacja, 2 - Odwołanie rezerwacji, 3 - Wyjście");
                    optional = scanner.nextInt();


                    break;
                case 2:
                    System.out.println("Podaj numer rezerwacji:");
                    int reservationNumber = scanner.nextInt();
                    Table reservedTable = findReservedTable(reservationNumber);
                    if (reservedTable != null) {
                        reservedTable.cancelReservation(reservationNumber);
                        System.out.println("Rezerwacja nr " + reservationNumber + " została odwołana.");
                    } else {
                        System.out.println("Brak rezerwacji o numerze " + reservationNumber + ".");
                    }
                    Storage.saveToFile(tables, "restaurant_databse.dat");
                    showReservations();
                    System.out.println("Wybierz opcję: 1 - Rezerwacja, 2 - Odwołanie rezerwacji, 3 - Wyjście");
                    optional = scanner.nextInt();
                    break;
                case 3:
                    Storage.saveToFile(tables, "restaurant_databse.dat");
                    Storage.saveToFileInt(reservationsList ,"reservations_database.dat");
                    return;
                default:
                    System.out.println("Wybierz poprawnie: 1 - Rezerwacja, 2 - Odwołanie rezerwacji, 3 - Wyjście");
                    Storage.saveToFile(tables, "restaurant_databse.dat");
                    break;
            }

             printAvailableTables();
             showReservations();
        }
    }

    private static Table findTable(int seats) {
        for (Table table : tables) {
            if (!table.isReserved() && table.getSeats() == seats) {
                return table;
            }
        }
        return null;
    }

    private static Table findReservedTable(int reservation) {
        for (Table table : tables) {
            if (table.isReserved() && table.getReservationNumber() == reservation) {
                return table;
            }
        }
        return null;
    }

    private static void printAvailableTables() {
        System.out.println("Dostępne aktualnie stoliki:");
        for (Table table : tables) {
            if (!table.isReserved()) {
                System.out.println("Stolik nr " + table.getTableNumber() + ", miejsca: " + table.getSeats());
            }
        }
    }

    private static void showReservations(){
        System.out.println("rezerwacje: \n");
        for (Table table : tables){
            if (table.isReserved()){
                System.out.println("Stolik nr " + table.getTableNumber() + ", miejsca: " + table.getSeats());
                System.out.println("Rezerwacja nr:" + table.getReservationNumber());
            }
        }

    }
}


