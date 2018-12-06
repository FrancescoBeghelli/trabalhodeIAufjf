/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEstruturas;

/**
 *
 * @author Guilherme
 */
public class Adjacencia {
    private int dist;
    private Node prox;

    public Adjacencia(int dist, Node prox) {
        this.dist = dist;
        this.prox = prox;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Node getProx() {
        return prox;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }
}
