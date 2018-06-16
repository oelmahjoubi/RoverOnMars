package marsRover;

public class MarsRoverApp {

	public static void main(String[] args) {
		
		MarsRoverControl marsRover = new MarsRoverControl();
		
		marsRover.readInstructions("Instructions.txt");
	}

}
