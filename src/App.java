import Main.Ejercicio_3_listLevels.*;
import Main.Materia.Controllers.ArbolAVL;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        //runEjercicio3();
        runArbolAvl();
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
        listLeves.imprimirListasPorNivel(listLeves.ListLevels(arbolBinario.getRoot()));
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
}