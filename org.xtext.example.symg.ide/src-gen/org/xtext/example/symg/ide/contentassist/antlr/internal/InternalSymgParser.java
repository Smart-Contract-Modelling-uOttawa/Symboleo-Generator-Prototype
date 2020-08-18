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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NUMBER'", "'STRING'", "'DATE'", "'ASSET'", "'EVENT'", "'ROLE'", "'SITUATION'", "'CONTRACT'", "'SECONDS'", "'MINUTES'", "'HOURS'", "'DAYS'", "'WEEKS'", "'MONTHS'", "'QUARTERS'", "'YEARS'", "'BEFORE'", "'AFTER'", "'AT'", "'WITHIN'", "'+'", "'-'", "'pTRIGGERED'", "'pACTIVATED'", "'pSUSPENDED'", "'pRESUMED'", "'pEXERTED'", "'pEXPIRED'", "'pTERMINATED'", "'cACTIVATED'", "'cSUSPENDED'", "'cRESUMED'", "'cFULFILLED_ACTIVE_OBLS'", "'cREVOKED_PARTY'", "'cASSIGNED_PARTY'", "'cTERMINATED'", "'oTRIGGERED'", "'oACTIVATED'", "'oSUSPENDED'", "'oRESUMED'", "'oDISCHARGED'", "'oEXPIRED'", "'oFULFILLED'", "'oVIOLATED'", "'oTERMINATED'", "'oCREATE'", "'oINEFFECT'", "'oSUSPENSION'", "'oSUCCESSFUL_TERMINATION'", "'oUNSUCCESSFUL_TERMINATION'", "'oVIOLATION'", "'oFULFILLMENT'", "'oDISCHARGE'", "'cFORM'", "'cINEFFECT'", "'cSUSPENSION'", "'cSUCCESSFUL_TERMINATION'", "'cUNSECCESSFUL_TERMINATION'", "'cUNASSIGN'", "'pCREATE'", "'pINEFFECT'", "'pSUSPENSION'", "'pSUCCESSFUL_TERMINATION'", "'pUNSUCCESSFUL_TERMINATION'", "'Domain'", "'endDomain'", "'Contract'", "'('", "')'", "'endContract'", "';'", "','", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'Surviving'", "'Powers'", "'Constraints'", "'isA'", "'with'", "':'", "'Enumeration'", "':='", "'obligation'", "'->'", "'power'", "'OR'", "'AND'", "'happens'", "'occurs'", "'within'", "'['", "']'", "'NOT'", "'TRUE'", "'FALSE'", "'UNNAMED_INTERVAL'", "'UNNAMED_POINT'"
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
    public static final int T__109=109;
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


    // $ANTLR start "entryRuleSitName"
    // InternalSymg.g:628:1: entryRuleSitName : ruleSitName EOF ;
    public final void entryRuleSitName() throws RecognitionException {
        try {
            // InternalSymg.g:629:1: ( ruleSitName EOF )
            // InternalSymg.g:630:1: ruleSitName EOF
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
    // InternalSymg.g:637:1: ruleSitName : ( ( rule__SitName__Alternatives ) ) ;
    public final void ruleSitName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:641:2: ( ( ( rule__SitName__Alternatives ) ) )
            // InternalSymg.g:642:2: ( ( rule__SitName__Alternatives ) )
            {
            // InternalSymg.g:642:2: ( ( rule__SitName__Alternatives ) )
            // InternalSymg.g:643:3: ( rule__SitName__Alternatives )
            {
             before(grammarAccess.getSitNameAccess().getAlternatives()); 
            // InternalSymg.g:644:3: ( rule__SitName__Alternatives )
            // InternalSymg.g:644:4: rule__SitName__Alternatives
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
    // InternalSymg.g:653:1: entryRuleUnit : ruleUnit EOF ;
    public final void entryRuleUnit() throws RecognitionException {
        try {
            // InternalSymg.g:654:1: ( ruleUnit EOF )
            // InternalSymg.g:655:1: ruleUnit EOF
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
    // InternalSymg.g:662:1: ruleUnit : ( ( rule__Unit__Alternatives ) ) ;
    public final void ruleUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:666:2: ( ( ( rule__Unit__Alternatives ) ) )
            // InternalSymg.g:667:2: ( ( rule__Unit__Alternatives ) )
            {
            // InternalSymg.g:667:2: ( ( rule__Unit__Alternatives ) )
            // InternalSymg.g:668:3: ( rule__Unit__Alternatives )
            {
             before(grammarAccess.getUnitAccess().getAlternatives()); 
            // InternalSymg.g:669:3: ( rule__Unit__Alternatives )
            // InternalSymg.g:669:4: rule__Unit__Alternatives
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
    // InternalSymg.g:678:1: entryRuleIntConst : ruleIntConst EOF ;
    public final void entryRuleIntConst() throws RecognitionException {
        try {
            // InternalSymg.g:679:1: ( ruleIntConst EOF )
            // InternalSymg.g:680:1: ruleIntConst EOF
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
    // InternalSymg.g:687:1: ruleIntConst : ( ( rule__IntConst__Group__0 ) ) ;
    public final void ruleIntConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:691:2: ( ( ( rule__IntConst__Group__0 ) ) )
            // InternalSymg.g:692:2: ( ( rule__IntConst__Group__0 ) )
            {
            // InternalSymg.g:692:2: ( ( rule__IntConst__Group__0 ) )
            // InternalSymg.g:693:3: ( rule__IntConst__Group__0 )
            {
             before(grammarAccess.getIntConstAccess().getGroup()); 
            // InternalSymg.g:694:3: ( rule__IntConst__Group__0 )
            // InternalSymg.g:694:4: rule__IntConst__Group__0
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
    // InternalSymg.g:703:1: entryRuleTempOp : ruleTempOp EOF ;
    public final void entryRuleTempOp() throws RecognitionException {
        try {
            // InternalSymg.g:704:1: ( ruleTempOp EOF )
            // InternalSymg.g:705:1: ruleTempOp EOF
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
    // InternalSymg.g:712:1: ruleTempOp : ( ( rule__TempOp__Alternatives ) ) ;
    public final void ruleTempOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:716:2: ( ( ( rule__TempOp__Alternatives ) ) )
            // InternalSymg.g:717:2: ( ( rule__TempOp__Alternatives ) )
            {
            // InternalSymg.g:717:2: ( ( rule__TempOp__Alternatives ) )
            // InternalSymg.g:718:3: ( rule__TempOp__Alternatives )
            {
             before(grammarAccess.getTempOpAccess().getAlternatives()); 
            // InternalSymg.g:719:3: ( rule__TempOp__Alternatives )
            // InternalSymg.g:719:4: rule__TempOp__Alternatives
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
    // InternalSymg.g:728:1: entryRulePoint : rulePoint EOF ;
    public final void entryRulePoint() throws RecognitionException {
        try {
            // InternalSymg.g:729:1: ( rulePoint EOF )
            // InternalSymg.g:730:1: rulePoint EOF
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
    // InternalSymg.g:737:1: rulePoint : ( ( rule__Point__Alternatives ) ) ;
    public final void rulePoint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:741:2: ( ( ( rule__Point__Alternatives ) ) )
            // InternalSymg.g:742:2: ( ( rule__Point__Alternatives ) )
            {
            // InternalSymg.g:742:2: ( ( rule__Point__Alternatives ) )
            // InternalSymg.g:743:3: ( rule__Point__Alternatives )
            {
             before(grammarAccess.getPointAccess().getAlternatives()); 
            // InternalSymg.g:744:3: ( rule__Point__Alternatives )
            // InternalSymg.g:744:4: rule__Point__Alternatives
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


    // $ANTLR start "entryRulepEvent"
    // InternalSymg.g:753:1: entryRulepEvent : rulepEvent EOF ;
    public final void entryRulepEvent() throws RecognitionException {
        try {
            // InternalSymg.g:754:1: ( rulepEvent EOF )
            // InternalSymg.g:755:1: rulepEvent EOF
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
    // InternalSymg.g:762:1: rulepEvent : ( ( rule__PEvent__Group__0 ) ) ;
    public final void rulepEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:766:2: ( ( ( rule__PEvent__Group__0 ) ) )
            // InternalSymg.g:767:2: ( ( rule__PEvent__Group__0 ) )
            {
            // InternalSymg.g:767:2: ( ( rule__PEvent__Group__0 ) )
            // InternalSymg.g:768:3: ( rule__PEvent__Group__0 )
            {
             before(grammarAccess.getPEventAccess().getGroup()); 
            // InternalSymg.g:769:3: ( rule__PEvent__Group__0 )
            // InternalSymg.g:769:4: rule__PEvent__Group__0
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
    // InternalSymg.g:778:1: entryRulePowEvent : rulePowEvent EOF ;
    public final void entryRulePowEvent() throws RecognitionException {
        try {
            // InternalSymg.g:779:1: ( rulePowEvent EOF )
            // InternalSymg.g:780:1: rulePowEvent EOF
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
    // InternalSymg.g:787:1: rulePowEvent : ( ( rule__PowEvent__Alternatives ) ) ;
    public final void rulePowEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:791:2: ( ( ( rule__PowEvent__Alternatives ) ) )
            // InternalSymg.g:792:2: ( ( rule__PowEvent__Alternatives ) )
            {
            // InternalSymg.g:792:2: ( ( rule__PowEvent__Alternatives ) )
            // InternalSymg.g:793:3: ( rule__PowEvent__Alternatives )
            {
             before(grammarAccess.getPowEventAccess().getAlternatives()); 
            // InternalSymg.g:794:3: ( rule__PowEvent__Alternatives )
            // InternalSymg.g:794:4: rule__PowEvent__Alternatives
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
    // InternalSymg.g:803:1: entryRulecEvent : rulecEvent EOF ;
    public final void entryRulecEvent() throws RecognitionException {
        try {
            // InternalSymg.g:804:1: ( rulecEvent EOF )
            // InternalSymg.g:805:1: rulecEvent EOF
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
    // InternalSymg.g:812:1: rulecEvent : ( ( rule__CEvent__Group__0 ) ) ;
    public final void rulecEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:816:2: ( ( ( rule__CEvent__Group__0 ) ) )
            // InternalSymg.g:817:2: ( ( rule__CEvent__Group__0 ) )
            {
            // InternalSymg.g:817:2: ( ( rule__CEvent__Group__0 ) )
            // InternalSymg.g:818:3: ( rule__CEvent__Group__0 )
            {
             before(grammarAccess.getCEventAccess().getGroup()); 
            // InternalSymg.g:819:3: ( rule__CEvent__Group__0 )
            // InternalSymg.g:819:4: rule__CEvent__Group__0
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
    // InternalSymg.g:828:1: entryRuleContrEvent : ruleContrEvent EOF ;
    public final void entryRuleContrEvent() throws RecognitionException {
        try {
            // InternalSymg.g:829:1: ( ruleContrEvent EOF )
            // InternalSymg.g:830:1: ruleContrEvent EOF
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
    // InternalSymg.g:837:1: ruleContrEvent : ( ( rule__ContrEvent__Alternatives ) ) ;
    public final void ruleContrEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:841:2: ( ( ( rule__ContrEvent__Alternatives ) ) )
            // InternalSymg.g:842:2: ( ( rule__ContrEvent__Alternatives ) )
            {
            // InternalSymg.g:842:2: ( ( rule__ContrEvent__Alternatives ) )
            // InternalSymg.g:843:3: ( rule__ContrEvent__Alternatives )
            {
             before(grammarAccess.getContrEventAccess().getAlternatives()); 
            // InternalSymg.g:844:3: ( rule__ContrEvent__Alternatives )
            // InternalSymg.g:844:4: rule__ContrEvent__Alternatives
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
    // InternalSymg.g:853:1: entryRuleoEvent : ruleoEvent EOF ;
    public final void entryRuleoEvent() throws RecognitionException {
        try {
            // InternalSymg.g:854:1: ( ruleoEvent EOF )
            // InternalSymg.g:855:1: ruleoEvent EOF
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
    // InternalSymg.g:862:1: ruleoEvent : ( ( rule__OEvent__Group__0 ) ) ;
    public final void ruleoEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:866:2: ( ( ( rule__OEvent__Group__0 ) ) )
            // InternalSymg.g:867:2: ( ( rule__OEvent__Group__0 ) )
            {
            // InternalSymg.g:867:2: ( ( rule__OEvent__Group__0 ) )
            // InternalSymg.g:868:3: ( rule__OEvent__Group__0 )
            {
             before(grammarAccess.getOEventAccess().getGroup()); 
            // InternalSymg.g:869:3: ( rule__OEvent__Group__0 )
            // InternalSymg.g:869:4: rule__OEvent__Group__0
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
    // InternalSymg.g:878:1: entryRuleOblEvent : ruleOblEvent EOF ;
    public final void entryRuleOblEvent() throws RecognitionException {
        try {
            // InternalSymg.g:879:1: ( ruleOblEvent EOF )
            // InternalSymg.g:880:1: ruleOblEvent EOF
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
    // InternalSymg.g:887:1: ruleOblEvent : ( ( rule__OblEvent__Alternatives ) ) ;
    public final void ruleOblEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:891:2: ( ( ( rule__OblEvent__Alternatives ) ) )
            // InternalSymg.g:892:2: ( ( rule__OblEvent__Alternatives ) )
            {
            // InternalSymg.g:892:2: ( ( rule__OblEvent__Alternatives ) )
            // InternalSymg.g:893:3: ( rule__OblEvent__Alternatives )
            {
             before(grammarAccess.getOblEventAccess().getAlternatives()); 
            // InternalSymg.g:894:3: ( rule__OblEvent__Alternatives )
            // InternalSymg.g:894:4: rule__OblEvent__Alternatives
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
    // InternalSymg.g:903:1: entryRulePointConst : rulePointConst EOF ;
    public final void entryRulePointConst() throws RecognitionException {
        try {
            // InternalSymg.g:904:1: ( rulePointConst EOF )
            // InternalSymg.g:905:1: rulePointConst EOF
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
    // InternalSymg.g:912:1: rulePointConst : ( ( rule__PointConst__Group__0 ) ) ;
    public final void rulePointConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:916:2: ( ( ( rule__PointConst__Group__0 ) ) )
            // InternalSymg.g:917:2: ( ( rule__PointConst__Group__0 ) )
            {
            // InternalSymg.g:917:2: ( ( rule__PointConst__Group__0 ) )
            // InternalSymg.g:918:3: ( rule__PointConst__Group__0 )
            {
             before(grammarAccess.getPointConstAccess().getGroup()); 
            // InternalSymg.g:919:3: ( rule__PointConst__Group__0 )
            // InternalSymg.g:919:4: rule__PointConst__Group__0
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
    // InternalSymg.g:928:1: entryRuleoState : ruleoState EOF ;
    public final void entryRuleoState() throws RecognitionException {
        try {
            // InternalSymg.g:929:1: ( ruleoState EOF )
            // InternalSymg.g:930:1: ruleoState EOF
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
    // InternalSymg.g:937:1: ruleoState : ( ( rule__OState__Group__0 ) ) ;
    public final void ruleoState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:941:2: ( ( ( rule__OState__Group__0 ) ) )
            // InternalSymg.g:942:2: ( ( rule__OState__Group__0 ) )
            {
            // InternalSymg.g:942:2: ( ( rule__OState__Group__0 ) )
            // InternalSymg.g:943:3: ( rule__OState__Group__0 )
            {
             before(grammarAccess.getOStateAccess().getGroup()); 
            // InternalSymg.g:944:3: ( rule__OState__Group__0 )
            // InternalSymg.g:944:4: rule__OState__Group__0
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
    // InternalSymg.g:953:1: entryRuleOblState : ruleOblState EOF ;
    public final void entryRuleOblState() throws RecognitionException {
        try {
            // InternalSymg.g:954:1: ( ruleOblState EOF )
            // InternalSymg.g:955:1: ruleOblState EOF
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
    // InternalSymg.g:962:1: ruleOblState : ( ( rule__OblState__Alternatives ) ) ;
    public final void ruleOblState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:966:2: ( ( ( rule__OblState__Alternatives ) ) )
            // InternalSymg.g:967:2: ( ( rule__OblState__Alternatives ) )
            {
            // InternalSymg.g:967:2: ( ( rule__OblState__Alternatives ) )
            // InternalSymg.g:968:3: ( rule__OblState__Alternatives )
            {
             before(grammarAccess.getOblStateAccess().getAlternatives()); 
            // InternalSymg.g:969:3: ( rule__OblState__Alternatives )
            // InternalSymg.g:969:4: rule__OblState__Alternatives
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
    // InternalSymg.g:978:1: entryRulecState : rulecState EOF ;
    public final void entryRulecState() throws RecognitionException {
        try {
            // InternalSymg.g:979:1: ( rulecState EOF )
            // InternalSymg.g:980:1: rulecState EOF
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
    // InternalSymg.g:987:1: rulecState : ( ( rule__CState__Group__0 ) ) ;
    public final void rulecState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:991:2: ( ( ( rule__CState__Group__0 ) ) )
            // InternalSymg.g:992:2: ( ( rule__CState__Group__0 ) )
            {
            // InternalSymg.g:992:2: ( ( rule__CState__Group__0 ) )
            // InternalSymg.g:993:3: ( rule__CState__Group__0 )
            {
             before(grammarAccess.getCStateAccess().getGroup()); 
            // InternalSymg.g:994:3: ( rule__CState__Group__0 )
            // InternalSymg.g:994:4: rule__CState__Group__0
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
    // InternalSymg.g:1003:1: entryRuleContrState : ruleContrState EOF ;
    public final void entryRuleContrState() throws RecognitionException {
        try {
            // InternalSymg.g:1004:1: ( ruleContrState EOF )
            // InternalSymg.g:1005:1: ruleContrState EOF
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
    // InternalSymg.g:1012:1: ruleContrState : ( ( rule__ContrState__Alternatives ) ) ;
    public final void ruleContrState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1016:2: ( ( ( rule__ContrState__Alternatives ) ) )
            // InternalSymg.g:1017:2: ( ( rule__ContrState__Alternatives ) )
            {
            // InternalSymg.g:1017:2: ( ( rule__ContrState__Alternatives ) )
            // InternalSymg.g:1018:3: ( rule__ContrState__Alternatives )
            {
             before(grammarAccess.getContrStateAccess().getAlternatives()); 
            // InternalSymg.g:1019:3: ( rule__ContrState__Alternatives )
            // InternalSymg.g:1019:4: rule__ContrState__Alternatives
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
    // InternalSymg.g:1028:1: entryRulepState : rulepState EOF ;
    public final void entryRulepState() throws RecognitionException {
        try {
            // InternalSymg.g:1029:1: ( rulepState EOF )
            // InternalSymg.g:1030:1: rulepState EOF
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
    // InternalSymg.g:1037:1: rulepState : ( ( rule__PState__Group__0 ) ) ;
    public final void rulepState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1041:2: ( ( ( rule__PState__Group__0 ) ) )
            // InternalSymg.g:1042:2: ( ( rule__PState__Group__0 ) )
            {
            // InternalSymg.g:1042:2: ( ( rule__PState__Group__0 ) )
            // InternalSymg.g:1043:3: ( rule__PState__Group__0 )
            {
             before(grammarAccess.getPStateAccess().getGroup()); 
            // InternalSymg.g:1044:3: ( rule__PState__Group__0 )
            // InternalSymg.g:1044:4: rule__PState__Group__0
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
    // InternalSymg.g:1053:1: entryRulePowState : rulePowState EOF ;
    public final void entryRulePowState() throws RecognitionException {
        try {
            // InternalSymg.g:1054:1: ( rulePowState EOF )
            // InternalSymg.g:1055:1: rulePowState EOF
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
    // InternalSymg.g:1062:1: rulePowState : ( ( rule__PowState__Alternatives ) ) ;
    public final void rulePowState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1066:2: ( ( ( rule__PowState__Alternatives ) ) )
            // InternalSymg.g:1067:2: ( ( rule__PowState__Alternatives ) )
            {
            // InternalSymg.g:1067:2: ( ( rule__PowState__Alternatives ) )
            // InternalSymg.g:1068:3: ( rule__PowState__Alternatives )
            {
             before(grammarAccess.getPowStateAccess().getAlternatives()); 
            // InternalSymg.g:1069:3: ( rule__PowState__Alternatives )
            // InternalSymg.g:1069:4: rule__PowState__Alternatives
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
    // InternalSymg.g:1077:1: rule__DomainConcept__Alternatives : ( ( ruleRegular ) | ( ruleEnumeration ) );
    public final void rule__DomainConcept__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1081:1: ( ( ruleRegular ) | ( ruleEnumeration ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==90) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==RULE_ID||(LA1_2>=11 && LA1_2<=18)) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==93) ) {
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
                    // InternalSymg.g:1082:2: ( ruleRegular )
                    {
                    // InternalSymg.g:1082:2: ( ruleRegular )
                    // InternalSymg.g:1083:3: ruleRegular
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
                    // InternalSymg.g:1088:2: ( ruleEnumeration )
                    {
                    // InternalSymg.g:1088:2: ( ruleEnumeration )
                    // InternalSymg.g:1089:3: ruleEnumeration
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
    // InternalSymg.g:1098:1: rule__CType__Alternatives : ( ( ruleDomainType ) | ( ruleOntoCType ) | ( ruleBasicType ) );
    public final void rule__CType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1102:1: ( ( ruleDomainType ) | ( ruleOntoCType ) | ( ruleBasicType ) )
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
                    // InternalSymg.g:1103:2: ( ruleDomainType )
                    {
                    // InternalSymg.g:1103:2: ( ruleDomainType )
                    // InternalSymg.g:1104:3: ruleDomainType
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
                    // InternalSymg.g:1109:2: ( ruleOntoCType )
                    {
                    // InternalSymg.g:1109:2: ( ruleOntoCType )
                    // InternalSymg.g:1110:3: ruleOntoCType
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
                    // InternalSymg.g:1115:2: ( ruleBasicType )
                    {
                    // InternalSymg.g:1115:2: ( ruleBasicType )
                    // InternalSymg.g:1116:3: ruleBasicType
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
    // InternalSymg.g:1125:1: rule__BasicType__NameAlternatives_0 : ( ( 'NUMBER' ) | ( 'STRING' ) | ( 'DATE' ) );
    public final void rule__BasicType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1129:1: ( ( 'NUMBER' ) | ( 'STRING' ) | ( 'DATE' ) )
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
                    // InternalSymg.g:1130:2: ( 'NUMBER' )
                    {
                    // InternalSymg.g:1130:2: ( 'NUMBER' )
                    // InternalSymg.g:1131:3: 'NUMBER'
                    {
                     before(grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1136:2: ( 'STRING' )
                    {
                    // InternalSymg.g:1136:2: ( 'STRING' )
                    // InternalSymg.g:1137:3: 'STRING'
                    {
                     before(grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1142:2: ( 'DATE' )
                    {
                    // InternalSymg.g:1142:2: ( 'DATE' )
                    // InternalSymg.g:1143:3: 'DATE'
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
    // InternalSymg.g:1152:1: rule__OntoCType__NameAlternatives_0 : ( ( 'ASSET' ) | ( 'EVENT' ) | ( 'ROLE' ) | ( 'SITUATION' ) | ( 'CONTRACT' ) );
    public final void rule__OntoCType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1156:1: ( ( 'ASSET' ) | ( 'EVENT' ) | ( 'ROLE' ) | ( 'SITUATION' ) | ( 'CONTRACT' ) )
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
                    // InternalSymg.g:1157:2: ( 'ASSET' )
                    {
                    // InternalSymg.g:1157:2: ( 'ASSET' )
                    // InternalSymg.g:1158:3: 'ASSET'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1163:2: ( 'EVENT' )
                    {
                    // InternalSymg.g:1163:2: ( 'EVENT' )
                    // InternalSymg.g:1164:3: 'EVENT'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1169:2: ( 'ROLE' )
                    {
                    // InternalSymg.g:1169:2: ( 'ROLE' )
                    // InternalSymg.g:1170:3: 'ROLE'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1175:2: ( 'SITUATION' )
                    {
                    // InternalSymg.g:1175:2: ( 'SITUATION' )
                    // InternalSymg.g:1176:3: 'SITUATION'
                    {
                     before(grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1181:2: ( 'CONTRACT' )
                    {
                    // InternalSymg.g:1181:2: ( 'CONTRACT' )
                    // InternalSymg.g:1182:3: 'CONTRACT'
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
    // InternalSymg.g:1191:1: rule__TypeName__Alternatives : ( ( ruleDomainType ) | ( ruleBasicType ) );
    public final void rule__TypeName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1195:1: ( ( ruleDomainType ) | ( ruleBasicType ) )
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
                    // InternalSymg.g:1196:2: ( ruleDomainType )
                    {
                    // InternalSymg.g:1196:2: ( ruleDomainType )
                    // InternalSymg.g:1197:3: ruleDomainType
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
                    // InternalSymg.g:1202:2: ( ruleBasicType )
                    {
                    // InternalSymg.g:1202:2: ( ruleBasicType )
                    // InternalSymg.g:1203:3: ruleBasicType
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
    // InternalSymg.g:1212:1: rule__Atom__Alternatives : ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__BoolAssignment_3 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1216:1: ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__BoolAssignment_3 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt6=1;
                }
                break;
            case 101:
                {
                alt6=2;
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
            case 74:
            case 109:
                {
                alt6=3;
                }
                break;
            case 106:
                {
                alt6=4;
                }
                break;
            case 107:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalSymg.g:1217:2: ( ( rule__Atom__Group_0__0 ) )
                    {
                    // InternalSymg.g:1217:2: ( ( rule__Atom__Group_0__0 ) )
                    // InternalSymg.g:1218:3: ( rule__Atom__Group_0__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_0()); 
                    // InternalSymg.g:1219:3: ( rule__Atom__Group_0__0 )
                    // InternalSymg.g:1219:4: rule__Atom__Group_0__0
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
                    // InternalSymg.g:1223:2: ( ( rule__Atom__Group_1__0 ) )
                    {
                    // InternalSymg.g:1223:2: ( ( rule__Atom__Group_1__0 ) )
                    // InternalSymg.g:1224:3: ( rule__Atom__Group_1__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_1()); 
                    // InternalSymg.g:1225:3: ( rule__Atom__Group_1__0 )
                    // InternalSymg.g:1225:4: rule__Atom__Group_1__0
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
                    // InternalSymg.g:1229:2: ( ( rule__Atom__Group_2__0 ) )
                    {
                    // InternalSymg.g:1229:2: ( ( rule__Atom__Group_2__0 ) )
                    // InternalSymg.g:1230:3: ( rule__Atom__Group_2__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_2()); 
                    // InternalSymg.g:1231:3: ( rule__Atom__Group_2__0 )
                    // InternalSymg.g:1231:4: rule__Atom__Group_2__0
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
                    // InternalSymg.g:1235:2: ( ( rule__Atom__BoolAssignment_3 ) )
                    {
                    // InternalSymg.g:1235:2: ( ( rule__Atom__BoolAssignment_3 ) )
                    // InternalSymg.g:1236:3: ( rule__Atom__BoolAssignment_3 )
                    {
                     before(grammarAccess.getAtomAccess().getBoolAssignment_3()); 
                    // InternalSymg.g:1237:3: ( rule__Atom__BoolAssignment_3 )
                    // InternalSymg.g:1237:4: rule__Atom__BoolAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__BoolAssignment_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getBoolAssignment_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1241:2: ( ( rule__Atom__BoolAssignment_4 ) )
                    {
                    // InternalSymg.g:1241:2: ( ( rule__Atom__BoolAssignment_4 ) )
                    // InternalSymg.g:1242:3: ( rule__Atom__BoolAssignment_4 )
                    {
                     before(grammarAccess.getAtomAccess().getBoolAssignment_4()); 
                    // InternalSymg.g:1243:3: ( rule__Atom__BoolAssignment_4 )
                    // InternalSymg.g:1243:4: rule__Atom__BoolAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Atom__BoolAssignment_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getAtomAccess().getBoolAssignment_4()); 

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
    // InternalSymg.g:1251:1: rule__SitProp__Alternatives_0 : ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) );
    public final void rule__SitProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1255:1: ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) )
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
            case 63:
                {
                alt7=2;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                {
                alt7=3;
                }
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
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
                    // InternalSymg.g:1256:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1256:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    // InternalSymg.g:1257:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    {
                     before(grammarAccess.getSitPropAccess().getSituationNameAssignment_0_0()); 
                    // InternalSymg.g:1258:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    // InternalSymg.g:1258:4: rule__SitProp__SituationNameAssignment_0_0
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
                    // InternalSymg.g:1262:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1262:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    // InternalSymg.g:1263:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    {
                     before(grammarAccess.getSitPropAccess().getOSituationNameAssignment_0_1()); 
                    // InternalSymg.g:1264:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    // InternalSymg.g:1264:4: rule__SitProp__OSituationNameAssignment_0_1
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
                    // InternalSymg.g:1268:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1268:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    // InternalSymg.g:1269:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    {
                     before(grammarAccess.getSitPropAccess().getCSituationNameAssignment_0_2()); 
                    // InternalSymg.g:1270:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    // InternalSymg.g:1270:4: rule__SitProp__CSituationNameAssignment_0_2
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
                    // InternalSymg.g:1274:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1274:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    // InternalSymg.g:1275:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    {
                     before(grammarAccess.getSitPropAccess().getPSituationNameAssignment_0_3()); 
                    // InternalSymg.g:1276:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    // InternalSymg.g:1276:4: rule__SitProp__PSituationNameAssignment_0_3
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
    // InternalSymg.g:1284:1: rule__EventProp__Alternatives_0 : ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) );
    public final void rule__EventProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1288:1: ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) )
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
                    // InternalSymg.g:1289:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1289:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    // InternalSymg.g:1290:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    {
                     before(grammarAccess.getEventPropAccess().getEventNameAssignment_0_0()); 
                    // InternalSymg.g:1291:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    // InternalSymg.g:1291:4: rule__EventProp__EventNameAssignment_0_0
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
                    // InternalSymg.g:1295:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1295:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    // InternalSymg.g:1296:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    {
                     before(grammarAccess.getEventPropAccess().getOEventNameAssignment_0_1()); 
                    // InternalSymg.g:1297:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    // InternalSymg.g:1297:4: rule__EventProp__OEventNameAssignment_0_1
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
                    // InternalSymg.g:1301:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1301:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    // InternalSymg.g:1302:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    {
                     before(grammarAccess.getEventPropAccess().getCEventNameAssignment_0_2()); 
                    // InternalSymg.g:1303:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    // InternalSymg.g:1303:4: rule__EventProp__CEventNameAssignment_0_2
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
                    // InternalSymg.g:1307:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1307:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    // InternalSymg.g:1308:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    {
                     before(grammarAccess.getEventPropAccess().getPEventNameAssignment_0_3()); 
                    // InternalSymg.g:1309:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    // InternalSymg.g:1309:4: rule__EventProp__PEventNameAssignment_0_3
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
    // InternalSymg.g:1317:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) );
    public final void rule__Interval__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1321:1: ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalSymg.g:1322:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1322:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    // InternalSymg.g:1323:3: ( rule__Interval__SituationNameAssignment_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getSituationNameAssignment_0()); 
                    // InternalSymg.g:1324:3: ( rule__Interval__SituationNameAssignment_0 )
                    // InternalSymg.g:1324:4: rule__Interval__SituationNameAssignment_0
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
                    // InternalSymg.g:1328:2: ( ( rule__Interval__Group_1__0 ) )
                    {
                    // InternalSymg.g:1328:2: ( ( rule__Interval__Group_1__0 ) )
                    // InternalSymg.g:1329:3: ( rule__Interval__Group_1__0 )
                    {
                     before(grammarAccess.getIntervalAccess().getGroup_1()); 
                    // InternalSymg.g:1330:3: ( rule__Interval__Group_1__0 )
                    // InternalSymg.g:1330:4: rule__Interval__Group_1__0
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
                    // InternalSymg.g:1334:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    {
                    // InternalSymg.g:1334:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    // InternalSymg.g:1335:3: ( rule__Interval__UnnamedAssignment_2 )
                    {
                     before(grammarAccess.getIntervalAccess().getUnnamedAssignment_2()); 
                    // InternalSymg.g:1336:3: ( rule__Interval__UnnamedAssignment_2 )
                    // InternalSymg.g:1336:4: rule__Interval__UnnamedAssignment_2
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
                    // InternalSymg.g:1340:2: ( ( rule__Interval__Group_3__0 ) )
                    {
                    // InternalSymg.g:1340:2: ( ( rule__Interval__Group_3__0 ) )
                    // InternalSymg.g:1341:3: ( rule__Interval__Group_3__0 )
                    {
                     before(grammarAccess.getIntervalAccess().getGroup_3()); 
                    // InternalSymg.g:1342:3: ( rule__Interval__Group_3__0 )
                    // InternalSymg.g:1342:4: rule__Interval__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Interval__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIntervalAccess().getGroup_3()); 

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
    // InternalSymg.g:1350:1: rule__SitName__Alternatives : ( ( ( rule__SitName__SitNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) );
    public final void rule__SitName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1354:1: ( ( ( rule__SitName__SitNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) )
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
            case 63:
                {
                alt10=2;
                }
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt10=3;
                }
                break;
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
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
                    // InternalSymg.g:1355:2: ( ( rule__SitName__SitNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1355:2: ( ( rule__SitName__SitNameAssignment_0 ) )
                    // InternalSymg.g:1356:3: ( rule__SitName__SitNameAssignment_0 )
                    {
                     before(grammarAccess.getSitNameAccess().getSitNameAssignment_0()); 
                    // InternalSymg.g:1357:3: ( rule__SitName__SitNameAssignment_0 )
                    // InternalSymg.g:1357:4: rule__SitName__SitNameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SitName__SitNameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSitNameAccess().getSitNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1361:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    {
                    // InternalSymg.g:1361:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    // InternalSymg.g:1362:3: ( rule__SitName__OStateAssignment_1 )
                    {
                     before(grammarAccess.getSitNameAccess().getOStateAssignment_1()); 
                    // InternalSymg.g:1363:3: ( rule__SitName__OStateAssignment_1 )
                    // InternalSymg.g:1363:4: rule__SitName__OStateAssignment_1
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
                    // InternalSymg.g:1367:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    {
                    // InternalSymg.g:1367:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    // InternalSymg.g:1368:3: ( rule__SitName__PStateAssignment_2 )
                    {
                     before(grammarAccess.getSitNameAccess().getPStateAssignment_2()); 
                    // InternalSymg.g:1369:3: ( rule__SitName__PStateAssignment_2 )
                    // InternalSymg.g:1369:4: rule__SitName__PStateAssignment_2
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
                    // InternalSymg.g:1373:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    {
                    // InternalSymg.g:1373:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    // InternalSymg.g:1374:3: ( rule__SitName__CStateAssignment_3 )
                    {
                     before(grammarAccess.getSitNameAccess().getCStateAssignment_3()); 
                    // InternalSymg.g:1375:3: ( rule__SitName__CStateAssignment_3 )
                    // InternalSymg.g:1375:4: rule__SitName__CStateAssignment_3
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
                    // InternalSymg.g:1379:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    {
                    // InternalSymg.g:1379:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    // InternalSymg.g:1380:3: ( rule__SitName__OEventAssignment_4 )
                    {
                     before(grammarAccess.getSitNameAccess().getOEventAssignment_4()); 
                    // InternalSymg.g:1381:3: ( rule__SitName__OEventAssignment_4 )
                    // InternalSymg.g:1381:4: rule__SitName__OEventAssignment_4
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
                    // InternalSymg.g:1385:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    {
                    // InternalSymg.g:1385:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    // InternalSymg.g:1386:3: ( rule__SitName__CEventAssignment_5 )
                    {
                     before(grammarAccess.getSitNameAccess().getCEventAssignment_5()); 
                    // InternalSymg.g:1387:3: ( rule__SitName__CEventAssignment_5 )
                    // InternalSymg.g:1387:4: rule__SitName__CEventAssignment_5
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
                    // InternalSymg.g:1391:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    {
                    // InternalSymg.g:1391:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    // InternalSymg.g:1392:3: ( rule__SitName__PEventAssignment_6 )
                    {
                     before(grammarAccess.getSitNameAccess().getPEventAssignment_6()); 
                    // InternalSymg.g:1393:3: ( rule__SitName__PEventAssignment_6 )
                    // InternalSymg.g:1393:4: rule__SitName__PEventAssignment_6
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
    // InternalSymg.g:1401:1: rule__Unit__Alternatives : ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) );
    public final void rule__Unit__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1405:1: ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) )
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
                    // InternalSymg.g:1406:2: ( 'SECONDS' )
                    {
                    // InternalSymg.g:1406:2: ( 'SECONDS' )
                    // InternalSymg.g:1407:3: 'SECONDS'
                    {
                     before(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1412:2: ( 'MINUTES' )
                    {
                    // InternalSymg.g:1412:2: ( 'MINUTES' )
                    // InternalSymg.g:1413:3: 'MINUTES'
                    {
                     before(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1418:2: ( 'HOURS' )
                    {
                    // InternalSymg.g:1418:2: ( 'HOURS' )
                    // InternalSymg.g:1419:3: 'HOURS'
                    {
                     before(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1424:2: ( 'DAYS' )
                    {
                    // InternalSymg.g:1424:2: ( 'DAYS' )
                    // InternalSymg.g:1425:3: 'DAYS'
                    {
                     before(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1430:2: ( 'WEEKS' )
                    {
                    // InternalSymg.g:1430:2: ( 'WEEKS' )
                    // InternalSymg.g:1431:3: 'WEEKS'
                    {
                     before(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1436:2: ( 'MONTHS' )
                    {
                    // InternalSymg.g:1436:2: ( 'MONTHS' )
                    // InternalSymg.g:1437:3: 'MONTHS'
                    {
                     before(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1442:2: ( 'QUARTERS' )
                    {
                    // InternalSymg.g:1442:2: ( 'QUARTERS' )
                    // InternalSymg.g:1443:3: 'QUARTERS'
                    {
                     before(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1448:2: ( 'YEARS' )
                    {
                    // InternalSymg.g:1448:2: ( 'YEARS' )
                    // InternalSymg.g:1449:3: 'YEARS'
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
    // InternalSymg.g:1458:1: rule__TempOp__Alternatives : ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) );
    public final void rule__TempOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1462:1: ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) )
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
                    // InternalSymg.g:1463:2: ( 'BEFORE' )
                    {
                    // InternalSymg.g:1463:2: ( 'BEFORE' )
                    // InternalSymg.g:1464:3: 'BEFORE'
                    {
                     before(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1469:2: ( 'AFTER' )
                    {
                    // InternalSymg.g:1469:2: ( 'AFTER' )
                    // InternalSymg.g:1470:3: 'AFTER'
                    {
                     before(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1475:2: ( 'AT' )
                    {
                    // InternalSymg.g:1475:2: ( 'AT' )
                    // InternalSymg.g:1476:3: 'AT'
                    {
                     before(grammarAccess.getTempOpAccess().getATKeyword_2()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getATKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1481:2: ( 'WITHIN' )
                    {
                    // InternalSymg.g:1481:2: ( 'WITHIN' )
                    // InternalSymg.g:1482:3: 'WITHIN'
                    {
                     before(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1487:2: ( '+' )
                    {
                    // InternalSymg.g:1487:2: ( '+' )
                    // InternalSymg.g:1488:3: '+'
                    {
                     before(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1493:2: ( '-' )
                    {
                    // InternalSymg.g:1493:2: ( '-' )
                    // InternalSymg.g:1494:3: '-'
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
    // InternalSymg.g:1503:1: rule__Point__Alternatives : ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ( rule__Point__Group_3__0 ) ) );
    public final void rule__Point__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1507:1: ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ( rule__Point__Group_3__0 ) ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
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
            case 74:
                {
                alt13=1;
                }
                break;
            case 109:
                {
                alt13=2;
                }
                break;
            case RULE_INT:
                {
                int LA13_3 = input.LA(2);

                if ( (LA13_3==EOF||LA13_3==79||LA13_3==82||LA13_3==102||LA13_3==104) ) {
                    alt13=3;
                }
                else if ( ((LA13_3>=19 && LA13_3<=26)) ) {
                    alt13=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalSymg.g:1508:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1508:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    // InternalSymg.g:1509:3: ( rule__Point__EventNameAssignment_0 )
                    {
                     before(grammarAccess.getPointAccess().getEventNameAssignment_0()); 
                    // InternalSymg.g:1510:3: ( rule__Point__EventNameAssignment_0 )
                    // InternalSymg.g:1510:4: rule__Point__EventNameAssignment_0
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
                    // InternalSymg.g:1514:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    {
                    // InternalSymg.g:1514:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    // InternalSymg.g:1515:3: ( rule__Point__UnnamedAssignment_1 )
                    {
                     before(grammarAccess.getPointAccess().getUnnamedAssignment_1()); 
                    // InternalSymg.g:1516:3: ( rule__Point__UnnamedAssignment_1 )
                    // InternalSymg.g:1516:4: rule__Point__UnnamedAssignment_1
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
                    // InternalSymg.g:1520:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    {
                    // InternalSymg.g:1520:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    // InternalSymg.g:1521:3: ( rule__Point__PointConstAssignment_2 )
                    {
                     before(grammarAccess.getPointAccess().getPointConstAssignment_2()); 
                    // InternalSymg.g:1522:3: ( rule__Point__PointConstAssignment_2 )
                    // InternalSymg.g:1522:4: rule__Point__PointConstAssignment_2
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
                    // InternalSymg.g:1526:2: ( ( rule__Point__Group_3__0 ) )
                    {
                    // InternalSymg.g:1526:2: ( ( rule__Point__Group_3__0 ) )
                    // InternalSymg.g:1527:3: ( rule__Point__Group_3__0 )
                    {
                     before(grammarAccess.getPointAccess().getGroup_3()); 
                    // InternalSymg.g:1528:3: ( rule__Point__Group_3__0 )
                    // InternalSymg.g:1528:4: rule__Point__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Point__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointAccess().getGroup_3()); 

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
    // InternalSymg.g:1536:1: rule__PowEvent__Alternatives : ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) );
    public final void rule__PowEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1540:1: ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) )
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
                    // InternalSymg.g:1541:2: ( 'pTRIGGERED' )
                    {
                    // InternalSymg.g:1541:2: ( 'pTRIGGERED' )
                    // InternalSymg.g:1542:3: 'pTRIGGERED'
                    {
                     before(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1547:2: ( 'pACTIVATED' )
                    {
                    // InternalSymg.g:1547:2: ( 'pACTIVATED' )
                    // InternalSymg.g:1548:3: 'pACTIVATED'
                    {
                     before(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1553:2: ( 'pSUSPENDED' )
                    {
                    // InternalSymg.g:1553:2: ( 'pSUSPENDED' )
                    // InternalSymg.g:1554:3: 'pSUSPENDED'
                    {
                     before(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1559:2: ( 'pRESUMED' )
                    {
                    // InternalSymg.g:1559:2: ( 'pRESUMED' )
                    // InternalSymg.g:1560:3: 'pRESUMED'
                    {
                     before(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1565:2: ( 'pEXERTED' )
                    {
                    // InternalSymg.g:1565:2: ( 'pEXERTED' )
                    // InternalSymg.g:1566:3: 'pEXERTED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1571:2: ( 'pEXPIRED' )
                    {
                    // InternalSymg.g:1571:2: ( 'pEXPIRED' )
                    // InternalSymg.g:1572:3: 'pEXPIRED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1577:2: ( 'pTERMINATED' )
                    {
                    // InternalSymg.g:1577:2: ( 'pTERMINATED' )
                    // InternalSymg.g:1578:3: 'pTERMINATED'
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
    // InternalSymg.g:1587:1: rule__ContrEvent__Alternatives : ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) );
    public final void rule__ContrEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1591:1: ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) )
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
                    // InternalSymg.g:1592:2: ( 'cACTIVATED' )
                    {
                    // InternalSymg.g:1592:2: ( 'cACTIVATED' )
                    // InternalSymg.g:1593:3: 'cACTIVATED'
                    {
                     before(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1598:2: ( 'cSUSPENDED' )
                    {
                    // InternalSymg.g:1598:2: ( 'cSUSPENDED' )
                    // InternalSymg.g:1599:3: 'cSUSPENDED'
                    {
                     before(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1604:2: ( 'cRESUMED' )
                    {
                    // InternalSymg.g:1604:2: ( 'cRESUMED' )
                    // InternalSymg.g:1605:3: 'cRESUMED'
                    {
                     before(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1610:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    {
                    // InternalSymg.g:1610:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    // InternalSymg.g:1611:3: 'cFULFILLED_ACTIVE_OBLS'
                    {
                     before(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1616:2: ( 'cREVOKED_PARTY' )
                    {
                    // InternalSymg.g:1616:2: ( 'cREVOKED_PARTY' )
                    // InternalSymg.g:1617:3: 'cREVOKED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1622:2: ( 'cASSIGNED_PARTY' )
                    {
                    // InternalSymg.g:1622:2: ( 'cASSIGNED_PARTY' )
                    // InternalSymg.g:1623:3: 'cASSIGNED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1628:2: ( 'cTERMINATED' )
                    {
                    // InternalSymg.g:1628:2: ( 'cTERMINATED' )
                    // InternalSymg.g:1629:3: 'cTERMINATED'
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
    // InternalSymg.g:1638:1: rule__OblEvent__Alternatives : ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) );
    public final void rule__OblEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1642:1: ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) )
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
                    // InternalSymg.g:1643:2: ( 'oTRIGGERED' )
                    {
                    // InternalSymg.g:1643:2: ( 'oTRIGGERED' )
                    // InternalSymg.g:1644:3: 'oTRIGGERED'
                    {
                     before(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1649:2: ( 'oACTIVATED' )
                    {
                    // InternalSymg.g:1649:2: ( 'oACTIVATED' )
                    // InternalSymg.g:1650:3: 'oACTIVATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1655:2: ( 'oSUSPENDED' )
                    {
                    // InternalSymg.g:1655:2: ( 'oSUSPENDED' )
                    // InternalSymg.g:1656:3: 'oSUSPENDED'
                    {
                     before(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1661:2: ( 'oRESUMED' )
                    {
                    // InternalSymg.g:1661:2: ( 'oRESUMED' )
                    // InternalSymg.g:1662:3: 'oRESUMED'
                    {
                     before(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1667:2: ( 'oDISCHARGED' )
                    {
                    // InternalSymg.g:1667:2: ( 'oDISCHARGED' )
                    // InternalSymg.g:1668:3: 'oDISCHARGED'
                    {
                     before(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1673:2: ( 'oEXPIRED' )
                    {
                    // InternalSymg.g:1673:2: ( 'oEXPIRED' )
                    // InternalSymg.g:1674:3: 'oEXPIRED'
                    {
                     before(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1679:2: ( 'oFULFILLED' )
                    {
                    // InternalSymg.g:1679:2: ( 'oFULFILLED' )
                    // InternalSymg.g:1680:3: 'oFULFILLED'
                    {
                     before(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1685:2: ( 'oVIOLATED' )
                    {
                    // InternalSymg.g:1685:2: ( 'oVIOLATED' )
                    // InternalSymg.g:1686:3: 'oVIOLATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalSymg.g:1691:2: ( 'oTERMINATED' )
                    {
                    // InternalSymg.g:1691:2: ( 'oTERMINATED' )
                    // InternalSymg.g:1692:3: 'oTERMINATED'
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
    // InternalSymg.g:1701:1: rule__OblState__Alternatives : ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oSUCCESSFUL_TERMINATION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) );
    public final void rule__OblState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1705:1: ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oSUCCESSFUL_TERMINATION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) )
            int alt17=8;
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
            case 63:
                {
                alt17=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalSymg.g:1706:2: ( 'oCREATE' )
                    {
                    // InternalSymg.g:1706:2: ( 'oCREATE' )
                    // InternalSymg.g:1707:3: 'oCREATE'
                    {
                     before(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1712:2: ( 'oINEFFECT' )
                    {
                    // InternalSymg.g:1712:2: ( 'oINEFFECT' )
                    // InternalSymg.g:1713:3: 'oINEFFECT'
                    {
                     before(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1718:2: ( 'oSUSPENSION' )
                    {
                    // InternalSymg.g:1718:2: ( 'oSUSPENSION' )
                    // InternalSymg.g:1719:3: 'oSUSPENSION'
                    {
                     before(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1724:2: ( 'oSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1724:2: ( 'oSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1725:3: 'oSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1730:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1730:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1731:3: 'oUNSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1736:2: ( 'oVIOLATION' )
                    {
                    // InternalSymg.g:1736:2: ( 'oVIOLATION' )
                    // InternalSymg.g:1737:3: 'oVIOLATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1742:2: ( 'oFULFILLMENT' )
                    {
                    // InternalSymg.g:1742:2: ( 'oFULFILLMENT' )
                    // InternalSymg.g:1743:3: 'oFULFILLMENT'
                    {
                     before(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1748:2: ( 'oDISCHARGE' )
                    {
                    // InternalSymg.g:1748:2: ( 'oDISCHARGE' )
                    // InternalSymg.g:1749:3: 'oDISCHARGE'
                    {
                     before(grammarAccess.getOblStateAccess().getODISCHARGEKeyword_7()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getODISCHARGEKeyword_7()); 

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
    // InternalSymg.g:1758:1: rule__ContrState__Alternatives : ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) );
    public final void rule__ContrState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1762:1: ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt18=1;
                }
                break;
            case 65:
                {
                alt18=2;
                }
                break;
            case 66:
                {
                alt18=3;
                }
                break;
            case 67:
                {
                alt18=4;
                }
                break;
            case 68:
                {
                alt18=5;
                }
                break;
            case 69:
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
                    // InternalSymg.g:1763:2: ( 'cFORM' )
                    {
                    // InternalSymg.g:1763:2: ( 'cFORM' )
                    // InternalSymg.g:1764:3: 'cFORM'
                    {
                     before(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1769:2: ( 'cINEFFECT' )
                    {
                    // InternalSymg.g:1769:2: ( 'cINEFFECT' )
                    // InternalSymg.g:1770:3: 'cINEFFECT'
                    {
                     before(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1775:2: ( 'cSUSPENSION' )
                    {
                    // InternalSymg.g:1775:2: ( 'cSUSPENSION' )
                    // InternalSymg.g:1776:3: 'cSUSPENSION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1781:2: ( 'cSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1781:2: ( 'cSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1782:3: 'cSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1787:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1787:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    // InternalSymg.g:1788:3: 'cUNSECCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1793:2: ( 'cUNASSIGN' )
                    {
                    // InternalSymg.g:1793:2: ( 'cUNASSIGN' )
                    // InternalSymg.g:1794:3: 'cUNASSIGN'
                    {
                     before(grammarAccess.getContrStateAccess().getCUNASSIGNKeyword_5()); 
                    match(input,69,FOLLOW_2); 
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
    // InternalSymg.g:1803:1: rule__PowState__Alternatives : ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) );
    public final void rule__PowState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1807:1: ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt19=1;
                }
                break;
            case 71:
                {
                alt19=2;
                }
                break;
            case 72:
                {
                alt19=3;
                }
                break;
            case 73:
                {
                alt19=4;
                }
                break;
            case 74:
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
                    // InternalSymg.g:1808:2: ( 'pCREATE' )
                    {
                    // InternalSymg.g:1808:2: ( 'pCREATE' )
                    // InternalSymg.g:1809:3: 'pCREATE'
                    {
                     before(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1814:2: ( 'pINEFFECT' )
                    {
                    // InternalSymg.g:1814:2: ( 'pINEFFECT' )
                    // InternalSymg.g:1815:3: 'pINEFFECT'
                    {
                     before(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1820:2: ( 'pSUSPENSION' )
                    {
                    // InternalSymg.g:1820:2: ( 'pSUSPENSION' )
                    // InternalSymg.g:1821:3: 'pSUSPENSION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1826:2: ( 'pSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1826:2: ( 'pSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1827:3: 'pSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1832:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1832:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1833:3: 'pUNSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getPowStateAccess().getPUNSUCCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,74,FOLLOW_2); 
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
    // InternalSymg.g:1842:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1846:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalSymg.g:1847:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalSymg.g:1854:1: rule__Model__Group__0__Impl : ( 'Domain' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1858:1: ( ( 'Domain' ) )
            // InternalSymg.g:1859:1: ( 'Domain' )
            {
            // InternalSymg.g:1859:1: ( 'Domain' )
            // InternalSymg.g:1860:2: 'Domain'
            {
             before(grammarAccess.getModelAccess().getDomainKeyword_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalSymg.g:1869:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1873:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalSymg.g:1874:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalSymg.g:1881:1: rule__Model__Group__1__Impl : ( ( rule__Model__DomainNameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1885:1: ( ( ( rule__Model__DomainNameAssignment_1 ) ) )
            // InternalSymg.g:1886:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            {
            // InternalSymg.g:1886:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            // InternalSymg.g:1887:2: ( rule__Model__DomainNameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getDomainNameAssignment_1()); 
            // InternalSymg.g:1888:2: ( rule__Model__DomainNameAssignment_1 )
            // InternalSymg.g:1888:3: rule__Model__DomainNameAssignment_1
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
    // InternalSymg.g:1896:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1900:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalSymg.g:1901:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalSymg.g:1908:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1912:1: ( ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) )
            // InternalSymg.g:1913:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            {
            // InternalSymg.g:1913:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            // InternalSymg.g:1914:2: ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* )
            {
            // InternalSymg.g:1914:2: ( ( rule__Model__Group_2__0 ) )
            // InternalSymg.g:1915:3: ( rule__Model__Group_2__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:1916:3: ( rule__Model__Group_2__0 )
            // InternalSymg.g:1916:4: rule__Model__Group_2__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }

            // InternalSymg.g:1919:2: ( ( rule__Model__Group_2__0 )* )
            // InternalSymg.g:1920:3: ( rule__Model__Group_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:1921:3: ( rule__Model__Group_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSymg.g:1921:4: rule__Model__Group_2__0
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
    // InternalSymg.g:1930:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1934:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalSymg.g:1935:2: rule__Model__Group__3__Impl rule__Model__Group__4
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
    // InternalSymg.g:1942:1: rule__Model__Group__3__Impl : ( 'endDomain' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1946:1: ( ( 'endDomain' ) )
            // InternalSymg.g:1947:1: ( 'endDomain' )
            {
            // InternalSymg.g:1947:1: ( 'endDomain' )
            // InternalSymg.g:1948:2: 'endDomain'
            {
             before(grammarAccess.getModelAccess().getEndDomainKeyword_3()); 
            match(input,76,FOLLOW_2); 
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
    // InternalSymg.g:1957:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1961:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalSymg.g:1962:2: rule__Model__Group__4__Impl rule__Model__Group__5
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
    // InternalSymg.g:1969:1: rule__Model__Group__4__Impl : ( 'Contract' ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1973:1: ( ( 'Contract' ) )
            // InternalSymg.g:1974:1: ( 'Contract' )
            {
            // InternalSymg.g:1974:1: ( 'Contract' )
            // InternalSymg.g:1975:2: 'Contract'
            {
             before(grammarAccess.getModelAccess().getContractKeyword_4()); 
            match(input,77,FOLLOW_2); 
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
    // InternalSymg.g:1984:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1988:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // InternalSymg.g:1989:2: rule__Model__Group__5__Impl rule__Model__Group__6
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
    // InternalSymg.g:1996:1: rule__Model__Group__5__Impl : ( ( rule__Model__ContractNameAssignment_5 ) ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2000:1: ( ( ( rule__Model__ContractNameAssignment_5 ) ) )
            // InternalSymg.g:2001:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            {
            // InternalSymg.g:2001:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            // InternalSymg.g:2002:2: ( rule__Model__ContractNameAssignment_5 )
            {
             before(grammarAccess.getModelAccess().getContractNameAssignment_5()); 
            // InternalSymg.g:2003:2: ( rule__Model__ContractNameAssignment_5 )
            // InternalSymg.g:2003:3: rule__Model__ContractNameAssignment_5
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
    // InternalSymg.g:2011:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2015:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // InternalSymg.g:2016:2: rule__Model__Group__6__Impl rule__Model__Group__7
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
    // InternalSymg.g:2023:1: rule__Model__Group__6__Impl : ( '(' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2027:1: ( ( '(' ) )
            // InternalSymg.g:2028:1: ( '(' )
            {
            // InternalSymg.g:2028:1: ( '(' )
            // InternalSymg.g:2029:2: '('
            {
             before(grammarAccess.getModelAccess().getLeftParenthesisKeyword_6()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:2038:1: rule__Model__Group__7 : rule__Model__Group__7__Impl rule__Model__Group__8 ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2042:1: ( rule__Model__Group__7__Impl rule__Model__Group__8 )
            // InternalSymg.g:2043:2: rule__Model__Group__7__Impl rule__Model__Group__8
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
    // InternalSymg.g:2050:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2054:1: ( ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) )
            // InternalSymg.g:2055:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            {
            // InternalSymg.g:2055:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            // InternalSymg.g:2056:2: ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* )
            {
            // InternalSymg.g:2056:2: ( ( rule__Model__Group_7__0 ) )
            // InternalSymg.g:2057:3: ( rule__Model__Group_7__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2058:3: ( rule__Model__Group_7__0 )
            // InternalSymg.g:2058:4: rule__Model__Group_7__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_7__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_7()); 

            }

            // InternalSymg.g:2061:2: ( ( rule__Model__Group_7__0 )* )
            // InternalSymg.g:2062:3: ( rule__Model__Group_7__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2063:3: ( rule__Model__Group_7__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==92) ) {
                        switch ( input.LA(3) ) {
                        case RULE_ID:
                            {
                            int LA21_3 = input.LA(4);

                            if ( (LA21_3==82) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 11:
                            {
                            int LA21_4 = input.LA(4);

                            if ( (LA21_4==82) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 12:
                            {
                            int LA21_5 = input.LA(4);

                            if ( (LA21_5==82) ) {
                                alt21=1;
                            }


                            }
                            break;
                        case 13:
                            {
                            int LA21_6 = input.LA(4);

                            if ( (LA21_6==82) ) {
                                alt21=1;
                            }


                            }
                            break;

                        }

                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalSymg.g:2063:4: rule__Model__Group_7__0
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
    // InternalSymg.g:2072:1: rule__Model__Group__8 : rule__Model__Group__8__Impl rule__Model__Group__9 ;
    public final void rule__Model__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2076:1: ( rule__Model__Group__8__Impl rule__Model__Group__9 )
            // InternalSymg.g:2077:2: rule__Model__Group__8__Impl rule__Model__Group__9
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
    // InternalSymg.g:2084:1: rule__Model__Group__8__Impl : ( ( rule__Model__ParametersAssignment_8 ) ) ;
    public final void rule__Model__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2088:1: ( ( ( rule__Model__ParametersAssignment_8 ) ) )
            // InternalSymg.g:2089:1: ( ( rule__Model__ParametersAssignment_8 ) )
            {
            // InternalSymg.g:2089:1: ( ( rule__Model__ParametersAssignment_8 ) )
            // InternalSymg.g:2090:2: ( rule__Model__ParametersAssignment_8 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_8()); 
            // InternalSymg.g:2091:2: ( rule__Model__ParametersAssignment_8 )
            // InternalSymg.g:2091:3: rule__Model__ParametersAssignment_8
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
    // InternalSymg.g:2099:1: rule__Model__Group__9 : rule__Model__Group__9__Impl rule__Model__Group__10 ;
    public final void rule__Model__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2103:1: ( rule__Model__Group__9__Impl rule__Model__Group__10 )
            // InternalSymg.g:2104:2: rule__Model__Group__9__Impl rule__Model__Group__10
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
    // InternalSymg.g:2111:1: rule__Model__Group__9__Impl : ( ')' ) ;
    public final void rule__Model__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2115:1: ( ( ')' ) )
            // InternalSymg.g:2116:1: ( ')' )
            {
            // InternalSymg.g:2116:1: ( ')' )
            // InternalSymg.g:2117:2: ')'
            {
             before(grammarAccess.getModelAccess().getRightParenthesisKeyword_9()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:2126:1: rule__Model__Group__10 : rule__Model__Group__10__Impl rule__Model__Group__11 ;
    public final void rule__Model__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2130:1: ( rule__Model__Group__10__Impl rule__Model__Group__11 )
            // InternalSymg.g:2131:2: rule__Model__Group__10__Impl rule__Model__Group__11
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
    // InternalSymg.g:2138:1: rule__Model__Group__10__Impl : ( ( rule__Model__Group_10__0 )? ) ;
    public final void rule__Model__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2142:1: ( ( ( rule__Model__Group_10__0 )? ) )
            // InternalSymg.g:2143:1: ( ( rule__Model__Group_10__0 )? )
            {
            // InternalSymg.g:2143:1: ( ( rule__Model__Group_10__0 )? )
            // InternalSymg.g:2144:2: ( rule__Model__Group_10__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_10()); 
            // InternalSymg.g:2145:2: ( rule__Model__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==83) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSymg.g:2145:3: rule__Model__Group_10__0
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
    // InternalSymg.g:2153:1: rule__Model__Group__11 : rule__Model__Group__11__Impl rule__Model__Group__12 ;
    public final void rule__Model__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2157:1: ( rule__Model__Group__11__Impl rule__Model__Group__12 )
            // InternalSymg.g:2158:2: rule__Model__Group__11__Impl rule__Model__Group__12
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
    // InternalSymg.g:2165:1: rule__Model__Group__11__Impl : ( ( rule__Model__Group_11__0 )? ) ;
    public final void rule__Model__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2169:1: ( ( ( rule__Model__Group_11__0 )? ) )
            // InternalSymg.g:2170:1: ( ( rule__Model__Group_11__0 )? )
            {
            // InternalSymg.g:2170:1: ( ( rule__Model__Group_11__0 )? )
            // InternalSymg.g:2171:2: ( rule__Model__Group_11__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_11()); 
            // InternalSymg.g:2172:2: ( rule__Model__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==84) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSymg.g:2172:3: rule__Model__Group_11__0
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
    // InternalSymg.g:2180:1: rule__Model__Group__12 : rule__Model__Group__12__Impl rule__Model__Group__13 ;
    public final void rule__Model__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2184:1: ( rule__Model__Group__12__Impl rule__Model__Group__13 )
            // InternalSymg.g:2185:2: rule__Model__Group__12__Impl rule__Model__Group__13
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
    // InternalSymg.g:2192:1: rule__Model__Group__12__Impl : ( ( rule__Model__Group_12__0 )? ) ;
    public final void rule__Model__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2196:1: ( ( ( rule__Model__Group_12__0 )? ) )
            // InternalSymg.g:2197:1: ( ( rule__Model__Group_12__0 )? )
            {
            // InternalSymg.g:2197:1: ( ( rule__Model__Group_12__0 )? )
            // InternalSymg.g:2198:2: ( rule__Model__Group_12__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_12()); 
            // InternalSymg.g:2199:2: ( rule__Model__Group_12__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==85) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSymg.g:2199:3: rule__Model__Group_12__0
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
    // InternalSymg.g:2207:1: rule__Model__Group__13 : rule__Model__Group__13__Impl rule__Model__Group__14 ;
    public final void rule__Model__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2211:1: ( rule__Model__Group__13__Impl rule__Model__Group__14 )
            // InternalSymg.g:2212:2: rule__Model__Group__13__Impl rule__Model__Group__14
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
    // InternalSymg.g:2219:1: rule__Model__Group__13__Impl : ( ( rule__Model__Group_13__0 )? ) ;
    public final void rule__Model__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2223:1: ( ( ( rule__Model__Group_13__0 )? ) )
            // InternalSymg.g:2224:1: ( ( rule__Model__Group_13__0 )? )
            {
            // InternalSymg.g:2224:1: ( ( rule__Model__Group_13__0 )? )
            // InternalSymg.g:2225:2: ( rule__Model__Group_13__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_13()); 
            // InternalSymg.g:2226:2: ( rule__Model__Group_13__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==86) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSymg.g:2226:3: rule__Model__Group_13__0
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
    // InternalSymg.g:2234:1: rule__Model__Group__14 : rule__Model__Group__14__Impl rule__Model__Group__15 ;
    public final void rule__Model__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2238:1: ( rule__Model__Group__14__Impl rule__Model__Group__15 )
            // InternalSymg.g:2239:2: rule__Model__Group__14__Impl rule__Model__Group__15
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
    // InternalSymg.g:2246:1: rule__Model__Group__14__Impl : ( ( rule__Model__Group_14__0 )? ) ;
    public final void rule__Model__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2250:1: ( ( ( rule__Model__Group_14__0 )? ) )
            // InternalSymg.g:2251:1: ( ( rule__Model__Group_14__0 )? )
            {
            // InternalSymg.g:2251:1: ( ( rule__Model__Group_14__0 )? )
            // InternalSymg.g:2252:2: ( rule__Model__Group_14__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_14()); 
            // InternalSymg.g:2253:2: ( rule__Model__Group_14__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==87) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymg.g:2253:3: rule__Model__Group_14__0
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
    // InternalSymg.g:2261:1: rule__Model__Group__15 : rule__Model__Group__15__Impl rule__Model__Group__16 ;
    public final void rule__Model__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2265:1: ( rule__Model__Group__15__Impl rule__Model__Group__16 )
            // InternalSymg.g:2266:2: rule__Model__Group__15__Impl rule__Model__Group__16
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
    // InternalSymg.g:2273:1: rule__Model__Group__15__Impl : ( ( rule__Model__Group_15__0 )? ) ;
    public final void rule__Model__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2277:1: ( ( ( rule__Model__Group_15__0 )? ) )
            // InternalSymg.g:2278:1: ( ( rule__Model__Group_15__0 )? )
            {
            // InternalSymg.g:2278:1: ( ( rule__Model__Group_15__0 )? )
            // InternalSymg.g:2279:2: ( rule__Model__Group_15__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_15()); 
            // InternalSymg.g:2280:2: ( rule__Model__Group_15__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==88) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSymg.g:2280:3: rule__Model__Group_15__0
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
    // InternalSymg.g:2288:1: rule__Model__Group__16 : rule__Model__Group__16__Impl rule__Model__Group__17 ;
    public final void rule__Model__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2292:1: ( rule__Model__Group__16__Impl rule__Model__Group__17 )
            // InternalSymg.g:2293:2: rule__Model__Group__16__Impl rule__Model__Group__17
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
    // InternalSymg.g:2300:1: rule__Model__Group__16__Impl : ( ( rule__Model__Group_16__0 )? ) ;
    public final void rule__Model__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2304:1: ( ( ( rule__Model__Group_16__0 )? ) )
            // InternalSymg.g:2305:1: ( ( rule__Model__Group_16__0 )? )
            {
            // InternalSymg.g:2305:1: ( ( rule__Model__Group_16__0 )? )
            // InternalSymg.g:2306:2: ( rule__Model__Group_16__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_16()); 
            // InternalSymg.g:2307:2: ( rule__Model__Group_16__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==89) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalSymg.g:2307:3: rule__Model__Group_16__0
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
    // InternalSymg.g:2315:1: rule__Model__Group__17 : rule__Model__Group__17__Impl ;
    public final void rule__Model__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2319:1: ( rule__Model__Group__17__Impl )
            // InternalSymg.g:2320:2: rule__Model__Group__17__Impl
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
    // InternalSymg.g:2326:1: rule__Model__Group__17__Impl : ( 'endContract' ) ;
    public final void rule__Model__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2330:1: ( ( 'endContract' ) )
            // InternalSymg.g:2331:1: ( 'endContract' )
            {
            // InternalSymg.g:2331:1: ( 'endContract' )
            // InternalSymg.g:2332:2: 'endContract'
            {
             before(grammarAccess.getModelAccess().getEndContractKeyword_17()); 
            match(input,80,FOLLOW_2); 
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
    // InternalSymg.g:2342:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2346:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalSymg.g:2347:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalSymg.g:2354:1: rule__Model__Group_2__0__Impl : ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2358:1: ( ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) )
            // InternalSymg.g:2359:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            {
            // InternalSymg.g:2359:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            // InternalSymg.g:2360:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            {
             before(grammarAccess.getModelAccess().getDomainConceptsAssignment_2_0()); 
            // InternalSymg.g:2361:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            // InternalSymg.g:2361:3: rule__Model__DomainConceptsAssignment_2_0
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
    // InternalSymg.g:2369:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2373:1: ( rule__Model__Group_2__1__Impl )
            // InternalSymg.g:2374:2: rule__Model__Group_2__1__Impl
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
    // InternalSymg.g:2380:1: rule__Model__Group_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2384:1: ( ( ';' ) )
            // InternalSymg.g:2385:1: ( ';' )
            {
            // InternalSymg.g:2385:1: ( ';' )
            // InternalSymg.g:2386:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_2_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:2396:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2400:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalSymg.g:2401:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
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
    // InternalSymg.g:2408:1: rule__Model__Group_7__0__Impl : ( ( rule__Model__ParametersAssignment_7_0 ) ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2412:1: ( ( ( rule__Model__ParametersAssignment_7_0 ) ) )
            // InternalSymg.g:2413:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            {
            // InternalSymg.g:2413:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            // InternalSymg.g:2414:2: ( rule__Model__ParametersAssignment_7_0 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_7_0()); 
            // InternalSymg.g:2415:2: ( rule__Model__ParametersAssignment_7_0 )
            // InternalSymg.g:2415:3: rule__Model__ParametersAssignment_7_0
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
    // InternalSymg.g:2423:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2427:1: ( rule__Model__Group_7__1__Impl )
            // InternalSymg.g:2428:2: rule__Model__Group_7__1__Impl
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
    // InternalSymg.g:2434:1: rule__Model__Group_7__1__Impl : ( ',' ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2438:1: ( ( ',' ) )
            // InternalSymg.g:2439:1: ( ',' )
            {
            // InternalSymg.g:2439:1: ( ',' )
            // InternalSymg.g:2440:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_7_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:2450:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2454:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalSymg.g:2455:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
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
    // InternalSymg.g:2462:1: rule__Model__Group_10__0__Impl : ( 'Declarations' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2466:1: ( ( 'Declarations' ) )
            // InternalSymg.g:2467:1: ( 'Declarations' )
            {
            // InternalSymg.g:2467:1: ( 'Declarations' )
            // InternalSymg.g:2468:2: 'Declarations'
            {
             before(grammarAccess.getModelAccess().getDeclarationsKeyword_10_0()); 
            match(input,83,FOLLOW_2); 
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
    // InternalSymg.g:2477:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2481:1: ( rule__Model__Group_10__1__Impl )
            // InternalSymg.g:2482:2: rule__Model__Group_10__1__Impl
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
    // InternalSymg.g:2488:1: rule__Model__Group_10__1__Impl : ( ( rule__Model__Group_10_1__0 )* ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2492:1: ( ( ( rule__Model__Group_10_1__0 )* ) )
            // InternalSymg.g:2493:1: ( ( rule__Model__Group_10_1__0 )* )
            {
            // InternalSymg.g:2493:1: ( ( rule__Model__Group_10_1__0 )* )
            // InternalSymg.g:2494:2: ( rule__Model__Group_10_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_10_1()); 
            // InternalSymg.g:2495:2: ( rule__Model__Group_10_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSymg.g:2495:3: rule__Model__Group_10_1__0
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
    // InternalSymg.g:2504:1: rule__Model__Group_10_1__0 : rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 ;
    public final void rule__Model__Group_10_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2508:1: ( rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 )
            // InternalSymg.g:2509:2: rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1
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
    // InternalSymg.g:2516:1: rule__Model__Group_10_1__0__Impl : ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) ;
    public final void rule__Model__Group_10_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2520:1: ( ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) )
            // InternalSymg.g:2521:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            {
            // InternalSymg.g:2521:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            // InternalSymg.g:2522:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            {
             before(grammarAccess.getModelAccess().getDeclarationsAssignment_10_1_0()); 
            // InternalSymg.g:2523:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            // InternalSymg.g:2523:3: rule__Model__DeclarationsAssignment_10_1_0
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
    // InternalSymg.g:2531:1: rule__Model__Group_10_1__1 : rule__Model__Group_10_1__1__Impl ;
    public final void rule__Model__Group_10_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2535:1: ( rule__Model__Group_10_1__1__Impl )
            // InternalSymg.g:2536:2: rule__Model__Group_10_1__1__Impl
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
    // InternalSymg.g:2542:1: rule__Model__Group_10_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_10_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2546:1: ( ( ';' ) )
            // InternalSymg.g:2547:1: ( ';' )
            {
            // InternalSymg.g:2547:1: ( ';' )
            // InternalSymg.g:2548:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_10_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:2558:1: rule__Model__Group_11__0 : rule__Model__Group_11__0__Impl rule__Model__Group_11__1 ;
    public final void rule__Model__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2562:1: ( rule__Model__Group_11__0__Impl rule__Model__Group_11__1 )
            // InternalSymg.g:2563:2: rule__Model__Group_11__0__Impl rule__Model__Group_11__1
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
    // InternalSymg.g:2570:1: rule__Model__Group_11__0__Impl : ( 'Preconditions' ) ;
    public final void rule__Model__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2574:1: ( ( 'Preconditions' ) )
            // InternalSymg.g:2575:1: ( 'Preconditions' )
            {
            // InternalSymg.g:2575:1: ( 'Preconditions' )
            // InternalSymg.g:2576:2: 'Preconditions'
            {
             before(grammarAccess.getModelAccess().getPreconditionsKeyword_11_0()); 
            match(input,84,FOLLOW_2); 
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
    // InternalSymg.g:2585:1: rule__Model__Group_11__1 : rule__Model__Group_11__1__Impl ;
    public final void rule__Model__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2589:1: ( rule__Model__Group_11__1__Impl )
            // InternalSymg.g:2590:2: rule__Model__Group_11__1__Impl
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
    // InternalSymg.g:2596:1: rule__Model__Group_11__1__Impl : ( ( rule__Model__Group_11_1__0 )* ) ;
    public final void rule__Model__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2600:1: ( ( ( rule__Model__Group_11_1__0 )* ) )
            // InternalSymg.g:2601:1: ( ( rule__Model__Group_11_1__0 )* )
            {
            // InternalSymg.g:2601:1: ( ( rule__Model__Group_11_1__0 )* )
            // InternalSymg.g:2602:2: ( rule__Model__Group_11_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_11_1()); 
            // InternalSymg.g:2603:2: ( rule__Model__Group_11_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_INT)||(LA30_0>=33 && LA30_0<=74)||(LA30_0>=100 && LA30_0<=101)||(LA30_0>=105 && LA30_0<=107)||LA30_0==109) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSymg.g:2603:3: rule__Model__Group_11_1__0
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
    // InternalSymg.g:2612:1: rule__Model__Group_11_1__0 : rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 ;
    public final void rule__Model__Group_11_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2616:1: ( rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 )
            // InternalSymg.g:2617:2: rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1
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
    // InternalSymg.g:2624:1: rule__Model__Group_11_1__0__Impl : ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) ;
    public final void rule__Model__Group_11_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2628:1: ( ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) )
            // InternalSymg.g:2629:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            {
            // InternalSymg.g:2629:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            // InternalSymg.g:2630:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            {
             before(grammarAccess.getModelAccess().getPreconditionsAssignment_11_1_0()); 
            // InternalSymg.g:2631:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            // InternalSymg.g:2631:3: rule__Model__PreconditionsAssignment_11_1_0
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
    // InternalSymg.g:2639:1: rule__Model__Group_11_1__1 : rule__Model__Group_11_1__1__Impl ;
    public final void rule__Model__Group_11_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2643:1: ( rule__Model__Group_11_1__1__Impl )
            // InternalSymg.g:2644:2: rule__Model__Group_11_1__1__Impl
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
    // InternalSymg.g:2650:1: rule__Model__Group_11_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_11_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2654:1: ( ( ';' ) )
            // InternalSymg.g:2655:1: ( ';' )
            {
            // InternalSymg.g:2655:1: ( ';' )
            // InternalSymg.g:2656:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:2666:1: rule__Model__Group_12__0 : rule__Model__Group_12__0__Impl rule__Model__Group_12__1 ;
    public final void rule__Model__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2670:1: ( rule__Model__Group_12__0__Impl rule__Model__Group_12__1 )
            // InternalSymg.g:2671:2: rule__Model__Group_12__0__Impl rule__Model__Group_12__1
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
    // InternalSymg.g:2678:1: rule__Model__Group_12__0__Impl : ( 'Postconditions' ) ;
    public final void rule__Model__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2682:1: ( ( 'Postconditions' ) )
            // InternalSymg.g:2683:1: ( 'Postconditions' )
            {
            // InternalSymg.g:2683:1: ( 'Postconditions' )
            // InternalSymg.g:2684:2: 'Postconditions'
            {
             before(grammarAccess.getModelAccess().getPostconditionsKeyword_12_0()); 
            match(input,85,FOLLOW_2); 
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
    // InternalSymg.g:2693:1: rule__Model__Group_12__1 : rule__Model__Group_12__1__Impl ;
    public final void rule__Model__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2697:1: ( rule__Model__Group_12__1__Impl )
            // InternalSymg.g:2698:2: rule__Model__Group_12__1__Impl
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
    // InternalSymg.g:2704:1: rule__Model__Group_12__1__Impl : ( ( rule__Model__Group_12_1__0 )* ) ;
    public final void rule__Model__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2708:1: ( ( ( rule__Model__Group_12_1__0 )* ) )
            // InternalSymg.g:2709:1: ( ( rule__Model__Group_12_1__0 )* )
            {
            // InternalSymg.g:2709:1: ( ( rule__Model__Group_12_1__0 )* )
            // InternalSymg.g:2710:2: ( rule__Model__Group_12_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_12_1()); 
            // InternalSymg.g:2711:2: ( rule__Model__Group_12_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_INT)||(LA31_0>=33 && LA31_0<=74)||(LA31_0>=100 && LA31_0<=101)||(LA31_0>=105 && LA31_0<=107)||LA31_0==109) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSymg.g:2711:3: rule__Model__Group_12_1__0
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
    // InternalSymg.g:2720:1: rule__Model__Group_12_1__0 : rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 ;
    public final void rule__Model__Group_12_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2724:1: ( rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 )
            // InternalSymg.g:2725:2: rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1
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
    // InternalSymg.g:2732:1: rule__Model__Group_12_1__0__Impl : ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) ;
    public final void rule__Model__Group_12_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2736:1: ( ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) )
            // InternalSymg.g:2737:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            {
            // InternalSymg.g:2737:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            // InternalSymg.g:2738:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            {
             before(grammarAccess.getModelAccess().getPostconditionsAssignment_12_1_0()); 
            // InternalSymg.g:2739:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            // InternalSymg.g:2739:3: rule__Model__PostconditionsAssignment_12_1_0
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
    // InternalSymg.g:2747:1: rule__Model__Group_12_1__1 : rule__Model__Group_12_1__1__Impl ;
    public final void rule__Model__Group_12_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2751:1: ( rule__Model__Group_12_1__1__Impl )
            // InternalSymg.g:2752:2: rule__Model__Group_12_1__1__Impl
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
    // InternalSymg.g:2758:1: rule__Model__Group_12_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_12_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2762:1: ( ( ';' ) )
            // InternalSymg.g:2763:1: ( ';' )
            {
            // InternalSymg.g:2763:1: ( ';' )
            // InternalSymg.g:2764:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:2774:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2778:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalSymg.g:2779:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
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
    // InternalSymg.g:2786:1: rule__Model__Group_13__0__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2790:1: ( ( 'Obligations' ) )
            // InternalSymg.g:2791:1: ( 'Obligations' )
            {
            // InternalSymg.g:2791:1: ( 'Obligations' )
            // InternalSymg.g:2792:2: 'Obligations'
            {
             before(grammarAccess.getModelAccess().getObligationsKeyword_13_0()); 
            match(input,86,FOLLOW_2); 
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
    // InternalSymg.g:2801:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2805:1: ( rule__Model__Group_13__1__Impl )
            // InternalSymg.g:2806:2: rule__Model__Group_13__1__Impl
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
    // InternalSymg.g:2812:1: rule__Model__Group_13__1__Impl : ( ( rule__Model__Group_13_1__0 )* ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2816:1: ( ( ( rule__Model__Group_13_1__0 )* ) )
            // InternalSymg.g:2817:1: ( ( rule__Model__Group_13_1__0 )* )
            {
            // InternalSymg.g:2817:1: ( ( rule__Model__Group_13_1__0 )* )
            // InternalSymg.g:2818:2: ( rule__Model__Group_13_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_13_1()); 
            // InternalSymg.g:2819:2: ( rule__Model__Group_13_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSymg.g:2819:3: rule__Model__Group_13_1__0
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
    // InternalSymg.g:2828:1: rule__Model__Group_13_1__0 : rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 ;
    public final void rule__Model__Group_13_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2832:1: ( rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 )
            // InternalSymg.g:2833:2: rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1
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
    // InternalSymg.g:2840:1: rule__Model__Group_13_1__0__Impl : ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) ;
    public final void rule__Model__Group_13_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2844:1: ( ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) )
            // InternalSymg.g:2845:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            {
            // InternalSymg.g:2845:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            // InternalSymg.g:2846:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            {
             before(grammarAccess.getModelAccess().getObligationsAssignment_13_1_0()); 
            // InternalSymg.g:2847:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            // InternalSymg.g:2847:3: rule__Model__ObligationsAssignment_13_1_0
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
    // InternalSymg.g:2855:1: rule__Model__Group_13_1__1 : rule__Model__Group_13_1__1__Impl ;
    public final void rule__Model__Group_13_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2859:1: ( rule__Model__Group_13_1__1__Impl )
            // InternalSymg.g:2860:2: rule__Model__Group_13_1__1__Impl
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
    // InternalSymg.g:2866:1: rule__Model__Group_13_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_13_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2870:1: ( ( ';' ) )
            // InternalSymg.g:2871:1: ( ';' )
            {
            // InternalSymg.g:2871:1: ( ';' )
            // InternalSymg.g:2872:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:2882:1: rule__Model__Group_14__0 : rule__Model__Group_14__0__Impl rule__Model__Group_14__1 ;
    public final void rule__Model__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2886:1: ( rule__Model__Group_14__0__Impl rule__Model__Group_14__1 )
            // InternalSymg.g:2887:2: rule__Model__Group_14__0__Impl rule__Model__Group_14__1
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
    // InternalSymg.g:2894:1: rule__Model__Group_14__0__Impl : ( 'Surviving' ) ;
    public final void rule__Model__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2898:1: ( ( 'Surviving' ) )
            // InternalSymg.g:2899:1: ( 'Surviving' )
            {
            // InternalSymg.g:2899:1: ( 'Surviving' )
            // InternalSymg.g:2900:2: 'Surviving'
            {
             before(grammarAccess.getModelAccess().getSurvivingKeyword_14_0()); 
            match(input,87,FOLLOW_2); 
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
    // InternalSymg.g:2909:1: rule__Model__Group_14__1 : rule__Model__Group_14__1__Impl rule__Model__Group_14__2 ;
    public final void rule__Model__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2913:1: ( rule__Model__Group_14__1__Impl rule__Model__Group_14__2 )
            // InternalSymg.g:2914:2: rule__Model__Group_14__1__Impl rule__Model__Group_14__2
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
    // InternalSymg.g:2921:1: rule__Model__Group_14__1__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2925:1: ( ( 'Obligations' ) )
            // InternalSymg.g:2926:1: ( 'Obligations' )
            {
            // InternalSymg.g:2926:1: ( 'Obligations' )
            // InternalSymg.g:2927:2: 'Obligations'
            {
             before(grammarAccess.getModelAccess().getObligationsKeyword_14_1()); 
            match(input,86,FOLLOW_2); 
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
    // InternalSymg.g:2936:1: rule__Model__Group_14__2 : rule__Model__Group_14__2__Impl ;
    public final void rule__Model__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2940:1: ( rule__Model__Group_14__2__Impl )
            // InternalSymg.g:2941:2: rule__Model__Group_14__2__Impl
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
    // InternalSymg.g:2947:1: rule__Model__Group_14__2__Impl : ( ( rule__Model__Group_14_2__0 )* ) ;
    public final void rule__Model__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2951:1: ( ( ( rule__Model__Group_14_2__0 )* ) )
            // InternalSymg.g:2952:1: ( ( rule__Model__Group_14_2__0 )* )
            {
            // InternalSymg.g:2952:1: ( ( rule__Model__Group_14_2__0 )* )
            // InternalSymg.g:2953:2: ( rule__Model__Group_14_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_14_2()); 
            // InternalSymg.g:2954:2: ( rule__Model__Group_14_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSymg.g:2954:3: rule__Model__Group_14_2__0
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
    // InternalSymg.g:2963:1: rule__Model__Group_14_2__0 : rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 ;
    public final void rule__Model__Group_14_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2967:1: ( rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 )
            // InternalSymg.g:2968:2: rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1
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
    // InternalSymg.g:2975:1: rule__Model__Group_14_2__0__Impl : ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) ;
    public final void rule__Model__Group_14_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2979:1: ( ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) )
            // InternalSymg.g:2980:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            {
            // InternalSymg.g:2980:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            // InternalSymg.g:2981:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            {
             before(grammarAccess.getModelAccess().getSobligationsAssignment_14_2_0()); 
            // InternalSymg.g:2982:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            // InternalSymg.g:2982:3: rule__Model__SobligationsAssignment_14_2_0
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
    // InternalSymg.g:2990:1: rule__Model__Group_14_2__1 : rule__Model__Group_14_2__1__Impl ;
    public final void rule__Model__Group_14_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2994:1: ( rule__Model__Group_14_2__1__Impl )
            // InternalSymg.g:2995:2: rule__Model__Group_14_2__1__Impl
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
    // InternalSymg.g:3001:1: rule__Model__Group_14_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_14_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3005:1: ( ( ';' ) )
            // InternalSymg.g:3006:1: ( ';' )
            {
            // InternalSymg.g:3006:1: ( ';' )
            // InternalSymg.g:3007:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_14_2_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:3017:1: rule__Model__Group_15__0 : rule__Model__Group_15__0__Impl rule__Model__Group_15__1 ;
    public final void rule__Model__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3021:1: ( rule__Model__Group_15__0__Impl rule__Model__Group_15__1 )
            // InternalSymg.g:3022:2: rule__Model__Group_15__0__Impl rule__Model__Group_15__1
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
    // InternalSymg.g:3029:1: rule__Model__Group_15__0__Impl : ( 'Powers' ) ;
    public final void rule__Model__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3033:1: ( ( 'Powers' ) )
            // InternalSymg.g:3034:1: ( 'Powers' )
            {
            // InternalSymg.g:3034:1: ( 'Powers' )
            // InternalSymg.g:3035:2: 'Powers'
            {
             before(grammarAccess.getModelAccess().getPowersKeyword_15_0()); 
            match(input,88,FOLLOW_2); 
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
    // InternalSymg.g:3044:1: rule__Model__Group_15__1 : rule__Model__Group_15__1__Impl ;
    public final void rule__Model__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3048:1: ( rule__Model__Group_15__1__Impl )
            // InternalSymg.g:3049:2: rule__Model__Group_15__1__Impl
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
    // InternalSymg.g:3055:1: rule__Model__Group_15__1__Impl : ( ( rule__Model__Group_15_1__0 )* ) ;
    public final void rule__Model__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3059:1: ( ( ( rule__Model__Group_15_1__0 )* ) )
            // InternalSymg.g:3060:1: ( ( rule__Model__Group_15_1__0 )* )
            {
            // InternalSymg.g:3060:1: ( ( rule__Model__Group_15_1__0 )* )
            // InternalSymg.g:3061:2: ( rule__Model__Group_15_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_15_1()); 
            // InternalSymg.g:3062:2: ( rule__Model__Group_15_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSymg.g:3062:3: rule__Model__Group_15_1__0
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
    // InternalSymg.g:3071:1: rule__Model__Group_15_1__0 : rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 ;
    public final void rule__Model__Group_15_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3075:1: ( rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 )
            // InternalSymg.g:3076:2: rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1
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
    // InternalSymg.g:3083:1: rule__Model__Group_15_1__0__Impl : ( ( rule__Model__PowersAssignment_15_1_0 ) ) ;
    public final void rule__Model__Group_15_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3087:1: ( ( ( rule__Model__PowersAssignment_15_1_0 ) ) )
            // InternalSymg.g:3088:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            {
            // InternalSymg.g:3088:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            // InternalSymg.g:3089:2: ( rule__Model__PowersAssignment_15_1_0 )
            {
             before(grammarAccess.getModelAccess().getPowersAssignment_15_1_0()); 
            // InternalSymg.g:3090:2: ( rule__Model__PowersAssignment_15_1_0 )
            // InternalSymg.g:3090:3: rule__Model__PowersAssignment_15_1_0
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
    // InternalSymg.g:3098:1: rule__Model__Group_15_1__1 : rule__Model__Group_15_1__1__Impl ;
    public final void rule__Model__Group_15_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3102:1: ( rule__Model__Group_15_1__1__Impl )
            // InternalSymg.g:3103:2: rule__Model__Group_15_1__1__Impl
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
    // InternalSymg.g:3109:1: rule__Model__Group_15_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_15_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3113:1: ( ( ';' ) )
            // InternalSymg.g:3114:1: ( ';' )
            {
            // InternalSymg.g:3114:1: ( ';' )
            // InternalSymg.g:3115:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_15_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:3125:1: rule__Model__Group_16__0 : rule__Model__Group_16__0__Impl rule__Model__Group_16__1 ;
    public final void rule__Model__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3129:1: ( rule__Model__Group_16__0__Impl rule__Model__Group_16__1 )
            // InternalSymg.g:3130:2: rule__Model__Group_16__0__Impl rule__Model__Group_16__1
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
    // InternalSymg.g:3137:1: rule__Model__Group_16__0__Impl : ( 'Constraints' ) ;
    public final void rule__Model__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3141:1: ( ( 'Constraints' ) )
            // InternalSymg.g:3142:1: ( 'Constraints' )
            {
            // InternalSymg.g:3142:1: ( 'Constraints' )
            // InternalSymg.g:3143:2: 'Constraints'
            {
             before(grammarAccess.getModelAccess().getConstraintsKeyword_16_0()); 
            match(input,89,FOLLOW_2); 
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
    // InternalSymg.g:3152:1: rule__Model__Group_16__1 : rule__Model__Group_16__1__Impl ;
    public final void rule__Model__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3156:1: ( rule__Model__Group_16__1__Impl )
            // InternalSymg.g:3157:2: rule__Model__Group_16__1__Impl
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
    // InternalSymg.g:3163:1: rule__Model__Group_16__1__Impl : ( ( rule__Model__Group_16_1__0 )* ) ;
    public final void rule__Model__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3167:1: ( ( ( rule__Model__Group_16_1__0 )* ) )
            // InternalSymg.g:3168:1: ( ( rule__Model__Group_16_1__0 )* )
            {
            // InternalSymg.g:3168:1: ( ( rule__Model__Group_16_1__0 )* )
            // InternalSymg.g:3169:2: ( rule__Model__Group_16_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_16_1()); 
            // InternalSymg.g:3170:2: ( rule__Model__Group_16_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_INT)||(LA35_0>=33 && LA35_0<=74)||(LA35_0>=100 && LA35_0<=101)||(LA35_0>=105 && LA35_0<=107)||LA35_0==109) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSymg.g:3170:3: rule__Model__Group_16_1__0
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
    // InternalSymg.g:3179:1: rule__Model__Group_16_1__0 : rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 ;
    public final void rule__Model__Group_16_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3183:1: ( rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 )
            // InternalSymg.g:3184:2: rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1
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
    // InternalSymg.g:3191:1: rule__Model__Group_16_1__0__Impl : ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) ;
    public final void rule__Model__Group_16_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3195:1: ( ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) )
            // InternalSymg.g:3196:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            {
            // InternalSymg.g:3196:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            // InternalSymg.g:3197:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            {
             before(grammarAccess.getModelAccess().getConstraintsAssignment_16_1_0()); 
            // InternalSymg.g:3198:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            // InternalSymg.g:3198:3: rule__Model__ConstraintsAssignment_16_1_0
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
    // InternalSymg.g:3206:1: rule__Model__Group_16_1__1 : rule__Model__Group_16_1__1__Impl ;
    public final void rule__Model__Group_16_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3210:1: ( rule__Model__Group_16_1__1__Impl )
            // InternalSymg.g:3211:2: rule__Model__Group_16_1__1__Impl
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
    // InternalSymg.g:3217:1: rule__Model__Group_16_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_16_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3221:1: ( ( ';' ) )
            // InternalSymg.g:3222:1: ( ';' )
            {
            // InternalSymg.g:3222:1: ( ';' )
            // InternalSymg.g:3223:2: ';'
            {
             before(grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1()); 
            match(input,81,FOLLOW_2); 
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
    // InternalSymg.g:3233:1: rule__Regular__Group__0 : rule__Regular__Group__0__Impl rule__Regular__Group__1 ;
    public final void rule__Regular__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3237:1: ( rule__Regular__Group__0__Impl rule__Regular__Group__1 )
            // InternalSymg.g:3238:2: rule__Regular__Group__0__Impl rule__Regular__Group__1
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
    // InternalSymg.g:3245:1: rule__Regular__Group__0__Impl : ( ( rule__Regular__NameAssignment_0 ) ) ;
    public final void rule__Regular__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3249:1: ( ( ( rule__Regular__NameAssignment_0 ) ) )
            // InternalSymg.g:3250:1: ( ( rule__Regular__NameAssignment_0 ) )
            {
            // InternalSymg.g:3250:1: ( ( rule__Regular__NameAssignment_0 ) )
            // InternalSymg.g:3251:2: ( rule__Regular__NameAssignment_0 )
            {
             before(grammarAccess.getRegularAccess().getNameAssignment_0()); 
            // InternalSymg.g:3252:2: ( rule__Regular__NameAssignment_0 )
            // InternalSymg.g:3252:3: rule__Regular__NameAssignment_0
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
    // InternalSymg.g:3260:1: rule__Regular__Group__1 : rule__Regular__Group__1__Impl rule__Regular__Group__2 ;
    public final void rule__Regular__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3264:1: ( rule__Regular__Group__1__Impl rule__Regular__Group__2 )
            // InternalSymg.g:3265:2: rule__Regular__Group__1__Impl rule__Regular__Group__2
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
    // InternalSymg.g:3272:1: rule__Regular__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Regular__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3276:1: ( ( 'isA' ) )
            // InternalSymg.g:3277:1: ( 'isA' )
            {
            // InternalSymg.g:3277:1: ( 'isA' )
            // InternalSymg.g:3278:2: 'isA'
            {
             before(grammarAccess.getRegularAccess().getIsAKeyword_1()); 
            match(input,90,FOLLOW_2); 
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
    // InternalSymg.g:3287:1: rule__Regular__Group__2 : rule__Regular__Group__2__Impl rule__Regular__Group__3 ;
    public final void rule__Regular__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3291:1: ( rule__Regular__Group__2__Impl rule__Regular__Group__3 )
            // InternalSymg.g:3292:2: rule__Regular__Group__2__Impl rule__Regular__Group__3
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
    // InternalSymg.g:3299:1: rule__Regular__Group__2__Impl : ( ( rule__Regular__ConceptTypeAssignment_2 ) ) ;
    public final void rule__Regular__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3303:1: ( ( ( rule__Regular__ConceptTypeAssignment_2 ) ) )
            // InternalSymg.g:3304:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            {
            // InternalSymg.g:3304:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            // InternalSymg.g:3305:2: ( rule__Regular__ConceptTypeAssignment_2 )
            {
             before(grammarAccess.getRegularAccess().getConceptTypeAssignment_2()); 
            // InternalSymg.g:3306:2: ( rule__Regular__ConceptTypeAssignment_2 )
            // InternalSymg.g:3306:3: rule__Regular__ConceptTypeAssignment_2
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
    // InternalSymg.g:3314:1: rule__Regular__Group__3 : rule__Regular__Group__3__Impl ;
    public final void rule__Regular__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3318:1: ( rule__Regular__Group__3__Impl )
            // InternalSymg.g:3319:2: rule__Regular__Group__3__Impl
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
    // InternalSymg.g:3325:1: rule__Regular__Group__3__Impl : ( ( rule__Regular__Group_3__0 )? ) ;
    public final void rule__Regular__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3329:1: ( ( ( rule__Regular__Group_3__0 )? ) )
            // InternalSymg.g:3330:1: ( ( rule__Regular__Group_3__0 )? )
            {
            // InternalSymg.g:3330:1: ( ( rule__Regular__Group_3__0 )? )
            // InternalSymg.g:3331:2: ( rule__Regular__Group_3__0 )?
            {
             before(grammarAccess.getRegularAccess().getGroup_3()); 
            // InternalSymg.g:3332:2: ( rule__Regular__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==91) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalSymg.g:3332:3: rule__Regular__Group_3__0
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
    // InternalSymg.g:3341:1: rule__Regular__Group_3__0 : rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 ;
    public final void rule__Regular__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3345:1: ( rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 )
            // InternalSymg.g:3346:2: rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1
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
    // InternalSymg.g:3353:1: rule__Regular__Group_3__0__Impl : ( 'with' ) ;
    public final void rule__Regular__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3357:1: ( ( 'with' ) )
            // InternalSymg.g:3358:1: ( 'with' )
            {
            // InternalSymg.g:3358:1: ( 'with' )
            // InternalSymg.g:3359:2: 'with'
            {
             before(grammarAccess.getRegularAccess().getWithKeyword_3_0()); 
            match(input,91,FOLLOW_2); 
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
    // InternalSymg.g:3368:1: rule__Regular__Group_3__1 : rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 ;
    public final void rule__Regular__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3372:1: ( rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 )
            // InternalSymg.g:3373:2: rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2
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
    // InternalSymg.g:3380:1: rule__Regular__Group_3__1__Impl : ( ( rule__Regular__Group_3_1__0 )* ) ;
    public final void rule__Regular__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3384:1: ( ( ( rule__Regular__Group_3_1__0 )* ) )
            // InternalSymg.g:3385:1: ( ( rule__Regular__Group_3_1__0 )* )
            {
            // InternalSymg.g:3385:1: ( ( rule__Regular__Group_3_1__0 )* )
            // InternalSymg.g:3386:2: ( rule__Regular__Group_3_1__0 )*
            {
             before(grammarAccess.getRegularAccess().getGroup_3_1()); 
            // InternalSymg.g:3387:2: ( rule__Regular__Group_3_1__0 )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // InternalSymg.g:3387:3: rule__Regular__Group_3_1__0
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
    // InternalSymg.g:3395:1: rule__Regular__Group_3__2 : rule__Regular__Group_3__2__Impl ;
    public final void rule__Regular__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3399:1: ( rule__Regular__Group_3__2__Impl )
            // InternalSymg.g:3400:2: rule__Regular__Group_3__2__Impl
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
    // InternalSymg.g:3406:1: rule__Regular__Group_3__2__Impl : ( ( rule__Regular__AttributesAssignment_3_2 ) ) ;
    public final void rule__Regular__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3410:1: ( ( ( rule__Regular__AttributesAssignment_3_2 ) ) )
            // InternalSymg.g:3411:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            {
            // InternalSymg.g:3411:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            // InternalSymg.g:3412:2: ( rule__Regular__AttributesAssignment_3_2 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_2()); 
            // InternalSymg.g:3413:2: ( rule__Regular__AttributesAssignment_3_2 )
            // InternalSymg.g:3413:3: rule__Regular__AttributesAssignment_3_2
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
    // InternalSymg.g:3422:1: rule__Regular__Group_3_1__0 : rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 ;
    public final void rule__Regular__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3426:1: ( rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 )
            // InternalSymg.g:3427:2: rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1
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
    // InternalSymg.g:3434:1: rule__Regular__Group_3_1__0__Impl : ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) ;
    public final void rule__Regular__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3438:1: ( ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) )
            // InternalSymg.g:3439:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            {
            // InternalSymg.g:3439:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            // InternalSymg.g:3440:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_1_0()); 
            // InternalSymg.g:3441:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            // InternalSymg.g:3441:3: rule__Regular__AttributesAssignment_3_1_0
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
    // InternalSymg.g:3449:1: rule__Regular__Group_3_1__1 : rule__Regular__Group_3_1__1__Impl ;
    public final void rule__Regular__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3453:1: ( rule__Regular__Group_3_1__1__Impl )
            // InternalSymg.g:3454:2: rule__Regular__Group_3_1__1__Impl
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
    // InternalSymg.g:3460:1: rule__Regular__Group_3_1__1__Impl : ( ',' ) ;
    public final void rule__Regular__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3464:1: ( ( ',' ) )
            // InternalSymg.g:3465:1: ( ',' )
            {
            // InternalSymg.g:3465:1: ( ',' )
            // InternalSymg.g:3466:2: ','
            {
             before(grammarAccess.getRegularAccess().getCommaKeyword_3_1_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:3476:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3480:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalSymg.g:3481:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalSymg.g:3488:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3492:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalSymg.g:3493:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalSymg.g:3493:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalSymg.g:3494:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalSymg.g:3495:2: ( rule__Attribute__NameAssignment_0 )
            // InternalSymg.g:3495:3: rule__Attribute__NameAssignment_0
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
    // InternalSymg.g:3503:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3507:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalSymg.g:3508:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalSymg.g:3515:1: rule__Attribute__Group__1__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3519:1: ( ( ':' ) )
            // InternalSymg.g:3520:1: ( ':' )
            {
            // InternalSymg.g:3520:1: ( ':' )
            // InternalSymg.g:3521:2: ':'
            {
             before(grammarAccess.getAttributeAccess().getColonKeyword_1()); 
            match(input,92,FOLLOW_2); 
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
    // InternalSymg.g:3530:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3534:1: ( rule__Attribute__Group__2__Impl )
            // InternalSymg.g:3535:2: rule__Attribute__Group__2__Impl
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
    // InternalSymg.g:3541:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3545:1: ( ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) )
            // InternalSymg.g:3546:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            {
            // InternalSymg.g:3546:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            // InternalSymg.g:3547:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_2()); 
            // InternalSymg.g:3548:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            // InternalSymg.g:3548:3: rule__Attribute__AttributeTypeAssignment_2
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
    // InternalSymg.g:3557:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3561:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalSymg.g:3562:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
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
    // InternalSymg.g:3569:1: rule__Enumeration__Group__0__Impl : ( ( rule__Enumeration__NameAssignment_0 ) ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3573:1: ( ( ( rule__Enumeration__NameAssignment_0 ) ) )
            // InternalSymg.g:3574:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            {
            // InternalSymg.g:3574:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            // InternalSymg.g:3575:2: ( rule__Enumeration__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_0()); 
            // InternalSymg.g:3576:2: ( rule__Enumeration__NameAssignment_0 )
            // InternalSymg.g:3576:3: rule__Enumeration__NameAssignment_0
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
    // InternalSymg.g:3584:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3588:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalSymg.g:3589:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
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
    // InternalSymg.g:3596:1: rule__Enumeration__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3600:1: ( ( 'isA' ) )
            // InternalSymg.g:3601:1: ( 'isA' )
            {
            // InternalSymg.g:3601:1: ( 'isA' )
            // InternalSymg.g:3602:2: 'isA'
            {
             before(grammarAccess.getEnumerationAccess().getIsAKeyword_1()); 
            match(input,90,FOLLOW_2); 
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
    // InternalSymg.g:3611:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3615:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalSymg.g:3616:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
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
    // InternalSymg.g:3623:1: rule__Enumeration__Group__2__Impl : ( 'Enumeration' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3627:1: ( ( 'Enumeration' ) )
            // InternalSymg.g:3628:1: ( 'Enumeration' )
            {
            // InternalSymg.g:3628:1: ( 'Enumeration' )
            // InternalSymg.g:3629:2: 'Enumeration'
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationKeyword_2()); 
            match(input,93,FOLLOW_2); 
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
    // InternalSymg.g:3638:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3642:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalSymg.g:3643:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
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
    // InternalSymg.g:3650:1: rule__Enumeration__Group__3__Impl : ( '(' ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3654:1: ( ( '(' ) )
            // InternalSymg.g:3655:1: ( '(' )
            {
            // InternalSymg.g:3655:1: ( '(' )
            // InternalSymg.g:3656:2: '('
            {
             before(grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:3665:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3669:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalSymg.g:3670:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
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
    // InternalSymg.g:3677:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3681:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalSymg.g:3682:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalSymg.g:3682:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalSymg.g:3683:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalSymg.g:3684:2: ( rule__Enumeration__Group_4__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    int LA38_1 = input.LA(2);

                    if ( (LA38_1==82) ) {
                        alt38=1;
                    }


                }


                switch (alt38) {
            	case 1 :
            	    // InternalSymg.g:3684:3: rule__Enumeration__Group_4__0
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
    // InternalSymg.g:3692:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3696:1: ( rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 )
            // InternalSymg.g:3697:2: rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6
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
    // InternalSymg.g:3704:1: rule__Enumeration__Group__5__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3708:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) )
            // InternalSymg.g:3709:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            {
            // InternalSymg.g:3709:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            // InternalSymg.g:3710:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_5()); 
            // InternalSymg.g:3711:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            // InternalSymg.g:3711:3: rule__Enumeration__EnumerationItemsAssignment_5
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
    // InternalSymg.g:3719:1: rule__Enumeration__Group__6 : rule__Enumeration__Group__6__Impl ;
    public final void rule__Enumeration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3723:1: ( rule__Enumeration__Group__6__Impl )
            // InternalSymg.g:3724:2: rule__Enumeration__Group__6__Impl
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
    // InternalSymg.g:3730:1: rule__Enumeration__Group__6__Impl : ( ')' ) ;
    public final void rule__Enumeration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3734:1: ( ( ')' ) )
            // InternalSymg.g:3735:1: ( ')' )
            {
            // InternalSymg.g:3735:1: ( ')' )
            // InternalSymg.g:3736:2: ')'
            {
             before(grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:3746:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3750:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalSymg.g:3751:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
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
    // InternalSymg.g:3758:1: rule__Enumeration__Group_4__0__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3762:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) )
            // InternalSymg.g:3763:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            {
            // InternalSymg.g:3763:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            // InternalSymg.g:3764:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_4_0()); 
            // InternalSymg.g:3765:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            // InternalSymg.g:3765:3: rule__Enumeration__EnumerationItemsAssignment_4_0
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
    // InternalSymg.g:3773:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3777:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalSymg.g:3778:2: rule__Enumeration__Group_4__1__Impl
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
    // InternalSymg.g:3784:1: rule__Enumeration__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3788:1: ( ( ',' ) )
            // InternalSymg.g:3789:1: ( ',' )
            {
            // InternalSymg.g:3789:1: ( ',' )
            // InternalSymg.g:3790:2: ','
            {
             before(grammarAccess.getEnumerationAccess().getCommaKeyword_4_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:3800:1: rule__EnumItem__Group__0 : rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 ;
    public final void rule__EnumItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3804:1: ( rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 )
            // InternalSymg.g:3805:2: rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1
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
    // InternalSymg.g:3812:1: rule__EnumItem__Group__0__Impl : ( () ) ;
    public final void rule__EnumItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3816:1: ( ( () ) )
            // InternalSymg.g:3817:1: ( () )
            {
            // InternalSymg.g:3817:1: ( () )
            // InternalSymg.g:3818:2: ()
            {
             before(grammarAccess.getEnumItemAccess().getEnumItemAction_0()); 
            // InternalSymg.g:3819:2: ()
            // InternalSymg.g:3819:3: 
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
    // InternalSymg.g:3827:1: rule__EnumItem__Group__1 : rule__EnumItem__Group__1__Impl ;
    public final void rule__EnumItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3831:1: ( rule__EnumItem__Group__1__Impl )
            // InternalSymg.g:3832:2: rule__EnumItem__Group__1__Impl
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
    // InternalSymg.g:3838:1: rule__EnumItem__Group__1__Impl : ( ( rule__EnumItem__NameAssignment_1 ) ) ;
    public final void rule__EnumItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3842:1: ( ( ( rule__EnumItem__NameAssignment_1 ) ) )
            // InternalSymg.g:3843:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            {
            // InternalSymg.g:3843:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            // InternalSymg.g:3844:2: ( rule__EnumItem__NameAssignment_1 )
            {
             before(grammarAccess.getEnumItemAccess().getNameAssignment_1()); 
            // InternalSymg.g:3845:2: ( rule__EnumItem__NameAssignment_1 )
            // InternalSymg.g:3845:3: rule__EnumItem__NameAssignment_1
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
    // InternalSymg.g:3854:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3858:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalSymg.g:3859:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalSymg.g:3866:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3870:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalSymg.g:3871:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalSymg.g:3871:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalSymg.g:3872:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalSymg.g:3873:2: ( rule__Parameter__NameAssignment_0 )
            // InternalSymg.g:3873:3: rule__Parameter__NameAssignment_0
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
    // InternalSymg.g:3881:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3885:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalSymg.g:3886:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
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
    // InternalSymg.g:3893:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3897:1: ( ( ':' ) )
            // InternalSymg.g:3898:1: ( ':' )
            {
            // InternalSymg.g:3898:1: ( ':' )
            // InternalSymg.g:3899:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,92,FOLLOW_2); 
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
    // InternalSymg.g:3908:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3912:1: ( rule__Parameter__Group__2__Impl )
            // InternalSymg.g:3913:2: rule__Parameter__Group__2__Impl
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
    // InternalSymg.g:3919:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__TypeAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3923:1: ( ( ( rule__Parameter__TypeAssignment_2 ) ) )
            // InternalSymg.g:3924:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            {
            // InternalSymg.g:3924:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            // InternalSymg.g:3925:2: ( rule__Parameter__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_2()); 
            // InternalSymg.g:3926:2: ( rule__Parameter__TypeAssignment_2 )
            // InternalSymg.g:3926:3: rule__Parameter__TypeAssignment_2
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
    // InternalSymg.g:3935:1: rule__DeclarPair__Group__0 : rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 ;
    public final void rule__DeclarPair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3939:1: ( rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 )
            // InternalSymg.g:3940:2: rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1
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
    // InternalSymg.g:3947:1: rule__DeclarPair__Group__0__Impl : ( ( rule__DeclarPair__AttrAssignment_0 ) ) ;
    public final void rule__DeclarPair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3951:1: ( ( ( rule__DeclarPair__AttrAssignment_0 ) ) )
            // InternalSymg.g:3952:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            {
            // InternalSymg.g:3952:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            // InternalSymg.g:3953:2: ( rule__DeclarPair__AttrAssignment_0 )
            {
             before(grammarAccess.getDeclarPairAccess().getAttrAssignment_0()); 
            // InternalSymg.g:3954:2: ( rule__DeclarPair__AttrAssignment_0 )
            // InternalSymg.g:3954:3: rule__DeclarPair__AttrAssignment_0
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
    // InternalSymg.g:3962:1: rule__DeclarPair__Group__1 : rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 ;
    public final void rule__DeclarPair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3966:1: ( rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 )
            // InternalSymg.g:3967:2: rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2
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
    // InternalSymg.g:3974:1: rule__DeclarPair__Group__1__Impl : ( ':=' ) ;
    public final void rule__DeclarPair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3978:1: ( ( ':=' ) )
            // InternalSymg.g:3979:1: ( ':=' )
            {
            // InternalSymg.g:3979:1: ( ':=' )
            // InternalSymg.g:3980:2: ':='
            {
             before(grammarAccess.getDeclarPairAccess().getColonEqualsSignKeyword_1()); 
            match(input,94,FOLLOW_2); 
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
    // InternalSymg.g:3989:1: rule__DeclarPair__Group__2 : rule__DeclarPair__Group__2__Impl ;
    public final void rule__DeclarPair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3993:1: ( rule__DeclarPair__Group__2__Impl )
            // InternalSymg.g:3994:2: rule__DeclarPair__Group__2__Impl
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
    // InternalSymg.g:4000:1: rule__DeclarPair__Group__2__Impl : ( ( rule__DeclarPair__ParamAssignment_2 ) ) ;
    public final void rule__DeclarPair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4004:1: ( ( ( rule__DeclarPair__ParamAssignment_2 ) ) )
            // InternalSymg.g:4005:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            {
            // InternalSymg.g:4005:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            // InternalSymg.g:4006:2: ( rule__DeclarPair__ParamAssignment_2 )
            {
             before(grammarAccess.getDeclarPairAccess().getParamAssignment_2()); 
            // InternalSymg.g:4007:2: ( rule__DeclarPair__ParamAssignment_2 )
            // InternalSymg.g:4007:3: rule__DeclarPair__ParamAssignment_2
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
    // InternalSymg.g:4016:1: rule__Declar__Group__0 : rule__Declar__Group__0__Impl rule__Declar__Group__1 ;
    public final void rule__Declar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4020:1: ( rule__Declar__Group__0__Impl rule__Declar__Group__1 )
            // InternalSymg.g:4021:2: rule__Declar__Group__0__Impl rule__Declar__Group__1
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
    // InternalSymg.g:4028:1: rule__Declar__Group__0__Impl : ( ( rule__Declar__NameAssignment_0 ) ) ;
    public final void rule__Declar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4032:1: ( ( ( rule__Declar__NameAssignment_0 ) ) )
            // InternalSymg.g:4033:1: ( ( rule__Declar__NameAssignment_0 ) )
            {
            // InternalSymg.g:4033:1: ( ( rule__Declar__NameAssignment_0 ) )
            // InternalSymg.g:4034:2: ( rule__Declar__NameAssignment_0 )
            {
             before(grammarAccess.getDeclarAccess().getNameAssignment_0()); 
            // InternalSymg.g:4035:2: ( rule__Declar__NameAssignment_0 )
            // InternalSymg.g:4035:3: rule__Declar__NameAssignment_0
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
    // InternalSymg.g:4043:1: rule__Declar__Group__1 : rule__Declar__Group__1__Impl rule__Declar__Group__2 ;
    public final void rule__Declar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4047:1: ( rule__Declar__Group__1__Impl rule__Declar__Group__2 )
            // InternalSymg.g:4048:2: rule__Declar__Group__1__Impl rule__Declar__Group__2
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
    // InternalSymg.g:4055:1: rule__Declar__Group__1__Impl : ( ':' ) ;
    public final void rule__Declar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4059:1: ( ( ':' ) )
            // InternalSymg.g:4060:1: ( ':' )
            {
            // InternalSymg.g:4060:1: ( ':' )
            // InternalSymg.g:4061:2: ':'
            {
             before(grammarAccess.getDeclarAccess().getColonKeyword_1()); 
            match(input,92,FOLLOW_2); 
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
    // InternalSymg.g:4070:1: rule__Declar__Group__2 : rule__Declar__Group__2__Impl rule__Declar__Group__3 ;
    public final void rule__Declar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4074:1: ( rule__Declar__Group__2__Impl rule__Declar__Group__3 )
            // InternalSymg.g:4075:2: rule__Declar__Group__2__Impl rule__Declar__Group__3
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
    // InternalSymg.g:4082:1: rule__Declar__Group__2__Impl : ( ( rule__Declar__TypeAssignment_2 ) ) ;
    public final void rule__Declar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4086:1: ( ( ( rule__Declar__TypeAssignment_2 ) ) )
            // InternalSymg.g:4087:1: ( ( rule__Declar__TypeAssignment_2 ) )
            {
            // InternalSymg.g:4087:1: ( ( rule__Declar__TypeAssignment_2 ) )
            // InternalSymg.g:4088:2: ( rule__Declar__TypeAssignment_2 )
            {
             before(grammarAccess.getDeclarAccess().getTypeAssignment_2()); 
            // InternalSymg.g:4089:2: ( rule__Declar__TypeAssignment_2 )
            // InternalSymg.g:4089:3: rule__Declar__TypeAssignment_2
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
    // InternalSymg.g:4097:1: rule__Declar__Group__3 : rule__Declar__Group__3__Impl rule__Declar__Group__4 ;
    public final void rule__Declar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4101:1: ( rule__Declar__Group__3__Impl rule__Declar__Group__4 )
            // InternalSymg.g:4102:2: rule__Declar__Group__3__Impl rule__Declar__Group__4
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
    // InternalSymg.g:4109:1: rule__Declar__Group__3__Impl : ( 'with' ) ;
    public final void rule__Declar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4113:1: ( ( 'with' ) )
            // InternalSymg.g:4114:1: ( 'with' )
            {
            // InternalSymg.g:4114:1: ( 'with' )
            // InternalSymg.g:4115:2: 'with'
            {
             before(grammarAccess.getDeclarAccess().getWithKeyword_3()); 
            match(input,91,FOLLOW_2); 
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
    // InternalSymg.g:4124:1: rule__Declar__Group__4 : rule__Declar__Group__4__Impl rule__Declar__Group__5 ;
    public final void rule__Declar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4128:1: ( rule__Declar__Group__4__Impl rule__Declar__Group__5 )
            // InternalSymg.g:4129:2: rule__Declar__Group__4__Impl rule__Declar__Group__5
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
    // InternalSymg.g:4136:1: rule__Declar__Group__4__Impl : ( ( rule__Declar__Group_4__0 )* ) ;
    public final void rule__Declar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4140:1: ( ( ( rule__Declar__Group_4__0 )* ) )
            // InternalSymg.g:4141:1: ( ( rule__Declar__Group_4__0 )* )
            {
            // InternalSymg.g:4141:1: ( ( rule__Declar__Group_4__0 )* )
            // InternalSymg.g:4142:2: ( rule__Declar__Group_4__0 )*
            {
             before(grammarAccess.getDeclarAccess().getGroup_4()); 
            // InternalSymg.g:4143:2: ( rule__Declar__Group_4__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    int LA39_1 = input.LA(2);

                    if ( (LA39_1==94) ) {
                        int LA39_2 = input.LA(3);

                        if ( (LA39_2==RULE_ID) ) {
                            int LA39_3 = input.LA(4);

                            if ( (LA39_3==82) ) {
                                alt39=1;
                            }


                        }


                    }


                }


                switch (alt39) {
            	case 1 :
            	    // InternalSymg.g:4143:3: rule__Declar__Group_4__0
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
    // InternalSymg.g:4151:1: rule__Declar__Group__5 : rule__Declar__Group__5__Impl ;
    public final void rule__Declar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4155:1: ( rule__Declar__Group__5__Impl )
            // InternalSymg.g:4156:2: rule__Declar__Group__5__Impl
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
    // InternalSymg.g:4162:1: rule__Declar__Group__5__Impl : ( ( rule__Declar__AttributesAssignment_5 ) ) ;
    public final void rule__Declar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4166:1: ( ( ( rule__Declar__AttributesAssignment_5 ) ) )
            // InternalSymg.g:4167:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            {
            // InternalSymg.g:4167:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            // InternalSymg.g:4168:2: ( rule__Declar__AttributesAssignment_5 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_5()); 
            // InternalSymg.g:4169:2: ( rule__Declar__AttributesAssignment_5 )
            // InternalSymg.g:4169:3: rule__Declar__AttributesAssignment_5
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
    // InternalSymg.g:4178:1: rule__Declar__Group_4__0 : rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 ;
    public final void rule__Declar__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4182:1: ( rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 )
            // InternalSymg.g:4183:2: rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1
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
    // InternalSymg.g:4190:1: rule__Declar__Group_4__0__Impl : ( ( rule__Declar__AttributesAssignment_4_0 ) ) ;
    public final void rule__Declar__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4194:1: ( ( ( rule__Declar__AttributesAssignment_4_0 ) ) )
            // InternalSymg.g:4195:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            {
            // InternalSymg.g:4195:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            // InternalSymg.g:4196:2: ( rule__Declar__AttributesAssignment_4_0 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_4_0()); 
            // InternalSymg.g:4197:2: ( rule__Declar__AttributesAssignment_4_0 )
            // InternalSymg.g:4197:3: rule__Declar__AttributesAssignment_4_0
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
    // InternalSymg.g:4205:1: rule__Declar__Group_4__1 : rule__Declar__Group_4__1__Impl ;
    public final void rule__Declar__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4209:1: ( rule__Declar__Group_4__1__Impl )
            // InternalSymg.g:4210:2: rule__Declar__Group_4__1__Impl
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
    // InternalSymg.g:4216:1: rule__Declar__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Declar__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4220:1: ( ( ',' ) )
            // InternalSymg.g:4221:1: ( ',' )
            {
            // InternalSymg.g:4221:1: ( ',' )
            // InternalSymg.g:4222:2: ','
            {
             before(grammarAccess.getDeclarAccess().getCommaKeyword_4_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4232:1: rule__Obligation__Group__0 : rule__Obligation__Group__0__Impl rule__Obligation__Group__1 ;
    public final void rule__Obligation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4236:1: ( rule__Obligation__Group__0__Impl rule__Obligation__Group__1 )
            // InternalSymg.g:4237:2: rule__Obligation__Group__0__Impl rule__Obligation__Group__1
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
    // InternalSymg.g:4244:1: rule__Obligation__Group__0__Impl : ( ( rule__Obligation__NameAssignment_0 ) ) ;
    public final void rule__Obligation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4248:1: ( ( ( rule__Obligation__NameAssignment_0 ) ) )
            // InternalSymg.g:4249:1: ( ( rule__Obligation__NameAssignment_0 ) )
            {
            // InternalSymg.g:4249:1: ( ( rule__Obligation__NameAssignment_0 ) )
            // InternalSymg.g:4250:2: ( rule__Obligation__NameAssignment_0 )
            {
             before(grammarAccess.getObligationAccess().getNameAssignment_0()); 
            // InternalSymg.g:4251:2: ( rule__Obligation__NameAssignment_0 )
            // InternalSymg.g:4251:3: rule__Obligation__NameAssignment_0
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
    // InternalSymg.g:4259:1: rule__Obligation__Group__1 : rule__Obligation__Group__1__Impl rule__Obligation__Group__2 ;
    public final void rule__Obligation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4263:1: ( rule__Obligation__Group__1__Impl rule__Obligation__Group__2 )
            // InternalSymg.g:4264:2: rule__Obligation__Group__1__Impl rule__Obligation__Group__2
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
    // InternalSymg.g:4271:1: rule__Obligation__Group__1__Impl : ( ':' ) ;
    public final void rule__Obligation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4275:1: ( ( ':' ) )
            // InternalSymg.g:4276:1: ( ':' )
            {
            // InternalSymg.g:4276:1: ( ':' )
            // InternalSymg.g:4277:2: ':'
            {
             before(grammarAccess.getObligationAccess().getColonKeyword_1()); 
            match(input,92,FOLLOW_2); 
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
    // InternalSymg.g:4286:1: rule__Obligation__Group__2 : rule__Obligation__Group__2__Impl rule__Obligation__Group__3 ;
    public final void rule__Obligation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4290:1: ( rule__Obligation__Group__2__Impl rule__Obligation__Group__3 )
            // InternalSymg.g:4291:2: rule__Obligation__Group__2__Impl rule__Obligation__Group__3
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
    // InternalSymg.g:4298:1: rule__Obligation__Group__2__Impl : ( ( rule__Obligation__Group_2__0 )? ) ;
    public final void rule__Obligation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4302:1: ( ( ( rule__Obligation__Group_2__0 )? ) )
            // InternalSymg.g:4303:1: ( ( rule__Obligation__Group_2__0 )? )
            {
            // InternalSymg.g:4303:1: ( ( rule__Obligation__Group_2__0 )? )
            // InternalSymg.g:4304:2: ( rule__Obligation__Group_2__0 )?
            {
             before(grammarAccess.getObligationAccess().getGroup_2()); 
            // InternalSymg.g:4305:2: ( rule__Obligation__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_INT)||(LA40_0>=33 && LA40_0<=74)||(LA40_0>=100 && LA40_0<=101)||(LA40_0>=105 && LA40_0<=107)||LA40_0==109) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalSymg.g:4305:3: rule__Obligation__Group_2__0
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
    // InternalSymg.g:4313:1: rule__Obligation__Group__3 : rule__Obligation__Group__3__Impl rule__Obligation__Group__4 ;
    public final void rule__Obligation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4317:1: ( rule__Obligation__Group__3__Impl rule__Obligation__Group__4 )
            // InternalSymg.g:4318:2: rule__Obligation__Group__3__Impl rule__Obligation__Group__4
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
    // InternalSymg.g:4325:1: rule__Obligation__Group__3__Impl : ( 'obligation' ) ;
    public final void rule__Obligation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4329:1: ( ( 'obligation' ) )
            // InternalSymg.g:4330:1: ( 'obligation' )
            {
            // InternalSymg.g:4330:1: ( 'obligation' )
            // InternalSymg.g:4331:2: 'obligation'
            {
             before(grammarAccess.getObligationAccess().getObligationKeyword_3()); 
            match(input,95,FOLLOW_2); 
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
    // InternalSymg.g:4340:1: rule__Obligation__Group__4 : rule__Obligation__Group__4__Impl rule__Obligation__Group__5 ;
    public final void rule__Obligation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4344:1: ( rule__Obligation__Group__4__Impl rule__Obligation__Group__5 )
            // InternalSymg.g:4345:2: rule__Obligation__Group__4__Impl rule__Obligation__Group__5
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
    // InternalSymg.g:4352:1: rule__Obligation__Group__4__Impl : ( '(' ) ;
    public final void rule__Obligation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4356:1: ( ( '(' ) )
            // InternalSymg.g:4357:1: ( '(' )
            {
            // InternalSymg.g:4357:1: ( '(' )
            // InternalSymg.g:4358:2: '('
            {
             before(grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:4367:1: rule__Obligation__Group__5 : rule__Obligation__Group__5__Impl rule__Obligation__Group__6 ;
    public final void rule__Obligation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4371:1: ( rule__Obligation__Group__5__Impl rule__Obligation__Group__6 )
            // InternalSymg.g:4372:2: rule__Obligation__Group__5__Impl rule__Obligation__Group__6
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
    // InternalSymg.g:4379:1: rule__Obligation__Group__5__Impl : ( ( rule__Obligation__Role1Assignment_5 ) ) ;
    public final void rule__Obligation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4383:1: ( ( ( rule__Obligation__Role1Assignment_5 ) ) )
            // InternalSymg.g:4384:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4384:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            // InternalSymg.g:4385:2: ( rule__Obligation__Role1Assignment_5 )
            {
             before(grammarAccess.getObligationAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4386:2: ( rule__Obligation__Role1Assignment_5 )
            // InternalSymg.g:4386:3: rule__Obligation__Role1Assignment_5
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
    // InternalSymg.g:4394:1: rule__Obligation__Group__6 : rule__Obligation__Group__6__Impl rule__Obligation__Group__7 ;
    public final void rule__Obligation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4398:1: ( rule__Obligation__Group__6__Impl rule__Obligation__Group__7 )
            // InternalSymg.g:4399:2: rule__Obligation__Group__6__Impl rule__Obligation__Group__7
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
    // InternalSymg.g:4406:1: rule__Obligation__Group__6__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4410:1: ( ( ',' ) )
            // InternalSymg.g:4411:1: ( ',' )
            {
            // InternalSymg.g:4411:1: ( ',' )
            // InternalSymg.g:4412:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_6()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4421:1: rule__Obligation__Group__7 : rule__Obligation__Group__7__Impl rule__Obligation__Group__8 ;
    public final void rule__Obligation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4425:1: ( rule__Obligation__Group__7__Impl rule__Obligation__Group__8 )
            // InternalSymg.g:4426:2: rule__Obligation__Group__7__Impl rule__Obligation__Group__8
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
    // InternalSymg.g:4433:1: rule__Obligation__Group__7__Impl : ( ( rule__Obligation__Role2Assignment_7 ) ) ;
    public final void rule__Obligation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4437:1: ( ( ( rule__Obligation__Role2Assignment_7 ) ) )
            // InternalSymg.g:4438:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4438:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            // InternalSymg.g:4439:2: ( rule__Obligation__Role2Assignment_7 )
            {
             before(grammarAccess.getObligationAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4440:2: ( rule__Obligation__Role2Assignment_7 )
            // InternalSymg.g:4440:3: rule__Obligation__Role2Assignment_7
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
    // InternalSymg.g:4448:1: rule__Obligation__Group__8 : rule__Obligation__Group__8__Impl rule__Obligation__Group__9 ;
    public final void rule__Obligation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4452:1: ( rule__Obligation__Group__8__Impl rule__Obligation__Group__9 )
            // InternalSymg.g:4453:2: rule__Obligation__Group__8__Impl rule__Obligation__Group__9
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
    // InternalSymg.g:4460:1: rule__Obligation__Group__8__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4464:1: ( ( ',' ) )
            // InternalSymg.g:4465:1: ( ',' )
            {
            // InternalSymg.g:4465:1: ( ',' )
            // InternalSymg.g:4466:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_8()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4475:1: rule__Obligation__Group__9 : rule__Obligation__Group__9__Impl rule__Obligation__Group__10 ;
    public final void rule__Obligation__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4479:1: ( rule__Obligation__Group__9__Impl rule__Obligation__Group__10 )
            // InternalSymg.g:4480:2: rule__Obligation__Group__9__Impl rule__Obligation__Group__10
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
    // InternalSymg.g:4487:1: rule__Obligation__Group__9__Impl : ( ( rule__Obligation__AntecedentAssignment_9 ) ) ;
    public final void rule__Obligation__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4491:1: ( ( ( rule__Obligation__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:4492:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:4492:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            // InternalSymg.g:4493:2: ( rule__Obligation__AntecedentAssignment_9 )
            {
             before(grammarAccess.getObligationAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:4494:2: ( rule__Obligation__AntecedentAssignment_9 )
            // InternalSymg.g:4494:3: rule__Obligation__AntecedentAssignment_9
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
    // InternalSymg.g:4502:1: rule__Obligation__Group__10 : rule__Obligation__Group__10__Impl rule__Obligation__Group__11 ;
    public final void rule__Obligation__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4506:1: ( rule__Obligation__Group__10__Impl rule__Obligation__Group__11 )
            // InternalSymg.g:4507:2: rule__Obligation__Group__10__Impl rule__Obligation__Group__11
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
    // InternalSymg.g:4514:1: rule__Obligation__Group__10__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4518:1: ( ( ',' ) )
            // InternalSymg.g:4519:1: ( ',' )
            {
            // InternalSymg.g:4519:1: ( ',' )
            // InternalSymg.g:4520:2: ','
            {
             before(grammarAccess.getObligationAccess().getCommaKeyword_10()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4529:1: rule__Obligation__Group__11 : rule__Obligation__Group__11__Impl rule__Obligation__Group__12 ;
    public final void rule__Obligation__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4533:1: ( rule__Obligation__Group__11__Impl rule__Obligation__Group__12 )
            // InternalSymg.g:4534:2: rule__Obligation__Group__11__Impl rule__Obligation__Group__12
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
    // InternalSymg.g:4541:1: rule__Obligation__Group__11__Impl : ( ( rule__Obligation__ConsequentAssignment_11 ) ) ;
    public final void rule__Obligation__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4545:1: ( ( ( rule__Obligation__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:4546:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:4546:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            // InternalSymg.g:4547:2: ( rule__Obligation__ConsequentAssignment_11 )
            {
             before(grammarAccess.getObligationAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:4548:2: ( rule__Obligation__ConsequentAssignment_11 )
            // InternalSymg.g:4548:3: rule__Obligation__ConsequentAssignment_11
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
    // InternalSymg.g:4556:1: rule__Obligation__Group__12 : rule__Obligation__Group__12__Impl ;
    public final void rule__Obligation__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4560:1: ( rule__Obligation__Group__12__Impl )
            // InternalSymg.g:4561:2: rule__Obligation__Group__12__Impl
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
    // InternalSymg.g:4567:1: rule__Obligation__Group__12__Impl : ( ')' ) ;
    public final void rule__Obligation__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4571:1: ( ( ')' ) )
            // InternalSymg.g:4572:1: ( ')' )
            {
            // InternalSymg.g:4572:1: ( ')' )
            // InternalSymg.g:4573:2: ')'
            {
             before(grammarAccess.getObligationAccess().getRightParenthesisKeyword_12()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:4583:1: rule__Obligation__Group_2__0 : rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 ;
    public final void rule__Obligation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4587:1: ( rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 )
            // InternalSymg.g:4588:2: rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1
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
    // InternalSymg.g:4595:1: rule__Obligation__Group_2__0__Impl : ( ( rule__Obligation__TriggerAssignment_2_0 ) ) ;
    public final void rule__Obligation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4599:1: ( ( ( rule__Obligation__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:4600:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:4600:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            // InternalSymg.g:4601:2: ( rule__Obligation__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getObligationAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:4602:2: ( rule__Obligation__TriggerAssignment_2_0 )
            // InternalSymg.g:4602:3: rule__Obligation__TriggerAssignment_2_0
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
    // InternalSymg.g:4610:1: rule__Obligation__Group_2__1 : rule__Obligation__Group_2__1__Impl ;
    public final void rule__Obligation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4614:1: ( rule__Obligation__Group_2__1__Impl )
            // InternalSymg.g:4615:2: rule__Obligation__Group_2__1__Impl
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
    // InternalSymg.g:4621:1: rule__Obligation__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Obligation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4625:1: ( ( '->' ) )
            // InternalSymg.g:4626:1: ( '->' )
            {
            // InternalSymg.g:4626:1: ( '->' )
            // InternalSymg.g:4627:2: '->'
            {
             before(grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            match(input,96,FOLLOW_2); 
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
    // InternalSymg.g:4637:1: rule__Power__Group__0 : rule__Power__Group__0__Impl rule__Power__Group__1 ;
    public final void rule__Power__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4641:1: ( rule__Power__Group__0__Impl rule__Power__Group__1 )
            // InternalSymg.g:4642:2: rule__Power__Group__0__Impl rule__Power__Group__1
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
    // InternalSymg.g:4649:1: rule__Power__Group__0__Impl : ( ( rule__Power__NameAssignment_0 ) ) ;
    public final void rule__Power__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4653:1: ( ( ( rule__Power__NameAssignment_0 ) ) )
            // InternalSymg.g:4654:1: ( ( rule__Power__NameAssignment_0 ) )
            {
            // InternalSymg.g:4654:1: ( ( rule__Power__NameAssignment_0 ) )
            // InternalSymg.g:4655:2: ( rule__Power__NameAssignment_0 )
            {
             before(grammarAccess.getPowerAccess().getNameAssignment_0()); 
            // InternalSymg.g:4656:2: ( rule__Power__NameAssignment_0 )
            // InternalSymg.g:4656:3: rule__Power__NameAssignment_0
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
    // InternalSymg.g:4664:1: rule__Power__Group__1 : rule__Power__Group__1__Impl rule__Power__Group__2 ;
    public final void rule__Power__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4668:1: ( rule__Power__Group__1__Impl rule__Power__Group__2 )
            // InternalSymg.g:4669:2: rule__Power__Group__1__Impl rule__Power__Group__2
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
    // InternalSymg.g:4676:1: rule__Power__Group__1__Impl : ( ':' ) ;
    public final void rule__Power__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4680:1: ( ( ':' ) )
            // InternalSymg.g:4681:1: ( ':' )
            {
            // InternalSymg.g:4681:1: ( ':' )
            // InternalSymg.g:4682:2: ':'
            {
             before(grammarAccess.getPowerAccess().getColonKeyword_1()); 
            match(input,92,FOLLOW_2); 
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
    // InternalSymg.g:4691:1: rule__Power__Group__2 : rule__Power__Group__2__Impl rule__Power__Group__3 ;
    public final void rule__Power__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4695:1: ( rule__Power__Group__2__Impl rule__Power__Group__3 )
            // InternalSymg.g:4696:2: rule__Power__Group__2__Impl rule__Power__Group__3
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
    // InternalSymg.g:4703:1: rule__Power__Group__2__Impl : ( ( rule__Power__Group_2__0 )? ) ;
    public final void rule__Power__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4707:1: ( ( ( rule__Power__Group_2__0 )? ) )
            // InternalSymg.g:4708:1: ( ( rule__Power__Group_2__0 )? )
            {
            // InternalSymg.g:4708:1: ( ( rule__Power__Group_2__0 )? )
            // InternalSymg.g:4709:2: ( rule__Power__Group_2__0 )?
            {
             before(grammarAccess.getPowerAccess().getGroup_2()); 
            // InternalSymg.g:4710:2: ( rule__Power__Group_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_INT)||(LA41_0>=33 && LA41_0<=74)||(LA41_0>=100 && LA41_0<=101)||(LA41_0>=105 && LA41_0<=107)||LA41_0==109) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSymg.g:4710:3: rule__Power__Group_2__0
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
    // InternalSymg.g:4718:1: rule__Power__Group__3 : rule__Power__Group__3__Impl rule__Power__Group__4 ;
    public final void rule__Power__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4722:1: ( rule__Power__Group__3__Impl rule__Power__Group__4 )
            // InternalSymg.g:4723:2: rule__Power__Group__3__Impl rule__Power__Group__4
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
    // InternalSymg.g:4730:1: rule__Power__Group__3__Impl : ( 'power' ) ;
    public final void rule__Power__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4734:1: ( ( 'power' ) )
            // InternalSymg.g:4735:1: ( 'power' )
            {
            // InternalSymg.g:4735:1: ( 'power' )
            // InternalSymg.g:4736:2: 'power'
            {
             before(grammarAccess.getPowerAccess().getPowerKeyword_3()); 
            match(input,97,FOLLOW_2); 
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
    // InternalSymg.g:4745:1: rule__Power__Group__4 : rule__Power__Group__4__Impl rule__Power__Group__5 ;
    public final void rule__Power__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4749:1: ( rule__Power__Group__4__Impl rule__Power__Group__5 )
            // InternalSymg.g:4750:2: rule__Power__Group__4__Impl rule__Power__Group__5
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
    // InternalSymg.g:4757:1: rule__Power__Group__4__Impl : ( '(' ) ;
    public final void rule__Power__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4761:1: ( ( '(' ) )
            // InternalSymg.g:4762:1: ( '(' )
            {
            // InternalSymg.g:4762:1: ( '(' )
            // InternalSymg.g:4763:2: '('
            {
             before(grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:4772:1: rule__Power__Group__5 : rule__Power__Group__5__Impl rule__Power__Group__6 ;
    public final void rule__Power__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4776:1: ( rule__Power__Group__5__Impl rule__Power__Group__6 )
            // InternalSymg.g:4777:2: rule__Power__Group__5__Impl rule__Power__Group__6
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
    // InternalSymg.g:4784:1: rule__Power__Group__5__Impl : ( ( rule__Power__Role1Assignment_5 ) ) ;
    public final void rule__Power__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4788:1: ( ( ( rule__Power__Role1Assignment_5 ) ) )
            // InternalSymg.g:4789:1: ( ( rule__Power__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4789:1: ( ( rule__Power__Role1Assignment_5 ) )
            // InternalSymg.g:4790:2: ( rule__Power__Role1Assignment_5 )
            {
             before(grammarAccess.getPowerAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4791:2: ( rule__Power__Role1Assignment_5 )
            // InternalSymg.g:4791:3: rule__Power__Role1Assignment_5
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
    // InternalSymg.g:4799:1: rule__Power__Group__6 : rule__Power__Group__6__Impl rule__Power__Group__7 ;
    public final void rule__Power__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4803:1: ( rule__Power__Group__6__Impl rule__Power__Group__7 )
            // InternalSymg.g:4804:2: rule__Power__Group__6__Impl rule__Power__Group__7
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
    // InternalSymg.g:4811:1: rule__Power__Group__6__Impl : ( ',' ) ;
    public final void rule__Power__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4815:1: ( ( ',' ) )
            // InternalSymg.g:4816:1: ( ',' )
            {
            // InternalSymg.g:4816:1: ( ',' )
            // InternalSymg.g:4817:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_6()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4826:1: rule__Power__Group__7 : rule__Power__Group__7__Impl rule__Power__Group__8 ;
    public final void rule__Power__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4830:1: ( rule__Power__Group__7__Impl rule__Power__Group__8 )
            // InternalSymg.g:4831:2: rule__Power__Group__7__Impl rule__Power__Group__8
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
    // InternalSymg.g:4838:1: rule__Power__Group__7__Impl : ( ( rule__Power__Role2Assignment_7 ) ) ;
    public final void rule__Power__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4842:1: ( ( ( rule__Power__Role2Assignment_7 ) ) )
            // InternalSymg.g:4843:1: ( ( rule__Power__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4843:1: ( ( rule__Power__Role2Assignment_7 ) )
            // InternalSymg.g:4844:2: ( rule__Power__Role2Assignment_7 )
            {
             before(grammarAccess.getPowerAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4845:2: ( rule__Power__Role2Assignment_7 )
            // InternalSymg.g:4845:3: rule__Power__Role2Assignment_7
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
    // InternalSymg.g:4853:1: rule__Power__Group__8 : rule__Power__Group__8__Impl rule__Power__Group__9 ;
    public final void rule__Power__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4857:1: ( rule__Power__Group__8__Impl rule__Power__Group__9 )
            // InternalSymg.g:4858:2: rule__Power__Group__8__Impl rule__Power__Group__9
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
    // InternalSymg.g:4865:1: rule__Power__Group__8__Impl : ( ',' ) ;
    public final void rule__Power__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4869:1: ( ( ',' ) )
            // InternalSymg.g:4870:1: ( ',' )
            {
            // InternalSymg.g:4870:1: ( ',' )
            // InternalSymg.g:4871:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_8()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4880:1: rule__Power__Group__9 : rule__Power__Group__9__Impl rule__Power__Group__10 ;
    public final void rule__Power__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4884:1: ( rule__Power__Group__9__Impl rule__Power__Group__10 )
            // InternalSymg.g:4885:2: rule__Power__Group__9__Impl rule__Power__Group__10
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
    // InternalSymg.g:4892:1: rule__Power__Group__9__Impl : ( ( rule__Power__AntecedentAssignment_9 ) ) ;
    public final void rule__Power__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4896:1: ( ( ( rule__Power__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:4897:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:4897:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            // InternalSymg.g:4898:2: ( rule__Power__AntecedentAssignment_9 )
            {
             before(grammarAccess.getPowerAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:4899:2: ( rule__Power__AntecedentAssignment_9 )
            // InternalSymg.g:4899:3: rule__Power__AntecedentAssignment_9
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
    // InternalSymg.g:4907:1: rule__Power__Group__10 : rule__Power__Group__10__Impl rule__Power__Group__11 ;
    public final void rule__Power__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4911:1: ( rule__Power__Group__10__Impl rule__Power__Group__11 )
            // InternalSymg.g:4912:2: rule__Power__Group__10__Impl rule__Power__Group__11
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
    // InternalSymg.g:4919:1: rule__Power__Group__10__Impl : ( ',' ) ;
    public final void rule__Power__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4923:1: ( ( ',' ) )
            // InternalSymg.g:4924:1: ( ',' )
            {
            // InternalSymg.g:4924:1: ( ',' )
            // InternalSymg.g:4925:2: ','
            {
             before(grammarAccess.getPowerAccess().getCommaKeyword_10()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:4934:1: rule__Power__Group__11 : rule__Power__Group__11__Impl rule__Power__Group__12 ;
    public final void rule__Power__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4938:1: ( rule__Power__Group__11__Impl rule__Power__Group__12 )
            // InternalSymg.g:4939:2: rule__Power__Group__11__Impl rule__Power__Group__12
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
    // InternalSymg.g:4946:1: rule__Power__Group__11__Impl : ( ( rule__Power__ConsequentAssignment_11 ) ) ;
    public final void rule__Power__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4950:1: ( ( ( rule__Power__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:4951:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:4951:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            // InternalSymg.g:4952:2: ( rule__Power__ConsequentAssignment_11 )
            {
             before(grammarAccess.getPowerAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:4953:2: ( rule__Power__ConsequentAssignment_11 )
            // InternalSymg.g:4953:3: rule__Power__ConsequentAssignment_11
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
    // InternalSymg.g:4961:1: rule__Power__Group__12 : rule__Power__Group__12__Impl ;
    public final void rule__Power__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4965:1: ( rule__Power__Group__12__Impl )
            // InternalSymg.g:4966:2: rule__Power__Group__12__Impl
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
    // InternalSymg.g:4972:1: rule__Power__Group__12__Impl : ( ')' ) ;
    public final void rule__Power__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4976:1: ( ( ')' ) )
            // InternalSymg.g:4977:1: ( ')' )
            {
            // InternalSymg.g:4977:1: ( ')' )
            // InternalSymg.g:4978:2: ')'
            {
             before(grammarAccess.getPowerAccess().getRightParenthesisKeyword_12()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:4988:1: rule__Power__Group_2__0 : rule__Power__Group_2__0__Impl rule__Power__Group_2__1 ;
    public final void rule__Power__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4992:1: ( rule__Power__Group_2__0__Impl rule__Power__Group_2__1 )
            // InternalSymg.g:4993:2: rule__Power__Group_2__0__Impl rule__Power__Group_2__1
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
    // InternalSymg.g:5000:1: rule__Power__Group_2__0__Impl : ( ( rule__Power__TriggerAssignment_2_0 ) ) ;
    public final void rule__Power__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5004:1: ( ( ( rule__Power__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:5005:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:5005:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            // InternalSymg.g:5006:2: ( rule__Power__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getPowerAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:5007:2: ( rule__Power__TriggerAssignment_2_0 )
            // InternalSymg.g:5007:3: rule__Power__TriggerAssignment_2_0
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
    // InternalSymg.g:5015:1: rule__Power__Group_2__1 : rule__Power__Group_2__1__Impl ;
    public final void rule__Power__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5019:1: ( rule__Power__Group_2__1__Impl )
            // InternalSymg.g:5020:2: rule__Power__Group_2__1__Impl
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
    // InternalSymg.g:5026:1: rule__Power__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Power__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5030:1: ( ( '->' ) )
            // InternalSymg.g:5031:1: ( '->' )
            {
            // InternalSymg.g:5031:1: ( '->' )
            // InternalSymg.g:5032:2: '->'
            {
             before(grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1()); 
            match(input,96,FOLLOW_2); 
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
    // InternalSymg.g:5042:1: rule__Proposition__Group__0 : rule__Proposition__Group__0__Impl rule__Proposition__Group__1 ;
    public final void rule__Proposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5046:1: ( rule__Proposition__Group__0__Impl rule__Proposition__Group__1 )
            // InternalSymg.g:5047:2: rule__Proposition__Group__0__Impl rule__Proposition__Group__1
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
    // InternalSymg.g:5054:1: rule__Proposition__Group__0__Impl : ( ( rule__Proposition__JunctionsAssignment_0 ) ) ;
    public final void rule__Proposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5058:1: ( ( ( rule__Proposition__JunctionsAssignment_0 ) ) )
            // InternalSymg.g:5059:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            {
            // InternalSymg.g:5059:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            // InternalSymg.g:5060:2: ( rule__Proposition__JunctionsAssignment_0 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_0()); 
            // InternalSymg.g:5061:2: ( rule__Proposition__JunctionsAssignment_0 )
            // InternalSymg.g:5061:3: rule__Proposition__JunctionsAssignment_0
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
    // InternalSymg.g:5069:1: rule__Proposition__Group__1 : rule__Proposition__Group__1__Impl ;
    public final void rule__Proposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5073:1: ( rule__Proposition__Group__1__Impl )
            // InternalSymg.g:5074:2: rule__Proposition__Group__1__Impl
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
    // InternalSymg.g:5080:1: rule__Proposition__Group__1__Impl : ( ( rule__Proposition__Group_1__0 )* ) ;
    public final void rule__Proposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5084:1: ( ( ( rule__Proposition__Group_1__0 )* ) )
            // InternalSymg.g:5085:1: ( ( rule__Proposition__Group_1__0 )* )
            {
            // InternalSymg.g:5085:1: ( ( rule__Proposition__Group_1__0 )* )
            // InternalSymg.g:5086:2: ( rule__Proposition__Group_1__0 )*
            {
             before(grammarAccess.getPropositionAccess().getGroup_1()); 
            // InternalSymg.g:5087:2: ( rule__Proposition__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==98) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSymg.g:5087:3: rule__Proposition__Group_1__0
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
    // InternalSymg.g:5096:1: rule__Proposition__Group_1__0 : rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 ;
    public final void rule__Proposition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5100:1: ( rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 )
            // InternalSymg.g:5101:2: rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1
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
    // InternalSymg.g:5108:1: rule__Proposition__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__Proposition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5112:1: ( ( 'OR' ) )
            // InternalSymg.g:5113:1: ( 'OR' )
            {
            // InternalSymg.g:5113:1: ( 'OR' )
            // InternalSymg.g:5114:2: 'OR'
            {
             before(grammarAccess.getPropositionAccess().getORKeyword_1_0()); 
            match(input,98,FOLLOW_2); 
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
    // InternalSymg.g:5123:1: rule__Proposition__Group_1__1 : rule__Proposition__Group_1__1__Impl ;
    public final void rule__Proposition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5127:1: ( rule__Proposition__Group_1__1__Impl )
            // InternalSymg.g:5128:2: rule__Proposition__Group_1__1__Impl
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
    // InternalSymg.g:5134:1: rule__Proposition__Group_1__1__Impl : ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) ;
    public final void rule__Proposition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5138:1: ( ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) )
            // InternalSymg.g:5139:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            {
            // InternalSymg.g:5139:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            // InternalSymg.g:5140:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_1_1()); 
            // InternalSymg.g:5141:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            // InternalSymg.g:5141:3: rule__Proposition__JunctionsAssignment_1_1
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
    // InternalSymg.g:5150:1: rule__Junction__Group__0 : rule__Junction__Group__0__Impl rule__Junction__Group__1 ;
    public final void rule__Junction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5154:1: ( rule__Junction__Group__0__Impl rule__Junction__Group__1 )
            // InternalSymg.g:5155:2: rule__Junction__Group__0__Impl rule__Junction__Group__1
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
    // InternalSymg.g:5162:1: rule__Junction__Group__0__Impl : ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) ;
    public final void rule__Junction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5166:1: ( ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) )
            // InternalSymg.g:5167:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            {
            // InternalSymg.g:5167:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            // InternalSymg.g:5168:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_0()); 
            // InternalSymg.g:5169:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            // InternalSymg.g:5169:3: rule__Junction__NegativeAtomsAssignment_0
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
    // InternalSymg.g:5177:1: rule__Junction__Group__1 : rule__Junction__Group__1__Impl ;
    public final void rule__Junction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5181:1: ( rule__Junction__Group__1__Impl )
            // InternalSymg.g:5182:2: rule__Junction__Group__1__Impl
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
    // InternalSymg.g:5188:1: rule__Junction__Group__1__Impl : ( ( rule__Junction__Group_1__0 )* ) ;
    public final void rule__Junction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5192:1: ( ( ( rule__Junction__Group_1__0 )* ) )
            // InternalSymg.g:5193:1: ( ( rule__Junction__Group_1__0 )* )
            {
            // InternalSymg.g:5193:1: ( ( rule__Junction__Group_1__0 )* )
            // InternalSymg.g:5194:2: ( rule__Junction__Group_1__0 )*
            {
             before(grammarAccess.getJunctionAccess().getGroup_1()); 
            // InternalSymg.g:5195:2: ( rule__Junction__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==99) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSymg.g:5195:3: rule__Junction__Group_1__0
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
    // InternalSymg.g:5204:1: rule__Junction__Group_1__0 : rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 ;
    public final void rule__Junction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5208:1: ( rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 )
            // InternalSymg.g:5209:2: rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1
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
    // InternalSymg.g:5216:1: rule__Junction__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__Junction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5220:1: ( ( 'AND' ) )
            // InternalSymg.g:5221:1: ( 'AND' )
            {
            // InternalSymg.g:5221:1: ( 'AND' )
            // InternalSymg.g:5222:2: 'AND'
            {
             before(grammarAccess.getJunctionAccess().getANDKeyword_1_0()); 
            match(input,99,FOLLOW_2); 
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
    // InternalSymg.g:5231:1: rule__Junction__Group_1__1 : rule__Junction__Group_1__1__Impl ;
    public final void rule__Junction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5235:1: ( rule__Junction__Group_1__1__Impl )
            // InternalSymg.g:5236:2: rule__Junction__Group_1__1__Impl
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
    // InternalSymg.g:5242:1: rule__Junction__Group_1__1__Impl : ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) ;
    public final void rule__Junction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5246:1: ( ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) )
            // InternalSymg.g:5247:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            {
            // InternalSymg.g:5247:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            // InternalSymg.g:5248:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_1_1()); 
            // InternalSymg.g:5249:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            // InternalSymg.g:5249:3: rule__Junction__NegativeAtomsAssignment_1_1
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
    // InternalSymg.g:5258:1: rule__Negation__Group__0 : rule__Negation__Group__0__Impl rule__Negation__Group__1 ;
    public final void rule__Negation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5262:1: ( rule__Negation__Group__0__Impl rule__Negation__Group__1 )
            // InternalSymg.g:5263:2: rule__Negation__Group__0__Impl rule__Negation__Group__1
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
    // InternalSymg.g:5270:1: rule__Negation__Group__0__Impl : ( ( rule__Negation__NegatedAssignment_0 )? ) ;
    public final void rule__Negation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5274:1: ( ( ( rule__Negation__NegatedAssignment_0 )? ) )
            // InternalSymg.g:5275:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            {
            // InternalSymg.g:5275:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            // InternalSymg.g:5276:2: ( rule__Negation__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNegationAccess().getNegatedAssignment_0()); 
            // InternalSymg.g:5277:2: ( rule__Negation__NegatedAssignment_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==105) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSymg.g:5277:3: rule__Negation__NegatedAssignment_0
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
    // InternalSymg.g:5285:1: rule__Negation__Group__1 : rule__Negation__Group__1__Impl ;
    public final void rule__Negation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5289:1: ( rule__Negation__Group__1__Impl )
            // InternalSymg.g:5290:2: rule__Negation__Group__1__Impl
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
    // InternalSymg.g:5296:1: rule__Negation__Group__1__Impl : ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) ;
    public final void rule__Negation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5300:1: ( ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) )
            // InternalSymg.g:5301:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            {
            // InternalSymg.g:5301:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            // InternalSymg.g:5302:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            {
             before(grammarAccess.getNegationAccess().getAtomicExpressionAssignment_1()); 
            // InternalSymg.g:5303:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            // InternalSymg.g:5303:3: rule__Negation__AtomicExpressionAssignment_1
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
    // InternalSymg.g:5312:1: rule__Atom__Group_0__0 : rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 ;
    public final void rule__Atom__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5316:1: ( rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 )
            // InternalSymg.g:5317:2: rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1
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
    // InternalSymg.g:5324:1: rule__Atom__Group_0__0__Impl : ( 'happens' ) ;
    public final void rule__Atom__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5328:1: ( ( 'happens' ) )
            // InternalSymg.g:5329:1: ( 'happens' )
            {
            // InternalSymg.g:5329:1: ( 'happens' )
            // InternalSymg.g:5330:2: 'happens'
            {
             before(grammarAccess.getAtomAccess().getHappensKeyword_0_0()); 
            match(input,100,FOLLOW_2); 
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
    // InternalSymg.g:5339:1: rule__Atom__Group_0__1 : rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 ;
    public final void rule__Atom__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5343:1: ( rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 )
            // InternalSymg.g:5344:2: rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2
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
    // InternalSymg.g:5351:1: rule__Atom__Group_0__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5355:1: ( ( '(' ) )
            // InternalSymg.g:5356:1: ( '(' )
            {
            // InternalSymg.g:5356:1: ( '(' )
            // InternalSymg.g:5357:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_0_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:5366:1: rule__Atom__Group_0__2 : rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 ;
    public final void rule__Atom__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5370:1: ( rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 )
            // InternalSymg.g:5371:2: rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3
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
    // InternalSymg.g:5378:1: rule__Atom__Group_0__2__Impl : ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) ;
    public final void rule__Atom__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5382:1: ( ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) )
            // InternalSymg.g:5383:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            {
            // InternalSymg.g:5383:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            // InternalSymg.g:5384:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            {
             before(grammarAccess.getAtomAccess().getEventPropositionAssignment_0_2()); 
            // InternalSymg.g:5385:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            // InternalSymg.g:5385:3: rule__Atom__EventPropositionAssignment_0_2
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
    // InternalSymg.g:5393:1: rule__Atom__Group_0__3 : rule__Atom__Group_0__3__Impl ;
    public final void rule__Atom__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5397:1: ( rule__Atom__Group_0__3__Impl )
            // InternalSymg.g:5398:2: rule__Atom__Group_0__3__Impl
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
    // InternalSymg.g:5404:1: rule__Atom__Group_0__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5408:1: ( ( ')' ) )
            // InternalSymg.g:5409:1: ( ')' )
            {
            // InternalSymg.g:5409:1: ( ')' )
            // InternalSymg.g:5410:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_0_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:5420:1: rule__Atom__Group_1__0 : rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 ;
    public final void rule__Atom__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5424:1: ( rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 )
            // InternalSymg.g:5425:2: rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1
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
    // InternalSymg.g:5432:1: rule__Atom__Group_1__0__Impl : ( 'occurs' ) ;
    public final void rule__Atom__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5436:1: ( ( 'occurs' ) )
            // InternalSymg.g:5437:1: ( 'occurs' )
            {
            // InternalSymg.g:5437:1: ( 'occurs' )
            // InternalSymg.g:5438:2: 'occurs'
            {
             before(grammarAccess.getAtomAccess().getOccursKeyword_1_0()); 
            match(input,101,FOLLOW_2); 
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
    // InternalSymg.g:5447:1: rule__Atom__Group_1__1 : rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 ;
    public final void rule__Atom__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5451:1: ( rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 )
            // InternalSymg.g:5452:2: rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2
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
    // InternalSymg.g:5459:1: rule__Atom__Group_1__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5463:1: ( ( '(' ) )
            // InternalSymg.g:5464:1: ( '(' )
            {
            // InternalSymg.g:5464:1: ( '(' )
            // InternalSymg.g:5465:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:5474:1: rule__Atom__Group_1__2 : rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 ;
    public final void rule__Atom__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5478:1: ( rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 )
            // InternalSymg.g:5479:2: rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3
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
    // InternalSymg.g:5486:1: rule__Atom__Group_1__2__Impl : ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) ;
    public final void rule__Atom__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5490:1: ( ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) )
            // InternalSymg.g:5491:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            {
            // InternalSymg.g:5491:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            // InternalSymg.g:5492:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            {
             before(grammarAccess.getAtomAccess().getSituationPropositionAssignment_1_2()); 
            // InternalSymg.g:5493:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            // InternalSymg.g:5493:3: rule__Atom__SituationPropositionAssignment_1_2
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
    // InternalSymg.g:5501:1: rule__Atom__Group_1__3 : rule__Atom__Group_1__3__Impl ;
    public final void rule__Atom__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5505:1: ( rule__Atom__Group_1__3__Impl )
            // InternalSymg.g:5506:2: rule__Atom__Group_1__3__Impl
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
    // InternalSymg.g:5512:1: rule__Atom__Group_1__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5516:1: ( ( ')' ) )
            // InternalSymg.g:5517:1: ( ')' )
            {
            // InternalSymg.g:5517:1: ( ')' )
            // InternalSymg.g:5518:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_1_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:5528:1: rule__Atom__Group_2__0 : rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 ;
    public final void rule__Atom__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5532:1: ( rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 )
            // InternalSymg.g:5533:2: rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalSymg.g:5540:1: rule__Atom__Group_2__0__Impl : ( ( rule__Atom__PointAssignment_2_0 ) ) ;
    public final void rule__Atom__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5544:1: ( ( ( rule__Atom__PointAssignment_2_0 ) ) )
            // InternalSymg.g:5545:1: ( ( rule__Atom__PointAssignment_2_0 ) )
            {
            // InternalSymg.g:5545:1: ( ( rule__Atom__PointAssignment_2_0 ) )
            // InternalSymg.g:5546:2: ( rule__Atom__PointAssignment_2_0 )
            {
             before(grammarAccess.getAtomAccess().getPointAssignment_2_0()); 
            // InternalSymg.g:5547:2: ( rule__Atom__PointAssignment_2_0 )
            // InternalSymg.g:5547:3: rule__Atom__PointAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Atom__PointAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getPointAssignment_2_0()); 

            }


            }

        }
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
    // InternalSymg.g:5555:1: rule__Atom__Group_2__1 : rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 ;
    public final void rule__Atom__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5559:1: ( rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 )
            // InternalSymg.g:5560:2: rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalSymg.g:5567:1: rule__Atom__Group_2__1__Impl : ( 'within' ) ;
    public final void rule__Atom__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5571:1: ( ( 'within' ) )
            // InternalSymg.g:5572:1: ( 'within' )
            {
            // InternalSymg.g:5572:1: ( 'within' )
            // InternalSymg.g:5573:2: 'within'
            {
             before(grammarAccess.getAtomAccess().getWithinKeyword_2_1()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getWithinKeyword_2_1()); 

            }


            }

        }
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
    // InternalSymg.g:5582:1: rule__Atom__Group_2__2 : rule__Atom__Group_2__2__Impl ;
    public final void rule__Atom__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5586:1: ( rule__Atom__Group_2__2__Impl )
            // InternalSymg.g:5587:2: rule__Atom__Group_2__2__Impl
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
    // InternalSymg.g:5593:1: rule__Atom__Group_2__2__Impl : ( ( rule__Atom__IntervalAssignment_2_2 ) ) ;
    public final void rule__Atom__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5597:1: ( ( ( rule__Atom__IntervalAssignment_2_2 ) ) )
            // InternalSymg.g:5598:1: ( ( rule__Atom__IntervalAssignment_2_2 ) )
            {
            // InternalSymg.g:5598:1: ( ( rule__Atom__IntervalAssignment_2_2 ) )
            // InternalSymg.g:5599:2: ( rule__Atom__IntervalAssignment_2_2 )
            {
             before(grammarAccess.getAtomAccess().getIntervalAssignment_2_2()); 
            // InternalSymg.g:5600:2: ( rule__Atom__IntervalAssignment_2_2 )
            // InternalSymg.g:5600:3: rule__Atom__IntervalAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__Atom__IntervalAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getIntervalAssignment_2_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__SitProp__Group__0"
    // InternalSymg.g:5609:1: rule__SitProp__Group__0 : rule__SitProp__Group__0__Impl rule__SitProp__Group__1 ;
    public final void rule__SitProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5613:1: ( rule__SitProp__Group__0__Impl rule__SitProp__Group__1 )
            // InternalSymg.g:5614:2: rule__SitProp__Group__0__Impl rule__SitProp__Group__1
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
    // InternalSymg.g:5621:1: rule__SitProp__Group__0__Impl : ( ( rule__SitProp__Alternatives_0 ) ) ;
    public final void rule__SitProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5625:1: ( ( ( rule__SitProp__Alternatives_0 ) ) )
            // InternalSymg.g:5626:1: ( ( rule__SitProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5626:1: ( ( rule__SitProp__Alternatives_0 ) )
            // InternalSymg.g:5627:2: ( rule__SitProp__Alternatives_0 )
            {
             before(grammarAccess.getSitPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5628:2: ( rule__SitProp__Alternatives_0 )
            // InternalSymg.g:5628:3: rule__SitProp__Alternatives_0
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
    // InternalSymg.g:5636:1: rule__SitProp__Group__1 : rule__SitProp__Group__1__Impl rule__SitProp__Group__2 ;
    public final void rule__SitProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5640:1: ( rule__SitProp__Group__1__Impl rule__SitProp__Group__2 )
            // InternalSymg.g:5641:2: rule__SitProp__Group__1__Impl rule__SitProp__Group__2
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
    // InternalSymg.g:5648:1: rule__SitProp__Group__1__Impl : ( ',' ) ;
    public final void rule__SitProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5652:1: ( ( ',' ) )
            // InternalSymg.g:5653:1: ( ',' )
            {
            // InternalSymg.g:5653:1: ( ',' )
            // InternalSymg.g:5654:2: ','
            {
             before(grammarAccess.getSitPropAccess().getCommaKeyword_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:5663:1: rule__SitProp__Group__2 : rule__SitProp__Group__2__Impl ;
    public final void rule__SitProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5667:1: ( rule__SitProp__Group__2__Impl )
            // InternalSymg.g:5668:2: rule__SitProp__Group__2__Impl
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
    // InternalSymg.g:5674:1: rule__SitProp__Group__2__Impl : ( ( rule__SitProp__IntervalAssignment_2 ) ) ;
    public final void rule__SitProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5678:1: ( ( ( rule__SitProp__IntervalAssignment_2 ) ) )
            // InternalSymg.g:5679:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            {
            // InternalSymg.g:5679:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            // InternalSymg.g:5680:2: ( rule__SitProp__IntervalAssignment_2 )
            {
             before(grammarAccess.getSitPropAccess().getIntervalAssignment_2()); 
            // InternalSymg.g:5681:2: ( rule__SitProp__IntervalAssignment_2 )
            // InternalSymg.g:5681:3: rule__SitProp__IntervalAssignment_2
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
    // InternalSymg.g:5690:1: rule__EventProp__Group__0 : rule__EventProp__Group__0__Impl rule__EventProp__Group__1 ;
    public final void rule__EventProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5694:1: ( rule__EventProp__Group__0__Impl rule__EventProp__Group__1 )
            // InternalSymg.g:5695:2: rule__EventProp__Group__0__Impl rule__EventProp__Group__1
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
    // InternalSymg.g:5702:1: rule__EventProp__Group__0__Impl : ( ( rule__EventProp__Alternatives_0 ) ) ;
    public final void rule__EventProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5706:1: ( ( ( rule__EventProp__Alternatives_0 ) ) )
            // InternalSymg.g:5707:1: ( ( rule__EventProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5707:1: ( ( rule__EventProp__Alternatives_0 ) )
            // InternalSymg.g:5708:2: ( rule__EventProp__Alternatives_0 )
            {
             before(grammarAccess.getEventPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5709:2: ( rule__EventProp__Alternatives_0 )
            // InternalSymg.g:5709:3: rule__EventProp__Alternatives_0
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
    // InternalSymg.g:5717:1: rule__EventProp__Group__1 : rule__EventProp__Group__1__Impl rule__EventProp__Group__2 ;
    public final void rule__EventProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5721:1: ( rule__EventProp__Group__1__Impl rule__EventProp__Group__2 )
            // InternalSymg.g:5722:2: rule__EventProp__Group__1__Impl rule__EventProp__Group__2
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
    // InternalSymg.g:5729:1: rule__EventProp__Group__1__Impl : ( ',' ) ;
    public final void rule__EventProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5733:1: ( ( ',' ) )
            // InternalSymg.g:5734:1: ( ',' )
            {
            // InternalSymg.g:5734:1: ( ',' )
            // InternalSymg.g:5735:2: ','
            {
             before(grammarAccess.getEventPropAccess().getCommaKeyword_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:5744:1: rule__EventProp__Group__2 : rule__EventProp__Group__2__Impl ;
    public final void rule__EventProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5748:1: ( rule__EventProp__Group__2__Impl )
            // InternalSymg.g:5749:2: rule__EventProp__Group__2__Impl
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
    // InternalSymg.g:5755:1: rule__EventProp__Group__2__Impl : ( ( rule__EventProp__PointAssignment_2 ) ) ;
    public final void rule__EventProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5759:1: ( ( ( rule__EventProp__PointAssignment_2 ) ) )
            // InternalSymg.g:5760:1: ( ( rule__EventProp__PointAssignment_2 ) )
            {
            // InternalSymg.g:5760:1: ( ( rule__EventProp__PointAssignment_2 ) )
            // InternalSymg.g:5761:2: ( rule__EventProp__PointAssignment_2 )
            {
             before(grammarAccess.getEventPropAccess().getPointAssignment_2()); 
            // InternalSymg.g:5762:2: ( rule__EventProp__PointAssignment_2 )
            // InternalSymg.g:5762:3: rule__EventProp__PointAssignment_2
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
    // InternalSymg.g:5771:1: rule__Interval__Group_1__0 : rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 ;
    public final void rule__Interval__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5775:1: ( rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 )
            // InternalSymg.g:5776:2: rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1
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
    // InternalSymg.g:5783:1: rule__Interval__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Interval__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5787:1: ( ( '[' ) )
            // InternalSymg.g:5788:1: ( '[' )
            {
            // InternalSymg.g:5788:1: ( '[' )
            // InternalSymg.g:5789:2: '['
            {
             before(grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,103,FOLLOW_2); 
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
    // InternalSymg.g:5798:1: rule__Interval__Group_1__1 : rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 ;
    public final void rule__Interval__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5802:1: ( rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 )
            // InternalSymg.g:5803:2: rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2
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
    // InternalSymg.g:5810:1: rule__Interval__Group_1__1__Impl : ( ( rule__Interval__StartAssignment_1_1 ) ) ;
    public final void rule__Interval__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5814:1: ( ( ( rule__Interval__StartAssignment_1_1 ) ) )
            // InternalSymg.g:5815:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            {
            // InternalSymg.g:5815:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            // InternalSymg.g:5816:2: ( rule__Interval__StartAssignment_1_1 )
            {
             before(grammarAccess.getIntervalAccess().getStartAssignment_1_1()); 
            // InternalSymg.g:5817:2: ( rule__Interval__StartAssignment_1_1 )
            // InternalSymg.g:5817:3: rule__Interval__StartAssignment_1_1
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
    // InternalSymg.g:5825:1: rule__Interval__Group_1__2 : rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 ;
    public final void rule__Interval__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5829:1: ( rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 )
            // InternalSymg.g:5830:2: rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3
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
    // InternalSymg.g:5837:1: rule__Interval__Group_1__2__Impl : ( ',' ) ;
    public final void rule__Interval__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5841:1: ( ( ',' ) )
            // InternalSymg.g:5842:1: ( ',' )
            {
            // InternalSymg.g:5842:1: ( ',' )
            // InternalSymg.g:5843:2: ','
            {
             before(grammarAccess.getIntervalAccess().getCommaKeyword_1_2()); 
            match(input,82,FOLLOW_2); 
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
    // InternalSymg.g:5852:1: rule__Interval__Group_1__3 : rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 ;
    public final void rule__Interval__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5856:1: ( rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 )
            // InternalSymg.g:5857:2: rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4
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
    // InternalSymg.g:5864:1: rule__Interval__Group_1__3__Impl : ( ( rule__Interval__EndAssignment_1_3 ) ) ;
    public final void rule__Interval__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5868:1: ( ( ( rule__Interval__EndAssignment_1_3 ) ) )
            // InternalSymg.g:5869:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            {
            // InternalSymg.g:5869:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            // InternalSymg.g:5870:2: ( rule__Interval__EndAssignment_1_3 )
            {
             before(grammarAccess.getIntervalAccess().getEndAssignment_1_3()); 
            // InternalSymg.g:5871:2: ( rule__Interval__EndAssignment_1_3 )
            // InternalSymg.g:5871:3: rule__Interval__EndAssignment_1_3
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
    // InternalSymg.g:5879:1: rule__Interval__Group_1__4 : rule__Interval__Group_1__4__Impl ;
    public final void rule__Interval__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5883:1: ( rule__Interval__Group_1__4__Impl )
            // InternalSymg.g:5884:2: rule__Interval__Group_1__4__Impl
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
    // InternalSymg.g:5890:1: rule__Interval__Group_1__4__Impl : ( ']' ) ;
    public final void rule__Interval__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5894:1: ( ( ']' ) )
            // InternalSymg.g:5895:1: ( ']' )
            {
            // InternalSymg.g:5895:1: ( ']' )
            // InternalSymg.g:5896:2: ']'
            {
             before(grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_1_4()); 
            match(input,104,FOLLOW_2); 
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


    // $ANTLR start "rule__Interval__Group_3__0"
    // InternalSymg.g:5906:1: rule__Interval__Group_3__0 : rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1 ;
    public final void rule__Interval__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5910:1: ( rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1 )
            // InternalSymg.g:5911:2: rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1
            {
            pushFollow(FOLLOW_34);
            rule__Interval__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_3__1();

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
    // $ANTLR end "rule__Interval__Group_3__0"


    // $ANTLR start "rule__Interval__Group_3__0__Impl"
    // InternalSymg.g:5918:1: rule__Interval__Group_3__0__Impl : ( ( rule__Interval__SituationNameAssignment_3_0 ) ) ;
    public final void rule__Interval__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5922:1: ( ( ( rule__Interval__SituationNameAssignment_3_0 ) ) )
            // InternalSymg.g:5923:1: ( ( rule__Interval__SituationNameAssignment_3_0 ) )
            {
            // InternalSymg.g:5923:1: ( ( rule__Interval__SituationNameAssignment_3_0 ) )
            // InternalSymg.g:5924:2: ( rule__Interval__SituationNameAssignment_3_0 )
            {
             before(grammarAccess.getIntervalAccess().getSituationNameAssignment_3_0()); 
            // InternalSymg.g:5925:2: ( rule__Interval__SituationNameAssignment_3_0 )
            // InternalSymg.g:5925:3: rule__Interval__SituationNameAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Interval__SituationNameAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getSituationNameAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_3__0__Impl"


    // $ANTLR start "rule__Interval__Group_3__1"
    // InternalSymg.g:5933:1: rule__Interval__Group_3__1 : rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2 ;
    public final void rule__Interval__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5937:1: ( rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2 )
            // InternalSymg.g:5938:2: rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2
            {
            pushFollow(FOLLOW_35);
            rule__Interval__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_3__2();

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
    // $ANTLR end "rule__Interval__Group_3__1"


    // $ANTLR start "rule__Interval__Group_3__1__Impl"
    // InternalSymg.g:5945:1: rule__Interval__Group_3__1__Impl : ( ( rule__Interval__TempOpAssignment_3_1 ) ) ;
    public final void rule__Interval__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5949:1: ( ( ( rule__Interval__TempOpAssignment_3_1 ) ) )
            // InternalSymg.g:5950:1: ( ( rule__Interval__TempOpAssignment_3_1 ) )
            {
            // InternalSymg.g:5950:1: ( ( rule__Interval__TempOpAssignment_3_1 ) )
            // InternalSymg.g:5951:2: ( rule__Interval__TempOpAssignment_3_1 )
            {
             before(grammarAccess.getIntervalAccess().getTempOpAssignment_3_1()); 
            // InternalSymg.g:5952:2: ( rule__Interval__TempOpAssignment_3_1 )
            // InternalSymg.g:5952:3: rule__Interval__TempOpAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Interval__TempOpAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getTempOpAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_3__1__Impl"


    // $ANTLR start "rule__Interval__Group_3__2"
    // InternalSymg.g:5960:1: rule__Interval__Group_3__2 : rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3 ;
    public final void rule__Interval__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5964:1: ( rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3 )
            // InternalSymg.g:5965:2: rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3
            {
            pushFollow(FOLLOW_36);
            rule__Interval__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Interval__Group_3__3();

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
    // $ANTLR end "rule__Interval__Group_3__2"


    // $ANTLR start "rule__Interval__Group_3__2__Impl"
    // InternalSymg.g:5972:1: rule__Interval__Group_3__2__Impl : ( ( rule__Interval__IntConstAssignment_3_2 ) ) ;
    public final void rule__Interval__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5976:1: ( ( ( rule__Interval__IntConstAssignment_3_2 ) ) )
            // InternalSymg.g:5977:1: ( ( rule__Interval__IntConstAssignment_3_2 ) )
            {
            // InternalSymg.g:5977:1: ( ( rule__Interval__IntConstAssignment_3_2 ) )
            // InternalSymg.g:5978:2: ( rule__Interval__IntConstAssignment_3_2 )
            {
             before(grammarAccess.getIntervalAccess().getIntConstAssignment_3_2()); 
            // InternalSymg.g:5979:2: ( rule__Interval__IntConstAssignment_3_2 )
            // InternalSymg.g:5979:3: rule__Interval__IntConstAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Interval__IntConstAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getIntConstAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_3__2__Impl"


    // $ANTLR start "rule__Interval__Group_3__3"
    // InternalSymg.g:5987:1: rule__Interval__Group_3__3 : rule__Interval__Group_3__3__Impl ;
    public final void rule__Interval__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5991:1: ( rule__Interval__Group_3__3__Impl )
            // InternalSymg.g:5992:2: rule__Interval__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Interval__Group_3__3__Impl();

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
    // $ANTLR end "rule__Interval__Group_3__3"


    // $ANTLR start "rule__Interval__Group_3__3__Impl"
    // InternalSymg.g:5998:1: rule__Interval__Group_3__3__Impl : ( ( rule__Interval__UnitAssignment_3_3 ) ) ;
    public final void rule__Interval__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6002:1: ( ( ( rule__Interval__UnitAssignment_3_3 ) ) )
            // InternalSymg.g:6003:1: ( ( rule__Interval__UnitAssignment_3_3 ) )
            {
            // InternalSymg.g:6003:1: ( ( rule__Interval__UnitAssignment_3_3 ) )
            // InternalSymg.g:6004:2: ( rule__Interval__UnitAssignment_3_3 )
            {
             before(grammarAccess.getIntervalAccess().getUnitAssignment_3_3()); 
            // InternalSymg.g:6005:2: ( rule__Interval__UnitAssignment_3_3 )
            // InternalSymg.g:6005:3: rule__Interval__UnitAssignment_3_3
            {
            pushFollow(FOLLOW_2);
            rule__Interval__UnitAssignment_3_3();

            state._fsp--;


            }

             after(grammarAccess.getIntervalAccess().getUnitAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__Group_3__3__Impl"


    // $ANTLR start "rule__IntConst__Group__0"
    // InternalSymg.g:6014:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6018:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // InternalSymg.g:6019:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalSymg.g:6026:1: rule__IntConst__Group__0__Impl : ( () ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6030:1: ( ( () ) )
            // InternalSymg.g:6031:1: ( () )
            {
            // InternalSymg.g:6031:1: ( () )
            // InternalSymg.g:6032:2: ()
            {
             before(grammarAccess.getIntConstAccess().getIntConstAction_0()); 
            // InternalSymg.g:6033:2: ()
            // InternalSymg.g:6033:3: 
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
    // InternalSymg.g:6041:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6045:1: ( rule__IntConst__Group__1__Impl )
            // InternalSymg.g:6046:2: rule__IntConst__Group__1__Impl
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
    // InternalSymg.g:6052:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__TypeAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6056:1: ( ( ( rule__IntConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6057:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6057:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            // InternalSymg.g:6058:2: ( rule__IntConst__TypeAssignment_1 )
            {
             before(grammarAccess.getIntConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6059:2: ( rule__IntConst__TypeAssignment_1 )
            // InternalSymg.g:6059:3: rule__IntConst__TypeAssignment_1
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


    // $ANTLR start "rule__Point__Group_3__0"
    // InternalSymg.g:6068:1: rule__Point__Group_3__0 : rule__Point__Group_3__0__Impl rule__Point__Group_3__1 ;
    public final void rule__Point__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6072:1: ( rule__Point__Group_3__0__Impl rule__Point__Group_3__1 )
            // InternalSymg.g:6073:2: rule__Point__Group_3__0__Impl rule__Point__Group_3__1
            {
            pushFollow(FOLLOW_36);
            rule__Point__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Point__Group_3__1();

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
    // $ANTLR end "rule__Point__Group_3__0"


    // $ANTLR start "rule__Point__Group_3__0__Impl"
    // InternalSymg.g:6080:1: rule__Point__Group_3__0__Impl : ( ( rule__Point__PointConstAssignment_3_0 ) ) ;
    public final void rule__Point__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6084:1: ( ( ( rule__Point__PointConstAssignment_3_0 ) ) )
            // InternalSymg.g:6085:1: ( ( rule__Point__PointConstAssignment_3_0 ) )
            {
            // InternalSymg.g:6085:1: ( ( rule__Point__PointConstAssignment_3_0 ) )
            // InternalSymg.g:6086:2: ( rule__Point__PointConstAssignment_3_0 )
            {
             before(grammarAccess.getPointAccess().getPointConstAssignment_3_0()); 
            // InternalSymg.g:6087:2: ( rule__Point__PointConstAssignment_3_0 )
            // InternalSymg.g:6087:3: rule__Point__PointConstAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Point__PointConstAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getPointAccess().getPointConstAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__Group_3__0__Impl"


    // $ANTLR start "rule__Point__Group_3__1"
    // InternalSymg.g:6095:1: rule__Point__Group_3__1 : rule__Point__Group_3__1__Impl rule__Point__Group_3__2 ;
    public final void rule__Point__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6099:1: ( rule__Point__Group_3__1__Impl rule__Point__Group_3__2 )
            // InternalSymg.g:6100:2: rule__Point__Group_3__1__Impl rule__Point__Group_3__2
            {
            pushFollow(FOLLOW_34);
            rule__Point__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Point__Group_3__2();

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
    // $ANTLR end "rule__Point__Group_3__1"


    // $ANTLR start "rule__Point__Group_3__1__Impl"
    // InternalSymg.g:6107:1: rule__Point__Group_3__1__Impl : ( ( rule__Point__UnitAssignment_3_1 ) ) ;
    public final void rule__Point__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6111:1: ( ( ( rule__Point__UnitAssignment_3_1 ) ) )
            // InternalSymg.g:6112:1: ( ( rule__Point__UnitAssignment_3_1 ) )
            {
            // InternalSymg.g:6112:1: ( ( rule__Point__UnitAssignment_3_1 ) )
            // InternalSymg.g:6113:2: ( rule__Point__UnitAssignment_3_1 )
            {
             before(grammarAccess.getPointAccess().getUnitAssignment_3_1()); 
            // InternalSymg.g:6114:2: ( rule__Point__UnitAssignment_3_1 )
            // InternalSymg.g:6114:3: rule__Point__UnitAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Point__UnitAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getPointAccess().getUnitAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__Group_3__1__Impl"


    // $ANTLR start "rule__Point__Group_3__2"
    // InternalSymg.g:6122:1: rule__Point__Group_3__2 : rule__Point__Group_3__2__Impl rule__Point__Group_3__3 ;
    public final void rule__Point__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6126:1: ( rule__Point__Group_3__2__Impl rule__Point__Group_3__3 )
            // InternalSymg.g:6127:2: rule__Point__Group_3__2__Impl rule__Point__Group_3__3
            {
            pushFollow(FOLLOW_28);
            rule__Point__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Point__Group_3__3();

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
    // $ANTLR end "rule__Point__Group_3__2"


    // $ANTLR start "rule__Point__Group_3__2__Impl"
    // InternalSymg.g:6134:1: rule__Point__Group_3__2__Impl : ( ( rule__Point__TempOpAssignment_3_2 ) ) ;
    public final void rule__Point__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6138:1: ( ( ( rule__Point__TempOpAssignment_3_2 ) ) )
            // InternalSymg.g:6139:1: ( ( rule__Point__TempOpAssignment_3_2 ) )
            {
            // InternalSymg.g:6139:1: ( ( rule__Point__TempOpAssignment_3_2 ) )
            // InternalSymg.g:6140:2: ( rule__Point__TempOpAssignment_3_2 )
            {
             before(grammarAccess.getPointAccess().getTempOpAssignment_3_2()); 
            // InternalSymg.g:6141:2: ( rule__Point__TempOpAssignment_3_2 )
            // InternalSymg.g:6141:3: rule__Point__TempOpAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Point__TempOpAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getPointAccess().getTempOpAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__Group_3__2__Impl"


    // $ANTLR start "rule__Point__Group_3__3"
    // InternalSymg.g:6149:1: rule__Point__Group_3__3 : rule__Point__Group_3__3__Impl ;
    public final void rule__Point__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6153:1: ( rule__Point__Group_3__3__Impl )
            // InternalSymg.g:6154:2: rule__Point__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Point__Group_3__3__Impl();

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
    // $ANTLR end "rule__Point__Group_3__3"


    // $ANTLR start "rule__Point__Group_3__3__Impl"
    // InternalSymg.g:6160:1: rule__Point__Group_3__3__Impl : ( ( rule__Point__EventNameAssignment_3_3 ) ) ;
    public final void rule__Point__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6164:1: ( ( ( rule__Point__EventNameAssignment_3_3 ) ) )
            // InternalSymg.g:6165:1: ( ( rule__Point__EventNameAssignment_3_3 ) )
            {
            // InternalSymg.g:6165:1: ( ( rule__Point__EventNameAssignment_3_3 ) )
            // InternalSymg.g:6166:2: ( rule__Point__EventNameAssignment_3_3 )
            {
             before(grammarAccess.getPointAccess().getEventNameAssignment_3_3()); 
            // InternalSymg.g:6167:2: ( rule__Point__EventNameAssignment_3_3 )
            // InternalSymg.g:6167:3: rule__Point__EventNameAssignment_3_3
            {
            pushFollow(FOLLOW_2);
            rule__Point__EventNameAssignment_3_3();

            state._fsp--;


            }

             after(grammarAccess.getPointAccess().getEventNameAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__Group_3__3__Impl"


    // $ANTLR start "rule__PEvent__Group__0"
    // InternalSymg.g:6176:1: rule__PEvent__Group__0 : rule__PEvent__Group__0__Impl rule__PEvent__Group__1 ;
    public final void rule__PEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6180:1: ( rule__PEvent__Group__0__Impl rule__PEvent__Group__1 )
            // InternalSymg.g:6181:2: rule__PEvent__Group__0__Impl rule__PEvent__Group__1
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
    // InternalSymg.g:6188:1: rule__PEvent__Group__0__Impl : ( ( rule__PEvent__PowEventAssignment_0 ) ) ;
    public final void rule__PEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6192:1: ( ( ( rule__PEvent__PowEventAssignment_0 ) ) )
            // InternalSymg.g:6193:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            {
            // InternalSymg.g:6193:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            // InternalSymg.g:6194:2: ( rule__PEvent__PowEventAssignment_0 )
            {
             before(grammarAccess.getPEventAccess().getPowEventAssignment_0()); 
            // InternalSymg.g:6195:2: ( rule__PEvent__PowEventAssignment_0 )
            // InternalSymg.g:6195:3: rule__PEvent__PowEventAssignment_0
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
    // InternalSymg.g:6203:1: rule__PEvent__Group__1 : rule__PEvent__Group__1__Impl rule__PEvent__Group__2 ;
    public final void rule__PEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6207:1: ( rule__PEvent__Group__1__Impl rule__PEvent__Group__2 )
            // InternalSymg.g:6208:2: rule__PEvent__Group__1__Impl rule__PEvent__Group__2
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
    // InternalSymg.g:6215:1: rule__PEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__PEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6219:1: ( ( '(' ) )
            // InternalSymg.g:6220:1: ( '(' )
            {
            // InternalSymg.g:6220:1: ( '(' )
            // InternalSymg.g:6221:2: '('
            {
             before(grammarAccess.getPEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6230:1: rule__PEvent__Group__2 : rule__PEvent__Group__2__Impl rule__PEvent__Group__3 ;
    public final void rule__PEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6234:1: ( rule__PEvent__Group__2__Impl rule__PEvent__Group__3 )
            // InternalSymg.g:6235:2: rule__PEvent__Group__2__Impl rule__PEvent__Group__3
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
    // InternalSymg.g:6242:1: rule__PEvent__Group__2__Impl : ( ( rule__PEvent__PowNameAssignment_2 ) ) ;
    public final void rule__PEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6246:1: ( ( ( rule__PEvent__PowNameAssignment_2 ) ) )
            // InternalSymg.g:6247:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:6247:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            // InternalSymg.g:6248:2: ( rule__PEvent__PowNameAssignment_2 )
            {
             before(grammarAccess.getPEventAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:6249:2: ( rule__PEvent__PowNameAssignment_2 )
            // InternalSymg.g:6249:3: rule__PEvent__PowNameAssignment_2
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
    // InternalSymg.g:6257:1: rule__PEvent__Group__3 : rule__PEvent__Group__3__Impl ;
    public final void rule__PEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6261:1: ( rule__PEvent__Group__3__Impl )
            // InternalSymg.g:6262:2: rule__PEvent__Group__3__Impl
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
    // InternalSymg.g:6268:1: rule__PEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__PEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6272:1: ( ( ')' ) )
            // InternalSymg.g:6273:1: ( ')' )
            {
            // InternalSymg.g:6273:1: ( ')' )
            // InternalSymg.g:6274:2: ')'
            {
             before(grammarAccess.getPEventAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6284:1: rule__CEvent__Group__0 : rule__CEvent__Group__0__Impl rule__CEvent__Group__1 ;
    public final void rule__CEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6288:1: ( rule__CEvent__Group__0__Impl rule__CEvent__Group__1 )
            // InternalSymg.g:6289:2: rule__CEvent__Group__0__Impl rule__CEvent__Group__1
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
    // InternalSymg.g:6296:1: rule__CEvent__Group__0__Impl : ( ( rule__CEvent__ContrEventAssignment_0 ) ) ;
    public final void rule__CEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6300:1: ( ( ( rule__CEvent__ContrEventAssignment_0 ) ) )
            // InternalSymg.g:6301:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            {
            // InternalSymg.g:6301:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            // InternalSymg.g:6302:2: ( rule__CEvent__ContrEventAssignment_0 )
            {
             before(grammarAccess.getCEventAccess().getContrEventAssignment_0()); 
            // InternalSymg.g:6303:2: ( rule__CEvent__ContrEventAssignment_0 )
            // InternalSymg.g:6303:3: rule__CEvent__ContrEventAssignment_0
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
    // InternalSymg.g:6311:1: rule__CEvent__Group__1 : rule__CEvent__Group__1__Impl rule__CEvent__Group__2 ;
    public final void rule__CEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6315:1: ( rule__CEvent__Group__1__Impl rule__CEvent__Group__2 )
            // InternalSymg.g:6316:2: rule__CEvent__Group__1__Impl rule__CEvent__Group__2
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
    // InternalSymg.g:6323:1: rule__CEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__CEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6327:1: ( ( '(' ) )
            // InternalSymg.g:6328:1: ( '(' )
            {
            // InternalSymg.g:6328:1: ( '(' )
            // InternalSymg.g:6329:2: '('
            {
             before(grammarAccess.getCEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6338:1: rule__CEvent__Group__2 : rule__CEvent__Group__2__Impl rule__CEvent__Group__3 ;
    public final void rule__CEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6342:1: ( rule__CEvent__Group__2__Impl rule__CEvent__Group__3 )
            // InternalSymg.g:6343:2: rule__CEvent__Group__2__Impl rule__CEvent__Group__3
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
    // InternalSymg.g:6350:1: rule__CEvent__Group__2__Impl : ( ( rule__CEvent__ContrNameAssignment_2 ) ) ;
    public final void rule__CEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6354:1: ( ( ( rule__CEvent__ContrNameAssignment_2 ) ) )
            // InternalSymg.g:6355:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            {
            // InternalSymg.g:6355:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            // InternalSymg.g:6356:2: ( rule__CEvent__ContrNameAssignment_2 )
            {
             before(grammarAccess.getCEventAccess().getContrNameAssignment_2()); 
            // InternalSymg.g:6357:2: ( rule__CEvent__ContrNameAssignment_2 )
            // InternalSymg.g:6357:3: rule__CEvent__ContrNameAssignment_2
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
    // InternalSymg.g:6365:1: rule__CEvent__Group__3 : rule__CEvent__Group__3__Impl ;
    public final void rule__CEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6369:1: ( rule__CEvent__Group__3__Impl )
            // InternalSymg.g:6370:2: rule__CEvent__Group__3__Impl
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
    // InternalSymg.g:6376:1: rule__CEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__CEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6380:1: ( ( ')' ) )
            // InternalSymg.g:6381:1: ( ')' )
            {
            // InternalSymg.g:6381:1: ( ')' )
            // InternalSymg.g:6382:2: ')'
            {
             before(grammarAccess.getCEventAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6392:1: rule__OEvent__Group__0 : rule__OEvent__Group__0__Impl rule__OEvent__Group__1 ;
    public final void rule__OEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6396:1: ( rule__OEvent__Group__0__Impl rule__OEvent__Group__1 )
            // InternalSymg.g:6397:2: rule__OEvent__Group__0__Impl rule__OEvent__Group__1
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
    // InternalSymg.g:6404:1: rule__OEvent__Group__0__Impl : ( ( rule__OEvent__OblEventAssignment_0 ) ) ;
    public final void rule__OEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6408:1: ( ( ( rule__OEvent__OblEventAssignment_0 ) ) )
            // InternalSymg.g:6409:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            {
            // InternalSymg.g:6409:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            // InternalSymg.g:6410:2: ( rule__OEvent__OblEventAssignment_0 )
            {
             before(grammarAccess.getOEventAccess().getOblEventAssignment_0()); 
            // InternalSymg.g:6411:2: ( rule__OEvent__OblEventAssignment_0 )
            // InternalSymg.g:6411:3: rule__OEvent__OblEventAssignment_0
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
    // InternalSymg.g:6419:1: rule__OEvent__Group__1 : rule__OEvent__Group__1__Impl rule__OEvent__Group__2 ;
    public final void rule__OEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6423:1: ( rule__OEvent__Group__1__Impl rule__OEvent__Group__2 )
            // InternalSymg.g:6424:2: rule__OEvent__Group__1__Impl rule__OEvent__Group__2
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
    // InternalSymg.g:6431:1: rule__OEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__OEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6435:1: ( ( '(' ) )
            // InternalSymg.g:6436:1: ( '(' )
            {
            // InternalSymg.g:6436:1: ( '(' )
            // InternalSymg.g:6437:2: '('
            {
             before(grammarAccess.getOEventAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6446:1: rule__OEvent__Group__2 : rule__OEvent__Group__2__Impl rule__OEvent__Group__3 ;
    public final void rule__OEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6450:1: ( rule__OEvent__Group__2__Impl rule__OEvent__Group__3 )
            // InternalSymg.g:6451:2: rule__OEvent__Group__2__Impl rule__OEvent__Group__3
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
    // InternalSymg.g:6458:1: rule__OEvent__Group__2__Impl : ( ( rule__OEvent__OblNameAssignment_2 ) ) ;
    public final void rule__OEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6462:1: ( ( ( rule__OEvent__OblNameAssignment_2 ) ) )
            // InternalSymg.g:6463:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:6463:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            // InternalSymg.g:6464:2: ( rule__OEvent__OblNameAssignment_2 )
            {
             before(grammarAccess.getOEventAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:6465:2: ( rule__OEvent__OblNameAssignment_2 )
            // InternalSymg.g:6465:3: rule__OEvent__OblNameAssignment_2
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
    // InternalSymg.g:6473:1: rule__OEvent__Group__3 : rule__OEvent__Group__3__Impl ;
    public final void rule__OEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6477:1: ( rule__OEvent__Group__3__Impl )
            // InternalSymg.g:6478:2: rule__OEvent__Group__3__Impl
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
    // InternalSymg.g:6484:1: rule__OEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__OEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6488:1: ( ( ')' ) )
            // InternalSymg.g:6489:1: ( ')' )
            {
            // InternalSymg.g:6489:1: ( ')' )
            // InternalSymg.g:6490:2: ')'
            {
             before(grammarAccess.getOEventAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6500:1: rule__PointConst__Group__0 : rule__PointConst__Group__0__Impl rule__PointConst__Group__1 ;
    public final void rule__PointConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6504:1: ( rule__PointConst__Group__0__Impl rule__PointConst__Group__1 )
            // InternalSymg.g:6505:2: rule__PointConst__Group__0__Impl rule__PointConst__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalSymg.g:6512:1: rule__PointConst__Group__0__Impl : ( () ) ;
    public final void rule__PointConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6516:1: ( ( () ) )
            // InternalSymg.g:6517:1: ( () )
            {
            // InternalSymg.g:6517:1: ( () )
            // InternalSymg.g:6518:2: ()
            {
             before(grammarAccess.getPointConstAccess().getPointConstAction_0()); 
            // InternalSymg.g:6519:2: ()
            // InternalSymg.g:6519:3: 
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
    // InternalSymg.g:6527:1: rule__PointConst__Group__1 : rule__PointConst__Group__1__Impl ;
    public final void rule__PointConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6531:1: ( rule__PointConst__Group__1__Impl )
            // InternalSymg.g:6532:2: rule__PointConst__Group__1__Impl
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
    // InternalSymg.g:6538:1: rule__PointConst__Group__1__Impl : ( ( rule__PointConst__TypeAssignment_1 ) ) ;
    public final void rule__PointConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6542:1: ( ( ( rule__PointConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6543:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6543:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            // InternalSymg.g:6544:2: ( rule__PointConst__TypeAssignment_1 )
            {
             before(grammarAccess.getPointConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6545:2: ( rule__PointConst__TypeAssignment_1 )
            // InternalSymg.g:6545:3: rule__PointConst__TypeAssignment_1
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
    // InternalSymg.g:6554:1: rule__OState__Group__0 : rule__OState__Group__0__Impl rule__OState__Group__1 ;
    public final void rule__OState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6558:1: ( rule__OState__Group__0__Impl rule__OState__Group__1 )
            // InternalSymg.g:6559:2: rule__OState__Group__0__Impl rule__OState__Group__1
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
    // InternalSymg.g:6566:1: rule__OState__Group__0__Impl : ( ( rule__OState__OblStateAssignment_0 ) ) ;
    public final void rule__OState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6570:1: ( ( ( rule__OState__OblStateAssignment_0 ) ) )
            // InternalSymg.g:6571:1: ( ( rule__OState__OblStateAssignment_0 ) )
            {
            // InternalSymg.g:6571:1: ( ( rule__OState__OblStateAssignment_0 ) )
            // InternalSymg.g:6572:2: ( rule__OState__OblStateAssignment_0 )
            {
             before(grammarAccess.getOStateAccess().getOblStateAssignment_0()); 
            // InternalSymg.g:6573:2: ( rule__OState__OblStateAssignment_0 )
            // InternalSymg.g:6573:3: rule__OState__OblStateAssignment_0
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
    // InternalSymg.g:6581:1: rule__OState__Group__1 : rule__OState__Group__1__Impl rule__OState__Group__2 ;
    public final void rule__OState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6585:1: ( rule__OState__Group__1__Impl rule__OState__Group__2 )
            // InternalSymg.g:6586:2: rule__OState__Group__1__Impl rule__OState__Group__2
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
    // InternalSymg.g:6593:1: rule__OState__Group__1__Impl : ( '(' ) ;
    public final void rule__OState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6597:1: ( ( '(' ) )
            // InternalSymg.g:6598:1: ( '(' )
            {
            // InternalSymg.g:6598:1: ( '(' )
            // InternalSymg.g:6599:2: '('
            {
             before(grammarAccess.getOStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6608:1: rule__OState__Group__2 : rule__OState__Group__2__Impl rule__OState__Group__3 ;
    public final void rule__OState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6612:1: ( rule__OState__Group__2__Impl rule__OState__Group__3 )
            // InternalSymg.g:6613:2: rule__OState__Group__2__Impl rule__OState__Group__3
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
    // InternalSymg.g:6620:1: rule__OState__Group__2__Impl : ( ( rule__OState__OblNameAssignment_2 ) ) ;
    public final void rule__OState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6624:1: ( ( ( rule__OState__OblNameAssignment_2 ) ) )
            // InternalSymg.g:6625:1: ( ( rule__OState__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:6625:1: ( ( rule__OState__OblNameAssignment_2 ) )
            // InternalSymg.g:6626:2: ( rule__OState__OblNameAssignment_2 )
            {
             before(grammarAccess.getOStateAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:6627:2: ( rule__OState__OblNameAssignment_2 )
            // InternalSymg.g:6627:3: rule__OState__OblNameAssignment_2
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
    // InternalSymg.g:6635:1: rule__OState__Group__3 : rule__OState__Group__3__Impl ;
    public final void rule__OState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6639:1: ( rule__OState__Group__3__Impl )
            // InternalSymg.g:6640:2: rule__OState__Group__3__Impl
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
    // InternalSymg.g:6646:1: rule__OState__Group__3__Impl : ( ')' ) ;
    public final void rule__OState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6650:1: ( ( ')' ) )
            // InternalSymg.g:6651:1: ( ')' )
            {
            // InternalSymg.g:6651:1: ( ')' )
            // InternalSymg.g:6652:2: ')'
            {
             before(grammarAccess.getOStateAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6662:1: rule__CState__Group__0 : rule__CState__Group__0__Impl rule__CState__Group__1 ;
    public final void rule__CState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6666:1: ( rule__CState__Group__0__Impl rule__CState__Group__1 )
            // InternalSymg.g:6667:2: rule__CState__Group__0__Impl rule__CState__Group__1
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
    // InternalSymg.g:6674:1: rule__CState__Group__0__Impl : ( ( rule__CState__ContrStateAssignment_0 ) ) ;
    public final void rule__CState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6678:1: ( ( ( rule__CState__ContrStateAssignment_0 ) ) )
            // InternalSymg.g:6679:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            {
            // InternalSymg.g:6679:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            // InternalSymg.g:6680:2: ( rule__CState__ContrStateAssignment_0 )
            {
             before(grammarAccess.getCStateAccess().getContrStateAssignment_0()); 
            // InternalSymg.g:6681:2: ( rule__CState__ContrStateAssignment_0 )
            // InternalSymg.g:6681:3: rule__CState__ContrStateAssignment_0
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
    // InternalSymg.g:6689:1: rule__CState__Group__1 : rule__CState__Group__1__Impl rule__CState__Group__2 ;
    public final void rule__CState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6693:1: ( rule__CState__Group__1__Impl rule__CState__Group__2 )
            // InternalSymg.g:6694:2: rule__CState__Group__1__Impl rule__CState__Group__2
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
    // InternalSymg.g:6701:1: rule__CState__Group__1__Impl : ( '(' ) ;
    public final void rule__CState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6705:1: ( ( '(' ) )
            // InternalSymg.g:6706:1: ( '(' )
            {
            // InternalSymg.g:6706:1: ( '(' )
            // InternalSymg.g:6707:2: '('
            {
             before(grammarAccess.getCStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6716:1: rule__CState__Group__2 : rule__CState__Group__2__Impl rule__CState__Group__3 ;
    public final void rule__CState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6720:1: ( rule__CState__Group__2__Impl rule__CState__Group__3 )
            // InternalSymg.g:6721:2: rule__CState__Group__2__Impl rule__CState__Group__3
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
    // InternalSymg.g:6728:1: rule__CState__Group__2__Impl : ( ( rule__CState__ContractNameAssignment_2 ) ) ;
    public final void rule__CState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6732:1: ( ( ( rule__CState__ContractNameAssignment_2 ) ) )
            // InternalSymg.g:6733:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            {
            // InternalSymg.g:6733:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            // InternalSymg.g:6734:2: ( rule__CState__ContractNameAssignment_2 )
            {
             before(grammarAccess.getCStateAccess().getContractNameAssignment_2()); 
            // InternalSymg.g:6735:2: ( rule__CState__ContractNameAssignment_2 )
            // InternalSymg.g:6735:3: rule__CState__ContractNameAssignment_2
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
    // InternalSymg.g:6743:1: rule__CState__Group__3 : rule__CState__Group__3__Impl ;
    public final void rule__CState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6747:1: ( rule__CState__Group__3__Impl )
            // InternalSymg.g:6748:2: rule__CState__Group__3__Impl
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
    // InternalSymg.g:6754:1: rule__CState__Group__3__Impl : ( ')' ) ;
    public final void rule__CState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6758:1: ( ( ')' ) )
            // InternalSymg.g:6759:1: ( ')' )
            {
            // InternalSymg.g:6759:1: ( ')' )
            // InternalSymg.g:6760:2: ')'
            {
             before(grammarAccess.getCStateAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6770:1: rule__PState__Group__0 : rule__PState__Group__0__Impl rule__PState__Group__1 ;
    public final void rule__PState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6774:1: ( rule__PState__Group__0__Impl rule__PState__Group__1 )
            // InternalSymg.g:6775:2: rule__PState__Group__0__Impl rule__PState__Group__1
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
    // InternalSymg.g:6782:1: rule__PState__Group__0__Impl : ( ( rule__PState__PowStateAssignment_0 ) ) ;
    public final void rule__PState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6786:1: ( ( ( rule__PState__PowStateAssignment_0 ) ) )
            // InternalSymg.g:6787:1: ( ( rule__PState__PowStateAssignment_0 ) )
            {
            // InternalSymg.g:6787:1: ( ( rule__PState__PowStateAssignment_0 ) )
            // InternalSymg.g:6788:2: ( rule__PState__PowStateAssignment_0 )
            {
             before(grammarAccess.getPStateAccess().getPowStateAssignment_0()); 
            // InternalSymg.g:6789:2: ( rule__PState__PowStateAssignment_0 )
            // InternalSymg.g:6789:3: rule__PState__PowStateAssignment_0
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
    // InternalSymg.g:6797:1: rule__PState__Group__1 : rule__PState__Group__1__Impl rule__PState__Group__2 ;
    public final void rule__PState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6801:1: ( rule__PState__Group__1__Impl rule__PState__Group__2 )
            // InternalSymg.g:6802:2: rule__PState__Group__1__Impl rule__PState__Group__2
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
    // InternalSymg.g:6809:1: rule__PState__Group__1__Impl : ( '(' ) ;
    public final void rule__PState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6813:1: ( ( '(' ) )
            // InternalSymg.g:6814:1: ( '(' )
            {
            // InternalSymg.g:6814:1: ( '(' )
            // InternalSymg.g:6815:2: '('
            {
             before(grammarAccess.getPStateAccess().getLeftParenthesisKeyword_1()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:6824:1: rule__PState__Group__2 : rule__PState__Group__2__Impl rule__PState__Group__3 ;
    public final void rule__PState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6828:1: ( rule__PState__Group__2__Impl rule__PState__Group__3 )
            // InternalSymg.g:6829:2: rule__PState__Group__2__Impl rule__PState__Group__3
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
    // InternalSymg.g:6836:1: rule__PState__Group__2__Impl : ( ( rule__PState__PowNameAssignment_2 ) ) ;
    public final void rule__PState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6840:1: ( ( ( rule__PState__PowNameAssignment_2 ) ) )
            // InternalSymg.g:6841:1: ( ( rule__PState__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:6841:1: ( ( rule__PState__PowNameAssignment_2 ) )
            // InternalSymg.g:6842:2: ( rule__PState__PowNameAssignment_2 )
            {
             before(grammarAccess.getPStateAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:6843:2: ( rule__PState__PowNameAssignment_2 )
            // InternalSymg.g:6843:3: rule__PState__PowNameAssignment_2
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
    // InternalSymg.g:6851:1: rule__PState__Group__3 : rule__PState__Group__3__Impl ;
    public final void rule__PState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6855:1: ( rule__PState__Group__3__Impl )
            // InternalSymg.g:6856:2: rule__PState__Group__3__Impl
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
    // InternalSymg.g:6862:1: rule__PState__Group__3__Impl : ( ')' ) ;
    public final void rule__PState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6866:1: ( ( ')' ) )
            // InternalSymg.g:6867:1: ( ')' )
            {
            // InternalSymg.g:6867:1: ( ')' )
            // InternalSymg.g:6868:2: ')'
            {
             before(grammarAccess.getPStateAccess().getRightParenthesisKeyword_3()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:6878:1: rule__Model__DomainNameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__DomainNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6882:1: ( ( RULE_ID ) )
            // InternalSymg.g:6883:2: ( RULE_ID )
            {
            // InternalSymg.g:6883:2: ( RULE_ID )
            // InternalSymg.g:6884:3: RULE_ID
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
    // InternalSymg.g:6893:1: rule__Model__DomainConceptsAssignment_2_0 : ( ruleDomainConcept ) ;
    public final void rule__Model__DomainConceptsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6897:1: ( ( ruleDomainConcept ) )
            // InternalSymg.g:6898:2: ( ruleDomainConcept )
            {
            // InternalSymg.g:6898:2: ( ruleDomainConcept )
            // InternalSymg.g:6899:3: ruleDomainConcept
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
    // InternalSymg.g:6908:1: rule__Model__ContractNameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Model__ContractNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6912:1: ( ( RULE_ID ) )
            // InternalSymg.g:6913:2: ( RULE_ID )
            {
            // InternalSymg.g:6913:2: ( RULE_ID )
            // InternalSymg.g:6914:3: RULE_ID
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
    // InternalSymg.g:6923:1: rule__Model__ParametersAssignment_7_0 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6927:1: ( ( ruleParameter ) )
            // InternalSymg.g:6928:2: ( ruleParameter )
            {
            // InternalSymg.g:6928:2: ( ruleParameter )
            // InternalSymg.g:6929:3: ruleParameter
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
    // InternalSymg.g:6938:1: rule__Model__ParametersAssignment_8 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6942:1: ( ( ruleParameter ) )
            // InternalSymg.g:6943:2: ( ruleParameter )
            {
            // InternalSymg.g:6943:2: ( ruleParameter )
            // InternalSymg.g:6944:3: ruleParameter
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
    // InternalSymg.g:6953:1: rule__Model__DeclarationsAssignment_10_1_0 : ( ruleDeclar ) ;
    public final void rule__Model__DeclarationsAssignment_10_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6957:1: ( ( ruleDeclar ) )
            // InternalSymg.g:6958:2: ( ruleDeclar )
            {
            // InternalSymg.g:6958:2: ( ruleDeclar )
            // InternalSymg.g:6959:3: ruleDeclar
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
    // InternalSymg.g:6968:1: rule__Model__PreconditionsAssignment_11_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PreconditionsAssignment_11_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6972:1: ( ( ruleProposition ) )
            // InternalSymg.g:6973:2: ( ruleProposition )
            {
            // InternalSymg.g:6973:2: ( ruleProposition )
            // InternalSymg.g:6974:3: ruleProposition
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
    // InternalSymg.g:6983:1: rule__Model__PostconditionsAssignment_12_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PostconditionsAssignment_12_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6987:1: ( ( ruleProposition ) )
            // InternalSymg.g:6988:2: ( ruleProposition )
            {
            // InternalSymg.g:6988:2: ( ruleProposition )
            // InternalSymg.g:6989:3: ruleProposition
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
    // InternalSymg.g:6998:1: rule__Model__ObligationsAssignment_13_1_0 : ( ruleObligation ) ;
    public final void rule__Model__ObligationsAssignment_13_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7002:1: ( ( ruleObligation ) )
            // InternalSymg.g:7003:2: ( ruleObligation )
            {
            // InternalSymg.g:7003:2: ( ruleObligation )
            // InternalSymg.g:7004:3: ruleObligation
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
    // InternalSymg.g:7013:1: rule__Model__SobligationsAssignment_14_2_0 : ( ruleObligation ) ;
    public final void rule__Model__SobligationsAssignment_14_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7017:1: ( ( ruleObligation ) )
            // InternalSymg.g:7018:2: ( ruleObligation )
            {
            // InternalSymg.g:7018:2: ( ruleObligation )
            // InternalSymg.g:7019:3: ruleObligation
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
    // InternalSymg.g:7028:1: rule__Model__PowersAssignment_15_1_0 : ( rulePower ) ;
    public final void rule__Model__PowersAssignment_15_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7032:1: ( ( rulePower ) )
            // InternalSymg.g:7033:2: ( rulePower )
            {
            // InternalSymg.g:7033:2: ( rulePower )
            // InternalSymg.g:7034:3: rulePower
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
    // InternalSymg.g:7043:1: rule__Model__ConstraintsAssignment_16_1_0 : ( ruleProposition ) ;
    public final void rule__Model__ConstraintsAssignment_16_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7047:1: ( ( ruleProposition ) )
            // InternalSymg.g:7048:2: ( ruleProposition )
            {
            // InternalSymg.g:7048:2: ( ruleProposition )
            // InternalSymg.g:7049:3: ruleProposition
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
    // InternalSymg.g:7058:1: rule__Regular__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Regular__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7062:1: ( ( RULE_ID ) )
            // InternalSymg.g:7063:2: ( RULE_ID )
            {
            // InternalSymg.g:7063:2: ( RULE_ID )
            // InternalSymg.g:7064:3: RULE_ID
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
    // InternalSymg.g:7073:1: rule__Regular__ConceptTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Regular__ConceptTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7077:1: ( ( ruleCType ) )
            // InternalSymg.g:7078:2: ( ruleCType )
            {
            // InternalSymg.g:7078:2: ( ruleCType )
            // InternalSymg.g:7079:3: ruleCType
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
    // InternalSymg.g:7088:1: rule__Regular__AttributesAssignment_3_1_0 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7092:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7093:2: ( ruleAttribute )
            {
            // InternalSymg.g:7093:2: ( ruleAttribute )
            // InternalSymg.g:7094:3: ruleAttribute
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
    // InternalSymg.g:7103:1: rule__Regular__AttributesAssignment_3_2 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7107:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7108:2: ( ruleAttribute )
            {
            // InternalSymg.g:7108:2: ( ruleAttribute )
            // InternalSymg.g:7109:3: ruleAttribute
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
    // InternalSymg.g:7118:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7122:1: ( ( RULE_ID ) )
            // InternalSymg.g:7123:2: ( RULE_ID )
            {
            // InternalSymg.g:7123:2: ( RULE_ID )
            // InternalSymg.g:7124:3: RULE_ID
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
    // InternalSymg.g:7133:1: rule__Attribute__AttributeTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Attribute__AttributeTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7137:1: ( ( ruleCType ) )
            // InternalSymg.g:7138:2: ( ruleCType )
            {
            // InternalSymg.g:7138:2: ( ruleCType )
            // InternalSymg.g:7139:3: ruleCType
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
    // InternalSymg.g:7148:1: rule__Enumeration__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7152:1: ( ( RULE_ID ) )
            // InternalSymg.g:7153:2: ( RULE_ID )
            {
            // InternalSymg.g:7153:2: ( RULE_ID )
            // InternalSymg.g:7154:3: RULE_ID
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
    // InternalSymg.g:7163:1: rule__Enumeration__EnumerationItemsAssignment_4_0 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7167:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7168:2: ( ruleenumItem )
            {
            // InternalSymg.g:7168:2: ( ruleenumItem )
            // InternalSymg.g:7169:3: ruleenumItem
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
    // InternalSymg.g:7178:1: rule__Enumeration__EnumerationItemsAssignment_5 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7182:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7183:2: ( ruleenumItem )
            {
            // InternalSymg.g:7183:2: ( ruleenumItem )
            // InternalSymg.g:7184:3: ruleenumItem
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
    // InternalSymg.g:7193:1: rule__EnumItem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7197:1: ( ( RULE_ID ) )
            // InternalSymg.g:7198:2: ( RULE_ID )
            {
            // InternalSymg.g:7198:2: ( RULE_ID )
            // InternalSymg.g:7199:3: RULE_ID
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
    // InternalSymg.g:7208:1: rule__DomainType__SuperTypeAssignment : ( ( RULE_ID ) ) ;
    public final void rule__DomainType__SuperTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7212:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7213:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7213:2: ( ( RULE_ID ) )
            // InternalSymg.g:7214:3: ( RULE_ID )
            {
             before(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0()); 
            // InternalSymg.g:7215:3: ( RULE_ID )
            // InternalSymg.g:7216:4: RULE_ID
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
    // InternalSymg.g:7227:1: rule__BasicType__NameAssignment : ( ( rule__BasicType__NameAlternatives_0 ) ) ;
    public final void rule__BasicType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7231:1: ( ( ( rule__BasicType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7232:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7232:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            // InternalSymg.g:7233:3: ( rule__BasicType__NameAlternatives_0 )
            {
             before(grammarAccess.getBasicTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7234:3: ( rule__BasicType__NameAlternatives_0 )
            // InternalSymg.g:7234:4: rule__BasicType__NameAlternatives_0
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
    // InternalSymg.g:7242:1: rule__OntoCType__NameAssignment : ( ( rule__OntoCType__NameAlternatives_0 ) ) ;
    public final void rule__OntoCType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7246:1: ( ( ( rule__OntoCType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7247:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7247:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            // InternalSymg.g:7248:3: ( rule__OntoCType__NameAlternatives_0 )
            {
             before(grammarAccess.getOntoCTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7249:3: ( rule__OntoCType__NameAlternatives_0 )
            // InternalSymg.g:7249:4: rule__OntoCType__NameAlternatives_0
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
    // InternalSymg.g:7257:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7261:1: ( ( RULE_ID ) )
            // InternalSymg.g:7262:2: ( RULE_ID )
            {
            // InternalSymg.g:7262:2: ( RULE_ID )
            // InternalSymg.g:7263:3: RULE_ID
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
    // InternalSymg.g:7272:1: rule__Parameter__TypeAssignment_2 : ( ruleTypeName ) ;
    public final void rule__Parameter__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7276:1: ( ( ruleTypeName ) )
            // InternalSymg.g:7277:2: ( ruleTypeName )
            {
            // InternalSymg.g:7277:2: ( ruleTypeName )
            // InternalSymg.g:7278:3: ruleTypeName
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
    // InternalSymg.g:7287:1: rule__DeclarPair__AttrAssignment_0 : ( RULE_ID ) ;
    public final void rule__DeclarPair__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7291:1: ( ( RULE_ID ) )
            // InternalSymg.g:7292:2: ( RULE_ID )
            {
            // InternalSymg.g:7292:2: ( RULE_ID )
            // InternalSymg.g:7293:3: RULE_ID
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
    // InternalSymg.g:7302:1: rule__DeclarPair__ParamAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclarPair__ParamAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7306:1: ( ( RULE_ID ) )
            // InternalSymg.g:7307:2: ( RULE_ID )
            {
            // InternalSymg.g:7307:2: ( RULE_ID )
            // InternalSymg.g:7308:3: RULE_ID
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
    // InternalSymg.g:7317:1: rule__Declar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Declar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7321:1: ( ( RULE_ID ) )
            // InternalSymg.g:7322:2: ( RULE_ID )
            {
            // InternalSymg.g:7322:2: ( RULE_ID )
            // InternalSymg.g:7323:3: RULE_ID
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
    // InternalSymg.g:7332:1: rule__Declar__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Declar__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7336:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7337:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7337:2: ( ( RULE_ID ) )
            // InternalSymg.g:7338:3: ( RULE_ID )
            {
             before(grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0()); 
            // InternalSymg.g:7339:3: ( RULE_ID )
            // InternalSymg.g:7340:4: RULE_ID
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
    // InternalSymg.g:7351:1: rule__Declar__AttributesAssignment_4_0 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7355:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7356:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7356:2: ( ruleDeclarPair )
            // InternalSymg.g:7357:3: ruleDeclarPair
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
    // InternalSymg.g:7366:1: rule__Declar__AttributesAssignment_5 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7370:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7371:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7371:2: ( ruleDeclarPair )
            // InternalSymg.g:7372:3: ruleDeclarPair
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
    // InternalSymg.g:7381:1: rule__Obligation__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Obligation__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7385:1: ( ( RULE_ID ) )
            // InternalSymg.g:7386:2: ( RULE_ID )
            {
            // InternalSymg.g:7386:2: ( RULE_ID )
            // InternalSymg.g:7387:3: RULE_ID
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
    // InternalSymg.g:7396:1: rule__Obligation__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Obligation__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7400:1: ( ( ruleProposition ) )
            // InternalSymg.g:7401:2: ( ruleProposition )
            {
            // InternalSymg.g:7401:2: ( ruleProposition )
            // InternalSymg.g:7402:3: ruleProposition
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
    // InternalSymg.g:7411:1: rule__Obligation__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Obligation__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7415:1: ( ( RULE_ID ) )
            // InternalSymg.g:7416:2: ( RULE_ID )
            {
            // InternalSymg.g:7416:2: ( RULE_ID )
            // InternalSymg.g:7417:3: RULE_ID
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
    // InternalSymg.g:7426:1: rule__Obligation__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Obligation__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7430:1: ( ( RULE_ID ) )
            // InternalSymg.g:7431:2: ( RULE_ID )
            {
            // InternalSymg.g:7431:2: ( RULE_ID )
            // InternalSymg.g:7432:3: RULE_ID
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
    // InternalSymg.g:7441:1: rule__Obligation__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Obligation__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7445:1: ( ( ruleProposition ) )
            // InternalSymg.g:7446:2: ( ruleProposition )
            {
            // InternalSymg.g:7446:2: ( ruleProposition )
            // InternalSymg.g:7447:3: ruleProposition
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
    // InternalSymg.g:7456:1: rule__Obligation__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Obligation__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7460:1: ( ( ruleProposition ) )
            // InternalSymg.g:7461:2: ( ruleProposition )
            {
            // InternalSymg.g:7461:2: ( ruleProposition )
            // InternalSymg.g:7462:3: ruleProposition
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
    // InternalSymg.g:7471:1: rule__Power__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Power__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7475:1: ( ( RULE_ID ) )
            // InternalSymg.g:7476:2: ( RULE_ID )
            {
            // InternalSymg.g:7476:2: ( RULE_ID )
            // InternalSymg.g:7477:3: RULE_ID
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
    // InternalSymg.g:7486:1: rule__Power__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Power__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7490:1: ( ( ruleProposition ) )
            // InternalSymg.g:7491:2: ( ruleProposition )
            {
            // InternalSymg.g:7491:2: ( ruleProposition )
            // InternalSymg.g:7492:3: ruleProposition
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
    // InternalSymg.g:7501:1: rule__Power__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Power__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7505:1: ( ( RULE_ID ) )
            // InternalSymg.g:7506:2: ( RULE_ID )
            {
            // InternalSymg.g:7506:2: ( RULE_ID )
            // InternalSymg.g:7507:3: RULE_ID
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
    // InternalSymg.g:7516:1: rule__Power__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Power__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7520:1: ( ( RULE_ID ) )
            // InternalSymg.g:7521:2: ( RULE_ID )
            {
            // InternalSymg.g:7521:2: ( RULE_ID )
            // InternalSymg.g:7522:3: RULE_ID
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
    // InternalSymg.g:7531:1: rule__Power__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Power__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7535:1: ( ( ruleProposition ) )
            // InternalSymg.g:7536:2: ( ruleProposition )
            {
            // InternalSymg.g:7536:2: ( ruleProposition )
            // InternalSymg.g:7537:3: ruleProposition
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
    // InternalSymg.g:7546:1: rule__Power__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Power__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7550:1: ( ( ruleProposition ) )
            // InternalSymg.g:7551:2: ( ruleProposition )
            {
            // InternalSymg.g:7551:2: ( ruleProposition )
            // InternalSymg.g:7552:3: ruleProposition
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
    // InternalSymg.g:7561:1: rule__Proposition__JunctionsAssignment_0 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7565:1: ( ( ruleJunction ) )
            // InternalSymg.g:7566:2: ( ruleJunction )
            {
            // InternalSymg.g:7566:2: ( ruleJunction )
            // InternalSymg.g:7567:3: ruleJunction
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
    // InternalSymg.g:7576:1: rule__Proposition__JunctionsAssignment_1_1 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7580:1: ( ( ruleJunction ) )
            // InternalSymg.g:7581:2: ( ruleJunction )
            {
            // InternalSymg.g:7581:2: ( ruleJunction )
            // InternalSymg.g:7582:3: ruleJunction
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
    // InternalSymg.g:7591:1: rule__Junction__NegativeAtomsAssignment_0 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7595:1: ( ( ruleNegation ) )
            // InternalSymg.g:7596:2: ( ruleNegation )
            {
            // InternalSymg.g:7596:2: ( ruleNegation )
            // InternalSymg.g:7597:3: ruleNegation
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
    // InternalSymg.g:7606:1: rule__Junction__NegativeAtomsAssignment_1_1 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7610:1: ( ( ruleNegation ) )
            // InternalSymg.g:7611:2: ( ruleNegation )
            {
            // InternalSymg.g:7611:2: ( ruleNegation )
            // InternalSymg.g:7612:3: ruleNegation
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
    // InternalSymg.g:7621:1: rule__Negation__NegatedAssignment_0 : ( ( 'NOT' ) ) ;
    public final void rule__Negation__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7625:1: ( ( ( 'NOT' ) ) )
            // InternalSymg.g:7626:2: ( ( 'NOT' ) )
            {
            // InternalSymg.g:7626:2: ( ( 'NOT' ) )
            // InternalSymg.g:7627:3: ( 'NOT' )
            {
             before(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 
            // InternalSymg.g:7628:3: ( 'NOT' )
            // InternalSymg.g:7629:4: 'NOT'
            {
             before(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 
            match(input,105,FOLLOW_2); 
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
    // InternalSymg.g:7640:1: rule__Negation__AtomicExpressionAssignment_1 : ( ruleAtom ) ;
    public final void rule__Negation__AtomicExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7644:1: ( ( ruleAtom ) )
            // InternalSymg.g:7645:2: ( ruleAtom )
            {
            // InternalSymg.g:7645:2: ( ruleAtom )
            // InternalSymg.g:7646:3: ruleAtom
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
    // InternalSymg.g:7655:1: rule__Atom__EventPropositionAssignment_0_2 : ( ruleEventProp ) ;
    public final void rule__Atom__EventPropositionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7659:1: ( ( ruleEventProp ) )
            // InternalSymg.g:7660:2: ( ruleEventProp )
            {
            // InternalSymg.g:7660:2: ( ruleEventProp )
            // InternalSymg.g:7661:3: ruleEventProp
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
    // InternalSymg.g:7670:1: rule__Atom__SituationPropositionAssignment_1_2 : ( ruleSitProp ) ;
    public final void rule__Atom__SituationPropositionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7674:1: ( ( ruleSitProp ) )
            // InternalSymg.g:7675:2: ( ruleSitProp )
            {
            // InternalSymg.g:7675:2: ( ruleSitProp )
            // InternalSymg.g:7676:3: ruleSitProp
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


    // $ANTLR start "rule__Atom__PointAssignment_2_0"
    // InternalSymg.g:7685:1: rule__Atom__PointAssignment_2_0 : ( rulePoint ) ;
    public final void rule__Atom__PointAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7689:1: ( ( rulePoint ) )
            // InternalSymg.g:7690:2: ( rulePoint )
            {
            // InternalSymg.g:7690:2: ( rulePoint )
            // InternalSymg.g:7691:3: rulePoint
            {
             before(grammarAccess.getAtomAccess().getPointPointParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            rulePoint();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getPointPointParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__PointAssignment_2_0"


    // $ANTLR start "rule__Atom__IntervalAssignment_2_2"
    // InternalSymg.g:7700:1: rule__Atom__IntervalAssignment_2_2 : ( ruleInterval ) ;
    public final void rule__Atom__IntervalAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7704:1: ( ( ruleInterval ) )
            // InternalSymg.g:7705:2: ( ruleInterval )
            {
            // InternalSymg.g:7705:2: ( ruleInterval )
            // InternalSymg.g:7706:3: ruleInterval
            {
             before(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleInterval();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__IntervalAssignment_2_2"


    // $ANTLR start "rule__Atom__BoolAssignment_3"
    // InternalSymg.g:7715:1: rule__Atom__BoolAssignment_3 : ( ( 'TRUE' ) ) ;
    public final void rule__Atom__BoolAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7719:1: ( ( ( 'TRUE' ) ) )
            // InternalSymg.g:7720:2: ( ( 'TRUE' ) )
            {
            // InternalSymg.g:7720:2: ( ( 'TRUE' ) )
            // InternalSymg.g:7721:3: ( 'TRUE' )
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0()); 
            // InternalSymg.g:7722:3: ( 'TRUE' )
            // InternalSymg.g:7723:4: 'TRUE'
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0()); 

            }

             after(grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__BoolAssignment_3"


    // $ANTLR start "rule__Atom__BoolAssignment_4"
    // InternalSymg.g:7734:1: rule__Atom__BoolAssignment_4 : ( ( 'FALSE' ) ) ;
    public final void rule__Atom__BoolAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7738:1: ( ( ( 'FALSE' ) ) )
            // InternalSymg.g:7739:2: ( ( 'FALSE' ) )
            {
            // InternalSymg.g:7739:2: ( ( 'FALSE' ) )
            // InternalSymg.g:7740:3: ( 'FALSE' )
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0()); 
            // InternalSymg.g:7741:3: ( 'FALSE' )
            // InternalSymg.g:7742:4: 'FALSE'
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0()); 
            match(input,107,FOLLOW_2); 
             after(grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0()); 

            }

             after(grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__SitProp__SituationNameAssignment_0_0"
    // InternalSymg.g:7753:1: rule__SitProp__SituationNameAssignment_0_0 : ( RULE_ID ) ;
    public final void rule__SitProp__SituationNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7757:1: ( ( RULE_ID ) )
            // InternalSymg.g:7758:2: ( RULE_ID )
            {
            // InternalSymg.g:7758:2: ( RULE_ID )
            // InternalSymg.g:7759:3: RULE_ID
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
    // InternalSymg.g:7768:1: rule__SitProp__OSituationNameAssignment_0_1 : ( ruleoState ) ;
    public final void rule__SitProp__OSituationNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7772:1: ( ( ruleoState ) )
            // InternalSymg.g:7773:2: ( ruleoState )
            {
            // InternalSymg.g:7773:2: ( ruleoState )
            // InternalSymg.g:7774:3: ruleoState
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
    // InternalSymg.g:7783:1: rule__SitProp__CSituationNameAssignment_0_2 : ( rulecState ) ;
    public final void rule__SitProp__CSituationNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7787:1: ( ( rulecState ) )
            // InternalSymg.g:7788:2: ( rulecState )
            {
            // InternalSymg.g:7788:2: ( rulecState )
            // InternalSymg.g:7789:3: rulecState
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
    // InternalSymg.g:7798:1: rule__SitProp__PSituationNameAssignment_0_3 : ( rulepState ) ;
    public final void rule__SitProp__PSituationNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7802:1: ( ( rulepState ) )
            // InternalSymg.g:7803:2: ( rulepState )
            {
            // InternalSymg.g:7803:2: ( rulepState )
            // InternalSymg.g:7804:3: rulepState
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
    // InternalSymg.g:7813:1: rule__SitProp__IntervalAssignment_2 : ( ruleInterval ) ;
    public final void rule__SitProp__IntervalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7817:1: ( ( ruleInterval ) )
            // InternalSymg.g:7818:2: ( ruleInterval )
            {
            // InternalSymg.g:7818:2: ( ruleInterval )
            // InternalSymg.g:7819:3: ruleInterval
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
    // InternalSymg.g:7828:1: rule__EventProp__EventNameAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EventProp__EventNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7832:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7833:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7833:2: ( ( RULE_ID ) )
            // InternalSymg.g:7834:3: ( RULE_ID )
            {
             before(grammarAccess.getEventPropAccess().getEventNameDeclarCrossReference_0_0_0()); 
            // InternalSymg.g:7835:3: ( RULE_ID )
            // InternalSymg.g:7836:4: RULE_ID
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
    // InternalSymg.g:7847:1: rule__EventProp__OEventNameAssignment_0_1 : ( ruleoEvent ) ;
    public final void rule__EventProp__OEventNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7851:1: ( ( ruleoEvent ) )
            // InternalSymg.g:7852:2: ( ruleoEvent )
            {
            // InternalSymg.g:7852:2: ( ruleoEvent )
            // InternalSymg.g:7853:3: ruleoEvent
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
    // InternalSymg.g:7862:1: rule__EventProp__CEventNameAssignment_0_2 : ( rulecEvent ) ;
    public final void rule__EventProp__CEventNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7866:1: ( ( rulecEvent ) )
            // InternalSymg.g:7867:2: ( rulecEvent )
            {
            // InternalSymg.g:7867:2: ( rulecEvent )
            // InternalSymg.g:7868:3: rulecEvent
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
    // InternalSymg.g:7877:1: rule__EventProp__PEventNameAssignment_0_3 : ( rulepEvent ) ;
    public final void rule__EventProp__PEventNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7881:1: ( ( rulepEvent ) )
            // InternalSymg.g:7882:2: ( rulepEvent )
            {
            // InternalSymg.g:7882:2: ( rulepEvent )
            // InternalSymg.g:7883:3: rulepEvent
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
    // InternalSymg.g:7892:1: rule__EventProp__PointAssignment_2 : ( rulePoint ) ;
    public final void rule__EventProp__PointAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7896:1: ( ( rulePoint ) )
            // InternalSymg.g:7897:2: ( rulePoint )
            {
            // InternalSymg.g:7897:2: ( rulePoint )
            // InternalSymg.g:7898:3: rulePoint
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
    // InternalSymg.g:7907:1: rule__Interval__SituationNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Interval__SituationNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7911:1: ( ( ruleSitName ) )
            // InternalSymg.g:7912:2: ( ruleSitName )
            {
            // InternalSymg.g:7912:2: ( ruleSitName )
            // InternalSymg.g:7913:3: ruleSitName
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
    // InternalSymg.g:7922:1: rule__Interval__StartAssignment_1_1 : ( rulePoint ) ;
    public final void rule__Interval__StartAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7926:1: ( ( rulePoint ) )
            // InternalSymg.g:7927:2: ( rulePoint )
            {
            // InternalSymg.g:7927:2: ( rulePoint )
            // InternalSymg.g:7928:3: rulePoint
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
    // InternalSymg.g:7937:1: rule__Interval__EndAssignment_1_3 : ( rulePoint ) ;
    public final void rule__Interval__EndAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7941:1: ( ( rulePoint ) )
            // InternalSymg.g:7942:2: ( rulePoint )
            {
            // InternalSymg.g:7942:2: ( rulePoint )
            // InternalSymg.g:7943:3: rulePoint
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
    // InternalSymg.g:7952:1: rule__Interval__UnnamedAssignment_2 : ( ( 'UNNAMED_INTERVAL' ) ) ;
    public final void rule__Interval__UnnamedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7956:1: ( ( ( 'UNNAMED_INTERVAL' ) ) )
            // InternalSymg.g:7957:2: ( ( 'UNNAMED_INTERVAL' ) )
            {
            // InternalSymg.g:7957:2: ( ( 'UNNAMED_INTERVAL' ) )
            // InternalSymg.g:7958:3: ( 'UNNAMED_INTERVAL' )
            {
             before(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 
            // InternalSymg.g:7959:3: ( 'UNNAMED_INTERVAL' )
            // InternalSymg.g:7960:4: 'UNNAMED_INTERVAL'
            {
             before(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 
            match(input,108,FOLLOW_2); 
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


    // $ANTLR start "rule__Interval__SituationNameAssignment_3_0"
    // InternalSymg.g:7971:1: rule__Interval__SituationNameAssignment_3_0 : ( ruleSitName ) ;
    public final void rule__Interval__SituationNameAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7975:1: ( ( ruleSitName ) )
            // InternalSymg.g:7976:2: ( ruleSitName )
            {
            // InternalSymg.g:7976:2: ( ruleSitName )
            // InternalSymg.g:7977:3: ruleSitName
            {
             before(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__SituationNameAssignment_3_0"


    // $ANTLR start "rule__Interval__TempOpAssignment_3_1"
    // InternalSymg.g:7986:1: rule__Interval__TempOpAssignment_3_1 : ( ruleTempOp ) ;
    public final void rule__Interval__TempOpAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7990:1: ( ( ruleTempOp ) )
            // InternalSymg.g:7991:2: ( ruleTempOp )
            {
            // InternalSymg.g:7991:2: ( ruleTempOp )
            // InternalSymg.g:7992:3: ruleTempOp
            {
             before(grammarAccess.getIntervalAccess().getTempOpTempOpParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getTempOpTempOpParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__TempOpAssignment_3_1"


    // $ANTLR start "rule__Interval__IntConstAssignment_3_2"
    // InternalSymg.g:8001:1: rule__Interval__IntConstAssignment_3_2 : ( ruleIntConst ) ;
    public final void rule__Interval__IntConstAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8005:1: ( ( ruleIntConst ) )
            // InternalSymg.g:8006:2: ( ruleIntConst )
            {
            // InternalSymg.g:8006:2: ( ruleIntConst )
            // InternalSymg.g:8007:3: ruleIntConst
            {
             before(grammarAccess.getIntervalAccess().getIntConstIntConstParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIntConst();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getIntConstIntConstParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__IntConstAssignment_3_2"


    // $ANTLR start "rule__Interval__UnitAssignment_3_3"
    // InternalSymg.g:8016:1: rule__Interval__UnitAssignment_3_3 : ( ruleUnit ) ;
    public final void rule__Interval__UnitAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8020:1: ( ( ruleUnit ) )
            // InternalSymg.g:8021:2: ( ruleUnit )
            {
            // InternalSymg.g:8021:2: ( ruleUnit )
            // InternalSymg.g:8022:3: ruleUnit
            {
             before(grammarAccess.getIntervalAccess().getUnitUnitParserRuleCall_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getIntervalAccess().getUnitUnitParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Interval__UnitAssignment_3_3"


    // $ANTLR start "rule__SitName__SitNameAssignment_0"
    // InternalSymg.g:8031:1: rule__SitName__SitNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SitName__SitNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8035:1: ( ( RULE_ID ) )
            // InternalSymg.g:8036:2: ( RULE_ID )
            {
            // InternalSymg.g:8036:2: ( RULE_ID )
            // InternalSymg.g:8037:3: RULE_ID
            {
             before(grammarAccess.getSitNameAccess().getSitNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSitNameAccess().getSitNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SitName__SitNameAssignment_0"


    // $ANTLR start "rule__SitName__OStateAssignment_1"
    // InternalSymg.g:8046:1: rule__SitName__OStateAssignment_1 : ( ruleoState ) ;
    public final void rule__SitName__OStateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8050:1: ( ( ruleoState ) )
            // InternalSymg.g:8051:2: ( ruleoState )
            {
            // InternalSymg.g:8051:2: ( ruleoState )
            // InternalSymg.g:8052:3: ruleoState
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
    // InternalSymg.g:8061:1: rule__SitName__PStateAssignment_2 : ( rulepState ) ;
    public final void rule__SitName__PStateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8065:1: ( ( rulepState ) )
            // InternalSymg.g:8066:2: ( rulepState )
            {
            // InternalSymg.g:8066:2: ( rulepState )
            // InternalSymg.g:8067:3: rulepState
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
    // InternalSymg.g:8076:1: rule__SitName__CStateAssignment_3 : ( rulecState ) ;
    public final void rule__SitName__CStateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8080:1: ( ( rulecState ) )
            // InternalSymg.g:8081:2: ( rulecState )
            {
            // InternalSymg.g:8081:2: ( rulecState )
            // InternalSymg.g:8082:3: rulecState
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
    // InternalSymg.g:8091:1: rule__SitName__OEventAssignment_4 : ( ruleoEvent ) ;
    public final void rule__SitName__OEventAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8095:1: ( ( ruleoEvent ) )
            // InternalSymg.g:8096:2: ( ruleoEvent )
            {
            // InternalSymg.g:8096:2: ( ruleoEvent )
            // InternalSymg.g:8097:3: ruleoEvent
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
    // InternalSymg.g:8106:1: rule__SitName__CEventAssignment_5 : ( rulecEvent ) ;
    public final void rule__SitName__CEventAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8110:1: ( ( rulecEvent ) )
            // InternalSymg.g:8111:2: ( rulecEvent )
            {
            // InternalSymg.g:8111:2: ( rulecEvent )
            // InternalSymg.g:8112:3: rulecEvent
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
    // InternalSymg.g:8121:1: rule__SitName__PEventAssignment_6 : ( rulepEvent ) ;
    public final void rule__SitName__PEventAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8125:1: ( ( rulepEvent ) )
            // InternalSymg.g:8126:2: ( rulepEvent )
            {
            // InternalSymg.g:8126:2: ( rulepEvent )
            // InternalSymg.g:8127:3: rulepEvent
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
    // InternalSymg.g:8136:1: rule__IntConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8140:1: ( ( RULE_INT ) )
            // InternalSymg.g:8141:2: ( RULE_INT )
            {
            // InternalSymg.g:8141:2: ( RULE_INT )
            // InternalSymg.g:8142:3: RULE_INT
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
    // InternalSymg.g:8151:1: rule__Point__EventNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Point__EventNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8155:1: ( ( ruleSitName ) )
            // InternalSymg.g:8156:2: ( ruleSitName )
            {
            // InternalSymg.g:8156:2: ( ruleSitName )
            // InternalSymg.g:8157:3: ruleSitName
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
    // InternalSymg.g:8166:1: rule__Point__UnnamedAssignment_1 : ( ( 'UNNAMED_POINT' ) ) ;
    public final void rule__Point__UnnamedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8170:1: ( ( ( 'UNNAMED_POINT' ) ) )
            // InternalSymg.g:8171:2: ( ( 'UNNAMED_POINT' ) )
            {
            // InternalSymg.g:8171:2: ( ( 'UNNAMED_POINT' ) )
            // InternalSymg.g:8172:3: ( 'UNNAMED_POINT' )
            {
             before(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 
            // InternalSymg.g:8173:3: ( 'UNNAMED_POINT' )
            // InternalSymg.g:8174:4: 'UNNAMED_POINT'
            {
             before(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 
            match(input,109,FOLLOW_2); 
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
    // InternalSymg.g:8185:1: rule__Point__PointConstAssignment_2 : ( rulePointConst ) ;
    public final void rule__Point__PointConstAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8189:1: ( ( rulePointConst ) )
            // InternalSymg.g:8190:2: ( rulePointConst )
            {
            // InternalSymg.g:8190:2: ( rulePointConst )
            // InternalSymg.g:8191:3: rulePointConst
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


    // $ANTLR start "rule__Point__PointConstAssignment_3_0"
    // InternalSymg.g:8200:1: rule__Point__PointConstAssignment_3_0 : ( rulePointConst ) ;
    public final void rule__Point__PointConstAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8204:1: ( ( rulePointConst ) )
            // InternalSymg.g:8205:2: ( rulePointConst )
            {
            // InternalSymg.g:8205:2: ( rulePointConst )
            // InternalSymg.g:8206:3: rulePointConst
            {
             before(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            rulePointConst();

            state._fsp--;

             after(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__PointConstAssignment_3_0"


    // $ANTLR start "rule__Point__UnitAssignment_3_1"
    // InternalSymg.g:8215:1: rule__Point__UnitAssignment_3_1 : ( ruleUnit ) ;
    public final void rule__Point__UnitAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8219:1: ( ( ruleUnit ) )
            // InternalSymg.g:8220:2: ( ruleUnit )
            {
            // InternalSymg.g:8220:2: ( ruleUnit )
            // InternalSymg.g:8221:3: ruleUnit
            {
             before(grammarAccess.getPointAccess().getUnitUnitParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnit();

            state._fsp--;

             after(grammarAccess.getPointAccess().getUnitUnitParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__UnitAssignment_3_1"


    // $ANTLR start "rule__Point__TempOpAssignment_3_2"
    // InternalSymg.g:8230:1: rule__Point__TempOpAssignment_3_2 : ( ruleTempOp ) ;
    public final void rule__Point__TempOpAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8234:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8235:2: ( ruleTempOp )
            {
            // InternalSymg.g:8235:2: ( ruleTempOp )
            // InternalSymg.g:8236:3: ruleTempOp
            {
             before(grammarAccess.getPointAccess().getTempOpTempOpParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTempOp();

            state._fsp--;

             after(grammarAccess.getPointAccess().getTempOpTempOpParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__TempOpAssignment_3_2"


    // $ANTLR start "rule__Point__EventNameAssignment_3_3"
    // InternalSymg.g:8245:1: rule__Point__EventNameAssignment_3_3 : ( ruleSitName ) ;
    public final void rule__Point__EventNameAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8249:1: ( ( ruleSitName ) )
            // InternalSymg.g:8250:2: ( ruleSitName )
            {
            // InternalSymg.g:8250:2: ( ruleSitName )
            // InternalSymg.g:8251:3: ruleSitName
            {
             before(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_3_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSitName();

            state._fsp--;

             after(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Point__EventNameAssignment_3_3"


    // $ANTLR start "rule__PEvent__PowEventAssignment_0"
    // InternalSymg.g:8260:1: rule__PEvent__PowEventAssignment_0 : ( rulePowEvent ) ;
    public final void rule__PEvent__PowEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8264:1: ( ( rulePowEvent ) )
            // InternalSymg.g:8265:2: ( rulePowEvent )
            {
            // InternalSymg.g:8265:2: ( rulePowEvent )
            // InternalSymg.g:8266:3: rulePowEvent
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
    // InternalSymg.g:8275:1: rule__PEvent__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PEvent__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8279:1: ( ( RULE_ID ) )
            // InternalSymg.g:8280:2: ( RULE_ID )
            {
            // InternalSymg.g:8280:2: ( RULE_ID )
            // InternalSymg.g:8281:3: RULE_ID
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
    // InternalSymg.g:8290:1: rule__CEvent__ContrEventAssignment_0 : ( ruleContrEvent ) ;
    public final void rule__CEvent__ContrEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8294:1: ( ( ruleContrEvent ) )
            // InternalSymg.g:8295:2: ( ruleContrEvent )
            {
            // InternalSymg.g:8295:2: ( ruleContrEvent )
            // InternalSymg.g:8296:3: ruleContrEvent
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
    // InternalSymg.g:8305:1: rule__CEvent__ContrNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CEvent__ContrNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8309:1: ( ( RULE_ID ) )
            // InternalSymg.g:8310:2: ( RULE_ID )
            {
            // InternalSymg.g:8310:2: ( RULE_ID )
            // InternalSymg.g:8311:3: RULE_ID
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
    // InternalSymg.g:8320:1: rule__OEvent__OblEventAssignment_0 : ( ruleOblEvent ) ;
    public final void rule__OEvent__OblEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8324:1: ( ( ruleOblEvent ) )
            // InternalSymg.g:8325:2: ( ruleOblEvent )
            {
            // InternalSymg.g:8325:2: ( ruleOblEvent )
            // InternalSymg.g:8326:3: ruleOblEvent
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
    // InternalSymg.g:8335:1: rule__OEvent__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OEvent__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8339:1: ( ( RULE_ID ) )
            // InternalSymg.g:8340:2: ( RULE_ID )
            {
            // InternalSymg.g:8340:2: ( RULE_ID )
            // InternalSymg.g:8341:3: RULE_ID
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
    // InternalSymg.g:8350:1: rule__PointConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__PointConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8354:1: ( ( RULE_INT ) )
            // InternalSymg.g:8355:2: ( RULE_INT )
            {
            // InternalSymg.g:8355:2: ( RULE_INT )
            // InternalSymg.g:8356:3: RULE_INT
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
    // InternalSymg.g:8365:1: rule__OState__OblStateAssignment_0 : ( ruleOblState ) ;
    public final void rule__OState__OblStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8369:1: ( ( ruleOblState ) )
            // InternalSymg.g:8370:2: ( ruleOblState )
            {
            // InternalSymg.g:8370:2: ( ruleOblState )
            // InternalSymg.g:8371:3: ruleOblState
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
    // InternalSymg.g:8380:1: rule__OState__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OState__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8384:1: ( ( RULE_ID ) )
            // InternalSymg.g:8385:2: ( RULE_ID )
            {
            // InternalSymg.g:8385:2: ( RULE_ID )
            // InternalSymg.g:8386:3: RULE_ID
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
    // InternalSymg.g:8395:1: rule__CState__ContrStateAssignment_0 : ( ruleContrState ) ;
    public final void rule__CState__ContrStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8399:1: ( ( ruleContrState ) )
            // InternalSymg.g:8400:2: ( ruleContrState )
            {
            // InternalSymg.g:8400:2: ( ruleContrState )
            // InternalSymg.g:8401:3: ruleContrState
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
    // InternalSymg.g:8410:1: rule__CState__ContractNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CState__ContractNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8414:1: ( ( RULE_ID ) )
            // InternalSymg.g:8415:2: ( RULE_ID )
            {
            // InternalSymg.g:8415:2: ( RULE_ID )
            // InternalSymg.g:8416:3: RULE_ID
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
    // InternalSymg.g:8425:1: rule__PState__PowStateAssignment_0 : ( rulePowState ) ;
    public final void rule__PState__PowStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8429:1: ( ( rulePowState ) )
            // InternalSymg.g:8430:2: ( rulePowState )
            {
            // InternalSymg.g:8430:2: ( rulePowState )
            // InternalSymg.g:8431:3: rulePowState
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
    // InternalSymg.g:8440:1: rule__PState__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PState__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8444:1: ( ( RULE_ID ) )
            // InternalSymg.g:8445:2: ( RULE_ID )
            {
            // InternalSymg.g:8445:2: ( RULE_ID )
            // InternalSymg.g:8446:3: RULE_ID
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
    protected DFA37 dfa37 = new DFA37(this);
    static final String dfa_1s = "\102\uffff";
    static final String dfa_2s = "\1\uffff\1\57\72\uffff\6\57";
    static final String dfa_3s = "\1\4\1\33\52\116\4\uffff\6\4\6\117\6\33";
    static final String dfa_4s = "\1\154\1\143\52\116\4\uffff\6\4\6\117\6\143";
    static final String dfa_5s = "\54\uffff\1\2\1\3\1\4\1\1\22\uffff";
    static final String dfa_6s = "\102\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\34\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\17\1\20\1\21\1\22\1\23\1\24\1\12\1\13\1\14\1\15\1\16\34\uffff\1\54\4\uffff\1\55",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\1\60",
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
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57",
            "\6\56\56\uffff\1\57\1\uffff\2\57\15\uffff\1\57\1\uffff\2\57"
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
            return "1317:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) );";
        }
    }
    static final String dfa_8s = "\16\uffff";
    static final String dfa_9s = "\3\uffff\11\14\2\uffff";
    static final String dfa_10s = "\1\4\1\134\1\4\11\121\2\uffff";
    static final String dfa_11s = "\1\4\1\134\1\22\11\122\2\uffff";
    static final String dfa_12s = "\14\uffff\1\2\1\1";
    static final String dfa_13s = "\16\uffff}>";
    static final String[] dfa_14s = {
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

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 3387:2: ( rule__Regular__Group_3_1__0 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000003F90000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E30000007FFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xFFFFFFFE00000032L,0x00002E30000007FFL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000007F810L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E30800007FFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E32000007FFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xFFFFFFFE00000010L,0x00000000000007FFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xFF00000000000010L,0x00000000000007FFL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0xFFFFFFFE00000010L,0x00001080000007FFL});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002000000007FFL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000001F8000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000007F80000L});

}