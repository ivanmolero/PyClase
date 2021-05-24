package control.vista;

import control.dao.CategoriaDao;
import control.dao.TipoDao;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import modelo.Categoria;
import modelo.Tipo;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MantenimientoCategoriaController implements Initializable {
    public Button btnEditar;
    public Button btnEliminar;
    public TableView<Categoria> tblCategoria;
    public TableColumn<Categoria, Long> colId;
    public TableColumn<Categoria, String> colNombre;
    public TableColumn<Categoria, String> colDescripcion;
    public TableColumn<Categoria, String> colTipo;
    public ComboBox<Tipo> cmbTipo;
    public ComboBox<Categoria> cmbCategoria;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarDatos();
        cargarCombos();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory((new PropertyValueFactory<>("descripcion")));
        btnEditar.disableProperty().bind(tblCategoria.getSelectionModel().selectedItemProperty().isNull());
        btnEliminar.disableProperty().bind(btnEditar.disableProperty());
        colTipo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Categoria, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Categoria, String> categoriaStringCellDataFeatures) {
                ReadOnlyObjectWrapper salida = new ReadOnlyObjectWrapper(
                        categoriaStringCellDataFeatures.getValue().getPerteneceTipo().getNombre()
                );
                return salida;
            }
        });
        cmbTipo.setConverter(new StringConverter<Tipo>() {
            @Override
            public String toString(Tipo tipo) {
                if (tipo != null)
                    return tipo.getNombre();
                return null;
            }

            @Override
            public Tipo fromString(String s) {
                return null;
            }
        });
        cmbCategoria.setConverter(new StringConverter<Categoria>() {
            @Override
            public String toString(Categoria categoria) {
                if (categoria != null) {
                    return categoria.getNombre();
                }
                return null;
            }

            @Override
            public Categoria fromString(String s) {
                return null;
            }
        });

    }

    private void cargarCombos() {
        cmbTipo.getItems().addAll(TipoDao.listar());
        //cmbCategoria.getItems().addAll(CategoriaDao.listar());
    }

    private void cargarDatos() {
        tblCategoria.getItems().clear();
        tblCategoria.getItems().addAll(CategoriaDao.listar());
    }

    public void nuevo(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mantenimientoCategoriaDetalle.fxml");
        Stage stage = (Stage)datos.get("escenario");
        stage.showAndWait();
        cargarDatos();
    }

    public Map escenario(String path) {
        Stage stage = new Stage();
        MantenimientoCategoriaDetalleController controlador = null;
        try {
            FXMLLoader cargador = new FXMLLoader(getClass().getResource(path));
            Parent root = cargador.load();
            controlador = cargador.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        Map salida = new HashMap();
        salida.put("escenario", stage);
        salida.put("controlador", controlador);
        return salida;
    }


    public void editar(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mantenimientoCategoriaDetalle.fxml");
        MantenimientoCategoriaDetalleController controlador = (MantenimientoCategoriaDetalleController) datos.get("controlador");
        controlador.setCategoria(tblCategoria.getSelectionModel().getSelectedItem());
        ((Stage)datos.get("escenario")).showAndWait();
        cargarDatos();
    }

    public void eliminar(ActionEvent actionEvent) {
    }

    public void seleccionaTipo(ActionEvent actionEvent) {
        Tipo seleccionado = cmbTipo.getSelectionModel().getSelectedItem();
        cmbCategoria.getItems().clear();
        cmbCategoria.getItems().addAll(CategoriaDao.listarTipo(seleccionado));
    }
}
