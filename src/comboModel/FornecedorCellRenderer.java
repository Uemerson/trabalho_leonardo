package comboModel;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Fornecedor;

/**
 *
 * @author Uemerson
 */
public class FornecedorCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Fornecedor) {
            Fornecedor fornecedor = (Fornecedor) value;
            setText(fornecedor.getRazaoSocial());
        }
        return this;
    }
}
