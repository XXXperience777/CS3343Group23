package game;

public class D implements Command {

	public void pressKey(Plane plane) {
		plane.setRight(true);
	}

	@Override
	public void releaseKey(Plane plane) {
		plane.setRight(false);

	}

}