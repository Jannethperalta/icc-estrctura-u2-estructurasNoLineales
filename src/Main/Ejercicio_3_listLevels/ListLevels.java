package Main.Ejercicio_3_listLevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Main.Materia.Models.Node;

public class ListLevels {
    public List<List<Integer>> ListLevels(Node root) {
        // Lista que almacenará los niveles
        List<List<Integer>> result = new ArrayList<>();

        // Si el árbol está vacío
        if (root == null) {
            return result;
        }

        // Cola para realizar un recorrido por niveles
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Bucle para recorrer todos los niveles
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Número de nodos en el nivel actual
            List<Integer> currentLevel = new ArrayList<>(); // Lista para este nivel

            for (int i = 0; i < levelSize; i++) {
                // Sacar el nodo de la cola
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.getValue());

                // Agregar los hijos a la cola
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            // Agregar la lista del nivel actual al resultado
            result.add(currentLevel);
        }

        return result;
    }
    public void imprimirListasPorNivel(List<LinkedList<Node>> listas) {
        int nivel = 0;
        for (LinkedList<Node> lista : listas) {
            System.out.print("Nivel " + nivel++ + ": ");
            for (Node nodo : lista) {
                System.out.print(nodo.getValue() + " -> ");
            }
            System.out.println("null");
        }
    }
}