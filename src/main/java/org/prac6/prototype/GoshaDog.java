package org.prac6.prototype;

public class GoshaDog implements Dog{
    private int mmr;
    public GoshaDog(int mmr) {
        this.mmr = mmr;
    }
    public void printMmr() {
        System.out.println(mmr);
    }

    @Override
    public Dog clone() {
        return new GoshaDog(mmr);
    }
}
