package ClassesEstruturas;

import java.util.ArrayList;

/**
 * @author Ramon
 * @author Francesco
 * @author Luís Guilherme Carvalho
 */
public class Node {

    public String valor;
    public ArrayList<Adjacencia> adjacencias;

    public Node(String valor) {
        this.valor = valor;
        adjacencias = new ArrayList<>();
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

    public String toString() {
        return "" + valor;
    }

    public void pai() {
        System.out.println("O pai de " + valor + " é: " + pai);
    }        
}
