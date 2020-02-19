
public class Snake {
	public static int rx, ry; // position of the head of the snake is referenced in main class
	private double vx, vy; // velocity direction
	private double radius;
	private int v = 1; // velocity
	private int length = 4;
	private int max_length = 1000;
	private int position_x[] = new int[max_length];
	private int position_y[] = new int[max_length];
	private boolean gamestart = false;
	public static boolean controls = true;	//is referenced in Orb class
	private boolean score = true;

	public Snake() {
		radius = 0.5;
		rx = ry = 16;
	}

	/*
	 * function move moves an array of snake values of position_x and position_y by
	 * using isKeyPressed for keys 'w' 'a' 's' and 'd' pressing 'w' removes the
	 * controls from the screen and starts game pressing 'a' 's' or 'd' after w will
	 * set gamestart = true which allows the GameOver function to work
	 */

	public void move() {
		ry = (int) (ry + vy);
		rx = (int) (rx + vx);

		if (StdDraw.isKeyPressed(83)|| StdDraw.isKeyPressed(40)) {
			vy = -v;
			vx = 0;
			gamestart = true;
		}
		if (StdDraw.isKeyPressed(87) || StdDraw.isKeyPressed(38)) {
			vy = v;
			vx = 0;
			controls = false;
		}
		if (StdDraw.isKeyPressed(65)|| StdDraw.isKeyPressed(37)) {
			vx = -v;
			vy = 0;
			gamestart = true;
		}
		if (StdDraw.isKeyPressed(68) ||StdDraw.isKeyPressed(39)) {
			vx = v;
			vy = 0;
			gamestart = true;
		}

		position_x[0] = rx;
		position_y[0] = ry;
		for (int i = length; i > 0; i--) {
			position_x[i] = position_x[(i - 1)];
			position_y[i] = position_y[(i - 1)];
		}

	}

	/*
	 * function draw draws the playing field including a black background, red
	 * outline, score, and lists the controls at the beginning it also draws the
	 * array of the snake
	 */

	public void draw() {
		StdDraw.setXscale(0, +32);
		StdDraw.setYscale(0, +32);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(16, 16, 16);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledSquare(16, 16, 15.5);
		StdDraw.setPenColor(StdDraw.BLUE);
		for (int j = 0; j <= length; j++) {
			StdDraw.filledCircle(position_x[j], position_y[j], radius);
		}
		if (controls == true) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.text(16, 28, "SNAKE");
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(16, 24, "Controls:");
			StdDraw.text(16, 23, "Up: w");
			StdDraw.text(16, 22, "Left: a");
			StdDraw.text(16, 21, "Down: s");
			StdDraw.text(16, 20, "Right: d");
			StdDraw.text(16, 18, "Press w to start");
		}
		StdDraw.setPenColor(StdDraw.WHITE);
		if (score == true)
			StdDraw.text(2.75, 1, "Score:" + ((length - 4) / 3));

	}
	/*
	 * function success is used when the snake head is in the same position as the
	 * orb it creates a new orb and adds 3 to the snake array length
	 */

	public void success() {
		length += 3;
		Orb.rx = (int) (Math.random() * 31 + 1);
		Orb.ry = (int) (Math.random() * 31 + 1);

	}
	/*
	 * function GameOver is used when the snake head hits a wall or any part of the
	 * snake body it displays 'Game Over' and the score in the center it also stops
	 * the snake from moving and removes the bottom left score from the screen
	 */

	public void GameOver() {
		for (int i = length; i > 1; i--)
			if ((rx == 0 || rx == 32 || ry == 0 || ry == 32)
					|| (rx == position_x[i] && ry == position_y[i] && gamestart == true)) {
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.text(16, 16, "Game Over");
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.text(16, 15, "Score: " + ((length - 4) / 3));
				vx = 0;
				vy = 0;
				score = false;
			}
	}
}
