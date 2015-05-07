import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	
	public boolean isLegal(List<Integer> selectedCards) 
{
	if(selectedCards.size() ==2 )
{
		return containsPairSum11(selectedCards);
}
	else if(selectedCards.size() == 3)
{
		return containsJQK(selectedCards);
	}
else 
return false;
}

public boolean anotherPlayIsPossible()
{
	return (containsPairSum11(cardIndexes()) || containsJQK(cardIndexes()));
}

public boolean containsPairSum11(List<Integer> selectedCards)
{
for (int x = 0; x < selectedCards.size()-1; x++)
{
for (int y = 1; y < selectedCards.size(); y++)	
{
            		if (cardAt(selectedCards.get(x)).pointValue() + cardAt(selectedCards.get(y)).pointValue() == 11)
			{
                       		return true;
		}
	}
}
return false;

}

public boolean containsJQK(List<Integer> selectedCards)
{
boolean jBool = false;
boolean qBool = false;
boolean kBool = false;
        	for(int ind = 0; ind < selectedCards.size(); ind++)
        	{
            	if(this.cardAt(selectedCards.get(ind)).rank().equals("jack"))
            	{
                		jBool = true;
            	}
            	if(cardAt(selectedCards.get(ind)).rank().equals("queen"))
            	{
                		qBool = true;
            	}
            	if(cardAt(selectedCards.get(ind)).rank().equals("king"))
            	{
              		kBool = true;
            	}
      	}
        	return jBool&&qBool&&kBool;
}
}
