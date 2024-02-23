package BaseCli;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProduitTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Produit> produits;
    private final String[] columnNames = {"Ref", "Désignation", "Famille", "Prix", "X"};

    public ProduitTableModel(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public int getRowCount() {
        return produits.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produit produit = produits.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return produit.getCodeProd();
            case 1:
                return produit.getDesiProd();
            case 2:
                return produit.getCodeFam();
            case 3:
                return produit.getPrixAchatProd();
            case 4:
                return "X";
            default:
                return null;
        }
    }

    public void addProduit(Produit produit) {
        produits.add(produit);
        fireTableRowsInserted(produits.size() - 1, produits.size() - 1);
    }

    public void removeProduit(int rowIndex) {
        System.out.println("Suppression du produit no " + rowIndex);
    	produits.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void clearData() {
        int size = produits.size();
        produits.clear();
        fireTableRowsDeleted(0, size - 1);
    }
}
