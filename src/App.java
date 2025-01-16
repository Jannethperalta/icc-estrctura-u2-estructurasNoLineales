import java.util.List;

import Main.Ejercicio_3_listLevels.*;
import Main.Materia.Ejercicio_01_insert;
import Main.Materia.Ejercicio_02_invert;
import Main.Materia.Ejercicio_03_listLeves;
import Main.Materia.Ejercicio_04_depth;
import Main.Materia.Controllers.ArbolAVL;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorridos;
import Main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        //runEjercicio3();
        //runArbolAvl();
        runEjercicio1Insert();
        runEjercicio2Invert();
        runEjercicio3();
        runEjercicio4Depth();
    }
    
    public static void runArbolBinario() {
        ArbolBinario arbolBinario = new ArbolBinario();
        ArbolRecorridos arbolRecorridos = new ArbolRecorridos();

        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        // Insertar valores en el árbol binario
        for (int i = 0; i < valores.length; i++) {
            arbolBinario.insert(valores[i]);
        }

        System.out.println();
        arbolBinario.printTree();

        System.out.println();
        System.out.println("Recorrido PreOrder");
        arbolRecorridos.preOrdenInterativo(arbolBinario.getRoot());
        System.out.println();
        System.out.println("Recorrido PostOrder");
        arbolRecorridos.posOrdenRecursivo(arbolBinario.getRoot());
        System.out.println();
        System.out.println("Recorrido InOrder");
        arbolRecorridos.inOrdenRecursivo(arbolBinario.getRoot());
    }

    public static void runEjercicio3() {
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevels listLeves = new ListLevels();
        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        for (int valor : valores) {
            arbolBinario.insert(valor);
        }

        System.out.println();
        System.out.println("Listas por Nivel:");
      
    }

    public static void runArbolAvl() {
        int[] values = {15, 20, 10, 24, 9, 8, 21, 23, 50, 25};

        ArbolAVL arbolAVL = new ArbolAVL();

        System.out.println("Insertando nodos en el árbol AVL...");

        for (int value : values) {
            arbolAVL.insert(value);
        }

        System.out.println("\nÁrbol AVL después de todas las inserciones:");
        arbolAVL.printTree(arbolAVL.getRoot(), "", true);
    }

    //Ejercicio1

    public static void runEjercicio1Insert() {
        System.out.println("Ejercicio 1");
        // Input: valores a insertar en el BST
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        Node root = null;
        for (int value : values) {
            root = Ejercicio_01_insert.insert(root, value);
        }
        System.out.println("El Árbol Binario de Búsqueda en orden:");
        Ejercicio_01_insert.printTree(root);

    }

    //EJercicio 2
     public static void runEjercicio2Invert() {
        System.out.println("Ejercicio 2");
        // Crear el árbol del ejemplo
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));

        // Mostrar árbol original
        System.out.println("Árbol Original:");
        Ejercicio_01_insert.printTree(root);  

        // Invertir el árbol
        root = Ejercicio_02_invert.invert(root);
        System.out.println("\nÁrbol Invertido:");
        Ejercicio_01_insert.printTree(root); 
        
        
    }


    //Ejercicio 3
    public static void runEjercicio3ListLevels() {
        System.out.println("Ejercicio 3");
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));

        // Mostrar árbol original
        System.out.println("Árbol Original:");
        Ejercicio_01_insert.printTree(root);
        System.out.println("\nListas por nivel:");
        List<Ejercicio_03_listLeves.ListNode> levelLists = Ejercicio_03_listLeves.listLevels(root);
        Ejercicio_03_listLeves.printLevelLists(levelLists);
    }

    //Ejercicio 4
    public static void runEjercicio4Depth() {
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setRight(new Node(8));

        // Mostrar árbol original
        System.out.println("Árbol Original:");
        Ejercicio_01_insert.printTree(root);

        // Calcular y mostrar la profundidad máxima
        int maxDepth = Ejercicio_04_depth.maxDepth(root);
        System.out.println("\nProfundidad máxima: " + maxDepth);
    }
}
