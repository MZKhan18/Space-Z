package spaceZ;
//DONE
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GamePausePanel extends JPanel implements ActionListener{
	static JButton newGame;
	static boolean startNewGame=false;
	static JButton quit;
	static boolean quitGame=false;
	JLabel title ;
	
	GamePausePanel(){
		
		startNewGame=false;
		quitGame=false;
		
		newGame = new JButton("New Game");
		newGame.setBounds(40, 280, 200, 60);
		newGame.setBackground(new Color(2,0,22));
		newGame.setHorizontalAlignment(JLabel.CENTER);
		newGame.setForeground(Color.white);
		newGame.setFont(new Font(Font.SERIF,Font.BOLD,35));
		newGame.setFocusable(false);
		newGame.setOpaque(true);
		newGame.addActionListener(this);
		
		quit = new JButton("Quit");
		quit.setBounds(260, 280, 200, 60);
		quit.setBackground(new Color(2,0,22));
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setForeground(Color.white);
		quit.setFocusable(false);
		quit.setFont(new Font(Font.SERIF,Font.BOLD,35));
		quit.addActionListener(this);
		quit.setOpaque(true);
		
		
		this.add(quit);
		this.add(newGame);
		this.setLayout(null);
		this.setBounds(510,230,600,600);
		this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {  //this method will paint all the graphics and components
		super.paint(g);
		g.setColor(Color.white);
		g.drawRect(2, 2, 496, 396);
		g.drawRect(4, 4, 492, 392);
		
		Graphics2D g2 =(Graphics2D)g;
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(2));
		g2.drawRect(100, 50, 300, 80);
		g2.setColor(new Color(250,122,0));
		g2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,75));
		g2.drawString("Space Z", 105, 115);
		g2.setColor(Color.white);
		g2.setFont(new Font(Font.SERIF,Font.BOLD,30));
		g2.drawString("Score : "+SpaceZPanel.score,180,185);
		g2.drawString("Enemies Destroyed : "+SpaceZPanel.oppoKill,115,225);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit) {
			MenuPanel.clickClip.loop(1);
			quitGame =true;
		}
			
		
		if(e.getSource()==newGame) {
			MenuPanel.clickClip.loop(1);
			startNewGame=true;
	    }
				
	}
}
