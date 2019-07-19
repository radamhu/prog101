package apptelek;

public class Telek
{
  private final int hsz;
  private final int sz;
  private final int h;
  private int t;
  private int ft;
  
  public Telek(String sor)
  {
    String[] t = sor.split(" ");
    this.hsz = Integer.parseInt(t[0]);
    this.sz = Integer.parseInt(t[1]);
    this.h = Integer.parseInt(t[2]);
    terulet();
    adoFt();
  }
  
  private int terulet()
  {
    return this.t = this.sz * this.h;
  }
  
  private void adoFt()
  {
    if (this.t < 701) {
      this.ft = (this.t * 51);
    } else if (this.t < 1001) {
      this.ft = (35700 + (this.t - 700) * 39);
    } else if (this.t > 1000) {
      this.ft = 49400;
    }
  }
  
  public int getHsz()
  {
    return this.hsz;
  }
  
  public int getSz()
  {
    return this.sz;
  }
  
  public int getH()
  {
    return this.h;
  }
  
  public int getT()
  {
    return this.t;
  }
  
  public int getFt()
  {
    return this.ft;
  }
}