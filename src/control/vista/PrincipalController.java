package control.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.repositorio.Persistencia;
import org.eclipse.persistence.jpa.PersistenceProvider;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {
    public HBox hboxPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrarUsuario(ActionEvent actionEvent) {
        if (hboxPrincipal.getChildren().size() > 1) {
            hboxPrincipal.getChildren().remove(1);
        }
        if (((ToggleButton)actionEvent.getSource()).isSelected()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vista/mantenimientoUsuario.fxml"));
                hboxPrincipal.getChildren().add(root);

                ((VBox)root).prefHeightProperty().bind(hboxPrincipal.heightProperty());
                ((VBox)root).prefWidthProperty().bind(hboxPrincipal.widthProperty().subtract(200));
            } catch (IOException ioException) {

            }
        }
    }

    public void mostrarTipo(ActionEvent actionEvent) {
        System.out.println("usuario: " + Persistencia.getInstancia().getUsuario().getLogin());
        if (hboxPrincipal.getChildren().size() > 1) {
            hboxPrincipal.getChildren().remove(1);
        }
        if (((ToggleButton)actionEvent.getSource()).isSelected()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vista/mantenimientoTipo.fxml"));
                hboxPrincipal.getChildren().add(root);

                ((VBox)root).prefHeightProperty().bind(hboxPrincipal.heightProperty());
                ((VBox)root).prefWidthProperty().bind(hboxPrincipal.widthProperty().subtract(200));
            } catch (IOException ioException) {

            }
        }
    }

    public void mostrarCategoria(ActionEvent actionEvent) {
        if (hboxPrincipal.getChildren().size() > 1) {
            hboxPrincipal.getChildren().remove(1);
        }
        if (((ToggleButton)actionEvent.getSource()).isSelected()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/vista/mantenimientoCategoria.fxml"));
                hboxPrincipal.getChildren().add(root);

                ((VBox)root).prefHeightProperty().bind(hboxPrincipal.heightProperty());
                ((VBox)root).prefWidthProperty().bind(hboxPrincipal.widthProperty().subtract(200));
            } catch (IOException ioException) {

            }
        }
    }

    public void mostrar01(ActionEvent actionEvent) {
    }

    public void mostrar02(ActionEvent actionEvent) {
    }

}
