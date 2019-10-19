package BlackJack;


import java.util.Collections;
import java.util.Optional;
import java.util.Stack;


public class Deck {
	
	private final Stack<Card> deckCards;
	public  Deck() {
		this.deckCards = initDeck();
	}
	
	private Stack<Card> initDeck(){
		
		final Stack <Card> deckCards = new Stack<>();
		for(Card.Suit suit : Card.Suit.values()) {
			for(Card.Rank rank : Card.Rank.values()) {
				deckCards.push(Card.getCard(rank,suit));				
			}
		}
		
		Collections.shuffle(deckCards);
		return deckCards;
	}
	
	public Optional<Card> deal(){
		return this.deckCards.empty() ?
				Optional.empty():Optional.of(this.deckCards.pop()); //Permite tomar un objeto que puede o no tener un valor. Y retornar algo si esta vacio.
	}
	public Card dealCard() {
		if(this.deckCards.isEmpty())
			return null;
		return deckCards.pop();
	}
	
	

}
