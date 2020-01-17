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
public class MyHelper {

    MyHelper(){
        
    }
    public void validarcontraseniaUsu (String contraseniaUsu) throws CustomExeption{
       if(contraseniaUsu.length()<6){
           throw new CustomExeption("La contraseña no es lo suficiente mente larga");
       } 
    }
    }
    

