package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 * 
 * @author Group 5
 */
public class Controller implements IController {

	/** The view. */
	@SuppressWarnings("unused")
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.model.loadMap("m104");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		// this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	
	/**
	 * Calls function depending on key pressed
	 * 
	 * @param controllerOrder 
	 * 					Order from the view depending on the last key pressed
	 * 
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case HomeMap:
				if(this.model.getLevel() == 0 || this.model.getLevel() == 102 || this.model.getLevel() == 103)
				{
					this.model.loadMap("m104");
					this.model.setLevel(104);
					this.model.setGlobalScore(0); 
				}
				
				if(this.model.getLevel()==104)
					;
				
				else
				{
					this.model.setLife(this.model.getLife()-1);
					this.model.setGlobalScore(this.model.getGlobalScore()-this.model.getScore());
					this.model.loadMap("m"+this.model.getLevel());
					if(this.model.getLife()==0)
					{	
						this.model.setLife(this.model.getLife()+1);
						this.model.gameOver();
					}
				}
				break;
			case Fireball:
				this.model.setActiveFireBall(true);
				break;
			case DisplayHighscores:
				if(this.model.getLevel()==104)
				this.model.setLevel(0);
				break;
			case MoveLeft:
				this.model.setLastKey("LEFT");
				break;
			case MoveRight:
				this.model.setLastKey("RIGHT");
				break;
			case MoveUp:
				this.model.setLastKey("UP");
				break;
			case MoveDown:
				this.model.setLastKey("DOWN");
				break;
			case MoveLeftUp:
				this.model.setLastKey("LEFTUP");
				break;
			case MoveRightUp:
				this.model.setLastKey("RIGHTUP");
				break;
			case MoveLeftDown:
				this.model.setLastKey("LEFTDOWN");
				break;
			case MoveRightDown:
				this.model.setLastKey("RIGHTDOWN");
				break;
			case Nop:
				break;
			default:
				break;
		}
	}
}
