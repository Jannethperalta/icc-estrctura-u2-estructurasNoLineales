package Main.Materia;

import Main.Materia.Models.Node;
import java.util.*;

public class Ejercicio_01_insert {
    
    private static int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    private static void fillLevel(Node node, int level1, List<List<String>> level) {
        if (node == null) return;
        
        level.get(level1).add(String.valueOf(node.getValue()));
        fillLevel(node.getLeft(), level1 + 1, level);
        fillLevel(node.getRight(), level1 + 1, level);
    }

    public static void printTree(Node root) {
        if (root == null) return;
        int height = getHeight(root);

        List<List<String>> level1 = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            level1.add(new ArrayList<>());
        }

        fillLevel(root, 0, level1);
        for (List<String> level : level1) {
            System.out.print("  ".repeat(height - level.indexOf(level1) - 1));
            for (String value : level) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } 
        else if (value > root.getValue()) {
            root.setRight(insert(root.getRight(), value));
        }
        return root;
    }

}