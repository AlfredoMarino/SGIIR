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
    private int id;
    private String descripcion;
    
   // public comboBox(){

    //}
    
    public comboBox(int id, String descripcion){
        this.setId(id);
        this.setDescripcion(descripcion);
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getId(){
        return id;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String toString(){
        return descripcion;
    }
    
}
