import java.util.List;
import java.util.Random;

public class Baseline implements Wolf{
    /**
     *  This method will serve as a baseline.
     *  Each wolf will follow the closest prey or
     *  will move randomly if no prey is seen
     */
    @Override
    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
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

    @Override
    public int moveLim(List<int[]> wolvesSight, List<int[]> preysSight) {
        return 0;
    }
}
