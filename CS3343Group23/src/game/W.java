package game;

public class W implements Command {

	public void pressKey(Plane plane) {
		plane.setUp(true);
	}

	@Override
	public void releaseKey(Plane plane) {
		plane.setUp(false);

	}

}