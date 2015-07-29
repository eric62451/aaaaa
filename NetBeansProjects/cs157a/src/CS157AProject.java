/*
 * Eric Tam
 * 007989423
 * CS157A Project
 * 12/04/2014
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CS157AProject {

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    /*
     * Starts connection with MySQL Database
     */
    private static void start() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Unable to load driver");
        }
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "99643333");
        stmt = conn.createStatement();
    }

    /*
     * Closes Connections with MySQL Database
     */
    private static void close() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        createDB();
        populateDB();
        getAllAuthors();
        System.out.println();
        getAllPublishers();
        System.out.println();
        getAllTitlesFromPublisher();
        System.out.println();
        addNewAuthor();
        System.out.println();
        editAuthor();
        System.out.println();
        addNewTitle();
        System.out.println();
        addNewPublisher();
        System.out.println();
        editPublisher();
    }

    /*
     * Populates tables in books database
     */
    public static void populateDB() throws SQLException {
        start();
        stmt.executeUpdate("use Books;");
        //Populating authors table
        stmt.executeUpdate("INSERT INTO authors(firstName,lastName) VALUES('Cay','Horstmann'),('Hector','Garcia-Molina'),('James','Stewart'),"
                + "('Lois','Lowry'),('Thomas','Cormen'),('Randal','Bryant'),('Brian','Kernighan'),('Larry','Peterson'),('Joel','Murach'),"
                + "('David','Lay'),('Jerrold','Marsden'),('Stephanie','Coopman'),('Thomas','Nechyba'),('Susanna','Epp'),('Michael','Sipser')");
        //Populating publishers table
        stmt.executeUpdate("INSERT INTO publishers(publisherName) VALUES('Pearson Prentice Hall'),('Wiley'),('Addison-Wesley Professional'),('Cengage Learning'),"
                + "(\"Random House Children's Books\"),('The MIT Press'),('Morgan Kaufmann'),('Freeman'),('Mike Murach & Associates'),('McGraw-Hill'),"
                + "('Scholastic'),('Houghton Mifflin Harcourt'),('Harper Collins'),('Simon & Schuster'),('Perseus')");
        //Populating titles table
        stmt.executeUpdate("INSERT INTO titles(isbn,title,editionNumber,copyright,publisherID,price) VALUES"
                + "('0131873253', 'Database Systems: The Complete Book', 2, '2009', (SELECT publisherID FROM publishers WHERE publisherName='Pearson Prentice Hall'), 202),"
                + "('0470509481', 'Big Java: Compatible with Java 5, 6 and 7', 4, '2010', (SELECT publisherID FROM publishers WHERE publisherName='Wiley'), 162.27),"
                + "('0321774094', 'Scala for the Impatient', 1, '2012', (SELECT publisherID FROM publishers WHERE publisherName='Addison-Wesley Professional'), 31.73),"
                + "('0538497815', 'Calculus', 7, '2012', (SELECT publisherID FROM publishers WHERE publisherName='Cengage Learning'), 238.57),"
                + "('0440237688', 'The Giver', 1, '1993', (SELECT publisherID FROM publishers WHERE publisherName=\"Random House Children's Books\"), 6.99),"
                + "('0262033844', 'Introduction to Algorithms', 3, '2009', (SELECT publisherID FROM publishers WHERE publisherName='The MIT Press'), 78.3),"
                + "('0136108040', \"Computer Systems: A Programmer's Perspective\", 2, '2011', (SELECT publisherID FROM publishers WHERE publisherName='Pearson Prentice Hall'), 129.39),"
                + "('0131103628', 'The C Programming Language', 2, '1988', (SELECT publisherID FROM publishers WHERE publisherName='Pearson Prentice Hall'), 50.6),"
                + "('1890774782', \"Murach's Java Servlets and JSP\", 3, '2014', (SELECT publisherID FROM publishers WHERE publisherName='Mike Murach & Associates'), 40.84),"
                + "('0123850592', 'Computer Networks, Fifth Edition: A Systems Approach', 5, '2011', (SELECT publisherID FROM publishers WHERE publisherName='Morgan Kaufmann'), 86.91),"
                + "('0321385179', 'Linear Algebra and Its Applications', 4, '2011', (SELECT publisherID FROM publishers WHERE publisherName='Pearson Prentice Hall'), 158.74),"
                + "('0716749920', 'Vector Calculus', 5, '2003', (SELECT publisherID FROM publishers WHERE publisherName='Freeman'), 169.22),"
                + "('049590578X', 'Public Speaking: The Evolving Art', 2, '2011', (SELECT publisherID FROM publishers WHERE publisherName='Cengage Learning'), 119.23),"
                + "('0538453247', 'Microeconomics: An Intuitive Approach with Calculus', 1, '2011', (SELECT publisherID FROM publishers WHERE publisherName='Cengage Learning'), 242.51),"
                + "('0495391328', 'Discrete Mathematics with Applications', 4, '2010', (SELECT publisherID FROM publishers WHERE publisherName='Cengage Learning'), 289.39)");

        //Populate authorISBN table
        stmt.executeUpdate("INSERT INTO authorISBN(authorID, isbn) VALUES"
                + "((SELECT authorID FROM authors WHERE firstName='Hector' AND lastName='Garcia-Molina'),'0131873253'),"
                + "((SELECT authorID FROM authors WHERE firstName='Cay' AND lastName='Horstmann'),'0470509481'),"
                + "((SELECT authorID FROM authors WHERE firstName='Cay' AND lastName='Horstmann'),'0321774094'),"
                + "((SELECT authorID FROM authors WHERE firstName='James' AND lastName='Stewart'),'0538497815'),"
                + "((SELECT authorID FROM authors WHERE firstName='Lois' AND lastName='Lowry'),'0440237688'),"
                + "((SELECT authorID FROM authors WHERE firstName='Thomas' AND lastName='Cormen'),'0262033844'),"
                + "((SELECT authorID FROM authors WHERE firstName='Randal' AND lastName='Bryant'),'0136108040'),"
                + "((SELECT authorID FROM authors WHERE firstName='Brian' AND lastName='Kernighan'),'0131103628'),"
                + "((SELECT authorID FROM authors WHERE firstName='Larry' AND lastName='Peterson'),'0123850592'),"
                + "((SELECT authorID FROM authors WHERE firstName='Joel' AND lastName='Murach'),'1890774782'),"
                + "((SELECT authorID FROM authors WHERE firstName='David' AND lastName='Lay'),'0321385179'),"
                + "((SELECT authorID FROM authors WHERE firstName='Jerrold' AND lastName='Marsden'),'0716749920'),"
                + "((SELECT authorID FROM authors WHERE firstName='Stephanie' AND lastName='Coopman'),'049590578X'),"
                + "((SELECT authorID FROM authors WHERE firstName='Thomas' AND lastName='Nechyba'),'0538453247'),"
                + "((SELECT authorID FROM authors WHERE firstName='Susanna' AND lastName='Epp'),'0495391328')");
        close();
    }

    /*
     * Creates Books Database and Create Tables
     */
    public static void createDB() throws SQLException {
        start();
        stmt.executeUpdate("DROP DATABASE IF EXISTS Books;");
        stmt.executeUpdate("CREATE DATABASE Books;");
        stmt.executeUpdate("use Books;");
        stmt.executeUpdate("CREATE TABLE authors (authorID INTEGER AUTO_INCREMENT PRIMARY KEY, firstName VARCHAR(20) NOT NULL, lastName CHAR(20) NOT NULL);");
        stmt.executeUpdate("CREATE TABLE publishers (publisherID INTEGER AUTO_INCREMENT PRIMARY KEY, publisherName CHAR(100) NOT NULL);");
        stmt.executeUpdate("CREATE TABLE titles (isbn CHAR(10) PRIMARY KEY, title VARCHAR(500) NOT NULL, editionNumber INTEGER NOT NULL, copyright CHAR(4) NOT NULL, publisherID INTEGER NOT NULL REFERENCES publishers(publisherID), price FLOAT NOT NULL);");
        stmt.executeUpdate("CREATE TABLE authorISBN (authorID INTEGER NOT NULL REFERENCES authors(authorID), isbn CHAR(10) NOT NULL REFERENCES titles(isbn));");
        close();
    }

    /*
     * Get all authors lastName, firstName in the authors table ordered alphabetically by lastName and then first Name
     */
    public static void getAllAuthors() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        String query = "SELECT lastName,firstName FROM authors ORDER BY lastName ASC, firstName ASC";
        System.out.println(query);
        rs = stmt.executeQuery(query);
        System.out.println("Authors:");
        while (rs.next()) {
            System.out.println(rs.getString(1) + ", " + rs.getString(2));
        }
        close();
    }

    /*
     * Get all publishers' name in the publishers table
     */
    public static void getAllPublishers() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        String query = "SELECT publisherName FROM publishers";
        rs = stmt.executeQuery(query);
        System.out.println(query);
        System.out.println("Publishers:");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        close();
    }

    /*
     * Get the name, year and isbn of all titles published by a publisher
     */
    public static void getAllTitlesFromPublisher() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        String query = "SELECT title,copyright,isbn FROM titles "
                + "WHERE publisherID = ANY (SELECT publisherID FROM publishers WHERE publisherName='Pearson Prentice Hall') ORDER BY title ASC";
        System.out.println(query);
        rs = stmt.executeQuery(query);
        System.out.println("titles from Publishers (title,year,isbn)");
        while (rs.next()) {
            System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
        }
        close();
    }

    /*
     * Add new author into the authors table
     */
    public static void addNewAuthor() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        //PRINT OUT CURRENT AUTHORS IN THE TABLE
        System.out.println("Current Authors:");
        rs = stmt.executeQuery("SELECT firstName,lastName FROM authors");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        String query = "INSERT INTO authors(firstName, lastName) VALUES('William','Shakespeare')";
        System.out.println("\n" + query);
        rs.close();
        //PERFORMING QUERY ADDING AUTHOR "William Shakespeare"
        int temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected");
        }
        //PRINT OUT THE AUTHORS AFTER PERFORMING QUERY
        System.out.println("\nAfter Query Authors:");
        rs = stmt.executeQuery("SELECT firstName,lastName FROM authors");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        close();
    }

    /*
     * Edit an Author's information in the authors table
     */
    public static void editAuthor() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        //PRINT OUT CURRENT AUTHORS IN THE TABLE
        System.out.println("Current Authors:");
        rs = stmt.executeQuery("SELECT firstName,lastName FROM authors");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        rs.close();
        String query = "UPDATE authors SET lastName = 'Jordan' WHERE firstName = 'Michael' AND lastName = 'Sipser'";
        System.out.println("\n" + query);
        //PERFORMING QUERY, EDITING AUTHOR INFORMATION "Michael Sipser into Michael Jordan"
        int temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected\n");
        }
        //PRINT OUT THE AUTHORS AFTER PERFORMING QUERY
        System.out.println("After Query Authors:");
        rs = stmt.executeQuery("SELECT firstName,lastName FROM authors");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        close();
    }
    /*
     * Adds new title into the titles table and add the isbn into the authorISBN table
     */

    public static void addNewTitle() throws SQLException {
        start();
        //New Title informations
        String title = "Object-Oriented Design and Patterns";
        String isbn = "0471744875";
        String year = "2005";
        String edition = "2";
        String publisher = "Wiley";
        String firstName = "Cay";
        String lastName = "Horstmann";
        String price = "99.4";

        stmt.executeUpdate("use books;");
        //PRINT OUT CURENT TITLE NAMES IN THE TABLE
        System.out.println("Current Titles:");
        rs = stmt.executeQuery("SELECT title FROM titles");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        String query = "INSERT INTO titles(isbn,title,editionNumber,copyright,publisherID,price) "
                + "VALUES('" + isbn + "','" + title + "'," + edition + ",'" + year + "'," + "(SELECT publisherID FROM publishers WHERE publisherName='" + publisher + "')," + price + ")";
        System.out.println("\n" + query);
        //PERFORMING QUERY, ADDING TITLE INTO TITLES TABLE
        int temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected\n");
        }
        //PRINT OUT TITLE NAMES IN THE TABLE AFTER ADDING
        System.out.println("After query Titles:");
        rs = stmt.executeQuery("SELECT title FROM titles");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        //PRINTING OUT CURRENT INFORMATION IN AUTHORISBN TABLE
        System.out.println("\nCurrent ISBN with AuthorID:");
        rs = stmt.executeQuery("SELECT authorID, isbn FROM authorISBN");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        rs.close();
        query = "INSERT INTO authorISBN(isbn,authorID) VALUES ('" + isbn + "',(SELECT authorID FROM authors WHERE firstName='" + firstName + "' AND lastName='" + lastName + "'))";
        //PERFORMING QUERY, ADDING ISBN INTO AUTHORISBN TABLE
        System.out.println("\n" + query);
        temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected\n");
        }
        //PRINT OUT AUTHORISBN TABLE AFTER ADDING THE ISBN
        System.out.println("After Query ISBN with AuthorID:");
        rs = stmt.executeQuery("SELECT authorID, isbn FROM authorISBN");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        close();
    }

    /*
     * Adds new publisher into the publishers table
     */
    public static void addNewPublisher() throws SQLException {
        String name = "Cambridge University Press";
        start();
        stmt.executeUpdate("use books;");
        //PRINT OUT CURRENT PUBLISHERS IN THE TABLE
        System.out.println("Current Publishers:");
        rs = stmt.executeQuery("SELECT publisherName FROM publishers");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        String query = "INSERT INTO publishers(publisherName) VALUES('" + name + "')";
        System.out.println("\n" + query);
        //PERFORMING QUERY, ADDING NEW PUBLISHER INTO THE TABLE
        int temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected\n");
        }
        //PRINT OUT PUBLISHERS AFTER THE QUERY
        System.out.println("After Query Publishers:");
        rs = stmt.executeQuery("SELECT publisherName FROM publishers");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        close();
    }

    public static void editPublisher() throws SQLException {
        start();
        stmt.executeUpdate("use books;");
        //PRINT OUT CURRENT PUBLISHERS IN THE TABLE
        System.out.println("Current Publishers:");
        rs = stmt.executeQuery("SELECT publisherName FROM publishers");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        String query = "UPDATE publishers SET publisherName = 'Prentice Hall' WHERE publisherName='Pearson Prentice Hall'";
        System.out.println("\n" + query);
        //PERFORMING QUERY, EDITING PUBLISHER "PEARSON PRENTICE HALL" TO "PRENTICE HALL"
        int temp = stmt.executeUpdate(query);
        if (temp != 0) {
            System.out.println("Query OK, " + temp + " row affected\n");
        }
        //PRINT OUT PUBLISHERS AFTER THE QUERY
        System.out.println("After Query Publishers:");
        rs = stmt.executeQuery("SELECT publisherName FROM publishers");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        close();
    }
}
