package marsRover;

public class Rover {
	private int roverNumber = 0;
	private Position pos;
	private String instructions;
	
	public Rover(int roverNumber, Position pos, String instructions) {
		
		this.roverNumber = roverNumber;
		this.pos = pos;
		this.instructions = instructions;
		
	}
	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getRoverNumber() {
		return roverNumber;
	}
	public void setRoverNumber(int roverNumber) {
		this.roverNumber = roverNumber;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "Rover [roverNumber=" + roverNumber + ", pos=" + pos + ", instructions=" + instructions + "]";
	}
	

}
