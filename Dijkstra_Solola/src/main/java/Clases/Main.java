/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static Clases.DijkstraShortestDistance.calcularDistanciaMinima;
import java.util.Scanner;

/**
 *
 * @author Leonel
 */
public class Main {
    public static void main(String[] args) {
        // Crear los nodos (municipios)
        DijkstraShortestDistance.Nodo solola = new DijkstraShortestDistance.Nodo("Sololá");
        DijkstraShortestDistance.Nodo sanPedroLaLaguna = new DijkstraShortestDistance.Nodo("San Pedro La Laguna");
        DijkstraShortestDistance.Nodo sanJuanLaLaguna = new DijkstraShortestDistance.Nodo("San Juan La Laguna");
        DijkstraShortestDistance.Nodo sanMarcosLaLaguna = new DijkstraShortestDistance.Nodo("San Marcos La Laguna");
        DijkstraShortestDistance.Nodo santaClaraLaLaguna = new DijkstraShortestDistance.Nodo("Santa Clara La Laguna");
        DijkstraShortestDistance.Nodo santaLuciaUtatlan = new DijkstraShortestDistance.Nodo("Santa Lucía Utatlán");
        DijkstraShortestDistance.Nodo panajachel = new DijkstraShortestDistance.Nodo("Panajachel");
        DijkstraShortestDistance.Nodo santaCatarinaPalopo = new DijkstraShortestDistance.Nodo("Santa Catarina Palopó");
        DijkstraShortestDistance.Nodo sanAntonioPalopo = new DijkstraShortestDistance.Nodo("San Antonio Palopó");
        DijkstraShortestDistance.Nodo sanLucasToliman = new DijkstraShortestDistance.Nodo("San Lucas Tolimán");
        DijkstraShortestDistance.Nodo santaMariaVisitacion = new DijkstraShortestDistance.Nodo("Santa María Visitación");
        DijkstraShortestDistance.Nodo santaMariaSantiagoAtitlan = new DijkstraShortestDistance.Nodo("Santa María Santiago Atitlán");
        DijkstraShortestDistance.Nodo sanJuanAtitlan = new DijkstraShortestDistance.Nodo("San Juan Atitlán");
        DijkstraShortestDistance.Nodo sanPedroAtitlan = new DijkstraShortestDistance.Nodo("San Pedro Atitlán");
        DijkstraShortestDistance.Nodo sanPabloLaLaguna = new DijkstraShortestDistance.Nodo("San Pablo La Laguna");
        DijkstraShortestDistance.Nodo sanAndresSemetabaj = new DijkstraShortestDistance.Nodo("San Andrés Semetabaj");
        DijkstraShortestDistance.Nodo santaCatarinaIxtahuacan = new DijkstraShortestDistance.Nodo("Santa Catarina Ixtahuacán");
        DijkstraShortestDistance.Nodo santaLuciaMonteBello = new DijkstraShortestDistance.Nodo("Santa Lucía Monte Bello");
        DijkstraShortestDistance.Nodo nahuala = new DijkstraShortestDistance.Nodo("Nahualá");
        // Agregar más nodos para los municipios de Sololá

        // Agregar los arcosenlazados entre los municipios con sus respectivas distancias
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanPedroLaLaguna, 10));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanJuanLaLaguna, 9));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanMarcosLaLaguna, 15));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaClaraLaLaguna, 8));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaLuciaUtatlan, 5));
        solola.agregarArco(new DijkstraShortestDistance.Arco(panajachel, 3));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaCatarinaPalopo, 7));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanAntonioPalopo, 6));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanLucasToliman, 12));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaMariaVisitacion, 20));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaMariaSantiagoAtitlan, 18));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanJuanAtitlan, 14));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanPedroAtitlan, 15));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanPabloLaLaguna, 11));
        solola.agregarArco(new DijkstraShortestDistance.Arco(sanAndresSemetabaj, 13));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaCatarinaIxtahuacan, 16));
        solola.agregarArco(new DijkstraShortestDistance.Arco(santaLuciaMonteBello, 7));
        solola.agregarArco(new DijkstraShortestDistance.Arco(nahuala, 22));
        

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del municipio de origen: ");
        String origen = scanner.nextLine();

        System.out.println("Ingrese el nombre del municipio de destino: ");
        String destino = scanner.nextLine();

        // Buscar los nodos de origen y destino
        DijkstraShortestDistance.Nodo nodoOrigen = null;
        DijkstraShortestDistance.Nodo nodoDestino = null;

        // Buscar los nodos de origen y destino en la lista de municipios
        if (solola.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = solola;
        } else if (sanPedroLaLaguna.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanPedroLaLaguna;
        } else if (sanJuanLaLaguna.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanJuanLaLaguna;
        } else if (sanMarcosLaLaguna.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanMarcosLaLaguna;
        } else if (santaClaraLaLaguna.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaClaraLaLaguna;
        } else if (santaLuciaUtatlan.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaLuciaUtatlan;
        } else if (panajachel.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = panajachel;
        } else if (santaCatarinaPalopo.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaCatarinaPalopo;
        } else if (sanAntonioPalopo.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanAntonioPalopo;
        } else if (sanLucasToliman.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanLucasToliman;
        } else if (santaMariaVisitacion.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaMariaVisitacion;
        } else if (santaMariaSantiagoAtitlan.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaMariaSantiagoAtitlan;
        } else if (sanJuanAtitlan.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanJuanAtitlan;
        } else if (sanPedroAtitlan.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanPedroAtitlan;
        } else if (sanPabloLaLaguna.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanPabloLaLaguna;
        } else if (sanAndresSemetabaj.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = sanAndresSemetabaj;
        } else if (santaCatarinaIxtahuacan.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaCatarinaIxtahuacan;
        } else if (santaLuciaMonteBello.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = santaLuciaMonteBello;
        } else if (nahuala.municipio.equalsIgnoreCase(origen)) {
            nodoOrigen = nahuala;
        }
        // Agregar más condiciones para los municipios de Sololá

        // Buscar los nodos de origen y destino en la lista de municipios
        if (solola.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = solola;
        } else if (sanPedroLaLaguna.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanPedroLaLaguna;
        } else if (sanJuanLaLaguna.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanJuanLaLaguna;
        } else if (sanMarcosLaLaguna.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanMarcosLaLaguna;
        } else if (santaClaraLaLaguna.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaClaraLaLaguna;
        } else if (santaLuciaUtatlan.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaLuciaUtatlan;
        } else if (panajachel.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = panajachel;
        } else if (santaCatarinaPalopo.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaCatarinaPalopo;
        } else if (sanAntonioPalopo.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanAntonioPalopo;
        } else if (sanLucasToliman.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanLucasToliman;
        } else if (santaMariaVisitacion.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaMariaVisitacion;
        } else if (santaMariaSantiagoAtitlan.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaMariaSantiagoAtitlan;
        } else if (sanJuanAtitlan.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanJuanAtitlan;
        } else if (sanPedroAtitlan.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanPedroAtitlan;
        } else if (sanPabloLaLaguna.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanPabloLaLaguna;
        } else if (sanAndresSemetabaj.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = sanAndresSemetabaj;
        } else if (santaCatarinaIxtahuacan.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaCatarinaIxtahuacan;
        } else if (santaLuciaMonteBello.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = santaLuciaMonteBello;
        } else if (nahuala.municipio.equalsIgnoreCase(destino)) {
            nodoDestino = nahuala;
        }
        // Agregar más condiciones para los municipios de Sololá

        if (nodoOrigen != null && nodoDestino != null) {
            int distanciaMinima = calcularDistanciaMinima(nodoOrigen, nodoDestino);
            System.out.println("Distancia mínima: " + distanciaMinima + " km");
        } else {
            System.out.println("Municipio de origen o destino no válido");
        }
    }
    
}
