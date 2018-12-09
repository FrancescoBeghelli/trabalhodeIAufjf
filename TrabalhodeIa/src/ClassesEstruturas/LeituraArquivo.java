/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEstruturas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramonlarivoir
 */
public class LeituraArquivo {

    public Grafo lerArquivo() {
        Grafo g = new Grafo();
        List<Node> list = new ArrayList<>();
        try {
            File file = new File("/home/ramonlarivoir/Área de Trabalho/Ramon/Materiais UFJF/Inteligência Artificial/Trabalho/Projeto/trabalhodeIAufjf/TrabalhodeIa/src/ClassesEstruturas/grafo.txt");
            FileInputStream in = new FileInputStream(file);
            Scanner scanner = new Scanner(in);
            String qtd = scanner.nextLine();
            for(int i = 0; i < Integer.valueOf(qtd); i++) {
                Node node = new Node();
                node.valor = scanner.next();
                node.heuristica = Integer.valueOf(scanner.next());
                System.out.println("Nó: " + i + " - Valor: " + node.valor + " - Heurística: " + node.heuristica);
                list.add(node);
            }
            
            while(scanner.hasNext()) {
                int origem = Integer.valueOf(scanner.next());
                int destino = Integer.valueOf(scanner.next());
                int dist = Integer.valueOf(scanner.next());
                
                list.get(origem).addCaminho(list.get(destino), dist);
            }
            g.nodes = list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeituraArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
}
