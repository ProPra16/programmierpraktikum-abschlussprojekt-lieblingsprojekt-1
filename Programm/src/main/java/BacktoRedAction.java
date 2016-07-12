import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BacktoRedAction extends CheckboxAction{
	
	
	public void backtoRedAction(Button backtoRed, Button startTest, Button green, Button pruefeProg, TextArea textTest, TextArea textProgramm, String backUpMain )
	{
		backUp=backUpMain;
		backtoRed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				startTest.setDisable(false);
				green.setDisable(true);
				backtoRed.setDisable(true);
				pruefeProg.setDisable(true);
				textTest.setDisable(false);
				textProgramm.setText(backUp);
				textProgramm.setDisable(true);
				// aktzeptanzCheckbox.setDisable(true); //auskommentieren evtl
			}
		});
		
	}
	
	
	
	
	

}
