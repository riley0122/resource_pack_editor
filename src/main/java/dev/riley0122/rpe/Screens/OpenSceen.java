package dev.riley0122.rpe.Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class OpenSceen {
	public static void open() {
		JFrame frame = new JFrame();
		JButton button = new JButton("Open resource pack");
		JLabel label = new JLabel("Minecaft resource pack editor");
		JFileChooser fileChooser = new JFileChooser();
		
		int width = 300;
		int height = 200;
		
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		button.setBounds(width/2 - (width - width/5)/2, height/2 - 50/2, width - width/5, 50);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(frame);
				AlertScreen.create("Sorry!", "This has not been implemented yet!", AlertTypes.WARNING);
			}
		});
		
		label.setBounds(width/2 - (width - width/5)/2, 0,  width - width/5, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		frame.add(label);
		frame.add(button);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
