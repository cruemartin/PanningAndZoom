import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	
	Panel panel;
	
	
	Frame(){
		panel = new Panel();
		
		add(panel);
		setResizable(false);
		setTitle("Pan and Zoom test");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(rootPaneCheckingEnabled);
		setLocationRelativeTo(null);
		
		
	}

}
