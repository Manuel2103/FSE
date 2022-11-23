# FSE

Dokumentation und Mitschrift für fortgeschrittene Software Entwicklung.

Manuel Foidl

# Inhaltsverzeichnis

* [Datenpersistenz](#datenpersistenz)

## Datenpersistenz (JDBC)


### Entwicklungsumgebung einrichten

In diesem Abschnitt wird die Einrichtung der Entwicklungsumgebung für die JDBC (Java Database Connectivity).

Es wird XAMPP für die eine Instanz einer Datenbank verwendet. XAMPP wird nicht vollständig verwendet, sonder nur der Webserver und die Datenbank.

Als Entwicklungsumgebung wird IntelliJ verwendet mit dem Buildtool Maven. In der pom.xml wird die MySqlConnector Dependency eingebunden.

### Datenbankverbindung herstellen

In diesem Teil wird eine Verbindung zu einer Datenbank erstellt.

**Datenbank vorbereiten**

Um eine Verbindung mit einer Datenbank zu erstellen muss zuerst eine erstellt werden. Dazu haben wird phpMyAdmin von XAMPP verwendet. Dort wird eine Datenbank mit einer Tabelle erstellt auf die zugegriffen werden soll.

**Verbindung herstellen in JAVA**

Für die Verbindung benötigt man eine ConnectionURL, damit JAVA weiß wo sich die Datenbank befindet. Weiters wird ein User und das Passwort benötigt. 
Eine Verbindung könnte zum Beispiel so aussehen: 

```JAVA
 String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){

            System.out.println("Verbindung zur DB hergestellt!");
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());

        }
```



