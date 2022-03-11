package pizzeriaonline.persistencia;

import pizzeriaonline.entidades.Usuario;

public class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {

        try {
            // VALIDACION
            if (usuario == null) {
                throw new Exception("USUARIO NO VÁLIDO");
            }

            // QUERY SQL NATIVO PARA CARGAR UN REGISTRO A UNA TABLA
            // CONCATENAMOS LOS VALORES DEL NUEVO OBJETO A CARGAR
            String sql = "INSERT INTO usuario "
                    + "VALUES('" + usuario.getEmail()
                    + "', '" + usuario.getNombre() + "', '" + usuario.getApellido()
                    + "', " + usuario.getEdad() + ");";

            // LLAMO AL MÉTODO DEL DAO PADRE QUE ME PERMITE HACER CONSULTAS DDL
            insertarModificarEliminar(sql);
            
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Usuario buscarPorEmail(String email) throws Exception {

        try {
            // Esta es una estrategia para ver que la query quede bien armada
            //SELECT * FROM usuario WHERE correo LIKE "persona1@egg.com";
            String sql = "SELECT * FROM usuario WHERE correo LIKE '"
                    + email + "';";

            // Esta es otra estrategia para ver si la query está bien armada
//            System.out.println(sql);
            
            consultarBase(sql);
            
            Usuario usuario = null;
            
            // EL MÉTODO resultado.next() DEVUELVE UN BOOLEANO SI EN LOS RESULTADOS QUE ARROJA NUESTRA
            // QUERY EXISTE UN SIGUIENTE REGISTRO
            while (resultado.next()) {
                usuario = new Usuario(); //instanciamos un nuevo objeto donde guardaremos nuestro registro encontrado
                // SETEAMOS LOS VALORES (hacemos una copia del registro)
                usuario.setEmail(resultado.getString(1)); // entre paréntesis se indica con un número entero la posición de columna que ocupa el valor
                usuario.setNombre(resultado.getString(2));
                usuario.setApellido(resultado.getString(3));
                usuario.setEdad(resultado.getInt(4));
            }

            return usuario; // retornamos el objeto que hemos seteado con los resultados de la query armada
        } catch (Exception e) {
            e.getStackTrace(); //nos imprime la pila de llamadas que hace la JVM al encontrar un error, nos sirve para encontrar dónde se originó
            throw new Exception("NO SE PUDO REALIZAR LA CONSULTA");
        }
    }

}
