package BlackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
	//actual window resolution
	int actualWidth =1280;
	int actualHeight = 1000;
	
	//background color
	Color colorBackground = new Color(39,119,20);
	Color colorButton = new Color(204,204,0);
	
	//fonts
	Font fontButton = new Font("Times New Roman",Font.ROMAN_BASELINE,30);
	
	//buttons
	JButton bHit = new JButton();
	JButton bStay = new JButton();
	JButton bYes = new JButton();
	JButton bNo = new JButton();
	
	//card grid positioning and dimensions
	int gridX = 50;
	int gridY = 350;
	int gridW = 220;
	int gridH = 500;
	
	public GUI() {
		this.setSize(actualWidth+6,actualHeight+29);
		this.setTitle("BlackJack");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		Board board = new Board();
		this.setContentPane(board); //conecta el jframe con el jpanel
		
		ActHit aHit = new ActHit();
		bHit.addActionListener(aHit);
		bHit.setBounds(400,400,200,120);
		bHit.setBackground(colorButton);
		bHit.setFont(fontButton);
		bHit.setText("HIT");
		board.add(bHit);
	
		ActStay aStay = new ActStay();
		bStay.addActionListener(aStay);
		bStay.setBounds(600,400,200,120);
		bStay.setBackground(colorButton);
		bStay.setFont(fontButton);
		bStay.setText("STAY");
		board.add(bStay);
	
	}
	public static void addButton(JButton jb,String name) {
		
	}
	
	public class Board extends JPanel{  //donde vamos a dibujar todo
		
		public void paintComponent(Graphics g) {
			g.setColor(colorBackground);
			g.fillRect(0, 0, actualWidth,actualHeight);
			
			//temporary grid painting player1
			g.setColor(Color.black);
			g.drawRect(gridX, gridY, gridW, gridH);
			//temporary grid painting player2
			g.setColor(Color.black);
			g.drawRect(gridX+gridW+50, gridY, gridW, gridH);
			//temporary grid painting player3
			g.setColor(Color.black);
			g.drawRect(gridX+2*gridW+100, gridY, gridW, gridH);
			//temporary grid painting player4
			g.setColor(Color.black);
			g.drawRect(gridX+3*gridW+150, gridY, gridW, gridH);
		}
		
	}
	
	
	
	public class ActHit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("WORKING");
			
		}
		
	}
	public class ActStay implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("WORKING");
			
		}
		
	}
	
	
	
}
