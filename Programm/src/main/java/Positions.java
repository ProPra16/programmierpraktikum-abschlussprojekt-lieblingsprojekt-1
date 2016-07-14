import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.text.Font;

public class Positions extends PruefeProgActions {

	public Button ubung()
	{
		Button ubung =new Button("1. Uebung reinladen");
		ubung.setLayoutX(250);
		ubung.setLayoutY(110);
		ubung.setId("ubung");
		ubung.setStyle("-fx-text-fill: BLUE;");
		return ubung;
	}
	
	public Label ersterSchritt()
	{
		Label ersterSchritt =new Label("Wähle zunächst eine Übung aus, um mit dem Testen und Programmieren beginnen zu können.");
		ersterSchritt.setLayoutX(20);
		ersterSchritt.setLayoutY(85);
		ersterSchritt.setId("ersterSchritt");
		//ersterSchritt.setStyle("-fx-text-fill: BLUE;");
		return ersterSchritt;
	}
	
	
	public Label willkommen()
	{
		Label willkommen =new Label("Willkommen beim Test-Tutorial");
		willkommen.setLayoutX(200);
		willkommen.setLayoutY(20);
		willkommen.setId("willkomen");
		Font myFont = new Font("Courier", 20);
	    willkommen.setFont(myFont);
		willkommen.setEffect(new Reflection());
		return willkommen;
	}
	
	
	
	public Button CA()
	{
		Button CA = new Button("2. Lade Akzeptanztest\n(nur fuer Testzwecke)");
		CA.setLayoutX(1000);
		CA.setLayoutY(250);
		CA.setId("CA");
		return CA;
	}
	public Label Akzeptanztest()
	{
		Label Akzeptanztest = new Label("Akzeptanztest:");
		Akzeptanztest.setLayoutX(700);
		Akzeptanztest.setLayoutY(30);
		Akzeptanztest.setId("Akzeptanztest");
		Akzeptanztest.setStyle("-fx-text-fill: BLUE;");
		return Akzeptanztest;
	}
	public TextArea AkzTest()
	{
		TextArea AkzTest = new TextArea("");
		AkzTest.setLayoutX(800);
		AkzTest.setLayoutY(30);
		AkzTest.setPrefWidth(300);
		AkzTest.setPrefHeight(200);
		AkzTest.setEditable(true);
		AkzTest.setId("AkzTest");
		return AkzTest;
	}
	public Button AkzepTest()
	{
		Button AkzepTest = new Button("3. Akzeptanztest starten\num RED freizugeben");
		AkzepTest.setTranslateX(800);
		AkzepTest.setTranslateY(250);	
		AkzepTest.setId("AkzepTest");
		return AkzepTest;
	}
	public Button red()
	{
		Button red = new Button("RED");
		red.setLayoutX(20);
		red.setLayoutY(190);
		red.setDisable(true);
		red.setId("red");
		red.setStyle("-fx-background-color: LIGHTPINK;");
		return red;
	}
	public TextArea textTest()
	{
		TextArea textTest = new TextArea("");
		textTest.setLayoutX(200);
		textTest.setLayoutY(190);
		textTest.setPrefWidth(300);
		textTest.setPrefHeight(200);
		textTest.setDisable(true);
		textTest.setId("textTest");
		return textTest;
	}
	public Label label()
	{
		Label label = new Label("Beschreibung");
		label.setLayoutX(95);
		label.setLayoutY(190);
		label.setId("label");
		return label;
	}
	public Button green()
	{
		Button green = new Button("GREEN");
		green.setLayoutX(20);
		green.setLayoutY(425);
		green.setDisable(true);
		green.setId("green");
		green.setStyle("-fx-background-color: LIGHTGREEN;");
		return green;
	}
	public Button exit()
	{
		Button exit = new Button("Exit");
		exit.setTranslateX(1000);
		exit.setTranslateY(650);
		exit.setId("exit");
		exit.setStyle("-fx-text-fill: RED;");
		return exit;
	}
	public Button speichern()
	{
		Button speichern = new Button("Dateien speichern");
		speichern.setTranslateX(850);
		speichern.setTranslateY(650);
		speichern.setId("speichern");
		speichern.setStyle("-fx-text-fill: GREEN;");
		return speichern;
	}
	public TextArea textProgramm()
	{
		TextArea textProgramm = new TextArea("");
		textProgramm.setPrefWidth(300);
		textProgramm.setPrefHeight(200);
		textProgramm.setTranslateX(200);
		textProgramm.setTranslateY(425);
		textProgramm.setDisable(true);
		textProgramm.setId("textProgramm");
		return textProgramm;
	}
	public TextArea textKonsole()
	{
		TextArea textKonsole = new TextArea("Konsolenausgabe");
		textKonsole.setPrefWidth(300);
		textKonsole.setPrefHeight(200);
		textKonsole.setTranslateX(800);
		textKonsole.setTranslateY(425);
		textKonsole.setEditable(false);
		textKonsole.setId("textKonsole");
		return textKonsole;
	}
	public Label label1()
	{
		Label label1 = new Label("Beschreibung");
		label1.setTranslateX(95);
		label1.setTranslateY(425);
		label1.setId("label1");
		return label1;
	}
	public Button startTest()
	{
		Button startTest = new Button("Starte Test");
		startTest.setTranslateX(525);
		startTest.setTranslateY(215);
		startTest.setDisable(true);
		startTest.setId("startTest");
		startTest.setStyle("-fx-text-fill: BLUE;");
		return startTest;
	}
	public Button pruefeProg()
	{
		Button pruefeProg = new Button("Pruefe Programm");
		pruefeProg.setTranslateX(525);
		pruefeProg.setTranslateY(450);
		pruefeProg.setDisable(true);
		pruefeProg.setId("pruefeProg");
		return pruefeProg;
	}
	public Button backtoRed()
	{
		Button backtoRed = new Button("Wechsle zu RED");
		backtoRed.setTranslateX(525);
		backtoRed.setTranslateY(500);
		backtoRed.setDisable(true);
		backtoRed.setId("backtoRed");
		backtoRed.setStyle("-fx-text-fill: RED;");
		return backtoRed;
	}
	public CheckBox aktzeptanzCheckbox()
	{
		CheckBox aktzeptanzCheckbox = new CheckBox("Check Akzeptanz");
		aktzeptanzCheckbox.setTranslateX(525);
		aktzeptanzCheckbox.setTranslateY(550);
		aktzeptanzCheckbox.setDisable(true);
		aktzeptanzCheckbox.setId("aktzeptanzCheckbox");
		return aktzeptanzCheckbox;
	}

}
