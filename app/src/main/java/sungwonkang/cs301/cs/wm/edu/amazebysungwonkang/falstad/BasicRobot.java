package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.*;

/**
 * 
 * @author Sungwon Kang
 *
 */

public class BasicRobot implements Robot {

	MazeController mazecontroller;
	int pathlength = 0;

	public int getPathlength(){
		return pathlength;
	}
	
	@Override
	public void rotate(Turn turn) {
		if (turn == Turn.LEFT){
			mazecontroller.rotate(1);
		}
		else if (turn == Turn.RIGHT){
			mazecontroller.rotate(-1);
		}
		else if (turn == Turn.AROUND){
			mazecontroller.rotate(1);
			mazecontroller.rotate(1);
		}
	}

	@Override
	public void move(int distance, boolean manual) {
		for (int i = 0; i < distance; i++){
			mazecontroller.walk(1);
			pathlength = pathlength + distance;
		}
	}

	@Override
	public int[] getCurrentPosition() throws Exception {
		return mazecontroller.getCurrentPosition();
	}

	@Override
	public void setMaze(MazeController maze) {
		mazecontroller = maze;
		
	}

	@Override
	public boolean isAtGoal() {
		int[] position;
		try {
			position = getCurrentPosition();
		} catch (Exception e) {
			return true;
		}
		int x = position[0];
		int y = position[1];	
		if(mazecontroller.isOutside(x, y)){
			return true;
		}
		return false;
	}

	@Override
	public boolean canSeeGoal(Direction direction) throws UnsupportedOperationException {
		try{
			distanceToObstacle(direction);
		}
		catch(ArrayIndexOutOfBoundsException e){
			return true;
		}
		return false;
	}

	@Override
	public boolean isInsideRoom() throws UnsupportedOperationException {
		MazeConfiguration mazeconfig = mazecontroller.getMazeConfiguration();
		int[] pos = mazecontroller.getCurrentPosition();
		int x = pos[0];
		int y = pos[1];
		
		Cells cells = mazeconfig.getMazecells();
		return cells.isInRoom(x, y);		
	}

	@Override
	public boolean hasRoomSensor() {
		return true;
	}

	@Override
	public CardinalDirection getCurrentDirection() {
		return mazecontroller.getCurrentDirection();
	}

	@Override
	public float getBatteryLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBatteryLevel(float level) {
		// TODO Auto-generated method stub
	}

	@Override
	public float getEnergyForFullRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getEnergyForStepForward() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStopped() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int distanceToObstacle(Direction direction) throws UnsupportedOperationException {
		MazeConfiguration mazeconfig = mazecontroller.getMazeConfiguration();
		Cells cells = mazeconfig.getMazecells();
		
		//determine cardinal direction of robot
		CardinalDirection dir = getCurrentDirection();
		int[] pos = mazecontroller.getCurrentPosition();
		int currx = pos[0];
		int curry = pos[1];

		//do a while loop and check mazecells for walls in that direction until it hits a wall, incrementing dist
		int dist = 0;
		if(dir == CardinalDirection.East){
			if (direction == direction.FORWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.East)){
					currx++;
					dist++;
				}
			}
			else if (direction == direction.LEFT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.South)){
					curry++;
					dist++;
				}
			}
			else if (direction == direction.RIGHT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.North)){
					curry--;
					dist++;
				}
			}
			else if (direction == direction.BACKWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.West)){
					currx--;
					dist++;
				}
			}
		}
		else if(dir == CardinalDirection.West){
			if (direction == direction.FORWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.West)){
					currx--;
					dist++;
				}
			}
			else if (direction == direction.LEFT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.North)){
					curry--;
					dist++;
				}
			}
			else if (direction == direction.RIGHT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.South)){
					curry++;
					dist++;
				}
			}
			else if (direction == direction.BACKWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.East)){
					currx++;
					dist++;
				}
			}
		}
		else if(dir == CardinalDirection.South){
			if (direction == direction.FORWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.South)){
					curry++;
					dist++;
				}
			}
			else if (direction == direction.LEFT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.East)){
					currx--;
					dist++;
				}
			}
			else if (direction == direction.RIGHT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.West)){
					currx++;
					dist++;
				}
			}
			else if (direction == direction.BACKWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.North)){
					curry--;
					dist++;
				}
			}
		}
		else if(dir == CardinalDirection.North){ 
			if (direction == direction.FORWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.North)){
					curry--;
					dist++;
				}
			}
			else if (direction == direction.LEFT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.West)){
					currx--;
					dist++;
				}
			}
			else if (direction == direction.RIGHT){
				while (cells.hasNoWall(currx, curry, CardinalDirection.East)){
					currx++;
					dist++;
				}
			}
			else if (direction == direction.BACKWARD){
				while (cells.hasNoWall(currx, curry, CardinalDirection.South)){
					curry++;
					dist++;
				}
			}
		}
		
		return dist;
	}

	@Override
	public boolean hasDistanceSensor(Direction direction) {
		return true;
	}

	public boolean wallExists(int x, int y, CardinalDirection dir){
		MazeConfiguration mazeconfig = mazecontroller.getMazeConfiguration();
		Cells cells = mazeconfig.getMazecells();
		return cells.hasWall(x, y, dir);
	}
}


