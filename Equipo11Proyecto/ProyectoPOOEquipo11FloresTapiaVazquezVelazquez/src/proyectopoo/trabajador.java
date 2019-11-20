/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.util.ArrayList;

/**
 *
 * @author velaz
 */
public class trabajador {
    String id;
    String Nombre;
    String ApeMat;
    String ApePat;
    String puesto;
    String pasword;
    String tareasAsignadas;
    
    public trabajador(String id,String Nombre, String ApeMat,String ApePat,String puesto, String pasword){
    this.id=id;
    this.Nombre=Nombre;
    this.ApePat=ApePat;
    this.ApeMat=ApeMat;
    this.puesto=puesto;
    this.pasword=pasword;
    
    }
    public trabajador(String id, ArrayList <String> usersArch){
        this.id = id;
        this.Nombre = usersArch.get(0);
        this.ApePat = usersArch.get(1);
        this.ApeMat = usersArch.get(2);
        this.puesto = usersArch.get(3);
        this.pasword = usersArch.get(4);
    }
    
    public void setTarea(String tarea){
        this.tareasAsignadas=tarea;
    }
    public String getTarea(){
        return  tareasAsignadas;
    }
    
}
