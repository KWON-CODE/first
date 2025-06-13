package basic.di04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
		
		String path="/src/main/java/basic/di04/TireObj.xml";
		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		
	
		Car car=(Car)context.getBean("car");

		System.out.println(car.getTireBrand());
	}
}
