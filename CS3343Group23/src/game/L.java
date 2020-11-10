package game;

public class L implements Command {

	public void execute(Plane plane) {
		plane.traceShot();
	}

}