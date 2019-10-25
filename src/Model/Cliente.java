/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private Direccion direccion;
    private Date fechaNacimiento;
    private TipoRango tipo;
    private TipoSexo sexo;
    private int PaquetesRetirados;
    
    public Cliente(int id,String nombre,String correo,String telefono,Direccion direccion,Date fecha,TipoSexo sexo){
        this.id=id;
        this.nombre=nombre;
        this.correo=correo;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fechaNacimiento=fecha;
        this.tipo=TipoRango.Normal;
        this.sexo=sexo;
        this.PaquetesRetirados=0;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "ID=" + id + 
                ", Nombre=" + nombre + 
                ", Correo=" + correo + 
                ", Telefono=" + telefono + 
                ", Direccion=" + direccion + 
                ", Fecha de Nacimiento=" + fechaNacimiento + 
                ", Tipo de Cliente=" + tipo + 
                ", Sexo=" + sexo + 
                ", Paquetes Retirados=" + PaquetesRetirados + '}'+"\n";  
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoRango getTipo() {
        return tipo;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public int getPaquetesRetirados() {
        return PaquetesRetirados;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipo(TipoRango tipo) {
        this.tipo = tipo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public void setPaquetesRetirados(int paquetesRetirados) {
        PaquetesRetirados = paquetesRetirados;
    }

    public void retirarPaquete(int cantidad){
        this.PaquetesRetirados += cantidad;
    }
}
