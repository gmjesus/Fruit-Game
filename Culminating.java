// The "Culminating" class.
/*Title: The Fruit Game
  Name: Jesus Garcia Moreno
  Date: June 20,2017
  Description: The purpose of the this program is to create a game similar to
  "The Fruit Game." At the start of the game there will be three piles of fruit:
  lemons, oranges, and bananas. The objective of the game is to take the very
  last fruit from the table. The number of lemons can vary between 5-7, the
  number of oranges can vary between 3-5, and the number of bananas can vary
  between 1-3. The user will then choose if they want to go first, if they
  say "no"; the computer will then go first. The user is not allowed to skip
  a turn. During the user's turn they must remove a certain number of fruit
  from only a pile. The user may not take two different types of fruit during
  one turn. The user will be asked two different questions, the type of
  fruit they would want to remove, and how many to remove from the pile.
  Once there are no fruit left, the game will end. Whoever took the last
  turn will win the game.
*/
import java.awt.*;
import hsa.Console;

public class Culminating
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	//Declaration
	int numLemon, numOrange, numBanana, total, userCount, compCount;
	char key, choice;

	//Assignment
	Font gameTitle = new Font ("ArialBlack", Font.BOLD, 40);
	Font gameRules = new Font ("ArialBlack", Font.BOLD, 20);
	Color lightBlue = new Color (5, 232, 250);

	char[] userAns = new char [9];
	char[] compAns = new char [9];

	int[] userNum = new int [9];
	int[] compNum = new int [9];

	String[] compName = new String [9];

	numLemon = (int) (Math.random () * 3 + 5);
	numOrange = (int) (Math.random () * 3 + 3);
	numBanana = (int) (Math.random () * 3 + 1);
	total = numLemon + numOrange + numBanana;

	userCount = 0;
	compCount = 0;

	//Introduction Screen
	c.setColor (lightBlue);
	c.fillRect (0, 0, 700, 700);

	c.setColor (Color.black);
	c.setFont (gameTitle);
	c.drawString ("Welcome to The Fruit Game!", 45, 60);

	c.setFont (gameRules);
	c.drawString ("How to Play: You will see three piles of fruit. During your turn you ", 10, 160);
	c.drawString ("may remove any number of fruit from one pile. However, you can't", 10, 190);
	c.drawString ("take two different types of fruit in one turn. You must remove", 10, 220);
	c.drawString ("something every turn, you cannot skip a turn. To remove a", 10, 250);
	c.drawString ("number of fruit, you must choose the type of fruit and how many ", 10, 280);
	c.drawString ("to remove. The objective of the game is to take the last fruit from", 10, 310);
	c.drawString ("the whole pile. Your opponent will be the computer.", 10, 340);

	c.drawString ("Please press any key to continue", 150, 460);
	key = c.getChar ();
	c.clear ();

	//Asking the user if they want to go first
	do
	{
	    c.setColor (lightBlue);
	    c.fillRect (0, 0, 700, 700);
	    c.setColor (Color.white);
	    c.fillRect (0, 150, 700, 200);

	    c.setColor (Color.black);
	    c.drawString ("Would you like to have the first", 161, 200);
	    c.drawString ("turn? Enter (Y/N): ", 220, 230);
	    c.setCursor (14, 38);
	    choice = c.getChar ();
	    c.print (choice);
	    if (choice == 'y' || choice == 'Y' || choice == 'n' || choice == 'N')
		break;
	}
	while (choice != 'y' || choice != 'Y' || choice != 'n' || choice != 'N');

	c.drawString ("Please press any key to continue", 150, 460);
	key = c.getChar ();
	c.clear ();
	gameboard (numLemon, numOrange, numBanana);

	//Asking which type of fruit to remove for the user's first turn
	if (choice == 'y' || choice == 'Y')
	{
	    c.setCursor (17, 1);
	    do
	    {
		c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		userAns [0] = c.getChar ();
		c.println (userAns [0]);
		if (userAns [0] == 'l' || userAns [0] == 'L' || userAns [0] == 'o' || userAns [0] == 'O' || userAns [0] == 'b' || userAns [0] == 'B')
		    break;
	    }
	    while (userAns [0] != 'l' || userAns [0] != 'L' || userAns [0] != 'o' || userAns [0] != 'O' || userAns [0] != 'b' || userAns [0] != 'B');
	    //Asking how many fruit to remove of that type
	    if (userAns [0] == 'l' || userAns [0] == 'L')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [0] = c.readInt ();
		}
		while (userNum [0] <= 0 || userNum [0] > numLemon);
		if (userNum [0] <= numLemon)
		    numLemon = numLemon - userNum [0];
	    }
	    if (userAns [0] == 'o' || userAns [0] == 'O')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [0] = c.readInt ();
		}
		while (userNum [0] <= 0 || userNum [0] > numOrange);
		if (userNum [0] <= numOrange)
		    numOrange = numOrange - userNum [0];
	    }

	    if (userAns [0] == 'b' || userAns [0] == 'B')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [0] = c.readInt ();
		}
		while (userNum [0] <= 0 || userNum [0] > numBanana);
		if (userNum [0] <= numBanana)
		    numBanana = numBanana - userNum [0];
	    }
	    total = numLemon + numOrange + numBanana;
	    c.println ("Please press any key to continue");
	    key = c.getChar ();
	    c.clear ();
	    gameboard (numLemon, numOrange, numBanana);
	}

	//The computer's first turn
	compAns [0] = typeFruit (numLemon, numOrange, numBanana);
	compNum [0] = numFruit (numLemon, numOrange, numBanana, compAns [0]);
	compName [0] = nameFruit (compAns [0]);
	if (compAns [0] == 'L')
	    numLemon = numLemon - compNum [0];
	else if (compAns [0] == 'O')
	    numOrange = numOrange - compNum [0];
	else
	    numBanana = numBanana - compNum [0];
	total = numLemon + numOrange + numBanana;

	c.setCursor (17, 1);
	c.println ("The computer chose to remove " + compNum [0] + " " + compName [0]);
	c.println ("Please press any key to continue");
	key = c.getChar ();
	c.clear ();
	gameboard (numLemon, numOrange, numBanana);


	//A loop for the rest of computer's and user's turns
	for (int count = 1 ; total >= 0 ; count++)
	{
	    //Asking which type of fruit to remove for the user's  turn & error-checking: making sure the user doesn't enter an incorrect type of fruit
	    c.setCursor (17, 1);
	    if (numLemon == 0 && numOrange == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'b' || userAns [count] == 'B')
			break;
		}
		while (userAns [count] != 'b' || userAns [count] != 'B');
	    }
	    else if (numLemon == 0 && numBanana == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'o' || userAns [count] == 'O')
			break;
		}
		while (userAns [count] != 'o' || userAns [count] != 'O');
	    }
	    else if (numOrange == 0 && numBanana == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'l' || userAns [count] == 'L')
			break;
		}
		while (userAns [count] != 'l' || userAns [count] != 'L');
	    }
	    else if (numLemon == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'o' || userAns [count] == 'O' || userAns [count] == 'b' || userAns [count] == 'B')
			break;
		}
		while (userAns [count] != 'o' || userAns [count] != 'O' || userAns [count] != 'b' || userAns [count] != 'B');
	    }
	    else if (numOrange == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'l' || userAns [count] == 'L' || userAns [count] == 'b' || userAns [count] == 'B')
			break;
		}
		while (userAns [count] != 'l' || userAns [count] != 'L' || userAns [count] != 'b' || userAns [count] != 'B');
	    }
	    else if (numBanana == 0)
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'l' || userAns [count] == 'L' || userAns [count] == 'o' || userAns [count] == 'O')
			break;
		}
		while (userAns [count] != 'l' || userAns [count] != 'L' || userAns [count] != 'o' || userAns [count] != 'O');
	    }
	    else
	    {
		do
		{
		    c.print ("Which type of fruit would you like to remove? Enter the letter of the fruit: ");
		    userAns [count] = c.getChar ();
		    c.println (userAns [count]);
		    if (userAns [count] == 'l' || userAns [count] == 'L' || userAns [count] == 'o' || userAns [count] == 'O' || userAns [count] == 'b' || userAns [count] == 'B')
			break;
		}
		while (userAns [count] != 'l' || userAns [count] != 'L' || userAns [count] != 'o' || userAns [count] != 'O' || userAns [count] != 'b' || userAns [count] != 'B');
	    }

	    //Asking how many fruit to remove of that type
	    if (userAns [count] == 'l' || userAns [count] == 'L')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [count] = c.readInt ();
		}
		while (userNum [count] <= 0 || userNum [count] > numLemon);
		if (userNum [count] <= numLemon)
		    numLemon = numLemon - userNum [count];
	    }
	    if (userAns [count] == 'o' || userAns [count] == 'O')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [count] = c.readInt ();
		}
		while (userNum [count] <= 0 || userNum [count] > numOrange);
		if (userNum [count] <= numOrange)
		    numOrange = numOrange - userNum [count];
	    }

	    if (userAns [count] == 'b' || userAns [count] == 'B')
	    {
		do
		{
		    c.print ("Please enter how many fruit of this type you would like to remove: ");
		    userNum [count] = c.readInt ();
		}
		while (userNum [count] <= 0 || userNum [count] > numBanana);
		if (userNum [count] <= numBanana)
		    numBanana = numBanana - userNum [count];
	    }
	    total = numLemon + numOrange + numBanana;


	    c.println ("Please press any key to continue");
	    key = c.getChar ();
	    c.clear ();
	    gameboard (numLemon, numOrange, numBanana);
	    userCount++;
	    //Checking if the game is over
	    if (total == 0)
		break;

	    //The computer's next turn
	    compAns [count] = typeFruit (numLemon, numOrange, numBanana);
	    compNum [count] = numFruit (numLemon, numOrange, numBanana, compAns [count]);
	    compName [count] = nameFruit (compAns [count]);
	    if (compAns [count] == 'L')
		numLemon = numLemon - compNum [count];
	    else if (compAns [count] == 'O')
		numOrange = numOrange - compNum [count];
	    else
		numBanana = numBanana - compNum [count];
	    total = numLemon + numOrange + numBanana;

	    c.setCursor (17, 1);
	    c.println ("The computer chose to remove " + compNum [count] + " " + compName [count]);
	    c.println ("Please press any key to continue");
	    key = c.getChar ();
	    c.clear ();
	    gameboard (numLemon, numOrange, numBanana);
	    compCount++;
	    //Checking if the game is over
	    if (total == 0)
		break;
	}
	c.clear ();

	//Determining who won the game
	c.setColor (lightBlue);
	c.fillRect (0, 0, 700, 700);
	c.setColor (Color.black);

	if ((choice == 'y' || choice == 'Y') && userCount > compCount)
	    wonGame ();
	else if ((choice == 'y' || choice == 'Y') && userCount == compCount)
	    lostGame ();

	if ((choice == 'n' || choice == 'N') && userCount > compCount)
	    wonGame ();
	else if ((choice == 'n' || choice == 'N') && userCount == compCount)
	    lostGame ();


    } // main method


    //Drawing the game board
    public static void gameboard (int l, int o, int b)
    {
	Font gameTitle = new Font ("ArialBlack", Font.BOLD, 40);
	c.setColor (Color.black);
	c.drawRect (40, 0, 560, 300);
	c.drawLine (40, 100, 600, 100);
	c.drawLine (40, 200, 600, 200);
	c.setFont (gameTitle);
	c.drawString ("L", 0, 60);
	c.drawString ("O", 0, 160);
	c.drawString ("B", 0, 260);

	//Drawing the fruits on the board
	drawLemon (l);
	drawOrange (o);
	drawBanana (b);
    }


    //Drawing the lemons
    public static void drawLemon (int num)
    {
	int x = 0;
	for (int count = 0 ; count < num ; count++)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (40 + x, 25, 60, 50);
	    c.setColor (Color.black);
	    c.drawOval (40 + x, 25, 60, 50);
	    x += 80;
	}
    }


    //Drawing the oranges
    public static void drawOrange (int num)
    {
	int x = 0;
	for (int count = 0 ; count < num ; count++)
	{
	    c.setColor (Color.orange);
	    c.fillOval (40 + x, 125, 50, 50);
	    c.setColor (Color.black);
	    c.drawOval (40 + x, 125, 50, 50);
	    x += 80;
	}
    }


    //Drawing the bananas
    public static void drawBanana (int num)
    {
	int x = 0;
	for (int count = 0 ; count < num ; count++)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (40 + x, 225, 50, 50);
	    c.setColor (Color.black);
	    c.drawOval (40 + x, 225, 50, 50);
	    c.drawArc (50 + x, 225, 50, 50, 90, 90);
	    c.setColor (Color.white);
	    c.fillOval (60 + x, 225, 50, 50);
	    c.setColor (Color.black);
	    c.drawArc (60 + x, 225, 50, 50, 110, 140);
	    x += 80;
	}
    }


    //Determining which type of fruit to remove from the computer
    public static char typeFruit (int l, int o, int b)
    {
	int x = (int) (Math.random () * 3 + 1);

	//Making sure the computer makes a smart choice
	if (l == 0 && o == 0)
	    x = 3;
	else if (o == 0 && b == 0)
	    x = 1;
	else if (l == 0 && b == 0)
	    x = 2;
	else if (l == 0)
	    x = (int) (Math.random () * 3 + 2);
	else if (o == 0)
	    x = 1;
	else if (b == 0)
	    x = (int) (Math.random () * 2 + 1);

	if ((l > 1 && o == 1 && b == 0) || (l > 1 && o == 0 && b == 1))
	    x = 1;
	else if ((l == 1 && o > 1 && b == 0) || (l == 0 && o > 1 && b == 1))
	    x = 2;
	else if ((l == 0 && o == 1 && b > 1) || (l == 1 && o == 0 && b > 1))
	    x = 3;
	else if ((l > 2 && o == 2 && b == 0) || (l > 2 && o == 0 && b == 2))
	    x = 1;
	else if ((l == 2 && o > 2 && b == 0) || (l == 0 && o > 2 && b == 2))
	    x = 2;
	else if ((l == 0 && o == 2 && b > 2) || (l == 2 && o == 0 && b > 2))
	    x = 3;
	else if ((l > 0 && o == 1 && b == 1) || (l > 0 && o == 2 && b == 2))
	    x = 1;
	else if ((l == 1 && o > 0 && b == 1) || (l == 2 && o > 0 && b == 2))
	    x = 2;
	else if ((l == 1 && o == 1 && b > 0) || (l == 2 && o == 2 && b > 0))
	    x = 3;
	else if (l == 0 && o > b)
	    x = 2;
	else if (b == 0 && l > o)
	    x = 1;

	//Returning a char variable
	char type;
	if (x == 1)
	    type = 'L';
	else if (x == 2)
	    type = 'O';
	else
	    type = 'B';
	return type;

    }


    //Translating the char varable type to a String variable type
    public static String nameFruit (char type)
    {
	String name;
	if (type == 'L')
	    name = "lemon(s)";
	else if (type == 'O')
	    name = "orange(s)";
	else
	    name = "banana(s)";
	return name;
    }


    //Determining how many fruit to remove from the computer
    public static int numFruit (int l, int o, int b, char type)
    {
	int num;
	if (type == 'L')
	    num = (int) (Math.random () * l + 1);
	else if (type == 'O')
	    num = (int) (Math.random () * o + 1);
	else
	    num = (int) (Math.random () * b + 1);

	//Making sure the computer makes smart choices

	if (type == 'L' && ((l > 1 && o == 0 && b == 1) || (l > 1 && o == 1 && b == 0)))
	    num = l - 1;
	else if (type == 'O' && ((l == 0 && o > 1 && b == 1) || (l == 1 && o > 1 && b == 0)))
	    num = o - 1;
	else if (type == 'B' && ((l == 1 && o == 0 && b > 1) || (l == 0 && o == 1 && b > 1)))
	    num = b - 1;
	else if (type == 'L' && ((l > 2 && o == 0 && b == 2) || (l > 2 && o == 2 && b == 0)))
	    num = l - 2;
	else if (type == 'O' && ((l == 0 && o > 2 && b == 2) || (l == 2 && o > 2 && b == 0)))
	    num = o - 2;
	else if (type == 'L' && ((l > 3 && o == 0 && b == 3) || (l > 3 && o == 3 && b == 0)))
	    num = l - 3;
	else if (type == 'O' && ((l == 0 && o > 3 && b == 3) || (l == 3 && o > 3 && b == 0)))
	    num = o - 3;
	else if (type == 'L' && (l > 4 && o == 4 && b == 0))
	    num = l - 4;
	else if (type == 'O' && (l == 4 && o > 4 && b == 0))
	    num = o - 4;
	else if (type == 'O' && ((l > 3 && o == 3 && b == 0) || (l == 0 && o == 3 && b == 3)))
	    num = 1;
	else if (type == 'L' && ((l > 0 && o == 1 && b == 1) || (l > 0 && o == 2 && b == 2)))
	    num = l;
	else if (type == 'O' && ((l == 1 && o > 0 && b == 1) || (l == 2 && o > 0 && b == 2)))
	    num = o;
	else if (type == 'B' && ((l == 1 && o == 1 && b > 0) || (l == 2 && o == 2 && b > 0)))
	    num = b;
	else if ((l == 3 && o == 3 && b == 0) || (l == 0 && o == 3 && b == 3) || (l == 3 && o == 0 && b == 3))
	    num = (int) (Math.random () * 2 + 1);
	else if (l > 3 && o > 3 && b == 0)
	    num = (int) (Math.random () * 2 + 1);
	else if (l > 3 && o == 0 && b > 2)
	    num = (int) (Math.random () * 2 + 1);
	else if (l == 0 && o > 3 && b > 2)
	    num = (int) (Math.random () * 2 + 1);
	else if (l > 3 && o == 0 && b == 1)
	    num = 1;
	else if (l == 0 && o > 3 && b == 1)
	    num = 1;
	else if (type == 'L' && ((l > 1 && o > 1 && b == 1) || (l > 1 && o == 1 && b > 1)))
	    num = l - (int) (Math.random () * (l - 1) + 1);
	else if (type == 'O' && ((l == 1 && o > 1 && b > 1) || (l > 1 && o > 1 && b == 1)))
	    num = o - (int) (Math.random () * (o - 1) + 1);
	else if (type == 'B' && ((l > 1 && o == 1 && b > 1) || (l == 1 && o > 1 && b > 1)))
	    num = b - (int) (Math.random () * (b - 1) + 1);
	else if ((l == 3 && o == 3 && b == 0) || (l == 3 && o == 0 && b == 3) || (l == 0 && o == 3 && b == 3))
	    num = (int) (Math.random () * 2 + 1);

	if ((l == 2 && o == 2 && b == 0) || (l == 0 && o == 2 && b == 2) || (l == 2 && o == 0 && b == 2))
	    num = 1;
	else if ((l == 3 && o == 3 && b == 0) || (l == 0 && o == 3 && b == 3) || (l == 3 && o == 0 && b == 3))
	    num = 1;
	else if (l == 4 && o == 4 && b == 0)
	    num = 1;

	//Making sure the computer wins if there is only one type of fruit left
	if (l == 0 && o == 0 && b > 0)
	    num = b;
	else if (l > 0 && o == 0 && b == 0)
	    num = l;
	else if (l == 0 && o > 0 && b == 0)
	    num = o;

	return num;
    }


    //Outro screen if the player won
    public static void wonGame ()
    {
	Font gameRules = new Font ("ArialBlack", Font.BOLD, 20);
	Font gameTitle = new Font ("ArialBlack", Font.BOLD, 40);
	Color lightBlue = new Color (5, 232, 250);
	c.setFont (gameTitle);
	c.drawString ("CONGRATULATIONS!", 100, 200);
	c.setFont (gameRules);
	c.drawString ("You won the game!!", 215, 250);
	for (int y = 0 ; y < 520 ; y++)
	{
	    c.setColor (Color.red);
	    c.fillStar (30, y, 50, 50);
	    delay (1);
	    c.setColor (lightBlue);
	    c.fillStar (30, y, 50, 50);
	    c.setColor (Color.red);
	    c.fillStar (570, y, 50, 50);
	    delay (1);
	    c.setColor (lightBlue);
	    c.fillStar (570, y, 50, 50);
	}
    }


    //Outro screen if the player lost
    public static void lostGame ()
    {
	Font gameRules = new Font ("ArialBlack", Font.BOLD, 20);
	Font gameTitle = new Font ("ArialBlack", Font.BOLD, 40);
	c.setFont (gameTitle);
	c.drawString ("GAME OVER!", 195, 200);
	c.setFont (gameRules);
	c.drawString ("Uh-Oh! You lost the game! ", 200, 250);
    }


    //Delay method
    public static void delay (int millisecs)
    {
	try
	{
	    Thread.currentThread ().sleep (millisecs);
	}


	catch (InterruptedException e)
	{
	}
    }
} // Culminating class
