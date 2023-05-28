/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dijkstra;

/**
 *
 * @author Leonel
 */
import java.util.*;

public class AlgoritmoDijkstra {
    private static final int INFINITO = Integer.MAX_VALUE;

    static class Nodo {
        int id;
        String nombre;
        List<Enlace> enlaces;

        public Nodo(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.enlaces = new ArrayList<>();
        }
    }

    static class Enlace {
        Nodo destino;
        int peso;

        public Enlace(Nodo destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {
        // Crear los municipios
        Nodo[] municipios = crearMunicipios();

        // Establecer las conexiones entre los municipios
        establecerConexiones(municipios);

        // Solicitar al usuario los municipios para calcular el recorrido más corto
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero correspondiente al municipio de origen:");
        for (int i = 0; i < municipios.length; i++) {
            System.out.println(i + ": " + municipios[i].nombre);
        }
        int origen = scanner.nextInt();

        System.out.println("Ingrese el numero correspondiente al municipio de destino:");
        for (int i = 0; i < municipios.length; i++) {
            System.out.println(i + ": " + municipios[i].nombre);
        }
        int destino = scanner.nextInt();

        // Calcular el recorrido más corto utilizando el algoritmo de Dijkstra
        int[] distancias = dijkstra(municipios, origen);
        List<Nodo> recorrido = obtenerRecorrido(destino, municipios, distancias);

        // Imprimir el recorrido más corto
        System.out.println("El recorrido mas corto desde " + municipios[origen].nombre + " hasta " + municipios[destino].nombre + " es:");
        for (Nodo nodo : recorrido) {
            System.out.print(nodo.nombre + " -> ");
        }
        System.out.println("Distancia total: " + distancias[destino] + "Km.");
    }

    private static Nodo[] crearMunicipios() {
        Nodo[] municipios = new Nodo[19];
        municipios[0] = new Nodo(0, "Solola");
        municipios[1] = new Nodo(1, "Nahuala");
        municipios[2] = new Nodo(2, "Santa Catarina Ixtahuacan");
        municipios[3] = new Nodo(3, "Santa Lucia Utatlan");
        municipios[4] = new Nodo(4, "Panajachel");
        municipios[5] = new Nodo(5, "Santa Clara La Laguna");
        municipios[6] = new Nodo(6, "San Juan La Laguna");
        municipios[7] = new Nodo(7, "San Pedro La Laguna");
        municipios[8] = new Nodo(8, "Santiago Atitlan");
        municipios[9] = new Nodo(9, "San Antonio Palopa");
        municipios[10] = new Nodo(10, "San Lucas Toliman");
        municipios[11] = new Nodo(11, "Santa Cruz La Laguna");
        municipios[12] = new Nodo(12, "San Marcos La Laguna");
        municipios[13] = new Nodo(13, "Santa Maria Visitacion");
        municipios[14] = new Nodo(14, "San Pablo La Laguna");
        municipios[15] = new Nodo(15, "Concepcion");
        municipios[16] = new Nodo(16, "San Andres Semetabaj");
        municipios[17] = new Nodo(17, "Santa Catarina Palopo");
        municipios[18] = new Nodo(18, "Santa Clara La Laguna");

        return municipios;
    }

    private static void establecerConexiones(Nodo[] municipios) {
        // Sololá
        municipios[0].enlaces.add(new Enlace(municipios[1], 30));
        municipios[0].enlaces.add(new Enlace(municipios[4], 5));
        municipios[0].enlaces.add(new Enlace(municipios[6], 7));
        municipios[0].enlaces.add(new Enlace(municipios[18], 2));

        // Nahualá
        municipios[1].enlaces.add(new Enlace(municipios[0], 30));
        municipios[1].enlaces.add(new Enlace(municipios[3], 6));
        municipios[1].enlaces.add(new Enlace(municipios[16], 8));

        // Santa Catarina Ixtahuacán
        municipios[2].enlaces.add(new Enlace(municipios[1], 3));
        municipios[2].enlaces.add(new Enlace(municipios[6], 9));
        municipios[2].enlaces.add(new Enlace(municipios[10], 7));
        municipios[2].enlaces.add(new Enlace(municipios[17], 4));

        // Santa Lucía Utatlán
        municipios[3].enlaces.add(new Enlace(municipios[1], 6));
        municipios[3].enlaces.add(new Enlace(municipios[2], 9));
        municipios[3].enlaces.add(new Enlace(municipios[16], 5));

        // Panajachel
        municipios[4].enlaces.add(new Enlace(municipios[0], 5));
        municipios[4].enlaces.add(new Enlace(municipios[6], 4));
        municipios[4].enlaces.add(new Enlace(municipios[9], 3));

        // Santa Clara La Laguna
        municipios[5].enlaces.add(new Enlace(municipios[0], 7));
        municipios[5].enlaces.add(new Enlace(municipios[3], 3));
        municipios[5].enlaces.add(new Enlace(municipios[11], 8));

        // San Juan La Laguna
        municipios[6].enlaces.add(new Enlace(municipios[0], 7));
        municipios[6].enlaces.add(new Enlace(municipios[2], 9));
        municipios[6].enlaces.add(new Enlace(municipios[4], 4));
        municipios[6].enlaces.add(new Enlace(municipios[16], 6));

        // San Pedro La Laguna
        municipios[7].enlaces.add(new Enlace(municipios[6], 2));
        municipios[7].enlaces.add(new Enlace(municipios[5], 1));
        municipios[7].enlaces.add(new Enlace(municipios[8], 3));
        municipios[7].enlaces.add(new Enlace(municipios[14], 4));

        // Santiago Atitlán
        municipios[8].enlaces.add(new Enlace(municipios[7], 3));
        municipios[8].enlaces.add(new Enlace(municipios[5], 5));
        municipios[8].enlaces.add(new Enlace(municipios[10], 2));
        municipios[8].enlaces.add(new Enlace(municipios[17], 6));

        // San Antonio Palopó
        municipios[9].enlaces.add(new Enlace(municipios[4], 3));
        municipios[9].enlaces.add(new Enlace(municipios[11], 7));
        municipios[9].enlaces.add(new Enlace(municipios[14], 5));

        // San Lucas Tolimán
        municipios[10].enlaces.add(new Enlace(municipios[2], 7));
        municipios[10].enlaces.add(new Enlace(municipios[8], 2));
        municipios[10].enlaces.add(new Enlace(municipios[15], 4));
        municipios[10].enlaces.add(new Enlace(municipios[17], 5));

        // Santa Cruz La Laguna
        municipios[11].enlaces.add(new Enlace(municipios[5], 8));
        municipios[11].enlaces.add(new Enlace(municipios[6], 2));
        municipios[11].enlaces.add(new Enlace(municipios[14], 6));
        municipios[11].enlaces.add(new Enlace(municipios[15], 1));

        // San Marcos La Laguna
        municipios[12].enlaces.add(new Enlace(municipios[11], 7));
        municipios[12].enlaces.add(new Enlace(municipios[7], 4));
        municipios[12].enlaces.add(new Enlace(municipios[6], 3));

        // Santa María Visitación
        municipios[13].enlaces.add(new Enlace(municipios[1], 4));
        municipios[13].enlaces.add(new Enlace(municipios[14], 2));
        municipios[13].enlaces.add(new Enlace(municipios[15], 5));
        municipios[13].enlaces.add(new Enlace(municipios[16], 9));

        // San Pablo La Laguna
        municipios[14].enlaces.add(new Enlace(municipios[7], 4));
        municipios[14].enlaces.add(new Enlace(municipios[9], 5));
        municipios[14].enlaces.add(new Enlace(municipios[13], 2));

        // Concepción
        municipios[15].enlaces.add(new Enlace(municipios[10], 4));
        municipios[15].enlaces.add(new Enlace(municipios[11], 1));
        municipios[15].enlaces.add(new Enlace(municipios[13], 5));
        municipios[15].enlaces.add(new Enlace(municipios[16], 8));

        // San Andrés Semetabaj
        municipios[16].enlaces.add(new Enlace(municipios[1], 8));
        municipios[16].enlaces.add(new Enlace(municipios[3], 5));
        municipios[16].enlaces.add(new Enlace(municipios[6], 6));
        municipios[16].enlaces.add(new Enlace(municipios[13], 9));
        municipios[16].enlaces.add(new Enlace(municipios[15], 8));

        // Santa Catarina Palopó
        municipios[17].enlaces.add(new Enlace(municipios[2], 4));
        municipios[17].enlaces.add(new Enlace(municipios[8], 6));
        municipios[17].enlaces.add(new Enlace(municipios[10], 5));

        // Santa Clara La Laguna
        municipios[18].enlaces.add(new Enlace(municipios[0], 2));

    }

    private static int[] dijkstra(Nodo[] municipios, int origen) {
        int n = municipios.length;
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = INFINITO;
            visitados[i] = false;
        }

        distancias[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = obtenerMinimo(distancias, visitados);
            visitados[u] = true;

            Nodo nodoU = municipios[u];
            for (Enlace enlace : nodoU.enlaces) {
                Nodo nodoV = enlace.destino;
                int peso = enlace.peso;
                if (!visitados[nodoV.id] && distancias[u] != INFINITO && distancias[u] + peso < distancias[nodoV.id]) {
                    distancias[nodoV.id] = distancias[u] + peso;
                }
            }
        }

        return distancias;
    }

    private static int obtenerMinimo(int[] distancias, boolean[] visitados) {
        int minimo = INFINITO;
        int minimoIndice = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] <= minimo) {
                minimo = distancias[i];
                minimoIndice = i;
            }
        }

        return minimoIndice;
    }

    private static List<Nodo> obtenerRecorrido(int destino, Nodo[] municipios, int[] distancias) {
        List<Nodo> recorrido = new ArrayList<>();
        Stack<Nodo> pila = new Stack<>();
        pila.push(municipios[destino]);

        while (!pila.isEmpty()) {
            Nodo nodo = pila.pop();
            recorrido.add(nodo);

            if (distancias[nodo.id] == 0) {
                break;
            }

            for (Enlace enlace : nodo.enlaces) {
                Nodo nodoAnterior = enlace.destino;
                int peso = enlace.peso;
                if (distancias[nodoAnterior.id] + peso == distancias[nodo.id]) {
                    pila.push(nodoAnterior);
                    break;
                }
            }
        }

        Collections.reverse(recorrido);
        return recorrido;
    }
}

