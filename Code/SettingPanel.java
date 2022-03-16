package spaceZ;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingPanel extends JPanel implements ActionListener, MouseListener {
	ImageIcon bg;
	JLabel label;
	JLabel sound;
	JLabel soundOn;
	JLabel soundOff;
	static boolean soundOnb=true;
	static boolean soundOffb =false;
	JLabel music;
	JLabel musicOn;
	JLabel musicOff;
	static boolean musicOnb = true;
	static boolean musicOffb = false;
	JLabel firing;
	JLabel auto;
	JLabel manual;
	static boolean autob =false;
	static boolean manualb =true;
	JLabel save;
	static boolean saveb;
	JLabel back;
	static boolean backb;
	
	SettingPanel(){
		saveb = false;
		backb = false;
		
		bg = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg"));
		label = new JLabel();
		label.setText("");
		label.setIcon(bg);
		label.setOpaque(true);
		label.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		label.setBounds(0, 0, 1535, 863);
		
		
//--------------------SOUND LABEL AND RADIO BUTTONS(ON AND OFF)---------------------//
		sound = new JLabel();
		sound.setText("Sound");
		sound.setBounds(470,250,200,50);
		sound.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		sound.setForeground(Color.white);
		sound.setVerticalTextPosition(JButton.CENTER);
		sound.setHorizontalTextPosition(JButton.CENTER);
		sound.addMouseListener(this);
		
		soundOn = new JLabel("ON");
		soundOn.setBounds(710,255,65,40);
		soundOn.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		soundOn.setForeground(Color.white);
		soundOn.setHorizontalAlignment(JLabel.CENTER);
		soundOn.addMouseListener(this);
		
		soundOff = new JLabel("OFF");
		soundOff.setBounds(860,255,80,40);
		soundOff.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		soundOff.setForeground(Color.white);
		soundOff.setHorizontalAlignment(JLabel.CENTER);
		soundOff.addMouseListener(this);
		
		
///--------------------firing LABEL AND RADIO BUTTONS(ON AND OFF)---------------------//		
		firing = new JLabel();
		firing.setText("Firing");
		firing.setBounds(470,400-20,200,50);
		firing.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		firing.setForeground(Color.white);
		firing.setVerticalTextPosition(JButton.CENTER);
		firing.setHorizontalTextPosition(JButton.CENTER);
		firing.addMouseListener(this);
		
		auto = new JLabel("AUTO");
		auto.setBounds(710,405-20,95,40);
		auto.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		auto.setForeground(Color.white);
		auto.setHorizontalAlignment(JLabel.CENTER);
		auto.addMouseListener(this);
		
		manual = new JLabel("MANUAL");
		manual.setBounds(860,405-20,150,40);
		manual.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		manual.setForeground(Color.white);
		manual.setHorizontalAlignment(JLabel.CENTER);
		manual.addMouseListener(this);		
		
		
		save = new JLabel();
		save.setText("Save");
		save.setBounds(860-40,605,200,50);
		save.setFont(new Font(Font.SERIF, Font.BOLD, 60));
		save.setForeground(Color.white);
		save.setHorizontalAlignment(JLabel.CENTER);
		save.addMouseListener(this);
		
		back = new JLabel();
		back.setText("Back");
		back.setBounds(460,605,200,50);
		back.setFont(new Font(Font.SERIF, Font.BOLD, 60));
		back.setForeground(Color.white);
		back.setHorizontalAlignment(JLabel.CENTER);
		back.addMouseListener(this);
		
		this.add(back);
		this.add(save);
		this.add(firing);
		this.add(manual);
		this.add(auto);
		this.add(soundOff);
		this.add(soundOn);
		this.add(sound);
		this.add(label);
		this.setFocusable(true);
		this.setOpaque(true);
		this.setLayout(null);
		this.setBounds(0, 0, SpaceZPanel.WIDTH+5, SpaceZPanel.HEIGHT+5);
		this.setBackground(Color.black);
		this.requestFocus();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 =(Graphics2D)g;
		g2.setColor(Color.white);
		g2.drawRect(400,200, 670, 500);
		g2.drawRect(400+2,200+2, 670-4, 500-4);
		g2.drawRect(400+4,200+4, 670-8, 500-8);
		g2.drawRect(400,200, 670, 340);
		g2.drawRect(400+2,200+2, 670-4, 340-4);
		
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(860-40,600,200,62);
		g2.drawRect(860-40+2,600+2,200-4,62-4);
		g2.drawRect(460,600,200,62);
		g2.drawRect(460+2,600+2,200-4,62-4);
		
//-----------------------SOUND ON/OFF BUTTON -------------------------------//
		g2.setStroke(new BasicStroke(1));
		g2.drawRect(470-10,250,130,50);   //sound button
		g2.drawRect(470+2-10,250+2,130-4,50-4);  //sound button
		g2.drawRect(710,255,65,40);   //sound On
		g2.drawRect(710+1,255+1,65-2,40-2);
		g2.drawRect(860,255,80,40);   //sound off
		g2.drawRect(860+1,255+1,80-2,40-2);
		
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(680, 268, 20, 20);  //sound on
		g2.drawOval(830, 268, 20, 20);   //sound off
		if(soundOnb) {
			g2.setColor(Color.green);
			g2.fillOval(680, 268, 20, 20);
		}else if(soundOffb) {
			g2.setColor(Color.green);
			g2.fillOval(830, 268, 20, 20);	
		}
		

	
//-----------------------FIRING AUTO/MANUAL BUTTON---------------------//		
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.white);
		g2.drawRect(470-10,400-20,130,50);   //firing button
		g2.drawRect(470+2-10,400+2-20,130-4,50-4);  //firing button
		g2.drawRect(710,405-20,95,40);   //firing button
		g2.drawRect(710+1,405+1-20,95-2,40-2);  //firing button
		g2.drawRect(860,405-20,150,40);   //firing button
		g2.drawRect(860+1,405+1-20,150-2,40-2);  //firing button
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(680, 418-20, 20, 20);  //auto
		g2.drawOval(830, 418-20, 20, 20);   //Manual
		if(autob) {
			g2.setColor(Color.green);
			g2.fillOval(680, 418-20, 20, 20);
		}else if(manualb) {
			g2.setColor(Color.green);
			g2.fillOval(830, 418-20, 20, 20);	
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==soundOn) {
			MenuPanel.clickClip.loop(1);
			soundOnb = true;
			soundOffb = false;
		}
		if(e.getSource()==soundOff) {
			MenuPanel.clickClip.loop(1);
			soundOffb = true;
			soundOnb = false;
		}
		if(e.getSource()==auto) {
			MenuPanel.clickClip.loop(1);
			autob = true;
			manualb = false;
		}
		if(e.getSource()==manual) {
			MenuPanel.clickClip.loop(1);
			autob = false;
			manualb = true;
		}
		if(e.getSource()==back) {
			MenuPanel.clickClip.loop(1);
			backb=true;
		}
		if(e.getSource()==save) {
			MenuPanel.clickClip.loop(1);
			if(soundOnb) {
				SpaceZPanel.sound =true;
			}
			if(soundOffb) {
				SpaceZPanel.sound =false;
			}
			if(autob) {
				SpaceZPanel.autoFiring = true;
			}
			if(manualb) {
				SpaceZPanel.autoFiring = false;
			}
			saveb=true;
		}
		repaint();
		
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
