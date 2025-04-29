package com.avatrixxyt.minigame;

public class LogicGame
{
	TablaPuntuacion tabla = new TablaPuntuacion();//Lectura para opciones de tala
	
	public String dificultad;//Definir la dificultad
	
	public int vidasInicial;//Vidas al iniciar
	public int puntos;//Puntos ganados
	public int resultOP;//Resultado cuando el número está dentro de lo permitido

	public boolean atinNum;//Valor si le atinas al numero

    public void ComMinMax(int min, int max, int num)//Operacion para saber si es un numero valido
	{
    	if (num == 0)
		{
			resultOP = 1;
		}
		else if(num > min-1 && num<max+1)//Si es mayor que y Menor que
		{
			resultOP = 2;//Es un valor válido
		}
		else//Si es invalido
		{
			resultOP = 3;//Es un valor inválido
		}
    }
        
    public boolean GameOperation(int NumeroUsuario, int NumeroRandom)//Checa si ganaste o no
    {
    	if (NumeroUsuario == NumeroRandom)//Si los numero son iguales
    	{
    		return true;//Ganaste
    	}
    	else//No son iguales
    	{
    		return false;//Perdiste
    	}
    }
    
    public void CalcularPuntos(int VidasRestantes,int Dificultad)//Calcula los puntos dependiendo de la dificultad
	{
    	puntos = VidasRestantes*Dificultad/2;//Multiplica las vidas por la dificultad y las divide entre dos
    }
    
    public void GuardarPuntuacion(String NombreJugador)//Guarda el puntaje en la tabla
    {
    	tabla.agregarPuntaje(NombreJugador, puntos);//Agrega el nombre y puntos del usuario y los guarda
    }
    
    public boolean Perder(int VidasRestantes)//Calcula si perdiste
    {
    	if(VidasRestantes == 0)//Si te quedan 0 vidas
    	{
    		return true;//Perdiste
    	}
    	else//Si te quedan vidas
    	{
    		return false;//Sigues jugando
    	}
    }
    
    public void CalcularDificultad(int Dificultad)//Calcula los puntos por dificultad
	{
    	if (Dificultad == 10)//Si la dificultad es facil
    	{
    		dificultad = "Facil";
    		vidasInicial = 5;//Te da 5 vidas iniciales
    	}
    	else if (Dificultad == 25)//Si la dificultad es media
		{
			dificultad = "Medio";
			vidasInicial = 10;//Te da 10 vidas iniciales
		}
		else if (Dificultad == 50)//Si la dificultad dificil
		{
			dificultad = "Dificil";
			vidasInicial = 20;//Te da 20 vidas iniciales
		}
		else
		{
			System.out.println("Error de programa");//Si el valor es incorecto es un error del sistema
			System.exit(3);//Salir del programa
    	}
    }
    
    public void pista(int Parametro1, int Parametro2, int Dificultad, int NumeroRandom)//Te da una pista dependiendo de los parametros
    {
    	if(Parametro1 == Parametro2)//Si los parametros son iguales
    	{
    		if(Dificultad==10)//Si la dificultad es facil
    		{
    			if(NumeroRandom <= 5)//Si el número aleatorio es menor que 5
    			{GameUI.Pista(5,Lenguaje.P22,Lenguaje.P23);}//te da una pista de que es menor
    			else//Si el número aleatorio es mayor que 5
    			{GameUI.Pista(5,Lenguaje.P22,Lenguaje.P24);}//te da una pista de que es mayor
    		}
    		else if(Dificultad == 25)//Si la dificultad es media
			{
				if(NumeroRandom <= 13)//Si el numeor aleatorio es mayor que 13
				{GameUI.Pista(13,Lenguaje.P22,Lenguaje.P23);}//te da una pista de que es menor
				else//Si el número aleatorio es mayor que 13
				{GameUI.Pista(13,Lenguaje.P22,Lenguaje.P24);}//te da una pista de que es mayor
			}
			else if(Dificultad == 50)//Si la dificultas es dificil
			{
				if(NumeroRandom <= 25)//Si el numeor aleatorio es mayor que 25
				{GameUI.Pista(25,Lenguaje.P22,Lenguaje.P23);}//te da una pista de que es menor
				else//Si el numeor aleatorio es menor que 25
				{GameUI.Pista(25,Lenguaje.P22,Lenguaje.P24);}//te da una pista de que es mayor
			}
			else//Si la dificultad no es dificil
			{
				System.out.println("Error de programa");//Error del programa
				System.exit(3);//Cierra el programa
			}
    	}
    }
    public boolean Pruebas(int NumeroUsuario)//Activar para realisar pruebas
    {
    	int ranNum = 23;//Establece el número magico como 23
    	if (NumeroUsuario==ranNum)//Compara los numero si son iguales
    	{
    		return true;//Ganaste
    	}
    	else
    	{
    		return false;//Perdiste
    	}
    }
    
}
