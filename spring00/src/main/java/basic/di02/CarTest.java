package basic.di02;

public class CarTest {
	public static void main(String[] args) {
		Tire tire=new HankukTire();
		//Tire tire=new kumhoTire();
		Car car=new Car();
		car.setTire(tire);
		
		System.out.println(car.getTireBrand());
	}
}
