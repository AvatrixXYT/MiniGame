package com.avatrixxyt.minigame;

import java.util.Scanner;

public class Lenguaje {
    static public String P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15,P16,P17,P18,P19,P20,P21,P22,P23,P24,P25,P26,P27,P28,P29,P30,P31,P32,P33,P34,P35,P36,P37,P38,P39,P40,P41,P42,P43,P44,P45,P46,P47,P48,P49,P50,P51,P52,P53,P54,P55,P56,P57,P58,P59,P60,P61,P62,P63,P64,P65,P66,P67,P68,P69,P70;

    //menu de selecion de idiomas
    public static void SelectIdioma(){
        String idioma;
        Scanner tec = new Scanner(System.in);

        System.out.println("Lenguage:");
        System.out.println("1)Español");
        System.out.println("2)English");
        System.out.print("<: ");
        idioma = tec.next();
        switch(idioma){
            case "1":
                es();
                break;
            case "2":
                en();
                break;
            default:
                System.out.println(P54);
                SelectIdioma();
        }
    }
    //Español
    public static void es(){
        //menu principal
        P1 = "_______Menu Principal______";
        P2 = "Bienvenido al juego ";
        P3 = "Empezar               ";
        P4 = "Infinito              ";
        P5 = "Idioma                ";
        P6 = "Creditos              ";
        P7 = "Tabla de puntuacion   ";
        P8 = "Salir                 ";
        //Creditos
        P9 = "________________Creditos________________";
        P10 = "|               Creador:               |";
        P11 = "|            Idea original:            |";
        P12 = "|              1)Regresar              |";
        //Tabla de puntuacion
        P13 = "\n_________Opciones__________";
        P14 = "|  2)Cambiar tabla        |";
        P15 = "|  3)Reiniciar Puntajes   |";
        P16 = "|  0)Regresar             |";
        //Dificultad
        P17 = "\n_______Dificultad________";
        P18 = "|     1)Facil   1-10      |";
        P19 = "|     2)Medio   1-25      |";
        P20 = "|     3)Dificil 1-50      |";
        P21 = "|     0)Regresar          |";
        //Pistas
        P22 ="______________________Pista_____________________";
        P23 = "|         El numero magico es menor o igual a";
        P24 = "|         El numero magico es mayor o igual a";
        //Valores al jugar
        P25 = "_________________________jugando_________________________";
        P26 = "| Tines: ";
        P27 = " vidas     Tienes: ";
        P28 = " Puntos    dificultad: ";
        P29 = "|                        0)Salir                        |";
        //Jugar otra vez
        P30 = "Quieres jugar otra vez?";
        P31 = "       1)Si 2)No       ";
        //ganar
        P32 = "Ganaste";
        //perder
        P33 = "Perdiste";
        P34 = "El numero magico era: ";
        //Juego Infinito
        P35 = "_____Juego Infinito_____";
        P36 = "|   1)Empezar          |";
        P37 = "|   2)Reglas           |";
        P38 = "|   0)Regresar         |";
        //Reglas del juego infinito
        P39 = "________________________Reglas_________________________";
        P40 = "| Realiza las operacionas matematicas sin equivocarte |";
        P41 = "| mientras mas puntos tengas, mas dificil las opera-  |";
        P42 = "| ciones, consige la mayor cantidad de puntos         |";
        P43 = "|                      0)Regrear                      |";
        //Estatus
        P44 = "jugando";
        P45 = "Puntos";
        P46 = "0)Salir";
        //Operacion
        P47 = "Operacion";
        //Perder juego infinito
        P48 = "El Resultado era: ";

        //Palabras sueltas
        P49 = "TOP 10 PUNTUACIONES DEL JUEGO NORMAL:";
        P50 = "TOP 10 PUNTUACIONES DEL JUEGO INFINITO:";
        P51 = "Error al guardar las puntuaciones";
        P52 = "Tabla de puntuaciones reiniciada.";
        P53 = "Hasta la proxima";
        P54 = "Opcion Invalida";
        P55 = "Seleciona la Dificultad";
        P56 = "Que empieze el Juego";
        P57 = "Introduce un numero aleatorio entre ";
        P58 = " y ";
        P59 = "Ingresa tu nombre";
        P60 = "Numero incorecto";
        P61 = "Numero Invalido";
        P62 = "Numeros iguales, sumas 500 puntos";
        P63 = "Facil";
        P64 = "Medio";
        P65 = "Dificil";
        P66 = "Error de programa";
        P67 = "No tienes permisos de administrador. Opcion denegada.";
        P68 = "Tienes permisos de administrador. Borrando Tabla";
    }
    //English
    public static void en() {
        //main menu
        P1 = "_________Main Menu_________";
        P2 = "Welcome to the game ";
        P3 = "Start                 ";
        P4 = "Infinity              ";
        P5 = "Language              ";
        P6 = "Credits               ";
        P7 = "Scoreboard            ";
        P8 = "Exit                  ";
        //Credits
        P9 = "________________Credits_________________";
        P10 = "|               Creator:               |";
        P11 = "|            Original idea:            |";
        P12 = "|              0)Back                  |";
        //Scoreboard
        P13 = "\n_________Options___________";
        P14 = "|  2)Change table        |";
        P15 = "|  3)Restart Scores      |";
        P16 = "|  0)Back                |";
        //Difficulty
        P17 = "\n_______Difficulty________";
        P18 = "|     1)Easy    1-10      |";
        P19 = "|     2)Medium  1-25      |";
        P20 = "|     3)Hard    1-50      |";
        P21 = "|     0)Back              |";
        //Hint
        P22 = "______________________Hint_____________________";
        P23 = "   The magic number is less than or equal to";
        P24 = "The magic number is greater than or equal to";
        //Values when playing
        P25 = "_________________________playing_________________________";
        P26 = "| You have: ";
        P27 = " lives   You have: ";
        P28 = " Points    difficulty: ";
        P29 = "|                        0)Exit                         |";
        //Play again
        P30 = "Do you want to play again?";
        P31 = "        1)Si 2)No        ";
        //win
        P32 = "You win";
        //lose
        P33 = "You lose";
        P34 = "The magic number was: ";
        //Game Infinity
        P35 = "_____Infinity Game______";
        P36 = "|   1)Start            |";
        P37 = "|   2)Rules            |";
        P38 = "|   0)Bask             |";
        //Rules of the infinite game
        P39 = "_________________________Rules_________________________";
        P40 = "| Perform the math operations without making mistakes |";
        P41 = "| the more points you have, the more difficult the    |";
        P42 = "| operations get the most points                      |";
        P43 = "|                       0)Back                        |";
        //Status
        P44 = "Playing";
        P45 = "Points";
        P46 = "0)Exit ";
        //Operation
        P47 = "Operation";
        //Lose infinite game
        P48 = "  The result was :";

        //randoms words
        P49 = "TOP 10 NORMAL GAME SCORES:";
        P50 = "TOP 10 INFINITE GAME SCORES:";
        P51 = "Error saving scores";
        P52 = "Scoreboard reset.";
        P53 = "See you next time";
        P54 = "Invalid option";
        P55 = "Select the difficulty";
        P56 = "Let the game begin";
        P57 = "Enter a random number between ";
        P58 = " and ";
        P59 = "Enter your name";
        P60 = "Incorrect number";
        P61 = "Invalid number";
        P62 = "Equal numbers, you add 500 points";
        P63 = "Easy";
        P64 = "Medium";
        P65 = "Hard";
        P66 = "Program error";
        P67 = "You do not have administrator permissions. Option denied.";
        P68 = "You have administrator permissions. Deleting table";
    }
}