/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triliapptest1;

/**
 *
 * @author Alejandro
 */
public class CustomExeption  extends Exception{

    public static final long serialVersionUID = 700L;
    
    public CustomExeption(String Mensaje) {
   super(Mensaje);
    }

    
}
