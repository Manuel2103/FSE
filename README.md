# FSE

Dokumentation und Mitschrift für fortgeschrittene Software Entwicklung.

Manuel Foidl

# Inhaltsverzeichnis

* [Datenpersistenz](#datenpersistenz-(jdbc))

# Datenpersistenz (JDBC)

## JDBC Intro Teil 1

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

### Daten löschen

Daten können gelöscht werden, wenn eine Verbindung zur Datenbank besteht und ein korrektes DELETE Statement als preparedStatement verwendet wird. Die Funktion wurde erweitert, indem jetzt Parameter übergeben werden können die bestimmen welcher Datensatz gelöscht werden soll.

```java
PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM `student` WHERE `student`.`id` = ?");
    try {
        //Fragezeichen auffüllen
        preparedStatement.setInt(1, studentID);
        // Statement ausführen
        int rowAffected = preparedStatement.executeUpdate();
        System.out.println("Anzahl der gelöschten Zeilen" + rowAffected);
    }catch (SQLException ex) {
        System.out.println("Fehler im der SQL-Delete Statement: " + ex.getMessage());
    }
```

### Daten abfragen 2

Der Aufbau dieser Funktion ändert sich nicht von [Daten abfragen](#daten-abfragen). Es ändert sich nur die Abfrage und es kann ein Parameter übergeben werden. Dieser Parameter bestimmt nach was gesucht werden soll. Das Select Statement ist so eingestellt, dass alle Ergebnisse die irgendwo diese Zeichenkette aufweisen, ausgegeben werden. 

```java
public static void findAllByNameLike(String pattern) {
        System.out.println("Find all by Name Demo mit JDBC");
        String sqlSelectAllPersons = "SELECT * FROM `student` WHERE  `student`.`name` LIKE ?";
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL,"root", "")){
            System.out.println("Verbindung zur DB hergestellt!");
            //SQL Statement vorbereiten
            PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectAllPersons);
            preparedStatement.setString(1,"%"+pattern+"%");
            //Abfrage executen
            ResultSet rs = preparedStatement.executeQuery();
            //Durch das ResultSet iterieren mit .next()
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Student aus der DB: ID: " + id + " Name: " + name + " EMAIL: " + email);
            }
        }catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }
```

## JDBC Intro Teil 2

In diesem Abschnitt wird eine weitere Tabelle erstellt und die gleichen Funktionen implementiert.

Erstellte Tabelle:

![](img/Tabelle_Hobbies.png)

Nun werden die einzelnen Funktionen dargestellt.

1. Select All Hobbies
```java
    /**
     * Gibt alle Datensätze aus.
     */
    public static void selectAll() {
        System.out.println("---------------------SelectAll---------------------");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "SELECT * FROM hobbies";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bezeichnung = rs.getString("bezeichnung");
                BigDecimal betrag = rs.getBigDecimal("beitrag");
                System.out.printf("Hobby: ID %d, Bezeichnung: %s, Betrag: %s %n", id, bezeichnung, betrag.toString());
            }
        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());
        }
    }
```
2. Insert Hobby
```java
/**
     * Fügt einen neuen Datensatz hinzu
     * @param bezeichnung Bezeichnung des Hobbies
     * @param beitrag Betrag des benötigten Vereinsbeitrages
     */
    public static void insertHobby(String bezeichnung, BigDecimal beitrag) {
        System.out.println("---------------------insertHobby---------------------");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "INSERT INTO `hobbies` (`id`, `bezeichnung`, `beitrag`) VALUES (NULL, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);
            try {
                preparedStatement.setString(1, bezeichnung);
                preparedStatement.setBigDecimal(2, beitrag);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Datensätze hinzugefügt: " + affectedRows);
            } catch (SQLException e) {
                System.out.println("Fehler beim Insert " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());
        }
    }
```
3. Update Hobby
```java
    /**
     * Aktualsiert ein Hobby.
     * @param id id des Hobbies
     * @param bezeichnung neue Bezeichnung des Hobbies
     * @param beitrag neuer Beitrag des Hobbies
     */
    public static void updateHobby(int id, String bezeichnung, BigDecimal beitrag){
        System.out.println("---------------------updateHobby---------------------");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "UPDATE `hobbies` SET `bezeichnung` = ?, `beitrag` = ? WHERE `hobbies`.`id` = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);
            try {
                preparedStatement.setString(1, bezeichnung);
                preparedStatement.setBigDecimal(2, beitrag);
                preparedStatement.setInt(3, id);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Datensätze geupdated: " + affectedRows);
            } catch (SQLException e) {
                System.out.println("Fehler beim Insert " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());
        }
    }
```
4. Delete Hobby
```java
    /**
     * einen Datensatz löschen
     * @param id id des zu löschenden Datensatzes
     */
    public static void deleteHobby(int id){
        System.out.println("---------------------deleteHobby---------------------");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "DELETE FROM `hobbies` WHERE `hobbies`.`id` = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);
            try {
                preparedStatement.setInt(1, id);
                int affectedRows = preparedStatement.executeUpdate();
                System.out.println("Datensätze gelöscht: " + affectedRows);
            } catch (SQLException e) {
                System.out.println("Fehler beim Delete " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());
        }
    }
```

5. Select Hobby Like
```java
    /**
     * Gibt alle Datensätze aus die den eingegebenen String beinhalten
     * @param suche Suchstring
     */
    public static void selectHobbyLike(String suche){
        System.out.println("---------------------selectHobbyLike---------------------");
        String connectionURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pw = "";
        try (Connection conn = DriverManager.getConnection(connectionURL, user, pw)) {
            String sqlstatement = "SELECT * FROM `hobbies` WHERE `hobbies`.`bezeichnung` LIKE ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlstatement);
            try {
                preparedStatement.setString(1, "%"+suche+"%");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String bezeichnung = rs.getString("bezeichnung");
                    BigDecimal betrag = rs.getBigDecimal("beitrag");
                    System.out.printf("Hobby: ID %d, Bezeichnung: %s, Betrag: %s %n", id, bezeichnung, betrag.toString());
                }
            } catch (SQLException e) {
                System.out.println("Fehler bei der Suche " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Fehler " + e.getMessage());
        }
    }
```


## JDBC UND DAO – STUDENTEN

In diesem Abschnitt werden CRUD (Create, Read, Update, Delete) Operationen mithilfe des DAO Patterns implementiert.

### DAO

Data Access Object (DAO) ist ein Entwurfsmuster, das den Zugriff auf unterschiedliche Arten von Datenquellen (z. B. Datenbanken, Dateisystem) so kapselt, dass die angesprochene Datenquelle ausgetauscht werden kann, ohne dass der aufrufende Code geändert werden muss.

### Projektsetup

Zu beginn wird eine Datenbank die Kurssystem Datenbank erstellt, die eine Tabelle besitzt. 

![](img/Tabelle_courses.png)

Danach wird ein neues IntelliJ Projekt erstellt. Dabei wird Java und Maven verwendet. Dazu kommt noch, dass die MySQL Connector Java Dependency in die pom.xml hinzugefügt wird.
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.31</version>
</dependency>
```

### DB Verbindung Singleton

Das Singleton Pattern behilft uns Codeduplikate zu vermeiden, indem man die Verbindung zur Datenbank in eine Klasse auslagert. Der Code schaut wie folgt aus:
```java
public class MysqlDatabaseConnection {
    private static Connection con = null;
    //privater Konstruktor, da kein Objekt von dieser Klasse erstellt werden soll. 
    private MysqlDatabaseConnection(){
    }

    //Gibt uns ein Objekt vom Typ Connection zurück oder eine Exception wird geworfen, wenn keine Verbindung hergestellt werden kann oder die Driver nicht verfügbar sind.
    public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException {
        //Prüfen ob eine Verbindung schon besteht
        if(con!=null){
            return con;
        }else{
            //Prüfen ob der Driver verfügbar ist
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user,pwd);
            return con;
        }
    }
}
```
### UI

Als UI wird die CLI verwendet. Dafür wurde eine Klasse erstellt die den Benutzer Auswahlmöglichkeiten bietet. 













