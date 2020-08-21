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

                    if ( (LA1_2==93) ) {
                        alt1=2;
                    }
                    else if ( (LA1_2==RULE_ID||(LA1_2>=11 && LA1_2<=18)) ) {
                        alt1=1;
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
    // InternalSymg.g:1212:1: rule__Atom__Alternatives : ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__Group_3__0 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) | ( ( rule__Atom__BoolAssignment_5 ) ) );
    public final void rule__Atom__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1216:1: ( ( ( rule__Atom__Group_0__0 ) ) | ( ( rule__Atom__Group_1__0 ) ) | ( ( rule__Atom__Group_2__0 ) ) | ( ( rule__Atom__Group_3__0 ) ) | ( ( rule__Atom__BoolAssignment_4 ) ) | ( ( rule__Atom__BoolAssignment_5 ) ) )
            int alt6=6;
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
            case 78:
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
            case 74:
            case 109:
                {
                alt6=4;
                }
                break;
            case 106:
                {
                alt6=5;
                }
                break;
            case 107:
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
                    // InternalSymg.g:1235:2: ( ( rule__Atom__Group_3__0 ) )
                    {
                    // InternalSymg.g:1235:2: ( ( rule__Atom__Group_3__0 ) )
                    // InternalSymg.g:1236:3: ( rule__Atom__Group_3__0 )
                    {
                     before(grammarAccess.getAtomAccess().getGroup_3()); 
                    // InternalSymg.g:1237:3: ( rule__Atom__Group_3__0 )
                    // InternalSymg.g:1237:4: rule__Atom__Group_3__0
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
                case 6 :
                    // InternalSymg.g:1247:2: ( ( rule__Atom__BoolAssignment_5 ) )
                    {
                    // InternalSymg.g:1247:2: ( ( rule__Atom__BoolAssignment_5 ) )
                    // InternalSymg.g:1248:3: ( rule__Atom__BoolAssignment_5 )
                    {
                     before(grammarAccess.getAtomAccess().getBoolAssignment_5()); 
                    // InternalSymg.g:1249:3: ( rule__Atom__BoolAssignment_5 )
                    // InternalSymg.g:1249:4: rule__Atom__BoolAssignment_5
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
    // InternalSymg.g:1257:1: rule__SitProp__Alternatives_0 : ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) );
    public final void rule__SitProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1261:1: ( ( ( rule__SitProp__SituationNameAssignment_0_0 ) ) | ( ( rule__SitProp__OSituationNameAssignment_0_1 ) ) | ( ( rule__SitProp__CSituationNameAssignment_0_2 ) ) | ( ( rule__SitProp__PSituationNameAssignment_0_3 ) ) )
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
                    // InternalSymg.g:1262:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1262:2: ( ( rule__SitProp__SituationNameAssignment_0_0 ) )
                    // InternalSymg.g:1263:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    {
                     before(grammarAccess.getSitPropAccess().getSituationNameAssignment_0_0()); 
                    // InternalSymg.g:1264:3: ( rule__SitProp__SituationNameAssignment_0_0 )
                    // InternalSymg.g:1264:4: rule__SitProp__SituationNameAssignment_0_0
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
                    // InternalSymg.g:1268:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1268:2: ( ( rule__SitProp__OSituationNameAssignment_0_1 ) )
                    // InternalSymg.g:1269:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    {
                     before(grammarAccess.getSitPropAccess().getOSituationNameAssignment_0_1()); 
                    // InternalSymg.g:1270:3: ( rule__SitProp__OSituationNameAssignment_0_1 )
                    // InternalSymg.g:1270:4: rule__SitProp__OSituationNameAssignment_0_1
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
                    // InternalSymg.g:1274:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1274:2: ( ( rule__SitProp__CSituationNameAssignment_0_2 ) )
                    // InternalSymg.g:1275:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    {
                     before(grammarAccess.getSitPropAccess().getCSituationNameAssignment_0_2()); 
                    // InternalSymg.g:1276:3: ( rule__SitProp__CSituationNameAssignment_0_2 )
                    // InternalSymg.g:1276:4: rule__SitProp__CSituationNameAssignment_0_2
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
                    // InternalSymg.g:1280:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1280:2: ( ( rule__SitProp__PSituationNameAssignment_0_3 ) )
                    // InternalSymg.g:1281:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    {
                     before(grammarAccess.getSitPropAccess().getPSituationNameAssignment_0_3()); 
                    // InternalSymg.g:1282:3: ( rule__SitProp__PSituationNameAssignment_0_3 )
                    // InternalSymg.g:1282:4: rule__SitProp__PSituationNameAssignment_0_3
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
    // InternalSymg.g:1290:1: rule__EventProp__Alternatives_0 : ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) );
    public final void rule__EventProp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1294:1: ( ( ( rule__EventProp__EventNameAssignment_0_0 ) ) | ( ( rule__EventProp__OEventNameAssignment_0_1 ) ) | ( ( rule__EventProp__CEventNameAssignment_0_2 ) ) | ( ( rule__EventProp__PEventNameAssignment_0_3 ) ) )
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
                    // InternalSymg.g:1295:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    {
                    // InternalSymg.g:1295:2: ( ( rule__EventProp__EventNameAssignment_0_0 ) )
                    // InternalSymg.g:1296:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    {
                     before(grammarAccess.getEventPropAccess().getEventNameAssignment_0_0()); 
                    // InternalSymg.g:1297:3: ( rule__EventProp__EventNameAssignment_0_0 )
                    // InternalSymg.g:1297:4: rule__EventProp__EventNameAssignment_0_0
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
                    // InternalSymg.g:1301:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    {
                    // InternalSymg.g:1301:2: ( ( rule__EventProp__OEventNameAssignment_0_1 ) )
                    // InternalSymg.g:1302:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    {
                     before(grammarAccess.getEventPropAccess().getOEventNameAssignment_0_1()); 
                    // InternalSymg.g:1303:3: ( rule__EventProp__OEventNameAssignment_0_1 )
                    // InternalSymg.g:1303:4: rule__EventProp__OEventNameAssignment_0_1
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
                    // InternalSymg.g:1307:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    {
                    // InternalSymg.g:1307:2: ( ( rule__EventProp__CEventNameAssignment_0_2 ) )
                    // InternalSymg.g:1308:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    {
                     before(grammarAccess.getEventPropAccess().getCEventNameAssignment_0_2()); 
                    // InternalSymg.g:1309:3: ( rule__EventProp__CEventNameAssignment_0_2 )
                    // InternalSymg.g:1309:4: rule__EventProp__CEventNameAssignment_0_2
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
                    // InternalSymg.g:1313:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    {
                    // InternalSymg.g:1313:2: ( ( rule__EventProp__PEventNameAssignment_0_3 ) )
                    // InternalSymg.g:1314:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    {
                     before(grammarAccess.getEventPropAccess().getPEventNameAssignment_0_3()); 
                    // InternalSymg.g:1315:3: ( rule__EventProp__PEventNameAssignment_0_3 )
                    // InternalSymg.g:1315:4: rule__EventProp__PEventNameAssignment_0_3
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
    // InternalSymg.g:1323:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) );
    public final void rule__Interval__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1327:1: ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // InternalSymg.g:1328:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1328:2: ( ( rule__Interval__SituationNameAssignment_0 ) )
                    // InternalSymg.g:1329:3: ( rule__Interval__SituationNameAssignment_0 )
                    {
                     before(grammarAccess.getIntervalAccess().getSituationNameAssignment_0()); 
                    // InternalSymg.g:1330:3: ( rule__Interval__SituationNameAssignment_0 )
                    // InternalSymg.g:1330:4: rule__Interval__SituationNameAssignment_0
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
                    // InternalSymg.g:1334:2: ( ( rule__Interval__Group_1__0 ) )
                    {
                    // InternalSymg.g:1334:2: ( ( rule__Interval__Group_1__0 ) )
                    // InternalSymg.g:1335:3: ( rule__Interval__Group_1__0 )
                    {
                     before(grammarAccess.getIntervalAccess().getGroup_1()); 
                    // InternalSymg.g:1336:3: ( rule__Interval__Group_1__0 )
                    // InternalSymg.g:1336:4: rule__Interval__Group_1__0
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
                    // InternalSymg.g:1340:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    {
                    // InternalSymg.g:1340:2: ( ( rule__Interval__UnnamedAssignment_2 ) )
                    // InternalSymg.g:1341:3: ( rule__Interval__UnnamedAssignment_2 )
                    {
                     before(grammarAccess.getIntervalAccess().getUnnamedAssignment_2()); 
                    // InternalSymg.g:1342:3: ( rule__Interval__UnnamedAssignment_2 )
                    // InternalSymg.g:1342:4: rule__Interval__UnnamedAssignment_2
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
                    // InternalSymg.g:1346:2: ( ( rule__Interval__Group_3__0 ) )
                    {
                    // InternalSymg.g:1346:2: ( ( rule__Interval__Group_3__0 ) )
                    // InternalSymg.g:1347:3: ( rule__Interval__Group_3__0 )
                    {
                     before(grammarAccess.getIntervalAccess().getGroup_3()); 
                    // InternalSymg.g:1348:3: ( rule__Interval__Group_3__0 )
                    // InternalSymg.g:1348:4: rule__Interval__Group_3__0
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
    // InternalSymg.g:1356:1: rule__SitName__Alternatives : ( ( ( rule__SitName__DeclNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) );
    public final void rule__SitName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1360:1: ( ( ( rule__SitName__DeclNameAssignment_0 ) ) | ( ( rule__SitName__OStateAssignment_1 ) ) | ( ( rule__SitName__PStateAssignment_2 ) ) | ( ( rule__SitName__CStateAssignment_3 ) ) | ( ( rule__SitName__OEventAssignment_4 ) ) | ( ( rule__SitName__CEventAssignment_5 ) ) | ( ( rule__SitName__PEventAssignment_6 ) ) )
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
                    // InternalSymg.g:1361:2: ( ( rule__SitName__DeclNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1361:2: ( ( rule__SitName__DeclNameAssignment_0 ) )
                    // InternalSymg.g:1362:3: ( rule__SitName__DeclNameAssignment_0 )
                    {
                     before(grammarAccess.getSitNameAccess().getDeclNameAssignment_0()); 
                    // InternalSymg.g:1363:3: ( rule__SitName__DeclNameAssignment_0 )
                    // InternalSymg.g:1363:4: rule__SitName__DeclNameAssignment_0
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
                    // InternalSymg.g:1367:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    {
                    // InternalSymg.g:1367:2: ( ( rule__SitName__OStateAssignment_1 ) )
                    // InternalSymg.g:1368:3: ( rule__SitName__OStateAssignment_1 )
                    {
                     before(grammarAccess.getSitNameAccess().getOStateAssignment_1()); 
                    // InternalSymg.g:1369:3: ( rule__SitName__OStateAssignment_1 )
                    // InternalSymg.g:1369:4: rule__SitName__OStateAssignment_1
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
                    // InternalSymg.g:1373:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    {
                    // InternalSymg.g:1373:2: ( ( rule__SitName__PStateAssignment_2 ) )
                    // InternalSymg.g:1374:3: ( rule__SitName__PStateAssignment_2 )
                    {
                     before(grammarAccess.getSitNameAccess().getPStateAssignment_2()); 
                    // InternalSymg.g:1375:3: ( rule__SitName__PStateAssignment_2 )
                    // InternalSymg.g:1375:4: rule__SitName__PStateAssignment_2
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
                    // InternalSymg.g:1379:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    {
                    // InternalSymg.g:1379:2: ( ( rule__SitName__CStateAssignment_3 ) )
                    // InternalSymg.g:1380:3: ( rule__SitName__CStateAssignment_3 )
                    {
                     before(grammarAccess.getSitNameAccess().getCStateAssignment_3()); 
                    // InternalSymg.g:1381:3: ( rule__SitName__CStateAssignment_3 )
                    // InternalSymg.g:1381:4: rule__SitName__CStateAssignment_3
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
                    // InternalSymg.g:1385:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    {
                    // InternalSymg.g:1385:2: ( ( rule__SitName__OEventAssignment_4 ) )
                    // InternalSymg.g:1386:3: ( rule__SitName__OEventAssignment_4 )
                    {
                     before(grammarAccess.getSitNameAccess().getOEventAssignment_4()); 
                    // InternalSymg.g:1387:3: ( rule__SitName__OEventAssignment_4 )
                    // InternalSymg.g:1387:4: rule__SitName__OEventAssignment_4
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
                    // InternalSymg.g:1391:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    {
                    // InternalSymg.g:1391:2: ( ( rule__SitName__CEventAssignment_5 ) )
                    // InternalSymg.g:1392:3: ( rule__SitName__CEventAssignment_5 )
                    {
                     before(grammarAccess.getSitNameAccess().getCEventAssignment_5()); 
                    // InternalSymg.g:1393:3: ( rule__SitName__CEventAssignment_5 )
                    // InternalSymg.g:1393:4: rule__SitName__CEventAssignment_5
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
                    // InternalSymg.g:1397:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    {
                    // InternalSymg.g:1397:2: ( ( rule__SitName__PEventAssignment_6 ) )
                    // InternalSymg.g:1398:3: ( rule__SitName__PEventAssignment_6 )
                    {
                     before(grammarAccess.getSitNameAccess().getPEventAssignment_6()); 
                    // InternalSymg.g:1399:3: ( rule__SitName__PEventAssignment_6 )
                    // InternalSymg.g:1399:4: rule__SitName__PEventAssignment_6
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
    // InternalSymg.g:1407:1: rule__Unit__Alternatives : ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) );
    public final void rule__Unit__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1411:1: ( ( 'SECONDS' ) | ( 'MINUTES' ) | ( 'HOURS' ) | ( 'DAYS' ) | ( 'WEEKS' ) | ( 'MONTHS' ) | ( 'QUARTERS' ) | ( 'YEARS' ) )
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
                    // InternalSymg.g:1412:2: ( 'SECONDS' )
                    {
                    // InternalSymg.g:1412:2: ( 'SECONDS' )
                    // InternalSymg.g:1413:3: 'SECONDS'
                    {
                     before(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getSECONDSKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1418:2: ( 'MINUTES' )
                    {
                    // InternalSymg.g:1418:2: ( 'MINUTES' )
                    // InternalSymg.g:1419:3: 'MINUTES'
                    {
                     before(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMINUTESKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1424:2: ( 'HOURS' )
                    {
                    // InternalSymg.g:1424:2: ( 'HOURS' )
                    // InternalSymg.g:1425:3: 'HOURS'
                    {
                     before(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getHOURSKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1430:2: ( 'DAYS' )
                    {
                    // InternalSymg.g:1430:2: ( 'DAYS' )
                    // InternalSymg.g:1431:3: 'DAYS'
                    {
                     before(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getDAYSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1436:2: ( 'WEEKS' )
                    {
                    // InternalSymg.g:1436:2: ( 'WEEKS' )
                    // InternalSymg.g:1437:3: 'WEEKS'
                    {
                     before(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getWEEKSKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1442:2: ( 'MONTHS' )
                    {
                    // InternalSymg.g:1442:2: ( 'MONTHS' )
                    // InternalSymg.g:1443:3: 'MONTHS'
                    {
                     before(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getMONTHSKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1448:2: ( 'QUARTERS' )
                    {
                    // InternalSymg.g:1448:2: ( 'QUARTERS' )
                    // InternalSymg.g:1449:3: 'QUARTERS'
                    {
                     before(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnitAccess().getQUARTERSKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1454:2: ( 'YEARS' )
                    {
                    // InternalSymg.g:1454:2: ( 'YEARS' )
                    // InternalSymg.g:1455:3: 'YEARS'
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
    // InternalSymg.g:1464:1: rule__TempOp__Alternatives : ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) );
    public final void rule__TempOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1468:1: ( ( 'BEFORE' ) | ( 'AFTER' ) | ( 'AT' ) | ( 'WITHIN' ) | ( '+' ) | ( '-' ) )
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
                    // InternalSymg.g:1469:2: ( 'BEFORE' )
                    {
                    // InternalSymg.g:1469:2: ( 'BEFORE' )
                    // InternalSymg.g:1470:3: 'BEFORE'
                    {
                     before(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getBEFOREKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1475:2: ( 'AFTER' )
                    {
                    // InternalSymg.g:1475:2: ( 'AFTER' )
                    // InternalSymg.g:1476:3: 'AFTER'
                    {
                     before(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getAFTERKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1481:2: ( 'AT' )
                    {
                    // InternalSymg.g:1481:2: ( 'AT' )
                    // InternalSymg.g:1482:3: 'AT'
                    {
                     before(grammarAccess.getTempOpAccess().getATKeyword_2()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getATKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1487:2: ( 'WITHIN' )
                    {
                    // InternalSymg.g:1487:2: ( 'WITHIN' )
                    // InternalSymg.g:1488:3: 'WITHIN'
                    {
                     before(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getWITHINKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1493:2: ( '+' )
                    {
                    // InternalSymg.g:1493:2: ( '+' )
                    // InternalSymg.g:1494:3: '+'
                    {
                     before(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getTempOpAccess().getPlusSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1499:2: ( '-' )
                    {
                    // InternalSymg.g:1499:2: ( '-' )
                    // InternalSymg.g:1500:3: '-'
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
    // InternalSymg.g:1509:1: rule__Point__Alternatives : ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ( rule__Point__Group_3__0 ) ) );
    public final void rule__Point__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1513:1: ( ( ( rule__Point__EventNameAssignment_0 ) ) | ( ( rule__Point__UnnamedAssignment_1 ) ) | ( ( rule__Point__PointConstAssignment_2 ) ) | ( ( rule__Point__Group_3__0 ) ) )
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
                    // InternalSymg.g:1514:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    {
                    // InternalSymg.g:1514:2: ( ( rule__Point__EventNameAssignment_0 ) )
                    // InternalSymg.g:1515:3: ( rule__Point__EventNameAssignment_0 )
                    {
                     before(grammarAccess.getPointAccess().getEventNameAssignment_0()); 
                    // InternalSymg.g:1516:3: ( rule__Point__EventNameAssignment_0 )
                    // InternalSymg.g:1516:4: rule__Point__EventNameAssignment_0
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
                    // InternalSymg.g:1520:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    {
                    // InternalSymg.g:1520:2: ( ( rule__Point__UnnamedAssignment_1 ) )
                    // InternalSymg.g:1521:3: ( rule__Point__UnnamedAssignment_1 )
                    {
                     before(grammarAccess.getPointAccess().getUnnamedAssignment_1()); 
                    // InternalSymg.g:1522:3: ( rule__Point__UnnamedAssignment_1 )
                    // InternalSymg.g:1522:4: rule__Point__UnnamedAssignment_1
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
                    // InternalSymg.g:1526:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    {
                    // InternalSymg.g:1526:2: ( ( rule__Point__PointConstAssignment_2 ) )
                    // InternalSymg.g:1527:3: ( rule__Point__PointConstAssignment_2 )
                    {
                     before(grammarAccess.getPointAccess().getPointConstAssignment_2()); 
                    // InternalSymg.g:1528:3: ( rule__Point__PointConstAssignment_2 )
                    // InternalSymg.g:1528:4: rule__Point__PointConstAssignment_2
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
                    // InternalSymg.g:1532:2: ( ( rule__Point__Group_3__0 ) )
                    {
                    // InternalSymg.g:1532:2: ( ( rule__Point__Group_3__0 ) )
                    // InternalSymg.g:1533:3: ( rule__Point__Group_3__0 )
                    {
                     before(grammarAccess.getPointAccess().getGroup_3()); 
                    // InternalSymg.g:1534:3: ( rule__Point__Group_3__0 )
                    // InternalSymg.g:1534:4: rule__Point__Group_3__0
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
    // InternalSymg.g:1542:1: rule__PowEvent__Alternatives : ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) );
    public final void rule__PowEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1546:1: ( ( 'pTRIGGERED' ) | ( 'pACTIVATED' ) | ( 'pSUSPENDED' ) | ( 'pRESUMED' ) | ( 'pEXERTED' ) | ( 'pEXPIRED' ) | ( 'pTERMINATED' ) )
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
                    // InternalSymg.g:1547:2: ( 'pTRIGGERED' )
                    {
                    // InternalSymg.g:1547:2: ( 'pTRIGGERED' )
                    // InternalSymg.g:1548:3: 'pTRIGGERED'
                    {
                     before(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1553:2: ( 'pACTIVATED' )
                    {
                    // InternalSymg.g:1553:2: ( 'pACTIVATED' )
                    // InternalSymg.g:1554:3: 'pACTIVATED'
                    {
                     before(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1559:2: ( 'pSUSPENDED' )
                    {
                    // InternalSymg.g:1559:2: ( 'pSUSPENDED' )
                    // InternalSymg.g:1560:3: 'pSUSPENDED'
                    {
                     before(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1565:2: ( 'pRESUMED' )
                    {
                    // InternalSymg.g:1565:2: ( 'pRESUMED' )
                    // InternalSymg.g:1566:3: 'pRESUMED'
                    {
                     before(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1571:2: ( 'pEXERTED' )
                    {
                    // InternalSymg.g:1571:2: ( 'pEXERTED' )
                    // InternalSymg.g:1572:3: 'pEXERTED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1577:2: ( 'pEXPIRED' )
                    {
                    // InternalSymg.g:1577:2: ( 'pEXPIRED' )
                    // InternalSymg.g:1578:3: 'pEXPIRED'
                    {
                     before(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1583:2: ( 'pTERMINATED' )
                    {
                    // InternalSymg.g:1583:2: ( 'pTERMINATED' )
                    // InternalSymg.g:1584:3: 'pTERMINATED'
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
    // InternalSymg.g:1593:1: rule__ContrEvent__Alternatives : ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) );
    public final void rule__ContrEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1597:1: ( ( 'cACTIVATED' ) | ( 'cSUSPENDED' ) | ( 'cRESUMED' ) | ( 'cFULFILLED_ACTIVE_OBLS' ) | ( 'cREVOKED_PARTY' ) | ( 'cASSIGNED_PARTY' ) | ( 'cTERMINATED' ) )
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
                    // InternalSymg.g:1598:2: ( 'cACTIVATED' )
                    {
                    // InternalSymg.g:1598:2: ( 'cACTIVATED' )
                    // InternalSymg.g:1599:3: 'cACTIVATED'
                    {
                     before(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1604:2: ( 'cSUSPENDED' )
                    {
                    // InternalSymg.g:1604:2: ( 'cSUSPENDED' )
                    // InternalSymg.g:1605:3: 'cSUSPENDED'
                    {
                     before(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1610:2: ( 'cRESUMED' )
                    {
                    // InternalSymg.g:1610:2: ( 'cRESUMED' )
                    // InternalSymg.g:1611:3: 'cRESUMED'
                    {
                     before(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1616:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    {
                    // InternalSymg.g:1616:2: ( 'cFULFILLED_ACTIVE_OBLS' )
                    // InternalSymg.g:1617:3: 'cFULFILLED_ACTIVE_OBLS'
                    {
                     before(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1622:2: ( 'cREVOKED_PARTY' )
                    {
                    // InternalSymg.g:1622:2: ( 'cREVOKED_PARTY' )
                    // InternalSymg.g:1623:3: 'cREVOKED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1628:2: ( 'cASSIGNED_PARTY' )
                    {
                    // InternalSymg.g:1628:2: ( 'cASSIGNED_PARTY' )
                    // InternalSymg.g:1629:3: 'cASSIGNED_PARTY'
                    {
                     before(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1634:2: ( 'cTERMINATED' )
                    {
                    // InternalSymg.g:1634:2: ( 'cTERMINATED' )
                    // InternalSymg.g:1635:3: 'cTERMINATED'
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
    // InternalSymg.g:1644:1: rule__OblEvent__Alternatives : ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) );
    public final void rule__OblEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1648:1: ( ( 'oTRIGGERED' ) | ( 'oACTIVATED' ) | ( 'oSUSPENDED' ) | ( 'oRESUMED' ) | ( 'oDISCHARGED' ) | ( 'oEXPIRED' ) | ( 'oFULFILLED' ) | ( 'oVIOLATED' ) | ( 'oTERMINATED' ) )
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
                    // InternalSymg.g:1649:2: ( 'oTRIGGERED' )
                    {
                    // InternalSymg.g:1649:2: ( 'oTRIGGERED' )
                    // InternalSymg.g:1650:3: 'oTRIGGERED'
                    {
                     before(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1655:2: ( 'oACTIVATED' )
                    {
                    // InternalSymg.g:1655:2: ( 'oACTIVATED' )
                    // InternalSymg.g:1656:3: 'oACTIVATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1661:2: ( 'oSUSPENDED' )
                    {
                    // InternalSymg.g:1661:2: ( 'oSUSPENDED' )
                    // InternalSymg.g:1662:3: 'oSUSPENDED'
                    {
                     before(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1667:2: ( 'oRESUMED' )
                    {
                    // InternalSymg.g:1667:2: ( 'oRESUMED' )
                    // InternalSymg.g:1668:3: 'oRESUMED'
                    {
                     before(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getORESUMEDKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1673:2: ( 'oDISCHARGED' )
                    {
                    // InternalSymg.g:1673:2: ( 'oDISCHARGED' )
                    // InternalSymg.g:1674:3: 'oDISCHARGED'
                    {
                     before(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1679:2: ( 'oEXPIRED' )
                    {
                    // InternalSymg.g:1679:2: ( 'oEXPIRED' )
                    // InternalSymg.g:1680:3: 'oEXPIRED'
                    {
                     before(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1685:2: ( 'oFULFILLED' )
                    {
                    // InternalSymg.g:1685:2: ( 'oFULFILLED' )
                    // InternalSymg.g:1686:3: 'oFULFILLED'
                    {
                     before(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1691:2: ( 'oVIOLATED' )
                    {
                    // InternalSymg.g:1691:2: ( 'oVIOLATED' )
                    // InternalSymg.g:1692:3: 'oVIOLATED'
                    {
                     before(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalSymg.g:1697:2: ( 'oTERMINATED' )
                    {
                    // InternalSymg.g:1697:2: ( 'oTERMINATED' )
                    // InternalSymg.g:1698:3: 'oTERMINATED'
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
    // InternalSymg.g:1707:1: rule__OblState__Alternatives : ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oSUCCESSFUL_TERMINATION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) );
    public final void rule__OblState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1711:1: ( ( 'oCREATE' ) | ( 'oINEFFECT' ) | ( 'oSUSPENSION' ) | ( 'oSUCCESSFUL_TERMINATION' ) | ( 'oUNSUCCESSFUL_TERMINATION' ) | ( 'oVIOLATION' ) | ( 'oFULFILLMENT' ) | ( 'oDISCHARGE' ) )
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
                    // InternalSymg.g:1712:2: ( 'oCREATE' )
                    {
                    // InternalSymg.g:1712:2: ( 'oCREATE' )
                    // InternalSymg.g:1713:3: 'oCREATE'
                    {
                     before(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1718:2: ( 'oINEFFECT' )
                    {
                    // InternalSymg.g:1718:2: ( 'oINEFFECT' )
                    // InternalSymg.g:1719:3: 'oINEFFECT'
                    {
                     before(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1724:2: ( 'oSUSPENSION' )
                    {
                    // InternalSymg.g:1724:2: ( 'oSUSPENSION' )
                    // InternalSymg.g:1725:3: 'oSUSPENSION'
                    {
                     before(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1730:2: ( 'oSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1730:2: ( 'oSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1731:3: 'oSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1736:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1736:2: ( 'oUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1737:3: 'oUNSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1742:2: ( 'oVIOLATION' )
                    {
                    // InternalSymg.g:1742:2: ( 'oVIOLATION' )
                    // InternalSymg.g:1743:3: 'oVIOLATION'
                    {
                     before(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:1748:2: ( 'oFULFILLMENT' )
                    {
                    // InternalSymg.g:1748:2: ( 'oFULFILLMENT' )
                    // InternalSymg.g:1749:3: 'oFULFILLMENT'
                    {
                     before(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalSymg.g:1754:2: ( 'oDISCHARGE' )
                    {
                    // InternalSymg.g:1754:2: ( 'oDISCHARGE' )
                    // InternalSymg.g:1755:3: 'oDISCHARGE'
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
    // InternalSymg.g:1764:1: rule__ContrState__Alternatives : ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) );
    public final void rule__ContrState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1768:1: ( ( 'cFORM' ) | ( 'cINEFFECT' ) | ( 'cSUSPENSION' ) | ( 'cSUCCESSFUL_TERMINATION' ) | ( 'cUNSECCESSFUL_TERMINATION' ) | ( 'cUNASSIGN' ) )
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
                    // InternalSymg.g:1769:2: ( 'cFORM' )
                    {
                    // InternalSymg.g:1769:2: ( 'cFORM' )
                    // InternalSymg.g:1770:3: 'cFORM'
                    {
                     before(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCFORMKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1775:2: ( 'cINEFFECT' )
                    {
                    // InternalSymg.g:1775:2: ( 'cINEFFECT' )
                    // InternalSymg.g:1776:3: 'cINEFFECT'
                    {
                     before(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1781:2: ( 'cSUSPENSION' )
                    {
                    // InternalSymg.g:1781:2: ( 'cSUSPENSION' )
                    // InternalSymg.g:1782:3: 'cSUSPENSION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1787:2: ( 'cSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1787:2: ( 'cSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1788:3: 'cSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1793:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1793:2: ( 'cUNSECCESSFUL_TERMINATION' )
                    // InternalSymg.g:1794:3: 'cUNSECCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:1799:2: ( 'cUNASSIGN' )
                    {
                    // InternalSymg.g:1799:2: ( 'cUNASSIGN' )
                    // InternalSymg.g:1800:3: 'cUNASSIGN'
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
    // InternalSymg.g:1809:1: rule__PowState__Alternatives : ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) );
    public final void rule__PowState__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1813:1: ( ( 'pCREATE' ) | ( 'pINEFFECT' ) | ( 'pSUSPENSION' ) | ( 'pSUCCESSFUL_TERMINATION' ) | ( 'pUNSUCCESSFUL_TERMINATION' ) )
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
                    // InternalSymg.g:1814:2: ( 'pCREATE' )
                    {
                    // InternalSymg.g:1814:2: ( 'pCREATE' )
                    // InternalSymg.g:1815:3: 'pCREATE'
                    {
                     before(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPCREATEKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1820:2: ( 'pINEFFECT' )
                    {
                    // InternalSymg.g:1820:2: ( 'pINEFFECT' )
                    // InternalSymg.g:1821:3: 'pINEFFECT'
                    {
                     before(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1826:2: ( 'pSUSPENSION' )
                    {
                    // InternalSymg.g:1826:2: ( 'pSUSPENSION' )
                    // InternalSymg.g:1827:3: 'pSUSPENSION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1832:2: ( 'pSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1832:2: ( 'pSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1833:3: 'pSUCCESSFUL_TERMINATION'
                    {
                     before(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1838:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    {
                    // InternalSymg.g:1838:2: ( 'pUNSUCCESSFUL_TERMINATION' )
                    // InternalSymg.g:1839:3: 'pUNSUCCESSFUL_TERMINATION'
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
    // InternalSymg.g:1848:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1852:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalSymg.g:1853:2: rule__Model__Group__0__Impl rule__Model__Group__1
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
    // InternalSymg.g:1860:1: rule__Model__Group__0__Impl : ( 'Domain' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1864:1: ( ( 'Domain' ) )
            // InternalSymg.g:1865:1: ( 'Domain' )
            {
            // InternalSymg.g:1865:1: ( 'Domain' )
            // InternalSymg.g:1866:2: 'Domain'
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
    // InternalSymg.g:1875:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1879:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalSymg.g:1880:2: rule__Model__Group__1__Impl rule__Model__Group__2
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
    // InternalSymg.g:1887:1: rule__Model__Group__1__Impl : ( ( rule__Model__DomainNameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1891:1: ( ( ( rule__Model__DomainNameAssignment_1 ) ) )
            // InternalSymg.g:1892:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            {
            // InternalSymg.g:1892:1: ( ( rule__Model__DomainNameAssignment_1 ) )
            // InternalSymg.g:1893:2: ( rule__Model__DomainNameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getDomainNameAssignment_1()); 
            // InternalSymg.g:1894:2: ( rule__Model__DomainNameAssignment_1 )
            // InternalSymg.g:1894:3: rule__Model__DomainNameAssignment_1
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
    // InternalSymg.g:1902:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1906:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalSymg.g:1907:2: rule__Model__Group__2__Impl rule__Model__Group__3
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
    // InternalSymg.g:1914:1: rule__Model__Group__2__Impl : ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1918:1: ( ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) ) )
            // InternalSymg.g:1919:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            {
            // InternalSymg.g:1919:1: ( ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* ) )
            // InternalSymg.g:1920:2: ( ( rule__Model__Group_2__0 ) ) ( ( rule__Model__Group_2__0 )* )
            {
            // InternalSymg.g:1920:2: ( ( rule__Model__Group_2__0 ) )
            // InternalSymg.g:1921:3: ( rule__Model__Group_2__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:1922:3: ( rule__Model__Group_2__0 )
            // InternalSymg.g:1922:4: rule__Model__Group_2__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_2()); 

            }

            // InternalSymg.g:1925:2: ( ( rule__Model__Group_2__0 )* )
            // InternalSymg.g:1926:3: ( rule__Model__Group_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_2()); 
            // InternalSymg.g:1927:3: ( rule__Model__Group_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSymg.g:1927:4: rule__Model__Group_2__0
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
    // InternalSymg.g:1936:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1940:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalSymg.g:1941:2: rule__Model__Group__3__Impl rule__Model__Group__4
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
    // InternalSymg.g:1948:1: rule__Model__Group__3__Impl : ( 'endDomain' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1952:1: ( ( 'endDomain' ) )
            // InternalSymg.g:1953:1: ( 'endDomain' )
            {
            // InternalSymg.g:1953:1: ( 'endDomain' )
            // InternalSymg.g:1954:2: 'endDomain'
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
    // InternalSymg.g:1963:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1967:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalSymg.g:1968:2: rule__Model__Group__4__Impl rule__Model__Group__5
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
    // InternalSymg.g:1975:1: rule__Model__Group__4__Impl : ( 'Contract' ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1979:1: ( ( 'Contract' ) )
            // InternalSymg.g:1980:1: ( 'Contract' )
            {
            // InternalSymg.g:1980:1: ( 'Contract' )
            // InternalSymg.g:1981:2: 'Contract'
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
    // InternalSymg.g:1990:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:1994:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // InternalSymg.g:1995:2: rule__Model__Group__5__Impl rule__Model__Group__6
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
    // InternalSymg.g:2002:1: rule__Model__Group__5__Impl : ( ( rule__Model__ContractNameAssignment_5 ) ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2006:1: ( ( ( rule__Model__ContractNameAssignment_5 ) ) )
            // InternalSymg.g:2007:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            {
            // InternalSymg.g:2007:1: ( ( rule__Model__ContractNameAssignment_5 ) )
            // InternalSymg.g:2008:2: ( rule__Model__ContractNameAssignment_5 )
            {
             before(grammarAccess.getModelAccess().getContractNameAssignment_5()); 
            // InternalSymg.g:2009:2: ( rule__Model__ContractNameAssignment_5 )
            // InternalSymg.g:2009:3: rule__Model__ContractNameAssignment_5
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
    // InternalSymg.g:2017:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2021:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // InternalSymg.g:2022:2: rule__Model__Group__6__Impl rule__Model__Group__7
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
    // InternalSymg.g:2029:1: rule__Model__Group__6__Impl : ( '(' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2033:1: ( ( '(' ) )
            // InternalSymg.g:2034:1: ( '(' )
            {
            // InternalSymg.g:2034:1: ( '(' )
            // InternalSymg.g:2035:2: '('
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
    // InternalSymg.g:2044:1: rule__Model__Group__7 : rule__Model__Group__7__Impl rule__Model__Group__8 ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2048:1: ( rule__Model__Group__7__Impl rule__Model__Group__8 )
            // InternalSymg.g:2049:2: rule__Model__Group__7__Impl rule__Model__Group__8
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
    // InternalSymg.g:2056:1: rule__Model__Group__7__Impl : ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2060:1: ( ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) ) )
            // InternalSymg.g:2061:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            {
            // InternalSymg.g:2061:1: ( ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* ) )
            // InternalSymg.g:2062:2: ( ( rule__Model__Group_7__0 ) ) ( ( rule__Model__Group_7__0 )* )
            {
            // InternalSymg.g:2062:2: ( ( rule__Model__Group_7__0 ) )
            // InternalSymg.g:2063:3: ( rule__Model__Group_7__0 )
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2064:3: ( rule__Model__Group_7__0 )
            // InternalSymg.g:2064:4: rule__Model__Group_7__0
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_7__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup_7()); 

            }

            // InternalSymg.g:2067:2: ( ( rule__Model__Group_7__0 )* )
            // InternalSymg.g:2068:3: ( rule__Model__Group_7__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_7()); 
            // InternalSymg.g:2069:3: ( rule__Model__Group_7__0 )*
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
            	    // InternalSymg.g:2069:4: rule__Model__Group_7__0
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
    // InternalSymg.g:2078:1: rule__Model__Group__8 : rule__Model__Group__8__Impl rule__Model__Group__9 ;
    public final void rule__Model__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2082:1: ( rule__Model__Group__8__Impl rule__Model__Group__9 )
            // InternalSymg.g:2083:2: rule__Model__Group__8__Impl rule__Model__Group__9
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
    // InternalSymg.g:2090:1: rule__Model__Group__8__Impl : ( ( rule__Model__ParametersAssignment_8 ) ) ;
    public final void rule__Model__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2094:1: ( ( ( rule__Model__ParametersAssignment_8 ) ) )
            // InternalSymg.g:2095:1: ( ( rule__Model__ParametersAssignment_8 ) )
            {
            // InternalSymg.g:2095:1: ( ( rule__Model__ParametersAssignment_8 ) )
            // InternalSymg.g:2096:2: ( rule__Model__ParametersAssignment_8 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_8()); 
            // InternalSymg.g:2097:2: ( rule__Model__ParametersAssignment_8 )
            // InternalSymg.g:2097:3: rule__Model__ParametersAssignment_8
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
    // InternalSymg.g:2105:1: rule__Model__Group__9 : rule__Model__Group__9__Impl rule__Model__Group__10 ;
    public final void rule__Model__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2109:1: ( rule__Model__Group__9__Impl rule__Model__Group__10 )
            // InternalSymg.g:2110:2: rule__Model__Group__9__Impl rule__Model__Group__10
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
    // InternalSymg.g:2117:1: rule__Model__Group__9__Impl : ( ')' ) ;
    public final void rule__Model__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2121:1: ( ( ')' ) )
            // InternalSymg.g:2122:1: ( ')' )
            {
            // InternalSymg.g:2122:1: ( ')' )
            // InternalSymg.g:2123:2: ')'
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
    // InternalSymg.g:2132:1: rule__Model__Group__10 : rule__Model__Group__10__Impl rule__Model__Group__11 ;
    public final void rule__Model__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2136:1: ( rule__Model__Group__10__Impl rule__Model__Group__11 )
            // InternalSymg.g:2137:2: rule__Model__Group__10__Impl rule__Model__Group__11
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
    // InternalSymg.g:2144:1: rule__Model__Group__10__Impl : ( ( rule__Model__Group_10__0 )? ) ;
    public final void rule__Model__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2148:1: ( ( ( rule__Model__Group_10__0 )? ) )
            // InternalSymg.g:2149:1: ( ( rule__Model__Group_10__0 )? )
            {
            // InternalSymg.g:2149:1: ( ( rule__Model__Group_10__0 )? )
            // InternalSymg.g:2150:2: ( rule__Model__Group_10__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_10()); 
            // InternalSymg.g:2151:2: ( rule__Model__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==83) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalSymg.g:2151:3: rule__Model__Group_10__0
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
    // InternalSymg.g:2159:1: rule__Model__Group__11 : rule__Model__Group__11__Impl rule__Model__Group__12 ;
    public final void rule__Model__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2163:1: ( rule__Model__Group__11__Impl rule__Model__Group__12 )
            // InternalSymg.g:2164:2: rule__Model__Group__11__Impl rule__Model__Group__12
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
    // InternalSymg.g:2171:1: rule__Model__Group__11__Impl : ( ( rule__Model__Group_11__0 )? ) ;
    public final void rule__Model__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2175:1: ( ( ( rule__Model__Group_11__0 )? ) )
            // InternalSymg.g:2176:1: ( ( rule__Model__Group_11__0 )? )
            {
            // InternalSymg.g:2176:1: ( ( rule__Model__Group_11__0 )? )
            // InternalSymg.g:2177:2: ( rule__Model__Group_11__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_11()); 
            // InternalSymg.g:2178:2: ( rule__Model__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==84) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSymg.g:2178:3: rule__Model__Group_11__0
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
    // InternalSymg.g:2186:1: rule__Model__Group__12 : rule__Model__Group__12__Impl rule__Model__Group__13 ;
    public final void rule__Model__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2190:1: ( rule__Model__Group__12__Impl rule__Model__Group__13 )
            // InternalSymg.g:2191:2: rule__Model__Group__12__Impl rule__Model__Group__13
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
    // InternalSymg.g:2198:1: rule__Model__Group__12__Impl : ( ( rule__Model__Group_12__0 )? ) ;
    public final void rule__Model__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2202:1: ( ( ( rule__Model__Group_12__0 )? ) )
            // InternalSymg.g:2203:1: ( ( rule__Model__Group_12__0 )? )
            {
            // InternalSymg.g:2203:1: ( ( rule__Model__Group_12__0 )? )
            // InternalSymg.g:2204:2: ( rule__Model__Group_12__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_12()); 
            // InternalSymg.g:2205:2: ( rule__Model__Group_12__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==85) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSymg.g:2205:3: rule__Model__Group_12__0
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
    // InternalSymg.g:2213:1: rule__Model__Group__13 : rule__Model__Group__13__Impl rule__Model__Group__14 ;
    public final void rule__Model__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2217:1: ( rule__Model__Group__13__Impl rule__Model__Group__14 )
            // InternalSymg.g:2218:2: rule__Model__Group__13__Impl rule__Model__Group__14
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
    // InternalSymg.g:2225:1: rule__Model__Group__13__Impl : ( ( rule__Model__Group_13__0 )? ) ;
    public final void rule__Model__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2229:1: ( ( ( rule__Model__Group_13__0 )? ) )
            // InternalSymg.g:2230:1: ( ( rule__Model__Group_13__0 )? )
            {
            // InternalSymg.g:2230:1: ( ( rule__Model__Group_13__0 )? )
            // InternalSymg.g:2231:2: ( rule__Model__Group_13__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_13()); 
            // InternalSymg.g:2232:2: ( rule__Model__Group_13__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==86) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSymg.g:2232:3: rule__Model__Group_13__0
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
    // InternalSymg.g:2240:1: rule__Model__Group__14 : rule__Model__Group__14__Impl rule__Model__Group__15 ;
    public final void rule__Model__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2244:1: ( rule__Model__Group__14__Impl rule__Model__Group__15 )
            // InternalSymg.g:2245:2: rule__Model__Group__14__Impl rule__Model__Group__15
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
    // InternalSymg.g:2252:1: rule__Model__Group__14__Impl : ( ( rule__Model__Group_14__0 )? ) ;
    public final void rule__Model__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2256:1: ( ( ( rule__Model__Group_14__0 )? ) )
            // InternalSymg.g:2257:1: ( ( rule__Model__Group_14__0 )? )
            {
            // InternalSymg.g:2257:1: ( ( rule__Model__Group_14__0 )? )
            // InternalSymg.g:2258:2: ( rule__Model__Group_14__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_14()); 
            // InternalSymg.g:2259:2: ( rule__Model__Group_14__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==87) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymg.g:2259:3: rule__Model__Group_14__0
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
    // InternalSymg.g:2267:1: rule__Model__Group__15 : rule__Model__Group__15__Impl rule__Model__Group__16 ;
    public final void rule__Model__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2271:1: ( rule__Model__Group__15__Impl rule__Model__Group__16 )
            // InternalSymg.g:2272:2: rule__Model__Group__15__Impl rule__Model__Group__16
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
    // InternalSymg.g:2279:1: rule__Model__Group__15__Impl : ( ( rule__Model__Group_15__0 )? ) ;
    public final void rule__Model__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2283:1: ( ( ( rule__Model__Group_15__0 )? ) )
            // InternalSymg.g:2284:1: ( ( rule__Model__Group_15__0 )? )
            {
            // InternalSymg.g:2284:1: ( ( rule__Model__Group_15__0 )? )
            // InternalSymg.g:2285:2: ( rule__Model__Group_15__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_15()); 
            // InternalSymg.g:2286:2: ( rule__Model__Group_15__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==88) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSymg.g:2286:3: rule__Model__Group_15__0
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
    // InternalSymg.g:2294:1: rule__Model__Group__16 : rule__Model__Group__16__Impl rule__Model__Group__17 ;
    public final void rule__Model__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2298:1: ( rule__Model__Group__16__Impl rule__Model__Group__17 )
            // InternalSymg.g:2299:2: rule__Model__Group__16__Impl rule__Model__Group__17
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
    // InternalSymg.g:2306:1: rule__Model__Group__16__Impl : ( ( rule__Model__Group_16__0 )? ) ;
    public final void rule__Model__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2310:1: ( ( ( rule__Model__Group_16__0 )? ) )
            // InternalSymg.g:2311:1: ( ( rule__Model__Group_16__0 )? )
            {
            // InternalSymg.g:2311:1: ( ( rule__Model__Group_16__0 )? )
            // InternalSymg.g:2312:2: ( rule__Model__Group_16__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_16()); 
            // InternalSymg.g:2313:2: ( rule__Model__Group_16__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==89) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalSymg.g:2313:3: rule__Model__Group_16__0
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
    // InternalSymg.g:2321:1: rule__Model__Group__17 : rule__Model__Group__17__Impl ;
    public final void rule__Model__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2325:1: ( rule__Model__Group__17__Impl )
            // InternalSymg.g:2326:2: rule__Model__Group__17__Impl
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
    // InternalSymg.g:2332:1: rule__Model__Group__17__Impl : ( 'endContract' ) ;
    public final void rule__Model__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2336:1: ( ( 'endContract' ) )
            // InternalSymg.g:2337:1: ( 'endContract' )
            {
            // InternalSymg.g:2337:1: ( 'endContract' )
            // InternalSymg.g:2338:2: 'endContract'
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
    // InternalSymg.g:2348:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2352:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalSymg.g:2353:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalSymg.g:2360:1: rule__Model__Group_2__0__Impl : ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2364:1: ( ( ( rule__Model__DomainConceptsAssignment_2_0 ) ) )
            // InternalSymg.g:2365:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            {
            // InternalSymg.g:2365:1: ( ( rule__Model__DomainConceptsAssignment_2_0 ) )
            // InternalSymg.g:2366:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            {
             before(grammarAccess.getModelAccess().getDomainConceptsAssignment_2_0()); 
            // InternalSymg.g:2367:2: ( rule__Model__DomainConceptsAssignment_2_0 )
            // InternalSymg.g:2367:3: rule__Model__DomainConceptsAssignment_2_0
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
    // InternalSymg.g:2375:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2379:1: ( rule__Model__Group_2__1__Impl )
            // InternalSymg.g:2380:2: rule__Model__Group_2__1__Impl
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
    // InternalSymg.g:2386:1: rule__Model__Group_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2390:1: ( ( ';' ) )
            // InternalSymg.g:2391:1: ( ';' )
            {
            // InternalSymg.g:2391:1: ( ';' )
            // InternalSymg.g:2392:2: ';'
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
    // InternalSymg.g:2402:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2406:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalSymg.g:2407:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
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
    // InternalSymg.g:2414:1: rule__Model__Group_7__0__Impl : ( ( rule__Model__ParametersAssignment_7_0 ) ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2418:1: ( ( ( rule__Model__ParametersAssignment_7_0 ) ) )
            // InternalSymg.g:2419:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            {
            // InternalSymg.g:2419:1: ( ( rule__Model__ParametersAssignment_7_0 ) )
            // InternalSymg.g:2420:2: ( rule__Model__ParametersAssignment_7_0 )
            {
             before(grammarAccess.getModelAccess().getParametersAssignment_7_0()); 
            // InternalSymg.g:2421:2: ( rule__Model__ParametersAssignment_7_0 )
            // InternalSymg.g:2421:3: rule__Model__ParametersAssignment_7_0
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
    // InternalSymg.g:2429:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2433:1: ( rule__Model__Group_7__1__Impl )
            // InternalSymg.g:2434:2: rule__Model__Group_7__1__Impl
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
    // InternalSymg.g:2440:1: rule__Model__Group_7__1__Impl : ( ',' ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2444:1: ( ( ',' ) )
            // InternalSymg.g:2445:1: ( ',' )
            {
            // InternalSymg.g:2445:1: ( ',' )
            // InternalSymg.g:2446:2: ','
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
    // InternalSymg.g:2456:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2460:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalSymg.g:2461:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
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
    // InternalSymg.g:2468:1: rule__Model__Group_10__0__Impl : ( 'Declarations' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2472:1: ( ( 'Declarations' ) )
            // InternalSymg.g:2473:1: ( 'Declarations' )
            {
            // InternalSymg.g:2473:1: ( 'Declarations' )
            // InternalSymg.g:2474:2: 'Declarations'
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
    // InternalSymg.g:2483:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2487:1: ( rule__Model__Group_10__1__Impl )
            // InternalSymg.g:2488:2: rule__Model__Group_10__1__Impl
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
    // InternalSymg.g:2494:1: rule__Model__Group_10__1__Impl : ( ( rule__Model__Group_10_1__0 )* ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2498:1: ( ( ( rule__Model__Group_10_1__0 )* ) )
            // InternalSymg.g:2499:1: ( ( rule__Model__Group_10_1__0 )* )
            {
            // InternalSymg.g:2499:1: ( ( rule__Model__Group_10_1__0 )* )
            // InternalSymg.g:2500:2: ( rule__Model__Group_10_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_10_1()); 
            // InternalSymg.g:2501:2: ( rule__Model__Group_10_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSymg.g:2501:3: rule__Model__Group_10_1__0
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
    // InternalSymg.g:2510:1: rule__Model__Group_10_1__0 : rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 ;
    public final void rule__Model__Group_10_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2514:1: ( rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1 )
            // InternalSymg.g:2515:2: rule__Model__Group_10_1__0__Impl rule__Model__Group_10_1__1
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
    // InternalSymg.g:2522:1: rule__Model__Group_10_1__0__Impl : ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) ;
    public final void rule__Model__Group_10_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2526:1: ( ( ( rule__Model__DeclarationsAssignment_10_1_0 ) ) )
            // InternalSymg.g:2527:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            {
            // InternalSymg.g:2527:1: ( ( rule__Model__DeclarationsAssignment_10_1_0 ) )
            // InternalSymg.g:2528:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            {
             before(grammarAccess.getModelAccess().getDeclarationsAssignment_10_1_0()); 
            // InternalSymg.g:2529:2: ( rule__Model__DeclarationsAssignment_10_1_0 )
            // InternalSymg.g:2529:3: rule__Model__DeclarationsAssignment_10_1_0
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
    // InternalSymg.g:2537:1: rule__Model__Group_10_1__1 : rule__Model__Group_10_1__1__Impl ;
    public final void rule__Model__Group_10_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2541:1: ( rule__Model__Group_10_1__1__Impl )
            // InternalSymg.g:2542:2: rule__Model__Group_10_1__1__Impl
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
    // InternalSymg.g:2548:1: rule__Model__Group_10_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_10_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2552:1: ( ( ';' ) )
            // InternalSymg.g:2553:1: ( ';' )
            {
            // InternalSymg.g:2553:1: ( ';' )
            // InternalSymg.g:2554:2: ';'
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
    // InternalSymg.g:2564:1: rule__Model__Group_11__0 : rule__Model__Group_11__0__Impl rule__Model__Group_11__1 ;
    public final void rule__Model__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2568:1: ( rule__Model__Group_11__0__Impl rule__Model__Group_11__1 )
            // InternalSymg.g:2569:2: rule__Model__Group_11__0__Impl rule__Model__Group_11__1
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
    // InternalSymg.g:2576:1: rule__Model__Group_11__0__Impl : ( 'Preconditions' ) ;
    public final void rule__Model__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2580:1: ( ( 'Preconditions' ) )
            // InternalSymg.g:2581:1: ( 'Preconditions' )
            {
            // InternalSymg.g:2581:1: ( 'Preconditions' )
            // InternalSymg.g:2582:2: 'Preconditions'
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
    // InternalSymg.g:2591:1: rule__Model__Group_11__1 : rule__Model__Group_11__1__Impl ;
    public final void rule__Model__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2595:1: ( rule__Model__Group_11__1__Impl )
            // InternalSymg.g:2596:2: rule__Model__Group_11__1__Impl
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
    // InternalSymg.g:2602:1: rule__Model__Group_11__1__Impl : ( ( rule__Model__Group_11_1__0 )* ) ;
    public final void rule__Model__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2606:1: ( ( ( rule__Model__Group_11_1__0 )* ) )
            // InternalSymg.g:2607:1: ( ( rule__Model__Group_11_1__0 )* )
            {
            // InternalSymg.g:2607:1: ( ( rule__Model__Group_11_1__0 )* )
            // InternalSymg.g:2608:2: ( rule__Model__Group_11_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_11_1()); 
            // InternalSymg.g:2609:2: ( rule__Model__Group_11_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_INT)||(LA30_0>=33 && LA30_0<=74)||LA30_0==78||(LA30_0>=100 && LA30_0<=101)||(LA30_0>=105 && LA30_0<=107)||LA30_0==109) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSymg.g:2609:3: rule__Model__Group_11_1__0
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
    // InternalSymg.g:2618:1: rule__Model__Group_11_1__0 : rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 ;
    public final void rule__Model__Group_11_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2622:1: ( rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1 )
            // InternalSymg.g:2623:2: rule__Model__Group_11_1__0__Impl rule__Model__Group_11_1__1
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
    // InternalSymg.g:2630:1: rule__Model__Group_11_1__0__Impl : ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) ;
    public final void rule__Model__Group_11_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2634:1: ( ( ( rule__Model__PreconditionsAssignment_11_1_0 ) ) )
            // InternalSymg.g:2635:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            {
            // InternalSymg.g:2635:1: ( ( rule__Model__PreconditionsAssignment_11_1_0 ) )
            // InternalSymg.g:2636:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            {
             before(grammarAccess.getModelAccess().getPreconditionsAssignment_11_1_0()); 
            // InternalSymg.g:2637:2: ( rule__Model__PreconditionsAssignment_11_1_0 )
            // InternalSymg.g:2637:3: rule__Model__PreconditionsAssignment_11_1_0
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
    // InternalSymg.g:2645:1: rule__Model__Group_11_1__1 : rule__Model__Group_11_1__1__Impl ;
    public final void rule__Model__Group_11_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2649:1: ( rule__Model__Group_11_1__1__Impl )
            // InternalSymg.g:2650:2: rule__Model__Group_11_1__1__Impl
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
    // InternalSymg.g:2656:1: rule__Model__Group_11_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_11_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2660:1: ( ( ';' ) )
            // InternalSymg.g:2661:1: ( ';' )
            {
            // InternalSymg.g:2661:1: ( ';' )
            // InternalSymg.g:2662:2: ';'
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
    // InternalSymg.g:2672:1: rule__Model__Group_12__0 : rule__Model__Group_12__0__Impl rule__Model__Group_12__1 ;
    public final void rule__Model__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2676:1: ( rule__Model__Group_12__0__Impl rule__Model__Group_12__1 )
            // InternalSymg.g:2677:2: rule__Model__Group_12__0__Impl rule__Model__Group_12__1
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
    // InternalSymg.g:2684:1: rule__Model__Group_12__0__Impl : ( 'Postconditions' ) ;
    public final void rule__Model__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2688:1: ( ( 'Postconditions' ) )
            // InternalSymg.g:2689:1: ( 'Postconditions' )
            {
            // InternalSymg.g:2689:1: ( 'Postconditions' )
            // InternalSymg.g:2690:2: 'Postconditions'
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
    // InternalSymg.g:2699:1: rule__Model__Group_12__1 : rule__Model__Group_12__1__Impl ;
    public final void rule__Model__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2703:1: ( rule__Model__Group_12__1__Impl )
            // InternalSymg.g:2704:2: rule__Model__Group_12__1__Impl
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
    // InternalSymg.g:2710:1: rule__Model__Group_12__1__Impl : ( ( rule__Model__Group_12_1__0 )* ) ;
    public final void rule__Model__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2714:1: ( ( ( rule__Model__Group_12_1__0 )* ) )
            // InternalSymg.g:2715:1: ( ( rule__Model__Group_12_1__0 )* )
            {
            // InternalSymg.g:2715:1: ( ( rule__Model__Group_12_1__0 )* )
            // InternalSymg.g:2716:2: ( rule__Model__Group_12_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_12_1()); 
            // InternalSymg.g:2717:2: ( rule__Model__Group_12_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_ID && LA31_0<=RULE_INT)||(LA31_0>=33 && LA31_0<=74)||LA31_0==78||(LA31_0>=100 && LA31_0<=101)||(LA31_0>=105 && LA31_0<=107)||LA31_0==109) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSymg.g:2717:3: rule__Model__Group_12_1__0
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
    // InternalSymg.g:2726:1: rule__Model__Group_12_1__0 : rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 ;
    public final void rule__Model__Group_12_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2730:1: ( rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1 )
            // InternalSymg.g:2731:2: rule__Model__Group_12_1__0__Impl rule__Model__Group_12_1__1
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
    // InternalSymg.g:2738:1: rule__Model__Group_12_1__0__Impl : ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) ;
    public final void rule__Model__Group_12_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2742:1: ( ( ( rule__Model__PostconditionsAssignment_12_1_0 ) ) )
            // InternalSymg.g:2743:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            {
            // InternalSymg.g:2743:1: ( ( rule__Model__PostconditionsAssignment_12_1_0 ) )
            // InternalSymg.g:2744:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            {
             before(grammarAccess.getModelAccess().getPostconditionsAssignment_12_1_0()); 
            // InternalSymg.g:2745:2: ( rule__Model__PostconditionsAssignment_12_1_0 )
            // InternalSymg.g:2745:3: rule__Model__PostconditionsAssignment_12_1_0
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
    // InternalSymg.g:2753:1: rule__Model__Group_12_1__1 : rule__Model__Group_12_1__1__Impl ;
    public final void rule__Model__Group_12_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2757:1: ( rule__Model__Group_12_1__1__Impl )
            // InternalSymg.g:2758:2: rule__Model__Group_12_1__1__Impl
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
    // InternalSymg.g:2764:1: rule__Model__Group_12_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_12_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2768:1: ( ( ';' ) )
            // InternalSymg.g:2769:1: ( ';' )
            {
            // InternalSymg.g:2769:1: ( ';' )
            // InternalSymg.g:2770:2: ';'
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
    // InternalSymg.g:2780:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2784:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalSymg.g:2785:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
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
    // InternalSymg.g:2792:1: rule__Model__Group_13__0__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2796:1: ( ( 'Obligations' ) )
            // InternalSymg.g:2797:1: ( 'Obligations' )
            {
            // InternalSymg.g:2797:1: ( 'Obligations' )
            // InternalSymg.g:2798:2: 'Obligations'
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
    // InternalSymg.g:2807:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2811:1: ( rule__Model__Group_13__1__Impl )
            // InternalSymg.g:2812:2: rule__Model__Group_13__1__Impl
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
    // InternalSymg.g:2818:1: rule__Model__Group_13__1__Impl : ( ( rule__Model__Group_13_1__0 )* ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2822:1: ( ( ( rule__Model__Group_13_1__0 )* ) )
            // InternalSymg.g:2823:1: ( ( rule__Model__Group_13_1__0 )* )
            {
            // InternalSymg.g:2823:1: ( ( rule__Model__Group_13_1__0 )* )
            // InternalSymg.g:2824:2: ( rule__Model__Group_13_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_13_1()); 
            // InternalSymg.g:2825:2: ( rule__Model__Group_13_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSymg.g:2825:3: rule__Model__Group_13_1__0
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
    // InternalSymg.g:2834:1: rule__Model__Group_13_1__0 : rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 ;
    public final void rule__Model__Group_13_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2838:1: ( rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1 )
            // InternalSymg.g:2839:2: rule__Model__Group_13_1__0__Impl rule__Model__Group_13_1__1
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
    // InternalSymg.g:2846:1: rule__Model__Group_13_1__0__Impl : ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) ;
    public final void rule__Model__Group_13_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2850:1: ( ( ( rule__Model__ObligationsAssignment_13_1_0 ) ) )
            // InternalSymg.g:2851:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            {
            // InternalSymg.g:2851:1: ( ( rule__Model__ObligationsAssignment_13_1_0 ) )
            // InternalSymg.g:2852:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            {
             before(grammarAccess.getModelAccess().getObligationsAssignment_13_1_0()); 
            // InternalSymg.g:2853:2: ( rule__Model__ObligationsAssignment_13_1_0 )
            // InternalSymg.g:2853:3: rule__Model__ObligationsAssignment_13_1_0
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
    // InternalSymg.g:2861:1: rule__Model__Group_13_1__1 : rule__Model__Group_13_1__1__Impl ;
    public final void rule__Model__Group_13_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2865:1: ( rule__Model__Group_13_1__1__Impl )
            // InternalSymg.g:2866:2: rule__Model__Group_13_1__1__Impl
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
    // InternalSymg.g:2872:1: rule__Model__Group_13_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_13_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2876:1: ( ( ';' ) )
            // InternalSymg.g:2877:1: ( ';' )
            {
            // InternalSymg.g:2877:1: ( ';' )
            // InternalSymg.g:2878:2: ';'
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
    // InternalSymg.g:2888:1: rule__Model__Group_14__0 : rule__Model__Group_14__0__Impl rule__Model__Group_14__1 ;
    public final void rule__Model__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2892:1: ( rule__Model__Group_14__0__Impl rule__Model__Group_14__1 )
            // InternalSymg.g:2893:2: rule__Model__Group_14__0__Impl rule__Model__Group_14__1
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
    // InternalSymg.g:2900:1: rule__Model__Group_14__0__Impl : ( 'Surviving' ) ;
    public final void rule__Model__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2904:1: ( ( 'Surviving' ) )
            // InternalSymg.g:2905:1: ( 'Surviving' )
            {
            // InternalSymg.g:2905:1: ( 'Surviving' )
            // InternalSymg.g:2906:2: 'Surviving'
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
    // InternalSymg.g:2915:1: rule__Model__Group_14__1 : rule__Model__Group_14__1__Impl rule__Model__Group_14__2 ;
    public final void rule__Model__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2919:1: ( rule__Model__Group_14__1__Impl rule__Model__Group_14__2 )
            // InternalSymg.g:2920:2: rule__Model__Group_14__1__Impl rule__Model__Group_14__2
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
    // InternalSymg.g:2927:1: rule__Model__Group_14__1__Impl : ( 'Obligations' ) ;
    public final void rule__Model__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2931:1: ( ( 'Obligations' ) )
            // InternalSymg.g:2932:1: ( 'Obligations' )
            {
            // InternalSymg.g:2932:1: ( 'Obligations' )
            // InternalSymg.g:2933:2: 'Obligations'
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
    // InternalSymg.g:2942:1: rule__Model__Group_14__2 : rule__Model__Group_14__2__Impl ;
    public final void rule__Model__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2946:1: ( rule__Model__Group_14__2__Impl )
            // InternalSymg.g:2947:2: rule__Model__Group_14__2__Impl
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
    // InternalSymg.g:2953:1: rule__Model__Group_14__2__Impl : ( ( rule__Model__Group_14_2__0 )* ) ;
    public final void rule__Model__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2957:1: ( ( ( rule__Model__Group_14_2__0 )* ) )
            // InternalSymg.g:2958:1: ( ( rule__Model__Group_14_2__0 )* )
            {
            // InternalSymg.g:2958:1: ( ( rule__Model__Group_14_2__0 )* )
            // InternalSymg.g:2959:2: ( rule__Model__Group_14_2__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_14_2()); 
            // InternalSymg.g:2960:2: ( rule__Model__Group_14_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSymg.g:2960:3: rule__Model__Group_14_2__0
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
    // InternalSymg.g:2969:1: rule__Model__Group_14_2__0 : rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 ;
    public final void rule__Model__Group_14_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2973:1: ( rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1 )
            // InternalSymg.g:2974:2: rule__Model__Group_14_2__0__Impl rule__Model__Group_14_2__1
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
    // InternalSymg.g:2981:1: rule__Model__Group_14_2__0__Impl : ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) ;
    public final void rule__Model__Group_14_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:2985:1: ( ( ( rule__Model__SobligationsAssignment_14_2_0 ) ) )
            // InternalSymg.g:2986:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            {
            // InternalSymg.g:2986:1: ( ( rule__Model__SobligationsAssignment_14_2_0 ) )
            // InternalSymg.g:2987:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            {
             before(grammarAccess.getModelAccess().getSobligationsAssignment_14_2_0()); 
            // InternalSymg.g:2988:2: ( rule__Model__SobligationsAssignment_14_2_0 )
            // InternalSymg.g:2988:3: rule__Model__SobligationsAssignment_14_2_0
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
    // InternalSymg.g:2996:1: rule__Model__Group_14_2__1 : rule__Model__Group_14_2__1__Impl ;
    public final void rule__Model__Group_14_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3000:1: ( rule__Model__Group_14_2__1__Impl )
            // InternalSymg.g:3001:2: rule__Model__Group_14_2__1__Impl
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
    // InternalSymg.g:3007:1: rule__Model__Group_14_2__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_14_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3011:1: ( ( ';' ) )
            // InternalSymg.g:3012:1: ( ';' )
            {
            // InternalSymg.g:3012:1: ( ';' )
            // InternalSymg.g:3013:2: ';'
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
    // InternalSymg.g:3023:1: rule__Model__Group_15__0 : rule__Model__Group_15__0__Impl rule__Model__Group_15__1 ;
    public final void rule__Model__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3027:1: ( rule__Model__Group_15__0__Impl rule__Model__Group_15__1 )
            // InternalSymg.g:3028:2: rule__Model__Group_15__0__Impl rule__Model__Group_15__1
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
    // InternalSymg.g:3035:1: rule__Model__Group_15__0__Impl : ( 'Powers' ) ;
    public final void rule__Model__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3039:1: ( ( 'Powers' ) )
            // InternalSymg.g:3040:1: ( 'Powers' )
            {
            // InternalSymg.g:3040:1: ( 'Powers' )
            // InternalSymg.g:3041:2: 'Powers'
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
    // InternalSymg.g:3050:1: rule__Model__Group_15__1 : rule__Model__Group_15__1__Impl ;
    public final void rule__Model__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3054:1: ( rule__Model__Group_15__1__Impl )
            // InternalSymg.g:3055:2: rule__Model__Group_15__1__Impl
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
    // InternalSymg.g:3061:1: rule__Model__Group_15__1__Impl : ( ( rule__Model__Group_15_1__0 )* ) ;
    public final void rule__Model__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3065:1: ( ( ( rule__Model__Group_15_1__0 )* ) )
            // InternalSymg.g:3066:1: ( ( rule__Model__Group_15_1__0 )* )
            {
            // InternalSymg.g:3066:1: ( ( rule__Model__Group_15_1__0 )* )
            // InternalSymg.g:3067:2: ( rule__Model__Group_15_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_15_1()); 
            // InternalSymg.g:3068:2: ( rule__Model__Group_15_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSymg.g:3068:3: rule__Model__Group_15_1__0
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
    // InternalSymg.g:3077:1: rule__Model__Group_15_1__0 : rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 ;
    public final void rule__Model__Group_15_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3081:1: ( rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1 )
            // InternalSymg.g:3082:2: rule__Model__Group_15_1__0__Impl rule__Model__Group_15_1__1
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
    // InternalSymg.g:3089:1: rule__Model__Group_15_1__0__Impl : ( ( rule__Model__PowersAssignment_15_1_0 ) ) ;
    public final void rule__Model__Group_15_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3093:1: ( ( ( rule__Model__PowersAssignment_15_1_0 ) ) )
            // InternalSymg.g:3094:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            {
            // InternalSymg.g:3094:1: ( ( rule__Model__PowersAssignment_15_1_0 ) )
            // InternalSymg.g:3095:2: ( rule__Model__PowersAssignment_15_1_0 )
            {
             before(grammarAccess.getModelAccess().getPowersAssignment_15_1_0()); 
            // InternalSymg.g:3096:2: ( rule__Model__PowersAssignment_15_1_0 )
            // InternalSymg.g:3096:3: rule__Model__PowersAssignment_15_1_0
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
    // InternalSymg.g:3104:1: rule__Model__Group_15_1__1 : rule__Model__Group_15_1__1__Impl ;
    public final void rule__Model__Group_15_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3108:1: ( rule__Model__Group_15_1__1__Impl )
            // InternalSymg.g:3109:2: rule__Model__Group_15_1__1__Impl
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
    // InternalSymg.g:3115:1: rule__Model__Group_15_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_15_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3119:1: ( ( ';' ) )
            // InternalSymg.g:3120:1: ( ';' )
            {
            // InternalSymg.g:3120:1: ( ';' )
            // InternalSymg.g:3121:2: ';'
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
    // InternalSymg.g:3131:1: rule__Model__Group_16__0 : rule__Model__Group_16__0__Impl rule__Model__Group_16__1 ;
    public final void rule__Model__Group_16__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3135:1: ( rule__Model__Group_16__0__Impl rule__Model__Group_16__1 )
            // InternalSymg.g:3136:2: rule__Model__Group_16__0__Impl rule__Model__Group_16__1
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
    // InternalSymg.g:3143:1: rule__Model__Group_16__0__Impl : ( 'Constraints' ) ;
    public final void rule__Model__Group_16__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3147:1: ( ( 'Constraints' ) )
            // InternalSymg.g:3148:1: ( 'Constraints' )
            {
            // InternalSymg.g:3148:1: ( 'Constraints' )
            // InternalSymg.g:3149:2: 'Constraints'
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
    // InternalSymg.g:3158:1: rule__Model__Group_16__1 : rule__Model__Group_16__1__Impl ;
    public final void rule__Model__Group_16__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3162:1: ( rule__Model__Group_16__1__Impl )
            // InternalSymg.g:3163:2: rule__Model__Group_16__1__Impl
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
    // InternalSymg.g:3169:1: rule__Model__Group_16__1__Impl : ( ( rule__Model__Group_16_1__0 )* ) ;
    public final void rule__Model__Group_16__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3173:1: ( ( ( rule__Model__Group_16_1__0 )* ) )
            // InternalSymg.g:3174:1: ( ( rule__Model__Group_16_1__0 )* )
            {
            // InternalSymg.g:3174:1: ( ( rule__Model__Group_16_1__0 )* )
            // InternalSymg.g:3175:2: ( rule__Model__Group_16_1__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_16_1()); 
            // InternalSymg.g:3176:2: ( rule__Model__Group_16_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_INT)||(LA35_0>=33 && LA35_0<=74)||LA35_0==78||(LA35_0>=100 && LA35_0<=101)||(LA35_0>=105 && LA35_0<=107)||LA35_0==109) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSymg.g:3176:3: rule__Model__Group_16_1__0
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
    // InternalSymg.g:3185:1: rule__Model__Group_16_1__0 : rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 ;
    public final void rule__Model__Group_16_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3189:1: ( rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1 )
            // InternalSymg.g:3190:2: rule__Model__Group_16_1__0__Impl rule__Model__Group_16_1__1
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
    // InternalSymg.g:3197:1: rule__Model__Group_16_1__0__Impl : ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) ;
    public final void rule__Model__Group_16_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3201:1: ( ( ( rule__Model__ConstraintsAssignment_16_1_0 ) ) )
            // InternalSymg.g:3202:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            {
            // InternalSymg.g:3202:1: ( ( rule__Model__ConstraintsAssignment_16_1_0 ) )
            // InternalSymg.g:3203:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            {
             before(grammarAccess.getModelAccess().getConstraintsAssignment_16_1_0()); 
            // InternalSymg.g:3204:2: ( rule__Model__ConstraintsAssignment_16_1_0 )
            // InternalSymg.g:3204:3: rule__Model__ConstraintsAssignment_16_1_0
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
    // InternalSymg.g:3212:1: rule__Model__Group_16_1__1 : rule__Model__Group_16_1__1__Impl ;
    public final void rule__Model__Group_16_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3216:1: ( rule__Model__Group_16_1__1__Impl )
            // InternalSymg.g:3217:2: rule__Model__Group_16_1__1__Impl
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
    // InternalSymg.g:3223:1: rule__Model__Group_16_1__1__Impl : ( ';' ) ;
    public final void rule__Model__Group_16_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3227:1: ( ( ';' ) )
            // InternalSymg.g:3228:1: ( ';' )
            {
            // InternalSymg.g:3228:1: ( ';' )
            // InternalSymg.g:3229:2: ';'
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
    // InternalSymg.g:3239:1: rule__Regular__Group__0 : rule__Regular__Group__0__Impl rule__Regular__Group__1 ;
    public final void rule__Regular__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3243:1: ( rule__Regular__Group__0__Impl rule__Regular__Group__1 )
            // InternalSymg.g:3244:2: rule__Regular__Group__0__Impl rule__Regular__Group__1
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
    // InternalSymg.g:3251:1: rule__Regular__Group__0__Impl : ( ( rule__Regular__NameAssignment_0 ) ) ;
    public final void rule__Regular__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3255:1: ( ( ( rule__Regular__NameAssignment_0 ) ) )
            // InternalSymg.g:3256:1: ( ( rule__Regular__NameAssignment_0 ) )
            {
            // InternalSymg.g:3256:1: ( ( rule__Regular__NameAssignment_0 ) )
            // InternalSymg.g:3257:2: ( rule__Regular__NameAssignment_0 )
            {
             before(grammarAccess.getRegularAccess().getNameAssignment_0()); 
            // InternalSymg.g:3258:2: ( rule__Regular__NameAssignment_0 )
            // InternalSymg.g:3258:3: rule__Regular__NameAssignment_0
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
    // InternalSymg.g:3266:1: rule__Regular__Group__1 : rule__Regular__Group__1__Impl rule__Regular__Group__2 ;
    public final void rule__Regular__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3270:1: ( rule__Regular__Group__1__Impl rule__Regular__Group__2 )
            // InternalSymg.g:3271:2: rule__Regular__Group__1__Impl rule__Regular__Group__2
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
    // InternalSymg.g:3278:1: rule__Regular__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Regular__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3282:1: ( ( 'isA' ) )
            // InternalSymg.g:3283:1: ( 'isA' )
            {
            // InternalSymg.g:3283:1: ( 'isA' )
            // InternalSymg.g:3284:2: 'isA'
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
    // InternalSymg.g:3293:1: rule__Regular__Group__2 : rule__Regular__Group__2__Impl rule__Regular__Group__3 ;
    public final void rule__Regular__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3297:1: ( rule__Regular__Group__2__Impl rule__Regular__Group__3 )
            // InternalSymg.g:3298:2: rule__Regular__Group__2__Impl rule__Regular__Group__3
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
    // InternalSymg.g:3305:1: rule__Regular__Group__2__Impl : ( ( rule__Regular__ConceptTypeAssignment_2 ) ) ;
    public final void rule__Regular__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3309:1: ( ( ( rule__Regular__ConceptTypeAssignment_2 ) ) )
            // InternalSymg.g:3310:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            {
            // InternalSymg.g:3310:1: ( ( rule__Regular__ConceptTypeAssignment_2 ) )
            // InternalSymg.g:3311:2: ( rule__Regular__ConceptTypeAssignment_2 )
            {
             before(grammarAccess.getRegularAccess().getConceptTypeAssignment_2()); 
            // InternalSymg.g:3312:2: ( rule__Regular__ConceptTypeAssignment_2 )
            // InternalSymg.g:3312:3: rule__Regular__ConceptTypeAssignment_2
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
    // InternalSymg.g:3320:1: rule__Regular__Group__3 : rule__Regular__Group__3__Impl ;
    public final void rule__Regular__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3324:1: ( rule__Regular__Group__3__Impl )
            // InternalSymg.g:3325:2: rule__Regular__Group__3__Impl
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
    // InternalSymg.g:3331:1: rule__Regular__Group__3__Impl : ( ( rule__Regular__Group_3__0 )? ) ;
    public final void rule__Regular__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3335:1: ( ( ( rule__Regular__Group_3__0 )? ) )
            // InternalSymg.g:3336:1: ( ( rule__Regular__Group_3__0 )? )
            {
            // InternalSymg.g:3336:1: ( ( rule__Regular__Group_3__0 )? )
            // InternalSymg.g:3337:2: ( rule__Regular__Group_3__0 )?
            {
             before(grammarAccess.getRegularAccess().getGroup_3()); 
            // InternalSymg.g:3338:2: ( rule__Regular__Group_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==91) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalSymg.g:3338:3: rule__Regular__Group_3__0
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
    // InternalSymg.g:3347:1: rule__Regular__Group_3__0 : rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 ;
    public final void rule__Regular__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3351:1: ( rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1 )
            // InternalSymg.g:3352:2: rule__Regular__Group_3__0__Impl rule__Regular__Group_3__1
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
    // InternalSymg.g:3359:1: rule__Regular__Group_3__0__Impl : ( 'with' ) ;
    public final void rule__Regular__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3363:1: ( ( 'with' ) )
            // InternalSymg.g:3364:1: ( 'with' )
            {
            // InternalSymg.g:3364:1: ( 'with' )
            // InternalSymg.g:3365:2: 'with'
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
    // InternalSymg.g:3374:1: rule__Regular__Group_3__1 : rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 ;
    public final void rule__Regular__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3378:1: ( rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2 )
            // InternalSymg.g:3379:2: rule__Regular__Group_3__1__Impl rule__Regular__Group_3__2
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
    // InternalSymg.g:3386:1: rule__Regular__Group_3__1__Impl : ( ( rule__Regular__Group_3_1__0 )* ) ;
    public final void rule__Regular__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3390:1: ( ( ( rule__Regular__Group_3_1__0 )* ) )
            // InternalSymg.g:3391:1: ( ( rule__Regular__Group_3_1__0 )* )
            {
            // InternalSymg.g:3391:1: ( ( rule__Regular__Group_3_1__0 )* )
            // InternalSymg.g:3392:2: ( rule__Regular__Group_3_1__0 )*
            {
             before(grammarAccess.getRegularAccess().getGroup_3_1()); 
            // InternalSymg.g:3393:2: ( rule__Regular__Group_3_1__0 )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // InternalSymg.g:3393:3: rule__Regular__Group_3_1__0
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
    // InternalSymg.g:3401:1: rule__Regular__Group_3__2 : rule__Regular__Group_3__2__Impl ;
    public final void rule__Regular__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3405:1: ( rule__Regular__Group_3__2__Impl )
            // InternalSymg.g:3406:2: rule__Regular__Group_3__2__Impl
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
    // InternalSymg.g:3412:1: rule__Regular__Group_3__2__Impl : ( ( rule__Regular__AttributesAssignment_3_2 ) ) ;
    public final void rule__Regular__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3416:1: ( ( ( rule__Regular__AttributesAssignment_3_2 ) ) )
            // InternalSymg.g:3417:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            {
            // InternalSymg.g:3417:1: ( ( rule__Regular__AttributesAssignment_3_2 ) )
            // InternalSymg.g:3418:2: ( rule__Regular__AttributesAssignment_3_2 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_2()); 
            // InternalSymg.g:3419:2: ( rule__Regular__AttributesAssignment_3_2 )
            // InternalSymg.g:3419:3: rule__Regular__AttributesAssignment_3_2
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
    // InternalSymg.g:3428:1: rule__Regular__Group_3_1__0 : rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 ;
    public final void rule__Regular__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3432:1: ( rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1 )
            // InternalSymg.g:3433:2: rule__Regular__Group_3_1__0__Impl rule__Regular__Group_3_1__1
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
    // InternalSymg.g:3440:1: rule__Regular__Group_3_1__0__Impl : ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) ;
    public final void rule__Regular__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3444:1: ( ( ( rule__Regular__AttributesAssignment_3_1_0 ) ) )
            // InternalSymg.g:3445:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            {
            // InternalSymg.g:3445:1: ( ( rule__Regular__AttributesAssignment_3_1_0 ) )
            // InternalSymg.g:3446:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            {
             before(grammarAccess.getRegularAccess().getAttributesAssignment_3_1_0()); 
            // InternalSymg.g:3447:2: ( rule__Regular__AttributesAssignment_3_1_0 )
            // InternalSymg.g:3447:3: rule__Regular__AttributesAssignment_3_1_0
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
    // InternalSymg.g:3455:1: rule__Regular__Group_3_1__1 : rule__Regular__Group_3_1__1__Impl ;
    public final void rule__Regular__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3459:1: ( rule__Regular__Group_3_1__1__Impl )
            // InternalSymg.g:3460:2: rule__Regular__Group_3_1__1__Impl
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
    // InternalSymg.g:3466:1: rule__Regular__Group_3_1__1__Impl : ( ',' ) ;
    public final void rule__Regular__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3470:1: ( ( ',' ) )
            // InternalSymg.g:3471:1: ( ',' )
            {
            // InternalSymg.g:3471:1: ( ',' )
            // InternalSymg.g:3472:2: ','
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
    // InternalSymg.g:3482:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3486:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalSymg.g:3487:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalSymg.g:3494:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3498:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // InternalSymg.g:3499:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // InternalSymg.g:3499:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // InternalSymg.g:3500:2: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // InternalSymg.g:3501:2: ( rule__Attribute__NameAssignment_0 )
            // InternalSymg.g:3501:3: rule__Attribute__NameAssignment_0
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
    // InternalSymg.g:3509:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3513:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalSymg.g:3514:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalSymg.g:3521:1: rule__Attribute__Group__1__Impl : ( ':' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3525:1: ( ( ':' ) )
            // InternalSymg.g:3526:1: ( ':' )
            {
            // InternalSymg.g:3526:1: ( ':' )
            // InternalSymg.g:3527:2: ':'
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
    // InternalSymg.g:3536:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3540:1: ( rule__Attribute__Group__2__Impl )
            // InternalSymg.g:3541:2: rule__Attribute__Group__2__Impl
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
    // InternalSymg.g:3547:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3551:1: ( ( ( rule__Attribute__AttributeTypeAssignment_2 ) ) )
            // InternalSymg.g:3552:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            {
            // InternalSymg.g:3552:1: ( ( rule__Attribute__AttributeTypeAssignment_2 ) )
            // InternalSymg.g:3553:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttributeTypeAssignment_2()); 
            // InternalSymg.g:3554:2: ( rule__Attribute__AttributeTypeAssignment_2 )
            // InternalSymg.g:3554:3: rule__Attribute__AttributeTypeAssignment_2
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
    // InternalSymg.g:3563:1: rule__Enumeration__Group__0 : rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 ;
    public final void rule__Enumeration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3567:1: ( rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1 )
            // InternalSymg.g:3568:2: rule__Enumeration__Group__0__Impl rule__Enumeration__Group__1
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
    // InternalSymg.g:3575:1: rule__Enumeration__Group__0__Impl : ( ( rule__Enumeration__NameAssignment_0 ) ) ;
    public final void rule__Enumeration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3579:1: ( ( ( rule__Enumeration__NameAssignment_0 ) ) )
            // InternalSymg.g:3580:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            {
            // InternalSymg.g:3580:1: ( ( rule__Enumeration__NameAssignment_0 ) )
            // InternalSymg.g:3581:2: ( rule__Enumeration__NameAssignment_0 )
            {
             before(grammarAccess.getEnumerationAccess().getNameAssignment_0()); 
            // InternalSymg.g:3582:2: ( rule__Enumeration__NameAssignment_0 )
            // InternalSymg.g:3582:3: rule__Enumeration__NameAssignment_0
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
    // InternalSymg.g:3590:1: rule__Enumeration__Group__1 : rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 ;
    public final void rule__Enumeration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3594:1: ( rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2 )
            // InternalSymg.g:3595:2: rule__Enumeration__Group__1__Impl rule__Enumeration__Group__2
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
    // InternalSymg.g:3602:1: rule__Enumeration__Group__1__Impl : ( 'isA' ) ;
    public final void rule__Enumeration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3606:1: ( ( 'isA' ) )
            // InternalSymg.g:3607:1: ( 'isA' )
            {
            // InternalSymg.g:3607:1: ( 'isA' )
            // InternalSymg.g:3608:2: 'isA'
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
    // InternalSymg.g:3617:1: rule__Enumeration__Group__2 : rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 ;
    public final void rule__Enumeration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3621:1: ( rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3 )
            // InternalSymg.g:3622:2: rule__Enumeration__Group__2__Impl rule__Enumeration__Group__3
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
    // InternalSymg.g:3629:1: rule__Enumeration__Group__2__Impl : ( 'Enumeration' ) ;
    public final void rule__Enumeration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3633:1: ( ( 'Enumeration' ) )
            // InternalSymg.g:3634:1: ( 'Enumeration' )
            {
            // InternalSymg.g:3634:1: ( 'Enumeration' )
            // InternalSymg.g:3635:2: 'Enumeration'
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
    // InternalSymg.g:3644:1: rule__Enumeration__Group__3 : rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 ;
    public final void rule__Enumeration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3648:1: ( rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4 )
            // InternalSymg.g:3649:2: rule__Enumeration__Group__3__Impl rule__Enumeration__Group__4
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
    // InternalSymg.g:3656:1: rule__Enumeration__Group__3__Impl : ( '(' ) ;
    public final void rule__Enumeration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3660:1: ( ( '(' ) )
            // InternalSymg.g:3661:1: ( '(' )
            {
            // InternalSymg.g:3661:1: ( '(' )
            // InternalSymg.g:3662:2: '('
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
    // InternalSymg.g:3671:1: rule__Enumeration__Group__4 : rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 ;
    public final void rule__Enumeration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3675:1: ( rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5 )
            // InternalSymg.g:3676:2: rule__Enumeration__Group__4__Impl rule__Enumeration__Group__5
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
    // InternalSymg.g:3683:1: rule__Enumeration__Group__4__Impl : ( ( rule__Enumeration__Group_4__0 )* ) ;
    public final void rule__Enumeration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3687:1: ( ( ( rule__Enumeration__Group_4__0 )* ) )
            // InternalSymg.g:3688:1: ( ( rule__Enumeration__Group_4__0 )* )
            {
            // InternalSymg.g:3688:1: ( ( rule__Enumeration__Group_4__0 )* )
            // InternalSymg.g:3689:2: ( rule__Enumeration__Group_4__0 )*
            {
             before(grammarAccess.getEnumerationAccess().getGroup_4()); 
            // InternalSymg.g:3690:2: ( rule__Enumeration__Group_4__0 )*
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
            	    // InternalSymg.g:3690:3: rule__Enumeration__Group_4__0
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
    // InternalSymg.g:3698:1: rule__Enumeration__Group__5 : rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 ;
    public final void rule__Enumeration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3702:1: ( rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6 )
            // InternalSymg.g:3703:2: rule__Enumeration__Group__5__Impl rule__Enumeration__Group__6
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
    // InternalSymg.g:3710:1: rule__Enumeration__Group__5__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) ;
    public final void rule__Enumeration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3714:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) ) )
            // InternalSymg.g:3715:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            {
            // InternalSymg.g:3715:1: ( ( rule__Enumeration__EnumerationItemsAssignment_5 ) )
            // InternalSymg.g:3716:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_5()); 
            // InternalSymg.g:3717:2: ( rule__Enumeration__EnumerationItemsAssignment_5 )
            // InternalSymg.g:3717:3: rule__Enumeration__EnumerationItemsAssignment_5
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
    // InternalSymg.g:3725:1: rule__Enumeration__Group__6 : rule__Enumeration__Group__6__Impl ;
    public final void rule__Enumeration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3729:1: ( rule__Enumeration__Group__6__Impl )
            // InternalSymg.g:3730:2: rule__Enumeration__Group__6__Impl
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
    // InternalSymg.g:3736:1: rule__Enumeration__Group__6__Impl : ( ')' ) ;
    public final void rule__Enumeration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3740:1: ( ( ')' ) )
            // InternalSymg.g:3741:1: ( ')' )
            {
            // InternalSymg.g:3741:1: ( ')' )
            // InternalSymg.g:3742:2: ')'
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
    // InternalSymg.g:3752:1: rule__Enumeration__Group_4__0 : rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 ;
    public final void rule__Enumeration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3756:1: ( rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1 )
            // InternalSymg.g:3757:2: rule__Enumeration__Group_4__0__Impl rule__Enumeration__Group_4__1
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
    // InternalSymg.g:3764:1: rule__Enumeration__Group_4__0__Impl : ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) ;
    public final void rule__Enumeration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3768:1: ( ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) ) )
            // InternalSymg.g:3769:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            {
            // InternalSymg.g:3769:1: ( ( rule__Enumeration__EnumerationItemsAssignment_4_0 ) )
            // InternalSymg.g:3770:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            {
             before(grammarAccess.getEnumerationAccess().getEnumerationItemsAssignment_4_0()); 
            // InternalSymg.g:3771:2: ( rule__Enumeration__EnumerationItemsAssignment_4_0 )
            // InternalSymg.g:3771:3: rule__Enumeration__EnumerationItemsAssignment_4_0
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
    // InternalSymg.g:3779:1: rule__Enumeration__Group_4__1 : rule__Enumeration__Group_4__1__Impl ;
    public final void rule__Enumeration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3783:1: ( rule__Enumeration__Group_4__1__Impl )
            // InternalSymg.g:3784:2: rule__Enumeration__Group_4__1__Impl
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
    // InternalSymg.g:3790:1: rule__Enumeration__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Enumeration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3794:1: ( ( ',' ) )
            // InternalSymg.g:3795:1: ( ',' )
            {
            // InternalSymg.g:3795:1: ( ',' )
            // InternalSymg.g:3796:2: ','
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
    // InternalSymg.g:3806:1: rule__EnumItem__Group__0 : rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 ;
    public final void rule__EnumItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3810:1: ( rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1 )
            // InternalSymg.g:3811:2: rule__EnumItem__Group__0__Impl rule__EnumItem__Group__1
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
    // InternalSymg.g:3818:1: rule__EnumItem__Group__0__Impl : ( () ) ;
    public final void rule__EnumItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3822:1: ( ( () ) )
            // InternalSymg.g:3823:1: ( () )
            {
            // InternalSymg.g:3823:1: ( () )
            // InternalSymg.g:3824:2: ()
            {
             before(grammarAccess.getEnumItemAccess().getEnumItemAction_0()); 
            // InternalSymg.g:3825:2: ()
            // InternalSymg.g:3825:3: 
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
    // InternalSymg.g:3833:1: rule__EnumItem__Group__1 : rule__EnumItem__Group__1__Impl ;
    public final void rule__EnumItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3837:1: ( rule__EnumItem__Group__1__Impl )
            // InternalSymg.g:3838:2: rule__EnumItem__Group__1__Impl
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
    // InternalSymg.g:3844:1: rule__EnumItem__Group__1__Impl : ( ( rule__EnumItem__NameAssignment_1 ) ) ;
    public final void rule__EnumItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3848:1: ( ( ( rule__EnumItem__NameAssignment_1 ) ) )
            // InternalSymg.g:3849:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            {
            // InternalSymg.g:3849:1: ( ( rule__EnumItem__NameAssignment_1 ) )
            // InternalSymg.g:3850:2: ( rule__EnumItem__NameAssignment_1 )
            {
             before(grammarAccess.getEnumItemAccess().getNameAssignment_1()); 
            // InternalSymg.g:3851:2: ( rule__EnumItem__NameAssignment_1 )
            // InternalSymg.g:3851:3: rule__EnumItem__NameAssignment_1
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
    // InternalSymg.g:3860:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3864:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalSymg.g:3865:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalSymg.g:3872:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3876:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalSymg.g:3877:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalSymg.g:3877:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalSymg.g:3878:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalSymg.g:3879:2: ( rule__Parameter__NameAssignment_0 )
            // InternalSymg.g:3879:3: rule__Parameter__NameAssignment_0
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
    // InternalSymg.g:3887:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3891:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalSymg.g:3892:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
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
    // InternalSymg.g:3899:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3903:1: ( ( ':' ) )
            // InternalSymg.g:3904:1: ( ':' )
            {
            // InternalSymg.g:3904:1: ( ':' )
            // InternalSymg.g:3905:2: ':'
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
    // InternalSymg.g:3914:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3918:1: ( rule__Parameter__Group__2__Impl )
            // InternalSymg.g:3919:2: rule__Parameter__Group__2__Impl
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
    // InternalSymg.g:3925:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__TypeAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3929:1: ( ( ( rule__Parameter__TypeAssignment_2 ) ) )
            // InternalSymg.g:3930:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            {
            // InternalSymg.g:3930:1: ( ( rule__Parameter__TypeAssignment_2 ) )
            // InternalSymg.g:3931:2: ( rule__Parameter__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_2()); 
            // InternalSymg.g:3932:2: ( rule__Parameter__TypeAssignment_2 )
            // InternalSymg.g:3932:3: rule__Parameter__TypeAssignment_2
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
    // InternalSymg.g:3941:1: rule__DeclarPair__Group__0 : rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 ;
    public final void rule__DeclarPair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3945:1: ( rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1 )
            // InternalSymg.g:3946:2: rule__DeclarPair__Group__0__Impl rule__DeclarPair__Group__1
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
    // InternalSymg.g:3953:1: rule__DeclarPair__Group__0__Impl : ( ( rule__DeclarPair__AttrAssignment_0 ) ) ;
    public final void rule__DeclarPair__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3957:1: ( ( ( rule__DeclarPair__AttrAssignment_0 ) ) )
            // InternalSymg.g:3958:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            {
            // InternalSymg.g:3958:1: ( ( rule__DeclarPair__AttrAssignment_0 ) )
            // InternalSymg.g:3959:2: ( rule__DeclarPair__AttrAssignment_0 )
            {
             before(grammarAccess.getDeclarPairAccess().getAttrAssignment_0()); 
            // InternalSymg.g:3960:2: ( rule__DeclarPair__AttrAssignment_0 )
            // InternalSymg.g:3960:3: rule__DeclarPair__AttrAssignment_0
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
    // InternalSymg.g:3968:1: rule__DeclarPair__Group__1 : rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 ;
    public final void rule__DeclarPair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3972:1: ( rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2 )
            // InternalSymg.g:3973:2: rule__DeclarPair__Group__1__Impl rule__DeclarPair__Group__2
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
    // InternalSymg.g:3980:1: rule__DeclarPair__Group__1__Impl : ( ':=' ) ;
    public final void rule__DeclarPair__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3984:1: ( ( ':=' ) )
            // InternalSymg.g:3985:1: ( ':=' )
            {
            // InternalSymg.g:3985:1: ( ':=' )
            // InternalSymg.g:3986:2: ':='
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
    // InternalSymg.g:3995:1: rule__DeclarPair__Group__2 : rule__DeclarPair__Group__2__Impl ;
    public final void rule__DeclarPair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:3999:1: ( rule__DeclarPair__Group__2__Impl )
            // InternalSymg.g:4000:2: rule__DeclarPair__Group__2__Impl
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
    // InternalSymg.g:4006:1: rule__DeclarPair__Group__2__Impl : ( ( rule__DeclarPair__ParamAssignment_2 ) ) ;
    public final void rule__DeclarPair__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4010:1: ( ( ( rule__DeclarPair__ParamAssignment_2 ) ) )
            // InternalSymg.g:4011:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            {
            // InternalSymg.g:4011:1: ( ( rule__DeclarPair__ParamAssignment_2 ) )
            // InternalSymg.g:4012:2: ( rule__DeclarPair__ParamAssignment_2 )
            {
             before(grammarAccess.getDeclarPairAccess().getParamAssignment_2()); 
            // InternalSymg.g:4013:2: ( rule__DeclarPair__ParamAssignment_2 )
            // InternalSymg.g:4013:3: rule__DeclarPair__ParamAssignment_2
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
    // InternalSymg.g:4022:1: rule__Declar__Group__0 : rule__Declar__Group__0__Impl rule__Declar__Group__1 ;
    public final void rule__Declar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4026:1: ( rule__Declar__Group__0__Impl rule__Declar__Group__1 )
            // InternalSymg.g:4027:2: rule__Declar__Group__0__Impl rule__Declar__Group__1
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
    // InternalSymg.g:4034:1: rule__Declar__Group__0__Impl : ( ( rule__Declar__NameAssignment_0 ) ) ;
    public final void rule__Declar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4038:1: ( ( ( rule__Declar__NameAssignment_0 ) ) )
            // InternalSymg.g:4039:1: ( ( rule__Declar__NameAssignment_0 ) )
            {
            // InternalSymg.g:4039:1: ( ( rule__Declar__NameAssignment_0 ) )
            // InternalSymg.g:4040:2: ( rule__Declar__NameAssignment_0 )
            {
             before(grammarAccess.getDeclarAccess().getNameAssignment_0()); 
            // InternalSymg.g:4041:2: ( rule__Declar__NameAssignment_0 )
            // InternalSymg.g:4041:3: rule__Declar__NameAssignment_0
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
    // InternalSymg.g:4049:1: rule__Declar__Group__1 : rule__Declar__Group__1__Impl rule__Declar__Group__2 ;
    public final void rule__Declar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4053:1: ( rule__Declar__Group__1__Impl rule__Declar__Group__2 )
            // InternalSymg.g:4054:2: rule__Declar__Group__1__Impl rule__Declar__Group__2
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
    // InternalSymg.g:4061:1: rule__Declar__Group__1__Impl : ( ':' ) ;
    public final void rule__Declar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4065:1: ( ( ':' ) )
            // InternalSymg.g:4066:1: ( ':' )
            {
            // InternalSymg.g:4066:1: ( ':' )
            // InternalSymg.g:4067:2: ':'
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
    // InternalSymg.g:4076:1: rule__Declar__Group__2 : rule__Declar__Group__2__Impl rule__Declar__Group__3 ;
    public final void rule__Declar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4080:1: ( rule__Declar__Group__2__Impl rule__Declar__Group__3 )
            // InternalSymg.g:4081:2: rule__Declar__Group__2__Impl rule__Declar__Group__3
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
    // InternalSymg.g:4088:1: rule__Declar__Group__2__Impl : ( ( rule__Declar__TypeAssignment_2 ) ) ;
    public final void rule__Declar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4092:1: ( ( ( rule__Declar__TypeAssignment_2 ) ) )
            // InternalSymg.g:4093:1: ( ( rule__Declar__TypeAssignment_2 ) )
            {
            // InternalSymg.g:4093:1: ( ( rule__Declar__TypeAssignment_2 ) )
            // InternalSymg.g:4094:2: ( rule__Declar__TypeAssignment_2 )
            {
             before(grammarAccess.getDeclarAccess().getTypeAssignment_2()); 
            // InternalSymg.g:4095:2: ( rule__Declar__TypeAssignment_2 )
            // InternalSymg.g:4095:3: rule__Declar__TypeAssignment_2
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
    // InternalSymg.g:4103:1: rule__Declar__Group__3 : rule__Declar__Group__3__Impl rule__Declar__Group__4 ;
    public final void rule__Declar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4107:1: ( rule__Declar__Group__3__Impl rule__Declar__Group__4 )
            // InternalSymg.g:4108:2: rule__Declar__Group__3__Impl rule__Declar__Group__4
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
    // InternalSymg.g:4115:1: rule__Declar__Group__3__Impl : ( 'with' ) ;
    public final void rule__Declar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4119:1: ( ( 'with' ) )
            // InternalSymg.g:4120:1: ( 'with' )
            {
            // InternalSymg.g:4120:1: ( 'with' )
            // InternalSymg.g:4121:2: 'with'
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
    // InternalSymg.g:4130:1: rule__Declar__Group__4 : rule__Declar__Group__4__Impl rule__Declar__Group__5 ;
    public final void rule__Declar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4134:1: ( rule__Declar__Group__4__Impl rule__Declar__Group__5 )
            // InternalSymg.g:4135:2: rule__Declar__Group__4__Impl rule__Declar__Group__5
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
    // InternalSymg.g:4142:1: rule__Declar__Group__4__Impl : ( ( rule__Declar__Group_4__0 )* ) ;
    public final void rule__Declar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4146:1: ( ( ( rule__Declar__Group_4__0 )* ) )
            // InternalSymg.g:4147:1: ( ( rule__Declar__Group_4__0 )* )
            {
            // InternalSymg.g:4147:1: ( ( rule__Declar__Group_4__0 )* )
            // InternalSymg.g:4148:2: ( rule__Declar__Group_4__0 )*
            {
             before(grammarAccess.getDeclarAccess().getGroup_4()); 
            // InternalSymg.g:4149:2: ( rule__Declar__Group_4__0 )*
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
            	    // InternalSymg.g:4149:3: rule__Declar__Group_4__0
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
    // InternalSymg.g:4157:1: rule__Declar__Group__5 : rule__Declar__Group__5__Impl ;
    public final void rule__Declar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4161:1: ( rule__Declar__Group__5__Impl )
            // InternalSymg.g:4162:2: rule__Declar__Group__5__Impl
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
    // InternalSymg.g:4168:1: rule__Declar__Group__5__Impl : ( ( rule__Declar__AttributesAssignment_5 ) ) ;
    public final void rule__Declar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4172:1: ( ( ( rule__Declar__AttributesAssignment_5 ) ) )
            // InternalSymg.g:4173:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            {
            // InternalSymg.g:4173:1: ( ( rule__Declar__AttributesAssignment_5 ) )
            // InternalSymg.g:4174:2: ( rule__Declar__AttributesAssignment_5 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_5()); 
            // InternalSymg.g:4175:2: ( rule__Declar__AttributesAssignment_5 )
            // InternalSymg.g:4175:3: rule__Declar__AttributesAssignment_5
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
    // InternalSymg.g:4184:1: rule__Declar__Group_4__0 : rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 ;
    public final void rule__Declar__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4188:1: ( rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1 )
            // InternalSymg.g:4189:2: rule__Declar__Group_4__0__Impl rule__Declar__Group_4__1
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
    // InternalSymg.g:4196:1: rule__Declar__Group_4__0__Impl : ( ( rule__Declar__AttributesAssignment_4_0 ) ) ;
    public final void rule__Declar__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4200:1: ( ( ( rule__Declar__AttributesAssignment_4_0 ) ) )
            // InternalSymg.g:4201:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            {
            // InternalSymg.g:4201:1: ( ( rule__Declar__AttributesAssignment_4_0 ) )
            // InternalSymg.g:4202:2: ( rule__Declar__AttributesAssignment_4_0 )
            {
             before(grammarAccess.getDeclarAccess().getAttributesAssignment_4_0()); 
            // InternalSymg.g:4203:2: ( rule__Declar__AttributesAssignment_4_0 )
            // InternalSymg.g:4203:3: rule__Declar__AttributesAssignment_4_0
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
    // InternalSymg.g:4211:1: rule__Declar__Group_4__1 : rule__Declar__Group_4__1__Impl ;
    public final void rule__Declar__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4215:1: ( rule__Declar__Group_4__1__Impl )
            // InternalSymg.g:4216:2: rule__Declar__Group_4__1__Impl
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
    // InternalSymg.g:4222:1: rule__Declar__Group_4__1__Impl : ( ',' ) ;
    public final void rule__Declar__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4226:1: ( ( ',' ) )
            // InternalSymg.g:4227:1: ( ',' )
            {
            // InternalSymg.g:4227:1: ( ',' )
            // InternalSymg.g:4228:2: ','
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
    // InternalSymg.g:4238:1: rule__Obligation__Group__0 : rule__Obligation__Group__0__Impl rule__Obligation__Group__1 ;
    public final void rule__Obligation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4242:1: ( rule__Obligation__Group__0__Impl rule__Obligation__Group__1 )
            // InternalSymg.g:4243:2: rule__Obligation__Group__0__Impl rule__Obligation__Group__1
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
    // InternalSymg.g:4250:1: rule__Obligation__Group__0__Impl : ( ( rule__Obligation__NameAssignment_0 ) ) ;
    public final void rule__Obligation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4254:1: ( ( ( rule__Obligation__NameAssignment_0 ) ) )
            // InternalSymg.g:4255:1: ( ( rule__Obligation__NameAssignment_0 ) )
            {
            // InternalSymg.g:4255:1: ( ( rule__Obligation__NameAssignment_0 ) )
            // InternalSymg.g:4256:2: ( rule__Obligation__NameAssignment_0 )
            {
             before(grammarAccess.getObligationAccess().getNameAssignment_0()); 
            // InternalSymg.g:4257:2: ( rule__Obligation__NameAssignment_0 )
            // InternalSymg.g:4257:3: rule__Obligation__NameAssignment_0
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
    // InternalSymg.g:4265:1: rule__Obligation__Group__1 : rule__Obligation__Group__1__Impl rule__Obligation__Group__2 ;
    public final void rule__Obligation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4269:1: ( rule__Obligation__Group__1__Impl rule__Obligation__Group__2 )
            // InternalSymg.g:4270:2: rule__Obligation__Group__1__Impl rule__Obligation__Group__2
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
    // InternalSymg.g:4277:1: rule__Obligation__Group__1__Impl : ( ':' ) ;
    public final void rule__Obligation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4281:1: ( ( ':' ) )
            // InternalSymg.g:4282:1: ( ':' )
            {
            // InternalSymg.g:4282:1: ( ':' )
            // InternalSymg.g:4283:2: ':'
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
    // InternalSymg.g:4292:1: rule__Obligation__Group__2 : rule__Obligation__Group__2__Impl rule__Obligation__Group__3 ;
    public final void rule__Obligation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4296:1: ( rule__Obligation__Group__2__Impl rule__Obligation__Group__3 )
            // InternalSymg.g:4297:2: rule__Obligation__Group__2__Impl rule__Obligation__Group__3
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
    // InternalSymg.g:4304:1: rule__Obligation__Group__2__Impl : ( ( rule__Obligation__Group_2__0 )? ) ;
    public final void rule__Obligation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4308:1: ( ( ( rule__Obligation__Group_2__0 )? ) )
            // InternalSymg.g:4309:1: ( ( rule__Obligation__Group_2__0 )? )
            {
            // InternalSymg.g:4309:1: ( ( rule__Obligation__Group_2__0 )? )
            // InternalSymg.g:4310:2: ( rule__Obligation__Group_2__0 )?
            {
             before(grammarAccess.getObligationAccess().getGroup_2()); 
            // InternalSymg.g:4311:2: ( rule__Obligation__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_INT)||(LA40_0>=33 && LA40_0<=74)||LA40_0==78||(LA40_0>=100 && LA40_0<=101)||(LA40_0>=105 && LA40_0<=107)||LA40_0==109) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalSymg.g:4311:3: rule__Obligation__Group_2__0
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
    // InternalSymg.g:4319:1: rule__Obligation__Group__3 : rule__Obligation__Group__3__Impl rule__Obligation__Group__4 ;
    public final void rule__Obligation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4323:1: ( rule__Obligation__Group__3__Impl rule__Obligation__Group__4 )
            // InternalSymg.g:4324:2: rule__Obligation__Group__3__Impl rule__Obligation__Group__4
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
    // InternalSymg.g:4331:1: rule__Obligation__Group__3__Impl : ( 'obligation' ) ;
    public final void rule__Obligation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4335:1: ( ( 'obligation' ) )
            // InternalSymg.g:4336:1: ( 'obligation' )
            {
            // InternalSymg.g:4336:1: ( 'obligation' )
            // InternalSymg.g:4337:2: 'obligation'
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
    // InternalSymg.g:4346:1: rule__Obligation__Group__4 : rule__Obligation__Group__4__Impl rule__Obligation__Group__5 ;
    public final void rule__Obligation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4350:1: ( rule__Obligation__Group__4__Impl rule__Obligation__Group__5 )
            // InternalSymg.g:4351:2: rule__Obligation__Group__4__Impl rule__Obligation__Group__5
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
    // InternalSymg.g:4358:1: rule__Obligation__Group__4__Impl : ( '(' ) ;
    public final void rule__Obligation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4362:1: ( ( '(' ) )
            // InternalSymg.g:4363:1: ( '(' )
            {
            // InternalSymg.g:4363:1: ( '(' )
            // InternalSymg.g:4364:2: '('
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
    // InternalSymg.g:4373:1: rule__Obligation__Group__5 : rule__Obligation__Group__5__Impl rule__Obligation__Group__6 ;
    public final void rule__Obligation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4377:1: ( rule__Obligation__Group__5__Impl rule__Obligation__Group__6 )
            // InternalSymg.g:4378:2: rule__Obligation__Group__5__Impl rule__Obligation__Group__6
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
    // InternalSymg.g:4385:1: rule__Obligation__Group__5__Impl : ( ( rule__Obligation__Role1Assignment_5 ) ) ;
    public final void rule__Obligation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4389:1: ( ( ( rule__Obligation__Role1Assignment_5 ) ) )
            // InternalSymg.g:4390:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4390:1: ( ( rule__Obligation__Role1Assignment_5 ) )
            // InternalSymg.g:4391:2: ( rule__Obligation__Role1Assignment_5 )
            {
             before(grammarAccess.getObligationAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4392:2: ( rule__Obligation__Role1Assignment_5 )
            // InternalSymg.g:4392:3: rule__Obligation__Role1Assignment_5
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
    // InternalSymg.g:4400:1: rule__Obligation__Group__6 : rule__Obligation__Group__6__Impl rule__Obligation__Group__7 ;
    public final void rule__Obligation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4404:1: ( rule__Obligation__Group__6__Impl rule__Obligation__Group__7 )
            // InternalSymg.g:4405:2: rule__Obligation__Group__6__Impl rule__Obligation__Group__7
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
    // InternalSymg.g:4412:1: rule__Obligation__Group__6__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4416:1: ( ( ',' ) )
            // InternalSymg.g:4417:1: ( ',' )
            {
            // InternalSymg.g:4417:1: ( ',' )
            // InternalSymg.g:4418:2: ','
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
    // InternalSymg.g:4427:1: rule__Obligation__Group__7 : rule__Obligation__Group__7__Impl rule__Obligation__Group__8 ;
    public final void rule__Obligation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4431:1: ( rule__Obligation__Group__7__Impl rule__Obligation__Group__8 )
            // InternalSymg.g:4432:2: rule__Obligation__Group__7__Impl rule__Obligation__Group__8
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
    // InternalSymg.g:4439:1: rule__Obligation__Group__7__Impl : ( ( rule__Obligation__Role2Assignment_7 ) ) ;
    public final void rule__Obligation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4443:1: ( ( ( rule__Obligation__Role2Assignment_7 ) ) )
            // InternalSymg.g:4444:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4444:1: ( ( rule__Obligation__Role2Assignment_7 ) )
            // InternalSymg.g:4445:2: ( rule__Obligation__Role2Assignment_7 )
            {
             before(grammarAccess.getObligationAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4446:2: ( rule__Obligation__Role2Assignment_7 )
            // InternalSymg.g:4446:3: rule__Obligation__Role2Assignment_7
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
    // InternalSymg.g:4454:1: rule__Obligation__Group__8 : rule__Obligation__Group__8__Impl rule__Obligation__Group__9 ;
    public final void rule__Obligation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4458:1: ( rule__Obligation__Group__8__Impl rule__Obligation__Group__9 )
            // InternalSymg.g:4459:2: rule__Obligation__Group__8__Impl rule__Obligation__Group__9
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
    // InternalSymg.g:4466:1: rule__Obligation__Group__8__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4470:1: ( ( ',' ) )
            // InternalSymg.g:4471:1: ( ',' )
            {
            // InternalSymg.g:4471:1: ( ',' )
            // InternalSymg.g:4472:2: ','
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
    // InternalSymg.g:4481:1: rule__Obligation__Group__9 : rule__Obligation__Group__9__Impl rule__Obligation__Group__10 ;
    public final void rule__Obligation__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4485:1: ( rule__Obligation__Group__9__Impl rule__Obligation__Group__10 )
            // InternalSymg.g:4486:2: rule__Obligation__Group__9__Impl rule__Obligation__Group__10
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
    // InternalSymg.g:4493:1: rule__Obligation__Group__9__Impl : ( ( rule__Obligation__AntecedentAssignment_9 ) ) ;
    public final void rule__Obligation__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4497:1: ( ( ( rule__Obligation__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:4498:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:4498:1: ( ( rule__Obligation__AntecedentAssignment_9 ) )
            // InternalSymg.g:4499:2: ( rule__Obligation__AntecedentAssignment_9 )
            {
             before(grammarAccess.getObligationAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:4500:2: ( rule__Obligation__AntecedentAssignment_9 )
            // InternalSymg.g:4500:3: rule__Obligation__AntecedentAssignment_9
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
    // InternalSymg.g:4508:1: rule__Obligation__Group__10 : rule__Obligation__Group__10__Impl rule__Obligation__Group__11 ;
    public final void rule__Obligation__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4512:1: ( rule__Obligation__Group__10__Impl rule__Obligation__Group__11 )
            // InternalSymg.g:4513:2: rule__Obligation__Group__10__Impl rule__Obligation__Group__11
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
    // InternalSymg.g:4520:1: rule__Obligation__Group__10__Impl : ( ',' ) ;
    public final void rule__Obligation__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4524:1: ( ( ',' ) )
            // InternalSymg.g:4525:1: ( ',' )
            {
            // InternalSymg.g:4525:1: ( ',' )
            // InternalSymg.g:4526:2: ','
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
    // InternalSymg.g:4535:1: rule__Obligation__Group__11 : rule__Obligation__Group__11__Impl rule__Obligation__Group__12 ;
    public final void rule__Obligation__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4539:1: ( rule__Obligation__Group__11__Impl rule__Obligation__Group__12 )
            // InternalSymg.g:4540:2: rule__Obligation__Group__11__Impl rule__Obligation__Group__12
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
    // InternalSymg.g:4547:1: rule__Obligation__Group__11__Impl : ( ( rule__Obligation__ConsequentAssignment_11 ) ) ;
    public final void rule__Obligation__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4551:1: ( ( ( rule__Obligation__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:4552:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:4552:1: ( ( rule__Obligation__ConsequentAssignment_11 ) )
            // InternalSymg.g:4553:2: ( rule__Obligation__ConsequentAssignment_11 )
            {
             before(grammarAccess.getObligationAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:4554:2: ( rule__Obligation__ConsequentAssignment_11 )
            // InternalSymg.g:4554:3: rule__Obligation__ConsequentAssignment_11
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
    // InternalSymg.g:4562:1: rule__Obligation__Group__12 : rule__Obligation__Group__12__Impl ;
    public final void rule__Obligation__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4566:1: ( rule__Obligation__Group__12__Impl )
            // InternalSymg.g:4567:2: rule__Obligation__Group__12__Impl
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
    // InternalSymg.g:4573:1: rule__Obligation__Group__12__Impl : ( ')' ) ;
    public final void rule__Obligation__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4577:1: ( ( ')' ) )
            // InternalSymg.g:4578:1: ( ')' )
            {
            // InternalSymg.g:4578:1: ( ')' )
            // InternalSymg.g:4579:2: ')'
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
    // InternalSymg.g:4589:1: rule__Obligation__Group_2__0 : rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 ;
    public final void rule__Obligation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4593:1: ( rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1 )
            // InternalSymg.g:4594:2: rule__Obligation__Group_2__0__Impl rule__Obligation__Group_2__1
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
    // InternalSymg.g:4601:1: rule__Obligation__Group_2__0__Impl : ( ( rule__Obligation__TriggerAssignment_2_0 ) ) ;
    public final void rule__Obligation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4605:1: ( ( ( rule__Obligation__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:4606:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:4606:1: ( ( rule__Obligation__TriggerAssignment_2_0 ) )
            // InternalSymg.g:4607:2: ( rule__Obligation__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getObligationAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:4608:2: ( rule__Obligation__TriggerAssignment_2_0 )
            // InternalSymg.g:4608:3: rule__Obligation__TriggerAssignment_2_0
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
    // InternalSymg.g:4616:1: rule__Obligation__Group_2__1 : rule__Obligation__Group_2__1__Impl ;
    public final void rule__Obligation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4620:1: ( rule__Obligation__Group_2__1__Impl )
            // InternalSymg.g:4621:2: rule__Obligation__Group_2__1__Impl
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
    // InternalSymg.g:4627:1: rule__Obligation__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Obligation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4631:1: ( ( '->' ) )
            // InternalSymg.g:4632:1: ( '->' )
            {
            // InternalSymg.g:4632:1: ( '->' )
            // InternalSymg.g:4633:2: '->'
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
    // InternalSymg.g:4643:1: rule__Power__Group__0 : rule__Power__Group__0__Impl rule__Power__Group__1 ;
    public final void rule__Power__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4647:1: ( rule__Power__Group__0__Impl rule__Power__Group__1 )
            // InternalSymg.g:4648:2: rule__Power__Group__0__Impl rule__Power__Group__1
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
    // InternalSymg.g:4655:1: rule__Power__Group__0__Impl : ( ( rule__Power__NameAssignment_0 ) ) ;
    public final void rule__Power__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4659:1: ( ( ( rule__Power__NameAssignment_0 ) ) )
            // InternalSymg.g:4660:1: ( ( rule__Power__NameAssignment_0 ) )
            {
            // InternalSymg.g:4660:1: ( ( rule__Power__NameAssignment_0 ) )
            // InternalSymg.g:4661:2: ( rule__Power__NameAssignment_0 )
            {
             before(grammarAccess.getPowerAccess().getNameAssignment_0()); 
            // InternalSymg.g:4662:2: ( rule__Power__NameAssignment_0 )
            // InternalSymg.g:4662:3: rule__Power__NameAssignment_0
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
    // InternalSymg.g:4670:1: rule__Power__Group__1 : rule__Power__Group__1__Impl rule__Power__Group__2 ;
    public final void rule__Power__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4674:1: ( rule__Power__Group__1__Impl rule__Power__Group__2 )
            // InternalSymg.g:4675:2: rule__Power__Group__1__Impl rule__Power__Group__2
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
    // InternalSymg.g:4682:1: rule__Power__Group__1__Impl : ( ':' ) ;
    public final void rule__Power__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4686:1: ( ( ':' ) )
            // InternalSymg.g:4687:1: ( ':' )
            {
            // InternalSymg.g:4687:1: ( ':' )
            // InternalSymg.g:4688:2: ':'
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
    // InternalSymg.g:4697:1: rule__Power__Group__2 : rule__Power__Group__2__Impl rule__Power__Group__3 ;
    public final void rule__Power__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4701:1: ( rule__Power__Group__2__Impl rule__Power__Group__3 )
            // InternalSymg.g:4702:2: rule__Power__Group__2__Impl rule__Power__Group__3
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
    // InternalSymg.g:4709:1: rule__Power__Group__2__Impl : ( ( rule__Power__Group_2__0 )? ) ;
    public final void rule__Power__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4713:1: ( ( ( rule__Power__Group_2__0 )? ) )
            // InternalSymg.g:4714:1: ( ( rule__Power__Group_2__0 )? )
            {
            // InternalSymg.g:4714:1: ( ( rule__Power__Group_2__0 )? )
            // InternalSymg.g:4715:2: ( rule__Power__Group_2__0 )?
            {
             before(grammarAccess.getPowerAccess().getGroup_2()); 
            // InternalSymg.g:4716:2: ( rule__Power__Group_2__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_INT)||(LA41_0>=33 && LA41_0<=74)||LA41_0==78||(LA41_0>=100 && LA41_0<=101)||(LA41_0>=105 && LA41_0<=107)||LA41_0==109) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalSymg.g:4716:3: rule__Power__Group_2__0
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
    // InternalSymg.g:4724:1: rule__Power__Group__3 : rule__Power__Group__3__Impl rule__Power__Group__4 ;
    public final void rule__Power__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4728:1: ( rule__Power__Group__3__Impl rule__Power__Group__4 )
            // InternalSymg.g:4729:2: rule__Power__Group__3__Impl rule__Power__Group__4
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
    // InternalSymg.g:4736:1: rule__Power__Group__3__Impl : ( 'power' ) ;
    public final void rule__Power__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4740:1: ( ( 'power' ) )
            // InternalSymg.g:4741:1: ( 'power' )
            {
            // InternalSymg.g:4741:1: ( 'power' )
            // InternalSymg.g:4742:2: 'power'
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
    // InternalSymg.g:4751:1: rule__Power__Group__4 : rule__Power__Group__4__Impl rule__Power__Group__5 ;
    public final void rule__Power__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4755:1: ( rule__Power__Group__4__Impl rule__Power__Group__5 )
            // InternalSymg.g:4756:2: rule__Power__Group__4__Impl rule__Power__Group__5
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
    // InternalSymg.g:4763:1: rule__Power__Group__4__Impl : ( '(' ) ;
    public final void rule__Power__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4767:1: ( ( '(' ) )
            // InternalSymg.g:4768:1: ( '(' )
            {
            // InternalSymg.g:4768:1: ( '(' )
            // InternalSymg.g:4769:2: '('
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
    // InternalSymg.g:4778:1: rule__Power__Group__5 : rule__Power__Group__5__Impl rule__Power__Group__6 ;
    public final void rule__Power__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4782:1: ( rule__Power__Group__5__Impl rule__Power__Group__6 )
            // InternalSymg.g:4783:2: rule__Power__Group__5__Impl rule__Power__Group__6
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
    // InternalSymg.g:4790:1: rule__Power__Group__5__Impl : ( ( rule__Power__Role1Assignment_5 ) ) ;
    public final void rule__Power__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4794:1: ( ( ( rule__Power__Role1Assignment_5 ) ) )
            // InternalSymg.g:4795:1: ( ( rule__Power__Role1Assignment_5 ) )
            {
            // InternalSymg.g:4795:1: ( ( rule__Power__Role1Assignment_5 ) )
            // InternalSymg.g:4796:2: ( rule__Power__Role1Assignment_5 )
            {
             before(grammarAccess.getPowerAccess().getRole1Assignment_5()); 
            // InternalSymg.g:4797:2: ( rule__Power__Role1Assignment_5 )
            // InternalSymg.g:4797:3: rule__Power__Role1Assignment_5
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
    // InternalSymg.g:4805:1: rule__Power__Group__6 : rule__Power__Group__6__Impl rule__Power__Group__7 ;
    public final void rule__Power__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4809:1: ( rule__Power__Group__6__Impl rule__Power__Group__7 )
            // InternalSymg.g:4810:2: rule__Power__Group__6__Impl rule__Power__Group__7
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
    // InternalSymg.g:4817:1: rule__Power__Group__6__Impl : ( ',' ) ;
    public final void rule__Power__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4821:1: ( ( ',' ) )
            // InternalSymg.g:4822:1: ( ',' )
            {
            // InternalSymg.g:4822:1: ( ',' )
            // InternalSymg.g:4823:2: ','
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
    // InternalSymg.g:4832:1: rule__Power__Group__7 : rule__Power__Group__7__Impl rule__Power__Group__8 ;
    public final void rule__Power__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4836:1: ( rule__Power__Group__7__Impl rule__Power__Group__8 )
            // InternalSymg.g:4837:2: rule__Power__Group__7__Impl rule__Power__Group__8
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
    // InternalSymg.g:4844:1: rule__Power__Group__7__Impl : ( ( rule__Power__Role2Assignment_7 ) ) ;
    public final void rule__Power__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4848:1: ( ( ( rule__Power__Role2Assignment_7 ) ) )
            // InternalSymg.g:4849:1: ( ( rule__Power__Role2Assignment_7 ) )
            {
            // InternalSymg.g:4849:1: ( ( rule__Power__Role2Assignment_7 ) )
            // InternalSymg.g:4850:2: ( rule__Power__Role2Assignment_7 )
            {
             before(grammarAccess.getPowerAccess().getRole2Assignment_7()); 
            // InternalSymg.g:4851:2: ( rule__Power__Role2Assignment_7 )
            // InternalSymg.g:4851:3: rule__Power__Role2Assignment_7
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
    // InternalSymg.g:4859:1: rule__Power__Group__8 : rule__Power__Group__8__Impl rule__Power__Group__9 ;
    public final void rule__Power__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4863:1: ( rule__Power__Group__8__Impl rule__Power__Group__9 )
            // InternalSymg.g:4864:2: rule__Power__Group__8__Impl rule__Power__Group__9
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
    // InternalSymg.g:4871:1: rule__Power__Group__8__Impl : ( ',' ) ;
    public final void rule__Power__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4875:1: ( ( ',' ) )
            // InternalSymg.g:4876:1: ( ',' )
            {
            // InternalSymg.g:4876:1: ( ',' )
            // InternalSymg.g:4877:2: ','
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
    // InternalSymg.g:4886:1: rule__Power__Group__9 : rule__Power__Group__9__Impl rule__Power__Group__10 ;
    public final void rule__Power__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4890:1: ( rule__Power__Group__9__Impl rule__Power__Group__10 )
            // InternalSymg.g:4891:2: rule__Power__Group__9__Impl rule__Power__Group__10
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
    // InternalSymg.g:4898:1: rule__Power__Group__9__Impl : ( ( rule__Power__AntecedentAssignment_9 ) ) ;
    public final void rule__Power__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4902:1: ( ( ( rule__Power__AntecedentAssignment_9 ) ) )
            // InternalSymg.g:4903:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            {
            // InternalSymg.g:4903:1: ( ( rule__Power__AntecedentAssignment_9 ) )
            // InternalSymg.g:4904:2: ( rule__Power__AntecedentAssignment_9 )
            {
             before(grammarAccess.getPowerAccess().getAntecedentAssignment_9()); 
            // InternalSymg.g:4905:2: ( rule__Power__AntecedentAssignment_9 )
            // InternalSymg.g:4905:3: rule__Power__AntecedentAssignment_9
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
    // InternalSymg.g:4913:1: rule__Power__Group__10 : rule__Power__Group__10__Impl rule__Power__Group__11 ;
    public final void rule__Power__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4917:1: ( rule__Power__Group__10__Impl rule__Power__Group__11 )
            // InternalSymg.g:4918:2: rule__Power__Group__10__Impl rule__Power__Group__11
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
    // InternalSymg.g:4925:1: rule__Power__Group__10__Impl : ( ',' ) ;
    public final void rule__Power__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4929:1: ( ( ',' ) )
            // InternalSymg.g:4930:1: ( ',' )
            {
            // InternalSymg.g:4930:1: ( ',' )
            // InternalSymg.g:4931:2: ','
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
    // InternalSymg.g:4940:1: rule__Power__Group__11 : rule__Power__Group__11__Impl rule__Power__Group__12 ;
    public final void rule__Power__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4944:1: ( rule__Power__Group__11__Impl rule__Power__Group__12 )
            // InternalSymg.g:4945:2: rule__Power__Group__11__Impl rule__Power__Group__12
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
    // InternalSymg.g:4952:1: rule__Power__Group__11__Impl : ( ( rule__Power__ConsequentAssignment_11 ) ) ;
    public final void rule__Power__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4956:1: ( ( ( rule__Power__ConsequentAssignment_11 ) ) )
            // InternalSymg.g:4957:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            {
            // InternalSymg.g:4957:1: ( ( rule__Power__ConsequentAssignment_11 ) )
            // InternalSymg.g:4958:2: ( rule__Power__ConsequentAssignment_11 )
            {
             before(grammarAccess.getPowerAccess().getConsequentAssignment_11()); 
            // InternalSymg.g:4959:2: ( rule__Power__ConsequentAssignment_11 )
            // InternalSymg.g:4959:3: rule__Power__ConsequentAssignment_11
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
    // InternalSymg.g:4967:1: rule__Power__Group__12 : rule__Power__Group__12__Impl ;
    public final void rule__Power__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4971:1: ( rule__Power__Group__12__Impl )
            // InternalSymg.g:4972:2: rule__Power__Group__12__Impl
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
    // InternalSymg.g:4978:1: rule__Power__Group__12__Impl : ( ')' ) ;
    public final void rule__Power__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4982:1: ( ( ')' ) )
            // InternalSymg.g:4983:1: ( ')' )
            {
            // InternalSymg.g:4983:1: ( ')' )
            // InternalSymg.g:4984:2: ')'
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
    // InternalSymg.g:4994:1: rule__Power__Group_2__0 : rule__Power__Group_2__0__Impl rule__Power__Group_2__1 ;
    public final void rule__Power__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:4998:1: ( rule__Power__Group_2__0__Impl rule__Power__Group_2__1 )
            // InternalSymg.g:4999:2: rule__Power__Group_2__0__Impl rule__Power__Group_2__1
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
    // InternalSymg.g:5006:1: rule__Power__Group_2__0__Impl : ( ( rule__Power__TriggerAssignment_2_0 ) ) ;
    public final void rule__Power__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5010:1: ( ( ( rule__Power__TriggerAssignment_2_0 ) ) )
            // InternalSymg.g:5011:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            {
            // InternalSymg.g:5011:1: ( ( rule__Power__TriggerAssignment_2_0 ) )
            // InternalSymg.g:5012:2: ( rule__Power__TriggerAssignment_2_0 )
            {
             before(grammarAccess.getPowerAccess().getTriggerAssignment_2_0()); 
            // InternalSymg.g:5013:2: ( rule__Power__TriggerAssignment_2_0 )
            // InternalSymg.g:5013:3: rule__Power__TriggerAssignment_2_0
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
    // InternalSymg.g:5021:1: rule__Power__Group_2__1 : rule__Power__Group_2__1__Impl ;
    public final void rule__Power__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5025:1: ( rule__Power__Group_2__1__Impl )
            // InternalSymg.g:5026:2: rule__Power__Group_2__1__Impl
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
    // InternalSymg.g:5032:1: rule__Power__Group_2__1__Impl : ( '->' ) ;
    public final void rule__Power__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5036:1: ( ( '->' ) )
            // InternalSymg.g:5037:1: ( '->' )
            {
            // InternalSymg.g:5037:1: ( '->' )
            // InternalSymg.g:5038:2: '->'
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
    // InternalSymg.g:5048:1: rule__Proposition__Group__0 : rule__Proposition__Group__0__Impl rule__Proposition__Group__1 ;
    public final void rule__Proposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5052:1: ( rule__Proposition__Group__0__Impl rule__Proposition__Group__1 )
            // InternalSymg.g:5053:2: rule__Proposition__Group__0__Impl rule__Proposition__Group__1
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
    // InternalSymg.g:5060:1: rule__Proposition__Group__0__Impl : ( ( rule__Proposition__JunctionsAssignment_0 ) ) ;
    public final void rule__Proposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5064:1: ( ( ( rule__Proposition__JunctionsAssignment_0 ) ) )
            // InternalSymg.g:5065:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            {
            // InternalSymg.g:5065:1: ( ( rule__Proposition__JunctionsAssignment_0 ) )
            // InternalSymg.g:5066:2: ( rule__Proposition__JunctionsAssignment_0 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_0()); 
            // InternalSymg.g:5067:2: ( rule__Proposition__JunctionsAssignment_0 )
            // InternalSymg.g:5067:3: rule__Proposition__JunctionsAssignment_0
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
    // InternalSymg.g:5075:1: rule__Proposition__Group__1 : rule__Proposition__Group__1__Impl ;
    public final void rule__Proposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5079:1: ( rule__Proposition__Group__1__Impl )
            // InternalSymg.g:5080:2: rule__Proposition__Group__1__Impl
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
    // InternalSymg.g:5086:1: rule__Proposition__Group__1__Impl : ( ( rule__Proposition__Group_1__0 )* ) ;
    public final void rule__Proposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5090:1: ( ( ( rule__Proposition__Group_1__0 )* ) )
            // InternalSymg.g:5091:1: ( ( rule__Proposition__Group_1__0 )* )
            {
            // InternalSymg.g:5091:1: ( ( rule__Proposition__Group_1__0 )* )
            // InternalSymg.g:5092:2: ( rule__Proposition__Group_1__0 )*
            {
             before(grammarAccess.getPropositionAccess().getGroup_1()); 
            // InternalSymg.g:5093:2: ( rule__Proposition__Group_1__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==98) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSymg.g:5093:3: rule__Proposition__Group_1__0
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
    // InternalSymg.g:5102:1: rule__Proposition__Group_1__0 : rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 ;
    public final void rule__Proposition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5106:1: ( rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1 )
            // InternalSymg.g:5107:2: rule__Proposition__Group_1__0__Impl rule__Proposition__Group_1__1
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
    // InternalSymg.g:5114:1: rule__Proposition__Group_1__0__Impl : ( 'OR' ) ;
    public final void rule__Proposition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5118:1: ( ( 'OR' ) )
            // InternalSymg.g:5119:1: ( 'OR' )
            {
            // InternalSymg.g:5119:1: ( 'OR' )
            // InternalSymg.g:5120:2: 'OR'
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
    // InternalSymg.g:5129:1: rule__Proposition__Group_1__1 : rule__Proposition__Group_1__1__Impl ;
    public final void rule__Proposition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5133:1: ( rule__Proposition__Group_1__1__Impl )
            // InternalSymg.g:5134:2: rule__Proposition__Group_1__1__Impl
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
    // InternalSymg.g:5140:1: rule__Proposition__Group_1__1__Impl : ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) ;
    public final void rule__Proposition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5144:1: ( ( ( rule__Proposition__JunctionsAssignment_1_1 ) ) )
            // InternalSymg.g:5145:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            {
            // InternalSymg.g:5145:1: ( ( rule__Proposition__JunctionsAssignment_1_1 ) )
            // InternalSymg.g:5146:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            {
             before(grammarAccess.getPropositionAccess().getJunctionsAssignment_1_1()); 
            // InternalSymg.g:5147:2: ( rule__Proposition__JunctionsAssignment_1_1 )
            // InternalSymg.g:5147:3: rule__Proposition__JunctionsAssignment_1_1
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
    // InternalSymg.g:5156:1: rule__Junction__Group__0 : rule__Junction__Group__0__Impl rule__Junction__Group__1 ;
    public final void rule__Junction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5160:1: ( rule__Junction__Group__0__Impl rule__Junction__Group__1 )
            // InternalSymg.g:5161:2: rule__Junction__Group__0__Impl rule__Junction__Group__1
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
    // InternalSymg.g:5168:1: rule__Junction__Group__0__Impl : ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) ;
    public final void rule__Junction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5172:1: ( ( ( rule__Junction__NegativeAtomsAssignment_0 ) ) )
            // InternalSymg.g:5173:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            {
            // InternalSymg.g:5173:1: ( ( rule__Junction__NegativeAtomsAssignment_0 ) )
            // InternalSymg.g:5174:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_0()); 
            // InternalSymg.g:5175:2: ( rule__Junction__NegativeAtomsAssignment_0 )
            // InternalSymg.g:5175:3: rule__Junction__NegativeAtomsAssignment_0
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
    // InternalSymg.g:5183:1: rule__Junction__Group__1 : rule__Junction__Group__1__Impl ;
    public final void rule__Junction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5187:1: ( rule__Junction__Group__1__Impl )
            // InternalSymg.g:5188:2: rule__Junction__Group__1__Impl
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
    // InternalSymg.g:5194:1: rule__Junction__Group__1__Impl : ( ( rule__Junction__Group_1__0 )* ) ;
    public final void rule__Junction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5198:1: ( ( ( rule__Junction__Group_1__0 )* ) )
            // InternalSymg.g:5199:1: ( ( rule__Junction__Group_1__0 )* )
            {
            // InternalSymg.g:5199:1: ( ( rule__Junction__Group_1__0 )* )
            // InternalSymg.g:5200:2: ( rule__Junction__Group_1__0 )*
            {
             before(grammarAccess.getJunctionAccess().getGroup_1()); 
            // InternalSymg.g:5201:2: ( rule__Junction__Group_1__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==99) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSymg.g:5201:3: rule__Junction__Group_1__0
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
    // InternalSymg.g:5210:1: rule__Junction__Group_1__0 : rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 ;
    public final void rule__Junction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5214:1: ( rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1 )
            // InternalSymg.g:5215:2: rule__Junction__Group_1__0__Impl rule__Junction__Group_1__1
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
    // InternalSymg.g:5222:1: rule__Junction__Group_1__0__Impl : ( 'AND' ) ;
    public final void rule__Junction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5226:1: ( ( 'AND' ) )
            // InternalSymg.g:5227:1: ( 'AND' )
            {
            // InternalSymg.g:5227:1: ( 'AND' )
            // InternalSymg.g:5228:2: 'AND'
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
    // InternalSymg.g:5237:1: rule__Junction__Group_1__1 : rule__Junction__Group_1__1__Impl ;
    public final void rule__Junction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5241:1: ( rule__Junction__Group_1__1__Impl )
            // InternalSymg.g:5242:2: rule__Junction__Group_1__1__Impl
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
    // InternalSymg.g:5248:1: rule__Junction__Group_1__1__Impl : ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) ;
    public final void rule__Junction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5252:1: ( ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) ) )
            // InternalSymg.g:5253:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            {
            // InternalSymg.g:5253:1: ( ( rule__Junction__NegativeAtomsAssignment_1_1 ) )
            // InternalSymg.g:5254:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            {
             before(grammarAccess.getJunctionAccess().getNegativeAtomsAssignment_1_1()); 
            // InternalSymg.g:5255:2: ( rule__Junction__NegativeAtomsAssignment_1_1 )
            // InternalSymg.g:5255:3: rule__Junction__NegativeAtomsAssignment_1_1
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
    // InternalSymg.g:5264:1: rule__Negation__Group__0 : rule__Negation__Group__0__Impl rule__Negation__Group__1 ;
    public final void rule__Negation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5268:1: ( rule__Negation__Group__0__Impl rule__Negation__Group__1 )
            // InternalSymg.g:5269:2: rule__Negation__Group__0__Impl rule__Negation__Group__1
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
    // InternalSymg.g:5276:1: rule__Negation__Group__0__Impl : ( ( rule__Negation__NegatedAssignment_0 )? ) ;
    public final void rule__Negation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5280:1: ( ( ( rule__Negation__NegatedAssignment_0 )? ) )
            // InternalSymg.g:5281:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            {
            // InternalSymg.g:5281:1: ( ( rule__Negation__NegatedAssignment_0 )? )
            // InternalSymg.g:5282:2: ( rule__Negation__NegatedAssignment_0 )?
            {
             before(grammarAccess.getNegationAccess().getNegatedAssignment_0()); 
            // InternalSymg.g:5283:2: ( rule__Negation__NegatedAssignment_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==105) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalSymg.g:5283:3: rule__Negation__NegatedAssignment_0
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
    // InternalSymg.g:5291:1: rule__Negation__Group__1 : rule__Negation__Group__1__Impl ;
    public final void rule__Negation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5295:1: ( rule__Negation__Group__1__Impl )
            // InternalSymg.g:5296:2: rule__Negation__Group__1__Impl
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
    // InternalSymg.g:5302:1: rule__Negation__Group__1__Impl : ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) ;
    public final void rule__Negation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5306:1: ( ( ( rule__Negation__AtomicExpressionAssignment_1 ) ) )
            // InternalSymg.g:5307:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            {
            // InternalSymg.g:5307:1: ( ( rule__Negation__AtomicExpressionAssignment_1 ) )
            // InternalSymg.g:5308:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            {
             before(grammarAccess.getNegationAccess().getAtomicExpressionAssignment_1()); 
            // InternalSymg.g:5309:2: ( rule__Negation__AtomicExpressionAssignment_1 )
            // InternalSymg.g:5309:3: rule__Negation__AtomicExpressionAssignment_1
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
    // InternalSymg.g:5318:1: rule__Atom__Group_0__0 : rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 ;
    public final void rule__Atom__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5322:1: ( rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1 )
            // InternalSymg.g:5323:2: rule__Atom__Group_0__0__Impl rule__Atom__Group_0__1
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
    // InternalSymg.g:5330:1: rule__Atom__Group_0__0__Impl : ( 'happens' ) ;
    public final void rule__Atom__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5334:1: ( ( 'happens' ) )
            // InternalSymg.g:5335:1: ( 'happens' )
            {
            // InternalSymg.g:5335:1: ( 'happens' )
            // InternalSymg.g:5336:2: 'happens'
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
    // InternalSymg.g:5345:1: rule__Atom__Group_0__1 : rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 ;
    public final void rule__Atom__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5349:1: ( rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2 )
            // InternalSymg.g:5350:2: rule__Atom__Group_0__1__Impl rule__Atom__Group_0__2
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
    // InternalSymg.g:5357:1: rule__Atom__Group_0__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5361:1: ( ( '(' ) )
            // InternalSymg.g:5362:1: ( '(' )
            {
            // InternalSymg.g:5362:1: ( '(' )
            // InternalSymg.g:5363:2: '('
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
    // InternalSymg.g:5372:1: rule__Atom__Group_0__2 : rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 ;
    public final void rule__Atom__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5376:1: ( rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3 )
            // InternalSymg.g:5377:2: rule__Atom__Group_0__2__Impl rule__Atom__Group_0__3
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
    // InternalSymg.g:5384:1: rule__Atom__Group_0__2__Impl : ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) ;
    public final void rule__Atom__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5388:1: ( ( ( rule__Atom__EventPropositionAssignment_0_2 ) ) )
            // InternalSymg.g:5389:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            {
            // InternalSymg.g:5389:1: ( ( rule__Atom__EventPropositionAssignment_0_2 ) )
            // InternalSymg.g:5390:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            {
             before(grammarAccess.getAtomAccess().getEventPropositionAssignment_0_2()); 
            // InternalSymg.g:5391:2: ( rule__Atom__EventPropositionAssignment_0_2 )
            // InternalSymg.g:5391:3: rule__Atom__EventPropositionAssignment_0_2
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
    // InternalSymg.g:5399:1: rule__Atom__Group_0__3 : rule__Atom__Group_0__3__Impl ;
    public final void rule__Atom__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5403:1: ( rule__Atom__Group_0__3__Impl )
            // InternalSymg.g:5404:2: rule__Atom__Group_0__3__Impl
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
    // InternalSymg.g:5410:1: rule__Atom__Group_0__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5414:1: ( ( ')' ) )
            // InternalSymg.g:5415:1: ( ')' )
            {
            // InternalSymg.g:5415:1: ( ')' )
            // InternalSymg.g:5416:2: ')'
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
    // InternalSymg.g:5426:1: rule__Atom__Group_1__0 : rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 ;
    public final void rule__Atom__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5430:1: ( rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1 )
            // InternalSymg.g:5431:2: rule__Atom__Group_1__0__Impl rule__Atom__Group_1__1
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
    // InternalSymg.g:5438:1: rule__Atom__Group_1__0__Impl : ( 'occurs' ) ;
    public final void rule__Atom__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5442:1: ( ( 'occurs' ) )
            // InternalSymg.g:5443:1: ( 'occurs' )
            {
            // InternalSymg.g:5443:1: ( 'occurs' )
            // InternalSymg.g:5444:2: 'occurs'
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
    // InternalSymg.g:5453:1: rule__Atom__Group_1__1 : rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 ;
    public final void rule__Atom__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5457:1: ( rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2 )
            // InternalSymg.g:5458:2: rule__Atom__Group_1__1__Impl rule__Atom__Group_1__2
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
    // InternalSymg.g:5465:1: rule__Atom__Group_1__1__Impl : ( '(' ) ;
    public final void rule__Atom__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5469:1: ( ( '(' ) )
            // InternalSymg.g:5470:1: ( '(' )
            {
            // InternalSymg.g:5470:1: ( '(' )
            // InternalSymg.g:5471:2: '('
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
    // InternalSymg.g:5480:1: rule__Atom__Group_1__2 : rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 ;
    public final void rule__Atom__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5484:1: ( rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3 )
            // InternalSymg.g:5485:2: rule__Atom__Group_1__2__Impl rule__Atom__Group_1__3
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
    // InternalSymg.g:5492:1: rule__Atom__Group_1__2__Impl : ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) ;
    public final void rule__Atom__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5496:1: ( ( ( rule__Atom__SituationPropositionAssignment_1_2 ) ) )
            // InternalSymg.g:5497:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            {
            // InternalSymg.g:5497:1: ( ( rule__Atom__SituationPropositionAssignment_1_2 ) )
            // InternalSymg.g:5498:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            {
             before(grammarAccess.getAtomAccess().getSituationPropositionAssignment_1_2()); 
            // InternalSymg.g:5499:2: ( rule__Atom__SituationPropositionAssignment_1_2 )
            // InternalSymg.g:5499:3: rule__Atom__SituationPropositionAssignment_1_2
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
    // InternalSymg.g:5507:1: rule__Atom__Group_1__3 : rule__Atom__Group_1__3__Impl ;
    public final void rule__Atom__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5511:1: ( rule__Atom__Group_1__3__Impl )
            // InternalSymg.g:5512:2: rule__Atom__Group_1__3__Impl
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
    // InternalSymg.g:5518:1: rule__Atom__Group_1__3__Impl : ( ')' ) ;
    public final void rule__Atom__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5522:1: ( ( ')' ) )
            // InternalSymg.g:5523:1: ( ')' )
            {
            // InternalSymg.g:5523:1: ( ')' )
            // InternalSymg.g:5524:2: ')'
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
    // InternalSymg.g:5534:1: rule__Atom__Group_2__0 : rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 ;
    public final void rule__Atom__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5538:1: ( rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1 )
            // InternalSymg.g:5539:2: rule__Atom__Group_2__0__Impl rule__Atom__Group_2__1
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
    // InternalSymg.g:5546:1: rule__Atom__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Atom__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5550:1: ( ( '(' ) )
            // InternalSymg.g:5551:1: ( '(' )
            {
            // InternalSymg.g:5551:1: ( '(' )
            // InternalSymg.g:5552:2: '('
            {
             before(grammarAccess.getAtomAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,78,FOLLOW_2); 
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
    // InternalSymg.g:5561:1: rule__Atom__Group_2__1 : rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 ;
    public final void rule__Atom__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5565:1: ( rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2 )
            // InternalSymg.g:5566:2: rule__Atom__Group_2__1__Impl rule__Atom__Group_2__2
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
    // InternalSymg.g:5573:1: rule__Atom__Group_2__1__Impl : ( ( rule__Atom__InnerAssignment_2_1 ) ) ;
    public final void rule__Atom__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5577:1: ( ( ( rule__Atom__InnerAssignment_2_1 ) ) )
            // InternalSymg.g:5578:1: ( ( rule__Atom__InnerAssignment_2_1 ) )
            {
            // InternalSymg.g:5578:1: ( ( rule__Atom__InnerAssignment_2_1 ) )
            // InternalSymg.g:5579:2: ( rule__Atom__InnerAssignment_2_1 )
            {
             before(grammarAccess.getAtomAccess().getInnerAssignment_2_1()); 
            // InternalSymg.g:5580:2: ( rule__Atom__InnerAssignment_2_1 )
            // InternalSymg.g:5580:3: rule__Atom__InnerAssignment_2_1
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
    // InternalSymg.g:5588:1: rule__Atom__Group_2__2 : rule__Atom__Group_2__2__Impl ;
    public final void rule__Atom__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5592:1: ( rule__Atom__Group_2__2__Impl )
            // InternalSymg.g:5593:2: rule__Atom__Group_2__2__Impl
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
    // InternalSymg.g:5599:1: rule__Atom__Group_2__2__Impl : ( ')' ) ;
    public final void rule__Atom__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5603:1: ( ( ')' ) )
            // InternalSymg.g:5604:1: ( ')' )
            {
            // InternalSymg.g:5604:1: ( ')' )
            // InternalSymg.g:5605:2: ')'
            {
             before(grammarAccess.getAtomAccess().getRightParenthesisKeyword_2_2()); 
            match(input,79,FOLLOW_2); 
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
    // InternalSymg.g:5615:1: rule__Atom__Group_3__0 : rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 ;
    public final void rule__Atom__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5619:1: ( rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1 )
            // InternalSymg.g:5620:2: rule__Atom__Group_3__0__Impl rule__Atom__Group_3__1
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
    // InternalSymg.g:5627:1: rule__Atom__Group_3__0__Impl : ( ( rule__Atom__PointAssignment_3_0 ) ) ;
    public final void rule__Atom__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5631:1: ( ( ( rule__Atom__PointAssignment_3_0 ) ) )
            // InternalSymg.g:5632:1: ( ( rule__Atom__PointAssignment_3_0 ) )
            {
            // InternalSymg.g:5632:1: ( ( rule__Atom__PointAssignment_3_0 ) )
            // InternalSymg.g:5633:2: ( rule__Atom__PointAssignment_3_0 )
            {
             before(grammarAccess.getAtomAccess().getPointAssignment_3_0()); 
            // InternalSymg.g:5634:2: ( rule__Atom__PointAssignment_3_0 )
            // InternalSymg.g:5634:3: rule__Atom__PointAssignment_3_0
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
    // InternalSymg.g:5642:1: rule__Atom__Group_3__1 : rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2 ;
    public final void rule__Atom__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5646:1: ( rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2 )
            // InternalSymg.g:5647:2: rule__Atom__Group_3__1__Impl rule__Atom__Group_3__2
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
    // InternalSymg.g:5654:1: rule__Atom__Group_3__1__Impl : ( 'within' ) ;
    public final void rule__Atom__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5658:1: ( ( 'within' ) )
            // InternalSymg.g:5659:1: ( 'within' )
            {
            // InternalSymg.g:5659:1: ( 'within' )
            // InternalSymg.g:5660:2: 'within'
            {
             before(grammarAccess.getAtomAccess().getWithinKeyword_3_1()); 
            match(input,102,FOLLOW_2); 
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
    // InternalSymg.g:5669:1: rule__Atom__Group_3__2 : rule__Atom__Group_3__2__Impl ;
    public final void rule__Atom__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5673:1: ( rule__Atom__Group_3__2__Impl )
            // InternalSymg.g:5674:2: rule__Atom__Group_3__2__Impl
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
    // InternalSymg.g:5680:1: rule__Atom__Group_3__2__Impl : ( ( rule__Atom__IntervalAssignment_3_2 ) ) ;
    public final void rule__Atom__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5684:1: ( ( ( rule__Atom__IntervalAssignment_3_2 ) ) )
            // InternalSymg.g:5685:1: ( ( rule__Atom__IntervalAssignment_3_2 ) )
            {
            // InternalSymg.g:5685:1: ( ( rule__Atom__IntervalAssignment_3_2 ) )
            // InternalSymg.g:5686:2: ( rule__Atom__IntervalAssignment_3_2 )
            {
             before(grammarAccess.getAtomAccess().getIntervalAssignment_3_2()); 
            // InternalSymg.g:5687:2: ( rule__Atom__IntervalAssignment_3_2 )
            // InternalSymg.g:5687:3: rule__Atom__IntervalAssignment_3_2
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
    // InternalSymg.g:5696:1: rule__SitProp__Group__0 : rule__SitProp__Group__0__Impl rule__SitProp__Group__1 ;
    public final void rule__SitProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5700:1: ( rule__SitProp__Group__0__Impl rule__SitProp__Group__1 )
            // InternalSymg.g:5701:2: rule__SitProp__Group__0__Impl rule__SitProp__Group__1
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
    // InternalSymg.g:5708:1: rule__SitProp__Group__0__Impl : ( ( rule__SitProp__Alternatives_0 ) ) ;
    public final void rule__SitProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5712:1: ( ( ( rule__SitProp__Alternatives_0 ) ) )
            // InternalSymg.g:5713:1: ( ( rule__SitProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5713:1: ( ( rule__SitProp__Alternatives_0 ) )
            // InternalSymg.g:5714:2: ( rule__SitProp__Alternatives_0 )
            {
             before(grammarAccess.getSitPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5715:2: ( rule__SitProp__Alternatives_0 )
            // InternalSymg.g:5715:3: rule__SitProp__Alternatives_0
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
    // InternalSymg.g:5723:1: rule__SitProp__Group__1 : rule__SitProp__Group__1__Impl rule__SitProp__Group__2 ;
    public final void rule__SitProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5727:1: ( rule__SitProp__Group__1__Impl rule__SitProp__Group__2 )
            // InternalSymg.g:5728:2: rule__SitProp__Group__1__Impl rule__SitProp__Group__2
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
    // InternalSymg.g:5735:1: rule__SitProp__Group__1__Impl : ( ',' ) ;
    public final void rule__SitProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5739:1: ( ( ',' ) )
            // InternalSymg.g:5740:1: ( ',' )
            {
            // InternalSymg.g:5740:1: ( ',' )
            // InternalSymg.g:5741:2: ','
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
    // InternalSymg.g:5750:1: rule__SitProp__Group__2 : rule__SitProp__Group__2__Impl ;
    public final void rule__SitProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5754:1: ( rule__SitProp__Group__2__Impl )
            // InternalSymg.g:5755:2: rule__SitProp__Group__2__Impl
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
    // InternalSymg.g:5761:1: rule__SitProp__Group__2__Impl : ( ( rule__SitProp__IntervalAssignment_2 ) ) ;
    public final void rule__SitProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5765:1: ( ( ( rule__SitProp__IntervalAssignment_2 ) ) )
            // InternalSymg.g:5766:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            {
            // InternalSymg.g:5766:1: ( ( rule__SitProp__IntervalAssignment_2 ) )
            // InternalSymg.g:5767:2: ( rule__SitProp__IntervalAssignment_2 )
            {
             before(grammarAccess.getSitPropAccess().getIntervalAssignment_2()); 
            // InternalSymg.g:5768:2: ( rule__SitProp__IntervalAssignment_2 )
            // InternalSymg.g:5768:3: rule__SitProp__IntervalAssignment_2
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
    // InternalSymg.g:5777:1: rule__EventProp__Group__0 : rule__EventProp__Group__0__Impl rule__EventProp__Group__1 ;
    public final void rule__EventProp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5781:1: ( rule__EventProp__Group__0__Impl rule__EventProp__Group__1 )
            // InternalSymg.g:5782:2: rule__EventProp__Group__0__Impl rule__EventProp__Group__1
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
    // InternalSymg.g:5789:1: rule__EventProp__Group__0__Impl : ( ( rule__EventProp__Alternatives_0 ) ) ;
    public final void rule__EventProp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5793:1: ( ( ( rule__EventProp__Alternatives_0 ) ) )
            // InternalSymg.g:5794:1: ( ( rule__EventProp__Alternatives_0 ) )
            {
            // InternalSymg.g:5794:1: ( ( rule__EventProp__Alternatives_0 ) )
            // InternalSymg.g:5795:2: ( rule__EventProp__Alternatives_0 )
            {
             before(grammarAccess.getEventPropAccess().getAlternatives_0()); 
            // InternalSymg.g:5796:2: ( rule__EventProp__Alternatives_0 )
            // InternalSymg.g:5796:3: rule__EventProp__Alternatives_0
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
    // InternalSymg.g:5804:1: rule__EventProp__Group__1 : rule__EventProp__Group__1__Impl rule__EventProp__Group__2 ;
    public final void rule__EventProp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5808:1: ( rule__EventProp__Group__1__Impl rule__EventProp__Group__2 )
            // InternalSymg.g:5809:2: rule__EventProp__Group__1__Impl rule__EventProp__Group__2
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
    // InternalSymg.g:5816:1: rule__EventProp__Group__1__Impl : ( ',' ) ;
    public final void rule__EventProp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5820:1: ( ( ',' ) )
            // InternalSymg.g:5821:1: ( ',' )
            {
            // InternalSymg.g:5821:1: ( ',' )
            // InternalSymg.g:5822:2: ','
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
    // InternalSymg.g:5831:1: rule__EventProp__Group__2 : rule__EventProp__Group__2__Impl ;
    public final void rule__EventProp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5835:1: ( rule__EventProp__Group__2__Impl )
            // InternalSymg.g:5836:2: rule__EventProp__Group__2__Impl
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
    // InternalSymg.g:5842:1: rule__EventProp__Group__2__Impl : ( ( rule__EventProp__PointAssignment_2 ) ) ;
    public final void rule__EventProp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5846:1: ( ( ( rule__EventProp__PointAssignment_2 ) ) )
            // InternalSymg.g:5847:1: ( ( rule__EventProp__PointAssignment_2 ) )
            {
            // InternalSymg.g:5847:1: ( ( rule__EventProp__PointAssignment_2 ) )
            // InternalSymg.g:5848:2: ( rule__EventProp__PointAssignment_2 )
            {
             before(grammarAccess.getEventPropAccess().getPointAssignment_2()); 
            // InternalSymg.g:5849:2: ( rule__EventProp__PointAssignment_2 )
            // InternalSymg.g:5849:3: rule__EventProp__PointAssignment_2
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
    // InternalSymg.g:5858:1: rule__Interval__Group_1__0 : rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 ;
    public final void rule__Interval__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5862:1: ( rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1 )
            // InternalSymg.g:5863:2: rule__Interval__Group_1__0__Impl rule__Interval__Group_1__1
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
    // InternalSymg.g:5870:1: rule__Interval__Group_1__0__Impl : ( '[' ) ;
    public final void rule__Interval__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5874:1: ( ( '[' ) )
            // InternalSymg.g:5875:1: ( '[' )
            {
            // InternalSymg.g:5875:1: ( '[' )
            // InternalSymg.g:5876:2: '['
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
    // InternalSymg.g:5885:1: rule__Interval__Group_1__1 : rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 ;
    public final void rule__Interval__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5889:1: ( rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2 )
            // InternalSymg.g:5890:2: rule__Interval__Group_1__1__Impl rule__Interval__Group_1__2
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
    // InternalSymg.g:5897:1: rule__Interval__Group_1__1__Impl : ( ( rule__Interval__StartAssignment_1_1 ) ) ;
    public final void rule__Interval__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5901:1: ( ( ( rule__Interval__StartAssignment_1_1 ) ) )
            // InternalSymg.g:5902:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            {
            // InternalSymg.g:5902:1: ( ( rule__Interval__StartAssignment_1_1 ) )
            // InternalSymg.g:5903:2: ( rule__Interval__StartAssignment_1_1 )
            {
             before(grammarAccess.getIntervalAccess().getStartAssignment_1_1()); 
            // InternalSymg.g:5904:2: ( rule__Interval__StartAssignment_1_1 )
            // InternalSymg.g:5904:3: rule__Interval__StartAssignment_1_1
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
    // InternalSymg.g:5912:1: rule__Interval__Group_1__2 : rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 ;
    public final void rule__Interval__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5916:1: ( rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3 )
            // InternalSymg.g:5917:2: rule__Interval__Group_1__2__Impl rule__Interval__Group_1__3
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
    // InternalSymg.g:5924:1: rule__Interval__Group_1__2__Impl : ( ',' ) ;
    public final void rule__Interval__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5928:1: ( ( ',' ) )
            // InternalSymg.g:5929:1: ( ',' )
            {
            // InternalSymg.g:5929:1: ( ',' )
            // InternalSymg.g:5930:2: ','
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
    // InternalSymg.g:5939:1: rule__Interval__Group_1__3 : rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 ;
    public final void rule__Interval__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5943:1: ( rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4 )
            // InternalSymg.g:5944:2: rule__Interval__Group_1__3__Impl rule__Interval__Group_1__4
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
    // InternalSymg.g:5951:1: rule__Interval__Group_1__3__Impl : ( ( rule__Interval__EndAssignment_1_3 ) ) ;
    public final void rule__Interval__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5955:1: ( ( ( rule__Interval__EndAssignment_1_3 ) ) )
            // InternalSymg.g:5956:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            {
            // InternalSymg.g:5956:1: ( ( rule__Interval__EndAssignment_1_3 ) )
            // InternalSymg.g:5957:2: ( rule__Interval__EndAssignment_1_3 )
            {
             before(grammarAccess.getIntervalAccess().getEndAssignment_1_3()); 
            // InternalSymg.g:5958:2: ( rule__Interval__EndAssignment_1_3 )
            // InternalSymg.g:5958:3: rule__Interval__EndAssignment_1_3
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
    // InternalSymg.g:5966:1: rule__Interval__Group_1__4 : rule__Interval__Group_1__4__Impl ;
    public final void rule__Interval__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5970:1: ( rule__Interval__Group_1__4__Impl )
            // InternalSymg.g:5971:2: rule__Interval__Group_1__4__Impl
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
    // InternalSymg.g:5977:1: rule__Interval__Group_1__4__Impl : ( ']' ) ;
    public final void rule__Interval__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5981:1: ( ( ']' ) )
            // InternalSymg.g:5982:1: ( ']' )
            {
            // InternalSymg.g:5982:1: ( ']' )
            // InternalSymg.g:5983:2: ']'
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
    // InternalSymg.g:5993:1: rule__Interval__Group_3__0 : rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1 ;
    public final void rule__Interval__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:5997:1: ( rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1 )
            // InternalSymg.g:5998:2: rule__Interval__Group_3__0__Impl rule__Interval__Group_3__1
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
    // InternalSymg.g:6005:1: rule__Interval__Group_3__0__Impl : ( ( rule__Interval__SituationNameAssignment_3_0 ) ) ;
    public final void rule__Interval__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6009:1: ( ( ( rule__Interval__SituationNameAssignment_3_0 ) ) )
            // InternalSymg.g:6010:1: ( ( rule__Interval__SituationNameAssignment_3_0 ) )
            {
            // InternalSymg.g:6010:1: ( ( rule__Interval__SituationNameAssignment_3_0 ) )
            // InternalSymg.g:6011:2: ( rule__Interval__SituationNameAssignment_3_0 )
            {
             before(grammarAccess.getIntervalAccess().getSituationNameAssignment_3_0()); 
            // InternalSymg.g:6012:2: ( rule__Interval__SituationNameAssignment_3_0 )
            // InternalSymg.g:6012:3: rule__Interval__SituationNameAssignment_3_0
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
    // InternalSymg.g:6020:1: rule__Interval__Group_3__1 : rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2 ;
    public final void rule__Interval__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6024:1: ( rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2 )
            // InternalSymg.g:6025:2: rule__Interval__Group_3__1__Impl rule__Interval__Group_3__2
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
    // InternalSymg.g:6032:1: rule__Interval__Group_3__1__Impl : ( ( rule__Interval__TempOpAssignment_3_1 ) ) ;
    public final void rule__Interval__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6036:1: ( ( ( rule__Interval__TempOpAssignment_3_1 ) ) )
            // InternalSymg.g:6037:1: ( ( rule__Interval__TempOpAssignment_3_1 ) )
            {
            // InternalSymg.g:6037:1: ( ( rule__Interval__TempOpAssignment_3_1 ) )
            // InternalSymg.g:6038:2: ( rule__Interval__TempOpAssignment_3_1 )
            {
             before(grammarAccess.getIntervalAccess().getTempOpAssignment_3_1()); 
            // InternalSymg.g:6039:2: ( rule__Interval__TempOpAssignment_3_1 )
            // InternalSymg.g:6039:3: rule__Interval__TempOpAssignment_3_1
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
    // InternalSymg.g:6047:1: rule__Interval__Group_3__2 : rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3 ;
    public final void rule__Interval__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6051:1: ( rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3 )
            // InternalSymg.g:6052:2: rule__Interval__Group_3__2__Impl rule__Interval__Group_3__3
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
    // InternalSymg.g:6059:1: rule__Interval__Group_3__2__Impl : ( ( rule__Interval__IntConstAssignment_3_2 ) ) ;
    public final void rule__Interval__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6063:1: ( ( ( rule__Interval__IntConstAssignment_3_2 ) ) )
            // InternalSymg.g:6064:1: ( ( rule__Interval__IntConstAssignment_3_2 ) )
            {
            // InternalSymg.g:6064:1: ( ( rule__Interval__IntConstAssignment_3_2 ) )
            // InternalSymg.g:6065:2: ( rule__Interval__IntConstAssignment_3_2 )
            {
             before(grammarAccess.getIntervalAccess().getIntConstAssignment_3_2()); 
            // InternalSymg.g:6066:2: ( rule__Interval__IntConstAssignment_3_2 )
            // InternalSymg.g:6066:3: rule__Interval__IntConstAssignment_3_2
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
    // InternalSymg.g:6074:1: rule__Interval__Group_3__3 : rule__Interval__Group_3__3__Impl ;
    public final void rule__Interval__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6078:1: ( rule__Interval__Group_3__3__Impl )
            // InternalSymg.g:6079:2: rule__Interval__Group_3__3__Impl
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
    // InternalSymg.g:6085:1: rule__Interval__Group_3__3__Impl : ( ( rule__Interval__UnitAssignment_3_3 ) ) ;
    public final void rule__Interval__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6089:1: ( ( ( rule__Interval__UnitAssignment_3_3 ) ) )
            // InternalSymg.g:6090:1: ( ( rule__Interval__UnitAssignment_3_3 ) )
            {
            // InternalSymg.g:6090:1: ( ( rule__Interval__UnitAssignment_3_3 ) )
            // InternalSymg.g:6091:2: ( rule__Interval__UnitAssignment_3_3 )
            {
             before(grammarAccess.getIntervalAccess().getUnitAssignment_3_3()); 
            // InternalSymg.g:6092:2: ( rule__Interval__UnitAssignment_3_3 )
            // InternalSymg.g:6092:3: rule__Interval__UnitAssignment_3_3
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
    // InternalSymg.g:6101:1: rule__IntConst__Group__0 : rule__IntConst__Group__0__Impl rule__IntConst__Group__1 ;
    public final void rule__IntConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6105:1: ( rule__IntConst__Group__0__Impl rule__IntConst__Group__1 )
            // InternalSymg.g:6106:2: rule__IntConst__Group__0__Impl rule__IntConst__Group__1
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
    // InternalSymg.g:6113:1: rule__IntConst__Group__0__Impl : ( () ) ;
    public final void rule__IntConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6117:1: ( ( () ) )
            // InternalSymg.g:6118:1: ( () )
            {
            // InternalSymg.g:6118:1: ( () )
            // InternalSymg.g:6119:2: ()
            {
             before(grammarAccess.getIntConstAccess().getIntConstAction_0()); 
            // InternalSymg.g:6120:2: ()
            // InternalSymg.g:6120:3: 
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
    // InternalSymg.g:6128:1: rule__IntConst__Group__1 : rule__IntConst__Group__1__Impl ;
    public final void rule__IntConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6132:1: ( rule__IntConst__Group__1__Impl )
            // InternalSymg.g:6133:2: rule__IntConst__Group__1__Impl
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
    // InternalSymg.g:6139:1: rule__IntConst__Group__1__Impl : ( ( rule__IntConst__TypeAssignment_1 ) ) ;
    public final void rule__IntConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6143:1: ( ( ( rule__IntConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6144:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6144:1: ( ( rule__IntConst__TypeAssignment_1 ) )
            // InternalSymg.g:6145:2: ( rule__IntConst__TypeAssignment_1 )
            {
             before(grammarAccess.getIntConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6146:2: ( rule__IntConst__TypeAssignment_1 )
            // InternalSymg.g:6146:3: rule__IntConst__TypeAssignment_1
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
    // InternalSymg.g:6155:1: rule__Point__Group_3__0 : rule__Point__Group_3__0__Impl rule__Point__Group_3__1 ;
    public final void rule__Point__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6159:1: ( rule__Point__Group_3__0__Impl rule__Point__Group_3__1 )
            // InternalSymg.g:6160:2: rule__Point__Group_3__0__Impl rule__Point__Group_3__1
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
    // InternalSymg.g:6167:1: rule__Point__Group_3__0__Impl : ( ( rule__Point__PointConstAssignment_3_0 ) ) ;
    public final void rule__Point__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6171:1: ( ( ( rule__Point__PointConstAssignment_3_0 ) ) )
            // InternalSymg.g:6172:1: ( ( rule__Point__PointConstAssignment_3_0 ) )
            {
            // InternalSymg.g:6172:1: ( ( rule__Point__PointConstAssignment_3_0 ) )
            // InternalSymg.g:6173:2: ( rule__Point__PointConstAssignment_3_0 )
            {
             before(grammarAccess.getPointAccess().getPointConstAssignment_3_0()); 
            // InternalSymg.g:6174:2: ( rule__Point__PointConstAssignment_3_0 )
            // InternalSymg.g:6174:3: rule__Point__PointConstAssignment_3_0
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
    // InternalSymg.g:6182:1: rule__Point__Group_3__1 : rule__Point__Group_3__1__Impl rule__Point__Group_3__2 ;
    public final void rule__Point__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6186:1: ( rule__Point__Group_3__1__Impl rule__Point__Group_3__2 )
            // InternalSymg.g:6187:2: rule__Point__Group_3__1__Impl rule__Point__Group_3__2
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
    // InternalSymg.g:6194:1: rule__Point__Group_3__1__Impl : ( ( rule__Point__UnitAssignment_3_1 ) ) ;
    public final void rule__Point__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6198:1: ( ( ( rule__Point__UnitAssignment_3_1 ) ) )
            // InternalSymg.g:6199:1: ( ( rule__Point__UnitAssignment_3_1 ) )
            {
            // InternalSymg.g:6199:1: ( ( rule__Point__UnitAssignment_3_1 ) )
            // InternalSymg.g:6200:2: ( rule__Point__UnitAssignment_3_1 )
            {
             before(grammarAccess.getPointAccess().getUnitAssignment_3_1()); 
            // InternalSymg.g:6201:2: ( rule__Point__UnitAssignment_3_1 )
            // InternalSymg.g:6201:3: rule__Point__UnitAssignment_3_1
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
    // InternalSymg.g:6209:1: rule__Point__Group_3__2 : rule__Point__Group_3__2__Impl rule__Point__Group_3__3 ;
    public final void rule__Point__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6213:1: ( rule__Point__Group_3__2__Impl rule__Point__Group_3__3 )
            // InternalSymg.g:6214:2: rule__Point__Group_3__2__Impl rule__Point__Group_3__3
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
    // InternalSymg.g:6221:1: rule__Point__Group_3__2__Impl : ( ( rule__Point__TempOpAssignment_3_2 ) ) ;
    public final void rule__Point__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6225:1: ( ( ( rule__Point__TempOpAssignment_3_2 ) ) )
            // InternalSymg.g:6226:1: ( ( rule__Point__TempOpAssignment_3_2 ) )
            {
            // InternalSymg.g:6226:1: ( ( rule__Point__TempOpAssignment_3_2 ) )
            // InternalSymg.g:6227:2: ( rule__Point__TempOpAssignment_3_2 )
            {
             before(grammarAccess.getPointAccess().getTempOpAssignment_3_2()); 
            // InternalSymg.g:6228:2: ( rule__Point__TempOpAssignment_3_2 )
            // InternalSymg.g:6228:3: rule__Point__TempOpAssignment_3_2
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
    // InternalSymg.g:6236:1: rule__Point__Group_3__3 : rule__Point__Group_3__3__Impl ;
    public final void rule__Point__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6240:1: ( rule__Point__Group_3__3__Impl )
            // InternalSymg.g:6241:2: rule__Point__Group_3__3__Impl
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
    // InternalSymg.g:6247:1: rule__Point__Group_3__3__Impl : ( ( rule__Point__EventNameAssignment_3_3 ) ) ;
    public final void rule__Point__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6251:1: ( ( ( rule__Point__EventNameAssignment_3_3 ) ) )
            // InternalSymg.g:6252:1: ( ( rule__Point__EventNameAssignment_3_3 ) )
            {
            // InternalSymg.g:6252:1: ( ( rule__Point__EventNameAssignment_3_3 ) )
            // InternalSymg.g:6253:2: ( rule__Point__EventNameAssignment_3_3 )
            {
             before(grammarAccess.getPointAccess().getEventNameAssignment_3_3()); 
            // InternalSymg.g:6254:2: ( rule__Point__EventNameAssignment_3_3 )
            // InternalSymg.g:6254:3: rule__Point__EventNameAssignment_3_3
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
    // InternalSymg.g:6263:1: rule__PEvent__Group__0 : rule__PEvent__Group__0__Impl rule__PEvent__Group__1 ;
    public final void rule__PEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6267:1: ( rule__PEvent__Group__0__Impl rule__PEvent__Group__1 )
            // InternalSymg.g:6268:2: rule__PEvent__Group__0__Impl rule__PEvent__Group__1
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
    // InternalSymg.g:6275:1: rule__PEvent__Group__0__Impl : ( ( rule__PEvent__PowEventAssignment_0 ) ) ;
    public final void rule__PEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6279:1: ( ( ( rule__PEvent__PowEventAssignment_0 ) ) )
            // InternalSymg.g:6280:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            {
            // InternalSymg.g:6280:1: ( ( rule__PEvent__PowEventAssignment_0 ) )
            // InternalSymg.g:6281:2: ( rule__PEvent__PowEventAssignment_0 )
            {
             before(grammarAccess.getPEventAccess().getPowEventAssignment_0()); 
            // InternalSymg.g:6282:2: ( rule__PEvent__PowEventAssignment_0 )
            // InternalSymg.g:6282:3: rule__PEvent__PowEventAssignment_0
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
    // InternalSymg.g:6290:1: rule__PEvent__Group__1 : rule__PEvent__Group__1__Impl rule__PEvent__Group__2 ;
    public final void rule__PEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6294:1: ( rule__PEvent__Group__1__Impl rule__PEvent__Group__2 )
            // InternalSymg.g:6295:2: rule__PEvent__Group__1__Impl rule__PEvent__Group__2
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
    // InternalSymg.g:6302:1: rule__PEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__PEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6306:1: ( ( '(' ) )
            // InternalSymg.g:6307:1: ( '(' )
            {
            // InternalSymg.g:6307:1: ( '(' )
            // InternalSymg.g:6308:2: '('
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
    // InternalSymg.g:6317:1: rule__PEvent__Group__2 : rule__PEvent__Group__2__Impl rule__PEvent__Group__3 ;
    public final void rule__PEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6321:1: ( rule__PEvent__Group__2__Impl rule__PEvent__Group__3 )
            // InternalSymg.g:6322:2: rule__PEvent__Group__2__Impl rule__PEvent__Group__3
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
    // InternalSymg.g:6329:1: rule__PEvent__Group__2__Impl : ( ( rule__PEvent__PowNameAssignment_2 ) ) ;
    public final void rule__PEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6333:1: ( ( ( rule__PEvent__PowNameAssignment_2 ) ) )
            // InternalSymg.g:6334:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:6334:1: ( ( rule__PEvent__PowNameAssignment_2 ) )
            // InternalSymg.g:6335:2: ( rule__PEvent__PowNameAssignment_2 )
            {
             before(grammarAccess.getPEventAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:6336:2: ( rule__PEvent__PowNameAssignment_2 )
            // InternalSymg.g:6336:3: rule__PEvent__PowNameAssignment_2
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
    // InternalSymg.g:6344:1: rule__PEvent__Group__3 : rule__PEvent__Group__3__Impl ;
    public final void rule__PEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6348:1: ( rule__PEvent__Group__3__Impl )
            // InternalSymg.g:6349:2: rule__PEvent__Group__3__Impl
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
    // InternalSymg.g:6355:1: rule__PEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__PEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6359:1: ( ( ')' ) )
            // InternalSymg.g:6360:1: ( ')' )
            {
            // InternalSymg.g:6360:1: ( ')' )
            // InternalSymg.g:6361:2: ')'
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
    // InternalSymg.g:6371:1: rule__CEvent__Group__0 : rule__CEvent__Group__0__Impl rule__CEvent__Group__1 ;
    public final void rule__CEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6375:1: ( rule__CEvent__Group__0__Impl rule__CEvent__Group__1 )
            // InternalSymg.g:6376:2: rule__CEvent__Group__0__Impl rule__CEvent__Group__1
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
    // InternalSymg.g:6383:1: rule__CEvent__Group__0__Impl : ( ( rule__CEvent__ContrEventAssignment_0 ) ) ;
    public final void rule__CEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6387:1: ( ( ( rule__CEvent__ContrEventAssignment_0 ) ) )
            // InternalSymg.g:6388:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            {
            // InternalSymg.g:6388:1: ( ( rule__CEvent__ContrEventAssignment_0 ) )
            // InternalSymg.g:6389:2: ( rule__CEvent__ContrEventAssignment_0 )
            {
             before(grammarAccess.getCEventAccess().getContrEventAssignment_0()); 
            // InternalSymg.g:6390:2: ( rule__CEvent__ContrEventAssignment_0 )
            // InternalSymg.g:6390:3: rule__CEvent__ContrEventAssignment_0
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
    // InternalSymg.g:6398:1: rule__CEvent__Group__1 : rule__CEvent__Group__1__Impl rule__CEvent__Group__2 ;
    public final void rule__CEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6402:1: ( rule__CEvent__Group__1__Impl rule__CEvent__Group__2 )
            // InternalSymg.g:6403:2: rule__CEvent__Group__1__Impl rule__CEvent__Group__2
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
    // InternalSymg.g:6410:1: rule__CEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__CEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6414:1: ( ( '(' ) )
            // InternalSymg.g:6415:1: ( '(' )
            {
            // InternalSymg.g:6415:1: ( '(' )
            // InternalSymg.g:6416:2: '('
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
    // InternalSymg.g:6425:1: rule__CEvent__Group__2 : rule__CEvent__Group__2__Impl rule__CEvent__Group__3 ;
    public final void rule__CEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6429:1: ( rule__CEvent__Group__2__Impl rule__CEvent__Group__3 )
            // InternalSymg.g:6430:2: rule__CEvent__Group__2__Impl rule__CEvent__Group__3
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
    // InternalSymg.g:6437:1: rule__CEvent__Group__2__Impl : ( ( rule__CEvent__ContrNameAssignment_2 ) ) ;
    public final void rule__CEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6441:1: ( ( ( rule__CEvent__ContrNameAssignment_2 ) ) )
            // InternalSymg.g:6442:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            {
            // InternalSymg.g:6442:1: ( ( rule__CEvent__ContrNameAssignment_2 ) )
            // InternalSymg.g:6443:2: ( rule__CEvent__ContrNameAssignment_2 )
            {
             before(grammarAccess.getCEventAccess().getContrNameAssignment_2()); 
            // InternalSymg.g:6444:2: ( rule__CEvent__ContrNameAssignment_2 )
            // InternalSymg.g:6444:3: rule__CEvent__ContrNameAssignment_2
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
    // InternalSymg.g:6452:1: rule__CEvent__Group__3 : rule__CEvent__Group__3__Impl ;
    public final void rule__CEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6456:1: ( rule__CEvent__Group__3__Impl )
            // InternalSymg.g:6457:2: rule__CEvent__Group__3__Impl
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
    // InternalSymg.g:6463:1: rule__CEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__CEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6467:1: ( ( ')' ) )
            // InternalSymg.g:6468:1: ( ')' )
            {
            // InternalSymg.g:6468:1: ( ')' )
            // InternalSymg.g:6469:2: ')'
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
    // InternalSymg.g:6479:1: rule__OEvent__Group__0 : rule__OEvent__Group__0__Impl rule__OEvent__Group__1 ;
    public final void rule__OEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6483:1: ( rule__OEvent__Group__0__Impl rule__OEvent__Group__1 )
            // InternalSymg.g:6484:2: rule__OEvent__Group__0__Impl rule__OEvent__Group__1
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
    // InternalSymg.g:6491:1: rule__OEvent__Group__0__Impl : ( ( rule__OEvent__OblEventAssignment_0 ) ) ;
    public final void rule__OEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6495:1: ( ( ( rule__OEvent__OblEventAssignment_0 ) ) )
            // InternalSymg.g:6496:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            {
            // InternalSymg.g:6496:1: ( ( rule__OEvent__OblEventAssignment_0 ) )
            // InternalSymg.g:6497:2: ( rule__OEvent__OblEventAssignment_0 )
            {
             before(grammarAccess.getOEventAccess().getOblEventAssignment_0()); 
            // InternalSymg.g:6498:2: ( rule__OEvent__OblEventAssignment_0 )
            // InternalSymg.g:6498:3: rule__OEvent__OblEventAssignment_0
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
    // InternalSymg.g:6506:1: rule__OEvent__Group__1 : rule__OEvent__Group__1__Impl rule__OEvent__Group__2 ;
    public final void rule__OEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6510:1: ( rule__OEvent__Group__1__Impl rule__OEvent__Group__2 )
            // InternalSymg.g:6511:2: rule__OEvent__Group__1__Impl rule__OEvent__Group__2
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
    // InternalSymg.g:6518:1: rule__OEvent__Group__1__Impl : ( '(' ) ;
    public final void rule__OEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6522:1: ( ( '(' ) )
            // InternalSymg.g:6523:1: ( '(' )
            {
            // InternalSymg.g:6523:1: ( '(' )
            // InternalSymg.g:6524:2: '('
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
    // InternalSymg.g:6533:1: rule__OEvent__Group__2 : rule__OEvent__Group__2__Impl rule__OEvent__Group__3 ;
    public final void rule__OEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6537:1: ( rule__OEvent__Group__2__Impl rule__OEvent__Group__3 )
            // InternalSymg.g:6538:2: rule__OEvent__Group__2__Impl rule__OEvent__Group__3
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
    // InternalSymg.g:6545:1: rule__OEvent__Group__2__Impl : ( ( rule__OEvent__OblNameAssignment_2 ) ) ;
    public final void rule__OEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6549:1: ( ( ( rule__OEvent__OblNameAssignment_2 ) ) )
            // InternalSymg.g:6550:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:6550:1: ( ( rule__OEvent__OblNameAssignment_2 ) )
            // InternalSymg.g:6551:2: ( rule__OEvent__OblNameAssignment_2 )
            {
             before(grammarAccess.getOEventAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:6552:2: ( rule__OEvent__OblNameAssignment_2 )
            // InternalSymg.g:6552:3: rule__OEvent__OblNameAssignment_2
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
    // InternalSymg.g:6560:1: rule__OEvent__Group__3 : rule__OEvent__Group__3__Impl ;
    public final void rule__OEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6564:1: ( rule__OEvent__Group__3__Impl )
            // InternalSymg.g:6565:2: rule__OEvent__Group__3__Impl
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
    // InternalSymg.g:6571:1: rule__OEvent__Group__3__Impl : ( ')' ) ;
    public final void rule__OEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6575:1: ( ( ')' ) )
            // InternalSymg.g:6576:1: ( ')' )
            {
            // InternalSymg.g:6576:1: ( ')' )
            // InternalSymg.g:6577:2: ')'
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
    // InternalSymg.g:6587:1: rule__PointConst__Group__0 : rule__PointConst__Group__0__Impl rule__PointConst__Group__1 ;
    public final void rule__PointConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6591:1: ( rule__PointConst__Group__0__Impl rule__PointConst__Group__1 )
            // InternalSymg.g:6592:2: rule__PointConst__Group__0__Impl rule__PointConst__Group__1
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
    // InternalSymg.g:6599:1: rule__PointConst__Group__0__Impl : ( () ) ;
    public final void rule__PointConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6603:1: ( ( () ) )
            // InternalSymg.g:6604:1: ( () )
            {
            // InternalSymg.g:6604:1: ( () )
            // InternalSymg.g:6605:2: ()
            {
             before(grammarAccess.getPointConstAccess().getPointConstAction_0()); 
            // InternalSymg.g:6606:2: ()
            // InternalSymg.g:6606:3: 
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
    // InternalSymg.g:6614:1: rule__PointConst__Group__1 : rule__PointConst__Group__1__Impl ;
    public final void rule__PointConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6618:1: ( rule__PointConst__Group__1__Impl )
            // InternalSymg.g:6619:2: rule__PointConst__Group__1__Impl
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
    // InternalSymg.g:6625:1: rule__PointConst__Group__1__Impl : ( ( rule__PointConst__TypeAssignment_1 ) ) ;
    public final void rule__PointConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6629:1: ( ( ( rule__PointConst__TypeAssignment_1 ) ) )
            // InternalSymg.g:6630:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            {
            // InternalSymg.g:6630:1: ( ( rule__PointConst__TypeAssignment_1 ) )
            // InternalSymg.g:6631:2: ( rule__PointConst__TypeAssignment_1 )
            {
             before(grammarAccess.getPointConstAccess().getTypeAssignment_1()); 
            // InternalSymg.g:6632:2: ( rule__PointConst__TypeAssignment_1 )
            // InternalSymg.g:6632:3: rule__PointConst__TypeAssignment_1
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
    // InternalSymg.g:6641:1: rule__OState__Group__0 : rule__OState__Group__0__Impl rule__OState__Group__1 ;
    public final void rule__OState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6645:1: ( rule__OState__Group__0__Impl rule__OState__Group__1 )
            // InternalSymg.g:6646:2: rule__OState__Group__0__Impl rule__OState__Group__1
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
    // InternalSymg.g:6653:1: rule__OState__Group__0__Impl : ( ( rule__OState__OblStateAssignment_0 ) ) ;
    public final void rule__OState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6657:1: ( ( ( rule__OState__OblStateAssignment_0 ) ) )
            // InternalSymg.g:6658:1: ( ( rule__OState__OblStateAssignment_0 ) )
            {
            // InternalSymg.g:6658:1: ( ( rule__OState__OblStateAssignment_0 ) )
            // InternalSymg.g:6659:2: ( rule__OState__OblStateAssignment_0 )
            {
             before(grammarAccess.getOStateAccess().getOblStateAssignment_0()); 
            // InternalSymg.g:6660:2: ( rule__OState__OblStateAssignment_0 )
            // InternalSymg.g:6660:3: rule__OState__OblStateAssignment_0
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
    // InternalSymg.g:6668:1: rule__OState__Group__1 : rule__OState__Group__1__Impl rule__OState__Group__2 ;
    public final void rule__OState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6672:1: ( rule__OState__Group__1__Impl rule__OState__Group__2 )
            // InternalSymg.g:6673:2: rule__OState__Group__1__Impl rule__OState__Group__2
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
    // InternalSymg.g:6680:1: rule__OState__Group__1__Impl : ( '(' ) ;
    public final void rule__OState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6684:1: ( ( '(' ) )
            // InternalSymg.g:6685:1: ( '(' )
            {
            // InternalSymg.g:6685:1: ( '(' )
            // InternalSymg.g:6686:2: '('
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
    // InternalSymg.g:6695:1: rule__OState__Group__2 : rule__OState__Group__2__Impl rule__OState__Group__3 ;
    public final void rule__OState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6699:1: ( rule__OState__Group__2__Impl rule__OState__Group__3 )
            // InternalSymg.g:6700:2: rule__OState__Group__2__Impl rule__OState__Group__3
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
    // InternalSymg.g:6707:1: rule__OState__Group__2__Impl : ( ( rule__OState__OblNameAssignment_2 ) ) ;
    public final void rule__OState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6711:1: ( ( ( rule__OState__OblNameAssignment_2 ) ) )
            // InternalSymg.g:6712:1: ( ( rule__OState__OblNameAssignment_2 ) )
            {
            // InternalSymg.g:6712:1: ( ( rule__OState__OblNameAssignment_2 ) )
            // InternalSymg.g:6713:2: ( rule__OState__OblNameAssignment_2 )
            {
             before(grammarAccess.getOStateAccess().getOblNameAssignment_2()); 
            // InternalSymg.g:6714:2: ( rule__OState__OblNameAssignment_2 )
            // InternalSymg.g:6714:3: rule__OState__OblNameAssignment_2
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
    // InternalSymg.g:6722:1: rule__OState__Group__3 : rule__OState__Group__3__Impl ;
    public final void rule__OState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6726:1: ( rule__OState__Group__3__Impl )
            // InternalSymg.g:6727:2: rule__OState__Group__3__Impl
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
    // InternalSymg.g:6733:1: rule__OState__Group__3__Impl : ( ')' ) ;
    public final void rule__OState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6737:1: ( ( ')' ) )
            // InternalSymg.g:6738:1: ( ')' )
            {
            // InternalSymg.g:6738:1: ( ')' )
            // InternalSymg.g:6739:2: ')'
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
    // InternalSymg.g:6749:1: rule__CState__Group__0 : rule__CState__Group__0__Impl rule__CState__Group__1 ;
    public final void rule__CState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6753:1: ( rule__CState__Group__0__Impl rule__CState__Group__1 )
            // InternalSymg.g:6754:2: rule__CState__Group__0__Impl rule__CState__Group__1
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
    // InternalSymg.g:6761:1: rule__CState__Group__0__Impl : ( ( rule__CState__ContrStateAssignment_0 ) ) ;
    public final void rule__CState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6765:1: ( ( ( rule__CState__ContrStateAssignment_0 ) ) )
            // InternalSymg.g:6766:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            {
            // InternalSymg.g:6766:1: ( ( rule__CState__ContrStateAssignment_0 ) )
            // InternalSymg.g:6767:2: ( rule__CState__ContrStateAssignment_0 )
            {
             before(grammarAccess.getCStateAccess().getContrStateAssignment_0()); 
            // InternalSymg.g:6768:2: ( rule__CState__ContrStateAssignment_0 )
            // InternalSymg.g:6768:3: rule__CState__ContrStateAssignment_0
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
    // InternalSymg.g:6776:1: rule__CState__Group__1 : rule__CState__Group__1__Impl rule__CState__Group__2 ;
    public final void rule__CState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6780:1: ( rule__CState__Group__1__Impl rule__CState__Group__2 )
            // InternalSymg.g:6781:2: rule__CState__Group__1__Impl rule__CState__Group__2
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
    // InternalSymg.g:6788:1: rule__CState__Group__1__Impl : ( '(' ) ;
    public final void rule__CState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6792:1: ( ( '(' ) )
            // InternalSymg.g:6793:1: ( '(' )
            {
            // InternalSymg.g:6793:1: ( '(' )
            // InternalSymg.g:6794:2: '('
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
    // InternalSymg.g:6803:1: rule__CState__Group__2 : rule__CState__Group__2__Impl rule__CState__Group__3 ;
    public final void rule__CState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6807:1: ( rule__CState__Group__2__Impl rule__CState__Group__3 )
            // InternalSymg.g:6808:2: rule__CState__Group__2__Impl rule__CState__Group__3
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
    // InternalSymg.g:6815:1: rule__CState__Group__2__Impl : ( ( rule__CState__ContractNameAssignment_2 ) ) ;
    public final void rule__CState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6819:1: ( ( ( rule__CState__ContractNameAssignment_2 ) ) )
            // InternalSymg.g:6820:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            {
            // InternalSymg.g:6820:1: ( ( rule__CState__ContractNameAssignment_2 ) )
            // InternalSymg.g:6821:2: ( rule__CState__ContractNameAssignment_2 )
            {
             before(grammarAccess.getCStateAccess().getContractNameAssignment_2()); 
            // InternalSymg.g:6822:2: ( rule__CState__ContractNameAssignment_2 )
            // InternalSymg.g:6822:3: rule__CState__ContractNameAssignment_2
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
    // InternalSymg.g:6830:1: rule__CState__Group__3 : rule__CState__Group__3__Impl ;
    public final void rule__CState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6834:1: ( rule__CState__Group__3__Impl )
            // InternalSymg.g:6835:2: rule__CState__Group__3__Impl
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
    // InternalSymg.g:6841:1: rule__CState__Group__3__Impl : ( ')' ) ;
    public final void rule__CState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6845:1: ( ( ')' ) )
            // InternalSymg.g:6846:1: ( ')' )
            {
            // InternalSymg.g:6846:1: ( ')' )
            // InternalSymg.g:6847:2: ')'
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
    // InternalSymg.g:6857:1: rule__PState__Group__0 : rule__PState__Group__0__Impl rule__PState__Group__1 ;
    public final void rule__PState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6861:1: ( rule__PState__Group__0__Impl rule__PState__Group__1 )
            // InternalSymg.g:6862:2: rule__PState__Group__0__Impl rule__PState__Group__1
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
    // InternalSymg.g:6869:1: rule__PState__Group__0__Impl : ( ( rule__PState__PowStateAssignment_0 ) ) ;
    public final void rule__PState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6873:1: ( ( ( rule__PState__PowStateAssignment_0 ) ) )
            // InternalSymg.g:6874:1: ( ( rule__PState__PowStateAssignment_0 ) )
            {
            // InternalSymg.g:6874:1: ( ( rule__PState__PowStateAssignment_0 ) )
            // InternalSymg.g:6875:2: ( rule__PState__PowStateAssignment_0 )
            {
             before(grammarAccess.getPStateAccess().getPowStateAssignment_0()); 
            // InternalSymg.g:6876:2: ( rule__PState__PowStateAssignment_0 )
            // InternalSymg.g:6876:3: rule__PState__PowStateAssignment_0
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
    // InternalSymg.g:6884:1: rule__PState__Group__1 : rule__PState__Group__1__Impl rule__PState__Group__2 ;
    public final void rule__PState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6888:1: ( rule__PState__Group__1__Impl rule__PState__Group__2 )
            // InternalSymg.g:6889:2: rule__PState__Group__1__Impl rule__PState__Group__2
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
    // InternalSymg.g:6896:1: rule__PState__Group__1__Impl : ( '(' ) ;
    public final void rule__PState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6900:1: ( ( '(' ) )
            // InternalSymg.g:6901:1: ( '(' )
            {
            // InternalSymg.g:6901:1: ( '(' )
            // InternalSymg.g:6902:2: '('
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
    // InternalSymg.g:6911:1: rule__PState__Group__2 : rule__PState__Group__2__Impl rule__PState__Group__3 ;
    public final void rule__PState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6915:1: ( rule__PState__Group__2__Impl rule__PState__Group__3 )
            // InternalSymg.g:6916:2: rule__PState__Group__2__Impl rule__PState__Group__3
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
    // InternalSymg.g:6923:1: rule__PState__Group__2__Impl : ( ( rule__PState__PowNameAssignment_2 ) ) ;
    public final void rule__PState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6927:1: ( ( ( rule__PState__PowNameAssignment_2 ) ) )
            // InternalSymg.g:6928:1: ( ( rule__PState__PowNameAssignment_2 ) )
            {
            // InternalSymg.g:6928:1: ( ( rule__PState__PowNameAssignment_2 ) )
            // InternalSymg.g:6929:2: ( rule__PState__PowNameAssignment_2 )
            {
             before(grammarAccess.getPStateAccess().getPowNameAssignment_2()); 
            // InternalSymg.g:6930:2: ( rule__PState__PowNameAssignment_2 )
            // InternalSymg.g:6930:3: rule__PState__PowNameAssignment_2
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
    // InternalSymg.g:6938:1: rule__PState__Group__3 : rule__PState__Group__3__Impl ;
    public final void rule__PState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6942:1: ( rule__PState__Group__3__Impl )
            // InternalSymg.g:6943:2: rule__PState__Group__3__Impl
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
    // InternalSymg.g:6949:1: rule__PState__Group__3__Impl : ( ')' ) ;
    public final void rule__PState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6953:1: ( ( ')' ) )
            // InternalSymg.g:6954:1: ( ')' )
            {
            // InternalSymg.g:6954:1: ( ')' )
            // InternalSymg.g:6955:2: ')'
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
    // InternalSymg.g:6965:1: rule__Model__DomainNameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Model__DomainNameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6969:1: ( ( RULE_ID ) )
            // InternalSymg.g:6970:2: ( RULE_ID )
            {
            // InternalSymg.g:6970:2: ( RULE_ID )
            // InternalSymg.g:6971:3: RULE_ID
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
    // InternalSymg.g:6980:1: rule__Model__DomainConceptsAssignment_2_0 : ( ruleDomainConcept ) ;
    public final void rule__Model__DomainConceptsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6984:1: ( ( ruleDomainConcept ) )
            // InternalSymg.g:6985:2: ( ruleDomainConcept )
            {
            // InternalSymg.g:6985:2: ( ruleDomainConcept )
            // InternalSymg.g:6986:3: ruleDomainConcept
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
    // InternalSymg.g:6995:1: rule__Model__ContractNameAssignment_5 : ( RULE_ID ) ;
    public final void rule__Model__ContractNameAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:6999:1: ( ( RULE_ID ) )
            // InternalSymg.g:7000:2: ( RULE_ID )
            {
            // InternalSymg.g:7000:2: ( RULE_ID )
            // InternalSymg.g:7001:3: RULE_ID
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
    // InternalSymg.g:7010:1: rule__Model__ParametersAssignment_7_0 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7014:1: ( ( ruleParameter ) )
            // InternalSymg.g:7015:2: ( ruleParameter )
            {
            // InternalSymg.g:7015:2: ( ruleParameter )
            // InternalSymg.g:7016:3: ruleParameter
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
    // InternalSymg.g:7025:1: rule__Model__ParametersAssignment_8 : ( ruleParameter ) ;
    public final void rule__Model__ParametersAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7029:1: ( ( ruleParameter ) )
            // InternalSymg.g:7030:2: ( ruleParameter )
            {
            // InternalSymg.g:7030:2: ( ruleParameter )
            // InternalSymg.g:7031:3: ruleParameter
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
    // InternalSymg.g:7040:1: rule__Model__DeclarationsAssignment_10_1_0 : ( ruleDeclar ) ;
    public final void rule__Model__DeclarationsAssignment_10_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7044:1: ( ( ruleDeclar ) )
            // InternalSymg.g:7045:2: ( ruleDeclar )
            {
            // InternalSymg.g:7045:2: ( ruleDeclar )
            // InternalSymg.g:7046:3: ruleDeclar
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
    // InternalSymg.g:7055:1: rule__Model__PreconditionsAssignment_11_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PreconditionsAssignment_11_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7059:1: ( ( ruleProposition ) )
            // InternalSymg.g:7060:2: ( ruleProposition )
            {
            // InternalSymg.g:7060:2: ( ruleProposition )
            // InternalSymg.g:7061:3: ruleProposition
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
    // InternalSymg.g:7070:1: rule__Model__PostconditionsAssignment_12_1_0 : ( ruleProposition ) ;
    public final void rule__Model__PostconditionsAssignment_12_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7074:1: ( ( ruleProposition ) )
            // InternalSymg.g:7075:2: ( ruleProposition )
            {
            // InternalSymg.g:7075:2: ( ruleProposition )
            // InternalSymg.g:7076:3: ruleProposition
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
    // InternalSymg.g:7085:1: rule__Model__ObligationsAssignment_13_1_0 : ( ruleObligation ) ;
    public final void rule__Model__ObligationsAssignment_13_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7089:1: ( ( ruleObligation ) )
            // InternalSymg.g:7090:2: ( ruleObligation )
            {
            // InternalSymg.g:7090:2: ( ruleObligation )
            // InternalSymg.g:7091:3: ruleObligation
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
    // InternalSymg.g:7100:1: rule__Model__SobligationsAssignment_14_2_0 : ( ruleObligation ) ;
    public final void rule__Model__SobligationsAssignment_14_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7104:1: ( ( ruleObligation ) )
            // InternalSymg.g:7105:2: ( ruleObligation )
            {
            // InternalSymg.g:7105:2: ( ruleObligation )
            // InternalSymg.g:7106:3: ruleObligation
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
    // InternalSymg.g:7115:1: rule__Model__PowersAssignment_15_1_0 : ( rulePower ) ;
    public final void rule__Model__PowersAssignment_15_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7119:1: ( ( rulePower ) )
            // InternalSymg.g:7120:2: ( rulePower )
            {
            // InternalSymg.g:7120:2: ( rulePower )
            // InternalSymg.g:7121:3: rulePower
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
    // InternalSymg.g:7130:1: rule__Model__ConstraintsAssignment_16_1_0 : ( ruleProposition ) ;
    public final void rule__Model__ConstraintsAssignment_16_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7134:1: ( ( ruleProposition ) )
            // InternalSymg.g:7135:2: ( ruleProposition )
            {
            // InternalSymg.g:7135:2: ( ruleProposition )
            // InternalSymg.g:7136:3: ruleProposition
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
    // InternalSymg.g:7145:1: rule__Regular__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Regular__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7149:1: ( ( RULE_ID ) )
            // InternalSymg.g:7150:2: ( RULE_ID )
            {
            // InternalSymg.g:7150:2: ( RULE_ID )
            // InternalSymg.g:7151:3: RULE_ID
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
    // InternalSymg.g:7160:1: rule__Regular__ConceptTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Regular__ConceptTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7164:1: ( ( ruleCType ) )
            // InternalSymg.g:7165:2: ( ruleCType )
            {
            // InternalSymg.g:7165:2: ( ruleCType )
            // InternalSymg.g:7166:3: ruleCType
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
    // InternalSymg.g:7175:1: rule__Regular__AttributesAssignment_3_1_0 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7179:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7180:2: ( ruleAttribute )
            {
            // InternalSymg.g:7180:2: ( ruleAttribute )
            // InternalSymg.g:7181:3: ruleAttribute
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
    // InternalSymg.g:7190:1: rule__Regular__AttributesAssignment_3_2 : ( ruleAttribute ) ;
    public final void rule__Regular__AttributesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7194:1: ( ( ruleAttribute ) )
            // InternalSymg.g:7195:2: ( ruleAttribute )
            {
            // InternalSymg.g:7195:2: ( ruleAttribute )
            // InternalSymg.g:7196:3: ruleAttribute
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
    // InternalSymg.g:7205:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7209:1: ( ( RULE_ID ) )
            // InternalSymg.g:7210:2: ( RULE_ID )
            {
            // InternalSymg.g:7210:2: ( RULE_ID )
            // InternalSymg.g:7211:3: RULE_ID
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
    // InternalSymg.g:7220:1: rule__Attribute__AttributeTypeAssignment_2 : ( ruleCType ) ;
    public final void rule__Attribute__AttributeTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7224:1: ( ( ruleCType ) )
            // InternalSymg.g:7225:2: ( ruleCType )
            {
            // InternalSymg.g:7225:2: ( ruleCType )
            // InternalSymg.g:7226:3: ruleCType
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
    // InternalSymg.g:7235:1: rule__Enumeration__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Enumeration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7239:1: ( ( RULE_ID ) )
            // InternalSymg.g:7240:2: ( RULE_ID )
            {
            // InternalSymg.g:7240:2: ( RULE_ID )
            // InternalSymg.g:7241:3: RULE_ID
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
    // InternalSymg.g:7250:1: rule__Enumeration__EnumerationItemsAssignment_4_0 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7254:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7255:2: ( ruleenumItem )
            {
            // InternalSymg.g:7255:2: ( ruleenumItem )
            // InternalSymg.g:7256:3: ruleenumItem
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
    // InternalSymg.g:7265:1: rule__Enumeration__EnumerationItemsAssignment_5 : ( ruleenumItem ) ;
    public final void rule__Enumeration__EnumerationItemsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7269:1: ( ( ruleenumItem ) )
            // InternalSymg.g:7270:2: ( ruleenumItem )
            {
            // InternalSymg.g:7270:2: ( ruleenumItem )
            // InternalSymg.g:7271:3: ruleenumItem
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
    // InternalSymg.g:7280:1: rule__EnumItem__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumItem__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7284:1: ( ( RULE_ID ) )
            // InternalSymg.g:7285:2: ( RULE_ID )
            {
            // InternalSymg.g:7285:2: ( RULE_ID )
            // InternalSymg.g:7286:3: RULE_ID
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
    // InternalSymg.g:7295:1: rule__DomainType__SuperTypeAssignment : ( ( RULE_ID ) ) ;
    public final void rule__DomainType__SuperTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7299:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7300:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7300:2: ( ( RULE_ID ) )
            // InternalSymg.g:7301:3: ( RULE_ID )
            {
             before(grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0()); 
            // InternalSymg.g:7302:3: ( RULE_ID )
            // InternalSymg.g:7303:4: RULE_ID
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
    // InternalSymg.g:7314:1: rule__BasicType__NameAssignment : ( ( rule__BasicType__NameAlternatives_0 ) ) ;
    public final void rule__BasicType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7318:1: ( ( ( rule__BasicType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7319:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7319:2: ( ( rule__BasicType__NameAlternatives_0 ) )
            // InternalSymg.g:7320:3: ( rule__BasicType__NameAlternatives_0 )
            {
             before(grammarAccess.getBasicTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7321:3: ( rule__BasicType__NameAlternatives_0 )
            // InternalSymg.g:7321:4: rule__BasicType__NameAlternatives_0
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
    // InternalSymg.g:7329:1: rule__OntoCType__NameAssignment : ( ( rule__OntoCType__NameAlternatives_0 ) ) ;
    public final void rule__OntoCType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7333:1: ( ( ( rule__OntoCType__NameAlternatives_0 ) ) )
            // InternalSymg.g:7334:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            {
            // InternalSymg.g:7334:2: ( ( rule__OntoCType__NameAlternatives_0 ) )
            // InternalSymg.g:7335:3: ( rule__OntoCType__NameAlternatives_0 )
            {
             before(grammarAccess.getOntoCTypeAccess().getNameAlternatives_0()); 
            // InternalSymg.g:7336:3: ( rule__OntoCType__NameAlternatives_0 )
            // InternalSymg.g:7336:4: rule__OntoCType__NameAlternatives_0
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
    // InternalSymg.g:7344:1: rule__Parameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7348:1: ( ( RULE_ID ) )
            // InternalSymg.g:7349:2: ( RULE_ID )
            {
            // InternalSymg.g:7349:2: ( RULE_ID )
            // InternalSymg.g:7350:3: RULE_ID
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
    // InternalSymg.g:7359:1: rule__Parameter__TypeAssignment_2 : ( ruleTypeName ) ;
    public final void rule__Parameter__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7363:1: ( ( ruleTypeName ) )
            // InternalSymg.g:7364:2: ( ruleTypeName )
            {
            // InternalSymg.g:7364:2: ( ruleTypeName )
            // InternalSymg.g:7365:3: ruleTypeName
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
    // InternalSymg.g:7374:1: rule__DeclarPair__AttrAssignment_0 : ( RULE_ID ) ;
    public final void rule__DeclarPair__AttrAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7378:1: ( ( RULE_ID ) )
            // InternalSymg.g:7379:2: ( RULE_ID )
            {
            // InternalSymg.g:7379:2: ( RULE_ID )
            // InternalSymg.g:7380:3: RULE_ID
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
    // InternalSymg.g:7389:1: rule__DeclarPair__ParamAssignment_2 : ( RULE_ID ) ;
    public final void rule__DeclarPair__ParamAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7393:1: ( ( RULE_ID ) )
            // InternalSymg.g:7394:2: ( RULE_ID )
            {
            // InternalSymg.g:7394:2: ( RULE_ID )
            // InternalSymg.g:7395:3: RULE_ID
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
    // InternalSymg.g:7404:1: rule__Declar__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Declar__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7408:1: ( ( RULE_ID ) )
            // InternalSymg.g:7409:2: ( RULE_ID )
            {
            // InternalSymg.g:7409:2: ( RULE_ID )
            // InternalSymg.g:7410:3: RULE_ID
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
    // InternalSymg.g:7419:1: rule__Declar__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Declar__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7423:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7424:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7424:2: ( ( RULE_ID ) )
            // InternalSymg.g:7425:3: ( RULE_ID )
            {
             before(grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0()); 
            // InternalSymg.g:7426:3: ( RULE_ID )
            // InternalSymg.g:7427:4: RULE_ID
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
    // InternalSymg.g:7438:1: rule__Declar__AttributesAssignment_4_0 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7442:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7443:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7443:2: ( ruleDeclarPair )
            // InternalSymg.g:7444:3: ruleDeclarPair
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
    // InternalSymg.g:7453:1: rule__Declar__AttributesAssignment_5 : ( ruleDeclarPair ) ;
    public final void rule__Declar__AttributesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7457:1: ( ( ruleDeclarPair ) )
            // InternalSymg.g:7458:2: ( ruleDeclarPair )
            {
            // InternalSymg.g:7458:2: ( ruleDeclarPair )
            // InternalSymg.g:7459:3: ruleDeclarPair
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
    // InternalSymg.g:7468:1: rule__Obligation__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Obligation__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7472:1: ( ( RULE_ID ) )
            // InternalSymg.g:7473:2: ( RULE_ID )
            {
            // InternalSymg.g:7473:2: ( RULE_ID )
            // InternalSymg.g:7474:3: RULE_ID
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
    // InternalSymg.g:7483:1: rule__Obligation__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Obligation__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7487:1: ( ( ruleProposition ) )
            // InternalSymg.g:7488:2: ( ruleProposition )
            {
            // InternalSymg.g:7488:2: ( ruleProposition )
            // InternalSymg.g:7489:3: ruleProposition
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
    // InternalSymg.g:7498:1: rule__Obligation__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Obligation__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7502:1: ( ( RULE_ID ) )
            // InternalSymg.g:7503:2: ( RULE_ID )
            {
            // InternalSymg.g:7503:2: ( RULE_ID )
            // InternalSymg.g:7504:3: RULE_ID
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
    // InternalSymg.g:7513:1: rule__Obligation__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Obligation__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7517:1: ( ( RULE_ID ) )
            // InternalSymg.g:7518:2: ( RULE_ID )
            {
            // InternalSymg.g:7518:2: ( RULE_ID )
            // InternalSymg.g:7519:3: RULE_ID
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
    // InternalSymg.g:7528:1: rule__Obligation__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Obligation__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7532:1: ( ( ruleProposition ) )
            // InternalSymg.g:7533:2: ( ruleProposition )
            {
            // InternalSymg.g:7533:2: ( ruleProposition )
            // InternalSymg.g:7534:3: ruleProposition
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
    // InternalSymg.g:7543:1: rule__Obligation__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Obligation__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7547:1: ( ( ruleProposition ) )
            // InternalSymg.g:7548:2: ( ruleProposition )
            {
            // InternalSymg.g:7548:2: ( ruleProposition )
            // InternalSymg.g:7549:3: ruleProposition
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
    // InternalSymg.g:7558:1: rule__Power__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Power__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7562:1: ( ( RULE_ID ) )
            // InternalSymg.g:7563:2: ( RULE_ID )
            {
            // InternalSymg.g:7563:2: ( RULE_ID )
            // InternalSymg.g:7564:3: RULE_ID
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
    // InternalSymg.g:7573:1: rule__Power__TriggerAssignment_2_0 : ( ruleProposition ) ;
    public final void rule__Power__TriggerAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7577:1: ( ( ruleProposition ) )
            // InternalSymg.g:7578:2: ( ruleProposition )
            {
            // InternalSymg.g:7578:2: ( ruleProposition )
            // InternalSymg.g:7579:3: ruleProposition
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
    // InternalSymg.g:7588:1: rule__Power__Role1Assignment_5 : ( RULE_ID ) ;
    public final void rule__Power__Role1Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7592:1: ( ( RULE_ID ) )
            // InternalSymg.g:7593:2: ( RULE_ID )
            {
            // InternalSymg.g:7593:2: ( RULE_ID )
            // InternalSymg.g:7594:3: RULE_ID
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
    // InternalSymg.g:7603:1: rule__Power__Role2Assignment_7 : ( RULE_ID ) ;
    public final void rule__Power__Role2Assignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7607:1: ( ( RULE_ID ) )
            // InternalSymg.g:7608:2: ( RULE_ID )
            {
            // InternalSymg.g:7608:2: ( RULE_ID )
            // InternalSymg.g:7609:3: RULE_ID
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
    // InternalSymg.g:7618:1: rule__Power__AntecedentAssignment_9 : ( ruleProposition ) ;
    public final void rule__Power__AntecedentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7622:1: ( ( ruleProposition ) )
            // InternalSymg.g:7623:2: ( ruleProposition )
            {
            // InternalSymg.g:7623:2: ( ruleProposition )
            // InternalSymg.g:7624:3: ruleProposition
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
    // InternalSymg.g:7633:1: rule__Power__ConsequentAssignment_11 : ( ruleProposition ) ;
    public final void rule__Power__ConsequentAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7637:1: ( ( ruleProposition ) )
            // InternalSymg.g:7638:2: ( ruleProposition )
            {
            // InternalSymg.g:7638:2: ( ruleProposition )
            // InternalSymg.g:7639:3: ruleProposition
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
    // InternalSymg.g:7648:1: rule__Proposition__JunctionsAssignment_0 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7652:1: ( ( ruleJunction ) )
            // InternalSymg.g:7653:2: ( ruleJunction )
            {
            // InternalSymg.g:7653:2: ( ruleJunction )
            // InternalSymg.g:7654:3: ruleJunction
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
    // InternalSymg.g:7663:1: rule__Proposition__JunctionsAssignment_1_1 : ( ruleJunction ) ;
    public final void rule__Proposition__JunctionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7667:1: ( ( ruleJunction ) )
            // InternalSymg.g:7668:2: ( ruleJunction )
            {
            // InternalSymg.g:7668:2: ( ruleJunction )
            // InternalSymg.g:7669:3: ruleJunction
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
    // InternalSymg.g:7678:1: rule__Junction__NegativeAtomsAssignment_0 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7682:1: ( ( ruleNegation ) )
            // InternalSymg.g:7683:2: ( ruleNegation )
            {
            // InternalSymg.g:7683:2: ( ruleNegation )
            // InternalSymg.g:7684:3: ruleNegation
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
    // InternalSymg.g:7693:1: rule__Junction__NegativeAtomsAssignment_1_1 : ( ruleNegation ) ;
    public final void rule__Junction__NegativeAtomsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7697:1: ( ( ruleNegation ) )
            // InternalSymg.g:7698:2: ( ruleNegation )
            {
            // InternalSymg.g:7698:2: ( ruleNegation )
            // InternalSymg.g:7699:3: ruleNegation
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
    // InternalSymg.g:7708:1: rule__Negation__NegatedAssignment_0 : ( ( 'NOT' ) ) ;
    public final void rule__Negation__NegatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7712:1: ( ( ( 'NOT' ) ) )
            // InternalSymg.g:7713:2: ( ( 'NOT' ) )
            {
            // InternalSymg.g:7713:2: ( ( 'NOT' ) )
            // InternalSymg.g:7714:3: ( 'NOT' )
            {
             before(grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0()); 
            // InternalSymg.g:7715:3: ( 'NOT' )
            // InternalSymg.g:7716:4: 'NOT'
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
    // InternalSymg.g:7727:1: rule__Negation__AtomicExpressionAssignment_1 : ( ruleAtom ) ;
    public final void rule__Negation__AtomicExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7731:1: ( ( ruleAtom ) )
            // InternalSymg.g:7732:2: ( ruleAtom )
            {
            // InternalSymg.g:7732:2: ( ruleAtom )
            // InternalSymg.g:7733:3: ruleAtom
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
    // InternalSymg.g:7742:1: rule__Atom__EventPropositionAssignment_0_2 : ( ruleEventProp ) ;
    public final void rule__Atom__EventPropositionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7746:1: ( ( ruleEventProp ) )
            // InternalSymg.g:7747:2: ( ruleEventProp )
            {
            // InternalSymg.g:7747:2: ( ruleEventProp )
            // InternalSymg.g:7748:3: ruleEventProp
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
    // InternalSymg.g:7757:1: rule__Atom__SituationPropositionAssignment_1_2 : ( ruleSitProp ) ;
    public final void rule__Atom__SituationPropositionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7761:1: ( ( ruleSitProp ) )
            // InternalSymg.g:7762:2: ( ruleSitProp )
            {
            // InternalSymg.g:7762:2: ( ruleSitProp )
            // InternalSymg.g:7763:3: ruleSitProp
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
    // InternalSymg.g:7772:1: rule__Atom__InnerAssignment_2_1 : ( ruleProposition ) ;
    public final void rule__Atom__InnerAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7776:1: ( ( ruleProposition ) )
            // InternalSymg.g:7777:2: ( ruleProposition )
            {
            // InternalSymg.g:7777:2: ( ruleProposition )
            // InternalSymg.g:7778:3: ruleProposition
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
    // InternalSymg.g:7787:1: rule__Atom__PointAssignment_3_0 : ( rulePoint ) ;
    public final void rule__Atom__PointAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7791:1: ( ( rulePoint ) )
            // InternalSymg.g:7792:2: ( rulePoint )
            {
            // InternalSymg.g:7792:2: ( rulePoint )
            // InternalSymg.g:7793:3: rulePoint
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
    // InternalSymg.g:7802:1: rule__Atom__IntervalAssignment_3_2 : ( ruleInterval ) ;
    public final void rule__Atom__IntervalAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7806:1: ( ( ruleInterval ) )
            // InternalSymg.g:7807:2: ( ruleInterval )
            {
            // InternalSymg.g:7807:2: ( ruleInterval )
            // InternalSymg.g:7808:3: ruleInterval
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
    // InternalSymg.g:7817:1: rule__Atom__BoolAssignment_4 : ( ( 'TRUE' ) ) ;
    public final void rule__Atom__BoolAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7821:1: ( ( ( 'TRUE' ) ) )
            // InternalSymg.g:7822:2: ( ( 'TRUE' ) )
            {
            // InternalSymg.g:7822:2: ( ( 'TRUE' ) )
            // InternalSymg.g:7823:3: ( 'TRUE' )
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 
            // InternalSymg.g:7824:3: ( 'TRUE' )
            // InternalSymg.g:7825:4: 'TRUE'
            {
             before(grammarAccess.getAtomAccess().getBoolTRUEKeyword_4_0()); 
            match(input,106,FOLLOW_2); 
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
    // InternalSymg.g:7836:1: rule__Atom__BoolAssignment_5 : ( ( 'FALSE' ) ) ;
    public final void rule__Atom__BoolAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7840:1: ( ( ( 'FALSE' ) ) )
            // InternalSymg.g:7841:2: ( ( 'FALSE' ) )
            {
            // InternalSymg.g:7841:2: ( ( 'FALSE' ) )
            // InternalSymg.g:7842:3: ( 'FALSE' )
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 
            // InternalSymg.g:7843:3: ( 'FALSE' )
            // InternalSymg.g:7844:4: 'FALSE'
            {
             before(grammarAccess.getAtomAccess().getBoolFALSEKeyword_5_0()); 
            match(input,107,FOLLOW_2); 
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
    // InternalSymg.g:7855:1: rule__SitProp__SituationNameAssignment_0_0 : ( RULE_ID ) ;
    public final void rule__SitProp__SituationNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7859:1: ( ( RULE_ID ) )
            // InternalSymg.g:7860:2: ( RULE_ID )
            {
            // InternalSymg.g:7860:2: ( RULE_ID )
            // InternalSymg.g:7861:3: RULE_ID
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
    // InternalSymg.g:7870:1: rule__SitProp__OSituationNameAssignment_0_1 : ( ruleoState ) ;
    public final void rule__SitProp__OSituationNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7874:1: ( ( ruleoState ) )
            // InternalSymg.g:7875:2: ( ruleoState )
            {
            // InternalSymg.g:7875:2: ( ruleoState )
            // InternalSymg.g:7876:3: ruleoState
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
    // InternalSymg.g:7885:1: rule__SitProp__CSituationNameAssignment_0_2 : ( rulecState ) ;
    public final void rule__SitProp__CSituationNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7889:1: ( ( rulecState ) )
            // InternalSymg.g:7890:2: ( rulecState )
            {
            // InternalSymg.g:7890:2: ( rulecState )
            // InternalSymg.g:7891:3: rulecState
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
    // InternalSymg.g:7900:1: rule__SitProp__PSituationNameAssignment_0_3 : ( rulepState ) ;
    public final void rule__SitProp__PSituationNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7904:1: ( ( rulepState ) )
            // InternalSymg.g:7905:2: ( rulepState )
            {
            // InternalSymg.g:7905:2: ( rulepState )
            // InternalSymg.g:7906:3: rulepState
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
    // InternalSymg.g:7915:1: rule__SitProp__IntervalAssignment_2 : ( ruleInterval ) ;
    public final void rule__SitProp__IntervalAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7919:1: ( ( ruleInterval ) )
            // InternalSymg.g:7920:2: ( ruleInterval )
            {
            // InternalSymg.g:7920:2: ( ruleInterval )
            // InternalSymg.g:7921:3: ruleInterval
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
    // InternalSymg.g:7930:1: rule__EventProp__EventNameAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__EventProp__EventNameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7934:1: ( ( ( RULE_ID ) ) )
            // InternalSymg.g:7935:2: ( ( RULE_ID ) )
            {
            // InternalSymg.g:7935:2: ( ( RULE_ID ) )
            // InternalSymg.g:7936:3: ( RULE_ID )
            {
             before(grammarAccess.getEventPropAccess().getEventNameDeclarCrossReference_0_0_0()); 
            // InternalSymg.g:7937:3: ( RULE_ID )
            // InternalSymg.g:7938:4: RULE_ID
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
    // InternalSymg.g:7949:1: rule__EventProp__OEventNameAssignment_0_1 : ( ruleoEvent ) ;
    public final void rule__EventProp__OEventNameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7953:1: ( ( ruleoEvent ) )
            // InternalSymg.g:7954:2: ( ruleoEvent )
            {
            // InternalSymg.g:7954:2: ( ruleoEvent )
            // InternalSymg.g:7955:3: ruleoEvent
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
    // InternalSymg.g:7964:1: rule__EventProp__CEventNameAssignment_0_2 : ( rulecEvent ) ;
    public final void rule__EventProp__CEventNameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7968:1: ( ( rulecEvent ) )
            // InternalSymg.g:7969:2: ( rulecEvent )
            {
            // InternalSymg.g:7969:2: ( rulecEvent )
            // InternalSymg.g:7970:3: rulecEvent
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
    // InternalSymg.g:7979:1: rule__EventProp__PEventNameAssignment_0_3 : ( rulepEvent ) ;
    public final void rule__EventProp__PEventNameAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7983:1: ( ( rulepEvent ) )
            // InternalSymg.g:7984:2: ( rulepEvent )
            {
            // InternalSymg.g:7984:2: ( rulepEvent )
            // InternalSymg.g:7985:3: rulepEvent
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
    // InternalSymg.g:7994:1: rule__EventProp__PointAssignment_2 : ( rulePoint ) ;
    public final void rule__EventProp__PointAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:7998:1: ( ( rulePoint ) )
            // InternalSymg.g:7999:2: ( rulePoint )
            {
            // InternalSymg.g:7999:2: ( rulePoint )
            // InternalSymg.g:8000:3: rulePoint
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
    // InternalSymg.g:8009:1: rule__Interval__SituationNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Interval__SituationNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8013:1: ( ( ruleSitName ) )
            // InternalSymg.g:8014:2: ( ruleSitName )
            {
            // InternalSymg.g:8014:2: ( ruleSitName )
            // InternalSymg.g:8015:3: ruleSitName
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
    // InternalSymg.g:8024:1: rule__Interval__StartAssignment_1_1 : ( rulePoint ) ;
    public final void rule__Interval__StartAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8028:1: ( ( rulePoint ) )
            // InternalSymg.g:8029:2: ( rulePoint )
            {
            // InternalSymg.g:8029:2: ( rulePoint )
            // InternalSymg.g:8030:3: rulePoint
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
    // InternalSymg.g:8039:1: rule__Interval__EndAssignment_1_3 : ( rulePoint ) ;
    public final void rule__Interval__EndAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8043:1: ( ( rulePoint ) )
            // InternalSymg.g:8044:2: ( rulePoint )
            {
            // InternalSymg.g:8044:2: ( rulePoint )
            // InternalSymg.g:8045:3: rulePoint
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
    // InternalSymg.g:8054:1: rule__Interval__UnnamedAssignment_2 : ( ( 'UNNAMED_INTERVAL' ) ) ;
    public final void rule__Interval__UnnamedAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8058:1: ( ( ( 'UNNAMED_INTERVAL' ) ) )
            // InternalSymg.g:8059:2: ( ( 'UNNAMED_INTERVAL' ) )
            {
            // InternalSymg.g:8059:2: ( ( 'UNNAMED_INTERVAL' ) )
            // InternalSymg.g:8060:3: ( 'UNNAMED_INTERVAL' )
            {
             before(grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0()); 
            // InternalSymg.g:8061:3: ( 'UNNAMED_INTERVAL' )
            // InternalSymg.g:8062:4: 'UNNAMED_INTERVAL'
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
    // InternalSymg.g:8073:1: rule__Interval__SituationNameAssignment_3_0 : ( ruleSitName ) ;
    public final void rule__Interval__SituationNameAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8077:1: ( ( ruleSitName ) )
            // InternalSymg.g:8078:2: ( ruleSitName )
            {
            // InternalSymg.g:8078:2: ( ruleSitName )
            // InternalSymg.g:8079:3: ruleSitName
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
    // InternalSymg.g:8088:1: rule__Interval__TempOpAssignment_3_1 : ( ruleTempOp ) ;
    public final void rule__Interval__TempOpAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8092:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8093:2: ( ruleTempOp )
            {
            // InternalSymg.g:8093:2: ( ruleTempOp )
            // InternalSymg.g:8094:3: ruleTempOp
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
    // InternalSymg.g:8103:1: rule__Interval__IntConstAssignment_3_2 : ( ruleIntConst ) ;
    public final void rule__Interval__IntConstAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8107:1: ( ( ruleIntConst ) )
            // InternalSymg.g:8108:2: ( ruleIntConst )
            {
            // InternalSymg.g:8108:2: ( ruleIntConst )
            // InternalSymg.g:8109:3: ruleIntConst
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
    // InternalSymg.g:8118:1: rule__Interval__UnitAssignment_3_3 : ( ruleUnit ) ;
    public final void rule__Interval__UnitAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8122:1: ( ( ruleUnit ) )
            // InternalSymg.g:8123:2: ( ruleUnit )
            {
            // InternalSymg.g:8123:2: ( ruleUnit )
            // InternalSymg.g:8124:3: ruleUnit
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


    // $ANTLR start "rule__SitName__DeclNameAssignment_0"
    // InternalSymg.g:8133:1: rule__SitName__DeclNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__SitName__DeclNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8137:1: ( ( RULE_ID ) )
            // InternalSymg.g:8138:2: ( RULE_ID )
            {
            // InternalSymg.g:8138:2: ( RULE_ID )
            // InternalSymg.g:8139:3: RULE_ID
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
    // InternalSymg.g:8148:1: rule__SitName__OStateAssignment_1 : ( ruleoState ) ;
    public final void rule__SitName__OStateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8152:1: ( ( ruleoState ) )
            // InternalSymg.g:8153:2: ( ruleoState )
            {
            // InternalSymg.g:8153:2: ( ruleoState )
            // InternalSymg.g:8154:3: ruleoState
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
    // InternalSymg.g:8163:1: rule__SitName__PStateAssignment_2 : ( rulepState ) ;
    public final void rule__SitName__PStateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8167:1: ( ( rulepState ) )
            // InternalSymg.g:8168:2: ( rulepState )
            {
            // InternalSymg.g:8168:2: ( rulepState )
            // InternalSymg.g:8169:3: rulepState
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
    // InternalSymg.g:8178:1: rule__SitName__CStateAssignment_3 : ( rulecState ) ;
    public final void rule__SitName__CStateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8182:1: ( ( rulecState ) )
            // InternalSymg.g:8183:2: ( rulecState )
            {
            // InternalSymg.g:8183:2: ( rulecState )
            // InternalSymg.g:8184:3: rulecState
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
    // InternalSymg.g:8193:1: rule__SitName__OEventAssignment_4 : ( ruleoEvent ) ;
    public final void rule__SitName__OEventAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8197:1: ( ( ruleoEvent ) )
            // InternalSymg.g:8198:2: ( ruleoEvent )
            {
            // InternalSymg.g:8198:2: ( ruleoEvent )
            // InternalSymg.g:8199:3: ruleoEvent
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
    // InternalSymg.g:8208:1: rule__SitName__CEventAssignment_5 : ( rulecEvent ) ;
    public final void rule__SitName__CEventAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8212:1: ( ( rulecEvent ) )
            // InternalSymg.g:8213:2: ( rulecEvent )
            {
            // InternalSymg.g:8213:2: ( rulecEvent )
            // InternalSymg.g:8214:3: rulecEvent
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
    // InternalSymg.g:8223:1: rule__SitName__PEventAssignment_6 : ( rulepEvent ) ;
    public final void rule__SitName__PEventAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8227:1: ( ( rulepEvent ) )
            // InternalSymg.g:8228:2: ( rulepEvent )
            {
            // InternalSymg.g:8228:2: ( rulepEvent )
            // InternalSymg.g:8229:3: rulepEvent
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
    // InternalSymg.g:8238:1: rule__IntConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__IntConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8242:1: ( ( RULE_INT ) )
            // InternalSymg.g:8243:2: ( RULE_INT )
            {
            // InternalSymg.g:8243:2: ( RULE_INT )
            // InternalSymg.g:8244:3: RULE_INT
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
    // InternalSymg.g:8253:1: rule__Point__EventNameAssignment_0 : ( ruleSitName ) ;
    public final void rule__Point__EventNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8257:1: ( ( ruleSitName ) )
            // InternalSymg.g:8258:2: ( ruleSitName )
            {
            // InternalSymg.g:8258:2: ( ruleSitName )
            // InternalSymg.g:8259:3: ruleSitName
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
    // InternalSymg.g:8268:1: rule__Point__UnnamedAssignment_1 : ( ( 'UNNAMED_POINT' ) ) ;
    public final void rule__Point__UnnamedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8272:1: ( ( ( 'UNNAMED_POINT' ) ) )
            // InternalSymg.g:8273:2: ( ( 'UNNAMED_POINT' ) )
            {
            // InternalSymg.g:8273:2: ( ( 'UNNAMED_POINT' ) )
            // InternalSymg.g:8274:3: ( 'UNNAMED_POINT' )
            {
             before(grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0()); 
            // InternalSymg.g:8275:3: ( 'UNNAMED_POINT' )
            // InternalSymg.g:8276:4: 'UNNAMED_POINT'
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
    // InternalSymg.g:8287:1: rule__Point__PointConstAssignment_2 : ( rulePointConst ) ;
    public final void rule__Point__PointConstAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8291:1: ( ( rulePointConst ) )
            // InternalSymg.g:8292:2: ( rulePointConst )
            {
            // InternalSymg.g:8292:2: ( rulePointConst )
            // InternalSymg.g:8293:3: rulePointConst
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
    // InternalSymg.g:8302:1: rule__Point__PointConstAssignment_3_0 : ( rulePointConst ) ;
    public final void rule__Point__PointConstAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8306:1: ( ( rulePointConst ) )
            // InternalSymg.g:8307:2: ( rulePointConst )
            {
            // InternalSymg.g:8307:2: ( rulePointConst )
            // InternalSymg.g:8308:3: rulePointConst
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
    // InternalSymg.g:8317:1: rule__Point__UnitAssignment_3_1 : ( ruleUnit ) ;
    public final void rule__Point__UnitAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8321:1: ( ( ruleUnit ) )
            // InternalSymg.g:8322:2: ( ruleUnit )
            {
            // InternalSymg.g:8322:2: ( ruleUnit )
            // InternalSymg.g:8323:3: ruleUnit
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
    // InternalSymg.g:8332:1: rule__Point__TempOpAssignment_3_2 : ( ruleTempOp ) ;
    public final void rule__Point__TempOpAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8336:1: ( ( ruleTempOp ) )
            // InternalSymg.g:8337:2: ( ruleTempOp )
            {
            // InternalSymg.g:8337:2: ( ruleTempOp )
            // InternalSymg.g:8338:3: ruleTempOp
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
    // InternalSymg.g:8347:1: rule__Point__EventNameAssignment_3_3 : ( ruleSitName ) ;
    public final void rule__Point__EventNameAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8351:1: ( ( ruleSitName ) )
            // InternalSymg.g:8352:2: ( ruleSitName )
            {
            // InternalSymg.g:8352:2: ( ruleSitName )
            // InternalSymg.g:8353:3: ruleSitName
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
    // InternalSymg.g:8362:1: rule__PEvent__PowEventAssignment_0 : ( rulePowEvent ) ;
    public final void rule__PEvent__PowEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8366:1: ( ( rulePowEvent ) )
            // InternalSymg.g:8367:2: ( rulePowEvent )
            {
            // InternalSymg.g:8367:2: ( rulePowEvent )
            // InternalSymg.g:8368:3: rulePowEvent
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
    // InternalSymg.g:8377:1: rule__PEvent__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PEvent__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8381:1: ( ( RULE_ID ) )
            // InternalSymg.g:8382:2: ( RULE_ID )
            {
            // InternalSymg.g:8382:2: ( RULE_ID )
            // InternalSymg.g:8383:3: RULE_ID
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
    // InternalSymg.g:8392:1: rule__CEvent__ContrEventAssignment_0 : ( ruleContrEvent ) ;
    public final void rule__CEvent__ContrEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8396:1: ( ( ruleContrEvent ) )
            // InternalSymg.g:8397:2: ( ruleContrEvent )
            {
            // InternalSymg.g:8397:2: ( ruleContrEvent )
            // InternalSymg.g:8398:3: ruleContrEvent
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
    // InternalSymg.g:8407:1: rule__CEvent__ContrNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CEvent__ContrNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8411:1: ( ( RULE_ID ) )
            // InternalSymg.g:8412:2: ( RULE_ID )
            {
            // InternalSymg.g:8412:2: ( RULE_ID )
            // InternalSymg.g:8413:3: RULE_ID
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
    // InternalSymg.g:8422:1: rule__OEvent__OblEventAssignment_0 : ( ruleOblEvent ) ;
    public final void rule__OEvent__OblEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8426:1: ( ( ruleOblEvent ) )
            // InternalSymg.g:8427:2: ( ruleOblEvent )
            {
            // InternalSymg.g:8427:2: ( ruleOblEvent )
            // InternalSymg.g:8428:3: ruleOblEvent
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
    // InternalSymg.g:8437:1: rule__OEvent__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OEvent__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8441:1: ( ( RULE_ID ) )
            // InternalSymg.g:8442:2: ( RULE_ID )
            {
            // InternalSymg.g:8442:2: ( RULE_ID )
            // InternalSymg.g:8443:3: RULE_ID
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
    // InternalSymg.g:8452:1: rule__PointConst__TypeAssignment_1 : ( RULE_INT ) ;
    public final void rule__PointConst__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8456:1: ( ( RULE_INT ) )
            // InternalSymg.g:8457:2: ( RULE_INT )
            {
            // InternalSymg.g:8457:2: ( RULE_INT )
            // InternalSymg.g:8458:3: RULE_INT
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
    // InternalSymg.g:8467:1: rule__OState__OblStateAssignment_0 : ( ruleOblState ) ;
    public final void rule__OState__OblStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8471:1: ( ( ruleOblState ) )
            // InternalSymg.g:8472:2: ( ruleOblState )
            {
            // InternalSymg.g:8472:2: ( ruleOblState )
            // InternalSymg.g:8473:3: ruleOblState
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
    // InternalSymg.g:8482:1: rule__OState__OblNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OState__OblNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8486:1: ( ( RULE_ID ) )
            // InternalSymg.g:8487:2: ( RULE_ID )
            {
            // InternalSymg.g:8487:2: ( RULE_ID )
            // InternalSymg.g:8488:3: RULE_ID
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
    // InternalSymg.g:8497:1: rule__CState__ContrStateAssignment_0 : ( ruleContrState ) ;
    public final void rule__CState__ContrStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8501:1: ( ( ruleContrState ) )
            // InternalSymg.g:8502:2: ( ruleContrState )
            {
            // InternalSymg.g:8502:2: ( ruleContrState )
            // InternalSymg.g:8503:3: ruleContrState
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
    // InternalSymg.g:8512:1: rule__CState__ContractNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__CState__ContractNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8516:1: ( ( RULE_ID ) )
            // InternalSymg.g:8517:2: ( RULE_ID )
            {
            // InternalSymg.g:8517:2: ( RULE_ID )
            // InternalSymg.g:8518:3: RULE_ID
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
    // InternalSymg.g:8527:1: rule__PState__PowStateAssignment_0 : ( rulePowState ) ;
    public final void rule__PState__PowStateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8531:1: ( ( rulePowState ) )
            // InternalSymg.g:8532:2: ( rulePowState )
            {
            // InternalSymg.g:8532:2: ( rulePowState )
            // InternalSymg.g:8533:3: rulePowState
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
    // InternalSymg.g:8542:1: rule__PState__PowNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__PState__PowNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalSymg.g:8546:1: ( ( RULE_ID ) )
            // InternalSymg.g:8547:2: ( RULE_ID )
            {
            // InternalSymg.g:8547:2: ( RULE_ID )
            // InternalSymg.g:8548:3: RULE_ID
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
    static final String dfa_2s = "\1\uffff\1\56\72\uffff\6\56";
    static final String dfa_3s = "\1\4\1\33\52\116\4\uffff\6\4\6\117\6\33";
    static final String dfa_4s = "\1\154\1\143\52\116\4\uffff\6\4\6\117\6\143";
    static final String dfa_5s = "\54\uffff\1\2\1\3\1\1\1\4\22\uffff";
    static final String dfa_6s = "\102\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\34\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\17\1\20\1\21\1\22\1\23\1\24\1\12\1\13\1\14\1\15\1\16\34\uffff\1\54\4\uffff\1\55",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
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
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56",
            "\6\57\56\uffff\1\56\1\uffff\2\56\15\uffff\1\56\1\uffff\2\56"
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
            return "1323:1: rule__Interval__Alternatives : ( ( ( rule__Interval__SituationNameAssignment_0 ) ) | ( ( rule__Interval__Group_1__0 ) ) | ( ( rule__Interval__UnnamedAssignment_2 ) ) | ( ( rule__Interval__Group_3__0 ) ) );";
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
            return "()* loopback of 3393:2: ( rule__Regular__Group_3_1__0 )*";
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
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E30000047FFL});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xFFFFFFFE00000032L,0x00002E30000047FFL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000007F810L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E30800047FFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xFFFFFFFE00000030L,0x00002E32000047FFL});
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