/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import ClassesEstruturas.Adjacencia;
import java.util.ArrayList;
import ClassesEstruturas.Node;
import ClassesEstruturas.Grafo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ramon
 * @author Francesco
 * @author Guilherme Carvalho
 */
public class EstruturaAlgoritmos {
    
    public static void buscaEmProfundidade(Node origem, Node destino) {
        Stack<Node> abertos = new Stack<>();
        HashMap<String, Node> visitados = new HashMap<>();

        abertos.push(origem);

        boolean sucesso = false;    
        int numIteracoes = 0;
        while (sucesso != false) {
            if(abertos.isEmpty())
            {
                sucesso = false;
                return;
            }
            else
            {
                Node v = abertos.pop();
                v.isSolucao = true;
                System.out.println("Abrindo estado " + v.valor);
                visitados.put(v.valor, v);
                if(v.valor == destino.valor)
                {
                    sucesso = true;
                    return;
                }
                else
                {
                   for(Adjacencia adj : v.adjacencias.values()){
                        Node prox = adj.getProx();
                        if(!visitados.containsKey(prox.valor)){
                            System.out.println(v.valor + " >> " + prox.valor);
                            abertos.push(prox);
                        }                
                    }
                }
            }

            numIteracoes++;
        }

        if(sucesso)
        {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
            imprimeSolucaoEmProfundidade(visitados);
        }
        else
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
    }
    
    public static void buscaEmLargura(Node origem, Node destino) {
        Queue<Node> abertos = new LinkedList<>();
        HashMap<String, Node> visitados = new HashMap<>();

        abertos.add(origem);

        boolean sucesso = false;    
        int numIteracoes = 0;
        
        while (sucesso != false) {
            if(abertos.isEmpty())
            {
                sucesso = false;
                return;
            }
            else
            {
                Node v = abertos.remove();
                v.isSolucao = true;
                System.out.println("Abrindo estado " + v.valor);
                visitados.put(v.valor, v);
                if(v.valor == destino.valor)
                {
                    sucesso = true;
                    return;
                }
                else
                {
                   for(Adjacencia adj : v.adjacencias.values()){
                        Node prox = adj.getProx();
                        if(!visitados.containsKey(prox.valor)){
                            System.out.println(v.valor + " >> " + prox.valor);
                            abertos.add(prox);
                        }                
                    }
                }
            }

            numIteracoes++;
        }

        if(sucesso)
        {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
        else
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
    }
    
    //computa o conjunto solução
    public static void imprimeSolucaoEmProfundidade(HashMap<String, Node> visitados)
    {
        System.out.println("Conjunto solução: ");
        StringBuilder sb = new StringBuilder();
        
        Node anterior = null;
        int custo = 0;
        for (Node v : visitados.values()) {
            if(v.isSolucao)
            {
                sb.append(" [" + v.valor + "]");
                
                if(anterior != null)
                {
                    custo += anterior.adjacencias.get(v.valor).getDist();
                }
                anterior = v;
            }
        }
        
        System.out.println("Custo total: " + custo);
    }
    
}
