package org.example.practicafinal.EstructurasDeDatos.Grafo;

public class Carretera implements Comparable<Carretera>{
    private Ciudad ciudad1, ciudad2;
    private int peso;

    public Carretera (){

    }

    public Carretera(Ciudad ciudad1, Ciudad ciudad2){
        this(ciudad1,ciudad2,1);
    }

    public Carretera (Ciudad ciudad1, Ciudad ciudad2, int peso){
        if (ciudad1.getNombre().compareTo(ciudad2.getNombre())<=0){
            this.ciudad1 = ciudad1;
            this.ciudad2 = ciudad2;
        } else {
            this.ciudad1 = ciudad2;
            this.ciudad2 = ciudad1;
        }
        this.peso = peso;
    }

    public Ciudad getVecinaDe(Ciudad actual){
        if (actual.equals(this.ciudad1)){
            return this.ciudad2;
        } else if (actual.equals(this.ciudad2)) {
            return this.ciudad1;
        } else {
            return null;
        }
    }

    public Ciudad getCiudad1(){
        return this.ciudad1;
    }

    public Ciudad getCiudad2(){
        return this.ciudad2;
    }

    public int getPeso(){
        return this.peso;
    }

    public void setpeso(int peso){
        this.peso = peso;
    }

    @Override
    public int compareTo(Carretera carretera) {
        return this.peso - carretera.peso;
    }

    public String toString(){
        return ("({ "+this.ciudad1.getNombre()+", "+this.ciudad2.getNombre()+"}, "+this.peso+")");
    }

    public int hashCode(){
        return (this.ciudad1.getNombre().hashCode()+ ciudad2.hashCode());
    }

    public boolean equals(Carretera objeto) {
        if (!(objeto instanceof Carretera)) {
            return false;
        }
        Carretera carretera = (Carretera) objeto;
        if (carretera.ciudad1.equals(this.ciudad1) && carretera.ciudad2.equals(this.ciudad2)) {
            return true;
        }
        return false;
    }
}
