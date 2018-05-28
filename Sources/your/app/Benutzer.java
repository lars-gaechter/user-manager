package your.app;

/**
 * 
 * Benutzer für Login und Verwaltung des Benutzers, Berechtigungen abhängig
 * davon ob der Benutzer ein Admin ist
 * 
 * @author Protoss
 */
public class Benutzer {

	private String name, vorname, benutzername, passwort;
	private Anrede anrede;
	private Boolean adminBerechtigung;

	/**
	 * 
	 * @param name
	 *            Nachname
	 * @param vorname
	 *            Vorname
	 * @param anrede
	 *            Anrede, Herr oder Frau
	 * @param benutzername
	 *            Benutzername
	 * @param passwort
	 *            Passwort
	 * @param adminBerechtigung
	 *            Admin oder nicht Admin
	 */
	public Benutzer(String name, String vorname, Anrede anrede, String benutzername, String passwort,
			Boolean adminBerechtigung) {
		this.name = name;
		this.vorname = vorname;
		this.anrede = anrede;
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.adminBerechtigung = adminBerechtigung;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Anrede getAnrede() {
		return anrede;
	}

	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
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

	public Boolean getAdminBerechtigung() {
		return adminBerechtigung;
	}

	public void setAdminBerechtigung(Boolean adminBerechtigung) {
		this.adminBerechtigung = adminBerechtigung;
	}

}
