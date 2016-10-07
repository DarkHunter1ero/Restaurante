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
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "mesaController")
@SessionScoped
public class MesaController implements Serializable{
    
    MesaHelper helperMesa;
    MozoHelper helperMozo;
    
    private Mesa selected = new Mesa();
    private List<Mesa> items = new ArrayList<>();
    private int cantidad;
    
    @PostConstruct
    private void init(){
        loadItems();
    }
    
    public MesaController() {
        helperMesa = new MesaHelper();
        helperMozo = new MozoHelper();
    }
    
    public void crearMozo(){
        helperMesa.create(selected);
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
        return this.items;
    }
    
    public void setItems(List<Mesa> items) {
        this.items = items;
    }
    
    public void loadItems(){
        this.items=helperMesa.obtenerMesasMozos();
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
            numero = helperMesa.count();
        }
        int i;
        for (i = 0; i < cantidad; i++) {
            helperMesa.create(new Mesa(++numero));
        }
        FacesContext.getCurrentInstance().addMessage("generarMButton", new FacesMessage("Las "+ i +" mesas fueron creadas correctamente."));
    }
    
    public boolean existenRegistros(){
        return helperMesa.existenRegistros();
    }
    
    public void guardarLista(){
        for(Mesa m : items){
            int id = m.getMozo().getId();
            m.setMozo(helperMozo.findById(id));
            helperMesa.update(m);
        }
        FacesContext.getCurrentInstance().addMessage("saveButton", new FacesMessage("Se han guardado los datos correctamente."));
    }
}
