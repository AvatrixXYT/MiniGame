package com.avatrixxyt.minigame;

import com.avatrixxyt.util.Clean;

import java.util.Random;
import java.util.Scanner;

public class LogicGameMath {
    TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();
    Random grn = new Random(System.currentTimeMillis()); //variable para el numero aleatorio
    Scanner tec = new Scanner(System.in);

    public int puntos;
    public int respuestaCorrecta;
    public int dificultad;

    public boolean perdiste;
    public boolean SalirDelJuego;
    
    public void GenOperation(int num1, int num2) {
        int tipoOP = grn.nextInt(1,4); //Genera un numero aleatorio entre 1 y 4
        
        if (tipoOP == 1) {
            GameUI.gameMath(num1, num2," + ");
            respuestaCorrecta = num1 + num2; //Suma
        } else if (tipoOP == 2) {
            GameUI.gameMath(num1, num2," - ");
            respuestaCorrecta = num1 - num2; //Resta
        } else if (tipoOP == 3) {
            GameUI.gameMath(num1, num2," * ");
            respuestaCorrecta = num1 * num2; //Multiplicacion
        } else if (tipoOP == 4) {
            GameUI.gameMath(num1, num2," / ");
            respuestaCorrecta = num1 / num2; //Division
        }
    }
    
    public void InGame(int Respuesta) {
        if (Respuesta == 0) {
            SalirDelJuego = true;
        } else if (Respuesta == respuestaCorrecta) {
            puntos += dificultad; //Suma 100 puntos
        } else {
            perdiste = true;
        }
    }
    public void CalcularDificultad()
    {
        if (puntos > 10000) {
            dificultad = 500;
        } else if (puntos > 5000) {
            dificultad = 200;
        } else if (puntos >= 0) {
            dificultad = 50;
        }
    }
}
