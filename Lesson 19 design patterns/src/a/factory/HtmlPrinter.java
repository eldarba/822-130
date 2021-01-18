package a.factory;

public class HtmlPrinter implements Printer {

	// attributes
	private String printerType;
	private String ink;

	// CTOR
	public HtmlPrinter(String printerType, String ink) {
		super();
		this.printerType = printerType;
		this.ink = ink;
	}

	@Override
	public void print(String content) {
		System.out.println(printerType);
		System.out.println("===================");
		System.out.println("<html>");
		System.out.println(content);
		System.out.println("</html>");
		System.out.println("===================\n");
	}

	@Override
	public String getPrinterType() {
		return this.printerType;
	}

	@Override
	public String getPrinterInk() {
		return this.ink;
	}

}
