package dev.riley0122.rpe.Screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.*;

import dev.riley0122.rpe.Loader.*;

public class LoadingScreen {
	private static JWindow window;
	private static JLabel StatusLabel;
	public static String StatusText;
	private static int width = 300;
	private static int height = 100;
	
	public static void UpdateStatus() {
		StatusLabel.setText(StatusText);	
	}
	
	public static void UpdateStatus(String newStatus) {
		StatusText = newStatus;
		StatusLabel.setText(StatusText);	
	}
	
	public static void open() {
		window = new JWindow();
		StatusLabel = new JLabel("");
		StatusText = "Initializing...";
		
		JProgressBar pb = new JProgressBar();
		
		JLabel loadingText = new JLabel("Loading");
		UpdateStatus();
		
		loadingText.setFont(new Font("sans-serif", Font.PLAIN, 50));
		loadingText.setBounds(0, 0, width, height - 15);
		loadingText.setHorizontalAlignment(SwingConstants.CENTER);
		loadingText.setVerticalAlignment(SwingConstants.TOP);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		StatusLabel.setFont(new Font("sans-serif", Font.PLAIN, 14));
		StatusLabel.setBounds(0, 50, width, height);
		StatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StatusLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		pb.setSize(width, 30);
		pb.setLocation(0, height - 15);
		pb.setIndeterminate(true);
		
		window.add(loadingText);
		window.add(StatusLabel);
		window.add(pb, BorderLayout.SOUTH);
		
		window.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		window.setSize(width, height);
		window.setLocation((dim.width / 2) - (width / 2), (dim.height / 2) - (height / 2));
		window.setBackground(new Color(255, 255, 255));
		window.setAlwaysOnTop(true);
		window.setVisible(true);
		
		// Actually start loading the resource pack
		new Thread(new PackLoader()).start();
	}
}
