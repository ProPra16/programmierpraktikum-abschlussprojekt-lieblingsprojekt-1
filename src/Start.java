import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Start extends Application {

    private Scene scene;
    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(400, 400);

		int x = 100;
		int y = 25;

		for (int i = 0; i < 5; i++) {
			
     	   	Label label = new Label("Beschreibung");
			label.setTranslateX(x);
			label.setTranslateY(y);
        	root.getChildren().add(label);
			y = y + 60;
		}

		Button button = new Button("Button");
		button.setTranslateX(20);
		button.setTranslateY(20);

		button.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent ae){
				Stage stage = new Stage();
				stage.setTitle("Aufgabe");
				stage.setScene(new Scene(aufgabe()));
				stage.show();
			}
		
		});

		Button button1 = new Button("Button1");
		button1.setTranslateX(20);
		button1.setTranslateY(80);

		Button button2 = new Button("Button2");
		button2.setTranslateX(20);
		button2.setTranslateY(140);

		Button button3 = new Button("Button3");
		button3.setTranslateX(20);
		button3.setTranslateY(200);

		Button button4 = new Button("Button4");
		button4.setTranslateX(20);
		button4.setTranslateY(260);

		root.getChildren().add(button);
		root.getChildren().add(button1);
		root.getChildren().add(button2);
		root.getChildren().add(button3);
		root.getChildren().add(button4);

		return root;
	}

	private Parent aufgabe(){
		Pane root = new Pane();
		root.setPrefSize(400,400);
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
