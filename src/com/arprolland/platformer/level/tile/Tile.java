package com.arprolland.platformer.level.tile;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.graphics.Sprite;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile darkGrass = new GrassTile(Sprite.darkGrass);
	public static Tile rock = new GrassTile(Sprite.rock);
	public static Tile water = new GrassTile(Sprite.water);
	public static Tile stone = new GrassTile(Sprite.stone);
	public static Tile marble = new GrassTile(Sprite.marble);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}
	
}
