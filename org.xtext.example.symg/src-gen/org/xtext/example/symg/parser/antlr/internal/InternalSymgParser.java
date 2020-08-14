package org.xtext.example.symg.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.symg.services.SymgGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSymgParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Domain'", "';'", "'endDomain'", "'Contract'", "'('", "','", "')'", "'Declarations'", "'Preconditions'", "'Postconditions'", "'Obligations'", "'Surviving'", "'Powers'", "'Constraints'", "'endContract'", "'isA'", "'with'", "':'", "'Enumeration'", "'NUMBER'", "'STRING'", "'DATE'", "'ASSET'", "'EVENT'", "'ROLE'", "'SITUATION'", "'CONTRACT'", "':='", "'->'", "'obligation'", "'power'", "'OR'", "'AND'", "'NOT'", "'happens'", "'occurs'", "'within'", "'TRUE'", "'FALSE'", "'['", "']'", "'UNNAMED_INTERVAL'", "'SECONDS'", "'MINUTES'", "'HOURS'", "'DAYS'", "'WEEKS'", "'MONTHS'", "'QUARTERS'", "'YEARS'", "'BEFORE'", "'AFTER'", "'AT'", "'WITHIN'", "'+'", "'-'", "'UNNAMED_POINT'", "'pTRIGGERED'", "'pACTIVATED'", "'pSUSPENDED'", "'pRESUMED'", "'pEXERTED'", "'pEXPIRED'", "'pTERMINATED'", "'cACTIVATED'", "'cSUSPENDED'", "'cRESUMED'", "'cFULFILLED_ACTIVE_OBLS'", "'cREVOKED_PARTY'", "'cASSIGNED_PARTY'", "'cTERMINATED'", "'oTRIGGERED'", "'oACTIVATED'", "'oSUSPENDED'", "'oRESUMED'", "'oDISCHARGED'", "'oEXPIRED'", "'oFULFILLED'", "'oVIOLATED'", "'oTERMINATED'", "'oCREATE'", "'oINEFFECT'", "'oSUSPENSION'", "'oSUCCESSFUL_TERMINATION'", "'oUNSUCCESSFUL_TERMINATION'", "'oVIOLATION'", "'oFULFILLMENT'", "'oDISCHARGE'", "'cFORM'", "'cINEFFECT'", "'cSUSPENSION'", "'cSUCCESSFUL_TERMINATION'", "'cUNSECCESSFUL_TERMINATION'", "'cUNASSIGN'", "'pCREATE'", "'pINEFFECT'", "'pSUSPENSION'", "'pSUCCESSFUL_TERMINATION'", "'pUNSUCCESSFUL_TERMINATION'"
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

        public InternalSymgParser(TokenStream input, SymgGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SymgGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSymg.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSymg.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSymg.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSymg.g:71:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )? (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )? (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )? otherlv_34= 'endContract' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domainName_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_contractName_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        EObject lv_domainConcepts_2_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_declarations_13_0 = null;

        EObject lv_preconditions_16_0 = null;

        EObject lv_postconditions_19_0 = null;

        EObject lv_obligations_22_0 = null;

        EObject lv_sobligations_26_0 = null;

        EObject lv_powers_29_0 = null;

        EObject lv_constraints_32_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:77:2: ( (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )? (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )? (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )? otherlv_34= 'endContract' ) )
            // InternalSymg.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )? (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )? (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )? otherlv_34= 'endContract' )
            {
            // InternalSymg.g:78:2: (otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )? (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )? (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )? otherlv_34= 'endContract' )
            // InternalSymg.g:79:3: otherlv_0= 'Domain' ( (lv_domainName_1_0= RULE_ID ) ) ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+ otherlv_4= 'endDomain' otherlv_5= 'Contract' ( (lv_contractName_6_0= RULE_ID ) ) otherlv_7= '(' ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+ ( (lv_parameters_10_0= ruleParameter ) ) otherlv_11= ')' (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )? (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )? (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )? (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )? (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )? (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )? (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )? otherlv_34= 'endContract'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getDomainKeyword_0());
            		
            // InternalSymg.g:83:3: ( (lv_domainName_1_0= RULE_ID ) )
            // InternalSymg.g:84:4: (lv_domainName_1_0= RULE_ID )
            {
            // InternalSymg.g:84:4: (lv_domainName_1_0= RULE_ID )
            // InternalSymg.g:85:5: lv_domainName_1_0= RULE_ID
            {
            lv_domainName_1_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(lv_domainName_1_0, grammarAccess.getModelAccess().getDomainNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSymg.g:101:3: ( ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSymg.g:102:4: ( (lv_domainConcepts_2_0= ruleDomainConcept ) ) otherlv_3= ';'
            	    {
            	    // InternalSymg.g:102:4: ( (lv_domainConcepts_2_0= ruleDomainConcept ) )
            	    // InternalSymg.g:103:5: (lv_domainConcepts_2_0= ruleDomainConcept )
            	    {
            	    // InternalSymg.g:103:5: (lv_domainConcepts_2_0= ruleDomainConcept )
            	    // InternalSymg.g:104:6: lv_domainConcepts_2_0= ruleDomainConcept
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getDomainConceptsDomainConceptParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_domainConcepts_2_0=ruleDomainConcept();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"domainConcepts",
            	    							lv_domainConcepts_2_0,
            	    							"org.xtext.example.symg.Symg.DomainConcept");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_5); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModelAccess().getSemicolonKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getModelAccess().getEndDomainKeyword_3());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getModelAccess().getContractKeyword_4());
            		
            // InternalSymg.g:134:3: ( (lv_contractName_6_0= RULE_ID ) )
            // InternalSymg.g:135:4: (lv_contractName_6_0= RULE_ID )
            {
            // InternalSymg.g:135:4: (lv_contractName_6_0= RULE_ID )
            // InternalSymg.g:136:5: lv_contractName_6_0= RULE_ID
            {
            lv_contractName_6_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_contractName_6_0, grammarAccess.getModelAccess().getContractNameIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getModelAccess().getLeftParenthesisKeyword_6());
            		
            // InternalSymg.g:156:3: ( ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ',' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==28) ) {
                        switch ( input.LA(3) ) {
                        case RULE_ID:
                            {
                            int LA2_3 = input.LA(4);

                            if ( (LA2_3==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 30:
                            {
                            int LA2_4 = input.LA(4);

                            if ( (LA2_4==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 31:
                            {
                            int LA2_5 = input.LA(4);

                            if ( (LA2_5==16) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 32:
                            {
                            int LA2_6 = input.LA(4);

                            if ( (LA2_6==16) ) {
                                alt2=1;
                            }


                            }
                            break;

                        }

                    }


                }


                switch (alt2) {
            	case 1 :
            	    // InternalSymg.g:157:4: ( (lv_parameters_8_0= ruleParameter ) ) otherlv_9= ','
            	    {
            	    // InternalSymg.g:157:4: ( (lv_parameters_8_0= ruleParameter ) )
            	    // InternalSymg.g:158:5: (lv_parameters_8_0= ruleParameter )
            	    {
            	    // InternalSymg.g:158:5: (lv_parameters_8_0= ruleParameter )
            	    // InternalSymg.g:159:6: lv_parameters_8_0= ruleParameter
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_parameters_8_0=ruleParameter();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parameters",
            	    							lv_parameters_8_0,
            	    							"org.xtext.example.symg.Symg.Parameter");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_9=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_9, grammarAccess.getModelAccess().getCommaKeyword_7_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalSymg.g:181:3: ( (lv_parameters_10_0= ruleParameter ) )
            // InternalSymg.g:182:4: (lv_parameters_10_0= ruleParameter )
            {
            // InternalSymg.g:182:4: (lv_parameters_10_0= ruleParameter )
            // InternalSymg.g:183:5: lv_parameters_10_0= ruleParameter
            {

            					newCompositeNode(grammarAccess.getModelAccess().getParametersParameterParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_9);
            lv_parameters_10_0=ruleParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"parameters",
            						lv_parameters_10_0,
            						"org.xtext.example.symg.Symg.Parameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_11, grammarAccess.getModelAccess().getRightParenthesisKeyword_9());
            		
            // InternalSymg.g:204:3: (otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSymg.g:205:4: otherlv_12= 'Declarations' ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )*
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getDeclarationsKeyword_10_0());
                    			
                    // InternalSymg.g:209:4: ( ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalSymg.g:210:5: ( (lv_declarations_13_0= ruleDeclar ) ) otherlv_14= ';'
                    	    {
                    	    // InternalSymg.g:210:5: ( (lv_declarations_13_0= ruleDeclar ) )
                    	    // InternalSymg.g:211:6: (lv_declarations_13_0= ruleDeclar )
                    	    {
                    	    // InternalSymg.g:211:6: (lv_declarations_13_0= ruleDeclar )
                    	    // InternalSymg.g:212:7: lv_declarations_13_0= ruleDeclar
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarParserRuleCall_10_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_declarations_13_0=ruleDeclar();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"declarations",
                    	    								lv_declarations_13_0,
                    	    								"org.xtext.example.symg.Symg.Declar");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_14=(Token)match(input,12,FOLLOW_11); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getModelAccess().getSemicolonKeyword_10_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:235:3: (otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSymg.g:236:4: otherlv_15= 'Preconditions' ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )*
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_15, grammarAccess.getModelAccess().getPreconditionsKeyword_11_0());
                    			
                    // InternalSymg.g:240:4: ( ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';' )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||(LA5_0>=44 && LA5_0<=46)||(LA5_0>=48 && LA5_0<=49)||(LA5_0>=67 && LA5_0<=109)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalSymg.g:241:5: ( (lv_preconditions_16_0= ruleProposition ) ) otherlv_17= ';'
                    	    {
                    	    // InternalSymg.g:241:5: ( (lv_preconditions_16_0= ruleProposition ) )
                    	    // InternalSymg.g:242:6: (lv_preconditions_16_0= ruleProposition )
                    	    {
                    	    // InternalSymg.g:242:6: (lv_preconditions_16_0= ruleProposition )
                    	    // InternalSymg.g:243:7: lv_preconditions_16_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPreconditionsPropositionParserRuleCall_11_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_preconditions_16_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"preconditions",
                    	    								lv_preconditions_16_0,
                    	    								"org.xtext.example.symg.Symg.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_17=(Token)match(input,12,FOLLOW_12); 

                    	    					newLeafNode(otherlv_17, grammarAccess.getModelAccess().getSemicolonKeyword_11_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:266:3: (otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSymg.g:267:4: otherlv_18= 'Postconditions' ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    {
                    otherlv_18=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getPostconditionsKeyword_12_0());
                    			
                    // InternalSymg.g:271:4: ( ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||(LA7_0>=44 && LA7_0<=46)||(LA7_0>=48 && LA7_0<=49)||(LA7_0>=67 && LA7_0<=109)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalSymg.g:272:5: ( (lv_postconditions_19_0= ruleProposition ) ) otherlv_20= ';'
                    	    {
                    	    // InternalSymg.g:272:5: ( (lv_postconditions_19_0= ruleProposition ) )
                    	    // InternalSymg.g:273:6: (lv_postconditions_19_0= ruleProposition )
                    	    {
                    	    // InternalSymg.g:273:6: (lv_postconditions_19_0= ruleProposition )
                    	    // InternalSymg.g:274:7: lv_postconditions_19_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPostconditionsPropositionParserRuleCall_12_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_postconditions_19_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"postconditions",
                    	    								lv_postconditions_19_0,
                    	    								"org.xtext.example.symg.Symg.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_20=(Token)match(input,12,FOLLOW_13); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getModelAccess().getSemicolonKeyword_12_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:297:3: (otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSymg.g:298:4: otherlv_21= 'Obligations' ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )*
                    {
                    otherlv_21=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_21, grammarAccess.getModelAccess().getObligationsKeyword_13_0());
                    			
                    // InternalSymg.g:302:4: ( ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalSymg.g:303:5: ( (lv_obligations_22_0= ruleObligation ) ) otherlv_23= ';'
                    	    {
                    	    // InternalSymg.g:303:5: ( (lv_obligations_22_0= ruleObligation ) )
                    	    // InternalSymg.g:304:6: (lv_obligations_22_0= ruleObligation )
                    	    {
                    	    // InternalSymg.g:304:6: (lv_obligations_22_0= ruleObligation )
                    	    // InternalSymg.g:305:7: lv_obligations_22_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getObligationsObligationParserRuleCall_13_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_obligations_22_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"obligations",
                    	    								lv_obligations_22_0,
                    	    								"org.xtext.example.symg.Symg.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_23=(Token)match(input,12,FOLLOW_14); 

                    	    					newLeafNode(otherlv_23, grammarAccess.getModelAccess().getSemicolonKeyword_13_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:328:3: (otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSymg.g:329:4: otherlv_24= 'Surviving' otherlv_25= 'Obligations' ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )*
                    {
                    otherlv_24=(Token)match(input,22,FOLLOW_15); 

                    				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getSurvivingKeyword_14_0());
                    			
                    otherlv_25=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_25, grammarAccess.getModelAccess().getObligationsKeyword_14_1());
                    			
                    // InternalSymg.g:337:4: ( ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalSymg.g:338:5: ( (lv_sobligations_26_0= ruleObligation ) ) otherlv_27= ';'
                    	    {
                    	    // InternalSymg.g:338:5: ( (lv_sobligations_26_0= ruleObligation ) )
                    	    // InternalSymg.g:339:6: (lv_sobligations_26_0= ruleObligation )
                    	    {
                    	    // InternalSymg.g:339:6: (lv_sobligations_26_0= ruleObligation )
                    	    // InternalSymg.g:340:7: lv_sobligations_26_0= ruleObligation
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getSobligationsObligationParserRuleCall_14_2_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_sobligations_26_0=ruleObligation();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"sobligations",
                    	    								lv_sobligations_26_0,
                    	    								"org.xtext.example.symg.Symg.Obligation");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_27=(Token)match(input,12,FOLLOW_16); 

                    	    					newLeafNode(otherlv_27, grammarAccess.getModelAccess().getSemicolonKeyword_14_2_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:363:3: (otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalSymg.g:364:4: otherlv_28= 'Powers' ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )*
                    {
                    otherlv_28=(Token)match(input,23,FOLLOW_17); 

                    				newLeafNode(otherlv_28, grammarAccess.getModelAccess().getPowersKeyword_15_0());
                    			
                    // InternalSymg.g:368:4: ( ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalSymg.g:369:5: ( (lv_powers_29_0= rulePower ) ) otherlv_30= ';'
                    	    {
                    	    // InternalSymg.g:369:5: ( (lv_powers_29_0= rulePower ) )
                    	    // InternalSymg.g:370:6: (lv_powers_29_0= rulePower )
                    	    {
                    	    // InternalSymg.g:370:6: (lv_powers_29_0= rulePower )
                    	    // InternalSymg.g:371:7: lv_powers_29_0= rulePower
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getPowersPowerParserRuleCall_15_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_powers_29_0=rulePower();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"powers",
                    	    								lv_powers_29_0,
                    	    								"org.xtext.example.symg.Symg.Power");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_30=(Token)match(input,12,FOLLOW_17); 

                    	    					newLeafNode(otherlv_30, grammarAccess.getModelAccess().getSemicolonKeyword_15_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSymg.g:394:3: (otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSymg.g:395:4: otherlv_31= 'Constraints' ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )*
                    {
                    otherlv_31=(Token)match(input,24,FOLLOW_18); 

                    				newLeafNode(otherlv_31, grammarAccess.getModelAccess().getConstraintsKeyword_16_0());
                    			
                    // InternalSymg.g:399:4: ( ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||(LA15_0>=44 && LA15_0<=46)||(LA15_0>=48 && LA15_0<=49)||(LA15_0>=67 && LA15_0<=109)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalSymg.g:400:5: ( (lv_constraints_32_0= ruleProposition ) ) otherlv_33= ';'
                    	    {
                    	    // InternalSymg.g:400:5: ( (lv_constraints_32_0= ruleProposition ) )
                    	    // InternalSymg.g:401:6: (lv_constraints_32_0= ruleProposition )
                    	    {
                    	    // InternalSymg.g:401:6: (lv_constraints_32_0= ruleProposition )
                    	    // InternalSymg.g:402:7: lv_constraints_32_0= ruleProposition
                    	    {

                    	    							newCompositeNode(grammarAccess.getModelAccess().getConstraintsPropositionParserRuleCall_16_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_4);
                    	    lv_constraints_32_0=ruleProposition();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"constraints",
                    	    								lv_constraints_32_0,
                    	    								"org.xtext.example.symg.Symg.Proposition");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_33=(Token)match(input,12,FOLLOW_18); 

                    	    					newLeafNode(otherlv_33, grammarAccess.getModelAccess().getSemicolonKeyword_16_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_34=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_34, grammarAccess.getModelAccess().getEndContractKeyword_17());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDomainConcept"
    // InternalSymg.g:433:1: entryRuleDomainConcept returns [EObject current=null] : iv_ruleDomainConcept= ruleDomainConcept EOF ;
    public final EObject entryRuleDomainConcept() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainConcept = null;


        try {
            // InternalSymg.g:433:54: (iv_ruleDomainConcept= ruleDomainConcept EOF )
            // InternalSymg.g:434:2: iv_ruleDomainConcept= ruleDomainConcept EOF
            {
             newCompositeNode(grammarAccess.getDomainConceptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainConcept=ruleDomainConcept();

            state._fsp--;

             current =iv_ruleDomainConcept; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainConcept"


    // $ANTLR start "ruleDomainConcept"
    // InternalSymg.g:440:1: ruleDomainConcept returns [EObject current=null] : (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration ) ;
    public final EObject ruleDomainConcept() throws RecognitionException {
        EObject current = null;

        EObject this_Regular_0 = null;

        EObject this_Enumeration_1 = null;



        	enterRule();

        try {
            // InternalSymg.g:446:2: ( (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration ) )
            // InternalSymg.g:447:2: (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration )
            {
            // InternalSymg.g:447:2: (this_Regular_0= ruleRegular | this_Enumeration_1= ruleEnumeration )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==26) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==RULE_ID||(LA17_2>=30 && LA17_2<=37)) ) {
                        alt17=1;
                    }
                    else if ( (LA17_2==29) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalSymg.g:448:3: this_Regular_0= ruleRegular
                    {

                    			newCompositeNode(grammarAccess.getDomainConceptAccess().getRegularParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Regular_0=ruleRegular();

                    state._fsp--;


                    			current = this_Regular_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:457:3: this_Enumeration_1= ruleEnumeration
                    {

                    			newCompositeNode(grammarAccess.getDomainConceptAccess().getEnumerationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Enumeration_1=ruleEnumeration();

                    state._fsp--;


                    			current = this_Enumeration_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainConcept"


    // $ANTLR start "entryRuleRegular"
    // InternalSymg.g:469:1: entryRuleRegular returns [EObject current=null] : iv_ruleRegular= ruleRegular EOF ;
    public final EObject entryRuleRegular() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegular = null;


        try {
            // InternalSymg.g:469:48: (iv_ruleRegular= ruleRegular EOF )
            // InternalSymg.g:470:2: iv_ruleRegular= ruleRegular EOF
            {
             newCompositeNode(grammarAccess.getRegularRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegular=ruleRegular();

            state._fsp--;

             current =iv_ruleRegular; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegular"


    // $ANTLR start "ruleRegular"
    // InternalSymg.g:476:1: ruleRegular returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? ) ;
    public final EObject ruleRegular() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_conceptType_2_0 = null;

        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:482:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? ) )
            // InternalSymg.g:483:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? )
            {
            // InternalSymg.g:483:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )? )
            // InternalSymg.g:484:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' ( (lv_conceptType_2_0= ruleCType ) ) (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )?
            {
            // InternalSymg.g:484:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:485:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:485:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:486:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_0_0, grammarAccess.getRegularAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRegularRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getRegularAccess().getIsAKeyword_1());
            		
            // InternalSymg.g:506:3: ( (lv_conceptType_2_0= ruleCType ) )
            // InternalSymg.g:507:4: (lv_conceptType_2_0= ruleCType )
            {
            // InternalSymg.g:507:4: (lv_conceptType_2_0= ruleCType )
            // InternalSymg.g:508:5: lv_conceptType_2_0= ruleCType
            {

            					newCompositeNode(grammarAccess.getRegularAccess().getConceptTypeCTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_conceptType_2_0=ruleCType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularRule());
            					}
            					set(
            						current,
            						"conceptType",
            						lv_conceptType_2_0,
            						"org.xtext.example.symg.Symg.CType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymg.g:525:3: (otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSymg.g:526:4: otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleAttribute ) )
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getRegularAccess().getWithKeyword_3_0());
                    			
                    // InternalSymg.g:530:4: ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )*
                    loop18:
                    do {
                        int alt18=2;
                        alt18 = dfa18.predict(input);
                        switch (alt18) {
                    	case 1 :
                    	    // InternalSymg.g:531:5: ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ','
                    	    {
                    	    // InternalSymg.g:531:5: ( (lv_attributes_4_0= ruleAttribute ) )
                    	    // InternalSymg.g:532:6: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // InternalSymg.g:532:6: (lv_attributes_4_0= ruleAttribute )
                    	    // InternalSymg.g:533:7: lv_attributes_4_0= ruleAttribute
                    	    {

                    	    							newCompositeNode(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_attributes_4_0=ruleAttribute();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRegularRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_4_0,
                    	    								"org.xtext.example.symg.Symg.Attribute");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getRegularAccess().getCommaKeyword_3_1_1());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // InternalSymg.g:555:4: ( (lv_attributes_6_0= ruleAttribute ) )
                    // InternalSymg.g:556:5: (lv_attributes_6_0= ruleAttribute )
                    {
                    // InternalSymg.g:556:5: (lv_attributes_6_0= ruleAttribute )
                    // InternalSymg.g:557:6: lv_attributes_6_0= ruleAttribute
                    {

                    						newCompositeNode(grammarAccess.getRegularAccess().getAttributesAttributeParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_attributes_6_0=ruleAttribute();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRegularRule());
                    						}
                    						add(
                    							current,
                    							"attributes",
                    							lv_attributes_6_0,
                    							"org.xtext.example.symg.Symg.Attribute");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegular"


    // $ANTLR start "entryRuleAttribute"
    // InternalSymg.g:579:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalSymg.g:579:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalSymg.g:580:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalSymg.g:586:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_attributeType_2_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:592:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) ) )
            // InternalSymg.g:593:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) )
            {
            // InternalSymg.g:593:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) ) )
            // InternalSymg.g:594:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_attributeType_2_0= ruleCType ) )
            {
            // InternalSymg.g:594:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:595:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:595:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:596:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
            		
            // InternalSymg.g:616:3: ( (lv_attributeType_2_0= ruleCType ) )
            // InternalSymg.g:617:4: (lv_attributeType_2_0= ruleCType )
            {
            // InternalSymg.g:617:4: (lv_attributeType_2_0= ruleCType )
            // InternalSymg.g:618:5: lv_attributeType_2_0= ruleCType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getAttributeTypeCTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_attributeType_2_0=ruleCType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"attributeType",
            						lv_attributeType_2_0,
            						"org.xtext.example.symg.Symg.CType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleEnumeration"
    // InternalSymg.g:639:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalSymg.g:639:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalSymg.g:640:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;

             current =iv_ruleEnumeration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalSymg.g:646:1: ruleEnumeration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_enumerationItems_4_0 = null;

        EObject lv_enumerationItems_6_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:652:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' ) )
            // InternalSymg.g:653:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' )
            {
            // InternalSymg.g:653:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')' )
            // InternalSymg.g:654:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'isA' otherlv_2= 'Enumeration' otherlv_3= '(' ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )* ( (lv_enumerationItems_6_0= ruleenumItem ) ) otherlv_7= ')'
            {
            // InternalSymg.g:654:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:655:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:655:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:656:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getIsAKeyword_1());
            		
            otherlv_2=(Token)match(input,29,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationAccess().getEnumerationKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSymg.g:684:3: ( ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ',' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==16) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // InternalSymg.g:685:4: ( (lv_enumerationItems_4_0= ruleenumItem ) ) otherlv_5= ','
            	    {
            	    // InternalSymg.g:685:4: ( (lv_enumerationItems_4_0= ruleenumItem ) )
            	    // InternalSymg.g:686:5: (lv_enumerationItems_4_0= ruleenumItem )
            	    {
            	    // InternalSymg.g:686:5: (lv_enumerationItems_4_0= ruleenumItem )
            	    // InternalSymg.g:687:6: lv_enumerationItems_4_0= ruleenumItem
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_enumerationItems_4_0=ruleenumItem();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"enumerationItems",
            	    							lv_enumerationItems_4_0,
            	    							"org.xtext.example.symg.Symg.enumItem");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getEnumerationAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalSymg.g:709:3: ( (lv_enumerationItems_6_0= ruleenumItem ) )
            // InternalSymg.g:710:4: (lv_enumerationItems_6_0= ruleenumItem )
            {
            // InternalSymg.g:710:4: (lv_enumerationItems_6_0= ruleenumItem )
            // InternalSymg.g:711:5: lv_enumerationItems_6_0= ruleenumItem
            {

            					newCompositeNode(grammarAccess.getEnumerationAccess().getEnumerationItemsEnumItemParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_enumerationItems_6_0=ruleenumItem();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationRule());
            					}
            					add(
            						current,
            						"enumerationItems",
            						lv_enumerationItems_6_0,
            						"org.xtext.example.symg.Symg.enumItem");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getEnumerationAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleenumItem"
    // InternalSymg.g:736:1: entryRuleenumItem returns [EObject current=null] : iv_ruleenumItem= ruleenumItem EOF ;
    public final EObject entryRuleenumItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleenumItem = null;


        try {
            // InternalSymg.g:736:49: (iv_ruleenumItem= ruleenumItem EOF )
            // InternalSymg.g:737:2: iv_ruleenumItem= ruleenumItem EOF
            {
             newCompositeNode(grammarAccess.getEnumItemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleenumItem=ruleenumItem();

            state._fsp--;

             current =iv_ruleenumItem; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleenumItem"


    // $ANTLR start "ruleenumItem"
    // InternalSymg.g:743:1: ruleenumItem returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleenumItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSymg.g:749:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSymg.g:750:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSymg.g:750:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSymg.g:751:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSymg.g:751:3: ()
            // InternalSymg.g:752:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumItemAccess().getEnumItemAction_0(),
            					current);
            			

            }

            // InternalSymg.g:758:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSymg.g:759:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSymg.g:759:4: (lv_name_1_0= RULE_ID )
            // InternalSymg.g:760:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumItemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumItemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleenumItem"


    // $ANTLR start "entryRuleCType"
    // InternalSymg.g:780:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalSymg.g:780:46: (iv_ruleCType= ruleCType EOF )
            // InternalSymg.g:781:2: iv_ruleCType= ruleCType EOF
            {
             newCompositeNode(grammarAccess.getCTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCType=ruleCType();

            state._fsp--;

             current =iv_ruleCType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalSymg.g:787:1: ruleCType returns [EObject current=null] : (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType ) ;
    public final EObject ruleCType() throws RecognitionException {
        EObject current = null;

        EObject this_DomainType_0 = null;

        EObject this_OntoCType_1 = null;

        EObject this_BasicType_2 = null;



        	enterRule();

        try {
            // InternalSymg.g:793:2: ( (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType ) )
            // InternalSymg.g:794:2: (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType )
            {
            // InternalSymg.g:794:2: (this_DomainType_0= ruleDomainType | this_OntoCType_1= ruleOntoCType | this_BasicType_2= ruleBasicType )
            int alt21=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt21=1;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
                {
                alt21=2;
                }
                break;
            case 30:
            case 31:
            case 32:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalSymg.g:795:3: this_DomainType_0= ruleDomainType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getDomainTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DomainType_0=ruleDomainType();

                    state._fsp--;


                    			current = this_DomainType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:804:3: this_OntoCType_1= ruleOntoCType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getOntoCTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OntoCType_1=ruleOntoCType();

                    state._fsp--;


                    			current = this_OntoCType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:813:3: this_BasicType_2= ruleBasicType
                    {

                    			newCompositeNode(grammarAccess.getCTypeAccess().getBasicTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BasicType_2=ruleBasicType();

                    state._fsp--;


                    			current = this_BasicType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleDomainType"
    // InternalSymg.g:825:1: entryRuleDomainType returns [EObject current=null] : iv_ruleDomainType= ruleDomainType EOF ;
    public final EObject entryRuleDomainType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainType = null;


        try {
            // InternalSymg.g:825:51: (iv_ruleDomainType= ruleDomainType EOF )
            // InternalSymg.g:826:2: iv_ruleDomainType= ruleDomainType EOF
            {
             newCompositeNode(grammarAccess.getDomainTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainType=ruleDomainType();

            state._fsp--;

             current =iv_ruleDomainType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainType"


    // $ANTLR start "ruleDomainType"
    // InternalSymg.g:832:1: ruleDomainType returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleDomainType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalSymg.g:838:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalSymg.g:839:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalSymg.g:839:2: ( (otherlv_0= RULE_ID ) )
            // InternalSymg.g:840:3: (otherlv_0= RULE_ID )
            {
            // InternalSymg.g:840:3: (otherlv_0= RULE_ID )
            // InternalSymg.g:841:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDomainTypeRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getDomainTypeAccess().getSuperTypeDomainConceptCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainType"


    // $ANTLR start "entryRuleBasicType"
    // InternalSymg.g:855:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalSymg.g:855:50: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalSymg.g:856:2: iv_ruleBasicType= ruleBasicType EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;

             current =iv_ruleBasicType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalSymg.g:862:1: ruleBasicType returns [EObject current=null] : ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;


        	enterRule();

        try {
            // InternalSymg.g:868:2: ( ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) ) )
            // InternalSymg.g:869:2: ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) )
            {
            // InternalSymg.g:869:2: ( ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) ) )
            // InternalSymg.g:870:3: ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) )
            {
            // InternalSymg.g:870:3: ( (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' ) )
            // InternalSymg.g:871:4: (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' )
            {
            // InternalSymg.g:871:4: (lv_name_0_1= 'NUMBER' | lv_name_0_2= 'STRING' | lv_name_0_3= 'DATE' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt22=1;
                }
                break;
            case 31:
                {
                alt22=2;
                }
                break;
            case 32:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSymg.g:872:5: lv_name_0_1= 'NUMBER'
                    {
                    lv_name_0_1=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getBasicTypeAccess().getNameNUMBERKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymg.g:883:5: lv_name_0_2= 'STRING'
                    {
                    lv_name_0_2=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getBasicTypeAccess().getNameSTRINGKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymg.g:894:5: lv_name_0_3= 'DATE'
                    {
                    lv_name_0_3=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getBasicTypeAccess().getNameDATEKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBasicTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleOntoCType"
    // InternalSymg.g:910:1: entryRuleOntoCType returns [EObject current=null] : iv_ruleOntoCType= ruleOntoCType EOF ;
    public final EObject entryRuleOntoCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOntoCType = null;


        try {
            // InternalSymg.g:910:50: (iv_ruleOntoCType= ruleOntoCType EOF )
            // InternalSymg.g:911:2: iv_ruleOntoCType= ruleOntoCType EOF
            {
             newCompositeNode(grammarAccess.getOntoCTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOntoCType=ruleOntoCType();

            state._fsp--;

             current =iv_ruleOntoCType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOntoCType"


    // $ANTLR start "ruleOntoCType"
    // InternalSymg.g:917:1: ruleOntoCType returns [EObject current=null] : ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) ) ;
    public final EObject ruleOntoCType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;


        	enterRule();

        try {
            // InternalSymg.g:923:2: ( ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) ) )
            // InternalSymg.g:924:2: ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) )
            {
            // InternalSymg.g:924:2: ( ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) ) )
            // InternalSymg.g:925:3: ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) )
            {
            // InternalSymg.g:925:3: ( (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' ) )
            // InternalSymg.g:926:4: (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' )
            {
            // InternalSymg.g:926:4: (lv_name_0_1= 'ASSET' | lv_name_0_2= 'EVENT' | lv_name_0_3= 'ROLE' | lv_name_0_4= 'SITUATION' | lv_name_0_5= 'CONTRACT' )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt23=1;
                }
                break;
            case 34:
                {
                alt23=2;
                }
                break;
            case 35:
                {
                alt23=3;
                }
                break;
            case 36:
                {
                alt23=4;
                }
                break;
            case 37:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSymg.g:927:5: lv_name_0_1= 'ASSET'
                    {
                    lv_name_0_1=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getOntoCTypeAccess().getNameASSETKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalSymg.g:938:5: lv_name_0_2= 'EVENT'
                    {
                    lv_name_0_2=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getOntoCTypeAccess().getNameEVENTKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalSymg.g:949:5: lv_name_0_3= 'ROLE'
                    {
                    lv_name_0_3=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getOntoCTypeAccess().getNameROLEKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalSymg.g:960:5: lv_name_0_4= 'SITUATION'
                    {
                    lv_name_0_4=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getOntoCTypeAccess().getNameSITUATIONKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalSymg.g:971:5: lv_name_0_5= 'CONTRACT'
                    {
                    lv_name_0_5=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getOntoCTypeAccess().getNameCONTRACTKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getOntoCTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOntoCType"


    // $ANTLR start "entryRuleParameter"
    // InternalSymg.g:987:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSymg.g:987:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSymg.g:988:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSymg.g:994:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1000:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) ) )
            // InternalSymg.g:1001:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) )
            {
            // InternalSymg.g:1001:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) ) )
            // InternalSymg.g:1002:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleTypeName ) )
            {
            // InternalSymg.g:1002:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:1003:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:1003:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:1004:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            // InternalSymg.g:1024:3: ( (lv_type_2_0= ruleTypeName ) )
            // InternalSymg.g:1025:4: (lv_type_2_0= ruleTypeName )
            {
            // InternalSymg.g:1025:4: (lv_type_2_0= ruleTypeName )
            // InternalSymg.g:1026:5: lv_type_2_0= ruleTypeName
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleTypeName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.xtext.example.symg.Symg.TypeName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeName"
    // InternalSymg.g:1047:1: entryRuleTypeName returns [EObject current=null] : iv_ruleTypeName= ruleTypeName EOF ;
    public final EObject entryRuleTypeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeName = null;


        try {
            // InternalSymg.g:1047:49: (iv_ruleTypeName= ruleTypeName EOF )
            // InternalSymg.g:1048:2: iv_ruleTypeName= ruleTypeName EOF
            {
             newCompositeNode(grammarAccess.getTypeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeName=ruleTypeName();

            state._fsp--;

             current =iv_ruleTypeName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeName"


    // $ANTLR start "ruleTypeName"
    // InternalSymg.g:1054:1: ruleTypeName returns [EObject current=null] : (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType ) ;
    public final EObject ruleTypeName() throws RecognitionException {
        EObject current = null;

        EObject this_DomainType_0 = null;

        EObject this_BasicType_1 = null;



        	enterRule();

        try {
            // InternalSymg.g:1060:2: ( (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType ) )
            // InternalSymg.g:1061:2: (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType )
            {
            // InternalSymg.g:1061:2: (this_DomainType_0= ruleDomainType | this_BasicType_1= ruleBasicType )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=30 && LA24_0<=32)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalSymg.g:1062:3: this_DomainType_0= ruleDomainType
                    {

                    			newCompositeNode(grammarAccess.getTypeNameAccess().getDomainTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DomainType_0=ruleDomainType();

                    state._fsp--;


                    			current = this_DomainType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:1071:3: this_BasicType_1= ruleBasicType
                    {

                    			newCompositeNode(grammarAccess.getTypeNameAccess().getBasicTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BasicType_1=ruleBasicType();

                    state._fsp--;


                    			current = this_BasicType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeName"


    // $ANTLR start "entryRuleDeclarPair"
    // InternalSymg.g:1083:1: entryRuleDeclarPair returns [EObject current=null] : iv_ruleDeclarPair= ruleDeclarPair EOF ;
    public final EObject entryRuleDeclarPair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarPair = null;


        try {
            // InternalSymg.g:1083:51: (iv_ruleDeclarPair= ruleDeclarPair EOF )
            // InternalSymg.g:1084:2: iv_ruleDeclarPair= ruleDeclarPair EOF
            {
             newCompositeNode(grammarAccess.getDeclarPairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclarPair=ruleDeclarPair();

            state._fsp--;

             current =iv_ruleDeclarPair; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarPair"


    // $ANTLR start "ruleDeclarPair"
    // InternalSymg.g:1090:1: ruleDeclarPair returns [EObject current=null] : ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_param_2_0= RULE_ID ) ) ) ;
    public final EObject ruleDeclarPair() throws RecognitionException {
        EObject current = null;

        Token lv_attr_0_0=null;
        Token otherlv_1=null;
        Token lv_param_2_0=null;


        	enterRule();

        try {
            // InternalSymg.g:1096:2: ( ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_param_2_0= RULE_ID ) ) ) )
            // InternalSymg.g:1097:2: ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_param_2_0= RULE_ID ) ) )
            {
            // InternalSymg.g:1097:2: ( ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_param_2_0= RULE_ID ) ) )
            // InternalSymg.g:1098:3: ( (lv_attr_0_0= RULE_ID ) ) otherlv_1= ':=' ( (lv_param_2_0= RULE_ID ) )
            {
            // InternalSymg.g:1098:3: ( (lv_attr_0_0= RULE_ID ) )
            // InternalSymg.g:1099:4: (lv_attr_0_0= RULE_ID )
            {
            // InternalSymg.g:1099:4: (lv_attr_0_0= RULE_ID )
            // InternalSymg.g:1100:5: lv_attr_0_0= RULE_ID
            {
            lv_attr_0_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_attr_0_0, grammarAccess.getDeclarPairAccess().getAttrIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarPairRule());
            					}
            					setWithLastConsumed(
            						current,
            						"attr",
            						lv_attr_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDeclarPairAccess().getColonEqualsSignKeyword_1());
            		
            // InternalSymg.g:1120:3: ( (lv_param_2_0= RULE_ID ) )
            // InternalSymg.g:1121:4: (lv_param_2_0= RULE_ID )
            {
            // InternalSymg.g:1121:4: (lv_param_2_0= RULE_ID )
            // InternalSymg.g:1122:5: lv_param_2_0= RULE_ID
            {
            lv_param_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_param_2_0, grammarAccess.getDeclarPairAccess().getParamIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarPairRule());
            					}
            					setWithLastConsumed(
            						current,
            						"param",
            						lv_param_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarPair"


    // $ANTLR start "entryRuleDeclar"
    // InternalSymg.g:1142:1: entryRuleDeclar returns [EObject current=null] : iv_ruleDeclar= ruleDeclar EOF ;
    public final EObject entryRuleDeclar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclar = null;


        try {
            // InternalSymg.g:1142:47: (iv_ruleDeclar= ruleDeclar EOF )
            // InternalSymg.g:1143:2: iv_ruleDeclar= ruleDeclar EOF
            {
             newCompositeNode(grammarAccess.getDeclarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclar=ruleDeclar();

            state._fsp--;

             current =iv_ruleDeclar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclar"


    // $ANTLR start "ruleDeclar"
    // InternalSymg.g:1149:1: ruleDeclar returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) ) ;
    public final EObject ruleDeclar() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_attributes_6_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1155:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) ) )
            // InternalSymg.g:1156:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) )
            {
            // InternalSymg.g:1156:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) ) )
            // InternalSymg.g:1157:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'with' ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )* ( (lv_attributes_6_0= ruleDeclarPair ) )
            {
            // InternalSymg.g:1157:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:1158:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:1158:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:1159:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getDeclarAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getDeclarAccess().getColonKeyword_1());
            		
            // InternalSymg.g:1179:3: ( (otherlv_2= RULE_ID ) )
            // InternalSymg.g:1180:4: (otherlv_2= RULE_ID )
            {
            // InternalSymg.g:1180:4: (otherlv_2= RULE_ID )
            // InternalSymg.g:1181:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclarRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_2, grammarAccess.getDeclarAccess().getTypeRegularCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDeclarAccess().getWithKeyword_3());
            		
            // InternalSymg.g:1196:3: ( ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ',' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==38) ) {
                        int LA25_2 = input.LA(3);

                        if ( (LA25_2==RULE_ID) ) {
                            int LA25_3 = input.LA(4);

                            if ( (LA25_3==16) ) {
                                alt25=1;
                            }


                        }


                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalSymg.g:1197:4: ( (lv_attributes_4_0= ruleDeclarPair ) ) otherlv_5= ','
            	    {
            	    // InternalSymg.g:1197:4: ( (lv_attributes_4_0= ruleDeclarPair ) )
            	    // InternalSymg.g:1198:5: (lv_attributes_4_0= ruleDeclarPair )
            	    {
            	    // InternalSymg.g:1198:5: (lv_attributes_4_0= ruleDeclarPair )
            	    // InternalSymg.g:1199:6: lv_attributes_4_0= ruleDeclarPair
            	    {

            	    						newCompositeNode(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_4_0_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_attributes_4_0=ruleDeclarPair();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeclarRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_4_0,
            	    							"org.xtext.example.symg.Symg.DeclarPair");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_5=(Token)match(input,16,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getDeclarAccess().getCommaKeyword_4_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // InternalSymg.g:1221:3: ( (lv_attributes_6_0= ruleDeclarPair ) )
            // InternalSymg.g:1222:4: (lv_attributes_6_0= ruleDeclarPair )
            {
            // InternalSymg.g:1222:4: (lv_attributes_6_0= ruleDeclarPair )
            // InternalSymg.g:1223:5: lv_attributes_6_0= ruleDeclarPair
            {

            					newCompositeNode(grammarAccess.getDeclarAccess().getAttributesDeclarPairParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_attributes_6_0=ruleDeclarPair();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeclarRule());
            					}
            					add(
            						current,
            						"attributes",
            						lv_attributes_6_0,
            						"org.xtext.example.symg.Symg.DeclarPair");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclar"


    // $ANTLR start "entryRuleObligation"
    // InternalSymg.g:1244:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalSymg.g:1244:51: (iv_ruleObligation= ruleObligation EOF )
            // InternalSymg.g:1245:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalSymg.g:1251:1: ruleObligation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_role1_6_0=null;
        Token otherlv_7=null;
        Token lv_role2_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_antecedent_10_0 = null;

        EObject lv_consequent_12_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1257:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) )
            // InternalSymg.g:1258:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            {
            // InternalSymg.g:1258:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            // InternalSymg.g:1259:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'obligation' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')'
            {
            // InternalSymg.g:1259:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:1260:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:1260:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:1261:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getObligationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationAccess().getColonKeyword_1());
            		
            // InternalSymg.g:1281:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_INT)||(LA26_0>=44 && LA26_0<=46)||(LA26_0>=48 && LA26_0<=49)||(LA26_0>=67 && LA26_0<=109)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalSymg.g:1282:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymg.g:1282:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymg.g:1283:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymg.g:1283:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymg.g:1284:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"org.xtext.example.symg.Symg.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_28); 

                    				newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,40,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getObligationKeyword_3());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymg.g:1314:3: ( (lv_role1_6_0= RULE_ID ) )
            // InternalSymg.g:1315:4: (lv_role1_6_0= RULE_ID )
            {
            // InternalSymg.g:1315:4: (lv_role1_6_0= RULE_ID )
            // InternalSymg.g:1316:5: lv_role1_6_0= RULE_ID
            {
            lv_role1_6_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role1_6_0, grammarAccess.getObligationAccess().getRole1IDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role1",
            						lv_role1_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getObligationAccess().getCommaKeyword_6());
            		
            // InternalSymg.g:1336:3: ( (lv_role2_8_0= RULE_ID ) )
            // InternalSymg.g:1337:4: (lv_role2_8_0= RULE_ID )
            {
            // InternalSymg.g:1337:4: (lv_role2_8_0= RULE_ID )
            // InternalSymg.g:1338:5: lv_role2_8_0= RULE_ID
            {
            lv_role2_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role2_8_0, grammarAccess.getObligationAccess().getRole2IDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role2",
            						lv_role2_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_29); 

            			newLeafNode(otherlv_9, grammarAccess.getObligationAccess().getCommaKeyword_8());
            		
            // InternalSymg.g:1358:3: ( (lv_antecedent_10_0= ruleProposition ) )
            // InternalSymg.g:1359:4: (lv_antecedent_10_0= ruleProposition )
            {
            // InternalSymg.g:1359:4: (lv_antecedent_10_0= ruleProposition )
            // InternalSymg.g:1360:5: lv_antecedent_10_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_antecedent_10_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_10_0,
            						"org.xtext.example.symg.Symg.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_29); 

            			newLeafNode(otherlv_11, grammarAccess.getObligationAccess().getCommaKeyword_10());
            		
            // InternalSymg.g:1381:3: ( (lv_consequent_12_0= ruleProposition ) )
            // InternalSymg.g:1382:4: (lv_consequent_12_0= ruleProposition )
            {
            // InternalSymg.g:1382:4: (lv_consequent_12_0= ruleProposition )
            // InternalSymg.g:1383:5: lv_consequent_12_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_9);
            lv_consequent_12_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_12_0,
            						"org.xtext.example.symg.Symg.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getObligationAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalSymg.g:1408:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // InternalSymg.g:1408:46: (iv_rulePower= rulePower EOF )
            // InternalSymg.g:1409:2: iv_rulePower= rulePower EOF
            {
             newCompositeNode(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePower=rulePower();

            state._fsp--;

             current =iv_rulePower; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalSymg.g:1415:1: rulePower returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_role1_6_0=null;
        Token otherlv_7=null;
        Token lv_role2_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_trigger_2_0 = null;

        EObject lv_antecedent_10_0 = null;

        EObject lv_consequent_12_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1421:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' ) )
            // InternalSymg.g:1422:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            {
            // InternalSymg.g:1422:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')' )
            // InternalSymg.g:1423:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )? otherlv_4= 'power' otherlv_5= '(' ( (lv_role1_6_0= RULE_ID ) ) otherlv_7= ',' ( (lv_role2_8_0= RULE_ID ) ) otherlv_9= ',' ( (lv_antecedent_10_0= ruleProposition ) ) otherlv_11= ',' ( (lv_consequent_12_0= ruleProposition ) ) otherlv_13= ')'
            {
            // InternalSymg.g:1423:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSymg.g:1424:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSymg.g:1424:4: (lv_name_0_0= RULE_ID )
            // InternalSymg.g:1425:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPowerAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_30); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerAccess().getColonKeyword_1());
            		
            // InternalSymg.g:1445:3: ( ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_ID && LA27_0<=RULE_INT)||(LA27_0>=44 && LA27_0<=46)||(LA27_0>=48 && LA27_0<=49)||(LA27_0>=67 && LA27_0<=109)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSymg.g:1446:4: ( (lv_trigger_2_0= ruleProposition ) ) otherlv_3= '->'
                    {
                    // InternalSymg.g:1446:4: ( (lv_trigger_2_0= ruleProposition ) )
                    // InternalSymg.g:1447:5: (lv_trigger_2_0= ruleProposition )
                    {
                    // InternalSymg.g:1447:5: (lv_trigger_2_0= ruleProposition )
                    // InternalSymg.g:1448:6: lv_trigger_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_27);
                    lv_trigger_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_2_0,
                    							"org.xtext.example.symg.Symg.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_31); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,41,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerAccess().getPowerKeyword_3());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerAccess().getLeftParenthesisKeyword_4());
            		
            // InternalSymg.g:1478:3: ( (lv_role1_6_0= RULE_ID ) )
            // InternalSymg.g:1479:4: (lv_role1_6_0= RULE_ID )
            {
            // InternalSymg.g:1479:4: (lv_role1_6_0= RULE_ID )
            // InternalSymg.g:1480:5: lv_role1_6_0= RULE_ID
            {
            lv_role1_6_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role1_6_0, grammarAccess.getPowerAccess().getRole1IDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role1",
            						lv_role1_6_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getPowerAccess().getCommaKeyword_6());
            		
            // InternalSymg.g:1500:3: ( (lv_role2_8_0= RULE_ID ) )
            // InternalSymg.g:1501:4: (lv_role2_8_0= RULE_ID )
            {
            // InternalSymg.g:1501:4: (lv_role2_8_0= RULE_ID )
            // InternalSymg.g:1502:5: lv_role2_8_0= RULE_ID
            {
            lv_role2_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_role2_8_0, grammarAccess.getPowerAccess().getRole2IDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"role2",
            						lv_role2_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_29); 

            			newLeafNode(otherlv_9, grammarAccess.getPowerAccess().getCommaKeyword_8());
            		
            // InternalSymg.g:1522:3: ( (lv_antecedent_10_0= ruleProposition ) )
            // InternalSymg.g:1523:4: (lv_antecedent_10_0= ruleProposition )
            {
            // InternalSymg.g:1523:4: (lv_antecedent_10_0= ruleProposition )
            // InternalSymg.g:1524:5: lv_antecedent_10_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_8);
            lv_antecedent_10_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_10_0,
            						"org.xtext.example.symg.Symg.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_29); 

            			newLeafNode(otherlv_11, grammarAccess.getPowerAccess().getCommaKeyword_10());
            		
            // InternalSymg.g:1545:3: ( (lv_consequent_12_0= ruleProposition ) )
            // InternalSymg.g:1546:4: (lv_consequent_12_0= ruleProposition )
            {
            // InternalSymg.g:1546:4: (lv_consequent_12_0= ruleProposition )
            // InternalSymg.g:1547:5: lv_consequent_12_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getConsequentPropositionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_9);
            lv_consequent_12_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_12_0,
            						"org.xtext.example.symg.Symg.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getPowerAccess().getRightParenthesisKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRuleProposition"
    // InternalSymg.g:1572:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalSymg.g:1572:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalSymg.g:1573:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalSymg.g:1579:1: ruleProposition returns [EObject current=null] : ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* ) ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_junctions_0_0 = null;

        EObject lv_junctions_2_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1585:2: ( ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* ) )
            // InternalSymg.g:1586:2: ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* )
            {
            // InternalSymg.g:1586:2: ( ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )* )
            // InternalSymg.g:1587:3: ( (lv_junctions_0_0= ruleJunction ) ) (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )*
            {
            // InternalSymg.g:1587:3: ( (lv_junctions_0_0= ruleJunction ) )
            // InternalSymg.g:1588:4: (lv_junctions_0_0= ruleJunction )
            {
            // InternalSymg.g:1588:4: (lv_junctions_0_0= ruleJunction )
            // InternalSymg.g:1589:5: lv_junctions_0_0= ruleJunction
            {

            					newCompositeNode(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_junctions_0_0=ruleJunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPropositionRule());
            					}
            					add(
            						current,
            						"junctions",
            						lv_junctions_0_0,
            						"org.xtext.example.symg.Symg.Junction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymg.g:1606:3: (otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSymg.g:1607:4: otherlv_1= 'OR' ( (lv_junctions_2_0= ruleJunction ) )
            	    {
            	    otherlv_1=(Token)match(input,42,FOLLOW_29); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPropositionAccess().getORKeyword_1_0());
            	    			
            	    // InternalSymg.g:1611:4: ( (lv_junctions_2_0= ruleJunction ) )
            	    // InternalSymg.g:1612:5: (lv_junctions_2_0= ruleJunction )
            	    {
            	    // InternalSymg.g:1612:5: (lv_junctions_2_0= ruleJunction )
            	    // InternalSymg.g:1613:6: lv_junctions_2_0= ruleJunction
            	    {

            	    						newCompositeNode(grammarAccess.getPropositionAccess().getJunctionsJunctionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_junctions_2_0=ruleJunction();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPropositionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"junctions",
            	    							lv_junctions_2_0,
            	    							"org.xtext.example.symg.Symg.Junction");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRuleJunction"
    // InternalSymg.g:1635:1: entryRuleJunction returns [EObject current=null] : iv_ruleJunction= ruleJunction EOF ;
    public final EObject entryRuleJunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJunction = null;


        try {
            // InternalSymg.g:1635:49: (iv_ruleJunction= ruleJunction EOF )
            // InternalSymg.g:1636:2: iv_ruleJunction= ruleJunction EOF
            {
             newCompositeNode(grammarAccess.getJunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJunction=ruleJunction();

            state._fsp--;

             current =iv_ruleJunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJunction"


    // $ANTLR start "ruleJunction"
    // InternalSymg.g:1642:1: ruleJunction returns [EObject current=null] : ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* ) ;
    public final EObject ruleJunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_negativeAtoms_0_0 = null;

        EObject lv_negativeAtoms_2_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1648:2: ( ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* ) )
            // InternalSymg.g:1649:2: ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* )
            {
            // InternalSymg.g:1649:2: ( ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )* )
            // InternalSymg.g:1650:3: ( (lv_negativeAtoms_0_0= ruleNegation ) ) (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )*
            {
            // InternalSymg.g:1650:3: ( (lv_negativeAtoms_0_0= ruleNegation ) )
            // InternalSymg.g:1651:4: (lv_negativeAtoms_0_0= ruleNegation )
            {
            // InternalSymg.g:1651:4: (lv_negativeAtoms_0_0= ruleNegation )
            // InternalSymg.g:1652:5: lv_negativeAtoms_0_0= ruleNegation
            {

            					newCompositeNode(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_33);
            lv_negativeAtoms_0_0=ruleNegation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJunctionRule());
            					}
            					add(
            						current,
            						"negativeAtoms",
            						lv_negativeAtoms_0_0,
            						"org.xtext.example.symg.Symg.Negation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSymg.g:1669:3: (otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==43) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSymg.g:1670:4: otherlv_1= 'AND' ( (lv_negativeAtoms_2_0= ruleNegation ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_29); 

            	    				newLeafNode(otherlv_1, grammarAccess.getJunctionAccess().getANDKeyword_1_0());
            	    			
            	    // InternalSymg.g:1674:4: ( (lv_negativeAtoms_2_0= ruleNegation ) )
            	    // InternalSymg.g:1675:5: (lv_negativeAtoms_2_0= ruleNegation )
            	    {
            	    // InternalSymg.g:1675:5: (lv_negativeAtoms_2_0= ruleNegation )
            	    // InternalSymg.g:1676:6: lv_negativeAtoms_2_0= ruleNegation
            	    {

            	    						newCompositeNode(grammarAccess.getJunctionAccess().getNegativeAtomsNegationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_33);
            	    lv_negativeAtoms_2_0=ruleNegation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getJunctionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"negativeAtoms",
            	    							lv_negativeAtoms_2_0,
            	    							"org.xtext.example.symg.Symg.Negation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJunction"


    // $ANTLR start "entryRuleNegation"
    // InternalSymg.g:1698:1: entryRuleNegation returns [EObject current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final EObject entryRuleNegation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegation = null;


        try {
            // InternalSymg.g:1698:49: (iv_ruleNegation= ruleNegation EOF )
            // InternalSymg.g:1699:2: iv_ruleNegation= ruleNegation EOF
            {
             newCompositeNode(grammarAccess.getNegationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNegation=ruleNegation();

            state._fsp--;

             current =iv_ruleNegation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // InternalSymg.g:1705:1: ruleNegation returns [EObject current=null] : ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) ) ;
    public final EObject ruleNegation() throws RecognitionException {
        EObject current = null;

        Token lv_negated_0_0=null;
        EObject lv_atomicExpression_1_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1711:2: ( ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) ) )
            // InternalSymg.g:1712:2: ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) )
            {
            // InternalSymg.g:1712:2: ( ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) ) )
            // InternalSymg.g:1713:3: ( (lv_negated_0_0= 'NOT' ) )? ( (lv_atomicExpression_1_0= ruleAtom ) )
            {
            // InternalSymg.g:1713:3: ( (lv_negated_0_0= 'NOT' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalSymg.g:1714:4: (lv_negated_0_0= 'NOT' )
                    {
                    // InternalSymg.g:1714:4: (lv_negated_0_0= 'NOT' )
                    // InternalSymg.g:1715:5: lv_negated_0_0= 'NOT'
                    {
                    lv_negated_0_0=(Token)match(input,44,FOLLOW_29); 

                    					newLeafNode(lv_negated_0_0, grammarAccess.getNegationAccess().getNegatedNOTKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNegationRule());
                    					}
                    					setWithLastConsumed(current, "negated", lv_negated_0_0 != null, "NOT");
                    				

                    }


                    }
                    break;

            }

            // InternalSymg.g:1727:3: ( (lv_atomicExpression_1_0= ruleAtom ) )
            // InternalSymg.g:1728:4: (lv_atomicExpression_1_0= ruleAtom )
            {
            // InternalSymg.g:1728:4: (lv_atomicExpression_1_0= ruleAtom )
            // InternalSymg.g:1729:5: lv_atomicExpression_1_0= ruleAtom
            {

            					newCompositeNode(grammarAccess.getNegationAccess().getAtomicExpressionAtomParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_atomicExpression_1_0=ruleAtom();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNegationRule());
            					}
            					set(
            						current,
            						"atomicExpression",
            						lv_atomicExpression_1_0,
            						"org.xtext.example.symg.Symg.Atom");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleAtom"
    // InternalSymg.g:1750:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalSymg.g:1750:45: (iv_ruleAtom= ruleAtom EOF )
            // InternalSymg.g:1751:2: iv_ruleAtom= ruleAtom EOF
            {
             newCompositeNode(grammarAccess.getAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalSymg.g:1757:1: ruleAtom returns [EObject current=null] : ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_bool_11_0=null;
        Token lv_bool_12_0=null;
        EObject lv_eventProposition_2_0 = null;

        EObject lv_situationProposition_6_0 = null;

        EObject lv_point_8_0 = null;

        EObject lv_interval_10_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1763:2: ( ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) ) )
            // InternalSymg.g:1764:2: ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) )
            {
            // InternalSymg.g:1764:2: ( (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' ) | (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' ) | ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) ) | ( (lv_bool_11_0= 'TRUE' ) ) | ( (lv_bool_12_0= 'FALSE' ) ) )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt31=1;
                }
                break;
            case 46:
                {
                alt31=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt31=3;
                }
                break;
            case 48:
                {
                alt31=4;
                }
                break;
            case 49:
                {
                alt31=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalSymg.g:1765:3: (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' )
                    {
                    // InternalSymg.g:1765:3: (otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')' )
                    // InternalSymg.g:1766:4: otherlv_0= 'happens' otherlv_1= '(' ( (lv_eventProposition_2_0= ruleEventProp ) ) otherlv_3= ')'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getAtomAccess().getHappensKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,15,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getAtomAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalSymg.g:1774:4: ( (lv_eventProposition_2_0= ruleEventProp ) )
                    // InternalSymg.g:1775:5: (lv_eventProposition_2_0= ruleEventProp )
                    {
                    // InternalSymg.g:1775:5: (lv_eventProposition_2_0= ruleEventProp )
                    // InternalSymg.g:1776:6: lv_eventProposition_2_0= ruleEventProp
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getEventPropositionEventPropParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_eventProposition_2_0=ruleEventProp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"eventProposition",
                    							lv_eventProposition_2_0,
                    							"org.xtext.example.symg.Symg.EventProp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getAtomAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1799:3: (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' )
                    {
                    // InternalSymg.g:1799:3: (otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')' )
                    // InternalSymg.g:1800:4: otherlv_4= 'occurs' otherlv_5= '(' ( (lv_situationProposition_6_0= ruleSitProp ) ) otherlv_7= ')'
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getAtomAccess().getOccursKeyword_1_0());
                    			
                    otherlv_5=(Token)match(input,15,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getAtomAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalSymg.g:1808:4: ( (lv_situationProposition_6_0= ruleSitProp ) )
                    // InternalSymg.g:1809:5: (lv_situationProposition_6_0= ruleSitProp )
                    {
                    // InternalSymg.g:1809:5: (lv_situationProposition_6_0= ruleSitProp )
                    // InternalSymg.g:1810:6: lv_situationProposition_6_0= ruleSitProp
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getSituationPropositionSitPropParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_situationProposition_6_0=ruleSitProp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"situationProposition",
                    							lv_situationProposition_6_0,
                    							"org.xtext.example.symg.Symg.SitProp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,17,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getAtomAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1833:3: ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) )
                    {
                    // InternalSymg.g:1833:3: ( ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) ) )
                    // InternalSymg.g:1834:4: ( (lv_point_8_0= rulePoint ) ) otherlv_9= 'within' ( (lv_interval_10_0= ruleInterval ) )
                    {
                    // InternalSymg.g:1834:4: ( (lv_point_8_0= rulePoint ) )
                    // InternalSymg.g:1835:5: (lv_point_8_0= rulePoint )
                    {
                    // InternalSymg.g:1835:5: (lv_point_8_0= rulePoint )
                    // InternalSymg.g:1836:6: lv_point_8_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getPointPointParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_point_8_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_8_0,
                    							"org.xtext.example.symg.Symg.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,47,FOLLOW_37); 

                    				newLeafNode(otherlv_9, grammarAccess.getAtomAccess().getWithinKeyword_2_1());
                    			
                    // InternalSymg.g:1857:4: ( (lv_interval_10_0= ruleInterval ) )
                    // InternalSymg.g:1858:5: (lv_interval_10_0= ruleInterval )
                    {
                    // InternalSymg.g:1858:5: (lv_interval_10_0= ruleInterval )
                    // InternalSymg.g:1859:6: lv_interval_10_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getAtomAccess().getIntervalIntervalParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_interval_10_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_10_0,
                    							"org.xtext.example.symg.Symg.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1878:3: ( (lv_bool_11_0= 'TRUE' ) )
                    {
                    // InternalSymg.g:1878:3: ( (lv_bool_11_0= 'TRUE' ) )
                    // InternalSymg.g:1879:4: (lv_bool_11_0= 'TRUE' )
                    {
                    // InternalSymg.g:1879:4: (lv_bool_11_0= 'TRUE' )
                    // InternalSymg.g:1880:5: lv_bool_11_0= 'TRUE'
                    {
                    lv_bool_11_0=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_bool_11_0, grammarAccess.getAtomAccess().getBoolTRUEKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAtomRule());
                    					}
                    					setWithLastConsumed(current, "bool", lv_bool_11_0, "TRUE");
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:1893:3: ( (lv_bool_12_0= 'FALSE' ) )
                    {
                    // InternalSymg.g:1893:3: ( (lv_bool_12_0= 'FALSE' ) )
                    // InternalSymg.g:1894:4: (lv_bool_12_0= 'FALSE' )
                    {
                    // InternalSymg.g:1894:4: (lv_bool_12_0= 'FALSE' )
                    // InternalSymg.g:1895:5: lv_bool_12_0= 'FALSE'
                    {
                    lv_bool_12_0=(Token)match(input,49,FOLLOW_2); 

                    					newLeafNode(lv_bool_12_0, grammarAccess.getAtomAccess().getBoolFALSEKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAtomRule());
                    					}
                    					setWithLastConsumed(current, "bool", lv_bool_12_0, "FALSE");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleSitProp"
    // InternalSymg.g:1911:1: entryRuleSitProp returns [EObject current=null] : iv_ruleSitProp= ruleSitProp EOF ;
    public final EObject entryRuleSitProp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSitProp = null;


        try {
            // InternalSymg.g:1911:48: (iv_ruleSitProp= ruleSitProp EOF )
            // InternalSymg.g:1912:2: iv_ruleSitProp= ruleSitProp EOF
            {
             newCompositeNode(grammarAccess.getSitPropRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSitProp=ruleSitProp();

            state._fsp--;

             current =iv_ruleSitProp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSitProp"


    // $ANTLR start "ruleSitProp"
    // InternalSymg.g:1918:1: ruleSitProp returns [EObject current=null] : ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) ) ;
    public final EObject ruleSitProp() throws RecognitionException {
        EObject current = null;

        Token lv_situationName_0_0=null;
        Token otherlv_4=null;
        EObject lv_oSituationName_1_0 = null;

        EObject lv_cSituationName_2_0 = null;

        EObject lv_pSituationName_3_0 = null;

        EObject lv_interval_5_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:1924:2: ( ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) ) )
            // InternalSymg.g:1925:2: ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) )
            {
            // InternalSymg.g:1925:2: ( ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) ) )
            // InternalSymg.g:1926:3: ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) ) otherlv_4= ',' ( (lv_interval_5_0= ruleInterval ) )
            {
            // InternalSymg.g:1926:3: ( ( (lv_situationName_0_0= RULE_ID ) ) | ( (lv_oSituationName_1_0= ruleoState ) ) | ( (lv_cSituationName_2_0= rulecState ) ) | ( (lv_pSituationName_3_0= rulepState ) ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt32=1;
                }
                break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt32=2;
                }
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                {
                alt32=3;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalSymg.g:1927:4: ( (lv_situationName_0_0= RULE_ID ) )
                    {
                    // InternalSymg.g:1927:4: ( (lv_situationName_0_0= RULE_ID ) )
                    // InternalSymg.g:1928:5: (lv_situationName_0_0= RULE_ID )
                    {
                    // InternalSymg.g:1928:5: (lv_situationName_0_0= RULE_ID )
                    // InternalSymg.g:1929:6: lv_situationName_0_0= RULE_ID
                    {
                    lv_situationName_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_situationName_0_0, grammarAccess.getSitPropAccess().getSituationNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSitPropRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"situationName",
                    							lv_situationName_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:1946:4: ( (lv_oSituationName_1_0= ruleoState ) )
                    {
                    // InternalSymg.g:1946:4: ( (lv_oSituationName_1_0= ruleoState ) )
                    // InternalSymg.g:1947:5: (lv_oSituationName_1_0= ruleoState )
                    {
                    // InternalSymg.g:1947:5: (lv_oSituationName_1_0= ruleoState )
                    // InternalSymg.g:1948:6: lv_oSituationName_1_0= ruleoState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getOSituationNameOStateParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_oSituationName_1_0=ruleoState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"oSituationName",
                    							lv_oSituationName_1_0,
                    							"org.xtext.example.symg.Symg.oState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:1966:4: ( (lv_cSituationName_2_0= rulecState ) )
                    {
                    // InternalSymg.g:1966:4: ( (lv_cSituationName_2_0= rulecState ) )
                    // InternalSymg.g:1967:5: (lv_cSituationName_2_0= rulecState )
                    {
                    // InternalSymg.g:1967:5: (lv_cSituationName_2_0= rulecState )
                    // InternalSymg.g:1968:6: lv_cSituationName_2_0= rulecState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getCSituationNameCStateParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_cSituationName_2_0=rulecState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"cSituationName",
                    							lv_cSituationName_2_0,
                    							"org.xtext.example.symg.Symg.cState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:1986:4: ( (lv_pSituationName_3_0= rulepState ) )
                    {
                    // InternalSymg.g:1986:4: ( (lv_pSituationName_3_0= rulepState ) )
                    // InternalSymg.g:1987:5: (lv_pSituationName_3_0= rulepState )
                    {
                    // InternalSymg.g:1987:5: (lv_pSituationName_3_0= rulepState )
                    // InternalSymg.g:1988:6: lv_pSituationName_3_0= rulepState
                    {

                    						newCompositeNode(grammarAccess.getSitPropAccess().getPSituationNamePStateParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_pSituationName_3_0=rulepState();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSitPropRule());
                    						}
                    						set(
                    							current,
                    							"pSituationName",
                    							lv_pSituationName_3_0,
                    							"org.xtext.example.symg.Symg.pState");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_37); 

            			newLeafNode(otherlv_4, grammarAccess.getSitPropAccess().getCommaKeyword_1());
            		
            // InternalSymg.g:2010:3: ( (lv_interval_5_0= ruleInterval ) )
            // InternalSymg.g:2011:4: (lv_interval_5_0= ruleInterval )
            {
            // InternalSymg.g:2011:4: (lv_interval_5_0= ruleInterval )
            // InternalSymg.g:2012:5: lv_interval_5_0= ruleInterval
            {

            					newCompositeNode(grammarAccess.getSitPropAccess().getIntervalIntervalParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_interval_5_0=ruleInterval();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSitPropRule());
            					}
            					set(
            						current,
            						"interval",
            						lv_interval_5_0,
            						"org.xtext.example.symg.Symg.Interval");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSitProp"


    // $ANTLR start "entryRuleEventProp"
    // InternalSymg.g:2033:1: entryRuleEventProp returns [EObject current=null] : iv_ruleEventProp= ruleEventProp EOF ;
    public final EObject entryRuleEventProp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventProp = null;


        try {
            // InternalSymg.g:2033:50: (iv_ruleEventProp= ruleEventProp EOF )
            // InternalSymg.g:2034:2: iv_ruleEventProp= ruleEventProp EOF
            {
             newCompositeNode(grammarAccess.getEventPropRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventProp=ruleEventProp();

            state._fsp--;

             current =iv_ruleEventProp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventProp"


    // $ANTLR start "ruleEventProp"
    // InternalSymg.g:2040:1: ruleEventProp returns [EObject current=null] : ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) ) ;
    public final EObject ruleEventProp() throws RecognitionException {
        EObject current = null;

        Token lv_eventName_0_0=null;
        Token otherlv_4=null;
        EObject lv_oEventName_1_0 = null;

        EObject lv_cEventName_2_0 = null;

        EObject lv_pEventName_3_0 = null;

        EObject lv_point_5_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2046:2: ( ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) ) )
            // InternalSymg.g:2047:2: ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) )
            {
            // InternalSymg.g:2047:2: ( ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) ) )
            // InternalSymg.g:2048:3: ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) ) otherlv_4= ',' ( (lv_point_5_0= rulePoint ) )
            {
            // InternalSymg.g:2048:3: ( ( (lv_eventName_0_0= RULE_ID ) ) | ( (lv_oEventName_1_0= ruleoEvent ) ) | ( (lv_cEventName_2_0= rulecEvent ) ) | ( (lv_pEventName_3_0= rulepEvent ) ) )
            int alt33=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt33=1;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt33=2;
                }
                break;
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                {
                alt33=3;
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalSymg.g:2049:4: ( (lv_eventName_0_0= RULE_ID ) )
                    {
                    // InternalSymg.g:2049:4: ( (lv_eventName_0_0= RULE_ID ) )
                    // InternalSymg.g:2050:5: (lv_eventName_0_0= RULE_ID )
                    {
                    // InternalSymg.g:2050:5: (lv_eventName_0_0= RULE_ID )
                    // InternalSymg.g:2051:6: lv_eventName_0_0= RULE_ID
                    {
                    lv_eventName_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    						newLeafNode(lv_eventName_0_0, grammarAccess.getEventPropAccess().getEventNameIDTerminalRuleCall_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventPropRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"eventName",
                    							lv_eventName_0_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:2068:4: ( (lv_oEventName_1_0= ruleoEvent ) )
                    {
                    // InternalSymg.g:2068:4: ( (lv_oEventName_1_0= ruleoEvent ) )
                    // InternalSymg.g:2069:5: (lv_oEventName_1_0= ruleoEvent )
                    {
                    // InternalSymg.g:2069:5: (lv_oEventName_1_0= ruleoEvent )
                    // InternalSymg.g:2070:6: lv_oEventName_1_0= ruleoEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getOEventNameOEventParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_oEventName_1_0=ruleoEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"oEventName",
                    							lv_oEventName_1_0,
                    							"org.xtext.example.symg.Symg.oEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:2088:4: ( (lv_cEventName_2_0= rulecEvent ) )
                    {
                    // InternalSymg.g:2088:4: ( (lv_cEventName_2_0= rulecEvent ) )
                    // InternalSymg.g:2089:5: (lv_cEventName_2_0= rulecEvent )
                    {
                    // InternalSymg.g:2089:5: (lv_cEventName_2_0= rulecEvent )
                    // InternalSymg.g:2090:6: lv_cEventName_2_0= rulecEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getCEventNameCEventParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_cEventName_2_0=rulecEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"cEventName",
                    							lv_cEventName_2_0,
                    							"org.xtext.example.symg.Symg.cEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:2108:4: ( (lv_pEventName_3_0= rulepEvent ) )
                    {
                    // InternalSymg.g:2108:4: ( (lv_pEventName_3_0= rulepEvent ) )
                    // InternalSymg.g:2109:5: (lv_pEventName_3_0= rulepEvent )
                    {
                    // InternalSymg.g:2109:5: (lv_pEventName_3_0= rulepEvent )
                    // InternalSymg.g:2110:6: lv_pEventName_3_0= rulepEvent
                    {

                    						newCompositeNode(grammarAccess.getEventPropAccess().getPEventNamePEventParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_pEventName_3_0=rulepEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventPropRule());
                    						}
                    						set(
                    							current,
                    							"pEventName",
                    							lv_pEventName_3_0,
                    							"org.xtext.example.symg.Symg.pEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_38); 

            			newLeafNode(otherlv_4, grammarAccess.getEventPropAccess().getCommaKeyword_1());
            		
            // InternalSymg.g:2132:3: ( (lv_point_5_0= rulePoint ) )
            // InternalSymg.g:2133:4: (lv_point_5_0= rulePoint )
            {
            // InternalSymg.g:2133:4: (lv_point_5_0= rulePoint )
            // InternalSymg.g:2134:5: lv_point_5_0= rulePoint
            {

            					newCompositeNode(grammarAccess.getEventPropAccess().getPointPointParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_point_5_0=rulePoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEventPropRule());
            					}
            					set(
            						current,
            						"point",
            						lv_point_5_0,
            						"org.xtext.example.symg.Symg.Point");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventProp"


    // $ANTLR start "entryRuleInterval"
    // InternalSymg.g:2155:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalSymg.g:2155:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalSymg.g:2156:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalSymg.g:2162:1: ruleInterval returns [EObject current=null] : ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_unnamed_6_0=null;
        EObject lv_situationName_0_0 = null;

        EObject lv_start_2_0 = null;

        EObject lv_end_4_0 = null;

        EObject lv_situationName_7_0 = null;

        AntlrDatatypeRuleToken lv_tempOp_8_0 = null;

        EObject lv_intConst_9_0 = null;

        AntlrDatatypeRuleToken lv_unit_10_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2168:2: ( ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) ) )
            // InternalSymg.g:2169:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )
            {
            // InternalSymg.g:2169:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )
            int alt34=4;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // InternalSymg.g:2170:3: ( (lv_situationName_0_0= ruleSitName ) )
                    {
                    // InternalSymg.g:2170:3: ( (lv_situationName_0_0= ruleSitName ) )
                    // InternalSymg.g:2171:4: (lv_situationName_0_0= ruleSitName )
                    {
                    // InternalSymg.g:2171:4: (lv_situationName_0_0= ruleSitName )
                    // InternalSymg.g:2172:5: lv_situationName_0_0= ruleSitName
                    {

                    					newCompositeNode(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_situationName_0_0=ruleSitName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIntervalRule());
                    					}
                    					set(
                    						current,
                    						"situationName",
                    						lv_situationName_0_0,
                    						"org.xtext.example.symg.Symg.SitName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:2190:3: (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' )
                    {
                    // InternalSymg.g:2190:3: (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' )
                    // InternalSymg.g:2191:4: otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_38); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntervalAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalSymg.g:2195:4: ( (lv_start_2_0= rulePoint ) )
                    // InternalSymg.g:2196:5: (lv_start_2_0= rulePoint )
                    {
                    // InternalSymg.g:2196:5: (lv_start_2_0= rulePoint )
                    // InternalSymg.g:2197:6: lv_start_2_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getStartPointParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_start_2_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"start",
                    							lv_start_2_0,
                    							"org.xtext.example.symg.Symg.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,16,FOLLOW_38); 

                    				newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getCommaKeyword_1_2());
                    			
                    // InternalSymg.g:2218:4: ( (lv_end_4_0= rulePoint ) )
                    // InternalSymg.g:2219:5: (lv_end_4_0= rulePoint )
                    {
                    // InternalSymg.g:2219:5: (lv_end_4_0= rulePoint )
                    // InternalSymg.g:2220:6: lv_end_4_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getEndPointParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_end_4_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"end",
                    							lv_end_4_0,
                    							"org.xtext.example.symg.Symg.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,51,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntervalAccess().getRightSquareBracketKeyword_1_4());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:2243:3: ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) )
                    {
                    // InternalSymg.g:2243:3: ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) )
                    // InternalSymg.g:2244:4: (lv_unnamed_6_0= 'UNNAMED_INTERVAL' )
                    {
                    // InternalSymg.g:2244:4: (lv_unnamed_6_0= 'UNNAMED_INTERVAL' )
                    // InternalSymg.g:2245:5: lv_unnamed_6_0= 'UNNAMED_INTERVAL'
                    {
                    lv_unnamed_6_0=(Token)match(input,52,FOLLOW_2); 

                    					newLeafNode(lv_unnamed_6_0, grammarAccess.getIntervalAccess().getUnnamedUNNAMED_INTERVALKeyword_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntervalRule());
                    					}
                    					setWithLastConsumed(current, "unnamed", lv_unnamed_6_0, "UNNAMED_INTERVAL");
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:2258:3: ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) )
                    {
                    // InternalSymg.g:2258:3: ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) )
                    // InternalSymg.g:2259:4: ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) )
                    {
                    // InternalSymg.g:2259:4: ( (lv_situationName_7_0= ruleSitName ) )
                    // InternalSymg.g:2260:5: (lv_situationName_7_0= ruleSitName )
                    {
                    // InternalSymg.g:2260:5: (lv_situationName_7_0= ruleSitName )
                    // InternalSymg.g:2261:6: lv_situationName_7_0= ruleSitName
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getSituationNameSitNameParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_situationName_7_0=ruleSitName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"situationName",
                    							lv_situationName_7_0,
                    							"org.xtext.example.symg.Symg.SitName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2278:4: ( (lv_tempOp_8_0= ruleTempOp ) )
                    // InternalSymg.g:2279:5: (lv_tempOp_8_0= ruleTempOp )
                    {
                    // InternalSymg.g:2279:5: (lv_tempOp_8_0= ruleTempOp )
                    // InternalSymg.g:2280:6: lv_tempOp_8_0= ruleTempOp
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getTempOpTempOpParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_tempOp_8_0=ruleTempOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"tempOp",
                    							lv_tempOp_8_0,
                    							"org.xtext.example.symg.Symg.TempOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2297:4: ( (lv_intConst_9_0= ruleIntConst ) )
                    // InternalSymg.g:2298:5: (lv_intConst_9_0= ruleIntConst )
                    {
                    // InternalSymg.g:2298:5: (lv_intConst_9_0= ruleIntConst )
                    // InternalSymg.g:2299:6: lv_intConst_9_0= ruleIntConst
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getIntConstIntConstParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_intConst_9_0=ruleIntConst();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"intConst",
                    							lv_intConst_9_0,
                    							"org.xtext.example.symg.Symg.IntConst");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2316:4: ( (lv_unit_10_0= ruleUnit ) )
                    // InternalSymg.g:2317:5: (lv_unit_10_0= ruleUnit )
                    {
                    // InternalSymg.g:2317:5: (lv_unit_10_0= ruleUnit )
                    // InternalSymg.g:2318:6: lv_unit_10_0= ruleUnit
                    {

                    						newCompositeNode(grammarAccess.getIntervalAccess().getUnitUnitParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_unit_10_0=ruleUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalRule());
                    						}
                    						set(
                    							current,
                    							"unit",
                    							lv_unit_10_0,
                    							"org.xtext.example.symg.Symg.Unit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleSitName"
    // InternalSymg.g:2340:1: entryRuleSitName returns [EObject current=null] : iv_ruleSitName= ruleSitName EOF ;
    public final EObject entryRuleSitName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSitName = null;


        try {
            // InternalSymg.g:2340:48: (iv_ruleSitName= ruleSitName EOF )
            // InternalSymg.g:2341:2: iv_ruleSitName= ruleSitName EOF
            {
             newCompositeNode(grammarAccess.getSitNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSitName=ruleSitName();

            state._fsp--;

             current =iv_ruleSitName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSitName"


    // $ANTLR start "ruleSitName"
    // InternalSymg.g:2347:1: ruleSitName returns [EObject current=null] : ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) ) ;
    public final EObject ruleSitName() throws RecognitionException {
        EObject current = null;

        Token lv_SitName_0_0=null;
        EObject lv_oState_1_0 = null;

        EObject lv_pState_2_0 = null;

        EObject lv_cState_3_0 = null;

        EObject lv_oEvent_4_0 = null;

        EObject lv_cEvent_5_0 = null;

        EObject lv_pEvent_6_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2353:2: ( ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) ) )
            // InternalSymg.g:2354:2: ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) )
            {
            // InternalSymg.g:2354:2: ( ( (lv_SitName_0_0= RULE_ID ) ) | ( (lv_oState_1_0= ruleoState ) ) | ( (lv_pState_2_0= rulepState ) ) | ( (lv_cState_3_0= rulecState ) ) | ( (lv_oEvent_4_0= ruleoEvent ) ) | ( (lv_cEvent_5_0= rulecEvent ) ) | ( (lv_pEvent_6_0= rulepEvent ) ) )
            int alt35=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt35=1;
                }
                break;
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
                {
                alt35=2;
                }
                break;
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt35=3;
                }
                break;
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                {
                alt35=4;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                {
                alt35=5;
                }
                break;
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
                {
                alt35=6;
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                {
                alt35=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSymg.g:2355:3: ( (lv_SitName_0_0= RULE_ID ) )
                    {
                    // InternalSymg.g:2355:3: ( (lv_SitName_0_0= RULE_ID ) )
                    // InternalSymg.g:2356:4: (lv_SitName_0_0= RULE_ID )
                    {
                    // InternalSymg.g:2356:4: (lv_SitName_0_0= RULE_ID )
                    // InternalSymg.g:2357:5: lv_SitName_0_0= RULE_ID
                    {
                    lv_SitName_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					newLeafNode(lv_SitName_0_0, grammarAccess.getSitNameAccess().getSitNameIDTerminalRuleCall_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSitNameRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"SitName",
                    						lv_SitName_0_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:2374:3: ( (lv_oState_1_0= ruleoState ) )
                    {
                    // InternalSymg.g:2374:3: ( (lv_oState_1_0= ruleoState ) )
                    // InternalSymg.g:2375:4: (lv_oState_1_0= ruleoState )
                    {
                    // InternalSymg.g:2375:4: (lv_oState_1_0= ruleoState )
                    // InternalSymg.g:2376:5: lv_oState_1_0= ruleoState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getOStateOStateParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_oState_1_0=ruleoState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"oState",
                    						lv_oState_1_0,
                    						"org.xtext.example.symg.Symg.oState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:2394:3: ( (lv_pState_2_0= rulepState ) )
                    {
                    // InternalSymg.g:2394:3: ( (lv_pState_2_0= rulepState ) )
                    // InternalSymg.g:2395:4: (lv_pState_2_0= rulepState )
                    {
                    // InternalSymg.g:2395:4: (lv_pState_2_0= rulepState )
                    // InternalSymg.g:2396:5: lv_pState_2_0= rulepState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getPStatePStateParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pState_2_0=rulepState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"pState",
                    						lv_pState_2_0,
                    						"org.xtext.example.symg.Symg.pState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:2414:3: ( (lv_cState_3_0= rulecState ) )
                    {
                    // InternalSymg.g:2414:3: ( (lv_cState_3_0= rulecState ) )
                    // InternalSymg.g:2415:4: (lv_cState_3_0= rulecState )
                    {
                    // InternalSymg.g:2415:4: (lv_cState_3_0= rulecState )
                    // InternalSymg.g:2416:5: lv_cState_3_0= rulecState
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getCStateCStateParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cState_3_0=rulecState();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"cState",
                    						lv_cState_3_0,
                    						"org.xtext.example.symg.Symg.cState");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSymg.g:2434:3: ( (lv_oEvent_4_0= ruleoEvent ) )
                    {
                    // InternalSymg.g:2434:3: ( (lv_oEvent_4_0= ruleoEvent ) )
                    // InternalSymg.g:2435:4: (lv_oEvent_4_0= ruleoEvent )
                    {
                    // InternalSymg.g:2435:4: (lv_oEvent_4_0= ruleoEvent )
                    // InternalSymg.g:2436:5: lv_oEvent_4_0= ruleoEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getOEventOEventParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_oEvent_4_0=ruleoEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"oEvent",
                    						lv_oEvent_4_0,
                    						"org.xtext.example.symg.Symg.oEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSymg.g:2454:3: ( (lv_cEvent_5_0= rulecEvent ) )
                    {
                    // InternalSymg.g:2454:3: ( (lv_cEvent_5_0= rulecEvent ) )
                    // InternalSymg.g:2455:4: (lv_cEvent_5_0= rulecEvent )
                    {
                    // InternalSymg.g:2455:4: (lv_cEvent_5_0= rulecEvent )
                    // InternalSymg.g:2456:5: lv_cEvent_5_0= rulecEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getCEventCEventParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_cEvent_5_0=rulecEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"cEvent",
                    						lv_cEvent_5_0,
                    						"org.xtext.example.symg.Symg.cEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalSymg.g:2474:3: ( (lv_pEvent_6_0= rulepEvent ) )
                    {
                    // InternalSymg.g:2474:3: ( (lv_pEvent_6_0= rulepEvent ) )
                    // InternalSymg.g:2475:4: (lv_pEvent_6_0= rulepEvent )
                    {
                    // InternalSymg.g:2475:4: (lv_pEvent_6_0= rulepEvent )
                    // InternalSymg.g:2476:5: lv_pEvent_6_0= rulepEvent
                    {

                    					newCompositeNode(grammarAccess.getSitNameAccess().getPEventPEventParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pEvent_6_0=rulepEvent();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSitNameRule());
                    					}
                    					set(
                    						current,
                    						"pEvent",
                    						lv_pEvent_6_0,
                    						"org.xtext.example.symg.Symg.pEvent");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSitName"


    // $ANTLR start "entryRuleUnit"
    // InternalSymg.g:2497:1: entryRuleUnit returns [String current=null] : iv_ruleUnit= ruleUnit EOF ;
    public final String entryRuleUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnit = null;


        try {
            // InternalSymg.g:2497:44: (iv_ruleUnit= ruleUnit EOF )
            // InternalSymg.g:2498:2: iv_ruleUnit= ruleUnit EOF
            {
             newCompositeNode(grammarAccess.getUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;

             current =iv_ruleUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // InternalSymg.g:2504:1: ruleUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' ) ;
    public final AntlrDatatypeRuleToken ruleUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:2510:2: ( (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' ) )
            // InternalSymg.g:2511:2: (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' )
            {
            // InternalSymg.g:2511:2: (kw= 'SECONDS' | kw= 'MINUTES' | kw= 'HOURS' | kw= 'DAYS' | kw= 'WEEKS' | kw= 'MONTHS' | kw= 'QUARTERS' | kw= 'YEARS' )
            int alt36=8;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt36=1;
                }
                break;
            case 54:
                {
                alt36=2;
                }
                break;
            case 55:
                {
                alt36=3;
                }
                break;
            case 56:
                {
                alt36=4;
                }
                break;
            case 57:
                {
                alt36=5;
                }
                break;
            case 58:
                {
                alt36=6;
                }
                break;
            case 59:
                {
                alt36=7;
                }
                break;
            case 60:
                {
                alt36=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalSymg.g:2512:3: kw= 'SECONDS'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getSECONDSKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:2518:3: kw= 'MINUTES'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getMINUTESKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:2524:3: kw= 'HOURS'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getHOURSKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:2530:3: kw= 'DAYS'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getDAYSKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:2536:3: kw= 'WEEKS'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getWEEKSKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:2542:3: kw= 'MONTHS'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getMONTHSKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymg.g:2548:3: kw= 'QUARTERS'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getQUARTERSKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymg.g:2554:3: kw= 'YEARS'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnitAccess().getYEARSKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleIntConst"
    // InternalSymg.g:2563:1: entryRuleIntConst returns [EObject current=null] : iv_ruleIntConst= ruleIntConst EOF ;
    public final EObject entryRuleIntConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntConst = null;


        try {
            // InternalSymg.g:2563:49: (iv_ruleIntConst= ruleIntConst EOF )
            // InternalSymg.g:2564:2: iv_ruleIntConst= ruleIntConst EOF
            {
             newCompositeNode(grammarAccess.getIntConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntConst=ruleIntConst();

            state._fsp--;

             current =iv_ruleIntConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntConst"


    // $ANTLR start "ruleIntConst"
    // InternalSymg.g:2570:1: ruleIntConst returns [EObject current=null] : ( () ( (lv_Type_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntConst() throws RecognitionException {
        EObject current = null;

        Token lv_Type_1_0=null;


        	enterRule();

        try {
            // InternalSymg.g:2576:2: ( ( () ( (lv_Type_1_0= RULE_INT ) ) ) )
            // InternalSymg.g:2577:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            {
            // InternalSymg.g:2577:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            // InternalSymg.g:2578:3: () ( (lv_Type_1_0= RULE_INT ) )
            {
            // InternalSymg.g:2578:3: ()
            // InternalSymg.g:2579:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntConstAccess().getIntConstAction_0(),
            					current);
            			

            }

            // InternalSymg.g:2585:3: ( (lv_Type_1_0= RULE_INT ) )
            // InternalSymg.g:2586:4: (lv_Type_1_0= RULE_INT )
            {
            // InternalSymg.g:2586:4: (lv_Type_1_0= RULE_INT )
            // InternalSymg.g:2587:5: lv_Type_1_0= RULE_INT
            {
            lv_Type_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_Type_1_0, grammarAccess.getIntConstAccess().getTypeINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"Type",
            						lv_Type_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntConst"


    // $ANTLR start "entryRuleTempOp"
    // InternalSymg.g:2607:1: entryRuleTempOp returns [String current=null] : iv_ruleTempOp= ruleTempOp EOF ;
    public final String entryRuleTempOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTempOp = null;


        try {
            // InternalSymg.g:2607:46: (iv_ruleTempOp= ruleTempOp EOF )
            // InternalSymg.g:2608:2: iv_ruleTempOp= ruleTempOp EOF
            {
             newCompositeNode(grammarAccess.getTempOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTempOp=ruleTempOp();

            state._fsp--;

             current =iv_ruleTempOp.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTempOp"


    // $ANTLR start "ruleTempOp"
    // InternalSymg.g:2614:1: ruleTempOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleTempOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:2620:2: ( (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' ) )
            // InternalSymg.g:2621:2: (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' )
            {
            // InternalSymg.g:2621:2: (kw= 'BEFORE' | kw= 'AFTER' | kw= 'AT' | kw= 'WITHIN' | kw= '+' | kw= '-' )
            int alt37=6;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt37=1;
                }
                break;
            case 62:
                {
                alt37=2;
                }
                break;
            case 63:
                {
                alt37=3;
                }
                break;
            case 64:
                {
                alt37=4;
                }
                break;
            case 65:
                {
                alt37=5;
                }
                break;
            case 66:
                {
                alt37=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalSymg.g:2622:3: kw= 'BEFORE'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getBEFOREKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:2628:3: kw= 'AFTER'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getAFTERKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:2634:3: kw= 'AT'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getATKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:2640:3: kw= 'WITHIN'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getWITHINKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:2646:3: kw= '+'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getPlusSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:2652:3: kw= '-'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTempOpAccess().getHyphenMinusKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTempOp"


    // $ANTLR start "entryRulePoint"
    // InternalSymg.g:2661:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalSymg.g:2661:46: (iv_rulePoint= rulePoint EOF )
            // InternalSymg.g:2662:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalSymg.g:2668:1: rulePoint returns [EObject current=null] : ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        Token lv_unnamed_1_0=null;
        EObject lv_eventName_0_0 = null;

        EObject lv_pointConst_2_0 = null;

        EObject lv_pointConst_3_0 = null;

        AntlrDatatypeRuleToken lv_unit_4_0 = null;

        AntlrDatatypeRuleToken lv_tempOp_5_0 = null;

        EObject lv_eventName_6_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2674:2: ( ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) ) )
            // InternalSymg.g:2675:2: ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) )
            {
            // InternalSymg.g:2675:2: ( ( (lv_eventName_0_0= ruleSitName ) ) | ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) ) | ( (lv_pointConst_2_0= rulePointConst ) ) | ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) ) )
            int alt38=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                {
                alt38=1;
                }
                break;
            case 67:
                {
                alt38=2;
                }
                break;
            case RULE_INT:
                {
                int LA38_3 = input.LA(2);

                if ( ((LA38_3>=53 && LA38_3<=60)) ) {
                    alt38=4;
                }
                else if ( (LA38_3==EOF||(LA38_3>=16 && LA38_3<=17)||LA38_3==47||LA38_3==51) ) {
                    alt38=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalSymg.g:2676:3: ( (lv_eventName_0_0= ruleSitName ) )
                    {
                    // InternalSymg.g:2676:3: ( (lv_eventName_0_0= ruleSitName ) )
                    // InternalSymg.g:2677:4: (lv_eventName_0_0= ruleSitName )
                    {
                    // InternalSymg.g:2677:4: (lv_eventName_0_0= ruleSitName )
                    // InternalSymg.g:2678:5: lv_eventName_0_0= ruleSitName
                    {

                    					newCompositeNode(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_eventName_0_0=ruleSitName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPointRule());
                    					}
                    					set(
                    						current,
                    						"eventName",
                    						lv_eventName_0_0,
                    						"org.xtext.example.symg.Symg.SitName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSymg.g:2696:3: ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) )
                    {
                    // InternalSymg.g:2696:3: ( (lv_unnamed_1_0= 'UNNAMED_POINT' ) )
                    // InternalSymg.g:2697:4: (lv_unnamed_1_0= 'UNNAMED_POINT' )
                    {
                    // InternalSymg.g:2697:4: (lv_unnamed_1_0= 'UNNAMED_POINT' )
                    // InternalSymg.g:2698:5: lv_unnamed_1_0= 'UNNAMED_POINT'
                    {
                    lv_unnamed_1_0=(Token)match(input,67,FOLLOW_2); 

                    					newLeafNode(lv_unnamed_1_0, grammarAccess.getPointAccess().getUnnamedUNNAMED_POINTKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPointRule());
                    					}
                    					setWithLastConsumed(current, "unnamed", lv_unnamed_1_0, "UNNAMED_POINT");
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSymg.g:2711:3: ( (lv_pointConst_2_0= rulePointConst ) )
                    {
                    // InternalSymg.g:2711:3: ( (lv_pointConst_2_0= rulePointConst ) )
                    // InternalSymg.g:2712:4: (lv_pointConst_2_0= rulePointConst )
                    {
                    // InternalSymg.g:2712:4: (lv_pointConst_2_0= rulePointConst )
                    // InternalSymg.g:2713:5: lv_pointConst_2_0= rulePointConst
                    {

                    					newCompositeNode(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pointConst_2_0=rulePointConst();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPointRule());
                    					}
                    					set(
                    						current,
                    						"pointConst",
                    						lv_pointConst_2_0,
                    						"org.xtext.example.symg.Symg.PointConst");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSymg.g:2731:3: ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) )
                    {
                    // InternalSymg.g:2731:3: ( ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) ) )
                    // InternalSymg.g:2732:4: ( (lv_pointConst_3_0= rulePointConst ) ) ( (lv_unit_4_0= ruleUnit ) ) ( (lv_tempOp_5_0= ruleTempOp ) ) ( (lv_eventName_6_0= ruleSitName ) )
                    {
                    // InternalSymg.g:2732:4: ( (lv_pointConst_3_0= rulePointConst ) )
                    // InternalSymg.g:2733:5: (lv_pointConst_3_0= rulePointConst )
                    {
                    // InternalSymg.g:2733:5: (lv_pointConst_3_0= rulePointConst )
                    // InternalSymg.g:2734:6: lv_pointConst_3_0= rulePointConst
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getPointConstPointConstParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_pointConst_3_0=rulePointConst();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"pointConst",
                    							lv_pointConst_3_0,
                    							"org.xtext.example.symg.Symg.PointConst");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2751:4: ( (lv_unit_4_0= ruleUnit ) )
                    // InternalSymg.g:2752:5: (lv_unit_4_0= ruleUnit )
                    {
                    // InternalSymg.g:2752:5: (lv_unit_4_0= ruleUnit )
                    // InternalSymg.g:2753:6: lv_unit_4_0= ruleUnit
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getUnitUnitParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_40);
                    lv_unit_4_0=ruleUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"unit",
                    							lv_unit_4_0,
                    							"org.xtext.example.symg.Symg.Unit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2770:4: ( (lv_tempOp_5_0= ruleTempOp ) )
                    // InternalSymg.g:2771:5: (lv_tempOp_5_0= ruleTempOp )
                    {
                    // InternalSymg.g:2771:5: (lv_tempOp_5_0= ruleTempOp )
                    // InternalSymg.g:2772:6: lv_tempOp_5_0= ruleTempOp
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getTempOpTempOpParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_tempOp_5_0=ruleTempOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"tempOp",
                    							lv_tempOp_5_0,
                    							"org.xtext.example.symg.Symg.TempOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSymg.g:2789:4: ( (lv_eventName_6_0= ruleSitName ) )
                    // InternalSymg.g:2790:5: (lv_eventName_6_0= ruleSitName )
                    {
                    // InternalSymg.g:2790:5: (lv_eventName_6_0= ruleSitName )
                    // InternalSymg.g:2791:6: lv_eventName_6_0= ruleSitName
                    {

                    						newCompositeNode(grammarAccess.getPointAccess().getEventNameSitNameParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_eventName_6_0=ruleSitName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointRule());
                    						}
                    						set(
                    							current,
                    							"eventName",
                    							lv_eventName_6_0,
                    							"org.xtext.example.symg.Symg.SitName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRulepEvent"
    // InternalSymg.g:2813:1: entryRulepEvent returns [EObject current=null] : iv_rulepEvent= rulepEvent EOF ;
    public final EObject entryRulepEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepEvent = null;


        try {
            // InternalSymg.g:2813:47: (iv_rulepEvent= rulepEvent EOF )
            // InternalSymg.g:2814:2: iv_rulepEvent= rulepEvent EOF
            {
             newCompositeNode(grammarAccess.getPEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulepEvent=rulepEvent();

            state._fsp--;

             current =iv_rulepEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepEvent"


    // $ANTLR start "rulepEvent"
    // InternalSymg.g:2820:1: rulepEvent returns [EObject current=null] : ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulepEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_powName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_powEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2826:2: ( ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:2827:2: ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:2827:2: ( ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:2828:3: ( (lv_powEvent_0_0= rulePowEvent ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:2828:3: ( (lv_powEvent_0_0= rulePowEvent ) )
            // InternalSymg.g:2829:4: (lv_powEvent_0_0= rulePowEvent )
            {
            // InternalSymg.g:2829:4: (lv_powEvent_0_0= rulePowEvent )
            // InternalSymg.g:2830:5: lv_powEvent_0_0= rulePowEvent
            {

            					newCompositeNode(grammarAccess.getPEventAccess().getPowEventPowEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_powEvent_0_0=rulePowEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPEventRule());
            					}
            					set(
            						current,
            						"powEvent",
            						lv_powEvent_0_0,
            						"org.xtext.example.symg.Symg.PowEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:2851:3: ( (lv_powName_2_0= RULE_ID ) )
            // InternalSymg.g:2852:4: (lv_powName_2_0= RULE_ID )
            {
            // InternalSymg.g:2852:4: (lv_powName_2_0= RULE_ID )
            // InternalSymg.g:2853:5: lv_powName_2_0= RULE_ID
            {
            lv_powName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_powName_2_0, grammarAccess.getPEventAccess().getPowNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"powName",
            						lv_powName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepEvent"


    // $ANTLR start "entryRulePowEvent"
    // InternalSymg.g:2877:1: entryRulePowEvent returns [String current=null] : iv_rulePowEvent= rulePowEvent EOF ;
    public final String entryRulePowEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowEvent = null;


        try {
            // InternalSymg.g:2877:48: (iv_rulePowEvent= rulePowEvent EOF )
            // InternalSymg.g:2878:2: iv_rulePowEvent= rulePowEvent EOF
            {
             newCompositeNode(grammarAccess.getPowEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowEvent=rulePowEvent();

            state._fsp--;

             current =iv_rulePowEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowEvent"


    // $ANTLR start "rulePowEvent"
    // InternalSymg.g:2884:1: rulePowEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' ) ;
    public final AntlrDatatypeRuleToken rulePowEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:2890:2: ( (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' ) )
            // InternalSymg.g:2891:2: (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' )
            {
            // InternalSymg.g:2891:2: (kw= 'pTRIGGERED' | kw= 'pACTIVATED' | kw= 'pSUSPENDED' | kw= 'pRESUMED' | kw= 'pEXERTED' | kw= 'pEXPIRED' | kw= 'pTERMINATED' )
            int alt39=7;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt39=1;
                }
                break;
            case 69:
                {
                alt39=2;
                }
                break;
            case 70:
                {
                alt39=3;
                }
                break;
            case 71:
                {
                alt39=4;
                }
                break;
            case 72:
                {
                alt39=5;
                }
                break;
            case 73:
                {
                alt39=6;
                }
                break;
            case 74:
                {
                alt39=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalSymg.g:2892:3: kw= 'pTRIGGERED'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPTRIGGEREDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:2898:3: kw= 'pACTIVATED'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPACTIVATEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:2904:3: kw= 'pSUSPENDED'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPSUSPENDEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:2910:3: kw= 'pRESUMED'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPRESUMEDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:2916:3: kw= 'pEXERTED'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPEXERTEDKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:2922:3: kw= 'pEXPIRED'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPEXPIREDKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymg.g:2928:3: kw= 'pTERMINATED'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowEventAccess().getPTERMINATEDKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowEvent"


    // $ANTLR start "entryRulecEvent"
    // InternalSymg.g:2937:1: entryRulecEvent returns [EObject current=null] : iv_rulecEvent= rulecEvent EOF ;
    public final EObject entryRulecEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecEvent = null;


        try {
            // InternalSymg.g:2937:47: (iv_rulecEvent= rulecEvent EOF )
            // InternalSymg.g:2938:2: iv_rulecEvent= rulecEvent EOF
            {
             newCompositeNode(grammarAccess.getCEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecEvent=rulecEvent();

            state._fsp--;

             current =iv_rulecEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecEvent"


    // $ANTLR start "rulecEvent"
    // InternalSymg.g:2944:1: rulecEvent returns [EObject current=null] : ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulecEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_contrName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_contrEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:2950:2: ( ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:2951:2: ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:2951:2: ( ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:2952:3: ( (lv_contrEvent_0_0= ruleContrEvent ) ) otherlv_1= '(' ( (lv_contrName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:2952:3: ( (lv_contrEvent_0_0= ruleContrEvent ) )
            // InternalSymg.g:2953:4: (lv_contrEvent_0_0= ruleContrEvent )
            {
            // InternalSymg.g:2953:4: (lv_contrEvent_0_0= ruleContrEvent )
            // InternalSymg.g:2954:5: lv_contrEvent_0_0= ruleContrEvent
            {

            					newCompositeNode(grammarAccess.getCEventAccess().getContrEventContrEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_contrEvent_0_0=ruleContrEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCEventRule());
            					}
            					set(
            						current,
            						"contrEvent",
            						lv_contrEvent_0_0,
            						"org.xtext.example.symg.Symg.ContrEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:2975:3: ( (lv_contrName_2_0= RULE_ID ) )
            // InternalSymg.g:2976:4: (lv_contrName_2_0= RULE_ID )
            {
            // InternalSymg.g:2976:4: (lv_contrName_2_0= RULE_ID )
            // InternalSymg.g:2977:5: lv_contrName_2_0= RULE_ID
            {
            lv_contrName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_contrName_2_0, grammarAccess.getCEventAccess().getContrNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contrName",
            						lv_contrName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecEvent"


    // $ANTLR start "entryRuleContrEvent"
    // InternalSymg.g:3001:1: entryRuleContrEvent returns [String current=null] : iv_ruleContrEvent= ruleContrEvent EOF ;
    public final String entryRuleContrEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContrEvent = null;


        try {
            // InternalSymg.g:3001:50: (iv_ruleContrEvent= ruleContrEvent EOF )
            // InternalSymg.g:3002:2: iv_ruleContrEvent= ruleContrEvent EOF
            {
             newCompositeNode(grammarAccess.getContrEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContrEvent=ruleContrEvent();

            state._fsp--;

             current =iv_ruleContrEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContrEvent"


    // $ANTLR start "ruleContrEvent"
    // InternalSymg.g:3008:1: ruleContrEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' ) ;
    public final AntlrDatatypeRuleToken ruleContrEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:3014:2: ( (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' ) )
            // InternalSymg.g:3015:2: (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' )
            {
            // InternalSymg.g:3015:2: (kw= 'cACTIVATED' | kw= 'cSUSPENDED' | kw= 'cRESUMED' | kw= 'cFULFILLED_ACTIVE_OBLS' | kw= 'cREVOKED_PARTY' | kw= 'cASSIGNED_PARTY' | kw= 'cTERMINATED' )
            int alt40=7;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt40=1;
                }
                break;
            case 76:
                {
                alt40=2;
                }
                break;
            case 77:
                {
                alt40=3;
                }
                break;
            case 78:
                {
                alt40=4;
                }
                break;
            case 79:
                {
                alt40=5;
                }
                break;
            case 80:
                {
                alt40=6;
                }
                break;
            case 81:
                {
                alt40=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalSymg.g:3016:3: kw= 'cACTIVATED'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCACTIVATEDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:3022:3: kw= 'cSUSPENDED'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCSUSPENDEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:3028:3: kw= 'cRESUMED'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCRESUMEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:3034:3: kw= 'cFULFILLED_ACTIVE_OBLS'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCFULFILLED_ACTIVE_OBLSKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:3040:3: kw= 'cREVOKED_PARTY'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCREVOKED_PARTYKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:3046:3: kw= 'cASSIGNED_PARTY'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCASSIGNED_PARTYKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymg.g:3052:3: kw= 'cTERMINATED'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrEventAccess().getCTERMINATEDKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContrEvent"


    // $ANTLR start "entryRuleoEvent"
    // InternalSymg.g:3061:1: entryRuleoEvent returns [EObject current=null] : iv_ruleoEvent= ruleoEvent EOF ;
    public final EObject entryRuleoEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoEvent = null;


        try {
            // InternalSymg.g:3061:47: (iv_ruleoEvent= ruleoEvent EOF )
            // InternalSymg.g:3062:2: iv_ruleoEvent= ruleoEvent EOF
            {
             newCompositeNode(grammarAccess.getOEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleoEvent=ruleoEvent();

            state._fsp--;

             current =iv_ruleoEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleoEvent"


    // $ANTLR start "ruleoEvent"
    // InternalSymg.g:3068:1: ruleoEvent returns [EObject current=null] : ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleoEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_oblName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_oblEvent_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:3074:2: ( ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:3075:2: ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:3075:2: ( ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:3076:3: ( (lv_oblEvent_0_0= ruleOblEvent ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:3076:3: ( (lv_oblEvent_0_0= ruleOblEvent ) )
            // InternalSymg.g:3077:4: (lv_oblEvent_0_0= ruleOblEvent )
            {
            // InternalSymg.g:3077:4: (lv_oblEvent_0_0= ruleOblEvent )
            // InternalSymg.g:3078:5: lv_oblEvent_0_0= ruleOblEvent
            {

            					newCompositeNode(grammarAccess.getOEventAccess().getOblEventOblEventParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_oblEvent_0_0=ruleOblEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOEventRule());
            					}
            					set(
            						current,
            						"oblEvent",
            						lv_oblEvent_0_0,
            						"org.xtext.example.symg.Symg.OblEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOEventAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:3099:3: ( (lv_oblName_2_0= RULE_ID ) )
            // InternalSymg.g:3100:4: (lv_oblName_2_0= RULE_ID )
            {
            // InternalSymg.g:3100:4: (lv_oblName_2_0= RULE_ID )
            // InternalSymg.g:3101:5: lv_oblName_2_0= RULE_ID
            {
            lv_oblName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_oblName_2_0, grammarAccess.getOEventAccess().getOblNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"oblName",
            						lv_oblName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOEventAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleoEvent"


    // $ANTLR start "entryRuleOblEvent"
    // InternalSymg.g:3125:1: entryRuleOblEvent returns [String current=null] : iv_ruleOblEvent= ruleOblEvent EOF ;
    public final String entryRuleOblEvent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOblEvent = null;


        try {
            // InternalSymg.g:3125:48: (iv_ruleOblEvent= ruleOblEvent EOF )
            // InternalSymg.g:3126:2: iv_ruleOblEvent= ruleOblEvent EOF
            {
             newCompositeNode(grammarAccess.getOblEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOblEvent=ruleOblEvent();

            state._fsp--;

             current =iv_ruleOblEvent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOblEvent"


    // $ANTLR start "ruleOblEvent"
    // InternalSymg.g:3132:1: ruleOblEvent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' ) ;
    public final AntlrDatatypeRuleToken ruleOblEvent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:3138:2: ( (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' ) )
            // InternalSymg.g:3139:2: (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' )
            {
            // InternalSymg.g:3139:2: (kw= 'oTRIGGERED' | kw= 'oACTIVATED' | kw= 'oSUSPENDED' | kw= 'oRESUMED' | kw= 'oDISCHARGED' | kw= 'oEXPIRED' | kw= 'oFULFILLED' | kw= 'oVIOLATED' | kw= 'oTERMINATED' )
            int alt41=9;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt41=1;
                }
                break;
            case 83:
                {
                alt41=2;
                }
                break;
            case 84:
                {
                alt41=3;
                }
                break;
            case 85:
                {
                alt41=4;
                }
                break;
            case 86:
                {
                alt41=5;
                }
                break;
            case 87:
                {
                alt41=6;
                }
                break;
            case 88:
                {
                alt41=7;
                }
                break;
            case 89:
                {
                alt41=8;
                }
                break;
            case 90:
                {
                alt41=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalSymg.g:3140:3: kw= 'oTRIGGERED'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOTRIGGEREDKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:3146:3: kw= 'oACTIVATED'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOACTIVATEDKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:3152:3: kw= 'oSUSPENDED'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOSUSPENDEDKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:3158:3: kw= 'oRESUMED'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getORESUMEDKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:3164:3: kw= 'oDISCHARGED'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getODISCHARGEDKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:3170:3: kw= 'oEXPIRED'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOEXPIREDKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymg.g:3176:3: kw= 'oFULFILLED'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOFULFILLEDKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymg.g:3182:3: kw= 'oVIOLATED'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOVIOLATEDKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSymg.g:3188:3: kw= 'oTERMINATED'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblEventAccess().getOTERMINATEDKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOblEvent"


    // $ANTLR start "entryRulePointConst"
    // InternalSymg.g:3197:1: entryRulePointConst returns [EObject current=null] : iv_rulePointConst= rulePointConst EOF ;
    public final EObject entryRulePointConst() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointConst = null;


        try {
            // InternalSymg.g:3197:51: (iv_rulePointConst= rulePointConst EOF )
            // InternalSymg.g:3198:2: iv_rulePointConst= rulePointConst EOF
            {
             newCompositeNode(grammarAccess.getPointConstRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointConst=rulePointConst();

            state._fsp--;

             current =iv_rulePointConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointConst"


    // $ANTLR start "rulePointConst"
    // InternalSymg.g:3204:1: rulePointConst returns [EObject current=null] : ( () ( (lv_Type_1_0= RULE_INT ) ) ) ;
    public final EObject rulePointConst() throws RecognitionException {
        EObject current = null;

        Token lv_Type_1_0=null;


        	enterRule();

        try {
            // InternalSymg.g:3210:2: ( ( () ( (lv_Type_1_0= RULE_INT ) ) ) )
            // InternalSymg.g:3211:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            {
            // InternalSymg.g:3211:2: ( () ( (lv_Type_1_0= RULE_INT ) ) )
            // InternalSymg.g:3212:3: () ( (lv_Type_1_0= RULE_INT ) )
            {
            // InternalSymg.g:3212:3: ()
            // InternalSymg.g:3213:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointConstAccess().getPointConstAction_0(),
            					current);
            			

            }

            // InternalSymg.g:3219:3: ( (lv_Type_1_0= RULE_INT ) )
            // InternalSymg.g:3220:4: (lv_Type_1_0= RULE_INT )
            {
            // InternalSymg.g:3220:4: (lv_Type_1_0= RULE_INT )
            // InternalSymg.g:3221:5: lv_Type_1_0= RULE_INT
            {
            lv_Type_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_Type_1_0, grammarAccess.getPointConstAccess().getTypeINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPointConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"Type",
            						lv_Type_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointConst"


    // $ANTLR start "entryRuleoState"
    // InternalSymg.g:3241:1: entryRuleoState returns [EObject current=null] : iv_ruleoState= ruleoState EOF ;
    public final EObject entryRuleoState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoState = null;


        try {
            // InternalSymg.g:3241:47: (iv_ruleoState= ruleoState EOF )
            // InternalSymg.g:3242:2: iv_ruleoState= ruleoState EOF
            {
             newCompositeNode(grammarAccess.getOStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleoState=ruleoState();

            state._fsp--;

             current =iv_ruleoState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleoState"


    // $ANTLR start "ruleoState"
    // InternalSymg.g:3248:1: ruleoState returns [EObject current=null] : ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleoState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_oblName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_oblState_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:3254:2: ( ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:3255:2: ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:3255:2: ( ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:3256:3: ( (lv_oblState_0_0= ruleOblState ) ) otherlv_1= '(' ( (lv_oblName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:3256:3: ( (lv_oblState_0_0= ruleOblState ) )
            // InternalSymg.g:3257:4: (lv_oblState_0_0= ruleOblState )
            {
            // InternalSymg.g:3257:4: (lv_oblState_0_0= ruleOblState )
            // InternalSymg.g:3258:5: lv_oblState_0_0= ruleOblState
            {

            					newCompositeNode(grammarAccess.getOStateAccess().getOblStateOblStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_oblState_0_0=ruleOblState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOStateRule());
            					}
            					set(
            						current,
            						"oblState",
            						lv_oblState_0_0,
            						"org.xtext.example.symg.Symg.OblState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:3279:3: ( (lv_oblName_2_0= RULE_ID ) )
            // InternalSymg.g:3280:4: (lv_oblName_2_0= RULE_ID )
            {
            // InternalSymg.g:3280:4: (lv_oblName_2_0= RULE_ID )
            // InternalSymg.g:3281:5: lv_oblName_2_0= RULE_ID
            {
            lv_oblName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_oblName_2_0, grammarAccess.getOStateAccess().getOblNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"oblName",
            						lv_oblName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleoState"


    // $ANTLR start "entryRuleOblState"
    // InternalSymg.g:3305:1: entryRuleOblState returns [String current=null] : iv_ruleOblState= ruleOblState EOF ;
    public final String entryRuleOblState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOblState = null;


        try {
            // InternalSymg.g:3305:48: (iv_ruleOblState= ruleOblState EOF )
            // InternalSymg.g:3306:2: iv_ruleOblState= ruleOblState EOF
            {
             newCompositeNode(grammarAccess.getOblStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOblState=ruleOblState();

            state._fsp--;

             current =iv_ruleOblState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOblState"


    // $ANTLR start "ruleOblState"
    // InternalSymg.g:3312:1: ruleOblState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' ) ;
    public final AntlrDatatypeRuleToken ruleOblState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:3318:2: ( (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' ) )
            // InternalSymg.g:3319:2: (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' )
            {
            // InternalSymg.g:3319:2: (kw= 'oCREATE' | kw= 'oINEFFECT' | kw= 'oSUSPENSION' | kw= 'oSUCCESSFUL_TERMINATION' | kw= 'oUNSUCCESSFUL_TERMINATION' | kw= 'oVIOLATION' | kw= 'oFULFILLMENT' | kw= 'oDISCHARGE' )
            int alt42=8;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt42=1;
                }
                break;
            case 92:
                {
                alt42=2;
                }
                break;
            case 93:
                {
                alt42=3;
                }
                break;
            case 94:
                {
                alt42=4;
                }
                break;
            case 95:
                {
                alt42=5;
                }
                break;
            case 96:
                {
                alt42=6;
                }
                break;
            case 97:
                {
                alt42=7;
                }
                break;
            case 98:
                {
                alt42=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalSymg.g:3320:3: kw= 'oCREATE'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOCREATEKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:3326:3: kw= 'oINEFFECT'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:3332:3: kw= 'oSUSPENSION'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:3338:3: kw= 'oSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:3344:3: kw= 'oUNSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOUNSUCCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:3350:3: kw= 'oVIOLATION'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOVIOLATIONKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSymg.g:3356:3: kw= 'oFULFILLMENT'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getOFULFILLMENTKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSymg.g:3362:3: kw= 'oDISCHARGE'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getOblStateAccess().getODISCHARGEKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOblState"


    // $ANTLR start "entryRulecState"
    // InternalSymg.g:3371:1: entryRulecState returns [EObject current=null] : iv_rulecState= rulecState EOF ;
    public final EObject entryRulecState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecState = null;


        try {
            // InternalSymg.g:3371:47: (iv_rulecState= rulecState EOF )
            // InternalSymg.g:3372:2: iv_rulecState= rulecState EOF
            {
             newCompositeNode(grammarAccess.getCStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecState=rulecState();

            state._fsp--;

             current =iv_rulecState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecState"


    // $ANTLR start "rulecState"
    // InternalSymg.g:3378:1: rulecState returns [EObject current=null] : ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulecState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_contractName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_contrState_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:3384:2: ( ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:3385:2: ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:3385:2: ( ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:3386:3: ( (lv_contrState_0_0= ruleContrState ) ) otherlv_1= '(' ( (lv_contractName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:3386:3: ( (lv_contrState_0_0= ruleContrState ) )
            // InternalSymg.g:3387:4: (lv_contrState_0_0= ruleContrState )
            {
            // InternalSymg.g:3387:4: (lv_contrState_0_0= ruleContrState )
            // InternalSymg.g:3388:5: lv_contrState_0_0= ruleContrState
            {

            					newCompositeNode(grammarAccess.getCStateAccess().getContrStateContrStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_contrState_0_0=ruleContrState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCStateRule());
            					}
            					set(
            						current,
            						"contrState",
            						lv_contrState_0_0,
            						"org.xtext.example.symg.Symg.ContrState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:3409:3: ( (lv_contractName_2_0= RULE_ID ) )
            // InternalSymg.g:3410:4: (lv_contractName_2_0= RULE_ID )
            {
            // InternalSymg.g:3410:4: (lv_contractName_2_0= RULE_ID )
            // InternalSymg.g:3411:5: lv_contractName_2_0= RULE_ID
            {
            lv_contractName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_contractName_2_0, grammarAccess.getCStateAccess().getContractNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractName",
            						lv_contractName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecState"


    // $ANTLR start "entryRuleContrState"
    // InternalSymg.g:3435:1: entryRuleContrState returns [String current=null] : iv_ruleContrState= ruleContrState EOF ;
    public final String entryRuleContrState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContrState = null;


        try {
            // InternalSymg.g:3435:50: (iv_ruleContrState= ruleContrState EOF )
            // InternalSymg.g:3436:2: iv_ruleContrState= ruleContrState EOF
            {
             newCompositeNode(grammarAccess.getContrStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContrState=ruleContrState();

            state._fsp--;

             current =iv_ruleContrState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContrState"


    // $ANTLR start "ruleContrState"
    // InternalSymg.g:3442:1: ruleContrState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' ) ;
    public final AntlrDatatypeRuleToken ruleContrState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:3448:2: ( (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' ) )
            // InternalSymg.g:3449:2: (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' )
            {
            // InternalSymg.g:3449:2: (kw= 'cFORM' | kw= 'cINEFFECT' | kw= 'cSUSPENSION' | kw= 'cSUCCESSFUL_TERMINATION' | kw= 'cUNSECCESSFUL_TERMINATION' | kw= 'cUNASSIGN' )
            int alt43=6;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt43=1;
                }
                break;
            case 100:
                {
                alt43=2;
                }
                break;
            case 101:
                {
                alt43=3;
                }
                break;
            case 102:
                {
                alt43=4;
                }
                break;
            case 103:
                {
                alt43=5;
                }
                break;
            case 104:
                {
                alt43=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalSymg.g:3450:3: kw= 'cFORM'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCFORMKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:3456:3: kw= 'cINEFFECT'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:3462:3: kw= 'cSUSPENSION'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:3468:3: kw= 'cSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:3474:3: kw= 'cUNSECCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCUNSECCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSymg.g:3480:3: kw= 'cUNASSIGN'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContrStateAccess().getCUNASSIGNKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContrState"


    // $ANTLR start "entryRulepState"
    // InternalSymg.g:3489:1: entryRulepState returns [EObject current=null] : iv_rulepState= rulepState EOF ;
    public final EObject entryRulepState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulepState = null;


        try {
            // InternalSymg.g:3489:47: (iv_rulepState= rulepState EOF )
            // InternalSymg.g:3490:2: iv_rulepState= rulepState EOF
            {
             newCompositeNode(grammarAccess.getPStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulepState=rulepState();

            state._fsp--;

             current =iv_rulepState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulepState"


    // $ANTLR start "rulepState"
    // InternalSymg.g:3496:1: rulepState returns [EObject current=null] : ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject rulepState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_powName_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_powState_0_0 = null;



        	enterRule();

        try {
            // InternalSymg.g:3502:2: ( ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalSymg.g:3503:2: ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalSymg.g:3503:2: ( ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalSymg.g:3504:3: ( (lv_powState_0_0= rulePowState ) ) otherlv_1= '(' ( (lv_powName_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            // InternalSymg.g:3504:3: ( (lv_powState_0_0= rulePowState ) )
            // InternalSymg.g:3505:4: (lv_powState_0_0= rulePowState )
            {
            // InternalSymg.g:3505:4: (lv_powState_0_0= rulePowState )
            // InternalSymg.g:3506:5: lv_powState_0_0= rulePowState
            {

            					newCompositeNode(grammarAccess.getPStateAccess().getPowStatePowStateParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_powState_0_0=rulePowState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPStateRule());
            					}
            					set(
            						current,
            						"powState",
            						lv_powState_0_0,
            						"org.xtext.example.symg.Symg.PowState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getPStateAccess().getLeftParenthesisKeyword_1());
            		
            // InternalSymg.g:3527:3: ( (lv_powName_2_0= RULE_ID ) )
            // InternalSymg.g:3528:4: (lv_powName_2_0= RULE_ID )
            {
            // InternalSymg.g:3528:4: (lv_powName_2_0= RULE_ID )
            // InternalSymg.g:3529:5: lv_powName_2_0= RULE_ID
            {
            lv_powName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_powName_2_0, grammarAccess.getPStateAccess().getPowNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPStateRule());
            					}
            					setWithLastConsumed(
            						current,
            						"powName",
            						lv_powName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getPStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulepState"


    // $ANTLR start "entryRulePowState"
    // InternalSymg.g:3553:1: entryRulePowState returns [String current=null] : iv_rulePowState= rulePowState EOF ;
    public final String entryRulePowState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowState = null;


        try {
            // InternalSymg.g:3553:48: (iv_rulePowState= rulePowState EOF )
            // InternalSymg.g:3554:2: iv_rulePowState= rulePowState EOF
            {
             newCompositeNode(grammarAccess.getPowStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowState=rulePowState();

            state._fsp--;

             current =iv_rulePowState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowState"


    // $ANTLR start "rulePowState"
    // InternalSymg.g:3560:1: rulePowState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' ) ;
    public final AntlrDatatypeRuleToken rulePowState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSymg.g:3566:2: ( (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' ) )
            // InternalSymg.g:3567:2: (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' )
            {
            // InternalSymg.g:3567:2: (kw= 'pCREATE' | kw= 'pINEFFECT' | kw= 'pSUSPENSION' | kw= 'pSUCCESSFUL_TERMINATION' | kw= 'pUNSUCCESSFUL_TERMINATION' )
            int alt44=5;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt44=1;
                }
                break;
            case 106:
                {
                alt44=2;
                }
                break;
            case 107:
                {
                alt44=3;
                }
                break;
            case 108:
                {
                alt44=4;
                }
                break;
            case 109:
                {
                alt44=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalSymg.g:3568:3: kw= 'pCREATE'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPCREATEKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSymg.g:3574:3: kw= 'pINEFFECT'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPINEFFECTKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSymg.g:3580:3: kw= 'pSUSPENSION'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPSUSPENSIONKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSymg.g:3586:3: kw= 'pSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,108,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPSUCCESSFUL_TERMINATIONKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSymg.g:3592:3: kw= 'pUNSUCCESSFUL_TERMINATION'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowStateAccess().getPUNSUCCESSFUL_TERMINATIONKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowState"

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    protected DFA34 dfa34 = new DFA34(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\3\uffff\11\15\2\uffff";
    static final String dfa_3s = "\1\4\1\34\1\4\11\14\2\uffff";
    static final String dfa_4s = "\1\4\1\34\1\45\11\20\2\uffff";
    static final String dfa_5s = "\14\uffff\1\1\1\2";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2",
            "\1\3\31\uffff\1\11\1\12\1\13\1\4\1\5\1\6\1\7\1\10",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "\1\15\3\uffff\1\14",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 530:4: ( ( (lv_attributes_4_0= ruleAttribute ) ) otherlv_5= ',' )*";
        }
    }
    static final String dfa_8s = "\102\uffff";
    static final String dfa_9s = "\1\uffff\1\56\72\uffff\6\56";
    static final String dfa_10s = "\1\4\1\14\52\17\4\uffff\6\4\6\21\6\14";
    static final String dfa_11s = "\1\155\1\102\52\17\4\uffff\6\4\6\21\6\102";
    static final String dfa_12s = "\54\uffff\1\2\1\3\1\1\1\4\22\uffff";
    static final String dfa_13s = "\102\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\55\uffff\1\54\1\uffff\1\55\17\uffff\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\17\1\20\1\21\1\22\1\23\1\24\1\12\1\13\1\14\1\15\1\16",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
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
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57",
            "\1\56\3\uffff\2\56\25\uffff\1\56\2\uffff\2\56\21\uffff\6\57"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2169:2: ( ( (lv_situationName_0_0= ruleSitName ) ) | (otherlv_1= '[' ( (lv_start_2_0= rulePoint ) ) otherlv_3= ',' ( (lv_end_4_0= rulePoint ) ) otherlv_5= ']' ) | ( (lv_unnamed_6_0= 'UNNAMED_INTERVAL' ) ) | ( ( (lv_situationName_7_0= ruleSitName ) ) ( (lv_tempOp_8_0= ruleTempOp ) ) ( (lv_intConst_9_0= ruleIntConst ) ) ( (lv_unit_10_0= ruleUnit ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000003FC0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000003F80010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0003700003F00030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0003700003E00030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000003C00010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003800010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0003700002000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000003FC0000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0003710000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0003700000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0003720000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000010L,0x00003FFFFFFFFFF0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000010L,0x00003FFFF8000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0014000000000010L,0x00003FFFFFFFFFF0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000030L,0x00003FFFFFFFFFF8L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xE000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x1FE0000000000000L});

}