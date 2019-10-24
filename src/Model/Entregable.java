/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Entregable {
    protected int numReferense;
    protected boolean entregado;
    protected TipoEntregable descripcion;
    protected String remitente;
    
    public Entregable(int numReferencia, boolean entregado, TipoEntregable descripcion, String remitente){
        this.numReferense=numReferencia;
        this.entregado=entregado;
        this.descripcion=descripcion;
        this.remitente=remitente;
    }
    public void calcularImpuesto(){
        
    }
    //@Override
    public String toStringInicial() {
        return "       " + "Numero de referencia=" + numReferense + 
                ", Entregablo/no=" + entregado + 
                ", Desclipcion=" + descripcion + 
                ", Remitente=" + remitente + '}'+"\n"; 
    }
}

