package dev.riley0122.rpe.Loader;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dev.riley0122.rpe.Loader.McMeta.McMeta;
import dev.riley0122.rpe.Screens.*;

public class PackLoader implements Runnable {
	public void run() {
		LoadingScreen.UpdateStatus("Started loading pack...");
		
		if (OpenScreen.packLocation == null) {
			AlertScreen.warn("No pack selected!", "You haven't selected a location for a resource pack!");
			return;
		}
		
		File location = new File(OpenScreen.packLocation);
		
		McMeta packInfo = new McMeta(location);
		
		AlertScreen.create("Desc", packInfo.pack.description());
		
		LoadingScreen.UpdateStatus("Loaded pack.mcmeta");
	}
}
