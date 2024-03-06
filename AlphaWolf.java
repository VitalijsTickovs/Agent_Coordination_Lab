import java.util.*;

public class AlphaWolf implements Wolf{
    private boolean isLeader = false;
    private final static BlackBoard blackBoard = new BlackBoard();

    private int[] searchPrey(List<int[]> preysSight){
        if(preysSight.isEmpty()){
        }
        Random r = new Random();
        return new int[]{r.nextInt(3)-1, r.nextInt(3)-1};
//        else
//            return new int[]{-preysSight.get(0)[0], -preysSight.get(0)[1]};
    }

    public void findAlpha(){
        if(!BlackBoard.isAssigned){
            this.isLeader = true;
            BlackBoard.isAssigned = true;
        }
    }

    @Override
    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
        findAlpha();
        if(this.isLeader){
            List<int[]> relDistWolves = new ArrayList<>();
            for(int i=0; i<wolvesSight.size(); i++){
                int[] wolfRel = wolvesSight.get(i);
                if(!(wolfRel[0]==0 && wolfRel[1]==0)){
                    relDistWolves.add(wolfRel);
                }
            }
            blackBoard.setRelDistWolves(relDistWolves);
            return searchPrey(preysSight);
        }else {
            int[] nextMove = new int[2];
            List<int[]> relDistWolves = blackBoard.getRelDistWolves();
            for (int i = 0; i < wolvesSight.size(); i++) {
                for (int j = 0; j < relDistWolves.size(); j++) {
                    int[] relDistWolf = relDistWolves.get(j);
                    int[] wolfSight = wolvesSight.get(i);
                    if (wolfSight[0] == -relDistWolf[0] && wolfSight[1] == -relDistWolf[1]) {
                        for (int k = 0; k < nextMove.length; k++) {
                            if (wolfSight[k] > 0) {
                                nextMove[k] = -1;
                            } else if (wolfSight[k] < 0) {
                                nextMove[k] = 1;
                            } else {
                                nextMove[k] = 0;
                            }
                        }

                    }
                }
            }
            System.out.println(Arrays.toString(nextMove));
            return nextMove;
        }
    }

    @Override
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}
