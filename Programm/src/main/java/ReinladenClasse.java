import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javafx.scene.control.ListView;

public class ReinladenClasse {
		
		//Die beide Variabelen werden einfach im Comstructor initialisiert, und zurück gegeben.
		public String codeMain, codeTest, nameMain, nameTest;
		public boolean isBaby, isTimetrack;
		public int babyTime;
		
		public ReinladenClasse(NodeList tableNodeList, ListView<String> list, int aufgabenanzahl,Document document)
		{
			String gewaehltAufgabeName=list.getSelectionModel().getSelectedItem();
			//Suchen in der ganze Liste, bis die betroffene gefunden ist.
			for(int z=0; z<aufgabenanzahl; z++){
						String aufgabe=tableNodeList.item(z).getAttributes().getNamedItem("name").getTextContent().toString();
						if(aufgabe.equals(gewaehltAufgabeName)){
							    //hier weride die beide Variabelen einfach initianlisiert
								codeMain = document.getElementsByTagName("class").item(z).getTextContent().trim();
								codeTest = document.getElementsByTagName("test").item(z).getTextContent().trim();
								nameMain = document.getElementsByTagName("class").item(z).getAttributes().getNamedItem("name").getTextContent();
								nameTest = document.getElementsByTagName("test").item(z).getAttributes().getNamedItem("name").getTextContent();
								//hinzunahme der Inhalte von Babysteps und Timetracking
								isBaby = Boolean.parseBoolean(document.getElementsByTagName("babysteps").item(z).getAttributes().getNamedItem("value").getTextContent());
								babyTime = Integer.parseInt(document.getElementsByTagName("babysteps").item(z).getAttributes().getNamedItem("time").getTextContent());
								isTimetrack = Boolean.parseBoolean(document.getElementsByTagName("timetracking").item(z).getAttributes().getNamedItem("value").getTextContent());		
				  		}
		  	}		
		}
		//5 getters um die Werte zurueck zu geben
		public String GetNeueCodeMain(){
			return this.codeMain;
			}
		
		public String GetNameMain(){
			return this.nameMain;
			}
		
		public String GetNeueCodeTest(){
			return this.codeTest;
			}
		
		public String GetNameTest(){
			return this.nameTest;
			}
		
		public boolean GetBabystep(){
			return this.isBaby;
		}
		
		public int GetBabystepTime(){
			return this.babyTime;
			}
		
		public boolean GetTimetracking(){
			return this.isTimetrack;
			}
}
