package com.arprolland.platformer.graphics;

import java.util.Random;

import com.arprolland.platformer.entity.mob.Player;
import com.arprolland.platformer.level.tile.Tile;

public class Screen {
	
	public int width;
	public int height;
	public int[] pixels;
	
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;
	
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	private Random random = new Random();
	
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		
		pixels = new int[width*height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int px, int py, Tile tile) {
		px -= xOffset;
		py -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = py + y;
			for(int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = px + x;
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa=0;
				pixels[xa+ya*width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
		
	}
	
	public void renderPlayer(int px, int py, Sprite sprite) {
		px -= xOffset;
		py -= yOffset;
		for(int y = 0; y < 16; y++) {
			int ya = py + y;
			for(int x = 0; x < 16; x++) {
				int xa = px + x;
				if(xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa=0;
				int col = sprite.pixels[x + y * 16];
				if(col != 0xffff00ff) pixels[xa+ya*width] = col;
			}
		}
		
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	

}
