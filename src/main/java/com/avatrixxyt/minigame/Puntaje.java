package com.avatrixxyt.minigame;

public class Puntaje 
{
	private String jugador;//Variable privada con el nombre del jugador
    private int puntuacion;//Crea variable privada con la puntuacion del jugador

    public Puntaje(String jugador, int puntuacion)//Lee el nombre del jugador y el puntaje
    {
        this.jugador = jugador;//Establece la variable del nombre
        this.puntuacion = puntuacion;//Establece la variable del puntaje
    }

    public String getJugador()//Variable del nombre del jugador
    {
        return jugador;//Regresa el valor del nombre 
    }

    public int getPuntuacion()
    {
        return puntuacion;//Regresa el valor de la puntuacion
    }
}
