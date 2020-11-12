package game;

public class K implements Command 
{

	public void pressKey(Plane plane) 
	{
	    this.grapeShot(plane);
	}

	@Override
	public void releaseKey(Plane plane) 
	{
		
		
	}
	private void grapeShot(Plane plane) 
	{
	
		plane.addBullet(new BulletPlayer(plane.getX()+22, plane.getY()-20, true, plane.getGs(), 1) );
		plane.addBullet(new BulletPlayer(plane.getX()+12, plane.getY()-20, true, plane.getGs(), 1) );
		plane.addBullet(new BulletPlayer(plane.getX()+40, plane.getY()-20, true, plane.getGs(), 2));
		plane.addBullet(new BulletPlayer(plane.getX()+50, plane.getY()-20, true, plane.getGs(), 2));
		plane.addBullet(new BulletPlayer(plane.getX()+66, plane.getY()-20, true, plane.getGs(), 3));
		plane.addBullet(new BulletPlayer(plane.getX()+76, plane.getY()-20, true, plane.getGs(), 3));
	}
}