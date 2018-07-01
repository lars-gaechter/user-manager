// DO NOT EDIT.  Make changes to Benutzer.java instead.
package your.app.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.eof.ERXKey.Type;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _Benutzer extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Benutzer";

  // Attribute Keys
  public static final ERXKey<String> BENUTZERNAME = new ERXKey<String>("benutzername", Type.Attribute);
  public static final ERXKey<String> NACHNAME = new ERXKey<String>("nachname", Type.Attribute);
  public static final ERXKey<String> PASSWORT = new ERXKey<String>("passwort", Type.Attribute);
  public static final ERXKey<String> VORNAME = new ERXKey<String>("vorname", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<your.app.eo.Anrede> ANREDE = new ERXKey<your.app.eo.Anrede>("anrede", Type.ToOneRelationship);

  // Attributes
  public static final String BENUTZERNAME_KEY = BENUTZERNAME.key();
  public static final String NACHNAME_KEY = NACHNAME.key();
  public static final String PASSWORT_KEY = PASSWORT.key();
  public static final String VORNAME_KEY = VORNAME.key();

  // Relationships
  public static final String ANREDE_KEY = ANREDE.key();

  private static final Logger log = LoggerFactory.getLogger(_Benutzer.class);

  public Benutzer localInstanceIn(EOEditingContext editingContext) {
    Benutzer localInstance = (Benutzer)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String benutzername() {
    return (String) storedValueForKey(_Benutzer.BENUTZERNAME_KEY);
  }

  public void setBenutzername(String value) {
    log.debug( "updating benutzername from {} to {}", benutzername(), value);
    takeStoredValueForKey(value, _Benutzer.BENUTZERNAME_KEY);
  }

  public String nachname() {
    return (String) storedValueForKey(_Benutzer.NACHNAME_KEY);
  }

  public void setNachname(String value) {
    log.debug( "updating nachname from {} to {}", nachname(), value);
    takeStoredValueForKey(value, _Benutzer.NACHNAME_KEY);
  }

  public String passwort() {
    return (String) storedValueForKey(_Benutzer.PASSWORT_KEY);
  }

  public void setPasswort(String value) {
    log.debug( "updating passwort from {} to {}", passwort(), value);
    takeStoredValueForKey(value, _Benutzer.PASSWORT_KEY);
  }

  public String vorname() {
    return (String) storedValueForKey(_Benutzer.VORNAME_KEY);
  }

  public void setVorname(String value) {
    log.debug( "updating vorname from {} to {}", vorname(), value);
    takeStoredValueForKey(value, _Benutzer.VORNAME_KEY);
  }

  public your.app.eo.Anrede anrede() {
    return (your.app.eo.Anrede)storedValueForKey(_Benutzer.ANREDE_KEY);
  }

  public void setAnrede(your.app.eo.Anrede value) {
    takeStoredValueForKey(value, _Benutzer.ANREDE_KEY);
  }

  public void setAnredeRelationship(your.app.eo.Anrede value) {
    log.debug("updating anrede from {} to {}", anrede(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setAnrede(value);
    }
    else if (value == null) {
      your.app.eo.Anrede oldValue = anrede();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Benutzer.ANREDE_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Benutzer.ANREDE_KEY);
    }
  }


  public static Benutzer createBenutzer(EOEditingContext editingContext) {
    Benutzer eo = (Benutzer) EOUtilities.createAndInsertInstance(editingContext, _Benutzer.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Benutzer> fetchSpec() {
    return new ERXFetchSpecification<Benutzer>(_Benutzer.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Benutzer> fetchAllBenutzers(EOEditingContext editingContext) {
    return _Benutzer.fetchAllBenutzers(editingContext, null);
  }

  public static NSArray<Benutzer> fetchAllBenutzers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Benutzer.fetchBenutzers(editingContext, null, sortOrderings);
  }

  public static NSArray<Benutzer> fetchBenutzers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Benutzer> fetchSpec = new ERXFetchSpecification<Benutzer>(_Benutzer.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Benutzer> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Benutzer fetchBenutzer(EOEditingContext editingContext, String keyName, Object value) {
    return _Benutzer.fetchBenutzer(editingContext, ERXQ.equals(keyName, value));
  }

  public static Benutzer fetchBenutzer(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Benutzer> eoObjects = _Benutzer.fetchBenutzers(editingContext, qualifier, null);
    Benutzer eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Benutzer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Benutzer fetchRequiredBenutzer(EOEditingContext editingContext, String keyName, Object value) {
    return _Benutzer.fetchRequiredBenutzer(editingContext, ERXQ.equals(keyName, value));
  }

  public static Benutzer fetchRequiredBenutzer(EOEditingContext editingContext, EOQualifier qualifier) {
    Benutzer eoObject = _Benutzer.fetchBenutzer(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Benutzer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Benutzer localInstanceIn(EOEditingContext editingContext, Benutzer eo) {
    Benutzer localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
