package com.arprolland.platformer.entity;

import java.util.Random;

import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.level.Level;

public class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}
