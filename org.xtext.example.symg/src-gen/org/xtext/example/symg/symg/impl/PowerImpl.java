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

import org.xtext.example.symg.symg.Power;
import org.xtext.example.symg.symg.Proposition;
import org.xtext.example.symg.symg.SymgPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getRole1 <em>Role1</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getRole2 <em>Role2</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getAntecedent <em>Antecedent</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.impl.PowerImpl#getConsequent <em>Consequent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerImpl extends MinimalEObjectImpl.Container implements Power
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected Proposition trigger;

  /**
   * The default value of the '{@link #getRole1() <em>Role1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole1()
   * @generated
   * @ordered
   */
  protected static final String ROLE1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRole1() <em>Role1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole1()
   * @generated
   * @ordered
   */
  protected String role1 = ROLE1_EDEFAULT;

  /**
   * The default value of the '{@link #getRole2() <em>Role2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole2()
   * @generated
   * @ordered
   */
  protected static final String ROLE2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRole2() <em>Role2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRole2()
   * @generated
   * @ordered
   */
  protected String role2 = ROLE2_EDEFAULT;

  /**
   * The cached value of the '{@link #getAntecedent() <em>Antecedent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAntecedent()
   * @generated
   * @ordered
   */
  protected Proposition antecedent;

  /**
   * The cached value of the '{@link #getConsequent() <em>Consequent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConsequent()
   * @generated
   * @ordered
   */
  protected Proposition consequent;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PowerImpl()
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
    return SymgPackage.Literals.POWER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Proposition getTrigger()
  {
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrigger(Proposition newTrigger, NotificationChain msgs)
  {
    Proposition oldTrigger = trigger;
    trigger = newTrigger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__TRIGGER, oldTrigger, newTrigger);
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
  public void setTrigger(Proposition newTrigger)
  {
    if (newTrigger != trigger)
    {
      NotificationChain msgs = null;
      if (trigger != null)
        msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__TRIGGER, null, msgs);
      if (newTrigger != null)
        msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__TRIGGER, null, msgs);
      msgs = basicSetTrigger(newTrigger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__TRIGGER, newTrigger, newTrigger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRole1()
  {
    return role1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRole1(String newRole1)
  {
    String oldRole1 = role1;
    role1 = newRole1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__ROLE1, oldRole1, role1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRole2()
  {
    return role2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRole2(String newRole2)
  {
    String oldRole2 = role2;
    role2 = newRole2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__ROLE2, oldRole2, role2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Proposition getAntecedent()
  {
    return antecedent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAntecedent(Proposition newAntecedent, NotificationChain msgs)
  {
    Proposition oldAntecedent = antecedent;
    antecedent = newAntecedent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__ANTECEDENT, oldAntecedent, newAntecedent);
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
  public void setAntecedent(Proposition newAntecedent)
  {
    if (newAntecedent != antecedent)
    {
      NotificationChain msgs = null;
      if (antecedent != null)
        msgs = ((InternalEObject)antecedent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__ANTECEDENT, null, msgs);
      if (newAntecedent != null)
        msgs = ((InternalEObject)newAntecedent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__ANTECEDENT, null, msgs);
      msgs = basicSetAntecedent(newAntecedent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__ANTECEDENT, newAntecedent, newAntecedent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Proposition getConsequent()
  {
    return consequent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConsequent(Proposition newConsequent, NotificationChain msgs)
  {
    Proposition oldConsequent = consequent;
    consequent = newConsequent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__CONSEQUENT, oldConsequent, newConsequent);
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
  public void setConsequent(Proposition newConsequent)
  {
    if (newConsequent != consequent)
    {
      NotificationChain msgs = null;
      if (consequent != null)
        msgs = ((InternalEObject)consequent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__CONSEQUENT, null, msgs);
      if (newConsequent != null)
        msgs = ((InternalEObject)newConsequent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SymgPackage.POWER__CONSEQUENT, null, msgs);
      msgs = basicSetConsequent(newConsequent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymgPackage.POWER__CONSEQUENT, newConsequent, newConsequent));
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
      case SymgPackage.POWER__TRIGGER:
        return basicSetTrigger(null, msgs);
      case SymgPackage.POWER__ANTECEDENT:
        return basicSetAntecedent(null, msgs);
      case SymgPackage.POWER__CONSEQUENT:
        return basicSetConsequent(null, msgs);
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
      case SymgPackage.POWER__NAME:
        return getName();
      case SymgPackage.POWER__TRIGGER:
        return getTrigger();
      case SymgPackage.POWER__ROLE1:
        return getRole1();
      case SymgPackage.POWER__ROLE2:
        return getRole2();
      case SymgPackage.POWER__ANTECEDENT:
        return getAntecedent();
      case SymgPackage.POWER__CONSEQUENT:
        return getConsequent();
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
      case SymgPackage.POWER__NAME:
        setName((String)newValue);
        return;
      case SymgPackage.POWER__TRIGGER:
        setTrigger((Proposition)newValue);
        return;
      case SymgPackage.POWER__ROLE1:
        setRole1((String)newValue);
        return;
      case SymgPackage.POWER__ROLE2:
        setRole2((String)newValue);
        return;
      case SymgPackage.POWER__ANTECEDENT:
        setAntecedent((Proposition)newValue);
        return;
      case SymgPackage.POWER__CONSEQUENT:
        setConsequent((Proposition)newValue);
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
      case SymgPackage.POWER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SymgPackage.POWER__TRIGGER:
        setTrigger((Proposition)null);
        return;
      case SymgPackage.POWER__ROLE1:
        setRole1(ROLE1_EDEFAULT);
        return;
      case SymgPackage.POWER__ROLE2:
        setRole2(ROLE2_EDEFAULT);
        return;
      case SymgPackage.POWER__ANTECEDENT:
        setAntecedent((Proposition)null);
        return;
      case SymgPackage.POWER__CONSEQUENT:
        setConsequent((Proposition)null);
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
      case SymgPackage.POWER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SymgPackage.POWER__TRIGGER:
        return trigger != null;
      case SymgPackage.POWER__ROLE1:
        return ROLE1_EDEFAULT == null ? role1 != null : !ROLE1_EDEFAULT.equals(role1);
      case SymgPackage.POWER__ROLE2:
        return ROLE2_EDEFAULT == null ? role2 != null : !ROLE2_EDEFAULT.equals(role2);
      case SymgPackage.POWER__ANTECEDENT:
        return antecedent != null;
      case SymgPackage.POWER__CONSEQUENT:
        return consequent != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", role1: ");
    result.append(role1);
    result.append(", role2: ");
    result.append(role2);
    result.append(')');
    return result.toString();
  }

} //PowerImpl
