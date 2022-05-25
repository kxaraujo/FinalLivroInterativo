import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlApp extends Application {
        public static void main(String[] args) {
                launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teste.fxml"));
                Parent root = fxmlLoader.load();
                Scene tela = new Scene(root);

                primaryStage.setTitle("Livro interativo");
                primaryStage.setScene(tela);
                primaryStage.show();
        }
}