package Clases;
// Generated Oct 2, 2016 10:39:18 PM by Hibernate Tools 4.3.1



/**
 * Mozo generated by hbm2java
 */
public class Mozo  implements java.io.Serializable {


     private int id;
     private String cedula;
     private String nombre;
     private String apellido;
     private String foto;
     private boolean activo;

    public Mozo() {
    }

    public Mozo(int id, String cedula, String nombre, String apellido, String foto, boolean activo) {
       this.id = id;
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellido = apellido;
       this.foto = foto;
       this.activo = activo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }




}

