package root.beans;

import java.io.Serializable;
import java.util.Objects;

public final class ResultBean implements Serializable {
  private static final long  serialVersionUID = 1L;

  public double getX( ) {
    return X;
  }

  public double getY( ) {
    return Y;
  }

  public double getR( ) {
    return R;
  }

  public boolean isHit( ) {
    return HIT;
  }

  public final double X;
  public final double Y;
  public final double R;
  public final boolean HIT;

  public ResultBean( double x, double y, double r, boolean hit ) {
    X = x;
    Y = y;
    R = r;
    HIT = hit;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass( ) != o.getClass( ) ) return false;
    ResultBean that = ( ResultBean ) o;
    return Double.compare( that.X, X ) == 0 && Double.compare( that.Y, Y ) == 0 && Double.compare( that.R, R ) == 0 && HIT == that.HIT;
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( X, Y, R, HIT );
  }

  @Override
  public String toString( ) {
    return "ResultBean{" +
        "X=" + X +
        ", Y=" + Y +
        ", R=" + R +
        ", HIT=" + HIT +
        '}';
  }
}
