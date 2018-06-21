package marsRover;

import java.util.Arrays;

public class Position {
	int[] xy = new int[2];
	private char dir;
	
	public Position(int x, int y, char dir) {
		
		this.xy[0] = x;
		this.xy[1] = y;
		this.dir = dir;
		
	}
	
	public int getX() {
		return this.xy[0];
	}
	public void setX(int x) {
		this.xy[0] = x;
	}
	public int getY() {
		return this.xy[1];
	}
	public void setY(int y) {
		this.xy[1] = y;
	}
	public char getDir() {
		return dir;
	}
	public void setDir(char dir) {
		this.dir = dir;
	}
	
	public void setXY(int k, int xy) {
		this.xy[k] =  this.xy[k] + xy;
	}

	public int[] getXY() {
		
		return this.xy;
	}
	
	@Override
	public String toString() {
		return "Position [xy=" + Arrays.toString(xy) + ", dir=" + dir + "]";
	}


}
