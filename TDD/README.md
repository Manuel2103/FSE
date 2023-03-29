# FSE

Dokumentation und Mitschrift des Themas TDD.

Manuel Foidl

# AUFGABE 1: THEORIE
Arbeite dich in die Theorie zum Thema Testen bzw. Test-Driven-Development (TDD) ein. Nach dieser Aufgabe musst du
folgende Punkte erklären können:
- Testdriven Development
- Red-Green-Refactor
- FIRST-Acronym
- Kent Beck (welche Rolle spielt er in Bezug auf TDD)
- Testarten
  - Unit-Tests (Sociable, Solitary, Mocks)
  - Integrationstests
  - UI-Tests / End-To-End Tests / Systemtests
  - Akzeptanztests
- Testpyramide
- JUNIT (Junit5)
- Mockito (Sinn und Funktionsweise von Mocking-Bibliotheken)

## Testdriven Development
Bei TDD werden bei dem Erstellen eines neuen Projekts mit den Tests begonnen. Danach wird der Code geschrieben, um die Tests von Rot auf Grün zu bringen.

## Red-Green-Refactor
![](img/red_green_refactor.webp)

Unit-Tests und mit ihnen getestete Units werden stets parallel entwickelt. Die eigentliche Programmierung erfolgt in kleinen, wiederholten Mikroiterationen. Eine solche Iteration, die nur wenige Minuten dauern sollte, hat drei Hauptteile, die man im englischen Red-Green-Refactor nennt.


## FIRST-Acronym

First principles of testing stand for

- Fast
- Isolated/Independent
- Repeatable
- Self-validating
- thorough


## Kent Beck
Der Wiederentdecker von TDD Kent Beck verrät, dass er die Idee aus einem äußerst alten Programmierhandbuch übernommen hat. Tatsächlich lassen sich die Ursprünge bis hin zu John von Neumann ins Jahr 1957 zurückverfolgen, der TDD seinerzeit mit vorgestanzten Lochstreifen betrieb.
Erst 1989 entwickelte Kent Beck sUnit für Smalltalk und später jUnit für Java und begründete damit das moderne TDD. Über 60 Jahre TDD sind Grund genug zu fragen, wie sich die Methodik seither weiterentwickelt hat.


## Testarten
Test werden in verschiedenen Arten unterteil. Diese Arten unterscheiden sich in der Art was getestet wird. 
### Unit-Tests (Sociable, Solitary, Mocks)
Ein Unittest (zu Deutsch auch Modultest oder Komponententests) bezeichnet das Testen der einzelnen Bestandteile eines Softwaresystems auf deren korrekte Funktionsweise. Die Tests stellen die granularste Möglichkeit dar Softwarebestandteile zu testen.

### Integrationstests
- Test des korrekten Zusammenspiels mehrerer
Programmbausteine (die jeweils für sich oft bereits
erfolgreich dem Unit Test unterzogen wurden)
- Es wird also hauptsächlich getestet, ob die definierten
Schnittstellen korrekt spezifiziert und implementiert sind
- Ausführung in speziellen Testumgebungen
- Einsatz von Automatisierungswerkzeugen äußerst sinnvoll
### UI-Tests / End-To-End Tests / Systemtests
- Test auf Funktionsfähigkeit des gesamten Systems entsprechend
der Anforderungen (Spezifikation)
- Reiner funktionaler Black-Box Test
- Zusätzlich: Security-, Performance-, Last-, Stress-, RobustheitsTest und auch andere Tests zu nicht-funktionalen Anforderungen
- Spezialfall System-Integrationstest:
Es wird das Zusammenspiel des Systems mit anderen Systemen
in seiner Umwelt getestet
- Automatisierung erstrebenswert, oft aber nicht sinnvoll möglich

### Akzeptanztests
- In Zielumgebung unter echten Einsatzbedingungen
- Test auf Erwartungen der Anwender bzw. des Kunden
- Bestätigung der Gebrauchstauglichkeit und der äußeren Qualität der
Software
- Reiner Black-Box Test
- Ideal: Abnahmekriterien aus Auftrag
- Endgültiger System-Integrationstest (Zusammenspiel des Systems mit
anderen Systemen in Zielumgebung)
- Automatisierung erstrebenswert (Regressionstests zu alten Funktionen),
allerdings neue Funktionen meist manuell durch Kunde

## Testpyramide
![](img/testpyramide.png)

Die Basis bilden einfache Unit Tests. Diese prüfen einen Großteil der Business Logik ab. Darauf setzen weitere Tests, welche durch Einbeziehung der Persistenzschicht eine höhere Komplexität aufweisen. Hier kann eine Unterteilung in zwei Teilebenen die Ausführung vereinfachen. Zum einen können Tests gegen eine In-Memory-DB ausgeführt werden. Dies beschränkt die Tests auf den lokalen Entwicklerrechner und reduziert damit Störungen durch Änderungen an der Testumgebung. Zum anderen ist der Datenbestand einer entsprechenden Datenbank immer identisch und somit ist eine Eindeutigkeit von Testergebnissen sichergestellt. Die Arbeit mit Realdaten ist aber in jedem Fall notwendig. Die oberste Testebene stellen dann Integrationstests dar. Nur auf einer Serverumgebung können Elemente wie Korrektheit von Konfigurationen, Firewall, Netzwerkperformance und Zusammenspiel aller Anwendungen in entsprechenden Versionen geprüft werden.

## JUNIT (Junit5)
JUnit ist das mit Abstand am weitesten verbreitete Framework zur Erstellung von Tests für Java-Programme. Es fokussiert die Erstellung von automatisierten Modultests für Java-Methoden. Das Framework wurde ursprünglich von Erich Gamme und Kent Beck entwickelt und orientierte sich an SUnit für Smalltalk.

JUnit 5 ist die aktuellste Version des JUnit Frameworks. Das 5te Majorrelease ist deswegen einen gesonderten Blick wert, weil mit ihm das Framework grundlegend überarbeitet wurde. Mit dem Upgrade auf die Version 5 wurde das populäre Testframework erstmals in verschiedene Module aufgeteilt. Hintergrund der Modularisierung sind die zunehmend aufkommenden Anforderungen an die Integrationsfähigkeit von und in JUnit.

## Mockito

Mockito ist eine open source Framework für das Erstellen von mocking Objekte für Software Tests. Ein Mock Objekt ist eine Dummy Implementierung einer Klasse oder Interface und erlaubt es uns Werte bei bestimmten Methodenaufrufe zurückzusenden. Somit muss man kein konkretes Objekt erstellen. 

![](/img/mockitousagevisualization.png)


# AUFGABE 2: AUSGANGSPROJEKT
Laden Sie sich das gegebene Maven-Ausgangsprojekt („TDD Kino Demo“, siehe Moodle) herunter. Laden Sie es
als Maven-Projekt in ihre IDE und schauen Sie sich an, wie das Projekt aufgebaut ist:
- pom.xml (Dependencies, Java-Version etc.)
- Gegebene Domänen-Klassen (Kinosaal, Ticket etc.)
- Gegebene Start-Junit5-Tests in test /java/at.itkolleg/AppTest
Starten Sie den Test AppTest über den grünen Pfeil und versichern Sie sich, dass alles korrekt läuft. Starten Sie
auch die App (main-Methode).



