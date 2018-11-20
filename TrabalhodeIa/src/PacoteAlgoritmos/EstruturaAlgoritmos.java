/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import java.util.ArrayList;
import ClassesEstruturas.Node;
import ClassesEstruturas.Grafo;
import java.util.Stack;

/**
 *
 * @author Francesco
 */
public class EstruturaAlgoritmos {
    
    static void buscaEmProfundidade(Grafo grafo, Node origem) {
    Stack<Node> pilha = new Stack<>();
    ArrayList<Node> aberto = grafo;
    
    pilha.push(origem);
    boolean fracasso = false;
    boolean sucesso = false;    
    
    while (sucesso != false || fracasso != false) {
        if(aberto == null)
        
        Node v = pilha.pop();
        System.out.println(pilha);

        for(int i = 0; i <v.adjacencias.size(); i++){
            Node adj = v.adjacencias.get(i);
            if(adj.visitado == false){
                System.out.println(v + " >> "+adj);
                pilha.push(adj);
                adj.setVisitado();
            }                
        }
    }

    enquanto não (sucesso ou fracasso) faça
        se abertos = vazio então
            fracasso := T;
        senão
            N := primeiro(abertos); {pilha(topo), fila(primeiro)}
            se N = solução então
                sucesso := T;
            senão
                enquanto R(N) ≠ vazio faça
                    escolha r de R(N); new(u);
                    u := r(N); insere(u, abertos);
                    atualiza R(N);
                fim-enquanto;
                insere(N, fechados); {destrua(N)}
            fim-se;
        fim-se;
    fim-enquanto;
}
    
}
