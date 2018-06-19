package marsRover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Exceptions.InvalidValue;
 

public class MarsRoverControl {

	private int plateauX = 0;
	private int plateauY = 0;
	private boolean error = false;
	
	private List<Rover> Rovers = new ArrayList<Rover>();
	
	
	public void readInstructions(String file) {
		
	    try {
	      FileReader f = new FileReader(file);
	      BufferedReader br = new BufferedReader(f);
	 
	      int posX = 0;
	      int posY = 0;
	      char dir = 0;
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
		    		String[] parts = lineA.split(" ");
		    		
		    		if (!Character.isLetter(parts[2].charAt(0))) {
		    	
		    			throw new InvalidValue(1);	
		    		}
		    		else {
		    			posX = Integer.parseInt(parts[0]);
		    			posY = Integer.parseInt(parts[1]);
		    			dir = parts[2].charAt(0);
		    		}
	    		
		    		lineB =  br.readLine();
	    			
		    		if (posX > this.plateauX || posY > this.plateauY) {
	    			
	    				throw new InvalidValue(2);
	    			}
	    					
	    			else if (lineB!= null){
	    				
		    			Position pos = new Position (posX, posY, dir);
		    			Rover rover = new Rover(roverN,pos,lineB);
		    			this.Rovers.add(rover);
		    			 
		    			roverN++;
		    			
	    			}
	    			else {
	    				
	    				throw new InvalidValue(3);
	    			}
	    		}
	      }
	      br.close();
	      f.close();
	      
	    }
	    catch(InvalidValue e) {
	    	
	    	System.out.println(e.getMessageError());
	    	error = true;
	    	
	    }
	    catch(Exception e) {
	    	
	    	System.out.println("An error occured when reading the Instructions.txt file!");
	    	error = true;
		      
		 }

	}	
		
	public List<Rover> goAhead() {
		
		if(!error) {
			
			for(Rover rover : this.Rovers) {
				
				char[] instructions = rover.getInstructions().toCharArray();
				
				for (char instruction: instructions) {
						
					if (instruction == 'M') move(rover); 
					
					else if (instruction == 'R' || instruction == 'L') turn(rover, instruction);		
				}	  
			}
			return this.Rovers;
		}
		else return null;
	}
	
	private void move(Rover rover) {
			
			char dir = rover.getPos().getDir();
			
	        int k = (dir == 'W' || dir == 'E') ? 0 : 1;
	        int value = (dir == 'N' || dir == 'E') ? 1 : -1;
	        
	        int increment = rover.getPos().getXY()[k] + value;
	
	        if((k == 0 && increment >= 0 && increment <= this.plateauX) 
	        		
	        		|| (k == 1 && increment > 0 && increment <= this.plateauY) ) {
	        	
	        	rover.getPos().setXY(k, value);
	        }
	        
		}
	
	private void turn(Rover rover, char instruction) {		 
		 
		  	String  orientation = "WNES";
	        char pos = rover.getPos().getDir();
	        
	        int location = (instruction == 'L') ? orientation.indexOf(pos) - 1 :orientation.indexOf(pos) + 1;
	        if (location < 0) location = 3; else if (location > 3) location = 0;
	        
	        rover.getPos().setDir(orientation.charAt(location));
		
	}
	
}
