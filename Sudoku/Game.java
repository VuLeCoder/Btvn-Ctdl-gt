package Sudoku;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private final int MAX = 9, SMALL = 3, DEL_CELL;
	private int missCell;
	private Node[][] board;
	private int[][] Ans;

	public Game(int n) {
		DEL_CELL = n;
		missCell = DEL_CELL * 9;
		
		Ans = new int[MAX][MAX];
		board = new Node[MAX][MAX];
		for(int i=0; i<MAX; ++i) {
			for(int j=0; j<MAX; ++j) {
				board[i][j] = new Node(i, j, 0);
			}
		}
		createGame();
	}
	
	private boolean isValid(int row, int col, int num) {
		for(int i=0; i<MAX; ++i) {
			if(board[row][i].getValue() == num) {
				return false;
			}
		}
		
		for(int i=0; i<MAX; ++i) {
			if(board[i][col].getValue() == num) {
				return false;
			}
		}
		
		int r = (row / SMALL) * SMALL, c = (col / SMALL) * SMALL;
		for(int i=0; i<SMALL; ++i) {
			for(int j=0; j<SMALL; ++j) {
				if(board[r + i][c + j].getValue() == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean createAnswer(int row, int col) {
		if(row == MAX) return true;
		if(col == MAX) return createAnswer(row + 1, 0);
		
		Random rand = new Random();
		for(int i=1; i<=9; ++i) {
			int num = rand.nextInt(MAX) + 1;
			
			if(isValid(row, col, num)) {
				board[row][col].setValue(num);
				Ans[row][col] = num;
				
				if(createAnswer(row, col + 1)) return true;
				
				board[row][col].setValue(0);
				Ans[row][col] = 0;
			}
		}
		return false;
	}
	
	// Mỗi bảng con 3x3 xóa n số
	private void createGame() {
		createAnswer(0, 0);
		
		int delRow, delCol;
		Random rand = new Random();
		for(int i=0; i<SMALL; ++i)
		{
			for(int j=0; j<SMALL; ++j)
			{
//				int tmp = rand.nextInt(DEL_CELL - 1, DEL_CELL + 2);
				int tmp = DEL_CELL;
				while(tmp-- > 0)
				{
					delRow = rand.nextInt(i * 3, i * 3 + 3);
					delCol = rand.nextInt(j * 3, j * 3 + 3);
					
					if(board[delRow][delCol].getValue() == 0) { 
						tmp++;
						continue;
					}
					
					board[delRow][delCol].setValue(0);
				}
			}
		}
	}
	
	private boolean isValidIn(int row, int col, int num) {
		if(row > 8 || row < 0) return false;
		
		if(col > 8 || col < 0) return false;
		
		if(num > 9 || num < 1) return false;
		
		if(board[row][col].getValue() != 0) return false;
		return true;
	}
	
	private void printBoard() {
		System.out.print(" ");
		for(int i=1; i<=MAX; ++i) {
			System.out.print("   " + i);
		}
		System.out.println();
		
		System.out.println("  -------------------------------------");
		for(int i=0; i<MAX; ++i)
		{
			System.out.print((i + 1) + " | ");
			for(int j=0; j<MAX; ++j)
			{
				if(board[i][j].getValue() == 0) System.out.print(' ');
				else System.out.print(board[i][j].getValue());
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("  -------------------------------------");
		}
		System.out.println();
		System.out.println();
	}
	
	public void play() {		
		Scanner sc = new Scanner(System.in);
		int currRow, currCol, currNum;
		
		printBoard();
		
		while(true)
		{
			System.out.println("Player enter your move (row, column and number: 1 1 1, 1 2 1, ...): ");
			currRow = sc.nextInt();
			currCol = sc.nextInt();
			currNum = sc.nextInt();
			currRow--; currCol--;
			
			if(!isValidIn(currRow, currCol, currNum))
			{
				System.out.println("This move is invalid. Try again.");
				continue;
			}
			
			if(currNum != Ans[currRow][currCol])
			{
				System.out.println("This move is wrong. Try again.");
				continue;
			}
			
			missCell--;
			board[currRow][currCol].setValue(currNum);
			
			printBoard();
			if(missCell == 0) break;
		}
		System.out.println("You win!");
		sc.close();
	}
}
