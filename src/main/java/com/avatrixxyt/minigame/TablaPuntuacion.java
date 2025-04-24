package com.avatrixxyt.minigame;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TablaPuntuacion 
{
	private List<Puntaje> puntajes;//Crea una lista con los puntajes
    private static final String ARCHIVO_JSON = "puntuaciones.json";//Crea el archivo JSON con los puntajes

    public TablaPuntuacion()//Configuar la lista de puntuacion
    {
        puntajes = new ArrayList<>();//Genera la nueva lista
        cargarPuntuaciones();//Carga los puntajes del archivo
    }

    public void agregarPuntaje(String jugador, int puntuacion)//Agrega un puntaje al archivo
    {
        puntajes.add(new Puntaje(jugador, puntuacion));//Agrega el puntaje con el nombre y puntuacion
        ordenarYLimitar();//Ordena los puntajes de mayor a menor
        guardarPuntuaciones();//Guarda el puntaje
    }

    private void ordenarYLimitar()//Ordena los puntajes
    {
        puntajes.sort((p1, p2) -> Integer.compare(p2.getPuntuacion(), p1.getPuntuacion()));//Sortea los puntajes
        if (puntajes.size() > 10)//Limita los puntajes a 10
        {
            puntajes = new ArrayList<>(puntajes.subList(0, 10));//crea la lista con los puntajes ordenados
        }
    }

    public void guardarPuntuaciones()//Guarda los puntajes
    {
        Gson gson = new Gson();//Usa gson de google
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON))//Escribe en el archivo JSON
        {
            gson.toJson(puntajes, writer);//Escribe los puntajes
        } catch (IOException e)
        {
            Logger.getLogger(TablaPuntuacionMath.class.getName()).log(Level.SEVERE, "Error al guardar las puntuaciones de matemáticas", e);
        }
    }

    public void cargarPuntuaciones()//Carga la tabla de puntajes
    {
        Gson gson = new Gson();//Usa Gson de google
        try (FileReader reader = new FileReader(ARCHIVO_JSON))//Lee el archivo JSON
        {
            Type tipoLista = new TypeToken<ArrayList<Puntaje>>() {}.getType();//Genera la lista y la tabla
            puntajes = gson.fromJson(reader, tipoLista);//Crea la lista
            if (puntajes == null) puntajes = new ArrayList<>();
            ordenarYLimitar();//Ordena la lista 
        } catch (IOException e) {
            puntajes = new ArrayList<>();
        }
    }

    public void mostrarPuntuaciones()//Muesta los puntajes en pantalla
    {
        System.out.println("🏆 TOP 10 PUNTUACIONES:");
        int pos = 1;
        for (Puntaje p : puntajes) {
            System.out.println(pos++ + ". " + p.getJugador() + ": " + p.getPuntuacion());//Genera la lista asta 10
        }
    }
    public void reiniciarTabla()//Limpia la lista
    {
        puntajes.clear();  // Limpia la lista en memoria

        // Borra el archivo o lo deja vacío
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON))
        {
            writer.write("[]");  // Escribe un array JSON vacío
        } catch (IOException e)
        {
            Logger.getLogger(TablaPuntuacionMath.class.getName()).log(Level.SEVERE, "Error al guardar las puntuaciones de matemáticas", e);
        }
        System.out.println("✅ Tabla de puntuaciones reiniciada.");
    }
    public void recargarDesdeArchivo()//Recarga la lista y tabla
    {
        cargarPuntuaciones();
    }
}
