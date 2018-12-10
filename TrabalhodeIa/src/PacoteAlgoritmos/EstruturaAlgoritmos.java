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
import java.util.LinkedHashMap;
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
        System.out.println("\n***Busca em profundidade***");
        Stack<NodeWithCost> abertos = new Stack<>();
        LinkedList<Node> todosAbertos = new LinkedList<>();
        LinkedHashMap<String, Node> visitados = new LinkedHashMap<>();

        abertos.push(new NodeWithCost(null, origem, 0));
        todosAbertos.add(origem);

        boolean sucesso = false;
        int numIteracoes = 0;
        NodeWithCost estadoFinal = null;
        
        while (sucesso != true) {
            if (abertos.isEmpty()) {
                sucesso = false;
                break;
            } else {
                NodeWithCost n = abertos.pop();
                n.node.isSolucao = true;
                System.out.println("Abrindo estado " + n.node.valor);
                visitados.put(n.node.valor, n.node);
                System.out.println("\n\n" + visitados + "\n\n");
                if (n.node.valor == destino.valor) {
                    sucesso = true;
                    estadoFinal = n;
                    break;
                } else {
                    for (Adjacencia adj : n.node.adjacencias.values()) {
                        Node prox = adj.getProx();
                        if (!visitados.containsKey(prox.valor)) {
                            System.out.println(n.node.valor + " >> " + prox.valor);
                            abertos.push(new NodeWithCost(n, prox, n.custoTotal + adj.getDist()));
                            todosAbertos.add(prox);
                        }
                    }
                }
            }

            numIteracoes++;
        }

        if (sucesso) {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
            imprimeSolucao(visitados, todosAbertos, estadoFinal);
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }

    public static void buscaEmLargura(Node origem, Node destino) {
        System.out.println("\n***Busca em largura***");
        LinkedList<NodeWithCost> abertos = new LinkedList<>();
        LinkedList<Node> todosAbertos = new LinkedList<>();
        LinkedHashMap<String, Node> visitados = new LinkedHashMap<>();

        abertos.add(new NodeWithCost(null, origem, 0));
        todosAbertos.add(origem);

        boolean sucesso = false;
        int numIteracoes = 0;
        NodeWithCost estadoFinal = null;

        while (sucesso != true) {
            if (abertos.isEmpty()) {
                sucesso = false;
                break;
            } else {
                NodeWithCost n = abertos.removeFirst();
                System.out.println("\nAbrindo estado " + n.node.valor);
                visitados.put(n.node.valor, n.node);
                if (n.node.valor == destino.valor) {
                    sucesso = true;
                    estadoFinal = n;
                    break;
                } else {
                    for (Adjacencia adj : n.node.adjacencias.values()) {
                        Node prox = adj.getProx();
                        if (!visitados.containsKey(prox.valor)) {
                            System.out.println(n.node.valor + " >> " + prox.valor);
                            abertos.add(new NodeWithCost(n, prox, n.custoTotal + adj.getDist()));
                            todosAbertos.add(prox);
                        }
                    }
                }
            }

            numIteracoes++;
        }

        if (sucesso) {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações.");
            imprimeSolucao(visitados, todosAbertos, estadoFinal);
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }

    public static void buscaOrdenada(Node origem, Node destino) {
        System.out.println("\n***Busca ordenada***");
        ArrayList<NodeWithCost> abertos = new ArrayList<NodeWithCost>();

        HashMap<String, Node> visitados = new HashMap<>();
        abertos.add(new NodeWithCost(null, origem, 0));

        boolean sucesso = false;
        int numIteracoes = 0;
        NodeWithCost estadoFinal = null;
        while (!sucesso) {
            if (abertos.isEmpty()) {
                sucesso = false;
                break;
            } else {
                NodeWithCost n = abertos.remove(0);
                visitados.put(n.node.valor, n.node);
                System.out.println("Abrindo o estado " + n.node.valor);

                if (n.node.valor == destino.valor) {
                    sucesso = true;
                    System.out.println("Custo Total " + n.custoTotal);
                    estadoFinal = n;
                    break;
                } else {
                    for (Adjacencia adj : n.node.adjacencias.values()) {
                        Node prox = adj.getProx();
                        if (!visitados.containsKey(prox.valor)) {
                            abertos.add(new NodeWithCost(n, prox, n.custoTotal + adj.getDist()));
                        } else {
                            int i;
                            for (i = 0; i < abertos.size(); i++) {
                                if (abertos.get(i).node.valor == prox.valor) {
                                    if (abertos.get(i).custoTotal > n.custoTotal + adj.getDist()) {
                                        abertos.get(i).custoTotal = n.custoTotal + adj.getDist();
                                        abertos.get(i).anterior = n;
                                    }

                                    break;
                                }
                            }
                        }
                    }

                    Collections.sort(abertos, new Comparator<NodeWithCost>() {
                        @Override
                        public int compare(NodeWithCost o1, NodeWithCost o2) {
                            return o1.custoTotal - o2.custoTotal;
                        }
                    });
                }
            }
            numIteracoes++;
        }

        if (sucesso) {
            System.out.println("Caminho:");
            StringBuilder sb = new StringBuilder();

            sb.append("]");
            while (estadoFinal != null) {
                sb.insert(0, estadoFinal.node.valor + " ");
                estadoFinal = estadoFinal.anterior;
            }
            sb.insert(0, "[");

            System.out.println(sb.toString());

            System.out.println("\nAlgoritmo achou o elemento com " + numIteracoes + " iterações.\n");
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }

    public static void backtracking(Node origem, Node destino) {
        System.out.println("\n***Backtracking***");
        HashMap<String, Node> visitados = new HashMap<>();
        Stack<Node> caminho = new Stack<>();
        int custo = 0;

        boolean sucesso = false;

        caminho.push(origem);
        visitados.put(origem.valor, origem);

        int numIteracoes = 0;
        while (!sucesso) {
            boolean inseriu = false;

            if (caminho.isEmpty()) {
                sucesso = false;
                break;
            } else {
                Node v = caminho.peek();
                System.out.println("\nAbrindo estado " + v.valor);
                if (v.valor == destino.valor) {
                    sucesso = true;
                    break;
                } else {
                    for (Adjacencia adj : v.adjacencias.values()) {
                        System.out.println(v.valor + " >> " + adj.getProx().valor);
                    }
                    for (Adjacencia adj : v.adjacencias.values()) {
                        Node prox = adj.getProx();
                        if (!visitados.containsKey(prox.valor)) {
                            inseriu = true;
                            caminho.push(prox);
                            visitados.put(prox.valor, prox);
                            custo = custo + adj.getDist();
                            break;
                        }
                    }
                }
            }
            numIteracoes++;

            if (!inseriu) {
                caminho.pop();
            }
        }

        if (sucesso) {
            System.out.println("Caminho:");
            for (Node node : caminho) {
                System.out.print("[" + node.valor + "] ");
            }
            System.out.println("\nAlgoritmo achou o elemento com " + numIteracoes + " iterações.\nCusto: " + custo);
        } else {
            System.out.println("Algoritmo achou o elemento com " + numIteracoes + " iterações");
        }
    }

    //computa o conjunto solução
    public static void imprimeSolucaoEmProfundidade(LinkedHashMap<String, Node> visitados) {
        StringBuilder sb = new StringBuilder();

        Node anterior = null;
        int custo = 0;
        for (Node v : visitados.values()) {
            if (v.isSolucao) {
                sb.append(" [" + v.valor + "]");

                if (anterior != null) {
                    if (anterior.adjacencias.get(v.valor) != null) {
                        custo += anterior.adjacencias.get(v.valor).getDist();
                    }
                }
                anterior = v;
            }
        }

        System.out.println("Conjunto solução: " + sb);
        System.out.println("Custo total: " + custo);
    }

    public static void imprimeSolucao(LinkedHashMap<String, Node> visitados, LinkedList<Node> abertos, NodeWithCost estadoFinal) {
        int custo = estadoFinal.custoTotal;
        System.out.println("\nNós abertos: ");
        for (Node aberto : abertos) {
            System.out.print("[" + aberto.valor + "] ");
        }
        System.out.println("\n\nNós visitados:");
        for (Node value : visitados.values()) {
            System.out.print("[" + value.valor + "] ");
        }
        System.out.println("\n\nSolução final:");
        while (estadoFinal != null) {
            System.out.print("[" + estadoFinal.node + "] ");
            estadoFinal = estadoFinal.anterior;
        }
        System.out.println("\n\nCusto final: " + custo);
    }

}
