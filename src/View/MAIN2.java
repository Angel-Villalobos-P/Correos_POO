/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.util.InputMismatchException;
import java.util.Scanner;
import Model.Counter;
import Model.Direccion;
import Model.Casillero;
import Model.Cliente;
import Model.TipoSexo;
import Model.TipoEntrega;
import Model.TipoEntregable;
import Model.Entregable;
import java.util.Date;
import Model.Paquete;
import Model.Sobre;
import Model.Revista;
import Model.TipoSobre;
import Model.TipoTemaRevista;
import java.util.ArrayList;
import Controller.Sistema;

public class MAIN2 {
    
    //public static ArrayList<Entregable> entregable = new ArrayList<Entregable>();
    public static void main(String[] args)
    {
        //Sistema sistema=new Sistema();
        //Direccion direccionCounter=null;
        //Counter counter=null;
        /*//MENU//
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            System.out.println("1. Crearcion de Counter 1");
            System.out.println("2. Administracion de Clientes 2");
            System.out.println("3. Recepcion de articulos 3");
            System.out.println("4. Retiro de articulos 4");
            System.out.println("5. Consulta de Entregables 5");
            System.out.println("6. Consulta de Tipo de cambio 6");
            System.out.println("7. Listado de clientes con paquetes pendiente7");
            System.out.println("8. Reporte de resumen contable8");
            
            
            System.out.println("9. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        if (counter==null){
                            Scanner entrada = new Scanner(System.in);
                            //System.out.print("Nombre del counter: ");
                            String nombreCounter = entrada.nextLine();
                            //System.out.print("CedulaJ del counter: ");
                            String cedulaCounter = entrada.nextLine();
                            //System.out.print("Direccion del counter: ");
                            //System.out.print("Provincia: ");
                            String provinciaCounter = entrada.nextLine();
                            //System.out.print("Canton: ");
                            String cantonCounter = entrada.nextLine();
                            //System.out.print("Distrito: ");
                            String distritoCounter = entrada.nextLine();
                            //System.out.print("Señas: ");
                            String seniasCounter = entrada.nextLine();
                            //System.out.print("Cantidad de casilleros del counter: ");
                            int cantCasilleros = entrada.nextInt();
                            direccionCounter = Sistema.crearDireccion(provinciaCounter, cantonCounter, distritoCounter, seniasCounter);
                            counter = Sistema.inicializarCounter(nombreCounter, cedulaCounter, null, cantCasilleros);
                        }
                        else{
                            System.out.println("El counter ya esta creado");
                        }
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }//MENU FIN;*/
 
    
    /*Sistema sistema=new Sistema();
        //1-Inicializar Counter//
        Counter counter = Sistema.inicializarCounter();
        //2-*/
        
        
        //scanners//
        //Scanner entrada = new Scanner(System.in);
        //System.out.print("Nombre del counter: ");
        String nombreCounter = "Lala";
        //System.out.print("CedulaJ del counter: ");
        String cedulaCounter = "234";
        //System.out.print("Direccion del counter: ");
        //System.out.print("Provincia: ");
        String provinciaCounter = "Punta";
        //System.out.print("Canton: ");
        String cantonCounter = "puntaa";
        //System.out.print("Distrito: ");
        String distritoCounter = "puntaaa";
        //System.out.print("Señas: ");
        String seniasCounter = "nonono";
        //System.out.print("Cantidad de casilleros del counter: ");
        int cantCasilleros = 2;
        
                //CREAR DIRECCION DEL COUNTER//
        Direccion direccionCounter=new Direccion(provinciaCounter, cantonCounter, distritoCounter, seniasCounter);
                //CREAR DIRECCION DEL CLIENTE//
        Direccion direccionCliente=new Direccion(provinciaCounter, cantonCounter, distritoCounter, seniasCounter);
                //CREAR FECHA NACIMIENTO DEL CLIENTE//
        Date fecha=new Date();
        //CREAR COUNTER//
        Counter CorreoCR = new Counter(nombreCounter, cedulaCounter, direccionCounter, cantCasilleros);
        //CREAR CLIENTE//        - ASIGNAR CASILLERO//
        int id=145;
        String nombreCli="",correo="",telefono="";
        TipoSexo sexo=TipoSexo.otro;
        Cliente clienteN=new Cliente(id,nombreCli,correo,telefono,direccionCliente,fecha,sexo);
                   //Crear Entregable//
        //CREAR PAQUETE//
        int numReferencia=45;
        boolean entregado=true,isElectric=true,isFragile=true;
        TipoEntregable descripcion=TipoEntregable.Paquete;
        String remitente="Carlos";
        TipoEntrega formaDeEntrega=TipoEntrega.bolsa;
        double peso=0.5;
        Paquete PaqueteN= new Paquete(numReferencia,entregado,descripcion,remitente,formaDeEntrega,isElectric,isFragile,peso); 
        //CREAR CASILLERO//
        Casillero casilleroN=new Casillero(1);
        //ASIGNAR CLIENTE//
        casilleroN.setCliente(clienteN);
        //CREAR REVISTA//
        int numReferenciarevi=45;
        boolean entregadorevi=true;
        TipoEntregable descripcionrevi=TipoEntregable.Revista;
        String remitenterevi="Carlos";
        String nombreRevi="Revi";
        boolean isCatalogo=true;
        TipoTemaRevista tema=TipoTemaRevista.belleza;
        Revista RevistaN= new Revista(numReferenciarevi,entregadorevi,descripcionrevi,remitenterevi,nombreRevi,isCatalogo,tema); 
        //CREAR SOBRE//
        int numReferenciasob=45;
        boolean entregadosob=true;
        TipoEntregable descripcionsob=TipoEntregable.Revista;
        String remitentesob="Carlos";
        TipoSobre tiposob = TipoSobre.aereo;
        String contenidosob="Mucho";
        double pesosob = 0.5;
        Sobre SobreN= new Sobre(numReferenciasob,entregadosob,descripcionsob,remitentesob,tiposob,contenidosob,pesosob); 
        //ASIGNAR PAQUETE - Revista//
        casilleroN.addEntregable(PaqueteN);
        casilleroN.addEntregable(RevistaN);
        casilleroN.addEntregable(SobreN);
        
        //agregarCasillero al Counter
        CorreoCR.addCasillero(casilleroN);
        //Imprimir//
        //Imprimir Entregables//
        System.out.println(PaqueteN.toString());
        System.out.println(PaqueteN.toStringInicial());
        System.out.println(RevistaN.toString());
        System.out.println(SobreN.toString());
        //Imprimir Clientes//
        System.out.println(clienteN.toString());
        //Imprimir Casilleros//
        System.out.println(casilleroN.toString());
        //Imprimir todo el counter//
        System.out.println(CorreoCR.toString());
    
    }
}
