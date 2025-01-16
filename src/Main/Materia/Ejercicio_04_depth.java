package Main.Materia;

import Main.Materia.Models.Node;

public class Ejercicio_04_depth {
    // Método principal para calcular la profundidad máxima
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());
        
        // Retornar la máxima profundidad + 1 (el nivel actual)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    

}