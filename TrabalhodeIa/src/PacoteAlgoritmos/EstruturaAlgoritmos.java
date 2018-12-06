/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import ClassesEstruturas.Adjacencia;
import java.util.ArrayList;
import ClassesEstruturas.Node;
import java.util.HashMap;
import java.util.LinkedList;
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
                break;
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
                    break;
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
        LinkedList<Node> abertos = new LinkedList<>();
        HashMap<String, Node> visitados = new HashMap<>();

        abertos.add(origem);

        boolean sucesso = false;    
        int numIteracoes = 0;
        
        while (sucesso != false) {
            if(abertos.isEmpty())
            {
                sucesso = false;
                break;
            }
            else
            {
                Node v = abertos.removeFirst();
                v.isSolucao = true;
                System.out.println("Abrindo estado " + v.valor);
                visitados.put(v.valor, v);
                if(v.valor == destino.valor)
                {
                    sucesso = true;
                    break;
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
    
    public static void backtracking(Node origem, Node destino, int count )
    {
        HashMap<String, Node> visitados = new HashMap<>();
        Stack<Node> caminho = new Stack<>();
        
        boolean sucesso = false;
        
        caminho.push(origem);
        visitados.put(origem.valor, origem);
        
        int numIteracoes = 0;
        while(!sucesso)
        {
            boolean inseriu = false;
            
            if(caminho.isEmpty())
            {
                sucesso = false;
                break;
            }
            else
            {
                Node v = caminho.peek();
                if(v.valor == destino.valor)
                {
                    sucesso = true;
                    break;
                }
                else
                {
                    for(Adjacencia adj : v.adjacencias.values())
                    {
                        Node prox = adj.getProx();
                        if(!visitados.containsKey(prox.valor))
                        {
                            inseriu = true;
                            caminho.add(prox);
                            visitados.put(prox.valor, prox);
                            break;
                        }
                    }
                }
            }
            numIteracoes++;
            
            if(!inseriu)
                caminho.pop();
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
