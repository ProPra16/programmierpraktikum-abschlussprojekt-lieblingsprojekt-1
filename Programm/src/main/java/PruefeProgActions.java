import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class PruefeProgActions extends StartTestAction{
	

	public void pruefeProgAction(Button pruefeProg, Button red, Button green,Button backtoRed, TextArea textTest, TextArea textProgramm, TextArea textKonsole,JavaFile klasseTest, JavaFile klasseMain, boolean testErfolgreich, CheckBox aktzeptanzCheckbox)
	{
		pruefeProg.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
		klasseTest.setCode(textTest.getText());
		klasseMain.setCode(textProgramm.getText());
		
		test = compiliere(klasseTest.getCode(), klasseTest.getName(), klasseMain.getCode(),
				klasseMain.getName(), textKonsole);
		if (test) {
			textKonsole.setText("Nicht Erfolgreich, bitte Main weiter abaendern");
		} else {
			textKonsole.setText(
					"Erfolgreich!\nDu kannst die Test Methoden und das Main Programm anpassen,\nsowie den AkzeptanzTest checken.");
			red.setDisable(false);
			green.setDisable(true);
			pruefeProg.setDisable(true);
			backtoRed.setDisable(true);
			textTest.setDisable(false);
			textProgramm.setDisable(false);
			// nur jetzt kann der AkzepetanzTest gecheckt werden
			aktzeptanzCheckbox.setDisable(false);
		}
		
		
	}
				
		});
		testErfolgreich=test;
	}
	
	
	

		
		
	
				

	
		
		
				
	
	
	
	
	

	}
