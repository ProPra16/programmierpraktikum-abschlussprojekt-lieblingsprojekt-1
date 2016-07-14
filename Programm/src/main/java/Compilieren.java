import java.util.Collection;
import java.util.Iterator;

import javafx.scene.control.TextArea;
import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestFailure;
import vk.core.api.TestResult;

public class Compilieren {
	String konsolentext;
	JavaStringCompiler javaCompilers;
	CompilationUnit classTest, classMain;
    //Die Function um die Test/Methoden zu Testen
	public boolean compiliere(String codeTest, String nameTest, String codeMain, String nameMain,
			TextArea textKonsole) {
		boolean result = false;
		try {
			result =  starteCompiler(codeTest, nameTest, codeMain, nameMain);			
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
	
	public boolean starteCompiler(String codeTest, String nameTest, String codeMain, String nameMain){
		classTest = new CompilationUnit(nameTest, codeTest, true);
		classMain = new CompilationUnit(nameMain, codeMain, false);
		javaCompilers = CompilerFactory.getCompiler(classMain, classTest);
		javaCompilers.compileAndRunTests();
		return javaCompilers.getCompilerResult().hasCompileErrors();
		
	}
	
	
	

}
