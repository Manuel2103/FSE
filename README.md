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

### Daten abfragen

Das Abfragen von Daten der Datenbank wird in diesem Bereich dokumentiert.

Als erstes muss ein PreparedStatement erstellt werden. Dazu wird auf unser connection die PrepareStatement Funktion aufgerufen und ein SQL Statement übergeben. Dieses Statement wird dann mit der Funktion executeQuery an dem preparedStatement aufgerufen. Als Ergebnis wird ein ResultSet zurückgegeben. Mithilfe einer while Schleife und der next Funktion kann durch das Ergebnis der Abfrage iteriert werden. Die einzelnen Daten werden mit einer Get Methode und dem Namen oder Nummer der Spalte ausgelesen. Der Code kann folgendermaßen aussehen.
```java
 PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectAllPersons);
            //Abfrage executen
            ResultSet rs = preparedStatement.executeQuery();
            //Durch das ResultSet iterieren mit .next()
            while (rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String email = rs.getString("email");
               System.out.println("Student aus der DB: ID: " + id + " Name: " + name + " EMAIL: " + email);
            }

```

### Daten hinzufügen

Ähnlich wie das Abfragen von Daten wird zuerst eine Verbindung zu der Datenbank hergestellt. Es wird auch PreparedStatement erstellt wobei die zu einfügenden Daten nicht direkt in das Insert Statement geschrieben werden, sonder ? als Placeholder. Dies verhindert eine SQL Injektion und die Geschwindigkeit erhöht, da das Statement schon vorgeladen ist. Damit das Einfügen auch gemacht wird muss am preparedStatement executeUpdate aufgerufen werden. Diese Funktion gibt einen Integer zurück wie viele Zeile betroffen waren. Beispiel Code: 
```Java
 //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, ?, ?)");
            try {
                preparedStatement.setString(1, "Peter Zeck");
                preparedStatement.setString(2, "p.zeck@gmail.com");
                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Datensätze eingefügt: " + rowAffected);

            }catch (SQLException ex) {
                System.out.println("Fehler im der SQL-INSERT Statement: " + ex.getMessage());
            }
```

### Daten ändern

Um Daten zu ändern wird wieder eine Verbindung zu Datenbank erstellt. Danach wird ein preparedStatement mit einem UPDATE erstellt, wobei die Daten wieder mit einem ? später eingefügt werden. Die Daten werden mit set Funktionen eingefügt und die Anzahl der aktualisierten Daten wird mit der executeUpdate Methode zurückgegeben. 

```java
PreparedStatement preparedStatement = conn.prepareStatement("UPDATE `student`SET `name` = ?, `email`= ? WHERE `student`.`id` = 5");
            try {

                preparedStatement.setString(1, "Hans Zimmer");
                preparedStatement.setString(2, "Hans@zimmer.home");
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " Datensätze geändert.");

            }catch (SQLException ex) {
                System.out.println("Fehler im der SQL-update Statement: " + ex.getMessage());
            }
```






