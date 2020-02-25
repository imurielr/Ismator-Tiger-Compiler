package co.edu.eafit.dis.st0270.s20181.ismator;

import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;

public class TigerMain {
    public static void usage(){
	System.err.println("MainTiger <file>");
	//System.exit(1);
    }
    
    private static String getType(String t){
	List<String> keywords = Arrays.asList("ARRAY","IF","ELSE","THEN","WHILE","FOR","TO","DO","LET","IN","END","OF","BREAK","NIL","FUNCTION","VAR","TYPE","IMPORT","PRIMITIVE","CLASS","EXTENDS","METHOD","NEW");
	List<String> symbols = Arrays.asList("SUM","RES","TIMES","DIV","COMA","COLON","SEMICOLON","LPAREN","RPAREN","LBRACKET","RBRACKET","LBRACE","RBRACE","DOT","EQUALS","LESS","GREATER","LOE","GOE","AND","OR","ASSIGN","COMP");
	if(keywords.contains(t)){
	    return "keyword";
	}
	else if(symbols.contains(t)){
	    return "symbol";
	}
	else if(t.equals("STRING")){
	    return "string";
	}
	else if(t.equals("ID")){
	    return "id";
	}
	else if(t.equals("INTEGER")){
	    return "number";
	}
	return "No aceptado";
    }
    
    public static void main(String args[]){
	if(args[0].equals("-s") && args[1].equals("-p")){
	    for(int i=2;i < args.length; ++i){
		if(args[i].contains(".tgr")){
		    try{
			TigerLexer scan = new TigerLexer(new FileReader(args[i]));
			TigerParser parser = new TigerParser(scan);
			Symbol t= scan.next_token();
			while(!TigerSymbols.terminalNames[t.sym].equals("EOF")){
			    System.out.println("[ Fila: " + scan.getLine() +
					       ", Columna: " + scan.getColumn() + ", Tipo token: "+getType(TigerSymbols.terminalNames[t.sym])
					       + ", Token string: " + scan.getString()+" ]");
			    t= scan.next_token();
			}
			
			TigerLexer scan2 = new TigerLexer(new FileReader(args[i]));
                        TigerParser parser2 = new TigerParser(scan2);
			parser2.parse();   
			System.out.println("File: "+args[i]+" Parser: true");

		    }
		    catch(FileNotFoundException fnfe){
			usage();
		    }
		    catch(Exception e){
			System.out.println("File: "+args[i]+" Parser: false");
			//System.exit(0);
		    }
		    catch(Error err){
                        System.out.println("File: "+args[i]+" Parser: false");
		    }
		}
		else{
		    usage();
		}
	    }
	} else if(args[0].equals("-s")){
	    for(int i=1;i < args.length; ++i){
		if(args[i].contains(".tgr")){
		    try{
			TigerLexer scan = new TigerLexer(new FileReader(args[i]));
			TigerParser parser = new TigerParser(scan);
			Symbol t= scan.next_token();
			while(!TigerSymbols.terminalNames[t.sym].equals("EOF")){
			    System.out.println("[ Fila: " + scan.getLine() +
					       ", Columna: " + scan.getColumn() + ", Tipo token: "+getType(TigerSymbols.terminalNames[t.sym])
					       + ", Token string: " + scan.getString()+" ]");
			    t= scan.next_token();
			}
		    }
		    catch(FileNotFoundException fnfe){
			usage();
		    }
		    catch(Exception e){
			//System.exit(1);
		    }	    

		}
		else{
		    usage();
		}
	    }

	}else if(args[0].equals("-p")){

	    for(int i=1;i < args.length; ++i){
		if(args[i].contains(".tgr")){
		    try{
			TigerLexer scan = new TigerLexer(new FileReader(args[i]));
			TigerParser parser = new TigerParser(scan);
			parser.parse();
			System.out.println("File: "+args[i]+" Parser: true");
		    }
		    catch(FileNotFoundException fnfe){
			usage();
		    }
		    catch(Exception e){
			System.out.println("File: "+args[i]+" Parser: false");
			//System.exit(1);
		    }
		    catch(Error err){
                        System.out.println("File: "+args[i]+" Parser: false");
		    }
		}
		else{
		    usage();
		}
		    
	    }
		
	}else{
	    for(int i=0;i < args.length; ++i){
		if(args[i].contains(".tgr")){
		    try{
			TigerLexer scan = new TigerLexer(new FileReader(args[i]));
			TigerParser parser = new TigerParser(scan);
			parser.parse();
			System.out.println("File: "+args[i]+" Parser: true");	
		    }
		    catch(FileNotFoundException fnfe){
			usage();
		    }
		    catch(Exception e){
			System.out.println("File: "+args[i]+" Parser: false");
			//System.exit(1);
		    }	    
		    catch(Error err){
			System.out.println("File: "+args[i]+" Parser: false");
		    }
		}
		else{
		    usage();
		}
		    
	    }

	}

    }
}	    


