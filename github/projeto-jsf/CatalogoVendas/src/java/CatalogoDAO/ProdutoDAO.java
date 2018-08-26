
package CatalogoDAO;

import CatalogoConexao.FabricaConexao;
import CatalogoTratamento.ErroSistema;
import Modelo.Cliente;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO implements CrudDAO<Produto> {

    @Override
    public void salvar(Produto entidade) throws ErroSistema {
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO Produto (Nome, Descricao, Valor) VALUES (?,?,?)");
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getDescricao());
            ps.setFloat(3, entidade.getValor());

            ps.execute();

            FabricaConexao.fecharConexao();
        }catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @Override
    public void deletar(Produto entidade) throws ErroSistema {
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM Produto WHERE Id = ?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        }catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }

    @Override
    public ArrayList<Produto> buscar() throws ErroSistema {
        
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM Produto;");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Produto> Produtos = new ArrayList<Produto>();
            
            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setNome(resultSet.getString("Nome"));
                produto.setDescricao(resultSet.getString("Descricao"));
                produto.setValor(resultSet.getFloat("Valor"));
                produto.setId(resultSet.getInt("IdProduto"));
                
                Produtos.add(produto);
                
            }
            
            FabricaConexao.fecharConexao();
            return Produtos;
              
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao buscar os carros!",ex);
        }
    
    
    }
    
}
