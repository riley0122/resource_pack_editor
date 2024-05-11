package dev.riley0122.rpe;

import dev.riley0122.rpe.Screens.*;

public class App 
{
	public static final String PREF_KEY_LAST_DIRECTORY = "RPE_LAST_DIRECTORY";
	
    public static void main( String[] args )
    {
    	try {			
    		SceenStyler.apply();
    		OpenScreen.open();
		} catch (Exception e) {
			System.out.println("Something went wrong!\n\n");
			System.out.println(e.getMessage() + "\n");
			System.out.println(e.getStackTrace());
			System.exit(1);
		}
    }
}
