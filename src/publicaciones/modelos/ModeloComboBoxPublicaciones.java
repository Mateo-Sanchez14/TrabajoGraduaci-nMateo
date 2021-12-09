/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import java.util.List;
import javax.swing.DefaultComboBoxModel;


public class ModeloComboBoxPublicaciones<T> extends DefaultComboBoxModel {
    
    public ModeloComboBoxPublicaciones(List<T> lista){
        for(T aux: lista){
            this.addElement(aux);
        }
    }
    
    public T ObtenerCaracteristicadelaPublicacion(){
        return (T)this.getSelectedItem();
    }
    
    public void seleccionarCargo(T t){
        this.setSelectedItem(t);
    }
}
