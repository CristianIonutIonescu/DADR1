package ro.ucv.main.interactive;

import java.awt.Point;

public class Suprafata {
	private Point Center;
	private Integer Radius;
	
	public Suprafata()
	{
		Center = new Point();
		Radius = 0;
	}
	
	public Suprafata(Point center,Integer distance)
	{
		Center = center;
		Radius = distance;
	}
	
	
	public Integer GetRadius()
	{
		return this.Radius;
	}
	
	public void SetRadius(Integer value)
	{
		this.Radius = value;
	}
	
	public Point GetCenter(){
		return Center;
	}
	
}
