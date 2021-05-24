package control.vista;

import control.dao.UsuarioDao;
import control.utilidad.Encripta;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class MantenimientoUsuarioDetalleController implements Initializable {
    public TextField txtId;
    public TextField txtLogin;
    public PasswordField txtContrasena;
    public Button btnAceptar;
    private Usuario usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtId.setDisable(true);
        btnAceptar.disableProperty().bind(
                txtLogin.textProperty().length().lessThan(3).or(
                        txtContrasena.textProperty().length().lessThan(3)
                ));
    }

    public void aceptar(ActionEvent actionEvent) {
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setLogin(txtLogin.getText());
            usuario.setContrasena(Encripta.encripta(txtContrasena.getText()));
            UsuarioDao.crear(usuario);
        } else {
            usuario.setLogin(txtLogin.getText());
            usuario.setContrasena(Encripta.encripta(txtContrasena.getText()));
            UsuarioDao.editar(usuario);
        }
        cancelar(actionEvent);
    }

    public void cancelar(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtId.setText(String.valueOf(usuario.getId()));
        txtLogin.setText(usuario.getLogin());
        txtContrasena.setText(usuario.getContrasena());
    }
}
