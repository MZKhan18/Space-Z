package spaceZ;
//DONE
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener, MouseListener{
	ImageIcon labelImage;
	Image background;
	JButton startNewGame;
	JButton diff;
	JButton planeNo;
	JButton setting;
	JButton help;
	JButton exit;
	JLabel startNewGamel;
	JLabel diffl;
	JLabel planeNol;
	JLabel settingl;
	JLabel helpl;
	JLabel exitl;
	JLabel label ;
	JButton title;
	Timer timer;
	ImageIcon bg;
	static boolean startGame;
	static boolean difficulty;
	static boolean settings;
	static boolean planeType;
	static boolean helpMenu;
	boolean temp;
	URL clickURL;   
	AudioInputStream clickAudio; 
	static Clip clickClip;
	
	MenuPanel(){
		
		temp=true;
		startGame = false;
		settings=false;
		planeType=false;
		helpMenu=false;
		difficulty=false;
		
		timer = new Timer(20,this);
		labelImage = new ImageIcon(getClass().getClassLoader().getResource("labelImage.png"));
		background = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg")).getImage();
		 bg = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg"));
		
		 
//----------Label that will be the background---------------//
		label = new JLabel();
		label.setText("");
		label.setIcon(bg);
		label.setOpaque(true);
		label.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		label.setBounds(0, 0, 1535, 863);
		label.addMouseListener(this);
//------------code for title button which will contain the game name----/		
		title = new JButton();
		title.setText("Space Z");
		title.setBounds(415,50,605,120);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 115));
		title.setForeground(new Color(250,122,0));
		title.setVerticalTextPosition(JButton.CENTER);
		title.setHorizontalTextPosition(JButton.CENTER);
		title.setContentAreaFilled(false);
		title.setBorder(null);
		
//---------code of startNewGame button starts----------------------//	
		startNewGamel=new JLabel();
		startNewGamel.setBounds(580,255, 40, 40);
		startNewGamel.setOpaque(true);
		startNewGamel.setIcon(bg);
		
		startNewGame = new JButton();
		startNewGame.setText("Start Game");
		startNewGame.setBounds(635,250,200,50);
		startNewGame.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		startNewGame.setForeground(Color.white);
		startNewGame.setVerticalTextPosition(JButton.CENTER);
		startNewGame.setHorizontalTextPosition(JButton.CENTER);
		startNewGame.setIcon(bg);
		startNewGame.setContentAreaFilled(false);
		startNewGame.setBorder(null);
		startNewGame.addActionListener(this);
		startNewGame.addMouseListener(this);
//---------code of startNewGame button ends----------------------//	
		
//---------code of difficulty button starts-----------------------//	
		diffl=new JLabel();
		diffl.setBounds(580,325, 40, 40);
		diffl.setOpaque(true);
		diffl.setIcon(bg);
		
		diff = new JButton();
		diff.setText("Difficulty");
		diff.setBounds(635,320,200,50);
		diff.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		diff.setForeground(Color.white);
		diff.setVerticalTextPosition(JButton.CENTER);
		diff.setHorizontalTextPosition(JButton.CENTER);
		diff.setIcon(bg);
		diff.setContentAreaFilled(false);
		diff.setBorder(null);
		diff.addActionListener(this);
		diff.addMouseListener(this);
//---------code of difficulty button ends----------------------//
		
//---------code of planeNo button starts----------------------//		
		planeNol=new JLabel();
		planeNol.setBounds(580,395, 40, 40);
		planeNol.setOpaque(true);
		planeNol.setIcon(bg);
		
		planeNo = new JButton();
		planeNo.setText("Planes");
		planeNo.setBounds(635,390,200,50);
		planeNo.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		planeNo.setForeground(Color.white);
		planeNo.setVerticalTextPosition(JButton.CENTER);
		planeNo.setHorizontalTextPosition(JButton.CENTER);
		planeNo.setIcon(bg);
		planeNo.setContentAreaFilled(false);
		planeNo.setBorder(null);
		planeNo.addActionListener(this);
		planeNo.addMouseListener(this);
//---------code of planeNO button ends----------------------//

//---------code of setting button starts----------------------//		
		settingl=new JLabel();
		settingl.setBounds(580,465, 40, 40);
		settingl.setOpaque(true);
		settingl.setIcon(bg);
		
		setting = new JButton();
		setting.setText("Setting");
		setting.setBounds(635,460,200,50);
		setting.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		setting.setForeground(Color.white);
		setting.setVerticalTextPosition(JButton.CENTER);
		setting.setHorizontalTextPosition(JButton.CENTER);
		setting.setIcon(bg);
		setting.setContentAreaFilled(false);
		setting.setBorder(null);
		setting.addActionListener(this);
		setting.addMouseListener(this);
//---------code of setting button ends----------------------//
		
//---------code of help button starts----------------------//		
		helpl=new JLabel();
		helpl.setBounds(580,535, 40, 40);
		helpl.setOpaque(true);
		helpl.setIcon(bg);
		
		help = new JButton();
		help.setText("Help");
		help.setBounds(635,530,200,50);
		help.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		help.setForeground(Color.white);
		help.setVerticalTextPosition(JButton.CENTER);
		help.setHorizontalTextPosition(JButton.CENTER);
		help.setIcon(bg);
		help.setContentAreaFilled(false);
		help.setBorder(null);
		help.addActionListener(this);
		help.addMouseListener(this);
//---------code of help button ends----------------------//

//---------code of exit button starts----------------------//		
		exitl=new JLabel();
		exitl.setBounds(580,605, 40, 40);
		exitl.setOpaque(true);
		exitl.setIcon(bg);
		
		exit = new JButton();
		exit.setText("Exit");
		exit.setBounds(635,600,200,50);
		exit.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		exit.setForeground(Color.white);
		exit.setVerticalTextPosition(JButton.CENTER);
		exit.setHorizontalTextPosition(JButton.CENTER);
		exit.setIcon(bg);
		exit.setContentAreaFilled(false);
		exit.setBorder(null);
		exit.addActionListener(this);
		exit.addMouseListener(this);
//---------code of exit button ends----------------------//
	
//------------starting the click sound--------------------//		
        try {
			ClickMusic();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		timer.start();
		this.add(planeNol);
		this.add(exitl);
		this.add(settingl);
		this.add(helpl);
		this.add(diffl);
		this.add(startNewGamel);
		this.add(title);
		this.add(exit);
		this.add(help);
		this.add(setting);
		this.add(planeNo);
		this.add(diff);
		this.add(startNewGame);
		this.add(label);
		this.setFocusable(true);
		this.setOpaque(true);
		this.setLayout(null);
		this.setBounds(0, 0, SpaceZPanel.WIDTH+5, SpaceZPanel.HEIGHT+5);
		this.setBackground(Color.black);
		this.requestFocus();
		
	}
	
	public void paint(Graphics g) {//the paint method to draw all the graphics
		super.paint(g);
		Graphics2D g2 =(Graphics2D)g;
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(1));

//-----Drawing borders of components---------//
//		g2.drawRect(455,50,530,130);
//		g2.drawRect(457,52,526,126);
		g2.drawRect(635,250,200,50);
		g2.drawRect(635+2,250+2,200-4,50-4);
		g2.drawRect(635,320,200,50);
		g2.drawRect(635+2,320+2,200-4,50-4);
		g2.drawRect(635,390,200,50);
		g2.drawRect(635+2,390+2,200-4,50-4);
		g2.drawRect(635,460,200,50);
		g2.drawRect(635+2,460+2,200-4,50-4);
		g2.drawRect(635,530,200,50);
		g2.drawRect(635+2,530+2,200-4,50-4);
		g2.drawRect(635,600,200,50);
		g2.drawRect(635+2,600+2,200-4,50-4);

		
	}

//----------------------------------METHOD TO PLAY THE CLICK SOUND--------------------------------//
	public void ClickMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		clickURL = getClass().getClassLoader().getResource("click1.wav");
		clickAudio = AudioSystem.getAudioInputStream(clickURL);
		clickClip = AudioSystem.getClip();
		clickClip.open(clickAudio);
		
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startNewGame) {
			startGame=true;
			clickClip.loop(0);
		}
		if(e.getSource()==diff) {
			difficulty =true;
			clickClip.loop(0);
		}
		if(e.getSource()==setting) {
			settings =true;
			clickClip.loop(0);
		}
		if(e.getSource()==help) {
			helpMenu=true;
			clickClip.loop(0);
		}
		if(e.getSource()==planeNo) {
			planeType=true;
			clickClip.loop(0);
		}
		if(e.getSource()==exit) {
			clickClip.loop(0);
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startNewGame) {
			startNewGamel.setBackground(new Color(0,1,22));
			startNewGamel.setIcon(labelImage);
		}
		if(e.getSource()==diff) {
			diffl.setBackground(new Color(0,1,22));
			diffl.setIcon(labelImage);
		}
		if(e.getSource()==setting) {
			settingl.setBackground(new Color(0,1,22));
			settingl.setIcon(labelImage);
		}
		if(e.getSource()==planeNo) {
			planeNol.setBackground(new Color(0,1,22));
			planeNol.setIcon(labelImage);
		}
		if(e.getSource()==help) {
			helpl.setBackground(new Color(0,1,22));
			helpl.setIcon(labelImage);
		}
		if(e.getSource()==exit) {
			exitl.setBackground(new Color(0,1,22));
			exitl.setIcon(labelImage);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startNewGame) {
			startNewGamel.setIcon(bg);
		}
		if(e.getSource()==diff) {
			diffl.setIcon(bg);
		}
		if(e.getSource()==setting) {
			settingl.setIcon(bg);
		}
		if(e.getSource()==help) {
			helpl.setIcon(bg);
		}
		if(e.getSource()==planeNo) {
			planeNol.setIcon(bg);
		}
		if(e.getSource()==exit) {
			exitl.setIcon(bg);
		}
		
	}

}
