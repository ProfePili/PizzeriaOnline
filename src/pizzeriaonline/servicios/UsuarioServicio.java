package pizzeriaonline.servicios;

import pizzeriaonline.entidades.Usuario;
import pizzeriaonline.persistencia.UsuarioDAO;

public class UsuarioServicio {

    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(String email, String nombre, String apellido, Integer edad) throws Exception {

        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new Exception("CORREO NO VÁLIDO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("NOMBRE NO VÁLIDO");
            }

            if (apellido == null | apellido.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN APELLIDO");
            }

            if (edad == null | edad < 18) {
                throw new Exception("DEBE SER MAYOR DE EDAD");
            }

            // CREO UNA INSTANCIA DE USUARIO
            Usuario usuario = new Usuario();

            //SETEO LOS VALORES
            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEdad(edad);

            usuarioDAO.guardarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) throws Exception {
        try {
            //VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new Exception("CORREO NO VÁLIDO");
            }

           // EL MÉTODO buscarPorEmail() NO RETORNA UN OBJETO USUARIO QUE RETORNAREMOS NUEVAMENTE
            return usuarioDAO.buscarPorEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo buscar el usuario");
        }
    }
}
