

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class StartTestAction extends GreenAction {
	
	public void startTestaction(Button startTest, JavaFile klasseTest, JavaFile klasseMain, TextArea textTest, TextArea textProgramm, TextArea textKonsole, boolean testErfolgreich, Button red, Button green)
	{
		
		
		startTest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				klasseTest.setCode(textTest.getText());
				klasseMain.setCode(textProgramm.getText());
				test = compiliere(klasseTest.getCode(), klasseTest.getName(), klasseMain.getCode(),
						klasseMain.getName(), textKonsole);
				if (test) {
					red.setDisable(true);
					startTest.setDisable(false);
					green.setDisable(false);
					textTest.setDisable(true);
					startTest.setDisable(true);
				} else {
					textKonsole.setText("Es ergab keine Fehler,\nbitte Test erneut schreiben");
				}
			}
		});
		
		testErfolgreich=test;
		
		
		
		
		
	}
	
	
	

}
