package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolBinario {
    private Node root;
    
    public void insert(int value) {
        root = insert (root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value); 
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }
    
    public void printTree(){
        printTree(root, " ", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft){
        if (node != null){
            // Cambie root.getValue() a node.getValue()
            System.out.println(prefix + (isLeft ? "├── " : "└──") + node.getValue());

            if (node.getLeft() != null || node.getRight() != null){
                if (node.getLeft() != null){
                    printTree(node.getLeft(), prefix + (isLeft ? "| " : "  "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "| " : " ") + "└── null");
                }

                if (node.getRight() != null){
                    // Use node.getRight() en lugar de node.getLeft()
                    printTree(node.getRight(), prefix + (isLeft ? "| " : "  "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "| " : " ") + "└── null");
                }
            }
        }
    }
    public Node getRoot() {
        return root;
    }    
}