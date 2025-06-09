package basic.di02;

public class Car {
	private Tire tire;
	
	public Car() {
		
	}
	public String getTireBrand() {
		return "장착된 타이어" + tire.getBrand();
	}
	public Tire getTire() {
		return tire;
	}
	public void setTire(Tire tire) {
		this.tire = tire;
	}
}
