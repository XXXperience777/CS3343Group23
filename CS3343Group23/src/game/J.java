package game;

public class J implements Command {

	public void pressKey(Plane plane)
	{
	  this.fire(plane);
	}

	@Override
	public void releaseKey(Plane plane)
	{


	}
	private void fire(Plane plane)
	{

		plane.addBullet(new BulletPlayer(true, plane.getGs()));
	}

}