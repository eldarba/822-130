package c.accessLevels;

public class AccessLevels {

	public static int aPublic; // every where
	protected static int bProtected; // all subclasses
	static int cDefault; // default is package private
	private static int dPrivate; // this class only

	public static void main(String[] args) {

		System.out.println(AccessLevels.aPublic);
		System.out.println(AccessLevels.bProtected);
		System.out.println(AccessLevels.cDefault);
		System.out.println(AccessLevels.dPrivate);
	}

}
