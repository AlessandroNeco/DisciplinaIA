/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1_IA;

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
        
        int estadoInicial[][] = {{1, 2, 5}, 
                                 {4, 0, 3}, 
                                 {7, 8, 6}}; //{{1,2,3},{4,5,0},{7,8,6}};
        Estado est = new Estado(estadoInicial);
        No noInicial = new No(est, 0, -1);
        BuscaProfundidade buscaProf = new BuscaProfundidade();
        BuscaLargura buscaLargura = new BuscaLargura();

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número da busca: ");
        System.out.println("1 - Busca em Profundidade \n2 - Busca em Largura");
        int escolherMetodo = scan.nextInt();
    
        boolean finalizou = false;

        if (escolherMetodo == 1) {
            finalizou = buscaProf.Busca(noInicial);
            System.out.print("\n Busca em Profundidade");
        }else if (escolherMetodo == 2) {
            finalizou = buscaLargura.Busca(noInicial);
            System.out.print("\n Busca em Largura");
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
