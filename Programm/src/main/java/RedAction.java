import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class RedAction extends AkzepTestAction {
	
	
	public void redAction(Button red, Button startTest, JavaFile klasseMain, JavaFile klasseTest, int babyValue, boolean geladen, Timer timer, TextArea textTest, TextArea textProgramm, String backUpMain)
	{
		Value=babyValue;
		backUp=backUpMain;
		
		red.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if (geladen == true) {
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							textTest.setText(klasseTest.getCode());
							if(Value > 180 || Value < 60){ Value = 120; }
							// timer.cancel();
							// schrittZurueck(1);
						}
					}, Value * 1000);
					textTest.setText(klasseTest.getCode());
					textTest.setDisable(false);
					textProgramm.setDisable(true);
					textProgramm.setText(klasseMain.getCode());
					startTest.setDisable(false);
					backUp = textProgramm.getText();
				}
			}
		});
		babyValue=Value;
		backUpMain=backUp;
		
		
		
	}
	
	
	
	

}
