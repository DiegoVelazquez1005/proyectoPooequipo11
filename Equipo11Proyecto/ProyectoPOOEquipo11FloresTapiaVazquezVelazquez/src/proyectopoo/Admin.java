package proyectopoo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Admin extends trabajador {
    static File archivo = null; 
    static PrintWriter pw = null;
    static FileWriter fichero = null;

    public Admin(String id, ArrayList<String> usersArch) {
        super(id,usersArch);
    }
    public Admin(String id, ArrayList<String> usersArch, trabajador worker) {
        super(id,usersArch);
    }   
    public void asignarTarea(trabajador worker, String tarea){
        worker.tareasAsignadas = tarea;
        
    }
}
