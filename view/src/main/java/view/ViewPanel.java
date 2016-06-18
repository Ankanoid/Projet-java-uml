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
		Timer timer = new Timer(75, new ActionListener() {
            @Override
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
			graphics.drawString("H",100,58); graphics.drawString("I",100,90); graphics.drawString("G",100,122);
			graphics.drawString("H",100,155); graphics.drawString("S",100,188); graphics.drawString("C",100,220); graphics.drawString("O",100,252);
			graphics.drawString("R",100,285); graphics.drawString("E",100,318); graphics.drawString("S",100,350);
			graphics.drawString("Map 1 : " + scoremap1,150,90);
			graphics.drawString("Map 2 : " + scoremap2,150,155);
			graphics.drawString("Map 3 : " + scoremap3,150,220);
			graphics.drawString("Map 4 : " + scoremap4,150,285);
			graphics.drawString("Map 5 : " + scoremap5,150,350);
			graphics.drawString("PRESS ENTER TO CONTINUE ",50,415);
			
			this.viewFrame.getModel().moveH();
		}
			
		if(this.viewFrame.getModel().getLevel() == 1 || this.viewFrame.getModel().getLevel() == 2 || this.viewFrame.getModel().getLevel() == 3 || this.viewFrame.getModel().getLevel() == 4 || this.viewFrame.getModel().getLevel() == 5)
		{
			Font fonte = new Font("TimesRoman ",Font.BOLD,30);
			graphics.setFont(fonte);
			graphics.setColor(Color.white);
			graphics.drawString("Niveau : " + this.viewFrame.getModel().getLevel(),60,410);
			graphics.drawString("Score : " + this.viewFrame.getModel().getScore(),60,440);
			
			this.viewFrame.getModel().moveH();
			this.viewFrame.getModel().moveM1();
			//this.viewFrame.getModel().moveM2();
			//this.viewFrame.getModel().moveM3();
			//this.viewFrame.getModel().moveM4();
			this.viewFrame.getModel().moveMissile();
			
			displayMap(graphics);
		}
		
		if(this.viewFrame.getModel().getLevel() == 9)
		{ 
			Font fonte = new Font("TimesRoman ",Font.BOLD,20);
			graphics.setFont(fonte);
			graphics.setColor(Color.white);
			graphics.drawString("PRESS H FOR HIGHSCORES",50,415);
			fonte = new Font("TimesRoman ",Font.BOLD,50);
			graphics.setFont(fonte);
			graphics.drawString(""+this.viewFrame.getModel().getDoorLevel(),290,220);
			//this.viewFrame.getModel().animatedHero();
			this.viewFrame.getModel().moveH();
			
			displayMap(graphics);
		}
		
		else { displayMap(graphics); }
	}
	
	public void displayMap(final Graphics graphics) {
		
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
						if(this.viewFrame.getModel().getLevel() != 6 && this.viewFrame.getModel().getLevel() != 7)
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
