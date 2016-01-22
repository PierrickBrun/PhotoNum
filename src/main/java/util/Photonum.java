package util;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Photonum {

	 /**Permet d'insérer des n-uplets dans la base de donnée  
     * @param conn la connection a la base de donnée
     * @throws SQLException
     */ 
    public static void AjoutBDD(Connection conn) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;

        // Execute the query
        stmt.executeUpdate("insert into LESREPRESENTATIONS values ('102', to_date('2009-01-14 21:00:00', 'YYYY-MM-DD HH24:MI:SS'))") ;
              
        stmt.close() ;
    }
   
    
    /**Question 1 Afficher toute la relation LesSpectacles.  
     * @param conn la connection a la base de donnée
     * @param num numero du spectacle 
     * @throws SQLException
     */ 
    public static void methode_a_1(Connection conn) throws SQLException {
        System.err.println("Les spectacles");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numS, nomS FROM LesSpectacles") ;
        
        while( rs.next() ) {
            System.out.println("Num spectacle : " + rs.getString(1)+ " nom spectacle : " + rs.getString(2)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
    
    /**Question 2 Etant donné un numéro de spectacle, afficher le nom de ce spectacle. 
     * Si le numéro indiqué n'est pas dans la base de données, un message spécial sera affiché.   
     * @param conn la connection a la base de donnée
     * @param num numero du spectacle 
     * @throws SQLException
     */ 
    public static void methode_a_2(Connection conn, int num) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        System.out.println("SELECT * FROM LesSpectacles WHERE numS =  "+num);
        ResultSet rs = stmt.executeQuery("SELECT noms FROM LesSpectacles WHERE numS =  "+num) ;
        // Execute the query
        
        if (!rs.next()) {System.out.println("Aucun spectacle a ce numero");}
        else {
            do{
                System.out.print("Nom "+ rs.getString(1));
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    /**Question 3 Etant donné un nom de spectacle, afficher les numéros de spectacles associés. 
     * Si le nom indiqué n'est pas dans la base de données, un message spécial sera affiché.
     * @param conn la connection a la base de donnée
     * @param nom nom du spectacle 
     * @throws SQLException
     */ 
    public static void methode_a_3(Connection conn, String nom) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        System.out.println(nom);
        ResultSet rs = stmt.executeQuery("SELECT numS FROM LesSpectacles WHERE nomS = '"+nom+"'") ;
        // Execute the query
       if (!rs.next()) {System.out.println("Aucun spectacle a ce nom");}
        else {
            do{
                System.out.print("Num "+ rs.getInt(1));
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
        
        
    }
   
    /**Question 4 Etant donné un numéro de spectacle, afficher le nom du spectacle et l’ensemble des représentations de ce spectacle. 
     * Le nom du programme n'apparaitra qu'une seule fois, même s'il y a plusieurs représentations du spectacle. Si le numéro indiqué n'est pas dans la base de données, un message spécial sera affiché. De même si le spectacle n'a pas de représentation prévue, son nom s'affichera et un message spécial indiquera l'absence de représentations. 
     * @param conn la connection a la base de donnée
     * @param num numero du spectacle 
     * @throws SQLException
     */ 
    public static void methode_a_4(Connection conn, int num) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT LesSpectacles.nomS, LesRepresentations.dateRep  FROM LesSpectacles natural join LesRepresentations  WHERE numS = " +num) ;
       
        if (!rs.next()) {System.out.println("Aucun spectacle a ce numero");} 
        else {
            System.out.println("Nom: " + rs.getString(1));
            do{
                System.out.println(" date "+ rs.getDate(2));
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    
    /**Question 5 Etant donné un nom de spectacle, afficher les numéros de spectacles associés et, pour chacun d’eux, l’ensemble des représentations du spectacle. 
     * Si le nom indiqué n'est pas dans la base de données, un message spécial sera affiché.     
     * @param conn la connection a la base de donnée
     * @param nom nom du spectacle 
     * @throws SQLException
     */ 
    public static void methode_a_5(Connection conn, String nom) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       
       ResultSet rs = stmt.executeQuery("SELECT numS, dateRep FROM LesSpectacles natural left outer join LesRepresentations WHERE nums in (SELECT nums FROM LesSpectacles WHERE nomS = '"+nom+"' )") ;
        if (!rs.next()) {System.out.println("Aucun spectacle a ce numero");} 
        else {
            System.out.println("Num: " + rs.getInt(1));
            do{
                System.out.println(" date "+ rs.getDate(2));
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
     
    /**Question 6 Afficher tous les spectacles et pour chaque spectacle, toutes ses représentations. 
     * Le numéro et le nom de chaque programme n'apparaitra qu'une seule fois, même s'il y a plusieurs représentations du spectacle. Si le spectacle n'a pas de représentation prévue, son numéro et son nom s'afficheront et un message spécial indiquera l'absence de représentations.
     * @param conn la connection a la base de donnée    
     * @throws SQLException
     */ 
    public static void methode_a_6(Connection conn) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       String s ="s";
       ResultSet rs = stmt.executeQuery("SELECT noms ,numS, dateRep FROM LesSpectacles natural left outer join LesRepresentations ") ;
        if (!rs.next()) {System.out.println("Aucun spectacle a ce numero");} 
        else {
           
            do{
                if(!s.equals(rs.getString(1))){
                     System.out.println("Nom: " + rs.getString(1));
                     System.out.println("Num: " + rs.getInt(2));
                     s = rs.getString(1);
                }
                
                System.out.println("        date "+ rs.getDate(3));
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
     /**Question 7 Etant donnée une date de représentation, afficher le numéro et le nom du spectacle associé. 
      * Si la date indiquée n'est pas dans la base de données, un message spécial sera affiché.
      * @param conn la connection a la base de donnée
      * @param date la date des représentations 
      * @throws SQLException
      */      
    public static void methode_a_7(Connection conn, String date) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT noms ,numS, dateRep FROM LesSpectacles natural join LesRepresentations WHERE numS in (SELECT numS FROM LesRepresentations WHERE dateRep=to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS'))") ;
        if (!rs.next()) {System.out.println("Aucun spectacle a cette date");} 
        else {
            System.out.println(" date "+ rs.getDate(3));
            do{
                
                System.out.println("Nom: " + rs.getString(1));
                System.out.println("Num: " + rs.getInt(2));
                
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
     /**
      * Affiche les représentations
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_8(Connection conn) throws SQLException {
        System.err.println("Les representations");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numS, dateRep FROM LesRepresentations") ;
        
        while( rs.next() ) {
            System.out.println("Num spectacle : " + rs.getInt(1)+ " date spectacle : " + rs.getTimestamp(2)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
     /**
      * Affiche les catégories tarifaires
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_9(Connection conn) throws SQLException {
        System.err.println("Les categories tarifaires");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numCT, nomCT, tarif FROM CATEGORIETARIFAIRE") ;
        
        while( rs.next() ) {
            System.out.println("Num categorie : " + rs.getInt(1)+ " nom categorie : " + rs.getString(2) + " tarif categorie :" + rs.getInt(3)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
     /**
      * Affiche les zones
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_10(Connection conn) throws SQLException {
        System.err.println("Les zones");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numZone, nomZone, numCT FROM ZONE") ;
        
        while( rs.next() ) {
            System.out.println("Num zone : " + rs.getInt(1)+ " Nom zone : " + rs.getString(2) + " Num categorie :" + rs.getInt(3)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
     /**
      * Affiche les places
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_11(Connection conn) throws SQLException {
        System.err.println("Les places");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numPlace, numRang, numZone FROM PLACE") ;
        
        while( rs.next() ) {
            System.out.println("Num place : " + rs.getInt(1)+ " num rang : " + rs.getInt(2) + " num zone :" + rs.getInt(3)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
     /**
      * Affiche les Dossiers de ventes
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_12(Connection conn) throws SQLException {
        System.err.println("Les Dossier de Ventes");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numDV, prixTot FROM DossierVente") ;
        
        while( rs.next() ) {
            System.out.println("Num Dossier Vente : " + rs.getString(1)+ " prix Total : " + rs.getString(2)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
     /**
      * Affiche les tickets
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */  
    public static void methode_a_13(Connection conn) throws SQLException {
        System.err.println("Les Ticket");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numSerie, dateHeure, numDV FROM Ticket") ;
        
        while( rs.next() ) {
            System.out.println("Num serie : " + rs.getString(1)+ " date heure : " + rs.getTimestamp(2)+ "num dossier vente" +rs.getString(3)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
     /**
      * Affiche les billets
      * @param conn la connection a la base de donnée      
      * @throws SQLException
      */   
    public static void methode_a_14(Connection conn) throws SQLException {
        System.err.println("Les Billets");
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT numS, numDV, numPlace, numRang, dateRep, numBillet FROM Billet") ;
        
        while( rs.next() ) {
            System.out.println("Num spectacle : " + rs.getString(1)+ " num dossier vente : " + rs.getInt(2)+ " num place : " + rs.getInt(3)+ " num rang: "+rs.getInt(4)+ " dateHeure : " + rs.getTimestamp(5) + " num billet :" + rs.getInt(6)) ;
        }
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt.close() ;
    }
    
    /**
      * Etant donné un numéro de zone,affiche les informations concernant cette zone
      * @param conn la connection a la base de donnée
      * @param zone le numero de la zone
      * @throws SQLException
      */  
    public static void methode_b(Connection conn, int zone) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT nomZone, numCT,  count(numPlace) FROM Zone left outer join Place on Zone.numZone = Place.numZone WHERE Zone.numZone = "+ zone+"Group By nomZone, numCT");
        if (!rs.next()) {System.out.println("Aucune zone n'a ce numero");} 
        else {
            do{ 
                System.out.println("Nom zone: " + rs.getString(1));
                System.out.println("Num Categorie tarifaire : " + rs.getInt(2));
                System.out.println("Nombre place : " + rs.getInt(3));
                
            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
      
    /**
      * Etant donnée une catégorie tarifaire, affiche les numéros de zones associées 
      * @param conn la connection a la base de donnée
      * @param numS le numero de la représentation
      * @param date la date de la représentation
      * @param numP le numero de la place
      * @param numR le numero de rang de la place 
      * @throws SQLException
      */  
    public static void methode_c(Connection conn, int numCT) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT numZone FROM Zone natural join CategorieTarifaire WHERE numCT = "+ numCT);
        if (!rs.next()) {System.out.println("Aucune zone n'a cette categorie tarifaire");} 
        else {
            do{ 
                System.out.println("Numero de zone: " + rs.getInt(1));

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    /**
      * Etant donnée une catégorie tarifaire, affiche le tarif et l’ensemble des places de cette zone
      * @param conn la connection a la base de donnée
      * @param numCT le numero de la catégorie tarifaire
      * @throws SQLException
      */  
    public static void methode_d(Connection conn, int numCT) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT tarif, numPlace, numRang FROM Place natural join Zone natural join Categorietarifaire WHERE numCT = "+ numCT);
        if (!rs.next()) {System.out.println("Aucune zone n'a cette categorie tarifaire");} 
        else {
            System.out.println("Prix place: " + rs.getInt(1));
            do{ 
                
                System.out.println("Num Place: " + rs.getInt(2));
                System.out.println("Num Rang: " + rs.getInt(3));

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    /**
      * Etant donné un numéro de zone, affiche la catégorie de la zone et l’ensemble des places de cette zone
      * @param conn la connection a la base de donnée
      * @param numZone le numero de la zone
      * @throws SQLException
      */  
    public static void methode_e(Connection conn, int numZone) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT numCT, nomCT, numPlace, numRang FROM Categorietarifaire natural join Zone left outer join Place on Zone.numZone = Place.numZone WHERE Zone.numZone ="+ numZone);
        if (!rs.next()) {System.out.println("Aucune zone n'a ce numero");} 
        else {
            System.out.println("Num Catergorie: " + rs.getInt(1));
            System.out.println("Nom Catergorie: " + rs.getString(2));
            do{ 
                
                System.out.println("Num Place: " + rs.getInt(3));
                System.out.println("Num Rang: " + rs.getInt(4));

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
     
    /**
      * Etant donné une vente sur une seule place, affiche les informations concernant la place achetée
      * @param conn la connection a la base de donnée
      * @param numDV le numero d'un dossier de vente
      * @param numP le numero de la place
      * @param numR le numero de rang de la place 
      * @throws SQLException
      */  
    public static void methode_f(Connection conn, int numDV, int numP, int numR) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT numPlace, numRang, numZone, tarif FROM Billet natural join Place natural join Zone natural join CategorieTarifaire WHERE numDV ="+ numDV+" AND numPlace = "+numP+ " AND numRang = "+numR);
        if (!rs.next()) {System.out.println("Aucune dossier n'a ce numero");} 
        else {
            
            do{ 
                
                System.out.println("Num Place: " + rs.getInt(1));
                System.out.println("Num Rang: " + rs.getInt(2));
                System.out.println("Num Zone: " + rs.getInt(3));
                System.out.println("Tarif: " + rs.getInt(4));

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    /**
      * Etant donné une vente, affiche les informations concernant l’ensemble des places achetées
      * @param conn la connection a la base de donnée
      * @param numDV le numero d'un dossier de vente
      * @throws SQLException
      */  
    public static void methode_g(Connection conn, int numDV) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
       ResultSet rs = stmt.executeQuery("SELECT numPlace, numRang, numZone, tarif FROM Billet natural join Place natural join Zone natural join CategorieTarifaire WHERE numDV ="+ numDV);
        if (!rs.next()) {System.out.println("Aucun dossier n'a ce numero");} 
        else {
            
            do{ 
                
                System.out.println("Num Place: " + rs.getInt(1));
                System.out.println("Num Rang: " + rs.getInt(2));
                System.out.println("Num Zone: " + rs.getInt(3));
                System.out.println("Tarif: " + rs.getInt(4));

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
    /**
      * Etant donné une vente, affiche le prix global de la vente
      * @param conn la connection a la base de donnée
      * @param numDv le numero d'un dossier de vente
      * @throws SQLException
      */  
    public static void methode_h(Connection conn, int numDV) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT prixTot  FROM DossierVente  WHERE numDV  ="+ numDV);
        if (!rs.next()) {System.out.println("Aucune dossier n'a ce numero");} 
        else {
            
            do{                 
                System.out.println("Prix Total: " + rs.getInt(1));              

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    //
    /**
      * Etant donné une représentation de spectacle, affiche l’ensemble des places vendues de cette représentation      * @param conn la connection a la base de donnée
      * @param numS le numero de la représentation
      * @param date la date de la représentation
      * @throws SQLException
      */  
    public static void methode_i(Connection conn, int numS, String date) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT  numPlace, numRang FROM Billet WHERE numS  ="+ numS +" AND dateRep = to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS')");
        if (!rs.next()) {System.out.println("Aucune dossier n'a ce numero");} 
        else {
            
            do{                 
                System.out.println("Num Place: " + rs.getInt(1));  
                System.out.println("Num Rang: " + rs.getInt(2)); 

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
     
    /**
      * Etant donné une représentation de spectacle, affiche l’ensemble des places disponibles de cette représentation
      * @param conn la connection a la base de donnée
      * @param numS le numero de la représentation
      * @throws SQLException
      */
    public static void methode_j(Connection conn, int numS, String date) throws SQLException {
        // Get a statement from the connection
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT numPlace, numRang, tarif  FROM Place minus ( SELECT  numPlace, numRang FROM Billet WHERE numS  = "+ numS + " AND dateRep = to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS'))");
        if (!rs.next()) {System.out.println("Aucune dossier n'a ce numero");} 
        else {
            
            do{                 
                System.out.println("Num Place: " + rs.getInt(1));  
                System.out.println("Num Rang: " + rs.getInt(2)); 

            } while (rs.next());
        }
        rs.close();
        stmt.close() ;
    }
    
     /**
      * Effectue la vente d'une seule place par rapport à une representation
      * @param conn la connection a la base de donnée
      * @param numS le numero de la représentation
      * @param date la date de la représentation
      * @param numP le numero de la place
      * @param numR le numero de rang de la place 
      * @throws SQLException
      */    
    public static void methode_k(Connection conn, int numS, String date, int numP, int numR) throws SQLException {
        int tarifPlace = 0; 
        int numDv = 0;
        int numT =0;
        boolean PlaceDispo = false;
        int nbPlaceDispo = 0;
        // Verifie les places disponibles
        Statement stmt7 = conn.createStatement() ;
        ResultSet rs4 = stmt7.executeQuery("SELECT numPlace, numRang FROM Place minus ( SELECT  numPlace, numRang FROM Billet WHERE numS  = "+ numS + " AND dateRep = to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS'))");
        if (!rs4.next()) {System.out.println("Aucune dossier n'a ce numero");} 
        else {
            
            do{                 
                if(numP == rs4.getInt(1) && numR == rs4.getInt(2)){PlaceDispo = true;}  
                nbPlaceDispo++;

            } while (rs4.next());
        }
        rs4.close();
        stmt7.close() ;
        System.out.println("verif place dispo");
        // Récupère numéro ticket
        Statement stmt = conn.createStatement() ;
        ResultSet rs = stmt.executeQuery("SELECT numSerie  FROM Ticket");
        if (!rs.next()) {System.out.println("Aucun dossier");} 
        else {
            do{ if(numT < rs.getInt(1)){numT = rs.getInt(1);}
            } while (rs.next());
        }
        rs.close();
        stmt.close();
        System.out.println("recup ticket");
        // Récupère numero Dossier
        Statement stmt5 = conn.createStatement() ;
        ResultSet rs3 = stmt5.executeQuery("SELECT numDV  FROM DossierVente");
        if (!rs3.next()) {System.out.println("Aucun dossier");} 
        else {
            do{ if(numDv < rs3.getInt(1)){numDv = rs3.getInt(1);}
            } while (rs3.next());
        }
        rs3.close();
        stmt5.close() ;
        System.out.println("recup dossier");
        // Récupère Tarif place
        Statement stmt1 = conn.createStatement() ;
        ResultSet rs1 = stmt1.executeQuery("SELECT tarif FROM Place natural join Zone natural join CategorieTarifaire WHERE numPlace = "+numP+ " AND numRang = "+numR);
        if (!rs1.next()) {System.out.println("Aucune place correspond a ce numero");} 
        tarifPlace = rs1.getInt(1);               
        rs1.close();
        stmt1.close();
        System.out.println("recup tarif");
        // Récupère la différence entre l'heure d'achat et l'heure de la representation
        Statement stmt8 = conn.createStatement() ;
        ResultSet rs5 = stmt8.executeQuery("SELECT dateRep - SYSDATE FROM LesRepresentations WHERE dateRep= to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS')");
        if (!rs5.next()) {System.out.println("aucune representation");} 
        double nbHeures = rs5.getInt(1)*24;               
        rs5.close();
        stmt8.close();
        System.out.println("recup diff");
        numDv++;
        numT++;
                
        if((PlaceDispo == true && nbPlaceDispo > 70) || (PlaceDispo == true && nbHeures <=1) ){
            // Insert pour créer la vente
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            Statement stmt4 = conn.createStatement();
            // Execute the query
           
            stmt2.executeUpdate("insert into DOSSIERVENTE values ( "+numDv+", "+tarifPlace +")");
            System.out.println("ok DOSSIER");
            stmt3.executeUpdate("insert into BILLET values ("+numS+","+numDv+","+numP +","+numR+", to_date('"+date+"', 'YYYY-MM-DD HH24:MI:SS'), '1001')");
            System.out.println("ok BILLET");
            stmt4.executeUpdate("insert into TICKET values ( "+numT+", to_date(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), "+numDv+")");
            System.out.println("ok TICKET");
               // Close the result set, statement and theconnection

            stmt2.close();
            stmt3.close();
            stmt4.close();
        }
        else{System.out.println("Place non disponible ou plus du place disponible");}
    }
    /**
      * Effectue une vente quelconque
      * @param conn la connection a la base de donnée
      * @param numS le tableau des numeros de la représentation
      * @param date le tableau des dates de la représentation
      * @param numP le tableau des numeros de la place
      * @param numR le tableau des numeros de rang de la place 
      * @throws SQLException
      */    
    public static void methode_l(Connection conn, int[] numS, String[] date, int[] numP, int[] numR) throws SQLException {
        
        for(int i = 0; i < numS.length; i++){
            int tarifPlace = 0; 
            int numDv = 0;
            int numT =0;
            int prixTot =0;
            boolean PlaceDispo = false;
            int nbPlaceDispo = 0;
            // Verifie les places disponibles
            Statement stmt7 = conn.createStatement() ;
            ResultSet rs4 = stmt7.executeQuery("SELECT numPlace, numRang FROM Place minus ( SELECT  numPlace, numRang FROM Billet WHERE numS  = "+ numS[i] + " AND dateRep = to_date('"+date[i]+"', 'YYYY-MM-DD HH24:MI:SS'))");
            if (!rs4.next()) {System.out.println("Aucune dossier n'a ce numero");} 
            else {

                do{                 
                    if(numP[i] == rs4.getInt(1) && numR[i] == rs4.getInt(2)){PlaceDispo = true;}  
                    nbPlaceDispo++;

                } while (rs4.next());
            }
            rs4.close();
            stmt7.close() ;
            System.out.println("verif place dispo");
            // Récupère numéro ticket
            Statement stmt = conn.createStatement() ;
            ResultSet rs = stmt.executeQuery("SELECT numSerie  FROM Ticket");
            if (!rs.next()) {System.out.println("Aucun dossier");} 
            else {
                do{ if(numT < rs.getInt(1)){numT = rs.getInt(1);}
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            System.out.println("recup num Ticket");
            // Récupère numero Dossier
            Statement stmt5 = conn.createStatement() ;
            ResultSet rs3 = stmt5.executeQuery("SELECT numDV  FROM DossierVente");
            if (!rs3.next()) {System.out.println("Aucun dossier");} 
            else {
                do{ if(numDv < rs3.getInt(1)){numDv = rs3.getInt(1);}
                } while (rs3.next());
            }
            rs3.close();
            stmt5.close();
            System.out.println("recup num Dossier");
            // Récupère Tarif place
            Statement stmt1 = conn.createStatement() ;
            ResultSet rs1 = stmt1.executeQuery("SELECT tarif FROM Place natural join Zone natural join CategorieTarifaire WHERE numPlace = "+numP[i]+ " AND numRang = "+numR[i]);
            if (!rs1.next()) {System.out.println("Aucune place correspond a ce numero");} 
            tarifPlace = rs1.getInt(1);
            prixTot = prixTot + tarifPlace;
            rs1.close();
            stmt1.close();
            System.out.println("recup Tarif");
            // Récupère la différence entre l'heure d'achat et l'heure de la representation
            Statement stmt8 = conn.createStatement() ;
            ResultSet rs5 = stmt8.executeQuery("SELECT dateRep - SYSDATE FROM LesRepresentations WHERE dateRep= to_date('"+date[i]+"', 'YYYY-MM-DD HH24:MI:SS')");
            if (!rs5.next()) {System.out.println("Aucune place correspond a ce numero");} 
            double nbHeures = rs5.getInt(1)*24;               
            rs5.close();
            stmt8.close();
            System.out.println("recup Diff"+ i);
            // incrémente les valeurs pour pouvoir créer un nouveau dossier et Ticket
            
            int numBillet = 1000;
            if((PlaceDispo == true && nbPlaceDispo > 70) || (PlaceDispo == true && nbHeures <=1) ){
                // Insert pour créer la vente
                Statement stmt2 = conn.createStatement();
                Statement stmt3 = conn.createStatement();
                Statement stmt4 = conn.createStatement();
                
                // Execute the query
                if(i == 0){
                    numDv++;
                    numT++;
                    stmt2.executeUpdate("insert into DOSSIERVENTE values ( "+numDv+", "+tarifPlace +")");
                    System.out.println("ok DOSSIER");
                    stmt4.executeUpdate("insert into TICKET values ( "+numT+", to_date(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), "+numDv+")");
                    System.out.println("ok TICKET");
                }
                numBillet = numBillet +1;
                stmt3.executeUpdate("insert into BILLET values ("+numS[i]+","+numDv+","+numP[i] +","+numR[i]+", to_date('"+date[i]+"', 'YYYY-MM-DD HH24:MI:SS'), '"+numBillet+"')");
                System.out.println("ok BILLET");
               
                   // Close the result set, statement and theconnection
                if(i == numS.length -1){
                    Statement stmt9 = conn.createStatement();
                    stmt9.executeUpdate("UPDATE  DossierVente set prixTot = "+prixTot+" WHERE numDV = "+ numDv);     
                    System.out.println("Mis à jour du Dossier de vente: "+numDv);
                    stmt9.close() ;
                
                }
                stmt2.close();
                stmt3.close();
                stmt4.close();
                
            }else{System.out.println("Place non disponible ou plus du place disponible");}
        }
    }
    
     /**
      * Effectue l’annulation d’une vente d'une seule place
      * @param conn la connection a la base de donnée
      * @param numBillet le numero du billet à supprimer
      * @param numDV le numero de la vente
      * @throws SQLException
      */ 
     public static void methode_m(Connection conn, int numBillet, int numDV) throws SQLException {
        int numDv = 0;
        int tarif = 0;
        // recupère information billet à annuler
        Statement stmt7 = conn.createStatement() ;
        // Execute the query
        ResultSet rs = stmt7.executeQuery("SELECT numPlace, numRang, tarif, prixTot FROM DossierVente natural join Billet natural join Place natural join Zone natural join CategorieTarifaire WHERE numBillet = "+ numBillet+" AND numDv = "+numDV) ;
        if (!rs.next()) {System.out.println("Aucun billet n'a ce numero");} 
        else {
                 
            tarif = rs.getInt(4) - rs.getInt(3);
           
        }
       
        // Close the result set, statement and theconnection
        rs.close() ;
        stmt7.close() ;
        
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE  FROM Billet WHERE numBillet = "+ numBillet);       
        System.out.println("Annulation du billet: "+numBillet);        
        stmt.close() ;
        
        Statement stmt2 = conn.createStatement() ;
        stmt2.executeUpdate("UPDATE  DossierVente set prixTot = "+tarif+" WHERE numDV = "+ numDv);     
        System.out.println("Mis à jour du Dossier de vente: "+numBillet);
        stmt2.close() ;
    }
     
    /**Effectue l’annulation de la vente
      * @param conn la connection a la base de donnée
      * @param numDV le numero de la vente
      * @throws SQLException
      */
      public static void methode_n(Connection conn, int numDV) throws SQLException {
       
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE  FROM billet WHERE numDV = "+ numDV);        
        System.out.println("Annulation du billet ");        
        stmt.close();
        
        Statement stmt2 = conn.createStatement() ;
        stmt2.executeUpdate("DELETE  FROM TICKET WHERE numDV = "+ numDV);        
        System.out.println("Annulation du ticket ");
        stmt2.close();
        
        Statement stmt3 = conn.createStatement() ;
        stmt3.executeUpdate("DELETE  FROM DossierVente WHERE numDV = "+ numDV);
        System.out.println("Annulation de la vente ");
        stmt3.close();
    }
	
}
