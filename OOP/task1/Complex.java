public class Complex{
	private int real;
	private int img;

	public Complex(){
		this.real = 0;
		this.img = 0;
	} 
	public Complex( int real , int img){
		this.real = real;
		this.img = img;
	} 
        public Complex( int num){
                this.real = num;
                this.img = num;
        }

	public void setreal(int real){
		this.real = real;
	}
	public void setimg(int img){
		this.img = img;
	}
	
	public int getreal(){
		return real;
	}
	public int getimg(){
		return img;
	}
	public void print(){
		System.out.println(this.real+"+"+this.img+"i");
	}

}
