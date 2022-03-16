package spaceZ;
//DONE
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameOverPanel extends JPanel implements ActionListener{
	JLabel title;
	JLabel score;
	JLabel scoreVal;
	JLabel oppKill;
	JLabel oppKillVal;
	JLabel label;
	static JButton newGame;
	static boolean startNewGame=false;
	static JButton quit;
	static boolean quitGame=false;
//	SpaceZFrame frame;
//	SpaceZPanel panel;
	
	GameOverPanel(){
		quitGame= false;
		startNewGame=false;
		title = new JLabel();
		title.setText("Game Over");
		title.setBounds(25, 30, 450, 70);
		title.setBackground(new Color(2,0,22));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.red);
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,60));
		title.setOpaque(true);
		
		score = new JLabel("Score");
		score.setBounds(130, 190, 100, 30);
		score.setBackground(new Color(2,0,22));
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setForeground(Color.white);
		score.setFont(new Font(Font.SERIF,Font.BOLD,25));
		score.setOpaque(true);
		
		scoreVal = new JLabel(""+SpaceZPanel.score);
		scoreVal.setBounds(280, 190, 130, 30);
		scoreVal.setBackground(new Color(2,0,22));
		scoreVal.setHorizontalAlignment(JLabel.CENTER);
		scoreVal.setForeground(Color.white);
		scoreVal.setFont(new Font(Font.SERIF,Font.BOLD,25));
		scoreVal.setOpaque(true);
		
		oppKill = new JLabel("Enemies Destroyed");
		oppKill.setBounds(80, 240, 200, 30);
		oppKill.setBackground(new Color(2,0,22));
		oppKill.setHorizontalAlignment(JLabel.CENTER);
		oppKill.setForeground(Color.white);
		oppKill.setFont(new Font(Font.SERIF,Font.BOLD,25));
		oppKill.setOpaque(true);
		
		oppKillVal = new JLabel(""+SpaceZPanel.oppoKill);
		oppKillVal.setBounds(320, 240, 80, 30);
		oppKillVal.setBackground(new Color(2,0,22));
		oppKillVal.setHorizontalAlignment(JLabel.CENTER);
		oppKillVal.setForeground(Color.white);
		oppKillVal.setFont(new Font(Font.SERIF,Font.BOLD,25));
		oppKillVal.setOpaque(true);
		
		
		newGame = new JButton("New Game");
		newGame.setBounds(40, 300, 200, 60);
		newGame.setBackground(new Color(2,0,22));
		newGame.setHorizontalAlignment(JLabel.CENTER);
		newGame.setForeground(Color.white);
		newGame.setFont(new Font(Font.SERIF,Font.BOLD,35));
		newGame.setFocusable(false);
		newGame.setOpaque(true);
		newGame.addActionListener(this);
		
		
		quit = new JButton("Quit");
		quit.setBounds(260, 300, 200, 60);
		quit.setBackground(new Color(2,0,22));
		quit.setHorizontalAlignment(JLabel.CENTER);
		quit.setForeground(Color.white);
		quit.setFocusable(false);
		quit.setFont(new Font(Font.SERIF,Font.BOLD,35));
		quit.addActionListener(this);
		quit.setOpaque(true);
		
		
		
		this.add(quit);
		this.add(newGame);
		this.add(oppKill);
		this.add(oppKillVal);
		this.add(scoreVal);
		this.add(score);
		this.add(title);
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
		g.drawRect(130, 160+30, 100, 30);
		g.drawRect(78, 200+40, 204, 30);
		g.drawRect(280, 160+30, 130, 30);
		g.drawRect(320, 200+40, 80, 30);
		g.setColor(Color.red);
		g.drawRect(25, 30, 450, 70);
		g.setFont(new Font(Font.SERIF,Font.BOLD,30));
		g.setColor(Color.yellow);
		if(SpaceZPanel.score<SpaceZPanel.highScore)
		  g.drawString("HIGH SCORE : "+SpaceZPanel.highScore, 125, 160);
		if(SpaceZPanel.score==SpaceZPanel.highScore)
			g.drawString("NEW HIGH SCORE : "+SpaceZPanel.highScore, 85, 160);
			
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit) {
			MenuPanel.clickClip.loop(1);
			quitGame=true;
		}
		
		if(e.getSource()==newGame) {
			MenuPanel.clickClip.loop(1);
			startNewGame=true;
		}
				
	}
}
