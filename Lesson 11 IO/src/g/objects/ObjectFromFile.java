package g.objects;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import b.sets.Point;

public class ObjectFromFile {

	public static void main(String[] args) {

		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("files/point.obj")));) {

			Point point = (Point) in.readObject();
			System.out.println(point);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
