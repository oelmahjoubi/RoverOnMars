package Exceptions;

public class InvalidValue extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int errorType = 0;
	public InvalidValue(int error) {
        super(); 
        this.errorType = error;
    }
	
	public String getMessageError() {
		
		String msg;
		
		switch (this.errorType) {
		 
         case 1:  msg = "The Rover orientation is not correct. Please, enter a valid value!";
                  break;
         case 2:  msg = "The Rover is out of the plateau. Please, enter a valid position!";
                  break;
         case 3:  msg = "The instruction lines number is not correct. Please, enter valid instructions!";
                  break;
         default: msg= "invalid input";
         
		}
	
			
		return msg;
	}
}