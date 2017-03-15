/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */
public class programadorSugerido {
    public List<Persona> programadorDesocupado = new ArrayList<Persona>();
    public List<Persona> programadorIndicado = new ArrayList<Persona>();
    
    public static class Persona implements Comparable<Persona> {

        public String nombrePersona;
        public int codigoPersona, match;

        public Persona(int codigo, int matchCounter, String nombre) {
            this.codigoPersona = codigo;
            this.match = matchCounter;
            this.nombrePersona = nombre;
        }
        public int getMatch(){
            return match;
        }        
        
        @Override
        public int compareTo(Persona o) {
            if (match < o.match) {
                return -1;
            }
            if (match > o.match) {
                return 1;
            }
            return 0;
        }
    }
    
    public List<Persona> programadorDisponible(){
        programadorDesocupado.clear();
        try {
            //busca los programadores involucrados en tareas
            String qryProgramadoresInvolucrados = "SELECT `involucrado`.`CodigoNaturaleza`, `involucrado`.`CodigoTarea`, "
                    + "`involucrado`.`CodigoInvolucrado`, `persona`.`NombrePersona`, `persona`.`CodigoPersona` "
                    + "FROM `involucrado` "
                    + "INNER JOIN `persona` ON `involucrado`.`CodigoPersona` = `persona`.`CodigoPersona` "
                    + "INNER JOIN `autenticacion` ON `persona`.`CodigoPersona` = `autenticacion`.`CodigoPersona` "
                    + "WHERE (( `NivelAutenticacion` = 4))  "
                    + "ORDER BY `persona`.`CodigoPersona` ASC, `involucrado`.`CodigoNaturaleza` ASC, `involucrado`.`CodigoTarea` ASC, "
                    + "`involucrado`.`CodigoInvolucrado`  DESC";
            
            Statement stPI = Conexion.prepareCall(qryProgramadoresInvolucrados);
            
            ResultSet rsPI = stPI.executeQuery(qryProgramadoresInvolucrados);
            
            int naturalezaAnterior = 0;
            int tareaAnterior = 0; 
            int personaAnterior = 0;
            int ultimaPersonaAgregada = 0;
            String ultimoNombreAgregado = "";
            String NombrePersonaAnterior = "";
            int count = 0;
            int i = 0;
            //de los involucrados se buscan solo las tareas inconclusas
            while(rsPI.next()){

                //si es una persona distinta reinicia el contador
                if(ultimaPersonaAgregada != rsPI.getInt("CodigoPersona")){
                    if(ultimaPersonaAgregada != 0){
                        programadorDesocupado.add(new Persona(ultimaPersonaAgregada, count, ultimoNombreAgregado));
                        
                    }
                    ultimaPersonaAgregada = rsPI.getInt("CodigoPersona");
                    ultimoNombreAgregado = rsPI.getString("NombrePersona");
                    count = 0;
                }   

                    
                //busca una sola tarea
                if((naturalezaAnterior != rsPI.getInt("CodigoNaturaleza")) || 
                        (tareaAnterior != rsPI.getInt("CodigoTarea")) ||
                        (personaAnterior != rsPI.getInt("CodigoPersona"))){
                    

                    personaAnterior = rsPI.getInt("CodigoPersona");
                    NombrePersonaAnterior = rsPI.getString("NombrePersona");
                    

                    //PARA QUE NO REPITA LA TAREA
                    naturalezaAnterior = rsPI.getInt("CodigoNaturaleza");
                    tareaAnterior = rsPI.getInt("CodigoTarea"); 
                    

                    String qryTareasInconclusas = "SELECT `tarea`.`CodigoNaturaleza`, "
                            + "`tarea`.`CodigoTarea` "
                           + "FROM `tarea` "
                           + "WHERE (( `FechaFinalizacionTarea`IS null and CodigoNaturaleza = ?"
                            + " and CodigoTarea = ?))"; 
                    PreparedStatement psTI = Conexion.prepareCall(qryTareasInconclusas);
                    psTI.setInt(1, naturalezaAnterior);
                    psTI.setInt(2, tareaAnterior);

                    ResultSet rsTI = psTI.executeQuery();
                    if(rsTI.absolute(1)){
                        //SI SE ENCONTRO UNA TAREA INCONCLUSA BUSCA SU ULTIMA BITACORA Y VERIFICA SI LA PERSONA ESTA INVOLUCRADO A ESTE ULTIMO
                        String qryUltimaBitacora = "SELECT * FROM `bitacora` "
                                + "WHERE CodigoNaturaleza = ? AND CodigoTarea = ? "
                                + "ORDER BY `bitacora`.`CodigoNaturaleza` ASC, `bitacora`.`CodigoTarea` ASC, "
                                + "`bitacora`.`CorrelativoBitacora`  DESC "
                                + "LIMIT 1";
                        PreparedStatement psUB = Conexion.prepareCall(qryUltimaBitacora);
                        psUB.setInt(1, naturalezaAnterior);
                        psUB.setInt(2, tareaAnterior);

                        ResultSet rsUB = psUB.executeQuery();
                        if(rsUB.absolute(1)){
                            if(rsUB.getInt("CodigoInvolucrado") == rsPI.getInt("CodigoInvolucrado")){
                                count ++;
                            }
                        }
                    }
                }
            }
            programadorDesocupado.add(new Persona(ultimaPersonaAgregada, count, ultimoNombreAgregado));
            
        } catch (SQLException ex) {
            Logger.getLogger(programadorSugerido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return programadorDesocupado;
        
    }
    
    public List<Persona> programadorEspecialista(List<Integer> Areas){
        programadorIndicado.clear();
        try {
            String qryProgramadoresInvolucrados = "SELECT `involucrado`.`CodigoNaturaleza`, "
                    + "`involucrado`.`CodigoTarea`, `persona`.`NombrePersona`, "
                    + "`persona`.`CodigoPersona` "
                    + "FROM `involucrado` "
                    + "INNER JOIN `persona` ON `involucrado`.`CodigoPersona` = `persona`.`CodigoPersona` "
                    + "INNER JOIN `autenticacion` ON `persona`.`CodigoPersona` = `autenticacion`.`CodigoPersona` "
                    + "WHERE (( `NivelAutenticacion` = 4))  "
                    + "GROUP BY CodigoNaturaleza, CodigoTarea, involucrado.CodigoPersona  "
                    + "ORDER BY `persona`.`CodigoPersona` ASC, `involucrado`.`CodigoNaturaleza` ASC, "
                    + "`involucrado`.`CodigoTarea` ASC";
            
            Statement stPI = Conexion.prepareCall(qryProgramadoresInvolucrados);
            
            ResultSet rsPI = stPI.executeQuery(qryProgramadoresInvolucrados);
            
            int ultimaPersonaAgregada = 0;
            String ultimoNombreAgregado = "";
            int count = 0;
            
            while(rsPI.next()){
                
                //si es una persona distinta reinicia el contador
                if(ultimaPersonaAgregada != rsPI.getInt("CodigoPersona")){
                    if(ultimaPersonaAgregada != 0){
                        programadorIndicado.add(new Persona(ultimaPersonaAgregada, count, ultimoNombreAgregado));
                        
                    }
                    ultimaPersonaAgregada = rsPI.getInt("CodigoPersona");
                    ultimoNombreAgregado = rsPI.getString("NombrePersona");
                    count = 0;
                }  
                
                String qryCaracteristica = "SELECT * FROM `caracteristica` "
                        + "where CodigoNaturaleza = ? and CodigoTarea = ?"; 
                    PreparedStatement psC = Conexion.prepareCall(qryCaracteristica);
                    psC.setInt(1, rsPI.getInt("CodigoNaturaleza"));
                    psC.setInt(2, rsPI.getInt("CodigoTarea"));

                    ResultSet rsC = psC.executeQuery();
                    while(rsC.next()){
                        if(comparaAreas(rsC.getInt("CodigoArea"), Areas)){
                            count ++;
                        }
                    }
            }
            
            programadorIndicado.add(new Persona(ultimaPersonaAgregada, count, ultimoNombreAgregado));
        } catch (SQLException ex) {
            Logger.getLogger(programadorSugerido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return programadorIndicado;
    }
    
    public boolean comparaAreas(int area, List<Integer> Caracteristica){
        for(int c : Caracteristica){
            if(area == c){
                return true;
            }
        }
        return false;
    }
    
    public List<Persona> programadorEspecialistaSugerido(int Naturaleza, int Tarea){
        programadorIndicado.clear();
        List<Integer> listaAreas = new ArrayList<>();
        
        try {    
            String qryCaracteristica = "SELECT * FROM `caracteristica` "
                    + "where CodigoNaturaleza = ? and CodigoTarea = ?";
            PreparedStatement psC = Conexion.prepareCall(qryCaracteristica);
            psC.setInt(1, Naturaleza);
            psC.setInt(2, Tarea);
            
            ResultSet rsC = psC.executeQuery();
            while(rsC.next()){
                listaAreas.add(rsC.getInt("CodigoArea"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(programadorSugerido.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(listaAreas.size() > 0){
            return programadorEspecialista(listaAreas);
        }else{
            return programadorIndicado;
        }
        
    }
    
}
