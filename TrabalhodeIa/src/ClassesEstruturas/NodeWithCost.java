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
public class NodeWithCost
{
    public NodeWithCost anterior;
    public Node node;
    public int custoTotal;
    public int valorHeuristico;

    public NodeWithCost(NodeWithCost anterior, Node n, int custo)
    {
        this.node = n;
        this.custoTotal = custo;
        this.anterior = anterior;
    }
    
    public NodeWithCost(NodeWithCost anterior, Node n, int custo, int valorHeuristico)
    {
        this.node = n;
        this.custoTotal = custo;
        this.valorHeuristico = valorHeuristico;
        this.anterior = anterior;
    }
}
