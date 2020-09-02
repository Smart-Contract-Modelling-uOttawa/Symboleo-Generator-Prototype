/**
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.symg.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.example.symg.symg.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.example.symg.symg.SymgPackage
 * @generated
 */
public class SymgSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SymgPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymgSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SymgPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case SymgPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.DOMAIN_CONCEPT:
      {
        DomainConcept domainConcept = (DomainConcept)theEObject;
        T result = caseDomainConcept(domainConcept);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.REGULAR:
      {
        Regular regular = (Regular)theEObject;
        T result = caseRegular(regular);
        if (result == null) result = caseDomainConcept(regular);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.ENUMERATION:
      {
        Enumeration enumeration = (Enumeration)theEObject;
        T result = caseEnumeration(enumeration);
        if (result == null) result = caseDomainConcept(enumeration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.ENUM_ITEM:
      {
        enumItem enumItem = (enumItem)theEObject;
        T result = caseenumItem(enumItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.CTYPE:
      {
        CType cType = (CType)theEObject;
        T result = caseCType(cType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.DOMAIN_TYPE:
      {
        DomainType domainType = (DomainType)theEObject;
        T result = caseDomainType(domainType);
        if (result == null) result = caseCType(domainType);
        if (result == null) result = caseTypeName(domainType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.BASIC_TYPE:
      {
        BasicType basicType = (BasicType)theEObject;
        T result = caseBasicType(basicType);
        if (result == null) result = caseCType(basicType);
        if (result == null) result = caseTypeName(basicType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.ONTO_CTYPE:
      {
        OntoCType ontoCType = (OntoCType)theEObject;
        T result = caseOntoCType(ontoCType);
        if (result == null) result = caseCType(ontoCType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.TYPE_NAME:
      {
        TypeName typeName = (TypeName)theEObject;
        T result = caseTypeName(typeName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.DECLAR_PAIR:
      {
        DeclarPair declarPair = (DeclarPair)theEObject;
        T result = caseDeclarPair(declarPair);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.DECLAR:
      {
        Declar declar = (Declar)theEObject;
        T result = caseDeclar(declar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.OBLIGATION:
      {
        Obligation obligation = (Obligation)theEObject;
        T result = caseObligation(obligation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.POWER:
      {
        Power power = (Power)theEObject;
        T result = casePower(power);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.PROPOSITION:
      {
        Proposition proposition = (Proposition)theEObject;
        T result = caseProposition(proposition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.JUNCTION:
      {
        Junction junction = (Junction)theEObject;
        T result = caseJunction(junction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.NEGATION:
      {
        Negation negation = (Negation)theEObject;
        T result = caseNegation(negation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.ATOM:
      {
        Atom atom = (Atom)theEObject;
        T result = caseAtom(atom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.SIT_PROP:
      {
        SitProp sitProp = (SitProp)theEObject;
        T result = caseSitProp(sitProp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.EVENT_PROP:
      {
        EventProp eventProp = (EventProp)theEObject;
        T result = caseEventProp(eventProp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.INTERVAL:
      {
        Interval interval = (Interval)theEObject;
        T result = caseInterval(interval);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.RELATIVE_SITUATION_POINT_BEFORE:
      {
        RelativeSituationPointBefore relativeSituationPointBefore = (RelativeSituationPointBefore)theEObject;
        T result = caseRelativeSituationPointBefore(relativeSituationPointBefore);
        if (result == null) result = caseInterval(relativeSituationPointBefore);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.RELATIVE_SITUATION_POINT_AFTER:
      {
        RelativeSituationPointAfter relativeSituationPointAfter = (RelativeSituationPointAfter)theEObject;
        T result = caseRelativeSituationPointAfter(relativeSituationPointAfter);
        if (result == null) result = caseInterval(relativeSituationPointAfter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.SIT_NAME:
      {
        SitName sitName = (SitName)theEObject;
        T result = caseSitName(sitName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.INT_CONST:
      {
        IntConst intConst = (IntConst)theEObject;
        T result = caseIntConst(intConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.POINT:
      {
        Point point = (Point)theEObject;
        T result = casePoint(point);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.RELATIVE_EVENT_POINT_BEFORE:
      {
        RelativeEventPointBefore relativeEventPointBefore = (RelativeEventPointBefore)theEObject;
        T result = caseRelativeEventPointBefore(relativeEventPointBefore);
        if (result == null) result = casePoint(relativeEventPointBefore);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.RELATIVE_EVENT_POINT_AFTER:
      {
        RelativeEventPointAfter relativeEventPointAfter = (RelativeEventPointAfter)theEObject;
        T result = caseRelativeEventPointAfter(relativeEventPointAfter);
        if (result == null) result = casePoint(relativeEventPointAfter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.PEVENT:
      {
        pEvent pEvent = (pEvent)theEObject;
        T result = casepEvent(pEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.CEVENT:
      {
        cEvent cEvent = (cEvent)theEObject;
        T result = casecEvent(cEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.OEVENT:
      {
        oEvent oEvent = (oEvent)theEObject;
        T result = caseoEvent(oEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.POINT_CONST:
      {
        PointConst pointConst = (PointConst)theEObject;
        T result = casePointConst(pointConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.OSTATE:
      {
        oState oState = (oState)theEObject;
        T result = caseoState(oState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.CSTATE:
      {
        cState cState = (cState)theEObject;
        T result = casecState(cState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SymgPackage.PSTATE:
      {
        pState pState = (pState)theEObject;
        T result = casepState(pState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Concept</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Concept</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainConcept(DomainConcept object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Regular</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Regular</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegular(Regular object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumeration(Enumeration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>enum Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>enum Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseenumItem(enumItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>CType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCType(CType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainType(DomainType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicType(BasicType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Onto CType</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Onto CType</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOntoCType(OntoCType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeName(TypeName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declar Pair</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declar Pair</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclarPair(DeclarPair object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declar</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declar</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclar(Declar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Obligation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Obligation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObligation(Obligation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Power</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Power</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePower(Power object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Proposition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Proposition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProposition(Proposition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Junction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Junction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJunction(Junction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegation(Negation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtom(Atom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sit Prop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sit Prop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSitProp(SitProp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Prop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Prop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventProp(EventProp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interval</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interval</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterval(Interval object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relative Situation Point Before</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relative Situation Point Before</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelativeSituationPointBefore(RelativeSituationPointBefore object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relative Situation Point After</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relative Situation Point After</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelativeSituationPointAfter(RelativeSituationPointAfter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sit Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sit Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSitName(SitName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntConst(IntConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePoint(Point object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relative Event Point Before</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relative Event Point Before</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelativeEventPointBefore(RelativeEventPointBefore object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relative Event Point After</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relative Event Point After</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelativeEventPointAfter(RelativeEventPointAfter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>pEvent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>pEvent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casepEvent(pEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>cEvent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>cEvent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casecEvent(cEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>oEvent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>oEvent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseoEvent(oEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Point Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Point Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePointConst(PointConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>oState</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>oState</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseoState(oState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>cState</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>cState</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casecState(cState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>pState</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>pState</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casepState(pState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //SymgSwitch
