package marsRover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
 

public class MarsRoverControl {

	int plateauX = 0;
	int plateauY = 0;
	Position pos = new Position(0,0,"N");
	String instructions;
	
	List<Rover> Rovers = new ArrayList<>();
	
	
	public void readInstructions(String fileX) {
		
		String file = fileX;
		boolean var = false;
		
		
	    try {
	      FileReader fr = new FileReader(file);
	      BufferedReader br = new BufferedReader(fr);
	 
	      String line;
	      int lineN = 0;
	      int roverN = 0;
	      
	      while((line = br.readLine()) != null) {
	    	  
	    	if (lineN == 0){
	    		
	    		String string = line;
	    		String[] parts = string.split(" ");
	    		plateauX = Integer.parseInt(parts[0]);
	    		plateauY = Integer.parseInt(parts[1]); 
	    		

	    		
	    	}
	    	else if (line.length() == 3 || var) {
	    		
	    		
	    		if (line.length() == 3) {
	    			
		    		String[] parts = line.split(" ");
		    		
	    			this.pos.setX(Integer.parseInt(parts[0]));
	    			this.pos.setY(Integer.parseInt(parts[1]));
	    			this.pos.setDir(parts[2]);
	    			
	    			//New Position
	    		}
	    		else {
	    			
	    			this.instructions = line;
	    			
	    			Rover rover = new Rover(roverN,this.pos, this.instructions);
	    			
	    			this.Rovers.add(rover);
	    			
	    			//Add new Rover
	    		}
	    		
	    		
	    	}
	    	
	    	
	      fr.close();
	      lineN ++;
	      }
	    }
	    catch(Exception e) {
	      System.out.println("Exception reading the file "+ file + ": " + e);
	    	}
		
		System.out.println(plateauX);
		System.out.println(plateauY);
		System.out.println(this.Rovers.get(0).getInstructions());
		System.out.println(this.Rovers.get(1).getPos());
	
	}	
}
