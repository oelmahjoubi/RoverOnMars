package marsRover;

import java.util.List;

public class MarsRoverApp {

	public static void main(String[] args) {
		
		MarsRoverControl marsRover = new MarsRoverControl();
		
		marsRover.readInstructions("Instructions.txt");
		
		List<Rover> rovers = marsRover.goAhead();
		
		if (rovers != null) {
			
				System.out.println("OUTPUT: ");
				
				for (Rover rover : rovers) {
					
					System.out.println("	"+rover.getPos().getX()+ " "+rover.getPos().getY()+ " "+rover.getPos().getDir());
					
				}
		}
	}

}
