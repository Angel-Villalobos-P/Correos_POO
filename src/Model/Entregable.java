/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public abstract class Entregable {
    protected int numReferense;
    protected boolean entregado;
    protected TipoEntregable descripcion;
    protected String remitente;
    protected double precio;
    
    public Entregable(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente,double precio){
        this.numReferense=numReferencia;
        this.entregado=entregado;
        this.descripcion=descripcion;
        this.remitente=remitente;
        this.precio = precio;
    }
    public abstract double calcularImpuesto();


    //@Override
    public String toStringInicial() {
        return "       " + "Numero de referencia=" + numReferense + 
                ", Entregablo/no=" + entregado +
                ", Desclipcion=" + descripcion +
                ", Remitente=" + remitente + '}'+"\n"; 
    }

    protected double calcularDescuento(TipoRango rango){
        if (rango == TipoRango.Plata) {
            return 0.05;
        }
        if (rango == TipoRango.Oro) {
            return 0.10;
        }
        return 0;
    }

    public abstract double calcularPrecio(TipoRango rango);
}

