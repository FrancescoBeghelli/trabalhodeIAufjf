package ClassesEstruturas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ramon
 * @author Francesco
 * @author Luís Guilherme Carvalho
 */
public class Node {

    public String valor;
    public HashMap<String, Adjacencia> adjacencias;
    public boolean isSolucao;
    
    public Node(String valor) {
        this.valor = valor;
        adjacencias = new HashMap<>();
        isSolucao = false;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean addCaminho(Node outroNode, int dist) {
        if (adjacencias.containsKey(outroNode.valor)) {
            return false;
        }

        adjacencias.put(outroNode.valor, new Adjacencia(dist, outroNode));
        return true;
    }

    public String toString() {
        return "" + valor;
    }
}
