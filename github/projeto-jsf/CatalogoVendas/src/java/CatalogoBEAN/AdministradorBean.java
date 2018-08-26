
package CatalogoBEAN;

import Modelo.Administrador;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AdministradorBean {
    private Administrador Adm = new Administrador();
    private ArrayList<Administrador> Adms = new ArrayList<Administrador>();
    
    public void AdicionarCliente(){
        Adms.add(Adm);
        Adm = new Administrador();
    }

    public Administrador getAdm() {
        return Adm;
    }

    public void setAdm(Administrador Adm) {
        this.Adm = Adm;
    }

    public ArrayList<Administrador> getAdms() {
        return Adms;
    }

    public void setAdms(ArrayList<Administrador> Adms) {
        this.Adms = Adms;
    }
    
    
    
}
