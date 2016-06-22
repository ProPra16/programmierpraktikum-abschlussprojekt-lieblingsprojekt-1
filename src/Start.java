import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Start extends Application {

    private Scene scene;

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(400, 400);
	Label label = new Label("Das hier ist das Startprogramm");
	label.setTranslateX(100);
	label.setTranslateY(200);
	root.getChildren().add(label);
	return root;
	}

    @Override
    public void start(Stage stage){
        scene = new Scene(createContent());
        stage.setTitle("Lieblingsprojekt");
        stage.setScene(scene);
        stage.show();
    }

    public static void Start() {
        launch();
    }
}
