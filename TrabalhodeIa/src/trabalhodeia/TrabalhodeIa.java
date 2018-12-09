/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhodeia;

import ClassesEstruturas.Grafo;
import ClassesEstruturas.LeituraArquivo;
import PacoteAlgoritmos.EstruturaAlgoritmos;
import java.util.Scanner;

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
              
        int opcao;
        boolean erro = true;//determina quando finalizar o loop
        Scanner sc = new Scanner(System.in);
        do {
          try {
            System.out.println("O que deseja fazer?");
            System.out.println("( 1 ) - buscaEmProfundidade");
            System.out.println("( 2 ) - backtracking");
            System.out.println("( 3 ) - buscaOrdenada");
            System.out.println("( 4 ) - buscaEmLargura");
            System.out.println("( 5 ) - Listar Funcionários");
            System.out.println("( 6 ) - Listar Funcionários");
            System.out.println("( 7 ) - Listar Funcionários");
            System.out.println("( 0 ) - Sair do Programa a qualquer momento");
            System.out.printf("Digite uma opcão: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println("A opçao escolhida foi: "+ opcao);
            if(opcao == 0) {
              System.out.println("\nO programa será finalizado");
              erro = false;
            }//fim do if
            if(opcao == 1){
                EstruturaAlgoritmos.buscaEmProfundidade(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 2){
                EstruturaAlgoritmos.backtracking(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 3){
                EstruturaAlgoritmos.buscaOrdenada(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 4){
                EstruturaAlgoritmos.buscaEmLargura(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 5){
                //EstruturaAlgoritmos.buscaEmLargura(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 6){
                //EstruturaAlgoritmos.buscaEmLargura(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao == 7){
                //EstruturaAlgoritmos.buscaEmLargura(g.nodes.get(0), g.nodes.get(1));
            }
            if(opcao < 8 && opcao < 0) {
              System.out.println("A função ainda não está implementada\n");
              erro = false;
            }//fim do if  
            if(opcao > 4) {
              System.out.println("Escolha um número entre 0 e 7\n");
            }//fim do if
          }//fim do try
        catch(NumberFormatException e) {
        System.out.println("Escolha um número entre 0 e 7\n");
        opcao = 0;
        }//fim do catch
        } while (erro);//fim do...while
        System.out.println("Escolha um número entre 0 e 7\n");
      }//fim do método
}
    
