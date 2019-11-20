package proyectopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import static proyectopoo.Admin.fichero;

public class archivos {
   static File archivo = null; 
   static FileReader fr;
   static FileWriter fw;
    static BufferedWriter bw;
    static PrintWriter pw = null;
   static String direccionUsuarios = "usuarios\\";
   static String direccionTareas = "tareas\\";
   static String direccionRelacion = "relacion\\";
   static BufferedReader br;
   
   public static  ArrayList archivos(boolean dir){
       File f = null;
       ArrayList <String> users = new <String> ArrayList();
       if(dir){
           f = new File(direccionUsuarios);
       }else{
           f = new File(direccionTareas);
       }
        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            users.add(ficheros[x].getName());
        }
        return users;
    }
   public static  ArrayList archivos(){
       File f = null;
       ArrayList <String> users = new <String> ArrayList();
        f = new File(direccionRelacion);
      
        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            users.add(ficheros[x].getName());
        }
        return users;
    }
    public static ArrayList<String> obtenerCredenciales(String nombre, boolean caso){
        ArrayList <String> Claves = new <String> ArrayList();
        try{
            if(caso){
                archivo = new File (direccionUsuarios+nombre+".txt");
            }else{
                archivo = new File (direccionUsuarios+nombre);
            }
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String claves;
            claves = br.readLine();
            String []arr = claves.split(",");
            for(int i=0; i<arr.length; i++){
                Claves.add(arr[i]);
                //System.out.println("Datos: " + arr[i]);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
            e2.printStackTrace();
            }
        }
        return Claves;
    }
    public static ArrayList<String> obtenerRelacion(String nombre){
        ArrayList <String> Claves = new <String> ArrayList();
        try{
            archivo = new File (direccionRelacion+nombre);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String claves;
            claves = br.readLine();
            String []arr = claves.split(",");
            for(int i=0; i<arr.length; i++){
                Claves.add(arr[i]);
                //System.out.println("Datos: " + arr[i]);
            }
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
            e2.printStackTrace();
            }
        }
        return Claves;
    }
    public static void crearArchTarea(String id){
        try {
            //instancia de objeto para un archivo
            archivo = new File(direccionTareas + id + ".txt");
            //Si el archivo no existe lo crea
            if (!archivo.exists()){
                archivo.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    public static void crearArchTarea(){
        try {
            archivo = new File("estadistica\\estadisticas.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    public static void setEstadisticas(int p, int pro, int ter, int ent){
        try {
            archivo = new File("estadistica\\estadisticas.txt");
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            
            fichero = new FileWriter("estadistica\\estadisticas.txt", false);
            pw = new PrintWriter(fichero);
            pw.write("numero de tareas pendientes : " + p);
            pw.write("\nnumero de tareas en progreso : " + pro);
            pw.write("\nnumero de tareas terminadas : " + ter);
            pw.write("\nnumero de tareas entregadas : " + ent);
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public static void crearArchRelacion(String id, String idTarea, String estado){
        try {
            //instancia de objeto para un archivo
            archivo = new File(direccionRelacion + id);
            //Si el archivo no existe lo crea
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            
            fichero = new FileWriter(direccionRelacion+id, false);
            pw = new PrintWriter(fichero);
            pw.write(estado+",");
            pw.write(idTarea+",");
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    public static void setArchRelacion(String id){
        try {
            //instancia de objeto para un archivo
            archivo = new File(direccionRelacion + id);
            //Si el archivo no existe lo crea
            if (!archivo.exists()){
                archivo.createNewFile();
            }
            
            fichero = new FileWriter(direccionRelacion+id, false);
            pw = new PrintWriter(fichero);
            pw.write("");
            pw.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    public static void eliminarTarea(String id){
 
        File f= new File(direccionTareas+id);
        f.delete();
         
    }
    public static void asignarDescripcion(String id, String msj){
        try{
            fichero = new FileWriter(direccionTareas+id+".txt", true);
            pw = new PrintWriter(fichero);
            pw.write(msj);
            pw.write('\n');
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
                if( null != archivo ){
                    fichero.close();
                }
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void crearWorker(String id) {

        try {
            //instancia de objeto para un archivo
            archivo = new File(direccionUsuarios + id + ".txt");
            //Si el archivo no existe lo crea
            if (!archivo.exists()){
                archivo.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    public void llenarWorker(trabajador worker, String id) {
    
    try {
            //instancia de objeto para un archivo
            archivo = new File(direccionUsuarios + id + ".txt");
            //Si el archivo no existe lo crea
           

            fw = new FileWriter(archivo);

            bw = new BufferedWriter(fw);
            
            bw.append(worker.Nombre+",");
            bw.append(worker.ApePat+",");
            bw.append(worker.ApeMat+",");
            bw.append(worker.puesto+",");
            bw.append(worker.pasword+",");
            
        bw.close();
        fw.close();
        //cierre del archivo 
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                 
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
}
