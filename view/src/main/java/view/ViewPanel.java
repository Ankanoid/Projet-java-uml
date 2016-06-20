package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * The Class ViewPanel.
 * 
 * @author Group 5
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	/**
	 * Char containing the map
	 */
	private char[][] tabmap ;
	
	/**
	 * Instantiates a new view panel. Make it refresh
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		Timer timer = new Timer(75, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	@SuppressWarnings("unused")
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
		this.viewFrame.getModel().parseMap();
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
			int scoremap1 = this.viewFrame.getModel().getHighScore(); // Ask the highscore of the map, save it in an int
			this.viewFrame.getModel().loadHighScore("map2");
			int scoremap2 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map3");
			int scoremap3 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map4");
			int scoremap4 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("map5");
			int scoremap5 = this.viewFrame.getModel().getHighScore();
			this.viewFrame.getModel().loadHighScore("mapG");
			int globalscore = this.viewFrame.getModel().getHighScore();
			
			Font font = new Font("Courier New",Font.BOLD,35);
			graphics.setFont(font);
			graphics.setColor(Color.red);
			graphics.drawString("HIGHSCORES",42,75);
			font = new Font("Courier New",Font.BOLD,20);
			graphics.setFont(font);
			graphics.drawString("PRESS ENTER TO CONTINUE ",50,415);
			graphics.setColor(Color.white);
			graphics.drawString("Map 1 : " + scoremap1,250,150);
			graphics.drawString("Map 2 : " + scoremap2,250,200); // Displaying scores
			graphics.drawString("Map 3 : " + scoremap3,250,250);
			graphics.drawString("Map 4 : " + scoremap4,250,300);
			graphics.drawString("Map 5 : " + scoremap5,250,350);
			font = new Font("Courier New",Font.BOLD,28);
			graphics.setFont(font);
			graphics.setColor(Color.yellow);
			graphics.drawString("Global : " + globalscore,375,55);
			try {
				Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/cesi.png"));
				graphics.drawImage(img, 480, 380, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			this.viewFrame.getModel().moveHero();
		}
			
		if(this.viewFrame.getModel().getLevel() >= 1 && this.viewFrame.getModel().getLevel() <= 101)
		{
			Font fonte = new Font("Courier New",Font.BOLD,28);
			graphics.setFont(fonte);
			graphics.setColor(Color.yellow);
			graphics.drawString("Level : " + this.viewFrame.getModel().getLevel(),10,410);
			graphics.drawString("Map Score : " + this.viewFrame.getModel().getScore(),10,440);
			graphics.drawString("Global Score : " + this.viewFrame.getModel().getGlobalScore(),310,440);
			graphics.drawString("Life x" + this.viewFrame.getModel().getLife(),310,410);
			
			this.viewFrame.getModel().moveHero();
			this.viewFrame.getModel().moveM1();
			this.viewFrame.getModel().moveM2();
			this.viewFrame.getModel().moveM3();
			this.viewFrame.getModel().moveM4();
			this.viewFrame.getModel().moveFireBall();
			displayMap(graphics);
		}
		
		if(this.viewFrame.getModel().getLevel() == 104)
		{ 
			Font font = new Font("Courier New",Font.BOLD,35);
			graphics.setFont(font);
			graphics.setColor(Color.red);
			graphics.drawString("LEVEL",95,75);
			font = new Font("Courier New",Font.BOLD,20);
			graphics.setFont(font);
			graphics.setColor(Color.red);
			graphics.drawString("PRESS H FOR HIGHSCORES",50,415);
			font = new Font("Courier New",Font.BOLD,80);
			graphics.setColor(Color.yellow);
			graphics.setFont(font);
			graphics.drawString(""+this.viewFrame.getModel().getDoorLevel(),525,115);
			font = new Font("Courier New",Font.BOLD,55);
			graphics.setFont(font);
			graphics.drawString("+",95,160);
			graphics.drawString("-",95,285);
			font = new Font("Courier New",Font.BOLD,24);
			graphics.setFont(font);
			graphics.drawString("Global Score : " + this.viewFrame.getModel().getGlobalScore(),350,440);
			graphics.drawString("Life x" + this.viewFrame.getModel().getLife(),350,410);
			this.viewFrame.getModel().moveHero();
			
			displayMap(graphics);
		}
		
		else { displayMap(graphics); }
	}
	
	private void displayMap(final Graphics graphics) {
		
		this.tabmap = this.viewFrame.getModel().getTabmap2d();

		for(int i = 0; i<this.tabmap.length; i++)
		{
			for (int j = 0; j<this.tabmap[i].length;j++)
			{
				switch (this.tabmap[i][j]) {
					case '0':
						System.out.print(this.tabmap[i][j]);
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
						String ImageHero = this.viewFrame.getModel().getImageHero();
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/"+ImageHero+".png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
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
					
					case 'L':
						System.out.print(tabmap[i][j]);
						String ImageFireBall = this.viewFrame.getModel().getImageFireBall();
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/"+ImageFireBall+".png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'S':
						System.out.print(tabmap[i][j]);
						String ImageDoor = this.viewFrame.getModel().getImageDoor();
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/"+ImageDoor+".png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'A':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/minus.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'Z':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/plus.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'G':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("C:/Users/Thomas/git/Projet-java-uml/sprite/play.png"));
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
