package model;

import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class OfficeRoom extends Room {
	public final int MAX_PEOPLE = 2;

	private String[] names;
	private String empty = "[Empty] \n";
	private int numPeople; // how many people using the office
	private Text fullText;

	public OfficeRoom(double x, double y) {
		super(x, y); // Call Room (double,double,int) employees
		names = new String[MAX_PEOPLE];
		numPeople = 0;
		infoText = new Text();
		setColor(Color.ROSYBROWN);
		rct.setFill(color);
		createRoomDialog = new TextInputDialog("Yossi,Moshe");
		createRoomDialog.setTitle("Creating a room");
		createRoomDialog.setHeaderText("Creating  Office");
		createRoomDialog.setContentText("Please enter the 2 people MAX , separated by comma:");
		fullText = new Text("The office room is full.\n Click to send the  \nemployees home ");
		fullText.setFill(Color.RED);
		setNames("default");
	}

	public void setNames(String str) {
		String temp = "Office number: " + number + "\n";
		names = str.split(",");
		if (str == "default") {
			temp +=empty;
			temp +=empty;
			numPeople = 0;
			
		} else {
			names = str.split(",");
			for (int i = 0; i < 2; i++) {
				if (str.length() > 1) {
					for (int j = 0; j < names.length; j++) {
						temp += names[j] + "\n";
						numPeople++;
						i++;
					}
				}
				if (i == 2)
					break;
				temp +=empty;
			}
		}
		infoText.setText(temp);
	}
	
	public void setNames(String str, OfficeRoom off) {
	names= str.split(",");
	String temp ="";
		for (int i = 0; i < names.length; i++) {
			temp =off.getInfoText().getText().replaceFirst("Empty", names[i]);
			numPeople++;
	}
		infoText.setText(temp);
	}
	@Override
	public void useIt() {
		if (isInUse == true)
			isInUse = false;
		else
			isInUse = true;

	}

	public String toString() {
		String str = super.toString() + " numPeople: " + numPeople;
		for (int i = 0; i < numPeople; i++)
			str += names[i] + " ";

		return str;
	}

	public Text getFullText() {
		return fullText;
	}

	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

}
