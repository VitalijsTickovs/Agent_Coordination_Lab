//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class AbstractAlphaWolf implements Wolf {
//    public boolean isLeader = false;
//    public final static BlackBoard blackBoard = new BlackBoard();
//
//    abstract void findAlpha();
//
//    abstract int[] searchPrey(List<int[]> preysSight);
//
//    public int[] moveAll(List<int[]> wolvesSight, List<int[]> preysSight) {
//        findAlpha();
//        if(this.isLeader){
//            List<int[]> relDistWolves = new ArrayList<>();
//            for(int i=0; i<wolvesSight.size(); i++){
//                int[] wolfRel = wolvesSight.get(i);
//                if(!(wolfRel[0]==0 && wolfRel[1]==0)){
//                    relDistWolves.add(wolfRel);
//                }
//            }
//            blackBoard.setRelDistWolves(relDistWolves);
//            return searchPrey(preysSight);
//        }else {
//            int[] nextMove = new int[2];
//
//            List<int[]> relDistWolves = blackBoard.getRelDistWolves();
//
//            for (int i = 0; i < wolvesSight.size(); i++) {
//                for (int j = 0; j < relDistWolves.size(); j++) {
//                    int[] relDistWolf = relDistWolves.get(j);
//                    int[] wolfSight = wolvesSight.get(i);
//
//                    if (wolfSight[0] == -relDistWolf[0] && wolfSight[1] == -relDistWolf[1]) {
//                        for (int k = 0; k < nextMove.length; k++) {
//                            if (wolfSight[k] > 0) {
//                                nextMove[k] = -1;
//                            } else if (wolfSight[k] < 0) {
//                                nextMove[k] = 1;
//                            } else {
//                                nextMove[k] = 0;
//                            }
//                        }
//
//                    }
//                }
//            }
//            return nextMove;
//        }
//    }
//}
