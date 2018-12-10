/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteAlgoritmos;

import ClassesEstruturas.Adjacencia;
import ClassesEstruturas.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Guilherme
 */
public class EstruturaAlgoritmosInformados {
    
    public static void buscaGulosa(Node origem, Node destino)
    {
        System.out.println("\n***Busca gulosa***");
        List<Node> solucao = new ArrayList<Node>();
        HashMap<String, Node> impasse = new HashMap<String, Node>();

        solucao.add(origem);

        boolean sucesso = false;
        int numIteracoes = 0;
        while (sucesso != true) {
            if (solucao.isEmpty()) {
                sucesso = false;
                break;
            } else {
                Node v = solucao.get(solucao.size() - 1);
                
                System.out.println("Abrindo estado " + v.valor);
                if (v.valor == destino.valor) {
                    sucesso = true;
                    break;
                } else {
                    Node menor = null;
                    for (Adjacencia adj : v.adjacencias.values()) {
                        Node prox = adj.getProx();
                        
                        if(!impasse.containsKey(prox.valor) && (menor == null || prox.heuristica < menor.heuristica))
                            menor = prox;
                    }
                    
                    if(menor != null)
                    {
                        solucao.add(menor);
                    }
                    else
                    {
                        System.out.println("Impasse, voltando um passo atrás");
                        impasse.put(v.valor, v);
                        solucao.remove(v);
                    }
                }
            }

            numIteracoes++;
        }

        if (sucesso) {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            int custoTotal = 0;
            Node anterior = null;
            for (Node node : solucao) {
                sb.append(" " + node.valor);
                
                if(anterior != null)
                    custoTotal += node.adjacencias.get(anterior.valor).getDist();
                anterior = node;
            }
            sb.append("}");
            System.out.println(sb.toString());
            System.out.println("Custo total " + custoTotal);
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }
    
    public static void buscaAEstrela(Node origem, Node destino)
    {
        System.out.println("\n***Busca gulosa***");
        List<Node> solucao = new ArrayList<Node>();
        HashMap<String, Node> impasse = new HashMap<String, Node>();

        solucao.add(origem);

        boolean sucesso = false;
        int numIteracoes = 0;
        while (sucesso != true) {
            if (solucao.isEmpty()) {
                sucesso = false;
                break;
            } else {
                Node v = solucao.get(solucao.size() - 1);
                
                System.out.println("Abrindo estado " + v.valor);
                if (v.valor == destino.valor) {
                    sucesso = true;
                    break;
                } else {
                    Node menor = null;
                    for (Adjacencia adj : v.adjacencias.values()) {
                        Node prox = adj.getProx();
                        
                        if(!impasse.containsKey(prox.valor) && (menor == null || prox.heuristica < menor.heuristica))
                            menor = prox;
                    }
                    
                    if(menor != null)
                    {
                        solucao.add(menor);
                    }
                    else
                    {
                        System.out.println("Impasse, voltando um passo atrás");
                        impasse.put(v.valor, v);
                        solucao.remove(v);
                    }
                }
            }

            numIteracoes++;
        }

        if (sucesso) {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            int custoTotal = 0;
            Node anterior = null;
            for (Node node : solucao) {
                sb.append(" " + node.valor);
                
                if(anterior != null)
                    custoTotal += node.adjacencias.get(anterior.valor).getDist();
                anterior = node;
            }
            sb.append("}");
            System.out.println(sb.toString());
            System.out.println("Custo total " + custoTotal);
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }
}
