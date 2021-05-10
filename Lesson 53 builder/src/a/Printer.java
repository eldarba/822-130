package a;

public class Printer {

	// required
	private String printerType;
	private String ink;
	private String series;
	// optional
	private boolean isScannerEnabled;
	private boolean isFaxEnabled;

	private Printer(Builder builder) {
		this.ink = builder.ink;
		this.isFaxEnabled = builder.isFaxEnabled;
		this.isScannerEnabled = builder.isScannerEnabled;
		this.printerType = builder.printerType;
		this.series = builder.series;
	}

	public String getPrinterType() {
		return printerType;
	}

	public String getInk() {
		return ink;
	}

	public String getSeries() {
		return series;
	}

	public boolean isScannerEnabled() {
		return isScannerEnabled;
	}

	public boolean isFaxEnabled() {
		return isFaxEnabled;
	}

	public static void moveStatic() {
		System.out.println("moving");
	}

	@Override
	public String toString() {
		return "Printer [printerType=" + printerType + ", ink=" + ink + ", series=" + series + ", isScannerEnabled="
				+ isScannerEnabled + ", isFaxEnabled=" + isFaxEnabled + "]";
	}

	// static nested class
	public static class Builder {
		// required
		private String printerType;
		private String ink;
		private String series;
		// optional
		private boolean isScannerEnabled;
		private boolean isFaxEnabled;

		public Builder(String printerType, String ink, String series) {
			super();
			this.printerType = printerType;
			this.ink = ink;
			this.series = series;
		}

		public Builder setScannerEnabled(boolean isScannerEnabled) {
			this.isScannerEnabled = isScannerEnabled;
			return this;
		}

		public Builder setFaxEnabled(boolean isFaxEnabled) {
			this.isFaxEnabled = isFaxEnabled;
			return this;
		}

		public Printer build() {
			return new Printer(this);
		}

	}

}
