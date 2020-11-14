package game;

public class L implements Command {

	public void pressKey(Plane plane) {
		plane.traceShot();
	}

	@Override
	public void releaseKey(Plane plane) {


	}

}