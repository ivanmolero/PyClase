package control.vista;

import control.dao.TipoDao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modelo.Tipo;

import java.net.URL;
import java.util.ResourceBundle;

public class MantenimientoTipoDetalleController implements Initializable {
    public Label lblTitulo;
    public TextField txtId;
    public TextField txtNombre;
    public TextArea txtDescripcion;
    public Button btnAceptar;
    private Tipo tipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtId.setDisable(true);
        btnAceptar.disableProperty().bind(
                txtNombre.textProperty().length().lessThan(3).or(
                        txtDescripcion.textProperty().length().lessThan(3)
                ));
    }

    public void aceptar(ActionEvent actionEvent) {
        if (tipo == null) {
            tipo = new Tipo();
            tipo.setNombre(txtNombre.getText());
            tipo.setDescripcion(txtDescripcion.getText());
            TipoDao.crear(tipo);
        } else {
            tipo.setNombre(txtNombre.getText());
            tipo.setDescripcion(txtDescripcion.getText());
            TipoDao.editar(tipo);
        }
        cancelar(actionEvent);
    }

    public void cancelar(ActionEvent actionEvent) {
        ((Stage)((Node)actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtId.setText(String.valueOf(tipo.getId()));
        txtNombre.setText(tipo.getNombre());
        txtDescripcion.setText(tipo.getDescripcion());
    }
}
