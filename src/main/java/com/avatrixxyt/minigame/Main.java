package com.avatrixxyt.minigame;

import java.util.Random;
import java.util.Scanner; //lectura del teclado
import com.avatrixxyt.util.*;

public class Main 
{

	public static void main(String[]args) throws InterruptedException
	{
		String op;//Switch del menu principal
		Clear ex = new Clear();
		Scanner tec = new Scanner(System.in);
		TablaPuntuacion tabla = new TablaPuntuacion();//Establecer la tabla de puntuacion
		TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();
		ModosGame game = new ModosGame();
		Lenguaje.es();
		while(true)
		{
			ex.clear();//Limpiar pantalla
			GameUI.menu(Lenguaje.P1, Lenguaje.P2, Lenguaje.P3, Lenguaje.P4, Lenguaje.P5, Lenguaje.P6, Lenguaje.P7, Lenguaje.P8);//Muestra el menu
			System.out.print("<: ");
			op = tec.next();
			GameUI.Salto();//Salto de linea
			switch(op)
			{
				case "0":
				{
					System.out.print(Lenguaje.P53);
					return;
				}
				case "1":
				{
					game.NumeroMagico();
					break;
				}
				case "2":
				{
					game.JuegoMath();
					break;
				}
				case "3":
				{
					Lenguaje.SelectIdioma();
					break;
				}
				case "4":
				{
					Creditos.Menu();
					break;
				}
				case "5": {
					MenuTabla.Menu();
					break;
				}
			default ://Default opcion invalida
			{
				System.out.println(Lenguaje.P54);
				Thread.sleep(1000);//Tiempo de pausa 1 segundo
			}//Default opcion invalida
			}//Switch menu principal
		}//While menu principal
	}
}
