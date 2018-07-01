// DO NOT EDIT.  Make changes to Anrede.java instead.
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
public abstract class _Anrede extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Anrede";

  // Attribute Keys
  public static final ERXKey<String> ANREDE = new ERXKey<String>("anrede", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<your.app.eo.Benutzer> BENUTZERS = new ERXKey<your.app.eo.Benutzer>("benutzers", Type.ToManyRelationship);

  // Attributes
  public static final String ANREDE_KEY = ANREDE.key();

  // Relationships
  public static final String BENUTZERS_KEY = BENUTZERS.key();

  private static final Logger log = LoggerFactory.getLogger(_Anrede.class);

  public Anrede localInstanceIn(EOEditingContext editingContext) {
    Anrede localInstance = (Anrede)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String anrede() {
    return (String) storedValueForKey(_Anrede.ANREDE_KEY);
  }

  public void setAnrede(String value) {
    log.debug( "updating anrede from {} to {}", anrede(), value);
    takeStoredValueForKey(value, _Anrede.ANREDE_KEY);
  }

  public NSArray<your.app.eo.Benutzer> benutzers() {
    return (NSArray<your.app.eo.Benutzer>)storedValueForKey(_Anrede.BENUTZERS_KEY);
  }

  public NSArray<your.app.eo.Benutzer> benutzers(EOQualifier qualifier) {
    return benutzers(qualifier, null, false);
  }

  public NSArray<your.app.eo.Benutzer> benutzers(EOQualifier qualifier, boolean fetch) {
    return benutzers(qualifier, null, fetch);
  }

  public NSArray<your.app.eo.Benutzer> benutzers(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.eo.Benutzer> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(your.app.eo.Benutzer.ANREDE_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = your.app.eo.Benutzer.fetchBenutzers(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = benutzers();
      if (qualifier != null) {
        results = (NSArray<your.app.eo.Benutzer>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.eo.Benutzer>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBenutzers(your.app.eo.Benutzer object) {
    includeObjectIntoPropertyWithKey(object, _Anrede.BENUTZERS_KEY);
  }

  public void removeFromBenutzers(your.app.eo.Benutzer object) {
    excludeObjectFromPropertyWithKey(object, _Anrede.BENUTZERS_KEY);
  }

  public void addToBenutzersRelationship(your.app.eo.Benutzer object) {
    log.debug("adding {} to benutzers relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBenutzers(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Anrede.BENUTZERS_KEY);
    }
  }

  public void removeFromBenutzersRelationship(your.app.eo.Benutzer object) {
    log.debug("removing {} from benutzers relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBenutzers(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Anrede.BENUTZERS_KEY);
    }
  }

  public your.app.eo.Benutzer createBenutzersRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  your.app.eo.Benutzer.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Anrede.BENUTZERS_KEY);
    return (your.app.eo.Benutzer) eo;
  }

  public void deleteBenutzersRelationship(your.app.eo.Benutzer object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Anrede.BENUTZERS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBenutzersRelationships() {
    Enumeration<your.app.eo.Benutzer> objects = benutzers().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBenutzersRelationship(objects.nextElement());
    }
  }


  public static Anrede createAnrede(EOEditingContext editingContext) {
    Anrede eo = (Anrede) EOUtilities.createAndInsertInstance(editingContext, _Anrede.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Anrede> fetchSpec() {
    return new ERXFetchSpecification<Anrede>(_Anrede.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Anrede> fetchAllAnredes(EOEditingContext editingContext) {
    return _Anrede.fetchAllAnredes(editingContext, null);
  }

  public static NSArray<Anrede> fetchAllAnredes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Anrede.fetchAnredes(editingContext, null, sortOrderings);
  }

  public static NSArray<Anrede> fetchAnredes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Anrede> fetchSpec = new ERXFetchSpecification<Anrede>(_Anrede.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Anrede> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Anrede fetchAnrede(EOEditingContext editingContext, String keyName, Object value) {
    return _Anrede.fetchAnrede(editingContext, ERXQ.equals(keyName, value));
  }

  public static Anrede fetchAnrede(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Anrede> eoObjects = _Anrede.fetchAnredes(editingContext, qualifier, null);
    Anrede eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Anrede that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Anrede fetchRequiredAnrede(EOEditingContext editingContext, String keyName, Object value) {
    return _Anrede.fetchRequiredAnrede(editingContext, ERXQ.equals(keyName, value));
  }

  public static Anrede fetchRequiredAnrede(EOEditingContext editingContext, EOQualifier qualifier) {
    Anrede eoObject = _Anrede.fetchAnrede(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Anrede that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Anrede localInstanceIn(EOEditingContext editingContext, Anrede eo) {
    Anrede localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
