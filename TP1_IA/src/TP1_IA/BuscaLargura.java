/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1_IA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alessandro
 */
public class BuscaLargura {
    
    private Queue<No> fronteira = new LinkedList<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();

    public BuscaLargura() {

    }

    public boolean Busca(No noInicial) {

        //inserir no inicial na fronteira
        fronteira.add(noInicial);

        No buscaNo;
        //enquanto a fronteira NÃO estiver vazia, ele irá percorrendo
        while (!fronteira.isEmpty()) {

            //remove o NO da fronteira
            buscaNo = fronteira.poll();
            
            //o NO removido passa a fazer parte de outra lista contendo apenas os excluídos
            removidosFronteira.add(buscaNo);
            
            //testa se o NO removido, se é o objetivo a ser alcançado, depois é saído do loop
            if (buscaNo.getEstado().Objetivo(buscaNo.getEstado().getMatriz())) {
                    System.out.println("\nEncontrado: \n");
                    ImprimeCaminho(buscaNo);
                    return true;
            }
            
            //Cria um ArrayList que recebe os nós removidos da fronteira 
            //e o atributo pai dos sucessores que forem gerados desse NO que foi removido, sera o indice desse NO em ArrayList      
            //Gera os sucessores e depois insere na fronteira
            fronteira.addAll(buscaNo.GeraSucessores(removidosFronteira.size() - 1));
        }
        return false;
    }
    
    public void ImprimeCaminho(No noImprimir){ 
        
        if (noImprimir.getPai()==-1) {
            System.out.println("Pai: " + noImprimir.getPai());
            noImprimir.getEstado().ImprimirEstado();
            return;
            
        }else{
            ImprimeCaminho(removidosFronteira.get(noImprimir.getPai()));
        }
        System.out.println("Pai: " + noImprimir.getPai());
            noImprimir.getEstado().ImprimirEstado();
    }

    public Queue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Queue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
