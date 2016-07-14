import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExitSpeichernActions extends LesenAusXml{
	
	public boolean test;
	public String backUp;
	public int Value;
	
	public void exitAction(Button exit, Timer timer)
	{
		exit.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent ae) {
				
				Stage stage_schliessen = new Stage();
				stage_schliessen.setTitle("Schliessen");
				try {
					stage_schliessen.setScene(new Scene(schluss(stage_schliessen,timer)));

				} catch (Exception e) {
					e.printStackTrace();
				}
				stage_schliessen.show();
			}
		});
	}
	
	private Parent schluss(Stage stage_schliessen, Timer timer) throws Exception {

					Pane root2 = new Pane();
					root2.setPrefSize(250, 200);
					
					Label schliesstext = new Label("Moechten Sie wirklich beenden?\nBitte ans Abspeichern denken");
					schliesstext.setLayoutX(50);
					schliesstext.setLayoutY(20);
					schliesstext.setId("schliesstext");
					
					Button close = new Button("Close");
					
					close.setLayoutX(150);
					close.setLayoutY(100);
					close.setId("close");
					close.setStyle("-fx-text-fill: RED;");
					close.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent ae) {
							timer.cancel();
							System.exit(0);
					}
					});
					
					
					Button abbrechen = new Button("Abbrechen");
					
					abbrechen.setLayoutX(50);
					abbrechen.setLayoutY(100);
					abbrechen.setId("abbrechen");
					
					abbrechen.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent ae) {
							stage_schliessen.close();
							
					}
					});
				
					root2.getChildren().add(schliesstext);
					root2.getChildren().add(close);
					root2.getChildren().add(abbrechen);
<<<<<<< HEAD
					return root2;
		
=======
					return root2;			
>>>>>>> 56fd0447ebb1656d57090f88430e52902ece809c
}
				
	public void speichernAction(Button speichern, JavaFile klasseTest, JavaFile klasseMain, JavaFile klasseAkTesttextTest, TextArea AkzTest, TextArea textTest, TextArea  textProgramm)
	{
		speichern.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				klasseMain.setCode(textProgramm.getText());
				klasseTest.setCode(textTest.getText());
				klasseAkTesttextTest.setCode(AkzTest.getText());
				klasseAkTesttextTest.setName("Akzeptanztest");
				Speichern.speichere(klasseMain);
				Speichern.speichere(klasseTest);
				Speichern.speichere(klasseAkTesttextTest);
			}
		});
	}


	
}