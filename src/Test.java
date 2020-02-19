public class Test {
	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();
		int pause = 75;

		Orb orb = new Orb();
		Snake snake = new Snake();

		while (true) {
			StdDraw.clear();
			snake.move();
			snake.draw();
			snake.GameOver();
			orb.draw();
			if (Snake.rx == Orb.rx && Snake.ry == Orb.ry) {
				snake.success();
				pause -= 2; // decreases the pause by 2 after each success which creates faster movement
			}

			StdDraw.show();
			StdDraw.pause(pause);

		}
	}
}
