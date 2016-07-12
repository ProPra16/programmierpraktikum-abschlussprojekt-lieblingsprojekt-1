import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ExitSpeichernActions extends LesenAusXml{
	
	public boolean test;
	public String backUp;
	public int Value;
	
	public void exitAction(Button exit, Timer timer)
	{
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				timer.cancel();
				System.exit(0);
			}
		});
		
		
	}
	
	public void speichernAction(Button speichern, JavaFile klasseTest, JavaFile klasseMain)
	{
		speichern.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Speichern.speichere(klasseMain);
				Speichern.speichere(klasseTest);
			}
		});
	}

}
