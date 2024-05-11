package dev.riley0122.rpe.Loader.McMeta;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.util.Objects;
import java.nio.file.Path;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dev.riley0122.rpe.Screens.AlertScreen;
import dev.riley0122.rpe.Screens.LoadingScreen;

public class McMetaMaker {
	public static String data;
	
	public static void run(File folder) {
		if (!ask(folder.getName()))
			return;
		
		data = "{\n"
			 + "\t\"pack\": {\n"
			 + "\t\t\"pack_format\": 41,\n"
			 + "\t\t\"description\": \"" + getDescription() + "\"\n"
			 + "\t}\n"
			 + "}\n";
		
		Path path = FileSystems.getDefault().getPath(folder.getAbsolutePath(), "pack.mcmeta");
		
		write(path.toFile());
	}
	
	private static JFrame getTmpFrame() {
		JFrame tmp_frame = new JFrame();
		tmp_frame.setAlwaysOnTop(true);
		return tmp_frame;
	}
	
	private static boolean ask(String foldername) {
		JFrame tmp_frame = getTmpFrame();
		int result = JOptionPane.showConfirmDialog(tmp_frame, "No pack.mcmeta found in the '" + foldername + "' directory!\nDo you want to create one?", "MC resource pack editor", JOptionPane.YES_NO_OPTION);
		return result == JOptionPane.YES_OPTION;
	}
	
	private static String getDescription() {
		JFrame tmp_frame = getTmpFrame();
		String description = JOptionPane.showInputDialog(tmp_frame, "Enter a description");
		if (description == null || description.trim() == "")
			description = "generic resource pack description";
		return description;
	}
	
	private static void write(File metaFile) {
		LoadingScreen.UpdateStatus("Writing pack.mcmeta");
		
		try {
			FileOutputStream out = new FileOutputStream(metaFile);
			
			byte[] byteData = data.getBytes();
			out.write(byteData);
			
			out.close();
		} catch (Exception e) {
			LoadingScreen.UpdateStatus("Failed to write pack.mcmeta!");
			
			AlertScreen.error("Something went wrong writing pack.mcmeta!", Objects.toString(e.getMessage(), "No more information"));
			return;
		}
	}
}
