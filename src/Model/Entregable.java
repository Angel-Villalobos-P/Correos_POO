/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
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
    protected Date fechaEntregadoCounter;
    protected Date fechaEntregadoCliente;
    protected double descuento;

    /**
     * Constructor de la clase
     * @param descripcion tipo del entregable
     * @param entregado un estado que indica si el artículo a sido entregado
     * @param numReferencia identificacion del artículo
     * @param precio precio del artículo
     * @param remitente la persona o compañía que envía el artículo
     * */
    public Entregable(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente,double precio,Date fechaRecibida){
        this.numReferense=numReferencia;
        this.entregado=entregado;
        this.descripcion=descripcion;
        this.remitente=remitente;
        this.precio = precio;
        this.fechaEntregadoCounter=fechaRecibida;
        this.fechaEntregadoCliente=null;
        this.descuento = 0;
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
    public int getNumReferencia(){
        return numReferense;
    }
    /**
     * Calcula el descuento dependiendo del rango del cliente receptor
     * @param rango Tipo de rango
     * */
    protected void calcularDescuento(TipoRango rango){
        if (rango == TipoRango.Plata) {
            descuento =  0.05;
        }
        if (rango == TipoRango.Oro) {
            descuento =  0.10;
        }
    }
    protected void setDayEntregadoCounter(Date dia){

    }
    protected void setMesEntregadoCounter(Date mes){

    }
    protected void setYearEntregadoCounter(Date year){

    }

    protected int getNumReferense() {
        return numReferense;
    }

    protected boolean isEntregado() {
        return entregado;
    }

    protected TipoEntregable getDescripcion() {
        return descripcion;
    }

    protected String getRemitente() {
        return remitente;
    }

    protected double getPrecio() {
        return precio;
    }

    protected Date getFechaEntregadoCounter() {
        return fechaEntregadoCounter;
    }

    protected Date getFechaEntregadoCliente() {
        return fechaEntregadoCliente;
    }

    protected void setNumReferense(int numReferense) {
        this.numReferense = numReferense;
    }

    protected void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    protected void setDescripcion(TipoEntregable descripcion) {
        this.descripcion = descripcion;
    }

    protected void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    protected void setFechaEntregadoCounter(Date fechaEntregadoCounter) {
        this.fechaEntregadoCounter = fechaEntregadoCounter;
    }

    protected void setFechaEntregadoCliente(Date fechaEntregadoCliente) {
        this.fechaEntregadoCliente = fechaEntregadoCliente;
    }

    /**
     * Calcula el precio total con el impuesto y el descuento
     * @param rango Tipo de rango
     * */
    public abstract double calcularPrecio(TipoRango rango);

    protected double getDescuento() {
        return descuento;
    }

    protected void setDescuento(double descuento) {
         this.descuento = descuento;
    }
}

