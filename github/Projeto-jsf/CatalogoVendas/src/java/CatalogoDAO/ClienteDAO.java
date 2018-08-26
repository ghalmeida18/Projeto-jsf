/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogoDAO;

import CatalogoConexao.FabricaConexao;
import CatalogoTratamento.ErroSistema;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavo
 */
public class ClienteDAO implements CrudDAO<Cliente>{

    @Override
    public void salvar(Cliente entidade) throws ErroSistema {
        
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("INSERT INTO Cliente (Nome, CPF, Endereco) VALUES (?,?,?)");
            ps.setString(1, entidade.getNome());
            ps.setString(2, entidade.getCPF());
            ps.setString(3, entidade.getEndereco());

            ps.execute();

            FabricaConexao.fecharConexao();
        }catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void deletar(Cliente entidade) throws ErroSistema {
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM Cliente WHERE CPF = ?");
            ps.setString(1, entidade.getCPF());
            ps.execute();
        }catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    }

    @Override
    public ArrayList<Cliente> buscar() throws ErroSistema{
        try{
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT Nome,CPF,Endereco FROM Cliente;");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            
            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setCPF(resultSet.getString("CPF"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                clientes.add(cliente);
                
            }
            
            FabricaConexao.fecharConexao();
            return clientes;
              
        } catch (Exception ex) {
            throw new ErroSistema("Erro ao buscar os carros!",ex);
        }
    
    
    
    }
    
    
}
