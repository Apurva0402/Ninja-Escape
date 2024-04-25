package com.apurva.gaming.sprites;

//import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	public Player() {
		w=250;
		h=250;
		x=15;
		y=500;
		image=new ImageIcon(Player.class.getResource("player.gif"));
	    
	}
	
	public void move() {
		x=x+speed;
	}
	
	public boolean outOfScreen() {
		return x>1500;
	}

	private boolean isJumping = false;
    private int jumpHeight = 100;

	
/*	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(),x,y,w,h,null);
	} */
}
