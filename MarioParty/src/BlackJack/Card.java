package BlackJack;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Card {

	private final Rank rank;
	private final Suit suit;
	private BufferedImage img;
	private final static Map<String, Card> CARD_CACHE = initCache();
	
	private Card (final Rank rank, final Suit suit, final BufferedImage img) {
		this.rank = rank;
		this.suit = suit;
		this.img = img;
	}
	public Card(Card other) {
		this.rank = other.rank;
		this.suit = other.suit;
		this.img = other.img;
	}
	private static Map<String, Card> initCache() {  //construyo un mapa de todas las cartas posibles
		final Map<String, Card> cache = new HashMap<>();
		for ( Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				try {
					if(rank == rank.JACK) {
						cache.put(cardKey(rank,suit),new Card(rank,suit,ImageIO.read(new File("src\\Archivos\\CARDS\\J "+suit+".png"))));						
					}
					if(rank == rank.QUEEN) {
						cache.put(cardKey(rank,suit),new Card(rank,suit,ImageIO.read(new File("src\\Archivos\\CARDS\\Q "+suit+".png"))));						
					}if(rank == rank.KING) {
						cache.put(cardKey(rank,suit),new Card(rank,suit,ImageIO.read(new File("src\\Archivos\\CARDS\\K "+suit+".png"))));						
					}
					else 
						cache.put(cardKey(rank,suit),new Card(rank,suit,ImageIO.read(new File("src\\Archivos\\CARDS\\"+rank.getRankValue()+" "+suit+".png"))));						
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Collections.unmodifiableMap(cache); //nadie va a poder editar el mapa
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	@Override
	public String toString() {
		return this.rank + " of "+this.suit;
	}
	
	private static String cardKey (final Rank rank, final Suit suit) {
		return rank + " of " +suit;
	}
	
	
	
	public int getRank() {
		return this.rank.getRankValue();
	}
	public Suit getSuit() {
		return suit;
	}



	enum Suit {
		DIAMONDS,
		CLUBS,
		HEARTS,
		SPADES
	}
	
	
	enum Rank{
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE (9),
		TEN(10),
		JACK(10),
		QUEEN(10),
		KING(10),
		ACE(11);
		
		private final int rankValue;
		Rank (final int rankValue){
			this.rankValue = rankValue;
			
		}
		public int getRankValue() {
			return this.rankValue;
		}
	}


	public static Card getCard(final Rank rank, Suit suit) {
		final Card card = CARD_CACHE.get(cardKey(rank,suit));
		if (card!=null)
			return card;
		
		throw new RuntimeException("Invalid Card!"+rank + " of "+suit);
		
	}
}
