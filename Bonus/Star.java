import java.util.Collections;

public class Star{

static void drawSymbols(String s , int count){
	String symbol = String.join("", Collections.nCopies(count , s));
	System.out.print(symbol);
  }
static void drawSymbolsWithSpace(String s , int count){
	String symbol = String.join(" ", Collections.nCopies(count , s));
	System.out.print(symbol);
  }
public static void main(String[] args){
	int nolines = Integer.parseInt(args[0]);
	int n = 3*nolines;
	for(int i = 1; i<=nolines ;i++ ){
		drawSymbols("*",i);
		drawSymbols(" ", nolines-i);
		drawSymbols(" ", nolines);
		drawSymbols(" ", nolines-i);
		drawSymbolsWithSpace("*",i);
		System.out.println();
	}

  }
}
