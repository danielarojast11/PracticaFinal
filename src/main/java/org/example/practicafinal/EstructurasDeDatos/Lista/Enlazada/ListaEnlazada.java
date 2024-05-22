package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

public class ListaEnlazada<TipoDato> {
    private ElementoLE<TipoDato> primero;
    private int numElementos;

    public ListaEnlazada(ElementoLE<TipoDato> primero){
        this.primero = primero;
    }

    public ListaEnlazada(){

    }

    public int getNumElementos(){
        return numElementos;
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
            primero = new ElementoLE<>((TipoDato) s);
        } else {
            ElementoLE<TipoDato> auxiliar = primero;
            ElementoLE<TipoDato> nuevo = new ElementoLE<>((TipoDato) s);
            nuevo.insertarmeEn(auxiliar);       //se convierte en el primero
            primero = nuevo;
        }
    }

    public void add(TipoDato o){
        ElementoLE<TipoDato> elementoLE = new ElementoLE<>(o);
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

    public int del(int position){
        int contador = 0;
        ElementoLE<TipoDato> auxiliar;
        if (position!=0){
            ElementoLE<TipoDato> siguiente;
            auxiliar=primero;
            while (auxiliar.getSiguiente()!=null){
                if (contador+1==position){
                    if (auxiliar.getSiguiente().getSiguiente()!=null){
                        siguiente = auxiliar.getSiguiente().getSiguiente();
                        auxiliar.insertarmeEn(siguiente);
                        auxiliar = siguiente;
                    } else{
                        break;
                    }
                } else{
                    siguiente = auxiliar.getSiguiente();
                    auxiliar.insertarmeEn(siguiente);
                    auxiliar=siguiente;
                }
                contador++;
            }
        } else{
            auxiliar = primero;
            primero = auxiliar.getSiguiente();
            auxiliar.setData(null);
        }
        return contador;
    }

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
        ElementoLE<TipoDato> valor = null;
        ElementoLE<TipoDato> auxiliar = primero;
        while (contador<=position){
            if (contador==position){
                valor = new ElementoLE<>(auxiliar.getData());
                break;
            } else{
                auxiliar = auxiliar.getSiguiente();
            }
            contador++;
        }
        return valor;
    }
}