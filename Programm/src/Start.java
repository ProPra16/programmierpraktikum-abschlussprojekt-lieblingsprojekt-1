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
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class Start extends Application {

    private Scene scene;
	private Button red;
	private boolean geladen = false;
	private boolean redGedrueckt = false;

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(550, 550);

		int x = 100;
		int y = 85;

		Button button = new Button("Übung reinladen");
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

		red = new Button("RED");
		red.setTranslateX(20);
		red.setTranslateY(80);

		Label label = new Label("Beschreibung");
		label.setTranslateX(85);
		label.setTranslateY(85);

		Label label2 = new Label("Beschreibung");
		label2.setTranslateX(85);
		label2.setTranslateY(295);

		TextArea textTest = new TextArea("Test");
		textTest.setPrefWidth(200);
		textTest.setPrefHeight(200);
		textTest.setTranslateX(200);
		textTest.setTranslateY(85);
		textTest.setDisable(true);

		TextArea textProgramm = new TextArea("Code");
		textProgramm.setPrefWidth(200);
		textProgramm.setPrefHeight(200);
		textProgramm.setTranslateX(200);
		textProgramm.setTranslateY(290);
		textProgramm.setDisable(true);

		red.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent ae){
				if(geladen == true)	textTest.setDisable(false);
			}
		
		});

		Button button2 = new Button("GREEN");
		button2.setTranslateX(20);
		button2.setTranslateY(290);
		//button2.setDisabled(false);

		button2.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent ae){
				textProgramm.setDisable(false);
				textTest.setDisable(true);
			}
		
		});


		Button button3 = new Button("Starte Test");
		button3.setTranslateX(400);
		button3.setTranslateY(85);
		//button3.setDisabled(false);
		
		button3.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent ae){
				if(redGedrueckt == true)
			}
		
		});

		Button button4 = new Button("Prüfe Programm");
		button4.setTranslateX(400);
		button4.setTranslateY(290);
		//button4.setDisabled(false);

		Button button5 = new Button("Wechsle RED");
		button5.setTranslateX(400);
		button5.setTranslateY(325);
		//button5.setDisabled(false);

		/*Button button6 = new Button("Refactor");
		button6.setTranslateX(20);
		button6.setTranslateY(225);

		root.getChildren().add(button6);*/
		root.getChildren().add(button5);
		root.getChildren().add(textProgramm);
		root.getChildren().add(textTest);
		root.getChildren().add(button);
		root.getChildren().add(red);
		root.getChildren().add(button2);
		root.getChildren().add(button3);
		root.getChildren().add(button4);
		root.getChildren().add(label);
		root.getChildren().add(label2);

		return root;
	}

	private Parent aufgabe(){
		Pane root = new Pane();
		root.setPrefSize(400,400);

		ListView<String> list = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList (
			"Beispiel","Beispiel2");
		list.setItems(items);
		list.setPrefWidth(100);
		list.setPrefHeight(70);

		Button button = new Button("Reinladen");
		button.setTranslateX(300);
		button.setTranslateY(20);

		button.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent ae){
				geladen = true;
			}
		
		});

		
		root.getChildren().add(list);
		root.getChildren().add(button);
		return root;
	}

    @Override
    public void start(Stage stage){
        scene = new Scene(createContent());
        stage.setTitle("Lieblingsprojekt");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        launch();
    }
}
