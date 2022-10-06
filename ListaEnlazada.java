/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jav1listasimple;

import java.util.HashSet;

/**
 *
 * @author etensor
 */
public class ListaEnlazada {
    
    private Nodo cabeza;      // la lista se caracteriza principalmente por el nodo cabeza
    private Nodo ordenado;
    // public int num_nodos;

    public ListaEnlazada() {
        cabeza = null;
    }
    
    public void imprimir(Nodo nodo){
        System.out.print(" -> "+nodo.getDato());
    }
    
    public void imprimir(String str){
        System.out.println(str);
    }
    
    public void print_list(){
        Nodo actual = cabeza;
        
        while(actual.getNext() != null){             // hasta el último 
            imprimir(actual);
            actual = actual.getNext();
            //actual.next = actual.next.next;
            // actual = actual.next
        }
        imprimir(actual); //
        
        imprimir("");      
    }
    
    public void print_pos(int id){      // 0, el ultimo
        Nodo actual = cabeza;
        int conteo = 0;
        
        if (id < 0){ imprimir("-- Posición no válida.");
        
        }else{
            while(conteo < id && actual.getNext() != null){  // para llegar a la posicion o al último.
                actual.setNext(actual.getNext());                  // para recorrer los nodos.
                conteo++;
            }
            if (actual == null){
                imprimir("-- Posición no válida.");
            }
            else imprimir(" id: "+id+" -> " + actual.getDato());
        }        
    }
    
    public boolean existeNodo(int valor){ // EQUIVALENTE A busqueda SECUENCIAL
        Nodo actual = cabeza;
        
        while(actual.getDato() != valor && actual.getNext() != null){
            actual = actual.getNext();
        }
        if (actual.getDato() == valor && actual.getNext() == null){
            return true;
        }
        else if (actual.getNext() == null) return false;
        else return true;                     
    }
    
    public void editar_Nodo_id(int id, int dato){              
        Nodo actual = cabeza;
        int conteo = 0;
        
        if (id < 0){
            System.out.println(" -- Posición no válida.");
        }
        else{
            while (conteo < id && actual.getNext() != null){
                actual = actual.getNext();
                conteo++;
            }
            if (actual.getNext() == null && conteo == id){          // si es el ultimo.
                actual.setDato(dato);
                imprimir(" -] Nodo ["+id+"] | actualizado: "+dato);
            }
            else if (actual.getNext() == null){
                imprimir(" -- Posición no válida.");
            }
            else{
                actual.setDato(dato);
                imprimir(" -] Nodo ["+id+"] | actualizado: "+dato);
            }
        }            
    }
    
    public void editar_Nodo_dato(int dato, int valor){          
        if (existeNodo(dato)) {
            Nodo actual = cabeza;
 
            while(actual.getDato() != dato){
                actual = actual.getNext();
            }
            actual.setDato(valor);
            imprimir(" -] Nodo {"+dato+"} modificado por {"+valor+"}." );
        }
        else imprimir(" -- No se pudo editar.");
    }            
    
    public boolean add_last(int dato){
        Nodo nuevo = new Nodo(dato); /// last sera el nuevo último
        Nodo actual = cabeza;
        
        if (cabeza == null){
            cabeza = nuevo;
            imprimir(" -] Primer nodo de la lista agregado: "+ dato);
            return true;     
            
        }else{
            
            while(actual.getNext() != null){
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
            imprimir(" -] Nodo agregado a lo último: "+ dato );
            return true;
        }
    }
    
    public void add_cabeza(int dato){            
        Nodo nuevo_nodo = new Nodo(dato);        /// L := -> {}
        nuevo_nodo.setNext(cabeza);              /// 1+ : X -> {}
        cabeza = nuevo_nodo;                     /// L -> X == {} -> X
        imprimir(" -] Nodo agregado como cabeza: "+ dato); 
    }                                            /// ==> L -> X -> {}
    
    public boolean add_index(int dato, int id){    // el anterior tiene apuntar al nuevo
        Nodo nuevo = new Nodo(dato);               // el nuevo al actual (id)
        Nodo actual = cabeza;
        int conteo;
        
        if (id < 0) return false;
        
        if (id == 0){
            add_cabeza(dato);
            imprimir(" -] Nodo agregado en la posición: "+ id + "{"+dato+"}");
            return true;
        }
        else{
            conteo = 0;
            
            while(conteo < id-1 && actual.getNext() != null){
                actual = actual.getNext();
                conteo++;
            }    
           
            nuevo.setNext(actual.getNext());
            actual.setNext(nuevo);
            
            imprimir(" -] Nodo agregado en la posición: "+ id + "{"+dato+"}");
            return true;
        }
        
    }
    
      
    public boolean delete_frente(){
       if (cabeza != null){                     // si la lista no esta vacia...'
           Nodo temp = cabeza;
        cabeza = cabeza.getNext();     
        imprimir(" -] Nodo del frente eliminado.");
        temp.setNext(null);
        return true;
       }
       else imprimir(" -- La lista ya esta vacía."); return false;      
    }
    
    public boolean delete_final(){
        Nodo actual = cabeza;
        
        if (cabeza != null){    // si esta vacia o si tiene solo un elemento
            if (cabeza.getNext() == null){cabeza = null; imprimir(" -] Nodo final eliminado."); return true;} 
            else{
                while(actual.getNext() != null){            /// L (2) : {X,Y,0}
                    actual = actual.getNext();              /// x->y->0
                }                                           /// x-> 0
                actual.setNext(null);
                System.out.println(" -] Nodo final eliminado.");
                return true;
            }
            
        }else System.out.println(" -- La lista ya esta vacía."); return false;
    }
    
    public void eliminarElementoPorDato(int dato) {
        //busca entre a lista si el dato existe
        if(existeNodo(dato)){
          //verifica si el dato es el primero
          if(cabeza.getDato()==dato){
            cabeza.setNext(cabeza.getNext());//el primer nodo apunta al siguiente
          }else{
            Nodo actual=cabeza;
            //recorre la lista hasta llegar al nodo anterior al dato registrado
            while(actual.getNext().getDato() != dato){
              actual = actual.getNext();
            }   
            Nodo next = actual.getNext().getNext(); //guarda el nodo siguiente del nodo a eliminar
            actual.setNext(next); //enlaza el nodo anterior a la lista
          }
           imprimir(" -] Elemento {"+dato+"} eliminado.");
        }
        else imprimir(" -- Elemento no encontrado.");
    }
    
    public boolean delete_pos(int id){
        Nodo actual = cabeza;
        int conteo;
        
        if (id == 0) this.cabeza = actual.getNext();
        
        if (id < 0){
            imprimir(" -- La posición no válida.");
            return false;
        }
        else{
            conteo = 0;
            while(conteo<id-1 && actual.getNext() != null){
                actual.setNext(actual.getNext());
                conteo++;
            }
            if (actual.getNext() != null){
                actual.setNext(actual.getNext().getNext());
                imprimir(" -] Nodo en la posición "+id+" eliminado.");
                return true;
            }
            else imprimir(" -- Posición no válida."); return false;              
        }
    }
    
    public int sumatoria() {
        int totalSuma = 0;     
        Nodo aux = cabeza;
        if (aux == null) return 0;
        else if (aux.getNext() == null) return aux.getDato();
        while(aux!=null){
          totalSuma += aux.getDato();
          aux = aux.getNext();
        }
        return totalSuma;
    }
    
    public long multiplicatoria(){
        int totalmul = 1;     
        Nodo aux = cabeza;
        if (aux == null) return 0;
        while(aux.getNext()!=null){
            if (aux.getDato() != 0){
            totalmul *= aux.getDato();   
            }
            aux = aux.getNext();
        }
        totalmul *= aux.getDato(); // ultimo
        return totalmul;     
    }
    
    public int encontrarMayor() {
        int mayor=0;
        Nodo aux = cabeza ;
        
        if (aux == null) return 0;
        
        while(aux.getNext()!=null){
          if(aux.getDato()> mayor){
            mayor = aux.getDato();
          }
          aux = aux.getNext();
        }
        return mayor;
    }

    public int encontrarMenor(){   
        Nodo aux = cabeza;   
        if (aux == null) return 0;
        
        int menor = cabeza.getNext().getDato();

        while(aux.getNext() != null){
          if(aux.getDato() < menor){
            menor = aux.getDato();
          }
          aux = aux.getNext();
         }
      return menor;   
    }
    
    public int encontrarMinimo(Nodo ref){
        Nodo aux = ref;
        if (aux == null) return 0;
        
        int menor = ref.getNext().getDato();
        
        while(aux.getNext() != null){
            if (aux.getDato() < menor){
                menor = aux.getDato();
            }
            aux = aux.getNext();
        }
     return menor;
    }
    
    public double promedio(){
        int conteo = 1;
        int suma = sumatoria();
        
        Nodo actual = cabeza;
        
        if (actual == null) return 0;
        else if (actual.getNext() == null) return actual.getDato();
        
        while (actual.getNext() != null){
            actual = actual.getNext();
            conteo++;
        }
        return (double) suma/conteo;
               
    }
    
    public int get_longitud(){
        Nodo actual = cabeza;
        int num_elems = 0;
        
        if (actual == null) return 0;
        
        while(actual.getNext() != null){    
           actual = actual.getNext();
           num_elems++;
        } 
    
      return num_elems;     
    }
    
    public void insertion_sort(){               ////
        ordenado = null;
        Nodo actual = cabeza;
        
        while(actual != null){
          Nodo next = actual.getNext();
          insertar_ord(actual);
          actual = next;            
        }
        
      cabeza = ordenado;
      ordenado = null;
    }
    
    public void insertar_ord(Nodo nuevo){      // -<<<
        if (ordenado == null || ordenado.getDato() >= nuevo.getDato() ){
          nuevo.setNext(ordenado);
          ordenado = nuevo;
        }else{
          Nodo actual = ordenado;
          
          while(actual.getNext() != null && actual.getNext().getDato() < nuevo.getDato()){
              actual = actual.getNext();
          }
          nuevo.setNext(actual.getNext());
          actual.setNext(nuevo);
        }
    }
    
    public void burbuja_beyota(){  /////
        Nodo actual = cabeza;
        Nodo siguiente;
        int valor = 0;
        boolean posible_cambio = true;
        
        if (cabeza == null) return;
        
        while(posible_cambio){
            posible_cambio = false;
            actual = cabeza;
            siguiente = actual.getNext();  
            while(!posible_cambio && actual.getNext() != null){
                if (actual.getDato() > siguiente.getDato()){
                  valor = actual.getDato();
                  actual.setDato(siguiente.getDato());
                  siguiente.setDato(valor);
                  posible_cambio = true;
                }
               actual = actual.getNext();
               siguiente = siguiente.getNext();        
            } 
        }      
    }
    
    /// busqueda binaria
    
    private Nodo enc_mitad(Nodo principio,Nodo last){
        if (principio == null) return null;
        
      Nodo actual = principio;
      Nodo auxiliar = principio.getNext();
      
      while (auxiliar != last){
          auxiliar = auxiliar.getNext();
          
          if (auxiliar != last){
              actual = actual.getNext();
              auxiliar = auxiliar.getNext();
          }
      }
     return actual;
    }
    
    public Nodo busqueda_binaria(int valor){
        Nodo izq = cabeza;
        Nodo der = null;
        
        do{
            Nodo mitad = enc_mitad(izq,der);
            
            if (mitad == null){imprimir("Valor NO encontrado."); return izq;}
            
            if (mitad.getDato() == valor){
                imprimir("Valor encontrado : [" + mitad.getDato()+ "] | ");return mitad;
            }
            else if (mitad.getDato() < valor){
                izq = mitad.getNext();
            }
            else der = mitad;
            
        }while(der == null || der != izq);   
        
        return null;         
    }
    
    
                                // SELECTION SORT
    public Nodo getHead(){ return cabeza;};
    
    public Nodo selection_sort(Nodo head){
       Nodo principio = head;
       if (principio.getNext() == null) return null;
       
       Nodo min = principio;
       Nodo previoMin = null;
       Nodo ptr;
       
       for (ptr = principio; ptr.getNext() != null; ptr = ptr.getNext()){
           if (ptr.getNext().getDato() < min.getDato()){
               min = ptr.getNext();
               previoMin = ptr;
           }
       }
       
       if (min != principio){
           intercambiar(principio,principio,min,previoMin);
       }
       
       principio.setNext(principio.getNext());    
    
      return principio;
    }
    
    public void intercambiar(Nodo primero,Nodo izq,Nodo der, Nodo prev){    
        primero = der;
        prev.setNext(izq);
        
        Nodo temp = der.getNext();
        der.setNext(izq.getNext());
        izq.setNext(temp);
        
        ////// [X]* , [Y]~
        //// =>[X]~ , [Y]*       
    }
    
                                        //// Shell Sort
    
    public void shell_sort(){           /// dañado.
        int dim = get_longitud();
        Nodo aux = cabeza;
        Nodo aux2 = aux;
        Nodo aux3 = aux;
        int temp = 0;
        
        for (int ds = dim/2; ds > 0; ds /= 2){
            for(int i = ds; i < dim; i++){
                int w = 0,k = 0;
                while (k < i){aux = aux.getNext(); k++;};
                while (w < i - ds){aux2.getNext(); w++;};
                
                temp = aux.getDato();
                int j;
                
                for (j = i; j >= ds && aux2.getDato() > temp; j -= ds){
                    int n = 0;
                    while (n < j){aux3 = aux3.getNext();};       
                    aux3 = aux2;
                }                     
            }
        }
        aux3.setDato(temp);
    }

          
}
