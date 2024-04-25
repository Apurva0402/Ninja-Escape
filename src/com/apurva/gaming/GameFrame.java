package com.apurva.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	public GameFrame() {
		Board board=new Board();
		//even if you don't write this it will work perfectly
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("GAME DEV IN JAVA");
		    this.setSize(1500,920);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);
		    add(board);
		    this.setVisible(true);
		    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    new GameFrame();
 
	}

}
