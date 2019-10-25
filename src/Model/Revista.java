/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Artículo que es recibido por el counter, la revista tiene un nombre, tema, y puede ser un catálogo
 * */
public class Revista extends Entregable{
    private String nombre;
    private boolean isCatalogo;
    private TipoTemaRevista tema;

    /**
     * Constructor de la clase
     * @param descripcion tipo del entregable
     * @param entregado un estado que indica si el artículo a sido entregado
     * @param numReferencia identificacion del artículo
     * @param precio precio del artículo
     * @param remitente la persona o compañía que envía el artículo
     * @param nombre nombre de la revista
     * @param isCatalogo indica si la revista es un catálogo
     * @param tema el tema de la revista
     * */
    public Revista(int numReferencia,boolean entregado, TipoEntregable descripcion,String remitente,double precio,String nombre,boolean isCatalogo,TipoTemaRevista tema){
        super(numReferencia,entregado,descripcion,remitente,precio);
        this.nombre=nombre;
        this.isCatalogo=isCatalogo;
        this.tema=tema;
    }
    @Override
    public String toString() {
        return "Revista{" + "Nombre=" + nombre + 
                ", Catalogo/no=" + isCatalogo + 
                ", Tema de Revista=" + tema + ", ";
    }


    @Override
    /**
     * Calcula el impuesto del artículo
     * */
    public double calcularImpuesto() {
        return isCatalogo ? 0:1;
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
