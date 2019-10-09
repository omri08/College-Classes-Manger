package model;

import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

public class Model {
	private double Xposition = 50; // starting point
	private double Yposition = 100; // starting point
	private double gap = 120;;
	private boolean creationSucced = true;
	private Container container;

	public Model() {
		container = new Container();

	}

	public boolean creation(String type) {
		if (Yposition <= 400)
			creationSucced = true;
		else
			creationSucced = false;
		if (creationSucced) {

			if (type == "ClassRoom") {
				ClassRoom r = new ClassRoom(Xposition, Yposition);
				container.add(r);
				// setting the text
				r.setTextLocation(Xposition, Yposition + 20,r.getInfoText());
				r.setTextLocation(Xposition, Yposition + 20,r.getOccupiedText());
				r.setTextLocation(Xposition, Yposition + 20,r.getDirty());
			}

			else if (type == "OfficeRoom") {
				OfficeRoom r = new OfficeRoom(Xposition, Yposition);
				container.add(r);
				// setting the text
				r.setTextLocation(Xposition, Yposition + 15,r.getInfoText());
				r.setTextLocation(Xposition, Yposition + 63, r.getFullText());

			}

			else if (type == "ComputerLab") {
				ComputerLab r = new ComputerLab(Xposition, Yposition);
				container.add(r);
				// setting the text
				r.setTextLocation(Xposition, Yposition + 20,r.getInfoText());
				r.setTextLocation(Xposition, Yposition + 20,r.getOccupiedText());
				r.setTextLocation(Xposition, Yposition + 20,r.getDirty());
		
			}

			else if (type == "Caf") {
				Cafeteria r = new Cafeteria(Xposition, Yposition);
				r.getTxt().setLayoutX((Xposition));
				r.getTxt().setLayoutY((Yposition + 20));
				container.add(r);
			}

			Xposition += gap;
			if (Xposition >= 530) {
				Xposition = 50;
				Yposition += gap;
			}
		}
		return creationSucced;

	}

	public Container getContainer() {
		return container;
	}

	public TextInputDialog getBookingInfo(String choice) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Searching");

		if (choice == "ClassRoom") {
			dialog.setHeaderText("Searcing for a  ClassRoom");
			dialog.setContentText("Please enter how many seats you need:");
			
		} else if (choice == "OfficeRoom") {
			dialog.setHeaderText("Searcing for a office Room");
			dialog.setContentText("Please enter a name:");
			
		} else if (choice == "ComputerLab") {
			dialog.setHeaderText("Searcing for a Computer Lab");
			dialog.setContentText("Please enter how many computers you need:");
		}
		
		return dialog;
	}
	
	public Room searchRoom(String type, int num) {
		if (type == "ClassRoom") {
			return container.searchClassRoom(num);
			
		} else if (type == "ComputerLab") {
		return container.searchComputer(num);
		}
		return null;
	}
	
	public OfficeRoom searOfficeRoom(String name) {
		return container.searchOfficeRoom(name);
	}
	
	

	public boolean CheckIfClean(Cleanable c) {
		if (c.isClean()) {
			return true;
		} else {
			return false;
		}
	}

}
