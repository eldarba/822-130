package app.core.components.cinema;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cinema {

	private String address;
	private int seats;

	public Cinema(@Value("${cinema.address:Israel}") String address, @Value("${cinema.seats:10}") int seats) {
		super();
		this.address = address;
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Cinema [address=" + address + ", seats=" + seats + "]";
	}

}
