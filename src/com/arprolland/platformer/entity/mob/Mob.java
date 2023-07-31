package com.arprolland.platformer.entity.mob;

import com.arprolland.platformer.entity.Entity;
import com.arprolland.platformer.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
		if(ya < 0) dir = 0; // up
		if(xa > 0) dir = 1; // left
		if(ya > 0) dir = 2; // down
		if(xa < 0) dir = 3; // right
		
		if(!collision()) {
			x += xa;
			y += ya;
		}
		
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}
	

}
