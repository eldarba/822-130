package a.factory;

import java.util.Calendar;

public class Client {

	public static void main(String[] args) {

		Printer printer;

		printer = PrinterFactory.createPrinter(PrinterType.PLAIN_TEXT);
		printer.print("Hello");

		printer = PrinterFactory.createPrinter(PrinterType.HTML);
		printer.print("Hello");

		Calendar cal = Calendar.getInstance();

	}

}

//		printer = new HtmlPrinter("HTML printer", "black");
