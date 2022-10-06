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
public class Main {
    
    public static void main(String[] args) {
        System.out.println("hello world");
        
        ListaEnlazada lista_enlazada = new ListaEnlazada();
        
          lista_enlazada.delete_frente();
        
        
        lista_enlazada.add_last(1);
        
        for (int i = 0; i < 20; i++){
            lista_enlazada.add_last(i+50);
        }
        lista_enlazada.print_list();
        lista_enlazada.delete_final();
        lista_enlazada.delete_final();
        
        lista_enlazada.add_cabeza(7);
        lista_enlazada.print_list();
       
        lista_enlazada.add_last(9);
        lista_enlazada.add_last(8);
        lista_enlazada.add_last(66);
        lista_enlazada.print_list();
        
        lista_enlazada.add_cabeza(2);
        lista_enlazada.print_list();
        
        lista_enlazada.add_last(1);
        lista_enlazada.print_list();
        
        lista_enlazada.add_index(8,2);
        lista_enlazada.print_list();
        
        lista_enlazada.add_index(8,3);
        lista_enlazada.print_list();

        int[] nums = {2,8,1,8};
        
        for (int i = 0; i < nums.length; i++){
            lista_enlazada.add_last(nums[i]);
            lista_enlazada.print_list();
        }
        
                                         lista_enlazada.delete_pos(0);
        
                                         lista_enlazada.delete_pos(4);
        lista_enlazada.print_list();
        
        System.out.println("Sumatoria datos de nodos: "+lista_enlazada.sumatoria());
        System.out.println("Multiplicatoria datos de nodos: "+lista_enlazada.multiplicatoria());
        
        lista_enlazada.print_list();
        
        lista_enlazada.delete_pos(3);
        lista_enlazada.print_list();
        
        lista_enlazada.add_index(2,0);
        lista_enlazada.print_list();
        
        lista_enlazada.add_cabeza(4);
        lista_enlazada.add_index(1,0);
        lista_enlazada.add_cabeza(3);
        
        lista_enlazada.print_list();
        
        lista_enlazada.delete_final();
        lista_enlazada.delete_final();
        
        lista_enlazada.print_list();

        for (int i = 0; i < 5; i++){
            lista_enlazada.print_pos(i);
        }
        
        lista_enlazada.delete_frente();
        lista_enlazada.delete_frente();
        
        lista_enlazada.print_list();
        
        //lista_enlazada.delete_final();
        lista_enlazada.editar_Nodo_id(5,2);
        lista_enlazada.print_list();
        
        lista_enlazada.editar_Nodo_id(1,33);
        lista_enlazada.editar_Nodo_id(0,-7);
        lista_enlazada.editar_Nodo_id(6, 0);
        lista_enlazada.editar_Nodo_id(5, 1);
        
        lista_enlazada.print_list();
        
        int maximo = lista_enlazada.encontrarMayor();
        int minimo = lista_enlazada.encontrarMenor();
        
        System.out.println("\nMinimo: "+minimo+" | Maximo: "+ maximo);
        
        System.out.println("\n\n Promedio de lista: "+ lista_enlazada.promedio());
        
        lista_enlazada.eliminarElementoPorDato(7);
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(1);
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(-7);
        lista_enlazada.print_list();
        
        lista_enlazada.print_pos(0);
        lista_enlazada.print_pos(3);
        
        System.out.println(lista_enlazada.existeNodo(1));
        System.out.println(lista_enlazada.existeNodo(7));
        
        lista_enlazada.add_index(-5,3);
        lista_enlazada.print_list();
        
        lista_enlazada.add_index(-8,2);
        lista_enlazada.print_list();
        
        lista_enlazada.editar_Nodo_dato(1,-55);
        lista_enlazada.editar_Nodo_dato(-5,77);
        
        lista_enlazada.print_list();
          
        lista_enlazada.delete_pos(0);
        lista_enlazada.delete_pos(3);           
       
        lista_enlazada.print_list();
        
        for (int i = 0; i < 5; i++){
            lista_enlazada.add_last(i);
        }
        
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(33);
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(4);
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(-55);
        lista_enlazada.print_list();
        
        lista_enlazada.eliminarElementoPorDato(-8);
        lista_enlazada.print_list();
        
        lista_enlazada.imprimir("HOLA\n\n\nksdhfjshfjk");
       
        
        maximo = lista_enlazada.encontrarMayor();
        
        System.out.println("AAAAA");
        
        minimo = lista_enlazada.encontrarMenor();
        System.out.println("BBBBB\\n\n\n\n\n__A_@!$u129412");
        
        System.out.println("\nMinimo: "+minimo+" | Maximo: "+ maximo);
        System.out.println("Sumatoria datos de nodos: "+lista_enlazada.sumatoria());
       
        System.out.println("Multiplicatoria datos de nodos: "+lista_enlazada.multiplicatoria());
  
        System.out.println("\n\n Promedio de lista: "+ lista_enlazada.promedio());
        
        //lista_enlazada.insertion_sort();
        lista_enlazada.burbuja_beyota();
        lista_enlazada.print_list();
        Nodo busqueda = lista_enlazada.busqueda_binaria(33);
        busqueda = lista_enlazada.busqueda_binaria(54);
        //lista_enlazada.imprimir(busqueda);
        busqueda = lista_enlazada.busqueda_binaria(77);
        busqueda = lista_enlazada.busqueda_binaria(69);
        busqueda = lista_enlazada.busqueda_binaria(9);
        busqueda = lista_enlazada.busqueda_binaria(1231);
        
        lista_enlazada.imprimir("\n\n\n");
        int k = 100;
        
        while(k < 130){
            busqueda = lista_enlazada.busqueda_binaria(k);
            k++;
        }
        
        lista_enlazada.selection_sort(lista_enlazada.getHead());
       lista_enlazada.print_list();
        
        //lista_enlazada.shell_sort();
        //lista_enlazada.print_list();
         
    }
}
