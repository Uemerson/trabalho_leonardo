package comboModel;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Cargo;

/**
 *
 * @author Uemerson
 */
public class CargoCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Cargo) {
            Cargo Cargo = (Cargo) value;
            setText(Cargo.getNome_cargo());
        }
        return this;
    }
}
