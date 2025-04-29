package com.avatrixxyt.minigame;

import com.avatrixxyt.util.Clean;

import java.util.Scanner;

public class MenuTabla {
    public static <Clena> void Menu() throws InterruptedException {
        TablaPuntuacion tabla = new TablaPuntuacion();
        TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();

        String sdtdp;
        Scanner tec = new Scanner(System.in);
        Clean ex = new Clean();
        int borrarTabla;
        int tipoTabla;

        borrarTabla = 1;
        tipoTabla = 1;

        while(true)
        {

            ex.clear();
            tabla.recargarDesdeArchivo();//Recarga archivo JSON de la tabla
            tablaMath.recargarDesdeArchivoMath();
            switch (tipoTabla){
            case 1: {
                tabla.mostrarPuntuaciones();
                break;
            }
                case 2: {
                tablaMath.mostrarPuntuacionesMath();
                break;
            }
            }
            GameUI.tablaDePuntuacion(Lenguaje.P13,Lenguaje.P14,Lenguaje.P15,Lenguaje.P16);
            System.out.print("<:");
            sdtdp = tec.next();
            GameUI.Salto();//Salto de linia
            switch(sdtdp)//Switch de tabla de puntuacion
            {
                case "0"://Case 1 salir de tabla de puntuacion
                {
                    return;
                }//Case 1 salir de tabla de puntuacion
                case "1":
                {
                    switch (tipoTabla) {
                        case 1: {
                            tipoTabla = 2;
                            borrarTabla = 2;
                            break;
                        }
                        case 2: {
                            tipoTabla = 1;
                            borrarTabla = 1;
                            break;
                        }
                    }
                    ex.clear();
                    break;
                }
                case "2"://Case 2 borrar datos de tabla de puntuacion
                {
                    switch (borrarTabla) {
                        case 1: {
                            PermisosAdmin.BorrarTabla();
                            Thread.sleep(1000);//Tiempo de pausa 1 segundo
                            break;
                        }
                        case 2: {
                            PermisosAdmin.BorrarTablaMath();
                            Thread.sleep(1000);
                            break;
                        }
                    }
                }//Case 2 borrar datos de tabla de puntuacion
                break;
                default://Default opcion invalida
                {
                    System.out.println(Lenguaje.P66);
                    Thread.sleep(1000);//Tiempo de pausa 1 segundo
                }//Default opcion invalida
            }
        }//Menu de tabla de puntuacion
    }
}
