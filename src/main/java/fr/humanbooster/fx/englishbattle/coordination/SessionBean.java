package fr.humanbooster.fx.englishbattle.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "sessionBean")
@RequestScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = -950911966773212620L;

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	}

}
