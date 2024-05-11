package dev.riley0122.rpe.Loader.McMeta;

import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.io.File;
import java.util.Scanner;

import dev.riley0122.rpe.Screens.AlertScreen;
import dev.riley0122.rpe.Screens.LoadingScreen;

public class McMetaReader {
	public static String data = "";
	
	public static void run(File folder) {
		LoadingScreen.UpdateStatus("Reading pack.mcmeta");
		
		Path path = FileSystems.getDefault().getPath(folder.getAbsolutePath(), "pack.mcmeta");
		
		try {
			Scanner reader = new Scanner(path.toFile());
			while (reader.hasNextLine()) {
				String _data = reader.nextLine();
				data += _data;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			LoadingScreen.UpdateStatus("Failed reading pack.mcmeta!");
			AlertScreen.error("File not found!", "pack.mcmeta wasn't found even after verifying it existed!");
			return;
		}
	}
}
