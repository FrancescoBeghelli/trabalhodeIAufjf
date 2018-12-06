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
    public boolean isSolucao;
    
    public Node(String valor) {
        this.valor = valor;
        adjacencias = new ArrayList<>();
        isSolucao = false;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean addCaminho(Node outroNode, int dist) {
        if (adjacencias.contains(outroNode)) {
            return false;
        }

        adjacencias.add(new Adjacencia(dist, outroNode) );
        return true;
    }

    public String toString() {
        return "" + valor;
    }
}
