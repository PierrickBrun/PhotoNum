package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateBase {

	public static void AjoutBDD(Connection conn) throws SQLException{
		Statement stmt=conn.createStatement();
		stmt.executeQuery("insert into CLIENT(NOM, PRENOM, MAIL, ADRESSE, MOT_DE_PASSE) values ('Dubois','Olivier','olivier.dubois@yahoo.fr','56 rue du boulanger','olivebois');");
		stmt.executeQuery("insert into CLIENT(NOM, PRENOM, MAIL, ADRESSE, MOT_DE_PASSE) values ('Brun','Jean-Pierrick','j.pb@hotmail.fr','15 allé du poullailet','imjpb15');");
		
		stmt.executeQuery("insert into ALBUM(IDCLIENT, TITRE, PREFACE, POSTFACE, NBPAGE, TYPE) values (1, ‘TitreLivre1’, 'Preface de mon premier livre', 'Postface de mon premier livre enfin fini', 32, 'Livre');");
		stmt.executeQuery("insert into ALBUM(IDCLIENT, TITRE, PREFACE, POSTFACE, NBPAGE, TYPE) values (2, 'TitreMonPremierAgenda52s', '', '', 52,'Agenda52s');");
		stmt.executeQuery("insert into ALBUM(IDCLIENT, TITRE, PREFACE, POSTFACE, NBPAGE, TYPE) values (1, 'Mon super calendrierMural', '', '', 14,'CalMural');");
		stmt.executeQuery("insert into ALBUM(IDCLIENT, TITRE, PREFACE, POSTFACE, NBPAGE, TYPE) values ( 2, 'Mon calendrier de bureau', '', '', 12,'CalBureau');");
		stmt.executeQuery("insert into ALBUM(IDCLIENT, TITRE, PREFACE, POSTFACE, NBPAGE, TYPE) values (2, 'Mon agenda 365j', '', '', 365,'Agenda365j');");
		
		stmt.executeQuery("insert into FICHIER (IDCLIENT, CHEMIN, PARTAGE, PRISEDEVUE, RESOLUTION) values (1,'/Doc/Fichier_Image2',0,'prise de vue contre plongée','1200x960');");
		stmt.executeQuery("insert into FICHIER (IDCLIENT, CHEMIN, PARTAGE, PRISEDEVUE, RESOLUTION) values (1,'/Doc/Fichier_Image',0,'prise panoramique','1600x460');");
		stmt.executeQuery("insert into FICHIER (IDCLIENT, CHEMIN, PARTAGE, PRISEDEVUE, RESOLUTION) values (2,'/Doc/Mon_Fichier_Image1',0,'prise panoramique','1600x460');");
		stmt.executeQuery("insert into FICHIER (IDCLIENT, CHEMIN, PARTAGE, PRISEDEVUE, RESOLUTION) values (2,'/Doc/Mon_Fichier_Image2',0,'prise de vue contre plongée','1200x960');");
		
		stmt.executeQuery("insert into PHOTO (IDALBUM, IDFICHIER, TITRE, COMMENTAIRE, PAGE) values (100,10,'TitrePhoto1','commentaire inutile',3);");
		stmt.executeQuery("insert into PHOTO (IDALBUM, IDFICHIER, TITRE, COMMENTAIRE, PAGE) values (101,11,'TitrePhoto2','commentaire inutile aussi',8);");
		stmt.executeQuery("insert into PHOTO (IDALBUM, IDFICHIER, TITRE, COMMENTAIRE, PAGE) values (100,12,'TitrePhoto3','commentaire inutile ++',1);");
		
		stmt.executeQuery("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values ('Agenda52s',12.95,'1024x600',5,500);");
		stmt.executeQuery("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values ('Agenda365j',15.95,'1024x600',7,3000);");
		stmt.executeQuery("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values ('CalendrierBureau',9.99,'1024x600',5,800);");
		stmt.executeQuery("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values ('CalendrierMural',7.99,'1024x600',6,100);");
		stmt.executeQuery("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values ('Livre',22.95,'1024x600',4,1000);");
		
		stmt.executeQuery("insert into COMMANDE (IDCLIENT,DATECOMMANDE,PRIXTOTAL,STATUT) values (1, date '2016-01-22', 120, 'en cours');");
		stmt.executeQuery("insert into COMMANDE (IDCLIENT,DATECOMMANDE,PRIXTOTAL,STATUT) values (2, date '2016-01-22', 120, 'creation');");
		stmt.executeQuery("insert into COMMANDE (IDCLIENT,DATECOMMANDE,PRIXTOTAL,STATUT) values (1, date '2016-01-15', 50, 'envoi complet');");
		stmt.executeQuery("insert into COMMANDE (IDCLIENT,DATECOMMANDE,PRIXTOTAL,STATUT) values (2, date '2016-01-18', 70, 'envoi partiel');");
		
		stmt.executeQuery("insert into PRESTATAIRE (NOM,ADRESSE,TELEPHONE,ACTIVITE) values ('Mr Jean', '18 rue de paper','04 76 90 45 64','Interessant pour les agenda et les calendrier');");
		stmt.executeQuery("insert into PRESTATAIRE (NOM,ADRESSE,TELEPHONE,ACTIVITE) values ('Mr Pierre', '49 rue de sensora','04 76 95 27 53','Interessant pour les livres');");
		
		stmt.executeQuery("insert into ARTICLE (IDALBUM,IDCOMMANDE,IDFORMAT,IDPRESTATAIRE,QUANTITE) values (100,2,6,2,6);");
		stmt.executeQuery("insert into ARTICLE (IDALBUM,IDCOMMANDE,IDFORMAT,IDPRESTATAIRE,QUANTITE) values (102,4,2,1,3);");
		stmt.executeQuery("insert into ARTICLE (IDALBUM,IDCOMMANDE,IDFORMAT,IDPRESTATAIRE,QUANTITE) values (102,2,2,2,1);");
	
		stmt.executeQuery("insert into LIVRAISON (IDARTICLE, DATELIVRAISON, STATUT) values (1, date '2016-01-28', 'en cours');");
		stmt.executeQuery("insert into LIVRAISON (IDARTICLE, DATELIVRAISON, STATUT) values (2, date '2016-01-24', 'envoi complet');");
		stmt.executeQuery("insert into LIVRAISON (IDARTICLE, DATELIVRAISON, STATUT) values (3, date '2016-01-27', 'envoi complet');");
		
		stmt.close();
	}
	
}
