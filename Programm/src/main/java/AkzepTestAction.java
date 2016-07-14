import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class AkzepTestAction extends CaAction {
	
	
	public void akzepTestAction(Button AkzepTest, Button red, JavaFile klasseAkzeptanzTest, JavaFile klasseMain, TextArea AkzTest, TextArea textProgramm, TextArea textKonsole, boolean testErfolgreich)
	{
		test=testErfolgreich;
		AkzepTest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				klasseAkzeptanzTest.setCode(AkzTest.getText());
				klasseMain.setCode(textProgramm.getText());
				
				test = compiliere(klasseAkzeptanzTest.getCode(), klasseAkzeptanzTest.getName(), klasseMain.getCode(),
						klasseMain.getName(), textKonsole);
				if (test) {
					// red.setDisable(true);
					AkzepTest.setDisable(false);
					red.setDisable(false);
					// textTest.setDisable(true);
					// AkzepTest.setDisable(true);
				} else {
					textKonsole.setText("Akzeptanztest klappt,\nRED ist freigeschaltet");
					red.setDisable(false);
				}
			}
		});
		testErfolgreich=test;
		
		
	}

}
