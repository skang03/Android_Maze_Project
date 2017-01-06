package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad;


import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.CardinalDirection;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.Distance;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.Robot.Turn;

/**
 * 
 * @author Sungwon Kang
 *
 */
public class Wallfollower implements RobotDriver{
    Robot robot;
	int width;
	int height;
	Distance distance;
	
	public Wallfollower(){
		
	}
	@Override
	public void setRobot(Robot r) {
		robot = r;
	}

	/////////////press 'r' to run wallfollower///////////////

	@Override
	public void setDimensions(int width, int height) {
		this.width = width;
		this.height = height;		
	}


	@Override
	public void setDistance(Distance distance) {
		this.distance = distance;	
	}


	@Override
	public boolean drive2Exit() throws Exception {
		wallFollower();
		return true;
	}


	@Override
	public float getEnergyConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPathLength() {
		return robot.getPathlength();
	}

	
	public void wallFollower() throws Exception{
		while(!robot.isAtGoal()){
			int[] pos = robot.getCurrentPosition();
			int x = pos[0];
			int y = pos[1];
			CardinalDirection dir = robot.getCurrentDirection();
			if (dir == CardinalDirection.North){
				if (robot.wallExists(x, y, CardinalDirection.East) && robot.wallExists(x, y, CardinalDirection.North)){
					robot.rotate(Turn.RIGHT);
					robot.move(1, true);
				}
				else if (robot.wallExists(x, y, CardinalDirection.East)){
					robot.move(1, true);
				}
				else if (!robot.wallExists(x, y, CardinalDirection.East)){
					robot.rotate(Turn.LEFT);
					robot.move(1, true);					
				}
			}
			else if (dir == CardinalDirection.South){
				if (robot.wallExists(x, y, CardinalDirection.West) && robot.wallExists(x, y, CardinalDirection.South)){
					robot.rotate(Turn.RIGHT);
					robot.move(1, true);
				}
				else if (robot.wallExists(x, y, CardinalDirection.West)){
					robot.move(1, true);
				}
				else if (!robot.wallExists(x, y, CardinalDirection.West)){
					robot.rotate(Turn.LEFT);
					robot.move(1, true);					
				}
			}
			else if (dir == CardinalDirection.East){
				if (robot.wallExists(x, y, CardinalDirection.South) && robot.wallExists(x, y, CardinalDirection.East)){
					robot.rotate(Turn.RIGHT);
					robot.move(1, true);
				}
				else if (robot.wallExists(x, y, CardinalDirection.South)){
					robot.move(1, true);
				}
				else if (!robot.wallExists(x, y, CardinalDirection.South)){
					robot.rotate(Turn.LEFT);
					robot.move(1, true);					
				}
			}
			else if (dir == CardinalDirection.West){
				if (robot.wallExists(x, y, CardinalDirection.North) && robot.wallExists(x, y, CardinalDirection.West)){
					robot.rotate(Turn.RIGHT);
					robot.move(1, true);
				}
				else if (robot.wallExists(x, y, CardinalDirection.North)){
					robot.move(1, true);
				}
				else if (!robot.wallExists(x, y, CardinalDirection.North)){
					robot.rotate(Turn.LEFT);
					robot.move(1, true);					
				}
			}					
		}
	}
}

