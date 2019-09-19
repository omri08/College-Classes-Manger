package model;

import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
public class ClassRoom extends Room implements Cleanable{
	private boolean isRoomClean;
	private int numSeats;
	private Text dirty;
	public Text getDirty() {
		return dirty;
	}

	public ClassRoom( double x , double y) {
		super(x,y); // Call Room (double,double,int)
		isRoomClean = true;// any ClassRoom when it is instantiated is clean
		setColor(Color.LIGHTYELLOW);
		rct.setFill(color);
		infoText = new Text();
	    createRoomDialog = new TextInputDialog("5");
		createRoomDialog.setTitle("Creating a room");
		createRoomDialog.setHeaderText("Creating a ClassRoom");
		createRoomDialog.setContentText("Please the the num of seats in the class:");
		
		dirty = new Text("This room is dirty! \n click to clean me");
		dirty.setFill(Color.WHITE);

	}
	
	public void setNumSeats(int seats) {
		numSeats = seats;
		infoText.setText("Room Numder: " +number + "\n"
				+ "Seats: " +seats);
	}

	@Override
	public void useIt() {
		if(isInUse == true)
			isInUse = false;
		else
			isInUse = true;
	}

	@Override
	public boolean isClean() {
		return isRoomClean;
	}

	@Override
	public void clean() {
		if(isRoomClean == true)
			isRoomClean = false;
		else
			isRoomClean = true;
		
	}
	
	public String toString() {
		return super.toString()+ " Num seats: "+numSeats+
				" Is Clean? "+ isClean();
	}

	public boolean isRoomClean() {
		return isRoomClean;
	}

	public void setRoomClean(boolean isRoomClean) {
		this.isRoomClean = isRoomClean;
	}

	public int getNumSeats() {
		return numSeats;
	}


}
