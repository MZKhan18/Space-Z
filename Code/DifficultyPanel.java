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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DifficultyPanel extends JPanel implements ActionListener, MouseListener{
		
		
	ImageIcon bg;
	JLabel label;
	JButton easy;
	JButton medium;
	JButton hard;
	JButton veryHard;
	JButton back;
	JButton select;
	JLabel easyl;
	JLabel mediuml;
	JLabel hardl;
	JLabel veryHardl;
	JLabel backl;
	JLabel selectl;
	ImageIcon labelImage;
	Border border;
	boolean easyb;
	boolean mediumb;
	boolean hardb;
	boolean veryHardb;
	static boolean backb;
	static boolean selectb;
	
	
	
			
	DifficultyPanel(){
		easyb=false;
		mediumb=false;
		hardb=false;
		veryHardb=false;
		
		labelImage = new ImageIcon(getClass().getClassLoader().getResource("labelImage.png"));
		border = BorderFactory.createLineBorder(Color.green,3);
//------Setting the background through label -----------//
		bg = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg"));
		label = new JLabel();
		label.setText("");
		label.setIcon(bg);
		label.setOpaque(true);
		label.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		label.setBounds(0, 0, 1535, 863);
		
//------------------------Easy button---------------------------//
		easyl=new JLabel();
		easyl.setBounds(580,255, 40, 40);
		easyl.setOpaque(true);
		easyl.setIcon(bg);
		
		easy = new JButton();
		easy.setText("Easy");
		easy.setBounds(625,250,200,50);
		easy.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		easy.setForeground(Color.white);
		easy.setVerticalTextPosition(JButton.CENTER);
		easy.setHorizontalTextPosition(JButton.CENTER);
		easy.setIcon(bg);
		easy.setContentAreaFilled(false);
		easy.setBorder(null);
		easy.addActionListener(this);
		easy.addMouseListener(this);
		
//------------------------medium button---------------------------//
		mediuml=new JLabel();
		mediuml.setBounds(580,345, 40, 40);
		mediuml.setOpaque(true);
		mediuml.setIcon(bg);
		
		medium = new JButton();
		medium.setText("Medium");
		medium.setBounds(625,320+20,200,50);
		medium.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		medium.setForeground(Color.white);
		medium.setVerticalTextPosition(JButton.CENTER);
		medium.setHorizontalTextPosition(JButton.CENTER);
		medium.setIcon(bg);
		medium.setContentAreaFilled(false);
		medium.setBorder(null);
		medium.addActionListener(this);
		medium.addMouseListener(this);
		
//------------------------hard button---------------------------//
		hardl=new JLabel();
		hardl.setBounds(580,435, 40, 40);
		hardl.setOpaque(true);
		hardl.setIcon(bg);
		
		hard = new JButton();
		hard.setText("Hard");
		hard.setBounds(625,390+40,200,50);
		hard.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		hard.setForeground(Color.white);
		hard.setVerticalTextPosition(JButton.CENTER);
		hard.setHorizontalTextPosition(JButton.CENTER);
		hard.setIcon(bg);
		hard.setContentAreaFilled(false);
		hard.setBorder(null);
		hard.addActionListener(this);
		hard.addMouseListener(this);	
		
//------------------------veryHard button---------------------------//
		veryHardl=new JLabel();
		veryHardl.setBounds(580,525, 40, 40);
		veryHardl.setOpaque(true);
		veryHardl.setIcon(bg);
		
		veryHard = new JButton();
		veryHard.setText("Very Hard");
		veryHard.setBounds(625,460+60,200,50);
		veryHard.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		veryHard.setForeground(Color.white);
		veryHard.setVerticalTextPosition(JButton.CENTER);
		veryHard.setHorizontalTextPosition(JButton.CENTER);
		veryHard.setIcon(bg);
		veryHard.setContentAreaFilled(false);
		veryHard.setBorder(null);
		veryHard.addActionListener(this);
		veryHard.addMouseListener(this);

//------------------------Back button---------------------------//
		backl=new JLabel();
		backl.setBounds(435-45,655, 40, 40);
		backl.setOpaque(true);
		backl.setIcon(bg);
		
		back = new JButton();
		back.setText("Back");
		back.setBounds(435,650,200,50);
		back.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		back.setForeground(Color.white);
		back.setVerticalTextPosition(JButton.CENTER);
		back.setHorizontalTextPosition(JButton.CENTER);
		back.setIcon(bg);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.addActionListener(this);
		back.addMouseListener(this);		
		
//------------------------Select button---------------------------//
		selectl=new JLabel();
		selectl.setBounds(815-45,655, 40, 40);
		selectl.setOpaque(true);
		selectl.setIcon(bg);
		
		select = new JButton();
		select.setText("Select");
		select.setBounds(815,650,200,50);
		select.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		select.setForeground(Color.white);
		select.setVerticalTextPosition(JButton.CENTER);
		select.setHorizontalTextPosition(JButton.CENTER);
		select.setIcon(bg);
		select.setEnabled(false);
		select.setContentAreaFilled(false);
		select.addActionListener(this);
		select.addMouseListener(this);
		
		
		this.add(easyl);
		this.add(backl);
		this.add(hardl);
		this.add(veryHardl);
		this.add(selectl);
		this.add(mediuml);
		this.add(back);
		this.add(select);
		this.add(hard);
		this.add(veryHard);
		this.add(medium);
		this.add(easy);
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
		g2.setStroke(new BasicStroke(1));

		g2.drawRect(625,250,200,50);
		g2.drawRect(625+2,250+2,200-4,50-4);
		g2.drawRect(625,320+20,200,50);
		g2.drawRect(625+2,320+2+20,200-4,50-4);
		g2.drawRect(625,390+40,200,50);
		g2.drawRect(625+2,390+2+40,200-4,50-4);
		g2.drawRect(625,460+60,200,50);
		g2.drawRect(625+2,460+2+60,200-4,50-4);
		g2.drawRect(435,650,200,50);
		g2.drawRect(435+2,650+2,200-4,50-4);
		g2.drawRect(815,650,200,50);
		g2.drawRect(815+2,650+2,200-4,50-4);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==easy) {
			MenuPanel.clickClip.loop(1);
			easy.setBorder(border);
			medium.setBorder(null);
			hard.setBorder(null);
			veryHard.setBorder(null);
			select.setEnabled(true);
			easyb=true;
			mediumb=false;
			hardb=false;
			veryHardb=false;
		}
		if(e.getSource()==medium) {
			MenuPanel.clickClip.loop(1);
			medium.setBorder(border);
			easy.setBorder(null);
			hard.setBorder(null);
			veryHard.setBorder(null);
			select.setEnabled(true);
			easyb=false;
			mediumb=true;
			hardb=false;
			veryHardb=false;
		}
		if(e.getSource()==hard) {
			MenuPanel.clickClip.loop(1);
			hard.setBorder(border);
			easy.setBorder(null);
			medium.setBorder(null);
			veryHard.setBorder(null);
			select.setEnabled(true);
			easyb=false;
			mediumb=false;
			hardb=true;
			veryHardb=false;
		}
		if(e.getSource()==veryHard) {
			MenuPanel.clickClip.loop(1);
			veryHard.setBorder(border);
			easy.setBorder(null);
			medium.setBorder(null);
			hard.setBorder(null);
			select.setEnabled(true);
			easyb=false;
			mediumb=false;
			hardb=false;
			veryHardb=true;
		}
		if(e.getSource()==back) {
			MenuPanel.clickClip.loop(1);
			backb=true;
		}
		if(e.getSource()==select && select.isEnabled()) {
			MenuPanel.clickClip.loop(1);
			if(easyb) SpaceZPanel.difficulty =0;
			if(mediumb) SpaceZPanel.difficulty =1;
			if(hardb) SpaceZPanel.difficulty =2;
			if(veryHardb) SpaceZPanel.difficulty =3;
			selectb=true;
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
		if(e.getSource()==easy) {
			easyl.setBackground(new Color(0,1,22));
			easyl.setIcon(labelImage);
		}
		if(e.getSource()==medium) {
			mediuml.setBackground(new Color(0,1,22));
			mediuml.setIcon(labelImage);
		}
		if(e.getSource()==hard) {
			hardl.setBackground(new Color(0,1,22));
			hardl.setIcon(labelImage);
		}
		if(e.getSource()==veryHard) {
			veryHardl.setBackground(new Color(0,1,22));
			veryHardl.setIcon(labelImage);
		}
		if(e.getSource()==back) {
			backl.setBackground(new Color(0,1,22));
			backl.setIcon(labelImage);
		}
		if(e.getSource()==select) {
			selectl.setBackground(new Color(0,1,22));
			selectl.setIcon(labelImage);
		}
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==easy) {
			easyl.setIcon(bg);
		}
		if(e.getSource()==medium) {
			mediuml.setIcon(bg);
		}
		if(e.getSource()==hard) {
			hardl.setIcon(bg);
		}
		if(e.getSource()==veryHard) {
			veryHardl.setIcon(bg);
		}
		if(e.getSource()==back) {
			backl.setIcon(bg);
		}
		if(e.getSource()==select) {
			selectl.setIcon(bg);
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
