package org.xtext.example.symg.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.symg.services.SymgGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSymgParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NUMBER'", "'STRING'", "'DATE'", "'ASSET'", "'EVENT'", "'ROLE'", "'SITUATION'", "'CONTRACT'", "'SECONDS'", "'MINUTES'", "'HOURS'", "'DAYS'", "'WEEKS'", "'MONTHS'", "'QUARTERS'", "'YEARS'", "'BEFORE'", "'AFTER'", "'AT'", "'WITHIN'", "'+'", "'-'", "'pTRIGGERED'", "'pACTIVATED'", "'pSUSPENDED'", "'pRESUMED'", "'pEXERTED'", "'pEXPIRED'", "'pTERMINATED'", "'cACTIVATED'", "'cSUSPENDED'", "'cRESUMED'", "'cFULFILLED_ACTIVE_OBLS'", "'cREVOKED_PARTY'", "'cASSIGNED_PARTY'", "'cTERMINATED'", "'oTRIGGERED'", "'oACTIVATED'", "'oSUSPENDED'", "'oRESUMED'", "'oDISCHARGED'", "'oEXPIRED'", "'oFULFILLED'", "'oVIOLATED'", "'oTERMINATED'", "'oCREATE'", "'oINEFFECT'", "'oSUSPENSION'", "'oUNSUCCESSFUL_TERMINATION'", "'oVIOLATION'", "'oFULFILLMENT'", "'oDISCHARGE'", "'cFORM'", "'cINEFFECT'", "'cSUSPENSION'", "'cSUCCESSFUL_TERMINATION'", "'cUNSECCESSFUL_TERMINATION'", "'cUNASSIGN'", "'pCREATE'", "'pINEFFECT'", "'pSUSPENSION'", "'pSUCCESSFUL_TERMINATION'", "'pUNSUCCESSFUL_TERMINATION'", "'Domain'", "'endDomain'", "'Contract'", "'('", "')'", "'endContract'", "';'", "','", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'Surviving'", "'Powers'", "'Constraints'", "'isA'", "'with'", "':'", "'Enumeration'", "':='", "'obligation'", "'->'", "'power'", "'OR'", "'AND'", "'happens'", "'occurs'", "'within'", "'['", "']'", "'NOT'", "'TRUE'", "'FALSE'", "'UNNAMED_INTERVAL'", "'UNNAMED_POINT'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSymgParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSymgParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSymgParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSymg.g"; }


    	private SymgGrammarAccess grammarAccess;

    	public void setGrammarAccess(SymgGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalSymg.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalSymg.g:54:1: ( ruleModel EOF )
            // InternalSymg.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSymg.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalSymg.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalSymg.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalSymg.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalSymg.g:69:3: ( rule__Model__Group__0 )
            // InternalSymg.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainConcept"
    // InternalSymg.g:78:1: entryRuleDomainConcept : ruleDomainConcept EOF ;
    public final void entryRuleDomainConcept() throws RecognitionException {
        try {
            // InternalSymg.g:79:1: ( ruleDomainConcept EOF )
            // InternalSymg.g:80:1: ruleDomainConcept EOF
            {
             before(grammarAccess.getDomainConceptRule()); 
            pushFollow(FOLLOW_1);
            ruleDomainConcept();

            state._fsp--;

             after(grammarAccess.getDomainConceptRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDomainConcept"


    // $ANTLR start "ruleDomainConcept"
    // InternalSymg.g:87:1: ruleDomainConcept : ( ( rule__DomainConcept__Alternatives ) ) ;
    public final void ruleDomainConcept() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:91:2: ( ( ( rule__DomainConcept__Alternatives ) ) )
            // InternalSymg.g:92:2: ( ( rule__DomainConcept__Alternatives ) )
            {
            // InternalSymg.g:92:2: ( ( rule__DomainConcept__Alternatives ) )
            // InternalSymg.g:93:3: ( rule__DomainConcept__Alternatives )
            {
             before(grammarAccess.getDomainConceptAccess().getAlternatives()); 
            // InternalSymg.g:94:3: ( rule__DomainConcept__Alternatives )
            // InternalSymg.g:94:4: rule__DomainConcept__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DomainConcept__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDomainConceptAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDomainConcept"


    // $ANTLR start "entryRuleRegular"
    // InternalSymg.g:103:1: entryRuleRegular : ruleRegular EOF ;
    public final void entryRuleRegular() throws RecognitionException {
        try {
            // InternalSymg.g:104:1: ( ruleRegular EOF )
            // InternalSymg.g:105:1: ruleRegular EOF
            {
             before(grammarAccess.getRegularRule()); 
            pushFollow(FOLLOW_1);
            ruleRegular();

            state._fsp--;

             after(grammarAccess.getRegularRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegular"


    // $ANTLR start "ruleRegular"
    // InternalSymg.g:112:1: ruleRegular : ( ( rule__Regular__Group__0 ) ) ;
    public final void ruleRegular() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:116:2: ( ( ( rule__Regular__Group__0 ) ) )
            // InternalSymg.g:117:2: ( ( rule__Regular__Group__0 ) )
            {
            // InternalSymg.g:117:2: ( ( rule__Regular__Group__0 ) )
            // InternalSymg.g:118:3: ( rule__Regular__Group__0 )
            {
             before(grammarAccess.getRegularAccess().getGroup()); 
            // InternalSymg.g:119:3: ( rule__Regular__Group__0 )
            // InternalSymg.g:119:4: rule__Regular__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Regular__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRegularAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegular"


    // $ANTLR start "entryRuleAttribute"
    // InternalSymg.g:128:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalSymg.g:129:1: ( ruleAttribute EOF )
            // InternalSymg.g:130:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSymg.g:137:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:141:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalSymg.g:142:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalSymg.g:142:2: ( ( rule__Attribute__Group__0 ) )
            // InternalSymg.g:143:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalSymg.g:144:3: ( rule__Attribute__Group__0 )
            // InternalSymg.g:144:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleEnumeration"
    // InternalSymg.g:153:1: entryRuleEnumeration : ruleEnumeration EOF ;
    public final void entryRuleEnumeration() throws RecognitionException {
        try {
            // InternalSymg.g:154:1: ( ruleEnumeration EOF )
            // InternalSymg.g:155:1: ruleEnumeration EOF
            {
             before(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumeration();

            state._fsp--;

             after(grammarAccess.getEnumerationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalSymg.g:162:1: ruleEnumeration : ( ( rule__Enumeration__Group__0 ) ) ;
    public final void ruleEnumeration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:166:2: ( ( ( rule__Enumeration__Group__0 ) ) )
            // InternalSymg.g:167:2: ( ( rule__Enumeration__Group__0 ) )
            {
            // InternalSymg.g:167:2: ( ( rule__Enumeration__Group__0 ) )
            // InternalSymg.g:168:3: ( rule__Enumeration__Group__0 )
            {
             before(grammarAccess.getEnumerationAccess().getGroup()); 
            // InternalSymg.g:169:3: ( rule__Enumeration__Group__0 )
            // InternalSymg.g:169:4: rule__Enumeration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleenumItem"
    // InternalSymg.g:178:1: entryRuleenumItem : ruleenumItem EOF ;
    public final void entryRuleenumItem() throws RecognitionException {
        try {
            // InternalSymg.g:179:1: ( ruleenumItem EOF )
            // InternalSymg.g:180:1: ruleenumItem EOF
            {
             before(grammarAccess.getEnumItemRule()); 
            pushFollow(FOLLOW_1);
            ruleenumItem();

            state._fsp--;

             after(grammarAccess.getEnumItemRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleenumItem"


    // $ANTLR start "ruleenumItem"
    // InternalSymg.g:187:1: ruleenumItem : ( ( rule__EnumItem__Group__0 ) ) ;
    public final void ruleenumItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:191:2: ( ( ( rule__EnumItem__Group__0 ) ) )
            // InternalSymg.g:192:2: ( ( rule__EnumItem__Group__0 ) )
            {
            // InternalSymg.g:192:2: ( ( rule__EnumItem__Group__0 ) )
            // InternalSymg.g:193:3: ( rule__EnumItem__Group__0 )
            {
             before(grammarAccess.getEnumItemAccess().getGroup()); 
            // InternalSymg.g:194:3: ( rule__EnumItem__Group__0 )
            // InternalSymg.g:194:4: rule__EnumItem__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumItem__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumItemAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleenumItem"


    // $ANTLR start "entryRuleCType"
    // InternalSymg.g:203:1: entryRuleCType : ruleCType EOF ;
    public final void entryRuleCType() throws RecognitionException {
        try {
            // InternalSymg.g:204:1: ( ruleCType EOF )
            // InternalSymg.g:205:1: ruleCType EOF
            {
             before(grammarAccess.getCTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleCType();

            state._fsp--;

             after(grammarAccess.getCTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalSymg.g:212:1: ruleCType : ( ( rule__CType__Alternatives ) ) ;
    public final void ruleCType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:216:2: ( ( ( rule__CType__Alternatives ) ) )
            // InternalSymg.g:217:2: ( ( rule__CType__Alternatives ) )
            {
            // InternalSymg.g:217:2: ( ( rule__CType__Alternatives ) )
            // InternalSymg.g:218:3: ( rule__CType__Alternatives )
            {
             before(grammarAccess.getCTypeAccess().getAlternatives()); 
            // InternalSymg.g:219:3: ( rule__CType__Alternatives )
            // InternalSymg.g:219:4: rule__CType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleDomainType"
    // InternalSymg.g:228:1: entryRuleDomainType : ruleDomainType EOF ;
    public final void entryRuleDomainType() throws RecognitionException {
        try {
            // InternalSymg.g:229:1: ( ruleDomainType EOF )
            // InternalSymg.g:230:1: ruleDomainType EOF
            {
             before(grammarAccess.getDomainTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleDomainType();

            state._fsp--;

             after(grammarAccess.getDomainTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDomainType"


    // $ANTLR start "ruleDomainType"
    // InternalSymg.g:237:1: ruleDomainType : ( ( rule__DomainType__SuperTypeAssignment ) ) ;
    public final void ruleDomainType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:241:2: ( ( ( rule__DomainType__SuperTypeAssignment ) ) )
            // InternalSymg.g:242:2: ( ( rule__DomainType__SuperTypeAssignment ) )
            {
            // InternalSymg.g:242:2: ( ( rule__DomainType__SuperTypeAssignment ) )
            // InternalSymg.g:243:3: ( rule__DomainType__SuperTypeAssignment )
            {
             before(grammarAccess.getDomainTypeAccess().getSuperTypeAssignment()); 
            // InternalSymg.g:244:3: ( rule__DomainType__SuperTypeAssignment )
            // InternalSymg.g:244:4: rule__DomainType__SuperTypeAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DomainType__SuperTypeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDomainTypeAccess().getSuperTypeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDomainType"


    // $ANTLR start "entryRuleBasicType"
    // InternalSymg.g:253:1: entryRuleBasicType : ruleBasicType EOF ;
    public final void entryRuleBasicType() throws RecognitionException {
        try {
            // InternalSymg.g:254:1: ( ruleBasicType EOF )
            // InternalSymg.g:255:1: ruleBasicType EOF
            {
             before(grammarAccess.getBasicTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleBasicType();

            state._fsp--;

             after(grammarAccess.getBasicTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalSymg.g:262:1: ruleBasicType : ( ( rule__BasicType__NameAssignment ) ) ;
    public final void ruleBasicType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:266:2: ( ( ( rule__BasicType__NameAssignment ) ) )
            // InternalSymg.g:267:2: ( ( rule__BasicType__NameAssignment ) )
            {
            // InternalSymg.g:267:2: ( ( rule__BasicType__NameAssignment ) )
            // InternalSymg.g:268:3: ( rule__BasicType__NameAssignment )
            {
             before(grammarAccess.getBasicTypeAccess().getNameAssignment()); 
            // InternalSymg.g:269:3: ( rule__BasicType__NameAssignment )
            // InternalSymg.g:269:4: rule__BasicType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BasicType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBasicTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleOntoCType"
    // InternalSymg.g:278:1: entryRuleOntoCType : ruleOntoCType EOF ;
    public final void entryRuleOntoCType() throws RecognitionException {
        try {
            // InternalSymg.g:279:1: ( ruleOntoCType EOF )
            // InternalSymg.g:280:1: ruleOntoCType EOF
            {
             before(grammarAccess.getOntoCTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleOntoCType();

            state._fsp--;

             after(grammarAccess.getOntoCTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOntoCType"


    // $ANTLR start "ruleOntoCType"
    // InternalSymg.g:287:1: ruleOntoCType : ( ( rule__OntoCType__NameAssignment ) ) ;
    public final void ruleOntoCType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:291:2: ( ( ( rule__OntoCType__NameAssignment ) ) )
            // InternalSymg.g:292:2: ( ( rule__OntoCType__NameAssignment ) )
            {
            // InternalSymg.g:292:2: ( ( rule__OntoCType__NameAssignment ) )
            // InternalSymg.g:293:3: ( rule__OntoCType__NameAssignment )
            {
             before(grammarAccess.getOntoCTypeAccess().getNameAssignment()); 
            // InternalSymg.g:294:3: ( rule__OntoCType__NameAssignment )
            // InternalSymg.g:294:4: rule__OntoCType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__OntoCType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOntoCTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOntoCType"


    // $ANTLR start "entryRuleParameter"
    // InternalSymg.g:303:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalSymg.g:304:1: ( ruleParameter EOF )
            // InternalSymg.g:305:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSymg.g:312:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:316:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalSymg.g:317:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalSymg.g:317:2: ( ( rule__Parameter__Group__0 ) )
            // InternalSymg.g:318:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalSymg.g:319:3: ( rule__Parameter__Group__0 )
            // InternalSymg.g:319:4: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeName"
    // InternalSymg.g:328:1: entryRuleTypeName : ruleTypeName EOF ;
    public final void entryRuleTypeName() throws RecognitionException {
        try {
            // InternalSymg.g:329:1: ( ruleTypeName EOF )
            // InternalSymg.g:330:1: ruleTypeName EOF
            {
             before(grammarAccess.getTypeNameRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeName();

            state._fsp--;

             after(grammarAccess.getTypeNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeName"


    // $ANTLR start "ruleTypeName"
    // InternalSymg.g:337:1: ruleTypeName : ( ( rule__TypeName__Alternatives ) ) ;
    public final void ruleTypeName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:341:2: ( ( ( rule__TypeName__Alternatives ) ) )
            // InternalSymg.g:342:2: ( ( rule__TypeName__Alternatives ) )
            {
            // InternalSymg.g:342:2: ( ( rule__TypeName__Alternatives ) )
            // InternalSymg.g:343:3: ( rule__TypeName__Alternatives )
            {
             before(grammarAccess.getTypeNameAccess().getAlternatives()); 
            // InternalSymg.g:344:3: ( rule__TypeName__Alternatives )
            // InternalSymg.g:344:4: rule__TypeName__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeName__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeName"


    // $ANTLR start "entryRuleDeclarPair"
    // InternalSymg.g:353:1: entryRuleDeclarPair : ruleDeclarPair EOF ;
    public final void entryRuleDeclarPair() throws RecognitionException {
        try {
            // InternalSymg.g:354:1: ( ruleDeclarPair EOF )
            // InternalSymg.g:355:1: ruleDeclarPair EOF
            {
             before(grammarAccess.getDeclarPairRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclarPair();

            state._fsp--;

             after(grammarAccess.getDeclarPairRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclarPair"


    // $ANTLR start "ruleDeclarPair"
    // InternalSymg.g:362:1: ruleDeclarPair : ( ( rule__DeclarPair__Group__0 ) ) ;
    public final void ruleDeclarPair() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:366:2: ( ( ( rule__DeclarPair__Group__0 ) ) )
            // InternalSymg.g:367:2: ( ( rule__DeclarPair__Group__0 ) )
            {
            // InternalSymg.g:367:2: ( ( rule__DeclarPair__Group__0 ) )
            // InternalSymg.g:368:3: ( rule__DeclarPair__Group__0 )
            {
             before(grammarAccess.getDeclarPairAccess().getGroup()); 
            // InternalSymg.g:369:3: ( rule__DeclarPair__Group__0 )
            // InternalSymg.g:369:4: rule__DeclarPair__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DeclarPair__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarPairAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclarPair"


    // $ANTLR start "entryRuleDeclar"
    // InternalSymg.g:378:1: entryRuleDeclar : ruleDeclar EOF ;
    public final void entryRuleDeclar() throws RecognitionException {
        try {
            // InternalSymg.g:379:1: ( ruleDeclar EOF )
            // InternalSymg.g:380:1: ruleDeclar EOF
            {
             before(grammarAccess.getDeclarRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclar();

            state._fsp--;

             after(grammarAccess.getDeclarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclar"


    // $ANTLR start "ruleDeclar"
    // InternalSymg.g:387:1: ruleDeclar : ( ( rule__Declar__Group__0 ) ) ;
    public final void ruleDeclar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:391:2: ( ( ( rule__Declar__Group__0 ) ) )
            // InternalSymg.g:392:2: ( ( rule__Declar__Group__0 ) )
            {
            // InternalSymg.g:392:2: ( ( rule__Declar__Group__0 ) )
            // InternalSymg.g:393:3: ( rule__Declar__Group__0 )
            {
             before(grammarAccess.getDeclarAccess().getGroup()); 
            // InternalSymg.g:394:3: ( rule__Declar__Group__0 )
            // InternalSymg.g:394:4: rule__Declar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Declar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclar"


    // $ANTLR start "entryRuleObligation"
    // InternalSymg.g:403:1: entryRuleObligation : ruleObligation EOF ;
    public final void entryRuleObligation() throws RecognitionException {
        try {
            // InternalSymg.g:404:1: ( ruleObligation EOF )
            // InternalSymg.g:405:1: ruleObligation EOF
            {
             before(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            ruleObligation();

            state._fsp--;

             after(grammarAccess.getObligationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalSymg.g:412:1: ruleObligation : ( ( rule__Obligation__Group__0 ) ) ;
    public final void ruleObligation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:416:2: ( ( ( rule__Obligation__Group__0 ) ) )
            // InternalSymg.g:417:2: ( ( rule__Obligation__Group__0 ) )
            {
            // InternalSymg.g:417:2: ( ( rule__Obligation__Group__0 ) )
            // InternalSymg.g:418:3: ( rule__Obligation__Group__0 )
            {
             before(grammarAccess.getObligationAccess().getGroup()); 
            // InternalSymg.g:419:3: ( rule__Obligation__Group__0 )
            // InternalSymg.g:419:4: rule__Obligation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalSymg.g:428:1: entryRulePower : rulePower EOF ;
    public final void entryRulePower() throws RecognitionException {
        try {
            // InternalSymg.g:429:1: ( rulePower EOF )
            // InternalSymg.g:430:1: rulePower EOF
            {
             before(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            rulePower();

            state._fsp--;

             after(grammarAccess.getPowerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalSymg.g:437:1: rulePower : ( ( rule__Power__Group__0 ) ) ;
    public final void rulePower() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:441:2: ( ( ( rule__Power__Group__0 ) ) )
            // InternalSymg.g:442:2: ( ( rule__Power__Group__0 ) )
            {
            // InternalSymg.g:442:2: ( ( rule__Power__Group__0 ) )
            // InternalSymg.g:443:3: ( rule__Power__Group__0 )
            {
             before(grammarAccess.getPowerAccess().getGroup()); 
            // InternalSymg.g:444:3: ( rule__Power__Group__0 )
            // InternalSymg.g:444:4: rule__Power__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Power__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRuleProposition"
    // InternalSymg.g:453:1: entryRuleProposition : ruleProposition EOF ;
    public final void entryRuleProposition() throws RecognitionException {
        try {
            // InternalSymg.g:454:1: ( ruleProposition EOF )
            // InternalSymg.g:455:1: ruleProposition EOF
            {
             before(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPropositionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalSymg.g:462:1: ruleProposition : ( ( rule__Proposition__Group__0 ) ) ;
    public final void ruleProposition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:466:2: ( ( ( rule__Proposition__Group__0 ) ) )
            // InternalSymg.g:467:2: ( ( rule__Proposition__Group__0 ) )
            {
            // InternalSymg.g:467:2: ( ( rule__Proposition__Group__0 ) )
            // InternalSymg.g:468:3: ( rule__Proposition__Group__0 )
            {
             before(grammarAccess.getPropositionAccess().getGroup()); 
            // InternalSymg.g:469:3: ( rule__Proposition__Group__0 )
            // InternalSymg.g:469:4: rule__Proposition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRuleJunction"
    // InternalSymg.g:478:1: entryRuleJunction : ruleJunction EOF ;
    public final void entryRuleJunction() throws RecognitionException {
        try {
            // InternalSymg.g:479:1: ( ruleJunction EOF )
            // InternalSymg.g:480:1: ruleJunction EOF
            {
             before(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleJunction();

            state._fsp--;

             after(grammarAccess.getJunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalSymg.g:487:1: ruleJunction : ( ( rule__Junction__Group__0 ) ) ;
    public final void ruleJunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:491:2: ( ( ( rule__Junction__Group__0 ) ) )
            // InternalSymg.g:492:2: ( ( rule__Junction__Group__0 ) )
            {
            // InternalSymg.g:492:2: ( ( rule__Junction__Group__0 ) )
            // InternalSymg.g:493:3: ( rule__Junction__Group__0 )
            {
             before(grammarAccess.getJunctionAccess().getGroup()); 
            // InternalSymg.g:494:3: ( rule__Junction__Group__0 )
            // InternalSymg.g:494:4: rule__Junction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Junction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleNegation"
    // InternalSymg.g:503:1: entryRuleNegation : ruleNegation EOF ;
    public final void entryRuleNegation() throws RecognitionException {
        try {
            // InternalSymg.g:504:1: ( ruleNegation EOF )
            // InternalSymg.g:505:1: ruleNegation EOF
            {
             before(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_1);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNegationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalSymg.g:512:1: ruleNegation : ( ( rule__Negation__Group__0 ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:516:2: ( ( ( rule__Negation__Group__0 ) ) )
            // InternalSymg.g:517:2: ( ( rule__Negation__Group__0 ) )
            {
            // InternalSymg.g:517:2: ( ( rule__Negation__Group__0 ) )
            // InternalSymg.g:518:3: ( rule__Negation__Group__0 )
            {
             before(grammarAccess.getNegationAccess().getGroup()); 
            // InternalSymg.g:519:3: ( rule__Negation__Group__0 )
            // InternalSymg.g:519:4: rule__Negation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Negation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalSymg.g:528:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalSymg.g:529:1: ( ruleAtom EOF )
            // InternalSymg.g:530:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getAtomRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalSymg.g:537:1: ruleAtom : ( ( rule__Atom__Alternatives ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:541:2: ( ( ( rule__Atom__Alternatives ) ) )
            // InternalSymg.g:542:2: ( ( rule__Atom__Alternatives ) )
            {
            // InternalSymg.g:542:2: ( ( rule__Atom__Alternatives ) )
            // InternalSymg.g:543:3: ( rule__Atom__Alternatives )
            {
             before(grammarAccess.getAtomAccess().getAlternatives()); 
            // InternalSymg.g:544:3: ( rule__Atom__Alternatives )
            // InternalSymg.g:544:4: rule__Atom__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleSitProp"
    // InternalSymg.g:553:1: entryRuleSitProp : ruleSitProp EOF ;
    public final void entryRuleSitProp() throws RecognitionException {
        try {
            // InternalSymg.g:554:1: ( ruleSitProp EOF )
            // InternalSymg.g:555:1: ruleSitProp EOF
            {
             before(grammarAccess.getSitPropRule()); 
            pushFollow(FOLLOW_1);
            ruleSitProp();

            state._fsp--;

             after(grammarAccess.getSitPropRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSitProp"


    // $ANTLR start "ruleSitProp"
    // InternalSymg.g:562:1: ruleSitProp : ( ( rule__SitProp__Group__0 ) ) ;
    public final void ruleSitProp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:566:2: ( ( ( rule__SitProp__Group__0 ) ) )
            // InternalSymg.g:567:2: ( ( rule__SitProp__Group__0 ) )
            {
            // InternalSymg.g:567:2: ( ( rule__SitProp__Group__0 ) )
            // InternalSymg.g:568:3: ( rule__SitProp__Group__0 )
            {
             before(grammarAccess.getSitPropAccess().getGroup()); 
            // InternalSymg.g:569:3: ( rule__SitProp__Group__0 )
            // InternalSymg.g:569:4: rule__SitProp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SitProp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSitPropAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSitProp"


    // $ANTLR start "entryRuleEventProp"
    // InternalSymg.g:578:1: entryRuleEventProp : ruleEventProp EOF ;
    public final void entryRuleEventProp() throws RecognitionException {
        try {
            // InternalSymg.g:579:1: ( ruleEventProp EOF )
            // InternalSymg.g:580:1: ruleEventProp EOF
            {
             before(grammarAccess.getEventPropRule()); 
            pushFollow(FOLLOW_1);
            ruleEventProp();

            state._fsp--;

             after(grammarAccess.getEventPropRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventProp"


    // $ANTLR start "ruleEventProp"
    // InternalSymg.g:587:1: ruleEventProp : ( ( rule__EventProp__Group__0 ) ) ;
    public final void ruleEventProp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:591:2: ( ( ( rule__EventProp__Group__0 ) ) )
            // InternalSymg.g:592:2: ( ( rule__EventProp__Group__0 ) )
            {
            // InternalSymg.g:592:2: ( ( rule__EventProp__Group__0 ) )
            // InternalSymg.g:593:3: ( rule__EventProp__Group__0 )
            {
             before(grammarAccess.getEventPropAccess().getGroup()); 
            // InternalSymg.g:594:3: ( rule__EventProp__Group__0 )
            // InternalSymg.g:594:4: rule__EventProp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EventProp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventPropAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventProp"


    // $ANTLR start "entryRuleInterval"
    // InternalSymg.g:603:1: entryRuleInterval : ruleInterval EOF ;
    public final void entryRuleInterval() throws RecognitionException {
        try {
            // InternalSymg.g:604:1: ( ruleInterval EOF )
            // InternalSymg.g:605:1: ruleInterval EOF
            {
             before(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            ruleInterval();

            state._fsp--;

             after(grammarAccess.getIntervalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalSymg.g:612:1: ruleInterval : ( ( rule__Interval__Alternatives ) ) ;
    public final void ruleInterval() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:616:2: ( ( ( rule__Interval__Alternatives ) ) )
            // InternalSymg.g:617:2: ( ( rule__Interval__Alternatives ) )
            {
            // InternalSymg.g:617:2: ( ( rule__Interval__Alternatives ) )
            // InternalSymg.g:618:3: ( rule__Interval__Alternatives )
            {
             before(grammarAccess.getIntervalAccess().getAlternatives()); 
            // InternalSymg.g:619:3: ( rule__Interval__Alternatives )
            // InternalSymg.g:619:4: rule__Interval__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Interval__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleRelativeSituationPointBefore"
    // InternalSymg.g:628:1: entryRuleRelativeSituationPointBefore : ruleRelativeSituationPointBefore EOF ;
    public final void entryRuleRelativeSituationPointBefore() throws RecognitionException {
        try {
            // InternalSymg.g:629:1: ( ruleRelativeSituationPointBefore EOF )
            // InternalSymg.g:630:1: ruleRelativeSituationPointBefore EOF
            {
             before(grammarAccess.getRelativeSituationPointBeforeRule()); 
            pushFollow(FOLLOW_1);
            ruleRelativeSituationPointBefore();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointBeforeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelativeSituationPointBefore"


    // $ANTLR start "ruleRelativeSituationPointBefore"
    // InternalSymg.g:637:1: ruleRelativeSituationPointBefore : ( ( rule__RelativeSituationPointBefore__Group__0 ) ) ;
    public final void ruleRelativeSituationPointBefore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:641:2: ( ( ( rule__RelativeSituationPointBefore__Group__0 ) ) )
            // InternalSymg.g:642:2: ( ( rule__RelativeSituationPointBefore__Group__0 ) )
            {
            // InternalSymg.g:642:2: ( ( rule__RelativeSituationPointBefore__Group__0 ) )
            // InternalSymg.g:643:3: ( rule__RelativeSituationPointBefore__Group__0 )
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getGroup()); 
            // InternalSymg.g:644:3: ( rule__RelativeSituationPointBefore__Group__0 )
            // InternalSymg.g:644:4: rule__RelativeSituationPointBefore__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelativeSituationPointBefore"


    // $ANTLR start "entryRuleRelativeSituationPointAfter"
    // InternalSymg.g:653:1: entryRuleRelativeSituationPointAfter : ruleRelativeSituationPointAfter EOF ;
    public final void entryRuleRelativeSituationPointAfter() throws RecognitionException {
        try {
            // InternalSymg.g:654:1: ( ruleRelativeSituationPointAfter EOF )
            // InternalSymg.g:655:1: ruleRelativeSituationPointAfter EOF
            {
             before(grammarAccess.getRelativeSituationPointAfterRule()); 
            pushFollow(FOLLOW_1);
            ruleRelativeSituationPointAfter();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointAfterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelativeSituationPointAfter"


    // $ANTLR start "ruleRelativeSituationPointAfter"
    // InternalSymg.g:662:1: ruleRelativeSituationPointAfter : ( ( rule__RelativeSituationPointAfter__Group__0 ) ) ;
    public final void ruleRelativeSituationPointAfter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:666:2: ( ( ( rule__RelativeSituationPointAfter__Group__0 ) ) )
            // InternalSymg.g:667:2: ( ( rule__RelativeSituationPointAfter__Group__0 ) )
            {
            // InternalSymg.g:667:2: ( ( rule__RelativeSituationPointAfter__Group__0 ) )
            // InternalSymg.g:668:3: ( rule__RelativeSituationPointAfter__Group__0 )
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getGroup()); 
            // InternalSymg.g:669:3: ( rule__RelativeSituationPointAfter__Group__0 )
            // InternalSymg.g:669:4: rule__RelativeSituationPointAfter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointAfterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelativeSituationPointAfter"


    // $ANTLR start "entryRuleSitName"
    // InternalSymg.g:678:1: entryRuleSitName : ruleSitName EOF ;
    public final void entryRuleSitName() throws RecognitionException {
        try {
            // InternalSymg.g:679:1: ( ruleSitName EOF )
            // InternalSymg.g:680:1: ruleSitName EOF
            {
             before(grammarAccess.getSitNameRule()); 
            pushFollow(FOLLOW_1);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getSitNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSitName"


    // $ANTLR start "ruleSitName"
    // InternalSymg.g:687:1: ruleSitName : ( ( rule__SitName__Alternatives ) ) ;
    public final void ruleSitName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:691:2: ( ( ( rule__SitName__Alternatives ) ) )
            // InternalSymg.g:692:2: ( ( rule__SitName__Alternatives ) )
            {
            // InternalSymg.g:692:2: ( ( rule__SitName__Alternatives ) )
            // InternalSymg.g:693:3: ( rule__SitName__Alternatives )
            {
             before(grammarAccess.getSitNameAccess().getAlternatives()); 
            // InternalSymg.g:694:3: ( rule__SitName__Alternatives )
            // InternalSymg.g:694:4: rule__SitName__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SitName__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSitNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSitName"


    // $ANTLR start "entryRuleUnit"
    // InternalSymg.g:703:1: entryRuleUnit : ruleUnit EOF ;
    public final void entryRuleUnit() throws RecognitionException {
        try {
            // InternalSymg.g:704:1: ( ruleUnit EOF )
            // InternalSymg.g:705:1: ruleUnit EOF
            {
             before(grammarAccess.getUnitRule()); 
            pushFollow(FOLLOW_1);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getUnitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalSymg.g:712:1: ruleUnit : ( ( rule__Unit__Alternatives ) ) ;
    public final void ruleUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:716:2: ( ( ( rule__Unit__Alternatives ) ) )
            // InternalSymg.g:717:2: ( ( rule__Unit__Alternatives ) )
            {
            // InternalSymg.g:717:2: ( ( rule__Unit__Alternatives ) )
            // InternalSymg.g:718:3: ( rule__Unit__Alternatives )
            {
             before(grammarAccess.getUnitAccess().getAlternatives()); 
            // InternalSymg.g:719:3: ( rule__Unit__Alternatives )
            // InternalSymg.g:719:4: rule__Unit__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Unit__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnitAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleIntConst"
    // InternalSymg.g:728:1: entryRuleIntConst : ruleIntConst EOF ;
    public final void entryRuleIntConst() throws RecognitionException {
        try {
            // InternalSymg.g:729:1: ( ruleIntConst EOF )
            // InternalSymg.g:730:1: ruleIntConst EOF
            {
             before(grammarAccess.getIntConstRule()); 
            pushFollow(FOLLOW_1);
            ruleIntConst();

            state._fsp--;

             after(grammarAccess.getIntConstRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntConst"


    // $ANTLR start "ruleIntConst"
    // InternalSymg.g:737:1: ruleIntConst : ( ( rule__IntConst__Group__0 ) ) ;
    public final void ruleIntConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:741:2: ( ( ( rule__IntConst__Group__0 ) ) )
            // InternalSymg.g:742:2: ( ( rule__IntConst__Group__0 ) )
            {
            // InternalSymg.g:742:2: ( ( rule__IntConst__Group__0 ) )
            // InternalSymg.g:743:3: ( rule__IntConst__Group__0 )
            {
             before(grammarAccess.getIntConstAccess().getGroup()); 
            // InternalSymg.g:744:3: ( rule__IntConst__Group__0 )
            // InternalSymg.g:744:4: rule__IntConst__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntConst"


    // $ANTLR start "entryRuleTempOp"
    // InternalSymg.g:753:1: entryRuleTempOp : ruleTempOp EOF ;
    public final void entryRuleTempOp() throws RecognitionException {
        try {
            // InternalSymg.g:754:1: ( ruleTempOp EOF )
            // InternalSymg.g:755:1: ruleTempOp EOF
            {
             before(grammarAccess.getTempOpRule()); 
            pushFollow(FOLLOW_1);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getTempOpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTempOp"


    // $ANTLR start "ruleTempOp"
    // InternalSymg.g:762:1: ruleTempOp : ( ( rule__TempOp__Alternatives ) ) ;
    public final void ruleTempOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:766:2: ( ( ( rule__TempOp__Alternatives ) ) )
            // InternalSymg.g:767:2: ( ( rule__TempOp__Alternatives ) )
            {
            // InternalSymg.g:767:2: ( ( rule__TempOp__Alternatives ) )
            // InternalSymg.g:768:3: ( rule__TempOp__Alternatives )
            {
             before(grammarAccess.getTempOpAccess().getAlternatives()); 
            // InternalSymg.g:769:3: ( rule__TempOp__Alternatives )
            // InternalSymg.g:769:4: rule__TempOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TempOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTempOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTempOp"


    // $ANTLR start "entryRulePoint"
    // InternalSymg.g:778:1: entryRulePoint : rulePoint EOF ;
    public final void entryRulePoint() throws RecognitionException {
        try {
            // InternalSymg.g:779:1: ( rulePoint EOF )
            // InternalSymg.g:780:1: rulePoint EOF
            {
             before(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getPointRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalSymg.g:787:1: rulePoint : ( ( rule__Point__Alternatives ) ) ;
    public final void rulePoint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:791:2: ( ( ( rule__Point__Alternatives ) ) )
            // InternalSymg.g:792:2: ( ( rule__Point__Alternatives ) )
            {
            // InternalSymg.g:792:2: ( ( rule__Point__Alternatives ) )
            // InternalSymg.g:793:3: ( rule__Point__Alternatives )
            {
             before(grammarAccess.getPointAccess().getAlternatives()); 
            // InternalSymg.g:794:3: ( rule__Point__Alternatives )
            // InternalSymg.g:794:4: rule__Point__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Point__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPointAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRuleRelativeEventPointBefore"
    // InternalSymg.g:803:1: entryRuleRelativeEventPointBefore : ruleRelativeEventPointBefore EOF ;
    public final void entryRuleRelativeEventPointBefore() throws RecognitionException {
        try {
            // InternalSymg.g:804:1: ( ruleRelativeEventPointBefore EOF )
            // InternalSymg.g:805:1: ruleRelativeEventPointBefore EOF
            {
             before(grammarAccess.getRelativeEventPointBeforeRule()); 
            pushFollow(FOLLOW_1);
            ruleRelativeEventPointBefore();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointBeforeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelativeEventPointBefore"


    // $ANTLR start "ruleRelativeEventPointBefore"
    // InternalSymg.g:812:1: ruleRelativeEventPointBefore : ( ( rule__RelativeEventPointBefore__Group__0 ) ) ;
    public final void ruleRelativeEventPointBefore() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:816:2: ( ( ( rule__RelativeEventPointBefore__Group__0 ) ) )
            // InternalSymg.g:817:2: ( ( rule__RelativeEventPointBefore__Group__0 ) )
            {
            // InternalSymg.g:817:2: ( ( rule__RelativeEventPointBefore__Group__0 ) )
            // InternalSymg.g:818:3: ( rule__RelativeEventPointBefore__Group__0 )
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getGroup()); 
            // InternalSymg.g:819:3: ( rule__RelativeEventPointBefore__Group__0 )
            // InternalSymg.g:819:4: rule__RelativeEventPointBefore__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointBeforeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelativeEventPointBefore"


    // $ANTLR start "entryRuleRelativeEventPointAfter"
    // InternalSymg.g:828:1: entryRuleRelativeEventPointAfter : ruleRelativeEventPointAfter EOF ;
    public final void entryRuleRelativeEventPointAfter() throws RecognitionException {
        try {
            // InternalSymg.g:829:1: ( ruleRelativeEventPointAfter EOF )
            // InternalSymg.g:830:1: ruleRelativeEventPointAfter EOF
            {
             before(grammarAccess.getRelativeEventPointAfterRule()); 
            pushFollow(FOLLOW_1);
            ruleRelativeEventPointAfter();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointAfterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelativeEventPointAfter"


    // $ANTLR start "ruleRelativeEventPointAfter"
    // InternalSymg.g:837:1: ruleRelativeEventPointAfter : ( ( rule__RelativeEventPointAfter__Group__0 ) ) ;
    public final void ruleRelativeEventPointAfter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:841:2: ( ( ( rule__RelativeEventPointAfter__Group__0 ) ) )
            // InternalSymg.g:842:2: ( ( rule__RelativeEventPointAfter__Group__0 ) )
            {
            // InternalSymg.g:842:2: ( ( rule__RelativeEventPointAfter__Group__0 ) )
            // InternalSymg.g:843:3: ( rule__RelativeEventPointAfter__Group__0 )
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getGroup()); 
            // InternalSymg.g:844:3: ( rule__RelativeEventPointAfter__Group__0 )
            // InternalSymg.g:844:4: rule__RelativeEventPointAfter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointAfterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelativeEventPointAfter"


    // $ANTLR start "entryRulepEvent"
    // InternalSymg.g:853:1: entryRulepEvent : rulepEvent EOF ;
    public final void entryRulepEvent() throws RecognitionException {
        try {
            // InternalSymg.g:854:1: ( rulepEvent EOF )
            // InternalSymg.g:855:1: rulepEvent EOF
            {
             before(grammarAccess.getPEventRule()); 
            pushFollow(FOLLOW_1);
            rulepEvent();

            state._fsp--;

             after(grammarAccess.getPEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulepEvent"


    // $ANTLR start "rulepEvent"
    // InternalSymg.g:862:1: rulepEvent : ( ( rule__PEvent__Group__0 ) ) ;
    public final void rulepEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:866:2: ( ( ( rule__PEvent__Group__0 ) ) )
            // InternalSymg.g:867:2: ( ( rule__PEvent__Group__0 ) )
            {
            // InternalSymg.g:867:2: ( ( rule__PEvent__Group__0 ) )
            // InternalSymg.g:868:3: ( rule__PEvent__Group__0 )
            {
             before(grammarAccess.getPEventAccess().getGroup()); 
            // InternalSymg.g:869:3: ( rule__PEvent__Group__0 )
            // InternalSymg.g:869:4: rule__PEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulepEvent"


    // $ANTLR start "entryRulePowEvent"
    // InternalSymg.g:878:1: entryRulePowEvent : rulePowEvent EOF ;
    public final void entryRulePowEvent() throws RecognitionException {
        try {
            // InternalSymg.g:879:1: ( rulePowEvent EOF )
            // InternalSymg.g:880:1: rulePowEvent EOF
            {
             before(grammarAccess.getPowEventRule()); 
            pushFollow(FOLLOW_1);
            rulePowEvent();

            state._fsp--;

             after(grammarAccess.getPowEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePowEvent"


    // $ANTLR start "rulePowEvent"
    // InternalSymg.g:887:1: rulePowEvent : ( ( rule__PowEvent__Alternatives ) ) ;
    public final void rulePowEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:891:2: ( ( ( rule__PowEvent__Alternatives ) ) )
            // InternalSymg.g:892:2: ( ( rule__PowEvent__Alternatives ) )
            {
            // InternalSymg.g:892:2: ( ( rule__PowEvent__Alternatives ) )
            // InternalSymg.g:893:3: ( rule__PowEvent__Alternatives )
            {
             before(grammarAccess.getPowEventAccess().getAlternatives()); 
            // InternalSymg.g:894:3: ( rule__PowEvent__Alternatives )
            // InternalSymg.g:894:4: rule__PowEvent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PowEvent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPowEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePowEvent"


    // $ANTLR start "entryRulecEvent"
    // InternalSymg.g:903:1: entryRulecEvent : rulecEvent EOF ;
    public final void entryRulecEvent() throws RecognitionException {
        try {
            // InternalSymg.g:904:1: ( rulecEvent EOF )
            // InternalSymg.g:905:1: rulecEvent EOF
            {
             before(grammarAccess.getCEventRule()); 
            pushFollow(FOLLOW_1);
            rulecEvent();

            state._fsp--;

             after(grammarAccess.getCEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulecEvent"


    // $ANTLR start "rulecEvent"
    // InternalSymg.g:912:1: rulecEvent : ( ( rule__CEvent__Group__0 ) ) ;
    public final void rulecEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:916:2: ( ( ( rule__CEvent__Group__0 ) ) )
            // InternalSymg.g:917:2: ( ( rule__CEvent__Group__0 ) )
            {
            // InternalSymg.g:917:2: ( ( rule__CEvent__Group__0 ) )
            // InternalSymg.g:918:3: ( rule__CEvent__Group__0 )
            {
             before(grammarAccess.getCEventAccess().getGroup()); 
            // InternalSymg.g:919:3: ( rule__CEvent__Group__0 )
            // InternalSymg.g:919:4: rule__CEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecEvent"


    // $ANTLR start "entryRuleContrEvent"
    // InternalSymg.g:928:1: entryRuleContrEvent : ruleContrEvent EOF ;
    public final void entryRuleContrEvent() throws RecognitionException {
        try {
            // InternalSymg.g:929:1: ( ruleContrEvent EOF )
            // InternalSymg.g:930:1: ruleContrEvent EOF
            {
             before(grammarAccess.getContrEventRule()); 
            pushFollow(FOLLOW_1);
            ruleContrEvent();

            state._fsp--;

             after(grammarAccess.getContrEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContrEvent"


    // $ANTLR start "ruleContrEvent"
    // InternalSymg.g:937:1: ruleContrEvent : ( ( rule__ContrEvent__Alternatives ) ) ;
    public final void ruleContrEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:941:2: ( ( ( rule__ContrEvent__Alternatives ) ) )
            // InternalSymg.g:942:2: ( ( rule__ContrEvent__Alternatives ) )
            {
            // InternalSymg.g:942:2: ( ( rule__ContrEvent__Alternatives ) )
            // InternalSymg.g:943:3: ( rule__ContrEvent__Alternatives )
            {
             before(grammarAccess.getContrEventAccess().getAlternatives()); 
            // InternalSymg.g:944:3: ( rule__ContrEvent__Alternatives )
            // InternalSymg.g:944:4: rule__ContrEvent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ContrEvent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContrEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContrEvent"


    // $ANTLR start "entryRuleoEvent"
    // InternalSymg.g:953:1: entryRuleoEvent : ruleoEvent EOF ;
    public final void entryRuleoEvent() throws RecognitionException {
        try {
            // InternalSymg.g:954:1: ( ruleoEvent EOF )
            // InternalSymg.g:955:1: ruleoEvent EOF
            {
             before(grammarAccess.getOEventRule()); 
            pushFollow(FOLLOW_1);
            ruleoEvent();

            state._fsp--;

             after(grammarAccess.getOEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleoEvent"


    // $ANTLR start "ruleoEvent"
    // InternalSymg.g:962:1: ruleoEvent : ( ( rule__OEvent__Group__0 ) ) ;
    public final void ruleoEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:966:2: ( ( ( rule__OEvent__Group__0 ) ) )
            // InternalSymg.g:967:2: ( ( rule__OEvent__Group__0 ) )
            {
            // InternalSymg.g:967:2: ( ( rule__OEvent__Group__0 ) )
            // InternalSymg.g:968:3: ( rule__OEvent__Group__0 )
            {
             before(grammarAccess.getOEventAccess().getGroup()); 
            // InternalSymg.g:969:3: ( rule__OEvent__Group__0 )
            // InternalSymg.g:969:4: rule__OEvent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleoEvent"


    // $ANTLR start "entryRuleOblEvent"
    // InternalSymg.g:978:1: entryRuleOblEvent : ruleOblEvent EOF ;
    public final void entryRuleOblEvent() throws RecognitionException {
        try {
            // InternalSymg.g:979:1: ( ruleOblEvent EOF )
            // InternalSymg.g:980:1: ruleOblEvent EOF
            {
             before(grammarAccess.getOblEventRule()); 
            pushFollow(FOLLOW_1);
            ruleOblEvent();

            state._fsp--;

             after(grammarAccess.getOblEventRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOblEvent"


    // $ANTLR start "ruleOblEvent"
    // InternalSymg.g:987:1: ruleOblEvent : ( ( rule__OblEvent__Alternatives ) ) ;
    public final void ruleOblEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:991:2: ( ( ( rule__OblEvent__Alternatives ) ) )
            // InternalSymg.g:992:2: ( ( rule__OblEvent__Alternatives ) )
            {
            // InternalSymg.g:992:2: ( ( rule__OblEvent__Alternatives ) )
            // InternalSymg.g:993:3: ( rule__OblEvent__Alternatives )
            {
             before(grammarAccess.getOblEventAccess().getAlternatives()); 
            // InternalSymg.g:994:3: ( rule__OblEvent__Alternatives )
            // InternalSymg.g:994:4: rule__OblEvent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OblEvent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOblEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOblEvent"


    // $ANTLR start "entryRulePointConst"
    // InternalSymg.g:1003:1: entryRulePointConst : rulePointConst EOF ;
    public final void entryRulePointConst() throws RecognitionException {
        try {
            // InternalSymg.g:1004:1: ( rulePointConst EOF )
            // InternalSymg.g:1005:1: rulePointConst EOF
            {
             before(grammarAccess.getPointConstRule()); 
            pushFollow(FOLLOW_1);
            rulePointConst();

            state._fsp--;

             after(grammarAccess.getPointConstRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePointConst"


    // $ANTLR start "rulePointConst"
    // InternalSymg.g:1012:1: rulePointConst : ( ( rule__PointConst__Group__0 ) ) ;
    public final void rulePointConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1016:2: ( ( ( rule__PointConst__Group__0 ) ) )
            // InternalSymg.g:1017:2: ( ( rule__PointConst__Group__0 ) )
            {
            // InternalSymg.g:1017:2: ( ( rule__PointConst__Group__0 ) )
            // InternalSymg.g:1018:3: ( rule__PointConst__Group__0 )
            {
             before(grammarAccess.getPointConstAccess().getGroup()); 
            // InternalSymg.g:1019:3: ( rule__PointConst__Group__0 )
            // InternalSymg.g:1019:4: rule__PointConst__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PointConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPointConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePointConst"


    // $ANTLR start "entryRuleoState"
    // InternalSymg.g:1028:1: entryRuleoState : ruleoState EOF ;
    public final void entryRuleoState() throws RecognitionException {
        try {
            // InternalSymg.g:1029:1: ( ruleoState EOF )
            // InternalSymg.g:1030:1: ruleoState EOF
            {
             before(grammarAccess.getOStateRule()); 
            pushFollow(FOLLOW_1);
            ruleoState();

            state._fsp--;

             after(grammarAccess.getOStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleoState"


    // $ANTLR start "ruleoState"
    // InternalSymg.g:1037:1: ruleoState : ( ( rule__OState__Group__0 ) ) ;
    public final void ruleoState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1041:2: ( ( ( rule__OState__Group__0 ) ) )
            // InternalSymg.g:1042:2: ( ( rule__OState__Group__0 ) )
            {
            // InternalSymg.g:1042:2: ( ( rule__OState__Group__0 ) )
            // InternalSymg.g:1043:3: ( rule__OState__Group__0 )
            {
             before(grammarAccess.getOStateAccess().getGroup()); 
            // InternalSymg.g:1044:3: ( rule__OState__Group__0 )
            // InternalSymg.g:1044:4: rule__OState__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OState__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleoState"


    // $ANTLR start "entryRuleOblState"
    // InternalSymg.g:1053:1: entryRuleOblState : ruleOblState EOF ;
    public final void entryRuleOblState() throws RecognitionException {
        try {
            // InternalSymg.g:1054:1: ( ruleOblState EOF )
            // InternalSymg.g:1055:1: ruleOblState EOF
            {
             before(grammarAccess.getOblStateRule()); 
            pushFollow(FOLLOW_1);
            ruleOblState();

            state._fsp--;

             after(grammarAccess.getOblStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOblState"


    // $ANTLR start "ruleOblState"
    // InternalSymg.g:1062:1: ruleOblState : ( ( rule__OblState__Alternatives ) ) ;
    public final void ruleOblState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1066:2: ( ( ( rule__OblState__Alternatives ) ) )
            // InternalSymg.g:1067:2: ( ( rule__OblState__Alternatives ) )
            {
            // InternalSymg.g:1067:2: ( ( rule__OblState__Alternatives ) )
            // InternalSymg.g:1068:3: ( rule__OblState__Alternatives )
            {
             before(grammarAccess.getOblStateAccess().getAlternatives()); 
            // InternalSymg.g:1069:3: ( rule__OblState__Alternatives )
            // InternalSymg.g:1069:4: rule__OblState__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OblState__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOblStateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOblState"


    // $ANTLR start "entryRulecState"
    // InternalSymg.g:1078:1: entryRulecState : rulecState EOF ;
    public final void entryRulecState() throws RecognitionException {
        try {
            // InternalSymg.g:1079:1: ( rulecState EOF )
            // InternalSymg.g:1080:1: rulecState EOF
            {
             before(grammarAccess.getCStateRule()); 
            pushFollow(FOLLOW_1);
            rulecState();

            state._fsp--;

             after(grammarAccess.getCStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulecState"


    // $ANTLR start "rulecState"
    // InternalSymg.g:1087:1: rulecState : ( ( rule__CState__Group__0 ) ) ;
    public final void rulecState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1091:2: ( ( ( rule__CState__Group__0 ) ) )
            // InternalSymg.g:1092:2: ( ( rule__CState__Group__0 ) )
            {
            // InternalSymg.g:1092:2: ( ( rule__CState__Group__0 ) )
            // InternalSymg.g:1093:3: ( rule__CState__Group__0 )
            {
             before(grammarAccess.getCStateAccess().getGroup()); 
            // InternalSymg.g:1094:3: ( rule__CState__Group__0 )
            // InternalSymg.g:1094:4: rule__CState__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CState__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecState"


    // $ANTLR start "entryRuleContrState"
    // InternalSymg.g:1103:1: entryRuleContrState : ruleContrState EOF ;
    public final void entryRuleContrState() throws RecognitionException {
        try {
            // InternalSymg.g:1104:1: ( ruleContrState EOF )
            // InternalSymg.g:1105:1: ruleContrState EOF
            {
             before(grammarAccess.getContrStateRule()); 
            pushFollow(FOLLOW_1);
            ruleContrState();

            state._fsp--;

             after(grammarAccess.getContrStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContrState"


    // $ANTLR start "ruleContrState"
    // InternalSymg.g:1112:1: ruleContrState : ( ( rule__ContrState__Alternatives ) ) ;
    public final void ruleContrState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1116:2: ( ( ( rule__ContrState__Alternatives ) ) )
            // InternalSymg.g:1117:2: ( ( rule__ContrState__Alternatives ) )
            {
            // InternalSymg.g:1117:2: ( ( rule__ContrState__Alternatives ) )
            // InternalSymg.g:1118:3: ( rule__ContrState__Alternatives )
            {
             before(grammarAccess.getContrStateAccess().getAlternatives()); 
            // InternalSymg.g:1119:3: ( rule__ContrState__Alternatives )
            // InternalSymg.g:1119:4: rule__ContrState__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ContrState__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContrStateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContrState"


    // $ANTLR start "entryRulepState"
    // InternalSymg.g:1128:1: entryRulepState : rulepState EOF ;
    public final void entryRulepState() throws RecognitionException {
        try {
            // InternalSymg.g:1129:1: ( rulepState EOF )
            // InternalSymg.g:1130:1: rulepState EOF
            {
             before(grammarAccess.getPStateRule()); 
            pushFollow(FOLLOW_1);
            rulepState();

            state._fsp--;

             after(grammarAccess.getPStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulepState"


    // $ANTLR start "rulepState"
    // InternalSymg.g:1137:1: rulepState : ( ( rule__PState__Group__0 ) ) ;
    public final void rulepState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1141:2: ( ( ( rule__PState__Group__0 ) ) )
            // InternalSymg.g:1142:2: ( ( rule__PState__Group__0 ) )
            {
            // InternalSymg.g:1142:2: ( ( rule__PState__Group__0 ) )
            // InternalSymg.g:1143:3: ( rule__PState__Group__0 )
            {
             before(grammarAccess.getPStateAccess().getGroup()); 
            // InternalSymg.g:1144:3: ( rule__PState__Group__0 )
            // InternalSymg.g:1144:4: rule__PState__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PState__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulepState"


    // $ANTLR start "entryRulePowState"
    // InternalSymg.g:1153:1: entryRulePowState : rulePowState EOF ;
    public final void entryRulePowState() throws RecognitionException {
        try {
            // InternalSymg.g:1154:1: ( rulePowState EOF )
            // InternalSymg.g:1155:1: rulePowState EOF
            {
             before(grammarAccess.getPowStateRule()); 
            pushFollow(FOLLOW_1);
            rulePowState();

            state._fsp--;

             after(grammarAccess.getPowStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePowState"


    // $ANTLR start "rulePowState"
    // InternalSymg.g:1162:1: rulePowState : ( ( rule__PowState__Alternatives ) ) ;
    public final void rulePowState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1166:2: ( ( ( rule__PowState__Alternatives ) ) )
            // InternalSymg.g:1167:2: ( ( rule__PowState__Alternatives ) )
            {
            // InternalSymg.g:1167:2: ( ( rule__PowState__Alternatives ) )
            // InternalSymg.g:1168:3: ( rule__PowState__Alternatives )
            {
             before(grammarAccess.getPowStateAccess().getAlternatives()); 
            // InternalSymg.g:1169:3: ( rule__PowState__Alternatives )
            // InternalSymg.g:1169:4: rule__PowState__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PowState__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPowStateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePowState"


    // $ANTLR start "rule__DomainConcept__Alternatives"
    // InternalSymg.g:1177:1: rule__DomainConcept__Alternatives : ( ( ruleRegular ) | ( ruleEnumeration ) );
    public final void rule__DomainConcept__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1181:1: ( ( ruleRegular ) | ( ruleEnumeration ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==89) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==RULE_ID||(LA1_2>=11 && LA1_2<=18)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==92) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalSymg.g:1182:2: ( ruleRegular )
                    {
                    // InternalSymg.g:1182:2: ( ruleRegular )
                    // InternalSymg.g:1183:3: ruleRegular
                    {
                     before(grammarAccess.getDomainConceptAccess().getRegularParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleRegular();

                    state._fsp--;

                     after(grammarAccess.getDomainConceptAccess().getRegularParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1188:2: ( ruleEnumeration )
                    {
                    // InternalSymg.g:1188:2: ( ruleEnumeration )
                    // InternalSymg.g:1189:3: ruleEnumeration
                    {
                     before(grammarAccess.getDomainConceptAccess().getEnumerationParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEnumeration();

                    state._fsp--;

                     after(grammarAccess.getDomainConceptAccess().getEnumerationParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DomainConcept__Alternatives"


    // $ANTLR start "rule__CType__Alternatives"
    // InternalSymg.g:1198:1: rule__CType__Alternatives : ( ( ruleDomainType ) | ( ruleOntoCType ) | ( ruleBasicType ) );
    public final void rule__CType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1202:1: ( ( ruleDomainType ) | ( ruleOntoCType ) | ( ruleBasicType ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                {
                alt2=2;
                }
                break;
            case 11:
            case 12:
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSymg.g:1203:2: ( ruleDomainType )
                    {
                    // InternalSymg.g:1203:2: ( ruleDomainType )
                    // InternalSymg.g:1204:3: ruleDomainType
                    {
                     before(grammarAccess.getCTypeAccess().getDomainTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDomainType();

                    state._fsp--;

                     after(grammarAccess.getCTypeAccess().getDomainTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1209:2: ( ruleOntoCType )
                    {
                    // InternalSymg.g:1209:2: ( ruleOntoCType )
                    // InternalSymg.g:1210:3: ruleOntoCType
                    {
                     before(grammarAccess.getCTypeAccess().getOntoCTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOntoCType();

                    state._fsp--;

                     after(grammarAccess.getCTypeAccess().getOntoCTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1215:2: ( ruleBasicType )
                    {
                    // InternalSymg.g:1215:2: ( ruleBasicType )
                    // InternalSymg.g:1216:3: ruleBasicType
                    {
                     before(grammarAccess.getCTypeAccess().getBasicTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBasicType();

                    state._fsp--;

                     after(grammarAccess.getCTypeAccess().getBasicTypeParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CType__Alternatives"


    // $ANTLR start "rule__BasicType__NameAlternatives_0"
    // InternalSymg.g:1225:1: rule__BasicType__NameAlternatives_0 : ( ( 'NUMBER' ) | ( 'STRING' ) | ( 'DATE' ) );
    public final void rule__BasicType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1229:1: ( ( 'NUMBER' ) | ( 'STRING' ) | ( 'DATE' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalSymg.g:1230:2: ( 'NUMBER' )
                    {
                    // InternalSymg.g:1230:2: ( 'NUMBER' )
                    // InternalSymg.g:1231:3: 'NUMBER'
                    {
                     before(grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1236:2: ( 'STRING' )
                    {
                    // InternalSymg.g:1236:2: ( 'STRING' )
                    // InternalSymg.g:1237:3: 'STRING'
                    {
                     before(grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1242:2: ( 'DATE' )
                    {
                    // InternalSymg.g:1242:2: ( 'DATE' )
                    // InternalSymg.g:1243:3: 'DATE'
                    {
                     before(grammarAccess.getBasicTypeAccess().getNameDATEKeyword_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBasicTypeAccess().getNameDATEKeyword_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicType__NameAlternatives_0"


    // $ANTLR start "rule__OntoCType__NameAlternatives_0"
    // InternalSymg.g:1252:1: rule__OntoCType__NameAlternatives_0 : ( ( 'ASSET' ) | ( 'EVENT' ) | ( 'ROLE' ) | ( 'SITUATION' ) | ( 'CONTRACT' ) );
    public final void rule__OntoCType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1256:1: ( ( 'ASSET' ) | ( 'EVENT' ) | ( 'ROLE' ) | ( 'SITUATION' ) | ( 'CONTRACT' ) )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt4=1;
                }
                break;
            case 15:
                {
                alt4=2;
                }
                break;
            case 16:
                {
                alt4=3;
                }
                break;
            case 17:
                {
                alt4=4;
                }
                break;
            case 18:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalSymg.g:1257:2: ( 'ASSET' )
                    {
                    // InternalSymg.g:1257:2: ( 'ASSET' )
                    // InternalSymg.g:1258:3: 'ASSET'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1263:2: ( 'EVENT' )
                    {
                    // InternalSymg.g:1263:2: ( 'EVENT' )
                    // InternalSymg.g:1264:3: 'EVENT'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1269:2: ( 'ROLE' )
                    {
                    // InternalSymg.g:1269:2: ( 'ROLE' )
                    // InternalSymg.g:1270:3: 'ROLE'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1275:2: ( 'SITUATION' )
                    {
                    // InternalSymg.g:1275:2: ( 'SITUATION' )
                    // InternalSymg.g:1276:3: 'SITUATION'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1281:2: ( 'CONTRACT' )
                    {
                    // InternalSymg.g:1281:2: ( 'CONTRACT' )
                    // InternalSymg.g:1282:3: 'CONTRACT'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameCONTRACTKeyword_0_4()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameCONTRACTKeyword_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OntoCType__NameAlternatives_0"


    // $ANTLR start "rule__TypeName__Alternatives"
    // InternalSymg.g:1291:1: rule__TypeName__Alternatives : ( ( ruleDomainType ) | ( ruleBasicType ) );
    public final void rule__TypeName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1295:1: ( ( ruleDomainType ) | ( ruleBasicType ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=11 && LA5_0<=13)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalSymg.g:1296:2: ( ruleDomainType )
                    {
                    // InternalSymg.g:1296:2: ( ruleDomainType )
                    // InternalSymg.g:1297:3: ruleDomainType
                    {
                     before(grammarAccess.getTypeNameAccess().getDomainTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDomainType();

                    state._fsp--;

                     after(grammarAccess.getTypeNameAccess().getDomainTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1302:2: ( ruleBasicType )
                    {
                    // InternalSymg.g:1302:2: ( ruleBasicType )
                    // InternalSymg.g:1303:3: ruleBasicType
                    {
                     before(grammarAccess.getTypeNameAccess().getBasicTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBasicType();

                    state._fsp--;

                     after(grammarAccess.getTypeNameAccess().getBasicTypeParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeName__Alternatives"


    // $ANTLR start "rule__Atom__Alternatives"
    // InternalSymg.g:1312:1: rule__Atom__Alternatives : ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__Group_3__0 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) | ( ( rule__Atom__BoolAssignment_5 ) ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1316:1: ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__Group_3__0 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) | ( ( rule__Atom__BoolAssignment_5 ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt6=1;
                }
                break;
            case 100:
                {
                alt6=2;
                }
                break;
            case 77:
                {
                alt6=3;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 108:
                {
                alt6=4;
                }
                break;
            case 105:
                {
                alt6=5;
                }
                break;
            case 106:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalSymg.g:1317:2: ( ( rule__Atom__Group_0__0 ) )
                    {
                    // InternalSymg.g:1317:2: ( ( rule__Atom__Group_0__0 ) )
                    // InternalSymg.g:1318:3: ( rule__Atom__Group_0__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_0()); 
                    // InternalSymg.g:1319:3: ( rule__Atom__Group_0__0 )
                    // InternalSymg.g:1319:4: rule__Atom__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1323:2: ( ( rule__Atom__Group_1__0 ) )
                    {
                    // InternalSymg.g:1323:2: ( ( rule__Atom__Group_1__0 ) )
                    // InternalSymg.g:1324:3: ( rule__Atom__Group_1__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_1()); 
                    // InternalSymg.g:1325:3: ( rule__Atom__Group_1__0 )
                    // InternalSymg.g:1325:4: rule__Atom__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1329:2: ( ( rule__Atom__Group_2__0 ) )
                    {
                    // InternalSymg.g:1329:2: ( ( rule__Atom__Group_2__0 ) )
                    // InternalSymg.g:1330:3: ( rule__Atom__Group_2__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_2()); 
                    // InternalSymg.g:1331:3: ( rule__Atom__Group_2__0 )
                    // InternalSymg.g:1331:4: rule__Atom__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1335:2: ( ( rule__Atom__Group_3__0 ) )
                    {
                    // InternalSymg.g:1335:2: ( ( rule__Atom__Group_3__0 ) )
                    // InternalSymg.g:1336:3: ( rule__Atom__Group_3__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_3()); 
                    // InternalSymg.g:1337:3: ( rule__Atom__Group_3__0 )
                    // InternalSymg.g:1337:4: rule__Atom__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1341:2: ( ( rule__Atom__BoolAssignment_4 ) )
                    {
                    // InternalSymg.g:1341:2: ( ( rule__Atom__BoolAssignment_4 ) )
                    // InternalSymg.g:1342:3: ( rule__Atom__BoolAssignment_4 )
                    {
                     before(grammarAccess.getAtomAccess().getBoolAssignment_4()); 
                    // InternalSymg.g:1343:3: ( rule__Atom__BoolAssignment_4 )
                    // InternalSymg.g:1343:4: rule__Atom__BoolAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__BoolAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getBoolAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1347:2: ( ( rule__Atom__BoolAssignment_5 ) )
                    {
                    // InternalSymg.g:1347:2: ( ( rule__Atom__BoolAssignment_5 ) )
                    // InternalSymg.g:1348:3: ( rule__Atom__BoolAssignment_5 )
                    {
                     before(grammarAccess.getAtomAccess().getBoolAssignment_5()); 
                    // InternalSymg.g:1349:3: ( rule__Atom__BoolAssignment_5 )
                    // InternalSymg.g:1349:4: rule__Atom__BoolAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__BoolAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getBoolAssignment_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Alternatives"


    // $ANTLR start "rule__SitProp__Alternatives_0"
    // InternalSymg.g:1357:1: rule__SitProp__Alternatives_0 : ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) );
    public final void rule__SitProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1361:1: ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
                {
                alt7=2;
                }
                break;
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt7=3;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalSymg.g:1362:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1362:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    // InternalSymg.g:1363:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    {
                     before(grammarAccess.getSitPropAccess().getSituationNameAssignment_0_0()); 
                    // InternalSymg.g:1364:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    // InternalSymg.g:1364:4: rule__SitProp__SituationNameAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitProp__SituationNameAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitPropAccess().getSituationNameAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1368:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1368:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    // InternalSymg.g:1369:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    {
                     before(grammarAccess.getSitPropAccess().getOSituationNameAssignment_0_1()); 
                    // InternalSymg.g:1370:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    // InternalSymg.g:1370:4: rule__SitProp__OSituationNameAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitProp__OSituationNameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitPropAccess().getOSituationNameAssignment_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1374:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1374:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    // InternalSymg.g:1375:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    {
                     before(grammarAccess.getSitPropAccess().getCSituationNameAssignment_0_2()); 
                    // InternalSymg.g:1376:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    // InternalSymg.g:1376:4: rule__SitProp__CSituationNameAssignment_0_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitProp__CSituationNameAssignment_0_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitPropAccess().getCSituationNameAssignment_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1380:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1380:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    // InternalSymg.g:1381:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    {
                     before(grammarAccess.getSitPropAccess().getPSituationNameAssignment_0_3()); 
                    // InternalSymg.g:1382:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    // InternalSymg.g:1382:4: rule__SitProp__PSituationNameAssignment_0_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitProp__PSituationNameAssignment_0_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitPropAccess().getPSituationNameAssignment_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Alternatives_0"


    // $ANTLR start "rule__EventProp__Alternatives_0"
    // InternalSymg.g:1390:1: rule__EventProp__Alternatives_0 : ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) );
    public final void rule__EventProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1394:1: ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                {
                alt8=2;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt8=3;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalSymg.g:1395:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1395:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    // InternalSymg.g:1396:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    {
                     before(grammarAccess.getEventPropAccess().getEventNameAssignment_0_0()); 
                    // InternalSymg.g:1397:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    // InternalSymg.g:1397:4: rule__EventProp__EventNameAssignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EventProp__EventNameAssignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEventPropAccess().getEventNameAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1401:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1401:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    // InternalSymg.g:1402:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    {
                     before(grammarAccess.getEventPropAccess().getOEventNameAssignment_0_1()); 
                    // InternalSymg.g:1403:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    // InternalSymg.g:1403:4: rule__EventProp__OEventNameAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EventProp__OEventNameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getEventPropAccess().getOEventNameAssignment_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1407:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1407:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    // InternalSymg.g:1408:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    {
                     before(grammarAccess.getEventPropAccess().getCEventNameAssignment_0_2()); 
                    // InternalSymg.g:1409:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    // InternalSymg.g:1409:4: rule__EventProp__CEventNameAssignment_0_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__EventProp__CEventNameAssignment_0_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getEventPropAccess().getCEventNameAssignment_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1413:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1413:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    // InternalSymg.g:1414:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    {
                     before(grammarAccess.getEventPropAccess().getPEventNameAssignment_0_3()); 
                    // InternalSymg.g:1415:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    // InternalSymg.g:1415:4: rule__EventProp__PEventNameAssignment_0_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__EventProp__PEventNameAssignment_0_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getEventPropAccess().getPEventNameAssignment_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Alternatives_0"


    // $ANTLR start "rule__Interval__Alternatives"
    // InternalSymg.g:1423:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ruleRelativeSituationPointBefore ) | ( ruleRelativeSituationPointAfter ) );
    public final void rule__Interval__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1427:1: ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ruleRelativeSituationPointBefore ) | ( ruleRelativeSituationPointAfter ) )
            int alt9=5;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalSymg.g:1428:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1428:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    // InternalSymg.g:1429:3: ( rule__Interval__SituationNameAssignment_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getSituationNameAssignment_0()); 
                    // InternalSymg.g:1430:3: ( rule__Interval__SituationNameAssignment_0 )
                    // InternalSymg.g:1430:4: rule__Interval__SituationNameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interval__SituationNameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getSituationNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1434:2: ( ( rule__Interval__Group_1__0 ) )
                    {
                    // InternalSymg.g:1434:2: ( ( rule__Interval__Group_1__0 ) )
                    // InternalSymg.g:1435:3: ( rule__Interval__Group_1__0 )
                    {
                     before(grammarAccess.getIntervalAccess().getGroup_1()); 
                    // InternalSymg.g:1436:3: ( rule__Interval__Group_1__0 )
                    // InternalSymg.g:1436:4: rule__Interval__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interval__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1440:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    {
                    // InternalSymg.g:1440:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    // InternalSymg.g:1441:3: ( rule__Interval__UnnamedAssignment_2 )
                    {
                     before(grammarAccess.getIntervalAccess().getUnnamedAssignment_2()); 
                    // InternalSymg.g:1442:3: ( rule__Interval__UnnamedAssignment_2 )
                    // InternalSymg.g:1442:4: rule__Interval__UnnamedAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interval__UnnamedAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getUnnamedAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1446:2: ( ruleRelativeSituationPointBefore )
                    {
                    // InternalSymg.g:1446:2: ( ruleRelativeSituationPointBefore )
                    // InternalSymg.g:1447:3: ruleRelativeSituationPointBefore
                    {
                     before(grammarAccess.getIntervalAccess().getRelativeSituationPointBeforeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleRelativeSituationPointBefore();

                    state._fsp--;

                     after(grammarAccess.getIntervalAccess().getRelativeSituationPointBeforeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1452:2: ( ruleRelativeSituationPointAfter )
                    {
                    // InternalSymg.g:1452:2: ( ruleRelativeSituationPointAfter )
                    // InternalSymg.g:1453:3: ruleRelativeSituationPointAfter
                    {
                     before(grammarAccess.getIntervalAccess().getRelativeSituationPointAfterParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleRelativeSituationPointAfter();

                    state._fsp--;

                     after(grammarAccess.getIntervalAccess().getRelativeSituationPointAfterParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Alternatives"


    // $ANTLR start "rule__SitName__Alternatives"
    // InternalSymg.g:1462:1: rule__SitName__Alternatives : ( ( ( rule__SitName__DeclNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) );
    public final void rule__SitName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1466:1: ( ( ( rule__SitName__DeclNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) )
            int alt10=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt10=1;
                }
                break;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
                {
                alt10=2;
                }
                break;
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt10=3;
                }
                break;
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                {
                alt10=4;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                {
                alt10=5;
                }
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt10=6;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                {
                alt10=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalSymg.g:1467:2: ( ( rule__SitName__DeclNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1467:2: ( ( rule__SitName__DeclNameAssignment_0 ) )
                    // InternalSymg.g:1468:3: ( rule__SitName__DeclNameAssignment_0 )
                    {
                     before(grammarAccess.getSitNameAccess().getDeclNameAssignment_0()); 
                    // InternalSymg.g:1469:3: ( rule__SitName__DeclNameAssignment_0 )
                    // InternalSymg.g:1469:4: rule__SitName__DeclNameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__DeclNameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getDeclNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1473:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    {
                    // InternalSymg.g:1473:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    // InternalSymg.g:1474:3: ( rule__SitName__OStateAssignment_1 )
                    {
                     before(grammarAccess.getSitNameAccess().getOStateAssignment_1()); 
                    // InternalSymg.g:1475:3: ( rule__SitName__OStateAssignment_1 )
                    // InternalSymg.g:1475:4: rule__SitName__OStateAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__OStateAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getOStateAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1479:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    {
                    // InternalSymg.g:1479:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    // InternalSymg.g:1480:3: ( rule__SitName__PStateAssignment_2 )
                    {
                     before(grammarAccess.getSitNameAccess().getPStateAssignment_2()); 
                    // InternalSymg.g:1481:3: ( rule__SitName__PStateAssignment_2 )
                    // InternalSymg.g:1481:4: rule__SitName__PStateAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__PStateAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getPStateAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1485:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    {
                    // InternalSymg.g:1485:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    // InternalSymg.g:1486:3: ( rule__SitName__CStateAssignment_3 )
                    {
                     before(grammarAccess.getSitNameAccess().getCStateAssignment_3()); 
                    // InternalSymg.g:1487:3: ( rule__SitName__CStateAssignment_3 )
                    // InternalSymg.g:1487:4: rule__SitName__CStateAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__CStateAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getCStateAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1491:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    {
                    // InternalSymg.g:1491:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    // InternalSymg.g:1492:3: ( rule__SitName__OEventAssignment_4 )
                    {
                     before(grammarAccess.getSitNameAccess().getOEventAssignment_4()); 
                    // InternalSymg.g:1493:3: ( rule__SitName__OEventAssignment_4 )
                    // InternalSymg.g:1493:4: rule__SitName__OEventAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__OEventAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getOEventAssignment_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1497:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    {
                    // InternalSymg.g:1497:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    // InternalSymg.g:1498:3: ( rule__SitName__CEventAssignment_5 )
                    {
                     before(grammarAccess.getSitNameAccess().getCEventAssignment_5()); 
                    // InternalSymg.g:1499:3: ( rule__SitName__CEventAssignment_5 )
                    // InternalSymg.g:1499:4: rule__SitName__CEventAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__CEventAssignment_5();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getCEventAssignment_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1503:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    {
                    // InternalSymg.g:1503:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    // InternalSymg.g:1504:3: ( rule__SitName__PEventAssignment_6 )
                    {
                     before(grammarAccess.getSitNameAccess().getPEventAssignment_6()); 
                    // InternalSymg.g:1505:3: ( rule__SitName__PEventAssignment_6 )
                    // InternalSymg.g:1505:4: rule__SitName__PEventAssignment_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__PEventAssignment_6();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getPEventAssignment_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__Alternatives"


    // $ANTLR start "rule__Unit__Alternatives"
    // InternalSymg.g:1513:1: rule__Unit__Alternatives : ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) );
    public final void rule__Unit__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1517:1: ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) )
            int alt11=8;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt11=1;
                }
                break;
            case 20:
                {
                alt11=2;
                }
                break;
            case 21:
                {
                alt11=3;
                }
                break;
            case 22:
                {
                alt11=4;
                }
                break;
            case 23:
                {
                alt11=5;
                }
                break;
            case 24:
                {
                alt11=6;
                }
                break;
            case 25:
                {
                alt11=7;
                }
                break;
            case 26:
                {
                alt11=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalSymg.g:1518:2: ( 'SECONDS' )
                    {
                    // InternalSymg.g:1518:2: ( 'SECONDS' )
                    // InternalSymg.g:1519:3: 'SECONDS'
                    {
                     before(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1524:2: ( 'MINUTES' )
                    {
                    // InternalSymg.g:1524:2: ( 'MINUTES' )
                    // InternalSymg.g:1525:3: 'MINUTES'
                    {
                     before(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1530:2: ( 'HOURS' )
                    {
                    // InternalSymg.g:1530:2: ( 'HOURS' )
                    // InternalSymg.g:1531:3: 'HOURS'
                    {
                     before(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1536:2: ( 'DAYS' )
                    {
                    // InternalSymg.g:1536:2: ( 'DAYS' )
                    // InternalSymg.g:1537:3: 'DAYS'
                    {
                     before(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1542:2: ( 'WEEKS' )
                    {
                    // InternalSymg.g:1542:2: ( 'WEEKS' )
                    // InternalSymg.g:1543:3: 'WEEKS'
                    {
                     before(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1548:2: ( 'MONTHS' )
                    {
                    // InternalSymg.g:1548:2: ( 'MONTHS' )
                    // InternalSymg.g:1549:3: 'MONTHS'
                    {
                     before(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1554:2: ( 'QUARTERS' )
                    {
                    // InternalSymg.g:1554:2: ( 'QUARTERS' )
                    // InternalSymg.g:1555:3: 'QUARTERS'
                    {
                     before(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1560:2: ( 'YEARS' )
                    {
                    // InternalSymg.g:1560:2: ( 'YEARS' )
                    // InternalSymg.g:1561:3: 'YEARS'
                    {
                     before(grammarAccess.getUnitAccess().getYEARSKeyword_7()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getYEARSKeyword_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unit__Alternatives"


    // $ANTLR start "rule__TempOp__Alternatives"
    // InternalSymg.g:1570:1: rule__TempOp__Alternatives : ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) );
    public final void rule__TempOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1574:1: ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt12=1;
                }
                break;
            case 28:
                {
                alt12=2;
                }
                break;
            case 29:
                {
                alt12=3;
                }
                break;
            case 30:
                {
                alt12=4;
                }
                break;
            case 31:
                {
                alt12=5;
                }
                break;
            case 32:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalSymg.g:1575:2: ( 'BEFORE' )
                    {
                    // InternalSymg.g:1575:2: ( 'BEFORE' )
                    // InternalSymg.g:1576:3: 'BEFORE'
                    {
                     before(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1581:2: ( 'AFTER' )
                    {
                    // InternalSymg.g:1581:2: ( 'AFTER' )
                    // InternalSymg.g:1582:3: 'AFTER'
                    {
                     before(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1587:2: ( 'AT' )
                    {
                    // InternalSymg.g:1587:2: ( 'AT' )
                    // InternalSymg.g:1588:3: 'AT'
                    {
                     before(grammarAccess.getTempOpAccess().getATKeyword_2()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getATKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1593:2: ( 'WITHIN' )
                    {
                    // InternalSymg.g:1593:2: ( 'WITHIN' )
                    // InternalSymg.g:1594:3: 'WITHIN'
                    {
                     before(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1599:2: ( '+' )
                    {
                    // InternalSymg.g:1599:2: ( '+' )
                    // InternalSymg.g:1600:3: '+'
                    {
                     before(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1605:2: ( '-' )
                    {
                    // InternalSymg.g:1605:2: ( '-' )
                    // InternalSymg.g:1606:3: '-'
                    {
                     before(grammarAccess.getTempOpAccess().getHyphenMinusKeyword_5()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getHyphenMinusKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TempOp__Alternatives"


    // $ANTLR start "rule__Point__Alternatives"
    // InternalSymg.g:1615:1: rule__Point__Alternatives : ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ruleRelativeEventPointBefore ) | ( ruleRelativeEventPointAfter ) );
    public final void rule__Point__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1619:1: ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ruleRelativeEventPointBefore ) | ( ruleRelativeEventPointAfter ) )
            int alt13=5;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalSymg.g:1620:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1620:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    // InternalSymg.g:1621:3: ( rule__Point__EventNameAssignment_0 )
                    {
                     before(grammarAccess.getPointAccess().getEventNameAssignment_0()); 
                    // InternalSymg.g:1622:3: ( rule__Point__EventNameAssignment_0 )
                    // InternalSymg.g:1622:4: rule__Point__EventNameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Point__EventNameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointAccess().getEventNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1626:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    {
                    // InternalSymg.g:1626:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    // InternalSymg.g:1627:3: ( rule__Point__UnnamedAssignment_1 )
                    {
                     before(grammarAccess.getPointAccess().getUnnamedAssignment_1()); 
                    // InternalSymg.g:1628:3: ( rule__Point__UnnamedAssignment_1 )
                    // InternalSymg.g:1628:4: rule__Point__UnnamedAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Point__UnnamedAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointAccess().getUnnamedAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1632:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    {
                    // InternalSymg.g:1632:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    // InternalSymg.g:1633:3: ( rule__Point__PointConstAssignment_2 )
                    {
                     before(grammarAccess.getPointAccess().getPointConstAssignment_2()); 
                    // InternalSymg.g:1634:3: ( rule__Point__PointConstAssignment_2 )
                    // InternalSymg.g:1634:4: rule__Point__PointConstAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Point__PointConstAssignment_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointAccess().getPointConstAssignment_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1638:2: ( ruleRelativeEventPointBefore )
                    {
                    // InternalSymg.g:1638:2: ( ruleRelativeEventPointBefore )
                    // InternalSymg.g:1639:3: ruleRelativeEventPointBefore
                    {
                     before(grammarAccess.getPointAccess().getRelativeEventPointBeforeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleRelativeEventPointBefore();

                    state._fsp--;

                     after(grammarAccess.getPointAccess().getRelativeEventPointBeforeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1644:2: ( ruleRelativeEventPointAfter )
                    {
                    // InternalSymg.g:1644:2: ( ruleRelativeEventPointAfter )
                    // InternalSymg.g:1645:3: ruleRelativeEventPointAfter
                    {
                     before(grammarAccess.getPointAccess().getRelativeEventPointAfterParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleRelativeEventPointAfter();

                    state._fsp--;

                     after(grammarAccess.getPointAccess().getRelativeEventPointAfterParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__Alternatives"


    // $ANTLR start "rule__PowEvent__Alternatives"
    // InternalSymg.g:1654:1: rule__PowEvent__Alternatives : ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) );
    public final void rule__PowEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1658:1: ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt14=1;
                }
                break;
            case 34:
                {
                alt14=2;
                }
                break;
            case 35:
                {
                alt14=3;
                }
                break;
            case 36:
                {
                alt14=4;
                }
                break;
            case 37:
                {
                alt14=5;
                }
                break;
            case 38:
                {
                alt14=6;
                }
                break;
            case 39:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalSymg.g:1659:2: ( 'pTRIGGERED' )
                    {
                    // InternalSymg.g:1659:2: ( 'pTRIGGERED' )
                    // InternalSymg.g:1660:3: 'pTRIGGERED'
                    {
                     before(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1665:2: ( 'pACTIVATED' )
                    {
                    // InternalSymg.g:1665:2: ( 'pACTIVATED' )
                    // InternalSymg.g:1666:3: 'pACTIVATED'
                    {
                     before(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1671:2: ( 'pSUSPENDED' )
                    {
                    // InternalSymg.g:1671:2: ( 'pSUSPENDED' )
                    // InternalSymg.g:1672:3: 'pSUSPENDED'
                    {
                     before(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1677:2: ( 'pRESUMED' )
                    {
                    // InternalSymg.g:1677:2: ( 'pRESUMED' )
                    // InternalSymg.g:1678:3: 'pRESUMED'
                    {
                     before(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1683:2: ( 'pEXERTED' )
                    {
                    // InternalSymg.g:1683:2: ( 'pEXERTED' )
                    // InternalSymg.g:1684:3: 'pEXERTED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1689:2: ( 'pEXPIRED' )
                    {
                    // InternalSymg.g:1689:2: ( 'pEXPIRED' )
                    // InternalSymg.g:1690:3: 'pEXPIRED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1695:2: ( 'pTERMINATED' )
                    {
                    // InternalSymg.g:1695:2: ( 'pTERMINATED' )
                    // InternalSymg.g:1696:3: 'pTERMINATED'
                    {
                     before(grammarAccess.getPowEventAccess().getPTERMINATEDKeyword_6()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPTERMINATEDKeyword_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowEvent__Alternatives"


    // $ANTLR start "rule__ContrEvent__Alternatives"
    // InternalSymg.g:1705:1: rule__ContrEvent__Alternatives : ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) );
    public final void rule__ContrEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1709:1: ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) )
            int alt15=7;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt15=1;
                }
                break;
            case 41:
                {
                alt15=2;
                }
                break;
            case 42:
                {
                alt15=3;
                }
                break;
            case 43:
                {
                alt15=4;
                }
                break;
            case 44:
                {
                alt15=5;
                }
                break;
            case 45:
                {
                alt15=6;
                }
                break;
            case 46:
                {
                alt15=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalSymg.g:1710:2: ( 'cACTIVATED' )
                    {
                    // InternalSymg.g:1710:2: ( 'cACTIVATED' )
                    // InternalSymg.g:1711:3: 'cACTIVATED'
                    {
                     before(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1716:2: ( 'cSUSPENDED' )
                    {
                    // InternalSymg.g:1716:2: ( 'cSUSPENDED' )
                    // InternalSymg.g:1717:3: 'cSUSPENDED'
                    {
                     before(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1722:2: ( 'cRESUMED' )
                    {
                    // InternalSymg.g:1722:2: ( 'cRESUMED' )
                    // InternalSymg.g:1723:3: 'cRESUMED'
                    {
                     before(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1728:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    {
                    // InternalSymg.g:1728:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    // InternalSymg.g:1729:3: 'cFULFILLED_ACTIVE_OBLS'
                    {
                     before(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1734:2: ( 'cREVOKED_PARTY' )
                    {
                    // InternalSymg.g:1734:2: ( 'cREVOKED_PARTY' )
                    // InternalSymg.g:1735:3: 'cREVOKED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1740:2: ( 'cASSIGNED_PARTY' )
                    {
                    // InternalSymg.g:1740:2: ( 'cASSIGNED_PARTY' )
                    // InternalSymg.g:1741:3: 'cASSIGNED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1746:2: ( 'cTERMINATED' )
                    {
                    // InternalSymg.g:1746:2: ( 'cTERMINATED' )
                    // InternalSymg.g:1747:3: 'cTERMINATED'
                    {
                     before(grammarAccess.getContrEventAccess().getCTERMINATEDKeyword_6()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCTERMINATEDKeyword_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContrEvent__Alternatives"


    // $ANTLR start "rule__OblEvent__Alternatives"
    // InternalSymg.g:1756:1: rule__OblEvent__Alternatives : ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) );
    public final void rule__OblEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1760:1: ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) )
            int alt16=9;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt16=1;
                }
                break;
            case 48:
                {
                alt16=2;
                }
                break;
            case 49:
                {
                alt16=3;
                }
                break;
            case 50:
                {
                alt16=4;
                }
                break;
            case 51:
                {
                alt16=5;
                }
                break;
            case 52:
                {
                alt16=6;
                }
                break;
            case 53:
                {
                alt16=7;
                }
                break;
            case 54:
                {
                alt16=8;
                }
                break;
            case 55:
                {
                alt16=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalSymg.g:1761:2: ( 'oTRIGGERED' )
                    {
                    // InternalSymg.g:1761:2: ( 'oTRIGGERED' )
                    // InternalSymg.g:1762:3: 'oTRIGGERED'
                    {
                     before(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1767:2: ( 'oACTIVATED' )
                    {
                    // InternalSymg.g:1767:2: ( 'oACTIVATED' )
                    // InternalSymg.g:1768:3: 'oACTIVATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1773:2: ( 'oSUSPENDED' )
                    {
                    // InternalSymg.g:1773:2: ( 'oSUSPENDED' )
                    // InternalSymg.g:1774:3: 'oSUSPENDED'
                    {
                     before(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1779:2: ( 'oRESUMED' )
                    {
                    // InternalSymg.g:1779:2: ( 'oRESUMED' )
                    // InternalSymg.g:1780:3: 'oRESUMED'
                    {
                     before(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1785:2: ( 'oDISCHARGED' )
                    {
                    // InternalSymg.g:1785:2: ( 'oDISCHARGED' )
                    // InternalSymg.g:1786:3: 'oDISCHARGED'
                    {
                     before(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1791:2: ( 'oEXPIRED' )
                    {
                    // InternalSymg.g:1791:2: ( 'oEXPIRED' )
                    // InternalSymg.g:1792:3: 'oEXPIRED'
                    {
                     before(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1797:2: ( 'oFULFILLED' )
                    {
                    // InternalSymg.g:1797:2: ( 'oFULFILLED' )
                    // InternalSymg.g:1798:3: 'oFULFILLED'
                    {
                     before(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1803:2: ( 'oVIOLATED' )
                    {
                    // InternalSymg.g:1803:2: ( 'oVIOLATED' )
                    // InternalSymg.g:1804:3: 'oVIOLATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalSymg.g:1809:2: ( 'oTERMINATED' )
                    {
                    // InternalSymg.g:1809:2: ( 'oTERMINATED' )
                    // InternalSymg.g:1810:3: 'oTERMINATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOTERMINATEDKeyword_8()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOTERMINATEDKeyword_8()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OblEvent__Alternatives"


    // $ANTLR start "rule__OblState__Alternatives"
    // InternalSymg.g:1819:1: rule__OblState__Alternatives : ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) );
    public final void rule__OblState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1823:1: ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) )
            int alt17=7;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt17=1;
                }
                break;
            case 57:
                {
                alt17=2;
                }
                break;
            case 58:
                {
                alt17=3;
                }
                break;
            case 59:
                {
                alt17=4;
                }
                break;
            case 60:
                {
                alt17=5;
                }
                break;
            case 61:
                {
                alt17=6;
                }
                break;
            case 62:
                {
                alt17=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalSymg.g:1824:2: ( 'oCREATE' )
                    {
                    // InternalSymg.g:1824:2: ( 'oCREATE' )
                    // InternalSymg.g:1825:3: 'oCREATE'
                    {
                     before(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1830:2: ( 'oINEFFECT' )
                    {
                    // InternalSymg.g:1830:2: ( 'oINEFFECT' )
                    // InternalSymg.g:1831:3: 'oINEFFECT'
                    {
                     before(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1836:2: ( 'oSUSPENSION' )
                    {
                    // InternalSymg.g:1836:2: ( 'oSUSPENSION' )
                    // InternalSymg.g:1837:3: 'oSUSPENSION'
                    {
                     before(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1842:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1842:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1843:3: 'oUNSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1848:2: ( 'oVIOLATION' )
                    {
                    // InternalSymg.g:1848:2: ( 'oVIOLATION' )
                    // InternalSymg.g:1849:3: 'oVIOLATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_4()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1854:2: ( 'oFULFILLMENT' )
                    {
                    // InternalSymg.g:1854:2: ( 'oFULFILLMENT' )
                    // InternalSymg.g:1855:3: 'oFULFILLMENT'
                    {
                     before(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_5()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1860:2: ( 'oDISCHARGE' )
                    {
                    // InternalSymg.g:1860:2: ( 'oDISCHARGE' )
                    // InternalSymg.g:1861:3: 'oDISCHARGE'
                    {
                     before(grammarAccess.getOblStateAccess().getODISCHARGEKeyword_6()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getODISCHARGEKeyword_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OblState__Alternatives"


    // $ANTLR start "rule__ContrState__Alternatives"
    // InternalSymg.g:1870:1: rule__ContrState__Alternatives : ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) );
    public final void rule__ContrState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1874:1: ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt18=1;
                }
                break;
            case 64:
                {
                alt18=2;
                }
                break;
            case 65:
                {
                alt18=3;
                }
                break;
            case 66:
                {
                alt18=4;
                }
                break;
            case 67:
                {
                alt18=5;
                }
                break;
            case 68:
                {
                alt18=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalSymg.g:1875:2: ( 'cFORM' )
                    {
                    // InternalSymg.g:1875:2: ( 'cFORM' )
                    // InternalSymg.g:1876:3: 'cFORM'
                    {
                     before(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1881:2: ( 'cINEFFECT' )
                    {
                    // InternalSymg.g:1881:2: ( 'cINEFFECT' )
                    // InternalSymg.g:1882:3: 'cINEFFECT'
                    {
                     before(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1887:2: ( 'cSUSPENSION' )
                    {
                    // InternalSymg.g:1887:2: ( 'cSUSPENSION' )
                    // InternalSymg.g:1888:3: 'cSUSPENSION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1893:2: ( 'cSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1893:2: ( 'cSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1894:3: 'cSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1899:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1899:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    // InternalSymg.g:1900:3: 'cUNSECCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1905:2: ( 'cUNASSIGN' )
                    {
                    // InternalSymg.g:1905:2: ( 'cUNASSIGN' )
                    // InternalSymg.g:1906:3: 'cUNASSIGN'
                    {
                     before(grammarAccess.getContrStateAccess().getCUNASSIGNKeyword_5()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCUNASSIGNKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContrState__Alternatives"


    // $ANTLR start "rule__PowState__Alternatives"
    // InternalSymg.g:1915:1: rule__PowState__Alternatives : ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) );
    public final void rule__PowState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1919:1: ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt19=1;
                }
                break;
            case 70:
                {
                alt19=2;
                }
                break;
            case 71:
                {
                alt19=3;
                }
                break;
            case 72:
                {
                alt19=4;
                }
                break;
            case 73:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalSymg.g:1920:2: ( 'pCREATE' )
                    {
                    // InternalSymg.g:1920:2: ( 'pCREATE' )
                    // InternalSymg.g:1921:3: 'pCREATE'
                    {
                     before(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1926:2: ( 'pINEFFECT' )
                    {
                    // InternalSymg.g:1926:2: ( 'pINEFFECT' )
                    // InternalSymg.g:1927:3: 'pINEFFECT'
                    {
                     before(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1932:2: ( 'pSUSPENSION' )
                    {
                    // InternalSymg.g:1932:2: ( 'pSUSPENSION' )
                    // InternalSymg.g:1933:3: 'pSUSPENSION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1938:2: ( 'pSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1938:2: ( 'pSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1939:3: 'pSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1944:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1944:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1945:3: 'pUNSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getPowStateAccess().getPUNSUCCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPUNSUCCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowState__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalSymg.g:1954:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1958:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalSymg.g:1959:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalSymg.g:1966:1: rule__Model__Group__0__Impl : ( 'Domain' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1970:1: ( ( 'Domain' ) )
            // InternalSymg.g:1971:1: ( 'Domain' )
            {
            // InternalSymg.g:1971:1: ( 'Domain' )
            // InternalSymg.g:1972:2: 'Domain'
            {
             before(grammarAccess.getModelAccess().getDomainKeyword_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getDomainKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalSymg.g:1981:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1985:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalSymg.g:1986:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalSymg.g:1993:1: rule__Model__Group__1__Impl : ( ( rule__Model__DomainNameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1997:1: ( ( ( rule__Model__DomainNameAssignment_1 ) ) )
            // InternalSymg.g:1998:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            {
            // InternalSymg.g:1998:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            // InternalSymg.g:1999:2: ( rule__Model__DomainNameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getDomainNameAssignment_1()); 
            // InternalSymg.g:2000:2: ( rule__Model__DomainNameAssignment_1 )
            // InternalSymg.g:2000:3: rule__Model__DomainNameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__DomainNameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDomainNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalSymg.g:2008:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2012:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalSymg.g:2013:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalSymg.g:2020:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2024:1: ( ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) )
            // InternalSymg.g:2025:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            {
            // InternalSymg.g:2025:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            // InternalSymg.g:2026:2: ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* )
            {
            // InternalSymg.g:2026:2: ( ( rule__Model__Group_2__0 ) )
            // InternalSymg.g:2027:3: ( rule__Model__Group_2__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:2028:3: ( rule__Model__Group_2__0 )
            // InternalSymg.g:2028:4: rule__Model__Group_2__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }

            // InternalSymg.g:2031:2: ( ( rule__Model__Group_2__0 )* )
            // InternalSymg.g:2032:3: ( rule__Model__Group_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:2033:3: ( rule__Model__Group_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSymg.g:2033:4: rule__Model__Group_2__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalSymg.g:2042:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2046:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalSymg.g:2047:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalSymg.g:2054:1: rule__Model__Group__3__Impl : ( 'endDomain' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2058:1: ( ( 'endDomain' ) )
            // InternalSymg.g:2059:1: ( 'endDomain' )
            {
            // InternalSymg.g:2059:1: ( 'endDomain' )
            // InternalSymg.g:2060:2: 'endDomain'
            {
             before(grammarAccess.getModelAccess().getEndDomainKeyword_3()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getEndDomainKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalSymg.g:2069:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2073:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalSymg.g:2074:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalSymg.g:2081:1: rule__Model__Group__4__Impl : ( 'Contract' ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2085:1: ( ( 'Contract' ) )
            // InternalSymg.g:2086:1: ( 'Contract' )
            {
            // InternalSymg.g:2086:1: ( 'Contract' )
            // InternalSymg.g:2087:2: 'Contract'
            {
             before(grammarAccess.getModelAccess().getContractKeyword_4()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getContractKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // InternalSymg.g:2096:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2100:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // InternalSymg.g:2101:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // InternalSymg.g:2108:1: rule__Model__Group__5__Impl : ( ( rule__Model__ContractNameAssignment_5 ) ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2112:1: ( ( ( rule__Model__ContractNameAssignment_5 ) ) )
            // InternalSymg.g:2113:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            {
            // InternalSymg.g:2113:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            // InternalSymg.g:2114:2: ( rule__Model__ContractNameAssignment_5 )
            {
             before(grammarAccess.getModelAccess().getContractNameAssignment_5()); 
            // InternalSymg.g:2115:2: ( rule__Model__ContractNameAssignment_5 )
            // InternalSymg.g:2115:3: rule__Model__ContractNameAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Model__ContractNameAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getContractNameAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Model__Group__6"
    // InternalSymg.g:2123:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2127:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // InternalSymg.g:2128:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6"


    // $ANTLR start "rule__Model__Group__6__Impl"
    // InternalSymg.g:2135:1: rule__Model__Group__6__Impl : ( '(' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2139:1: ( ( '(' ) )
            // InternalSymg.g:2140:1: ( '(' )
            {
            // InternalSymg.g:2140:1: ( '(' )
            // InternalSymg.g:2141:2: '('
            {
             before(grammarAccess.getModelAccess().getLeftParenthesisKeyword_6()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6__Impl"


    // $ANTLR start "rule__Model__Group__7"
    // InternalSymg.g:2150:1: rule__Model__Group__7 : rule__Model__Group__7__Impl rule__Model__Group__8 ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2154:1: ( rule__Model__Group__7__Impl rule__Model__Group__8 )
            // InternalSymg.g:2155:2: rule__Model__Group__7__Impl rule__Model__Group__8
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7"


    // $ANTLR start "rule__Model__Group__7__Impl"
    // InternalSymg.g:2162:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2166:1: ( ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) )
            // InternalSymg.g:2167:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            {
            // InternalSymg.g:2167:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            // InternalSymg.g:2168:2: ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* )
            {
            // InternalSymg.g:2168:2: ( ( rule__Model__Group_7__0 ) )
            // InternalSymg.g:2169:3: ( rule__Model__Group_7__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2170:3: ( rule__Model__Group_7__0 )
            // InternalSymg.g:2170:4: rule__Model__Group_7__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_7__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_7()); 

            }

            // InternalSymg.g:2173:2: ( ( rule__Model__Group_7__0 )* )
            // InternalSymg.g:2174:3: ( rule__Model__Group_7__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2175:3: ( rule__Model__Group_7__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==91) ) {
                        switch ( input.LA(3) ) {
                        case RULE_ID:
                            {
                            int LA21_3 = input.LA(4);

                            if ( (LA21_3==81) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 11:
                            {
                            int LA21_4 = input.LA(4);

                            if ( (LA21_4==81) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 12:
                            {
                            int LA21_5 = input.LA(4);

                            if ( (LA21_5==81) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 13:
                            {
                            int LA21_6 = input.LA(4);

                            if ( (LA21_6==81) ) {
                                alt21=1;
                            }


                            }
                            break;

                        }

                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalSymg.g:2175:4: rule__Model__Group_7__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_7()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7__Impl"


    // $ANTLR start "rule__Model__Group__8"
    // InternalSymg.g:2184:1: rule__Model__Group__8 : rule__Model__Group__8__Impl rule__Model__Group__9 ;
    public final void rule__Model__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2188:1: ( rule__Model__Group__8__Impl rule__Model__Group__9 )
            // InternalSymg.g:2189:2: rule__Model__Group__8__Impl rule__Model__Group__9
            {
            pushFollow(FOLLOW_8);
            rule__Model__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8"


    // $ANTLR start "rule__Model__Group__8__Impl"
    // InternalSymg.g:2196:1: rule__Model__Group__8__Impl : ( ( rule__Model__ParametersAssignment_8 ) ) ;
    public final void rule__Model__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2200:1: ( ( ( rule__Model__ParametersAssignment_8 ) ) )
            // InternalSymg.g:2201:1: ( ( rule__Model__ParametersAssignment_8 ) )
            {
            // InternalSymg.g:2201:1: ( ( rule__Model__ParametersAssignment_8 ) )
            // InternalSymg.g:2202:2: ( rule__Model__ParametersAssignment_8 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_8()); 
            // InternalSymg.g:2203:2: ( rule__Model__ParametersAssignment_8 )
            // InternalSymg.g:2203:3: rule__Model__ParametersAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Model__ParametersAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getParametersAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8__Impl"


    // $ANTLR start "rule__Model__Group__9"
    // InternalSymg.g:2211:1: rule__Model__Group__9 : rule__Model__Group__9__Impl rule__Model__Group__10 ;
    public final void rule__Model__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2215:1: ( rule__Model__Group__9__Impl rule__Model__Group__10 )
            // InternalSymg.g:2216:2: rule__Model__Group__9__Impl rule__Model__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9"


    // $ANTLR start "rule__Model__Group__9__Impl"
    // InternalSymg.g:2223:1: rule__Model__Group__9__Impl : ( ')' ) ;
    public final void rule__Model__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2227:1: ( ( ')' ) )
            // InternalSymg.g:2228:1: ( ')' )
            {
            // InternalSymg.g:2228:1: ( ')' )
            // InternalSymg.g:2229:2: ')'
            {
             before(grammarAccess.getModelAccess().getRightParenthesisKeyword_9()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightParenthesisKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9__Impl"


    // $ANTLR start "rule__Model__Group__10"
    // InternalSymg.g:2238:1: rule__Model__Group__10 : rule__Model__Group__10__Impl rule__Model__Group__11 ;
    public final void rule__Model__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2242:1: ( rule__Model__Group__10__Impl rule__Model__Group__11 )
            // InternalSymg.g:2243:2: rule__Model__Group__10__Impl rule__Model__Group__11
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10"


    // $ANTLR start "rule__Model__Group__10__Impl"
    // InternalSymg.g:2250:1: rule__Model__Group__10__Impl : ( ( rule__Model__Group_10__0 )? ) ;
    public final void rule__Model__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2254:1: ( ( ( rule__Model__Group_10__0 )? ) )
            // InternalSymg.g:2255:1: ( ( rule__Model__Group_10__0 )? )
            {
            // InternalSymg.g:2255:1: ( ( rule__Model__Group_10__0 )? )
            // InternalSymg.g:2256:2: ( rule__Model__Group_10__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_10()); 
            // InternalSymg.g:2257:2: ( rule__Model__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==82) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSymg.g:2257:3: rule__Model__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10__Impl"


    // $ANTLR start "rule__Model__Group__11"
    // InternalSymg.g:2265:1: rule__Model__Group__11 : rule__Model__Group__11__Impl rule__Model__Group__12 ;
    public final void rule__Model__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2269:1: ( rule__Model__Group__11__Impl rule__Model__Group__12 )
            // InternalSymg.g:2270:2: rule__Model__Group__11__Impl rule__Model__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11"


    // $ANTLR start "rule__Model__Group__11__Impl"
    // InternalSymg.g:2277:1: rule__Model__Group__11__Impl : ( ( rule__Model__Group_11__0 )? ) ;
    public final void rule__Model__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2281:1: ( ( ( rule__Model__Group_11__0 )? ) )
            // InternalSymg.g:2282:1: ( ( rule__Model__Group_11__0 )? )
            {
            // InternalSymg.g:2282:1: ( ( rule__Model__Group_11__0 )? )
            // InternalSymg.g:2283:2: ( rule__Model__Group_11__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_11()); 
            // InternalSymg.g:2284:2: ( rule__Model__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==83) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSymg.g:2284:3: rule__Model__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11__Impl"


    // $ANTLR start "rule__Model__Group__12"
    // InternalSymg.g:2292:1: rule__Model__Group__12 : rule__Model__Group__12__Impl rule__Model__Group__13 ;
    public final void rule__Model__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2296:1: ( rule__Model__Group__12__Impl rule__Model__Group__13 )
            // InternalSymg.g:2297:2: rule__Model__Group__12__Impl rule__Model__Group__13
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__12"


    // $ANTLR start "rule__Model__Group__12__Impl"
    // InternalSymg.g:2304:1: rule__Model__Group__12__Impl : ( ( rule__Model__Group_12__0 )? ) ;
    public final void rule__Model__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2308:1: ( ( ( rule__Model__Group_12__0 )? ) )
            // InternalSymg.g:2309:1: ( ( rule__Model__Group_12__0 )? )
            {
            // InternalSymg.g:2309:1: ( ( rule__Model__Group_12__0 )? )
            // InternalSymg.g:2310:2: ( rule__Model__Group_12__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_12()); 
            // InternalSymg.g:2311:2: ( rule__Model__Group_12__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==84) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSymg.g:2311:3: rule__Model__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__12__Impl"


    // $ANTLR start "rule__Model__Group__13"
    // InternalSymg.g:2319:1: rule__Model__Group__13 : rule__Model__Group__13__Impl rule__Model__Group__14 ;
    public final void rule__Model__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2323:1: ( rule__Model__Group__13__Impl rule__Model__Group__14 )
            // InternalSymg.g:2324:2: rule__Model__Group__13__Impl rule__Model__Group__14
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__13"


    // $ANTLR start "rule__Model__Group__13__Impl"
    // InternalSymg.g:2331:1: rule__Model__Group__13__Impl : ( ( rule__Model__Group_13__0 )? ) ;
    public final void rule__Model__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2335:1: ( ( ( rule__Model__Group_13__0 )? ) )
            // InternalSymg.g:2336:1: ( ( rule__Model__Group_13__0 )? )
            {
            // InternalSymg.g:2336:1: ( ( rule__Model__Group_13__0 )? )
            // InternalSymg.g:2337:2: ( rule__Model__Group_13__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_13()); 
            // InternalSymg.g:2338:2: ( rule__Model__Group_13__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==85) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSymg.g:2338:3: rule__Model__Group_13__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_13__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__13__Impl"


    // $ANTLR start "rule__Model__Group__14"
    // InternalSymg.g:2346:1: rule__Model__Group__14 : rule__Model__Group__14__Impl rule__Model__Group__15 ;
    public final void rule__Model__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2350:1: ( rule__Model__Group__14__Impl rule__Model__Group__15 )
            // InternalSymg.g:2351:2: rule__Model__Group__14__Impl rule__Model__Group__15
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__14"


    // $ANTLR start "rule__Model__Group__14__Impl"
    // InternalSymg.g:2358:1: rule__Model__Group__14__Impl : ( ( rule__Model__Group_14__0 )? ) ;
    public final void rule__Model__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2362:1: ( ( ( rule__Model__Group_14__0 )? ) )
            // InternalSymg.g:2363:1: ( ( rule__Model__Group_14__0 )? )
            {
            // InternalSymg.g:2363:1: ( ( rule__Model__Group_14__0 )? )
            // InternalSymg.g:2364:2: ( rule__Model__Group_14__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_14()); 
            // InternalSymg.g:2365:2: ( rule__Model__Group_14__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==86) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymg.g:2365:3: rule__Model__Group_14__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_14__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__14__Impl"


    // $ANTLR start "rule__Model__Group__15"
    // InternalSymg.g:2373:1: rule__Model__Group__15 : rule__Model__Group__15__Impl rule__Model__Group__16 ;
    public final void rule__Model__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2377:1: ( rule__Model__Group__15__Impl rule__Model__Group__16 )
            // InternalSymg.g:2378:2: rule__Model__Group__15__Impl rule__Model__Group__16
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__15"


    // $ANTLR start "rule__Model__Group__15__Impl"
    // InternalSymg.g:2385:1: rule__Model__Group__15__Impl : ( ( rule__Model__Group_15__0 )? ) ;
    public final void rule__Model__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2389:1: ( ( ( rule__Model__Group_15__0 )? ) )
            // InternalSymg.g:2390:1: ( ( rule__Model__Group_15__0 )? )
            {
            // InternalSymg.g:2390:1: ( ( rule__Model__Group_15__0 )? )
            // InternalSymg.g:2391:2: ( rule__Model__Group_15__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_15()); 
            // InternalSymg.g:2392:2: ( rule__Model__Group_15__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==87) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSymg.g:2392:3: rule__Model__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__15__Impl"


    // $ANTLR start "rule__Model__Group__16"
    // InternalSymg.g:2400:1: rule__Model__Group__16 : rule__Model__Group__16__Impl rule__Model__Group__17 ;
    public final void rule__Model__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2404:1: ( rule__Model__Group__16__Impl rule__Model__Group__17 )
            // InternalSymg.g:2405:2: rule__Model__Group__16__Impl rule__Model__Group__17
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__16"


    // $ANTLR start "rule__Model__Group__16__Impl"
    // InternalSymg.g:2412:1: rule__Model__Group__16__Impl : ( ( rule__Model__Group_16__0 )? ) ;
    public final void rule__Model__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2416:1: ( ( ( rule__Model__Group_16__0 )? ) )
            // InternalSymg.g:2417:1: ( ( rule__Model__Group_16__0 )? )
            {
            // InternalSymg.g:2417:1: ( ( rule__Model__Group_16__0 )? )
            // InternalSymg.g:2418:2: ( rule__Model__Group_16__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_16()); 
            // InternalSymg.g:2419:2: ( rule__Model__Group_16__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==88) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalSymg.g:2419:3: rule__Model__Group_16__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_16__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__16__Impl"


    // $ANTLR start "rule__Model__Group__17"
    // InternalSymg.g:2427:1: rule__Model__Group__17 : rule__Model__Group__17__Impl ;
    public final void rule__Model__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2431:1: ( rule__Model__Group__17__Impl )
            // InternalSymg.g:2432:2: rule__Model__Group__17__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__17__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__17"


    // $ANTLR start "rule__Model__Group__17__Impl"
    // InternalSymg.g:2438:1: rule__Model__Group__17__Impl : ( 'endContract' ) ;
    public final void rule__Model__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2442:1: ( ( 'endContract' ) )
            // InternalSymg.g:2443:1: ( 'endContract' )
            {
            // InternalSymg.g:2443:1: ( 'endContract' )
            // InternalSymg.g:2444:2: 'endContract'
            {
             before(grammarAccess.getModelAccess().getEndContractKeyword_17()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getEndContractKeyword_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__17__Impl"


    // $ANTLR start "rule__Model__Group_2__0"
    // InternalSymg.g:2454:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2458:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalSymg.g:2459:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
    // InternalSymg.g:2466:1: rule__Model__Group_2__0__Impl : ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2470:1: ( ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) )
            // InternalSymg.g:2471:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            {
            // InternalSymg.g:2471:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            // InternalSymg.g:2472:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            {
             before(grammarAccess.getModelAccess().getDomainConceptsAssignment_2_0()); 
            // InternalSymg.g:2473:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            // InternalSymg.g:2473:3: rule__Model__DomainConceptsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__DomainConceptsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDomainConceptsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // InternalSymg.g:2481:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2485:1: ( rule__Model__Group_2__1__Impl )
            // InternalSymg.g:2486:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
    // InternalSymg.g:2492:1: rule__Model__Group_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2496:1: ( ( ';' ) )
            // InternalSymg.g:2497:1: ( ';' )
            {
            // InternalSymg.g:2497:1: ( ';' )
            // InternalSymg.g:2498:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_2_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__Model__Group_7__0"
    // InternalSymg.g:2508:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2512:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalSymg.g:2513:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
            {
            pushFollow(FOLLOW_11);
            rule__Model__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__0"


    // $ANTLR start "rule__Model__Group_7__0__Impl"
    // InternalSymg.g:2520:1: rule__Model__Group_7__0__Impl : ( ( rule__Model__ParametersAssignment_7_0 ) ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2524:1: ( ( ( rule__Model__ParametersAssignment_7_0 ) ) )
            // InternalSymg.g:2525:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            {
            // InternalSymg.g:2525:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            // InternalSymg.g:2526:2: ( rule__Model__ParametersAssignment_7_0 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_7_0()); 
            // InternalSymg.g:2527:2: ( rule__Model__ParametersAssignment_7_0 )
            // InternalSymg.g:2527:3: rule__Model__ParametersAssignment_7_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__ParametersAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getParametersAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__0__Impl"


    // $ANTLR start "rule__Model__Group_7__1"
    // InternalSymg.g:2535:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2539:1: ( rule__Model__Group_7__1__Impl )
            // InternalSymg.g:2540:2: rule__Model__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__1"


    // $ANTLR start "rule__Model__Group_7__1__Impl"
    // InternalSymg.g:2546:1: rule__Model__Group_7__1__Impl : ( ',' ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2550:1: ( ( ',' ) )
            // InternalSymg.g:2551:1: ( ',' )
            {
            // InternalSymg.g:2551:1: ( ',' )
            // InternalSymg.g:2552:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_7_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__1__Impl"


    // $ANTLR start "rule__Model__Group_10__0"
    // InternalSymg.g:2562:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2566:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalSymg.g:2567:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0"


    // $ANTLR start "rule__Model__Group_10__0__Impl"
    // InternalSymg.g:2574:1: rule__Model__Group_10__0__Impl : ( 'Declarations' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2578:1: ( ( 'Declarations' ) )
            // InternalSymg.g:2579:1: ( 'Declarations' )
            {
            // InternalSymg.g:2579:1: ( 'Declarations' )
            // InternalSymg.g:2580:2: 'Declarations'
            {
             before(grammarAccess.getModelAccess().getDeclarationsKeyword_10_0()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getDeclarationsKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0__Impl"


    // $ANTLR start "rule__Model__Group_10__1"
    // InternalSymg.g:2589:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2593:1: ( rule__Model__Group_10__1__Impl )
            // InternalSymg.g:2594:2: rule__Model__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1"


    // $ANTLR start "rule__Model__Group_10__1__Impl"
    // InternalSymg.g:2600:1: rule__Model__Group_10__1__Impl : ( ( rule__Model__Group_10_1__0 )* ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2604:1: ( ( ( rule__Model__Group_10_1__0 )* ) )
            // InternalSymg.g:2605:1: ( ( rule__Model__Group_10_1__0 )* )
            {
            // InternalSymg.g:2605:1: ( ( rule__Model__Group_10_1__0 )* )
            // InternalSymg.g:2606:2: ( rule__Model__Group_10_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_10_1()); 
            // InternalSymg.g:2607:2: ( rule__Model__Group_10_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSymg.g:2607:3: rule__Model__Group_10_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_10_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1__Impl"


    // $ANTLR start "rule__Model__Group_10_1__0"
    // InternalSymg.g:2616:1: rule__Model__Group_10_1__0 : rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 ;
    public final void rule__Model__Group_10_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2620:1: ( rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 )
            // InternalSymg.g:2621:2: rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_10_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_10_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10_1__0"


    // $ANTLR start "rule__Model__Group_10_1__0__Impl"
    // InternalSymg.g:2628:1: rule__Model__Group_10_1__0__Impl : ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) ;
    public final void rule__Model__Group_10_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2632:1: ( ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) )
            // InternalSymg.g:2633:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            {
            // InternalSymg.g:2633:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            // InternalSymg.g:2634:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            {
             before(grammarAccess.getModelAccess().getDeclarationsAssignment_10_1_0()); 
            // InternalSymg.g:2635:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            // InternalSymg.g:2635:3: rule__Model__DeclarationsAssignment_10_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__DeclarationsAssignment_10_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getDeclarationsAssignment_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10_1__0__Impl"


    // $ANTLR start "rule__Model__Group_10_1__1"
    // InternalSymg.g:2643:1: rule__Model__Group_10_1__1 : rule__Model__Group_10_1__1__Impl ;
    public final void rule__Model__Group_10_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2647:1: ( rule__Model__Group_10_1__1__Impl )
            // InternalSymg.g:2648:2: rule__Model__Group_10_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_10_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10_1__1"


    // $ANTLR start "rule__Model__Group_10_1__1__Impl"
    // InternalSymg.g:2654:1: rule__Model__Group_10_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_10_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2658:1: ( ( ';' ) )
            // InternalSymg.g:2659:1: ( ';' )
            {
            // InternalSymg.g:2659:1: ( ';' )
            // InternalSymg.g:2660:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_10_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_10_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10_1__1__Impl"


    // $ANTLR start "rule__Model__Group_11__0"
    // InternalSymg.g:2670:1: rule__Model__Group_11__0 : rule__Model__Group_11__0__Impl rule__Model__Group_11__1 ;
    public final void rule__Model__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2674:1: ( rule__Model__Group_11__0__Impl rule__Model__Group_11__1 )
            // InternalSymg.g:2675:2: rule__Model__Group_11__0__Impl rule__Model__Group_11__1
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__0"


    // $ANTLR start "rule__Model__Group_11__0__Impl"
    // InternalSymg.g:2682:1: rule__Model__Group_11__0__Impl : ( 'Preconditions' ) ;
    public final void rule__Model__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2686:1: ( ( 'Preconditions' ) )
            // InternalSymg.g:2687:1: ( 'Preconditions' )
            {
            // InternalSymg.g:2687:1: ( 'Preconditions' )
            // InternalSymg.g:2688:2: 'Preconditions'
            {
             before(grammarAccess.getModelAccess().getPreconditionsKeyword_11_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getPreconditionsKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__0__Impl"


    // $ANTLR start "rule__Model__Group_11__1"
    // InternalSymg.g:2697:1: rule__Model__Group_11__1 : rule__Model__Group_11__1__Impl ;
    public final void rule__Model__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2701:1: ( rule__Model__Group_11__1__Impl )
            // InternalSymg.g:2702:2: rule__Model__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__1"


    // $ANTLR start "rule__Model__Group_11__1__Impl"
    // InternalSymg.g:2708:1: rule__Model__Group_11__1__Impl : ( ( rule__Model__Group_11_1__0 )* ) ;
    public final void rule__Model__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2712:1: ( ( ( rule__Model__Group_11_1__0 )* ) )
            // InternalSymg.g:2713:1: ( ( rule__Model__Group_11_1__0 )* )
            {
            // InternalSymg.g:2713:1: ( ( rule__Model__Group_11_1__0 )* )
            // InternalSymg.g:2714:2: ( rule__Model__Group_11_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_11_1()); 
            // InternalSymg.g:2715:2: ( rule__Model__Group_11_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_INT)||(LA30_0>=33 && LA30_0<=73)||LA30_0==77||(LA30_0>=99 && LA30_0<=100)||(LA30_0>=104 && LA30_0<=106)||LA30_0==108) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSymg.g:2715:3: rule__Model__Group_11_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Model__Group_11_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__1__Impl"


    // $ANTLR start "rule__Model__Group_11_1__0"
    // InternalSymg.g:2724:1: rule__Model__Group_11_1__0 : rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 ;
    public final void rule__Model__Group_11_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2728:1: ( rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 )
            // InternalSymg.g:2729:2: rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_11_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_11_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11_1__0"


    // $ANTLR start "rule__Model__Group_11_1__0__Impl"
    // InternalSymg.g:2736:1: rule__Model__Group_11_1__0__Impl : ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) ;
    public final void rule__Model__Group_11_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2740:1: ( ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) )
            // InternalSymg.g:2741:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            {
            // InternalSymg.g:2741:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            // InternalSymg.g:2742:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            {
             before(grammarAccess.getModelAccess().getPreconditionsAssignment_11_1_0()); 
            // InternalSymg.g:2743:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            // InternalSymg.g:2743:3: rule__Model__PreconditionsAssignment_11_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__PreconditionsAssignment_11_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPreconditionsAssignment_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11_1__0__Impl"


    // $ANTLR start "rule__Model__Group_11_1__1"
    // InternalSymg.g:2751:1: rule__Model__Group_11_1__1 : rule__Model__Group_11_1__1__Impl ;
    public final void rule__Model__Group_11_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2755:1: ( rule__Model__Group_11_1__1__Impl )
            // InternalSymg.g:2756:2: rule__Model__Group_11_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_11_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11_1__1"


    // $ANTLR start "rule__Model__Group_11_1__1__Impl"
    // InternalSymg.g:2762:1: rule__Model__Group_11_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_11_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2766:1: ( ( ';' ) )
            // InternalSymg.g:2767:1: ( ';' )
            {
            // InternalSymg.g:2767:1: ( ';' )
            // InternalSymg.g:2768:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11_1__1__Impl"


    // $ANTLR start "rule__Model__Group_12__0"
    // InternalSymg.g:2778:1: rule__Model__Group_12__0 : rule__Model__Group_12__0__Impl rule__Model__Group_12__1 ;
    public final void rule__Model__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2782:1: ( rule__Model__Group_12__0__Impl rule__Model__Group_12__1 )
            // InternalSymg.g:2783:2: rule__Model__Group_12__0__Impl rule__Model__Group_12__1
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__0"


    // $ANTLR start "rule__Model__Group_12__0__Impl"
    // InternalSymg.g:2790:1: rule__Model__Group_12__0__Impl : ( 'Postconditions' ) ;
    public final void rule__Model__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2794:1: ( ( 'Postconditions' ) )
            // InternalSymg.g:2795:1: ( 'Postconditions' )
            {
            // InternalSymg.g:2795:1: ( 'Postconditions' )
            // InternalSymg.g:2796:2: 'Postconditions'
            {
             before(grammarAccess.getModelAccess().getPostconditionsKeyword_12_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getPostconditionsKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__0__Impl"


    // $ANTLR start "rule__Model__Group_12__1"
    // InternalSymg.g:2805:1: rule__Model__Group_12__1 : rule__Model__Group_12__1__Impl ;
    public final void rule__Model__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2809:1: ( rule__Model__Group_12__1__Impl )
            // InternalSymg.g:2810:2: rule__Model__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_12__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__1"


    // $ANTLR start "rule__Model__Group_12__1__Impl"
    // InternalSymg.g:2816:1: rule__Model__Group_12__1__Impl : ( ( rule__Model__Group_12_1__0 )* ) ;
    public final void rule__Model__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2820:1: ( ( ( rule__Model__Group_12_1__0 )* ) )
            // InternalSymg.g:2821:1: ( ( rule__Model__Group_12_1__0 )* )
            {
            // InternalSymg.g:2821:1: ( ( rule__Model__Group_12_1__0 )* )
            // InternalSymg.g:2822:2: ( rule__Model__Group_12_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_12_1()); 
            // InternalSymg.g:2823:2: ( rule__Model__Group_12_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_INT)||(LA31_0>=33 && LA31_0<=73)||LA31_0==77||(LA31_0>=99 && LA31_0<=100)||(LA31_0>=104 && LA31_0<=106)||LA31_0==108) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSymg.g:2823:3: rule__Model__Group_12_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Model__Group_12_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__1__Impl"


    // $ANTLR start "rule__Model__Group_12_1__0"
    // InternalSymg.g:2832:1: rule__Model__Group_12_1__0 : rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 ;
    public final void rule__Model__Group_12_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2836:1: ( rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 )
            // InternalSymg.g:2837:2: rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_12_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_12_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12_1__0"


    // $ANTLR start "rule__Model__Group_12_1__0__Impl"
    // InternalSymg.g:2844:1: rule__Model__Group_12_1__0__Impl : ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) ;
    public final void rule__Model__Group_12_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2848:1: ( ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) )
            // InternalSymg.g:2849:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            {
            // InternalSymg.g:2849:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            // InternalSymg.g:2850:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            {
             before(grammarAccess.getModelAccess().getPostconditionsAssignment_12_1_0()); 
            // InternalSymg.g:2851:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            // InternalSymg.g:2851:3: rule__Model__PostconditionsAssignment_12_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__PostconditionsAssignment_12_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPostconditionsAssignment_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12_1__0__Impl"


    // $ANTLR start "rule__Model__Group_12_1__1"
    // InternalSymg.g:2859:1: rule__Model__Group_12_1__1 : rule__Model__Group_12_1__1__Impl ;
    public final void rule__Model__Group_12_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2863:1: ( rule__Model__Group_12_1__1__Impl )
            // InternalSymg.g:2864:2: rule__Model__Group_12_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_12_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12_1__1"


    // $ANTLR start "rule__Model__Group_12_1__1__Impl"
    // InternalSymg.g:2870:1: rule__Model__Group_12_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_12_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2874:1: ( ( ';' ) )
            // InternalSymg.g:2875:1: ( ';' )
            {
            // InternalSymg.g:2875:1: ( ';' )
            // InternalSymg.g:2876:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12_1__1__Impl"


    // $ANTLR start "rule__Model__Group_13__0"
    // InternalSymg.g:2886:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2890:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalSymg.g:2891:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0"


    // $ANTLR start "rule__Model__Group_13__0__Impl"
    // InternalSymg.g:2898:1: rule__Model__Group_13__0__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2902:1: ( ( 'Obligations' ) )
            // InternalSymg.g:2903:1: ( 'Obligations' )
            {
            // InternalSymg.g:2903:1: ( 'Obligations' )
            // InternalSymg.g:2904:2: 'Obligations'
            {
             before(grammarAccess.getModelAccess().getObligationsKeyword_13_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getObligationsKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0__Impl"


    // $ANTLR start "rule__Model__Group_13__1"
    // InternalSymg.g:2913:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2917:1: ( rule__Model__Group_13__1__Impl )
            // InternalSymg.g:2918:2: rule__Model__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1"


    // $ANTLR start "rule__Model__Group_13__1__Impl"
    // InternalSymg.g:2924:1: rule__Model__Group_13__1__Impl : ( ( rule__Model__Group_13_1__0 )* ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2928:1: ( ( ( rule__Model__Group_13_1__0 )* ) )
            // InternalSymg.g:2929:1: ( ( rule__Model__Group_13_1__0 )* )
            {
            // InternalSymg.g:2929:1: ( ( rule__Model__Group_13_1__0 )* )
            // InternalSymg.g:2930:2: ( rule__Model__Group_13_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_13_1()); 
            // InternalSymg.g:2931:2: ( rule__Model__Group_13_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSymg.g:2931:3: rule__Model__Group_13_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_13_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1__Impl"


    // $ANTLR start "rule__Model__Group_13_1__0"
    // InternalSymg.g:2940:1: rule__Model__Group_13_1__0 : rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 ;
    public final void rule__Model__Group_13_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2944:1: ( rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 )
            // InternalSymg.g:2945:2: rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_13_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_13_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13_1__0"


    // $ANTLR start "rule__Model__Group_13_1__0__Impl"
    // InternalSymg.g:2952:1: rule__Model__Group_13_1__0__Impl : ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) ;
    public final void rule__Model__Group_13_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2956:1: ( ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) )
            // InternalSymg.g:2957:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            {
            // InternalSymg.g:2957:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            // InternalSymg.g:2958:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            {
             before(grammarAccess.getModelAccess().getObligationsAssignment_13_1_0()); 
            // InternalSymg.g:2959:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            // InternalSymg.g:2959:3: rule__Model__ObligationsAssignment_13_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__ObligationsAssignment_13_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getObligationsAssignment_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13_1__0__Impl"


    // $ANTLR start "rule__Model__Group_13_1__1"
    // InternalSymg.g:2967:1: rule__Model__Group_13_1__1 : rule__Model__Group_13_1__1__Impl ;
    public final void rule__Model__Group_13_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2971:1: ( rule__Model__Group_13_1__1__Impl )
            // InternalSymg.g:2972:2: rule__Model__Group_13_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_13_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13_1__1"


    // $ANTLR start "rule__Model__Group_13_1__1__Impl"
    // InternalSymg.g:2978:1: rule__Model__Group_13_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_13_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2982:1: ( ( ';' ) )
            // InternalSymg.g:2983:1: ( ';' )
            {
            // InternalSymg.g:2983:1: ( ';' )
            // InternalSymg.g:2984:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13_1__1__Impl"


    // $ANTLR start "rule__Model__Group_14__0"
    // InternalSymg.g:2994:1: rule__Model__Group_14__0 : rule__Model__Group_14__0__Impl rule__Model__Group_14__1 ;
    public final void rule__Model__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2998:1: ( rule__Model__Group_14__0__Impl rule__Model__Group_14__1 )
            // InternalSymg.g:2999:2: rule__Model__Group_14__0__Impl rule__Model__Group_14__1
            {
            pushFollow(FOLLOW_14);
            rule__Model__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_14__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__0"


    // $ANTLR start "rule__Model__Group_14__0__Impl"
    // InternalSymg.g:3006:1: rule__Model__Group_14__0__Impl : ( 'Surviving' ) ;
    public final void rule__Model__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3010:1: ( ( 'Surviving' ) )
            // InternalSymg.g:3011:1: ( 'Surviving' )
            {
            // InternalSymg.g:3011:1: ( 'Surviving' )
            // InternalSymg.g:3012:2: 'Surviving'
            {
             before(grammarAccess.getModelAccess().getSurvivingKeyword_14_0()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSurvivingKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__0__Impl"


    // $ANTLR start "rule__Model__Group_14__1"
    // InternalSymg.g:3021:1: rule__Model__Group_14__1 : rule__Model__Group_14__1__Impl rule__Model__Group_14__2 ;
    public final void rule__Model__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3025:1: ( rule__Model__Group_14__1__Impl rule__Model__Group_14__2 )
            // InternalSymg.g:3026:2: rule__Model__Group_14__1__Impl rule__Model__Group_14__2
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_14__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__1"


    // $ANTLR start "rule__Model__Group_14__1__Impl"
    // InternalSymg.g:3033:1: rule__Model__Group_14__1__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3037:1: ( ( 'Obligations' ) )
            // InternalSymg.g:3038:1: ( 'Obligations' )
            {
            // InternalSymg.g:3038:1: ( 'Obligations' )
            // InternalSymg.g:3039:2: 'Obligations'
            {
             before(grammarAccess.getModelAccess().getObligationsKeyword_14_1()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getObligationsKeyword_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__1__Impl"


    // $ANTLR start "rule__Model__Group_14__2"
    // InternalSymg.g:3048:1: rule__Model__Group_14__2 : rule__Model__Group_14__2__Impl ;
    public final void rule__Model__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3052:1: ( rule__Model__Group_14__2__Impl )
            // InternalSymg.g:3053:2: rule__Model__Group_14__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_14__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__2"


    // $ANTLR start "rule__Model__Group_14__2__Impl"
    // InternalSymg.g:3059:1: rule__Model__Group_14__2__Impl : ( ( rule__Model__Group_14_2__0 )* ) ;
    public final void rule__Model__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3063:1: ( ( ( rule__Model__Group_14_2__0 )* ) )
            // InternalSymg.g:3064:1: ( ( rule__Model__Group_14_2__0 )* )
            {
            // InternalSymg.g:3064:1: ( ( rule__Model__Group_14_2__0 )* )
            // InternalSymg.g:3065:2: ( rule__Model__Group_14_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_14_2()); 
            // InternalSymg.g:3066:2: ( rule__Model__Group_14_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSymg.g:3066:3: rule__Model__Group_14_2__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_14_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_14_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__2__Impl"


    // $ANTLR start "rule__Model__Group_14_2__0"
    // InternalSymg.g:3075:1: rule__Model__Group_14_2__0 : rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 ;
    public final void rule__Model__Group_14_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3079:1: ( rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 )
            // InternalSymg.g:3080:2: rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_14_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_14_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14_2__0"


    // $ANTLR start "rule__Model__Group_14_2__0__Impl"
    // InternalSymg.g:3087:1: rule__Model__Group_14_2__0__Impl : ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) ;
    public final void rule__Model__Group_14_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3091:1: ( ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) )
            // InternalSymg.g:3092:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            {
            // InternalSymg.g:3092:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            // InternalSymg.g:3093:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            {
             before(grammarAccess.getModelAccess().getSobligationsAssignment_14_2_0()); 
            // InternalSymg.g:3094:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            // InternalSymg.g:3094:3: rule__Model__SobligationsAssignment_14_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__SobligationsAssignment_14_2_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getSobligationsAssignment_14_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14_2__0__Impl"


    // $ANTLR start "rule__Model__Group_14_2__1"
    // InternalSymg.g:3102:1: rule__Model__Group_14_2__1 : rule__Model__Group_14_2__1__Impl ;
    public final void rule__Model__Group_14_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3106:1: ( rule__Model__Group_14_2__1__Impl )
            // InternalSymg.g:3107:2: rule__Model__Group_14_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_14_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14_2__1"


    // $ANTLR start "rule__Model__Group_14_2__1__Impl"
    // InternalSymg.g:3113:1: rule__Model__Group_14_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_14_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3117:1: ( ( ';' ) )
            // InternalSymg.g:3118:1: ( ';' )
            {
            // InternalSymg.g:3118:1: ( ';' )
            // InternalSymg.g:3119:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_14_2_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_14_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14_2__1__Impl"


    // $ANTLR start "rule__Model__Group_15__0"
    // InternalSymg.g:3129:1: rule__Model__Group_15__0 : rule__Model__Group_15__0__Impl rule__Model__Group_15__1 ;
    public final void rule__Model__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3133:1: ( rule__Model__Group_15__0__Impl rule__Model__Group_15__1 )
            // InternalSymg.g:3134:2: rule__Model__Group_15__0__Impl rule__Model__Group_15__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15__0"


    // $ANTLR start "rule__Model__Group_15__0__Impl"
    // InternalSymg.g:3141:1: rule__Model__Group_15__0__Impl : ( 'Powers' ) ;
    public final void rule__Model__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3145:1: ( ( 'Powers' ) )
            // InternalSymg.g:3146:1: ( 'Powers' )
            {
            // InternalSymg.g:3146:1: ( 'Powers' )
            // InternalSymg.g:3147:2: 'Powers'
            {
             before(grammarAccess.getModelAccess().getPowersKeyword_15_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getPowersKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15__0__Impl"


    // $ANTLR start "rule__Model__Group_15__1"
    // InternalSymg.g:3156:1: rule__Model__Group_15__1 : rule__Model__Group_15__1__Impl ;
    public final void rule__Model__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3160:1: ( rule__Model__Group_15__1__Impl )
            // InternalSymg.g:3161:2: rule__Model__Group_15__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_15__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15__1"


    // $ANTLR start "rule__Model__Group_15__1__Impl"
    // InternalSymg.g:3167:1: rule__Model__Group_15__1__Impl : ( ( rule__Model__Group_15_1__0 )* ) ;
    public final void rule__Model__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3171:1: ( ( ( rule__Model__Group_15_1__0 )* ) )
            // InternalSymg.g:3172:1: ( ( rule__Model__Group_15_1__0 )* )
            {
            // InternalSymg.g:3172:1: ( ( rule__Model__Group_15_1__0 )* )
            // InternalSymg.g:3173:2: ( rule__Model__Group_15_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_15_1()); 
            // InternalSymg.g:3174:2: ( rule__Model__Group_15_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSymg.g:3174:3: rule__Model__Group_15_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Model__Group_15_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15__1__Impl"


    // $ANTLR start "rule__Model__Group_15_1__0"
    // InternalSymg.g:3183:1: rule__Model__Group_15_1__0 : rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 ;
    public final void rule__Model__Group_15_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3187:1: ( rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 )
            // InternalSymg.g:3188:2: rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_15_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_15_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15_1__0"


    // $ANTLR start "rule__Model__Group_15_1__0__Impl"
    // InternalSymg.g:3195:1: rule__Model__Group_15_1__0__Impl : ( ( rule__Model__PowersAssignment_15_1_0 ) ) ;
    public final void rule__Model__Group_15_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3199:1: ( ( ( rule__Model__PowersAssignment_15_1_0 ) ) )
            // InternalSymg.g:3200:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            {
            // InternalSymg.g:3200:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            // InternalSymg.g:3201:2: ( rule__Model__PowersAssignment_15_1_0 )
            {
             before(grammarAccess.getModelAccess().getPowersAssignment_15_1_0()); 
            // InternalSymg.g:3202:2: ( rule__Model__PowersAssignment_15_1_0 )
            // InternalSymg.g:3202:3: rule__Model__PowersAssignment_15_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__PowersAssignment_15_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getPowersAssignment_15_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15_1__0__Impl"


    // $ANTLR start "rule__Model__Group_15_1__1"
    // InternalSymg.g:3210:1: rule__Model__Group_15_1__1 : rule__Model__Group_15_1__1__Impl ;
    public final void rule__Model__Group_15_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3214:1: ( rule__Model__Group_15_1__1__Impl )
            // InternalSymg.g:3215:2: rule__Model__Group_15_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_15_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15_1__1"


    // $ANTLR start "rule__Model__Group_15_1__1__Impl"
    // InternalSymg.g:3221:1: rule__Model__Group_15_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_15_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3225:1: ( ( ';' ) )
            // InternalSymg.g:3226:1: ( ';' )
            {
            // InternalSymg.g:3226:1: ( ';' )
            // InternalSymg.g:3227:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_15_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_15_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_15_1__1__Impl"


    // $ANTLR start "rule__Model__Group_16__0"
    // InternalSymg.g:3237:1: rule__Model__Group_16__0 : rule__Model__Group_16__0__Impl rule__Model__Group_16__1 ;
    public final void rule__Model__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3241:1: ( rule__Model__Group_16__0__Impl rule__Model__Group_16__1 )
            // InternalSymg.g:3242:2: rule__Model__Group_16__0__Impl rule__Model__Group_16__1
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group_16__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_16__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16__0"


    // $ANTLR start "rule__Model__Group_16__0__Impl"
    // InternalSymg.g:3249:1: rule__Model__Group_16__0__Impl : ( 'Constraints' ) ;
    public final void rule__Model__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3253:1: ( ( 'Constraints' ) )
            // InternalSymg.g:3254:1: ( 'Constraints' )
            {
            // InternalSymg.g:3254:1: ( 'Constraints' )
            // InternalSymg.g:3255:2: 'Constraints'
            {
             before(grammarAccess.getModelAccess().getConstraintsKeyword_16_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getConstraintsKeyword_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16__0__Impl"


    // $ANTLR start "rule__Model__Group_16__1"
    // InternalSymg.g:3264:1: rule__Model__Group_16__1 : rule__Model__Group_16__1__Impl ;
    public final void rule__Model__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3268:1: ( rule__Model__Group_16__1__Impl )
            // InternalSymg.g:3269:2: rule__Model__Group_16__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_16__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16__1"


    // $ANTLR start "rule__Model__Group_16__1__Impl"
    // InternalSymg.g:3275:1: rule__Model__Group_16__1__Impl : ( ( rule__Model__Group_16_1__0 )* ) ;
    public final void rule__Model__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3279:1: ( ( ( rule__Model__Group_16_1__0 )* ) )
            // InternalSymg.g:3280:1: ( ( rule__Model__Group_16_1__0 )* )
            {
            // InternalSymg.g:3280:1: ( ( rule__Model__Group_16_1__0 )* )
            // InternalSymg.g:3281:2: ( rule__Model__Group_16_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_16_1()); 
            // InternalSymg.g:3282:2: ( rule__Model__Group_16_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_INT)||(LA35_0>=33 && LA35_0<=73)||LA35_0==77||(LA35_0>=99 && LA35_0<=100)||(LA35_0>=104 && LA35_0<=106)||LA35_0==108) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSymg.g:3282:3: rule__Model__Group_16_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Model__Group_16_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_16_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16__1__Impl"


    // $ANTLR start "rule__Model__Group_16_1__0"
    // InternalSymg.g:3291:1: rule__Model__Group_16_1__0 : rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 ;
    public final void rule__Model__Group_16_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3295:1: ( rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 )
            // InternalSymg.g:3296:2: rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Model__Group_16_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_16_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16_1__0"


    // $ANTLR start "rule__Model__Group_16_1__0__Impl"
    // InternalSymg.g:3303:1: rule__Model__Group_16_1__0__Impl : ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) ;
    public final void rule__Model__Group_16_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3307:1: ( ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) )
            // InternalSymg.g:3308:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            {
            // InternalSymg.g:3308:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            // InternalSymg.g:3309:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            {
             before(grammarAccess.getModelAccess().getConstraintsAssignment_16_1_0()); 
            // InternalSymg.g:3310:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            // InternalSymg.g:3310:3: rule__Model__ConstraintsAssignment_16_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Model__ConstraintsAssignment_16_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getConstraintsAssignment_16_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16_1__0__Impl"


    // $ANTLR start "rule__Model__Group_16_1__1"
    // InternalSymg.g:3318:1: rule__Model__Group_16_1__1 : rule__Model__Group_16_1__1__Impl ;
    public final void rule__Model__Group_16_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3322:1: ( rule__Model__Group_16_1__1__Impl )
            // InternalSymg.g:3323:2: rule__Model__Group_16_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_16_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16_1__1"


    // $ANTLR start "rule__Model__Group_16_1__1__Impl"
    // InternalSymg.g:3329:1: rule__Model__Group_16_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_16_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3333:1: ( ( ';' ) )
            // InternalSymg.g:3334:1: ( ';' )
            {
            // InternalSymg.g:3334:1: ( ';' )
            // InternalSymg.g:3335:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_16_1__1__Impl"


    // $ANTLR start "rule__Regular__Group__0"
    // InternalSymg.g:3345:1: rule__Regular__Group__0 : rule__Regular__Group__0__Impl rule__Regular__Group__1 ;
    public final void rule__Regular__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3349:1: ( rule__Regular__Group__0__Impl rule__Regular__Group__1 )
            // InternalSymg.g:3350:2: rule__Regular__Group__0__Impl rule__Regular__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Regular__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__0"


    // $ANTLR start "rule__Regular__Group__0__Impl"
    // InternalSymg.g:3357:1: rule__Regular__Group__0__Impl : ( ( rule__Regular__NameAssignment_0 ) ) ;
    public final void rule__Regular__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3361:1: ( ( ( rule__Regular__NameAssignment_0 ) ) )
            // InternalSymg.g:3362:1: ( ( rule__Regular__NameAssignment_0 ) )
            {
            // InternalSymg.g:3362:1: ( ( rule__Regular__NameAssignment_0 ) )
            // InternalSymg.g:3363:2: ( rule__Regular__NameAssignment_0 )
            {
             before(grammarAccess.getRegularAccess().getNameAssignment_0()); 
            // InternalSymg.g:3364:2: ( rule__Regular__NameAssignment_0 )
            // InternalSymg.g:3364:3: rule__Regular__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Regular__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRegularAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__0__Impl"


    // $ANTLR start "rule__Regular__Group__1"
    // InternalSymg.g:3372:1: rule__Regular__Group__1 : rule__Regular__Group__1__Impl rule__Regular__Group__2 ;
    public final void rule__Regular__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3376:1: ( rule__Regular__Group__1__Impl rule__Regular__Group__2 )
            // InternalSymg.g:3377:2: rule__Regular__Group__1__Impl rule__Regular__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__Regular__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__1"


    // $ANTLR start "rule__Regular__Group__1__Impl"
    // InternalSymg.g:3384:1: rule__Regular__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Regular__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3388:1: ( ( 'isA' ) )
            // InternalSymg.g:3389:1: ( 'isA' )
            {
            // InternalSymg.g:3389:1: ( 'isA' )
            // InternalSymg.g:3390:2: 'isA'
            {
             before(grammarAccess.getRegularAccess().getIsAKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getRegularAccess().getIsAKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__1__Impl"


    // $ANTLR start "rule__Regular__Group__2"
    // InternalSymg.g:3399:1: rule__Regular__Group__2 : rule__Regular__Group__2__Impl rule__Regular__Group__3 ;
    public final void rule__Regular__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3403:1: ( rule__Regular__Group__2__Impl rule__Regular__Group__3 )
            // InternalSymg.g:3404:2: rule__Regular__Group__2__Impl rule__Regular__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Regular__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__2"


    // $ANTLR start "rule__Regular__Group__2__Impl"
    // InternalSymg.g:3411:1: rule__Regular__Group__2__Impl : ( ( rule__Regular__ConceptTypeAssignment_2 ) ) ;
    public final void rule__Regular__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3415:1: ( ( ( rule__Regular__ConceptTypeAssignment_2 ) ) )
            // InternalSymg.g:3416:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            {
            // InternalSymg.g:3416:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            // InternalSymg.g:3417:2: ( rule__Regular__ConceptTypeAssignment_2 )
            {
             before(grammarAccess.getRegularAccess().getConceptTypeAssignment_2()); 
            // InternalSymg.g:3418:2: ( rule__Regular__ConceptTypeAssignment_2 )
            // InternalSymg.g:3418:3: rule__Regular__ConceptTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Regular__ConceptTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRegularAccess().getConceptTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__2__Impl"


    // $ANTLR start "rule__Regular__Group__3"
    // InternalSymg.g:3426:1: rule__Regular__Group__3 : rule__Regular__Group__3__Impl ;
    public final void rule__Regular__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3430:1: ( rule__Regular__Group__3__Impl )
            // InternalSymg.g:3431:2: rule__Regular__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Regular__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__3"


    // $ANTLR start "rule__Regular__Group__3__Impl"
    // InternalSymg.g:3437:1: rule__Regular__Group__3__Impl : ( ( rule__Regular__Group_3__0 )? ) ;
    public final void rule__Regular__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3441:1: ( ( ( rule__Regular__Group_3__0 )? ) )
            // InternalSymg.g:3442:1: ( ( rule__Regular__Group_3__0 )? )
            {
            // InternalSymg.g:3442:1: ( ( rule__Regular__Group_3__0 )? )
            // InternalSymg.g:3443:2: ( rule__Regular__Group_3__0 )?
            {
             before(grammarAccess.getRegularAccess().getGroup_3()); 
            // InternalSymg.g:3444:2: ( rule__Regular__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==90) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalSymg.g:3444:3: rule__Regular__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Regular__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRegularAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group__3__Impl"


    // $ANTLR start "rule__Regular__Group_3__0"
    // InternalSymg.g:3453:1: rule__Regular__Group_3__0 : rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 ;
    public final void rule__Regular__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3457:1: ( rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 )
            // InternalSymg.g:3458:2: rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Regular__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__0"


    // $ANTLR start "rule__Regular__Group_3__0__Impl"
    // InternalSymg.g:3465:1: rule__Regular__Group_3__0__Impl : ( 'with' ) ;
    public final void rule__Regular__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3469:1: ( ( 'with' ) )
            // InternalSymg.g:3470:1: ( 'with' )
            {
            // InternalSymg.g:3470:1: ( 'with' )
            // InternalSymg.g:3471:2: 'with'
            {
             before(grammarAccess.getRegularAccess().getWithKeyword_3_0()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getRegularAccess().getWithKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__0__Impl"


    // $ANTLR start "rule__Regular__Group_3__1"
    // InternalSymg.g:3480:1: rule__Regular__Group_3__1 : rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 ;
    public final void rule__Regular__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3484:1: ( rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 )
            // InternalSymg.g:3485:2: rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2
            {
            pushFollow(FOLLOW_3);
            rule__Regular__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__1"


    // $ANTLR start "rule__Regular__Group_3__1__Impl"
    // InternalSymg.g:3492:1: rule__Regular__Group_3__1__Impl : ( ( rule__Regular__Group_3_1__0 )* ) ;
    public final void rule__Regular__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3496:1: ( ( ( rule__Regular__Group_3_1__0 )* ) )
            // InternalSymg.g:3497:1: ( ( rule__Regular__Group_3_1__0 )* )
            {
            // InternalSymg.g:3497:1: ( ( rule__Regular__Group_3_1__0 )* )
            // InternalSymg.g:3498:2: ( rule__Regular__Group_3_1__0 )*
            {
             before(grammarAccess.getRegularAccess().getGroup_3_1()); 
            // InternalSymg.g:3499:2: ( rule__Regular__Group_3_1__0 )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // InternalSymg.g:3499:3: rule__Regular__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Regular__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getRegularAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__1__Impl"


    // $ANTLR start "rule__Regular__Group_3__2"
    // InternalSymg.g:3507:1: rule__Regular__Group_3__2 : rule__Regular__Group_3__2__Impl ;
    public final void rule__Regular__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3511:1: ( rule__Regular__Group_3__2__Impl )
            // InternalSymg.g:3512:2: rule__Regular__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Regular__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__2"


    // $ANTLR start "rule__Regular__Group_3__2__Impl"
    // InternalSymg.g:3518:1: rule__Regular__Group_3__2__Impl : ( ( rule__Regular__AttributesAssignment_3_2 ) ) ;
    public final void rule__Regular__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3522:1: ( ( ( rule__Regular__AttributesAssignment_3_2 ) ) )
            // InternalSymg.g:3523:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            {
            // InternalSymg.g:3523:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            // InternalSymg.g:3524:2: ( rule__Regular__AttributesAssignment_3_2 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_2()); 
            // InternalSymg.g:3525:2: ( rule__Regular__AttributesAssignment_3_2 )
            // InternalSymg.g:3525:3: rule__Regular__AttributesAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Regular__AttributesAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getRegularAccess().getAttributesAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3__2__Impl"


    // $ANTLR start "rule__Regular__Group_3_1__0"
    // InternalSymg.g:3534:1: rule__Regular__Group_3_1__0 : rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 ;
    public final void rule__Regular__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3538:1: ( rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 )
            // InternalSymg.g:3539:2: rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1
            {
            pushFollow(FOLLOW_11);
            rule__Regular__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Regular__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3_1__0"


    // $ANTLR start "rule__Regular__Group_3_1__0__Impl"
    // InternalSymg.g:3546:1: rule__Regular__Group_3_1__0__Impl : ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) ;
    public final void rule__Regular__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3550:1: ( ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) )
            // InternalSymg.g:3551:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            {
            // InternalSymg.g:3551:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            // InternalSymg.g:3552:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_1_0()); 
            // InternalSymg.g:3553:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            // InternalSymg.g:3553:3: rule__Regular__AttributesAssignment_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Regular__AttributesAssignment_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRegularAccess().getAttributesAssignment_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3_1__0__Impl"


    // $ANTLR start "rule__Regular__Group_3_1__1"
    // InternalSymg.g:3561:1: rule__Regular__Group_3_1__1 : rule__Regular__Group_3_1__1__Impl ;
    public final void rule__Regular__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3565:1: ( rule__Regular__Group_3_1__1__Impl )
            // InternalSymg.g:3566:2: rule__Regular__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Regular__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3_1__1"


    // $ANTLR start "rule__Regular__Group_3_1__1__Impl"
    // InternalSymg.g:3572:1: rule__Regular__Group_3_1__1__Impl : ( ',' ) ;
    public final void rule__Regular__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3576:1: ( ( ',' ) )
            // InternalSymg.g:3577:1: ( ',' )
            {
            // InternalSymg.g:3577:1: ( ',' )
            // InternalSymg.g:3578:2: ','
            {
             before(grammarAccess.getRegularAccess().getCommaKeyword_3_1_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getRegularAccess().getCommaKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__Group_3_1__1__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalSymg.g:3588:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3592:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalSymg.g:3593:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalSymg.g:3600:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3604:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalSymg.g:3605:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalSymg.g:3605:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalSymg.g:3606:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalSymg.g:3607:2: ( rule__Attribute__NameAssignment_0 )
            // InternalSymg.g:3607:3: rule__Attribute__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalSymg.g:3615:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3619:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalSymg.g:3620:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalSymg.g:3627:1: rule__Attribute__Group__1__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3631:1: ( ( ':' ) )
            // InternalSymg.g:3632:1: ( ':' )
            {
            // InternalSymg.g:3632:1: ( ':' )
            // InternalSymg.g:3633:2: ':'
            {
             before(grammarAccess.getAttributeAccess().getColonKeyword_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalSymg.g:3642:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3646:1: ( rule__Attribute__Group__2__Impl )
            // InternalSymg.g:3647:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalSymg.g:3653:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3657:1: ( ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) )
            // InternalSymg.g:3658:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            {
            // InternalSymg.g:3658:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            // InternalSymg.g:3659:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_2()); 
            // InternalSymg.g:3660:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            // InternalSymg.g:3660:3: rule__Attribute__AttributeTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__AttributeTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Enumeration__Group__0"
    // InternalSymg.g:3669:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3673:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalSymg.g:3674:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Enumeration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__0"


    // $ANTLR start "rule__Enumeration__Group__0__Impl"
    // InternalSymg.g:3681:1: rule__Enumeration__Group__0__Impl : ( ( rule__Enumeration__NameAssignment_0 ) ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3685:1: ( ( ( rule__Enumeration__NameAssignment_0 ) ) )
            // InternalSymg.g:3686:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            {
            // InternalSymg.g:3686:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            // InternalSymg.g:3687:2: ( rule__Enumeration__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_0()); 
            // InternalSymg.g:3688:2: ( rule__Enumeration__NameAssignment_0 )
            // InternalSymg.g:3688:3: rule__Enumeration__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__0__Impl"


    // $ANTLR start "rule__Enumeration__Group__1"
    // InternalSymg.g:3696:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3700:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalSymg.g:3701:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__Enumeration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__1"


    // $ANTLR start "rule__Enumeration__Group__1__Impl"
    // InternalSymg.g:3708:1: rule__Enumeration__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3712:1: ( ( 'isA' ) )
            // InternalSymg.g:3713:1: ( 'isA' )
            {
            // InternalSymg.g:3713:1: ( 'isA' )
            // InternalSymg.g:3714:2: 'isA'
            {
             before(grammarAccess.getEnumerationAccess().getIsAKeyword_1()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getIsAKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__1__Impl"


    // $ANTLR start "rule__Enumeration__Group__2"
    // InternalSymg.g:3723:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3727:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalSymg.g:3728:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Enumeration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__2"


    // $ANTLR start "rule__Enumeration__Group__2__Impl"
    // InternalSymg.g:3735:1: rule__Enumeration__Group__2__Impl : ( 'Enumeration' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3739:1: ( ( 'Enumeration' ) )
            // InternalSymg.g:3740:1: ( 'Enumeration' )
            {
            // InternalSymg.g:3740:1: ( 'Enumeration' )
            // InternalSymg.g:3741:2: 'Enumeration'
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationKeyword_2()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getEnumerationKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__2__Impl"


    // $ANTLR start "rule__Enumeration__Group__3"
    // InternalSymg.g:3750:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3754:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalSymg.g:3755:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Enumeration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__3"


    // $ANTLR start "rule__Enumeration__Group__3__Impl"
    // InternalSymg.g:3762:1: rule__Enumeration__Group__3__Impl : ( '(' ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3766:1: ( ( '(' ) )
            // InternalSymg.g:3767:1: ( '(' )
            {
            // InternalSymg.g:3767:1: ( '(' )
            // InternalSymg.g:3768:2: '('
            {
             before(grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__3__Impl"


    // $ANTLR start "rule__Enumeration__Group__4"
    // InternalSymg.g:3777:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3781:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalSymg.g:3782:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Enumeration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__4"


    // $ANTLR start "rule__Enumeration__Group__4__Impl"
    // InternalSymg.g:3789:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3793:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalSymg.g:3794:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalSymg.g:3794:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalSymg.g:3795:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalSymg.g:3796:2: ( rule__Enumeration__Group_4__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    int LA38_1 = input.LA(2);

                    if ( (LA38_1==81) ) {
                        alt38=1;
                    }


                }


                switch (alt38) {
            	case 1 :
            	    // InternalSymg.g:3796:3: rule__Enumeration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Enumeration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getEnumerationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__4__Impl"


    // $ANTLR start "rule__Enumeration__Group__5"
    // InternalSymg.g:3804:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3808:1: ( rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 )
            // InternalSymg.g:3809:2: rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Enumeration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__5"


    // $ANTLR start "rule__Enumeration__Group__5__Impl"
    // InternalSymg.g:3816:1: rule__Enumeration__Group__5__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3820:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) )
            // InternalSymg.g:3821:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            {
            // InternalSymg.g:3821:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            // InternalSymg.g:3822:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_5()); 
            // InternalSymg.g:3823:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            // InternalSymg.g:3823:3: rule__Enumeration__EnumerationItemsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__EnumerationItemsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__5__Impl"


    // $ANTLR start "rule__Enumeration__Group__6"
    // InternalSymg.g:3831:1: rule__Enumeration__Group__6 : rule__Enumeration__Group__6__Impl ;
    public final void rule__Enumeration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3835:1: ( rule__Enumeration__Group__6__Impl )
            // InternalSymg.g:3836:2: rule__Enumeration__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__6"


    // $ANTLR start "rule__Enumeration__Group__6__Impl"
    // InternalSymg.g:3842:1: rule__Enumeration__Group__6__Impl : ( ')' ) ;
    public final void rule__Enumeration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3846:1: ( ( ')' ) )
            // InternalSymg.g:3847:1: ( ')' )
            {
            // InternalSymg.g:3847:1: ( ')' )
            // InternalSymg.g:3848:2: ')'
            {
             before(grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group__6__Impl"


    // $ANTLR start "rule__Enumeration__Group_4__0"
    // InternalSymg.g:3858:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3862:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalSymg.g:3863:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__Enumeration__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__0"


    // $ANTLR start "rule__Enumeration__Group_4__0__Impl"
    // InternalSymg.g:3870:1: rule__Enumeration__Group_4__0__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3874:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) )
            // InternalSymg.g:3875:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            {
            // InternalSymg.g:3875:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            // InternalSymg.g:3876:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_4_0()); 
            // InternalSymg.g:3877:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            // InternalSymg.g:3877:3: rule__Enumeration__EnumerationItemsAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__EnumerationItemsAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__0__Impl"


    // $ANTLR start "rule__Enumeration__Group_4__1"
    // InternalSymg.g:3885:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3889:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalSymg.g:3890:2: rule__Enumeration__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumeration__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__1"


    // $ANTLR start "rule__Enumeration__Group_4__1__Impl"
    // InternalSymg.g:3896:1: rule__Enumeration__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3900:1: ( ( ',' ) )
            // InternalSymg.g:3901:1: ( ',' )
            {
            // InternalSymg.g:3901:1: ( ',' )
            // InternalSymg.g:3902:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_4_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getCommaKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__Group_4__1__Impl"


    // $ANTLR start "rule__EnumItem__Group__0"
    // InternalSymg.g:3912:1: rule__EnumItem__Group__0 : rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 ;
    public final void rule__EnumItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3916:1: ( rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 )
            // InternalSymg.g:3917:2: rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EnumItem__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumItem__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumItem__Group__0"


    // $ANTLR start "rule__EnumItem__Group__0__Impl"
    // InternalSymg.g:3924:1: rule__EnumItem__Group__0__Impl : ( () ) ;
    public final void rule__EnumItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3928:1: ( ( () ) )
            // InternalSymg.g:3929:1: ( () )
            {
            // InternalSymg.g:3929:1: ( () )
            // InternalSymg.g:3930:2: ()
            {
             before(grammarAccess.getEnumItemAccess().getEnumItemAction_0()); 
            // InternalSymg.g:3931:2: ()
            // InternalSymg.g:3931:3: 
            {
            }

             after(grammarAccess.getEnumItemAccess().getEnumItemAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumItem__Group__0__Impl"


    // $ANTLR start "rule__EnumItem__Group__1"
    // InternalSymg.g:3939:1: rule__EnumItem__Group__1 : rule__EnumItem__Group__1__Impl ;
    public final void rule__EnumItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3943:1: ( rule__EnumItem__Group__1__Impl )
            // InternalSymg.g:3944:2: rule__EnumItem__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumItem__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumItem__Group__1"


    // $ANTLR start "rule__EnumItem__Group__1__Impl"
    // InternalSymg.g:3950:1: rule__EnumItem__Group__1__Impl : ( ( rule__EnumItem__NameAssignment_1 ) ) ;
    public final void rule__EnumItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3954:1: ( ( ( rule__EnumItem__NameAssignment_1 ) ) )
            // InternalSymg.g:3955:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            {
            // InternalSymg.g:3955:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            // InternalSymg.g:3956:2: ( rule__EnumItem__NameAssignment_1 )
            {
             before(grammarAccess.getEnumItemAccess().getNameAssignment_1()); 
            // InternalSymg.g:3957:2: ( rule__EnumItem__NameAssignment_1 )
            // InternalSymg.g:3957:3: rule__EnumItem__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumItem__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumItemAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumItem__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // InternalSymg.g:3966:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3970:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalSymg.g:3971:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // InternalSymg.g:3978:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3982:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalSymg.g:3983:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalSymg.g:3983:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalSymg.g:3984:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalSymg.g:3985:2: ( rule__Parameter__NameAssignment_0 )
            // InternalSymg.g:3985:3: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // InternalSymg.g:3993:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3997:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalSymg.g:3998:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // InternalSymg.g:4005:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4009:1: ( ( ':' ) )
            // InternalSymg.g:4010:1: ( ':' )
            {
            // InternalSymg.g:4010:1: ( ':' )
            // InternalSymg.g:4011:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // InternalSymg.g:4020:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4024:1: ( rule__Parameter__Group__2__Impl )
            // InternalSymg.g:4025:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // InternalSymg.g:4031:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__TypeAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4035:1: ( ( ( rule__Parameter__TypeAssignment_2 ) ) )
            // InternalSymg.g:4036:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            {
            // InternalSymg.g:4036:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            // InternalSymg.g:4037:2: ( rule__Parameter__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_2()); 
            // InternalSymg.g:4038:2: ( rule__Parameter__TypeAssignment_2 )
            // InternalSymg.g:4038:3: rule__Parameter__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__DeclarPair__Group__0"
    // InternalSymg.g:4047:1: rule__DeclarPair__Group__0 : rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 ;
    public final void rule__DeclarPair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4051:1: ( rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 )
            // InternalSymg.g:4052:2: rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__DeclarPair__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeclarPair__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__0"


    // $ANTLR start "rule__DeclarPair__Group__0__Impl"
    // InternalSymg.g:4059:1: rule__DeclarPair__Group__0__Impl : ( ( rule__DeclarPair__AttrAssignment_0 ) ) ;
    public final void rule__DeclarPair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4063:1: ( ( ( rule__DeclarPair__AttrAssignment_0 ) ) )
            // InternalSymg.g:4064:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            {
            // InternalSymg.g:4064:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            // InternalSymg.g:4065:2: ( rule__DeclarPair__AttrAssignment_0 )
            {
             before(grammarAccess.getDeclarPairAccess().getAttrAssignment_0()); 
            // InternalSymg.g:4066:2: ( rule__DeclarPair__AttrAssignment_0 )
            // InternalSymg.g:4066:3: rule__DeclarPair__AttrAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DeclarPair__AttrAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarPairAccess().getAttrAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__0__Impl"


    // $ANTLR start "rule__DeclarPair__Group__1"
    // InternalSymg.g:4074:1: rule__DeclarPair__Group__1 : rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 ;
    public final void rule__DeclarPair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4078:1: ( rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 )
            // InternalSymg.g:4079:2: rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__DeclarPair__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeclarPair__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__1"


    // $ANTLR start "rule__DeclarPair__Group__1__Impl"
    // InternalSymg.g:4086:1: rule__DeclarPair__Group__1__Impl : ( ':=' ) ;
    public final void rule__DeclarPair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4090:1: ( ( ':=' ) )
            // InternalSymg.g:4091:1: ( ':=' )
            {
            // InternalSymg.g:4091:1: ( ':=' )
            // InternalSymg.g:4092:2: ':='
            {
             before(grammarAccess.getDeclarPairAccess().getColonEqualsSignKeyword_1()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getDeclarPairAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__1__Impl"


    // $ANTLR start "rule__DeclarPair__Group__2"
    // InternalSymg.g:4101:1: rule__DeclarPair__Group__2 : rule__DeclarPair__Group__2__Impl ;
    public final void rule__DeclarPair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4105:1: ( rule__DeclarPair__Group__2__Impl )
            // InternalSymg.g:4106:2: rule__DeclarPair__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeclarPair__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__2"


    // $ANTLR start "rule__DeclarPair__Group__2__Impl"
    // InternalSymg.g:4112:1: rule__DeclarPair__Group__2__Impl : ( ( rule__DeclarPair__ParamAssignment_2 ) ) ;
    public final void rule__DeclarPair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4116:1: ( ( ( rule__DeclarPair__ParamAssignment_2 ) ) )
            // InternalSymg.g:4117:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            {
            // InternalSymg.g:4117:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            // InternalSymg.g:4118:2: ( rule__DeclarPair__ParamAssignment_2 )
            {
             before(grammarAccess.getDeclarPairAccess().getParamAssignment_2()); 
            // InternalSymg.g:4119:2: ( rule__DeclarPair__ParamAssignment_2 )
            // InternalSymg.g:4119:3: rule__DeclarPair__ParamAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DeclarPair__ParamAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDeclarPairAccess().getParamAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__Group__2__Impl"


    // $ANTLR start "rule__Declar__Group__0"
    // InternalSymg.g:4128:1: rule__Declar__Group__0 : rule__Declar__Group__0__Impl rule__Declar__Group__1 ;
    public final void rule__Declar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4132:1: ( rule__Declar__Group__0__Impl rule__Declar__Group__1 )
            // InternalSymg.g:4133:2: rule__Declar__Group__0__Impl rule__Declar__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Declar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__0"


    // $ANTLR start "rule__Declar__Group__0__Impl"
    // InternalSymg.g:4140:1: rule__Declar__Group__0__Impl : ( ( rule__Declar__NameAssignment_0 ) ) ;
    public final void rule__Declar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4144:1: ( ( ( rule__Declar__NameAssignment_0 ) ) )
            // InternalSymg.g:4145:1: ( ( rule__Declar__NameAssignment_0 ) )
            {
            // InternalSymg.g:4145:1: ( ( rule__Declar__NameAssignment_0 ) )
            // InternalSymg.g:4146:2: ( rule__Declar__NameAssignment_0 )
            {
             before(grammarAccess.getDeclarAccess().getNameAssignment_0()); 
            // InternalSymg.g:4147:2: ( rule__Declar__NameAssignment_0 )
            // InternalSymg.g:4147:3: rule__Declar__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Declar__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__0__Impl"


    // $ANTLR start "rule__Declar__Group__1"
    // InternalSymg.g:4155:1: rule__Declar__Group__1 : rule__Declar__Group__1__Impl rule__Declar__Group__2 ;
    public final void rule__Declar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4159:1: ( rule__Declar__Group__1__Impl rule__Declar__Group__2 )
            // InternalSymg.g:4160:2: rule__Declar__Group__1__Impl rule__Declar__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__Declar__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__1"


    // $ANTLR start "rule__Declar__Group__1__Impl"
    // InternalSymg.g:4167:1: rule__Declar__Group__1__Impl : ( ':' ) ;
    public final void rule__Declar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4171:1: ( ( ':' ) )
            // InternalSymg.g:4172:1: ( ':' )
            {
            // InternalSymg.g:4172:1: ( ':' )
            // InternalSymg.g:4173:2: ':'
            {
             before(grammarAccess.getDeclarAccess().getColonKeyword_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getDeclarAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__1__Impl"


    // $ANTLR start "rule__Declar__Group__2"
    // InternalSymg.g:4182:1: rule__Declar__Group__2 : rule__Declar__Group__2__Impl rule__Declar__Group__3 ;
    public final void rule__Declar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4186:1: ( rule__Declar__Group__2__Impl rule__Declar__Group__3 )
            // InternalSymg.g:4187:2: rule__Declar__Group__2__Impl rule__Declar__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__Declar__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__2"


    // $ANTLR start "rule__Declar__Group__2__Impl"
    // InternalSymg.g:4194:1: rule__Declar__Group__2__Impl : ( ( rule__Declar__TypeAssignment_2 ) ) ;
    public final void rule__Declar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4198:1: ( ( ( rule__Declar__TypeAssignment_2 ) ) )
            // InternalSymg.g:4199:1: ( ( rule__Declar__TypeAssignment_2 ) )
            {
            // InternalSymg.g:4199:1: ( ( rule__Declar__TypeAssignment_2 ) )
            // InternalSymg.g:4200:2: ( rule__Declar__TypeAssignment_2 )
            {
             before(grammarAccess.getDeclarAccess().getTypeAssignment_2()); 
            // InternalSymg.g:4201:2: ( rule__Declar__TypeAssignment_2 )
            // InternalSymg.g:4201:3: rule__Declar__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Declar__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDeclarAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__2__Impl"


    // $ANTLR start "rule__Declar__Group__3"
    // InternalSymg.g:4209:1: rule__Declar__Group__3 : rule__Declar__Group__3__Impl rule__Declar__Group__4 ;
    public final void rule__Declar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4213:1: ( rule__Declar__Group__3__Impl rule__Declar__Group__4 )
            // InternalSymg.g:4214:2: rule__Declar__Group__3__Impl rule__Declar__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Declar__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__3"


    // $ANTLR start "rule__Declar__Group__3__Impl"
    // InternalSymg.g:4221:1: rule__Declar__Group__3__Impl : ( 'with' ) ;
    public final void rule__Declar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4225:1: ( ( 'with' ) )
            // InternalSymg.g:4226:1: ( 'with' )
            {
            // InternalSymg.g:4226:1: ( 'with' )
            // InternalSymg.g:4227:2: 'with'
            {
             before(grammarAccess.getDeclarAccess().getWithKeyword_3()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getDeclarAccess().getWithKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__3__Impl"


    // $ANTLR start "rule__Declar__Group__4"
    // InternalSymg.g:4236:1: rule__Declar__Group__4 : rule__Declar__Group__4__Impl rule__Declar__Group__5 ;
    public final void rule__Declar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4240:1: ( rule__Declar__Group__4__Impl rule__Declar__Group__5 )
            // InternalSymg.g:4241:2: rule__Declar__Group__4__Impl rule__Declar__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Declar__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__4"


    // $ANTLR start "rule__Declar__Group__4__Impl"
    // InternalSymg.g:4248:1: rule__Declar__Group__4__Impl : ( ( rule__Declar__Group_4__0 )* ) ;
    public final void rule__Declar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4252:1: ( ( ( rule__Declar__Group_4__0 )* ) )
            // InternalSymg.g:4253:1: ( ( rule__Declar__Group_4__0 )* )
            {
            // InternalSymg.g:4253:1: ( ( rule__Declar__Group_4__0 )* )
            // InternalSymg.g:4254:2: ( rule__Declar__Group_4__0 )*
            {
             before(grammarAccess.getDeclarAccess().getGroup_4()); 
            // InternalSymg.g:4255:2: ( rule__Declar__Group_4__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    int LA39_1 = input.LA(2);

                    if ( (LA39_1==93) ) {
                        int LA39_2 = input.LA(3);

                        if ( (LA39_2==RULE_ID) ) {
                            int LA39_3 = input.LA(4);

                            if ( (LA39_3==81) ) {
                                alt39=1;
                            }


                        }


                    }


                }


                switch (alt39) {
            	case 1 :
            	    // InternalSymg.g:4255:3: rule__Declar__Group_4__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Declar__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getDeclarAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__4__Impl"


    // $ANTLR start "rule__Declar__Group__5"
    // InternalSymg.g:4263:1: rule__Declar__Group__5 : rule__Declar__Group__5__Impl ;
    public final void rule__Declar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4267:1: ( rule__Declar__Group__5__Impl )
            // InternalSymg.g:4268:2: rule__Declar__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declar__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__5"


    // $ANTLR start "rule__Declar__Group__5__Impl"
    // InternalSymg.g:4274:1: rule__Declar__Group__5__Impl : ( ( rule__Declar__AttributesAssignment_5 ) ) ;
    public final void rule__Declar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4278:1: ( ( ( rule__Declar__AttributesAssignment_5 ) ) )
            // InternalSymg.g:4279:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            {
            // InternalSymg.g:4279:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            // InternalSymg.g:4280:2: ( rule__Declar__AttributesAssignment_5 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_5()); 
            // InternalSymg.g:4281:2: ( rule__Declar__AttributesAssignment_5 )
            // InternalSymg.g:4281:3: rule__Declar__AttributesAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Declar__AttributesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getDeclarAccess().getAttributesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group__5__Impl"


    // $ANTLR start "rule__Declar__Group_4__0"
    // InternalSymg.g:4290:1: rule__Declar__Group_4__0 : rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 ;
    public final void rule__Declar__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4294:1: ( rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 )
            // InternalSymg.g:4295:2: rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__Declar__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declar__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group_4__0"


    // $ANTLR start "rule__Declar__Group_4__0__Impl"
    // InternalSymg.g:4302:1: rule__Declar__Group_4__0__Impl : ( ( rule__Declar__AttributesAssignment_4_0 ) ) ;
    public final void rule__Declar__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4306:1: ( ( ( rule__Declar__AttributesAssignment_4_0 ) ) )
            // InternalSymg.g:4307:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            {
            // InternalSymg.g:4307:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            // InternalSymg.g:4308:2: ( rule__Declar__AttributesAssignment_4_0 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_4_0()); 
            // InternalSymg.g:4309:2: ( rule__Declar__AttributesAssignment_4_0 )
            // InternalSymg.g:4309:3: rule__Declar__AttributesAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__Declar__AttributesAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarAccess().getAttributesAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group_4__0__Impl"


    // $ANTLR start "rule__Declar__Group_4__1"
    // InternalSymg.g:4317:1: rule__Declar__Group_4__1 : rule__Declar__Group_4__1__Impl ;
    public final void rule__Declar__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4321:1: ( rule__Declar__Group_4__1__Impl )
            // InternalSymg.g:4322:2: rule__Declar__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declar__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group_4__1"


    // $ANTLR start "rule__Declar__Group_4__1__Impl"
    // InternalSymg.g:4328:1: rule__Declar__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Declar__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4332:1: ( ( ',' ) )
            // InternalSymg.g:4333:1: ( ',' )
            {
            // InternalSymg.g:4333:1: ( ',' )
            // InternalSymg.g:4334:2: ','
            {
             before(grammarAccess.getDeclarAccess().getCommaKeyword_4_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getDeclarAccess().getCommaKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__Group_4__1__Impl"


    // $ANTLR start "rule__Obligation__Group__0"
    // InternalSymg.g:4344:1: rule__Obligation__Group__0 : rule__Obligation__Group__0__Impl rule__Obligation__Group__1 ;
    public final void rule__Obligation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4348:1: ( rule__Obligation__Group__0__Impl rule__Obligation__Group__1 )
            // InternalSymg.g:4349:2: rule__Obligation__Group__0__Impl rule__Obligation__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Obligation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__0"


    // $ANTLR start "rule__Obligation__Group__0__Impl"
    // InternalSymg.g:4356:1: rule__Obligation__Group__0__Impl : ( ( rule__Obligation__NameAssignment_0 ) ) ;
    public final void rule__Obligation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4360:1: ( ( ( rule__Obligation__NameAssignment_0 ) ) )
            // InternalSymg.g:4361:1: ( ( rule__Obligation__NameAssignment_0 ) )
            {
            // InternalSymg.g:4361:1: ( ( rule__Obligation__NameAssignment_0 ) )
            // InternalSymg.g:4362:2: ( rule__Obligation__NameAssignment_0 )
            {
             before(grammarAccess.getObligationAccess().getNameAssignment_0()); 
            // InternalSymg.g:4363:2: ( rule__Obligation__NameAssignment_0 )
            // InternalSymg.g:4363:3: rule__Obligation__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__0__Impl"


    // $ANTLR start "rule__Obligation__Group__1"
    // InternalSymg.g:4371:1: rule__Obligation__Group__1 : rule__Obligation__Group__1__Impl rule__Obligation__Group__2 ;
    public final void rule__Obligation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4375:1: ( rule__Obligation__Group__1__Impl rule__Obligation__Group__2 )
            // InternalSymg.g:4376:2: rule__Obligation__Group__1__Impl rule__Obligation__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Obligation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__1"


    // $ANTLR start "rule__Obligation__Group__1__Impl"
    // InternalSymg.g:4383:1: rule__Obligation__Group__1__Impl : ( ':' ) ;
    public final void rule__Obligation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4387:1: ( ( ':' ) )
            // InternalSymg.g:4388:1: ( ':' )
            {
            // InternalSymg.g:4388:1: ( ':' )
            // InternalSymg.g:4389:2: ':'
            {
             before(grammarAccess.getObligationAccess().getColonKeyword_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__1__Impl"


    // $ANTLR start "rule__Obligation__Group__2"
    // InternalSymg.g:4398:1: rule__Obligation__Group__2 : rule__Obligation__Group__2__Impl rule__Obligation__Group__3 ;
    public final void rule__Obligation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4402:1: ( rule__Obligation__Group__2__Impl rule__Obligation__Group__3 )
            // InternalSymg.g:4403:2: rule__Obligation__Group__2__Impl rule__Obligation__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Obligation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__2"


    // $ANTLR start "rule__Obligation__Group__2__Impl"
    // InternalSymg.g:4410:1: rule__Obligation__Group__2__Impl : ( ( rule__Obligation__Group_2__0 )? ) ;
    public final void rule__Obligation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4414:1: ( ( ( rule__Obligation__Group_2__0 )? ) )
            // InternalSymg.g:4415:1: ( ( rule__Obligation__Group_2__0 )? )
            {
            // InternalSymg.g:4415:1: ( ( rule__Obligation__Group_2__0 )? )
            // InternalSymg.g:4416:2: ( rule__Obligation__Group_2__0 )?
            {
             before(grammarAccess.getObligationAccess().getGroup_2()); 
            // InternalSymg.g:4417:2: ( rule__Obligation__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_INT)||(LA40_0>=33 && LA40_0<=73)||LA40_0==77||(LA40_0>=99 && LA40_0<=100)||(LA40_0>=104 && LA40_0<=106)||LA40_0==108) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalSymg.g:4417:3: rule__Obligation__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Obligation__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObligationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__2__Impl"


    // $ANTLR start "rule__Obligation__Group__3"
    // InternalSymg.g:4425:1: rule__Obligation__Group__3 : rule__Obligation__Group__3__Impl rule__Obligation__Group__4 ;
    public final void rule__Obligation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4429:1: ( rule__Obligation__Group__3__Impl rule__Obligation__Group__4 )
            // InternalSymg.g:4430:2: rule__Obligation__Group__3__Impl rule__Obligation__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Obligation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__3"


    // $ANTLR start "rule__Obligation__Group__3__Impl"
    // InternalSymg.g:4437:1: rule__Obligation__Group__3__Impl : ( 'obligation' ) ;
    public final void rule__Obligation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4441:1: ( ( 'obligation' ) )
            // InternalSymg.g:4442:1: ( 'obligation' )
            {
            // InternalSymg.g:4442:1: ( 'obligation' )
            // InternalSymg.g:4443:2: 'obligation'
            {
             before(grammarAccess.getObligationAccess().getObligationKeyword_3()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getObligationKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__3__Impl"


    // $ANTLR start "rule__Obligation__Group__4"
    // InternalSymg.g:4452:1: rule__Obligation__Group__4 : rule__Obligation__Group__4__Impl rule__Obligation__Group__5 ;
    public final void rule__Obligation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4456:1: ( rule__Obligation__Group__4__Impl rule__Obligation__Group__5 )
            // InternalSymg.g:4457:2: rule__Obligation__Group__4__Impl rule__Obligation__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Obligation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__4"


    // $ANTLR start "rule__Obligation__Group__4__Impl"
    // InternalSymg.g:4464:1: rule__Obligation__Group__4__Impl : ( '(' ) ;
    public final void rule__Obligation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4468:1: ( ( '(' ) )
            // InternalSymg.g:4469:1: ( '(' )
            {
            // InternalSymg.g:4469:1: ( '(' )
            // InternalSymg.g:4470:2: '('
            {
             before(grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__4__Impl"


    // $ANTLR start "rule__Obligation__Group__5"
    // InternalSymg.g:4479:1: rule__Obligation__Group__5 : rule__Obligation__Group__5__Impl rule__Obligation__Group__6 ;
    public final void rule__Obligation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4483:1: ( rule__Obligation__Group__5__Impl rule__Obligation__Group__6 )
            // InternalSymg.g:4484:2: rule__Obligation__Group__5__Impl rule__Obligation__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Obligation__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__5"


    // $ANTLR start "rule__Obligation__Group__5__Impl"
    // InternalSymg.g:4491:1: rule__Obligation__Group__5__Impl : ( ( rule__Obligation__Role1Assignment_5 ) ) ;
    public final void rule__Obligation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4495:1: ( ( ( rule__Obligation__Role1Assignment_5 ) ) )
            // InternalSymg.g:4496:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4496:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            // InternalSymg.g:4497:2: ( rule__Obligation__Role1Assignment_5 )
            {
             before(grammarAccess.getObligationAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4498:2: ( rule__Obligation__Role1Assignment_5 )
            // InternalSymg.g:4498:3: rule__Obligation__Role1Assignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__Role1Assignment_5();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getRole1Assignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__5__Impl"


    // $ANTLR start "rule__Obligation__Group__6"
    // InternalSymg.g:4506:1: rule__Obligation__Group__6 : rule__Obligation__Group__6__Impl rule__Obligation__Group__7 ;
    public final void rule__Obligation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4510:1: ( rule__Obligation__Group__6__Impl rule__Obligation__Group__7 )
            // InternalSymg.g:4511:2: rule__Obligation__Group__6__Impl rule__Obligation__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Obligation__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__6"


    // $ANTLR start "rule__Obligation__Group__6__Impl"
    // InternalSymg.g:4518:1: rule__Obligation__Group__6__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4522:1: ( ( ',' ) )
            // InternalSymg.g:4523:1: ( ',' )
            {
            // InternalSymg.g:4523:1: ( ',' )
            // InternalSymg.g:4524:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_6()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__6__Impl"


    // $ANTLR start "rule__Obligation__Group__7"
    // InternalSymg.g:4533:1: rule__Obligation__Group__7 : rule__Obligation__Group__7__Impl rule__Obligation__Group__8 ;
    public final void rule__Obligation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4537:1: ( rule__Obligation__Group__7__Impl rule__Obligation__Group__8 )
            // InternalSymg.g:4538:2: rule__Obligation__Group__7__Impl rule__Obligation__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Obligation__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__7"


    // $ANTLR start "rule__Obligation__Group__7__Impl"
    // InternalSymg.g:4545:1: rule__Obligation__Group__7__Impl : ( ( rule__Obligation__Role2Assignment_7 ) ) ;
    public final void rule__Obligation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4549:1: ( ( ( rule__Obligation__Role2Assignment_7 ) ) )
            // InternalSymg.g:4550:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4550:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            // InternalSymg.g:4551:2: ( rule__Obligation__Role2Assignment_7 )
            {
             before(grammarAccess.getObligationAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4552:2: ( rule__Obligation__Role2Assignment_7 )
            // InternalSymg.g:4552:3: rule__Obligation__Role2Assignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__Role2Assignment_7();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getRole2Assignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__7__Impl"


    // $ANTLR start "rule__Obligation__Group__8"
    // InternalSymg.g:4560:1: rule__Obligation__Group__8 : rule__Obligation__Group__8__Impl rule__Obligation__Group__9 ;
    public final void rule__Obligation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4564:1: ( rule__Obligation__Group__8__Impl rule__Obligation__Group__9 )
            // InternalSymg.g:4565:2: rule__Obligation__Group__8__Impl rule__Obligation__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__Obligation__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__8"


    // $ANTLR start "rule__Obligation__Group__8__Impl"
    // InternalSymg.g:4572:1: rule__Obligation__Group__8__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4576:1: ( ( ',' ) )
            // InternalSymg.g:4577:1: ( ',' )
            {
            // InternalSymg.g:4577:1: ( ',' )
            // InternalSymg.g:4578:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_8()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getCommaKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__8__Impl"


    // $ANTLR start "rule__Obligation__Group__9"
    // InternalSymg.g:4587:1: rule__Obligation__Group__9 : rule__Obligation__Group__9__Impl rule__Obligation__Group__10 ;
    public final void rule__Obligation__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4591:1: ( rule__Obligation__Group__9__Impl rule__Obligation__Group__10 )
            // InternalSymg.g:4592:2: rule__Obligation__Group__9__Impl rule__Obligation__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Obligation__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__9"


    // $ANTLR start "rule__Obligation__Group__9__Impl"
    // InternalSymg.g:4599:1: rule__Obligation__Group__9__Impl : ( ( rule__Obligation__AntecedentAssignment_9 ) ) ;
    public final void rule__Obligation__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4603:1: ( ( ( rule__Obligation__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:4604:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:4604:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            // InternalSymg.g:4605:2: ( rule__Obligation__AntecedentAssignment_9 )
            {
             before(grammarAccess.getObligationAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:4606:2: ( rule__Obligation__AntecedentAssignment_9 )
            // InternalSymg.g:4606:3: rule__Obligation__AntecedentAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__AntecedentAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getAntecedentAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__9__Impl"


    // $ANTLR start "rule__Obligation__Group__10"
    // InternalSymg.g:4614:1: rule__Obligation__Group__10 : rule__Obligation__Group__10__Impl rule__Obligation__Group__11 ;
    public final void rule__Obligation__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4618:1: ( rule__Obligation__Group__10__Impl rule__Obligation__Group__11 )
            // InternalSymg.g:4619:2: rule__Obligation__Group__10__Impl rule__Obligation__Group__11
            {
            pushFollow(FOLLOW_12);
            rule__Obligation__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__10"


    // $ANTLR start "rule__Obligation__Group__10__Impl"
    // InternalSymg.g:4626:1: rule__Obligation__Group__10__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4630:1: ( ( ',' ) )
            // InternalSymg.g:4631:1: ( ',' )
            {
            // InternalSymg.g:4631:1: ( ',' )
            // InternalSymg.g:4632:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_10()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getCommaKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__10__Impl"


    // $ANTLR start "rule__Obligation__Group__11"
    // InternalSymg.g:4641:1: rule__Obligation__Group__11 : rule__Obligation__Group__11__Impl rule__Obligation__Group__12 ;
    public final void rule__Obligation__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4645:1: ( rule__Obligation__Group__11__Impl rule__Obligation__Group__12 )
            // InternalSymg.g:4646:2: rule__Obligation__Group__11__Impl rule__Obligation__Group__12
            {
            pushFollow(FOLLOW_8);
            rule__Obligation__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__11"


    // $ANTLR start "rule__Obligation__Group__11__Impl"
    // InternalSymg.g:4653:1: rule__Obligation__Group__11__Impl : ( ( rule__Obligation__ConsequentAssignment_11 ) ) ;
    public final void rule__Obligation__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4657:1: ( ( ( rule__Obligation__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:4658:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:4658:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            // InternalSymg.g:4659:2: ( rule__Obligation__ConsequentAssignment_11 )
            {
             before(grammarAccess.getObligationAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:4660:2: ( rule__Obligation__ConsequentAssignment_11 )
            // InternalSymg.g:4660:3: rule__Obligation__ConsequentAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__ConsequentAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getConsequentAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__11__Impl"


    // $ANTLR start "rule__Obligation__Group__12"
    // InternalSymg.g:4668:1: rule__Obligation__Group__12 : rule__Obligation__Group__12__Impl ;
    public final void rule__Obligation__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4672:1: ( rule__Obligation__Group__12__Impl )
            // InternalSymg.g:4673:2: rule__Obligation__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__12"


    // $ANTLR start "rule__Obligation__Group__12__Impl"
    // InternalSymg.g:4679:1: rule__Obligation__Group__12__Impl : ( ')' ) ;
    public final void rule__Obligation__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4683:1: ( ( ')' ) )
            // InternalSymg.g:4684:1: ( ')' )
            {
            // InternalSymg.g:4684:1: ( ')' )
            // InternalSymg.g:4685:2: ')'
            {
             before(grammarAccess.getObligationAccess().getRightParenthesisKeyword_12()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getRightParenthesisKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group__12__Impl"


    // $ANTLR start "rule__Obligation__Group_2__0"
    // InternalSymg.g:4695:1: rule__Obligation__Group_2__0 : rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 ;
    public final void rule__Obligation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4699:1: ( rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 )
            // InternalSymg.g:4700:2: rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1
            {
            pushFollow(FOLLOW_22);
            rule__Obligation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Obligation__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group_2__0"


    // $ANTLR start "rule__Obligation__Group_2__0__Impl"
    // InternalSymg.g:4707:1: rule__Obligation__Group_2__0__Impl : ( ( rule__Obligation__TriggerAssignment_2_0 ) ) ;
    public final void rule__Obligation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4711:1: ( ( ( rule__Obligation__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:4712:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:4712:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            // InternalSymg.g:4713:2: ( rule__Obligation__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getObligationAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:4714:2: ( rule__Obligation__TriggerAssignment_2_0 )
            // InternalSymg.g:4714:3: rule__Obligation__TriggerAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__TriggerAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getObligationAccess().getTriggerAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group_2__0__Impl"


    // $ANTLR start "rule__Obligation__Group_2__1"
    // InternalSymg.g:4722:1: rule__Obligation__Group_2__1 : rule__Obligation__Group_2__1__Impl ;
    public final void rule__Obligation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4726:1: ( rule__Obligation__Group_2__1__Impl )
            // InternalSymg.g:4727:2: rule__Obligation__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Obligation__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group_2__1"


    // $ANTLR start "rule__Obligation__Group_2__1__Impl"
    // InternalSymg.g:4733:1: rule__Obligation__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Obligation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4737:1: ( ( '->' ) )
            // InternalSymg.g:4738:1: ( '->' )
            {
            // InternalSymg.g:4738:1: ( '->' )
            // InternalSymg.g:4739:2: '->'
            {
             before(grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Group_2__1__Impl"


    // $ANTLR start "rule__Power__Group__0"
    // InternalSymg.g:4749:1: rule__Power__Group__0 : rule__Power__Group__0__Impl rule__Power__Group__1 ;
    public final void rule__Power__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4753:1: ( rule__Power__Group__0__Impl rule__Power__Group__1 )
            // InternalSymg.g:4754:2: rule__Power__Group__0__Impl rule__Power__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__Power__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__0"


    // $ANTLR start "rule__Power__Group__0__Impl"
    // InternalSymg.g:4761:1: rule__Power__Group__0__Impl : ( ( rule__Power__NameAssignment_0 ) ) ;
    public final void rule__Power__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4765:1: ( ( ( rule__Power__NameAssignment_0 ) ) )
            // InternalSymg.g:4766:1: ( ( rule__Power__NameAssignment_0 ) )
            {
            // InternalSymg.g:4766:1: ( ( rule__Power__NameAssignment_0 ) )
            // InternalSymg.g:4767:2: ( rule__Power__NameAssignment_0 )
            {
             before(grammarAccess.getPowerAccess().getNameAssignment_0()); 
            // InternalSymg.g:4768:2: ( rule__Power__NameAssignment_0 )
            // InternalSymg.g:4768:3: rule__Power__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Power__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__0__Impl"


    // $ANTLR start "rule__Power__Group__1"
    // InternalSymg.g:4776:1: rule__Power__Group__1 : rule__Power__Group__1__Impl rule__Power__Group__2 ;
    public final void rule__Power__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4780:1: ( rule__Power__Group__1__Impl rule__Power__Group__2 )
            // InternalSymg.g:4781:2: rule__Power__Group__1__Impl rule__Power__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Power__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__1"


    // $ANTLR start "rule__Power__Group__1__Impl"
    // InternalSymg.g:4788:1: rule__Power__Group__1__Impl : ( ':' ) ;
    public final void rule__Power__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4792:1: ( ( ':' ) )
            // InternalSymg.g:4793:1: ( ':' )
            {
            // InternalSymg.g:4793:1: ( ':' )
            // InternalSymg.g:4794:2: ':'
            {
             before(grammarAccess.getPowerAccess().getColonKeyword_1()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__1__Impl"


    // $ANTLR start "rule__Power__Group__2"
    // InternalSymg.g:4803:1: rule__Power__Group__2 : rule__Power__Group__2__Impl rule__Power__Group__3 ;
    public final void rule__Power__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4807:1: ( rule__Power__Group__2__Impl rule__Power__Group__3 )
            // InternalSymg.g:4808:2: rule__Power__Group__2__Impl rule__Power__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__Power__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__2"


    // $ANTLR start "rule__Power__Group__2__Impl"
    // InternalSymg.g:4815:1: rule__Power__Group__2__Impl : ( ( rule__Power__Group_2__0 )? ) ;
    public final void rule__Power__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4819:1: ( ( ( rule__Power__Group_2__0 )? ) )
            // InternalSymg.g:4820:1: ( ( rule__Power__Group_2__0 )? )
            {
            // InternalSymg.g:4820:1: ( ( rule__Power__Group_2__0 )? )
            // InternalSymg.g:4821:2: ( rule__Power__Group_2__0 )?
            {
             before(grammarAccess.getPowerAccess().getGroup_2()); 
            // InternalSymg.g:4822:2: ( rule__Power__Group_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_INT)||(LA41_0>=33 && LA41_0<=73)||LA41_0==77||(LA41_0>=99 && LA41_0<=100)||(LA41_0>=104 && LA41_0<=106)||LA41_0==108) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSymg.g:4822:3: rule__Power__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Power__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPowerAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__2__Impl"


    // $ANTLR start "rule__Power__Group__3"
    // InternalSymg.g:4830:1: rule__Power__Group__3 : rule__Power__Group__3__Impl rule__Power__Group__4 ;
    public final void rule__Power__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4834:1: ( rule__Power__Group__3__Impl rule__Power__Group__4 )
            // InternalSymg.g:4835:2: rule__Power__Group__3__Impl rule__Power__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Power__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__3"


    // $ANTLR start "rule__Power__Group__3__Impl"
    // InternalSymg.g:4842:1: rule__Power__Group__3__Impl : ( 'power' ) ;
    public final void rule__Power__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4846:1: ( ( 'power' ) )
            // InternalSymg.g:4847:1: ( 'power' )
            {
            // InternalSymg.g:4847:1: ( 'power' )
            // InternalSymg.g:4848:2: 'power'
            {
             before(grammarAccess.getPowerAccess().getPowerKeyword_3()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__3__Impl"


    // $ANTLR start "rule__Power__Group__4"
    // InternalSymg.g:4857:1: rule__Power__Group__4 : rule__Power__Group__4__Impl rule__Power__Group__5 ;
    public final void rule__Power__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4861:1: ( rule__Power__Group__4__Impl rule__Power__Group__5 )
            // InternalSymg.g:4862:2: rule__Power__Group__4__Impl rule__Power__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Power__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__4"


    // $ANTLR start "rule__Power__Group__4__Impl"
    // InternalSymg.g:4869:1: rule__Power__Group__4__Impl : ( '(' ) ;
    public final void rule__Power__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4873:1: ( ( '(' ) )
            // InternalSymg.g:4874:1: ( '(' )
            {
            // InternalSymg.g:4874:1: ( '(' )
            // InternalSymg.g:4875:2: '('
            {
             before(grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__4__Impl"


    // $ANTLR start "rule__Power__Group__5"
    // InternalSymg.g:4884:1: rule__Power__Group__5 : rule__Power__Group__5__Impl rule__Power__Group__6 ;
    public final void rule__Power__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4888:1: ( rule__Power__Group__5__Impl rule__Power__Group__6 )
            // InternalSymg.g:4889:2: rule__Power__Group__5__Impl rule__Power__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__Power__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__5"


    // $ANTLR start "rule__Power__Group__5__Impl"
    // InternalSymg.g:4896:1: rule__Power__Group__5__Impl : ( ( rule__Power__Role1Assignment_5 ) ) ;
    public final void rule__Power__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4900:1: ( ( ( rule__Power__Role1Assignment_5 ) ) )
            // InternalSymg.g:4901:1: ( ( rule__Power__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4901:1: ( ( rule__Power__Role1Assignment_5 ) )
            // InternalSymg.g:4902:2: ( rule__Power__Role1Assignment_5 )
            {
             before(grammarAccess.getPowerAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4903:2: ( rule__Power__Role1Assignment_5 )
            // InternalSymg.g:4903:3: rule__Power__Role1Assignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Power__Role1Assignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getRole1Assignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__5__Impl"


    // $ANTLR start "rule__Power__Group__6"
    // InternalSymg.g:4911:1: rule__Power__Group__6 : rule__Power__Group__6__Impl rule__Power__Group__7 ;
    public final void rule__Power__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4915:1: ( rule__Power__Group__6__Impl rule__Power__Group__7 )
            // InternalSymg.g:4916:2: rule__Power__Group__6__Impl rule__Power__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Power__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__6"


    // $ANTLR start "rule__Power__Group__6__Impl"
    // InternalSymg.g:4923:1: rule__Power__Group__6__Impl : ( ',' ) ;
    public final void rule__Power__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4927:1: ( ( ',' ) )
            // InternalSymg.g:4928:1: ( ',' )
            {
            // InternalSymg.g:4928:1: ( ',' )
            // InternalSymg.g:4929:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_6()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getCommaKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__6__Impl"


    // $ANTLR start "rule__Power__Group__7"
    // InternalSymg.g:4938:1: rule__Power__Group__7 : rule__Power__Group__7__Impl rule__Power__Group__8 ;
    public final void rule__Power__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4942:1: ( rule__Power__Group__7__Impl rule__Power__Group__8 )
            // InternalSymg.g:4943:2: rule__Power__Group__7__Impl rule__Power__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Power__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__7"


    // $ANTLR start "rule__Power__Group__7__Impl"
    // InternalSymg.g:4950:1: rule__Power__Group__7__Impl : ( ( rule__Power__Role2Assignment_7 ) ) ;
    public final void rule__Power__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4954:1: ( ( ( rule__Power__Role2Assignment_7 ) ) )
            // InternalSymg.g:4955:1: ( ( rule__Power__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4955:1: ( ( rule__Power__Role2Assignment_7 ) )
            // InternalSymg.g:4956:2: ( rule__Power__Role2Assignment_7 )
            {
             before(grammarAccess.getPowerAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4957:2: ( rule__Power__Role2Assignment_7 )
            // InternalSymg.g:4957:3: rule__Power__Role2Assignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Power__Role2Assignment_7();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getRole2Assignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__7__Impl"


    // $ANTLR start "rule__Power__Group__8"
    // InternalSymg.g:4965:1: rule__Power__Group__8 : rule__Power__Group__8__Impl rule__Power__Group__9 ;
    public final void rule__Power__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4969:1: ( rule__Power__Group__8__Impl rule__Power__Group__9 )
            // InternalSymg.g:4970:2: rule__Power__Group__8__Impl rule__Power__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__Power__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__8"


    // $ANTLR start "rule__Power__Group__8__Impl"
    // InternalSymg.g:4977:1: rule__Power__Group__8__Impl : ( ',' ) ;
    public final void rule__Power__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4981:1: ( ( ',' ) )
            // InternalSymg.g:4982:1: ( ',' )
            {
            // InternalSymg.g:4982:1: ( ',' )
            // InternalSymg.g:4983:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_8()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getCommaKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__8__Impl"


    // $ANTLR start "rule__Power__Group__9"
    // InternalSymg.g:4992:1: rule__Power__Group__9 : rule__Power__Group__9__Impl rule__Power__Group__10 ;
    public final void rule__Power__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4996:1: ( rule__Power__Group__9__Impl rule__Power__Group__10 )
            // InternalSymg.g:4997:2: rule__Power__Group__9__Impl rule__Power__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Power__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__9"


    // $ANTLR start "rule__Power__Group__9__Impl"
    // InternalSymg.g:5004:1: rule__Power__Group__9__Impl : ( ( rule__Power__AntecedentAssignment_9 ) ) ;
    public final void rule__Power__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5008:1: ( ( ( rule__Power__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:5009:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:5009:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            // InternalSymg.g:5010:2: ( rule__Power__AntecedentAssignment_9 )
            {
             before(grammarAccess.getPowerAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:5011:2: ( rule__Power__AntecedentAssignment_9 )
            // InternalSymg.g:5011:3: rule__Power__AntecedentAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Power__AntecedentAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getAntecedentAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__9__Impl"


    // $ANTLR start "rule__Power__Group__10"
    // InternalSymg.g:5019:1: rule__Power__Group__10 : rule__Power__Group__10__Impl rule__Power__Group__11 ;
    public final void rule__Power__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5023:1: ( rule__Power__Group__10__Impl rule__Power__Group__11 )
            // InternalSymg.g:5024:2: rule__Power__Group__10__Impl rule__Power__Group__11
            {
            pushFollow(FOLLOW_12);
            rule__Power__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__10"


    // $ANTLR start "rule__Power__Group__10__Impl"
    // InternalSymg.g:5031:1: rule__Power__Group__10__Impl : ( ',' ) ;
    public final void rule__Power__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5035:1: ( ( ',' ) )
            // InternalSymg.g:5036:1: ( ',' )
            {
            // InternalSymg.g:5036:1: ( ',' )
            // InternalSymg.g:5037:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_10()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getCommaKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__10__Impl"


    // $ANTLR start "rule__Power__Group__11"
    // InternalSymg.g:5046:1: rule__Power__Group__11 : rule__Power__Group__11__Impl rule__Power__Group__12 ;
    public final void rule__Power__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5050:1: ( rule__Power__Group__11__Impl rule__Power__Group__12 )
            // InternalSymg.g:5051:2: rule__Power__Group__11__Impl rule__Power__Group__12
            {
            pushFollow(FOLLOW_8);
            rule__Power__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__11"


    // $ANTLR start "rule__Power__Group__11__Impl"
    // InternalSymg.g:5058:1: rule__Power__Group__11__Impl : ( ( rule__Power__ConsequentAssignment_11 ) ) ;
    public final void rule__Power__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5062:1: ( ( ( rule__Power__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:5063:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:5063:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            // InternalSymg.g:5064:2: ( rule__Power__ConsequentAssignment_11 )
            {
             before(grammarAccess.getPowerAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:5065:2: ( rule__Power__ConsequentAssignment_11 )
            // InternalSymg.g:5065:3: rule__Power__ConsequentAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Power__ConsequentAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getConsequentAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__11__Impl"


    // $ANTLR start "rule__Power__Group__12"
    // InternalSymg.g:5073:1: rule__Power__Group__12 : rule__Power__Group__12__Impl ;
    public final void rule__Power__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5077:1: ( rule__Power__Group__12__Impl )
            // InternalSymg.g:5078:2: rule__Power__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Power__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__12"


    // $ANTLR start "rule__Power__Group__12__Impl"
    // InternalSymg.g:5084:1: rule__Power__Group__12__Impl : ( ')' ) ;
    public final void rule__Power__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5088:1: ( ( ')' ) )
            // InternalSymg.g:5089:1: ( ')' )
            {
            // InternalSymg.g:5089:1: ( ')' )
            // InternalSymg.g:5090:2: ')'
            {
             before(grammarAccess.getPowerAccess().getRightParenthesisKeyword_12()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getRightParenthesisKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group__12__Impl"


    // $ANTLR start "rule__Power__Group_2__0"
    // InternalSymg.g:5100:1: rule__Power__Group_2__0 : rule__Power__Group_2__0__Impl rule__Power__Group_2__1 ;
    public final void rule__Power__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5104:1: ( rule__Power__Group_2__0__Impl rule__Power__Group_2__1 )
            // InternalSymg.g:5105:2: rule__Power__Group_2__0__Impl rule__Power__Group_2__1
            {
            pushFollow(FOLLOW_22);
            rule__Power__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Power__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group_2__0"


    // $ANTLR start "rule__Power__Group_2__0__Impl"
    // InternalSymg.g:5112:1: rule__Power__Group_2__0__Impl : ( ( rule__Power__TriggerAssignment_2_0 ) ) ;
    public final void rule__Power__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5116:1: ( ( ( rule__Power__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:5117:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:5117:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            // InternalSymg.g:5118:2: ( rule__Power__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getPowerAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:5119:2: ( rule__Power__TriggerAssignment_2_0 )
            // InternalSymg.g:5119:3: rule__Power__TriggerAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Power__TriggerAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getPowerAccess().getTriggerAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group_2__0__Impl"


    // $ANTLR start "rule__Power__Group_2__1"
    // InternalSymg.g:5127:1: rule__Power__Group_2__1 : rule__Power__Group_2__1__Impl ;
    public final void rule__Power__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5131:1: ( rule__Power__Group_2__1__Impl )
            // InternalSymg.g:5132:2: rule__Power__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Power__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group_2__1"


    // $ANTLR start "rule__Power__Group_2__1__Impl"
    // InternalSymg.g:5138:1: rule__Power__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Power__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5142:1: ( ( '->' ) )
            // InternalSymg.g:5143:1: ( '->' )
            {
            // InternalSymg.g:5143:1: ( '->' )
            // InternalSymg.g:5144:2: '->'
            {
             before(grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Group_2__1__Impl"


    // $ANTLR start "rule__Proposition__Group__0"
    // InternalSymg.g:5154:1: rule__Proposition__Group__0 : rule__Proposition__Group__0__Impl rule__Proposition__Group__1 ;
    public final void rule__Proposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5158:1: ( rule__Proposition__Group__0__Impl rule__Proposition__Group__1 )
            // InternalSymg.g:5159:2: rule__Proposition__Group__0__Impl rule__Proposition__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Proposition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0"


    // $ANTLR start "rule__Proposition__Group__0__Impl"
    // InternalSymg.g:5166:1: rule__Proposition__Group__0__Impl : ( ( rule__Proposition__JunctionsAssignment_0 ) ) ;
    public final void rule__Proposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5170:1: ( ( ( rule__Proposition__JunctionsAssignment_0 ) ) )
            // InternalSymg.g:5171:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            {
            // InternalSymg.g:5171:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            // InternalSymg.g:5172:2: ( rule__Proposition__JunctionsAssignment_0 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_0()); 
            // InternalSymg.g:5173:2: ( rule__Proposition__JunctionsAssignment_0 )
            // InternalSymg.g:5173:3: rule__Proposition__JunctionsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__JunctionsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getJunctionsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0__Impl"


    // $ANTLR start "rule__Proposition__Group__1"
    // InternalSymg.g:5181:1: rule__Proposition__Group__1 : rule__Proposition__Group__1__Impl ;
    public final void rule__Proposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5185:1: ( rule__Proposition__Group__1__Impl )
            // InternalSymg.g:5186:2: rule__Proposition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1"


    // $ANTLR start "rule__Proposition__Group__1__Impl"
    // InternalSymg.g:5192:1: rule__Proposition__Group__1__Impl : ( ( rule__Proposition__Group_1__0 )* ) ;
    public final void rule__Proposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5196:1: ( ( ( rule__Proposition__Group_1__0 )* ) )
            // InternalSymg.g:5197:1: ( ( rule__Proposition__Group_1__0 )* )
            {
            // InternalSymg.g:5197:1: ( ( rule__Proposition__Group_1__0 )* )
            // InternalSymg.g:5198:2: ( rule__Proposition__Group_1__0 )*
            {
             before(grammarAccess.getPropositionAccess().getGroup_1()); 
            // InternalSymg.g:5199:2: ( rule__Proposition__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==97) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSymg.g:5199:3: rule__Proposition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__Proposition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getPropositionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1__Impl"


    // $ANTLR start "rule__Proposition__Group_1__0"
    // InternalSymg.g:5208:1: rule__Proposition__Group_1__0 : rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 ;
    public final void rule__Proposition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5212:1: ( rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 )
            // InternalSymg.g:5213:2: rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Proposition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group_1__0"


    // $ANTLR start "rule__Proposition__Group_1__0__Impl"
    // InternalSymg.g:5220:1: rule__Proposition__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__Proposition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5224:1: ( ( 'OR' ) )
            // InternalSymg.g:5225:1: ( 'OR' )
            {
            // InternalSymg.g:5225:1: ( 'OR' )
            // InternalSymg.g:5226:2: 'OR'
            {
             before(grammarAccess.getPropositionAccess().getORKeyword_1_0()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getORKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group_1__0__Impl"


    // $ANTLR start "rule__Proposition__Group_1__1"
    // InternalSymg.g:5235:1: rule__Proposition__Group_1__1 : rule__Proposition__Group_1__1__Impl ;
    public final void rule__Proposition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5239:1: ( rule__Proposition__Group_1__1__Impl )
            // InternalSymg.g:5240:2: rule__Proposition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group_1__1"


    // $ANTLR start "rule__Proposition__Group_1__1__Impl"
    // InternalSymg.g:5246:1: rule__Proposition__Group_1__1__Impl : ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) ;
    public final void rule__Proposition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5250:1: ( ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) )
            // InternalSymg.g:5251:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            {
            // InternalSymg.g:5251:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            // InternalSymg.g:5252:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_1_1()); 
            // InternalSymg.g:5253:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            // InternalSymg.g:5253:3: rule__Proposition__JunctionsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__JunctionsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getJunctionsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group_1__1__Impl"


    // $ANTLR start "rule__Junction__Group__0"
    // InternalSymg.g:5262:1: rule__Junction__Group__0 : rule__Junction__Group__0__Impl rule__Junction__Group__1 ;
    public final void rule__Junction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5266:1: ( rule__Junction__Group__0__Impl rule__Junction__Group__1 )
            // InternalSymg.g:5267:2: rule__Junction__Group__0__Impl rule__Junction__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Junction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Junction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__0"


    // $ANTLR start "rule__Junction__Group__0__Impl"
    // InternalSymg.g:5274:1: rule__Junction__Group__0__Impl : ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) ;
    public final void rule__Junction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5278:1: ( ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) )
            // InternalSymg.g:5279:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            {
            // InternalSymg.g:5279:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            // InternalSymg.g:5280:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_0()); 
            // InternalSymg.g:5281:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            // InternalSymg.g:5281:3: rule__Junction__NegativeAtomsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Junction__NegativeAtomsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__0__Impl"


    // $ANTLR start "rule__Junction__Group__1"
    // InternalSymg.g:5289:1: rule__Junction__Group__1 : rule__Junction__Group__1__Impl ;
    public final void rule__Junction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5293:1: ( rule__Junction__Group__1__Impl )
            // InternalSymg.g:5294:2: rule__Junction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Junction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__1"


    // $ANTLR start "rule__Junction__Group__1__Impl"
    // InternalSymg.g:5300:1: rule__Junction__Group__1__Impl : ( ( rule__Junction__Group_1__0 )* ) ;
    public final void rule__Junction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5304:1: ( ( ( rule__Junction__Group_1__0 )* ) )
            // InternalSymg.g:5305:1: ( ( rule__Junction__Group_1__0 )* )
            {
            // InternalSymg.g:5305:1: ( ( rule__Junction__Group_1__0 )* )
            // InternalSymg.g:5306:2: ( rule__Junction__Group_1__0 )*
            {
             before(grammarAccess.getJunctionAccess().getGroup_1()); 
            // InternalSymg.g:5307:2: ( rule__Junction__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==98) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSymg.g:5307:3: rule__Junction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__Junction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getJunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group__1__Impl"


    // $ANTLR start "rule__Junction__Group_1__0"
    // InternalSymg.g:5316:1: rule__Junction__Group_1__0 : rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 ;
    public final void rule__Junction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5320:1: ( rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 )
            // InternalSymg.g:5321:2: rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Junction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Junction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group_1__0"


    // $ANTLR start "rule__Junction__Group_1__0__Impl"
    // InternalSymg.g:5328:1: rule__Junction__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__Junction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5332:1: ( ( 'AND' ) )
            // InternalSymg.g:5333:1: ( 'AND' )
            {
            // InternalSymg.g:5333:1: ( 'AND' )
            // InternalSymg.g:5334:2: 'AND'
            {
             before(grammarAccess.getJunctionAccess().getANDKeyword_1_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getJunctionAccess().getANDKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group_1__0__Impl"


    // $ANTLR start "rule__Junction__Group_1__1"
    // InternalSymg.g:5343:1: rule__Junction__Group_1__1 : rule__Junction__Group_1__1__Impl ;
    public final void rule__Junction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5347:1: ( rule__Junction__Group_1__1__Impl )
            // InternalSymg.g:5348:2: rule__Junction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Junction__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group_1__1"


    // $ANTLR start "rule__Junction__Group_1__1__Impl"
    // InternalSymg.g:5354:1: rule__Junction__Group_1__1__Impl : ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) ;
    public final void rule__Junction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5358:1: ( ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) )
            // InternalSymg.g:5359:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            {
            // InternalSymg.g:5359:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            // InternalSymg.g:5360:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_1_1()); 
            // InternalSymg.g:5361:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            // InternalSymg.g:5361:3: rule__Junction__NegativeAtomsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Junction__NegativeAtomsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__Group_1__1__Impl"


    // $ANTLR start "rule__Negation__Group__0"
    // InternalSymg.g:5370:1: rule__Negation__Group__0 : rule__Negation__Group__0__Impl rule__Negation__Group__1 ;
    public final void rule__Negation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5374:1: ( rule__Negation__Group__0__Impl rule__Negation__Group__1 )
            // InternalSymg.g:5375:2: rule__Negation__Group__0__Impl rule__Negation__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Negation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Negation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group__0"


    // $ANTLR start "rule__Negation__Group__0__Impl"
    // InternalSymg.g:5382:1: rule__Negation__Group__0__Impl : ( ( rule__Negation__NegatedAssignment_0 )? ) ;
    public final void rule__Negation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5386:1: ( ( ( rule__Negation__NegatedAssignment_0 )? ) )
            // InternalSymg.g:5387:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            {
            // InternalSymg.g:5387:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            // InternalSymg.g:5388:2: ( rule__Negation__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNegationAccess().getNegatedAssignment_0()); 
            // InternalSymg.g:5389:2: ( rule__Negation__NegatedAssignment_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==104) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSymg.g:5389:3: rule__Negation__NegatedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Negation__NegatedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNegationAccess().getNegatedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group__0__Impl"


    // $ANTLR start "rule__Negation__Group__1"
    // InternalSymg.g:5397:1: rule__Negation__Group__1 : rule__Negation__Group__1__Impl ;
    public final void rule__Negation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5401:1: ( rule__Negation__Group__1__Impl )
            // InternalSymg.g:5402:2: rule__Negation__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Negation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group__1"


    // $ANTLR start "rule__Negation__Group__1__Impl"
    // InternalSymg.g:5408:1: rule__Negation__Group__1__Impl : ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) ;
    public final void rule__Negation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5412:1: ( ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) )
            // InternalSymg.g:5413:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            {
            // InternalSymg.g:5413:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            // InternalSymg.g:5414:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            {
             before(grammarAccess.getNegationAccess().getAtomicExpressionAssignment_1()); 
            // InternalSymg.g:5415:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            // InternalSymg.g:5415:3: rule__Negation__AtomicExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Negation__AtomicExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAtomicExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__Group__1__Impl"


    // $ANTLR start "rule__Atom__Group_0__0"
    // InternalSymg.g:5424:1: rule__Atom__Group_0__0 : rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 ;
    public final void rule__Atom__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5428:1: ( rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 )
            // InternalSymg.g:5429:2: rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1
            {
            pushFollow(FOLLOW_7);
            rule__Atom__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__0"


    // $ANTLR start "rule__Atom__Group_0__0__Impl"
    // InternalSymg.g:5436:1: rule__Atom__Group_0__0__Impl : ( 'happens' ) ;
    public final void rule__Atom__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5440:1: ( ( 'happens' ) )
            // InternalSymg.g:5441:1: ( 'happens' )
            {
            // InternalSymg.g:5441:1: ( 'happens' )
            // InternalSymg.g:5442:2: 'happens'
            {
             before(grammarAccess.getAtomAccess().getHappensKeyword_0_0()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getHappensKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__0__Impl"


    // $ANTLR start "rule__Atom__Group_0__1"
    // InternalSymg.g:5451:1: rule__Atom__Group_0__1 : rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 ;
    public final void rule__Atom__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5455:1: ( rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 )
            // InternalSymg.g:5456:2: rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2
            {
            pushFollow(FOLLOW_28);
            rule__Atom__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__1"


    // $ANTLR start "rule__Atom__Group_0__1__Impl"
    // InternalSymg.g:5463:1: rule__Atom__Group_0__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5467:1: ( ( '(' ) )
            // InternalSymg.g:5468:1: ( '(' )
            {
            // InternalSymg.g:5468:1: ( '(' )
            // InternalSymg.g:5469:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_0_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__1__Impl"


    // $ANTLR start "rule__Atom__Group_0__2"
    // InternalSymg.g:5478:1: rule__Atom__Group_0__2 : rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 ;
    public final void rule__Atom__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5482:1: ( rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 )
            // InternalSymg.g:5483:2: rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3
            {
            pushFollow(FOLLOW_8);
            rule__Atom__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__2"


    // $ANTLR start "rule__Atom__Group_0__2__Impl"
    // InternalSymg.g:5490:1: rule__Atom__Group_0__2__Impl : ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) ;
    public final void rule__Atom__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5494:1: ( ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) )
            // InternalSymg.g:5495:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            {
            // InternalSymg.g:5495:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            // InternalSymg.g:5496:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            {
             before(grammarAccess.getAtomAccess().getEventPropositionAssignment_0_2()); 
            // InternalSymg.g:5497:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            // InternalSymg.g:5497:3: rule__Atom__EventPropositionAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Atom__EventPropositionAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getEventPropositionAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__2__Impl"


    // $ANTLR start "rule__Atom__Group_0__3"
    // InternalSymg.g:5505:1: rule__Atom__Group_0__3 : rule__Atom__Group_0__3__Impl ;
    public final void rule__Atom__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5509:1: ( rule__Atom__Group_0__3__Impl )
            // InternalSymg.g:5510:2: rule__Atom__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__3"


    // $ANTLR start "rule__Atom__Group_0__3__Impl"
    // InternalSymg.g:5516:1: rule__Atom__Group_0__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5520:1: ( ( ')' ) )
            // InternalSymg.g:5521:1: ( ')' )
            {
            // InternalSymg.g:5521:1: ( ')' )
            // InternalSymg.g:5522:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_0_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getRightParenthesisKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_0__3__Impl"


    // $ANTLR start "rule__Atom__Group_1__0"
    // InternalSymg.g:5532:1: rule__Atom__Group_1__0 : rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 ;
    public final void rule__Atom__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5536:1: ( rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 )
            // InternalSymg.g:5537:2: rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__Atom__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__0"


    // $ANTLR start "rule__Atom__Group_1__0__Impl"
    // InternalSymg.g:5544:1: rule__Atom__Group_1__0__Impl : ( 'occurs' ) ;
    public final void rule__Atom__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5548:1: ( ( 'occurs' ) )
            // InternalSymg.g:5549:1: ( 'occurs' )
            {
            // InternalSymg.g:5549:1: ( 'occurs' )
            // InternalSymg.g:5550:2: 'occurs'
            {
             before(grammarAccess.getAtomAccess().getOccursKeyword_1_0()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getOccursKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__0__Impl"


    // $ANTLR start "rule__Atom__Group_1__1"
    // InternalSymg.g:5559:1: rule__Atom__Group_1__1 : rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 ;
    public final void rule__Atom__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5563:1: ( rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 )
            // InternalSymg.g:5564:2: rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2
            {
            pushFollow(FOLLOW_29);
            rule__Atom__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__1"


    // $ANTLR start "rule__Atom__Group_1__1__Impl"
    // InternalSymg.g:5571:1: rule__Atom__Group_1__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5575:1: ( ( '(' ) )
            // InternalSymg.g:5576:1: ( '(' )
            {
            // InternalSymg.g:5576:1: ( '(' )
            // InternalSymg.g:5577:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__1__Impl"


    // $ANTLR start "rule__Atom__Group_1__2"
    // InternalSymg.g:5586:1: rule__Atom__Group_1__2 : rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 ;
    public final void rule__Atom__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5590:1: ( rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 )
            // InternalSymg.g:5591:2: rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3
            {
            pushFollow(FOLLOW_8);
            rule__Atom__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__2"


    // $ANTLR start "rule__Atom__Group_1__2__Impl"
    // InternalSymg.g:5598:1: rule__Atom__Group_1__2__Impl : ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) ;
    public final void rule__Atom__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5602:1: ( ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) )
            // InternalSymg.g:5603:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            {
            // InternalSymg.g:5603:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            // InternalSymg.g:5604:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            {
             before(grammarAccess.getAtomAccess().getSituationPropositionAssignment_1_2()); 
            // InternalSymg.g:5605:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            // InternalSymg.g:5605:3: rule__Atom__SituationPropositionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Atom__SituationPropositionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getSituationPropositionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__2__Impl"


    // $ANTLR start "rule__Atom__Group_1__3"
    // InternalSymg.g:5613:1: rule__Atom__Group_1__3 : rule__Atom__Group_1__3__Impl ;
    public final void rule__Atom__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5617:1: ( rule__Atom__Group_1__3__Impl )
            // InternalSymg.g:5618:2: rule__Atom__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__3"


    // $ANTLR start "rule__Atom__Group_1__3__Impl"
    // InternalSymg.g:5624:1: rule__Atom__Group_1__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5628:1: ( ( ')' ) )
            // InternalSymg.g:5629:1: ( ')' )
            {
            // InternalSymg.g:5629:1: ( ')' )
            // InternalSymg.g:5630:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_1_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getRightParenthesisKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_1__3__Impl"


    // $ANTLR start "rule__Atom__Group_2__0"
    // InternalSymg.g:5640:1: rule__Atom__Group_2__0 : rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 ;
    public final void rule__Atom__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5644:1: ( rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 )
            // InternalSymg.g:5645:2: rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1
            {
            pushFollow(FOLLOW_12);
            rule__Atom__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__0"


    // $ANTLR start "rule__Atom__Group_2__0__Impl"
    // InternalSymg.g:5652:1: rule__Atom__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Atom__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5656:1: ( ( '(' ) )
            // InternalSymg.g:5657:1: ( '(' )
            {
            // InternalSymg.g:5657:1: ( '(' )
            // InternalSymg.g:5658:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__0__Impl"


    // $ANTLR start "rule__Atom__Group_2__1"
    // InternalSymg.g:5667:1: rule__Atom__Group_2__1 : rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 ;
    public final void rule__Atom__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5671:1: ( rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 )
            // InternalSymg.g:5672:2: rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2
            {
            pushFollow(FOLLOW_8);
            rule__Atom__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__1"


    // $ANTLR start "rule__Atom__Group_2__1__Impl"
    // InternalSymg.g:5679:1: rule__Atom__Group_2__1__Impl : ( ( rule__Atom__InnerAssignment_2_1 ) ) ;
    public final void rule__Atom__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5683:1: ( ( ( rule__Atom__InnerAssignment_2_1 ) ) )
            // InternalSymg.g:5684:1: ( ( rule__Atom__InnerAssignment_2_1 ) )
            {
            // InternalSymg.g:5684:1: ( ( rule__Atom__InnerAssignment_2_1 ) )
            // InternalSymg.g:5685:2: ( rule__Atom__InnerAssignment_2_1 )
            {
             before(grammarAccess.getAtomAccess().getInnerAssignment_2_1()); 
            // InternalSymg.g:5686:2: ( rule__Atom__InnerAssignment_2_1 )
            // InternalSymg.g:5686:3: rule__Atom__InnerAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Atom__InnerAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getInnerAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__1__Impl"


    // $ANTLR start "rule__Atom__Group_2__2"
    // InternalSymg.g:5694:1: rule__Atom__Group_2__2 : rule__Atom__Group_2__2__Impl ;
    public final void rule__Atom__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5698:1: ( rule__Atom__Group_2__2__Impl )
            // InternalSymg.g:5699:2: rule__Atom__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__2"


    // $ANTLR start "rule__Atom__Group_2__2__Impl"
    // InternalSymg.g:5705:1: rule__Atom__Group_2__2__Impl : ( ')' ) ;
    public final void rule__Atom__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5709:1: ( ( ')' ) )
            // InternalSymg.g:5710:1: ( ')' )
            {
            // InternalSymg.g:5710:1: ( ')' )
            // InternalSymg.g:5711:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_2_2()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_2__2__Impl"


    // $ANTLR start "rule__Atom__Group_3__0"
    // InternalSymg.g:5721:1: rule__Atom__Group_3__0 : rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 ;
    public final void rule__Atom__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5725:1: ( rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 )
            // InternalSymg.g:5726:2: rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1
            {
            pushFollow(FOLLOW_30);
            rule__Atom__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__0"


    // $ANTLR start "rule__Atom__Group_3__0__Impl"
    // InternalSymg.g:5733:1: rule__Atom__Group_3__0__Impl : ( ( rule__Atom__PointAssignment_3_0 ) ) ;
    public final void rule__Atom__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5737:1: ( ( ( rule__Atom__PointAssignment_3_0 ) ) )
            // InternalSymg.g:5738:1: ( ( rule__Atom__PointAssignment_3_0 ) )
            {
            // InternalSymg.g:5738:1: ( ( rule__Atom__PointAssignment_3_0 ) )
            // InternalSymg.g:5739:2: ( rule__Atom__PointAssignment_3_0 )
            {
             before(grammarAccess.getAtomAccess().getPointAssignment_3_0()); 
            // InternalSymg.g:5740:2: ( rule__Atom__PointAssignment_3_0 )
            // InternalSymg.g:5740:3: rule__Atom__PointAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Atom__PointAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getPointAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__0__Impl"


    // $ANTLR start "rule__Atom__Group_3__1"
    // InternalSymg.g:5748:1: rule__Atom__Group_3__1 : rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2 ;
    public final void rule__Atom__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5752:1: ( rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2 )
            // InternalSymg.g:5753:2: rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2
            {
            pushFollow(FOLLOW_31);
            rule__Atom__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Atom__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__1"


    // $ANTLR start "rule__Atom__Group_3__1__Impl"
    // InternalSymg.g:5760:1: rule__Atom__Group_3__1__Impl : ( 'within' ) ;
    public final void rule__Atom__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5764:1: ( ( 'within' ) )
            // InternalSymg.g:5765:1: ( 'within' )
            {
            // InternalSymg.g:5765:1: ( 'within' )
            // InternalSymg.g:5766:2: 'within'
            {
             before(grammarAccess.getAtomAccess().getWithinKeyword_3_1()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getWithinKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__1__Impl"


    // $ANTLR start "rule__Atom__Group_3__2"
    // InternalSymg.g:5775:1: rule__Atom__Group_3__2 : rule__Atom__Group_3__2__Impl ;
    public final void rule__Atom__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5779:1: ( rule__Atom__Group_3__2__Impl )
            // InternalSymg.g:5780:2: rule__Atom__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Atom__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__2"


    // $ANTLR start "rule__Atom__Group_3__2__Impl"
    // InternalSymg.g:5786:1: rule__Atom__Group_3__2__Impl : ( ( rule__Atom__IntervalAssignment_3_2 ) ) ;
    public final void rule__Atom__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5790:1: ( ( ( rule__Atom__IntervalAssignment_3_2 ) ) )
            // InternalSymg.g:5791:1: ( ( rule__Atom__IntervalAssignment_3_2 ) )
            {
            // InternalSymg.g:5791:1: ( ( rule__Atom__IntervalAssignment_3_2 ) )
            // InternalSymg.g:5792:2: ( rule__Atom__IntervalAssignment_3_2 )
            {
             before(grammarAccess.getAtomAccess().getIntervalAssignment_3_2()); 
            // InternalSymg.g:5793:2: ( rule__Atom__IntervalAssignment_3_2 )
            // InternalSymg.g:5793:3: rule__Atom__IntervalAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Atom__IntervalAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getIntervalAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__Group_3__2__Impl"


    // $ANTLR start "rule__SitProp__Group__0"
    // InternalSymg.g:5802:1: rule__SitProp__Group__0 : rule__SitProp__Group__0__Impl rule__SitProp__Group__1 ;
    public final void rule__SitProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5806:1: ( rule__SitProp__Group__0__Impl rule__SitProp__Group__1 )
            // InternalSymg.g:5807:2: rule__SitProp__Group__0__Impl rule__SitProp__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__SitProp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SitProp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__0"


    // $ANTLR start "rule__SitProp__Group__0__Impl"
    // InternalSymg.g:5814:1: rule__SitProp__Group__0__Impl : ( ( rule__SitProp__Alternatives_0 ) ) ;
    public final void rule__SitProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5818:1: ( ( ( rule__SitProp__Alternatives_0 ) ) )
            // InternalSymg.g:5819:1: ( ( rule__SitProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5819:1: ( ( rule__SitProp__Alternatives_0 ) )
            // InternalSymg.g:5820:2: ( rule__SitProp__Alternatives_0 )
            {
             before(grammarAccess.getSitPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5821:2: ( rule__SitProp__Alternatives_0 )
            // InternalSymg.g:5821:3: rule__SitProp__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__SitProp__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getSitPropAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__0__Impl"


    // $ANTLR start "rule__SitProp__Group__1"
    // InternalSymg.g:5829:1: rule__SitProp__Group__1 : rule__SitProp__Group__1__Impl rule__SitProp__Group__2 ;
    public final void rule__SitProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5833:1: ( rule__SitProp__Group__1__Impl rule__SitProp__Group__2 )
            // InternalSymg.g:5834:2: rule__SitProp__Group__1__Impl rule__SitProp__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__SitProp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SitProp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__1"


    // $ANTLR start "rule__SitProp__Group__1__Impl"
    // InternalSymg.g:5841:1: rule__SitProp__Group__1__Impl : ( ',' ) ;
    public final void rule__SitProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5845:1: ( ( ',' ) )
            // InternalSymg.g:5846:1: ( ',' )
            {
            // InternalSymg.g:5846:1: ( ',' )
            // InternalSymg.g:5847:2: ','
            {
             before(grammarAccess.getSitPropAccess().getCommaKeyword_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getSitPropAccess().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__1__Impl"


    // $ANTLR start "rule__SitProp__Group__2"
    // InternalSymg.g:5856:1: rule__SitProp__Group__2 : rule__SitProp__Group__2__Impl ;
    public final void rule__SitProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5860:1: ( rule__SitProp__Group__2__Impl )
            // InternalSymg.g:5861:2: rule__SitProp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SitProp__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__2"


    // $ANTLR start "rule__SitProp__Group__2__Impl"
    // InternalSymg.g:5867:1: rule__SitProp__Group__2__Impl : ( ( rule__SitProp__IntervalAssignment_2 ) ) ;
    public final void rule__SitProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5871:1: ( ( ( rule__SitProp__IntervalAssignment_2 ) ) )
            // InternalSymg.g:5872:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            {
            // InternalSymg.g:5872:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            // InternalSymg.g:5873:2: ( rule__SitProp__IntervalAssignment_2 )
            {
             before(grammarAccess.getSitPropAccess().getIntervalAssignment_2()); 
            // InternalSymg.g:5874:2: ( rule__SitProp__IntervalAssignment_2 )
            // InternalSymg.g:5874:3: rule__SitProp__IntervalAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SitProp__IntervalAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSitPropAccess().getIntervalAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__Group__2__Impl"


    // $ANTLR start "rule__EventProp__Group__0"
    // InternalSymg.g:5883:1: rule__EventProp__Group__0 : rule__EventProp__Group__0__Impl rule__EventProp__Group__1 ;
    public final void rule__EventProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5887:1: ( rule__EventProp__Group__0__Impl rule__EventProp__Group__1 )
            // InternalSymg.g:5888:2: rule__EventProp__Group__0__Impl rule__EventProp__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__EventProp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EventProp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__0"


    // $ANTLR start "rule__EventProp__Group__0__Impl"
    // InternalSymg.g:5895:1: rule__EventProp__Group__0__Impl : ( ( rule__EventProp__Alternatives_0 ) ) ;
    public final void rule__EventProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5899:1: ( ( ( rule__EventProp__Alternatives_0 ) ) )
            // InternalSymg.g:5900:1: ( ( rule__EventProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5900:1: ( ( rule__EventProp__Alternatives_0 ) )
            // InternalSymg.g:5901:2: ( rule__EventProp__Alternatives_0 )
            {
             before(grammarAccess.getEventPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5902:2: ( rule__EventProp__Alternatives_0 )
            // InternalSymg.g:5902:3: rule__EventProp__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__EventProp__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getEventPropAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__0__Impl"


    // $ANTLR start "rule__EventProp__Group__1"
    // InternalSymg.g:5910:1: rule__EventProp__Group__1 : rule__EventProp__Group__1__Impl rule__EventProp__Group__2 ;
    public final void rule__EventProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5914:1: ( rule__EventProp__Group__1__Impl rule__EventProp__Group__2 )
            // InternalSymg.g:5915:2: rule__EventProp__Group__1__Impl rule__EventProp__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__EventProp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EventProp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__1"


    // $ANTLR start "rule__EventProp__Group__1__Impl"
    // InternalSymg.g:5922:1: rule__EventProp__Group__1__Impl : ( ',' ) ;
    public final void rule__EventProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5926:1: ( ( ',' ) )
            // InternalSymg.g:5927:1: ( ',' )
            {
            // InternalSymg.g:5927:1: ( ',' )
            // InternalSymg.g:5928:2: ','
            {
             before(grammarAccess.getEventPropAccess().getCommaKeyword_1()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getEventPropAccess().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__1__Impl"


    // $ANTLR start "rule__EventProp__Group__2"
    // InternalSymg.g:5937:1: rule__EventProp__Group__2 : rule__EventProp__Group__2__Impl ;
    public final void rule__EventProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5941:1: ( rule__EventProp__Group__2__Impl )
            // InternalSymg.g:5942:2: rule__EventProp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EventProp__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__2"


    // $ANTLR start "rule__EventProp__Group__2__Impl"
    // InternalSymg.g:5948:1: rule__EventProp__Group__2__Impl : ( ( rule__EventProp__PointAssignment_2 ) ) ;
    public final void rule__EventProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5952:1: ( ( ( rule__EventProp__PointAssignment_2 ) ) )
            // InternalSymg.g:5953:1: ( ( rule__EventProp__PointAssignment_2 ) )
            {
            // InternalSymg.g:5953:1: ( ( rule__EventProp__PointAssignment_2 ) )
            // InternalSymg.g:5954:2: ( rule__EventProp__PointAssignment_2 )
            {
             before(grammarAccess.getEventPropAccess().getPointAssignment_2()); 
            // InternalSymg.g:5955:2: ( rule__EventProp__PointAssignment_2 )
            // InternalSymg.g:5955:3: rule__EventProp__PointAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EventProp__PointAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEventPropAccess().getPointAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__Group__2__Impl"


    // $ANTLR start "rule__Interval__Group_1__0"
    // InternalSymg.g:5964:1: rule__Interval__Group_1__0 : rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 ;
    public final void rule__Interval__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5968:1: ( rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 )
            // InternalSymg.g:5969:2: rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1
            {
            pushFollow(FOLLOW_32);
            rule__Interval__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__0"


    // $ANTLR start "rule__Interval__Group_1__0__Impl"
    // InternalSymg.g:5976:1: rule__Interval__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Interval__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5980:1: ( ( '[' ) )
            // InternalSymg.g:5981:1: ( '[' )
            {
            // InternalSymg.g:5981:1: ( '[' )
            // InternalSymg.g:5982:2: '['
            {
             before(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__0__Impl"


    // $ANTLR start "rule__Interval__Group_1__1"
    // InternalSymg.g:5991:1: rule__Interval__Group_1__1 : rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 ;
    public final void rule__Interval__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5995:1: ( rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 )
            // InternalSymg.g:5996:2: rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__Interval__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__1"


    // $ANTLR start "rule__Interval__Group_1__1__Impl"
    // InternalSymg.g:6003:1: rule__Interval__Group_1__1__Impl : ( ( rule__Interval__StartAssignment_1_1 ) ) ;
    public final void rule__Interval__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6007:1: ( ( ( rule__Interval__StartAssignment_1_1 ) ) )
            // InternalSymg.g:6008:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            {
            // InternalSymg.g:6008:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            // InternalSymg.g:6009:2: ( rule__Interval__StartAssignment_1_1 )
            {
             before(grammarAccess.getIntervalAccess().getStartAssignment_1_1()); 
            // InternalSymg.g:6010:2: ( rule__Interval__StartAssignment_1_1 )
            // InternalSymg.g:6010:3: rule__Interval__StartAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Interval__StartAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getStartAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__1__Impl"


    // $ANTLR start "rule__Interval__Group_1__2"
    // InternalSymg.g:6018:1: rule__Interval__Group_1__2 : rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 ;
    public final void rule__Interval__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6022:1: ( rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 )
            // InternalSymg.g:6023:2: rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3
            {
            pushFollow(FOLLOW_32);
            rule__Interval__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__2"


    // $ANTLR start "rule__Interval__Group_1__2__Impl"
    // InternalSymg.g:6030:1: rule__Interval__Group_1__2__Impl : ( ',' ) ;
    public final void rule__Interval__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6034:1: ( ( ',' ) )
            // InternalSymg.g:6035:1: ( ',' )
            {
            // InternalSymg.g:6035:1: ( ',' )
            // InternalSymg.g:6036:2: ','
            {
             before(grammarAccess.getIntervalAccess().getCommaKeyword_1_2()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getIntervalAccess().getCommaKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__2__Impl"


    // $ANTLR start "rule__Interval__Group_1__3"
    // InternalSymg.g:6045:1: rule__Interval__Group_1__3 : rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 ;
    public final void rule__Interval__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6049:1: ( rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 )
            // InternalSymg.g:6050:2: rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4
            {
            pushFollow(FOLLOW_33);
            rule__Interval__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__3"


    // $ANTLR start "rule__Interval__Group_1__3__Impl"
    // InternalSymg.g:6057:1: rule__Interval__Group_1__3__Impl : ( ( rule__Interval__EndAssignment_1_3 ) ) ;
    public final void rule__Interval__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6061:1: ( ( ( rule__Interval__EndAssignment_1_3 ) ) )
            // InternalSymg.g:6062:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            {
            // InternalSymg.g:6062:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            // InternalSymg.g:6063:2: ( rule__Interval__EndAssignment_1_3 )
            {
             before(grammarAccess.getIntervalAccess().getEndAssignment_1_3()); 
            // InternalSymg.g:6064:2: ( rule__Interval__EndAssignment_1_3 )
            // InternalSymg.g:6064:3: rule__Interval__EndAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__Interval__EndAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getEndAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__3__Impl"


    // $ANTLR start "rule__Interval__Group_1__4"
    // InternalSymg.g:6072:1: rule__Interval__Group_1__4 : rule__Interval__Group_1__4__Impl ;
    public final void rule__Interval__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6076:1: ( rule__Interval__Group_1__4__Impl )
            // InternalSymg.g:6077:2: rule__Interval__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interval__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__4"


    // $ANTLR start "rule__Interval__Group_1__4__Impl"
    // InternalSymg.g:6083:1: rule__Interval__Group_1__4__Impl : ( ']' ) ;
    public final void rule__Interval__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6087:1: ( ( ']' ) )
            // InternalSymg.g:6088:1: ( ']' )
            {
            // InternalSymg.g:6088:1: ( ']' )
            // InternalSymg.g:6089:2: ']'
            {
             before(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_1_4()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_1__4__Impl"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__0"
    // InternalSymg.g:6099:1: rule__RelativeSituationPointBefore__Group__0 : rule__RelativeSituationPointBefore__Group__0__Impl rule__RelativeSituationPointBefore__Group__1 ;
    public final void rule__RelativeSituationPointBefore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6103:1: ( rule__RelativeSituationPointBefore__Group__0__Impl rule__RelativeSituationPointBefore__Group__1 )
            // InternalSymg.g:6104:2: rule__RelativeSituationPointBefore__Group__0__Impl rule__RelativeSituationPointBefore__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__RelativeSituationPointBefore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__0"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__0__Impl"
    // InternalSymg.g:6111:1: rule__RelativeSituationPointBefore__Group__0__Impl : ( ( rule__RelativeSituationPointBefore__IntConstAssignment_0 ) ) ;
    public final void rule__RelativeSituationPointBefore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6115:1: ( ( ( rule__RelativeSituationPointBefore__IntConstAssignment_0 ) ) )
            // InternalSymg.g:6116:1: ( ( rule__RelativeSituationPointBefore__IntConstAssignment_0 ) )
            {
            // InternalSymg.g:6116:1: ( ( rule__RelativeSituationPointBefore__IntConstAssignment_0 ) )
            // InternalSymg.g:6117:2: ( rule__RelativeSituationPointBefore__IntConstAssignment_0 )
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getIntConstAssignment_0()); 
            // InternalSymg.g:6118:2: ( rule__RelativeSituationPointBefore__IntConstAssignment_0 )
            // InternalSymg.g:6118:3: rule__RelativeSituationPointBefore__IntConstAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__IntConstAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getIntConstAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__0__Impl"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__1"
    // InternalSymg.g:6126:1: rule__RelativeSituationPointBefore__Group__1 : rule__RelativeSituationPointBefore__Group__1__Impl rule__RelativeSituationPointBefore__Group__2 ;
    public final void rule__RelativeSituationPointBefore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6130:1: ( rule__RelativeSituationPointBefore__Group__1__Impl rule__RelativeSituationPointBefore__Group__2 )
            // InternalSymg.g:6131:2: rule__RelativeSituationPointBefore__Group__1__Impl rule__RelativeSituationPointBefore__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__RelativeSituationPointBefore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__1"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__1__Impl"
    // InternalSymg.g:6138:1: rule__RelativeSituationPointBefore__Group__1__Impl : ( ( rule__RelativeSituationPointBefore__UnitAssignment_1 ) ) ;
    public final void rule__RelativeSituationPointBefore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6142:1: ( ( ( rule__RelativeSituationPointBefore__UnitAssignment_1 ) ) )
            // InternalSymg.g:6143:1: ( ( rule__RelativeSituationPointBefore__UnitAssignment_1 ) )
            {
            // InternalSymg.g:6143:1: ( ( rule__RelativeSituationPointBefore__UnitAssignment_1 ) )
            // InternalSymg.g:6144:2: ( rule__RelativeSituationPointBefore__UnitAssignment_1 )
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getUnitAssignment_1()); 
            // InternalSymg.g:6145:2: ( rule__RelativeSituationPointBefore__UnitAssignment_1 )
            // InternalSymg.g:6145:3: rule__RelativeSituationPointBefore__UnitAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__UnitAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getUnitAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__1__Impl"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__2"
    // InternalSymg.g:6153:1: rule__RelativeSituationPointBefore__Group__2 : rule__RelativeSituationPointBefore__Group__2__Impl rule__RelativeSituationPointBefore__Group__3 ;
    public final void rule__RelativeSituationPointBefore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6157:1: ( rule__RelativeSituationPointBefore__Group__2__Impl rule__RelativeSituationPointBefore__Group__3 )
            // InternalSymg.g:6158:2: rule__RelativeSituationPointBefore__Group__2__Impl rule__RelativeSituationPointBefore__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__RelativeSituationPointBefore__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__2"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__2__Impl"
    // InternalSymg.g:6165:1: rule__RelativeSituationPointBefore__Group__2__Impl : ( ( rule__RelativeSituationPointBefore__TempOpAssignment_2 ) ) ;
    public final void rule__RelativeSituationPointBefore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6169:1: ( ( ( rule__RelativeSituationPointBefore__TempOpAssignment_2 ) ) )
            // InternalSymg.g:6170:1: ( ( rule__RelativeSituationPointBefore__TempOpAssignment_2 ) )
            {
            // InternalSymg.g:6170:1: ( ( rule__RelativeSituationPointBefore__TempOpAssignment_2 ) )
            // InternalSymg.g:6171:2: ( rule__RelativeSituationPointBefore__TempOpAssignment_2 )
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getTempOpAssignment_2()); 
            // InternalSymg.g:6172:2: ( rule__RelativeSituationPointBefore__TempOpAssignment_2 )
            // InternalSymg.g:6172:3: rule__RelativeSituationPointBefore__TempOpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__TempOpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getTempOpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__2__Impl"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__3"
    // InternalSymg.g:6180:1: rule__RelativeSituationPointBefore__Group__3 : rule__RelativeSituationPointBefore__Group__3__Impl ;
    public final void rule__RelativeSituationPointBefore__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6184:1: ( rule__RelativeSituationPointBefore__Group__3__Impl )
            // InternalSymg.g:6185:2: rule__RelativeSituationPointBefore__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__3"


    // $ANTLR start "rule__RelativeSituationPointBefore__Group__3__Impl"
    // InternalSymg.g:6191:1: rule__RelativeSituationPointBefore__Group__3__Impl : ( ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 ) ) ;
    public final void rule__RelativeSituationPointBefore__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6195:1: ( ( ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 ) ) )
            // InternalSymg.g:6196:1: ( ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 ) )
            {
            // InternalSymg.g:6196:1: ( ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 ) )
            // InternalSymg.g:6197:2: ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 )
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getSituationNameAssignment_3()); 
            // InternalSymg.g:6198:2: ( rule__RelativeSituationPointBefore__SituationNameAssignment_3 )
            // InternalSymg.g:6198:3: rule__RelativeSituationPointBefore__SituationNameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointBefore__SituationNameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getSituationNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__Group__3__Impl"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__0"
    // InternalSymg.g:6207:1: rule__RelativeSituationPointAfter__Group__0 : rule__RelativeSituationPointAfter__Group__0__Impl rule__RelativeSituationPointAfter__Group__1 ;
    public final void rule__RelativeSituationPointAfter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6211:1: ( rule__RelativeSituationPointAfter__Group__0__Impl rule__RelativeSituationPointAfter__Group__1 )
            // InternalSymg.g:6212:2: rule__RelativeSituationPointAfter__Group__0__Impl rule__RelativeSituationPointAfter__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__RelativeSituationPointAfter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__0"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__0__Impl"
    // InternalSymg.g:6219:1: rule__RelativeSituationPointAfter__Group__0__Impl : ( ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 ) ) ;
    public final void rule__RelativeSituationPointAfter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6223:1: ( ( ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 ) ) )
            // InternalSymg.g:6224:1: ( ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 ) )
            {
            // InternalSymg.g:6224:1: ( ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 ) )
            // InternalSymg.g:6225:2: ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 )
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getSituationNameAssignment_0()); 
            // InternalSymg.g:6226:2: ( rule__RelativeSituationPointAfter__SituationNameAssignment_0 )
            // InternalSymg.g:6226:3: rule__RelativeSituationPointAfter__SituationNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__SituationNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointAfterAccess().getSituationNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__0__Impl"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__1"
    // InternalSymg.g:6234:1: rule__RelativeSituationPointAfter__Group__1 : rule__RelativeSituationPointAfter__Group__1__Impl rule__RelativeSituationPointAfter__Group__2 ;
    public final void rule__RelativeSituationPointAfter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6238:1: ( rule__RelativeSituationPointAfter__Group__1__Impl rule__RelativeSituationPointAfter__Group__2 )
            // InternalSymg.g:6239:2: rule__RelativeSituationPointAfter__Group__1__Impl rule__RelativeSituationPointAfter__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__RelativeSituationPointAfter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__1"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__1__Impl"
    // InternalSymg.g:6246:1: rule__RelativeSituationPointAfter__Group__1__Impl : ( ( rule__RelativeSituationPointAfter__TempOpAssignment_1 ) ) ;
    public final void rule__RelativeSituationPointAfter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6250:1: ( ( ( rule__RelativeSituationPointAfter__TempOpAssignment_1 ) ) )
            // InternalSymg.g:6251:1: ( ( rule__RelativeSituationPointAfter__TempOpAssignment_1 ) )
            {
            // InternalSymg.g:6251:1: ( ( rule__RelativeSituationPointAfter__TempOpAssignment_1 ) )
            // InternalSymg.g:6252:2: ( rule__RelativeSituationPointAfter__TempOpAssignment_1 )
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getTempOpAssignment_1()); 
            // InternalSymg.g:6253:2: ( rule__RelativeSituationPointAfter__TempOpAssignment_1 )
            // InternalSymg.g:6253:3: rule__RelativeSituationPointAfter__TempOpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__TempOpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointAfterAccess().getTempOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__1__Impl"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__2"
    // InternalSymg.g:6261:1: rule__RelativeSituationPointAfter__Group__2 : rule__RelativeSituationPointAfter__Group__2__Impl rule__RelativeSituationPointAfter__Group__3 ;
    public final void rule__RelativeSituationPointAfter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6265:1: ( rule__RelativeSituationPointAfter__Group__2__Impl rule__RelativeSituationPointAfter__Group__3 )
            // InternalSymg.g:6266:2: rule__RelativeSituationPointAfter__Group__2__Impl rule__RelativeSituationPointAfter__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__RelativeSituationPointAfter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__2"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__2__Impl"
    // InternalSymg.g:6273:1: rule__RelativeSituationPointAfter__Group__2__Impl : ( ( rule__RelativeSituationPointAfter__IntConstAssignment_2 ) ) ;
    public final void rule__RelativeSituationPointAfter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6277:1: ( ( ( rule__RelativeSituationPointAfter__IntConstAssignment_2 ) ) )
            // InternalSymg.g:6278:1: ( ( rule__RelativeSituationPointAfter__IntConstAssignment_2 ) )
            {
            // InternalSymg.g:6278:1: ( ( rule__RelativeSituationPointAfter__IntConstAssignment_2 ) )
            // InternalSymg.g:6279:2: ( rule__RelativeSituationPointAfter__IntConstAssignment_2 )
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getIntConstAssignment_2()); 
            // InternalSymg.g:6280:2: ( rule__RelativeSituationPointAfter__IntConstAssignment_2 )
            // InternalSymg.g:6280:3: rule__RelativeSituationPointAfter__IntConstAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__IntConstAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointAfterAccess().getIntConstAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__2__Impl"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__3"
    // InternalSymg.g:6288:1: rule__RelativeSituationPointAfter__Group__3 : rule__RelativeSituationPointAfter__Group__3__Impl ;
    public final void rule__RelativeSituationPointAfter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6292:1: ( rule__RelativeSituationPointAfter__Group__3__Impl )
            // InternalSymg.g:6293:2: rule__RelativeSituationPointAfter__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__3"


    // $ANTLR start "rule__RelativeSituationPointAfter__Group__3__Impl"
    // InternalSymg.g:6299:1: rule__RelativeSituationPointAfter__Group__3__Impl : ( ( rule__RelativeSituationPointAfter__UnitAssignment_3 ) ) ;
    public final void rule__RelativeSituationPointAfter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6303:1: ( ( ( rule__RelativeSituationPointAfter__UnitAssignment_3 ) ) )
            // InternalSymg.g:6304:1: ( ( rule__RelativeSituationPointAfter__UnitAssignment_3 ) )
            {
            // InternalSymg.g:6304:1: ( ( rule__RelativeSituationPointAfter__UnitAssignment_3 ) )
            // InternalSymg.g:6305:2: ( rule__RelativeSituationPointAfter__UnitAssignment_3 )
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getUnitAssignment_3()); 
            // InternalSymg.g:6306:2: ( rule__RelativeSituationPointAfter__UnitAssignment_3 )
            // InternalSymg.g:6306:3: rule__RelativeSituationPointAfter__UnitAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RelativeSituationPointAfter__UnitAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRelativeSituationPointAfterAccess().getUnitAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__Group__3__Impl"


    // $ANTLR start "rule__IntConst__Group__0"
    // InternalSymg.g:6315:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6319:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // InternalSymg.g:6320:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__IntConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__0"


    // $ANTLR start "rule__IntConst__Group__0__Impl"
    // InternalSymg.g:6327:1: rule__IntConst__Group__0__Impl : ( () ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6331:1: ( ( () ) )
            // InternalSymg.g:6332:1: ( () )
            {
            // InternalSymg.g:6332:1: ( () )
            // InternalSymg.g:6333:2: ()
            {
             before(grammarAccess.getIntConstAccess().getIntConstAction_0()); 
            // InternalSymg.g:6334:2: ()
            // InternalSymg.g:6334:3: 
            {
            }

             after(grammarAccess.getIntConstAccess().getIntConstAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__0__Impl"


    // $ANTLR start "rule__IntConst__Group__1"
    // InternalSymg.g:6342:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6346:1: ( rule__IntConst__Group__1__Impl )
            // InternalSymg.g:6347:2: rule__IntConst__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntConst__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__1"


    // $ANTLR start "rule__IntConst__Group__1__Impl"
    // InternalSymg.g:6353:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__TypeAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6357:1: ( ( ( rule__IntConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6358:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6358:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            // InternalSymg.g:6359:2: ( rule__IntConst__TypeAssignment_1 )
            {
             before(grammarAccess.getIntConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6360:2: ( rule__IntConst__TypeAssignment_1 )
            // InternalSymg.g:6360:3: rule__IntConst__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IntConst__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntConstAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__Group__1__Impl"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__0"
    // InternalSymg.g:6369:1: rule__RelativeEventPointBefore__Group__0 : rule__RelativeEventPointBefore__Group__0__Impl rule__RelativeEventPointBefore__Group__1 ;
    public final void rule__RelativeEventPointBefore__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6373:1: ( rule__RelativeEventPointBefore__Group__0__Impl rule__RelativeEventPointBefore__Group__1 )
            // InternalSymg.g:6374:2: rule__RelativeEventPointBefore__Group__0__Impl rule__RelativeEventPointBefore__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__RelativeEventPointBefore__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__0"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__0__Impl"
    // InternalSymg.g:6381:1: rule__RelativeEventPointBefore__Group__0__Impl : ( ( rule__RelativeEventPointBefore__PointConstAssignment_0 ) ) ;
    public final void rule__RelativeEventPointBefore__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6385:1: ( ( ( rule__RelativeEventPointBefore__PointConstAssignment_0 ) ) )
            // InternalSymg.g:6386:1: ( ( rule__RelativeEventPointBefore__PointConstAssignment_0 ) )
            {
            // InternalSymg.g:6386:1: ( ( rule__RelativeEventPointBefore__PointConstAssignment_0 ) )
            // InternalSymg.g:6387:2: ( rule__RelativeEventPointBefore__PointConstAssignment_0 )
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getPointConstAssignment_0()); 
            // InternalSymg.g:6388:2: ( rule__RelativeEventPointBefore__PointConstAssignment_0 )
            // InternalSymg.g:6388:3: rule__RelativeEventPointBefore__PointConstAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__PointConstAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointBeforeAccess().getPointConstAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__0__Impl"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__1"
    // InternalSymg.g:6396:1: rule__RelativeEventPointBefore__Group__1 : rule__RelativeEventPointBefore__Group__1__Impl rule__RelativeEventPointBefore__Group__2 ;
    public final void rule__RelativeEventPointBefore__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6400:1: ( rule__RelativeEventPointBefore__Group__1__Impl rule__RelativeEventPointBefore__Group__2 )
            // InternalSymg.g:6401:2: rule__RelativeEventPointBefore__Group__1__Impl rule__RelativeEventPointBefore__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__RelativeEventPointBefore__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__1"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__1__Impl"
    // InternalSymg.g:6408:1: rule__RelativeEventPointBefore__Group__1__Impl : ( ( rule__RelativeEventPointBefore__UnitAssignment_1 ) ) ;
    public final void rule__RelativeEventPointBefore__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6412:1: ( ( ( rule__RelativeEventPointBefore__UnitAssignment_1 ) ) )
            // InternalSymg.g:6413:1: ( ( rule__RelativeEventPointBefore__UnitAssignment_1 ) )
            {
            // InternalSymg.g:6413:1: ( ( rule__RelativeEventPointBefore__UnitAssignment_1 ) )
            // InternalSymg.g:6414:2: ( rule__RelativeEventPointBefore__UnitAssignment_1 )
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getUnitAssignment_1()); 
            // InternalSymg.g:6415:2: ( rule__RelativeEventPointBefore__UnitAssignment_1 )
            // InternalSymg.g:6415:3: rule__RelativeEventPointBefore__UnitAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__UnitAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointBeforeAccess().getUnitAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__1__Impl"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__2"
    // InternalSymg.g:6423:1: rule__RelativeEventPointBefore__Group__2 : rule__RelativeEventPointBefore__Group__2__Impl rule__RelativeEventPointBefore__Group__3 ;
    public final void rule__RelativeEventPointBefore__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6427:1: ( rule__RelativeEventPointBefore__Group__2__Impl rule__RelativeEventPointBefore__Group__3 )
            // InternalSymg.g:6428:2: rule__RelativeEventPointBefore__Group__2__Impl rule__RelativeEventPointBefore__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__RelativeEventPointBefore__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__2"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__2__Impl"
    // InternalSymg.g:6435:1: rule__RelativeEventPointBefore__Group__2__Impl : ( ( rule__RelativeEventPointBefore__TempOpAssignment_2 ) ) ;
    public final void rule__RelativeEventPointBefore__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6439:1: ( ( ( rule__RelativeEventPointBefore__TempOpAssignment_2 ) ) )
            // InternalSymg.g:6440:1: ( ( rule__RelativeEventPointBefore__TempOpAssignment_2 ) )
            {
            // InternalSymg.g:6440:1: ( ( rule__RelativeEventPointBefore__TempOpAssignment_2 ) )
            // InternalSymg.g:6441:2: ( rule__RelativeEventPointBefore__TempOpAssignment_2 )
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getTempOpAssignment_2()); 
            // InternalSymg.g:6442:2: ( rule__RelativeEventPointBefore__TempOpAssignment_2 )
            // InternalSymg.g:6442:3: rule__RelativeEventPointBefore__TempOpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__TempOpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointBeforeAccess().getTempOpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__2__Impl"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__3"
    // InternalSymg.g:6450:1: rule__RelativeEventPointBefore__Group__3 : rule__RelativeEventPointBefore__Group__3__Impl ;
    public final void rule__RelativeEventPointBefore__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6454:1: ( rule__RelativeEventPointBefore__Group__3__Impl )
            // InternalSymg.g:6455:2: rule__RelativeEventPointBefore__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__3"


    // $ANTLR start "rule__RelativeEventPointBefore__Group__3__Impl"
    // InternalSymg.g:6461:1: rule__RelativeEventPointBefore__Group__3__Impl : ( ( rule__RelativeEventPointBefore__EventNameAssignment_3 ) ) ;
    public final void rule__RelativeEventPointBefore__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6465:1: ( ( ( rule__RelativeEventPointBefore__EventNameAssignment_3 ) ) )
            // InternalSymg.g:6466:1: ( ( rule__RelativeEventPointBefore__EventNameAssignment_3 ) )
            {
            // InternalSymg.g:6466:1: ( ( rule__RelativeEventPointBefore__EventNameAssignment_3 ) )
            // InternalSymg.g:6467:2: ( rule__RelativeEventPointBefore__EventNameAssignment_3 )
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getEventNameAssignment_3()); 
            // InternalSymg.g:6468:2: ( rule__RelativeEventPointBefore__EventNameAssignment_3 )
            // InternalSymg.g:6468:3: rule__RelativeEventPointBefore__EventNameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointBefore__EventNameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointBeforeAccess().getEventNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__Group__3__Impl"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__0"
    // InternalSymg.g:6477:1: rule__RelativeEventPointAfter__Group__0 : rule__RelativeEventPointAfter__Group__0__Impl rule__RelativeEventPointAfter__Group__1 ;
    public final void rule__RelativeEventPointAfter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6481:1: ( rule__RelativeEventPointAfter__Group__0__Impl rule__RelativeEventPointAfter__Group__1 )
            // InternalSymg.g:6482:2: rule__RelativeEventPointAfter__Group__0__Impl rule__RelativeEventPointAfter__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__RelativeEventPointAfter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__0"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__0__Impl"
    // InternalSymg.g:6489:1: rule__RelativeEventPointAfter__Group__0__Impl : ( ( rule__RelativeEventPointAfter__EventNameAssignment_0 ) ) ;
    public final void rule__RelativeEventPointAfter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6493:1: ( ( ( rule__RelativeEventPointAfter__EventNameAssignment_0 ) ) )
            // InternalSymg.g:6494:1: ( ( rule__RelativeEventPointAfter__EventNameAssignment_0 ) )
            {
            // InternalSymg.g:6494:1: ( ( rule__RelativeEventPointAfter__EventNameAssignment_0 ) )
            // InternalSymg.g:6495:2: ( rule__RelativeEventPointAfter__EventNameAssignment_0 )
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getEventNameAssignment_0()); 
            // InternalSymg.g:6496:2: ( rule__RelativeEventPointAfter__EventNameAssignment_0 )
            // InternalSymg.g:6496:3: rule__RelativeEventPointAfter__EventNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__EventNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointAfterAccess().getEventNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__0__Impl"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__1"
    // InternalSymg.g:6504:1: rule__RelativeEventPointAfter__Group__1 : rule__RelativeEventPointAfter__Group__1__Impl rule__RelativeEventPointAfter__Group__2 ;
    public final void rule__RelativeEventPointAfter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6508:1: ( rule__RelativeEventPointAfter__Group__1__Impl rule__RelativeEventPointAfter__Group__2 )
            // InternalSymg.g:6509:2: rule__RelativeEventPointAfter__Group__1__Impl rule__RelativeEventPointAfter__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__RelativeEventPointAfter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__1"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__1__Impl"
    // InternalSymg.g:6516:1: rule__RelativeEventPointAfter__Group__1__Impl : ( ( rule__RelativeEventPointAfter__TempOpAssignment_1 ) ) ;
    public final void rule__RelativeEventPointAfter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6520:1: ( ( ( rule__RelativeEventPointAfter__TempOpAssignment_1 ) ) )
            // InternalSymg.g:6521:1: ( ( rule__RelativeEventPointAfter__TempOpAssignment_1 ) )
            {
            // InternalSymg.g:6521:1: ( ( rule__RelativeEventPointAfter__TempOpAssignment_1 ) )
            // InternalSymg.g:6522:2: ( rule__RelativeEventPointAfter__TempOpAssignment_1 )
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getTempOpAssignment_1()); 
            // InternalSymg.g:6523:2: ( rule__RelativeEventPointAfter__TempOpAssignment_1 )
            // InternalSymg.g:6523:3: rule__RelativeEventPointAfter__TempOpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__TempOpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointAfterAccess().getTempOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__1__Impl"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__2"
    // InternalSymg.g:6531:1: rule__RelativeEventPointAfter__Group__2 : rule__RelativeEventPointAfter__Group__2__Impl rule__RelativeEventPointAfter__Group__3 ;
    public final void rule__RelativeEventPointAfter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6535:1: ( rule__RelativeEventPointAfter__Group__2__Impl rule__RelativeEventPointAfter__Group__3 )
            // InternalSymg.g:6536:2: rule__RelativeEventPointAfter__Group__2__Impl rule__RelativeEventPointAfter__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__RelativeEventPointAfter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__2"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__2__Impl"
    // InternalSymg.g:6543:1: rule__RelativeEventPointAfter__Group__2__Impl : ( ( rule__RelativeEventPointAfter__UnitAssignment_2 ) ) ;
    public final void rule__RelativeEventPointAfter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6547:1: ( ( ( rule__RelativeEventPointAfter__UnitAssignment_2 ) ) )
            // InternalSymg.g:6548:1: ( ( rule__RelativeEventPointAfter__UnitAssignment_2 ) )
            {
            // InternalSymg.g:6548:1: ( ( rule__RelativeEventPointAfter__UnitAssignment_2 ) )
            // InternalSymg.g:6549:2: ( rule__RelativeEventPointAfter__UnitAssignment_2 )
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getUnitAssignment_2()); 
            // InternalSymg.g:6550:2: ( rule__RelativeEventPointAfter__UnitAssignment_2 )
            // InternalSymg.g:6550:3: rule__RelativeEventPointAfter__UnitAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__UnitAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointAfterAccess().getUnitAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__2__Impl"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__3"
    // InternalSymg.g:6558:1: rule__RelativeEventPointAfter__Group__3 : rule__RelativeEventPointAfter__Group__3__Impl ;
    public final void rule__RelativeEventPointAfter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6562:1: ( rule__RelativeEventPointAfter__Group__3__Impl )
            // InternalSymg.g:6563:2: rule__RelativeEventPointAfter__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__3"


    // $ANTLR start "rule__RelativeEventPointAfter__Group__3__Impl"
    // InternalSymg.g:6569:1: rule__RelativeEventPointAfter__Group__3__Impl : ( ( rule__RelativeEventPointAfter__PointConstAssignment_3 ) ) ;
    public final void rule__RelativeEventPointAfter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6573:1: ( ( ( rule__RelativeEventPointAfter__PointConstAssignment_3 ) ) )
            // InternalSymg.g:6574:1: ( ( rule__RelativeEventPointAfter__PointConstAssignment_3 ) )
            {
            // InternalSymg.g:6574:1: ( ( rule__RelativeEventPointAfter__PointConstAssignment_3 ) )
            // InternalSymg.g:6575:2: ( rule__RelativeEventPointAfter__PointConstAssignment_3 )
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getPointConstAssignment_3()); 
            // InternalSymg.g:6576:2: ( rule__RelativeEventPointAfter__PointConstAssignment_3 )
            // InternalSymg.g:6576:3: rule__RelativeEventPointAfter__PointConstAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RelativeEventPointAfter__PointConstAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRelativeEventPointAfterAccess().getPointConstAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__Group__3__Impl"


    // $ANTLR start "rule__PEvent__Group__0"
    // InternalSymg.g:6585:1: rule__PEvent__Group__0 : rule__PEvent__Group__0__Impl rule__PEvent__Group__1 ;
    public final void rule__PEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6589:1: ( rule__PEvent__Group__0__Impl rule__PEvent__Group__1 )
            // InternalSymg.g:6590:2: rule__PEvent__Group__0__Impl rule__PEvent__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__PEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__0"


    // $ANTLR start "rule__PEvent__Group__0__Impl"
    // InternalSymg.g:6597:1: rule__PEvent__Group__0__Impl : ( ( rule__PEvent__PowEventAssignment_0 ) ) ;
    public final void rule__PEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6601:1: ( ( ( rule__PEvent__PowEventAssignment_0 ) ) )
            // InternalSymg.g:6602:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            {
            // InternalSymg.g:6602:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            // InternalSymg.g:6603:2: ( rule__PEvent__PowEventAssignment_0 )
            {
             before(grammarAccess.getPEventAccess().getPowEventAssignment_0()); 
            // InternalSymg.g:6604:2: ( rule__PEvent__PowEventAssignment_0 )
            // InternalSymg.g:6604:3: rule__PEvent__PowEventAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PEvent__PowEventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPEventAccess().getPowEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__0__Impl"


    // $ANTLR start "rule__PEvent__Group__1"
    // InternalSymg.g:6612:1: rule__PEvent__Group__1 : rule__PEvent__Group__1__Impl rule__PEvent__Group__2 ;
    public final void rule__PEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6616:1: ( rule__PEvent__Group__1__Impl rule__PEvent__Group__2 )
            // InternalSymg.g:6617:2: rule__PEvent__Group__1__Impl rule__PEvent__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__PEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__1"


    // $ANTLR start "rule__PEvent__Group__1__Impl"
    // InternalSymg.g:6624:1: rule__PEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__PEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6628:1: ( ( '(' ) )
            // InternalSymg.g:6629:1: ( '(' )
            {
            // InternalSymg.g:6629:1: ( '(' )
            // InternalSymg.g:6630:2: '('
            {
             before(grammarAccess.getPEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPEventAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__1__Impl"


    // $ANTLR start "rule__PEvent__Group__2"
    // InternalSymg.g:6639:1: rule__PEvent__Group__2 : rule__PEvent__Group__2__Impl rule__PEvent__Group__3 ;
    public final void rule__PEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6643:1: ( rule__PEvent__Group__2__Impl rule__PEvent__Group__3 )
            // InternalSymg.g:6644:2: rule__PEvent__Group__2__Impl rule__PEvent__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__PEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__2"


    // $ANTLR start "rule__PEvent__Group__2__Impl"
    // InternalSymg.g:6651:1: rule__PEvent__Group__2__Impl : ( ( rule__PEvent__PowNameAssignment_2 ) ) ;
    public final void rule__PEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6655:1: ( ( ( rule__PEvent__PowNameAssignment_2 ) ) )
            // InternalSymg.g:6656:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:6656:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            // InternalSymg.g:6657:2: ( rule__PEvent__PowNameAssignment_2 )
            {
             before(grammarAccess.getPEventAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:6658:2: ( rule__PEvent__PowNameAssignment_2 )
            // InternalSymg.g:6658:3: rule__PEvent__PowNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PEvent__PowNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPEventAccess().getPowNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__2__Impl"


    // $ANTLR start "rule__PEvent__Group__3"
    // InternalSymg.g:6666:1: rule__PEvent__Group__3 : rule__PEvent__Group__3__Impl ;
    public final void rule__PEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6670:1: ( rule__PEvent__Group__3__Impl )
            // InternalSymg.g:6671:2: rule__PEvent__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PEvent__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__3"


    // $ANTLR start "rule__PEvent__Group__3__Impl"
    // InternalSymg.g:6677:1: rule__PEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__PEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6681:1: ( ( ')' ) )
            // InternalSymg.g:6682:1: ( ')' )
            {
            // InternalSymg.g:6682:1: ( ')' )
            // InternalSymg.g:6683:2: ')'
            {
             before(grammarAccess.getPEventAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getPEventAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__Group__3__Impl"


    // $ANTLR start "rule__CEvent__Group__0"
    // InternalSymg.g:6693:1: rule__CEvent__Group__0 : rule__CEvent__Group__0__Impl rule__CEvent__Group__1 ;
    public final void rule__CEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6697:1: ( rule__CEvent__Group__0__Impl rule__CEvent__Group__1 )
            // InternalSymg.g:6698:2: rule__CEvent__Group__0__Impl rule__CEvent__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__CEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__0"


    // $ANTLR start "rule__CEvent__Group__0__Impl"
    // InternalSymg.g:6705:1: rule__CEvent__Group__0__Impl : ( ( rule__CEvent__ContrEventAssignment_0 ) ) ;
    public final void rule__CEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6709:1: ( ( ( rule__CEvent__ContrEventAssignment_0 ) ) )
            // InternalSymg.g:6710:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            {
            // InternalSymg.g:6710:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            // InternalSymg.g:6711:2: ( rule__CEvent__ContrEventAssignment_0 )
            {
             before(grammarAccess.getCEventAccess().getContrEventAssignment_0()); 
            // InternalSymg.g:6712:2: ( rule__CEvent__ContrEventAssignment_0 )
            // InternalSymg.g:6712:3: rule__CEvent__ContrEventAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CEvent__ContrEventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCEventAccess().getContrEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__0__Impl"


    // $ANTLR start "rule__CEvent__Group__1"
    // InternalSymg.g:6720:1: rule__CEvent__Group__1 : rule__CEvent__Group__1__Impl rule__CEvent__Group__2 ;
    public final void rule__CEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6724:1: ( rule__CEvent__Group__1__Impl rule__CEvent__Group__2 )
            // InternalSymg.g:6725:2: rule__CEvent__Group__1__Impl rule__CEvent__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__CEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__1"


    // $ANTLR start "rule__CEvent__Group__1__Impl"
    // InternalSymg.g:6732:1: rule__CEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__CEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6736:1: ( ( '(' ) )
            // InternalSymg.g:6737:1: ( '(' )
            {
            // InternalSymg.g:6737:1: ( '(' )
            // InternalSymg.g:6738:2: '('
            {
             before(grammarAccess.getCEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getCEventAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__1__Impl"


    // $ANTLR start "rule__CEvent__Group__2"
    // InternalSymg.g:6747:1: rule__CEvent__Group__2 : rule__CEvent__Group__2__Impl rule__CEvent__Group__3 ;
    public final void rule__CEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6751:1: ( rule__CEvent__Group__2__Impl rule__CEvent__Group__3 )
            // InternalSymg.g:6752:2: rule__CEvent__Group__2__Impl rule__CEvent__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__CEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__2"


    // $ANTLR start "rule__CEvent__Group__2__Impl"
    // InternalSymg.g:6759:1: rule__CEvent__Group__2__Impl : ( ( rule__CEvent__ContrNameAssignment_2 ) ) ;
    public final void rule__CEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6763:1: ( ( ( rule__CEvent__ContrNameAssignment_2 ) ) )
            // InternalSymg.g:6764:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            {
            // InternalSymg.g:6764:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            // InternalSymg.g:6765:2: ( rule__CEvent__ContrNameAssignment_2 )
            {
             before(grammarAccess.getCEventAccess().getContrNameAssignment_2()); 
            // InternalSymg.g:6766:2: ( rule__CEvent__ContrNameAssignment_2 )
            // InternalSymg.g:6766:3: rule__CEvent__ContrNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CEvent__ContrNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCEventAccess().getContrNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__2__Impl"


    // $ANTLR start "rule__CEvent__Group__3"
    // InternalSymg.g:6774:1: rule__CEvent__Group__3 : rule__CEvent__Group__3__Impl ;
    public final void rule__CEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6778:1: ( rule__CEvent__Group__3__Impl )
            // InternalSymg.g:6779:2: rule__CEvent__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CEvent__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__3"


    // $ANTLR start "rule__CEvent__Group__3__Impl"
    // InternalSymg.g:6785:1: rule__CEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__CEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6789:1: ( ( ')' ) )
            // InternalSymg.g:6790:1: ( ')' )
            {
            // InternalSymg.g:6790:1: ( ')' )
            // InternalSymg.g:6791:2: ')'
            {
             before(grammarAccess.getCEventAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getCEventAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__Group__3__Impl"


    // $ANTLR start "rule__OEvent__Group__0"
    // InternalSymg.g:6801:1: rule__OEvent__Group__0 : rule__OEvent__Group__0__Impl rule__OEvent__Group__1 ;
    public final void rule__OEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6805:1: ( rule__OEvent__Group__0__Impl rule__OEvent__Group__1 )
            // InternalSymg.g:6806:2: rule__OEvent__Group__0__Impl rule__OEvent__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__OEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__0"


    // $ANTLR start "rule__OEvent__Group__0__Impl"
    // InternalSymg.g:6813:1: rule__OEvent__Group__0__Impl : ( ( rule__OEvent__OblEventAssignment_0 ) ) ;
    public final void rule__OEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6817:1: ( ( ( rule__OEvent__OblEventAssignment_0 ) ) )
            // InternalSymg.g:6818:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            {
            // InternalSymg.g:6818:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            // InternalSymg.g:6819:2: ( rule__OEvent__OblEventAssignment_0 )
            {
             before(grammarAccess.getOEventAccess().getOblEventAssignment_0()); 
            // InternalSymg.g:6820:2: ( rule__OEvent__OblEventAssignment_0 )
            // InternalSymg.g:6820:3: rule__OEvent__OblEventAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OEvent__OblEventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOEventAccess().getOblEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__0__Impl"


    // $ANTLR start "rule__OEvent__Group__1"
    // InternalSymg.g:6828:1: rule__OEvent__Group__1 : rule__OEvent__Group__1__Impl rule__OEvent__Group__2 ;
    public final void rule__OEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6832:1: ( rule__OEvent__Group__1__Impl rule__OEvent__Group__2 )
            // InternalSymg.g:6833:2: rule__OEvent__Group__1__Impl rule__OEvent__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__OEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__1"


    // $ANTLR start "rule__OEvent__Group__1__Impl"
    // InternalSymg.g:6840:1: rule__OEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__OEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6844:1: ( ( '(' ) )
            // InternalSymg.g:6845:1: ( '(' )
            {
            // InternalSymg.g:6845:1: ( '(' )
            // InternalSymg.g:6846:2: '('
            {
             before(grammarAccess.getOEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getOEventAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__1__Impl"


    // $ANTLR start "rule__OEvent__Group__2"
    // InternalSymg.g:6855:1: rule__OEvent__Group__2 : rule__OEvent__Group__2__Impl rule__OEvent__Group__3 ;
    public final void rule__OEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6859:1: ( rule__OEvent__Group__2__Impl rule__OEvent__Group__3 )
            // InternalSymg.g:6860:2: rule__OEvent__Group__2__Impl rule__OEvent__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__OEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__2"


    // $ANTLR start "rule__OEvent__Group__2__Impl"
    // InternalSymg.g:6867:1: rule__OEvent__Group__2__Impl : ( ( rule__OEvent__OblNameAssignment_2 ) ) ;
    public final void rule__OEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6871:1: ( ( ( rule__OEvent__OblNameAssignment_2 ) ) )
            // InternalSymg.g:6872:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:6872:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            // InternalSymg.g:6873:2: ( rule__OEvent__OblNameAssignment_2 )
            {
             before(grammarAccess.getOEventAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:6874:2: ( rule__OEvent__OblNameAssignment_2 )
            // InternalSymg.g:6874:3: rule__OEvent__OblNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OEvent__OblNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOEventAccess().getOblNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__2__Impl"


    // $ANTLR start "rule__OEvent__Group__3"
    // InternalSymg.g:6882:1: rule__OEvent__Group__3 : rule__OEvent__Group__3__Impl ;
    public final void rule__OEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6886:1: ( rule__OEvent__Group__3__Impl )
            // InternalSymg.g:6887:2: rule__OEvent__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OEvent__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__3"


    // $ANTLR start "rule__OEvent__Group__3__Impl"
    // InternalSymg.g:6893:1: rule__OEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__OEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6897:1: ( ( ')' ) )
            // InternalSymg.g:6898:1: ( ')' )
            {
            // InternalSymg.g:6898:1: ( ')' )
            // InternalSymg.g:6899:2: ')'
            {
             before(grammarAccess.getOEventAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getOEventAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__Group__3__Impl"


    // $ANTLR start "rule__PointConst__Group__0"
    // InternalSymg.g:6909:1: rule__PointConst__Group__0 : rule__PointConst__Group__0__Impl rule__PointConst__Group__1 ;
    public final void rule__PointConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6913:1: ( rule__PointConst__Group__0__Impl rule__PointConst__Group__1 )
            // InternalSymg.g:6914:2: rule__PointConst__Group__0__Impl rule__PointConst__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__PointConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointConst__Group__0"


    // $ANTLR start "rule__PointConst__Group__0__Impl"
    // InternalSymg.g:6921:1: rule__PointConst__Group__0__Impl : ( () ) ;
    public final void rule__PointConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6925:1: ( ( () ) )
            // InternalSymg.g:6926:1: ( () )
            {
            // InternalSymg.g:6926:1: ( () )
            // InternalSymg.g:6927:2: ()
            {
             before(grammarAccess.getPointConstAccess().getPointConstAction_0()); 
            // InternalSymg.g:6928:2: ()
            // InternalSymg.g:6928:3: 
            {
            }

             after(grammarAccess.getPointConstAccess().getPointConstAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointConst__Group__0__Impl"


    // $ANTLR start "rule__PointConst__Group__1"
    // InternalSymg.g:6936:1: rule__PointConst__Group__1 : rule__PointConst__Group__1__Impl ;
    public final void rule__PointConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6940:1: ( rule__PointConst__Group__1__Impl )
            // InternalSymg.g:6941:2: rule__PointConst__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointConst__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointConst__Group__1"


    // $ANTLR start "rule__PointConst__Group__1__Impl"
    // InternalSymg.g:6947:1: rule__PointConst__Group__1__Impl : ( ( rule__PointConst__TypeAssignment_1 ) ) ;
    public final void rule__PointConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6951:1: ( ( ( rule__PointConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6952:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6952:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            // InternalSymg.g:6953:2: ( rule__PointConst__TypeAssignment_1 )
            {
             before(grammarAccess.getPointConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6954:2: ( rule__PointConst__TypeAssignment_1 )
            // InternalSymg.g:6954:3: rule__PointConst__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PointConst__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPointConstAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointConst__Group__1__Impl"


    // $ANTLR start "rule__OState__Group__0"
    // InternalSymg.g:6963:1: rule__OState__Group__0 : rule__OState__Group__0__Impl rule__OState__Group__1 ;
    public final void rule__OState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6967:1: ( rule__OState__Group__0__Impl rule__OState__Group__1 )
            // InternalSymg.g:6968:2: rule__OState__Group__0__Impl rule__OState__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__OState__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OState__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__0"


    // $ANTLR start "rule__OState__Group__0__Impl"
    // InternalSymg.g:6975:1: rule__OState__Group__0__Impl : ( ( rule__OState__OblStateAssignment_0 ) ) ;
    public final void rule__OState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6979:1: ( ( ( rule__OState__OblStateAssignment_0 ) ) )
            // InternalSymg.g:6980:1: ( ( rule__OState__OblStateAssignment_0 ) )
            {
            // InternalSymg.g:6980:1: ( ( rule__OState__OblStateAssignment_0 ) )
            // InternalSymg.g:6981:2: ( rule__OState__OblStateAssignment_0 )
            {
             before(grammarAccess.getOStateAccess().getOblStateAssignment_0()); 
            // InternalSymg.g:6982:2: ( rule__OState__OblStateAssignment_0 )
            // InternalSymg.g:6982:3: rule__OState__OblStateAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OState__OblStateAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOStateAccess().getOblStateAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__0__Impl"


    // $ANTLR start "rule__OState__Group__1"
    // InternalSymg.g:6990:1: rule__OState__Group__1 : rule__OState__Group__1__Impl rule__OState__Group__2 ;
    public final void rule__OState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6994:1: ( rule__OState__Group__1__Impl rule__OState__Group__2 )
            // InternalSymg.g:6995:2: rule__OState__Group__1__Impl rule__OState__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__OState__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OState__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__1"


    // $ANTLR start "rule__OState__Group__1__Impl"
    // InternalSymg.g:7002:1: rule__OState__Group__1__Impl : ( '(' ) ;
    public final void rule__OState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7006:1: ( ( '(' ) )
            // InternalSymg.g:7007:1: ( '(' )
            {
            // InternalSymg.g:7007:1: ( '(' )
            // InternalSymg.g:7008:2: '('
            {
             before(grammarAccess.getOStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getOStateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__1__Impl"


    // $ANTLR start "rule__OState__Group__2"
    // InternalSymg.g:7017:1: rule__OState__Group__2 : rule__OState__Group__2__Impl rule__OState__Group__3 ;
    public final void rule__OState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7021:1: ( rule__OState__Group__2__Impl rule__OState__Group__3 )
            // InternalSymg.g:7022:2: rule__OState__Group__2__Impl rule__OState__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__OState__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OState__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__2"


    // $ANTLR start "rule__OState__Group__2__Impl"
    // InternalSymg.g:7029:1: rule__OState__Group__2__Impl : ( ( rule__OState__OblNameAssignment_2 ) ) ;
    public final void rule__OState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7033:1: ( ( ( rule__OState__OblNameAssignment_2 ) ) )
            // InternalSymg.g:7034:1: ( ( rule__OState__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:7034:1: ( ( rule__OState__OblNameAssignment_2 ) )
            // InternalSymg.g:7035:2: ( rule__OState__OblNameAssignment_2 )
            {
             before(grammarAccess.getOStateAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:7036:2: ( rule__OState__OblNameAssignment_2 )
            // InternalSymg.g:7036:3: rule__OState__OblNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OState__OblNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOStateAccess().getOblNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__2__Impl"


    // $ANTLR start "rule__OState__Group__3"
    // InternalSymg.g:7044:1: rule__OState__Group__3 : rule__OState__Group__3__Impl ;
    public final void rule__OState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7048:1: ( rule__OState__Group__3__Impl )
            // InternalSymg.g:7049:2: rule__OState__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OState__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__3"


    // $ANTLR start "rule__OState__Group__3__Impl"
    // InternalSymg.g:7055:1: rule__OState__Group__3__Impl : ( ')' ) ;
    public final void rule__OState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7059:1: ( ( ')' ) )
            // InternalSymg.g:7060:1: ( ')' )
            {
            // InternalSymg.g:7060:1: ( ')' )
            // InternalSymg.g:7061:2: ')'
            {
             before(grammarAccess.getOStateAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getOStateAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__Group__3__Impl"


    // $ANTLR start "rule__CState__Group__0"
    // InternalSymg.g:7071:1: rule__CState__Group__0 : rule__CState__Group__0__Impl rule__CState__Group__1 ;
    public final void rule__CState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7075:1: ( rule__CState__Group__0__Impl rule__CState__Group__1 )
            // InternalSymg.g:7076:2: rule__CState__Group__0__Impl rule__CState__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__CState__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CState__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__0"


    // $ANTLR start "rule__CState__Group__0__Impl"
    // InternalSymg.g:7083:1: rule__CState__Group__0__Impl : ( ( rule__CState__ContrStateAssignment_0 ) ) ;
    public final void rule__CState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7087:1: ( ( ( rule__CState__ContrStateAssignment_0 ) ) )
            // InternalSymg.g:7088:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            {
            // InternalSymg.g:7088:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            // InternalSymg.g:7089:2: ( rule__CState__ContrStateAssignment_0 )
            {
             before(grammarAccess.getCStateAccess().getContrStateAssignment_0()); 
            // InternalSymg.g:7090:2: ( rule__CState__ContrStateAssignment_0 )
            // InternalSymg.g:7090:3: rule__CState__ContrStateAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CState__ContrStateAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCStateAccess().getContrStateAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__0__Impl"


    // $ANTLR start "rule__CState__Group__1"
    // InternalSymg.g:7098:1: rule__CState__Group__1 : rule__CState__Group__1__Impl rule__CState__Group__2 ;
    public final void rule__CState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7102:1: ( rule__CState__Group__1__Impl rule__CState__Group__2 )
            // InternalSymg.g:7103:2: rule__CState__Group__1__Impl rule__CState__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__CState__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CState__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__1"


    // $ANTLR start "rule__CState__Group__1__Impl"
    // InternalSymg.g:7110:1: rule__CState__Group__1__Impl : ( '(' ) ;
    public final void rule__CState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7114:1: ( ( '(' ) )
            // InternalSymg.g:7115:1: ( '(' )
            {
            // InternalSymg.g:7115:1: ( '(' )
            // InternalSymg.g:7116:2: '('
            {
             before(grammarAccess.getCStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getCStateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__1__Impl"


    // $ANTLR start "rule__CState__Group__2"
    // InternalSymg.g:7125:1: rule__CState__Group__2 : rule__CState__Group__2__Impl rule__CState__Group__3 ;
    public final void rule__CState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7129:1: ( rule__CState__Group__2__Impl rule__CState__Group__3 )
            // InternalSymg.g:7130:2: rule__CState__Group__2__Impl rule__CState__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__CState__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CState__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__2"


    // $ANTLR start "rule__CState__Group__2__Impl"
    // InternalSymg.g:7137:1: rule__CState__Group__2__Impl : ( ( rule__CState__ContractNameAssignment_2 ) ) ;
    public final void rule__CState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7141:1: ( ( ( rule__CState__ContractNameAssignment_2 ) ) )
            // InternalSymg.g:7142:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            {
            // InternalSymg.g:7142:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            // InternalSymg.g:7143:2: ( rule__CState__ContractNameAssignment_2 )
            {
             before(grammarAccess.getCStateAccess().getContractNameAssignment_2()); 
            // InternalSymg.g:7144:2: ( rule__CState__ContractNameAssignment_2 )
            // InternalSymg.g:7144:3: rule__CState__ContractNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CState__ContractNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCStateAccess().getContractNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__2__Impl"


    // $ANTLR start "rule__CState__Group__3"
    // InternalSymg.g:7152:1: rule__CState__Group__3 : rule__CState__Group__3__Impl ;
    public final void rule__CState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7156:1: ( rule__CState__Group__3__Impl )
            // InternalSymg.g:7157:2: rule__CState__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CState__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__3"


    // $ANTLR start "rule__CState__Group__3__Impl"
    // InternalSymg.g:7163:1: rule__CState__Group__3__Impl : ( ')' ) ;
    public final void rule__CState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7167:1: ( ( ')' ) )
            // InternalSymg.g:7168:1: ( ')' )
            {
            // InternalSymg.g:7168:1: ( ')' )
            // InternalSymg.g:7169:2: ')'
            {
             before(grammarAccess.getCStateAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getCStateAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__Group__3__Impl"


    // $ANTLR start "rule__PState__Group__0"
    // InternalSymg.g:7179:1: rule__PState__Group__0 : rule__PState__Group__0__Impl rule__PState__Group__1 ;
    public final void rule__PState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7183:1: ( rule__PState__Group__0__Impl rule__PState__Group__1 )
            // InternalSymg.g:7184:2: rule__PState__Group__0__Impl rule__PState__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__PState__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PState__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__0"


    // $ANTLR start "rule__PState__Group__0__Impl"
    // InternalSymg.g:7191:1: rule__PState__Group__0__Impl : ( ( rule__PState__PowStateAssignment_0 ) ) ;
    public final void rule__PState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7195:1: ( ( ( rule__PState__PowStateAssignment_0 ) ) )
            // InternalSymg.g:7196:1: ( ( rule__PState__PowStateAssignment_0 ) )
            {
            // InternalSymg.g:7196:1: ( ( rule__PState__PowStateAssignment_0 ) )
            // InternalSymg.g:7197:2: ( rule__PState__PowStateAssignment_0 )
            {
             before(grammarAccess.getPStateAccess().getPowStateAssignment_0()); 
            // InternalSymg.g:7198:2: ( rule__PState__PowStateAssignment_0 )
            // InternalSymg.g:7198:3: rule__PState__PowStateAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PState__PowStateAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPStateAccess().getPowStateAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__0__Impl"


    // $ANTLR start "rule__PState__Group__1"
    // InternalSymg.g:7206:1: rule__PState__Group__1 : rule__PState__Group__1__Impl rule__PState__Group__2 ;
    public final void rule__PState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7210:1: ( rule__PState__Group__1__Impl rule__PState__Group__2 )
            // InternalSymg.g:7211:2: rule__PState__Group__1__Impl rule__PState__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__PState__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PState__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__1"


    // $ANTLR start "rule__PState__Group__1__Impl"
    // InternalSymg.g:7218:1: rule__PState__Group__1__Impl : ( '(' ) ;
    public final void rule__PState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7222:1: ( ( '(' ) )
            // InternalSymg.g:7223:1: ( '(' )
            {
            // InternalSymg.g:7223:1: ( '(' )
            // InternalSymg.g:7224:2: '('
            {
             before(grammarAccess.getPStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getPStateAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__1__Impl"


    // $ANTLR start "rule__PState__Group__2"
    // InternalSymg.g:7233:1: rule__PState__Group__2 : rule__PState__Group__2__Impl rule__PState__Group__3 ;
    public final void rule__PState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7237:1: ( rule__PState__Group__2__Impl rule__PState__Group__3 )
            // InternalSymg.g:7238:2: rule__PState__Group__2__Impl rule__PState__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__PState__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PState__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__2"


    // $ANTLR start "rule__PState__Group__2__Impl"
    // InternalSymg.g:7245:1: rule__PState__Group__2__Impl : ( ( rule__PState__PowNameAssignment_2 ) ) ;
    public final void rule__PState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7249:1: ( ( ( rule__PState__PowNameAssignment_2 ) ) )
            // InternalSymg.g:7250:1: ( ( rule__PState__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:7250:1: ( ( rule__PState__PowNameAssignment_2 ) )
            // InternalSymg.g:7251:2: ( rule__PState__PowNameAssignment_2 )
            {
             before(grammarAccess.getPStateAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:7252:2: ( rule__PState__PowNameAssignment_2 )
            // InternalSymg.g:7252:3: rule__PState__PowNameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PState__PowNameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPStateAccess().getPowNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__2__Impl"


    // $ANTLR start "rule__PState__Group__3"
    // InternalSymg.g:7260:1: rule__PState__Group__3 : rule__PState__Group__3__Impl ;
    public final void rule__PState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7264:1: ( rule__PState__Group__3__Impl )
            // InternalSymg.g:7265:2: rule__PState__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PState__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__3"


    // $ANTLR start "rule__PState__Group__3__Impl"
    // InternalSymg.g:7271:1: rule__PState__Group__3__Impl : ( ')' ) ;
    public final void rule__PState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7275:1: ( ( ')' ) )
            // InternalSymg.g:7276:1: ( ')' )
            {
            // InternalSymg.g:7276:1: ( ')' )
            // InternalSymg.g:7277:2: ')'
            {
             before(grammarAccess.getPStateAccess().getRightParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getPStateAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__Group__3__Impl"


    // $ANTLR start "rule__Model__DomainNameAssignment_1"
    // InternalSymg.g:7287:1: rule__Model__DomainNameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__DomainNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7291:1: ( ( RULE_ID ) )
            // InternalSymg.g:7292:2: ( RULE_ID )
            {
            // InternalSymg.g:7292:2: ( RULE_ID )
            // InternalSymg.g:7293:3: RULE_ID
            {
             before(grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DomainNameAssignment_1"


    // $ANTLR start "rule__Model__DomainConceptsAssignment_2_0"
    // InternalSymg.g:7302:1: rule__Model__DomainConceptsAssignment_2_0 : ( ruleDomainConcept ) ;
    public final void rule__Model__DomainConceptsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7306:1: ( ( ruleDomainConcept ) )
            // InternalSymg.g:7307:2: ( ruleDomainConcept )
            {
            // InternalSymg.g:7307:2: ( ruleDomainConcept )
            // InternalSymg.g:7308:3: ruleDomainConcept
            {
             before(grammarAccess.getModelAccess().getDomainConceptsDomainConceptParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDomainConcept();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDomainConceptsDomainConceptParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DomainConceptsAssignment_2_0"


    // $ANTLR start "rule__Model__ContractNameAssignment_5"
    // InternalSymg.g:7317:1: rule__Model__ContractNameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Model__ContractNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7321:1: ( ( RULE_ID ) )
            // InternalSymg.g:7322:2: ( RULE_ID )
            {
            // InternalSymg.g:7322:2: ( RULE_ID )
            // InternalSymg.g:7323:3: RULE_ID
            {
             before(grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ContractNameAssignment_5"


    // $ANTLR start "rule__Model__ParametersAssignment_7_0"
    // InternalSymg.g:7332:1: rule__Model__ParametersAssignment_7_0 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7336:1: ( ( ruleParameter ) )
            // InternalSymg.g:7337:2: ( ruleParameter )
            {
            // InternalSymg.g:7337:2: ( ruleParameter )
            // InternalSymg.g:7338:3: ruleParameter
            {
             before(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_7_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ParametersAssignment_7_0"


    // $ANTLR start "rule__Model__ParametersAssignment_8"
    // InternalSymg.g:7347:1: rule__Model__ParametersAssignment_8 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7351:1: ( ( ruleParameter ) )
            // InternalSymg.g:7352:2: ( ruleParameter )
            {
            // InternalSymg.g:7352:2: ( ruleParameter )
            // InternalSymg.g:7353:3: ruleParameter
            {
             before(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ParametersAssignment_8"


    // $ANTLR start "rule__Model__DeclarationsAssignment_10_1_0"
    // InternalSymg.g:7362:1: rule__Model__DeclarationsAssignment_10_1_0 : ( ruleDeclar ) ;
    public final void rule__Model__DeclarationsAssignment_10_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7366:1: ( ( ruleDeclar ) )
            // InternalSymg.g:7367:2: ( ruleDeclar )
            {
            // InternalSymg.g:7367:2: ( ruleDeclar )
            // InternalSymg.g:7368:3: ruleDeclar
            {
             before(grammarAccess.getModelAccess().getDeclarationsDeclarParserRuleCall_10_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclar();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDeclarationsDeclarParserRuleCall_10_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DeclarationsAssignment_10_1_0"


    // $ANTLR start "rule__Model__PreconditionsAssignment_11_1_0"
    // InternalSymg.g:7377:1: rule__Model__PreconditionsAssignment_11_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PreconditionsAssignment_11_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7381:1: ( ( ruleProposition ) )
            // InternalSymg.g:7382:2: ( ruleProposition )
            {
            // InternalSymg.g:7382:2: ( ruleProposition )
            // InternalSymg.g:7383:3: ruleProposition
            {
             before(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_11_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_11_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PreconditionsAssignment_11_1_0"


    // $ANTLR start "rule__Model__PostconditionsAssignment_12_1_0"
    // InternalSymg.g:7392:1: rule__Model__PostconditionsAssignment_12_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PostconditionsAssignment_12_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7396:1: ( ( ruleProposition ) )
            // InternalSymg.g:7397:2: ( ruleProposition )
            {
            // InternalSymg.g:7397:2: ( ruleProposition )
            // InternalSymg.g:7398:3: ruleProposition
            {
             before(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_12_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_12_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PostconditionsAssignment_12_1_0"


    // $ANTLR start "rule__Model__ObligationsAssignment_13_1_0"
    // InternalSymg.g:7407:1: rule__Model__ObligationsAssignment_13_1_0 : ( ruleObligation ) ;
    public final void rule__Model__ObligationsAssignment_13_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7411:1: ( ( ruleObligation ) )
            // InternalSymg.g:7412:2: ( ruleObligation )
            {
            // InternalSymg.g:7412:2: ( ruleObligation )
            // InternalSymg.g:7413:3: ruleObligation
            {
             before(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_13_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleObligation();

            state._fsp--;

             after(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_13_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ObligationsAssignment_13_1_0"


    // $ANTLR start "rule__Model__SobligationsAssignment_14_2_0"
    // InternalSymg.g:7422:1: rule__Model__SobligationsAssignment_14_2_0 : ( ruleObligation ) ;
    public final void rule__Model__SobligationsAssignment_14_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7426:1: ( ( ruleObligation ) )
            // InternalSymg.g:7427:2: ( ruleObligation )
            {
            // InternalSymg.g:7427:2: ( ruleObligation )
            // InternalSymg.g:7428:3: ruleObligation
            {
             before(grammarAccess.getModelAccess().getSobligationsObligationParserRuleCall_14_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleObligation();

            state._fsp--;

             after(grammarAccess.getModelAccess().getSobligationsObligationParserRuleCall_14_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__SobligationsAssignment_14_2_0"


    // $ANTLR start "rule__Model__PowersAssignment_15_1_0"
    // InternalSymg.g:7437:1: rule__Model__PowersAssignment_15_1_0 : ( rulePower ) ;
    public final void rule__Model__PowersAssignment_15_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7441:1: ( ( rulePower ) )
            // InternalSymg.g:7442:2: ( rulePower )
            {
            // InternalSymg.g:7442:2: ( rulePower )
            // InternalSymg.g:7443:3: rulePower
            {
             before(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_15_1_0_0()); 
            pushFollow(FOLLOW_2);
            rulePower();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_15_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PowersAssignment_15_1_0"


    // $ANTLR start "rule__Model__ConstraintsAssignment_16_1_0"
    // InternalSymg.g:7452:1: rule__Model__ConstraintsAssignment_16_1_0 : ( ruleProposition ) ;
    public final void rule__Model__ConstraintsAssignment_16_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7456:1: ( ( ruleProposition ) )
            // InternalSymg.g:7457:2: ( ruleProposition )
            {
            // InternalSymg.g:7457:2: ( ruleProposition )
            // InternalSymg.g:7458:3: ruleProposition
            {
             before(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_16_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_16_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ConstraintsAssignment_16_1_0"


    // $ANTLR start "rule__Regular__NameAssignment_0"
    // InternalSymg.g:7467:1: rule__Regular__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Regular__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7471:1: ( ( RULE_ID ) )
            // InternalSymg.g:7472:2: ( RULE_ID )
            {
            // InternalSymg.g:7472:2: ( RULE_ID )
            // InternalSymg.g:7473:3: RULE_ID
            {
             before(grammarAccess.getRegularAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRegularAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__NameAssignment_0"


    // $ANTLR start "rule__Regular__ConceptTypeAssignment_2"
    // InternalSymg.g:7482:1: rule__Regular__ConceptTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Regular__ConceptTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7486:1: ( ( ruleCType ) )
            // InternalSymg.g:7487:2: ( ruleCType )
            {
            // InternalSymg.g:7487:2: ( ruleCType )
            // InternalSymg.g:7488:3: ruleCType
            {
             before(grammarAccess.getRegularAccess().getConceptTypeCTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCType();

            state._fsp--;

             after(grammarAccess.getRegularAccess().getConceptTypeCTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__ConceptTypeAssignment_2"


    // $ANTLR start "rule__Regular__AttributesAssignment_3_1_0"
    // InternalSymg.g:7497:1: rule__Regular__AttributesAssignment_3_1_0 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7501:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7502:2: ( ruleAttribute )
            {
            // InternalSymg.g:7502:2: ( ruleAttribute )
            // InternalSymg.g:7503:3: ruleAttribute
            {
             before(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__AttributesAssignment_3_1_0"


    // $ANTLR start "rule__Regular__AttributesAssignment_3_2"
    // InternalSymg.g:7512:1: rule__Regular__AttributesAssignment_3_2 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7516:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7517:2: ( ruleAttribute )
            {
            // InternalSymg.g:7517:2: ( ruleAttribute )
            // InternalSymg.g:7518:3: ruleAttribute
            {
             before(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Regular__AttributesAssignment_3_2"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // InternalSymg.g:7527:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7531:1: ( ( RULE_ID ) )
            // InternalSymg.g:7532:2: ( RULE_ID )
            {
            // InternalSymg.g:7532:2: ( RULE_ID )
            // InternalSymg.g:7533:3: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__AttributeTypeAssignment_2"
    // InternalSymg.g:7542:1: rule__Attribute__AttributeTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Attribute__AttributeTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7546:1: ( ( ruleCType ) )
            // InternalSymg.g:7547:2: ( ruleCType )
            {
            // InternalSymg.g:7547:2: ( ruleCType )
            // InternalSymg.g:7548:3: ruleCType
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeCTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCType();

            state._fsp--;

             after(grammarAccess.getAttributeAccess().getAttributeTypeCTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__AttributeTypeAssignment_2"


    // $ANTLR start "rule__Enumeration__NameAssignment_0"
    // InternalSymg.g:7557:1: rule__Enumeration__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7561:1: ( ( RULE_ID ) )
            // InternalSymg.g:7562:2: ( RULE_ID )
            {
            // InternalSymg.g:7562:2: ( RULE_ID )
            // InternalSymg.g:7563:3: RULE_ID
            {
             before(grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__NameAssignment_0"


    // $ANTLR start "rule__Enumeration__EnumerationItemsAssignment_4_0"
    // InternalSymg.g:7572:1: rule__Enumeration__EnumerationItemsAssignment_4_0 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7576:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7577:2: ( ruleenumItem )
            {
            // InternalSymg.g:7577:2: ( ruleenumItem )
            // InternalSymg.g:7578:3: ruleenumItem
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleenumItem();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__EnumerationItemsAssignment_4_0"


    // $ANTLR start "rule__Enumeration__EnumerationItemsAssignment_5"
    // InternalSymg.g:7587:1: rule__Enumeration__EnumerationItemsAssignment_5 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7591:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7592:2: ( ruleenumItem )
            {
            // InternalSymg.g:7592:2: ( ruleenumItem )
            // InternalSymg.g:7593:3: ruleenumItem
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleenumItem();

            state._fsp--;

             after(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumeration__EnumerationItemsAssignment_5"


    // $ANTLR start "rule__EnumItem__NameAssignment_1"
    // InternalSymg.g:7602:1: rule__EnumItem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7606:1: ( ( RULE_ID ) )
            // InternalSymg.g:7607:2: ( RULE_ID )
            {
            // InternalSymg.g:7607:2: ( RULE_ID )
            // InternalSymg.g:7608:3: RULE_ID
            {
             before(grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumItem__NameAssignment_1"


    // $ANTLR start "rule__DomainType__SuperTypeAssignment"
    // InternalSymg.g:7617:1: rule__DomainType__SuperTypeAssignment : ( ( RULE_ID ) ) ;
    public final void rule__DomainType__SuperTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7621:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7622:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7622:2: ( ( RULE_ID ) )
            // InternalSymg.g:7623:3: ( RULE_ID )
            {
             before(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0()); 
            // InternalSymg.g:7624:3: ( RULE_ID )
            // InternalSymg.g:7625:4: RULE_ID
            {
             before(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DomainType__SuperTypeAssignment"


    // $ANTLR start "rule__BasicType__NameAssignment"
    // InternalSymg.g:7636:1: rule__BasicType__NameAssignment : ( ( rule__BasicType__NameAlternatives_0 ) ) ;
    public final void rule__BasicType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7640:1: ( ( ( rule__BasicType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7641:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7641:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            // InternalSymg.g:7642:3: ( rule__BasicType__NameAlternatives_0 )
            {
             before(grammarAccess.getBasicTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7643:3: ( rule__BasicType__NameAlternatives_0 )
            // InternalSymg.g:7643:4: rule__BasicType__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__BasicType__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBasicTypeAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BasicType__NameAssignment"


    // $ANTLR start "rule__OntoCType__NameAssignment"
    // InternalSymg.g:7651:1: rule__OntoCType__NameAssignment : ( ( rule__OntoCType__NameAlternatives_0 ) ) ;
    public final void rule__OntoCType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7655:1: ( ( ( rule__OntoCType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7656:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7656:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            // InternalSymg.g:7657:3: ( rule__OntoCType__NameAlternatives_0 )
            {
             before(grammarAccess.getOntoCTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7658:3: ( rule__OntoCType__NameAlternatives_0 )
            // InternalSymg.g:7658:4: rule__OntoCType__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__OntoCType__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getOntoCTypeAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OntoCType__NameAssignment"


    // $ANTLR start "rule__Parameter__NameAssignment_0"
    // InternalSymg.g:7666:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7670:1: ( ( RULE_ID ) )
            // InternalSymg.g:7671:2: ( RULE_ID )
            {
            // InternalSymg.g:7671:2: ( RULE_ID )
            // InternalSymg.g:7672:3: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_0"


    // $ANTLR start "rule__Parameter__TypeAssignment_2"
    // InternalSymg.g:7681:1: rule__Parameter__TypeAssignment_2 : ( ruleTypeName ) ;
    public final void rule__Parameter__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7685:1: ( ( ruleTypeName ) )
            // InternalSymg.g:7686:2: ( ruleTypeName )
            {
            // InternalSymg.g:7686:2: ( ruleTypeName )
            // InternalSymg.g:7687:3: ruleTypeName
            {
             before(grammarAccess.getParameterAccess().getTypeTypeNameParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeName();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getTypeTypeNameParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__TypeAssignment_2"


    // $ANTLR start "rule__DeclarPair__AttrAssignment_0"
    // InternalSymg.g:7696:1: rule__DeclarPair__AttrAssignment_0 : ( RULE_ID ) ;
    public final void rule__DeclarPair__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7700:1: ( ( RULE_ID ) )
            // InternalSymg.g:7701:2: ( RULE_ID )
            {
            // InternalSymg.g:7701:2: ( RULE_ID )
            // InternalSymg.g:7702:3: RULE_ID
            {
             before(grammarAccess.getDeclarPairAccess().getAttrIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeclarPairAccess().getAttrIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__AttrAssignment_0"


    // $ANTLR start "rule__DeclarPair__ParamAssignment_2"
    // InternalSymg.g:7711:1: rule__DeclarPair__ParamAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclarPair__ParamAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7715:1: ( ( RULE_ID ) )
            // InternalSymg.g:7716:2: ( RULE_ID )
            {
            // InternalSymg.g:7716:2: ( RULE_ID )
            // InternalSymg.g:7717:3: RULE_ID
            {
             before(grammarAccess.getDeclarPairAccess().getParamIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeclarPairAccess().getParamIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeclarPair__ParamAssignment_2"


    // $ANTLR start "rule__Declar__NameAssignment_0"
    // InternalSymg.g:7726:1: rule__Declar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Declar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7730:1: ( ( RULE_ID ) )
            // InternalSymg.g:7731:2: ( RULE_ID )
            {
            // InternalSymg.g:7731:2: ( RULE_ID )
            // InternalSymg.g:7732:3: RULE_ID
            {
             before(grammarAccess.getDeclarAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeclarAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__NameAssignment_0"


    // $ANTLR start "rule__Declar__TypeAssignment_2"
    // InternalSymg.g:7741:1: rule__Declar__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Declar__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7745:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7746:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7746:2: ( ( RULE_ID ) )
            // InternalSymg.g:7747:3: ( RULE_ID )
            {
             before(grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0()); 
            // InternalSymg.g:7748:3: ( RULE_ID )
            // InternalSymg.g:7749:4: RULE_ID
            {
             before(grammarAccess.getDeclarAccess().getTypeRegularIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeclarAccess().getTypeRegularIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__TypeAssignment_2"


    // $ANTLR start "rule__Declar__AttributesAssignment_4_0"
    // InternalSymg.g:7760:1: rule__Declar__AttributesAssignment_4_0 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7764:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7765:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7765:2: ( ruleDeclarPair )
            // InternalSymg.g:7766:3: ruleDeclarPair
            {
             before(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclarPair();

            state._fsp--;

             after(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__AttributesAssignment_4_0"


    // $ANTLR start "rule__Declar__AttributesAssignment_5"
    // InternalSymg.g:7775:1: rule__Declar__AttributesAssignment_5 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7779:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7780:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7780:2: ( ruleDeclarPair )
            // InternalSymg.g:7781:3: ruleDeclarPair
            {
             before(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclarPair();

            state._fsp--;

             after(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declar__AttributesAssignment_5"


    // $ANTLR start "rule__Obligation__NameAssignment_0"
    // InternalSymg.g:7790:1: rule__Obligation__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Obligation__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7794:1: ( ( RULE_ID ) )
            // InternalSymg.g:7795:2: ( RULE_ID )
            {
            // InternalSymg.g:7795:2: ( RULE_ID )
            // InternalSymg.g:7796:3: RULE_ID
            {
             before(grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__NameAssignment_0"


    // $ANTLR start "rule__Obligation__TriggerAssignment_2_0"
    // InternalSymg.g:7805:1: rule__Obligation__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Obligation__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7809:1: ( ( ruleProposition ) )
            // InternalSymg.g:7810:2: ( ruleProposition )
            {
            // InternalSymg.g:7810:2: ( ruleProposition )
            // InternalSymg.g:7811:3: ruleProposition
            {
             before(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__TriggerAssignment_2_0"


    // $ANTLR start "rule__Obligation__Role1Assignment_5"
    // InternalSymg.g:7820:1: rule__Obligation__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Obligation__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7824:1: ( ( RULE_ID ) )
            // InternalSymg.g:7825:2: ( RULE_ID )
            {
            // InternalSymg.g:7825:2: ( RULE_ID )
            // InternalSymg.g:7826:3: RULE_ID
            {
             before(grammarAccess.getObligationAccess().getRole1IDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getRole1IDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Role1Assignment_5"


    // $ANTLR start "rule__Obligation__Role2Assignment_7"
    // InternalSymg.g:7835:1: rule__Obligation__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Obligation__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7839:1: ( ( RULE_ID ) )
            // InternalSymg.g:7840:2: ( RULE_ID )
            {
            // InternalSymg.g:7840:2: ( RULE_ID )
            // InternalSymg.g:7841:3: RULE_ID
            {
             before(grammarAccess.getObligationAccess().getRole2IDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObligationAccess().getRole2IDTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__Role2Assignment_7"


    // $ANTLR start "rule__Obligation__AntecedentAssignment_9"
    // InternalSymg.g:7850:1: rule__Obligation__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Obligation__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7854:1: ( ( ruleProposition ) )
            // InternalSymg.g:7855:2: ( ruleProposition )
            {
            // InternalSymg.g:7855:2: ( ruleProposition )
            // InternalSymg.g:7856:3: ruleProposition
            {
             before(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__AntecedentAssignment_9"


    // $ANTLR start "rule__Obligation__ConsequentAssignment_11"
    // InternalSymg.g:7865:1: rule__Obligation__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Obligation__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7869:1: ( ( ruleProposition ) )
            // InternalSymg.g:7870:2: ( ruleProposition )
            {
            // InternalSymg.g:7870:2: ( ruleProposition )
            // InternalSymg.g:7871:3: ruleProposition
            {
             before(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Obligation__ConsequentAssignment_11"


    // $ANTLR start "rule__Power__NameAssignment_0"
    // InternalSymg.g:7880:1: rule__Power__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Power__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7884:1: ( ( RULE_ID ) )
            // InternalSymg.g:7885:2: ( RULE_ID )
            {
            // InternalSymg.g:7885:2: ( RULE_ID )
            // InternalSymg.g:7886:3: RULE_ID
            {
             before(grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__NameAssignment_0"


    // $ANTLR start "rule__Power__TriggerAssignment_2_0"
    // InternalSymg.g:7895:1: rule__Power__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Power__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7899:1: ( ( ruleProposition ) )
            // InternalSymg.g:7900:2: ( ruleProposition )
            {
            // InternalSymg.g:7900:2: ( ruleProposition )
            // InternalSymg.g:7901:3: ruleProposition
            {
             before(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__TriggerAssignment_2_0"


    // $ANTLR start "rule__Power__Role1Assignment_5"
    // InternalSymg.g:7910:1: rule__Power__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Power__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7914:1: ( ( RULE_ID ) )
            // InternalSymg.g:7915:2: ( RULE_ID )
            {
            // InternalSymg.g:7915:2: ( RULE_ID )
            // InternalSymg.g:7916:3: RULE_ID
            {
             before(grammarAccess.getPowerAccess().getRole1IDTerminalRuleCall_5_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getRole1IDTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Role1Assignment_5"


    // $ANTLR start "rule__Power__Role2Assignment_7"
    // InternalSymg.g:7925:1: rule__Power__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Power__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7929:1: ( ( RULE_ID ) )
            // InternalSymg.g:7930:2: ( RULE_ID )
            {
            // InternalSymg.g:7930:2: ( RULE_ID )
            // InternalSymg.g:7931:3: RULE_ID
            {
             before(grammarAccess.getPowerAccess().getRole2IDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPowerAccess().getRole2IDTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__Role2Assignment_7"


    // $ANTLR start "rule__Power__AntecedentAssignment_9"
    // InternalSymg.g:7940:1: rule__Power__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Power__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7944:1: ( ( ruleProposition ) )
            // InternalSymg.g:7945:2: ( ruleProposition )
            {
            // InternalSymg.g:7945:2: ( ruleProposition )
            // InternalSymg.g:7946:3: ruleProposition
            {
             before(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__AntecedentAssignment_9"


    // $ANTLR start "rule__Power__ConsequentAssignment_11"
    // InternalSymg.g:7955:1: rule__Power__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Power__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7959:1: ( ( ruleProposition ) )
            // InternalSymg.g:7960:2: ( ruleProposition )
            {
            // InternalSymg.g:7960:2: ( ruleProposition )
            // InternalSymg.g:7961:3: ruleProposition
            {
             before(grammarAccess.getPowerAccess().getConsequentPropositionParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPowerAccess().getConsequentPropositionParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Power__ConsequentAssignment_11"


    // $ANTLR start "rule__Proposition__JunctionsAssignment_0"
    // InternalSymg.g:7970:1: rule__Proposition__JunctionsAssignment_0 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7974:1: ( ( ruleJunction ) )
            // InternalSymg.g:7975:2: ( ruleJunction )
            {
            // InternalSymg.g:7975:2: ( ruleJunction )
            // InternalSymg.g:7976:3: ruleJunction
            {
             before(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleJunction();

            state._fsp--;

             after(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__JunctionsAssignment_0"


    // $ANTLR start "rule__Proposition__JunctionsAssignment_1_1"
    // InternalSymg.g:7985:1: rule__Proposition__JunctionsAssignment_1_1 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7989:1: ( ( ruleJunction ) )
            // InternalSymg.g:7990:2: ( ruleJunction )
            {
            // InternalSymg.g:7990:2: ( ruleJunction )
            // InternalSymg.g:7991:3: ruleJunction
            {
             before(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleJunction();

            state._fsp--;

             after(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__JunctionsAssignment_1_1"


    // $ANTLR start "rule__Junction__NegativeAtomsAssignment_0"
    // InternalSymg.g:8000:1: rule__Junction__NegativeAtomsAssignment_0 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8004:1: ( ( ruleNegation ) )
            // InternalSymg.g:8005:2: ( ruleNegation )
            {
            // InternalSymg.g:8005:2: ( ruleNegation )
            // InternalSymg.g:8006:3: ruleNegation
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__NegativeAtomsAssignment_0"


    // $ANTLR start "rule__Junction__NegativeAtomsAssignment_1_1"
    // InternalSymg.g:8015:1: rule__Junction__NegativeAtomsAssignment_1_1 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8019:1: ( ( ruleNegation ) )
            // InternalSymg.g:8020:2: ( ruleNegation )
            {
            // InternalSymg.g:8020:2: ( ruleNegation )
            // InternalSymg.g:8021:3: ruleNegation
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Junction__NegativeAtomsAssignment_1_1"


    // $ANTLR start "rule__Negation__NegatedAssignment_0"
    // InternalSymg.g:8030:1: rule__Negation__NegatedAssignment_0 : ( ( 'NOT' ) ) ;
    public final void rule__Negation__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8034:1: ( ( ( 'NOT' ) ) )
            // InternalSymg.g:8035:2: ( ( 'NOT' ) )
            {
            // InternalSymg.g:8035:2: ( ( 'NOT' ) )
            // InternalSymg.g:8036:3: ( 'NOT' )
            {
             before(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 
            // InternalSymg.g:8037:3: ( 'NOT' )
            // InternalSymg.g:8038:4: 'NOT'
            {
             before(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 
            match(input,104,FOLLOW_2); 
             after(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 

            }

             after(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__NegatedAssignment_0"


    // $ANTLR start "rule__Negation__AtomicExpressionAssignment_1"
    // InternalSymg.g:8049:1: rule__Negation__AtomicExpressionAssignment_1 : ( ruleAtom ) ;
    public final void rule__Negation__AtomicExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8053:1: ( ( ruleAtom ) )
            // InternalSymg.g:8054:2: ( ruleAtom )
            {
            // InternalSymg.g:8054:2: ( ruleAtom )
            // InternalSymg.g:8055:3: ruleAtom
            {
             before(grammarAccess.getNegationAccess().getAtomicExpressionAtomParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getNegationAccess().getAtomicExpressionAtomParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Negation__AtomicExpressionAssignment_1"


    // $ANTLR start "rule__Atom__EventPropositionAssignment_0_2"
    // InternalSymg.g:8064:1: rule__Atom__EventPropositionAssignment_0_2 : ( ruleEventProp ) ;
    public final void rule__Atom__EventPropositionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8068:1: ( ( ruleEventProp ) )
            // InternalSymg.g:8069:2: ( ruleEventProp )
            {
            // InternalSymg.g:8069:2: ( ruleEventProp )
            // InternalSymg.g:8070:3: ruleEventProp
            {
             before(grammarAccess.getAtomAccess().getEventPropositionEventPropParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEventProp();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getEventPropositionEventPropParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__EventPropositionAssignment_0_2"


    // $ANTLR start "rule__Atom__SituationPropositionAssignment_1_2"
    // InternalSymg.g:8079:1: rule__Atom__SituationPropositionAssignment_1_2 : ( ruleSitProp ) ;
    public final void rule__Atom__SituationPropositionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8083:1: ( ( ruleSitProp ) )
            // InternalSymg.g:8084:2: ( ruleSitProp )
            {
            // InternalSymg.g:8084:2: ( ruleSitProp )
            // InternalSymg.g:8085:3: ruleSitProp
            {
             before(grammarAccess.getAtomAccess().getSituationPropositionSitPropParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSitProp();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getSituationPropositionSitPropParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__SituationPropositionAssignment_1_2"


    // $ANTLR start "rule__Atom__InnerAssignment_2_1"
    // InternalSymg.g:8094:1: rule__Atom__InnerAssignment_2_1 : ( ruleProposition ) ;
    public final void rule__Atom__InnerAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8098:1: ( ( ruleProposition ) )
            // InternalSymg.g:8099:2: ( ruleProposition )
            {
            // InternalSymg.g:8099:2: ( ruleProposition )
            // InternalSymg.g:8100:3: ruleProposition
            {
             before(grammarAccess.getAtomAccess().getInnerPropositionParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getInnerPropositionParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__InnerAssignment_2_1"


    // $ANTLR start "rule__Atom__PointAssignment_3_0"
    // InternalSymg.g:8109:1: rule__Atom__PointAssignment_3_0 : ( rulePoint ) ;
    public final void rule__Atom__PointAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8113:1: ( ( rulePoint ) )
            // InternalSymg.g:8114:2: ( rulePoint )
            {
            // InternalSymg.g:8114:2: ( rulePoint )
            // InternalSymg.g:8115:3: rulePoint
            {
             before(grammarAccess.getAtomAccess().getPointPointParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getPointPointParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__PointAssignment_3_0"


    // $ANTLR start "rule__Atom__IntervalAssignment_3_2"
    // InternalSymg.g:8124:1: rule__Atom__IntervalAssignment_3_2 : ( ruleInterval ) ;
    public final void rule__Atom__IntervalAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8128:1: ( ( ruleInterval ) )
            // InternalSymg.g:8129:2: ( ruleInterval )
            {
            // InternalSymg.g:8129:2: ( ruleInterval )
            // InternalSymg.g:8130:3: ruleInterval
            {
             before(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleInterval();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__IntervalAssignment_3_2"


    // $ANTLR start "rule__Atom__BoolAssignment_4"
    // InternalSymg.g:8139:1: rule__Atom__BoolAssignment_4 : ( ( 'TRUE' ) ) ;
    public final void rule__Atom__BoolAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8143:1: ( ( ( 'TRUE' ) ) )
            // InternalSymg.g:8144:2: ( ( 'TRUE' ) )
            {
            // InternalSymg.g:8144:2: ( ( 'TRUE' ) )
            // InternalSymg.g:8145:3: ( 'TRUE' )
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 
            // InternalSymg.g:8146:3: ( 'TRUE' )
            // InternalSymg.g:8147:4: 'TRUE'
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 
            match(input,105,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 

            }

             after(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__BoolAssignment_4"


    // $ANTLR start "rule__Atom__BoolAssignment_5"
    // InternalSymg.g:8158:1: rule__Atom__BoolAssignment_5 : ( ( 'FALSE' ) ) ;
    public final void rule__Atom__BoolAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8162:1: ( ( ( 'FALSE' ) ) )
            // InternalSymg.g:8163:2: ( ( 'FALSE' ) )
            {
            // InternalSymg.g:8163:2: ( ( 'FALSE' ) )
            // InternalSymg.g:8164:3: ( 'FALSE' )
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 
            // InternalSymg.g:8165:3: ( 'FALSE' )
            // InternalSymg.g:8166:4: 'FALSE'
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 

            }

             after(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__BoolAssignment_5"


    // $ANTLR start "rule__SitProp__SituationNameAssignment_0_0"
    // InternalSymg.g:8177:1: rule__SitProp__SituationNameAssignment_0_0 : ( RULE_ID ) ;
    public final void rule__SitProp__SituationNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8181:1: ( ( RULE_ID ) )
            // InternalSymg.g:8182:2: ( RULE_ID )
            {
            // InternalSymg.g:8182:2: ( RULE_ID )
            // InternalSymg.g:8183:3: RULE_ID
            {
             before(grammarAccess.getSitPropAccess().getSituationNameIDTerminalRuleCall_0_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSitPropAccess().getSituationNameIDTerminalRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__SituationNameAssignment_0_0"


    // $ANTLR start "rule__SitProp__OSituationNameAssignment_0_1"
    // InternalSymg.g:8192:1: rule__SitProp__OSituationNameAssignment_0_1 : ( ruleoState ) ;
    public final void rule__SitProp__OSituationNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8196:1: ( ( ruleoState ) )
            // InternalSymg.g:8197:2: ( ruleoState )
            {
            // InternalSymg.g:8197:2: ( ruleoState )
            // InternalSymg.g:8198:3: ruleoState
            {
             before(grammarAccess.getSitPropAccess().getOSituationNameOStateParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleoState();

            state._fsp--;

             after(grammarAccess.getSitPropAccess().getOSituationNameOStateParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__OSituationNameAssignment_0_1"


    // $ANTLR start "rule__SitProp__CSituationNameAssignment_0_2"
    // InternalSymg.g:8207:1: rule__SitProp__CSituationNameAssignment_0_2 : ( rulecState ) ;
    public final void rule__SitProp__CSituationNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8211:1: ( ( rulecState ) )
            // InternalSymg.g:8212:2: ( rulecState )
            {
            // InternalSymg.g:8212:2: ( rulecState )
            // InternalSymg.g:8213:3: rulecState
            {
             before(grammarAccess.getSitPropAccess().getCSituationNameCStateParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            rulecState();

            state._fsp--;

             after(grammarAccess.getSitPropAccess().getCSituationNameCStateParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__CSituationNameAssignment_0_2"


    // $ANTLR start "rule__SitProp__PSituationNameAssignment_0_3"
    // InternalSymg.g:8222:1: rule__SitProp__PSituationNameAssignment_0_3 : ( rulepState ) ;
    public final void rule__SitProp__PSituationNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8226:1: ( ( rulepState ) )
            // InternalSymg.g:8227:2: ( rulepState )
            {
            // InternalSymg.g:8227:2: ( rulepState )
            // InternalSymg.g:8228:3: rulepState
            {
             before(grammarAccess.getSitPropAccess().getPSituationNamePStateParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            rulepState();

            state._fsp--;

             after(grammarAccess.getSitPropAccess().getPSituationNamePStateParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__PSituationNameAssignment_0_3"


    // $ANTLR start "rule__SitProp__IntervalAssignment_2"
    // InternalSymg.g:8237:1: rule__SitProp__IntervalAssignment_2 : ( ruleInterval ) ;
    public final void rule__SitProp__IntervalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8241:1: ( ( ruleInterval ) )
            // InternalSymg.g:8242:2: ( ruleInterval )
            {
            // InternalSymg.g:8242:2: ( ruleInterval )
            // InternalSymg.g:8243:3: ruleInterval
            {
             before(grammarAccess.getSitPropAccess().getIntervalIntervalParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleInterval();

            state._fsp--;

             after(grammarAccess.getSitPropAccess().getIntervalIntervalParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitProp__IntervalAssignment_2"


    // $ANTLR start "rule__EventProp__EventNameAssignment_0_0"
    // InternalSymg.g:8252:1: rule__EventProp__EventNameAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EventProp__EventNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8256:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:8257:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:8257:2: ( ( RULE_ID ) )
            // InternalSymg.g:8258:3: ( RULE_ID )
            {
             before(grammarAccess.getEventPropAccess().getEventNameDeclarCrossReference_0_0_0()); 
            // InternalSymg.g:8259:3: ( RULE_ID )
            // InternalSymg.g:8260:4: RULE_ID
            {
             before(grammarAccess.getEventPropAccess().getEventNameDeclarIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEventPropAccess().getEventNameDeclarIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getEventPropAccess().getEventNameDeclarCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__EventNameAssignment_0_0"


    // $ANTLR start "rule__EventProp__OEventNameAssignment_0_1"
    // InternalSymg.g:8271:1: rule__EventProp__OEventNameAssignment_0_1 : ( ruleoEvent ) ;
    public final void rule__EventProp__OEventNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8275:1: ( ( ruleoEvent ) )
            // InternalSymg.g:8276:2: ( ruleoEvent )
            {
            // InternalSymg.g:8276:2: ( ruleoEvent )
            // InternalSymg.g:8277:3: ruleoEvent
            {
             before(grammarAccess.getEventPropAccess().getOEventNameOEventParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleoEvent();

            state._fsp--;

             after(grammarAccess.getEventPropAccess().getOEventNameOEventParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__OEventNameAssignment_0_1"


    // $ANTLR start "rule__EventProp__CEventNameAssignment_0_2"
    // InternalSymg.g:8286:1: rule__EventProp__CEventNameAssignment_0_2 : ( rulecEvent ) ;
    public final void rule__EventProp__CEventNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8290:1: ( ( rulecEvent ) )
            // InternalSymg.g:8291:2: ( rulecEvent )
            {
            // InternalSymg.g:8291:2: ( rulecEvent )
            // InternalSymg.g:8292:3: rulecEvent
            {
             before(grammarAccess.getEventPropAccess().getCEventNameCEventParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            rulecEvent();

            state._fsp--;

             after(grammarAccess.getEventPropAccess().getCEventNameCEventParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__CEventNameAssignment_0_2"


    // $ANTLR start "rule__EventProp__PEventNameAssignment_0_3"
    // InternalSymg.g:8301:1: rule__EventProp__PEventNameAssignment_0_3 : ( rulepEvent ) ;
    public final void rule__EventProp__PEventNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8305:1: ( ( rulepEvent ) )
            // InternalSymg.g:8306:2: ( rulepEvent )
            {
            // InternalSymg.g:8306:2: ( rulepEvent )
            // InternalSymg.g:8307:3: rulepEvent
            {
             before(grammarAccess.getEventPropAccess().getPEventNamePEventParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            rulepEvent();

            state._fsp--;

             after(grammarAccess.getEventPropAccess().getPEventNamePEventParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__PEventNameAssignment_0_3"


    // $ANTLR start "rule__EventProp__PointAssignment_2"
    // InternalSymg.g:8316:1: rule__EventProp__PointAssignment_2 : ( rulePoint ) ;
    public final void rule__EventProp__PointAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8320:1: ( ( rulePoint ) )
            // InternalSymg.g:8321:2: ( rulePoint )
            {
            // InternalSymg.g:8321:2: ( rulePoint )
            // InternalSymg.g:8322:3: rulePoint
            {
             before(grammarAccess.getEventPropAccess().getPointPointParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getEventPropAccess().getPointPointParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventProp__PointAssignment_2"


    // $ANTLR start "rule__Interval__SituationNameAssignment_0"
    // InternalSymg.g:8331:1: rule__Interval__SituationNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Interval__SituationNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8335:1: ( ( ruleSitName ) )
            // InternalSymg.g:8336:2: ( ruleSitName )
            {
            // InternalSymg.g:8336:2: ( ruleSitName )
            // InternalSymg.g:8337:3: ruleSitName
            {
             before(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__SituationNameAssignment_0"


    // $ANTLR start "rule__Interval__StartAssignment_1_1"
    // InternalSymg.g:8346:1: rule__Interval__StartAssignment_1_1 : ( rulePoint ) ;
    public final void rule__Interval__StartAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8350:1: ( ( rulePoint ) )
            // InternalSymg.g:8351:2: ( rulePoint )
            {
            // InternalSymg.g:8351:2: ( rulePoint )
            // InternalSymg.g:8352:3: rulePoint
            {
             before(grammarAccess.getIntervalAccess().getStartPointParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getStartPointParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__StartAssignment_1_1"


    // $ANTLR start "rule__Interval__EndAssignment_1_3"
    // InternalSymg.g:8361:1: rule__Interval__EndAssignment_1_3 : ( rulePoint ) ;
    public final void rule__Interval__EndAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8365:1: ( ( rulePoint ) )
            // InternalSymg.g:8366:2: ( rulePoint )
            {
            // InternalSymg.g:8366:2: ( rulePoint )
            // InternalSymg.g:8367:3: rulePoint
            {
             before(grammarAccess.getIntervalAccess().getEndPointParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_2);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getEndPointParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__EndAssignment_1_3"


    // $ANTLR start "rule__Interval__UnnamedAssignment_2"
    // InternalSymg.g:8376:1: rule__Interval__UnnamedAssignment_2 : ( ( 'UNNAMED_INTERVAL' ) ) ;
    public final void rule__Interval__UnnamedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8380:1: ( ( ( 'UNNAMED_INTERVAL' ) ) )
            // InternalSymg.g:8381:2: ( ( 'UNNAMED_INTERVAL' ) )
            {
            // InternalSymg.g:8381:2: ( ( 'UNNAMED_INTERVAL' ) )
            // InternalSymg.g:8382:3: ( 'UNNAMED_INTERVAL' )
            {
             before(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 
            // InternalSymg.g:8383:3: ( 'UNNAMED_INTERVAL' )
            // InternalSymg.g:8384:4: 'UNNAMED_INTERVAL'
            {
             before(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 
            match(input,107,FOLLOW_2); 
             after(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 

            }

             after(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__UnnamedAssignment_2"


    // $ANTLR start "rule__RelativeSituationPointBefore__IntConstAssignment_0"
    // InternalSymg.g:8395:1: rule__RelativeSituationPointBefore__IntConstAssignment_0 : ( ruleIntConst ) ;
    public final void rule__RelativeSituationPointBefore__IntConstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8399:1: ( ( ruleIntConst ) )
            // InternalSymg.g:8400:2: ( ruleIntConst )
            {
            // InternalSymg.g:8400:2: ( ruleIntConst )
            // InternalSymg.g:8401:3: ruleIntConst
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getIntConstIntConstParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleIntConst();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getIntConstIntConstParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__IntConstAssignment_0"


    // $ANTLR start "rule__RelativeSituationPointBefore__UnitAssignment_1"
    // InternalSymg.g:8410:1: rule__RelativeSituationPointBefore__UnitAssignment_1 : ( ruleUnit ) ;
    public final void rule__RelativeSituationPointBefore__UnitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8414:1: ( ( ruleUnit ) )
            // InternalSymg.g:8415:2: ( ruleUnit )
            {
            // InternalSymg.g:8415:2: ( ruleUnit )
            // InternalSymg.g:8416:3: ruleUnit
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getUnitUnitParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getUnitUnitParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__UnitAssignment_1"


    // $ANTLR start "rule__RelativeSituationPointBefore__TempOpAssignment_2"
    // InternalSymg.g:8425:1: rule__RelativeSituationPointBefore__TempOpAssignment_2 : ( ruleTempOp ) ;
    public final void rule__RelativeSituationPointBefore__TempOpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8429:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8430:2: ( ruleTempOp )
            {
            // InternalSymg.g:8430:2: ( ruleTempOp )
            // InternalSymg.g:8431:3: ruleTempOp
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__TempOpAssignment_2"


    // $ANTLR start "rule__RelativeSituationPointBefore__SituationNameAssignment_3"
    // InternalSymg.g:8440:1: rule__RelativeSituationPointBefore__SituationNameAssignment_3 : ( ruleSitName ) ;
    public final void rule__RelativeSituationPointBefore__SituationNameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8444:1: ( ( ruleSitName ) )
            // InternalSymg.g:8445:2: ( ruleSitName )
            {
            // InternalSymg.g:8445:2: ( ruleSitName )
            // InternalSymg.g:8446:3: ruleSitName
            {
             before(grammarAccess.getRelativeSituationPointBeforeAccess().getSituationNameSitNameParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointBeforeAccess().getSituationNameSitNameParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointBefore__SituationNameAssignment_3"


    // $ANTLR start "rule__RelativeSituationPointAfter__SituationNameAssignment_0"
    // InternalSymg.g:8455:1: rule__RelativeSituationPointAfter__SituationNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__RelativeSituationPointAfter__SituationNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8459:1: ( ( ruleSitName ) )
            // InternalSymg.g:8460:2: ( ruleSitName )
            {
            // InternalSymg.g:8460:2: ( ruleSitName )
            // InternalSymg.g:8461:3: ruleSitName
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getSituationNameSitNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointAfterAccess().getSituationNameSitNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__SituationNameAssignment_0"


    // $ANTLR start "rule__RelativeSituationPointAfter__TempOpAssignment_1"
    // InternalSymg.g:8470:1: rule__RelativeSituationPointAfter__TempOpAssignment_1 : ( ruleTempOp ) ;
    public final void rule__RelativeSituationPointAfter__TempOpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8474:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8475:2: ( ruleTempOp )
            {
            // InternalSymg.g:8475:2: ( ruleTempOp )
            // InternalSymg.g:8476:3: ruleTempOp
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getTempOpTempOpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointAfterAccess().getTempOpTempOpParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__TempOpAssignment_1"


    // $ANTLR start "rule__RelativeSituationPointAfter__IntConstAssignment_2"
    // InternalSymg.g:8485:1: rule__RelativeSituationPointAfter__IntConstAssignment_2 : ( ruleIntConst ) ;
    public final void rule__RelativeSituationPointAfter__IntConstAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8489:1: ( ( ruleIntConst ) )
            // InternalSymg.g:8490:2: ( ruleIntConst )
            {
            // InternalSymg.g:8490:2: ( ruleIntConst )
            // InternalSymg.g:8491:3: ruleIntConst
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getIntConstIntConstParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIntConst();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointAfterAccess().getIntConstIntConstParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__IntConstAssignment_2"


    // $ANTLR start "rule__RelativeSituationPointAfter__UnitAssignment_3"
    // InternalSymg.g:8500:1: rule__RelativeSituationPointAfter__UnitAssignment_3 : ( ruleUnit ) ;
    public final void rule__RelativeSituationPointAfter__UnitAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8504:1: ( ( ruleUnit ) )
            // InternalSymg.g:8505:2: ( ruleUnit )
            {
            // InternalSymg.g:8505:2: ( ruleUnit )
            // InternalSymg.g:8506:3: ruleUnit
            {
             before(grammarAccess.getRelativeSituationPointAfterAccess().getUnitUnitParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getRelativeSituationPointAfterAccess().getUnitUnitParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeSituationPointAfter__UnitAssignment_3"


    // $ANTLR start "rule__SitName__DeclNameAssignment_0"
    // InternalSymg.g:8515:1: rule__SitName__DeclNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SitName__DeclNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8519:1: ( ( RULE_ID ) )
            // InternalSymg.g:8520:2: ( RULE_ID )
            {
            // InternalSymg.g:8520:2: ( RULE_ID )
            // InternalSymg.g:8521:3: RULE_ID
            {
             before(grammarAccess.getSitNameAccess().getDeclNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSitNameAccess().getDeclNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__DeclNameAssignment_0"


    // $ANTLR start "rule__SitName__OStateAssignment_1"
    // InternalSymg.g:8530:1: rule__SitName__OStateAssignment_1 : ( ruleoState ) ;
    public final void rule__SitName__OStateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8534:1: ( ( ruleoState ) )
            // InternalSymg.g:8535:2: ( ruleoState )
            {
            // InternalSymg.g:8535:2: ( ruleoState )
            // InternalSymg.g:8536:3: ruleoState
            {
             before(grammarAccess.getSitNameAccess().getOStateOStateParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleoState();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getOStateOStateParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__OStateAssignment_1"


    // $ANTLR start "rule__SitName__PStateAssignment_2"
    // InternalSymg.g:8545:1: rule__SitName__PStateAssignment_2 : ( rulepState ) ;
    public final void rule__SitName__PStateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8549:1: ( ( rulepState ) )
            // InternalSymg.g:8550:2: ( rulepState )
            {
            // InternalSymg.g:8550:2: ( rulepState )
            // InternalSymg.g:8551:3: rulepState
            {
             before(grammarAccess.getSitNameAccess().getPStatePStateParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulepState();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getPStatePStateParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__PStateAssignment_2"


    // $ANTLR start "rule__SitName__CStateAssignment_3"
    // InternalSymg.g:8560:1: rule__SitName__CStateAssignment_3 : ( rulecState ) ;
    public final void rule__SitName__CStateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8564:1: ( ( rulecState ) )
            // InternalSymg.g:8565:2: ( rulecState )
            {
            // InternalSymg.g:8565:2: ( rulecState )
            // InternalSymg.g:8566:3: rulecState
            {
             before(grammarAccess.getSitNameAccess().getCStateCStateParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulecState();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getCStateCStateParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__CStateAssignment_3"


    // $ANTLR start "rule__SitName__OEventAssignment_4"
    // InternalSymg.g:8575:1: rule__SitName__OEventAssignment_4 : ( ruleoEvent ) ;
    public final void rule__SitName__OEventAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8579:1: ( ( ruleoEvent ) )
            // InternalSymg.g:8580:2: ( ruleoEvent )
            {
            // InternalSymg.g:8580:2: ( ruleoEvent )
            // InternalSymg.g:8581:3: ruleoEvent
            {
             before(grammarAccess.getSitNameAccess().getOEventOEventParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleoEvent();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getOEventOEventParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__OEventAssignment_4"


    // $ANTLR start "rule__SitName__CEventAssignment_5"
    // InternalSymg.g:8590:1: rule__SitName__CEventAssignment_5 : ( rulecEvent ) ;
    public final void rule__SitName__CEventAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8594:1: ( ( rulecEvent ) )
            // InternalSymg.g:8595:2: ( rulecEvent )
            {
            // InternalSymg.g:8595:2: ( rulecEvent )
            // InternalSymg.g:8596:3: rulecEvent
            {
             before(grammarAccess.getSitNameAccess().getCEventCEventParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            rulecEvent();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getCEventCEventParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__CEventAssignment_5"


    // $ANTLR start "rule__SitName__PEventAssignment_6"
    // InternalSymg.g:8605:1: rule__SitName__PEventAssignment_6 : ( rulepEvent ) ;
    public final void rule__SitName__PEventAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8609:1: ( ( rulepEvent ) )
            // InternalSymg.g:8610:2: ( rulepEvent )
            {
            // InternalSymg.g:8610:2: ( rulepEvent )
            // InternalSymg.g:8611:3: rulepEvent
            {
             before(grammarAccess.getSitNameAccess().getPEventPEventParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulepEvent();

            state._fsp--;

             after(grammarAccess.getSitNameAccess().getPEventPEventParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__PEventAssignment_6"


    // $ANTLR start "rule__IntConst__TypeAssignment_1"
    // InternalSymg.g:8620:1: rule__IntConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8624:1: ( ( RULE_INT ) )
            // InternalSymg.g:8625:2: ( RULE_INT )
            {
            // InternalSymg.g:8625:2: ( RULE_INT )
            // InternalSymg.g:8626:3: RULE_INT
            {
             before(grammarAccess.getIntConstAccess().getTypeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntConstAccess().getTypeINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntConst__TypeAssignment_1"


    // $ANTLR start "rule__Point__EventNameAssignment_0"
    // InternalSymg.g:8635:1: rule__Point__EventNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Point__EventNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8639:1: ( ( ruleSitName ) )
            // InternalSymg.g:8640:2: ( ruleSitName )
            {
            // InternalSymg.g:8640:2: ( ruleSitName )
            // InternalSymg.g:8641:3: ruleSitName
            {
             before(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__EventNameAssignment_0"


    // $ANTLR start "rule__Point__UnnamedAssignment_1"
    // InternalSymg.g:8650:1: rule__Point__UnnamedAssignment_1 : ( ( 'UNNAMED_POINT' ) ) ;
    public final void rule__Point__UnnamedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8654:1: ( ( ( 'UNNAMED_POINT' ) ) )
            // InternalSymg.g:8655:2: ( ( 'UNNAMED_POINT' ) )
            {
            // InternalSymg.g:8655:2: ( ( 'UNNAMED_POINT' ) )
            // InternalSymg.g:8656:3: ( 'UNNAMED_POINT' )
            {
             before(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 
            // InternalSymg.g:8657:3: ( 'UNNAMED_POINT' )
            // InternalSymg.g:8658:4: 'UNNAMED_POINT'
            {
             before(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 
            match(input,108,FOLLOW_2); 
             after(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 

            }

             after(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__UnnamedAssignment_1"


    // $ANTLR start "rule__Point__PointConstAssignment_2"
    // InternalSymg.g:8669:1: rule__Point__PointConstAssignment_2 : ( rulePointConst ) ;
    public final void rule__Point__PointConstAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8673:1: ( ( rulePointConst ) )
            // InternalSymg.g:8674:2: ( rulePointConst )
            {
            // InternalSymg.g:8674:2: ( rulePointConst )
            // InternalSymg.g:8675:3: rulePointConst
            {
             before(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePointConst();

            state._fsp--;

             after(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__PointConstAssignment_2"


    // $ANTLR start "rule__RelativeEventPointBefore__PointConstAssignment_0"
    // InternalSymg.g:8684:1: rule__RelativeEventPointBefore__PointConstAssignment_0 : ( rulePointConst ) ;
    public final void rule__RelativeEventPointBefore__PointConstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8688:1: ( ( rulePointConst ) )
            // InternalSymg.g:8689:2: ( rulePointConst )
            {
            // InternalSymg.g:8689:2: ( rulePointConst )
            // InternalSymg.g:8690:3: rulePointConst
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getPointConstPointConstParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePointConst();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointBeforeAccess().getPointConstPointConstParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__PointConstAssignment_0"


    // $ANTLR start "rule__RelativeEventPointBefore__UnitAssignment_1"
    // InternalSymg.g:8699:1: rule__RelativeEventPointBefore__UnitAssignment_1 : ( ruleUnit ) ;
    public final void rule__RelativeEventPointBefore__UnitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8703:1: ( ( ruleUnit ) )
            // InternalSymg.g:8704:2: ( ruleUnit )
            {
            // InternalSymg.g:8704:2: ( ruleUnit )
            // InternalSymg.g:8705:3: ruleUnit
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getUnitUnitParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointBeforeAccess().getUnitUnitParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__UnitAssignment_1"


    // $ANTLR start "rule__RelativeEventPointBefore__TempOpAssignment_2"
    // InternalSymg.g:8714:1: rule__RelativeEventPointBefore__TempOpAssignment_2 : ( ruleTempOp ) ;
    public final void rule__RelativeEventPointBefore__TempOpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8718:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8719:2: ( ruleTempOp )
            {
            // InternalSymg.g:8719:2: ( ruleTempOp )
            // InternalSymg.g:8720:3: ruleTempOp
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointBeforeAccess().getTempOpTempOpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__TempOpAssignment_2"


    // $ANTLR start "rule__RelativeEventPointBefore__EventNameAssignment_3"
    // InternalSymg.g:8729:1: rule__RelativeEventPointBefore__EventNameAssignment_3 : ( ruleSitName ) ;
    public final void rule__RelativeEventPointBefore__EventNameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8733:1: ( ( ruleSitName ) )
            // InternalSymg.g:8734:2: ( ruleSitName )
            {
            // InternalSymg.g:8734:2: ( ruleSitName )
            // InternalSymg.g:8735:3: ruleSitName
            {
             before(grammarAccess.getRelativeEventPointBeforeAccess().getEventNameSitNameParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointBeforeAccess().getEventNameSitNameParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointBefore__EventNameAssignment_3"


    // $ANTLR start "rule__RelativeEventPointAfter__EventNameAssignment_0"
    // InternalSymg.g:8744:1: rule__RelativeEventPointAfter__EventNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__RelativeEventPointAfter__EventNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8748:1: ( ( ruleSitName ) )
            // InternalSymg.g:8749:2: ( ruleSitName )
            {
            // InternalSymg.g:8749:2: ( ruleSitName )
            // InternalSymg.g:8750:3: ruleSitName
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getEventNameSitNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointAfterAccess().getEventNameSitNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__EventNameAssignment_0"


    // $ANTLR start "rule__RelativeEventPointAfter__TempOpAssignment_1"
    // InternalSymg.g:8759:1: rule__RelativeEventPointAfter__TempOpAssignment_1 : ( ruleTempOp ) ;
    public final void rule__RelativeEventPointAfter__TempOpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8763:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8764:2: ( ruleTempOp )
            {
            // InternalSymg.g:8764:2: ( ruleTempOp )
            // InternalSymg.g:8765:3: ruleTempOp
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getTempOpTempOpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointAfterAccess().getTempOpTempOpParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__TempOpAssignment_1"


    // $ANTLR start "rule__RelativeEventPointAfter__UnitAssignment_2"
    // InternalSymg.g:8774:1: rule__RelativeEventPointAfter__UnitAssignment_2 : ( ruleUnit ) ;
    public final void rule__RelativeEventPointAfter__UnitAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8778:1: ( ( ruleUnit ) )
            // InternalSymg.g:8779:2: ( ruleUnit )
            {
            // InternalSymg.g:8779:2: ( ruleUnit )
            // InternalSymg.g:8780:3: ruleUnit
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getUnitUnitParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointAfterAccess().getUnitUnitParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__UnitAssignment_2"


    // $ANTLR start "rule__RelativeEventPointAfter__PointConstAssignment_3"
    // InternalSymg.g:8789:1: rule__RelativeEventPointAfter__PointConstAssignment_3 : ( rulePointConst ) ;
    public final void rule__RelativeEventPointAfter__PointConstAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8793:1: ( ( rulePointConst ) )
            // InternalSymg.g:8794:2: ( rulePointConst )
            {
            // InternalSymg.g:8794:2: ( rulePointConst )
            // InternalSymg.g:8795:3: rulePointConst
            {
             before(grammarAccess.getRelativeEventPointAfterAccess().getPointConstPointConstParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePointConst();

            state._fsp--;

             after(grammarAccess.getRelativeEventPointAfterAccess().getPointConstPointConstParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeEventPointAfter__PointConstAssignment_3"


    // $ANTLR start "rule__PEvent__PowEventAssignment_0"
    // InternalSymg.g:8804:1: rule__PEvent__PowEventAssignment_0 : ( rulePowEvent ) ;
    public final void rule__PEvent__PowEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8808:1: ( ( rulePowEvent ) )
            // InternalSymg.g:8809:2: ( rulePowEvent )
            {
            // InternalSymg.g:8809:2: ( rulePowEvent )
            // InternalSymg.g:8810:3: rulePowEvent
            {
             before(grammarAccess.getPEventAccess().getPowEventPowEventParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePowEvent();

            state._fsp--;

             after(grammarAccess.getPEventAccess().getPowEventPowEventParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__PowEventAssignment_0"


    // $ANTLR start "rule__PEvent__PowNameAssignment_2"
    // InternalSymg.g:8819:1: rule__PEvent__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PEvent__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8823:1: ( ( RULE_ID ) )
            // InternalSymg.g:8824:2: ( RULE_ID )
            {
            // InternalSymg.g:8824:2: ( RULE_ID )
            // InternalSymg.g:8825:3: RULE_ID
            {
             before(grammarAccess.getPEventAccess().getPowNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPEventAccess().getPowNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PEvent__PowNameAssignment_2"


    // $ANTLR start "rule__CEvent__ContrEventAssignment_0"
    // InternalSymg.g:8834:1: rule__CEvent__ContrEventAssignment_0 : ( ruleContrEvent ) ;
    public final void rule__CEvent__ContrEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8838:1: ( ( ruleContrEvent ) )
            // InternalSymg.g:8839:2: ( ruleContrEvent )
            {
            // InternalSymg.g:8839:2: ( ruleContrEvent )
            // InternalSymg.g:8840:3: ruleContrEvent
            {
             before(grammarAccess.getCEventAccess().getContrEventContrEventParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleContrEvent();

            state._fsp--;

             after(grammarAccess.getCEventAccess().getContrEventContrEventParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__ContrEventAssignment_0"


    // $ANTLR start "rule__CEvent__ContrNameAssignment_2"
    // InternalSymg.g:8849:1: rule__CEvent__ContrNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CEvent__ContrNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8853:1: ( ( RULE_ID ) )
            // InternalSymg.g:8854:2: ( RULE_ID )
            {
            // InternalSymg.g:8854:2: ( RULE_ID )
            // InternalSymg.g:8855:3: RULE_ID
            {
             before(grammarAccess.getCEventAccess().getContrNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCEventAccess().getContrNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEvent__ContrNameAssignment_2"


    // $ANTLR start "rule__OEvent__OblEventAssignment_0"
    // InternalSymg.g:8864:1: rule__OEvent__OblEventAssignment_0 : ( ruleOblEvent ) ;
    public final void rule__OEvent__OblEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8868:1: ( ( ruleOblEvent ) )
            // InternalSymg.g:8869:2: ( ruleOblEvent )
            {
            // InternalSymg.g:8869:2: ( ruleOblEvent )
            // InternalSymg.g:8870:3: ruleOblEvent
            {
             before(grammarAccess.getOEventAccess().getOblEventOblEventParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOblEvent();

            state._fsp--;

             after(grammarAccess.getOEventAccess().getOblEventOblEventParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__OblEventAssignment_0"


    // $ANTLR start "rule__OEvent__OblNameAssignment_2"
    // InternalSymg.g:8879:1: rule__OEvent__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OEvent__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8883:1: ( ( RULE_ID ) )
            // InternalSymg.g:8884:2: ( RULE_ID )
            {
            // InternalSymg.g:8884:2: ( RULE_ID )
            // InternalSymg.g:8885:3: RULE_ID
            {
             before(grammarAccess.getOEventAccess().getOblNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOEventAccess().getOblNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OEvent__OblNameAssignment_2"


    // $ANTLR start "rule__PointConst__TypeAssignment_1"
    // InternalSymg.g:8894:1: rule__PointConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__PointConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8898:1: ( ( RULE_INT ) )
            // InternalSymg.g:8899:2: ( RULE_INT )
            {
            // InternalSymg.g:8899:2: ( RULE_INT )
            // InternalSymg.g:8900:3: RULE_INT
            {
             before(grammarAccess.getPointConstAccess().getTypeINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPointConstAccess().getTypeINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointConst__TypeAssignment_1"


    // $ANTLR start "rule__OState__OblStateAssignment_0"
    // InternalSymg.g:8909:1: rule__OState__OblStateAssignment_0 : ( ruleOblState ) ;
    public final void rule__OState__OblStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8913:1: ( ( ruleOblState ) )
            // InternalSymg.g:8914:2: ( ruleOblState )
            {
            // InternalSymg.g:8914:2: ( ruleOblState )
            // InternalSymg.g:8915:3: ruleOblState
            {
             before(grammarAccess.getOStateAccess().getOblStateOblStateParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOblState();

            state._fsp--;

             after(grammarAccess.getOStateAccess().getOblStateOblStateParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__OblStateAssignment_0"


    // $ANTLR start "rule__OState__OblNameAssignment_2"
    // InternalSymg.g:8924:1: rule__OState__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OState__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8928:1: ( ( RULE_ID ) )
            // InternalSymg.g:8929:2: ( RULE_ID )
            {
            // InternalSymg.g:8929:2: ( RULE_ID )
            // InternalSymg.g:8930:3: RULE_ID
            {
             before(grammarAccess.getOStateAccess().getOblNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOStateAccess().getOblNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OState__OblNameAssignment_2"


    // $ANTLR start "rule__CState__ContrStateAssignment_0"
    // InternalSymg.g:8939:1: rule__CState__ContrStateAssignment_0 : ( ruleContrState ) ;
    public final void rule__CState__ContrStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8943:1: ( ( ruleContrState ) )
            // InternalSymg.g:8944:2: ( ruleContrState )
            {
            // InternalSymg.g:8944:2: ( ruleContrState )
            // InternalSymg.g:8945:3: ruleContrState
            {
             before(grammarAccess.getCStateAccess().getContrStateContrStateParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleContrState();

            state._fsp--;

             after(grammarAccess.getCStateAccess().getContrStateContrStateParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__ContrStateAssignment_0"


    // $ANTLR start "rule__CState__ContractNameAssignment_2"
    // InternalSymg.g:8954:1: rule__CState__ContractNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CState__ContractNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8958:1: ( ( RULE_ID ) )
            // InternalSymg.g:8959:2: ( RULE_ID )
            {
            // InternalSymg.g:8959:2: ( RULE_ID )
            // InternalSymg.g:8960:3: RULE_ID
            {
             before(grammarAccess.getCStateAccess().getContractNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCStateAccess().getContractNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CState__ContractNameAssignment_2"


    // $ANTLR start "rule__PState__PowStateAssignment_0"
    // InternalSymg.g:8969:1: rule__PState__PowStateAssignment_0 : ( rulePowState ) ;
    public final void rule__PState__PowStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8973:1: ( ( rulePowState ) )
            // InternalSymg.g:8974:2: ( rulePowState )
            {
            // InternalSymg.g:8974:2: ( rulePowState )
            // InternalSymg.g:8975:3: rulePowState
            {
             before(grammarAccess.getPStateAccess().getPowStatePowStateParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePowState();

            state._fsp--;

             after(grammarAccess.getPStateAccess().getPowStatePowStateParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__PowStateAssignment_0"


    // $ANTLR start "rule__PState__PowNameAssignment_2"
    // InternalSymg.g:8984:1: rule__PState__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PState__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8988:1: ( ( RULE_ID ) )
            // InternalSymg.g:8989:2: ( RULE_ID )
            {
            // InternalSymg.g:8989:2: ( RULE_ID )
            // InternalSymg.g:8990:3: RULE_ID
            {
             before(grammarAccess.getPStateAccess().getPowNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPStateAccess().getPowNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PState__PowNameAssignment_2"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String dfa_1s = "\102\uffff";
    static final String dfa_2s = "\1\uffff\1\56\72\uffff\6\56";
    static final String dfa_3s = "\1\4\1\33\51\115\5\uffff\6\4\6\116\6\33";
    static final String dfa_4s = "\1\153\1\142\51\115\5\uffff\6\4\6\116\6\142";
    static final String dfa_5s = "\53\uffff\1\2\1\3\1\4\1\1\1\5\22\uffff";
    static final String dfa_6s = "\102\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\55\33\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\16\1\17\1\20\1\21\1\22\1\23\1\11\1\12\1\13\1\14\1\15\34\uffff\1\53\4\uffff\1\54",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "\1\65",
            "",
            "",
            "",
            "",
            "",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\55\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1423:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ruleRelativeSituationPointBefore ) | ( ruleRelativeSituationPointAfter ) );";
        }
    }
    static final String dfa_8s = "\103\uffff";
    static final String dfa_9s = "\1\uffff\1\56\52\uffff\1\65\20\uffff\6\56";
    static final String dfa_10s = "\1\4\1\33\51\115\1\uffff\1\23\2\uffff\6\4\2\uffff\6\116\6\33";
    static final String dfa_11s = "\1\154\1\147\51\115\1\uffff\1\147\2\uffff\6\4\2\uffff\6\116\6\147";
    static final String dfa_12s = "\53\uffff\1\2\1\uffff\1\5\1\1\6\uffff\1\3\1\4\14\uffff";
    static final String dfa_13s = "\103\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\1\54\33\uffff\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\16\1\17\1\20\1\21\1\22\1\23\1\11\1\12\1\13\1\14\1\15\42\uffff\1\53",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\57",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\60",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\61",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\62",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\63",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "\1\64",
            "",
            "\10\66\63\uffff\1\65\2\uffff\1\65\23\uffff\1\65\1\uffff\1\65",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56",
            "\6\55\55\uffff\1\56\2\uffff\1\56\23\uffff\1\56\1\uffff\1\56"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1615:1: rule__Point__Alternatives : ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ruleRelativeEventPointBefore ) | ( ruleRelativeEventPointAfter ) );";
        }
    }
    static final String dfa_15s = "\16\uffff";
    static final String dfa_16s = "\3\uffff\11\14\2\uffff";
    static final String dfa_17s = "\1\4\1\133\1\4\11\120\2\uffff";
    static final String dfa_18s = "\1\4\1\133\1\22\11\121\2\uffff";
    static final String dfa_19s = "\14\uffff\1\2\1\1";
    static final String dfa_20s = "\16\uffff}>";
    static final String[] dfa_21s = {
            "\1\1",
            "\1\2",
            "\1\3\6\uffff\1\11\1\12\1\13\1\4\1\5\1\6\1\7\1\10",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "\1\14\1\15",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "()* loopback of 3499:2: ( rule__Regular__Group_3_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000001FC8000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00001718000023FFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xFFFFFFFE00000032L,0x00001718000023FFL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000007F810L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00001718400023FFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00001719000023FFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xFFFFFFFE00000010L,0x00000000000003FFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xFF00000000000010L,0x00000000000003FFL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00000840000003FFL});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00001000000003FFL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000007F80000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000001F8000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000020L});

}