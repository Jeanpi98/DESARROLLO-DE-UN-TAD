/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jav1listasimple;

/**
 *
 * @author etensor
 */

public class Nodo{
    
    private int dato;
    private Nodo next;
    
    public int getDato(){
       return this.dato;
    }
    
    public Nodo(int valor){
        next = null;
        dato = valor;
    }
    
    public Nodo(int valor, Nodo next_valor){
        next = next_valor;
        dato = valor;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
 

    public void setNext(Nodo next) {            /// si next fuera privado,
        this.next = next;                       // seria la manera correcta.
    }
    
    public Nodo getNext(){
         return next;
    }
    
    
}
