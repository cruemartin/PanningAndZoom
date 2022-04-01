import java.awt.*;

public class Square extends Rectangle {

	private static final int WIDTH = 100;
	
	Square(){
		super.width = WIDTH;
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.x, this.y, this.width, this.width);
		
	}
}
