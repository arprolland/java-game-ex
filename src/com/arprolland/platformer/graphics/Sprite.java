package com.arprolland.platformer.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	private SpriteSheet sheet;
	
	public static Sprite voidSprite = new Sprite(16, 0);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite darkGrass = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite brick = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite marble = new Sprite(16, 4, 1, SpriteSheet.tiles);
	
	public static Sprite player_down = new Sprite(16, 0, 0, SpriteSheet.chars);
	public static Sprite player_up = new Sprite(16, 3, 0, SpriteSheet.chars);
	public static Sprite player_left = new Sprite(16, 2, 0, SpriteSheet.chars);
	public static Sprite player_right = new Sprite(16, 1, 0, SpriteSheet.chars);
	
	public static Sprite player_down_1 = new Sprite(16, 0, 1, SpriteSheet.chars);
	public static Sprite player_up_1 = new Sprite(16, 3, 1, SpriteSheet.chars);
	public static Sprite player_left_1 = new Sprite(16, 2, 1, SpriteSheet.chars);
	public static Sprite player_right_1 = new Sprite(16, 1, 1, SpriteSheet.chars);
	
	public static Sprite player_down_2 = new Sprite(16, 0, 2, SpriteSheet.chars);
	public static Sprite player_up_2 = new Sprite(16, 3, 2, SpriteSheet.chars);
	public static Sprite player_left_2 = new Sprite(16, 2, 2, SpriteSheet.chars);
	public static Sprite player_right_2 = new Sprite(16, 1, 2, SpriteSheet.chars);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i < SIZE*SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y)*sheet.SIZE];
			}
		}
	}
}
