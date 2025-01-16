package Main.Materia;

import Main.Materia.Models.Node;

public class Ejercicio_02_invert {
    public static Node invert(Node root) {
        
        if (root == null) {
            return null;
        }

        // Invertir recursivamente los subárboles
        Node left = invert(root.getLeft());
        Node right = invert(root.getRight());
        // Intercambiar los hijos
        root.setLeft(right);
        root.setRight(left);

        return root;
    }
}