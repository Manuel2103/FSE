# FSE

Dokumentation und Mitschrift des Themas OOA.

Manuel Foidl

# Inhaltsverzeichnis
- [FSE](#fse)
- [Inhaltsverzeichnis](#inhaltsverzeichnis)
- [OBJEKTORIENTIERTE ANALYSE](#objektorientierte-analyse)
  - [Ziele](#ziele)
  - [Requirements-Engineering](#requirements-engineering)
  - [Strukturelle Modellierung](#strukturelle-modellierung)
    - [Objektdiagramm](#objektdiagramm)
  - [Dynamische Modellierung](#dynamische-modellierung)
    - [Flussdiagramm](#flussdiagramm)
- [ANFORDERUNGSANALYSE MIT ANWENDUNGSFÄLLEN](#anforderungsanalyse-mit-anwendungsfällen)
  - [Grundlagen](#grundlagen)
  - [Vorgehensweisen](#vorgehensweisen)
  - [Werkzeuge](#werkzeuge)
  - [Dokumentation](#dokumentation)
- [ANFORDERUNGSANALYSE MIT USER STORIES UND EPICS](#anforderungsanalyse-mit-user-stories-und-epics)
  - [Grundlagen](#grundlagen-1)
  - [Vorgehensweisen](#vorgehensweisen-1)
  - [Werkzeuge](#werkzeuge-1)
  - [Dokumentation](#dokumentation-1)
- [WICHTIGE UML-DIAGRAMMARTEN](#wichtige-uml-diagrammarten)
  - [Klassendiagramm](#klassendiagramm)
  - [Sequenzdiagramm](#sequenzdiagramm)
  - [Zustandsdiagramm](#zustandsdiagramm)
- [TEXTUELLES DIAGRAMM-DESIGN-TOOL](#textuelles-diagramm-design-tool)
- [USE-CASE-DIAGRAMM 1](#use-case-diagramm-1)
- [USE-CASE-DIAGRAMM 2](#use-case-diagramm-2)
- [USE-CASE-DIAGRAMM 3](#use-case-diagramm-3)
- [USE-CASE-DIAGRAMM 4](#use-case-diagramm-4)
- [USE-CASE-DETAILBESCHREIBUNGEN](#use-case-detailbeschreibungen)
- [KLASSENDIAGRAMME 1](#klassendiagramme-1)
- [KLASSENDIAGRAMME 2](#klassendiagramme-2)
- [KLASSENDIAGRAMME 3](#klassendiagramme-3)
- [KLASSENDIAGRAMME 4](#klassendiagramme-4)
- [SEQUENZDIAGRAMM 1](#sequenzdiagramm-1)
- [SEQUENZDIAGRAMM 2](#sequenzdiagramm-2)
- [AKTIVITÄTSDIAGRAMM 1](#aktivitätsdiagramm-1)
- [AKTIVITÄTSDIAGRAMM 2](#aktivitätsdiagramm-2)
- [ZUSTANDSDIAGRAMM 1](#zustandsdiagramm-1)
- [ZUSTANDSDIAGRAMM 2](#zustandsdiagramm-2)
- [C4-DIAGRAMM](#c4-diagramm)
  - [System Context diagram](#system-context-diagram)
  - [Container diagramm](#container-diagramm)
  - [Component diagramm](#component-diagramm)
  - [Code Diagramm](#code-diagramm)


# OBJEKTORIENTIERTE ANALYSE

Arbeite dich in die Grundprinzipien der Objektorientierten Analyse (OOA) ein.
## Ziele
- In der Analyse geht es darum, die Anforderungen zu erfassen und zu beschreiben, die das zu entwickelnde Softwaresystem erfüllen soll.
-  alle Fakten gesammelt, dargestellt und überprüft
-  Ergebnis der Analyse ist ein allgemeines Produktmodell in Form eines objektorientierten Analyse-Modells (OOA-Modell).

## Requirements-Engineering
Ziel des Requirements Engineering (i. e. Anforderungsermittlung) ist es, die Anforderungen an ein neues Softwareprodukt zu ermitteln, zu spezifizieren, zu analysieren, zu validieren und daraus eine fachliche Lösung abzuleiten beziehungsweise ein Produktmodell zu entwickeln. Sie führen zu einem integrierten Modell der funktionalen Anforderungen, in dem alle relevanten Systemaspekte berücksichtigt sind. Nichtfunktionale Anforderungen können allerdings nur textuell oder durch individuelle Erweiterung erfasst werden.
Funktionale Anforderungen lassen sich wie folgt einteilen: 
- Anforderungen, die die Statik des Systems beschreiben,
- Anforderungen, die die Dynamik des Systems beschreiben und
- Anforderungen, die die Logik des Systems beschreiben.
Nichtfunktionale Anforderungen, auch Technische Anforderungen oder „Quality of Service“ (kurz QoS) genannt, meinen Aspekte wie Zuverlässigkeit, Verfügbarkeit, Nebenläufigkeit, Konsumierbarkeit, Internationalisierung, Informationssicherheit, Service-Anforderungen und Support.

Alle Anforderungen des Auftraggebers werden im Lastenheft niedergeschrieben. Somit ist das Lastenheft die Grundlage der Lösungsfindung. Dabei sollen folgende Ziele verfolgt werden:
- Die Beschreibung der Ausgangslage zum Projekt (Ist-Situation, Ziel und Zweck, Geltungsbereich etc.),
- die Beschreibung der Anforderungen an das zu realisierende Projekt,
- die Sicherstellung, dass wichtige Themenkreise nicht vergessen werden,
- die klare Abgrenzung zum Umfang des zu erstellenden Projekts und
- die Übereinstimmung über Art und Umfang der Projektaufgabe hinsichtlich der Vorstellungen des Auftraggebers und des Auftragnehmers.

Das Pflichtenheft hingegen beinhaltet die vom Auftragnehmer erarbeiteten Realisierungsvorgaben auf Basis des Lastenhefts. Lasten- und Pflichtenheft sollen den Systemanalytiker also in die Lage versetzen, das OOA-Modell zu erstellen.

## Strukturelle Modellierung
Zur Modellierung der inneren Struktur eines Systems werden Strukturdiagramme herangezogen. Die beiden wichtigsten Diagrammtypen des objektorientierten Designs sind Klassendiagramm und Objektdiagramm.

### Objektdiagramm
Ein Objektdiagramm kann als Sonderfall des Klassendiagramms angesehen werden. Während ein Klassendiagramm die allgemeinen „Schablonen“ und alle möglichen Beziehungen der Objekte untereinander modelliert, stellt das zugehörige Objektdiagramm die tatsächlich erzeugten Objekte, deren Attributwerte und Beziehungen innerhalb eines begrenzten Zeitraums der Laufzeit dar. Beispiel für ein Objektdiagramm: [Beispiel Objektdiagramm](https://de.wikipedia.org/wiki/Objektdiagramm)

## Dynamische Modellierung 
Dynamische Modellierung ist die Erstellung von Modellen, die das Verhalten von Systemen beschreiben, wenn sie ausgeführt werden. Diese Modelle beschreiben, wie Objekte in einem System interagieren, wie sie Nachrichten senden und empfangen, wie sich Zustände ändern und wie sich das System im Laufe der Zeit verhält.

Ein Beispiel für dynamische Modellierung in UML ist das Sequenzdiagramm, das die Interaktionen zwischen Objekten in einer bestimmten Sequenz darstellt. Es zeigt, wie Nachrichten von einem Objekt zum anderen gesendet werden und wie das System auf diese Nachrichten reagiert.

### Flussdiagramm
Ein Programmablaufplan (PAP) ist ein Ablaufdiagramm für ein Computerprogramm, das auch als Flussdiagramm (engl. flowchart) oder Programmstrukturplan bezeichnet wird. Es ist eine grafische Darstellung zur Umsetzung eines Algorithmus in einem Programm und beschreibt die Folge von Operationen zur Lösung einer Aufgabe. Beispiel: ![](img/Flowchart.png)

# ANFORDERUNGSANALYSE MIT ANWENDUNGSFÄLLEN
Arbeite dich in die Grundprinzipien der Anforderungsanalyse mit USE-Cases (Diagramm + textuelle Beschreibung + Mockup) ein.
## Grundlagen
Mit Anwendungsfällen (englisch use cases) werden die extern beobachtbaren Funktionen spezifiziert, das heißt das, was ein Anwendungssystem einem Benutzer anbieten soll. Ein Akteur ist dabei eine außerhalb des Systems liegende Einheit, die an der Interaktion mit dem System beteiligt ist. Dies kann ein Mensch sein, aber ebenso ein technisches System wie ein Betriebssystem oder ein Drucker. Folgende Regeln sind zu beachten:
- An jedem Anwendungsfall ist mindestens ein Akteur beteiligt.
- Jeder Anwendungsfall hat einen fachlichen Auslöser.
- Jeder Anwendungsfall produziert ein für die Akteure relevantes fachliches Ergebnis, d. h. ein Ergebnis von „geschäftlichem Wert“.

## Vorgehensweisen
Bei einer Anforderungsanalyse geht man wie folgt vor:
- Ermittlung und Analyse
- Strukturierung und Abstimmung 
- Prüfung und Bewertung
  
[Genauere Beschreibung der einzelnen Phasen](https://de.wikipedia.org/wiki/Anforderungsanalyse_(Informatik))
## Werkzeuge
Für die Dokumentation kann man einen entweder eine Textverarbeitungssoftware oder ein Zeichenprogramm verwenden. Die Anforderungen können erhoben werden durch die Befragung der Stakeholder z.B. mithilfe eines Fragebogens oder Interviews.

## Dokumentation
Anforderungen können textuell mithilfe von Use Cases, User Stories oder grafisch mit einem Use Case Diagramm dokumentiert werden.

# ANFORDERUNGSANALYSE MIT USER STORIES UND EPICS
Arbeite dich in die Grundprinzipien der Anforderungsanalyse mit User-Stories und Epics ein.
## Grundlagen
Ein Epic in der Anforderungsanalyse ist eine große, umfassende Anforderung oder eine Zusammenstellung von mehreren Anforderungen, die eine signifikante Funktionalität, eine Hauptfunktion oder ein Ziel für das Projekt beschreiben. Ein Epic ist normalerweise zu groß, um in einem Sprint oder einer Iteration abgeschlossen zu werden und wird in kleinere Teile aufgeteilt, die als User Stories bezeichnet werden.
## Vorgehensweisen
Um einen guten Epic zu erstellen sollten folgende Faktoren berücksichtigt werden:
1. Identifizierung der Epics
1. Definieren der Anforderungen
1. Schätzen des Umfangs des Epics
2. Priorisierung von Epics
3. Unterteilen des Epics in kleinere User Stories
4. Verfolgung des Fortschritts 
5. Überprüfung des Fortschritts
  
## Werkzeuge
Für die Formulierung von Epics ode User Stories werden Satzschablonen verwendet. Diese können wie folgt lauten: 
- Als (Rolle) möchte ich (Funktionalität), um (Nutzen) zu erreichen.
- Um (Nutzen) als (Rolle) zu erreichen, möchte ich (Funktionalität/Ziel/Wunsch).
- Als (Rolle) möchte ich (was) (warum).
- Als (wer) (wann) (wo) möchte ich (was) (warum).
Für die Erstellung der können Agile Projektmanagement-Tools verwendet werden.
## Dokumentation
Es gibt verschiedene Tools, die Sie verwenden können, um Epics und User Stories zu dokumentieren, wie beispielsweise Jira, Trello, oder Notiz-Apps wie Evernote. Wichtig ist jedoch, dass das Dokumentationsformat konsistent bleibt und alle wichtigen Informationen enthalten sind, um sicherzustellen, dass das Entwicklungsteam die Anforderungen versteht und das Produkt erfolgreich entwickeln kann.

# WICHTIGE UML-DIAGRAMMARTEN
Arbeite dich in folgende Diagrammarten ein:
## Klassendiagramm
Ein Klassendiagramm ist ein Strukturdiagramm der Unified Modeling Language (UML) zur grafischen Darstellung (Modellierung) von Klassen, Schnittstellen sowie deren Beziehungen. Alle möglichen Elemente und Beziehungen in einem Klassendiagramm werden hier aufgelistet: [Notation Klassendiagramm](https://de.wikipedia.org/wiki/Klassendiagramm)
Beispiel Klassendiagramm: 

![](img/Klassendiagramm.png)

## Sequenzdiagramm
Eine Sequenz von Verarbeitungsschritten, die unter bestimmten Bedingungen auszuführen ist, wird Szenario genannt. Diese Schritte sollen das Hauptziel des Akteurs realisieren und ein entsprechendes Ergebnis liefern. Man unterscheidet zwei Kategorien von Szenarios: Solche, die eine erfolgreiche Bearbeitung des Geschäftsprozesses beschreiben, und solche, die zu einem Fehlschlag führen. Sequenzdiagrammen sollen Szenarios so präzise modelliert werden, dass deren fachliche Korrektheit diskutiert werden kann, um eine geeignete Vorgabe für Design und Implementierung zu erstellen. Sequenzdiagramme beschreiben den Austausch von Nachrichten zwischen Ausprägungen mittels Lebenslinien und stellen in der Regel einen Weg durch einen Entscheidungsbaum innerhalb eines Systemablaufes dar. Sie besitzen zwei Dimensionen: Die Vertikale repräsentiert die Zeit, auf der Horizontalen werden die Objekte eingetragen. Notation eines Sequenzdiagramms: [Notation Sequenzdiagramm](https://www.uml-diagrams.org/sequence-diagrams.html) 
Beispiel: ![](img/Sequenzdiagramm.png)

## Zustandsdiagramm
Der Zustand eines Objekts wird durch seine Attributwerte festgelegt. Je nachdem, in welchem Zustand sich nun ein Objekt befindet, kann es auf gleiche eingehende Nachrichten unterschiedlich reagieren. Dieses Verhalten von Objekten kann durch Zustandsautomaten modelliert werden: Dabei handelt es sich um eine Menge von Zuständen und eine Übergangsfunktion, die abhängig vom momentanen Zustand und dem eingehenden Ereignis den Nachfolgezustand bestimmt. Notation ist hier zu finden: [Notation Zustandsdiagramm](https://de.wikipedia.org/wiki/Zustandsdiagramm_(UML))
Beispiel: 

![](img/Zustandsdiagramm.png)

# TEXTUELLES DIAGRAMM-DESIGN-TOOL

Für das Erstellen der Diagramme wird das Tool Mermaid verwendet. Mit Mermaid können Diagramm textuell erstellt werden. 
Link: https://mermaid.live/

# USE-CASE-DIAGRAMM 1
Interpretieren Sie schriftlich das folgende Use-Case-Diagramm:
![](img/Usecase1.png)
Interpretation: 
Bei diesem Use Case handelt es sich um Online Shopping. Bei dem Online Shopping gibt es einen Kunden. Dieser Kunde lässt sich in einen neuen Kunden und einen registrierten Kunden aufteilen. Ein neuer Kunde hat die Möglichkeit die Waren anzusehen oder sich zu registrieren. Das Registrieren erfordert eine Authentication damit die Registrierung abgeschlossen ist. Hingegen der bereits registrierte Kunde die Waren anschauen und auch diese bestellen kann. Das Bestellen grundsätzlich beinhaltet zwei Vorgänge, einmal das anschauen/aussuchen der Waren und den Checkout. Der Checkout verwendet verschiedene Actors, um den Checkout durchzuführen. Diese wären die Authentication, Identity Provider, Credit Payment Service, PayPal.

# USE-CASE-DIAGRAMM 2
Interpretieren Sie schriftlich das folgende Use-Case-Diagramm:
![](img/UseCase2.jpg)
Das Use-Case-Diagramm zeigt einen Bestellvorgang bei einem Essenslieferant. Es gibt drei Actors Hungriger Kunde, Bezahlsystem, E-Mail-System. Der Hungrige Kunde kann entweder mit der Kundenregistrierung oder mit der Funktion Essen bestellen kommunizieren. Die Bestellung beinhaltet das Senden einer Bestellbestätigung. Das Bestellen wird wiederrum auch von Online bezahlen erweitert. Online bezahlen kann man entweder mit einer Kreditkarte oder mit einer EC-Karte. Das Online bezahlen kommuniziert mit dem Bezahlsystem um die Zahlung schlussendlich abzuwickeln.

# USE-CASE-DIAGRAMM 3
Entwerfen Sie ein Anwendungsfalldiagramm zu der folgenden Beschreibung:
In einem Kino kann ein Gast Kinokarten an der Kasse kaufen, die vorbestellt sein könnten. Außerdem ist es möglich Popcorn und Getränke zu bestellen. Danach bezahlt der Kunde beim Kassierer die Rechnung. Es ist auch möglich mit Kreditkarte zu bezahlen, welche bei Bedarf einer automatischen Prüfung unterzogen werden kann.

Textuell in PlantUML:
``` 
@startuml
actor Gast
actor Kassierer
rectangle Kino{
(Tickets kaufen) ..> (vorbestellen) : extends
(Snacks kaufen)
(Bezahlung)<|-- (Kreditkarte)
(Bezahlung)<|-- (Bar)
(Tickets kaufen)..>(Bezahlung) : include
(Snacks kaufen)..>(Bezahlung) : include

}
Gast -- (Tickets kaufen)
Gast -- (Snacks kaufen)
(Bezahlung) -- Kassierer
@enduml
```

Grafisch:

![](img/Usecase3.png)


# USE-CASE-DIAGRAMM 4
Entwerfen Sie ein Anwendungsfalldiagramm zu der folgenden Beschreibung:
Es soll ein Anwendungssystem zur Unterstützung der Geschäftsprozesse in einem Krankenhaus entwickelt werden. Das System soll folgende Aufgaben erledigen:
- Herr Müller und Herr Maier seien in der Verwaltung angestellt.
- Herr Müller soll Mitarbeiter einstellen und entlassen können. Sowohl Herr Müller als auch Herr Maier kann Patienten aufnehmen und entlassen.
- Sowohl bei der Einstellung von Mitarbeitern, als auch bei der Aufnahme von Patienten müssen Name und Adresse erfasst werden. Um redundante Anwendungsfall-Beschreibungen zu verhindern wird diese Tätigkeit in einen gesonderten Anwendungsfall ausgelagert.
- Falls der einzustellende Mitarbeiter bzw. der aufzunehmende Patient seinen Wohnsitz am Ort des Krankenhauses hat, wird geprüft, ob die angegebene Adresse am Wohnort existiert. Lagern Sie auch diesen Anwendungsfall aus.
  
Textuell:
```
@startuml
left to right direction
actor "Verwaltung" as v
actor "Herr Maier" as ma
actor "Herr Müller" as mü
actor "Mitarbeiter" as mit
actor "Patient" as pat
v<|-- ma
v<|-- mü

rectangle Erfassung{
  usecase "Adresse erfassen" as ort
  usecase "Adresse prüfen" as prüf
  ort<..prüf : include
  usecase "Name erfassen" as n
}

rectangle "Patienten Abwicklung"{
  usecase "Patient entlassen" as ent
  usecase "Patient aufnehmen" as auf
}
rectangle "Mitarbeiter Verwaltung"{
  usecase "Mitarbeiter kündigen" as ku
  usecase "Mitarbeiter einstellen" as ein
}
v--"Patienten Abwicklung"
auf<..Erfassung : include 
ent -- pat
auf -- pat
mü -- "Mitarbeiter Verwaltung"
ein<..Erfassung : include
ku--mit
ein--mit
@enduml
```
Grafisch: 

![](img/Usecase4.png)

# USE-CASE-DETAILBESCHREIBUNGEN
Definieren Sie die Use-Case-Details (level, complexity, status, pre-conditions, post-conditions and assumptions, event flow etc.) für einige Use-Cases der vorhergehenden Use-Case-Übungen. Verwenden Sie dazu eine der bereitgestellten Schablonen bzw. ein entsprechendes Software-Tool.

| Task                     | Beschreibung                                                                                                                   |
| ------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| **Name**                 | Online Shopping                                                                                                                |
| **Ziel im Kontext**      | Produkte zu kaufen                                                                                                             |
| **Akteure**              | Kunde, Identity Provider, Credit Payment Service, PayPal, Authentication                                                       |
| **Trigger**              | Kunde besucht die Webseite und möchte etwas kaufen                                                                             |
| **Essenzielle Schritte** | 1. Produkte anschauen <br> 2. Produkte bestellen <br> 3. Checkout mit Authentifizierung und Zahlung                            |
| **Erweiterungen**        | 2a. Kunde muss registriert sein, um diese Funktion zu nutzen. <br> 2b. Registrierung erfolgt über einen Authentication Service |

# KLASSENDIAGRAMME 1

Gegeben ist folgendes Klassendiagramm:
![](img/Klassendiagramm1.png)

Bestimmen Sie, ob die folgenden Aussagen zum Klassendiagramm richtig oder falsch sind.
- Es kann im System Kunden geben die nie eine Bestellung durchgeführt haben. **Richtig**
- Die Klasse Einzahlung ist die Oberklasse der Klasse Bestellung. **Falsch**
- Jedes Objekt der Klasse Bestellung_Detail besitzt genau einen Artikel. **Richtig**
- Alle Einzahlungen mit Kreditkarte haben einen Betrag. **Richtig**
- Es ist möglich, dass ein Artikel keine Assoziation mit einem Bestellung_Detail besitzt. **Richtig**
- Jedes Bestellung_Detail, das Teil einer Bestellung ist, hat seinen eigenen Status und sein eigenes Datum. **Falsch**

# KLASSENDIAGRAMME 2
Gegeben ist der folgende Sachverhalt.
Jede Person hat einen Namen, eine Telefonnummer und E-Mail. Jede Wohnadresse wird von nur einer Person bewohnt. Es kann aber sein, dass einige Wohnadressen nichtbewohnt sind. Den Wohnadressen sind je eine Strasse, eine Stadt, eine PLZ und ein Land zugeteilt. Alle Wohnadressen können bestätigt werden und als Beschriftung (für Postversand) gedruckt werden. Es gibt zwei Sorten von Personen: Student, welcher sich für ein Modul einschreiben kann und Professor, welcher einen Lohn hat. Der Student besitzt eine Matrikelnummer und eine Durchschnittsnote.
Modellieren Sie diesen Sachverhalt mit einem UML Klassendiagramm.

```mermaid
classDiagram
    Person <|-- Student
    Person <|-- Professor
    Person "1" --> "0..1" Wohnadresse
    class Person{
      -String namen
      -String telefonnummer
      -String eMail
    }
    class Wohnadresse{
      -String strasse
      -String stadt
      -String plz
      -String land
      +bestaetigeWohnadresse()
      +druckeBeschriftung()
    }
    class Student{
      -String matrikelnummer
      -int durchschnittsnote
      +einschreibenModul()
    }
    class Professor{
        -double lohn
    }
```

# KLASSENDIAGRAMME 3
Sie haben den Auftrag, eine Online-Videothek zu realisieren. Sie haben dazu folgende Angaben erhalten:
-	Die Videothek unterstützt das Ausleihen von Filmen für registrierte Kunden. Dazu müssen
-	Kunden sich zunächst mit ihrer Kundennummer und ihrem Passwort anmelden.
-	Kunden werden zusammen mit ihrem Guthaben verwaltet.
-	Filme besitzen einen individuellen Namen und Preis.
-	Ein Film wird über einen Streaming-Server bereitgestellt. Der Server kann hierzu einen kundenspezifischen Link generieren.

```mermaid
classDiagram
    Server "1" --> "*" Film
    Kunde "*" --> "*" Film
    class Kunde{
      -String kundennummer
      -String passwort
      -double guthaben
      -Arraylist<Film> filmliste
      +anmelden(kundennummer : String, passwort : String)$ : Kunde
      +guthabenAbbuchen(preis : double) : void
      +guthabenHinzufuegen(guthaben : double) : void
      +leiheFilm() : void
      +freigebenFilm() : void
      +getter()
      -setter()
    }
    
    class Film{
      -String name
      -double preis
      +getter()
      -setter()
    }
    class Server{      
      +erstelleLink(kunde : Kunde)$
      +getter()
      -setter()
    }
```


# KLASSENDIAGRAMME 4
Interpretieren Sie schriftlich das folgende Klassendiagramm:
![](img/Klassendiagramm4.png)
Das Spielobjekt ist eine abstrakte Klasse die von der Klasse Raumschiff und einer weiteren abstrakten Klasse Laserschuss extended. Laserschuss vererbt an die Klassen LaserschussGross und LaserschussKlein. Raumschiff verwendet n Laserschüsse und besitzt 0 bis 10 Schussvorrichtungen. Die Schussvorrichtung ist eine abstrakte Klasse an Vorrichtung Gross und VorrichtungKlein vererbt.

# SEQUENZDIAGRAMM 1
Interpretieren Sie schriftlich das folgende Sequenzdiagramm:
![](img/Sequenzdiagramm1.png)

In diesem Sequenzdiagramm geht es, um die Funktion einen Kommentar zu schreiben. 
Zu Beginn wird die mitgegebene Nachricht validiert. Danach wird eine Nachricht an den Ajax Proxy erstellt. Weiters wird ein CAPTCHA CHECK durchgeführt. Sollten keine Fehler auftreten werden die Kommentare geposted. Dazu wird eine Anfrage an den Ajax Proxy erstellt und gesendet. Der Proxy sendet den postComments an den PluckService. und dieser gibt als Antwort ein JSON zurück. Nachdem wird ein callback an das Applikations Fenster gesendet und dort werden Fehler gehandelt sofern es welche gibt. Zum Schluss werden all Kommentare angefragt.

# SEQUENZDIAGRAMM 2
Modellieren Sie für die Online-Videothek (siehe Aufgabe 3) die Film Ausleihen Funktion. Erstellen Sie dazu ein Sequenzdiagramm für folgenden Ablauf der Ausleihe:
-	Die Videothek berechnet zuerst, ob das Guthaben des Kunden reicht um den Film zu bezahlen.
-	Reicht das Guthaben nicht aus, wird stattdessen eine Aufforderung zum Ausfüllen des Guthabens
angezeigt.
-	Falls das aktuelle Guthaben des Mitglieds ausreicht, veranlasst die Videothek einen Streaming-
Server einen Link für den Film zu generieren.
-	Die Videothek zeigt dem Benutzer den Link an, unter dem der Film zugreifbar ist.
Gehen Sie davon aus, dass sich das Mitglied bereits auf der Seite des gewünschten Films beendet.

```mermaid
sequenceDiagram
    Kunde->>+Videothek: Film ausleihen
      opt Guthaben zu wenig
      Videothek-->>-Kunde: Aufforderung zum Auffüllen des Guthaben
      Kunde->>+Videothek: Guthaben aufladen
    end
    Videothek->>+Server: Link generieren
    Server -->>- Videothek: Link zurücksenden
    Videothek->>+Kunde: Link anzeigen
```

# AKTIVITÄTSDIAGRAMM 1
Interpretieren Sie schriftlich das folgende Aktivitätsdiagramm:

![](img/Aktivit%C3%A4tsdiagramm1.png)

Des Diagramm beschreibt die Aktivität, wie ein Pendler eine Ticket am Automaten kauft.
Zu Beginn wird eine Session gestartet. Als Nächstes wird die Reiseinfo angefragt und dem Pendler zurückgegeben. Danach wird das Reiseziel eingegeben und von dem Automaten bearbeitet. Dieser fragt den Pendler für eine Zahlung und darauf gibt der Pendler seine Zahlungsinformation ein. Daraufhin werden diese Daten verarbeitet. Zuerst wird eruiert, ob ob es sich um eine Bar-oder Kartenzahlung handelt. Sollte es sich um eine Karte handelt wird die Karte von der Bank autorisiert. Nach den Zahlungstätigkeiten wird das Ticket gedruckt und ausgegeben und der Pendler nimmt sich das Ticket. Wurde mit Bargeld bezahlt wird das Wechselgeld noch ausgeworfen und der Pendler kann dieses entnehmen und zu Letzt wird Danke angezeigt.

# AKTIVITÄTSDIAGRAMM 2
Modellieren Sie schriftlich den folgenden Sachverhalt als Aktivitätsdiagramm: 

Ein Fluggast ist am Flughafen angekommen. Zur Überprüfung seines Tickets begibt er sich zum Schalter seiner Fluggesellschaft. Falls das Ticket in Ordnung ist, übergibt er am Schalter sein Gepäck. Falls mit dem Ticket etwas nicht stimmt, muss der Fluggast den Kundendienst konsultieren und er kann nichtmitfliegen. Das Gepäck wird zudem auf Übergewicht überprüft. Falls dem so ist, muss der Fluggast zusätzliche Kostenübernehmen. Falls aber das Gewicht in Ordnung ist, wird die Bordkarte ausgestellt.

Ankunft Flughafen -> Überprüfung der Tickets am Schalter -> Ticket in Ordnung -> Gepäck wird übergeben -> Gewicht des Gepäcks überprüfen -> bei Übergewicht Mehrkosten, ansonsten Bordkarte zustellen, Ticket nicht in Ordnung -> Kundendienst konsultieren

# ZUSTANDSDIAGRAMM 1
Interpretieren Sie schriftlich das folgende Zustandsdiagramm:

![](img/Zustandsdiagramm1.png)

In diesem Diagramm wird der Zustand eines Bankautomaten dargestellt. Der initiale Zustand ist der ausgeschaltete Zustand. Durch das Starten wird zuerst der Selbsttest durchgeführt. Sollte des fehlschlagen schlägt der Zustand Out of Service an. Daraufhin folgt das Ausschalten oder ein Service. Bei erfolgreichem Selbsttest kommt der Automat in den Leerlauf. Entweder wird dann ein Service gemacht oder eine Karte hineingesteckt. Bei Zweiteren wird der Service Customer angesprochen. Dieser Beginnt nachdem die Karte gelesen wurde. Danach wird der Kunde authentifiziert, die Transaktion ausgewählt, die Transaktion durchgeführt und die Karte ausgegeben. 

# ZUSTANDSDIAGRAMM 2
Entwerfen Sie ein Zustandsdiagramm für eine Bestellung auf Amazon. Modellieren Sie dazu die Zustände und die Übergänge einer Bestellung vom Aufgeben der Bestellung bis hin zur Aushändigung des Paketes an den Kunden. 
```mermaid
stateDiagram
    [*] --> Bestellung
    Bestellung --> Zahlung
    Zahlung --> Bestellung: fehlgeschlagen
    Zahlung --> Bestätigung
    Bestätigung --> Versandvorbereitung
    Versandvorbereitung --> Versand
    Versand --> Lieferung
    Lieferung --> Kunde
    Kunde --> Lieferung: nicht erhalten
    Kunde -->[*]
```

# C4-DIAGRAMM
Arbeite dich in das C4-Modell zur Visualisierung von Architekturen von Softwaresystemen ein.
https://c4model.com
Dokumentieren Sie danach die Architektur deines Spring-Boot-Abschlussprojektes aus dem Unterricht mit dem C4-Diagrammmodell:
-	Level 1: System Context diagram
-	Level 2: Container diagramm
-	Level 3: Component diagramm
-	Level 4: Code Diagramm (Beispielhaft nur für ein paar Komponenten aus Level 3)

## System Context diagram
Ein System Context Diagram ist ein Diagramm, das eine Übersicht über ein System und dessen Umgebung bietet. Es zeigt, welche Systeme oder Akteure mit dem System interagieren und welche Schnittstellen zwischen ihnen bestehen. Das System Context Diagramm ist ein Werkzeug zur Visualisierung und Kommunikation von Systemgrenzen und Kontextinformationen.

```mermaid
    C4Context
        Person(user, "Benutzer", "Der Benutzer, der das Spiel spielt")
        System(meme, "What do you meme Applikation", "Stellt dem Benutzer verschiedene Funktionen zur Verfügung, um das Spiel zu spielen")
        System_Ext(api, "REST API Bilder", "Diese API wird für die Bilder verwendet")
        Rel(meme, api, "get pictures", "HTTP")
        BiRel(user, meme, "Uses")
        UpdateLayoutConfig($c4ShapeInRow="1", $c4BoundaryInRow="1")
```

## Container diagramm
Ein Containerdiagramm ist eine Art von Diagramm in der Softwarearchitektur, das eine Übersicht über die Container (oder auch Komponenten) eines Systems und deren Beziehungen zueinander bietet. Container können physische oder virtuelle Systeme wie z.B. Anwendungsserver, Datenbankserver oder Webserver sein, die zusammenarbeiten, um eine Anwendung zu erstellen.
```mermaid
flowchart TB

subgraph user[Benutzer]
    h1[-Person-]:::type
    d1[Benutzer der das Spiel spielt]:::description
end
user:::person

user--Besucht die Website-->webApplication
user--Verwendet die \n Funktionen-->singlePageApplication


subgraph system[what do you meme]
    subgraph webApplication[Web Anwendung]
        direction LR
        h2[Container: Java and Spring MVC]:::type
        d2[Stellt die Website zur Verfügung]:::description
    end
    webApplication:::internalContainer

    subgraph singlePageApplication[Website]
        direction LR
        h3[Container: JavaScript/Thymeleaf, HTML, CSS]:::type
        d3[Stellt alle Funktionen im Browser dar.]:::description
    end
    singlePageApplication:::internalContainer

    subgraph apiApplication[API Application]
        direction LR
        h5[Container: Java and Spring MVC]:::type
        d5[Stellt Funktionen mithilfe von JSON/HTTP bereit]:::description
    end
    apiApplication:::internalContainer

    subgraph database[Database]
        direction LR
        h6[Container: H2 Database ]:::type
        d6[In Memory Datenbank zum Testen]:::description
    end
    database:::internalContainer

    webApplication--Gibt die Website dem Browser zurück-->singlePageApplication
    singlePageApplication--Ruft die API auf-->apiApplication
    apiApplication--vewendet Datenbank-->database
end


%% Element type definitions

classDef person fill:#08427b
classDef internalContainer fill:#1168bd
classDef externalSystem fill:#999999

classDef type stroke-width:0px, color:#fff, fill:transparent, font-size:12px
classDef description stroke-width:0px, color:#fff, fill:transparent, font-size:13px
```

## Component diagramm
Ein Component-Diagramm ist ein Diagramm in der Softwarearchitektur, das die einzelnen Komponenten eines Systems und deren Beziehungen untereinander zeigt. Komponenten repräsentieren hierbei abgeschlossene, unabhängige Einheiten in der Softwarearchitektur, die spezifische Funktionen ausführen.
```mermaid
flowchart TB

  subgraph singlePageApplication[Website]
        direction LR
        h3[Container: JavaScript/Thymeleaf, HTML, CSS]:::type
        d3[Stellt alle Funktionen im Browser dar.]:::description
    end
singlePageApplication:::internalContainer

subgraph database[Database]
    direction LR
    h6[Container: H2 Database]:::type
    d6[In Memory Datenbank zum Testen, Speichert Bilder,Quotes und Memes]:::description
end
database:::internalContainer

subgraph service[ServiceLayer]
    direction LR
    h7[Container: Spring Bean]:::type
    d7[Stellt im System Services zur Verfügung]:::description
end
service:::internalContainer

singlePageApplication--Make calls to-->thymeleafcontroller
singlePageApplication--Make API calls to-->restcontroller
thymeleafcontroller--Uses-->service
restcontroller--Uses-->service

subgraph apiApplication[API Application]


    subgraph thymeleafcontroller[Thymeleaf Controller]
        direction LR
        h30[Component: Spring Thymeleaf Controller]:::type
        d30[Wird verwendet für die verschiedensten Funktionen]:::description
    end
    thymeleafcontroller:::internalComponent

    subgraph restcontroller[REST Controller]
        direction LR
        h40[Component:  REST Controller]:::type
        d40[REST Controller für verschiedene Funktionen mittels JSON]:::description
    end
    restcontroller:::internalComponent
 
end

service--Lese und Schreib Zugriff-->database

%% Element type definitions

classDef person fill:#08427b
classDef internalContainer fill:#1168bd
classDef internalComponent fill:#4b9bea
classDef externalSystem fill:#999999

classDef type stroke-width:0px, color:#fff, fill:transparent, font-size:12px
classDef description stroke-width:0px, color:#fff, fill:transparent, font-size:13px
```

## Code Diagramm
Ein Code-Diagramm ist ein Diagramm, das den Code einer Softwareanwendung oder eines Systems in einer visuellen Form darstellt. Es gibt verschiedene Arten von Code-Diagrammen, aber im Allgemeinen haben sie das Ziel, den Code verständlicher und leichter zu lesen und zu verstehen.
```mermaid
classDiagram
    ThymeleafController --> MemeService

    RESTController --> MemeService
    RESTController --> QuoteService
    RESTController --> PictureService
    MemeService <|-- MemeServiceImpl
  
    class ThymeleafController{
        - QuoteService quoteservice
        - MemeService memeservice
        - PictureService pictureservice
        +allQuotes()
        +allMemes()
        +addLike(id : long)
        +deleteMeme(id : long)
        ....()
    }
    class RESTController{
        - QuoteService quoteservice
        - MemeService memeservice
        - PictureService pictureservice
        +getRandomPicture()
        +getPicturebyID(id : long)
        +deleteQuotebyID(id : long)
        ....()
    }
          
    class MemeService{
        +speichereMeme(meme : Meme)  
        +setzeLike(id : Long)  
        +gibMemeMitId(id : Long) 
        ....() 
      
    }
    <<interface>> MemeService
    class MemeServiceImpl{
        -DbZugriffMeme dbZugriffMeme
        +speichereMeme(meme : Meme)  
        +setzeLike(id : Long)  
        +gibMemeMitId(id : Long) 
        ....() 
    }
     class QuoteService{
        ....() 
      
    }
    <<interface>> QuoteService
         class PictureService{
        ....() 
      
    }
    <<interface>> PictureService
```




