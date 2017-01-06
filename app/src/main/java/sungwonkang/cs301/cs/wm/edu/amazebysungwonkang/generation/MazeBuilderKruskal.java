package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.Constants;
import java.util.ArrayList;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.Wall;

public class MazeBuilderKruskal extends MazeBuilder implements Runnable{
	
	int[][] set; //will be used in both generatePathways and pickNeighbor
	
	public MazeBuilderKruskal(){
		super();
		System.out.println("MazeBuilderKruskal uses Kruskal algorithm to generate maze.");
		}
		
	public MazeBuilderKruskal(boolean det) {
			super(det);
			System.out.println("MazeBuilderKruskal uses Kruskal algorithm to generate maze.");
		}


	@Override
	protected void generatePathways() {
		
		//Create a set matrix that is same size as the maze, giving each cell a different number.
		int setNumber = 0;
		set = new int[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				set[i][j] = setNumber++;
			}	
		}
		
		//Create unvisitedCoordinates arraylist that has each and every coordinates of the maze.
		//It keeps track of unvisited coordinates.
		ArrayList<int[]> unvisitedCoordinates = new ArrayList<int[]>();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				int[] coordinate = {i, j};
				unvisitedCoordinates.add(coordinate);
			}
		}

		//while there is more than one set, pick a random index in the unvisitedCordinates arraylist.
	    //in order to determine whether it is more than one set, number of walls taken down is counted.
	    //when that number reaches the number of cells - 1, the while-loop stops.
		while(unvisitedCoordinates.size() > 0){
			//picks a random value from the array, set the corresponding data as variables 
			//x (width of the random cell) and y(height of the random cell) and then 
			//removes the value from the array so the coordinate will not be used again in the future.
			int t = random.nextIntWithinInterval(0, unvisitedCoordinates.size() - 1);
			int[] currentCoordinates = (int[]) unvisitedCoordinates.remove(t);
			int row = currentCoordinates[0];
			int column = currentCoordinates[1];
		
			
		//Get a random number that corresponds to the direction of the neighbor of the cell and 
		//get the coordinate of the neighbor.
			int[] neighbor = pickRandomNeighbor(row, column);
			if(neighbor != null){
				int nrow = neighbor[0];
				int ncolumn = neighbor[1];
					
				destroyWall(row, column, nrow, ncolumn);
					
					//Iterate through and replaces the set number of every cell that has the same set number as the neighbor
					//with the set number of the original cell.
				int oldSetNumber = set[nrow][ncolumn];	
				for(int j = 0; j < height; j++){
					for (int k = 0; k < width; k++){
						if(set[j][k] == oldSetNumber){
							set[j][k] = set[row][column];
						}
					}	
				}
			}
		}
		for(int i = 0; i < height - 1; i++){
			for(int j = 0; j < width - 1; j++){
				if (set[i][j] != set[i + 1][j]){
					destroyWall(i, j, i + 1, j);
					int oldSetNumber = set[i + 1][j];	
					for(int z = 0; z < height; z++){
						for (int k = 0; k < width; k++){
							if(set[z][k] == oldSetNumber){
								set[z][k] = set[i][j];
							}
						}	
					}
				}
				if (set[i][j] != set[i][j + 1]){
					destroyWall(i, j, i, j + 1);
					int oldSetNumber = set[i][j + 1];	
					for(int z = 0; z < height; z++){
						for (int k = 0; k < width; k++){
							if(set[z][k] == oldSetNumber){
								set[z][k] = set[i][j];
							}
						}	
					}
				}
			
			}
		}
			
	}
	
	//it takes the location of a cell as a list of xy coordinates and get a random number to pick a direction of the neighbor of the cell and 
	//returns the location of the neighbor as xy coordinates in a list.
	private int[] pickRandomNeighbor(int row, int column){
		int nrow; 
		int ncolumn;
		int skill = order.getSkillLevel() ;
		int whichNeighbor = random.nextIntWithinInterval(0, 3);;
		int[] neighbor = new int[2];
		
		////////////make sure whichNeighbor is a valid direction by switching direction if it's off the edge/////////////
		
		//if it's on the top and says go up, it picks the bottom neighbor
		if(row == 0 && whichNeighbor == 1){ 
			whichNeighbor = 2;
		}
		//if it's on the bottom and says go down, it picks the top neighbor
		else if(row == Constants.SKILL_Y[skill] - 1 && whichNeighbor == 2){ 
			whichNeighbor = 1;
		}
		//if it's on the right and says go right, it picks the left neighbor
		else if(column == Constants.SKILL_X[skill] - 1 && whichNeighbor == 0){
			whichNeighbor = 3;
		}
		//if it's on the left and says go left, it picks the right neighbor
		else if(column == 0 && whichNeighbor == 3){
			whichNeighbor = 0;
		}
		//////////choosing an initial neighbor neighbor///////////
		if (whichNeighbor == 1){
			nrow = row - 1; // select top neighbor;
			ncolumn = column;
		}
		else if (whichNeighbor == 2) {
			nrow = row + 1; // select bottom neighbor;
			ncolumn = column;
		}
		else if (whichNeighbor == 3) {
			nrow = row; // select left neighbor;
			ncolumn = column - 1;
		}
		else {
			nrow = row; // select right neighbor;
		    ncolumn = column + 1;
		}
		
		//if the neighbor is in a different set, then send it to generatePathways so it can break down the wall between it
		if(set[row][column] != set[nrow][ncolumn]){
			neighbor = new int[]{nrow, ncolumn};
			return neighbor;
		}
		
		///////////////the neighbor is part of the same set, so move clockwise until it finds a neighbor that is in a different set////////////
		//using try/catch because it will pick cells that are out of bounds if it's on the edge
		
		for(int i = 0; i < 3; i++){ //only 3 other directions 	
			try{
				if (column == ncolumn - 1 && row == nrow){ //right to bottom
					nrow++;
					ncolumn--;
				}
				else if (column == ncolumn + 1 && row == nrow){ // left to top
					nrow--;
					ncolumn++;
				}
				else if (column == ncolumn && row == nrow + 1){ // top to right
					nrow++;
					ncolumn++;
				}
				else if(column == ncolumn && row == nrow - 1){ // bottom to left
					nrow--;
					ncolumn--;
				}
				
				if(set[row][column] != set[nrow][ncolumn]){
					neighbor = new int[]{nrow, ncolumn};
					return neighbor;
				}
			}
			
			catch(Exception e){
				continue;
			}
		}
		
		//if all four directions are part of the same set, then it returns a null neighbor
		return null;

	}
	
	
	private void destroyWall(int row, int column, int nrow, int ncolumn){
		//if they are not in the same set, delete the wall between them and combine them in the list of sets. 
		//set number of the cell overwrites every cell that has the set number of the neighbor.
		CardinalDirection[][] origcds = new CardinalDirection[width][height]; 
		CardinalDirection cd = CardinalDirection.East;
		CardinalDirection origcd = cd;
		
		//if same set neighbor is in the east, check the neighbor in the south.
		//south --> west, west --> north, north --> east.
		
		//this sets the direction of the wall to be broken
		if (row == nrow - 1 && column == ncolumn && set[row][column] != set[nrow][ncolumn]){
			origcd = CardinalDirection.South;
		}
		else if (row == nrow + 1 && column == ncolumn && set[row][column] != set[nrow][ncolumn]){
			origcd = CardinalDirection.North;
		}
		else if (row == nrow && column == ncolumn - 1 && set[row][column] != set[nrow][ncolumn]){
			origcd = CardinalDirection.East;
		}
		else if (row == nrow && column == ncolumn + 1 && set[row][column] != set[nrow][ncolumn]){
			origcd = CardinalDirection.West;
		}
		
		
		Wall wall = new Wall(column, row, origcd); //order reversed because Wall uses x/y, but x is measured in columns and y is measured in rows @__@
		
		cells.deleteWall(wall);
					
	}

}