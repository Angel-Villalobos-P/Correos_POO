/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 * Artículo que es recibido por el counter, tiene un peso, e indica si es electrónico y frájil
 * */
public class Paquete extends Entregable {
    private TipoEntrega FormaDeEntregar;
    private boolean isElectronic;
    private boolean isFragile;
    private double peso;

    /**
     * Constructor de la clase
     * @param descripcion tipo del entregable
     * @param entregado un estado que indica si el artículo a sido entregado
     * @param numReferencia identificacion del artículo
     * @param precio precio del artículo
     * @param remitente la persona o compañía que envía el artículo
     * @param peso peso del artículo en kg
     * @param formaDeEntrega material que envuelve el artículo de TipoEntrega
     * @param isElectric indica si el objeto es electrónico
     * @param isFragile indica si el objeto es frájil
     * */
    public Paquete(int numReferencia,boolean entregado, TipoEntregable descripcion,String remitente,double precio,TipoEntrega formaDeEntrega, boolean isElectric,boolean isFragile,double peso){
        super(numReferencia,entregado,descripcion,remitente,precio);
        this.FormaDeEntregar=formaDeEntrega;
        this.isElectronic=isElectric;
        this.isFragile=isFragile;
    }
    @Override
    public String toString() {
        return "Paquete{" + "Tipo de Entrega=" + FormaDeEntregar + 
                ", Electronico/no=" + isElectronic + 
                ", Fragil/no=" + isFragile + 
                ", Peso=" + peso + "Kg, "; 
    }

    @Override
    /**
     * Calcula el impuesto del artículo
     * */
    public double calcularImpuesto() {
        double impuestoDolar = peso * 0.02;
        if (isElectronic){
            impuestoDolar += 2;
        }
        if (isFragile) {
            impuestoDolar += 2;
        }
        return impuestoDolar;
    }

    @Override
    /**
     * Calcula el precio total con el impuesto y el descuento
     * @param rango Tipo de rango
     * */
    public double calcularPrecio(TipoRango rango) {
        return precio - precio*calcularDescuento(rango) + calcularImpuesto();
    }


}
