package com.avatrixxyt.minigame;

import com.avatrixxyt.util.Clean;

import java.util.Random;
import java.util.Scanner;

public class ModosGame {
    Clean ex = new Clean();
    Scanner tec = new Scanner(System.in);
    Random grn = new Random(System.currentTimeMillis()); //variable para el numero aleatorio
    public void NumeroMagico() throws InterruptedException
    {
        LogicGame logic = new LogicGame();//Establecer la logica del juego
        int nm;//Inicio del numero magico
        int xn;//Numero x del usuario
        int vidas;//Numero de Vidas
        int ngmi = 1;//Numero Minimo a generar
        int ngma = 50;//Número Maximo a generar
        int p1;//Perimetro 1 para la pista
        int p2;//Perimetro 2 para la pista

        boolean jov;//While para jugar otra vez
        boolean selDificultad;//While de la dificultad

        String jugador;//Establecer nombre de jugador
        String reinJuego;//Switch para reiniciar el juego
        String dificultad;//Switch para seleccionar dificultad

        selDificultad = true;//Reinicia el valor del while
        while (selDificultad) {
            ex.clear();//Limpiar pantalla
            System.out.println("Seleciona la Dificultad");
            GameUI.tablaDeDificultad(Lenguaje.P17,Lenguaje.P18,Lenguaje.P19,Lenguaje.P20,Lenguaje.P21);//Muesta la tabla de dificultad
            GameUI.Salto();//Salto de linea
            System.out.print("<:");
            dificultad = tec.next();
            switch (dificultad) {
                case "0"://Regresar
                {
                    return;
                }
                case "1"://Facil
                {
                    ngma = 10;
                    break;
                }
                case "2"://Medio
                {
                    ngma = 25;
                    break;
                }
                case "3"://Dificil
                {
                    break;
                }
                default://Opcion invalida
            }//Switch de dificultad
            selDificultad = false;//Salir del menu de dificultad
        }
        ex.clear();//Limpiar pantalla
        logic.CalcularDificultad(ngma);//Calcula la dificultad
        System.out.println("Que empieze el Juego");
        nm = grn.nextInt(ngmi, ngma);//Genera el primer numero aleatorio
        vidas = logic.vidasInicial;//Te da las vidas para iniciar
        while (true) {
            GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad,Lenguaje.P25,Lenguaje.P26,Lenguaje.P27,Lenguaje.P28,Lenguaje.P29);//Valores del jugador
            GameUI.Salto();//Salto de linea
            System.out.println("Introduce un numero aleatorio entre " + ngmi + " y " + ngma);
            System.out.print("<: ");
            xn = tec.nextInt();
            logic.ComMinMax(ngmi, ngma, xn);//Da los valores para checar si el numero es valido o no y da el resultado
            if (logic.resultOP == 1) {
                return; //Salir del juego
            } else {
                if (logic.resultOP == 2) {
                    //if (logic.Pruebas(xn))//activar para hacer pruebas
                    if (logic.GameOperation(xn, nm))//Comprueva si le atinaste o no
                    {
                        jov = true;//Reinicia el valor del while
                        while (jov) {
                            ex.clear();//Limpiar pantalla
                            logic.CalcularPuntos(vidas, ngma);//Calcula los puntos que tienes
                            GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad,Lenguaje.P25,Lenguaje.P26,Lenguaje.P27,Lenguaje.P28,Lenguaje.P29);//Valores del jugador
                            GameUI.Salto();//Salto de linea
                            GameUI.ganaste(Lenguaje.P32);//Pantalla de ganar
                            GameUI.Salto();//Salto de linea
                            GameUI.jugarDeNuevo(Lenguaje.P30,Lenguaje.P31);//Opciones para jugar de nuevo
                            System.out.print("<:");
                            reinJuego = tec.next();
                            switch (reinJuego) {
                                case "1"://Seguir jugando para ganar más puntos
                                {
                                    ex.clear();//Limpiar pantalla
                                    nm = grn.nextInt(ngmi, ngma);//Genera un nuevo numero aleatorio
                                    vidas = vidas + 5;//Aumenta las vidas
                                    jov = false;//Salir de las opciones
                                    break;
                                }
                                case "2"://Caso 2 salir del juego y guardar puntuacion
                                {
                                    ex.clear();//Limpiar pantalla
                                    System.out.println("Ingresa tu nombre");
                                    System.out.print("<:");
                                    jugador = tec.next();
                                    logic.GuardarPuntuacion(jugador);//Guarda puntuacion en el JSON
                                    return;
                                }//Caso 2 salir del juego y guardar puntuacion
                                default://Default opcion invalida
                                {
                                    System.out.println("Opcion invalida");
                                    Thread.sleep(1000);//Tiempo en pausa 1 segundo
                                }//Opcion invalida
                            }//Switch para seguir jugando
                        }//While para seguir jugando
                    }//Cuando el numero es correcto
                    else//Cuando el numero es incorrecto y pierdes
                    {
                        ex.clear();//Limpiar pantalla
                        System.out.println("Numero incorecto");
                        GameUI.Salto();//Salto de linea
                        p1 = grn.nextInt(0, (ngma / 2));//Genera un numero aleatorio para la pista
                        p2 = grn.nextInt(0, (ngma / 2));//Genera el otro numero aleatorio para la pista
                        logic.pista(p1, p2, ngma, nm);//Te da una pista totalmente aleatoria
                        vidas = vidas - 1;//Te quita una vida
                        if (logic.Perder(vidas))//Si te quedan vidas o no
                        {
                            jov = true;//Reinicia el valor del while
                            while (jov) {
                                ex.clear();//Limpiar pantalla
                                logic.CalcularPuntos(vidas, ngma);//Calcula los puntos que tienes
                                GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad,Lenguaje.P25,Lenguaje.P26,Lenguaje.P27,Lenguaje.P28,Lenguaje.P29);//Valores del jugador
                                GameUI.Salto();//Salto de linea
                                GameUI.perdiste(nm,Lenguaje.P33,Lenguaje.P34);//Pantalla de perder
                                GameUI.Salto();//Salto de linea
                                GameUI.jugarDeNuevo(Lenguaje.P30,Lenguaje.P31);//Opciones de jugar de nuuevo
                                System.out.print("<:");
                                reinJuego = tec.next();
                                switch (reinJuego) {
                                    case "1"://Reiniciar por perder todas las vidas
                                    {
                                        ex.clear();//Limpiar pantalla
                                        nm = grn.nextInt(ngmi, ngma);//Genera un nuevo numero aleatorio
                                        vidas = vidas + logic.vidasInicial;//Reinicia las vidas
                                        jov = false;//Salir de las opciones
                                        break;
                                    }
                                    case "2"://Salir por perder todas las vias
                                    {
                                        return;
                                    }
                                    default://Opcion invalida
                                    {
                                        System.out.println("Opcion invalida");
                                        Thread.sleep(1000);//Tiempo en pausa 1 segundo
                                    }//Opcion invalida
                                }//Switch para seguir jugando
                            }//While para seguir jugando
                        }//Te quedaste sin vidas
                    }//Else numero inccorecto
                }//If comprobacion del número mayor y menor
                else//Numero invalido
                {
                    System.out.println("Numero Invalido");
                    Thread.sleep(1000);//Tiempo en pasua 1 segundo
                    ex.clear();//Limpiar pantalla
                }
            }
        }//while del juego
    }
    public void JuegoMath() throws InterruptedException
    {
        LogicGameMath logic = new LogicGameMath();//Establecer la logica del juego
        String menuMath;//Menu de opciones
        String instrucionesGame;//Menu de instrucciones
        TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();

        int respuesta;//Respuesta del usuario

        boolean jugando;
        boolean menuInstruc;

        while (true)
        {

            ex.clear();
            GameUI.menuGameMath(Lenguaje.P35,Lenguaje.P36,Lenguaje.P37,Lenguaje.P48);
            System.out.print("<:");
            menuMath = tec.next();
            switch (menuMath) {
                case "1": {
                    ex.clear();
                    System.out.println("Que empieze el juego");
                    jugando = true;
                    while (jugando)
                    {
                        GameUI.playerStarus(logic.puntos,Lenguaje.P44,Lenguaje.P45,Lenguaje.P46);
                        logic.CalcularDificultad();
                        int num1 = grn.nextInt(1, logic.dificultad); //Genera un numero aleatorio entre 1 y 10
                        int num2 = grn.nextInt(1, logic.dificultad); //Genera un numero aleatorio entre 1 y 10
                        if (num1 == num2) {
                            System.out.println("Numeros iguales, sumas 500 puntos");
                            logic.puntos += 500; //Suma 50 puntos
                        }
                        else {
                            logic.GenOperation(num1, num2);
                            System.out.print("<:");
                            respuesta = tec.nextInt();
                            logic.InGame(respuesta);
                            if (logic.SalirDelJuego) {
                                return;
                            }
                            if (logic.perdiste) {
                                ex.clear();
                                GameUI.perdisteMath(logic.puntos,logic.respuestaCorrecta,Lenguaje.P33,Lenguaje.P48,Lenguaje.P32,Lenguaje.P45);
                                System.out.println("Ingresa tu nombre");
                                System.out.print("<:");
                                String nombre = tec.next();
                                tablaMath.agregarPuntajeMath(nombre, logic.puntos);
                                logic.perdiste = false;
                                break;
                            } else {
                                ex.clear();
                            }
                        }
                    }
                    break;
                }
                case "2": {
                    menuInstruc = true;
                    while (menuInstruc) {
                        ex.clear();
                        GameUI.menuInstruction(Lenguaje.P39,Lenguaje.P40,Lenguaje.P41,Lenguaje.P42,Lenguaje.P43);
                        System.out.print("<:");
                        instrucionesGame = tec.next();
                        switch (instrucionesGame) {
                            case "0": {
                                menuInstruc = false;
                                break;
                            }

                            default: {
                                System.out.println("Opcion invalida");
                                Thread.sleep(1000);//Tiempo en pausa 1 segundo
                            }
                        }
                    }
                    break;
                }
                case "0": {
                    return;
                }
                default: {
                    System.out.println("Opcion invalida");
                    Thread.sleep(1000);//Tiempo en pausa 1 segundo
                }
            }
        }
    }
}
