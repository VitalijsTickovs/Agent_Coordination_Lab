public class BlackBoard {
    private int[] relDistWolf1;
    private int[] relDistWolf2;
    private boolean isAssigned;

    public void setRelDistWolf1(int[] wolf1){
        this.relDistWolf1 = wolf1;
    }

    public void setRelDistWolf2(int[] wolf2){
        this.relDistWolf2 = wolf2;
    }

    public void setIsAssigned(boolean isAssigned){
        this.isAssigned = isAssigned;
    }

    public int[] getRelDistWolf1() {
        return relDistWolf1;
    }

    public int[] getRelDistWolf2() {
        return relDistWolf2;
    }

    public boolean getIsAssigned() {
        return isAssigned;
    }
}
