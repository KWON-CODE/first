package basic.di01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
		
		String path="src/main/java/basic/di01/tireObj.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		Tire tire = (Tire)context.getBean("tire1");
		Car car = (Car)context.getBean("car1");
		
		
//		Tire tire = new HankooTire();
//		tire = new KumhoTire();
//		Car car = new Car(tire);
		car.setTire(tire);
		System.out.println(car.getTireBrand());
	} 
}
