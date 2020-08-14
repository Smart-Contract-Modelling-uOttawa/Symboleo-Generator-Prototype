/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.symg.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.symg.symg.SymgPackage;
import org.xtext.example.symg.symg.oEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>oEvent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symg.symg.impl.oEventImpl#getOblEvent <em>Obl Event</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.oEventImpl#getOblName <em>Obl Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class oEventImpl extends MinimalEObjectImpl.Container implements oEvent
{
  /**
   * The default value of the '{@link #getOblEvent() <em>Obl Event</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblEvent()
   * @generated
   * @ordered
   */
  protected static final String OBL_EVENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOblEvent() <em>Obl Event</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblEvent()
   * @generated
   * @ordered
   */
  protected String oblEvent = OBL_EVENT_EDEFAULT;

  /**
   * The default value of the '{@link #getOblName() <em>Obl Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblName()
   * @generated
   * @ordered
   */
  protected static final String OBL_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOblName() <em>Obl Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOblName()
   * @generated
   * @ordered
   */
  protected String oblName = OBL_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected oEventImpl()
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
    return SymgPackage.Literals.OEVENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOblEvent()
  {
    return oblEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOblEvent(String newOblEvent)
  {
    String oldOblEvent = oblEvent;
    oblEvent = newOblEvent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.OEVENT__OBL_EVENT, oldOblEvent, oblEvent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOblName()
  {
    return oblName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOblName(String newOblName)
  {
    String oldOblName = oblName;
    oblName = newOblName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.OEVENT__OBL_NAME, oldOblName, oblName));
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
      case SymgPackage.OEVENT__OBL_EVENT:
        return getOblEvent();
      case SymgPackage.OEVENT__OBL_NAME:
        return getOblName();
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
      case SymgPackage.OEVENT__OBL_EVENT:
        setOblEvent((String)newValue);
        return;
      case SymgPackage.OEVENT__OBL_NAME:
        setOblName((String)newValue);
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
      case SymgPackage.OEVENT__OBL_EVENT:
        setOblEvent(OBL_EVENT_EDEFAULT);
        return;
      case SymgPackage.OEVENT__OBL_NAME:
        setOblName(OBL_NAME_EDEFAULT);
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
      case SymgPackage.OEVENT__OBL_EVENT:
        return OBL_EVENT_EDEFAULT == null ? oblEvent != null : !OBL_EVENT_EDEFAULT.equals(oblEvent);
      case SymgPackage.OEVENT__OBL_NAME:
        return OBL_NAME_EDEFAULT == null ? oblName != null : !OBL_NAME_EDEFAULT.equals(oblName);
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
    result.append(" (oblEvent: ");
    result.append(oblEvent);
    result.append(", oblName: ");
    result.append(oblName);
    result.append(')');
    return result.toString();
  }

} //oEventImpl
