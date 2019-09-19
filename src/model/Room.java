package model;

import javafx.scene.paint.*;

import java.util.ArrayList;

import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.*;
import javafx.scene.text.*;

public abstract class Room {
	protected static int number = 0;
	protected boolean isInUse;
	protected Color color;
	protected double width = 110;
	protected double height = 100;
	protected double Xposition;
	protected double Yposition;
	protected Rectangle rct;
	protected TextInputDialog createRoomDialog;
	protected Text occupiedText;
	protected Text infoText;

	public Room() {
		this(0);
		width = 100;
		height = 100;
		color = Color.GRAY;
	}

	public Room(double x, double y) {
		rct = new Rectangle(x, y, width, height);
		isInUse = false;
		Xposition = x;
		Yposition = y;
		number++;
		infoText = new Text();
		occupiedText = new Text("This Room is \n Occupied! \n click to relase me");
		occupiedText.setFill(Color.RED);
	}

	public Room(int num) {
		number = num;
		isInUse = false;
	}

	public abstract void useIt(); // ABSTRACT METHOD

	public String toString() {
		return "Room #: " + number + " is in use? " + isInUse;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isInUse() {
		return isInUse;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getXposition() {
		return Xposition;
	}

	public void setXposition(double xposition) {
		Xposition = xposition;
	}

	public double getYposition() {
		return Yposition;
	}

	public void setYposition(double yposition) {
		Yposition = yposition;
	}

	public Rectangle getRct() {
		return rct;
	}

	public void setRct(Rectangle rct) {
		this.rct = rct;
	}

	public TextInputDialog getDialog() {
		return createRoomDialog;
	}

	public void setDialog(TextInputDialog dialog) {
		this.createRoomDialog = dialog;
	}

	public Text getInfoText() {
		return infoText;
	}

	public void setInfoText(Text txt) {
		this.infoText = txt;
	}

	public void setTextLocation(double x, double y, Text txt) {
		txt.setLayoutX(x);
		txt.setLayoutY(y);
	}

	public Text getOccupiedText() {
		return occupiedText;
	}

	public void setOccupiedText(Text occupiedText) {
		this.occupiedText = occupiedText;
	}

}
