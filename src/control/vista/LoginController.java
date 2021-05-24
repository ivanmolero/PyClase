package control.vista;

import com.mysql.cj.conf.IntegerProperty;
import control.dao.UsuarioDao;
import control.utilidad.Encripta;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelo.Usuario;
import modelo.repositorio.Persistencia;
import org.eclipse.persistence.jpa.jpql.parser.RegexpExpression;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    public TextField txtUsuario;
    public PasswordField txtContrasena;
    public Button btnAceptar;

    @Override
    public void initialize(URL uzrl, ResourceBundle resourceBundle) {
//        txtUsuario.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String t1, String t2) {
//                Pattern base = Pattern.compile("^[0-9]+([.][0-9]+)?$");
//                System.out.println("cadena: " + t2);
//                System.out.println("evalua: " + base.matcher(t2).matches());
//
//                if (!base.matcher(t2).matches() && !t2.isEmpty()){
//                    txtUsuario.setText(t1);
//                }
//            }
//        });

//        Bindings.bindBidirectional(txtUsuario.textProperty(), btnAceptar.disableProperty(), new StringConverter<Boolean>() {
//            @Override
//            public String toString(Boolean aBoolean) {
//                return null;
//            }
//
//            @Override
//            public Boolean fromString(String s) {
//                try {
//                    int numero = Integer.parseInt(s);
//                    return numero <= 0;
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        });
    }

    public void aceptar(ActionEvent actionEvent) {
        Usuario usuario = UsuarioDao.buscarLogin(txtUsuario.getText().trim());
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle("Autenticación");
        mensaje.setHeaderText("Usuario o contraseña no validos");
        if (usuario != null) {
            boolean valida = usuario.getContrasena().equals(Encripta.encripta(txtContrasena.getText()));
            if (valida) {
                try {
                    Stage stage = new Stage();
                    Parent root = null;
                    root = FXMLLoader.load(getClass().getResource("/vista/principal.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    Persistencia.getInstancia().setUsuario(usuario);
                    cancelar(actionEvent);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    //e.printStackTrace();
                }
            } else {
                mensaje.show();
            }

        } else {
            mensaje.show();
        }
    }

    public void cancelar(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }
}
