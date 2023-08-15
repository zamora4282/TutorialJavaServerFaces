package beans.configuracion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import static jakarta.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(
        //Activa CDI build-in beans
        version = JSF_2_3
)
@ApplicationScoped
public class ConfiguracionJSF {
    
}
