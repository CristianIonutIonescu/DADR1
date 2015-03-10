package ro.ucv.main.interactive;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class PictureGUI extends JFrame implements MouseListener {

	private LinkedList<Punct> entities= new LinkedList<Punct>();
	
	private Point LastClickedPosition = new Point();
	
	private Suprafata myArea = null;

	private int ovalRadius=20;	
	
	public void paint(Graphics g) {
		super.paint(g);	//this line will ensure that paint can still draw buttons and other controls	
		
		g.setColor(Color.BLUE);		
		for(Point p:entities){
			g.fillOval(p.x-ovalRadius/2, p.y-ovalRadius/2, ovalRadius, ovalRadius);
		}
		
		if(myArea != null){
			g.setColor(Color.RED);
			g.fillOval((int)myArea.GetCenter().getX() - ovalRadius/2, (int)myArea.GetCenter().getY() - ovalRadius/2, ovalRadius, ovalRadius);
			g.setColor(new Color(255,0,0,128));
			g.fillOval((int)myArea.GetCenter().getX() - (int)myArea.GetRadius()/2, (int)myArea.GetCenter().getY() - (int)myArea.GetRadius()/2, (int)myArea.GetRadius(), (int)myArea.GetRadius());
		}
		
	}

	/**
	 * creates a GUI puts a picture in the background and draws circles on click
	 */
	public PictureGUI() {

		super("Click Anywhere");
		
		this.setVisible(true);
		this.setBounds(120, 120, 820, 620);
		this.setLayout(null);

		JLabel l = new JLabel();
		l.setBounds(0, 0, 800, 600);
		l.setIcon(new ImageIcon(".\\leaf.jpg"));
		this.add(l);

		
		JButton b = new JButton("dummy buton");
		b.setBounds(200, 500, 150, 25);
		l.add(b);
		RandomPointsGenerator();
		
		this.addMouseListener(this);
		
		repaint();
		

	}
	
	private void RandomPointsGenerator(){
		Integer i = 0;
		Random randomGen = new Random();
		do{
			Integer x = randomGen.nextInt(799);
			Integer y = randomGen.nextInt(599);
			Punct myPoint = new Punct(x,y,i);
			i++;
			entities.add(myPoint);
			
		}while(entities.size()<51);
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			LastClickedPosition.setLocation(e.getX(), e.getY());
		}
		
		if (e.getButton() == MouseEvent.BUTTON2)
		{
			Point locationClicked = new Point(e.getX(),e.getY());
			
			int Distance = (int)LastClickedPosition.distance(locationClicked);
			
			myArea = new Suprafata(LastClickedPosition,(Integer) Distance);
			
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//do something when mouse pointer enters the frame
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// do something when mouse pointer exits the frame	
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
