package BaseCli;

import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PriceRenderer extends DefaultTableCellRenderer {
  
	private static final long serialVersionUID = 1L;

	{
        setHorizontalAlignment(RIGHT);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Number) {
            // Ajouter deux espaces après le prix
            value = NumberFormat.getCurrencyInstance().format(value) + "  ";
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
