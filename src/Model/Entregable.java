/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Clase madre de los artículos para entregar
 *
 * */
public abstract class Entregable {
    protected int numReferense;
    protected boolean entregado;
    protected TipoEntregable descripcion;
    protected String remitente;
    protected double precio;

    /**
     * Constructor de la clase
     * @param descripcion tipo del entregable
     * @param entregado un estado que indica si el artículo a sido entregado
     * @param numReferencia identificacion del artículo
     * @param precio precio del artículo
     * @param remitente la persona o compañía que envía el artículo
     * */
    public Entregable(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente,double precio){
        this.numReferense=numReferencia;
        this.entregado=entregado;
        this.descripcion=descripcion;
        this.remitente=remitente;
        this.precio = precio;
    }

    /**
     * Calcula el impuesto del artículo
     * */
    public abstract double calcularImpuesto();

    //@Override
    public String toStringInicial() {
        return "       " + "Numero de referencia=" + numReferense + 
                ", Entregablo/no=" + entregado +
                ", Desclipcion=" + descripcion +
                ", Remitente=" + remitente + '}'+"\n"; 
    }

    /**
     * Calcula el descuento dependiendo del rango del cliente receptor
     * @param rango Tipo de rango
     * */
    protected double calcularDescuento(TipoRango rango){
        if (rango == TipoRango.Plata) {
            return 0.05;
        }
        if (rango == TipoRango.Oro) {
            return 0.10;
        }
        return 0;
    }

    /**
     * Calcula el precio total con el impuesto y el descuento
     * @param rango Tipo de rango
     * */
    public abstract double calcularPrecio(TipoRango rango);
}

