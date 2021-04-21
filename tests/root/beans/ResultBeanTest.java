package root.beans;

import org.junit.Assert;
import org.junit.Test;
import root.beans.ResultBean;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResultBeanTest {
  private static final ResultBean FIRST = new ResultBean( -1, 2, 3, true );
  private static final ResultBean SECOND_EQUALS_TO_FIRST = new ResultBean( -1, 2, 3, true );
  private static final ResultBean SECOND_NOT_EQUALS_TO_FIRST = new ResultBean( -1, 2, 3, false );
  private static final double EQUAL_DELTA = Double.MIN_VALUE;
  private static final ResourceBundle testsBundle = ResourceBundle.getBundle("root.beans.locals.native.russian.resultBeanTests", Locale.getDefault( ) );

  @Test
  public void testXGetter( ) {
    final String message = testsBundle.getString( "testXGetter" );
    Assert.assertEquals( message, FIRST.X, FIRST.getX(), EQUAL_DELTA );
  }

  @Test
  public void testYGetter() {
    final String message = testsBundle.getString( "testYGetter" );
    Assert.assertEquals( message, FIRST.Y, FIRST.getY(), EQUAL_DELTA );
  }

  @Test
  public void testRGetter() {
    final String message = testsBundle.getString( "testRGetter" );
    Assert.assertEquals( message, FIRST.R, FIRST.getR(), EQUAL_DELTA );
  }

  @Test
  public void testHitGetter() {
    final String message = testsBundle.getString( "testHitGetter" );
    Assert.assertEquals( message, FIRST.HIT, FIRST.isHit() );
  }

  @Test
  public void testEqualsWithSameResultsParameters( ) {
    final String message = testsBundle.getString( "testEqualsWithSameResultsParameters" );
    Assert.assertEquals( String.format( message,
        FIRST ), FIRST, SECOND_EQUALS_TO_FIRST );
  }

  @Test
  public void testEqualsWithSameResult( ) {
    final String message = testsBundle.getString( "testEqualsWithSameResult" );
    Assert.assertEquals( String.format( message, FIRST ), FIRST, FIRST );
  }

  @Test
  public void testEqualsWithDifferentResults( ) {
    final String message = testsBundle.getString( "testEqualsWithDifferentResults" );
    Assert.assertNotEquals( String.format( message,
        FIRST, SECOND_NOT_EQUALS_TO_FIRST ), FIRST, SECOND_NOT_EQUALS_TO_FIRST );
  }

  @Test
  public void testEqualsCommutativityProperty( ) {
    final String message = testsBundle.getString( "testEqualsCommutativityProperty" );
    Assert.assertEquals( message,
        FIRST.equals( SECOND_NOT_EQUALS_TO_FIRST ),
        SECOND_NOT_EQUALS_TO_FIRST.equals( FIRST ) );
  }

  @Test
  public void testEqualsWithNaN( ) {
    final String message = testsBundle.getString( "testEqualsWithNaN" );
    ResultBean NaNFirstBean = new ResultBean( Double.NaN, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.NaN, 0, 0, false );
    Assert.assertEquals( message, NaNFirstBean, NaNSecondBean );
  }

  @Test
  public void testEqualsWithPositiveInfinite( ) {
    final String message = testsBundle.getString( "testEqualsWithPositiveInfinite" );
    ResultBean NaNFirstBean = new ResultBean( Double.POSITIVE_INFINITY, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.POSITIVE_INFINITY, 0, 0, false );
    Assert.assertEquals( message, NaNFirstBean, NaNSecondBean );
  }

  @Test
  public void testEqualsWithNegativeInfinite( ) {
    final String message = testsBundle.getString( "testEqualsWithNegativeInfinite" );
    ResultBean NaNFirstBean = new ResultBean( Double.NEGATIVE_INFINITY, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.NEGATIVE_INFINITY, 0, 0, false );
    Assert.assertEquals( message, NaNFirstBean, NaNSecondBean );
  }
}
