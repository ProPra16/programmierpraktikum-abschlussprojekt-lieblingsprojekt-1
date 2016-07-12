import java.util.Timer;
import java.util.TimerTask;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GreenAction extends RedAction{
	

	public void greenAction(Button green,JavaFile klasseMain, JavaFile klasseTest, int babyValue, Timer timer, TextArea textProgramm, TextArea textTest, Button pruefeProg, Button backtoRed)
	{
		this.Value=babyValue;
		green.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				timer.schedule(new TimerTask() {
					@Override 
					public void run() {
						textProgramm.setText(klasseMain.getCode());
						if( Value > 180 || Value < 60){ Value = 120; }
						// timer.cancel();
						// schrittZurueck(0);
					}
				}, Value * 1000);
				pruefeProg.setDisable(false);
				backtoRed.setDisable(false);
				textProgramm.setDisable(false);
				textTest.setText(klasseTest.getCode());
				textTest.setDisable(true);
			}
		});
		
		babyValue=this.Value;
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
