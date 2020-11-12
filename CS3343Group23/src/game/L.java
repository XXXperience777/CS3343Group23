package game;

public class L implements Command {

	public void pressKey(Plane plane) {
		this.traceShot(plane);
	}

	@Override
	public void releaseKey(Plane plane) {
		
		
	}
    private void traceShot(Plane plane) {
		
		plane.addBullet(new BulletPlayer(plane.getX()+44, plane.getY()-20, true, plane.getGs(),4) );
	}
}