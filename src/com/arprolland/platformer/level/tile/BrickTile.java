package com.arprolland.platformer.level.tile;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.graphics.Sprite;

public class BrickTile extends Tile{

	public BrickTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int x, int y, Screen screen) {
		//render stone
		screen.renderTile(x << 4, y << 4, this);
		
	}
	
	public boolean solid() {
		return true;
	}

}
