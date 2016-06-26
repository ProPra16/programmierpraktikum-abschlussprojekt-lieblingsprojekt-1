import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.codegen.CompilationException;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
// Imports fuer die Bibilothek vom Java Compiler
import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.JavaStringCompiler;
import static org.junit.Assert.*;
import org.junit.Test;


public class Start extends Application {

    private Scene scene;
	private Button red;
	private boolean geladen = false;
	private boolean testErgolreich = false; // Hier muss die Schnittstelle implementiert werden
	//***********************************************************************************
	// TESTCODE für die Implementierung des Compilers
	// Speter wird der Text automatisch aus dem Textfeld genommen
	private String codeTest = "import static org.junit.Assert.*;\n"
			+ "import org.junit.Test;\n"
			+	"public class TestTest{\n"
					+"@Test\n"
							+"public void aTest(){\n"
							+"	assertEquals(null,TestCode.convert());\n"
							+"}\n"
					+"}";
	
	private String codeMain = "public class RomanNumberConverter{\n"
        +"public static String convert(){\n"
        +"return null;\n"
        +"}\n"
        +"}\n";
	/// Testcode Ende
	//***********************************************************************************
	
			
    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(950, 550);
		
		// Button zum starten damit der Uebungskatalog in einem neuen Fenster angezeigt wird
		Button ubung = new Button("Uebung reinladen");
		ubung.setTranslateX(20);
		ubung.setTranslateY(20);

		// Button RED zum Starten des RED Werkzeugs
		red = new Button("RED");
		red.setTranslateX(20);
		red.setTranslateY(80);
		
		// Textfeld fuer die Test.java Datei
		TextArea textTest = new TextArea(codeTest);
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
		green.setTranslateX(20);
		green.setTranslateY(290);
		green.setDisable(true);
		
		// Textfeld fuer die Class.java Datei
		TextArea textProgramm = new TextArea(codeMain);
		textProgramm.setPrefWidth(300);
		textProgramm.setPrefHeight(200);
		textProgramm.setTranslateX(200);
		textProgramm.setTranslateY(290);
		textProgramm.setDisable(true);		
		
		// Textfeld fuer die Konsole
		TextArea textKonsole = new TextArea("Konsole");
		textKonsole.setPrefWidth(300);
		textKonsole.setPrefHeight(200);
		textKonsole.setTranslateX(625);
		textKonsole.setTranslateY(85);
		textKonsole.setDisable(true);
		
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
		
		// Hier steht der Code fuer die Daten dass die Knoepfe gedreuckt wurden
		// Button fuer Uebung reinlden, sodass ein enues Fenster startet mit den Uebungsaufgaben
		ubung.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				Stage stage = new Stage();
				stage.setTitle("Aufgabe");
				stage.setScene(new Scene(aufgabe(stage)));
				stage.show();
			}
		});
		
		// Textfeld darf nur geaendert werden wenn der RED Button geklickt wurde
		red.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				if(geladen == true){
					textTest.setDisable(false);
					startTest.setDisable(false);
				}
			}
		});
		
		// Textfeld darf nur geaendert werden wenn der GREEN Button geklickt wurde
		green.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				textProgramm.setDisable(false);
				textTest.setDisable(true);			
			}
		});
		
		// Wenn der Test erfolgreich ist dann kann der GREEN Prozess gestartet werden
		startTest.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				testErgolreich = compiliere(textTest.getText(), textProgramm.getText(), textKonsole);
				if(testErgolreich == true){
					red.setDisable(true);
					startTest.setDisable(false);
					green.setDisable(false);
					pruefeProg.setDisable(false);
					backtoRed.setDisable(false);
					textTest.setDisable(true);
				}
				else{
					System.out.println("Es ergab keine Fehler, bitte Test erneut schreiben");
				}
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
		
		// Fuege Labels hinzu
		root.getChildren().add(label);
		root.getChildren().add(label1);

		return root;
	}

    // code fuer das Fenster Uebugnsaufgaben: uebernimmt die stage (Fenster) damit beim Knopf druecken reinladen dies automatisch geschlossen wird
	private Parent aufgabe(Stage stage){
		
		Pane root = new Pane();
		root.setPrefSize(400,400);
		
		// Liste für die Auswahl der Programme -> Hier muesstet Ihr mit Array Lists arbeiten
		ListView<String> list = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList (
			"Beispiel","Beispiel2");
		
		list.setItems(items);
		list.setPrefWidth(100);
		list.setPrefHeight(70);
		
		// Erstelle Reinladen Button damit die Ubungsaufgabe reingeladen wird
		Button reinladen = new Button("Reinladen");
		reinladen.setTranslateX(300);
		reinladen.setTranslateY(20);
		
		// To Do wenn der Knopf gedrueckt wurde
		reinladen.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent ae){
				geladen = true;	
				stage.close();
			}
		});

		root.getChildren().add(list);
		root.getChildren().add(reinladen);
		return root;
	}

    @Override
    public void start(Stage stage){
        scene = new Scene(createContent());
        stage.setTitle("Lieblingsprojekt");
        stage.setScene(scene);
        stage.show();
    }
    
    private boolean compiliere(String codeTest, String codeMain, TextArea textKonsole){	
    	boolean result = false;
    	try{
    		CompilationUnit classTest = new CompilationUnit("TestCode", codeTest, true);
        	CompilationUnit classMain = new CompilationUnit("RomanNumberConverter", codeMain, false); 
    		JavaStringCompiler javaCompilers = CompilerFactory.getCompiler(classMain, classTest);
    		javaCompilers.compileAndRunTests();
    		result = javaCompilers.getCompilerResult().hasCompileErrors(); 
    		if(result){
    			textKonsole.setText(javaCompilers.getCompilerResult().getCompilerErrorsForCompilationUnit(classTest).toString());
    			textKonsole.setDisable(false);
    			return true;	
    		}
    		else return false;  		
    	}
    	catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public static void main(String... args) {
        launch();
    }
    
}