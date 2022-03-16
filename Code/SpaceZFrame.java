package spaceZ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpaceZFrame extends JFrame implements ActionListener{
	boolean tempBool=false;
	MenuPanel menu;
	SpaceZPanel panel;
	Timer timer;
	GameOverPanel panelOver;
	GamePausePanel panelPaused;
	DifficultyPanel panelDiff;
	PlanePanel panelPlane;
	SettingPanel settingPanel;
	JLayeredPane lp;
	SpaceZFrame(){
		tempBool=false;
		lp = new JLayeredPane();
		lp.setLayout(null);
		lp.setBounds(0, 0, panel.WIDTH+5, panel.HEIGHT+5);
		
		
		timer = new Timer(20,this);
		menu = new MenuPanel();
		panel =new SpaceZPanel();
		
		
		timer.start();
		lp.add(menu,Integer.valueOf(1));
		this.add(lp);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//--------------START GAME CODE--------------------------//
		if(MenuPanel.startGame) {
			MenuPanel.startGame=false;
			lp.remove(menu);
			panel = new SpaceZPanel();
			lp.add(panel,Integer.valueOf(1));
			panel.requestFocusInWindow();
			SwingUtilities.updateComponentTreeUI(this);
		}
		
//-------------DIFFICULTY OPTION CODE--------------------//
		if(MenuPanel.difficulty) {
			MenuPanel.difficulty=false;
			lp.remove(menu);
			panelDiff = new DifficultyPanel();
			lp.add(panelDiff, Integer.valueOf(1));
		}
		if(DifficultyPanel.backb) {
			DifficultyPanel.backb=false;
			lp.remove(panelDiff);
			menu = new MenuPanel();
			lp.add(menu);
		}
		if(DifficultyPanel.selectb) {
			DifficultyPanel.selectb=false;
			lp.remove(panelDiff);
			menu = new MenuPanel();
			lp.add(menu);
		}

//---------------PLANE TYPE OPPTION CODE------------------//
		if(MenuPanel.planeType) {
			MenuPanel.planeType=false;
			lp.remove(menu);
			panelPlane=new PlanePanel();
			lp.add(panelPlane,Integer.valueOf(1));
		}
		if(PlanePanel.backb) {
			PlanePanel.backb=false;
			lp.remove(panelPlane);
			menu = new MenuPanel();
			lp.add(menu);
		}
		if(PlanePanel.selectb) {
			PlanePanel.selectb=false;
			lp.remove(panelPlane);
			menu = new MenuPanel();
			lp.add(menu);
		}
		
//-----------------SETTING PANEL------------------------------//
		if(MenuPanel.settings) {
			MenuPanel.settings = false;
			lp.remove(menu);
			settingPanel = new SettingPanel();
			lp.add(settingPanel,Integer.valueOf(1));
		}
		if(SettingPanel.backb) {
			SettingPanel.backb = false;
			lp.remove(settingPanel);
			menu = new MenuPanel();
			lp.add(menu);
		}
		if(SettingPanel.saveb) {
			SettingPanel.saveb =false;
			lp.remove(settingPanel);
			menu = new MenuPanel();
			lp.add(menu);
		}
		
//----------------GAME OVER CODE-----------------------------//
		if(SpaceZPanel.gameOver) {
				SpaceZPanel.gameOver=false;
				SpaceZPanel.gameEnd=true;
				panelOver =new GameOverPanel();
				lp.add(panelOver,Integer.valueOf(2));
			
		}
		
//---------------START NEW GAME CODE--------------------------//
		if(GameOverPanel.startNewGame) {
			GameOverPanel.startNewGame=false;
			lp.remove(panelOver);
			lp.remove(panel);
			panel = new SpaceZPanel();
			lp.add(panel,Integer.valueOf(1));
			panel.requestFocusInWindow();
			SwingUtilities.updateComponentTreeUI(this);
			
		}
		
//--------------------PAUSE GAME CODE-------------------------//
		if(SpaceZPanel.paused && !tempBool ) { //when game is paused that is escape button is pressed
			tempBool=true;
			panelPaused = new GamePausePanel();
			lp.add(panelPaused,Integer.valueOf(2));
		}
		if(!SpaceZPanel.paused && tempBool) {  //resuming the game and removing the pause menu
			tempBool=false;
			lp.remove(panelPaused);
		}

		
//--------------------QUIT GAME CODE---------------------------------//
		if(GameOverPanel.quitGame) {
			GameOverPanel.quitGame=false;
			lp.remove(panel);
			lp.remove(panelOver);
			menu = new MenuPanel();
			lp.add(menu,Integer.valueOf(1));
		}
		
		if(GamePausePanel.quitGame) {
			GamePausePanel.quitGame=false;
			lp.remove(panel);
			lp.remove(panelPaused);
			menu = new MenuPanel();
			lp.add(menu,Integer.valueOf(1));
		}

//-----------------START NEW GAME(RESTART CODE------------------//
		if(GamePausePanel.startNewGame) {
			GamePausePanel.startNewGame=false;
			lp.remove(panelPaused);
			lp.remove(panel);
			panel = new SpaceZPanel();
			lp.add(panel,Integer.valueOf(1));
			panel.requestFocusInWindow();
			SwingUtilities.updateComponentTreeUI(this);
			
		}
		
		
		
	}
}
