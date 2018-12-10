package ClassesEstruturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ramon
 * @author Francesco
 * @author Luís Guilherme Carvalho
 */
public class Node {

    public String valor;
    public int heuristica;
    public LinkedHashMap<String, Adjacencia> adjacencias;
    public boolean isSolucao;
    
    public Node() {
        adjacencias = new LinkedHashMap<>();
        isSolucao = false;
    }

    public Node(String valor) {
        this.valor = valor;
        adjacencias = new LinkedHashMap<>();
        isSolucao = false;
    }
    
    public Node(String valor, int heuristica) {
        this.valor = valor;
        adjacencias = new LinkedHashMap<>();
        isSolucao = false;
        this.heuristica = heuristica;
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
