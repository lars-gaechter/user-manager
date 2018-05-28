package your.app.components;

import com.webobjects.appserver.WOContext;
import your.app.Application;

public class Main extends BaseComponent {

	Application application;

	private String benutzername;
	private String passwort;

	public Main(WOContext context) {
		super(context);

		application = (Application) Application.application();
	}
	/**
	 * Aufruf der Anmeldefunktion, mehr Details findet man in der Klasse Application
	 * 
	 * @return eigegebener benutzername und eingegebenes passwort
	 */
	public UserListPage anmelden() {

		return application.anmelden(getBenutzername(), getPasswort());

	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Main clickOutSide() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

}
