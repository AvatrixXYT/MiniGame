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
            GameUI.credits(Lenguaje.P9,Lenguaje.P10,Lenguaje.P11,Lenguaje.P12);//Muesta los creditos
            System.out.print("<:");
            swCre = tec.next();
            if (swCre.equals("0")) //Salir del menu de credito
            {
                return;
            } else {
                System.out.println(Lenguaje.P54);
                Thread.sleep(1000);//Tiempo en pausa 1 segundo
            }
        }//Switch regresar creditos
    }
}
