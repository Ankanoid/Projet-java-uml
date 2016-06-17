package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_ENTER:
				return ControllerOrder.Map0;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.MoveLeft;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.MoveRight;
			case KeyEvent.VK_UP:
				return ControllerOrder.MoveUp;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.MoveDown;
			case 1406:
				return ControllerOrder.MoveLeftUp;
			case 1482:
				return ControllerOrder.MoveRightUp;
			case 1480:
				return ControllerOrder.MoveLeftDown;
			case 1560:
				return ControllerOrder.MoveRightDown;
			case KeyEvent.VK_A:
				return ControllerOrder.Missile;
			default:
				return ControllerOrder.Nop;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
