package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolAVL {

    private Node root;

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);

    }

    private Node insert(Node nodo, int value) {
        if (nodo == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            return newNode;
        }

        if (value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));
        } else if (value < nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));
        } else {
            return nodo;
        }
        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));
        // Obtener el balance o factor de equilibrio del nodo ancestro
        int balance = getBalance(nodo);

        // Caso izquierda - izquierda
        if (balance > 1 && value < nodo.getLeft().getHeight()) {

        }

        // Caso derecha - derecha
        if (balance < -1 && value > nodo.getRight().getValue()) {

        }

        // Caso izquierda - derecha
        if (balance > 1 && value > nodo.getLeft().getValue()) {

        }

        // Caso derecha - izquierda
        if (balance < -1 && value < nodo.getRight().getValue()) {

        }
        return nodo;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void printTree() {
        printTree(root, " ", true);
    }


    private Node righRotate( Node y){
        Node x = y.getLeft();
        Node temp = x.getRight();


        System.out.println("Rotamos derecha el nodo: "+y.getValue());

        x.setRight(y);
        y.setLeft(temp);



        y.setHeight((Math.max(height(y.getLeft()), height(y.getRight()))));
        x.setHeight((Math.max(height(x.getLeft()), height(x.getRight()))));

        System.out.println("Nueva raiz despues de rotacion: "+x.getValue());



        return x;

    }

    private Node leftRotate(Node x){
        Node y = x.getRight();
        Node temp = y.getLeft();
        //Imprimir informaion antes de la rotacion 
        System.out.println("Left rotate on node: "+x.getValue());

        //Realizar la rotacion 

        y.setLeft(x);
        x.setRight(temp);

        //Actualizar alturas 
        x.setHeight((Math.max(height(x.getLeft()), height(x.getRight()))));
        y.setHeight((Math.max(height(y.getLeft()), height(y.getRight()))));

        //imprimir informacion despues de la rotacion 

        System.out.println("New root after left rotate: "+y.getValue());

        //devolver nueva raiz 
        return y;
        


    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├──" : "└──") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "├── null");
                }

                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "└── null");
                }
            }
        }
    }

    

    public Node getRoot() {
        return root;
    }
}