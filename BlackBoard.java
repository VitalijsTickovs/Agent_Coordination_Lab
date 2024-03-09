import java.util.ArrayList;
import java.util.List;

public class BlackBoard {
    private int[] relDistWolf1;
    private int[] relDistWolf2;
    private List<int[]> relDistWolves = new ArrayList<>();
    public static boolean isAssigned = false;

    public void setRelDistWolf1(int[] wolf1){
        this.relDistWolf1 = wolf1;
    }

    public void setRelDistWolf2(int[] wolf2){
        this.relDistWolf2 = wolf2;
    }

    public int[] getRelDistWolf1() {
        return relDistWolf1;
    }

    public int[] getRelDistWolf2() {
        return relDistWolf2;
    }

    public List<int[]> getRelDistWolves(){
        return relDistWolves;
    }

    public void setRelDistWolves(List<int[]> relDistWolves) {
        this.relDistWolves = relDistWolves;
    }
}
