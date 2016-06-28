
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javafx.scene.control.ListView;



public class ReinladenClasse {
		
		//Die beide Variabelen werden einfach im Comstructor initialisiert, und zurück gegeben.
		public String codeMain, codeTest;
		
		public ReinladenClasse(NodeList tableNodeList, ListView<String> list, int aufgabenanzahl,Document document)
		{
			
			String gewaehltAufgabeName=list.getSelectionModel().getSelectedItem();
			
			//Suchen in der ganze liste, bis die betroffene gefunden ist.
				for(int z=0; z<aufgabenanzahl; z++)
		  	{
						String aufgabe=tableNodeList.item(z).getAttributes().getNamedItem("name").getTextContent().toString();
						
						if(aufgabe.equals(gewaehltAufgabeName))
				  		{
							    //hier weride die beide Variabelen einfach initianlisiert
								codeMain=document.getElementsByTagName("class").item(z).getTextContent();
								codeTest=document.getElementsByTagName("test").item(z).getTextContent();
				  		}
						
			
		  	}
				
			
			
		}
		//2 getters um die werten zurück zu geben
		public String GetNeueCodeMain(){return this.codeMain;}
		public String GetNeueCodeTest(){return this.codeTest;}
		
		
		
		
		
		
		

	

	
	

}
