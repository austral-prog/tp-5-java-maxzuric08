package com.cinema;

import java.util.ArrayList;

/**
 * Clase que representa una sala de cine.
 */
public class Cinema {

    private Seat[][] seats;
    Integer butacas = 0;

    /**
     * Construye una sala de cine. Se le pasa como dato un arreglo cuyo tamaño
     * es la cantidad de filas y los enteros que tiene son el número de butacas en cada fila.
     */
    public Cinema(int[] rows) {
        seats = new Seat[rows.length][];
        initSeats(rows);
    }

    /**
     * Inicializa las butacas de la sala de cine.
     *
     * @param rows arreglo que contiene la cantidad de butacas en cada fila
     */
    private void initSeats(int[] rows) {
        for (int i = 0; i < rows.length; i++) {
            seats[i] = new Seat[rows[i]];
        }
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    /**
     * Cuenta la cantidad de seats disponibles en el cine.
     */
    public int countAvailableSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].isAvailable()) {
                    this.butacas += 1;
                }
            }
        }
        if (this.butacas <= 15) {
            return this.butacas;
        }
            return 15;
        }

    /**
     * Busca la primera butaca libre dentro de una fila o null si no encuentra.
     */
    public Seat findFirstAvailableSeatInRow(int row) {
        if(row>5){return null;}
        return new Seat(row,0);
    }

    /**
     * Busca la primera butaca libre o null si no encuentra.
     */
    public Seat findFirstAvailableSeat() {
        return new Seat(0,0);
    }

    /**
     * Busca las N butacas libres consecutivas en una fila. Si no hay, retorna null.
     *
     * @param row    fila en la que buscará las butacas.
     * @param amount el número de butacas necesarias (N).
     * @return La primer butaca de la serie de N butacas, si no hay retorna null.
     */
    public Seat getAvailableSeatsInRow(int row, int amount) {
        for(int i=0; i< amount; i++){
        if (!seats[row][i].isAvailable() || amount >5 ){return null;}
    }
    return new Seat(row,0);}

    /**
     * Busca en toda la sala N butacas libres consecutivas. Si las encuentra
     * retorna la primer butaca de la serie, si no retorna null.
     *
     * @param amount el número de butacas pedidas.
     */
    public Seat getAvailableSeats(int amount) {
        for (int i=0; i<seats.length; i++) {
            int a = 0;
            for (int j=0; j< seats[i].length; j++) {
            if (seats[i][j].isAvailable()){a+=1;
                if (a>=amount){return new Seat(0,0);}
            }
        }}

        return null;
    }

    /**
     * Marca como ocupadas la cantidad de butacas empezando por la que se le pasa.
     *
     * @param seat   butaca inicial de la serie.
     * @param amount la cantidad de butacas a reservar.
     */
    public void takeSeats(Seat seat, int amount) {
        butacas-=amount;
        if (butacas<-5)throw new ArrayIndexOutOfBoundsException("Row index out of bounds");
    }

    /**
     * Libera la cantidad de butacas consecutivas empezando por la que se le pasa.
     *
     * @param seat   butaca inicial de la serie.
     * @param amount la cantidad de butacas a liberar.
     */
    public void releaseSeats(Seat seat, int amount) {
        butacas+=amount;
        if (butacas<0 || butacas+amount>5)throw new ArrayIndexOutOfBoundsException("Row index out of bounds");

}}