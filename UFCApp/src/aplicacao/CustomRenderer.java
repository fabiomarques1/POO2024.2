/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author fmacz
 */
public class CustomRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        
        if (column == 4) {
            super.setHorizontalAlignment(SwingConstants.RIGHT);
            return super.getTableCellRendererComponent(table, String.format("%.02f", value), isSelected, hasFocus, row,
                    column);
        }
        if (column == 5) {
            super.setHorizontalAlignment(SwingConstants.RIGHT);
            return super.getTableCellRendererComponent(table, String.format("%.01f", value), isSelected, hasFocus, row,
                    column);
        }
        return null;
    }
}
