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
public class No{

    private Estado estado;
    private int profundidade;
    private int pai;

    public No(Estado estado, int profundidade, int pai) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        
    }

    public No() {
    }

    
    //public ArrayList<No> GeraSucessores(No no, int indexPai) {
    public ArrayList<No> GeraSucessores(int indicePai) {
        ArrayList<No> sucessores = new ArrayList<>();
    
        Estado direita;
        Estado esquerda;
        Estado cima;
        Estado baixo;

        
        direita = this.estado.GeraSucessor('d'); 
        if (direita != null) {
            No noSucessor1 = new No(direita, this.profundidade+1, indicePai);
            sucessores.add(noSucessor1);
            //direita.ImprimirEstado();
        }

        
        esquerda = this.estado.GeraSucessor('e');
        if (esquerda != null) {
            No noSucessor2 = new No(esquerda, this.profundidade+1, indicePai);
            sucessores.add(noSucessor2);
            //esquerda.ImprimirEstado();
        }

       
        cima = this.estado.GeraSucessor('c');
        if (cima != null) {
            No noSucessor3 = new No(cima, this.profundidade+1, indicePai);
            sucessores.add(noSucessor3);
            //cima.ImprimirEstado();
        }

        
        baixo = this.estado.GeraSucessor('b');
        if (baixo != null) {
            No noSucessor4 = new No(baixo, this.profundidade+1, indicePai);
            sucessores.add(noSucessor4);
            //baixo.ImprimirEstado();
        }
        
        return sucessores;
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

}
