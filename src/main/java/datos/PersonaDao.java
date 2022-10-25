/*
El conjunto de operaciones que yo voy  apoder realizar sobre una persona
 */
package datos;

import Dominio.Persona;
import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class PersonaDao {
    
    private static final String SQL_SELECT="SELECT * FROM persona";
    
    public List<Persona> seleccionar() throws SQLException{
        //Inicializo mis variables 
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                Persona persona = null;
                List<Persona> personas = new ArrayList<>();
                
                conn = getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    int idpersona= rs.getInt("idpersona");
                    String nombre=rs.getString("nombre");
                    String apellidos=rs.getString("apellidos");
                    String email=rs.getString("email");
                    String tlfno=rs.getString("tlfno");
                    
                    //Instancio un nuevo objeto
                    
                    personas.add(new Persona(idpersona, nombre, apellidos, email, tlfno));
                    
                }
                
                close(rs);
                close(stmt);
                close(conn);
                
                return personas;
                
    }
    
}
