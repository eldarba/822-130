package app.core.beans.a.injectors.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

	private BeanA a;

	@Autowired
	public BeanB(BeanA a) {
		super();
		this.a = a;
	}

	public BeanA getA() {
		return a;
	}

	// DANGER of stack overflow
	@Override
	public String toString() {
		return a.toString();
	}

}
