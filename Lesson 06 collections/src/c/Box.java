package c;

// define type parameter
public class Box<T> {

	// use it in the class
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public static void main(String[] args) {

		Box<String> b1 = new Box<>();
		b1.setContent("aaa");
		System.out.println(b1.getContent());

		Box<Integer> b2 = new Box<>();
		b2.setContent(5);
		System.out.println(b2.getContent());

	}

}
