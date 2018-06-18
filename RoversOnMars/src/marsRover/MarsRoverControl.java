package marsRover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
 

public class MarsRoverControl {

	private int plateauX = 0;
	private int plateauY = 0;
	private int posY = 0;
	private int posX = 0;
	private String dir;
	private boolean error = false;
	
	private List<Rover> Rovers = new ArrayList<Rover>();
	
	
	public void readInstructions(String fileX) {
		
		String file = fileX;		
		
	    try {
	      FileReader f = new FileReader(file);
	      BufferedReader br = new BufferedReader(f);
	 
	      String lineA;
	      String lineB;
	      int roverN = 0;
	      boolean firstLine = true;
	      
	      while((lineA = br.readLine()) != null) {
	    	  
	    	if (firstLine){
	    		
	    		String[] parts =  lineA.split(" ");
	    		plateauX = Integer.parseInt(parts[0]);
	    		plateauY = Integer.parseInt(parts[1]); 
	    		firstLine = false;

	    	}
	    	else {
	    		
	    			//New Position
		    		String[] parts = lineA.split(" ");
		    		
		    		if (!Character.isLetter(parts[2].charAt(0))) {
		    	
		    			error = true;
		    			
		    		}
		    		else {
		    			this.posX = Integer.parseInt(parts[0]);
		    			this.posY = Integer.parseInt(parts[1]);
		    			this.dir = parts[2];
		    		}
	    			
	    			//Add new Rover
	    			
	    			lineB =  br.readLine();

	    			if (this.posX > this.plateauX || this.posY > this.plateauY) {
	    				
	    				error = true;
	
	    			}
	    			else {
	    				
		    			Position pos = new Position (this.posX, this.posY, this.dir);
		    			Rover rover = new Rover(roverN,pos,lineB);
		    			this.Rovers.add(rover);
		    			
		    			roverN++;
		    			
	    			}
	    		}
	      }
	      
	      f.close();
	    }
	    catch(Exception e) {
	    	
	      this.error = true;
	      
	    }

	}	
		
	public void goAhead() {
		
		
		if(error) {
			
			showMessageError();
			
		}
		
		else {
			
			for(Rover rover : this.Rovers) {
				
				char[] instructions = rover.getInstructions().toCharArray();
				
				for (char instruction: instructions) {
						
					if (instruction == 'M') move(rover); 
					
					else if (instruction == 'R' || instruction == 'L') turn(rover, instruction);	
					
				}
				  
			}
			System.out.println("SYSTEM OUT:");
			System.out.println("	"+this.Rovers.get(0).getPos());
			System.out.println("	"+this.Rovers.get(1).getPos());
			
		}
		
	}
	
	private void move(Rover rover) {
			
		 switch (rover.getPos().getDir()) {
		 
         case "N":  if (this.plateauY > rover.getPos().getY()) {rover.getPos().incrementY();}
                  break;
         case "E":  if (this.plateauX > rover.getPos().getX()) {rover.getPos().incrementX();}
                  break;
         case "S":  if (0 < rover.getPos().getY()) {rover.getPos().decrementY();}
                  break;
         case "W":  if (0 < rover.getPos().getX()) {rover.getPos().decrementX();}
                  break;
         default: dir= "invalid dir";
         
		}
	}
	
	private void turn(Rover rover, char instruction) {
	
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
	
	private void showMessageError() {
		
		System.out.println("The data input is not correct. Please, enter correct data!");
	}
	
	
}
