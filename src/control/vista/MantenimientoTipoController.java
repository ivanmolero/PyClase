package control.vista;

import control.dao.TipoDao;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Tipo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MantenimientoTipoController implements Initializable {
    public Button btnEditar;
    public Button btnEliminar;
    public TableView<Tipo> tblTipo;
    public TableColumn<Tipo, Long> colId;
    public TableColumn<Tipo, String> colNombre;
    public TableColumn<Tipo, String> colDescripcion;
    public TableColumn<Tipo, Integer> colCats;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarDatos();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory((new PropertyValueFactory<>("descripcion")));
        colCats.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Tipo, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Tipo, Integer> tipoIntegerCellDataFeatures) {
                ReadOnlyObjectWrapper salida = new ReadOnlyObjectWrapper(
                        tipoIntegerCellDataFeatures.getValue().getAgrupaCategorias().size()
                );
                return salida;
            }
        });
        btnEditar.disableProperty().bind(tblTipo.getSelectionModel().selectedItemProperty().isNull());
        btnEliminar.disableProperty().bind(btnEditar.disableProperty());
    }

    private void cargarDatos() {
        tblTipo.getItems().clear();
        tblTipo.getItems().addAll(TipoDao.listar());
    }

    public void nuevo(ActionEvent actionEvent) {
        Map datos = escenario("/vista/mantenimientoTipoDetalle.fxml");
        Stage stage = (Stage)datos.get("escenario");
        stage.showAndWait();
        cargarDatos();
    }

    private Map escenario(String path) {
        Stage stage = new Stage();
        MantenimientoTipoDetalleController controlador = null;
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
        Map datos = escenario("/vista/mantenimientoTipoDetalle.fxml");
        MantenimientoTipoDetalleController controlador = (MantenimientoTipoDetalleController) datos.get("controlador");
        controlador.setTipo(tblTipo.getSelectionModel().getSelectedItem());
        ((Stage)datos.get("escenario")).showAndWait();
        cargarDatos();
    }

    public void eliminar(ActionEvent actionEvent) {
    }

    public void generarReporte(ActionEvent actionEvent) {
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/reporte/Tipo_Categoria.jasper"));
            JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(TipoDao.listarConteoCategoria());
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, datos);
            JasperViewer jviewer = new JasperViewer(jprint);
            jviewer.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
