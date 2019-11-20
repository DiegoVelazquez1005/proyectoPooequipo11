package proyectopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static proyectopoo.Admin.fichero;
import static proyectopoo.archivos.archivo;

public class Tarea {
    
   static FileReader fr;
   static BufferedReader br;
  
    static FileWriter fw;
    static BufferedWriter bw;

    static PrintWriter pw = null;
    static String idTarea;
    static String detalles = "tareas\\";
    
    public Tarea ( String tarea){
        this.idTarea = tarea;
        
    }
    public Tarea (){}

    public static String obtenerDescripcion(String id){
        String des = null;
        try{
            archivo = new File (detalles+id);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String claves;
            des = br.readLine();
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(" ");
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
            e2.printStackTrace();
            }
        }
        
        return des;
    }
    public static void estadisticas(){
         ArrayList relaciones = archivos.archivos();
        ArrayList <String> rel = new <String>ArrayList();
        int pendiente=0, progreso =0, terminado =0, entregada = 0;
        
        for(int i = 0; i< relaciones.size(); i++){
            
            rel = archivos.obtenerRelacion(relaciones.get(i).toString());
            if(rel.get(0).equals("pendiente")){
                pendiente++;
            }else if (rel.get(0).equals("en progreso")){
                progreso++;
            }else if (rel.get(0).equals("terminada")){
                terminado++;
            }else if(rel.get(0).equals("entregada")){
                entregada ++;
            }
        }
        archivos.crearArchTarea();
        archivos.setEstadisticas(pendiente, progreso, terminado, entregada);
    }
}
