import java.util.Scanner;
public class ticTacToe
{
	public static void main (String [] args)
	{
		char gameboard[][] = new char[3][3];
		for (int i = 0; i <= 2; i++)
		{
			for (int j = 0; j <= 2; j++)
			{
				gameboard[i][j] = '_';
			}
		}
		
		while (!checkWin(gameboard))
		{
			playerOneTurn(gameboard);
			if (checkWin(gameboard))
			{
					System.out.println("Player 1 wins!!!");
					break;
			}
			
			printBoard(gameboard);
			
			playerTwoTurn(gameboard);
			if (checkWin(gameboard))
			{
				System.out.println("Player 2 wins!!!");
				break;
			}
			
			printBoard(gameboard);

			if (checkDraw(gameboard))
			{
				System.out.println("It's a draw!!!");
				break;
			}
		}
	}
	
	public static char[][] playerOneTurn(char[][] a)
	{
		Scanner input = new Scanner(System.in);
		int i = -1;
		int j = -1;
		while ((i < 0 || i > 2) || (j < 0 || j > 2))
		{
			System.out.println("Player one: Pick a vertical coordinate (0,1 or 2)");
			i = input.nextInt();
			System.out.println("Player one: Pick a horizontal coordinate (0,1 or 2)");
			j = input.nextInt();
			if ((i < 0 || i > 2) || (j < 0 || j > 2)) 
			{
				System.out.println("Those coordinates are out of bounds");
			}
		}
		while (!checkFree(a,i,j))
		{
			System.out.println("Those coordinates are occupied");
			System.out.println("Player one: Pick a vertical coordinate (0,1 or 2)");
			i = input.nextInt();
			System.out.println("Player one: Pick a horizontal coordinate (0,1 or 2)");
			j = input.nextInt();
		}
		a[i][j] = 'X';
		return a;
	}
	
	public static char[][] playerTwoTurn(char[][] a)
	{
		Scanner input = new Scanner(System.in);
		int i =-1;
		int j =-1;
		while ((i < 0 || i > 2) || (j < 0 || j > 2))
		{
			System.out.println("Player two: Pick a vertical coordinate (0,1 or 2)");
			i = input.nextInt();
			System.out.println("Player two: Pick a horizontal coordinate (0,1 or 2)");
			j = input.nextInt();
			if ((i < 0 || i > 2) || (j < 0 || j > 2)) 
			{
				System.out.println("Those coordinates are out of bounds");
			}
		}
		while (!checkFree(a,i,j))
		{
			System.out.println("Those coordinates are occupied");
			System.out.println("Player two: Pick a vertical coordinate (0,1 or 2)");
			i = input.nextInt();
			System.out.println("Player two: Pick a horizontal coordinate (0,1 or 2)");
			j = input.nextInt();
		}
		a[i][j] = 'O';
		return a;
	}
	
	public static boolean checkWin(char[][] a)
	{
		for (int i = 0; i <= 2; i++)
		{
			if (a[i][0] == a[i][1] && a[i][1] == a[i][2] && (a[i][0] == 'X' || a[i][0] == 'O'))
				return true;
		}
		for (int i = 0; i <= 2; i++)
		{
			if (a[0][i] == a[1][i] && a[1][i] == a[2][i] && (a[0][i] == 'X' || a[0][i] == 'O'))
				return true;
		}
		if (a[0][0] == a[1][1] && a[1][1] == a[2][2] && (a[0][0] == 'X' || a[0][0] == 'O'))
				return true;
		if (a[0][2] == a[1][1] && a[1][1] == a[2][0] && (a[0][2] == 'X' || a[0][2] == 'O'))
				return true;
		if (checkDraw(a))
			return true;
		return false;
	}
	
	public static boolean checkFree(char [][] a, int r, int c)
	{
		if (a[r][c] == 'X' || a[r][c] == 'O')
			return false;
		else return true;
	}
	public static boolean checkDraw(char [][] a)
	{
		int playCounter = 0;
		for (int i = 0; i <= 2; i++)
		{
			for (int j = 0; j <= 2; j++)
			{
				if (a[i][j] != '_')
					playCounter++;
			}
		}
		if (playCounter == 9)
			return true;
		else return false;
		
	}
	
	public static void printBoard(char [][] a)
	{
		for (int i = 0; i <= 2; i++)
		{
			for (int j = 0; j <= 2; j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
	}
}