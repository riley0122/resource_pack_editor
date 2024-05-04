package dev.riley0122.rpe.Loader;

import java.io.*;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dev.riley0122.rpe.Screens.*;

public class PackLoader implements Runnable {
	public void run() {
		LoadingScreen.UpdateStatus("Started loading pack...");
		
		if (OpenScreen.packLocation == null) {
			AlertScreen.warn("No pack selected!", "You haven't selected a location for a resource pack!");
			return;
		}
		
		File location = new File(OpenScreen.packLocation);
		File[] topLevelFiles = location.listFiles();
		
		File McMetaFile = new File(location.getAbsolutePath() + "/pack.mcmeta"); 
		if (!McMetaFile.exists()) {
			JFrame tmp_frame = new JFrame();
			tmp_frame.setAlwaysOnTop(true);
			int result = JOptionPane.showConfirmDialog(tmp_frame, "Do you want to create one?", "No resource pack exists in the " + location.getName() + " directory", JOptionPane.YES_NO_OPTION);
			String description = JOptionPane.showInputDialog(tmp_frame, "Enter a description");
			if (description == null || description.trim() == "") {
				description = "generic resource pack description";
			}
			if (result == JOptionPane.YES_OPTION) {
				String data = "{\n"
							+ "\t\"pack\": {\n"
							+ "\t\t\"pack_fomat\": 41,\n"
							+ "\t\t\"description\": \"" + description + "\"\n"
							+ "\t}\n"
							+ "}\n";
				try {
					LoadingScreen.UpdateStatus("Writing pack.mcmeta");
					FileOutputStream out = new FileOutputStream(McMetaFile);
					
					byte[] byteData = data.getBytes();
					out.write(byteData);
					
					out.close();
				} catch (Exception e) {
					AlertScreen.error("Something went wrong writing pack.mcmeta!", Objects.toString(e.getMessage(), "No more information"));
					return;
				}
			} else {
				System.exit(1);
			}
		}
	}
}
