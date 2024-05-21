package org.example.practicafinal.EstructurasDeDatos.Lista.Enlazada;

public class ListaEnlazada {
    private ElementoLE primero;

    public ListaEnlazada(){
        primero = null;
    }

    public boolean isVacia(){   //Si la primera posicion es null, es que la lista esta vacia
        return primero==null;
    }

    public void vaciar(){
        ElementoLE auxiliar;    //Creamos un auxiliar
        while (primero.getSiguiente()!=null){   //sabremos que hemos llegado al final de la lista y no hay mas elementos
            auxiliar = primero;
            primero = primero.getSiguiente();
            auxiliar.setData(null); // vamos recorriendo la lista y eliminando sus elementos
        }
        primero = null;
    }

    protected void add(ElementoLE el){
        if (primero==null){ //si la lista esta vacia, sera el primer elemento
            primero = el;
        } else {
            ElementoLE auxiliar = primero;
            el.insertarmeEn(auxiliar);       //se convierte en el primero
            primero = el;
        }
    }

    public void add(String s){
        if (primero==null){
            primero = new ElementoLE(s);
        } else {
            ElementoLE auxiliar = primero;
            ElementoLE nuevo = new ElementoLE(s);
            nuevo.insertarmeEn(auxiliar);       //se convierte en el primero
            primero = nuevo;
        }
    }

    public void add(Object o){
        if (primero==null){
            primero = new ElementoLE(o);
        } else {
            ElementoLE auxiliar = primero;
            ElementoLE nuevo = new ElementoLE(o);
            nuevo.insertarmeEn(auxiliar);       //se convierte en el primero
            primero = nuevo;
        }
    }

    public void insert(String s, int position){
        int contador = 0;
        if (position != 0) {    //si el usuario indica la posicion 0, es el metodo add ya definido
            ElementoLE auxiliar = primero;
            ElementoLE siguiente;
            while (auxiliar.getSiguiente() != null) { //saber cuando hemos recorrido toda la lista
                //volvemos a enlazar los elementos en el mismo orden, añadiendo el nuevo en su posicion
                if (contador + 1 == position) {
                    ElementoLE nuevo = new ElementoLE(s);
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

    public void insert(Object o, int position){
        int contador = 0;
        if (position != 0) {    //si el usuario indica la posicion 0, es el metodo add ya definido
            ElementoLE auxiliar = primero;
            ElementoLE siguiente;
            while (auxiliar.getSiguiente() != null) {   //saber cuando hemos recorrido toda la lista
                //volvemos a enlazar los elementos en el mismo orden, añadiendo el nuevo en su posicion
                if (contador + 1 == position) {
                    ElementoLE nuevo = new ElementoLE(o);
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
            add(o);
        }
    }

    public int del(int position){
        int contador = 0;
        ElementoLE auxiliar;
        if (position!=0){
            ElementoLE siguiente;
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
            ElementoLE auxiliar = primero;
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
            ElementoLE auxiliar = primero;
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

    public ElementoLE getPrimero(){
        return primero;
    }

    public ElementoLE getSiguiente(ElementoLE el){
        int posicion = getPosicion(el) + 1;
        return getElemento(posicion);
    }

    public ElementoLE getUltimo(){
        ElementoLE auxiliar = primero;
        while (auxiliar.getSiguiente()!=null){
            auxiliar = auxiliar.getSiguiente();
        }
        return auxiliar;
    }

    public ElementoLE getElemento(int position){
        int contador = 0;
        ElementoLE valor = null;
        ElementoLE auxiliar = primero;
        while (contador<=position){
            if (contador==position){
                valor = new ElementoLE(auxiliar.getData());
                break;
            } else{
                auxiliar = auxiliar.getSiguiente();
            }
            contador++;
        }
        return valor;
    }
}
