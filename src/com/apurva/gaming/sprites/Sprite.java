package com.apurva.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;
//we don't want to allow to make objects of sprite class since the only motive of this class is to reduce redundancy in the code so we make it abstract
public abstract class Sprite {
	public int speed;
	public int x;
	public int y;
	public int h;
	public int w;
	ImageIcon image;
	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(), x, y, w, h, null);
	}
	
	
}
