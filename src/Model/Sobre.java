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
    
    public Sobre(int numReferencia,boolean entregado, TipoEntregable descripcion,String remitente
                 ,TipoSobre tipo, String contenido, double peso){
        super(numReferencia,entregado,descripcion,remitente);
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
}
