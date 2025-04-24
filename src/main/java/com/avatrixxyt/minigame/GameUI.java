package com.avatrixxyt.minigame;

public class GameUI 
{
	//Menu principal
	public static void menu()
	{
		System.out.println("____________Menu___________");
		System.out.println("|                         |");
		System.out.println("|   Bienvenido al Juego   |");
		System.out.println("|                         |");
		System.out.println("|        1)Empezar        |");
		System.out.println("|        2)Infinito       |");
		System.out.println("|        3)Creditos       |");
		System.out.println("|  4)Tabla de puntuacion  |");
		System.out.println("|         5)Salir         |");
		System.out.println("|                         |");
		System.out.println("---------------------------");
	}
	//Creditos del juego
	public static void credits()
	{
		System.out.println("________________Creditos________________");
		System.out.println("|                                      |");
		System.out.println("|               Creador:               |");
		System.out.println("|      Andres Villalobos Arellano      |");
		System.out.println("|                                      |");
		System.out.println("|            Idea original:            |");
		System.out.println("|  Profesor Mendoza Chulim Hugo César  |");
		System.out.println("|                                      |");
		System.out.println("|              1)Regresar              |");
		System.out.println("----------------------------------------");
	}
	//Opciones de la tabla
	public static void tablaDePuntuacion()
	{
		System.out.println("\n_________Opciones__________");
		System.out.println("|                         |");
		System.out.println("|        1)Regresar       |");
		System.out.println("|     2)Cambiar tabla     |");
		System.out.println("|  3)Reiniciar Puntajes   |");
		System.out.println("|                         |");
		System.out.println("---------------------------");
	}
	//Opciones de dificultad
	public static void tablaDeDificultad()
	{
		System.out.println("\n_______Dificultad________");
		System.out.println("|                         |");
		System.out.println("|     1)Facil 1-10        |");
		System.out.println("|     2)Medio 1-25        |");
		System.out.println("|     3)Dificil 1-50      |");
		System.out.println("|                         |");
		System.out.println("|     0)Regresar          |");
		System.out.println("|                         |");
		System.out.println("---------------------------");
	}
	//Pista menor
	public static void menor(int Valor) 
	{
		System.out.println("__________________Pista__________________");
		System.out.println("| El numero magico es menor o igual a "+ Valor +" |");
		System.out.println("-----------------------------------------");
	}
	//Pista mayor
	public static void mayor(int Valor) 
	{
		System.out.println("__________________Pista__________________");
		System.out.println("| El numero magico es mayor o igual a "+ Valor +" |");
		System.out.println("-----------------------------------------");
	}
	//Vidas restantes y dificultad
	public static void valoresDelJuego(int Vidas,int Puntos, String Dificultad)
	{
		System.out.println("_________________________jugando_________________________");
		System.out.println("| Tines: "+Vidas+" vidas   Tienes: "+Puntos+ " Puntos    dificultad: "+Dificultad+"|");
		System.out.println("|                        0)Salir                        |");
		System.out.println("---------------------------------------------------------");
	}
	//Jugar otra vez
	public static void jugarDeNuevo()
	{
		System.out.println("Quieres jugar otra vez?");
		System.out.println("       1)Si 2)No       ");
	}
	public static void ganaste()
	{
		System.out.println("_________________________________________________________");
		System.out.println("|                        Ganaste                        |");
		System.out.println("---------------------------------------------------------");
	}
	//Perdiste
	public static void perdiste(int num)
	{
		System.out.println("_________________________________________________________");
		System.out.println("|                        Perdiste                       |");
		System.out.println("|             El numero magico era: "+num+"                   |");
		System.out.println("---------------------------------------------------------");
	}
	public static void Salto()
	{
		System.out.println("\n\n");
	}
	//game math
	public static void menuGameMath()
	{
		System.out.println("_____Juego Infinito_____");
		System.out.println("|                      |");
		System.out.println("|   1)Empezar          |");
		System.out.println("|   2)Reglas           |");
		System.out.println("|                      |");
		System.out.println("|   0)Regresar         |");
		System.out.println("|                      |");
		System.out.println("------------------------");
	}
	public static void menuInstruction()
	{
		System.out.println("_____________________Instrucciones_____________________");
		System.out.println("|                                                     |");
		System.out.println("| Realiza las operacionas matematicas sin equivocarte |");
		System.out.println("| Mientras mas puntos tengas, mas dificil las opera-  |");
		System.out.println("| ciones, consige la mayor cantidad de puntos         |");
		System.out.println("|                                                     |");
		System.out.println("|                      0)Regrear                      |");
		System.out.println("|                                                     |");
		System.out.println("-------------------------------------------------------");
	}
	public static void playerStarus(int puntos) {
		System.out.println("_________________________jugando_________________________");
		System.out.println("|                 Puntos: "+puntos+"                    |");
		System.out.println("|                        0)Salir                        |");
		System.out.println("---------------------------------------------------------");
	}
	public static void gameMath(int num1, int num2, String op) {
		System.out.println("_________________________jugando_________________________");
		System.out.println("|        Operacion: "+num1+" "+op+" "+num2+" = ?        |");
		System.out.println("---------------------------------------------------------");
	}
	public static void perdisteMath(int num) {
		System.out.println("_________________________________________________________");
		System.out.println("|                        Perdiste                       |");
		System.out.println("|                 Ganaste "+num+" puntos                |");
		System.out.println("---------------------------------------------------------");
	}
}
