package a.cinema;

public class Cinema {

	// field declaration - initialize the array at the 1st dimension
	private String[][] arr;

	// the CTOR will initialize the 2nd dimension of the array
	public Cinema() {
		arr = new String[3][];
		arr[0] = new String[3];
		arr[1] = new String[5];
		arr[2] = new String[4];
	}

	/**
	 * adds the specified name to the specified row and seat. first row and seat is
	 * 1.
	 */
	public void add(String name, int row, int seat) {
		row--;
		seat--;
		if (row >= 0 && row < arr.length && seat >= 0 && seat < arr[row].length) {
			if (arr[row][seat] == null) {
				arr[row][seat] = name;
				System.out.println(name + " is seated: row: " + (row + 1) + ", seat: " + (seat + 1));
			} else {
				System.out.println("this place is taken: row: " + (row + 1) + ", seat: " + (seat + 1));
			}
		} else {
			System.out.println("the row and seat you specified are invalid");
		}
	}

	public String remove(int row, int seat) {
		row--;
		seat--;
		if (row >= 0 && row < arr.length && seat >= 0 && seat < arr[row].length) {
			String nameToRemove = arr[row][seat];
			arr[row][seat] = null;
			return nameToRemove;
		} else {
			System.out.println("the row and seat you specified are invalid");
			return null;
		}
	}

	public void display() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
