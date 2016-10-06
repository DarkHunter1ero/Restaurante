/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import Clases.Mesa;
import Clases.MesaHelper;
import Clases.Mozo;
import Clases.MozoHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "mesaController")
@SessionScoped
public class MesaController implements Serializable{
    
    MesaHelper helper;
    
    private Mesa selected = new Mesa();
    private List<Mesa> items = new ArrayList<>();
    private int cantidad;
    
    public MesaController() {
        helper = new MesaHelper();
    }
    
    public void crearMozo(){
        helper.create(selected);
        selected= new Mesa();
    }
    
    public Mesa getSelected(){
        if(selected == null){
            selected = new Mesa();
        }
        return selected;
    }
    
    public void setSelected(Mesa selected){
        this.selected=selected;
    }
    
    public List<Mesa> getItems(){
        loadItems();
        return this.items;
    }
    
    public void setItems(List<Mesa> items) {
        this.items = items;
    }
    
    public void loadItems(){
        this.items=helper.obtenerMesasMozos();
    }
    
    public String getEstado(boolean activo){
        if(activo==true){
            return "activa";
        }else{
            return "inactiva";
        }
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void generarMesas(){
        int numero;
        if(!existenRegistros()){
            numero=0;
        }else{
            numero = helper.count();
        }
        int i;
        for (i = 0; i < cantidad; i++) {
            helper.create(new Mesa(++numero));
        }
        FacesContext.getCurrentInstance().addMessage("generarMButton", new FacesMessage("Las "+ i+1 +" mesas fueron creadas correctamente."));
    }
    
    public boolean existenRegistros(){
        return helper.existenRegistros();
    }
}
