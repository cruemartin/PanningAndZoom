import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {

	private final int SCREEN_WIDTH = 800;
	private final int SCREEN_HEIGHT = 600;
	private final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
	
	
	float fOffsetX;
	float fOffsetY;
	
	float fWorldX;
	float fWorldY;

	int nScreenX;
	int nScreenY;
	
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
	
	
	class Point{
		int pixelX;
		int pixelY;
		
		Point(int x, int y){
			pixelX = x;
			pixelY = y;
		}
	}
	
	



	
}
