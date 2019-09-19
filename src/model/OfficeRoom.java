package model;

import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class OfficeRoom extends Room {
	public final int MAX_PEOPLE = 2;
	private String[] names;
	private String person1 = "[Empty] \n";
	private int numPeople;
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
		fullText = new Text("The office room is full, Click to send the employees home ");
 setNames("default");
	}

	public void setNames(String str) {
		String temp = "Office number: " + number + "\n";
		if (str == "default") {
			names[0] = person1;
			names[1] = person1;
			temp +=names[0];
			temp +=names[1];
		} else {
			names = str.split(",");
			for (int i = 0; i < names.length; i++) {
				if (names[i] != null)
					temp += names[i] + "\n";
			}
		}
		infoText.setText(temp);
	}

	@Override
	public void useIt() {
		if(isInUse == true)
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
	
	

}
