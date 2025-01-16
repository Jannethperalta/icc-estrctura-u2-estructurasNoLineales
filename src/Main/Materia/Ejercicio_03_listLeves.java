package Main.Materia;

import Main.Materia.Models.Node;
import java.util.*;

public class Ejercicio_03_listLeves {
    // Clase interna para los nodos de la lista enlazada
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Método principal que devuelve la lista de listas enlazadas por nivel
    public static List<ListNode> listLevels(Node root) {
        if (root == null) return new ArrayList<>();
        
        List<ListNode> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;
            
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                current.next = new ListNode(node.getValue());
                current = current.next;
                
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            
            result.add(dummyHead.next);
        }
        
        return result;
    }

    // Método para imprimir las listas enlazadas por nivel
    public static void printLevelLists(List<ListNode> level) {
        for (int i = 0; i < level.size(); i++) {
            ListNode current = level.get(i);
            boolean first = true;
            
            while (current != null) {
                if (!first) {
                    System.out.print(" -> ");
                }
                System.out.print(current.val);
                first = false;
                current = current.next;
            }
            System.out.println();
        }
    }
    
}