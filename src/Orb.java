
public class Orb {
	public static int rx, ry; // position of orb which is referenced in main class
	private double radius;

	public Orb() {
		radius = 0.5;
		rx = (int) (Math.random() * 31 + 1);
		ry = (int) (Math.random() * 31 + 1);

	}

	// function draw draws the orb at position rx, ry
	public void draw() {
		if (Snake.controls == false) { // keeps orb from covering up controls
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(rx, ry, radius);
		}
	}
}