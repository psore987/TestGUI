package BaseCli;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private static final long serialVersionUID = 1L;

    private JButton button;
    private JTable table;
    private ActionListener action;

    public ButtonColumn(JTable table, int column, ActionListener action) {
        this.table = table;
        this.action = action;
        
        this.button = new JButton("Supprimer");
        this.button.setFocusPainted(false);
        this.button.addActionListener(this);

        //debogage
        System.out.println("Debogage Listener Supprimer");
        System.out.println("Action listener :" + action);
        
        
        // Définir le rendu et l'éditeur pour la colonne
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        tableColumn.setCellRenderer(this);
        tableColumn.setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int modelRow = table.convertRowIndexToModel(table.getEditingRow());
        action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(modelRow)));
        fireEditingStopped();
    }
}
