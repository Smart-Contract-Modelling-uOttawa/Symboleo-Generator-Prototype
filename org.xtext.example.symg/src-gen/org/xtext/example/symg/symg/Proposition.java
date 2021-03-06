/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.symg;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.symg.symg.Proposition#getJunctions <em>Junctions</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.symg.symg.SymgPackage#getProposition()
 * @model
 * @generated
 */
public interface Proposition extends EObject
{
  /**
   * Returns the value of the '<em><b>Junctions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.symg.symg.Junction}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Junctions</em>' containment reference list.
   * @see org.xtext.example.symg.symg.SymgPackage#getProposition_Junctions()
   * @model containment="true"
   * @generated
   */
  EList<Junction> getJunctions();

} // Proposition
