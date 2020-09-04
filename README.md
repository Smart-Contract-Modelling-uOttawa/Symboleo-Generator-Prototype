# Symboleo-Generator-Prototype
# How to Install
run the command git clone (URL of this repo).  
In eclipse, import a project from the project folder (Symboleo-Generator-Prototype).  
You're done.  

# How to Use
# When working on the xtext language work with: 
org.xtext.example.symg.symg.xtext
 
# When working on the prolog generator work with: 
org.xtext.example.symg.generator.symgGenerator.xtend
How it works:
The doGenerate function calls a compile function which proceeds to call sub functions to compile sections of the contract (seperated into: domain concepts, contract initialization, declarations, obligations, powers, surviving obligations). All generated code is added to a StringBuilder and at the end of the compile function, the StringBuilders contents are returned.

# When working on validation for the xtext language work with: 
org.xtext.example.symg.validation.symgValidator.java
