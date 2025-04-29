package com.avatrixxyt.minigame;

public class GameUI 
{
	//Menu principal
	public static void menu(String T1, String T2, String T3, String T4, String T5, String T6, String T7, String T8)
	{
		System.out.println(T1);
		System.out.println("|                          |");
		System.out.println("|   "+T2+"   |");
		System.out.println("|                          |");
		System.out.println("|  1)"+T3+"|");
		System.out.println("|  2)"+T4+"|");
		System.out.println("|  3)"+T5+"|");
		System.out.println("|  4)"+T6+"|");
		System.out.println("|  5)"+T7+"|");
		System.out.println("|                          |");
		System.out.println("|  0)"+T8+"|");
		System.out.println("|                          |");
		System.out.println("----------------------------");
	}
	//Creditos del juego
	public static void credits(String T1, String T2, String T3, String T4)
	{
		System.out.println(T1);
		System.out.println("|                                      |");
		System.out.println(T2);
		System.out.println("|      Andres Villalobos Arellano      |");
		System.out.println("|                                      |");
		System.out.println(T3);
		System.out.println("|  Profesor Mendoza Chulim Hugo César  |");
		System.out.println("|                                      |");
		System.out.println(T4);
		System.out.println("----------------------------------------");
	}
	//Opciones de la tabla
	public static void tablaDePuntuacion(String T1, String T2, String T3, String T4)
	{
		System.out.println(T1);
		System.out.println("|                         |");
		System.out.println(T2);
		System.out.println(T3);
		System.out.println("|                         |");
		System.out.println(T4);
		System.out.println("|                         |");
		System.out.println("---------------------------");
	}
	//Opciones de dificultad
	public static void tablaDeDificultad(String T1, String T2, String T3, String T4, String T5)
	{
		System.out.println(T1);
		System.out.println("|                         |");
		System.out.println(T2);
		System.out.println(T3);
		System.out.println(T4);
		System.out.println("|                         |");
		System.out.println(T5);
		System.out.println("|                         |");
		System.out.println("---------------------------");
	}
	//Pista
	public static void Pista(int Valor,String T1,String T2)
	{
		System.out.println(T1);
		System.out.println(T2+" "+Valor+" |");
		System.out.println("-----------------------------------------");
	}
	//Vidas restantes y dificultad
	public static void valoresDelJuego(int Vidas,int Puntos, String Dificultad,String T1, String T2, String T3, String T4, String T5)
	{
		System.out.println(T1);
		System.out.println(T2+Vidas+T3+Puntos+T4+Dificultad+"|");
		System.out.println(T5);
		System.out.println("---------------------------------------------------------");
	}
	//Jugar otra vez
	public static void jugarDeNuevo(String T1,String T2)
	{
		System.out.println(T1);
		System.out.println(T2);
	}
	public static void ganaste(String T1)
	{
		System.out.println("_________________________________________________________");
		System.out.println("|                        "+T1+"                        |");
		System.out.println("---------------------------------------------------------");
	}
	//Perdiste
	public static void perdiste(int num,String T1,String T2)
	{
		System.out.println("_________________________________________________________");
		System.out.println("|                        "+T1+"                       |");
		System.out.println("|             "+T2+" "+num+"                   |");
		System.out.println("---------------------------------------------------------");
	}
	public static void Salto()
	{
		System.out.println("\n\n");
	}
	//game math
	public static void menuGameMath(String T1, String T2, String T3, String T4)
	{
		System.out.println(T1);
		System.out.println("|                      |");
		System.out.println(T2);
		System.out.println(T3);
		System.out.println("|                      |");
		System.out.println(T4);
		System.out.println("|                      |");
		System.out.println("------------------------");
	}
	public static void menuInstruction(String T1, String T2, String T3, String T4, String T5)
	{
		System.out.println(T1);
		System.out.println("|                                                     |");
		System.out.println(T2);
		System.out.println(T3);
		System.out.println(T4);
		System.out.println("|                                                     |");
		System.out.println(T5);
		System.out.println("|                                                     |");
		System.out.println("-------------------------------------------------------");
	}
	public static void playerStarus(int puntos,String T1, String T2, String T3) {
		System.out.println("_________________________"+T1+"_________________________");
		System.out.println("|                 "+T2+": "+puntos+"                    |");
		System.out.println("|                        "+T3+"                        |");
		System.out.println("---------------------------------------------------------");
	}
	public static void gameMath(int num1, int num2, String op,String T1, String T2) {
		System.out.println("_________________________"+T1+"_________________________");
		System.out.println("|        "+T2+": "+num1+" "+op+" "+num2+" = ?        |");
		System.out.println("---------------------------------------------------------");
	}
	public static void perdisteMath(int num,int Resultado,String T1, String T2, String T3,String T4) {
		System.out.println("_________________________________________________________");
		System.out.println("|                        "+T1+"                       |");
		System.out.println("|                    "+T2+" "+Resultado+"                |");
		System.out.println("|                 "+T3+" "+num+" "+T4+"                |");
		System.out.println("---------------------------------------------------------");
	}
}
