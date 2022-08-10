package Reservation;

public class Seat {
	private String name;

	public Seat() {
		name = null;
	}

	public void reserveName(String name) {
		this.name = name;
	}

	public boolean isOccupeied() {
		if (name == null)
			return false;
		else
			return true;
	}

	public boolean match(String name) {
		return (name.equals(name));
	}

	public void cancel() {
		name = null;
	}

	// getter 메소드만 구현
	public String getName() {
		return name;
	}
}
