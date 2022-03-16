package spaceZ;
//DONE
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.FloatControl.Type;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

public class SpaceZPanel extends JPanel implements ActionListener, KeyListener{
	static final int WIDTH =1535;  //width of game screen
	static final int HEIGHT = 860; //height of game screen
	int bgYpos=0;    //y position of background
	int delay =30;	//speed of moving background
	int distance =800;  //distance between opponent cars
	int speed =10;//speed of opponent car
	int ballSpeed=12;
	static int difficulty =3;
	Image background;
	Image redFire;
	Image fighter;
	Image bullet;
	Image fireBall;
	Image oppo;
	static int temp=0;
	int oppoXpos=10;
	int oppoYpos=100;
	int oppo2Xpos=10;
	int oppo2Ypos=100;
	int fighterXpos=200;   
	int fighterHeight =120;
	int fighterWidth =119;
	int fighterYpos =HEIGHT-fighterHeight;
	int oppoWidth = 80;
	int oppoHeight =120;
	static int plane =1;
	static int score=0;
	static int highScore=0;
	int tempScore =0;
	static int oppoKill =0;
	int counter =150;
	Timer timer;
	boolean Bullet=false;
	static boolean playing =true;
	static boolean gameOver=false;
	boolean start =false;
	static boolean gameEnd=false;
	static boolean paused=false;
	static boolean autoFiring =false;
//	static boolean manualFiring=false;
	static boolean sound =true;
	Random random;
	ArrayList<Rectangle> bullets; 
	ArrayList<Rectangle> fireBall1;
	ArrayList<Rectangle> fireBall2;
	ArrayList<Rectangle> fireBall3;
	ArrayList<Rectangle> fireBall4;
	ArrayList<Rectangle> fireBall5;
	ArrayList<Rectangle> opponent;
	ArrayList<Rectangle> opponent2;
	ArrayList<Rectangle> redFireBall;
	ArrayList<Rectangle> redFireBall2;
	backGround thread2; //variable of the background thread class
	URL bulletURL;   
	AudioInputStream bulletAudio; 
	Clip bulletClip;
	URL laserURL;   
	AudioInputStream laserAudio; 
	Clip laserClip;
	URL explosionURL;   
	AudioInputStream explosionAudio; 
	Clip explosionClip;
	long counterf =0;
	
	
	SpaceZPanel(){	 //the constructor class with all the initializations of variables and other important things
		
	
//--------------------------INIIALISING VARIABLES-----------------------------------//
		counterf =0;
		temp=0;
		start =false;
		playing =true;
		paused =false;
		gameEnd =false;
		score=0;
		tempScore =0;
		oppoKill =0;
		counter =150;
		gameOver =false;
		timer = new Timer(15,this);
		random = new Random();
		opponent = new ArrayList<Rectangle>();
		opponent2 = new ArrayList<Rectangle>();
		fireBall1 = new ArrayList<Rectangle>();
		fireBall2 = new ArrayList<Rectangle>();
		fireBall3 = new ArrayList<Rectangle>();
		fireBall4 = new ArrayList<Rectangle>();
		fireBall5 = new ArrayList<Rectangle>();
		redFireBall = new ArrayList<Rectangle>();
		redFireBall2 = new ArrayList<Rectangle>();
		bullets = new ArrayList<Rectangle>();
//--------------------------INIIALISING VARIABLES DONE-----------------------------------//

//--------------------------INIIALISING IMAGES-----------------------------------//		
		redFire = new ImageIcon(getClass().getClassLoader().getResource("redFireBall.png")).getImage();
		oppo = new ImageIcon(getClass().getClassLoader().getResource("opponent.png")).getImage();
		background = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg")).getImage();
		if(plane==1)
			fighter = new ImageIcon(getClass().getClassLoader().getResource("fighter1.png")).getImage();
		else if(plane==2)
			fighter = new ImageIcon(getClass().getClassLoader().getResource("fighter2.png")).getImage();
		else if(plane==3)
			fighter = new ImageIcon(getClass().getClassLoader().getResource("fighter3.gif")).getImage();
		bullet = new ImageIcon(getClass().getClassLoader().getResource("bullet.png")).getImage();
		fireBall = new ImageIcon(getClass().getClassLoader().getResource("blueFireBall.png")).getImage();
//--------------------------INIIALISING IMAGES DONE-----------------------------------//
		
//		timer.start();
///--------------------------CHANGING THE GAME ACCORDING TO DIFFICULTY-----------------------------------//
		if(difficulty==0) {  // difficulty 0, two opponents will come and there distance will be less
		delay =17;
		distance = 1000;
		speed =7;
		ballSpeed =10;
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
					
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		}
		
		if(difficulty==1) {			// difficulty 1, two opponents will come and there distance will be less
		delay =15;
		distance = 850;
		speed =11;
		ballSpeed = 15;
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
					
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);}
		
		if(difficulty==2) { // difficulty 2, two opponents will come and there distance will be less			
		delay =13;
		distance = 600;
		speed=15;
		ballSpeed = 19;
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
					
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		
		opponents(true);
		opponents2(true);
		
		if(oppoYpos>0)
		redFireBalls(true);
		if(oppo2Ypos>0)
			redFireBalls2(true);
		}
		
		if(difficulty==3) {  // difficulty 3, two opponents will come and there distance will be less
			delay =10;
			distance = 450;
			speed =17;
			ballSpeed=26;
			opponents(true);
			opponents2(true);
			
			if(oppoYpos>0)
			redFireBalls(true);
			if(oppo2Ypos>0)
				redFireBalls2(true);
			
			opponents(true);
			opponents2(true);
			
			if(oppoYpos>0)
			redFireBalls(true);
			if(oppo2Ypos>0)
				redFireBalls2(true);
						
			opponents(true);
			opponents2(true);
			
			if(oppoYpos>0)
			redFireBalls(true);
			if(oppo2Ypos>0)
				redFireBalls2(true);
			
			opponents(true);
			opponents2(true);
			
			if(oppoYpos>0)
			redFireBalls(true);
			if(oppo2Ypos>0)
				redFireBalls2(true);
		}

//--------------------------CHANGING THE GAME ACCORDING TO DIFFICULTY DONE-----------------------------------//

		
//---------------------------STARTING THE BULLET SOUND----------------------------------------------------//
		try {
			BulletMusic();
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

//---------------------------STARTING THE BULLET SOUND----------------------------------------------------//
		try {
			LaserMusic();
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
		
//---------------------------STARTING THE BULLET SOUND----------------------------------------------------//		
		try {
			ExplosionMusic();
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
		
		
		this.setFocusable(true);
		this.setOpaque(true);
		this.setLayout(null);
//		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBounds(0, 0, WIDTH+5, HEIGHT+5);
		this.setBackground(Color.darkGray);
		this.addKeyListener(this);
		this.requestFocus();
		thread2 = new backGround();
		thread2.start();
		
		
	}
	
	
//----------------------------------METHOD TO PLAY THE GUN SOUND--------------------------------//
	public void BulletMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		bulletURL = getClass().getClassLoader().getResource("gunSound.wav");
		bulletAudio = AudioSystem.getAudioInputStream(bulletURL);
		bulletClip = AudioSystem.getClip();
		bulletClip.open(bulletAudio);
		
		
	}

//----------------------------------METHOD TO PLAY THE FIREBALL SOUND--------------------------------//
	public void LaserMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		laserURL = getClass().getClassLoader().getResource("laserSound.wav");
		laserAudio = AudioSystem.getAudioInputStream(laserURL);
		laserClip = AudioSystem.getClip();
		laserClip.open(laserAudio);
	}

//----------------------------------METHOD TO PLAY THE EXPLOSION SOUND--------------------------------//
	public void ExplosionMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		explosionURL = getClass().getClassLoader().getResource("explosionSound.wav");
		explosionAudio = AudioSystem.getAudioInputStream(explosionURL);
		explosionClip = AudioSystem.getClip();
		explosionClip.open(explosionAudio);
	}	
	
	
	public void fire() {  //this method will be called when we fire the bullets
		bullets.add(new Rectangle(fighterXpos+fighterWidth/2 -2,fighterYpos-30,10,25));
	}
	
	public void fireBall1() {  //this method will be called when we fire the blueFireBall
		fireBall1.add(new Rectangle(fighterXpos+fighterWidth/2 -10,fighterYpos-30,20,20));
		fireBall2.add(new Rectangle(fighterXpos+fighterWidth/2 -10,fighterYpos-30,20,20));
		fireBall3.add(new Rectangle(fighterXpos+fighterWidth/2 -10,fighterYpos-30,20,20));
		fireBall4.add(new Rectangle(fighterXpos+fighterWidth/2 -10,fighterYpos-30,20,20));
		fireBall5.add(new Rectangle(fighterXpos+fighterWidth/2 -10,fighterYpos-30,20,20));
	}
	
	public void opponents(boolean first) {   //this will call opponents
		oppoXpos = random.nextInt()%15;
		oppoXpos = Math.abs(oppoXpos);
		
		if(first) {
			opponent.add(new Rectangle(100*oppoXpos,oppoYpos-100-(opponent.size()*distance),oppoWidth, oppoHeight));
		}
		else {
			opponent.add(new Rectangle(100*oppoXpos,opponent.get(opponent.size()-1).y-(distance+100),oppoWidth, oppoHeight));
		}
	}
	
	public void opponents2(boolean first) {   //this will call opponent-2
		oppo2Xpos = random.nextInt()%15;
		oppo2Xpos = Math.abs(oppo2Xpos);
		
		if(first) {
			opponent2.add(new Rectangle(100*oppo2Xpos,oppo2Ypos-100-(opponent2.size()*distance),oppoWidth, oppoHeight));
		}
		else {
			opponent2.add(new Rectangle(100*oppo2Xpos,opponent2.get(opponent2.size()-1).y-(distance+100),oppoWidth, oppoHeight));
		}
	}
	
//-------------this will call the redFireBall i.e, opponents fireBall----------------------//
	public void redFireBalls(boolean firstFire) { 
		if(firstFire)
		redFireBall.add(new Rectangle(100*oppoXpos+oppoWidth/2-5,distance +oppoYpos-100-(opponent.size()*distance),20,20));
		else
			redFireBall.add(new Rectangle(100*oppoXpos+oppoWidth/2-5,30+oppoHeight+opponent.get(opponent.size()-1).y-(distance+100),20,20));
			
	}
//-----------------------this will call the redFireBall but for opponent-2-----------------//
	public void redFireBalls2(boolean firstFire) {  
		if(firstFire)
		redFireBall2.add(new Rectangle(100*oppo2Xpos+oppoWidth/2-5,distance +oppo2Ypos-100-(opponent2.size()*distance),20,20));
		else
			redFireBall2.add(new Rectangle(100*oppo2Xpos+oppoWidth/2-5,30+oppoHeight+opponent2.get(opponent2.size()-1).y-(distance+100),20,20));		
	}

//-------------------------class to create a background thread to run our background-------------------//	
	public class backGround extends Thread{  // 
	public void run()
	{ 
		
		while(true) {
			try
			{	
				
				bgYpos +=5;
				if(bgYpos>860)
					bgYpos=0;
				repaint();
				Thread.sleep(delay);
				
			}catch(Exception e){}
		}
		
	
	}
}

	
//--------------this method will paint all the graphics and components--------------------------//	
	public void paint(Graphics g) {  //
		super.paint(g);
		g.drawImage(background, 0, bgYpos, null);
		if(bgYpos>0) {
			g.drawImage(background, 0, bgYpos-860, null);
		}
		g.drawImage(fighter, fighterXpos, fighterYpos, null);
		for(Rectangle rect : bullets) {
			g.drawImage(bullet, rect.x, rect.y, null);
		}
		for(Rectangle rect : fireBall1) {
			g.drawImage(fireBall, rect.x, rect.y, null);
		}
		for(Rectangle rect : fireBall2) {
			g.drawImage(fireBall, rect.x, rect.y, null);
		}
		for(Rectangle rect : fireBall3) {
			g.drawImage(fireBall, rect.x, rect.y, null);
		}
		for(Rectangle rect : fireBall4) {
			g.drawImage(fireBall, rect.x, rect.y, null);
		}
		for(Rectangle rect : fireBall5) {
			g.drawImage(fireBall, rect.x, rect.y, null);
		}
		for(Rectangle rect : opponent) {
			g.drawImage(oppo, rect.x, rect.y, null);
		}
		for(Rectangle rect : opponent2) {
			g.drawImage(oppo, rect.x, rect.y, null);
		}
		for(Rectangle rect : redFireBall) {
			g.drawImage(redFire, rect.x, rect.y, null);
		}
		for(Rectangle rect : redFireBall2) {
			g.drawImage(redFire, rect.x, rect.y, null);
		}
		g.setColor(Color.white);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		g.drawString("Score : "+score, 1350, 100);
		g.drawString("Enemy Killed : "+oppoKill, 1350, 120);
		g.drawString("High Score : "+highScore, 1350, 140);
		g.setColor(Color.white);
		g.drawRect(1348, 38, 152, 32);
		g.setColor(Color.red);
		g.fillRect(1350, 40, counter, 30);
		if(!start) {
			g.setColor(Color.yellow);
			g.setFont(new Font(Font.MONOSPACED,Font.BOLD,70));
			g.drawString("PRESS ENTER TO START", 350, 400);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) { //it is the actionPerformed method
		// TODO Auto-generated method stub
//--------------------------CREATING, MOVING AND REMOVING COMPONENTS-----------------------------------//
		//CREATING THE BULLETS
				Rectangle rect;
				for(int i=0; i<bullets.size();i++) {
					rect = bullets.get(i);
					rect.y -=10;
//					rect.x -=5;		
				}
		//REMOVING THE BULLETS
				for(int i=0; i<bullets.size();i++) {
					rect =bullets.get(i);
					if(rect.y<0) {
						bullets.remove(rect);
					}
				}
       //CREATING THE FIREBALL  1 (the most left inclined fireBall)
				Rectangle rectFireBall1;
				for(int i=0; i<fireBall1.size();i++) {
					rectFireBall1 = fireBall1.get(i);
					rectFireBall1.y -=10;
					rectFireBall1.x -=7;		
				}
	   //REMOVING THE FIREBALL	1
				for(int i=0; i<fireBall1.size();i++) {
					rectFireBall1 =fireBall1.get(i);
					if(rectFireBall1.y<0 || rectFireBall1.x<0) {
						fireBall1.remove(rectFireBall1);
					}
				}
	//CREATING THE FIREBALL  2 (the left inclined fireBall)
				Rectangle rectFireBall2;
				for(int i=0; i<fireBall2.size();i++) {
					rectFireBall2 = fireBall2.get(i);
					rectFireBall2.y -=10;
					rectFireBall2.x -=4;		
				}
	   //REMOVING THE FIREBALL	2
				for(int i=0; i<fireBall2.size();i++) {
					rectFireBall2 =fireBall2.get(i);
					if(rectFireBall2.y<0 || rectFireBall2.x<0) {
						fireBall2.remove(rectFireBall2);
					}
				}
		//CREATING THE FIREBALL   3 (the straight fireBall)
				Rectangle rectFireBall3;
				for(int i=0; i<fireBall3.size();i++) {
					rectFireBall3 = fireBall3.get(i);
					rectFireBall3.y -=10;		
				}
	   //REMOVING THE FIREBALL	3
				for(int i=0; i<fireBall3.size();i++) {
					rectFireBall3 =fireBall3.get(i);
					if(rectFireBall3.y<0 ) {
						fireBall3.remove(rectFireBall3);
					}
				}
		//CREATING THE FIREBALL  4 (the right inclined fireBall)
				Rectangle rectFireBall4;
				for(int i=0; i<fireBall4.size();i++) {
					rectFireBall4 = fireBall4.get(i);
					rectFireBall4.y -=10;
					rectFireBall4.x +=4;		
				}
	   //REMOVING THE FIREBALL	4
				for(int i=0; i<fireBall4.size();i++) {
					rectFireBall4 =fireBall4.get(i);
					if(rectFireBall4.y<0 || rectFireBall4.x>WIDTH) {
						fireBall1.remove(rectFireBall4);
					}
				}
		//CREATING THE FIREBALL   5 (the most right inclined fireBall)
				Rectangle rectFireBall5;
				for(int i=0; i<fireBall5.size();i++) {
					rectFireBall5 = fireBall5.get(i);
					rectFireBall5.y -=10;
					rectFireBall5.x +=7;		
				}
	   //REMOVING THE FIREBALL	5
				for(int i=0; i<fireBall5.size();i++) {
					rectFireBall5 =fireBall5.get(i);
					if(rectFireBall5.y<0 || rectFireBall5.x>WIDTH) {
						fireBall1.remove(rectFireBall5);
					}
				}
		//CREATING OPPONENTS
				Rectangle rectOpponent;
				for(int i=0; i<opponent.size();i++) {
					rectOpponent = opponent.get(i);
					rectOpponent.y +=speed;
				}
	   //REMOVING OPPONENTS
				for(int i=0; i<opponent.size();i++) {
					rectOpponent =opponent.get(i);
					if(rectOpponent.y>HEIGHT) {
						opponent.remove(rectOpponent);
						opponents(false);
						if(oppoYpos>10)
						redFireBalls(false);
					}
				}
				//CREATING OPPONENT 2
				Rectangle rectOpponent2;
				for(int i=0; i<opponent2.size();i++) {
					rectOpponent2 = opponent2.get(i);
					rectOpponent2.y +=speed;
				}
	   //REMOVING OPPONENT 2
				for(int i=0; i<opponent2.size();i++) {
					rectOpponent2 =opponent2.get(i);
					if(rectOpponent2.y>HEIGHT) {
						opponent2.remove(rectOpponent2);
						opponents2(false);
						if(oppo2Ypos>10)
						redFireBalls2(false);
					}
				}
//		MOVING OPPONENTS FIREBALL
				Rectangle rectRedFire;
				for(int i=0; i<redFireBall.size();i++) {
					rectRedFire = redFireBall.get(i);
					rectRedFire.y +=ballSpeed;
					
				}
	   //REMOVING OPPONENTS FIREBALL
				for(int i=0; i<redFireBall.size();i++) {
					rectRedFire =redFireBall.get(i);
					if(rectRedFire.y>HEIGHT) {
						redFireBall.remove(rectRedFire);
					}
				}
//		MOVING OPPONENTS FIREBALL
				Rectangle rectRedFire2;
				for(int i=0; i<redFireBall2.size();i++) {
					rectRedFire2 = redFireBall2.get(i);
					rectRedFire2.y +=ballSpeed;
							
				}
 //REMOVING OPPONENTS FIREBALL
	     	for(int i=0; i<redFireBall2.size();i++) {
					rectRedFire2 =redFireBall2.get(i);
					if(rectRedFire2.y>HEIGHT) {
					redFireBall2.remove(rectRedFire2);
					}
			}
//--------------------------CREATING , MOVING AND REMOVING COMPONENTS DONE-----------------------------------//
	     	
//---------------------------CHECKING COLLLISION OF BULLETS AND ENEMY-----------------------------------//
	     	Rectangle bullet1,oppo1Jet,oppo2Jet; //creating variable rectangles
	     	if(Bullet) {
	     		for(int i=0; i<bullets.size();i++) {
	     			bullet1 =bullets.get(i);   //bullet1 will store the bullet rectangle
	     			for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(bullet1.intersects(oppo1Jet)) {
							oppoKill +=1;
							score +=50;
							if(score>=highScore) 
								highScore+=50;
							tempScore +=50;
	     					opponent.remove(j);        //removing opponent 1
	     					opponents(false);        //calling another opponent 1
	     					if(oppoYpos>0)
	     						redFireBalls(true);  //calling the fireBall of opponent
	     				}
	     				if(bullet1.intersects(oppo2Jet) && k<opponent2.size()) {
							oppoKill +=1;
							score +=50;
							if(score>=highScore) 
								highScore+=50;
							tempScore +=50;
	     					opponent2.remove(k);
	     					opponents2(false);
	     					if(oppo2Ypos>0)
	     						redFireBalls2(true);
	     				}	
	     			}
	     		}
	     	}
//--------------------------CHECKING COLLLISION OF BULLETS AND DONE-----------------------------------//	     	
	     	
//--------------------------CHECKING COLLLISION OF FIREBALLS AND ENEMY-----------------------------------//
	     	Rectangle rectBlueFireBall1, rectBlueFireBall2, rectBlueFireBall3, rectBlueFireBall4, rectBlueFireBall5;
	     	if(!Bullet) {
	     		for(int i=0; i<fireBall1.size();i++) {
	     			  rectBlueFireBall1 = fireBall1.get(i);//this will store the fireBall rectangle
	     			  for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(rectBlueFireBall1.intersects(oppo1Jet) || rectBlueFireBall1.intersects(oppo2Jet) ) {
							score +=1;
							if(score>=highScore) 
								highScore+=1;
							tempScore +=1;
	     				}
	     			}
	     		}
	     	}
	     	if(!Bullet) {
	     		for(int i=0; i<fireBall2.size();i++) {
	     			  rectBlueFireBall2 = fireBall2.get(i);//this will store the fireBall rectangle
	     			  for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(rectBlueFireBall2.intersects(oppo1Jet) || rectBlueFireBall2.intersects(oppo2Jet) ) {
							score +=1;
							if(score>=highScore) 
								highScore+=1;
							tempScore +=1;
	     				}
	     				
	     			}
	     		}
	     	}
	     	if(!Bullet) {
	     		for(int i=0; i<fireBall3.size();i++) {
	     			  rectBlueFireBall3 = fireBall3.get(i);//this will store the fireBall rectangle
	     			  for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(rectBlueFireBall3.intersects(oppo1Jet) || rectBlueFireBall3.intersects(oppo2Jet) ) {
							score +=1;
							if(score>=highScore) 
								highScore+=1;
							tempScore +=1;
	     				}
	     			}
	     		}
	     	}
	     	if(!Bullet) {
	     		for(int i=0; i<fireBall4.size();i++) {
	     			  rectBlueFireBall4 = fireBall4.get(i);//this will store the fireBall rectangle
	     			  for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(rectBlueFireBall4.intersects(oppo1Jet) || rectBlueFireBall4.intersects(oppo2Jet)) {
							score +=1;
							if(score>=highScore) 
								highScore+=1;
							tempScore +=1;
	     				}
	     			}
	     		}
	     	}
	     	if(!Bullet) {
	     		for(int i=0; i<fireBall5.size();i++) {
	     			  rectBlueFireBall5 = fireBall5.get(i);//this will store the fireBall rectangle
	     			  for(int j=0, k=0;j<opponent.size() && k<opponent2.size();j++,k++) {   //two variable j and k for two opponents
	     				oppo1Jet = opponent.get(j);     //value of opponent 1 rectangle given in oppo1Jet
	     				oppo2Jet =opponent2.get(k);   //value of opponent 2 rectangle given in oppo2Jet
	     				if(rectBlueFireBall5.intersects(oppo1Jet) || rectBlueFireBall5.intersects(oppo2Jet)) {
							score +=1;
							if(score>=highScore) 
								highScore+=1;
							tempScore +=1;
	     				}
	     			}
	     		}
	     	}
//--------------------------CHECKING COLLLISION OF FIREBALLS AND ENEMY IS DONE-----------------------------------//
			
//--------------------------CHECKING COLLLISION OF  ENEMIES FIREBALL AND PLAYER-----------------------------------//
	     	for(Rectangle redFire1:redFireBall) {
	     		if(redFire1.x>fighterXpos && redFire1.x< fighterXpos + fighterWidth && redFire1.y>fighterYpos -fighterHeight  && redFire1.y<fighterYpos) {
	     			counter -=3;
	     		}
	     		
	     	}
	     	for(Rectangle redFire2:redFireBall2) {
	     		if(redFire2.x>fighterXpos && redFire2.x< fighterXpos + fighterWidth && redFire2.y>fighterYpos -fighterHeight  && redFire2.y<fighterYpos) {
	     			counter -=3;
	     		}
	     	}
	     	
//--------------------------CHECKING COLLLISION OF ENEMIES FIREBALL AND PLAYER-----------------------------------//	     	

//--------------------------CHECKING COLLLISION OF ENEMIES AND PLAYER-----------------------------------//
	     	for(Rectangle redFire1:opponent) {
	     		if((redFire1.x>fighterXpos && redFire1.x< fighterXpos + fighterWidth	&& redFire1.y>fighterYpos -fighterHeight && redFire1.y<fighterYpos) 
	     		|| (redFire1.x + oppoWidth>fighterXpos && redFire1.x + oppoWidth< fighterXpos + fighterWidth	&& redFire1.y>fighterYpos -fighterHeight && redFire1.y<fighterYpos)) {
	     			counter -=1;
	     		}
	     		
	     	}
	     	for(Rectangle redFire2:opponent2) {
	     		if((redFire2.x>fighterXpos && redFire2.x< fighterXpos + fighterWidth && redFire2.y>fighterYpos -fighterHeight && redFire2.y<fighterYpos)
	     		|| (redFire2.x + oppoWidth>fighterXpos && redFire2.x + oppoWidth< fighterXpos + fighterWidth	&& redFire2.y>fighterYpos -fighterHeight && redFire2.y<fighterYpos)) {
	     			counter -=1;
	     		}
	     	}
	     	
//--------------------------CHECKING COLLLISION OF ENEMIES AND PLAYER-----------------------------------//	     	

	     	if(counter<=0) {//stop the game when life is zero
	     		gameOver =true;
	     	}
	     	if(gameOver) {
	     		if(sound)
	     		 explosionClip.loop(0);
	     		playing=false;
	     		thread2.stop();
	     		
	     	}
	     	
	     	if(tempScore>speed*350) {  //increasing the speed
	     		speed +=1;
	     		tempScore =0;
	     	}

			if(!playing)
				timer.stop();
				repaint();
				
				counterf++;	
			if(counterf==10) {
				counterf=0;
				if(Bullet && autoFiring) {
					fire();
					if(sound) {
						bulletClip.loop(1);
					   }
					}else if(!Bullet && autoFiring){
						fireBall1();
						if(sound)
						laserClip.loop(1);
					}
			}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) { //this contains all the controls 
		// TODO Auto-generated method stub
		if(!gameEnd){
		if(playing) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT && fighterXpos>0) {
			if(difficulty ==3)
				fighterXpos -=43;
			fighterXpos -=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD4 && fighterXpos>0+5) {
			if(difficulty ==3)
				fighterXpos -=45;
			fighterXpos -=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && fighterXpos+fighterWidth<WIDTH) {
			if(difficulty ==3)
				fighterXpos +=43;
			fighterXpos +=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD6 && fighterXpos+fighterWidth<WIDTH-5) {
			if(difficulty ==3)
				fighterXpos +=45;
			fighterXpos +=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN && fighterYpos+fighterHeight<HEIGHT) {
			if(difficulty ==3)
				fighterYpos +=43;
			fighterYpos +=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD2 && fighterYpos+fighterHeight<HEIGHT-5) {
			if(difficulty ==3)
				fighterYpos +=45;
			fighterYpos +=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP && fighterYpos>0) {
			if(difficulty ==3)
				fighterYpos -=43;
			fighterYpos -=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD8 && fighterYpos>0+5) {
			if(difficulty ==3)
				fighterYpos -=45;
			fighterYpos -=25;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) { //firing the bullets/fireBalls
			if(!autoFiring) {
			if(Bullet ) {
			fire();
			if(sound) {
				bulletClip.loop(1);
			   }
			}else if(!Bullet){
				fireBall1();
				if(sound)
				laserClip.loop(1);
			}
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_R) {  //reloading the firing by switching from bullets to fireBall and vice versa
			if(Bullet) {
				Bullet =false;
			}else if(!Bullet) {
				Bullet = true;
			}
		}
	}
		
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {  //pause/play the game
			if(playing ) {
				timer.stop();
				playing =false;
				paused =true;
				
			}else if(!playing  ) {
				timer.start();
				playing = true;
				paused=false;
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			timer.start();
			start=true;
		}
//		if(score>highScore) {
//			highScore=score;
//			
//		}
		
	}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
