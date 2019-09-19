package model;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
public class Cafeteria implements Cleanable {
	private boolean isCfeteriaClean;
	private Color color;
	private double width = 100;
	private double height= 100;
	private double Xposition;
	private double Yposition;
	private Rectangle rct;
	private Text txt;
	public Cafeteria(double x , double y) {
		isCfeteriaClean = true;
		setColor(Color.ORANGERED);
		rct = new Rectangle(x,y,width,height);
		rct.setFill(color);
		txt = new Text("Cafeteria");
	}
	
	@Override
	public boolean isClean() {
		return isCfeteriaClean;
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return "This is Cafeteria." + "is it clean? "+ isClean();
	}

	public boolean isCfeteriaClean() {
		return isCfeteriaClean;
	}

	public void setCfeteriaClean(boolean isCfeteriaClean) {
		this.isCfeteriaClean = isCfeteriaClean;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public Text getTxt() {
		return txt;
	}

	public void setTxt(Text txt) {
		this.txt = txt;
	}
	
	
	

}
