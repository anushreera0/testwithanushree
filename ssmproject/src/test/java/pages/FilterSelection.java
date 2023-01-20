package pages;

import java.io.*;

import javax.script.*;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;

import tests.testBase;

public class FilterSelection extends testBase{
	public static void main(String[] args) throws Exception {
		 
		 ScriptEngineManager sem = new ScriptEngineManager();
		 java.util.List<ScriptEngineFactory> factories = sem.getEngineFactories();
		 for (ScriptEngineFactory factory : factories)
		     System.out.println(factory.getEngineName() + " " + factory.getEngineVersion() + " " + factory.getNames());
		 if (factories.isEmpty())
		     System.out.println("No Script Engines found");
		 ScriptEngine sem = new ScriptEngineManager().getEngineByName("Nashorn");
		// Bindings bind = ee.getBindings(ScriptContext.ENGINE_SCOPE);  
	      //  bind.put("name", "Nashorn");  
		 ee.eval(new FileReader("C:\\Users\\anushree\\Projects\\testwithanushree\\ssmproject\\src\\test\\java\\pages\\javaScriptPlays.js"));  
		 Invocable invocable = (Invocable)ee;  
		 Object dateString=invocable.invokeFunction("istDate");  
		 System.out.println(dateString);
	}
}
