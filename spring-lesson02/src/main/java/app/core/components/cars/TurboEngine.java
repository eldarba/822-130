package app.core.components.cars;

import org.springframework.stereotype.Component;

@Component
public class TurboEngine implements Engine {

	@Override
	public void start() {
		System.out.println("TurboEngine engine started");

	}

}
