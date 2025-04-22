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

		Clean ex = new Clean();
		Scanner tec = new Scanner(System.in);
		TablaPuntuacion tabla = new TablaPuntuacion();//Establecer la tabla de puntuacion
		
		while(true)
		{
			ex.clear();//Limpiar pantalla
			GameUI.menu();//Muestra el menu
			System.out.print("<: ");
			op = tec.next();
			GameUI.Salto();//Salto de linea
			switch(op) {
				case "1": {
				}
				case "4": {
					System.out.print("Hasta la proxima");
					return;
				}//Switch menu case 4 salir
				case "2": {
					mdc = true;//Reinicia el valor del while
					while (mdc) {
						ex.clear();//Limpiar pantalla
						GameUI.credits();//Muesta los creditos
						System.out.print("<:");
						swCre = tec.next();
						if (swCre.equals("1")) //Salir del menu de credito
						{
							mdc = false;//Valor para salir
						} else {
							System.out.println("Opcion invalida");
							Thread.sleep(1000);//Tiempo en pausa 1 segundo
						}
					}//Switch regresar creditos
				}
				break;
			case "3":
			{
				wdtp=true;//Reinicia el valor del while
				while(wdtp)
				{
					tabla.recargarDesdeArchivo();//Recarga archivo JSON de la tabla
					ex.clear();//Limpiar pantalla
					tabla.mostrarPuntuaciones();//Lee el archivo JSON para ver las puntuaciones
					GameUI.Salto();//Salto de linea
					GameUI.tablaDePuntuacion();//Menu de opciones de tabla de puntuacion
					System.out.print("<:");
					sdtdp = tec.next();
					GameUI.Salto();//Salto de linia
					switch(sdtdp)//Switch de tabla de puntuacion
					{
					case "1"://Case 1 salir de tabla de puntuacion
					{
						wdtp=false;//Valor de salida
						break;
					}//Case 1 salir de tabla de puntuacion
					case "2"://Case 2 borrar datos de tabla de puntuacion
					{
						PermisosAdmin.BorrarTabla();
						Thread.sleep(1000);//Tiempo de pausa 1 segundo
					}//Case 2 borrar datos de tabla de puntuacion
					break;
					default://Default opcion invalida
					{
						System.out.println("Opcion invalida");
						Thread.sleep(1000);//Tiempo de pausa 1 segundo
					}//Default opcion invalida
					}
				}//Menu de tabla de puntuacion
				break;
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
