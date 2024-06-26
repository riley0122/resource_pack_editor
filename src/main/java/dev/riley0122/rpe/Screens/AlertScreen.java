package dev.riley0122.rpe.Screens;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.*;

public class AlertScreen {
	public static void warn(String title, String description) {
		create(title, description, AlertTypes.WARNING);
	}
	
	public static void error(String title, String description) {
		create(title, description, AlertTypes.ERROR);
	}
	
	public static void create(String title, String description) {
		create(title, description, AlertTypes.INFO);
	}
	
	public static void create(String title, String description, AlertTypes type) {
		JFrame frame = new JFrame();
		JLabel Title = new JLabel(title);
		JLabel Descr = new JLabel(description);
		
		Title.setFont(new Font("sans-serif", Font.PLAIN, 20));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setVerticalAlignment(SwingConstants.TOP);
		Title.setBounds(0, 20, 300, 30);

		Descr.setHorizontalAlignment(SwingConstants.CENTER);
		Descr.setVerticalAlignment(SwingConstants.TOP);
		Descr.setBounds(0, 50, 300, 100);
		
		frame.add(Title);
		frame.add(Descr);
		
		if (type == AlertTypes.WARNING) {
			frame.setTitle("Warning!");
		} else if (type == AlertTypes.ERROR) {
			frame.setTitle("Error!");
		} else {
			frame.setTitle("Info");
		}
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(300, 150);
		frame.setLocation((dim.width / 2) - (300 / 2), (dim.height / 2) - (150 / 2));
		frame.setVisible(true);
	}
}
