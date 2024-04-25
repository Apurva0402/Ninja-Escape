package com.apurva.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	
public Enemy(int x,int speed) {
	
	this.x=x;
	y=30;
	w=200;
	h=150;
	this.speed=speed;
	image=new ImageIcon(Enemy.class.getResource("enemy.gif"));
}


public void move() {
	if(y>800) {
	y=0;	
	}
	y=y+speed;
	x=x+speed/10;
}


}
