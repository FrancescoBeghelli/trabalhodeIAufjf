package ClassesEstruturas;

import java.util.ArrayList;

/**
 *
 * @author Francesco
 */
public class Node {

    public String valor;
    public ArrayList<Node> adjacencias;
    public boolean visitado;
    public int dist;
    public Node pai;

    public Node(String valor) {
        this.valor = valor;
        adjacencias = new ArrayList<>();
        visitado = false;
        dist = 0;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean addCaminho(Node outroNode) {
        if (adjacencias.contains(outroNode)) {
            return false;
        }

        adjacencias.add(outroNode);
        return true;
    }

    public void setVisitado() {
        this.visitado = true;
    }

    public String toString() {
        return "" + valor;
    }

    public void pai() {
        System.out.println("O pai de " + valor + " é: " + pai);
    }        
}
