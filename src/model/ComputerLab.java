package model;

import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ComputerLab extends Room implements Cleanable {
	private int numComputers;
	private boolean isLabClean;
    private Text dirty;
	public ComputerLab(double x, double y) {
		super(x, y); // Call Room (double,double,int)
		isLabClean = true;
		setColor(Color.ALICEBLUE);
		rct.setFill(color);
		createRoomDialog = new TextInputDialog("5");
		createRoomDialog.setTitle("Creating a room");
		createRoomDialog.setHeaderText("Creating a ComputerLab");
		createRoomDialog.setContentText("Please enter the number of computers in the class");
		
		dirty = new Text("This room is dirty! \n click to clean me");
		dirty.setFill(Color.WHITE);

	}

	public void setNumComputers(int computers) {
		numComputers = computers;
		infoText.setText("Room Numder: " + number + "\n" + "Computers: " + computers);
	}

	@Override
	public boolean isClean() {
		return isLabClean;
	}

	@Override
	public void clean() {
		if(isLabClean == true)
			isLabClean = false;
		else
			isLabClean = true;

	}

	@Override
	public void useIt() {
		if(isInUse == true)
			isInUse = false;
		else
			isInUse = true;

	}

	public String toString() {
		return super.toString() + " Num computers: " + numComputers + " Is Clean? " + isClean();
	}

	public int getNumComputers() {
		return numComputers;
	}

	public Text getDirty() {
		return dirty;
	}

	public void setDirty(Text dirty) {
		this.dirty = dirty;
	}

	public boolean isLabClean() {
		return isLabClean;
	}

	public void setLabClean(boolean isLabClean) {
		this.isLabClean = isLabClean;
	}


}
