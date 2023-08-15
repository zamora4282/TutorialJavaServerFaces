package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {

    @Inject
    private Candidato candidato;
    
    Logger log = LogManager.getRootLogger();
            
    public VacanteForm(){
        log.info("Creando el objeto VacanteForm");
    }
    public void setCandidato(Candidato candidato){
        log.info("Entrando en candidato");
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(this.candidato.getNombre().equals("Juan")){
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String conponentId = null;
                facesContext.addMessage(msg, facesMessage);
                return "index";
                
            }
            return "exito";
        }
        else{
            log.info("Entrando en fallo");
            return "fallo";
        }
    }
}
