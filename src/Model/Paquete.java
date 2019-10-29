/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Date;

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
     * @param fechaRecibida fecha en que se recibió el paquete
     *
     * */
    public Paquete(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente, double precio, TipoEntrega formaDeEntrega, boolean isElectric, boolean isFragile, double peso, Date fechaRecibida){
        super(numReferencia,entregado,descripcion,remitente,precio,fechaRecibida);
        this.FormaDeEntregar=formaDeEntrega;
        this.isElectronic=isElectric;
        this.peso = peso;
        this.isFragile=isFragile;
    }
    @Override
    public String toString() {
        return  super.toStringInicial() +
                "Paquete{" + "Tipo de Entrega=" + FormaDeEntregar +
                ", Electronico/no=" + isElectronic + 
                ", Fragil/no=" + isFragile + 
                ", Peso=" + peso + "kg\n";
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
