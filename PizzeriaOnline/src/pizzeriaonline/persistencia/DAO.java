package pizzeriaonline.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {
    
    // ADMINISTRAR LA CONEXIÓN
    protected Connection conexion = null;
    // MANIPULAR SQL NATIVO
    protected Statement sentencia = null;
    // PERMITE CREAR UNA COPIA DE LOS REGISTROS = RESULTADOS DE QUERY
    protected ResultSet resultado = null;
 
    private final String USUARIO = "root";
    private final String CLAVE = "root";
//    private final String NOMBRE = "pizzeria";
    
    
    private final String CONTROLADOR = "com.mysql.jdbc.Driver";
    // APACHE : com.mysql.cj.jdbc.Driver
    
//    private final String URL = "jdbc:mysql://localhost:3306/" + NOMBRE + "?useSSL=false";
    private final String URL = "jdbc:mysql://localhost:3306/pizzeria1?useSSL=false";

    protected void conectarBase() throws Exception{
       try {
            // CARGAR EL CONTROLADOR
            Class.forName(CONTROLADOR);
            
            // CREO LA CONEXION
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
       } catch (Exception e){
           e.printStackTrace();
           throw new Exception ("NO CONECTA LA BASE");
       }
    }

    protected void desconectarBase() throws Exception {
        try {
            //VERIFICO QUE NO SEAN NULOS, SI SON NULOS LA CONEXIÓN NO SE REALIXÓ, ¿Y PA QUÉ VOY A DESCONECTÁ?
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {            
            throw new Exception("Error al desconectarse");
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            //CONECTO A LA BASE
            conectarBase();
            
            //NOS PERMITE CREAR EL OBJETO SENTENCIA QUE ALOJARA NUESTRA QUERY
            sentencia = conexion.createStatement();
            
            //EJECUTO LA QUERY (sql) QUE LE PASO POR PARÁMETRO
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("ERROR AL REALIZAR LA CONEXION A LA BASE DE DATOS");
            }
            throw new Exception("ERROR AL EJECUTAR SENTENCIA");
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            //CONECTO A LA BASE
            conectarBase();
            //INSTANCIAMOS EL OBJETO SENTENCIA PARA QUE PUEDA ALMACENAR NUESTRA QUERY SQL
            sentencia = conexion.createStatement();
            //RECIBE EL RESULTADO DE LA QUERY
            resultado = sentencia.executeQuery(sql);
            //IMPRIMIMOS EL RESULTADO
            System.out.println(resultado);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error al realizar la consulta");
        } 
    }
    

}
