/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * El objeto Dirección representa la dirección fisica de un lugar, persona, acontecimiento, entre otros
 * */
public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String senias;

    /**
     * Constructor de la Dirección, es una dirección vacía
     * */
    public Direccion(){
        provincia = "";
        canton = "";
        distrito = "";
        senias = "";
    }

    /**
     * Constructor de la dirección
     * @param provincia provincia de residencia
     * @param canton cantón de residencia
     * @param distrito distrito de residencia
     * @param senias indicaciones físicas para facilitar la localización. Ej: color, objetos, locales, objetos
     * */
    public Direccion(String provincia,String canton, String distrito, String senias){
        this.provincia=provincia;
        this.canton=canton;
        this.distrito=distrito;
        this.senias=senias;
    }
    public void setProvincia(String provincia){
        this.provincia=provincia;
    }
    public void setCanton(String canton){
        this.canton=canton;
    }
    public void setDistrito(String distrito){
        this.distrito=distrito;
    }
    public void setSenias(String senias){
        this.senias=senias;
    }
    public String getProvincia(){
        return provincia;
    }
    public String getCanton(){
        return canton;
    }
    public String getDistrito(){
        return distrito;
    }
    public String getSenias(){
        return senias;
    }
    @Override
    public String toString() {
        return "Direccion{" + "Provincia=" + provincia + 
                ", canton=" + canton + 
                ", distrito=" + distrito + 
                ", senias=" + senias + '}'+"\n"; 
    }
}
