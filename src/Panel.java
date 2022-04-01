import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Panel extends JPanel implements MouseListener, MouseMotionListener {

	private final int SCREEN_WIDTH = 800;
	private final int SCREEN_HEIGHT = 600;
	private final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	float fOffsetX;
	float fOffsetY;
	
	float fWorldX;
	float fWorldY;

	int nScreenX;
	int nScreenY;
	
	float fStartPanX;
	float fStartPanY;
	
	boolean mouseHeld = false;

	Square square;
	Image image;
	Graphics graphics;
	
	Panel(){
		
		fOffsetX = 0.0f;
		fOffsetY = 0.0f;
		
		fWorldY = 0.0f;
		fWorldX = 0.0f;
		
		nScreenX = 0;
		nScreenY = 0;
		
		square = new Square();

		addMouseListener(this);
		setPreferredSize(this.SCREEN_SIZE);
		repaint();	
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		square.x = WorldToScreenX(fWorldX);
		square.y = WorldToScreenY(fWorldY);
		square.draw(g);
	}	
	//World
	public int WorldToScreenX(float fWorldX) {
		return (int)(fWorldX - fOffsetX);
	}
	
	public int WorldToScreenY(float fWorldY) {
		return (int)(fWorldY - fOffsetY);
	}
	
	//Screen
	public float ScreenToWorldX(int nScreenX) {
		return (float)(fWorldX) + fOffsetX;
	}
	
	public float ScreenToWorldY(int nScreenY) {
		return (float)(fWorldY) + fOffsetY;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		fStartPanX = (float)e.getX();
		fStartPanY = (float)e.getY();
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		fOffsetX -= (e.getX() - fStartPanX); //Add scaling to this later!!
//		fOffsetY -= (e.getY() - fStartPanY);
		
		fStartPanX = fOffsetX;
		fStartPanY = fOffsetY;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		fOffsetX -= (e.getX() - fStartPanX); //Add scaling to this later!!
		fOffsetY -= (e.getY() - fStartPanY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	



	
}
