package control.vista.reporte;

import control.dao.CategoriaTipoDao;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.reporte.CategoriaTipo;

import java.net.URL;
import java.util.ResourceBundle;

public class ReporteController implements Initializable {
    public TableView<CategoriaTipo> tblDatos;
    public TableColumn<CategoriaTipo, Long> colIdCat;
    public TableColumn<CategoriaTipo, String> colNomCat;
    public TableColumn<CategoriaTipo, String> colDescCat;
    public TableColumn<CategoriaTipo, Long> colIdTip;
    public TableColumn<CategoriaTipo, String> colNomTip;
    public TableColumn<CategoriaTipo, String> colDescTip;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colIdCat.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        colNomCat.setCellValueFactory(new PropertyValueFactory<>("nombreCategoria"));
        colIdTip.setCellValueFactory(new PropertyValueFactory<>("idTipo"));
        colNomTip.setCellValueFactory(new PropertyValueFactory<>("nombreTipo"));
        cargarDatos();
    }

    private void cargarDatos() {
        tblDatos.getItems().addAll(CategoriaTipoDao.listar());
    }
}
