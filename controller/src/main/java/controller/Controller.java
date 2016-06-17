package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
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
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case MoveLeft:
				this.model.moveH(-1, 0);
				this.model.setRotat(-1);
				break;
			case MoveRight:
				this.model.moveH(1, 0);
				this.model.setRotat(1);
				break;
			case MoveUp:
				this.model.moveH(0, -1);
				this.model.setRotat(2);
				break;
			case MoveDown:
				this.model.moveH(0, 1);
				this.model.setRotat(3);
				break;
			case MoveLeftUp:
				this.model.moveH(-1, -1);
				this.model.setRotat(6);
				break;
			case MoveRightUp:
				this.model.moveH(1, -1);
				this.model.setRotat(7);
				break;
			case MoveLeftDown:
				this.model.moveH(-1, 1);
				this.model.setRotat(4);
				break;
			case MoveRightDown:
				this.model.moveH(1, 1);
				this.model.setRotat(5);
				break;
			case Map0:
				this.model.loadMessage("m9");
				this.model.setLevel(9);
			case Missile:
				this.model.setActivemissile(1);
				this.model.moveMissile();
			default:
				break;
		}
	}

}
