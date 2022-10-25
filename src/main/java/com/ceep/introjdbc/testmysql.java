/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceep.introjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class testmysql {
   
    public static void main(String[] args) {
       
        //Defino la url de conexión a nuestra base de datos y sus parámetros
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false"+
                "&useTimezone=true&serverTimezone=UTC"
                + "&allowPublicKeyRetrieval=true";
       
        try {
            //Ahora tratamos de establecer la conexión con nuestra base de datos
            Connection conexion = DriverManager.getConnection(url,"root","1234");
            
            //Creo un statement para poder ejecutar mis consultas SQL
            Statement instruccion = conexion.createStatement();
           //Defino mi consulta SQL
            String sql = "SELECT * FROM persona";
           
            //Ejecuto la instrucción
            ResultSet resultado = instruccion.executeQuery(sql);
           //Mientras haya algo en resultado, muestro la informacion iterando
            while(resultado.next()){
                System.out.println("Id.Persona:"+resultado.getInt("idpersona"));
                System.out.println("Nombre:"+resultado.getString("nombre"));
                System.out.println("Apellidos:"+resultado.getString("apellidos"));
                System.out.println("Email::"+resultado.getString("email"));
                System.out.println("Teléfono:"+resultado.getString("tlfno"));
            }
        resultado.close();
        instruccion.close();
        conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
               

       
    }
   
}