package marsRover;

public class Position {
	int x;
	int y;
	String dir;
	
	public Position(int x, int y, String dir) {
		
		this.x = x;
		this.y = y;
		this.dir = dir;
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	public void incrementX() {
		this.x ++;
	}
	
	public void decrementX() {
		this.x --;
	}
	
	public void incrementY() {
		this.y ++;
	}
	
	public void decrementY() {
		this.y --;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
}
