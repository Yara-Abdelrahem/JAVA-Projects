abstract class GeoShape{
	private int dim1 ;
	private int dim2 ;
	
	public GeoShape(){
		dim1 = 0;
		dim2 = 0;
	}
	public GeoShape(int num){
		dim1 = num;
		dim2 = num;
	}	public GeoShape(int num1 , int num2){
		dim1 = num1;
		dim2 = num2;
	}
	public void setdim1(int dim1){
		this.dim1 = dim1;
	}
	public void setdim2(int dim2){
		this.dim2 = dim2;
	}
	
	public int getdim1(){
		return dim1;
	}
	public int getdim2(){
		return dim2;
	}
	public abstract double cal_area();
}
class Circle extends GeoShape{
	public Circle(int r){
		super(r);
	}
	public double cal_area(){
		return 3.14*getdim1() * getdim2();
	}
	
}
 class Rectangle extends GeoShape{
	public Rectangle(int dim1 , int dim2){
		super(dim1 , dim2);
	}
	public double cal_area(){
		return getdim1() * getdim2();
	}
}

 class Triangle extends GeoShape{
	public Triangle(int dim1 , int dim2){
		super(dim1 , dim2);
	}
	public double cal_area(){
		return 0.5 * getdim1() * getdim2();
	}
}

public class GeoShapeMain{
	static void clac_combo_area(GeoShape s1 , GeoShape s2 , GeoShape s3){
		double sum =  s1.cal_area() +s2.cal_area() + s3.cal_area();
		        System.out.println("Sum 3 area = " + sum);
	}


public static void main(String[] args){
	GeoShape s1 = new Circle(3);
	GeoShape s2  = new Rectangle (2,3); 
	GeoShape s3 = new Triangle(2,3);
	clac_combo_area(s1 , s2 , s3);

}
}
