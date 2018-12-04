package model;

import java.util.ArrayList;
import java.util.Date;
import tableModel.ItensVendaTableModel;

/**
 *
 * @author UEMERSON
 */
public class Venda {
    private int id_venda;
    private Funcionario vendedor;
    private Cliente cliente;
    private float venda_total;
    private float desconto;
    private Date data_venda;
    private ArrayList<ItemVenda> itensVenda;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getVenda_total() {
        return venda_total;
    }

    public void setVenda_total(float venda_total) {
        this.venda_total = venda_total;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public ArrayList<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
    
}
