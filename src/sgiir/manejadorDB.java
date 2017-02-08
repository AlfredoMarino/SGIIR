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
public class manejadorDB {
    
    private manejadorDB() {
    }
    
    public static manejadorDB getInstance() {
        return manejadorDBHolder.INSTANCE;
    }
    
    private static class manejadorDBHolder {

        private static final manejadorDB INSTANCE = new manejadorDB();
    }
}
