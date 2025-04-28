package com.avatrixxyt.minigame;

import java.util.Random;
import java.util.Scanner; //lectura del teclado
import com.avatrixxyt.util.*;

public class Main 
{
	public static void main(String[]args) throws InterruptedException
	{
		boolean mdc;//While del menu de creditos
		boolean wdtp;//While de la tabla de puntuacion

		String sdtdp;//Switch opciones de la tabla de puntucion
		String swCre;//Switch para salir de los creditos
		String op;//Switch del menu principal

		boolean tipoTabla;
		boolean borrarTabla = true;//Variable para borrar tabla

		Clean ex = new Clean();
		Scanner tec = new Scanner(System.in);
		TablaPuntuacion tabla = new TablaPuntuacion();//Establecer la tabla de puntuacion
		TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();
		ModosGame game = new ModosGame();
		
		while(true)
		{
			ex.clear();//Limpiar pantalla
			GameUI.menu();//Muestra el menu
			System.out.print("<: ");
			op = tec.next();
			GameUI.Salto();//Salto de linea
			switch(op)
			{
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
					Creditos.Menu();
					break;
				}//Switch menu case 4 salir
				case "4": {
					MenuTabla.Menu();
					break;
				}
			case "5":
			{
				System.out.print("Hasta la proxima");
				return;
			}//Switch case 3 tabla de puntuacion
			default ://Default opcion invalida
			{
				System.out.println("Opcion invalida");
				Thread.sleep(1000);//Tiempo de pausa 1 segundo
			}//Default opcion invalida
			}//Switch menu principal
		}//While menu principal
	}
}
