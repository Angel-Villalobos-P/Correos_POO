/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Paquete extends Entregable {
    private TipoEntrega FormaDeEntregar;
    private boolean isElectronic;
    private boolean isFragile;
    private double peso;
    
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
    public double calcularPrecio(TipoRango rango) {
        return precio - precio*calcularDescuento(rango) + calcularImpuesto();
    }


}
