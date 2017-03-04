package elections.dao.entities;

 import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ElectionsException extends RuntimeException implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int code;
	private String message;
	private List<String> erreurs;
	
	//constructeurs
	public ElectionsException(int code, String message){
		super();
		this.code = code;
		this.message = message;
	}
	
	public ElectionsException(int code, Throwable e){
		super(e);
		this.code = code;
		this.erreurs = getErreursForException(e);
	}
	
	
	public ElectionsException(int code, String message, Throwable e) {
		super(message,e);
		this.code = code;
		this.erreurs = getErreursForException(e);
	}
	
	public ElectionsException(int code, List<String> erreurs) {
		super();
		this.code = code;
		this.erreurs = erreurs;
	}
	
	// liste des messages d'erreur d'une exception
	private List<String> getErreursForException(Throwable th) {
		// on récupère la liste des messages d'erreur de l'exception
		Throwable cause = th;
		List<String> erreurs = new ArrayList<String>();
		while (cause != null) {
			//on récupère le message seulement s'il est != null et non blanc
			String message = cause.getMessage();
			if (message != null) {
				message = message.trim();
				if (message.length() != 0) {
					erreurs.add(message);
				}
			}
			// cause suivante
			cause = cause.getCause();
		}
		return erreurs;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(List<String> erreurs) {
		this.erreurs = erreurs;
	}
	
}