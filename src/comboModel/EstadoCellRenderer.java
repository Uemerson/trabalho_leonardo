package comboModel;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Estado;

/**
 *
 * @author Uemerson
 */
public class EstadoCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Estado) {
            Estado estado = (Estado) value;
            setText(estado.getSigla());
        }
        return this;
    }
}
