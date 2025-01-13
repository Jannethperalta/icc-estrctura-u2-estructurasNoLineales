package Main.Materia.Controllers;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import Main.Materia.Models.Node;

public class ArbolRecorridos {

    public String preOrdenInterativo(Node root) {
        if (root == null) {
            return "";
        }

        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.getValue());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return convertirListaAString(result);
    }

    public String preOrdenRecursivo(Node node) {
        List<Integer> result = new ArrayList<>();
        preOrdenRecursivoHelper(node, result);
        return convertirListaAString(result);
    }

    private void preOrdenRecursivoHelper(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.getValue());
            preOrdenRecursivoHelper(node.getLeft(), result);
            preOrdenRecursivoHelper(node.getRight(), result);
        }
    }

    public String posOrdenRecursivo(Node node) {
        List<Integer> result = new ArrayList<>();
        posOrdenRecursivoHelper(node, result);
        return convertirListaAString(result);
    }

    private void posOrdenRecursivoHelper(Node node, List<Integer> result) {
        if (node != null) {
            posOrdenRecursivoHelper(node.getLeft(), result);
            posOrdenRecursivoHelper(node.getRight(), result);
            result.add(node.getValue());
        }
    }

    public String inOrdenRecursivo(Node node) {
        List<Integer> result = new ArrayList<>();
        inOrdenRecursivoHelper(node, result);
        return convertirListaAString(result);
    }

    private void inOrdenRecursivoHelper(Node node, List<Integer> result) {
        if (node != null) {
            inOrdenRecursivoHelper(node.getLeft(), result);
            result.add(node.getValue());
            inOrdenRecursivoHelper(node.getRight(), result);
        }
    }

    private String convertirListaAString(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}