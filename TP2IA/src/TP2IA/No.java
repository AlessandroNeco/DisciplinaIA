/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2IA;

import java.util.ArrayList;

/**
 *
 * @author Alessandro
 */

//implementei o Comparable, para criar uma forma de fazer comparações
//para saber quais números estão fora da ordem e cerificar a distância de cada um
public class No implements Comparable<No>{

    private Estado estado;
    private int profundidade;
    private int pai;
    private int heuristica;
    private int funcaoAvaliacao;
    
    //construtor invocando 
    public No(Estado estado, int profundidade, int pai) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        FuncaoHeuristicaPecas();
        FuncaoHeuristicaDistManhattan();
        this.funcaoAvaliacao = this.profundidade+this.heuristica;
    }

    public No() {
    }
    //usado para fazer busca em largura e profundidade
    /*public No(Estado estado, int profundidade, int pai, int heuristica) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        this.heuristica = heuristica;
        this.funcaoAvaliacao = profundidade+heuristica;
    }*/
    
    
    public ArrayList<No> GeraSucessores(int indexPai) {
        ArrayList<No> sucessores = new ArrayList<>();
    
        Estado direita;
        Estado esquerda;
        Estado cima;
        Estado baixo;

        
        direita = this.estado.GeraSucessor('d'); 
        if (direita != null) {
            No noSucessor1 = new No(direita, this.profundidade+1, indexPai);
            sucessores.add(noSucessor1);
            //direita.ImprimirEstado();
        }

        
        esquerda = this.estado.GeraSucessor('e');
        if (esquerda != null) {
            No noSucessor2 = new No(esquerda, this.profundidade+1, indexPai);
            sucessores.add(noSucessor2);
            //esquerda.ImprimirEstado();
        }

       
        cima = this.estado.GeraSucessor('c');
        if (cima != null) {
            No noSucessor3 = new No(cima, this.profundidade+1, indexPai);
            sucessores.add(noSucessor3);
            //cima.ImprimirEstado();
        }

        
        baixo = this.estado.GeraSucessor('b');
        if (baixo != null) {
            No noSucessor4 = new No(baixo, this.profundidade+1, indexPai);
            sucessores.add(noSucessor4);
            //baixo.ImprimirEstado();
        }
        
        return sucessores;
    }
    //é utilizada para encontrar uma solução mais eficiente do que a busca sem informação
    //esta função é utilizada para verificar e contar quantas peças estão fora do lugar
    public int FuncaoHeuristicaPecas(){
        heuristica = 0;
        int matrizObjetivo[][] = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};
        for(int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (matrizObjetivo[i][j] != this.estado.getMatriz()[i][j]) {
                    heuristica++;
                }
            }
            
        }
        return heuristica;
    }
    //está já é utilizada para calcular a distância de cada peça fora do lugar de objetivo
    public int FuncaoHeuristicaDistManhattan(){
        heuristica = 0;
 
        int matrizObjetivo[][] = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};
        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++) {
                if (matrizObjetivo[i][j] != this.estado.getMatriz()[i][j]) {
                    for(int k=0; k < 3; k++){
                        for (int l=0; l < 3; l++) {
                            if (this.estado.getMatriz()[i][j] == matrizObjetivo[k][l]){
                                heuristica += Math.abs(i - k) + Math.abs(j - l);
                                break;
                            }
                        }
                    }
                }
            }
        }
    return heuristica;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public int getFuncaoAvaliacao() {
        return funcaoAvaliacao;
    }

    public void setFuncaoAvaliacao(int funcaoAvaliacao) {
        this.funcaoAvaliacao = funcaoAvaliacao;
    }
    
    //utilizada para decidir qual é maior, menor ou se ficar na mesma posição de acordo com a profundidade 
    //executada durante o puzze
    @Override
    public int compareTo(No no) {
        if (this.funcaoAvaliacao> no.funcaoAvaliacao) {
            return 1;
        }else if(this.funcaoAvaliacao< no.funcaoAvaliacao){
            return -1;
        }else{
            return 0;
        }
    }

}
