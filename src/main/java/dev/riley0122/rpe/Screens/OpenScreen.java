package dev.riley0122.rpe.Screens;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.io.*;

import javax.swing.*;

import dev.riley0122.rpe.App;

import java.util.prefs.Preferences;

public class OpenScreen {
	public static String packLocation;
	
	public static void open() {
		JFrame frame = new JFrame();
		JButton button = new JButton("Open resource pack");
		JLabel label = new JLabel("Minecaft resource pack editor");
		JFileChooser fileChooser = new JFileChooser();
		
		int width = 300;
		int height = 200;
		
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		Preferences prefs = Preferences.userNodeForPackage(App.class);
		String directoryToOpen = prefs.get(App.PREF_KEY_LAST_DIRECTORY, System.getProperty("user.home"));
		
		fileChooser.setCurrentDirectory(new File(directoryToOpen));
		
		button.setBounds(width/2 - (width - width/5)/2, height/2 - 50/2, width - width/5, 50);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					packLocation = fileChooser.getSelectedFile().getAbsolutePath();
					prefs.put(App.PREF_KEY_LAST_DIRECTORY, packLocation);
				} else {
					AlertScreen.create("Cancelled", "Opening resource pack was cancelled.");
					return;
				}
				LoadingScreen.open();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		label.setBounds(width/2 - (width - width/5)/2, 0,  width - width/5, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.add(label);
		frame.add(button);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation((dim.width / 2) - (width / 2), (dim.height / 2) - (height / 2));
		frame.setVisible(true);
	}
}
