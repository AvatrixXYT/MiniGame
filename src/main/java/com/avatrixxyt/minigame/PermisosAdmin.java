package com.avatrixxyt.minigame;

import java.io.File;
import java.io.IOException;

public class PermisosAdmin
{
	public static void BorrarTabla() // Comprobar si tienes permiso para borrar tabla
	{
		TablaPuntuacion tabla = new TablaPuntuacion();// Agrega la bariable de la tabla de puntuacion
		if (!tienePermisos())// Si no tienes permiso
		{
			System.out.println("❌ "+Lenguaje.P67);// No puedes borrar la tabla;
			return;
		} else {
			System.out.println("✅ "+Lenguaje.P68);// Tienes permiso
            tabla.reiniciarTabla();
        }
	}

    public static void BorrarTablaMath() // Comprobar si tienes permiso para borrar tabla
    {

        TablaPuntuacionMath tablaMath = new TablaPuntuacionMath();
        if (!tienePermisos())// Si no tienes permiso
        {
            System.out.println("❌ "+Lenguaje.P67);// No puedes borrar la tabla;
            return;
        } else {
            System.out.println("✅ "+Lenguaje.P68);// Tienes permiso
            tablaMath.reiniciarTablaMath();
        }
    }

    static boolean tienePermisos()//Detectar si tienes permisos
    {
        String os = System.getProperty("os.name").toLowerCase();//Detecta el tipo de sistema
        File testFile;//Crea un archivo 

        if (os.contains("win"))//Si el sistema es windows
        {
            testFile = new File("C:\\Windows\\System32\\test_perm.txt");//Crea un archivo en system32
        } 
        else//Si el sistema es linux o variantes
        {
            testFile = new File("/etc/test_perm.txt");//Crea un archivo en /etc
        }

        try 
        {
            boolean creado = testFile.createNewFile();//Si el archivo se pudo crear tienes permisos de administrador
            if (creado) testFile.delete();//Elimina el archivo creado
            return true;//Te da el el valor true
        } catch (IOException e)//Si no se pudo crear el archivo
        {
            return false;//No tienes permiso de administrado
        }
    }
}