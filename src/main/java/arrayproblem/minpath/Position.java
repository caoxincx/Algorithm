package arrayproblem.minpath;

/**
 * 需求编号:2019D0519
 * 问题编号:
 * 开发人员: caoxin
 * 创建日期:2019/10/19
 * 功能描述:
 * 修改日期:2019/10/19
 * 修改描述:
 */
public class Position {
    private int lp;
    private int rp;

    public Position(int lp, int rp) {
        this.lp = lp;
        this.rp = rp;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public int getRp() {
        return rp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }
}
