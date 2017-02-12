/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;


/**
 *
 * @author Alfredo Mariño
 */
public class comboBox {
    private String id;
    private String descripcion;
    
    
    public comboBox(String id, String descripcion){
        this.setId(id);
        this.setDescripcion(descripcion);
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getId(){
        return id;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
}
