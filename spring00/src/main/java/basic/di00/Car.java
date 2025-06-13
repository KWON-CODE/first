package basic.di00;

public class Car {
	private Tire tire;
	
	public Car() {
		//tire=new HankukTire();
		tire=new kumhoTire();
	}
	public String getTireBrand() {
		return "장착된 타이어 : "+tire.getBrand();
	}
}
