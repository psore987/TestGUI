package BaseCli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import coursSwing.Classe;

public class Produit {
	private int codeProd;
	private String desiProd;
	private int codeFam;
	private double prixAchatProd;


	// constructeur

	public Produit(int codeProd, String desiProd, int codeFam, double prixAchatProd) {
		super();
		this.codeProd = codeProd;
		this.desiProd = desiProd;
		this.codeFam = codeFam;
		this.prixAchatProd = prixAchatProd;
	}


	// accesseurs

	public int getCodeProd() {
		return codeProd;
	}
	
	public void setCodeProd(int codeProd) {
		this.codeProd = codeProd;
	}

	public String getDesiProd() {
		return desiProd;
	}
	public void setDesiProd(String desiProd) {
		this.desiProd = desiProd;
	}
	public int getCodeFam() {
		return codeFam;
	}
	public void setCodeFam(int codeFam) {
		this.codeFam = codeFam;
	}
	public double getPrixAchatProd() {
		return prixAchatProd;
	}
	public void setPrixAchatProd(double prixAchatProd) {
		this.prixAchatProd = prixAchatProd;
	}

	public static List<Produit> afficherProduits(Connection connection, String noFacture) {
		List<Produit> produits = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		// Requête SQL avec un PreparedStatement
		 String sql = "SELECT figurer.Code_prod, produits.Desi_prod, produits.code_fam, produits.prixachat_prod "
		            + "FROM produits, figurer "
		            + "WHERE figurer.Code_prod = produits.Code_prod AND figurer.Num_fac = ?;";


		try {
			preparedStatement = connection.prepareStatement(sql);

			// Remplacer les paramètres par les valeurs actuelles
			preparedStatement.setString(1, noFacture);

			// Exécutez la requête pour trouver les articles de la facture
			ResultSet resultSet =preparedStatement.executeQuery();

			// les données sont récupérées dans le "resultset", il faut compléter la collection "produits"

			while (resultSet.next()) {
				int codeProd = resultSet.getInt("Code_prod");
				String desiProd = resultSet.getString("Desi_Prod");
				int codefam = resultSet.getInt("Code_Fam");
				double prixAchatProd = resultSet.getDouble("prixachat_prod");
				Produit produit = new Produit(codeProd,desiProd,codefam,prixAchatProd);
				produits.add(produit);
				System.out.println(produit);}
			// la collection "produits" est complète !
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Fermez les ressources
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return produits;
	}

	public String ligneProduit() {
		// Utilisation de String.format pour formater la ligne de produit
		return String.format("%-3d %-25s %-3s %6.2f €", codeProd, desiProd, codeFam, prixAchatProd);
    }
	
	@Override
	public String toString() {
		return "Produit [codeProd=" + codeProd + ", desiProd=" + desiProd + ", codeFam=" + codeFam + ", prixAchatProd="
				+ prixAchatProd + "]";
	}
}
