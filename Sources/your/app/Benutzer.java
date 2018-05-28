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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminBerechtigung == null) ? 0 : adminBerechtigung.hashCode());
		result = prime * result + ((anrede == null) ? 0 : anrede.hashCode());
		result = prime * result + ((benutzername == null) ? 0 : benutzername.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwort == null) ? 0 : passwort.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Benutzer other = (Benutzer) obj;
		if (adminBerechtigung == null) {
			if (other.adminBerechtigung != null)
				return false;
		} else if (!adminBerechtigung.equals(other.adminBerechtigung))
			return false;
		if (anrede != other.anrede)
			return false;
		if (benutzername == null) {
			if (other.benutzername != null)
				return false;
		} else if (!benutzername.equals(other.benutzername))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwort == null) {
			if (other.passwort != null)
				return false;
		} else if (!passwort.equals(other.passwort))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
	

}
