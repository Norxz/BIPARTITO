package main;

/**
 *
 * @author espin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph G = new Graph(6); // Suponiendo que 5 es el número de vértices
        /*
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 0); // Esto crea un ciclo
        */
        G.addEdge(0, 1);
        G.addEdge(1, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(2, 5);

        // Verificar si el grafo tiene un ciclo
        Ciclo detectorDeCiclos = new Ciclo(G);
        if (detectorDeCiclos.tieneCiclo()) {
            System.out.println("El grafo tiene un ciclo.");
        } else {
            System.out.println("El grafo no tiene ciclos.");
        }

        // Verificar si el grafo es bipartito
        DosColores verificadorBipartito = new DosColores(G);
        if (verificadorBipartito.isBipartite()) {
            System.out.println("El grafo es bipartito.");
        } else {
            System.out.println("El grafo no es bipartito.");
        }
    }
}
