package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.repositorio.Persistencia;

import java.time.LocalDateTime;

public class PyClase extends Application {
    public static void main(String[] args){
        Persistencia.getInstancia();
        LocalDateTime fecha = LocalDateTime.now();
        System.out.println(fecha.toLocalDate());
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
