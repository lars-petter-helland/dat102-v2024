package dat102v24.fraktaler;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class Tegneflate extends JPanel {
	
	private record Linje (int x1, int y1, int x2, int y2) {}
	
	List<Linje> lines = new ArrayList<>();
	
	public void tegnLinje(int x1, int y1, int x2, int y2) {
		lines.add(new Linje(x1, y1, x2, y2));
		repaint();
	}
	
	public void tegnTrekant(int x1, int y1, int x2, int y2, int x3, int y3) {
		lines.add(new Linje(x1, y1, x2, y2));
		lines.add(new Linje(x1, y1, x3, y3));
		lines.add(new Linje(x2, y2, x3, y3));
		repaint();
	}
	
	public void tegnFirkant(int x1, int y1, int x2, int y2) {
		lines.add(new Linje(x1, y1, x1, y2));
		lines.add(new Linje(x1, y1, x2, y1));
		lines.add(new Linje(x2, y2, x1, y2));
		lines.add(new Linje(x2, y2, x2, y1));
		repaint();
	}

	public void slettTegning() {
		lines.clear();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Linje line : lines) {
			g.drawLine(line.x1(), line.y1(), line.x2(), line.y2());
		}
	}
}