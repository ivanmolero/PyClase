package control.vista;

import control.dao.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MantenimientoUsuarioController implements Initializable {
    public Button btnEditar;
    public Button btnEliminar;
    public TableView<Usuario> tblUsuario;
    public TableColumn<Usuario, Long> colId;
    public TableColumn<Usuario, String> colUsuario;
    public TableColumn<Usuario, String> colContrasena;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarDatos();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
        colContrasena.setCellValueFactory((new PropertyValueFactory<>("contrasena")));
        btnEditar.disableProperty().bind(tblUsuario.getSelectionModel().selectedItemProperty().isNull());
        btnEliminar.disableProperty().bind(btnEditar.disableProperty());
    }

    private void cargarDatos() {
        tblUsuario.getItems().clear();
        tblUsuario.getItems().addAll(UsuarioDao.listar());
    }

    public void nuevo(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mantenimientoUsuarioDetalle.fxml", true);
        Stage stage = (Stage)datos.get("escenario");
        stage.showAndWait();
        cargarDatos();
    }

    public Map escenario(String path, boolean crearStage) {
        Stage stage = null;
        Initializable controlador = null;
        Parent root = null;
        try {
            FXMLLoader cargador = new FXMLLoader(getClass().getResource(path));
            root = cargador.load();
            controlador = cargador.getController();
            if (crearStage) {
                Scene scene = new Scene(root);
                stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        Map salida = new HashMap();
        salida.put("escenario", stage);
        salida.put("controlador", controlador);
        salida.put("nodo", root);
        return salida;
    }

    public void editar(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mantenimientoUsuarioDetalle.fxml", true);
        MantenimientoUsuarioDetalleController controlador = (MantenimientoUsuarioDetalleController) datos.get("controlador");
        controlador.setUsuario(tblUsuario.getSelectionModel().getSelectedItem());
        ((Stage)datos.get("escenario")).showAndWait();
        cargarDatos();
    }

    public void eliminar(ActionEvent actionEvent) {
    }

    public void verElementos(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mostrarUsuario.fxml", true);
        MostrarUsuarioController controlador = (MostrarUsuarioController) datos.get("controlador");
        for (Usuario usuario: UsuarioDao.listar()) {
            Map elementos = escenario("/vista/elementoUsuario.fxml", false);
            ElementoUsuarioController controladorElemento = (ElementoUsuarioController) elementos.get("controlador");
            controladorElemento.setUsuario(usuario);
            controlador.agregarElemento((VBox) elementos.get("nodo"));
        }
        ((Stage)datos.get("escenario")).showAndWait();
    }
}
