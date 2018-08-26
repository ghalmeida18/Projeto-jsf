
package Modelo;

import java.util.ArrayList;

public class Pedido {
   
    private Cliente cliente;
    private ArrayList<Produto> Produtos;
    
    public void Pedido(){
        Produtos = new ArrayList<Produto>();
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(Produto produto) {
        this.Produtos.add(produto);
    }
    
    
    
    
}
