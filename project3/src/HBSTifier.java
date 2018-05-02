class HBSTifier  
{   
  private final static String[] keys =   
     { "abstract",     "assert",       "boolean",     "break",  
		"byte",         "case",         "catch",       "char",  
		"class",        "const",        "continue",    "default",  
 		"do",           "double",       "else",        "extends",  
	  	"false",        "final",        "finally",     "float",  
		"for",          "goto",         "if",          "implements",  
		"import",       "instanceof",   "int",         "interface",  
		"long",         "native",       "new",         "null",
		"package",      "private",      "protected",   "public",  
		"return",       "short",        "static",      "super",  
		"switch",       "synchronized", "this",        "throw",  
		"throws",       "transient",    "true",        "try",  
		"var",          "void",         "volatile",    "while" };
	
	public static void main(String [] args){  
		HBST<String, Integer> hbst = new HBST<String, Integer>();  
		
		for (int index = 0; index < keys.length; index += 1) {  
			hbst.put(keys[index], index);
	    }

		System.out.println(hbst.height());
		for (int index = 0; index < keys.length; index += 1) {
			System.out.format("%02d %s", hbst.get(keys[index]), keys[index]);  
			System.out.println();  
		}  
	}  
}
