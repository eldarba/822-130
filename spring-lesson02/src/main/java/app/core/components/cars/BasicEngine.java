package app.core.components.cars;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasicEngine implements Engine {

	@Override
	public void start() {
		System.out.println("BasicEngine started");

	}

}
