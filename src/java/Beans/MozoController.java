/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Mozo;
import Clases.MozoHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "mozoController")
@SessionScoped
public class MozoController implements Serializable{

    MozoHelper helper;

    private Mozo selected = new Mozo();
    private List<Mozo> items = new ArrayList<>();
    
    public MozoController() {
         helper = new MozoHelper();
    }
    
    public void crearMozo(){
        helper.create(selected);
        selected= new Mozo();
    }
    
    public Mozo getSelected(){
        if(selected == null){
            selected = new Mozo();
        }
        return selected;
    }
    
    public void setSelected(Mozo selected){
        this.selected=selected;
    }
    
    public List<Mozo> getItems(){
        loadItems();
        return this.items;
    }

    public void setItems(List<Mozo> items) {
        this.items = items;
    }
    
    public void loadItems(){
        this.items=helper.findAll();
    }
    
    public Mozo getMozo(int id){
        return helper.findById(id);
    }
}
