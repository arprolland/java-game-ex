package com.arprolland.platformer.level;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width*height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	//lets RandomLevel class override
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		x1++;
		y1++;
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	// Grass = 0xFF007F0E
		// Dark Grass = 0xFFE7FF93
		// Rock = 0xFF7E7D7E
		// Stone = 0xFF000000
		// Water = 0xFF0094FF
		// Marble = 0xFFFDF6E4
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x+y*width] == 0xFF007F0E) return Tile.grass;
		if(tiles[x+y*width] == 0xFFE7FF93) return Tile.darkGrass;
		if(tiles[x+y*width] == 0xFF0094FF) return Tile.water;
		if(tiles[x+y*width] == 0xFF7E7D7E) return Tile.rock;
		if(tiles[x+y*width] == 0xFF000000) return Tile.stone;
		if(tiles[x+y*width] == 0xFFFDF6E4) return Tile.marble;
		
		return Tile.voidTile;
	}

}
