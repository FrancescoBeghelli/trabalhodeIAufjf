/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodeia;

import ClassesEstruturas.Grafo;
import ClassesEstruturas.LeituraArquivo;
import PacoteAlgoritmos.EstruturaAlgoritmos;

/**
 * @author Ramon
 * @author Francesco
 */
public class TrabalhodeIa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LeituraArquivo la = new LeituraArquivo();
        Grafo g = new Grafo();
        g = la.lerArquivo();
        
        EstruturaAlgoritmos.buscaEmProfundidade(g.nodes.get(0), g.nodes.get(2));
        EstruturaAlgoritmos.backtracking(g.nodes.get(0), g.nodes.get(8));
        EstruturaAlgoritmos.buscaOrdenada(g.nodes.get(0), g.nodes.get(6));
        EstruturaAlgoritmos.buscaEmLargura(g.nodes.get(7), g.nodes.get(1));
    }
    
}
