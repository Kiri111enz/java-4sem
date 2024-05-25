package org.prac6.builder;


public class GoshaDog {
    private int mmr;
    private int pts;

    public GoshaDog(int mmr, int pts) {
        this.mmr = mmr;
        this.pts = pts;
    }

    @Override
    public String toString() {
        return "GoshaDog{" +
                "mmr=" + mmr +
                ", pts=" + pts +
                '}';
    }
}
