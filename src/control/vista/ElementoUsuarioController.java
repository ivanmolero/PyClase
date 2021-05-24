package control.vista;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modelo.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementoUsuarioController implements Initializable {
    public TextField txtNombre;
    private Usuario usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void accion(ActionEvent actionEvent) {
        System.out.println("nombre: " + txtNombre.getText());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        txtNombre.setText(usuario.getLogin());
    }
}
