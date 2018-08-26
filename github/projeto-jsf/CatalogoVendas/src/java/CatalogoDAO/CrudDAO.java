
package CatalogoDAO;

import CatalogoTratamento.ErroSistema;
import java.util.List;

public interface CrudDAO<E> {//Entidade
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public ArrayList<E> buscar() throws ErroSistema;
    
    
}
