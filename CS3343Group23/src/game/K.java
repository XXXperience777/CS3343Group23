package game;

public class K implements Command
{

	public void pressKey(Plane plane)
	{
	    plane.grapeShot();
	}

	@Override
	public void releaseKey(Plane plane)
	{


	}
	

}