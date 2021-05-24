package control.vista;

import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MostrarUsuarioController implements Initializable {
    public FlowPane contenedor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void agregarElemento(VBox elemento){
        contenedor.getChildren().add(elemento);
    }
}
