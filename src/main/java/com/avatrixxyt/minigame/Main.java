package com.avatrixxyt.minigame;

import java.util.Random;
import java.util.Scanner; //lectura del teclado
import com.avatrixxyt.util.*;

public class Main 
{
	public static void main(String[]args) throws InterruptedException 
	{
		Clean ex = new Clean();
		Scanner tec = new Scanner(System.in);
		LogicGame logic = new LogicGame();//Establecer la logica del juego
		TablaPuntuacion tabla = new TablaPuntuacion();//Establecer la tabla de puntuacion
		Random grn = new Random(System.currentTimeMillis()); //variable para el numero aleatorio
		int nm = 0;//Inicio del numero magico
		int xn;//Numero x del usuario
		int vidas;//Numero de Vidas
		int ngmi = 1;//Numero Minimo a generar
		int ngma = 50;//Numero Maximo a generar
		int p1;//Perimetro 1 para la pista
		int p2;//Perimetro 2 para la pista
		//Variables booleanas boolean
		boolean mdc;//While del menu de creditos
		boolean wdtp;//While de la tabla de puntuacion
		boolean men;//While del menu principal
		boolean jov;//While para jugar otra vez
		boolean jugando = true;//While el juego
		boolean selDificultad;//While de la dificultad
		//Variables de cadenas de texto String
		String sdtdp;//Switch opciones de la tabla de puntucion
		String swCre;//Switch para salir de los creditos
		String op;//Switch del menu principal
		String jugador;//Establecer nombre de jugador
		String reinJuego;//Switch para reiniciar el juego
		String dificultad;//Switch para seleccionar dificultad
		//Variables usadas
		men=true;
		while(men==true)
		{
			ex.clear();//Limpiar pantalla
			GameUI.menu();//Muestra el menu
			System.out.print("<: ");
			op = tec.next();
			System.lineSeparator();//Salto de linea
			switch(op)
			{
			case "1":{
				selDificultad = true;//Reinicia el valor del while
				while(selDificultad == true)
				{
					ex.clear();//Limpiar pantalla
					System.out.println("Seleciona la Dificultad");
					GameUI.tablaDeDificultad();//Muesta la tabla de dificultad
					System.lineSeparator();//Salto de linea
					System.out.print("<:");
					dificultad = tec.next();
					switch(dificultad)
					{
						case "0"://Regresar
						{
							selDificultad = false;//Salir del menu de dificultad
							jugando=false;//Reinicia el valor del while
							break;
						}
					case "1"://Facil
					{
						ngma = 10;
						jugando=true;//Reinicia el valor del while
						break;
					}
					case "2"://Medio
					{
						ngma = 25;
						jugando=true;//Reinicia el valor del while
						break;
					}
					case "3"://Dificil
					{
						ngma = 50;
						jugando=true;//Reinicia el valor del while
						break;
					}
					default://Opcion invalida
					}//Switch de dificultad
					selDificultad = false;//Salir del menu de dificultad
				}
				ex.clear();//Limpiar pantalla
				logic.CalcularDificultad(ngma);//Calcula la dificultad
				System.out.println("Que empieze el Juego");
				nm = grn.nextInt(ngmi,ngma);//Genera el primer numero aleatorio
				vidas = logic.vidasInicial;//Te da las vidas para iniciar
				while(jugando==true)
				{	
					GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad);//Valores del jugador
					System.lineSeparator();//Salto de linea
					System.out.println("Introduce un numero aleatorio entre "+ ngmi + " y " + ngma);
					System.out.print("<: ");
					xn = tec.nextInt();
					logic.ComMinMax(ngmi, ngma, xn);//Da los valores para checar si el numero es valido o no y da el resultado
					if(logic.resultOP==1)
					{
						jugando=false;
						break;
					}
					else
					{
						if(logic.resultOP==2)
						{
							//logic.Pruebas(xn);//activar para hacer pruebas
							logic.GameOperation(xn,nm);//Compurueba si ganste o no
							if(logic.atinNum==true)//Comprueva si le atinaste o no
							{
								jov = true;//Reinicia el valor del while
								while(jov == true)
								{
									ex.clear();//Limpiar pantalla
									logic.CalcularPuntos(vidas, ngma);//Calcula los puntos que tienes
									GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad);//Valores del jugador
									System.lineSeparator();//Salto de linea
									GameUI.ganaste();//Pantalla de ganar
									System.lineSeparator();//Salto de linea
									GameUI.jugarDeNuevo();//Opciones para jugar de nuevo
									System.out.print("<:");
									reinJuego = tec.next();
									switch(reinJuego)
									{
									case "1"://Seguir jugando para ganar mas puntos
									{
										ex.clear();//Limpiar pantalla
										nm = grn.nextInt(ngmi,ngma);//Genera un nuevo numero aleatorio
										vidas=vidas+5;//Aumenta las vidas dandote  5 mas
										jugando = true;//Seguir del juego
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
										jugando = false;//Salir del juego
										jov = false;//Salir de las opciones
										break;
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
								System.lineSeparator();//Salto de linea
								p1 = grn.nextInt(0,(ngma/2));//Genera un numero aleatorio para la pista
								p2 = grn.nextInt(0,(ngma/2));//Genera el otro numero aleatorio para la pista
								logic.pista(p1, p2, ngma, nm);//Te da una pista totalmente aleatoria
								vidas=vidas-1;//Te quita una vida
								logic.Perder(vidas);//operacion para saber si te quedan vidas
								if(logic.perder == true)//Si te quedan vidas o no
								{
									jov = true;//Reinicia el valor del while
									while(jov)
									{
										ex.clear();//Limpiar pantalla
										logic.CalcularPuntos(vidas, ngma);//Calcula los puntos que tienes
										GameUI.valoresDelJuego(vidas, logic.puntos, logic.dificultad);//Valores del jugador
										System.lineSeparator();//Salto de linea
										GameUI.perdiste(nm);//Pantalla de perder
										System.lineSeparator();//Salto de linea
										GameUI.jugarDeNuevo();//Opciones de jugar de nuuevo
										System.out.print("<:");
										reinJuego = tec.next();
										switch(reinJuego)
										{
										case "1"://Reiniciar por perder todas las vidas
										{
											ex.clear();//Limpiar pantalla
											nm = grn.nextInt(ngmi,ngma);//Genera un nuevo numero aleatorio
											vidas=vidas+logic.vidasInicial;//Reinicia las vidas
											jugando = true;//Seguir jugando
											jov = false;//Salir de las opciones
											break;
										}
										case "2"://Salir por perder todas las vias
										{
											jugando = false;//Salir del juego
											jov = false;//Salir de las opcioneas para reiniciar
											break;
										}
										default://Opcion invalida
										{
											System.out.println("Opcion invalida");
											Thread.sleep(1000);//Tiempo en pausa 1 segundo
										}//Opcion invalida
										}//Switch para seguir jugando
									}//While para seguir jugando
								}//Te quedaste sin vidas
								else
								{
									jugando = true;//Valor para seguir jugando
								}//Si tienes vida seguir jugando
							}//Else numero inccorecto
						}//If comprobacion del numero mayor y menor
						else//Numero invalido
						{
							System.out.println("Numero Invalido");
							Thread.sleep(1000);//Tiempo en pasua 1 segundo
							ex.clear();//Limpiar pantalla
						}
					}
				}//while del juego
				break;
			}//Switch menu case 1 Jugar
			case "4":
			{	
				System.out.print("Hasta la proxima");
				return;	
			}//Switch menu case 4 salir
			case "2":
			{
				mdc=true;//Reinicia el valor del while
				while(mdc==true)
				{
					ex.clear();//Limpiar pantalla
					GameUI.credits();//Muesta los creditos
					System.out.print("<:");
					swCre = tec.next();
					switch(swCre)
					{
					case "1"://Salir del menu de creditos
					{
						mdc=false;//Valor para salir
						break;
					}//Switch creditos case 1 regresar
					default://Default opcion invalida
					{
						System.out.println("Opcion invalida");
						Thread.sleep(1000);//Tiempo en pausa 1 segundo
					}//Swuitch creditos opcion invalida
					}//Switch regresar creditos
				}
				break;
			}//Swuitch menu case 2 Creditos
			case "3":
			{
				wdtp=true;//Reinicia el valor del while
				while(wdtp==true)
				{
					tabla.recargarDesdeArchivo();//Recarga archivo JSON de la tabla
					ex.clear();//Limpiar pantalla
					tabla.mostrarPuntuaciones();//Lee el archivo JSON para ver las puntuaciones
					System.lineSeparator();//Salto de linea
					GameUI.tablaDePuntuacion();//Menu de opciones de tabla de puntuacion
					System.out.print("<:");
					sdtdp = tec.next();
					System.lineSeparator();//Salto de linia
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
