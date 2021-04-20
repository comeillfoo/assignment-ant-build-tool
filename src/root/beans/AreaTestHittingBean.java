package root.beans;

public final class AreaTestHittingBean {
  public static final double DEFAULT_ERROR = Double.MIN_VALUE;
  public final double RADIUS;
  private double error = DEFAULT_ERROR;

  public double getError( ) {
    return error;
  }

  public double setError( double error ) {
    return this.error = error;
  }

  public double getR( ) {
    return RADIUS;
  }

  public AreaTestHittingBean( double radius ) {
    RADIUS = radius;
  }

  public boolean test( double x, double y ) {
    return ( x >= -error && y <= error && ( x - RADIUS <= y + error ) ) ||
        ( x <= error && y <= error && x >= -( RADIUS + error ) / 2 && y >= -( RADIUS + error ) ) ||
        ( x <= error && y >= -error && ( x * x + y * y ) <= ( RADIUS + error ) * ( RADIUS + error ) );
  }
}
