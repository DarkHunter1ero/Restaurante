package Clases;
// Generated Oct 2, 2016 10:39:18 PM by Hibernate Tools 4.3.1



/**
 * Mesa generated by hbm2java
 */
public class Mesa  implements java.io.Serializable {


     private int id;
     private int numero;
     private Mozo mozo;
     private boolean activo = true;

    public Mesa() {
    }

    public Mesa(int numero) {
        this.numero = numero;
    }

    public Mesa(int id, int numero, Mozo mozo) {
        this.id = id;
        this.numero = numero;
        this.mozo = mozo;
    }

    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Mozo getMozo() {
        return mozo;
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}


