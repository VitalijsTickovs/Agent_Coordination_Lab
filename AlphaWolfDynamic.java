import java.util.*;

public class AlphaWolfDynamic implements Wolf{
    private boolean isLeader = false;
    private final static BlackBoard blackBoard = new BlackBoard();

    int[] searchPrey(List<int[]> preysSight){
        if(preysSight.isEmpty()){
            Random r = new Random();
            return new int[]{r.nextInt(3)-1, r.nextInt(3)-1};
        }else{
            int[] prey_dist = new int[preysSight.size()];
            for(int i= 0; i<preysSight.size(); i++){
                prey_dist[i] = Math.abs(preysSight.get(i)[0]) + Math.abs(preysSight.get(i)[1]);
            }

            int min_index = -1;
            int min_distance = 100000;
            for(int i=0; i<prey_dist.length; i++){
                if (prey_dist[i] < min_distance){
                    min_distance = prey_dist[i];
                    min_index = i;
                }
            }
            int[] next_move = new int[2];

            int[] prey = preysSight.get(min_index);
            next_move[0] = (prey[0] > 0) ? -1 : (prey[0] < 0) ? 1 : 0;
            next_move[1] = (prey[1] > 0) ? -1 : (prey[1] < 0) ? 1 : 0;

            return next_move;
        }
    }

    void findLeader(List<int[]> preysSight){
        if(!BlackBoard.isAssigned && !preysSight.isEmpty()){
            this.isLeader= true;
            BlackBoard.isAssigned = true;
        }else if(preysSight.isEmpty() && this.isLeader){
            this.isLeader = false;
            BlackBoard.isAssigned = false;
        }
    }

    @Override
    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
        findLeader(preysSight);
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
            if(BlackBoard.isAssigned) {
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
                return nextMove;
            }else{
                Random r = new Random();
                return new int[]{r.nextInt(3)-1, r.nextInt(3)-1};
            }
        }
    }

    @Override
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}
