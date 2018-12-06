/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import ClassesEstruturas.Adjacencia;
import java.util.ArrayList;
import ClassesEstruturas.Node;
import ClassesEstruturas.NodeWithCost;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javafx.collections.transformation.SortedList;

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
    
    
    
    public static void buscaOrdenada(Node origem, Node destino, int count )
    {
        ArrayList<NodeWithCost> abertos = new ArrayList<NodeWithCost>();
                
        HashMap<String, Node> visitados = new HashMap<>();
        abertos.add(new NodeWithCost(origem, 0));
        
        boolean sucesso = false;
        int numIteracoes = 0;
        while(!sucesso)
        {
            if(abertos.isEmpty())
            {
                sucesso = false;
                break;
            }
            else
            {
                NodeWithCost n = abertos.remove(0);
                visitados.put(n.node.valor, n.node);
                
                if(n.node.valor == destino.valor)
                {
                    sucesso = true;
                    break;
                }
                else
                {
                    for(Adjacencia adj : n.node.adjacencias.values())
                    {
                        Node prox = adj.getProx();
                        if(!visitados.containsKey(prox.valor))
                            abertos.add(new NodeWithCost(prox, n.custoTotal + adj.getDist()));
                        else
                        {
                            int i;
                            for(i = 0; i < abertos.size(); i++)
                            {
                                if(abertos.get(i).node.valor == prox.valor)
                                {
                                    abertos.get(i).custoTotal = abertos.get(i).custoTotal < n.custoTotal + adj.getDist() ? abertos.get(i).custoTotal : n.custoTotal + adj.getDist();
                                    break;
                                }
                            }
                        }
                    }
                    
                    Collections.sort(abertos, new Comparator<NodeWithCost>(){
                        @Override
                        public int compare(NodeWithCost o1, NodeWithCost o2) {
                            return o1.custoTotal - o2.custoTotal;
                        }
                    });
                }
            }
            numIteracoes++;
        }
    }
    
    public static void backtracking(Node origem, Node destino)
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
                            caminho.push(prox);
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
