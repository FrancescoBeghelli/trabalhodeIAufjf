package ClassesEstruturas;

import java.util.ArrayList;

/**
 *
 * @author Francesco
 */
public class Node {

    String valor;
    ArrayList<Node> adjacencias;
    boolean visitado;
    int maiorSeq;
    Node refMaxNextNode;
    char color;
    int dist;
    Node pai;

    Node(String valor) {
        this.valor = valor;
        adjacencias = new ArrayList<>();
        visitado = false;
        maiorSeq = 0;
        refMaxNextNode = null;
        dist = 0;
    }

    void setValor(String valor) {
        this.valor = valor;
    }

    boolean addCaminho(Node outroNode) {
        if (adjacencias.contains(outroNode)) {
            return false;
        }

        adjacencias.add(outroNode);
        return true;
    }

    void setVisitado() {
        this.visitado = true;
    }

    public String toString() {
        return "" + valor;
    }

    public void pai() {
        System.out.println("O pai de " + valor + " é: " + pai);
    }        
}
