
package CatalogoBEAN;

import Modelo.Produto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ProdutoBEAN {
    private Produto produto = new Produto();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    public void AdicionarProduto(){
        produtos.add(produto);
        produto = new Produto();
        
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    
}
