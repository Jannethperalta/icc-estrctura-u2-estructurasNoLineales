package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolAVL {
    private Node root;
    
    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value) {
        if(nodo == null) {
            System.out.println("Nodo insertado: " + value);
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if(value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));
        } else if(value > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));
        }else {
            return nodo;
        }

        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));
        // Obtener el balance o factor de equilibrio del nodo ancestro
        int balance = getBalance(nodo);
        System.out.println("- Nodo actual: " + nodo.getValue());
        System.out.println("  Altura del nodo: " + nodo.getHeight() + " (izq: " + height(nodo.getLeft()) + ", der: " + height(nodo.getRight()) + ")");
        System.out.println("  Equilibrio del nodo: " + balance);

        // Caso Izquierda - Izquierda
        if(balance > 1 && value < nodo.getLeft().getValue()) {
            System.out.println("  Rotación Der en nodo " + nodo.getValue() + ", Balance: " + balance);
            return rightRotate(nodo);
        }
        // Caso Derecha - Derecha
        if(balance < -1 && value > nodo.getRight().getValue()) {
            System.out.println("  Rotación Izq en nodo " + nodo.getValue() + ", Balance: " + balance);
            return leftRotate(nodo);
        }
        // Caso Izquierda - Derecha
        if(balance > 1 && value > nodo.getLeft().getValue()) {
            System.out.println("  Rotación Izq-Der en nodo " + nodo.getValue());
            nodo.setLeft(leftRotate(nodo.getLeft()));
            return rightRotate(nodo);
        }
        // Caso Derecha - Izquierda
        if(balance < -1 && value < nodo.getRight().getValue()) {
            System.out.println("  Rotación Der-Izq en nodo " + nodo.getValue());
            nodo.setRight(rightRotate(nodo.getRight()));
            return leftRotate(nodo);
        }
        // Devolvemos el nodo sin cambio
        return nodo;
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();
        // Imprimir informacion antes de la rotacion
        System.out.println("Rotamos derecha el nodo: " + y.getValue());
        // Realizamos la rotacion
        x.setRight(y);
        y.setLeft(temp);
        // Actualizamos las alturas
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        System.out.println("Nueva raiz despues de la rotacion:" + x.getValue());
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();
        // Impirmir informacion antes de la rotacion
        System.out.println("Rotamos izquierda el nodo: " + x.getValue() + ", Balance: " + getBalance(x));
        // Realizamos la rotacion
        y.setLeft(x);
        x.setRight(temp);
        // Actualizamos las alturas
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        // Imprimir informacion despues de la rotacion
        System.out.println("Nueva raiz despues de la rotacion:" + y.getValue());
        // Devolver nueca raiz
        return y;
    }

    private int height(Node node) {
        if(node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if(node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }

                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}