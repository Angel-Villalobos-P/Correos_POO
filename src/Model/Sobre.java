/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Sobre extends Entregable {
    private TipoSobre tipo;
    private String contenido;
    private double peso;
    
    public Sobre(int numReferencia,boolean entregado, TipoEntregable descripcion,String remitente,double precio
                 ,TipoSobre tipo, String contenido, double peso){
        super(numReferencia,entregado,descripcion,remitente,precio);
        this.tipo=tipo;
        this.contenido=contenido;
        this.peso=peso;
    }
    @Override
    public String toString() {
        return "Paquete{" + "Tipo de Sobre=" + tipo + 
                ", Contenido=" + contenido + 
                ", Peso=" + peso + "Kg, "; 
    }

    @Override
    public double calcularImpuesto() {
        double impuestoDolar = 0;
        if (tipo == TipoSobre.manila && contenido.equalsIgnoreCase("Documento")){
            impuestoDolar += 1;
        }
        else if (tipo == TipoSobre.manila && contenido.equalsIgnoreCase("Documento") == false){
            impuestoDolar += 2;

        }
        if (tipo == TipoSobre.aereo && contenido.equalsIgnoreCase("Documento") == false){
            impuestoDolar += 1;
        }
        return impuestoDolar;
    }

    @Override
    public double calcularPrecio(TipoRango rango) {
        return precio - precio*calcularDescuento(rango) + calcularImpuesto();
    }

}
