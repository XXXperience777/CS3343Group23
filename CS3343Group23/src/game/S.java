package game;

public class S implements Command {

	public void pressKey(Plane plane) {
		plane.setDown(true);
	}

	@Override
	public void releaseKey(Plane plane) {
		plane.setDown(false);

	}

}