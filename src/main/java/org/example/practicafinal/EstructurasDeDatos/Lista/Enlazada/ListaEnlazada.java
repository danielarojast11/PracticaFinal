package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

import org.example.practicafinal.Entity.Individuo;

public class ListaEnlazada<TipoDato> {
    private ElementoLE<TipoDato> primero;

    public ListaEnlazada(ElementoLE<TipoDato> primero){
        this.primero = primero;
    }

    public ListaEnlazada()
    { }

    public int getNumeroElementos(){
        int contador = 0;
        if (!isVacia()) {   //La lista no debe estar vacia
            contador = 1;
            ElementoLE<TipoDato> auxiliar = primero;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }
        }
        return contador;
    }

    public boolean isVacia(){   //Si la primera posicion es null, es que la lista esta vacia
        return primero == null;
    }

    public void vaciar(){
        ElementoLE<TipoDato> auxiliar;    //Creamos un auxiliar
        while (primero.getSiguiente()!=null){   //sabremos que hemos llegado al final de la lista y no hay mas elementos
            auxiliar = primero;
            primero = primero.getSiguiente();
            auxiliar.setData(null); // vamos recorriendo la lista y eliminando sus elementos
        }
        primero = null;
    }

    private void add(ElementoLE<TipoDato> s){
        if (primero==null){
            primero = s;
        } else {
            s.insertarmeEn(primero);
            primero = s;
        }
    }

    public void add(TipoDato o){
        ElementoLE<TipoDato> elementoLE = new ElementoLE<>(o);
        elementoLE.setSiguiente(null);
        add(elementoLE);
    }

    public void insert(ElementoLE<TipoDato> s, int position){
        int contador = 0;
        if (position != 0) {    //si el usuario indica la posicion 0, es el metodo add ya definido
            ElementoLE<TipoDato> auxiliar = primero;
            ElementoLE<TipoDato> siguiente;
            while (auxiliar.getSiguiente() != null) { //saber cuando hemos recorrido toda la lista
                //volvemos a enlazar los elementos en el mismo orden, añadiendo el nuevo en su posicion
                if (contador + 1 == position) {
                    ElementoLE<TipoDato> nuevo = (ElementoLE<TipoDato>) new ElementoLE<>(s);
                    siguiente = auxiliar.getSiguiente();
                    auxiliar.insertarmeEn(nuevo);
                    nuevo.insertarmeEn(siguiente);
                    auxiliar = siguiente;
                } else {
                    siguiente = auxiliar.getSiguiente();
                    auxiliar.insertarmeEn(siguiente);
                    auxiliar = siguiente;
                }
                contador++;
            }
        }else{
            add(s);
        }
    }

    public void remove(TipoDato dato){
        int contador = 0;
        ElementoLE<TipoDato> auxiliar;
        auxiliar = primero;
        if (auxiliar.getData() == dato) {
            del(contador);
        }
        while (auxiliar.getSiguiente() != null) {
            auxiliar = auxiliar.getSiguiente();
            contador++;
            if (auxiliar.getData() == dato) {
                del(contador);
                break;
            }
        }
    }

    public int del(int position){
        int contador = 0;
        ElementoLE<TipoDato> auxiliar;
        if (position > 0){
            ElementoLE<TipoDato> siguiente;
            auxiliar = primero;
            while (auxiliar.getSiguiente() != null){
                if ((contador + 1) == position){
                    ElementoLE<TipoDato> saltar = auxiliar.getSiguiente();
                    auxiliar.insertarmeEn(saltar.getSiguiente());
                    break;
                } else{
                    auxiliar = auxiliar.getSiguiente();
                }
                contador++;
            }
        } else{
            if (primero.getSiguiente() == null) {
                primero = null;
            } else {
                primero = primero.getSiguiente();
            }
        }
        return contador;
    }

    public int getPosicion(ElementoLE el){
        int contador = 0;
        if (primero.getData()!=el.getData()){
            ElementoLE<TipoDato> auxiliar = primero;
            while (auxiliar!=null){
                if (auxiliar.getData()==el.getData()){
                    break;
                } else if (auxiliar.getSiguiente()!=null) {
                    auxiliar=auxiliar.getSiguiente();
                    contador++;
                }else {
                    System.out.println("No se ha encontrado el elemento");
                    break;
                }
            }
        }
        return contador;
    }

    public ElementoLE<TipoDato> getPrimero(){
        return primero;
    }

    public ElementoLE<TipoDato> getSiguiente(ElementoLE<TipoDato> el){
        int posicion = getPosicion(el) + 1;
        return getElemento(posicion);
    }

    public ElementoLE<TipoDato> getUltimo(){
        ElementoLE<TipoDato> auxiliar = primero;
        while (auxiliar.getSiguiente()!=null){
            auxiliar = auxiliar.getSiguiente();
        }
        return auxiliar;
    }

    public ElementoLE<TipoDato> getElemento(int position){
        int contador = 0;
        ElementoLE<TipoDato> auxiliar;
        if (primero != null){
            auxiliar = primero;
            while (auxiliar.getSiguiente() != null){
                if (contador == position){
                    return auxiliar;
                }
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }

            return null;
        }

        return null;
    }
}
