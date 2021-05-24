package control.vista;

import control.dao.CategoriaDao;
import control.dao.TipoDao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelo.Categoria;
import modelo.Tipo;
import modelo.Categoria;
import modelo.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class MantenimientoCategoriaDetalleController implements Initializable {
    public Label lblTitulo;
    public TextField txtId;
    public TextField txtNombre;
    public TextArea txtDescripcion;
    public ComboBox<Tipo> cmbTipo;
    public Button btnAceptar;
    private Categoria categoria;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtId.setDisable(true);
        btnAceptar.disableProperty().bind(
                txtNombre.textProperty().length().lessThan(3).or(
                        txtDescripcion.textProperty().length().lessThan(3)).or(
                                cmbTipo.valueProperty().isNull()
                )
        );
        cargarDatos();
        cmbTipo.setConverter(new StringConverter<Tipo>() {
            @Override
            public String toString(Tipo tipo) {
                if (tipo == null)
                    return null;
                return tipo.getNombre();
            }

            @Override
            public Tipo fromString(String s) {
                return null;
            }
        });
    }

    public void aceptar(ActionEvent actionEvent) {
        if (categoria == null) {
            categoria = new Categoria();
            categoria.setNombre(txtNombre.getText());
            categoria.setDescripcion(txtDescripcion.getText());
            categoria.setPerteneceTipo(cmbTipo.getValue());
            CategoriaDao.crear(categoria);
        } else {
            categoria.setNombre(txtNombre.getText());
            categoria.setDescripcion(txtDescripcion.getText());
            categoria.setPerteneceTipo(cmbTipo.getValue());
            CategoriaDao.editar(categoria);
        }
        cancelar(actionEvent);
    }

    public void cancelar(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtId.setText(String.valueOf(categoria.getId()));
        txtNombre.setText(categoria.getNombre());
        txtDescripcion.setText(categoria.getDescripcion());
        cmbTipo.getSelectionModel().select(categoria.getPerteneceTipo());
        lblTitulo.setText("Edición de Categoria");
    }

    private void cargarDatos() {
        cmbTipo.getItems().addAll(TipoDao.listar());
    }

}
