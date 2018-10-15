package comboModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Cargo;

/**
 *
 * @author Uemerson
 */
public class CargoComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private List<Cargo> listCargo;
    private Cargo selectedCargo;
    private final static int FIRSTINDEX = 0;
 
    public CargoComboModel() {
        this.listCargo = new ArrayList<Cargo>();
    }
     
    public CargoComboModel(List<Cargo> listCargo) {
        this();
        this.listCargo.addAll(listCargo);
        if (getSize() > 0) {
            setSelectedItem(this.listCargo.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Object getElementAt(int index) {
        return listCargo.get(index);
    }
 
    @Override
    public int getSize() {
        return listCargo.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return selectedCargo;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedCargo = (Cargo) anItem;
    }
     
    public void addCargo(Cargo Cargo) {
        listCargo.add(Cargo);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listCargo.get(getSize() - 1));
    }
     
    public void addListCargo(List<Cargo> Cargos) {
        int primeiraLinha = getSize();
        listCargo.addAll(Cargos);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + Cargos.size());
        setSelectedItem(listCargo.get(getSize() - 1));
    }
     
    public void removeCargo() {
        listCargo.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listCargo.get(FIRSTINDEX));
    }
     
    public void clear() {
        listCargo.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
