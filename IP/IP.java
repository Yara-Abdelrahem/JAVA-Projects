import java.util.StringTokenizer;
public class IP{
	public static void splitString(String ip){
		int j = 0;
		while(j != -1){
			int i = 0 ;
			j = 0;
			j= ip.indexOf(".");
			if (j == -1){
	        	System.out.println(ip);
	        	break;
			}
	        	System.out.println(ip.substring(i,j));
	        	ip = ip.substring(j+1);
		}
	}
	public static void splitString2(String ip){
		int j = ip.indexOf(".");;
		int i = 0 ;
		while(j != -1){
			//j = (ip.substring(i)).indexOf(".");
			j = (ip).indexOf("." , i);
	        	//System.out.println(ip.substring(i));
	        	//System.out.println("i = "+i+" ,  j = "+j);
			if (j == -1){
	        	System.out.println(ip.substring(i));
	        	break;
			}
	        	System.out.println(ip.substring(i,j));
	        	i = j+1;
		}
	}  
	public static void main(String[] args){
		//splitString(args[0]);
   	System.out.println("Split using IndexOf & substring method");		
	splitString2(args[0]);
		
   	System.out.println("Split using StringTokenizer method");
	StringTokenizer s = new StringTokenizer(args[0], ".");
        while (s.hasMoreTokens()) {
            System.out.println(s.nextToken());
        }
       
       // with split method 
   	System.out.println("Split using split method");
	String[] str1 = args[0].split("[.]");
	for (String s2 : str1) {
	  System.out.println(s2);
	}
    }
	
}
