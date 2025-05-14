
public class Complex_Main{
        public static Complex sum(Complex c1 , Complex c2 ){
                Complex c3 = new Complex();
                c3.setreal(c1.getreal() +c1.getreal());
                c3.setimg(c1.getimg() + c2.getimg());
                return c3;

        }
         public static Complex sub(Complex c1 , Complex c2 ){
                Complex c3 = new Complex();
                c3.setreal(c1.getreal() -c2.getreal());
                c3.setimg(c1.getimg() - c2.getimg());
                return c3;

        }
public static void main(String[] args){
	Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,4);
        System.out.println("Sum");
        Complex c3 =new Complex();
        c3 = sum(c1 , c2);
	c3.print();
        System.out.println("Subtract");
         Complex c4 = new Complex(); 
         c4= sub(c1 , c2);
         c4.print();

	}
}
