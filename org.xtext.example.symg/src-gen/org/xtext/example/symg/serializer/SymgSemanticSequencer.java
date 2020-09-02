/*
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.symg.services.SymgGrammarAccess;
import org.xtext.example.symg.symg.Atom;
import org.xtext.example.symg.symg.Attribute;
import org.xtext.example.symg.symg.BasicType;
import org.xtext.example.symg.symg.Declar;
import org.xtext.example.symg.symg.DeclarPair;
import org.xtext.example.symg.symg.DomainType;
import org.xtext.example.symg.symg.Enumeration;
import org.xtext.example.symg.symg.EventProp;
import org.xtext.example.symg.symg.IntConst;
import org.xtext.example.symg.symg.Interval;
import org.xtext.example.symg.symg.Junction;
import org.xtext.example.symg.symg.Model;
import org.xtext.example.symg.symg.Negation;
import org.xtext.example.symg.symg.Obligation;
import org.xtext.example.symg.symg.OntoCType;
import org.xtext.example.symg.symg.Point;
import org.xtext.example.symg.symg.PointConst;
import org.xtext.example.symg.symg.Power;
import org.xtext.example.symg.symg.Proposition;
import org.xtext.example.symg.symg.Regular;
import org.xtext.example.symg.symg.RelativeEventPointAfter;
import org.xtext.example.symg.symg.RelativeEventPointBefore;
import org.xtext.example.symg.symg.RelativeSituationPointAfter;
import org.xtext.example.symg.symg.RelativeSituationPointBefore;
import org.xtext.example.symg.symg.SitName;
import org.xtext.example.symg.symg.SitProp;
import org.xtext.example.symg.symg.SymgPackage;
import org.xtext.example.symg.symg.cEvent;
import org.xtext.example.symg.symg.cState;
import org.xtext.example.symg.symg.enumItem;
import org.xtext.example.symg.symg.oEvent;
import org.xtext.example.symg.symg.oState;
import org.xtext.example.symg.symg.pEvent;
import org.xtext.example.symg.symg.pState;

@SuppressWarnings("all")
public class SymgSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SymgGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == SymgPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case SymgPackage.ATOM:
				sequence_Atom(context, (Atom) semanticObject); 
				return; 
			case SymgPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case SymgPackage.BASIC_TYPE:
				sequence_BasicType(context, (BasicType) semanticObject); 
				return; 
			case SymgPackage.DECLAR:
				sequence_Declar(context, (Declar) semanticObject); 
				return; 
			case SymgPackage.DECLAR_PAIR:
				sequence_DeclarPair(context, (DeclarPair) semanticObject); 
				return; 
			case SymgPackage.DOMAIN_TYPE:
				sequence_DomainType(context, (DomainType) semanticObject); 
				return; 
			case SymgPackage.ENUMERATION:
				sequence_Enumeration(context, (Enumeration) semanticObject); 
				return; 
			case SymgPackage.EVENT_PROP:
				sequence_EventProp(context, (EventProp) semanticObject); 
				return; 
			case SymgPackage.INT_CONST:
				sequence_IntConst(context, (IntConst) semanticObject); 
				return; 
			case SymgPackage.INTERVAL:
				sequence_Interval(context, (Interval) semanticObject); 
				return; 
			case SymgPackage.JUNCTION:
				sequence_Junction(context, (Junction) semanticObject); 
				return; 
			case SymgPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case SymgPackage.NEGATION:
				sequence_Negation(context, (Negation) semanticObject); 
				return; 
			case SymgPackage.OBLIGATION:
				sequence_Obligation(context, (Obligation) semanticObject); 
				return; 
			case SymgPackage.ONTO_CTYPE:
				sequence_OntoCType(context, (OntoCType) semanticObject); 
				return; 
			case SymgPackage.PARAMETER:
				sequence_Parameter(context, (org.xtext.example.symg.symg.Parameter) semanticObject); 
				return; 
			case SymgPackage.POINT:
				sequence_Point(context, (Point) semanticObject); 
				return; 
			case SymgPackage.POINT_CONST:
				sequence_PointConst(context, (PointConst) semanticObject); 
				return; 
			case SymgPackage.POWER:
				sequence_Power(context, (Power) semanticObject); 
				return; 
			case SymgPackage.PROPOSITION:
				sequence_Proposition(context, (Proposition) semanticObject); 
				return; 
			case SymgPackage.REGULAR:
				sequence_Regular(context, (Regular) semanticObject); 
				return; 
			case SymgPackage.RELATIVE_EVENT_POINT_AFTER:
				sequence_RelativeEventPointAfter(context, (RelativeEventPointAfter) semanticObject); 
				return; 
			case SymgPackage.RELATIVE_EVENT_POINT_BEFORE:
				sequence_RelativeEventPointBefore(context, (RelativeEventPointBefore) semanticObject); 
				return; 
			case SymgPackage.RELATIVE_SITUATION_POINT_AFTER:
				sequence_RelativeSituationPointAfter(context, (RelativeSituationPointAfter) semanticObject); 
				return; 
			case SymgPackage.RELATIVE_SITUATION_POINT_BEFORE:
				sequence_RelativeSituationPointBefore(context, (RelativeSituationPointBefore) semanticObject); 
				return; 
			case SymgPackage.SIT_NAME:
				sequence_SitName(context, (SitName) semanticObject); 
				return; 
			case SymgPackage.SIT_PROP:
				sequence_SitProp(context, (SitProp) semanticObject); 
				return; 
			case SymgPackage.CEVENT:
				sequence_cEvent(context, (cEvent) semanticObject); 
				return; 
			case SymgPackage.CSTATE:
				sequence_cState(context, (cState) semanticObject); 
				return; 
			case SymgPackage.ENUM_ITEM:
				sequence_enumItem(context, (enumItem) semanticObject); 
				return; 
			case SymgPackage.OEVENT:
				sequence_oEvent(context, (oEvent) semanticObject); 
				return; 
			case SymgPackage.OSTATE:
				sequence_oState(context, (oState) semanticObject); 
				return; 
			case SymgPackage.PEVENT:
				sequence_pEvent(context, (pEvent) semanticObject); 
				return; 
			case SymgPackage.PSTATE:
				sequence_pState(context, (pState) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Atom returns Atom
	 *
	 * Constraint:
	 *     (
	 *         eventProposition=EventProp | 
	 *         situationProposition=SitProp | 
	 *         inner=Proposition | 
	 *         (point=Point interval=Interval) | 
	 *         bool='TRUE' | 
	 *         bool='FALSE'
	 *     )
	 */
	protected void sequence_Atom(ISerializationContext context, Atom semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (name=ID attributeType=CType)
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.ATTRIBUTE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.ATTRIBUTE__NAME));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.ATTRIBUTE__ATTRIBUTE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.ATTRIBUTE__ATTRIBUTE_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeAccess().getAttributeTypeCTypeParserRuleCall_2_0(), semanticObject.getAttributeType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     CType returns BasicType
	 *     BasicType returns BasicType
	 *     TypeName returns BasicType
	 *
	 * Constraint:
	 *     (name='NUMBER' | name='STRING' | name='DATE')
	 */
	protected void sequence_BasicType(ISerializationContext context, BasicType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DeclarPair returns DeclarPair
	 *
	 * Constraint:
	 *     (attr=ID param=ID)
	 */
	protected void sequence_DeclarPair(ISerializationContext context, DeclarPair semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.DECLAR_PAIR__ATTR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.DECLAR_PAIR__ATTR));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.DECLAR_PAIR__PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.DECLAR_PAIR__PARAM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDeclarPairAccess().getAttrIDTerminalRuleCall_0_0(), semanticObject.getAttr());
		feeder.accept(grammarAccess.getDeclarPairAccess().getParamIDTerminalRuleCall_2_0(), semanticObject.getParam());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Declar returns Declar
	 *
	 * Constraint:
	 *     (name=ID type=[Regular|ID] attributes+=DeclarPair* attributes+=DeclarPair)
	 */
	protected void sequence_Declar(ISerializationContext context, Declar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CType returns DomainType
	 *     DomainType returns DomainType
	 *     TypeName returns DomainType
	 *
	 * Constraint:
	 *     superType=[DomainConcept|ID]
	 */
	protected void sequence_DomainType(ISerializationContext context, DomainType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.DOMAIN_TYPE__SUPER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.DOMAIN_TYPE__SUPER_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptIDTerminalRuleCall_0_1(), semanticObject.eGet(SymgPackage.Literals.DOMAIN_TYPE__SUPER_TYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DomainConcept returns Enumeration
	 *     Enumeration returns Enumeration
	 *
	 * Constraint:
	 *     (name=ID enumerationItems+=enumItem* enumerationItems+=enumItem)
	 */
	protected void sequence_Enumeration(ISerializationContext context, Enumeration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     EventProp returns EventProp
	 *
	 * Constraint:
	 *     ((eventName=[Declar|ID] | oEventName=oEvent | cEventName=cEvent | pEventName=pEvent) point=Point)
	 */
	protected void sequence_EventProp(ISerializationContext context, EventProp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IntConst returns IntConst
	 *
	 * Constraint:
	 *     Type=INT
	 */
	protected void sequence_IntConst(ISerializationContext context, IntConst semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INT_CONST__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INT_CONST__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntConstAccess().getTypeINTTerminalRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Interval returns Interval
	 *
	 * Constraint:
	 *     (situationName=SitName | (start=Point end=Point) | unnamed='UNNAMED_INTERVAL')
	 */
	protected void sequence_Interval(ISerializationContext context, Interval semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Junction returns Junction
	 *
	 * Constraint:
	 *     (negativeAtoms+=Negation negativeAtoms+=Negation*)
	 */
	protected void sequence_Junction(ISerializationContext context, Junction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         domainName=ID 
	 *         domainConcepts+=DomainConcept+ 
	 *         contractName=ID 
	 *         parameters+=Parameter+ 
	 *         parameters+=Parameter 
	 *         declarations+=Declar* 
	 *         preconditions+=Proposition* 
	 *         postconditions+=Proposition* 
	 *         obligations+=Obligation* 
	 *         sobligations+=Obligation* 
	 *         powers+=Power* 
	 *         constraints+=Proposition*
	 *     )
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Negation returns Negation
	 *
	 * Constraint:
	 *     (negated?='NOT'? atomicExpression=Atom)
	 */
	protected void sequence_Negation(ISerializationContext context, Negation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Obligation returns Obligation
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         trigger=Proposition? 
	 *         role1=ID 
	 *         role2=ID 
	 *         antecedent=Proposition 
	 *         consequent=Proposition
	 *     )
	 */
	protected void sequence_Obligation(ISerializationContext context, Obligation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     CType returns OntoCType
	 *     OntoCType returns OntoCType
	 *
	 * Constraint:
	 *     (name='ASSET' | name='EVENT' | name='ROLE' | name='SITUATION' | name='CONTRACT')
	 */
	protected void sequence_OntoCType(ISerializationContext context, OntoCType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Parameter returns Parameter
	 *
	 * Constraint:
	 *     (name=ID type=TypeName)
	 */
	protected void sequence_Parameter(ISerializationContext context, org.xtext.example.symg.symg.Parameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PARAMETER__NAME));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PARAMETER__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PARAMETER__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParameterAccess().getTypeTypeNameParserRuleCall_2_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     PointConst returns PointConst
	 *
	 * Constraint:
	 *     Type=INT
	 */
	protected void sequence_PointConst(ISerializationContext context, PointConst semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT_CONST__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT_CONST__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPointConstAccess().getTypeINTTerminalRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Point returns Point
	 *
	 * Constraint:
	 *     (eventName=SitName | unnamed='UNNAMED_POINT' | pointConst=PointConst)
	 */
	protected void sequence_Point(ISerializationContext context, Point semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Power returns Power
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         trigger=Proposition? 
	 *         role1=ID 
	 *         role2=ID 
	 *         antecedent=Proposition 
	 *         consequent=Proposition
	 *     )
	 */
	protected void sequence_Power(ISerializationContext context, Power semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Proposition returns Proposition
	 *
	 * Constraint:
	 *     (junctions+=Junction junctions+=Junction*)
	 */
	protected void sequence_Proposition(ISerializationContext context, Proposition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DomainConcept returns Regular
	 *     Regular returns Regular
	 *
	 * Constraint:
	 *     (name=ID conceptType=CType (attributes+=Attribute* attributes+=Attribute)?)
	 */
	protected void sequence_Regular(ISerializationContext context, Regular semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Point returns RelativeEventPointAfter
	 *     RelativeEventPointAfter returns RelativeEventPointAfter
	 *
	 * Constraint:
	 *     (eventName=SitName tempOp=TempOp unit=Unit pointConst=PointConst)
	 */
	protected void sequence_RelativeEventPointAfter(ISerializationContext context, RelativeEventPointAfter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__EVENT_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__EVENT_NAME));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__TEMP_OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__TEMP_OP));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__UNIT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__POINT_CONST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__POINT_CONST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelativeEventPointAfterAccess().getEventNameSitNameParserRuleCall_0_0(), semanticObject.getEventName());
		feeder.accept(grammarAccess.getRelativeEventPointAfterAccess().getTempOpTempOpParserRuleCall_1_0(), semanticObject.getTempOp());
		feeder.accept(grammarAccess.getRelativeEventPointAfterAccess().getUnitUnitParserRuleCall_2_0(), semanticObject.getUnit());
		feeder.accept(grammarAccess.getRelativeEventPointAfterAccess().getPointConstPointConstParserRuleCall_3_0(), semanticObject.getPointConst());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Point returns RelativeEventPointBefore
	 *     RelativeEventPointBefore returns RelativeEventPointBefore
	 *
	 * Constraint:
	 *     (pointConst=PointConst unit=Unit tempOp=TempOp eventName=SitName)
	 */
	protected void sequence_RelativeEventPointBefore(ISerializationContext context, RelativeEventPointBefore semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__POINT_CONST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__POINT_CONST));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__UNIT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__TEMP_OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__TEMP_OP));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.POINT__EVENT_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.POINT__EVENT_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelativeEventPointBeforeAccess().getPointConstPointConstParserRuleCall_0_0(), semanticObject.getPointConst());
		feeder.accept(grammarAccess.getRelativeEventPointBeforeAccess().getUnitUnitParserRuleCall_1_0(), semanticObject.getUnit());
		feeder.accept(grammarAccess.getRelativeEventPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0(), semanticObject.getTempOp());
		feeder.accept(grammarAccess.getRelativeEventPointBeforeAccess().getEventNameSitNameParserRuleCall_3_0(), semanticObject.getEventName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Interval returns RelativeSituationPointAfter
	 *     RelativeSituationPointAfter returns RelativeSituationPointAfter
	 *
	 * Constraint:
	 *     (situationName=SitName tempOp=TempOp intConst=IntConst unit=Unit)
	 */
	protected void sequence_RelativeSituationPointAfter(ISerializationContext context, RelativeSituationPointAfter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__SITUATION_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__SITUATION_NAME));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__TEMP_OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__TEMP_OP));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__INT_CONST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__INT_CONST));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__UNIT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelativeSituationPointAfterAccess().getSituationNameSitNameParserRuleCall_0_0(), semanticObject.getSituationName());
		feeder.accept(grammarAccess.getRelativeSituationPointAfterAccess().getTempOpTempOpParserRuleCall_1_0(), semanticObject.getTempOp());
		feeder.accept(grammarAccess.getRelativeSituationPointAfterAccess().getIntConstIntConstParserRuleCall_2_0(), semanticObject.getIntConst());
		feeder.accept(grammarAccess.getRelativeSituationPointAfterAccess().getUnitUnitParserRuleCall_3_0(), semanticObject.getUnit());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Interval returns RelativeSituationPointBefore
	 *     RelativeSituationPointBefore returns RelativeSituationPointBefore
	 *
	 * Constraint:
	 *     (intConst=IntConst unit=Unit tempOp=TempOp situationName=SitName)
	 */
	protected void sequence_RelativeSituationPointBefore(ISerializationContext context, RelativeSituationPointBefore semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__INT_CONST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__INT_CONST));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__UNIT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__TEMP_OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__TEMP_OP));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.INTERVAL__SITUATION_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.INTERVAL__SITUATION_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelativeSituationPointBeforeAccess().getIntConstIntConstParserRuleCall_0_0(), semanticObject.getIntConst());
		feeder.accept(grammarAccess.getRelativeSituationPointBeforeAccess().getUnitUnitParserRuleCall_1_0(), semanticObject.getUnit());
		feeder.accept(grammarAccess.getRelativeSituationPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0(), semanticObject.getTempOp());
		feeder.accept(grammarAccess.getRelativeSituationPointBeforeAccess().getSituationNameSitNameParserRuleCall_3_0(), semanticObject.getSituationName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     SitName returns SitName
	 *
	 * Constraint:
	 *     (
	 *         declName=ID | 
	 *         oState=oState | 
	 *         pState=pState | 
	 *         cState=cState | 
	 *         oEvent=oEvent | 
	 *         cEvent=cEvent | 
	 *         pEvent=pEvent
	 *     )
	 */
	protected void sequence_SitName(ISerializationContext context, SitName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     SitProp returns SitProp
	 *
	 * Constraint:
	 *     ((situationName=ID | oSituationName=oState | cSituationName=cState | pSituationName=pState) interval=Interval)
	 */
	protected void sequence_SitProp(ISerializationContext context, SitProp semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     cEvent returns cEvent
	 *
	 * Constraint:
	 *     (contrEvent=ContrEvent contrName=ID)
	 */
	protected void sequence_cEvent(ISerializationContext context, cEvent semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.CEVENT__CONTR_EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.CEVENT__CONTR_EVENT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.CEVENT__CONTR_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.CEVENT__CONTR_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCEventAccess().getContrEventContrEventParserRuleCall_0_0(), semanticObject.getContrEvent());
		feeder.accept(grammarAccess.getCEventAccess().getContrNameIDTerminalRuleCall_2_0(), semanticObject.getContrName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     cState returns cState
	 *
	 * Constraint:
	 *     (contrState=ContrState contractName=ID)
	 */
	protected void sequence_cState(ISerializationContext context, cState semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.CSTATE__CONTR_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.CSTATE__CONTR_STATE));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.CSTATE__CONTRACT_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.CSTATE__CONTRACT_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCStateAccess().getContrStateContrStateParserRuleCall_0_0(), semanticObject.getContrState());
		feeder.accept(grammarAccess.getCStateAccess().getContractNameIDTerminalRuleCall_2_0(), semanticObject.getContractName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     enumItem returns enumItem
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_enumItem(ISerializationContext context, enumItem semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.ENUM_ITEM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.ENUM_ITEM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     oEvent returns oEvent
	 *
	 * Constraint:
	 *     (oblEvent=OblEvent oblName=ID)
	 */
	protected void sequence_oEvent(ISerializationContext context, oEvent semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.OEVENT__OBL_EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.OEVENT__OBL_EVENT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.OEVENT__OBL_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.OEVENT__OBL_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOEventAccess().getOblEventOblEventParserRuleCall_0_0(), semanticObject.getOblEvent());
		feeder.accept(grammarAccess.getOEventAccess().getOblNameIDTerminalRuleCall_2_0(), semanticObject.getOblName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     oState returns oState
	 *
	 * Constraint:
	 *     (oblState=OblState oblName=ID)
	 */
	protected void sequence_oState(ISerializationContext context, oState semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.OSTATE__OBL_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.OSTATE__OBL_STATE));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.OSTATE__OBL_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.OSTATE__OBL_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOStateAccess().getOblStateOblStateParserRuleCall_0_0(), semanticObject.getOblState());
		feeder.accept(grammarAccess.getOStateAccess().getOblNameIDTerminalRuleCall_2_0(), semanticObject.getOblName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     pEvent returns pEvent
	 *
	 * Constraint:
	 *     (powEvent=PowEvent powName=ID)
	 */
	protected void sequence_pEvent(ISerializationContext context, pEvent semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PEVENT__POW_EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PEVENT__POW_EVENT));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PEVENT__POW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PEVENT__POW_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPEventAccess().getPowEventPowEventParserRuleCall_0_0(), semanticObject.getPowEvent());
		feeder.accept(grammarAccess.getPEventAccess().getPowNameIDTerminalRuleCall_2_0(), semanticObject.getPowName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     pState returns pState
	 *
	 * Constraint:
	 *     (powState=PowState powName=ID)
	 */
	protected void sequence_pState(ISerializationContext context, pState semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PSTATE__POW_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PSTATE__POW_STATE));
			if (transientValues.isValueTransient(semanticObject, SymgPackage.Literals.PSTATE__POW_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SymgPackage.Literals.PSTATE__POW_NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPStateAccess().getPowStatePowStateParserRuleCall_0_0(), semanticObject.getPowState());
		feeder.accept(grammarAccess.getPStateAccess().getPowNameIDTerminalRuleCall_2_0(), semanticObject.getPowName());
		feeder.finish();
	}
	
	
}
