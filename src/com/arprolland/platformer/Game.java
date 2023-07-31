package com.arprolland.platformer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.arprolland.platformer.entity.mob.Player;
import com.arprolland.platformer.graphics.Screen;
import com.arprolland.platformer.input.Keyboard;
import com.arprolland.platformer.level.Level;
import com.arprolland.platformer.level.RandomLevel;
import com.arprolland.platformer.level.SpawnLevel;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String title = "Shiny Lumi";
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Thread gameThread;
	private boolean isRunning = false;
	private JFrame frame;
	
	//graphics
	private Screen screen;
	
	//input
	private Keyboard key;
	
	//level
	private Level level;
	
	//player
	private Player player;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		level = new SpawnLevel("res/textures/spawn.png");
		
		key = new Keyboard();
		player = new Player(128, 128, key);
		addKeyListener(key);
	}
	public synchronized void start() {
		isRunning = true;
		gameThread = new Thread(this, "Display");
		gameThread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			gameThread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

	public void run() {
		//tick method
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		//fps counter
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	//tick rate 60Hz
	public void tick() {
		key.update();
		player.update();
	}
	
	//render images to Game object
	public void render() {
		//create a buffer strategy object
		BufferStrategy buffStrat = getBufferStrategy();
		if(buffStrat == null) {
			//create a triple buffer strategy to handle
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width/2;
		int yScroll = player.y - screen.height/2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		//give the buffer strategy screen data
		Graphics g = buffStrat.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		buffStrat.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
	
	
	
	
	
	
}
