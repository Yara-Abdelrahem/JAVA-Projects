public class Calc{
	static double calculator(int num1 , int num2 , String symbol){
		double res  = 0.0; 
		switch(symbol){
			case "+":
				res = (double)num1 + num2;
			break;
		
			case "-":
				res = (double)num1 - num2;
			break;
			
			case "x":
				res = (double)num1 * num2;
			break;
						
			case "/":
				res = (double)num1 / num2;
			break;
		}
		return res;
	}
	public static void main(String[] args){
		if(args.length !=3){
			System.out.println("No of args not correct");
			return;
		}else{
			System.out.println(args[0] +" " + args[1] + " "+ args[2]);
			if(args[1].equals("+") || args[1].equals("-")  || args[1].equals("x")  || args[1].equals("/") ){
				
							
			int arg1 = Integer.parseInt(args[0]);
			int arg3 = Integer.parseInt(args[2]);
			double res = calculator(arg1 , arg3 , args[1]);	
			System.out.println("The result = "+ res);
			}else{
				System.out.println("Symbol Not vaild");
				return;
			}
			

		}
	}
}
