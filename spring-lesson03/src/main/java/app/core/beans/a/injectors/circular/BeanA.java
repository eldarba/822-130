package app.core.beans.a.injectors.circular;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class BeanA {

	private BeanB b;

	@Autowired
	public BeanA(BeanB b) {
		super();
		this.b = b;
	}

	public BeanB getB() {
		return b;
	}

	// DANGER of stack overflow
	@Override
	public String toString() {
		return b.toString();
	}
	/*
	 * if we do CTOR injection: Spring warns us about circular injection and will
	 * NOT start the context at all.
	 * 
	 * if we do field injection: Spring will NOT warns us about circular injection
	 * and WILL start the context.
	 * 
	 * Therefore we do the best practice of CTOR injection
	 */

}
