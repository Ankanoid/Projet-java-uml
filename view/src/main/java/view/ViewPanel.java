package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	char[][] tabmap ;
	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.viewFrame.getModel().doTheThing();
		this.repaint();
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
	    
		if(this.viewFrame.getModel().getLevel() == 0)
		{ 
			
			this.viewFrame.getModel().loadHighScore("map1");
			int scoremap1 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map2");
			int scoremap2 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map3");
			int scoremap3 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map4");
			int scoremap4 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map5");
			int scoremap5 = this.viewFrame.getModel().getHighScore();
			
			Font fonte = new Font("TimesRoman ",Font.BOLD,30);
			graphics.setFont(fonte);
			graphics.setColor(Color.white);
			graphics.drawString("Highscores : ",225,75);
			graphics.drawString("Map 1 : " + scoremap1,150,150);
			graphics.drawString("Map 2 : " + scoremap2,150,200);
			graphics.drawString("Map 3 : " + scoremap3,150,250);
			graphics.drawString("Map 4 : " + scoremap4,150,300);
			graphics.drawString("Map 5 : " + scoremap5,150,350);
		}
			
		if(this.viewFrame.getModel().getLevel() == 1 || this.viewFrame.getModel().getLevel() == 2 || this.viewFrame.getModel().getLevel() == 3 || this.viewFrame.getModel().getLevel() == 4 || this.viewFrame.getModel().getLevel() == 5)
		{
			Font fonte = new Font("TimesRoman ",Font.BOLD,30);
			graphics.setFont(fonte);
			graphics.setColor(Color.white);
			graphics.drawString("Niveau : " + this.viewFrame.getModel().getLevel(),60,410);
			graphics.drawString("Score : " + this.viewFrame.getModel().getScore(),60,440);
			
			this.viewFrame.getModel().moveM1();
			this.viewFrame.getModel().moveMissile();
			afficherMap(graphics);
		}
		
		if(this.viewFrame.getModel().getLevel() == 9)
		{ 
		
			/*this.viewFrame.getModel().loadHighScore("map1");
			int scoremap1 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map2");
			int scoremap2 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map3");
			int scoremap3 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map4");
			int scoremap4 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map5");
			int scoremap5 = this.viewFrame.getModel().getHighScore();*/
			
			/*Font fonte = new Font("TimesRoman ",Font.BOLD,20);
			graphics.setFont(fonte);
			graphics.setColor(Color.white);
			graphics.drawString("Map 1",200,80);*/

			
			afficherMap(graphics);
		}
		
		else {afficherMap(graphics);}

	}
	
	public void afficherMap(final Graphics graphics) {
		
		this.tabmap = this.viewFrame.getModel().getTabmap2d();

		for(int i =0; i<this.tabmap.length; i++)
		{
			for (int j =0; j<this.tabmap[i].length;j++)
			{
				switch (this.tabmap[i][j]) {
					case '0':
						System.out.print(this.tabmap[i][j]);
						/**try {
						 Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
						 graphics.drawImage(img, 32*j, 32*i, this);
						 } catch (IOException e) {

						 e.printStackTrace();

						 }**/
						break;

					case '1':
						System.out.print(this.tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '2':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '3':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '6':
						System.out.print(tabmap[i][j]);

						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '7':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '8':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '9':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'C':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'P':
						System.out.print(tabmap[i][j]);
							graphics.drawImage(new ImageIcon("C:/Users/Thomas/git/Projet-java-uml/sprite/animated.gif").getImage(), 32*j, 32*i, this);
					break;

					case 'E':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'D':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_b.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'X':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_bl.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'V':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_br.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'Q':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_l.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'F':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_r.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'I':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_u.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'B':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_ul.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;
					case 'M':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/lorann_ur.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						tabmap[i][j]='P';
						break;

					case 'L':
						System.out.print(tabmap[i][j]);
						graphics.drawImage(new ImageIcon("C:/Users/Thomas/git/Projet-java-uml/sprite/fireball_animated.gif").getImage(), 32*j, 32*i, this);
						break;

					case 'S':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'O':
					case 'A':
					case 'Z':
					case 'R':
					case 'T':
					case 'Y':
					case 'W':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/gate_open.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					default :
						System.out.print(tabmap[i][j]);
						break;
				}
			}
			System.out.println();
		}
		
	}
}
