import main.Ejercicio_3_listLevels.ListLevels;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;

import java.util.List;

public class App {
    private static ArbolBinario arbolBinario;
    private static ArbolRecorridos arbolRecorrido;
    private static final int[] VALORES = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

    public static void main(String[] args) {
        inicializarArboles();

        System.out.println("\nÁrbol Binario:");
        arbolBinario.printTree();

        System.out.println("\nPreorden Iterativo:");
        System.out.println(arbolRecorrido.preOrdenInterativo(arbolBinario.getRoot()));

        System.out.println("\nPreorden Recursivo:");
        System.out.println(arbolRecorrido.preOrdenRecursivo(arbolBinario.getRoot()));

        System.out.println("\nPostorden:");
        System.out.println(arbolRecorrido.posOrdenRecursivo(arbolBinario.getRoot()));

        System.out.println("\nInorden:");
        System.out.println(arbolRecorrido.inOrdenRecursivo(arbolBinario.getRoot()));

        // Ejercicio 3: Mostrar niveles del árbol
        Ejerccio3();
    }

    private static void inicializarArboles() {
        arbolBinario = new ArbolBinario();
        arbolRecorrido = new ArbolRecorridos();

        for (int valor : VALORES) {
            arbolBinario.insert(valor);
        }
    }

    private static void Ejerccio3() {
        System.out.println("\nEjercicio 3: Listar Niveles del Árbol");

        // Crear el árbol binario y el objeto para listar niveles
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevels levels = new ListLevels();

        // Insertar valores en el árbol
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int valor : valores) {
            arbolBinario.insert(valor);
        }

        // Mostrar el árbol
        arbolBinario.printTree();

        // Obtener los niveles del árbol
        List<List<Integer>> lista = levels.ListLevels(arbolBinario.getRoot());

        // Imprimir los niveles
        System.out.println("\nNiveles del árbol:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Nivel " + i + ": " + lista.get(i));
        }
    }
}