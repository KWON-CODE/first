package basic.di01;

public class CarTest {
	public static void main(String[] args) {
		Tire tire=new HankukTire();
		tire=new kumhoTire();
		Car car=new Car(tire);
		System.out.println(car.getTireBrand());
	}
}
