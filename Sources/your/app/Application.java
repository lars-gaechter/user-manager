package your.app;

import java.util.Iterator;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXApplication;
import your.app.components.UserListPage;

/**
 * 
 * Das Verwalten der Session vom angemeldeten Benutzer. Die erstellung einer
 * ArrayListe für Benutzer und Anrede. Prüft bei Anmeldung ob der der benutzer
 * so in der Liste bereits existiert.
 * 
 * @author Protoss
 *
 */
public class Application extends ERXApplication {
	private NSMutableArray<Benutzer> benutzerListe;
	private NSArray<Anrede> anredeListe;
	private Anrede anredeSchleifenVar;

	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);
		/*
		 * Session vom Benutzer laäuft nach 5 Minuten ab, aber bleibt im Browser
		 * ersichlich
		 */
		setSessionTimeOut(5 * 60);
		anredeListe = new NSArray<Anrede>(Anrede.values());
		benutzerListe = new NSMutableArray<Benutzer>();
		/* Standard Admin Benutzer vorerfasst */
		benutzerListe.add(new Benutzer("Gächter", "Lars", Anrede.Herr, "Toolcrafting", "123456", true));
	}

	public NSMutableArray<Benutzer> getBenutzerListe() {
		return benutzerListe;
	}

	/**
	 * 
	 * Kann Benutzer entfernen
	 * 
	 * @param benutzer
	 *            welcher entfernt werden sollte
	 */
	public void entferneBenutzer(Benutzer benutzer) {
		benutzerListe.remove(benutzer);
	}

	public NSArray<Anrede> anredeListe() {
		return anredeListe;
	}

	public Anrede getAnredeSchleifenVar() {
		return anredeSchleifenVar;
	}

	/**
	 * 
	 * 
	 * @param anredeSchleifenVar
	 */
	public void setAnredeSchleifenVar(Anrede anredeSchleifenVar) {
		this.anredeSchleifenVar = anredeSchleifenVar;
	}

	/**
	 * Fügt einen neuen leeren Benutzer hinzu
	 */
	public void hinzufügeBenutzer() {
		benutzerListe.add(new Benutzer("leer", "leer", Anrede.Herr, "leer", "leer", false));
	}

	/**
	 * Die eigentliche ANmeldefunktion prüft ob es einen gleichen benutzername mit
	 * dem Passwort finden kann.
	 * 
	 * @param login
	 *            Benutzername
	 * @param passwort
	 *            Passwort
	 * @return ein UserListPage Objekt für die erfolgreiche Anmeldung oder null wenn
	 *         nicht
	 */
	public UserListPage anmelden(String benutzername, String passwort) {
		Iterator<Benutzer> it = benutzerListe.iterator();

		while (it.hasNext()) {
			Benutzer benutzer = it.next();

			if (benutzer.getLogin().equals(benutzername) && benutzer.getPasswort().equals(passwort)) {
				UserListPage anmeldungErfolgreich = pageWithName(UserListPage.class);
				anmeldungErfolgreich.setAngemeldeterBenutzer(benutzer);

				return anmeldungErfolgreich;
			}
		}

		return null;
	}
}
