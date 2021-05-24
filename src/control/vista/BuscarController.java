package control.vista;

import control.dao.TipoDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Tipo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BuscarController implements Initializable {
    public TextField txtFiltro;
    public TableView<Tipo> tblElementos;
    public TableColumn<Tipo, Long> colId;
    public TableColumn<Tipo, String> colNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        txtFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldText, String newText) {
//                if (newText.length() >= 3) {
//                    List<Tipo> datos = TipoDao.buscarNombre("%" + newText.trim() + "%");
//                    cargarTabla(datos);
//                }
                try {
                    long valor = Long.parseLong(newText);
                } catch (Exception e) {
                    if (newText.length() > 0) {
                        txtFiltro.setText(oldText);
                    }
                }
            }
        });
    }

    public void buscar(ActionEvent actionEvent) {
        List<Tipo> datos = TipoDao.buscarNombre("%" + txtFiltro.getText().trim() + "%");
        cargarTabla(datos);
    }

    private void cargarTabla(List<Tipo> datos){
        tblElementos.getItems().clear();
        tblElementos.getItems().addAll(datos);
    }

    public void aceptar(ActionEvent actionEvent) {
    }

    public void cancelar(ActionEvent actionEvent) {
    }
}
