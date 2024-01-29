package dat102v24.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HanoiPuzzle extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;

	int fwidth = 1000;
	int fheight = 600;

	JButton start = new JButton("Start");
	JButton exit = new JButton("Exit");

	Rectangle[] peg = new Rectangle[3];
	Rectangle[] disk;

	JLabel numof_moves = new JLabel("Number of Moves : ");
	JLabel present_move = new JLabel("Present Move : ");
	JTextArea title = new JTextArea();

	int[][] peg_capacity;
	int[] h = new int[3];
	int num;
	int count = 1;
	
	Thread t = new Thread(this);
	
	private int antallDisker;
	private HanoiSolver solver;

	public HanoiPuzzle(int antallDisker, HanoiSolver solver) {
		
		this.antallDisker = antallDisker;
		disk = new Rectangle[antallDisker];
		peg_capacity = new int[3][antallDisker];

		this.solver = solver;

		h[0] = antallDisker;
		h[1] = 0;
		h[2] = 0;

		setLayout(null);
		setSize(fwidth, fheight);
		setTitle("Towers Of Hanoi ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start.setBounds(300, 520, 100, 25);
		exit.setBounds(600, 520, 100, 25);
		numof_moves.setBounds(100, 50, 300, 25);
		present_move.setBounds(300, 50, 300, 25);

		add(start);
		add(exit);
		add(numof_moves);
		add(present_move);

		// disk[0] large size
		for (int i = 0; i < antallDisker; i++) {
			disk[i] = new Rectangle(150 + i * 10, 475 - i * 22, 200 - i * 19, 20);
			peg_capacity[0][i] = i; // pushing disk numbers in to first peg
		}

		peg[0] = new Rectangle(250, 200, 15, 300);
		peg[1] = new Rectangle(510, 200, 15, 300);
		peg[2] = new Rectangle(760, 200, 15, 300);

		start.addActionListener(this);
		exit.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void run() {
		solver.solveHanoi(this::moveOneDisk, antallDisker, 1, 3, 2);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == start) {
			t.start();
			start.setEnabled(false);
		}

		if (ae.getSource() == exit) {
			System.exit(0);
		}
	}

	public void moveOneDisk(int from, int dest) {
		int hor_displacement = 260;
		try {
			Thread.sleep(1000);

			// maintains number of disks in each peg
			peg_capacity[dest - 1][h[dest - 1]] = peg_capacity[from - 1][--h[from - 1]];

			if ((from == 1 && dest == 2) || (from == 3 && dest == 2))
				;// do nothing: hor_displacement = hor_displacement;
			else if ((from == 1 && dest == 3) || (from == 2 && dest == 3))
				hor_displacement = hor_displacement * 2;
			else if ((from == 3 && dest == 1) || (from == 2 && dest == 1))
				hor_displacement = 0;

			num = peg_capacity[dest - 1][h[dest - 1]++];

			disk[num].setLocation(150 + num * 10 + hor_displacement, 475 - (h[dest - 1] - 1) * 22);

			repaint();
			numof_moves.setText("Number of Moves :" + (count++));
			present_move.setText("Present Move : Disk " + (num + 1) + " moved from " + (char) (from + 64) + " --> "
					+ (char) (dest + 64));

		} catch (Exception e) {
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);

		for (int i = 0; i < 3; i++) {
			g.fillRect(peg[i].x, peg[i].y, peg[i].width, peg[i].height);
			g.drawString("" + (char) (i + 65), peg[i].x + 5, peg[i].y - 10);
		}

		g.drawLine(100, 500, 850, 500);

		// drawing disks
		for (int i = 0; i < antallDisker; i++) {
			g.setColor(Color.yellow);
			g.fillRoundRect(disk[i].x, disk[i].y, disk[i].width, disk[i].height, 10, 10);
			g.setColor(Color.BLACK);
			g.drawRoundRect(disk[i].x, disk[i].y, disk[i].width, disk[i].height, 10, 10);
			g.setColor(Color.black);
			g.drawString("" + (i + 1), disk[i].x + 100 - i * 10, disk[i].y + 13);

		}

	}

}