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
    
    public Paquete(int numReferencia,boolean entregado, TipoEntregable descripcion,String remitente,TipoEntrega formaDeEntrega, boolean isElectric,boolean isFragile,double peso){
        super(numReferencia,entregado,descripcion,remitente);
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
}
