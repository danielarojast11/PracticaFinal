package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

import java.util.Arrays;

public class ListaSimple {
    private ElementoLS[] datos;
    private int maximo = 0;

    public ListaSimple(){
        datos = new ElementoLS[maximo];
    }

    public boolean isVacia(){
        if (datos.length == 0){
            return true;
        }
        return false;
    }

    public void vaciar(){
        maximo = 0;
        datos = new ElementoLS[maximo];
    }

    private void add(ElementoLS el) {
        ElementoLS a = new ElementoLS();
        a.setData(el);
        if (isVacia()){
            datos[0] = a;
        }
        else {
            for (int i = 0; i<datos.length;i++){
                if (datos[i]==null){
                    datos[i] = a;
                    break;
                }
            }

        }

    }

    public void add(String s){
        ElementoLS a = new ElementoLS();
        a.setData(s);
        if (isVacia()){
            datos = Arrays.copyOf(datos, 1);
            datos[0] = a;
        }
        else {
            maximo = datos.length +1;
            datos = Arrays.copyOf(datos, maximo);
            datos[maximo -1] = a;

        }
    }

    public void add(Object o){
        ElementoLS a = new ElementoLS();
        a.setData(o);
        if (isVacia()){
            datos[0] = a;
        } else {
            for (int i = 0; i<datos.length;i++){
                if (datos[i]==null){
                    datos[i] = a;
                    break;
                }
            }

        }
        maximo ++;
        datos = new ElementoLS[maximo];
    }

    public void insert (String s, int position){
        ElementoLS el = new ElementoLS();
        el.setData(s);
        if (position > datos.length){
            maximo = datos.length +1;
            datos = Arrays.copyOf(datos, maximo);
            datos[maximo -1] = el;
        }
        else{
            datos[position] = el;
        }
    }

    public void insert (Object o, int position){
        ElementoLS el = new ElementoLS();
        el.setData(0);
        if (position > datos.length){
            maximo = datos.length +1;
            datos = Arrays.copyOf(datos, maximo);
            datos[maximo -1] = el;
        }
        else{
            datos[position] = el;
        }
    }

    public int del(int position){
        if (position > datos.length){
            return datos.length;
        }
        else{
            if (datos != null){
                datos[position] = null;
                return datos.length;
            }
            else{
                System.out.println("La lista está vacía");
            }
            return 0;
        }
    }

    public int getNumeroElementos(){
        return datos.length;
    }

    public int getPosicion(ElementoLS el){
        int position = 0;
        for (int i=0; i<datos.length; i++){
            if (datos[i]==el){
                position = i;
                break;
            } else if (i == datos.length-1) {
                System.out.println("Elemento no encontrado");
            }
        }
        return position;
    }

    public ElementoLS getPrimero(){
        if (datos.length > 0){
            return datos[0];
        }
        else{
            System.out.println("La lista está vacía");
        }
        return null;
    }

    public ElementoLS getUltimo(){
        if (datos.length > 0){
            int i = datos.length-1;
            return datos[i];
        }
        else{
            System.out.println("La lista está vacía");
        }
        return null;
    }

    private ElementoLS getSiguiente(ElementoLS el){
        int i = getPosicion(el) + 1;
        return (ElementoLS) datos[i].getData();
    }

    public ElementoLS getElemento(int position){
        if (position > datos.length || datos[position] == null){
            return null;
        }
        else{
            return datos[position];
        }
    }
}
