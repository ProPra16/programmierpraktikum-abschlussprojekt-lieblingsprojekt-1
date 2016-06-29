import java.io.File;
import java.io.FileWriter;

public class Speichern {
	
  public static void speichere(JavaFile file){
	  File datei = new File(file.getName() + ".java");
	  try{
      FileWriter schreiber = new FileWriter(datei);
      schreiber.write(file.getCode());
      schreiber.close();
	  }
	  catch (Exception e) {
        e.printStackTrace();
    }
  }
}