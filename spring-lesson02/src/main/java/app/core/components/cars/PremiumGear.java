package app.core.components.cars;

import org.springframework.stereotype.Component;

@Component
public class PremiumGear implements Gear {

	private int state;
	private int max = 9;

	@Override
	public int shiftUp() {
		state = (state + 1) % (max + 1);
		return state;
	}

	@Override
	public int shiftDown() {
		if (state > 0) {
			state--;
		}
		return state;
	}

}
