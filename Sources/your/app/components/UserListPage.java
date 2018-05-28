package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import er.extensions.components.ERXComponent;
import your.app.Application;
import your.app.Benutzer;
import your.app.Session;

/**
 * 
 * Die gesammte Benutzerverwaltungsfunktionen sind hier festgelet.
 * 
 * @author Protoss
 *
 */
public class UserListPage extends ERXComponent {
	private Benutzer angemeldeterBenutzer;
	private Benutzer selektierterBenutzer;

	private Session sitzung;
	private Application application;

	private Benutzer benutzerSchleifenVar;

	/**
	 * Bei erstellen eines Objektes wird eine neue Session gestartet.
	 * 
	 * @param context
	 */
	public UserListPage(WOContext context) {
		super(context);

		sitzung = (Session) session();
		application = (Application) Application.application();
	}

	public Benutzer selektierterBenutzer() {
		return selektierterBenutzer;
	}

	public Benutzer getBenutzerSchleifenVar() {
		return benutzerSchleifenVar;
	}

	public void setBenutzerSchleifenVar(Benutzer benutzerSchleifenVar) {
		this.benutzerSchleifenVar = benutzerSchleifenVar;
	}

	public void setAngemeldeterBenutzer(Benutzer benutzer) {
		angemeldeterBenutzer = benutzer;
	}

	/**
	 * Überprüft ob der Benutzer angemeldet ist.
	 * 
	 * @return war oder falsch
	 */
	public boolean angemeldet() {
		if (angemeldeterBenutzer != null) {
			return true;
		}

		return false;
	}

	public Benutzer angemeldeterBenutzer() {
		return angemeldeterBenutzer;
	}

	public String vollerName() {
		return angemeldeterBenutzer.getVorname()+" "+angemeldeterBenutzer.getName();
	}

	/**
	 * Session wird ganz beendet
	 * 
	 * @return
	 */
	public Main abmelden() {
		angemeldeterBenutzer = null;
		sitzung.terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	public void entferneBenutzer() {
		application.entferneBenutzer(selektierterBenutzer);
	}

	public void bearbeiteBenutzer() {
		selektierterBenutzer = benutzerSchleifenVar;
	}

	public WOComponent aktualisiereBenutzer() {
		return this.context().page();
	}

	public boolean bistDuSelbst() {
		if (benutzerSchleifenVar.equals(angemeldeterBenutzer)) {
			return true;
		}

		return false;
	}
}