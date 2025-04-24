package com.avatrixxyt.minigame;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TablaPuntuacionMath {
    private List<Puntaje> puntajesMath; // Lista que almacena las puntuaciones de matemáticas
    private static final String ARCHIVO_JSON_MATH = "puntuaciones_math.json"; // Archivo JSON para puntajes de matemáticas

    public TablaPuntuacionMath() {
        puntajesMath = new ArrayList<>(); // Inicializa la lista de puntuaciones de matemáticas
        cargarPuntuacionesMath(); // Carga los datos del archivo JSON de matemáticas
    }

    public void agregarPuntajeMath(String jugador, int puntuacion) {
        puntajesMath.add(new Puntaje(jugador, puntuacion)); // Agrega un nuevo puntaje de matemáticas
        ordenarYLimitarMath(); // Ordena los puntajes de matemáticas y los limita a 10
        guardarPuntuacionesMath(); // Guarda los cambios en el archivo JSON de matemáticas
    }

    private void ordenarYLimitarMath() {
        puntajesMath.sort((p1, p2) -> Integer.compare(p2.getPuntuacion(), p1.getPuntuacion())); // Ordena en orden descendente
        if (puntajesMath.size() > 10) { // Limita la lista a un máximo de 10 elementos
            puntajesMath = new ArrayList<>(puntajesMath.subList(0, 10)); // Recorta la lista
        }
    }

    public void guardarPuntuacionesMath() {
        Gson gson = new Gson(); // Utiliza la biblioteca Gson
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON_MATH)) {
            gson.toJson(puntajesMath, writer); // Escribe los puntajes de matemáticas en el archivo JSON
        } catch (IOException e) {
            Logger.getLogger(TablaPuntuacionMath.class.getName()).log(Level.SEVERE, "Error al guardar las puntuaciones de matemáticas", e); // Muestra un error si ocurre
        }
    }

    public void cargarPuntuacionesMath() {
        Gson gson = new Gson(); // Utiliza Gson para manejar JSON
        try (FileReader reader = new FileReader(ARCHIVO_JSON_MATH)) {
            Type tipoLista = new TypeToken<ArrayList<Puntaje>>() {}.getType(); // Define el tipo de datos
            puntajesMath = gson.fromJson(reader, tipoLista); // Carga los datos desde el archivo
            if (puntajesMath == null) puntajesMath = new ArrayList<>(); // Si el archivo está vacío, inicializa la lista
            ordenarYLimitarMath(); // Ordena la lista después de cargarla
        } catch (IOException e) {
            puntajesMath = new ArrayList<>(); // Si ocurre un error, inicializa una lista vacía
        }
    }

    public void mostrarPuntuacionesMath() {
        System.out.println("🏆 TOP 10 PUNTUACIONES DEL MODO INFINITO:");
        int pos = 1;
        for (Puntaje p : puntajesMath) {
            System.out.println(pos++ + ". " + p.getJugador() + ": " + p.getPuntuacion()); // Muestra cada puntaje
        }
    }

    public void reiniciarTablaMath() {
        puntajesMath.clear(); // Vacía la lista en memoria
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON_MATH)) {
            writer.write("[]"); // Escribe un array vacío en el archivo
        } catch (IOException e) {
            Logger.getLogger(TablaPuntuacionMath.class.getName()).log(Level.SEVERE, "Error al guardar las puntuaciones de matemáticas", e); // Muestra un error si ocurre
        }
    }

    public void recargarDesdeArchivoMath() {
        cargarPuntuacionesMath(); // Carga las puntuaciones desde el archivo en disco
    }
}