import java.util.Timer;
import java.util.TimerTask;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GreenAction extends RedAction{
	

	public void greenAction(Button green,JavaFile klasseMain, JavaFile klasseTest, int babyValue, Timer timer, TextArea textProgramm, TextArea textTest, Button pruefeProg, Button backtoRed, TextField counter,Timer sekunden)
	{
		this.Value=babyValue;
		green.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				sekunden.cancel();
				int final temp = babyValue;
				sekunden = new Timer();
				sekunden.schedule(new TimerTask() {
						@Override
						public void run() {
							if(temp == 0)sekunden.cancel();
							counter.setText("Noch"+temp+"Sekunden");
							if(temp != 0) temp--;
						}
					}, 1000,1000);
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
