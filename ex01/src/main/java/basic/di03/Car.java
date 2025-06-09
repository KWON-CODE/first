package basic.di03;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	@Autowired
	private Tire tire;
	
	public Car() {
		
	}
	public String getTireBrand() {
		return "장착된 타이어" + tire.getBrand();
	}
	public Tire getTire() {
		return tire;
	}
}
