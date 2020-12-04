/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2IA;

import java.util.Scanner;

/**
 *
 * @author Alessandro
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int estadoInicial[][] = {{7, 2, 4}, 
                                 {5, 0, 6}, 
                                 {8, 3, 1}}; 
        Estado est = new Estado(estadoInicial);
        No noInicial = new No(est, 0, -1);
        BuscaProfundidade buscaProf = new BuscaProfundidade();
        BuscaLargura buscaLargura = new BuscaLargura();
        Aestrela buscaAestrela = new Aestrela();
        BuscaGulosa buscaGulosa = new BuscaGulosa();

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número da busca: ");
        System.out.println("1 - Busca em Profundidade \n2 - Busca em Largura \n3 - A* Estrela \n4 - Busca Gulosa");
        int escolherMetodo = scan.nextInt();
    
        boolean finalizou = false;

        if (escolherMetodo == 1) {
            finalizou = buscaProf.Busca(noInicial);
            System.out.print("\n Busca em Profundidade");
        }else if (escolherMetodo == 2) {
            finalizou = buscaLargura.Busca(noInicial);
            System.out.print("\n Busca em Largura");
        }else if (escolherMetodo==3){
            finalizou = buscaAestrela.Busca(noInicial);
            System.out.println("\n A* Estrela\n");
            System.out.println(" Heuristicas Distância de Manhattan: "+noInicial.FuncaoHeuristicaDistManhattan());    
            
        }else if(escolherMetodo==4){
            finalizou = buscaGulosa.Busca(noInicial);
            System.out.println("\n Busca Gulosa");
            System.out.println(" Heuristicas Peças: "+noInicial.FuncaoHeuristicaPecas());
        }else {
            System.out.println("Metodo não encontrado!");
        }
        
        if (finalizou) {
            System.out.println("\n Busca resolvida com sucesso \n");
        }else{
            System.out.println("\n Busca não resolvida \n");
        }

 
    }
    
}
