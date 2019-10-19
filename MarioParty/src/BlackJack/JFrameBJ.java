package BlackJack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameBJ extends JFrame{
		
		//card grid positioning and dimensions
		int gridX = 50;
		int gridY = 350;
		int gridW = 256;
		int gridH = 500;
		// card dimensions and spacing
		int cardTW = 120;
		int cardTH = 200;
		int cardX = (gridW/5)+63;
		int cardY = gridY+20;	
		
		//hit stay grid positioning
		int hsX = 800;
		int hsY = 50;
		int hsW = 400;
		int hsH = 200;
			//actual window resolution
			int actualWidth =1280;
			int actualHeight = 1000;
			
	
			//background color
			Color colorBackground = new Color(39,119,20);
			Color colorButton = new Color(204,204,0);
			
			//fonts
			Font fontButton = new Font("Times New Roman",Font.ROMAN_BASELINE,30);
			Font fontLabel = new Font("Times New Roman",Font.ROMAN_BASELINE,20);
			
	//buttons
			JButton bHit = new JButton();
			JButton bStay = new JButton();
			JButton bYes = new JButton();
			JButton bNo = new JButton();
	//jLabel	
			JLabel jugadorAct = new JLabel();
			JLabel cronometro = new JLabel();
			JLabel score[] = new JLabel[4];
			JLabel JLabelganador = new JLabel();
			
			
			Deck deck = new Deck();
			ArrayList<PlayerBJ> players= new ArrayList<PlayerBJ>();
			int jugadorActual = 0;
			ArrayList<String> ganador = new ArrayList<String>();
			ArrayList<Integer>ganadorIndex = new ArrayList<Integer>();
			int banGanador=0;
	
			
	public JFrameBJ (ArrayList<String> jugadores)  {
		this.setSize(actualWidth+6,actualHeight+29);
		this.setTitle("BlackJack");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanelBJ panel= new JPanelBJ();
		
		this.setContentPane(panel); //conecta el jframe con el jpanel
		this.setLayout(null);
		
		

//		players.add(new PlayerBJ("Yahir",deck.dealCard(),deck.dealCard()));
//		players.add(new PlayerBJ("Ayrton",deck.dealCard(),deck.dealCard()));
//		players.add(new PlayerBJ("Fransis",deck.dealCard(),deck.dealCard()));
//		players.add(new PlayerBJ("Leo",deck.dealCard(),deck.dealCard()));
		for(int i=0;i<jugadores.size();i++) {
			players.add(new PlayerBJ(jugadores.get(i),deck.dealCard(),deck.dealCard()));
		}
		
		jugadorAct.setText("JUGADOR ACTUAL:"+players.get(0).getPlayer());
		bHit.addActionListener(panel);
		bStay.addActionListener(panel);
		
		formatButtons(panel);
		formatLabels(panel);
		formatChronometer(panel);
		jLabelGanador(panel);
		
		
		Timer timer = new Timer();
		int begin = 0;
		int timeInterval = 1000;
		timer.schedule(new TimerTask() {
		  int counter = 0;
		   @Override
		   public void run() {
		       try {
		    	   banGanador=hayGanador(panel);
		    	   saltearTurno(panel);
		    	   
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       counter++;
		       if (counter >= 5000){
		         timer.cancel();
		       }
		   }
		}, begin, timeInterval);
		
		
}
		
	private void formatChronometer(JPanelBJ panel) {
		cronometro.setBounds(hsX-80,hsY+60,80,80);
		cronometro.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,40));
		cronometro.setForeground(Color.black);
		cronometro.setHorizontalAlignment(JLabel.CENTER);
	    cronometro.setVerticalAlignment(JLabel.CENTER);
		cronometro.setBorder(BorderFactory.createLineBorder(Color.black, 3));;
		cronometro.setText("14");
		panel.add(cronometro);
	}
	private void jLabelGanador(JPanelBJ panel) {
		JLabelganador.setBounds(gridX,20,650,270);
		JLabelganador.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,35));
		JLabelganador.setForeground(Color.black);
		JLabelganador.setVerticalAlignment(JLabel.CENTER);
		JLabelganador.setVisible(false);
		JLabelganador.setText("EL GANADOR ES:KONO DIO DAAAA");
		panel.add(JLabelganador);
	}
	
	
	private void saltearTurno(JPanelBJ panel)throws InterruptedException {
		if(players.get(jugadorActual).calcularPuntaje()>=21 || players.get(jugadorActual).isStayFlag()) {
			if(jugadorActual==players.size()-1)
				jugadorActual=0;
			else
				jugadorActual++;
			jugadorAct.setText("JUGADOR ACTUAL:"+players.get(jugadorActual).getPlayer());
			
		}
	}
	private int hayGanador(JPanelBJ panel) throws InterruptedException {
		int ban=0;
		for(int i=0;i<players.size();i++) {
			if(players.get(i).calcularPuntaje()<21 && !players.get(i).isStayFlag())
				ban=1;
		}
		if(ban==1) {
			return 0;
		}
		else {
			int mayor=0;
			int posMayor=-1;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).calcularPuntaje()>mayor &&players.get(i).calcularPuntaje()<=21) {
					mayor=players.get(i).calcularPuntaje();
					posMayor=i;
				}
			}
			if(posMayor==-1) {
				JLabelganador.setText("NO HAY GANADOR");	
			}
			else {
				JLabelganador.setText("EL GANADOR ES: ");
				for(int i=0;i<players.size();i++) {
					if(players.get(i).calcularPuntaje()==mayor) {
						JLabelganador.setText(JLabelganador.getText()+
								players.get(i).getPlayer().toUpperCase());
						ganador.add(players.get(i).getPlayer());
						ganadorIndex.add(i);
					}
				}
				
				
			}
				
			JLabelganador.setVisible(true);
			
			
			return 1;
		}

	}


    public void CerrarVentana(){
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
       }
	private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}

	private void formatLabels(JPanelBJ panel) {
		jugadorAct.setBounds(hsX+50,hsY+10,300,50);
		jugadorAct.setFont(fontLabel);
		jugadorAct.setForeground(Color.black);
		jugadorAct.setText("JUGADOR ACTUAL");
		panel.add(jugadorAct);
		
		for(int i=0;i<players.size();i++) {
			score[i]=new JLabel();
			score[i].setBounds(gridX+i*(gridW+gridW/5), gridY+gridH+10, gridW,50);
			score[i].setFont(fontLabel);
			score[i].setForeground(Color.black);
			score[i].setText("SCORE "+players.get(i).getPlayer()+": "+players.get(i).calcularPuntaje());
			panel.add(score[i]);
			
		}
	}



	private void formatButtons(JPanelBJ panel) {
		bHit.setBackground(colorButton);
		bHit.setBounds(hsX+55,hsY+60,120,80);
		bHit.setFont(fontButton);
		bHit.setText("HIT");
		panel.add(bHit);
		bStay.setBounds(hsX+110+120,hsY+60,120,80);
		bStay.setBackground(colorButton);
		bStay.setFont(fontButton);
		bStay.setText("STAY");
		panel.add(bStay);
	}
	
	
	
	public class JPanelBJ extends JPanel implements ActionListener{
		public void paintComponent(Graphics g) {
			g.setColor(colorBackground);
			g.fillRect(0, 0, actualWidth,actualHeight);
			//temporary grid painting player1
			for(int i=0;i<players.size();i++) {
				g.setColor(Color.black);
				g.drawRect(gridX+i*(gridW+gridW/5), gridY, gridW, gridH);
				for(int j=0;j<5;j++) {
					g.setColor(Color.black);
					g.drawRect(cardX+i*(gridW+gridW/5),cardY+j*50, cardTW, cardTH);
					//hit stay
					g.setColor(Color.black);
					g.drawRect(hsX, hsY, hsW, hsH);
				}
				pintarCarta(g);
			}
		}
		public void pintarCarta(Graphics g) {
			for (int i=0;i<players.size(); i++) {
				for(int j=0;j<players.get(i).getCartas().size();j++) {
					g.drawImage(players.get(i).getCartas().get(j).getImg(), cardX+i*(gridW+gridW/5),cardY+j*50, cardTW, cardTH,null);
				}
			}
		}
		public void pintarActual(Graphics g) {
			g.setColor(Color.green);
			g.drawRect(gridX+jugadorActual*(gridW+gridW/5), gridY, gridW, gridH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bHit) {
				if(players.get(jugadorActual).calcularPuntaje()<21 && !players.get(jugadorActual).isStayFlag()) {
					players.get(jugadorActual).getCartas().add(deck.dealCard());
					score[jugadorActual].setText("SCORE "+players.get(jugadorActual).getPlayer()+": "+players.get(jugadorActual).calcularPuntaje());
				}
				if(jugadorActual==players.size()-1)
					jugadorActual=0;
				else
					jugadorActual++;
				jugadorAct.setText("JUGADOR ACTUAL:"+players.get(jugadorActual).getPlayer());
				pintarActual(getGraphics());
			}
			if(e.getSource()==bStay) {
				players.get(jugadorActual).setStayFlag(true);
				if(jugadorActual==players.size()-1)
					jugadorActual=0;
				else
					jugadorActual++;
				jugadorAct.setText("JUGADOR ACTUAL:"+players.get(jugadorActual).getPlayer());
				pintarActual(getGraphics());
			}
			
			
		}
		

	}
	
	
}
