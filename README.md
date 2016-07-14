##Programm für das 7. Projekt vom Programmierpraktikum 

Für alle Beteiligten hier einige Infos zum Import:<br />
1. Damit der Ordner lokal für euch verfügbar ist muss folgender Code in der Kommandozeile eingegeben werden:<br />
git clone https://github.com/ProPra16/programmierpraktikum-abschlussprojekt-lieblingsprojekt-1.git

Für spätere Updates nur noch den Befehl "git pull" verwenden!

### Eclipse 

Ladet euch am besten das Tool für GitHub in eclipse runter:


To install from this site, start up Eclipse 3.8.2 / 4.2.2 (Juno) or newer, then do:
Help > Install New Software... >
Copy this site's URL into Eclipse, and hit Enter.
        http://download.eclipse.org/egit/updates/
When the site loads, select the features to install, or click the Select All button.
To properly resolve all dependencies, check
[x] Contact all update sites during install to find required software
Click Next, agree to the license terms, and install.

Nun auf Import -> Git Projekt und dann entweder wenn Ihr das Reposotory local habt, das locale auswählen, oder es neu clonen.
Unter Rechtsklick auf die Dateien können dann die Dteien neu gepullt werden.

*Starte Eclipse und wähle File -> New -> Gradle Project (Import Gradle Project). Im Wizard wählt ihr als Namen Programm. Die Option "Use default location" muss deaktiviert werden. Hier wählt ihr den Programm Ordner auf euren Rechner aus den ihr vom Github repository geclont habt. Ein Klick auf Finish sollte das Projekt erfolgreich importieren.*

### IntelliJ

File -> New -> Project (bzw. Import Project) from existing sources auswählen und dort den Ordner five-buttons, der geclont wurde importieren.

Danach Rechtsklick auf den Ordner res/ und Mark directory as -> Resources Root wählen.

## Hinweise

1. Es wurde ein Ordner Protokolle erstellt, wo Teambesprechungen aufgezeichnet werden.
2. Wichtige github Befehle (siehe https://rogerdudler.github.io/git-guide/index.de.html)


# Updates

26.06.2016 - Erstellung der Aufgaben.xml Formate, damit wir auf dem Aufgabenblatt die Übungsgruppenleiter die Aufgaben in xml Format erstellen können<br />
26.06.2016 - Hinzunhme der Bibliotheken für den Java Compiler und den JUnit Testrunner dazu wurde eine neue Methode erstellt die den Code testet<br />
27.06.2016 - Einbinden der virtual-kata-lib in eclipse: Rechtsklick auf Projekt -> Build Path -> configure Bulid Path und dann unter add external Jars, die jar Datei hinzufügen<br />
29.06.2016 - Einbinden der virtual-kata-lib, sodass man nur noch ein Grandle Projekt erzeugen, bzw. importieren muss<br />
03.07.2016 - Richtige erstellung der .travis.yml Datei mit Output: "Done. Your build exited with 0."<br />
05.07.2016 - Link für den Travis Test https://travis-ci.org/ProPra16/programmierpraktikum-abschlussprojekt-lieblingsprojekt-1/branches
14.07.2016 - Erstellung der finalen Datei
