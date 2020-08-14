/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.symg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symg.symg.Power#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.Power#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.Power#getRole1 <em>Role1</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.Power#getRole2 <em>Role2</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.Power#getAntecedent <em>Antecedent</em>}</li>
 *   <li>{@link org.xtext.example.symg.symg.Power#getConsequent <em>Consequent</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.symg.symg.SymgPackage#getPower()
 * @model
 * @generated
 */
public interface Power extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger</em>' containment reference.
   * @see #setTrigger(Proposition)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Trigger()
   * @model containment="true"
   * @generated
   */
  Proposition getTrigger();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getTrigger <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger</em>' containment reference.
   * @see #getTrigger()
   * @generated
   */
  void setTrigger(Proposition value);

  /**
   * Returns the value of the '<em><b>Role1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role1</em>' attribute.
   * @see #setRole1(String)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Role1()
   * @model
   * @generated
   */
  String getRole1();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getRole1 <em>Role1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role1</em>' attribute.
   * @see #getRole1()
   * @generated
   */
  void setRole1(String value);

  /**
   * Returns the value of the '<em><b>Role2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role2</em>' attribute.
   * @see #setRole2(String)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Role2()
   * @model
   * @generated
   */
  String getRole2();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getRole2 <em>Role2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role2</em>' attribute.
   * @see #getRole2()
   * @generated
   */
  void setRole2(String value);

  /**
   * Returns the value of the '<em><b>Antecedent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Antecedent</em>' containment reference.
   * @see #setAntecedent(Proposition)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Antecedent()
   * @model containment="true"
   * @generated
   */
  Proposition getAntecedent();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getAntecedent <em>Antecedent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Antecedent</em>' containment reference.
   * @see #getAntecedent()
   * @generated
   */
  void setAntecedent(Proposition value);

  /**
   * Returns the value of the '<em><b>Consequent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Consequent</em>' containment reference.
   * @see #setConsequent(Proposition)
   * @see org.xtext.example.symg.symg.SymgPackage#getPower_Consequent()
   * @model containment="true"
   * @generated
   */
  Proposition getConsequent();

  /**
   * Sets the value of the '{@link org.xtext.example.symg.symg.Power#getConsequent <em>Consequent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Consequent</em>' containment reference.
   * @see #getConsequent()
   * @generated
   */
  void setConsequent(Proposition value);

} // Power
