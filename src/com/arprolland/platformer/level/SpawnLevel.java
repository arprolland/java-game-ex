package com.arprolland.platformer.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(new File(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w*h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
			}
		}
	// Grass = 0xFF007F0E
	// Flower = 0xFFE7FF93
	// Rock = 0xFF7E7D7E
	// Stone = 0xFF000000
	// Water = 0xFF0094FF
	
	protected void generateLevel() {
		
	}
	
	
}
