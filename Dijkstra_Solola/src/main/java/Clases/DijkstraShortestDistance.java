/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Leonel
 */
import java.util.*;

public class DijkstraShortestDistance {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static class Nodo {
        String municipio;
        List<Arco> arcosenlazados;

        public Nodo(String municipio) {
            this.municipio = municipio;
            arcosenlazados = new ArrayList<>();
        }

        public void agregarArco(Arco arco) {
            arcosenlazados.add(arco);
        }
    }

    public static class Arco {
        Nodo destino;
        int distancia;

        public Arco(Nodo destino, int distancia) {
            this.destino = destino;
            this.distancia = distancia;
        }
    }

    public static int calcularDistanciaMinima(Nodo inicio, Nodo destino) {
        Map<Nodo, Integer> distancias = new HashMap<>();
        Set<Nodo> visitados = new HashSet<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
        Map<Nodo, Nodo> padres = new HashMap<>();

        distancias.put(inicio, 0);
        colaPrioridad.offer(inicio);

        while (!colaPrioridad.isEmpty()) {
            Nodo actual = colaPrioridad.poll();
            visitados.add(actual);

            for (Arco arco : actual.arcosenlazados) {
                Nodo siguiente = arco.destino;
                int distanciaTotal = distancias.get(actual) + arco.distancia;

                if (!visitados.contains(siguiente) && distanciaTotal < distancias.getOrDefault(siguiente, INFINITY)) {
                    distancias.put(siguiente, distanciaTotal);
                    padres.put(siguiente, actual);
                    colaPrioridad.offer(siguiente);
                }
            }
        }

        if (!distancias.containsKey(destino)) {
            System.out.println("No hay una ruta válida desde " + inicio.municipio + " a " + destino.municipio);
            return -1;
        }

        List<Nodo> camino = new ArrayList<>();
        Nodo nodo = destino;
        camino.add(nodo);

        while (padres.containsKey(nodo)) {
            nodo = padres.get(nodo);
            camino.add(nodo);
        }

        System.out.println("Camino más corto desde " + inicio.municipio + " a " + destino.municipio + ":");
        for (int i = camino.size() - 1; i >= 0; i--) {
            System.out.print(camino.get(i).municipio);
            if (i != 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        return distancias.get(destino);
    }

    
}



