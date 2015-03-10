package ro.ucv.main.interactive;

import java.awt.Point;

@SuppressWarnings("serial")
public class Punct extends Point {
	private Integer ID;
	
	public Punct(Integer x, Integer y, Integer ID){
		super(x,y);
		this.ID = ID;
	}
	
	public Integer GetID(){
		return this.ID;
	}
}
