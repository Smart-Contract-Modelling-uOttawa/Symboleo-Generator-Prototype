/*
 * generated by Xtext 2.22.0
 */
package org.xtext.example.symg;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class SymgStandaloneSetup extends SymgStandaloneSetupGenerated {

	public static void doSetup() {
		new SymgStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
