package dev.riley0122.rpe.Windows;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class WindowStyler {
	public static void apply() {
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize theme. Using fallback." );
		}
	}
}
