package game;

public class A implements Command {

	public void pressKey(Plane plane) {
		plane.setLeft(true);
	}

	@Override
	public void releaseKey(Plane plane) {

		plane.setLeft(false);
	}

}