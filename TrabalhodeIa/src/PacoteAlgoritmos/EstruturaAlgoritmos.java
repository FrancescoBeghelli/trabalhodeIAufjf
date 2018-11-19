/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import java.util.ArrayList;
import ClassesEstruturas.Node;
import java.util.Stack;

/**
 *
 * @author Francesco
 */
public class EstruturaAlgoritmos {
    
    static void buscaEmProfundidade(ArrayList<Node> grafo, Node origem) {
    Stack<Node> pilha = new Stack<>();
    for (int i = 0; i < grafo.size(); i++) {
        grafo.get(i).visitado = false;            
    }

    pilha.push(origem);
    origem.setVisitado();

    while (!pilha.isEmpty()) {
        Node v = pilha.peek();
        System.out.println(pilha);

        for(int i = 0; i <v.adjacencias.size(); i++){
            Node adj = v.adjacencias.get(i);
            if(adj.visitado == false){
                System.out.println(v + " >> "+adj);
                pilha.push(adj);
                adj.setVisitado();
            }                
        }
        pilha.pop();
    }
}
    
}
