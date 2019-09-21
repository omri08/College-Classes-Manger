package controller;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import model.ClassRoom;
import model.Cleanable;
import javafx.scene.shape.*;

public class Controller {
	private model.Model model;
	private view.View view;

	public Controller(view.View view, model.Model model) {
		this.model = model;
		this.view = view;

		// setting the event handler for view
		view.addEventHanlderToClassRoom(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// update the model that we created a classRoom
				if (model.creation("ClassRoom")) {
					// creation succeed

					// getting input from the user
					model.ClassRoom temp = (ClassRoom) model.getContainer().getLastCleanable();
					int result = view.showInputDialog(temp.getDialog());
					temp.setNumSeats(result); // update the model with the result

					// update the view to draw the rectangle
					view.draw(model.getContainer().getLastCleanable());
					
					
					// create action when click on the rectangle
					view.addClickingActionToClassRoom(model.getContainer().getLastRec(),
							new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// 1. get the rectangle that was clicked on
									Rectangle rct = (Rectangle) event.getTarget();
							
									
									
									// 2. find the object that was clicked on
									
									model.ClassRoom c = (model.ClassRoom) model.getContainer().findSourceClean(rct);
									
									// 3. a. check if this room is occupied
									          // * if  occupied release it and mark as dirty
									if(c.isInUse()) {
										c.useIt();;
										view.relaseTheRoomCleanable(c, c.getDirty());
										c.clean(); // update the  model room is dirty
									} else if (c.isInUse() == false && c.isClean() == false) {   // else clean the the room and mark as clean
										c.clean(); // update the model room is clean
										view.cleanTheRoom(c, c.getDirty());
										
									}
									        
								}

							});
					
					
					
				} else
					view.alertOutOfSpce();
				
				
		}

		});

		view.addEventHanlderToOfficeRoom(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// update the model that we created a officeRoom
				if (model.creation("OfficeRoom")) {
					// creation succeed

					// getting input from the user
					model.OfficeRoom temp = (model.OfficeRoom) model.getContainer().getLastRoom();
					String result = view.showInputDialogString(temp.getDialog());
					temp.setNames(result); // update the model with the result

					// update the view to draw the rectangle
					view.draw(model.getContainer().getLastRoom());
					
					
					view.addClickingActionToClassOffice(model.getContainer().getLastRec(),
							new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// 1. get the rectangle that was clicked on
									Rectangle rct = (Rectangle) event.getTarget();
							
									
									
									// 2. find the object that was clicked on
									
									model.OfficeRoom off = (model.OfficeRoom) model.getContainer().findSourceRoom(rct);
									
									// 3. a. check if this room is occupied
									          // * if  occupied release it
									if(off.isInUse()) {
										off.useIt();;
										off.setNames("default");
										
										
									}
									        
								}

							});
					
					
					
				} else
					view.alertOutOfSpce();
			}

		});

		view.addEventHanlderToComputerLab(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// update the model that we created a classRoom
				if (model.creation("ComputerLab")) {

					// getting input from the user
					model.ComputerLab temp = (model.ComputerLab) model.getContainer().getLastCleanable();
					int result = view.showInputDialog(temp.getDialog());
					temp.setNumComputers(result); // update the model with the result

					// update the view to draw the rectangle // creation succeed
					view.draw(model.getContainer().getLastCleanable());

					// create action when click on the rectangle
					view.addClickingActionToComputerLab(model.getContainer().getLastRec(),
							new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									// 1. get the rectangle that was clicked on
									Rectangle rct = (Rectangle) event.getTarget();
							
									
									
									// 2. find the object that was clicked on
									
									model.ComputerLab com = (model.ComputerLab) model.getContainer().findSourceClean(rct);
									
									// 3. a. check if this room is occupied
									          // * if  occupied release it and mark as dirty
									if(com.isInUse()) {
										com.useIt();
										view.relaseTheRoomCleanable(com, com.getDirty());
										com.clean();
									} else if (com.isInUse() == false && com.isClean() == false) {   // else clean the the room and mark as clean
										com.clean(); // update the model room is clean
										view.cleanTheRoom(com, com.getDirty());
										
									}
									        
								}

							});

				} else
					view.alertOutOfSpce();
			}

		});

		view.addEventHanlderToCaf(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// update the model that we created a officeRoom
				if (model.creation("Caf")) {
					// update the view to draw the rectangle // creation succeed
					view.draw(model.getContainer().getLastCleanable());
				} else
					view.alertOutOfSpce();
			}

		});

		view.addEventHandlerToBook(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// show dialog for user input
				String choice = view.showBookDialog();
				int input = view.searching(choice, model); // store the user input

				// search for the user book
				model.Room r = model.searchRoom(choice, input);
				if (r != null) { // if we found a suitable room update the view and the model
					view.bookTheRoom(r);
					r.setInUse(true);
				}

			}

		});

		///////// end of event handling //////////
	}

}
