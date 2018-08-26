
package CatalogoBEAN;

import CatalogoDAO.ClienteDAO;
import CatalogoTratamento.ErroSistema;
import Modelo.Cliente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@SessionScoped
@ManagedBean
public class ClienteBEAN {
    private Cliente cliente = new Cliente();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ArrayList<Cliente> Clientes = new ArrayList<Cliente>();

    public ClienteBEAN() throws ErroSistema{
        setClientes(this.clienteDAO.buscar());
    }
    
    
    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    
    
    public void AdicionarCliente() throws ErroSistema{
       
        
        Clientes.add(cliente);
        clienteDAO.salvar(cliente);
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getClientes() throws ErroSistema {
        return this.Clientes;
        
    }
    
    public void getClientesBanco() throws ErroSistema {
        setClientes(this.clienteDAO.buscar());
        
    }

    public void setClientes(ArrayList<Cliente> Clientes) {
        this.Clientes = Clientes;
    }
    
   
    
    
}
