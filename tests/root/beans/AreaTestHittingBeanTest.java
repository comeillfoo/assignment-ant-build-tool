package root.beans;

import org.junit.Assert;
import org.junit.Test;

public class AreaTestHittingBeanTest {
  private static final double EQUAL_DELTA = Double.MIN_VALUE;
  @Test
  public void testConstructorRadiusSet( ) {
    double radius = 8;
    Assert.assertEquals( "Некорректная установка поля radius в конструкторе", radius, new AreaTestHittingBean( radius ).RADIUS, EQUAL_DELTA );
  }

  @Test
  public void testDefaultErrorValue( ) {
    Assert.assertEquals( "Неправильное значение по умолчанию поля error", AreaTestHittingBean.DEFAULT_ERROR, new AreaTestHittingBean( 1 ).getError(), EQUAL_DELTA );
  }

  @Test
  public void testErrorSetter( ) {
    double error = 8;
    AreaTestHittingBean a = new AreaTestHittingBean( 1 );
    a.setError( error );
    Assert.assertEquals( "Неправильная работа аксессора set поля error", error, a.getError(), EQUAL_DELTA );
  }

  @Test
  public void testHitInEmptySpaceFalse( ) {
    Assert.assertFalse( "Неправильное вычисление попадания в пустую область", new AreaTestHittingBean( 3 ).test( 2, 2 ) );
  }

  @Test
  public void testHitInQuadrantTrue( ) {
    Assert.assertTrue( "Неправильное вычисление попадания в область кругового сектора", new AreaTestHittingBean( 3 ).test( -2, 2 ) );
  }

  @Test
  public void testHitInQuadrantFalse( ) {
    Assert.assertFalse( "Неправильное вычисление попадания в область кругового сектора", new AreaTestHittingBean( 3 ).test( -3, 3 ) );
  }

  @Test
  public void testHitInRectangleTrue( ) {
    Assert.assertTrue( "Неправильное вычисление попадания в область прямоугольника", new AreaTestHittingBean( 3 ).test( -1, -1 ) );
  }

  @Test
  public void testHitInRectangleFalse( ) {
    Assert.assertFalse( "Неправильное вычисление попадания в область прямоугольника", new AreaTestHittingBean( 3 ).test( -2, -1 ) );
  }

  @Test
  public void testHitInTriangleTrue( ) {
    Assert.assertTrue( "Неправильное вычисление попадания в область треугольника", new AreaTestHittingBean( 3 ).test( 1.5, -1.5 ) );
  }

  @Test
  public void testHitInTriangleFalse( ) {
    Assert.assertFalse( "Неправильное вычисление попадания в область треугольника", new AreaTestHittingBean( 3 ).test( 2, -1.5 ) );
  }
}
