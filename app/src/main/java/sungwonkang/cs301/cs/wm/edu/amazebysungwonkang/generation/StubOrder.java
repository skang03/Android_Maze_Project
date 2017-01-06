package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.Constants;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.Cells;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.Factory;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.MazeConfiguration;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.MazeContainer;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.MazeFactory;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.generation.Order;
import java.util.Iterator;


public class StubOrder implements Order{
	private MazeConfiguration mazeConfig;
	private Order.Builder buildertype;
	public StubOrder(){
		mazeConfig = new MazeContainer();
		buildertype = Order.Builder.Kruskal;
	}
	
	public StubOrder(Order.Builder orderenum){
		mazeConfig = new MazeContainer();
		buildertype = orderenum;
	}
	
	public MazeConfiguration getMazeConfiguration(){
		return mazeConfig;
	}
	

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Builder getBuilder() {
		// TODO Auto-generated method stub
		return buildertype;
	}

	@Override
	public boolean isPerfect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deliver(MazeConfiguration mazeConfig) {
		this.mazeConfig = mazeConfig;		
	}

	@Override
	public void updateProgress(int percentage) {
		// TODO Auto-generated method stub
	}


}
