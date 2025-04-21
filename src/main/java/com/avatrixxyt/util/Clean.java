package com.avatrixxyt.util;

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
		      e.printStackTrace();//Error 
		}
	}
}
