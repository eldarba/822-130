package b.recursion;

import java.io.File;

public class FileSystemExercise {

	public static void main(String[] args) {

		printFS("C:\\java\\workspace 822 130\\Lesson04-homework");

	}

	/**
	 * print the contents of the specified path, including all files, directories
	 * and sub directories
	 */
	public static void printFS(String path) {
		File file = new File(path); // this can be a file or directory

		if (file.isFile()) {
			System.out.println("\t" + file);
		} else {
			System.out.println(file);
			File[] files = file.listFiles();
			for (File f : files) {
				printFS(f.getPath());
			}
			System.out.println("=============");
		}

	}

}
