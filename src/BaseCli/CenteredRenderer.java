package BaseCli;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CenteredRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	public CenteredRenderer() {
        setHorizontalAlignment(CENTER); // Centre le contenu horizontalement
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
