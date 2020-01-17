/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante 2018
 * @param <T>
 */
public class Conexion {
//    public static void main(String[] args) {
//      
//        objectpool objecpool = new objectpool();
//        PooleObject PooleObject = objecpool.getPooleObject();
//        objecpool.releasePoolObject(PooleObject);
//    }
//}


    private static final String URL = "jdbc:mysql://localhost:3306/triliapp?user=root";
    private static final String DATA_BASE = "mysql";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection link = null;

    public Conexion() {
    }

    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexion Drive Correcto");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

        String path = URL + DATA_BASE;
        link = DriverManager.getConnection(path, USER, PASSWORD);
        return link;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
// ejemplo object pool

// class PooleObject {
//     
// }
//    class objectpool{
//        List<PooleObject> free = new LinkedList<>();
//        List<PooleObject> used = new LinkedList<>();
//        
//        public PooleObject getPooleObject(){
//            if(free.isEmpty()){
//                PooleObject PooleObject = new PooleObject();
//                free.add(PooleObject);
//                return PooleObject;
//            }else {
//                PooleObject PooleObject = free.get(0);
//                used.add(PooleObject);
//                free.remove(PooleObject);
//                return PooleObject;
//            } 
//        }
//        public void releasePoolObject(PooleObject PooleObject) {
//            used.remove(PooleObject);
//            free.add(PooleObject);
//        }
//    }
//    
  
