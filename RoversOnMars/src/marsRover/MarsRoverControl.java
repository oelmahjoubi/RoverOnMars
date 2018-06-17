package marsRover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
 

public class MarsRoverControl {

	int plateauX = 0;
	int plateauY = 0;
	int posY = 0;
	int posX = 0;
	String dir;
	
	String instructions;
	
	List<Rover> Rovers = new ArrayList<Rover>();
	
	
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
	    	else if (lineN % 2 != 0) {
	    		
		    		String[] parts = line.split(" ");
		    		
	    			this.posX = Integer.parseInt(parts[0]);
	    			this.posY = Integer.parseInt(parts[1]);
	    			this.dir = parts[2];
	    			
	    			//New Position
	    		}
	    	else {
	    			
	    			this.instructions = line;
	    			
	    			Position pos = new Position (this.posX, this.posY, this.dir);
	    			
	    			Rover rover = new Rover(roverN,pos, this.instructions);
	    			
	    			this.Rovers.add(rover);
	    			
	    			roverN++;
	    			
	    			//Add new Rover
	    		}
	    	lineN ++;
	      }
	      
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Exception reading the file "+ file + ": " + e);
	    	}
		
		
	}	
	
	
	public void goAhead() {
		
		for(int i = 0; i < this.Rovers.size(); i++) {
			
			char[] instructions = this.Rovers.get(i).getInstructions().toCharArray();
			
			for (int k = 0; k < instructions.length; k++) {
				
				if (instructions[k] == 'M') {
				
					move(this.Rovers.get(i));
				}
				else {
				}
			}
			  
		}
		System.out.println("SYSTEM OUT:");
		System.out.println("	"+this.Rovers.get(0).getPos());
		System.out.println("	"+this.Rovers.get(1).getPos());
		
	}
	
	public void move(Rover rover) {
			
		 switch (rover.getPos().getDir()) {
		 
         case "N":  rover.getPos().incrementY();
                  break;
         case "E":  rover.getPos().incrementX();
                  break;
         case "S":  rover.getPos().decrementY();
                  break;
         case "W":  rover.getPos().decrementX();
                  break;
         default: dir= "invalid dir";
         
		}
	}
	
	public void turn(Rover rover, char instruction) {
	
		 switch (rover.getPos().getDir()) {
		 
         case "N":  if (instruction == 'L') {rover.getPos().setDir("W");} else {rover.getPos().setDir("E");}
                  break;
         case "E":  if (instruction == 'L') {rover.getPos().setDir("N");} else {rover.getPos().setDir("S");}
                  break;
         case "S":  if (instruction == 'L') {rover.getPos().setDir("E");} else {rover.getPos().setDir("W");}
                  break;
         case "W":  if (instruction == 'L') {rover.getPos().setDir("S");} else {rover.getPos().setDir("N");}
                  break;
         default: dir= "invalid dir";
         
		}
		
	}
	
	
	
}
