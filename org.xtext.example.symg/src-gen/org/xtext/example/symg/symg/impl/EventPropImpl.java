/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.symg.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.symg.symg.EventProp;
import org.xtext.example.symg.symg.Point;
import org.xtext.example.symg.symg.SymgPackage;
import org.xtext.example.symg.symg.cEvent;
import org.xtext.example.symg.symg.oEvent;
import org.xtext.example.symg.symg.pEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Prop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symg.symg.impl.EventPropImpl#getEventName <em>Event Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.EventPropImpl#getOEventName <em>OEvent Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.EventPropImpl#getCEventName <em>CEvent Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.EventPropImpl#getPEventName <em>PEvent Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.EventPropImpl#getPoint <em>Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventPropImpl extends MinimalEObjectImpl.Container implements EventProp
{
  /**
   * The default value of the '{@link #getEventName() <em>Event Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventName()
   * @generated
   * @ordered
   */
  protected static final String EVENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEventName() <em>Event Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEventName()
   * @generated
   * @ordered
   */
  protected String eventName = EVENT_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOEventName() <em>OEvent Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOEventName()
   * @generated
   * @ordered
   */
  protected oEvent oEventName;

  /**
   * The cached value of the '{@link #getCEventName() <em>CEvent Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCEventName()
   * @generated
   * @ordered
   */
  protected cEvent cEventName;

  /**
   * The cached value of the '{@link #getPEventName() <em>PEvent Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPEventName()
   * @generated
   * @ordered
   */
  protected pEvent pEventName;

  /**
   * The cached value of the '{@link #getPoint() <em>Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPoint()
   * @generated
   * @ordered
   */
  protected Point point;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventPropImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SymgPackage.Literals.EVENT_PROP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getEventName()
  {
    return eventName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEventName(String newEventName)
  {
    String oldEventName = eventName;
    eventName = newEventName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__EVENT_NAME, oldEventName, eventName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public oEvent getOEventName()
  {
    return oEventName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOEventName(oEvent newOEventName, NotificationChain msgs)
  {
    oEvent oldOEventName = oEventName;
    oEventName = newOEventName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__OEVENT_NAME, oldOEventName, newOEventName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOEventName(oEvent newOEventName)
  {
    if (newOEventName != oEventName)
    {
      NotificationChain msgs = null;
      if (oEventName != null)
        msgs = ((InternalEObject)oEventName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__OEVENT_NAME, null, msgs);
      if (newOEventName != null)
        msgs = ((InternalEObject)newOEventName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__OEVENT_NAME, null, msgs);
      msgs = basicSetOEventName(newOEventName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__OEVENT_NAME, newOEventName, newOEventName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public cEvent getCEventName()
  {
    return cEventName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCEventName(cEvent newCEventName, NotificationChain msgs)
  {
    cEvent oldCEventName = cEventName;
    cEventName = newCEventName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__CEVENT_NAME, oldCEventName, newCEventName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCEventName(cEvent newCEventName)
  {
    if (newCEventName != cEventName)
    {
      NotificationChain msgs = null;
      if (cEventName != null)
        msgs = ((InternalEObject)cEventName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__CEVENT_NAME, null, msgs);
      if (newCEventName != null)
        msgs = ((InternalEObject)newCEventName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__CEVENT_NAME, null, msgs);
      msgs = basicSetCEventName(newCEventName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__CEVENT_NAME, newCEventName, newCEventName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public pEvent getPEventName()
  {
    return pEventName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPEventName(pEvent newPEventName, NotificationChain msgs)
  {
    pEvent oldPEventName = pEventName;
    pEventName = newPEventName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__PEVENT_NAME, oldPEventName, newPEventName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPEventName(pEvent newPEventName)
  {
    if (newPEventName != pEventName)
    {
      NotificationChain msgs = null;
      if (pEventName != null)
        msgs = ((InternalEObject)pEventName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__PEVENT_NAME, null, msgs);
      if (newPEventName != null)
        msgs = ((InternalEObject)newPEventName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__PEVENT_NAME, null, msgs);
      msgs = basicSetPEventName(newPEventName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__PEVENT_NAME, newPEventName, newPEventName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Point getPoint()
  {
    return point;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPoint(Point newPoint, NotificationChain msgs)
  {
    Point oldPoint = point;
    point = newPoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__POINT, oldPoint, newPoint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPoint(Point newPoint)
  {
    if (newPoint != point)
    {
      NotificationChain msgs = null;
      if (point != null)
        msgs = ((InternalEObject)point).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__POINT, null, msgs);
      if (newPoint != null)
        msgs = ((InternalEObject)newPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.EVENT_PROP__POINT, null, msgs);
      msgs = basicSetPoint(newPoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.EVENT_PROP__POINT, newPoint, newPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SymgPackage.EVENT_PROP__OEVENT_NAME:
        return basicSetOEventName(null, msgs);
      case SymgPackage.EVENT_PROP__CEVENT_NAME:
        return basicSetCEventName(null, msgs);
      case SymgPackage.EVENT_PROP__PEVENT_NAME:
        return basicSetPEventName(null, msgs);
      case SymgPackage.EVENT_PROP__POINT:
        return basicSetPoint(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SymgPackage.EVENT_PROP__EVENT_NAME:
        return getEventName();
      case SymgPackage.EVENT_PROP__OEVENT_NAME:
        return getOEventName();
      case SymgPackage.EVENT_PROP__CEVENT_NAME:
        return getCEventName();
      case SymgPackage.EVENT_PROP__PEVENT_NAME:
        return getPEventName();
      case SymgPackage.EVENT_PROP__POINT:
        return getPoint();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymgPackage.EVENT_PROP__EVENT_NAME:
        setEventName((String)newValue);
        return;
      case SymgPackage.EVENT_PROP__OEVENT_NAME:
        setOEventName((oEvent)newValue);
        return;
      case SymgPackage.EVENT_PROP__CEVENT_NAME:
        setCEventName((cEvent)newValue);
        return;
      case SymgPackage.EVENT_PROP__PEVENT_NAME:
        setPEventName((pEvent)newValue);
        return;
      case SymgPackage.EVENT_PROP__POINT:
        setPoint((Point)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SymgPackage.EVENT_PROP__EVENT_NAME:
        setEventName(EVENT_NAME_EDEFAULT);
        return;
      case SymgPackage.EVENT_PROP__OEVENT_NAME:
        setOEventName((oEvent)null);
        return;
      case SymgPackage.EVENT_PROP__CEVENT_NAME:
        setCEventName((cEvent)null);
        return;
      case SymgPackage.EVENT_PROP__PEVENT_NAME:
        setPEventName((pEvent)null);
        return;
      case SymgPackage.EVENT_PROP__POINT:
        setPoint((Point)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SymgPackage.EVENT_PROP__EVENT_NAME:
        return EVENT_NAME_EDEFAULT == null ? eventName != null : !EVENT_NAME_EDEFAULT.equals(eventName);
      case SymgPackage.EVENT_PROP__OEVENT_NAME:
        return oEventName != null;
      case SymgPackage.EVENT_PROP__CEVENT_NAME:
        return cEventName != null;
      case SymgPackage.EVENT_PROP__PEVENT_NAME:
        return pEventName != null;
      case SymgPackage.EVENT_PROP__POINT:
        return point != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (eventName: ");
    result.append(eventName);
    result.append(')');
    return result.toString();
  }

} //EventPropImpl
