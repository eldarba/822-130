package a.factory;

public class PrinterFactory {

	public static Printer createPrinter(PrinterType type) {

		Printer printer = null;

		switch (type) {
		case PLAIN_TEXT:
			printer = new PlainTextPrinter("plain printer", "color");
			break;
		case HTML:
			printer = new HtmlPrinter("HTML printer", "black");
			break;
		}

		return printer;
	}

}
