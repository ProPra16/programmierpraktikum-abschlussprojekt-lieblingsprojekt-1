import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
// Imports fuer die Bibilothek vom Java Compiler
import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestFailure;
import vk.core.api.TestResult;

public class Start extends Application {
	
	// akzept test oben ins fenster
	private Scene scene;
	private Button red, green, pruefeProg, backtoRed, startTest;
	private Timer timer = new Timer();
	private boolean geladen = false, testErfolgreich = false, isBaby, isTracked;
	private JavaFile klasseTest, klasseMain, klasseAkzeptanzTest, KlasseMainFuerAkzeptanztest;
	private String backUpMain, aufgabe;
	private int babyValue;
	private TextArea textTest, textKonsole, textProgramm, AkzTest;
	// fuer das Lesen der XML Datei:
	private DocumentBuilderFactory dbfactory;
	private Document document;
	private NodeList tableNodeList; 
	private Stage ExtraStage;	
	private Positions verkurzenObjekt=new Positions();
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(1200, 700);

		// Button zum Starten damit der Uebungskatalog in einem neuen Fenster
		// angezeigt wird
		Button ubung = verkurzenObjekt.ubung();	
		Label willkommen= verkurzenObjekt.willkommen();
		Label ersterSchritt= verkurzenObjekt.ersterSchritt();
		Button CA=verkurzenObjekt.CA();
		Label verweisaufakztest = verkurzenObjekt.verweisaufakztest();
        Label Akzeptanztest=verkurzenObjekt.Akzeptanztest();
		AkzTest = verkurzenObjekt.AkzTest();
		Button AkzepTest = verkurzenObjekt.AkzepTest();
		// Button RED zum Starten des RED Werkzeugs
		red = verkurzenObjekt.red();
		// Textfeld fuer die Test.java Datei
		textTest = verkurzenObjekt.textTest();
		// Beschreibungsfeld fuer den RED Button
		Label label = verkurzenObjekt.label();
		// Button GREEN zum Starten des GREEN Werkzeugs
		Button green = verkurzenObjekt.green();
		// Button Exit zum Schliessen des Programms
		Button exit = verkurzenObjekt.exit();
		// Button Speichern zum Speichern des Programms
		Button speichern = verkurzenObjekt.speichern();
		// Textfeld fuer die Class.java Datei
		textProgramm = verkurzenObjekt.textProgramm();
		// Textfeld fuer die Konsole
		textKonsole = verkurzenObjekt.textKonsole();
		// Beschreibungsfeld fuer den GREEN Button
		Label label1 = verkurzenObjekt.label1();
		// Button Starte Test um die Test.java Datei zu kompilieren und starten
		Button startTest = verkurzenObjekt.startTest();
		// Button Pruefe Programm der Prueft ob der Test erfolgreich ist
		Button pruefeProg = verkurzenObjekt.pruefeProg();
		// Button Wechsele zu RED der wieder zum RED Schritt zurueckgeht
		Button backtoRed = verkurzenObjekt.backtoRed();
		// checkbox fuer aktzeptanzTest Checken beim erfolgereich entwicklungs des Programms
		CheckBox aktzeptanzCheckbox = verkurzenObjekt.aktzeptanzCheckbox();		
		
		verkurzenObjekt.checkboxAction(aktzeptanzCheckbox, startTest, red, green, backtoRed, pruefeProg, klasseTest, klasseMain, testErfolgreich, 
				textTest, AkzTest, textProgramm, textKonsole);
		
		// Hier steht der Code fuer die Daten dass die Knoepfe gedreuckt wurden
		// Button fuer Uebung reinlden, sodass ein enues Fenster startet mit den
		// Uebungsaufgaben
		ubung.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				
				Stage stage_ubung = new Stage();
				stage_ubung.setTitle("Aufgabe");
				try {
					stage_ubung.setScene(new Scene(aufgabe(stage_ubung)));

				} catch (Exception e) {
					e.printStackTrace();
				}
				stage_ubung.show();
			}
		});
		/// neuer Akztest
		
		verkurzenObjekt.caAction(CA, klasseTest, klasseMain, babyValue, geladen, timer, AkzTest, textProgramm, backUpMain);		
		
		verkurzenObjekt.akzepTestAction(AkzepTest, red, klasseTest, klasseMain, AkzTest, textProgramm, textKonsole, testErfolgreich);

		// Textfeld darf nur geaendert werden wenn der RED Button geklickt wurde
        verkurzenObjekt.redAction(red, startTest, klasseMain, klasseTest, babyValue, geladen, timer, textTest, textProgramm, backUpMain);

		// Textfeld darf nur geaendert werden wenn der GREEN Button geklickt
		// wurde
		verkurzenObjekt.greenAction(green, klasseMain, klasseTest, babyValue, timer, textProgramm, textTest, pruefeProg, backtoRed);
		// Exit beendet das Programm
		verkurzenObjekt.exitAction(exit, timer);

		// Speichern speichert das Programm
		verkurzenObjekt.speichernAction(speichern, klasseTest, klasseMain, klasseAkzeptanzTest, textTest, textProgramm, AkzTest);

		// Wenn der Test erfolgreich ist dann kann der GREEN Prozess gestartet
		// werden
		verkurzenObjekt.startTestaction(startTest, klasseTest, klasseMain, textTest, textProgramm,
				textKonsole, testErfolgreich, red, green);
		
		verkurzenObjekt.pruefeProgAction(pruefeProg, backtoRed, green, backtoRed,textTest, textProgramm,
				textKonsole,klasseTest, klasseMain,testErfolgreich, aktzeptanzCheckbox);

		verkurzenObjekt.backtoRedAction(backtoRed, startTest, green, pruefeProg, textTest, textProgramm, backUpMain);

		// Fuege Textfelder hinzu
		root.getChildren().add(textProgramm);
		root.getChildren().add(textTest);
		root.getChildren().add(textKonsole);

		// Fuege Buttons hinzu
		root.getChildren().add(ubung);
		root.getChildren().add(red);
		root.getChildren().add(green);
		root.getChildren().add(startTest);
		root.getChildren().add(pruefeProg);
		root.getChildren().add(backtoRed);
		root.getChildren().add(exit);
		root.getChildren().add(speichern);
		root.getChildren().add(aktzeptanzCheckbox); // evtl auch raus

		// Fuege Labels hinzu
		root.getChildren().add(label);
		root.getChildren().add(ersterSchritt);
		root.getChildren().add(willkommen);
		root.getChildren().add(verweisaufakztest);
		root.getChildren().add(label1);
		root.getChildren().add(CA);
		root.getChildren().add(Akzeptanztest);
		root.getChildren().add(AkzTest);
		root.getChildren().add(AkzepTest);
		return root;
	}


	// code fuer das Fenster Uebugnsaufgaben: uebernimmt die stage (Fenster)
	// damit beim Knopf druecken reinladen dies automatisch geschlossen wird
	private Parent aufgabe(Stage stage_ubung) throws Exception {

		Pane root = new Pane();
		root.setPrefSize(400, 400);

		// Liste fuer die Auswahl der Programme
		ListView<String> list = new ListView<String>();

		ObservableList<String> items = FXCollections.observableArrayList();

		// im Folgenden wird die Datei Aufgaben.xml nach dem Begriff "exercise"
		// durchsucht; alle Eintraege hinter "exercise name" werden ausgegeben
		dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbfactory.newDocumentBuilder();
		document = builder.parse(new File("Aufgaben.xml"));

		tableNodeList = document.getElementsByTagName("exercise");

		// Aufgabenanzahl innerhalb der Aufgaben.xml Datei
		int aufgabenanzahl = tableNodeList.getLength();

		verkurzenObjekt.read_exercise(aufgabenanzahl, items, aufgabe, tableNodeList);

		list.setItems(items);
		list.setTranslateY(40);
		list.setTranslateX(50);
		list.setPrefWidth(300);
		list.setPrefHeight(200);

		// Erstelle Reinladen Button damit die Ubungsaufgabe reingeladen wird
		Button reinladen = new Button("Reinladen");
		reinladen.setTranslateX(175);
		reinladen.setTranslateY(325);

		// To Do Wenn der Knopf gedrueckt wurde
		reinladen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				geladen = true; // davor in Akzeptanztest
				// Neue Objekt machen, und direkt die noetige Parameters beim
				// Constructor geben.
				ReinladenClasse reinladenobjekt = new ReinladenClasse(tableNodeList, list, aufgabenanzahl, document);
				// die beide String Variabelen kriegen ihren neue Werte :)
				klasseMain = new JavaFile(reinladenobjekt.GetNameMain(), reinladenobjekt.GetNeueCodeMain());
				klasseTest = new JavaFile(reinladenobjekt.GetNameTest(), reinladenobjekt.GetNeueCodeTest());
				// Ist zu Anfang noch identisch mit normaler Test
				klasseAkzeptanzTest = new JavaFile(reinladenobjekt.GetNameTest(), reinladenobjekt.GetNeueCodeTest());

				isBaby = reinladenobjekt.GetBabystep();
				if (isBaby) {
					babyValue = reinladenobjekt.GetBabystepTime();
				}
				isTracked = reinladenobjekt.GetTimetracking();
				ExtraStage.setScene(new Scene(createContent()));

			}
		});

		root.getChildren().add(list);
		root.getChildren().add(reinladen);
		return root;
	}

	@Override
	public void start(Stage stage) {
		ExtraStage = stage;
		scene = new Scene(createContent());
		stage.setTitle("Lieblingsprojekt");		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String... args) {
		launch();
	}
}
