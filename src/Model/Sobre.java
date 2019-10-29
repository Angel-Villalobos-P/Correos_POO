/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Date;

/**
 * Un artículo pequeño, puede ser entregado de varias maneras y tiene un peso.
 * */
public class Sobre extends Entregable {
    private TipoSobre tipo;
    private String contenido;
    private double peso;

    /**
     * Constructor de la clase
     * @param descripcion tipo del entregable
     * @param entregado un estado que indica si el artículo a sido entregado
     * @param numReferencia identificacion del artículo
     * @param precio precio del artículo
     * @param remitente la persona o compañía que envía el artículo
     * @param peso peso del sobre en kg
     * @param contenido contenido del sobre, puede ser "Documento" u otra cosa
     * @param tipo forma de entrega del sobre, ej: manila, aéreo
     * @param fechaRecibido fecha que se recibió el paquete
     * */
    public Sobre(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente, double precio
                 , TipoSobre tipo, String contenido, double peso, Date fechaRecibido){
        super(numReferencia,entregado,descripcion,remitente,precio,fechaRecibido);
        this.tipo=tipo;
        this.contenido=contenido;
        this.peso=peso;
    }
    @Override
    public String toString() {
        return super.toString() +
                "Paquete{" + "Tipo de Sobre=" + tipo +
                ", Contenido=" + contenido + 
                ", Peso=" + peso + "kg\n";
    }

    @Override
    /**
     * Calcula el impuesto del artículo
     * */
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
    /**
     * Calcula el precio total con el impuesto y el descuento
     * @param rango Tipo de rango
     * */
    public double calcularPrecio(TipoRango rango) {
        return precio - precio*calcularDescuento(rango) + calcularImpuesto();
    }

}
