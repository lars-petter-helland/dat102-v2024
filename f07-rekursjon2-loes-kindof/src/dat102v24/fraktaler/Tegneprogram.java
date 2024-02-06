package dat102v24.fraktaler;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Tegneprogram extends JFrame {
	
	public Tegneprogram(String title, Tegneflate canvas) {
		
		setTitle(title);
		setSize(850, 850);
		getContentPane().add(canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}


