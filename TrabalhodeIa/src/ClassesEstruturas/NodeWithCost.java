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
    public Node node;
    public int custoTotal;
    public int valorHeuristico;

    public NodeWithCost(Node n, int custo)
    {
        this.node = n;
        this.custoTotal = custo;
    }
    
    public NodeWithCost(Node n, int custo, int valorHeuristico)
    {
        this.node = n;
        this.custoTotal = custo;
        this.valorHeuristico = valorHeuristico;
    }
}
