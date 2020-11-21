/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1_IA;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Alessandro
 */
public class BuscaProfundidade {

    private Stack<No> fronteira = new Stack<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    private final int limite = 50;

    public BuscaProfundidade() {

    }

    public boolean Busca(No noInicio) {

        fronteira.push(noInicio);
       
        No buscaNo;
        
        while (!fronteira.isEmpty()) {
         
            //removendo o NO da fronteira
            buscaNo = fronteira.pop();
           
            removidosFronteira.add(buscaNo);
          
            //Testa se o NO removido é o objetivo, depois disso fecha e sai do loop
            if (buscaNo.getEstado().Objetivo(buscaNo.getEstado().getMatriz())) {
                    System.out.println("\nEncontrado: \n");
                    ImprimeCaminho(buscaNo);
                    return true;
                }
            //cria um ArrayList que recebe os nós removidos da fronteira 
            //e o atributo pai dos sucessores que forem gerados desse NO que foi removido, sera o indice desse NO no ArrayList
            
            if (buscaNo.getProfundidade() < limite) {
                
                //gera sucessores e depois insere na fronteira
                fronteira.addAll(buscaNo.GeraSucessores(removidosFronteira.size() - 1));
                
            }

        }
        return false;
    }
    
    public void ImprimeCaminho(No noImprimir){ 
        
       /* if (no.getPai()==-1) {

        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
            return;
            
        }else{
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
        }*/
        
        if (noImprimir.getPai()!=-1){
            ImprimeCaminho(removidosFronteira.get(noImprimir.getPai()));
        }
        System.out.println("Pai: " + noImprimir.getPai());
            noImprimir.getEstado().ImprimirEstado();
        /*
        No noAux = removidosFronteira.get(no.getPai());;
                    
        System.out.println("#########################################\n"
                + "++++++++++++++++Caminho+++++++++++++++++\n"
                + "#########################################");
        System.out.println("Pai: " + no.getPai());
        no.getEstado().ImprimirEstado();
         
        while (noAux.getPai()>-1) {
            System.out.println("Pai: " + noAux.getPai());
            
            noAux.getEstado().ImprimirEstado();
            noAux = removidosFronteira.get(noAux.getPai());
        }
        System.out.println("Pai: " + noAux.getPai());
            
            noAux.getEstado().ImprimirEstado();*/
    }

    public Stack<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Stack<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
