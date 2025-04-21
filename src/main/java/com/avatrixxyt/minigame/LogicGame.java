package com.avatrixxyt.minigame;

public class LogicGame 
{
	TablaPuntuacion tabla = new TablaPuntuacion();//Lectura para opciones de tala
	
	private int numMin;//Valor minimo
	private int numMax;//Valor maximo
	private int numXU;//Valor del numero dada por el jugador
	private int rando;//Numero random
	private int vidas;//Vidas del jugador
	private int dificultadPuntos;//Los puntos por dificultad
	private int p1;//Primer Parametro para la pista
	private int p2;//Segundo parametro para la pista
	
	private String jugador;//Nombre del jugador
	
	public String dificultad;//Definir la dificultad
	
	public int vidasInicial;//Vidas al iniciar
	public int puntos;//Puntos ganados
	public int resultOP;//Resultado cuando el numero esta dentro de lo permitido
	
	public boolean perder = false;//Valor cunado pierdes
	public boolean atinNum;//Valor si le atinas al numero
	
    public void ComMinMax(int min, int max, int num)//Operacion para saber si es un numero valido
    {
    	this.numMin = min;//Valor minimo
    	this.numMax = max;//Valor maximo
    	this.numXU = num;//Numero dado por el usuario
    	
    	int pr = numXU;//Inicia una variable con numero del usuario
    	int se = numMax;//Inicia una variable con el valor maximo
    	int te = numMin;//Inicia una variable con el valor minimo
    	if(pr == 0)//Opcion de salir
    	{
    		resultOP = 1;
    	}
    	else
    	{
    		if(pr > te-1 && pr<se+1)//Si es mayor que y Menor que
    		{
    			resultOP = 2;//Es un valor valido
    		}
    		else//Si es invalido
    		{
    			resultOP = 3;//Es un valor invalido
    		}
    	}
    }
        
    public void GameOperation(int NumeroUsuario, int NumeroRandom)//Checa si ganaste o no
    {
    	this.numXU = NumeroUsuario;//Le la variable del numero del usuario
    	this.rando = NumeroRandom;//Le la variable con el numero random
    	
    	int num = numXU;//Establese una variable con el numero de usuario
    	int ranNum = rando;//Establese una variable con el numero aleatorio
    	if (num==ranNum)//Si los numero son iguales
    	{
    		atinNum = true;//Ganaste
    	}
    	else//No son iguales
    	{
    		atinNum = false;//Perdiste
    	}
    }
    
    public void CalcularPuntos(int VidasRestantes,int Dificultad)//Calcula los puntos dependiendo de la dificultad
    {
    	this.dificultadPuntos = Dificultad;//Lee la dificultad
    	this.vidas = VidasRestantes;//Le las vidas que te quedan
    	
    	int vid = vidas;//Establece una variable con las vidas
    	int dif = dificultadPuntos;//Establece una variable con la dificultad
    	
    	puntos = vid*dif/2;//Multiplica las vidas por la dificultad y las divide entre dos
    }
    
    public void GuardarPuntuacion(String NombreJugador)//Guarda el puntaje en la tabla
    {
    	this.jugador = NombreJugador;//Lee el nombre del usuario
    	
    	tabla.agregarPuntaje(jugador, puntos);//Agrega el nombre y puntos del usuario y los guarda
    }
    
    public void Perder(int VidasRestantes)//Calcula si perdiste
    {
    	this.vidas = VidasRestantes;//Lee las vidas que te quedaron
    	if(vidas == 0)//Si te quedan 0 vidas
    	{
    		perder = true;//Perdiste
    	}
    	else//Si te quedan vidas
    	{
    		perder = false;//Sigues jugando
    	}
    }
    
    public void CalcularDificultad(int Dificultad)//Calcula los puntos por dificultad
    {
    	this.dificultadPuntos = Dificultad;//Lee la dificultad
    	
    	int dif = dificultadPuntos;//Variable con la dificultad
    	
    	if (dif == 10)//Si la dificultad es facil
    	{
    		dificultad = "Facil";
    		vidasInicial = 5;//Te da 5 vidas iniciales
    	}
    	else
    	{
    		if (dif == 25)//Si la dificultad es media
        	{
        		dificultad = "Medio";
        		vidasInicial = 10;//Te da 10 vidas iniciales
        	}
    		else
    		{
    			if (dif == 50)//Si la dificultad dificil
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
    	}
    }
    
    public void pista(int Parametro1, int Parametro2, int Dificultad, int NumeroRandom)//Te da una pista dependiendo de los parametros
    {
    	this.p1 = Parametro1;//Lee el parametro 1
    	this.p2 = Parametro2;//Lee el parametro 2
    	this.dificultadPuntos = Dificultad;//Lee la dificultad seleccionada
    	this.rando = NumeroRandom;//Lee el numero random
    	
    	int pp = p1;//Establece una variable con el perimetro 1
    	int sp = p2;//Establece una variable con el perimetro 2
    	int dt = dificultadPuntos;//Establece una variable cpn la dificultad
    	int nr = rando;//Establece una variale con el numero random
    	
    	if(pp == sp)//Si los parametros son iguales
    	{
    		if(dt==10)//Si la dificultad es facil
    		{
    			if(nr <= 5)//Si el numero aleatorio es menor que 5
    			{GameUI.menor(5);}//te da una pista de que es menor
    			else//Si el numero aleatorio es mayor que 5
    			{GameUI.mayor(5);}//te da una pista de que es mayor
    		}
    		else//Si la dificultad no es facil
    		{
    			if(dt == 25)//Si la dificultad es media
    			{
    				if(nr <= 13)//Si el numeor aleatorio es mayor que 13
        			{GameUI.menor(13);}//te da una pista de que es menor
        			else//Si el numero aleatorio es mayor que 13
        			{GameUI.mayor(13);}//te da una pista de que es mayor
    			}
    			else//Si la dificultad no es media
    			{
    				if(dt == 50)//Si la dificultas es dificil
    				{
    					if(nr <= 25)//Si el numeor aleatorio es mayor que 25
    	    			{GameUI.menor(25);}//te da una pista de que es menor
    	    			else//Si el numeor aleatorio es menor que 25
    	    			{GameUI.mayor(25);}//te da una pista de que es mayor
    				}
    				else//Si la dificultad no es dificil
    				{
    					System.out.println("Error de programa");//Error del programa
    					System.exit(3);//Cierra el programa
    				}
    			}
    		}
    	}
    	else//Si los parametros no coinciden
    	{
    		return;//El programa sige con normalidad
    	}
    }
    
    public void Pruebas(int NumeroUsuario)//Activar para realisar pruebas
    {
    	this.numXU = NumeroUsuario;//Lee el numero dado por el usuario
    	
    	int nomber = numXU;//Establece una variable con el numero del usuario
    	int ranNum = 23;//Establece el numero magico como 23
    	if (nomber==ranNum)//Compara los numero si son iguales
    	{
    		atinNum = true;//Ganaste
    	}
    	else
    	{
    		atinNum = false;//Perdiste
    	}
    }
    
}
