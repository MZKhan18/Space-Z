package spaceZ;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

public class PlanePanel extends JPanel implements ActionListener, MouseListener{
		
	ImageIcon bg;
	ImageIcon fighter1;
	ImageIcon fighter2;
	ImageIcon fighter3;
	JLabel plane1;
	JLabel plane2;
	JLabel plane3;
	boolean plane1b;
	boolean plane2b;
	boolean plane3b;
	JLabel label;
	JButton back;
	JButton select;
	static boolean backb;
	static boolean selectb;
	Border border;
	PlanePanel(){
		border = BorderFactory.createLineBorder(Color.green,7);
		bg = new ImageIcon(getClass().getClassLoader().getResource("bg1.jpg"));
		label = new JLabel();
		label.setText("");
		label.setIcon(bg);
		label.setOpaque(true);
		label.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		label.setBounds(0, 0, 1535, 863);
		
		plane1b=false;
		plane2b=false;
		plane3b=false;
		backb=false;
		selectb=false;
		

		fighter2 = new ImageIcon(getClass().getClassLoader().getResource("plane2.png"));
		fighter3 = new ImageIcon(getClass().getClassLoader().getResource("plane3.gif"));
		fighter1 = new ImageIcon(getClass().getClassLoader().getResource("plane1.png"));
			
//-----------------------------Plane 1-------------------------//
			plane1 =new JLabel(fighter1,JLabel.CENTER);
			plane1.setBounds(160,200,250,250);
			plane1.addMouseListener(this);
//-----------------------------Plane 2-------------------------//
			plane2 =new JLabel(fighter2,JLabel.CENTER);
			plane2.setBounds(640,200,250,250);
			plane2.addMouseListener(this);
//-----------------------------Plane 1-------------------------//
			plane3 =new JLabel(fighter3,JLabel.CENTER);
			plane3.setBounds(1120,200,250,250);
			plane3.addMouseListener(this);
//--------------------back button-----------------------------//
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
//---------------select button----------------------------//
			select = new JButton();
			select.setText("Select");
			select.setBounds(790,650,200,50);
			select.setFont(new Font(Font.SERIF, Font.BOLD, 40));
			select.setForeground(Color.white);
			select.setVerticalTextPosition(JButton.CENTER);
			select.setHorizontalTextPosition(JButton.CENTER);
			select.setIcon(bg);
			select.setEnabled(false);
			select.setContentAreaFilled(false);
			select.addActionListener(this);
			select.addMouseListener(this);
			
			
			
		this.add(back);
		this.add(select);
		this.add(plane2);
		this.add(plane3);
		this.add(plane1);
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
		g2.drawRect(435,650,200,50);
		g2.drawRect(435+2,650+2,200-4,50-4);
		g2.drawRect(790,650,200,50);
		g2.drawRect(790+2,650+2,200-4,50-4);
		g2.setStroke(new BasicStroke(3));
		
		g2.drawRect(160,200,250,250);
		g2.drawRect(160+2,200+2,250-4,250-4);
		g2.drawRect(640,200,250,250);
		g2.drawRect(640+2,200+2,250-4,250-4);
		g2.drawRect(1120,200,250,250);
		g2.drawRect(1120+2,200+2,250-4,250-4);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==plane1) {
			MenuPanel.clickClip.loop(1);
			plane1.setBorder(border);
			plane2.setBorder(null);
			plane2.setBorder(null);
			plane1b=true;
			plane2b=false;
			plane3b=false;
			select.setEnabled(true);
		}
		if(e.getSource()==plane2) {
			MenuPanel.clickClip.loop(1);
			plane2.setBorder(border);
			plane1.setBorder(null);
			plane3.setBorder(null);
			plane2b=true;
			plane1b=false;
			plane3b=false;
			select.setEnabled(true);
		}
		if(e.getSource()==plane3) {
			MenuPanel.clickClip.loop(1);
			plane3.setBorder(border);
			plane1.setBorder(null);
			plane2.setBorder(null);
			plane3b=true;
			plane2b=false;
			plane1b=false;
			select.setEnabled(true);
		}
		
		if(e.getSource()==select && select.isEnabled()) {
			MenuPanel.clickClip.loop(1);
			selectb=true;
			if(plane1b) SpaceZPanel.plane=1;
			if(plane2b) SpaceZPanel.plane=2;
			if(plane3b) SpaceZPanel.plane=3;
		}
		
		if(e.getSource()==back) {
			MenuPanel.clickClip.loop(1);
			backb=true;
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
