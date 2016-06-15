package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

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
		//String[]tabmap = this.getViewFrame().getModel().getMessage().split("\n");
		this.viewFrame.getModel().doTheThing();
		char[][] tabmap = this.viewFrame.getModel().getTabmap2d();

		for(int i =0; i<tabmap.length; i++)
		{
			for (int j =0; j<tabmap[i].length;j++)
			{
				switch (tabmap[i][j]) {
					case '0':
						System.out.print(tabmap[i][j]);
						/**try {
						 Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
						 graphics.drawImage(img, 32*j, 32*i, this);
						 } catch (IOException e) {

						 e.printStackTrace();

						 }**/
						break;

					case '1':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '2':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/horizontal_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '3':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/vertical_bone.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '6':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '7':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_2.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '8':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_3.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case '9':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/monster_4.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'C':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/purse.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'P':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/lorann_r.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'E':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/crystal_ball.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'L':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/fireball_1.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 'S':
						System.out.print(tabmap[i][j]);
						try {
							Image img = ImageIO.read(new File("sprite/gate_closed.png"));
							graphics.drawImage(img, 32*j, 32*i, this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;







					/** remplir switch case **/


					default :
						System.out.print(tabmap[i][j]);
						break;
				}
			}
			System.out.println();
		}
		/**tabmap2d[0][0] = tabmap[0].charAt(1) ;
		 graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		 int x=0;
		 int y=20;
		 char t=tabmap2d[0][0];
		 while(x!=10){
		 graphics.drawChars(null, t, 10, y, y);
		 y=y+20;
		 x++;}**/


	}
}
