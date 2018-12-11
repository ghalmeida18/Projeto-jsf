
package CatalogoBEAN;

import CatalogoDAO.ProdutoDAO;
import CatalogoTratamento.ErroSistema;
import Modelo.Produto;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ProdutoBEAN {
    private Produto produto = new Produto();
    private ProdutoDAO produtoDAD = new ProdutoDAO();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public ProdutoBEAN() throws ErroSistema {
        setProdutos(this.produtoDAD.buscar());
    }
    
    public void AdicionarProduto() throws ErroSistema{
        produtos.add(produto);
        this.produtoDAD.salvar(produto);
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
    
    public void getProdutosBanco() throws ErroSistema {
        setProdutos(this.produtoDAD.buscar());
        
    }
}
