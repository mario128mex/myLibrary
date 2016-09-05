package mariomejia.graphs;
import java.util.*;

/**
 * Class that implements the BFS algorithm, this class can represen a 2D map
 * with obstacles
 * 
 * Given a 2D array in boolean form (a false element indicates an obstacle)
 * this class can tell us how many steps will take to go from a point (x1, y1)
 * to a point (x2, y2)
 * 
 * @author Mario Mejia
 * @date 07/oct/2015
*/

public class BFS{
	// predefined movements to make the search
	private int [] rowMoves    = {-1, 0, 1, 0};
	private int [] columnMoves = { 0, 1, 0,-1};

	// Information of the map and the nodes pending to visit
	public boolean [][] map;
	public Queue<Node> pending;

	// constructor of the class
	public BFS(boolean [][] map){
		this.map = map;
	}

	// this method is the BFS algorithm itself
	public int go(int startRow, int startColumn, int endRow, int endColumn){
		boolean [][] visited = new boolean[map.length][map[0].length];

		for(int i=0; i<map.length; i++)
			for(int j=0; j<map[i].length; j++)
				visited[i][j] = map[i][j];

		pending = new LinkedList<Node>();
		pending.add(new Node(startRow,startColumn,0));
		visited[startRow][startColumn] = true;

		while(!pending.isEmpty()){
			Node current = pending.poll();

			if(current.row == endRow && current.column == endColumn)
				return current.steps;

			for(int i=0; i<4; i++){
				int r = current.row + rowMoves[i];
				int c = current.column + columnMoves[i];

				try{
					if(!visited[r][c]){
						pending.add(new Node(r,c,current.steps+1));
						visited[r][c] = true;
					}
				}

				catch(Exception e){}
			}
		}

		return -1;
	}

	public void printMap(boolean [][] m){
		for(boolean [] V : m){
			for(boolean value : V){
				char c = value? 'T' : 'F';
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

	// A node class that hold all the information to make the search
	class Node{
		int row;
		int column;
		int steps;

		public Node(int row, int column, int steps){
			this.row = row;
			this.column = column;
			this.steps = steps;
		}
	}
}