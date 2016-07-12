import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class CaAction extends BacktoRedAction{
	

	public void caAction(Button CA, JavaFile klasseTest, JavaFile klasseMain, int babyValue, boolean geladen, Timer timer, TextArea AkzTest, TextArea textProgramm, String backUpMain)
	{
		backUp=backUpMain;
		CA.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if (geladen == true) {
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							AkzTest.setText("");
							// timer.cancel();
							// schrittZurueck(1);
						}
					}, babyValue * 1000);

					AkzTest.setText(klasseTest.getCode());
					// red.setDisable(false);
					textProgramm.setDisable(true);
					textProgramm.setText(klasseMain.getCode());
					backUp = textProgramm.getText();
				}
			}
		});
		backUpMain=backUp;
		
	}
	
	
	
	
	
	

}
