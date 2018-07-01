package your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import your.app.Anrede;
import your.app.Application;
import your.app.Benutzer;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.eof.ERXEnterpriseObject;
import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXKey;
import er.extensions.eof.ERXSortOrdering;
import er.extensions.eof.ERXSortOrdering.ERXSortOrderings;
import your.app.eo.*;

public class Main extends BaseComponent {

	Application application;

	private String benutzername;
	private String passwort;
	
	//private NSMutableDictionary queryBindings;
	/*
	ERXSortOrderings sortOrderings = null;
	EOQualifier qual = null;
	ERXFetchSpecification fs =
			new ERXFetchSpecification
			(_Benutzer.ENTITY_NAME, qual, sortOrderings);
	EOEditingContext ec = session().defaultEditingContext();
*/
	
/*
	ERXFetchSpecification<_Benutzer> fsf
	= new ERXFetchSpecification<_Benutzer>(
	_Benutzer.ENTITY_NAME, null, null);
	*/
	
	//EOEditingContext ecc = session().defaultEditingContext();
	//NSArray<your.app.eo.Benutzer> benutzer = _Benutzer.fetchAllBenutzers(ecc);
	
	//EOEditingContext ecx = session().defaultEditingContext();
	//NSArray<_Benutzer> benutzerr = _Benutzer.fetchBenutzerbyName(ecx);
	
	
	
	//NSArray<_Benutzer> benutzern =
			//ec.objectsWithFetchSpecification(fs);
	//NSArray<_Benutzer> benutzern =
			//ec.objectsWithFetchSpecification(fs);
	/*
	public static final ERXKey<String> BENUTZERNAME =
			new ERXKey<String>("benutzername");
	
	EOQualifier qualifier =
			_Benutzer.BENUTZERNAME.eq("Lars");
	
	
*/

	public Main(WOContext context) {
		super(context);

		application = (Application) Application.application();
		

		/*
		EOEditingContext ec = session().defaultEditingContext();
		
		
		your.app.eo.Benutzer benutzer = new your.app.eo.Benutzer();
		ec.insertObject(benutzer);
		ERXEOControlUtilities.createAndInsertObject(ec, _Benutzer.ENTITY_NAME);
		//ec.deleteObject(benutzer);
		setBenutzername("Lars");
		
		
		ERXFetchSpecification<_Benutzer> fs =
				new ERXFetchSpecification<_Benutzer>
				(_Benutzer.ENTITY_NAME, null, null);
		ec.objectsWithFetchSpecification(fs);
		*/
	}
	
	public void awake() {
		super.awake();
		queryBindings = new NSMutableDictionary<String, Object>();
	}
	
	public NSMutableDictionary<String, Object> getQueryBindings() {
		return queryBindings;
	}

	public void setQueryBindings(NSMutableDictionary<String, Object> queryBindings) {
		this.queryBindings = queryBindings;
	}

	private NSArray<your.app.eo.Benutzer> benutzern;
	private your.app.eo.Benutzer benutzernLoopvar;
	
	private NSMutableDictionary<String, Object> queryBindings;

	private NSArray<String> loop;
	
	
	public WOComponent reload() {
		benutzern = your.app.eo.Benutzer.fetchBenutzerByName(
				session().defaultEditingContext(), queryBindings);
		return null;
	}
	
	public String first() {
		return (String) valueForKey(_Benutzer.VORNAME_KEY);
	}
	
public void setFirst(String value) {
		if(_Benutzer.logMod.isDebugEnabled()) {
			_Benutzer.logMod.debug("updating firastname from" + first() + "to" + value);
		}
		takeValueForKey(value, _Benutzer.VORNAME_KEY);
	}


public String last() {
	return (String) valueForKey(_Benutzer.NACHNAME_KEY);
}

public void setLast(String value) {
	if(_Benutzer.logMod.isDebugEnabled()) {
		_Benutzer.logMod.debug("updating lastname from" + last() + "to" + value);
	}
	takeValueForKey(value, _Benutzer.NACHNAME_KEY);
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
	
	

	public your.app.eo.Benutzer getBenutzernLoopvar() {
		return benutzernLoopvar;
	}

	public void setBenutzernLoopvar(your.app.eo.Benutzer benutzernLoopvar) {
		this.benutzernLoopvar = benutzernLoopvar;
	}

	public NSArray<your.app.eo.Benutzer> getBenutzern() {
		return benutzern;
	}

	public void setBenutzern(NSArray<your.app.eo.Benutzer> benutzern) {
		this.benutzern = benutzern;
	}

}
