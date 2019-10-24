/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Revista extends Entregable{
    private String nombre;
    private boolean isCatalogo;
    private TipoTemaRevista tema;
    
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
    public double calcularImpuesto() {
        return isCatalogo ? 0:1;
    }

    @Override
    public double calcularPrecio(TipoRango rango) {
        return precio - precio*calcularDescuento(rango) + calcularImpuesto();
    }

}
