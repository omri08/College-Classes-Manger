package view;

import javafx.stage.*;
import javafx.scene.text.*;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.scene.input.*;
import java.util.ArrayList;
import java.util.Optional;
import javafx.scene.control.*; 
import javafx.scene.control.TextInputDialog;

import javafx.event.*;
import javafx.scene.shape.*;
import javafx.scene.control.Alert;

public class View {
	private Stage stage;
	private Button btnClassRoom;
	private Button btnComputerLab;
	private Button btnOfficeRoom;
	private Button btnCafeteria;
	private Button btnBook;
	private Color dirtyColor = Color.DARKOLIVEGREEN;
	private Color bookedColor = Color.PINK;
	private ArrayList<Rectangle> r;

	final static int SIZE = 600;
	private Group root;

	public View(Stage stage) {
		// Group
		root = new Group();

		// Buttons
		btnClassRoom = new Button("Add a Class Room");
		btnComputerLab = new Button("Add a Computer Lab");
		btnOfficeRoom = new Button("Add a OfficeRoom");
		btnCafeteria = new Button("Add a Cafeteria");
		btnBook = new Button("Book a Room");
		
		btnBook.setLayoutX(275);
		btnBook.setLayoutY(450);

		// Hbox
		HBox hb = new HBox();
		hb.getChildren().addAll(btnClassRoom, btnComputerLab, btnOfficeRoom, btnCafeteria);
		hb.setLayoutX(70);
		hb.setLayoutY(50);
		root.getChildren().addAll(hb);
		hb.setMargin(btnComputerLab, new Insets(0, 5, 0, 5));
		hb.setMargin(btnOfficeRoom, new Insets(0, 5, 0, 5));

		// scene
		Scene scene = new Scene(root, SIZE, SIZE);

		// stage

		stage.setScene(scene);
		stage.show();
	}

	// event handlers
	public void addEventHanlderToClassRoom(EventHandler<ActionEvent> event) {
		btnClassRoom.setOnAction(event);
	}

	public void addEventHanlderToOfficeRoom(EventHandler<ActionEvent> event) {
		btnOfficeRoom.setOnAction(event);
	}

	public void addEventHanlderToComputerLab(EventHandler<ActionEvent> event) {
		btnComputerLab.setOnAction(event);
	}

	public void addEventHanlderToCaf(EventHandler<ActionEvent> event) {
		btnCafeteria.setOnAction(event);
	}
	
	public void addEventHandlerToBook(EventHandler<ActionEvent> event) {
		btnBook.setOnAction(event);
	}
	
	public String showBookDialog() {
		ArrayList<String> choices = new ArrayList<>();
		choices.add("ClassRoom");
		choices.add("OfficeRoom");
		choices.add("ComputerLab");
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("ClassRoom", choices);
		dialog.setTitle("Booking");
		dialog.setHeaderText("Book a room");
		dialog.setContentText("Choose your Room:");
		
		Optional<String> result = dialog.showAndWait();
		String str = result.get();
		
		return str;
	}

	// clicking event actions
	public void addClickingActionToComputerLab(Rectangle rct, EventHandler<MouseEvent> event) {
		rct.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
	}
	
	public void addClickingActionToClassRoom(Rectangle rct, EventHandler<MouseEvent> event) {
		rct.addEventHandler(MouseEvent.MOUSE_CLICKED, event);

	}
	
	public void addClickingActionToClassOffice(Rectangle rct, EventHandler<MouseEvent> event) {
		rct.addEventHandler(MouseEvent.MOUSE_CLICKED, event);

	}
	

	// drawing
	public void draw(model.Cleanable c) {

		if(root.getChildren().contains(btnBook) == false)
			root.getChildren().add(btnBook);
		
		if (c instanceof model.Room) {
			model.Room room = (((model.Room) c));
			root.getChildren().addAll(room.getRct(), room.getInfoText());

		}

		if (c instanceof model.Cafeteria) {
			model.Cafeteria caf = ((model.Cafeteria) c);
			root.getChildren().addAll(caf.getRct(),caf.getTxt());
		}

	}

	public void draw(model.Room r) {
		if(root.getChildren().contains(btnBook) == false)
			root.getChildren().add(btnBook);
		
		if(r instanceof model.OfficeRoom) {
			model.OfficeRoom office = (model.OfficeRoom)r;
			if(office.getNumPeople() == 2)
				root.getChildren().addAll(office.getRct(),office.getInfoText(),office.getFullText());
			else
				root.getChildren().addAll(r.getRct(),r.getInfoText());
		}else {
			root.getChildren().addAll(r.getRct(),r.getInfoText());
		}
		
	}

	public void alertOutOfSpce() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!");
		alert.setHeaderText("No more space!");
		alert.setContentText("Ooops, we ran out of space :(");

		alert.showAndWait();
	}

	public int showInputDialog(TextInputDialog dialog) {
		Optional<String> result = dialog.showAndWait();
		int numResult = 0;
		if (result.isPresent()) { // check there is an input
			numResult = Integer.parseInt(result.get());
		}
		return numResult;
	}

	public String showInputDialogString(TextInputDialog dialog) {
		Optional<String> result = dialog.showAndWait();
		String temp = (String) result.get();
		return temp;
	}
	
	public int searching (String str,model.Model m) {
		Optional<String> result = m.getBookingInfo(str).showAndWait();
		return Integer.parseInt(result.get());
	}
	
	public String searchingOffice (String str,model.Model m) {
		Optional<String> result = m.getBookingInfo(str).showAndWait();
		return result.get();
	}
	
	
	public void bookTheRoom(model.Room r) {
		root.getChildren().removeAll(r.getInfoText(),r.getRct());
		r.getRct().setFill(bookedColor);
		root.getChildren().addAll(r.getRct(),r.getOccupiedText());
		
	}
	
	public void bookOffice(model.OfficeRoom off) {
		root.getChildren().remove(off.getInfoText());
		root.getChildren().add(off.getInfoText());
		if(off.getNumPeople() == 2) {
			root.getChildren().add(off.getFullText());
		}
	}
	
	public void cleanTheRoom(model.Room r, Text dirtyText) {
        root.getChildren().removeAll(r.getRct(),dirtyText);
        r.getRct().setFill(r.getColor()); // setting the default color back
        root.getChildren().addAll(r.getRct(),r.getInfoText()); // adding the info text back
	}
	
	public void relaseTheRoomCleanable(model.Room r,Text dirtyText) {
	          root.getChildren().removeAll(r.getRct(),r.getOccupiedText());
	          r.getRct().setFill(dirtyColor); // setting the dirty color
	          root.getChildren().addAll(r.getRct(),dirtyText); // adding the dirty text 
		}
	
	public void relaseOffice(model.OfficeRoom off) {
		root.getChildren().removeAll(off.getFullText(),off.getInfoText()); // delete the old names and full text
		root.getChildren().add(off.getInfoText());
		
	}

	
}
