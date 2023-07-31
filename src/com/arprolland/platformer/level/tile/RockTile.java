package com.arprolland.platformer.level.tile;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.graphics.Sprite;

public class RockTile extends Tile{

	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		//render stone
		screen.renderTile(x << 4, y << 4, this);
		
	}

}
