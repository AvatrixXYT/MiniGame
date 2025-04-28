package com.avatrixxyt.minigame;

import com.avatrixxyt.util.Clean;

import java.util.Scanner;

public class Creditos {
    public static void Menu() throws InterruptedException {
        Scanner tec = new Scanner(System.in);
        String swCre;//Switch para salir de los creditos
        Clean ex = new Clean();
        while (true) {
            ex.clear();//Limpiar pantalla
            GameUI.credits();//Muesta los creditos
            System.out.print("<:");
            swCre = tec.next();
            if (swCre.equals("1")) //Salir del menu de credito
            {
                return;
            } else {
                System.out.println("Opcion invalida");
                Thread.sleep(1000);//Tiempo en pausa 1 segundo
            }
        }//Switch regresar creditos
    }
}
