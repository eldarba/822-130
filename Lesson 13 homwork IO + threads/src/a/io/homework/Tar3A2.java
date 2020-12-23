package a.io.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tar3A2 {

	public static void main(String[] args) {

		{ // do it with buffer and converter
			try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
				System.out.println("enter a lines. enter \"exit\" to stop");
				String line = in.readLine();
				while (!line.equals("exit")) {
					System.out.println(line);
//					System.out.println("enter a line. enter \"exit\" to stop");
					line = in.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
