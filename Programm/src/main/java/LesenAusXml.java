import org.w3c.dom.NodeList;

import javafx.collections.ObservableList;

public class LesenAusXml extends Compilieren {
		
	// Auslesen der Aufgabennamen aus der XML-Datei
	public ObservableList<String> read_exercise(int aufgabenanzahl, ObservableList<String> items, String aufgabe, NodeList tableNodeList ) {
		for (int i = 0; i < aufgabenanzahl; i++) {
			aufgabe = tableNodeList.item(i).getAttributes().getNamedItem("name").getTextContent().toString();
			items.add(aufgabe);
		}
		return items;
	}

}
