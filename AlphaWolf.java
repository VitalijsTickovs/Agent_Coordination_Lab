import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class AlphaWolf implements Wolf{

    private boolean isLeader;
    private final static BlackBoard blackBoard = new BlackBoard();

    public AlphaWolf(boolean isLeader){
        this.isLeader = isLeader;
    }

    @Override
    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
        if(isLeader){
            if(!blackBoard.getIsAssigned()){
//                blackBoard.setIsAssigned(true);
                blackBoard.setRelDistWolf1(wolvesSight.get(0));
                blackBoard.setRelDistWolf2(wolvesSight.get(1));
            }
        }

    }

    @Override
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}
