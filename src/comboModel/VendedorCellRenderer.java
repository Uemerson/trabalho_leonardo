package comboModel;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Funcionario;

/**
 *
 * @author Uemerson
 */
public class VendedorCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Funcionario) {
            Funcionario vendedor = (Funcionario) value;
            setText(vendedor.getNome_completo());
        }
        return this;
    }
}
