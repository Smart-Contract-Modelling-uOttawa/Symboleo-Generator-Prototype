/*
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.example.symg.symg.Model
import org.xtext.example.symg.symg.Obligation
import org.xtext.example.symg.symg.Proposition
import org.xtext.example.symg.symg.Junction
import org.xtext.example.symg.symg.Negation
import org.xtext.example.symg.symg.Atom
import org.xtext.example.symg.symg.EventProp
import org.xtext.example.symg.symg.SitProp
import org.xtext.example.symg.symg.oEvent
import org.xtext.example.symg.symg.cEvent
import org.xtext.example.symg.symg.pEvent
import org.xtext.example.symg.symg.oState
import org.xtext.example.symg.symg.cState
import org.xtext.example.symg.symg.pState
import org.xtext.example.symg.symg.SitName
import org.xtext.example.symg.symg.Point
import org.xtext.example.symg.symg.Power
import org.xtext.example.symg.symg.Interval
import java.util.HashMap
import org.xtext.example.symg.symg.Regular
import org.xtext.example.symg.symg.Enumeration
import org.xtext.example.symg.symg.DomainType
import org.xtext.example.symg.symg.BasicType
import org.xtext.example.symg.symg.OntoCType
import org.xtext.example.symg.symg.Declar

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class SymgGenerator extends AbstractGenerator {

	def compile(Model model) {
		var res = new StringBuilder()
		var superTypes = new HashMap<String, String>()
		var totParams = 0
		var p = 1
		// compiling domain
		res.append("## Domain\n")
		for (domainConcept : model.domainConcepts) {
			domainConcept.compileDomainConcept(res, superTypes)
		}
		
		res.append("\n## Declarations\n")		
		// count the number of contract parameters
		for (param: model.parameters) {
			var pType = param.type.checkParameterType(superTypes)
			if (pType.equals('ROLE') || pType.equals('DATE') || pType.equals('ASSET')) {
				totParams += 1
			}
		}
		
		// count the number of contract parameters
		for (declaration : model.declarations) {
			var parentType = declaration.type.name
			
			while (superTypes.containsKey(parentType)) {
				parentType = superTypes.get(parentType)
			}
			
			if (parentType.equals('ASSET')) {
				totParams += 1
			}
		}
		
		// I'm guessing length of contract = #roles + #dates + #assets + 1
		
		res.append("c(X)\t:-\tinitially(" + model.contractName + "(X")
		for (i : 0..< totParams) {
			res.append(",_")
		}
		res.append(")).\n\n")
		totParams -= 1
		
		for (param : model.parameters) {
			var pType = param.type.checkParameterType(superTypes)
			
			if (pType.equals('ROLE') || pType.equals('DATE') || pType.equals('ASSET')) {
				if (pType.equals('ROLE')) {
					res.append("initially(bind(" + param.name + ",X))\t:-\t")
				}
				if (pType.equals('ASSET') || pType.equals('DATE')) {
					res.append(param.name + "(X)\t:-\t")	
				}
				res.append("initially(" + model.contractName + "(")
				for (i : 0..< p) {
					res.append("_,")
				}
				res.append("X")
				for (i : 0..< totParams) {
					res.append(",_")
				}
				res.append(")).\n")
				totParams -= 1
				p += 1
			}
		}
		
		// adds declarations to the contract parameters
		for (declaration : model.declarations) {
			var parentType = declaration.type.name
			
			while (superTypes.containsKey(parentType)) {
				parentType = superTypes.get(parentType)
			}
			
			if (parentType.equals('ASSET')) {
				res.append(declaration.name + "(X)\t:-\t")	
				res.append("initially(" + model.contractName + "(")
				for (i : 0..< p) {
					res.append("_,")
				}
				res.append("X")
				for (i : 0..< totParams) {
					res.append(",_")
				}
				res.append(")).\n")
				totParams -= 1
				p += 1
			}
		}
		res.append("\n\n")
		
		// compiling declarations
		for (declaration : model.declarations) {
			declaration.compileDeclaration(res, superTypes)
		}
		
		res.append("\n## Contract\n")
		res.append("initially(form(X))\t:-\t")
		res.append("initially(" + model.contractName + "(X")
		
		for (i : 0..< p-1) {
			res.append(",_")
		}
		res.append(")).\n")
		
		res.append("\n## Obligations\n")
		// compiling obligations
		for (i : 0 ..< model.obligations.length) {
			model.obligations.get(i).compileObligations(i+1, res)
		}
		
		res.append("\n## Powers\n")
		// compiling powers
		for(i : 0..< model.powers.length) {
			model.powers.get(i).compilePowers(i+1, res)
		}
		
		res.append("\n## Surviving Obligations\n")
		// compiling surviving obligations
		for (i : 0..< model.sobligations.length) {
			model.sobligations.get(i).compileSObligations(i+1, res)
		}
		
		return res.toString
	}
	
	def compileSObligations(Obligation obl, int i, StringBuilder res) {
		res.append("SO(X)\t:-\tSO" + i + "(X).\n")
		res.append("SO" + i + "(" + obl.name + ").\n")
		res.append("associate(" + obl.name + ",cArgToCan).\n\n")
		res.append("initially(debtor(X,P))\t:-\tO" + i + "(X),initially(bind(" + obl.role1 + ",P)).\n")
		res.append("initially(creditor(X,P))\t:-\tO" + i + "(X),initially(bind(" + obl.role1 + ",P)).\n\n")
		obl.antecedent.compileAntecedent(obl.name, res)
		obl.trigger.compileTrigger(obl.name, res)
		obl.consequent.compileOConsequent(obl.name, res)
		res.append("\n\n")
	}
	
	def compilePowers(Power power, int i, StringBuilder res) {
		res.append("P(X)\t:-\tP" + i + "(X).\n")
		res.append("P" + i + "(" + power.name + ").\n")
		res.append("associate(" + power.name + ",cArgToCan).\n\n")
		res.append("initially(debtor(X,P))\t:-\tP" + i + "(X),initially(bind(" + power.role1 + ",P)).\n")
		res.append("initially(creditor(X,P))\t:-\tP" + i + "(X),initially(bind(" + power.role1 + ",P)).\n\n")
		power.antecedent.compileAntecedent(power.name, res)
		power.trigger.compileTrigger(power.name, res)
	}
	
	def dispatch checkParameterType(DomainType dType, HashMap<String, String> superTypes) {
		var parentType = dType.superType.name
		
		while (superTypes.containsKey(parentType)) {
			parentType = superTypes.get(parentType)
		}
		
		return parentType
	}
	
	def dispatch checkParameterType(BasicType bType, HashMap<String, String> superTypes) {
		return bType.name
	}
	
	/**
	 * Generates prolog code for a declaration
	 */
	def compileDeclaration(Declar declaration, StringBuilder res, HashMap<String, String> superTypes) {
		var parentType = declaration.type.name
		
		// determine parent type
		while (superTypes.containsKey(parentType)) {
			parentType = superTypes.get(parentType)
		}
		
		if (parentType.equals('EVENT')) {
			res.append(declaration.name + "(E)\t:-\t")
			res.append("happens(E,T),")
			res.append("holds_at(type(E," + declaration.name + "),T),")
			for (i : 0 ..< declaration.attributes.length) {
				if (declaration.attributes.get(i).attr.equals('from')) {
					res.append("within(E,performer(O," + declaration.attributes.get(i).param.name + ")),")
				}
				if (declaration.attributes.get(i).attr.equals('to')) {
					res.append("within(E,rightHolder(O," + declaration.attributes.get(i).param.name + ")),")
				}
				res.append("holds_at(" + declaration.attributes.get(i).attr + "(E," + declaration.attributes.get(i).param.name + "),T)")	
				if (i < declaration.attributes.length - 1) {
					res.append(",")
				}
			}
			res.append(".\n")
		}
		
		// think about how objects will work with this
	}
	
	/**
	 * Generates prolog code for a regular domain concept
	 */
	def dispatch compileDomainConcept(Regular domainConcept, StringBuilder res, HashMap<String, String> superTypes) {
		domainConcept.conceptType.compileCType(domainConcept.name, res, superTypes)
	}
	
	/**
	 * compiles domain concept if its type is another domain concept
	 */
	def dispatch compileCType(DomainType dType, String dName, StringBuilder res, HashMap<String, String> superTypes) {
		res.append(dType.superType.name + "(X)\t:-\t" + dName + "(X).\n")
		superTypes.put(dName, dType.superType.name)
	}
	
	/**
	 * compiles domain concept if its type is a basic type
	 */
	def dispatch compileCType(BasicType bType, String dName, StringBuilder res, HashMap<String, String> superTypes) {
		res.append(bType.name + "(" + dName + ").\n")
		superTypes.put(dName, bType.name)
	}
	
	/**
	 * compiles domain concept if its type is an ontoctype
	 */
	def dispatch compileCType(OntoCType oType, String dName, StringBuilder res, HashMap<String, String> superTypes) {
		if (oType.name.equals('ROLE')) {
			res.append("ROLE(" + dName + ").\n")
		}
		else {
			res.append(oType.name + "(X)\t:-\t" + dName + "(X).\n")
		}
		superTypes.put(dName, oType.name)
	}
	
	/**
	 * Generates prolog code for an enumeration domain concept
	 */
	def dispatch compileDomainConcept(Enumeration domainConcept, StringBuilder res, HashMap<String, String> superTypes) {
		for (value : domainConcept.enumerationItems) {
			res.append(domainConcept.name + "(" + value.name + ").\n")
		}
		res.append("\n")
	}
	
	def compileObligations(Obligation obl, int i, StringBuilder res) {
		res.append("O(X)\t:-\tO" + i + "(X).\n")
		res.append("O" + i + "(" + obl.name + ").\n")
		res.append("associate(" + obl.name + ",cArgToCan).\n\n")
		res.append("initially(debtor(X,P))\t:-\tO" + i + "(X),initially(bind(" + obl.role1 + ",P)).\n")
		res.append("initially(creditor(X,P))\t:-\tO" + i + "(X),initially(bind(" + obl.role1 + ",P)).\n\n")
		obl.antecedent.compileAntecedent(obl.name, res)
		obl.trigger.compileTrigger(obl.name, res)
		obl.consequent.compileOConsequent(obl.name, res)
		res.append("\n\n")
	}
	
	def compileAntecedent(Proposition prop, String oblName, StringBuilder res) {
		var ant = new StringBuilder()
		
		for (junction : prop.junctions) {
			ant.append("ant(" + oblName + ")\t:-\t")
			junction.obligationCompileAnds(ant, 0)
			ant.append(".\n")
		}
		
		res.append(ant.toString)
	}
	
	def compileOConsequent(Proposition prop, String oblName, StringBuilder res) {
		var cons = new StringBuilder()
		
		for (junction : prop.junctions) {
			cons.append("initiates(E0, cons(" + oblName + "))\t:\t")
			junction.obligationCompileAnds(cons, 0)
			cons.append(".\n")
		}
		
		res.append(cons.toString)
	}
	
	def compileTrigger(Proposition trigger, String oblName, StringBuilder res) {
		if (trigger == null) {
			res.append("initiates(E0,trigger(" + oblName + "))\t:-\thappens(E0,_),initiates(E0,inEffect(cArgToCan)).\n")
			return
		}
		
		var trig = new StringBuilder()
		
		for (junction : trigger.junctions) {
			trig.append("initiates(E0,trigger(" + oblName + "))\t:-\t")
			junction.obligationCompileAnds(trig, 0)
			trig.append(".\n")
		}
		
		res.append(trig.toString)
	}
	
	def obligationCompileAnds(Junction junc, StringBuilder res, int d) {
		var x = 0
		for (atom : junc.negativeAtoms) {
			atom.obligationCompileNegs(res, d)
			if (x < junc.negativeAtoms.length - 1) {
				res.append(',')
				x += 1	
			}
		}
	}
	
	def obligationCompileNegs(Negation atom, StringBuilder res, int d) {
		if (atom.negated) {
			res.append("\\+(")
			atom.atomicExpression.obligationCompileAtom(res, d)
			res.append(")")
		}
		else {
			atom.atomicExpression.obligationCompileAtom(res, d)
		}
	}
	
	def obligationCompileAtom(Atom atom, StringBuilder res, int d) {
		if (atom.bool == 'TRUE') {
			res.append("TRUE")	
		}
		if (atom.bool == 'FALSE') {
			res.append("FALSE")
		}
		if (atom.eventProposition != null) {
			atom.eventProposition.obligationCompileEventProp(res, d)
		}
		if (atom.situationProposition != null) {
			atom.situationProposition.obligationCompileSituationProp(res, d)
		}
		if (atom.point != null && atom.interval != null) {
			atom.point.obligationCompileWithin(atom.interval, res, d)
		}
	}
	
	def obligationCompileWithin(Point point, Interval interval, StringBuilder res, int d) {
		point.compilePoint(res, d)
		res.append(",")
		interval.compileInterval(res, d+1)
	}
	
	def obligationCompileEventProp(EventProp eProp, StringBuilder res, int d) {
		// compile point
		eProp.point.compilePoint(res, d)
		res.append(",")
		
		// compile event
		// happens(paid,UNNAMED_POINT)
		// happens(E0,T0),paid(E0)
		if (eProp.eventName != null) {
			res.append(eProp.eventName + "(E" + d + ")")
		}
		else {
			if (eProp.OEventName != null) {
				eProp.OEventName.compileOEvent(res, d)
			}
			if (eProp.CEventName != null) {
				eProp.CEventName.compileCEvent(res, d)
			}
			if (eProp.PEventName != null) {
				eProp.PEventName.compilePEvent(res, d)
			}
		}
	}
	
	def obligationCompileSituationProp(SitProp sProp, StringBuilder res, int d) {
		//compile interval
		sProp.interval.compileInterval(res, d)
		res.append(",")
		// oViolation(02)
		// [paid,delivered]
		
		//compile situation
		if (sProp.situationName != null) {
			res.append(sProp.situationName + "(E" + d + ")")
		}
		else {
			// potentially not right
			res.append("initiates(E" + d + ",")
			if (sProp.OSituationName != null) {
				sProp.OSituationName.compileOState(res)
			}
			if (sProp.CSituationName != null) {
				sProp.CSituationName.compileCState(res)
			}
			if (sProp.PSituationName != null) {
				sProp.PSituationName.compilePState(res)
			}
			if (sProp.situationName != null) {
				res.append(sProp.situationName + "(X)")
			}
			res.append(")")
		}
	}
	
	def compilePoint(Point point, StringBuilder res, int d) {
		if (point.unnamed != null) {
			res.append("happens(E" + d + ",T" + d + ")")
		}
		else {
			if (point.tempOp != null) {
				// 5 DAYS AFTER paid
				// happens(E0,T0),happens(E1,T1),paid(E1),T0+5=T1
				res.append("happens(E" + d + ",T" + d + "),")
				res.append("happens(E" + (d+1) + ",T" + (d+1) + "),")
				point.eventName.compileEvent(res, d+1)
				res.append(",")
				res.append("T" + d)
				if (point.tempOp.equals('BEFORE')) {
					res.append("-")
				}
				else {
					res.append("+")
				}
				res.append(point.pointConst.type + "=T" + (d+1))
			}
			else {
				if (point.pointConst != null) {
					// happens(delivered, 180)
					// happens(E0,180), delivered(E0)
					res.append("happens(E" + d + "," + point.pointConst.type + ")")
				}
				else {
					// happens(delivered,oTRIGGERED(o2))
					// happens(E0,T0), initiates(E0,trigger(o2)) -> T0
					res.append("happens(E" + d + ",T" + d + "),")
					point.eventName.compileEvent(res, d)
				}
			}
		}
	}
	
	def compileEvent(SitName event, StringBuilder res, int d) {
		if (event.OEvent != null) {
			event.OEvent.compileOEvent(res, d)
		}	
		if (event.CEvent != null) {
			event.CEvent.compileCEvent(res, d)
		}
		if (event.PEvent != null) {
			event.PEvent.compilePEvent(res, d)
		}
		if (event.sitName != null) {
			res.append(event.sitName + "(E" + d + ")")
		}
	}
	
	def compileOEvent(oEvent event, StringBuilder res, int d) {
		
		res.append("initiates(E" + d + ",")
		switch (event.oblEvent) {
			case 'oTRIGGERED': res.append('trigger(' + event.oblName + ')')
			case 'oACTIVATED': res.append('activate(' + event.oblName + ')')
			case 'oSUSPENDED': res.append('suspend(' + event.oblName + ')')
			case 'oRESUMED': res.append('resume(' + event.oblName + ')')
			case 'oDISCHARGED': res.append('discharge(' + event.oblName + ')')
			case 'oEXPIRED': res.append('expire(' + event.oblName + ')')
			case 'oFULFILLED': res.append('fulfill(' + event.oblName + ')')
			case'oVIOLATED': res.append('violate(' + event.oblName + ')')
			case 'oTERMINATED': res.append('terminate(' + event.oblName + ')')
		}
		res.append(")")
	}
	
	def compileCEvent(cEvent event, StringBuilder res, int d) {
				
		res.append("initiates(E" + d + ",")
		switch (event.contrEvent) {
			case 'cACTIVATED': res.append('activate(' + event.contrName + ')')
			case 'cSUSPENDED': res.append('suspend(' + event.contrName + ')')
			case 'cRESUMED': res.append('resume(' + event.contrName + ')')
			case 'cFULFILLED_ACTIVE_OBLS': res.append('fulfill(' + event.contrName + ')')
			case 'cREVOKED_PARTY': res.append('revoke(' + event.contrName + ')')
			case 'cASSIGNED_PARTY': res.append('assignParty(' + event.contrName + ')')
			case 'cTERMINATED': res.append('terminate(' + event.contrName + ')')
		}
		res.append(")")
	}
	
	def compilePEvent(pEvent event, StringBuilder res, int d) {

		res.append("initiates(E" + d + ",")
		switch (event.powEvent) {
			case 'pTRIGGERED': res.append('trigger(' + event.powName + ')')
			case 'pACTIVATED': res.append('activate(' + event.powName + ')')
			case 'pSUSPENDED': res.append('suspend(' + event.powName + ')')
			case 'pRESUMED': res.append('resume(' + event.powName + ')')
			case 'pEXERTED': res.append('exert(' + event.powName + ')')
			case 'pEXPIRED': res.append('expire(' + event.powName + ')')
			case 'pTERMINATED': res.append('terminate(' + event.powName + ')')
		}
		res.append(")")
	}
	
	def compileInterval(Interval interval, StringBuilder res, int d) {
		if (interval.unnamed != null) {
			res.append("happens(E" + d + ",T" + d + ")")
		}
		else {
			if (interval.intConst != null) {
				// where does AT fit into this?
				// what is this?
			}
			else {
				if (interval.situationName != null) {
					// within(E0,oViolation(o2))
					res.append("within(E" + d + ",")
					interval.situationName.compileState(res)
					res.append(")")
				}
				else {
					interval.start.compilePoint(res, d+1)
					res.append(",")
					interval.end.compilePoint(res, d+2)
					res.append(",")
					res.append("T" + (d+1) + "<=T" + d + "<=T" + (d+2))
				}
			}
		}
	}
	
	def compileState(SitName state, StringBuilder res) {
		if (state.OState != null) {
			state.OState.compileOState(res)
		}
		if (state.CState != null) {
			state.CState.compileCState(res)
		}
		if (state.PState != null) {
			state.PState.compilePState(res)
		}
		if (state.sitName != null) {
			res.append(state.sitName + "(X)")
		}
	}
	
	def compileOState(oState state, StringBuilder res) {
		switch (state.oblState) {
			case 'oCREATE': res.append('create(' + state.oblName + ')')
			case 'oINEFFECT': res.append('ineffect(' + state.oblName + ')')
			case 'oSUSPENSION': res.append('suspension(' + state.oblName + ')')
			case 'oSUCCESSFUL_TERMINATION': res.append('successfulTermination(' + state.oblName + ')')
			case 'oUNSUCCESSFUL_TERMINATION': res.append('unsuccessfulTermination(' + state.oblName + ')')
			case 'oVIOLATION': res.append('violation(' + state.oblName + ')')
			case 'oFULFILLMENT': res.append('fulfillment(' + state.oblName + ')')
			case 'oDISCHARGE': res.append('discharge(' + state.oblName + ')')
		}
	}
	
	def compileCState(cState state, StringBuilder res) {
		switch (state.contrState) {
			case 'cFORM': res.append('form(' + state.contractName + ')')
			case 'cINEFFECT': res.append('ineffect(' + state.contractName + ')')
			case 'cSUSPENSION': res.append('suspension(' + state.contractName + ')')
			case 'cSUCCESSFUL_TERMINATION': res.append('successfulTermination(' + state.contractName + ')')
			case 'cUNSECCESSFUL_TERMINATION': res.append('unsuccessfulTermination(' + state.contractName + ')')
			case 'cUNASSIGN': res.append('unassign(' + state.contractName + ')')
		}
	}
	
	def compilePState(pState state, StringBuilder res) {
		switch (state.powState) {
			case 'pCREATE': res.append('create(' + state.powName + ')')
			case 'pINEFFECT': res.append('ineffect(' + state.powName + ')')
			case 'pSUSPENSION': res.append('suspension(' + state.powName + ')')
			case 'pSUCCESSFUL_TERMINATION': res.append('successfulTermination(' + state.powName + ')')
			case 'pUNSUCCESSFUL_TERMINATION': res.append('unsuccessfulTermination(' + state.powName + ')')
		}
	}
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		fsa.generateFile('test.pl', resource.allContents.filter(Model).head.compile)
	}
}
