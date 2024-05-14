private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

Estas son las variables de instancia de la clase DosColores. marked es un array de booleanos que indica si un vértice ha sido visitado o no. color es un array de booleanos que almacena el color asignado a cada vértice. isTwoColorable es un booleano que indica si el grafo es bipartito (es decir, si puede ser coloreado con solo dos colores de tal manera que ningún par de vértices adyacentes tenga el mismo color).

Java

    public DosColores(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];

Este es el constructor de la clase DosColores. Inicializa los arrays marked y color con el número de vértices en el grafo G.

Java

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

Este bucle itera sobre todos los vértices en el grafo G. Si un vértice no ha sido marcado como visitado, realiza una búsqueda en profundidad desde ese vértice.

Java

    private void dfs(Graph G, int v) {
        marked[v] = true;
Este es el método de búsqueda en profundidad. Marca el vértice v como visitado.

Java

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }
            else if (color[w] == color[v]) isTwoColorable = false;
        }
    }

Este bucle itera sobre todos los vértices adyacentes al vértice v. Si un vértice adyacente no ha sido marcado como visitado, le asigna un color diferente al de v y realiza una búsqueda en profundidad desde ese vértice. Si un vértice adyacente ha sido marcado como visitado y tiene el mismo color que v, entonces el grafo no es bipartito.

Java

    public boolean isBipartite() {
        return isTwoColorable;
    }
}

Este método devuelve true si el grafo es bipartito y false en caso contrario.
