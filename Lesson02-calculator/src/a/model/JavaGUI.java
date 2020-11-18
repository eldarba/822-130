package a.model;

import javax.swing.JFrame;

public class JavaGUI {

	public static void main(String[] args) {

		JFrame fr = new JFrame("My Calculator");
		fr.setBounds(100, 100, 500, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);

	}

}
