package a.homework.point;

public class Point {

	public static final int MIN = 0;
	public static final int MAX = 100;

	private int x = MIN;
	private int y = MIN;

	public Point() {
	}

	public Point(int x, int y) throws PointXYException {
		super();
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws PointXYException {
		if (x > MAX) {
			throw new PointXYException("the value " + x + " is above the max allowed for x. max is: " + MAX);
		} else if (x < MIN) {
			throw new PointXYException("the value " + x + " is below the minimum allowed for x. min is: " + MIN);
		} else {
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws PointXYException {
		if (y > MAX) {
			throw new PointXYException("the value " + y + " is above the max allowed for y. max is: " + MAX);
		} else if (y < MIN) {
			throw new PointXYException("the value " + y + " is below the minimum allowed for y. min is: " + MIN);
		} else {
			this.y = y;
		}
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	/**
	 * returns a value within the legal range of x , y coordinates. if the specified
	 * value is above max - assigns max. if below minimum, assigns minimum.
	 * 
	 * @param val the value to validate
	 * @return
	 */
	public static int validateXY(int val) {
		if (val < MIN) {
			val = MIN;
		} else if (val > MAX) {
			val = MAX;
		}
		return val;
	}

}
