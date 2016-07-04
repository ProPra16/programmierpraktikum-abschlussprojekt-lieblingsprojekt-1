
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

	private Scene scene;
	private Button red;
	private Timer timer;
	private boolean geladen = false;
	private boolean testErfolgreich = false;
	private JavaFile klasseTest, klasseMain, klasseAkzeptanzTest, KlasseMainFuerAkzeptanztest;
	private boolean isBaby, isTracked;
	private String backUpMain;

	// fuer das Lesen der XML Datei:
	private DocumentBuilderFactory dbfactory;
	private Document document;
	private NodeList tableNodeList;
	private String aufgabe;
	private Stage ExtraStage;
	// TextArea hier declarieren sodass ich in anderen Methoden daran zugreifen
	// kann.
	private TextArea textKonsole, textProgramm;

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(950, 550);

		timer = new Timer();
		// Button zum starten damit der Uebungskatalog in einem neuen Fenster
		// angezeigt wird
		Button ubung = new Button("Uebung reinladen");
		ubung.setTranslateX(20);
		ubung.setTranslateY(20);

		// Button RED zum Starten des RED Werkzeugs
		red = new Button("RED");
		red.setStyle("-fx-background-color: LIGHTPINK;");
		red.setTranslateX(20);
		red.setTranslateY(80);

		// Textfeld fuer die Test.java Datei
		TextArea textTest = new TextArea("");
		textTest.setPrefWidth(300);
		textTest.setPrefHeight(200);
		textTest.setTranslateX(200);
		textTest.setTranslateY(85);
		textTest.setDisable(true);

		// Beschreibungsfeld fuer den RED Button
		Label label = new Label("Beschreibung");
		label.setTranslateX(85);
		label.setTranslateY(85);

		// Button GREEN zum Starten des GREEN Werkzeugs
		Button green = new Button("GREEN");
		green.setStyle("-fx-background-color: LIGHTGREEN;");
		green.setTranslateX(20);
		green.setTranslateY(290);
		green.setDisable(true);

		// Button Exit zum Schliessen des Programms
		Button exit = new Button("Exit");
		exit.setTranslateX(500);
		exit.setTranslateY(500);

		// Button Speichern zum Speichern des Programms
		Button speichern = new Button("Dateien speichern");
		speichern.setTranslateX(300);
		speichern.setTranslateY(500);

		// Textfeld fuer die Class.java Datei
		textProgramm = new TextArea("");
		textProgramm.setPrefWidth(300);
		textProgramm.setPrefHeight(200);
		textProgramm.setTranslateX(200);
		textProgramm.setTranslateY(290);
		textProgramm.setDisable(true);

		// Textfeld fuer die Konsole
		textKonsole = new TextArea("Konsole");
		textKonsole.setPrefWidth(300);
		textKonsole.setPrefHeight(200);
		textKonsole.setTranslateX(625);
		textKonsole.setTranslateY(85);
		textKonsole.setEditable(false);

		// Beschreibungsfeld fuer den GREEN Button
		Label label1 = new Label("Beschreibung");
		label1.setTranslateX(85);
		label1.setTranslateY(295);

		// Button Starte Test um die Test.java Datei zu kompilieren und starten
		Button startTest = new Button("Starte Test");
		startTest.setTranslateX(500);
		startTest.setTranslateY(85);
		startTest.setDisable(true);

		// Button Pruefe Programm der Prueft ob der Test erfolgreich ist
		Button pruefeProg = new Button("Pruefe Programm");
		pruefeProg.setTranslateX(500);
		pruefeProg.setTranslateY(290);
		pruefeProg.setDisable(true);

		// Button Wechsele zu RED der wieder zum RED Schritt zurueckgeht
		Button backtoRed = new Button("Wechsle zu RED");
		backtoRed.setTranslateX(500);
		backtoRed.setTranslateY(325);
		backtoRed.setDisable(true);

		// checkbox fuer aktzeptanzTest Checken beim erfolgereich entwicklungs
		// des Programms
		CheckBox aktzeptanzCheckbox = new CheckBox("Check Akzeptanz");
		aktzeptanzCheckbox.setTranslateX(500);
		aktzeptanzCheckbox.setTranslateY(365);
		aktzeptanzCheckbox.setDisable(true);

		aktzeptanzCheckbox.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {

				KlasseMainFuerAkzeptanztest.setCode(textProgramm.getText());

				if (compiliere(klasseAkzeptanzTest.getCode(), klasseAkzeptanzTest.getName(),
						KlasseMainFuerAkzeptanztest.getCode(), KlasseMainFuerAkzeptanztest.getName(), textKonsole)) {
					textKonsole.setText("Programm noch nicht erfolgreich!\nBitte Tests/Main weiter abaendern");

					red.setDisable(false);
					startTest.setDisable(false);
					textTest.setDisable(false);
					green.setDisable(true);
					backtoRed.setDisable(true);
					pruefeProg.setDisable(true);
					textProgramm.setDisable(true);
					aktzeptanzCheckbox.setSelected(false);
					aktzeptanzCheckbox.setDisable(true);

				} else {
					// Beim erfolgereichen Programm, kann man Speichern, und
					// auch eine neue Ubung reinladen
					textKonsole.setText("Programm in Ordnung!\nBitte speichern oder eine neue Ubung reinladen.");

					startTest.setDisable(true);
					green.setDisable(true);
					red.setDisable(true);
					backtoRed.setDisable(true);
					pruefeProg.setDisable(true);
					textTest.setDisable(true);
					textProgramm.setDisable(true);
					aktzeptanzCheckbox.setSelected(false);
					aktzeptanzCheckbox.setDisable(true);
				}

			}

		});

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

		// Textfeld darf nur geaendert werden wenn der RED Button geklickt wurde
		red.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				if (geladen == true) {
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							textTest.setText("");
							timer.cancel();
						}
					}, 180000);
					textTest.setText(klasseTest.getCode());
					textTest.setDisable(false);
					textProgramm.setDisable(true);
					textProgramm.setText(klasseMain.getCode());
					startTest.setDisable(false);
					backUpMain = textProgramm.getText();
				}
			}
		});

		// Textfeld darf nur geaendert werden wenn der GREEN Button geklickt
		// wurde
		green.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				pruefeProg.setDisable(false);
				backtoRed.setDisable(false);
				textProgramm.setDisable(false);
				textTest.setText(klasseTest.getCode());
				textTest.setDisable(true);
			}
		});

		// Exit beendet das Programm
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				System.exit(0);
			}
		});

		// Speichern speichert das Programm
		speichern.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				Speichern.speichere(klasseMain);
				Speichern.speichere(klasseTest);
			}
		});

		// Wenn der Test erfolgreich ist dann kann der GREEN Prozess gestartet
		// werden
		startTest.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				klasseTest.setCode(textTest.getText());
				klasseMain.setCode(textProgramm.getText());
				testErfolgreich = compiliere(klasseTest.getCode(), klasseTest.getName(), klasseMain.getCode(),
						klasseMain.getName(), textKonsole);
				if (testErfolgreich) {
					red.setDisable(true);
					startTest.setDisable(false);
					green.setDisable(false);
					textTest.setDisable(true);
					startTest.setDisable(true);
				} else {
					textKonsole.setText("Es ergab keine Fehler,\nbitte Test erneut schreiben");
				}
			}
		});

		pruefeProg.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {

				klasseTest.setCode(textTest.getText());
				klasseMain.setCode(textProgramm.getText());

				testErfolgreich = compiliere(klasseTest.getCode(), klasseTest.getName(), klasseMain.getCode(),
						klasseMain.getName(), textKonsole);
				if (testErfolgreich) {
					textKonsole.setText("Nicht Erfolgreich, bitte Main weiter abï¿½ndern");
				} else {
					textKonsole.setText(
							"Erfolgreich!\nDu kannst die Test Methoden und das Main Programm anpassen,\nsowie den AkzeptanzTest checken.");
					red.setDisable(false);
					green.setDisable(true);
					pruefeProg.setDisable(true);
					backtoRed.setDisable(true);
					textTest.setDisable(false);
					textProgramm.setDisable(false);
					// nur jetzt kann der AkzepetanzTest gecheckt werden
					aktzeptanzCheckbox.setDisable(false);
				}

			}
		});

		backtoRed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {
				startTest.setDisable(false);
				green.setDisable(true);
				backtoRed.setDisable(true);
				pruefeProg.setDisable(true);
				textTest.setDisable(false);
				textProgramm.setText(backUpMain);
				textProgramm.setDisable(true);
				aktzeptanzCheckbox.setDisable(true);
			}
		});

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
		root.getChildren().add(aktzeptanzCheckbox);

		// Fuege Labels hinzu
		root.getChildren().add(label);
		root.getChildren().add(label1);

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

		read_exercise(aufgabenanzahl, items);

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
					int babyValue = reinladenobjekt.GetBabystepTime();
				}
				isTracked = reinladenobjekt.GetTimetracking();
				ExtraStage.setScene(new Scene(createContent()));

				// Bereite die Maske "Akzeptanztest" vor:
				Stage stage_akzeptanz = new Stage();
				stage_akzeptanz.setTitle("Akzeptanztest");
				try {
					stage_akzeptanz.setScene(new Scene(akzept_test(stage_akzeptanz)));
				} catch (Exception e) {
					e.printStackTrace();
				}

				// Auf den Schirm mit den neuen Werten aktualisieren.
				// ExtraStage.setScene(new Scene(createContent()));

				stage_ubung.close();
				stage_akzeptanz.toFront();
			}
		});

		root.getChildren().add(list);
		root.getChildren().add(reinladen);
		return root;
	}

	public Parent akzept_test(Stage stage_akzeptanz) throws IOException {
		Pane root_akzept = new Pane();
		root_akzept.setPrefSize(600, 600);

		Button checker = new Button("Check Programm");
		checker.setTranslateX(225);
		checker.setTranslateY(400);

		TextArea akzept_text = new TextArea();
		akzept_text.setPrefSize(300, 200);
		akzept_text.setTranslateY(150);
		akzept_text.setTranslateX(150);

		akzept_text.setText(klasseTest.getCode());

		// Hiermit wird der RED Button aktiviert
		// eigentlich sollte hier nun ueberprueft werden, ob das Programm den
		// Akzeptanztest erfuellt.
		// Wenn nicht, wird der RED Button freigegeben
		checker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ae) {

				stage_akzeptanz.close();
				KlasseMainFuerAkzeptanztest = new JavaFile(klasseMain.getName(), textProgramm.getText());

				if (compiliere(klasseAkzeptanzTest.getCode(), klasseAkzeptanzTest.getName(),
						KlasseMainFuerAkzeptanztest.getCode(), KlasseMainFuerAkzeptanztest.getName(), textKonsole)) {
					geladen = true;
					textKonsole.setText("Akzeptanztest noch nicht erfuellt!\nProgramm muss bearbeitet werden.");

				} else {
					textKonsole.setText("Programm in Ordnung.");
				}

			}

		});

		root_akzept.getChildren().addAll(akzept_text, checker);

		stage_akzeptanz.show();
		stage_akzeptanz.toFront();
		stage_akzeptanz.centerOnScreen();
		return root_akzept;
	}

	@Override
	public void start(Stage stage) {
		ExtraStage = stage;
		scene = new Scene(createContent());
		stage.setTitle("Lieblingsprojekt");
		stage.setScene(scene);
		stage.show();
	}

	private boolean compiliere(String codeTest, String nameTest, String codeMain, String nameMain,
			TextArea textKonsole) {
		boolean result = false;
		try {
			CompilationUnit classTest = new CompilationUnit(nameTest, codeTest, true);
			CompilationUnit classMain = new CompilationUnit(nameMain, codeMain, false);
			JavaStringCompiler javaCompilers = CompilerFactory.getCompiler(classMain, classTest);
			javaCompilers.compileAndRunTests();
			result = javaCompilers.getCompilerResult().hasCompileErrors();
			if (result) {
				textKonsole.setText(textKonsole.getText() + "\n"
						+ javaCompilers.getCompilerResult().getCompilerErrorsForCompilationUnit(classTest).toString());
				textKonsole.setDisable(false);
				return true;
			} else {
				String konsolentext = "";
				TestResult testResult = javaCompilers.getTestResult();
				Collection<TestFailure> fehlerbericht = testResult.getTestFailures();
				Iterator<TestFailure> fehler = fehlerbericht.iterator();
				while (fehler.hasNext()) {
					TestFailure fail = fehler.next();
					konsolentext += "Klasse: " + fail.getTestClassName() + "\n" + "methode: " + fail.getMethodName()
							+ "\n" + "Nachricht: " + fail.getMessage();
				}
				textKonsole.setText(konsolentext);

				if (javaCompilers.getTestResult().getNumberOfFailedTests() >= 1) {
					String sTest = javaCompilers.getCompilerResult().getCompilerErrorsForCompilationUnit(classTest)
							.toString();
					String sMain = javaCompilers.getCompilerResult().getCompilerErrorsForCompilationUnit(classMain)
							.toString();
					textKonsole.setText(konsolentext + "\n" + "Error failed Tests: "
							+ javaCompilers.getTestResult().getNumberOfFailedTests() + " " + sTest + " " + sMain);
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Auslesen der Aufgabennamen aus der XML-Datei
	public ObservableList<String> read_exercise(int aufgabenanzahl, ObservableList<String> items) {
		for (int i = 0; i < aufgabenanzahl; i++) {
			aufgabe = tableNodeList.item(i).getAttributes().getNamedItem("name").getTextContent().toString();
			items.add(aufgabe);
		}
		return items;
	}

	public static void main(String... args) {
		launch();
	}
}
