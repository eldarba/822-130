package app.core;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.business.CalculatorBean;

public class Main {

	public static void main(String[] args) {
		System.out.println("--- from the join point");
		System.out.println(">>> from the advice");
		System.out.println("=============================");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {
			CalculatorBean bean = ctx.getBean(CalculatorBean.class);
			int a = 24;
			int b = Integer.parseInt(JOptionPane.showInputDialog("divide " + a + " by "));
			String res = bean.div(a, b);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("=============================");

	}

}
