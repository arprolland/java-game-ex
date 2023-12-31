package com.arprolland.platformer.level.tile;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		//render grass
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}

}
