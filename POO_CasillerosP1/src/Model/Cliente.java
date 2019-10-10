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
    
    public Cliente(){
    
    }
    
}
