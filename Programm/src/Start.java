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
	private boolean testErgolreich = false; // Hier muss die Schnittstelle implementiert werden

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(550, 550);
		
		// Button zum starten damit der Uebungskatalog in einem neuen Fenster angezeigt wird
		Button ubung = new Button("Uebung reinladen");
		ubung.setTranslateX(20);
		ubung.setTranslateY(20);

		// Button RED zum Starten des RED Werkzeugs
		red = new Button("RED");
		red.setTranslateX(20);
		red.setTranslateY(80);
		
		// Textfeld fuer die Test.java Datei
		TextArea textTest = new TextArea("Test");
		textTest.setPrefWidth(200);
		textTest.setPrefHeight(200);
		textTest.setTranslateX(200);
		textTest.setTranslateY(85);
		textTest.setDisable(true);
		
		// Beschreibungsfeld fuer den RED Button
		Label label = new Label("Beschreibung");
		label.setTranslateX(85);
		label.setTranslateY(85);
		
		// Button GREEN zum Starten des GREEN Werkzeugs
		Button green = new Button("GREEN");
		green.setTranslateX(20);
		green.setTranslateY(290);
		green.setDisable(true);
		
		// Textfeld fuer die Class.java Datei
		TextArea textProgramm = new TextArea("Code");
		textProgramm.setPrefWidth(200);
		textProgramm.setPrefHeight(200);
		textProgramm.setTranslateX(200);
		textProgramm.setTranslateY(290);
		textProgramm.setDisable(true);
		
		// Beschreibungsfeld fuer den GREEN Button
		Label label1 = new Label("Beschreibung");
		label1.setTranslateX(85);
		label1.setTranslateY(295);

		// Button Starte Test um die Test.java Datei zu kompilieren und starten
		Button startTest = new Button("Starte Test");
		startTest.setTranslateX(400);
		startTest.setTranslateY(85);
		startTest.setDisable(true);
		
		// Button Pruefe Programm der Prueft ob der Test erfolgreich ist
		Button pruefeProg = new Button("Pruefe Programm");
		pruefeProg.setTranslateX(400);
		pruefeProg.setTranslateY(290);
		pruefeProg.setDisable(true);
		
		// Button Wechsele zu RED der wieder zum RED Schritt zurueckgeht
		Button backtoRed = new Button("Wechsle zu RED");
		backtoRed.setTranslateX(400);
		backtoRed.setTranslateY(325);
		backtoRed.setDisable(true);
		
		// Hier steht der Code fuer die Daten dass die Knoepfe gedreuckt wurden
		// Button fuer Uebung reinlden, sodass ein enues Fenster startet mit den Uebungsaufgaben
		ubung.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				Stage stage = new Stage();
				stage.setTitle("Aufgabe");
				stage.setScene(new Scene(aufgabe(stage)));
				stage.show();
			}
		});
		
		// Textfeld darf nur geaendert werden wenn der RED Button geklickt wurde
		red.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				if(geladen == true){
					textTest.setDisable(false);
					startTest.setDisable(false);
				}
			}
		});
		
		// Textfeld darf nur geaendert werden wenn der GREEN Button geklickt wurde
		green.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				textProgramm.setDisable(false);
				textTest.setDisable(true);			
			}
		});
		
		// Wenn der Test erfolgreich ist dann kann der GREEN Prozess gestartet werden
		startTest.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				if(testErgolreich == true){
					red.setDisable(true);
					green.setDisable(false);
					pruefeProg.setDisable(false);
					backtoRed.setDisable(false);
				}
			}
		});
		
		// Fuege Textfelder hinzu
		root.getChildren().add(textProgramm);
		root.getChildren().add(textTest);
		
		// Fuege Buttons hinzu
		root.getChildren().add(ubung);
		root.getChildren().add(red);
		root.getChildren().add(green);
		root.getChildren().add(startTest);
		root.getChildren().add(pruefeProg);
		root.getChildren().add(backtoRed);
		
		// Fuege Labels hinzu
		root.getChildren().add(label);
		root.getChildren().add(label1);

		return root;
	}

    // code fuer das Fenster Uebugnsaufgaben: uebernimmt die stage (Fenster) damit beim Knopf druecken reinladen dies automatisch geschlossen wird
	private Parent aufgabe(Stage stage){
		
		Pane root = new Pane();
		root.setPrefSize(400,400);
		
		// Liste für die Auswahl der Programme -> Hier muesstet Ihr mit Array Lists arbeiten
		ListView<String> list = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList (
			"Beispiel","Beispiel2");
		
		list.setItems(items);
		list.setPrefWidth(100);
		list.setPrefHeight(70);
		
		// Erstelle Reinladen Button damit die Ubungsaufgabe reingeladen wird
		Button reinladen = new Button("Reinladen");
		reinladen.setTranslateX(300);
		reinladen.setTranslateY(20);
		
		// To Do wenn der Knopf gedrueckt wurde
		reinladen.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				geladen = true;	
				stage.close();
			}
		});

		root.getChildren().add(list);
		root.getChildren().add(reinladen);
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
