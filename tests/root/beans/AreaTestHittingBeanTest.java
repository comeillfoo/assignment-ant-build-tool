package root.beans;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class AreaTestHittingBeanTest {
  private static final double EQUAL_DELTA = Double.MIN_VALUE;
  private static final ResourceBundle testsBundle = ResourceBundle.getBundle( "root.beans.locals.native.russian.areaTestHittingBeanTests", Locale.getDefault( ) );
  @Test
  public void testConstructorRadiusSet( ) {
    final String msg = testsBundle.getString( "testConstructorRadiusSet" );
    double radius = 8;
    Assert.assertEquals( msg, radius, new AreaTestHittingBean( radius ).RADIUS, EQUAL_DELTA );
  }

  @Test
  public void testDefaultErrorValue( ) {
    final String msg = testsBundle.getString( "testDefaultErrorValue" );
    Assert.assertEquals( msg, AreaTestHittingBean.DEFAULT_ERROR, new AreaTestHittingBean( 1 ).getError(), EQUAL_DELTA );
  }

  @Test
  public void testErrorSetter( ) {
    final String msg = testsBundle.getString( "testErrorSetter" );
    double error = 8;
    AreaTestHittingBean a = new AreaTestHittingBean( 1 );
    a.setError( error );
    Assert.assertEquals( msg, error, a.getError(), EQUAL_DELTA );
  }

  @Test
  public void testHitInEmptySpaceFalse( ) {
    final String msg = testsBundle.getString( "testHitInEmptySpaceFalse" );
    Assert.assertFalse( msg, new AreaTestHittingBean( 3 ).test( 2, 2 ) );
  }

  @Test
  public void testHitInQuadrantTrue( ) {
    final String msg = testsBundle.getString( "testHitInQuadrantTrue" );
    Assert.assertTrue( msg, new AreaTestHittingBean( 3 ).test( -2, 2 ) );
  }

  @Test
  public void testHitInQuadrantFalse( ) {
    final String msg = testsBundle.getString( "testHitInQuadrantFalse" );
    Assert.assertFalse( msg, new AreaTestHittingBean( 3 ).test( -3, 3 ) );
  }

  @Test
  public void testHitInRectangleTrue( ) {
    final String msg = testsBundle.getString( "testHitInRectangleTrue" );
    Assert.assertTrue( msg, new AreaTestHittingBean( 3 ).test( -1, -1 ) );
  }

  @Test
  public void testHitInRectangleFalse( ) {
    final String msg = testsBundle.getString( "testHitInRectangleFalse" );
    Assert.assertFalse( msg, new AreaTestHittingBean( 3 ).test( -2, -1 ) );
  }

  @Test
  public void testHitInTriangleTrue( ) {
    final String msg = testsBundle.getString( "testHitInTriangleTrue" );
    Assert.assertTrue( msg, new AreaTestHittingBean( 3 ).test( 1.5, -1.5 ) );
  }

  @Test
  public void testHitInTriangleFalse( ) {
    final String msg = testsBundle.getString( "testHitInTriangleFalse" );
    Assert.assertFalse( msg, new AreaTestHittingBean( 3 ).test( 2, -1.5 ) );
  }
}
