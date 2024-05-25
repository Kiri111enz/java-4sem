package org.prac6.builder;

public class GoshaDogBuilder {
    private int mmr = 0;
    private int pts = 0;

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public GoshaDog build() {
        return new GoshaDog(mmr, pts);
    }
}
