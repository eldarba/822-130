package f.data.products;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Product {

	private String name;
	private double price;
	private int barcode;

	private static final File PRODUCTS_FILE = new File("files/products/product.dat");

	public Product() {
	}

	public Product(String name, double price, int barcode) {
		super();
		this.name = name;
		this.price = price;
		this.barcode = barcode;
	}

	public void save() throws IOException {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(PRODUCTS_FILE));) {
			out.writeUTF(this.name);
			out.writeDouble(this.price);
			out.writeInt(this.barcode);
			System.out.println(this + " written to: " + PRODUCTS_FILE);
		}
	}

	public void load() throws IOException {
		try (DataInputStream in = new DataInputStream(new FileInputStream(PRODUCTS_FILE));) {
			this.name = in.readUTF();
			this.price = in.readDouble();
			this.barcode = in.readInt();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", barcode=" + barcode + "]";
	}

}
