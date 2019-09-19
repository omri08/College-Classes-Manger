package model;

import java.util.ArrayList;
import javafx.scene.shape.*;
public class Container {
	private ArrayList<Room> roomList;
	private ArrayList<Cleanable> Clist;
	private ArrayList<Rectangle> recList;
	
	public Container() {
		roomList = new ArrayList<>();
		Clist = new ArrayList<>();
		recList = new ArrayList<>();
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public ArrayList<Cleanable> getClist() {
		return Clist;
	}

	
	public void add(Room r) {
		if(r instanceof Cleanable) {
			Clist.add((Cleanable)r);
		
		}else 
		roomList.add(r);
	recList.add(r.getRct());
	}
		
		public void addRec( Rectangle r) {
			recList.add(r);
		}
	
	public void add(Cafeteria c) {
		Clist.add(c);
		recList.add(c.getRct());
	}

	// find the parent of the rectangle
	public Room findSourceRoom (Rectangle r) {
		for(int i = 0 ; i < roomList.size() ; i ++ ) {
			if(roomList.get(i).getRct() == r)
				return roomList.get(i);
		}
		return null; // Couldn't find
	}
	
	public Cleanable findSourceClean (Rectangle r) {
		for(int i = 0 ; i < Clist.size() ; i ++ ) {
			if(Clist.get(i) instanceof Room) {
				if(((Room)Clist.get(i)).getRct() == r) {
					return Clist.get(i);
					
				}
			}
		}
		return null; // Couldn't find
	}
	public Rectangle getLastRec() {
		return recList.get(recList.size() -1); // return the last rectangle we added to the last;
	}
	
	public Cleanable getLastCleanable() {
		return Clist.get(Clist.size() -1); // return the last rectangle we added to the last;
	}
	
	public Room getLastRoom() {
		return roomList.get(roomList.size() -1);
	}

	public ArrayList<Rectangle> getRecList() {
		return recList;
	}
	
	public ComputerLab searchComputer(int num) {
		for(int i = 0 ; i <Clist.size() ; i ++) {
			if(Clist.get(i) instanceof ComputerLab) {
			ComputerLab r = (ComputerLab) Clist.get(i);
			if(r.isInUse == false && r.getNumComputers() >= num && r.isClean() == true)
				return r;
			}
		}
		
		return null; // Couldn't find
	}
	
	public ClassRoom searchClassRoom(int num) {
		for(int i = 0 ; i <Clist.size() ; i ++) {
			if(Clist.get(i) instanceof ClassRoom) {
				ClassRoom r = (ClassRoom) Clist.get(i);
			if(r.isInUse == false && r.getNumSeats() >= num && r.isClean() == true)
				return r;
			}
		}
		
		return null; // Couldn't find
	}
	
}
