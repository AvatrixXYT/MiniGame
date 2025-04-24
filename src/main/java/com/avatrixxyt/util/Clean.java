package com.avatrixxyt.util;

import com.avatrixxyt.minigame.TablaPuntuacionMath;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clean
{
	public void clear()
	{
		try
		{
			final String os = System.getProperty("os.name");//Detecta tu sistema
		    if (os.contains("Windows")) //Si es windows manda el comando cls
		    {
		    	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		    }
		    else//Si es cualquier otro sistema linux manda el comando clear
		    {
		    	new ProcessBuilder("clear").inheritIO().start().waitFor();
		    }
		}
		catch (final Exception e)//Si no tdetecta tu sistema
		{
			Logger.getLogger(TablaPuntuacionMath.class.getName()).log(Level.SEVERE, "Error al guardar las puntuaciones de matemáticas", e);
		}
	}
}
