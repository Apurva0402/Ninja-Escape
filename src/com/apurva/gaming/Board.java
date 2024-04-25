package com.apurva.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.apurva.gaming.sprites.Enemy;
import com.apurva.gaming.sprites.Player;
public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	//Enemy enemy;
	  Enemy enemies[]=new Enemy[5];
  public Board() {
	  setSize(1500,920);
	  loadBGimage();
	  player=new Player();
	 // enemy=new Enemy();
	  loadEnemies();
	  gameLoop();
	  setFocusable(true);
	//  requestFocus();
	  bindEvents();
  }
  
  
 

  private void gameOver(Graphics pen) {
	  
	  if(player.outOfScreen()) {
		  pen.setFont(new Font("times",Font.BOLD,100));
		  
		  pen.setColor(Color.GREEN);
		  pen.drawString("YOU WIN", 1500/2, 900/2);
		  timer.stop();
		  return;
	  }
	  for(Enemy e:enemies) {
		  if(isCollide(e)) {
			  pen.setFont(new Font("times",Font.BOLD,100));
			  pen.setColor(Color.RED);
			  pen.drawString("GAME OVER", 1500/2, 900/2);
			  timer.stop();
		  }
	  }
  }
  private boolean isCollide(Enemy enemy) {
  int xDistance=Math.abs(player.x-enemy.x);
  int yDistance=Math.abs(player.y-enemy.y);
  int maxH=Math.max(player.h, enemy.h);
  int maxW=Math.max(player.w, enemy.w);
  return xDistance <= maxW-200 && yDistance <=maxH-200;
  }
  
  private void bindEvents() {
	  addKeyListener(new KeyListener() {
		  
		  public void keyTyped(KeyEvent e) {
			  
		  }
		  
           public void keyReleased(KeyEvent e) {
        	   player.speed=0;
        	   
        	//   if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
              //     player.stopJump();
              // }
		  }
 
 
          public void keyPressed(KeyEvent e) {
        	  if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
        		  player.speed=8;
        	  }
        	  else if(e.getKeyCode()==KeyEvent.VK_LEFT){
        		  player.speed=-8;
        	  }
        //	  else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                  // Start jumping when backspace key is pressed
             //     player.jump();
          //    }
        	 
          }
	  });
  }
  private void loadEnemies() {
	int x=300;
	int gap=300;
	int speed=5;
	for(int i=0;i<enemies.length;i++) {
		  enemies[i]=new Enemy(x,speed);
		  x=x+gap;
		  speed=speed+10;
	  }
  }
  private void gameLoop() {
	  timer=new Timer(50,(e)->repaint());
		 
	  //REPAINT CALLS PAINT COMPONENT & YOU CAN ONLY CALL PAINT COMPONENT ONCE
	  timer.start();
  }
  
  
  private void loadBGimage() {
	  try {
		  backgroundImage=ImageIO.read(Board.class.getResource("game-bg.jpeg.png"));
	} catch (IOException e) {
		System.out.println("BACKGROUND IMAGE NOT FOUND");
		System.exit(1);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  private void printEnemies(Graphics pen) {
	  for(Enemy e:enemies) {
		//  e.draw(getGraphics()); OR
		  e.draw(pen);
		  e.move();
	  }
  }
  public void paintComponent(Graphics pen){
	  
	  super.paintComponent(pen);//only clean ups
	//all painting logic will be here
	  pen.drawImage(backgroundImage,0,0,1500,920,null);
	  player.draw(pen);
	  player.move();
	  printEnemies(pen);
	  gameOver(pen);
  }
}
