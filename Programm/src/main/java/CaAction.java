import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CaAction extends BacktoRedAction{
	
	private int temp = 0;
	String AktestHaupt=
			"import static org.junit.Assert.*;\n"
			+ "import org.junit.Test;\n"
			+ "public class Akzeptanztest{\n"
			+ "      @Test\n"
			+ "      public void aTest(){\n"
			+ "            assertEquals(null,TestCode.convert());\n"
			+ "      }\n"
			+ "}\n";
	
	public void caAction(Button CA, JavaFile klasseTest, JavaFile klasseMain, JavaFile klasseAkzeptanzTest, int babyValue, boolean geladen, Timer timer, TextArea AkzTest, TextArea textProgramm, String backUpMain,TextField counter,Timer sekunden)
	{
		backUp=backUpMain;
		CA.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				temp = babyValue;
				if (geladen == true) {
					sekunden.cancel();
					timer.cancel();
					Timer timer = new Timer();
					Timer sekunden = new Timer();
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
							AkzTest.setText(AktestHaupt);
							timer.cancel();
							// schrittZurueck(1);
						}
					}, babyValue * 1000);			
						
					
					klasseAkzeptanzTest.setCode(AktestHaupt);

					AkzTest.setText(AktestHaupt);
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
