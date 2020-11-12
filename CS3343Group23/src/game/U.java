package game;

public class U implements Command {

	public void pressKey(Plane plane) {
		plane.ult();
	}

	@Override
	public void releaseKey(Plane plane) {
		
		
	}

}