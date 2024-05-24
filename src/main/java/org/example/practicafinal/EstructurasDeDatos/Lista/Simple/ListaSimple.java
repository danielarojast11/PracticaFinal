package org.example.practicafinal.EstructurasDeDatos.Lista.Simple;

public class ListaSimple<TipoDato> {
    private ElementoLS<TipoDato> [] datos;
    private int maximo = 3000;
    private int numeroElementos;

    public ListaSimple(){
        this.datos = new ElementoLS[maximo];
        this.numeroElementos = 0;
    }

    public int getMaximo(){
        return maximo;
    }

    public void setMaximo(int maximo){
        this.maximo = maximo;
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

    public void add(ElementoLS<TipoDato> el) {
        ElementoLS<TipoDato> a = new ElementoLS<>();
        a.setData((TipoDato) el);
        if (isVacia()){
            datos[0] = a;
        }
        else {
            for (int i = 0; i<datos.length;i++){
                if (datos[i]==null){
                    datos[i] = a;
                    numeroElementos++;
                    break;
                }
            }
        }
    }

    public void add(TipoDato o){
        ElementoLS<TipoDato> a = new ElementoLS<>();
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
        numeroElementos ++;
        datos = new ElementoLS[numeroElementos];
    }

    public void del(int position){
        if (position > numeroElementos && position >= 0){
            datos[position] = null;
            datos[position] = datos[numeroElementos-1];
            datos[numeroElementos-1] = null;
            numeroElementos--;
        }
    }

    public int getNumeroElementos(){
        return datos.length;
    }

    public int getPosicion(ElementoLS<TipoDato> el){
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

    public TipoDato getPrimero(){
        if (datos.length > 0){
            return datos[0].getData();
        }
        else{
            System.out.println("La lista está vacía");
        }
        return null;
    }

    public TipoDato getUltimo(){
        if (datos.length > 0){
            int i = datos.length-1;
            return datos[i].getData();
        }
        else{
            System.out.println("La lista está vacía");
        }
        return null;
    }

    private ElementoLS<TipoDato> getSiguiente(ElementoLS<TipoDato> el){
        int i = getPosicion(el) + 1;
        return (ElementoLS<TipoDato>) datos[i].getData();
    }

    public TipoDato getElemento(int position){
        if (position > datos.length || datos[position] == null){
            return null;
        }
        else{
            return datos[position].getData();
        }
    }
}
