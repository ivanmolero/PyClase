package control.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MantenimientoCategoriaDetalle2Controller implements Initializable {
    public TextField txtId;
    public TextField txtNombre;
    public TextArea txtDescripcion;
    public TextField txtTipo;
    public Button btnAceptar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void aceptar(ActionEvent actionEvent) {
    }

    public void cancelar(ActionEvent actionEvent) {
    }

    public void buscar(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader cargador = new FXMLLoader(getClass().getResource("/vista/busqueda.fxml"));
            Parent root = cargador.load();
            BuscarController controlador = cargador.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
