import java.util.Random;

import stack.Pila;
import stack.PilaCollegata;


public class Maze {
	private final int LIBERA = 0;
	private final int OCCUPATA = 1;
	private final int PERCORSA = 2;
	Posizione startPos;
	Pila<Posizione> path = new PilaCollegata<Posizione>();
	private int [][] maze = {	{1, 1, 1, 0, 1, 0},
								{1, 0, 0, 0, 0, 1},
								{1, 0, 1, 0, 1, 1},
								{1, 0, 1, 0, 0, 1},
								{1, 1, 1, 0, 1, 1}
							};
	
	
	public Maze() {
		this.startPos = getRandomStartPos();
	}
	
	boolean attraversa(Posizione start) {
		Posizione pos = start;
		path.push(pos);
		
		if(getValue(pos) == OCCUPATA)
			return false;
		if(isExit(pos))
			return true;
		
		while(!isExit(pos)){
			pos = move(pos);
			if(pos == null){
				path.pop();
				pos = path.top();
			}
		}
		
		System.out.println("path:");
		for(Object obj : path)
			System.out.println(((Posizione)obj).toString());
		return true;
	}
	
	boolean valido(Posizione p){
		int r = p.row;
		int c = p.col;
		if(maze[r][c] == LIBERA)
			return true;
		return false;
	}
	
	private Posizione move(Posizione pos){
		Posizione nextPos = null;
		int r = pos.row;
		int c = pos.col;
		maze[r][c] = PERCORSA;
		
		if(valido(new Posizione(r,c+1))){
			nextPos = new Posizione(r,c+1);
			path.push(nextPos);
		} else if(valido(new Posizione(r,c-1))){
			nextPos = new Posizione(r,c-1);
			path.push(nextPos);
		} else if(valido(new Posizione(r+1,c))){
			nextPos = new Posizione(r+1,c);
			path.push(nextPos);
		} else if(valido(new Posizione(r-1,c))){
			nextPos = new Posizione(r-1,c);
			path.push(nextPos);
		}
		
		return nextPos;
	}
	
	private Posizione getRandomStartPos(){
		int nRows = maze.length;
		int nCols = maze[0].length;
		Posizione pos = new Posizione(new Random().nextInt(nRows), new Random().nextInt(nCols));
		return pos;
	}
	
	private int getValue(Posizione pos){
		int row = pos.row;
		int col = pos.col;
		return maze[row][col];
	}
	
	private boolean isExit(Posizione pos){
		if(pos.row == 0 || pos.row == maze.length-1)
			return true;
		if(pos.col == 0 || pos.col == maze[0].length-1)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze();
		System.out.println("START: " + maze.startPos.toString());
		maze.attraversa(maze.startPos);
	}
}
