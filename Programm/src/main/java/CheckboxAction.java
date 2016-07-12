import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class CheckboxAction extends ExitSpeichernActions{

	
	public void checkboxAction(CheckBox aktzeptanzCheckbox,Button startTest,
			Button red, Button green, Button backtoRed, Button pruefeProg, JavaFile klasseTest,
			JavaFile klasseMain, boolean testErfolgreich,TextArea textTest, TextArea AkzTest,
			                   TextArea textProgramm, TextArea textKonsole)
	{
		
		
		test=testErfolgreich;
		aktzeptanzCheckbox.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {

				klasseTest.setCode(AkzTest.getText());
				klasseMain.setCode(textProgramm.getText());
				test = compiliere(klasseTest.getCode(), klasseTest.getName(), klasseMain.getCode(),
						klasseMain.getName(), textKonsole);
				if (test) {
					textKonsole.setText("Programm noch nicht erfolgreich!\nBitte Tests/Main weiter abaendern");

					red.setDisable(false);
					startTest.setDisable(false);
					textTest.setDisable(false);
					green.setDisable(true);
					backtoRed.setDisable(true);
					pruefeProg.setDisable(true);
					textProgramm.setDisable(true);
					aktzeptanzCheckbox.setSelected(false);
					aktzeptanzCheckbox.setDisable(true);

				} else { // Beim erfolgereichen Programm, kann man Speichern,
							// und //
					// auch eine neue Ubung reinladen
					textKonsole.setText("Programm in Ordnung!\nBitte speichern oder eine neue Ubung reinladen.");

					startTest.setDisable(true);
					green.setDisable(true);
					red.setDisable(true);
					backtoRed.setDisable(true);
					pruefeProg.setDisable(true);
					textTest.setDisable(true);
					textProgramm.setDisable(true);
					aktzeptanzCheckbox.setSelected(false);
					aktzeptanzCheckbox.setDisable(true);
				}

			}

		});
		testErfolgreich=test;
		
	}
	
	
	
	

}
