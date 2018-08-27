
package CatalogoDAO;

import CatalogoTratamento.ErroSistema;
import java.util.List;

public interface CrudDAO<E> {//Entidade
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> buscar() throws ErroSistema;
    
    
}
