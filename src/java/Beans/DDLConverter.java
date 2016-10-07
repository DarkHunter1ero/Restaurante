/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Beans;

import Clases.Mozo;
import Clases.MozoHelper;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="DDLConverter", forClass = Mozo.class)
public class DDLConverter implements Converter, Serializable {
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Convert ProjectDetail to its unique String representation.
        Mozo projectDetail = (Mozo) value;
        String idAsString = String.valueOf(projectDetail.getId());
                return idAsString;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // Convert unique String representation of ProjectDetail back to ProjectDetail object.
        Long id = Long.valueOf(value);
        MozoHelper helper = new MozoHelper();
        Mozo projectDetail = helper.findById(id.intValue());
        return projectDetail;
    }
}
