package root.beans;

import org.junit.Assert;
import org.junit.Test;
import root.beans.ResultBean;

public class ResultBeanTest {
  private static final ResultBean FIRST = new ResultBean( -1, 2, 3, true );
  private static final ResultBean SECOND_EQUALS_TO_FIRST = new ResultBean( -1, 2, 3, true );
  private static final ResultBean SECOND_NOT_EQUALS_TO_FIRST = new ResultBean( -1, 2, 3, false );
  private static final double EQUAL_DELTA = Double.MIN_VALUE;

  @Test
  public void testXGetter( ) {
    Assert.assertEquals( "Значения поля X и его аксессора не совпадают", FIRST.X, FIRST.getX(), EQUAL_DELTA );
  }

  @Test
  public void testYGetter() {
    Assert.assertEquals( "Значения поля Y и его аксессора не совпадают", FIRST.Y, FIRST.getY(), EQUAL_DELTA );
  }

  @Test
  public void testRGetter() {
    Assert.assertEquals( "Значения поля R и его аксессора не совпадают", FIRST.R, FIRST.getR(), EQUAL_DELTA );
  }

  @Test
  public void testHitGetter() {
    Assert.assertEquals( "Значения поля HIT и его аксессора не совпадают", FIRST.HIT, FIRST.isHit() );
  }

  @Test
  public void testEqualsWithSameResultsParameters( ) {
    Assert.assertEquals( String.format( "Результаты [ %s ] с одинаковыми параметрами не равны",
        FIRST ), FIRST, SECOND_EQUALS_TO_FIRST );
  }

  @Test
  public void testEqualsWithSameResult( ) {
    Assert.assertEquals( String.format( "Результат [ %s ] не равен самому себе", FIRST ), FIRST, FIRST );
  }

  @Test
  public void testEqualsWithDifferentResults( ) {
    Assert.assertNotEquals( String.format( "Результаты [ %s ] и [ %s ] равны, несмотря на разные параметры",
        FIRST, SECOND_NOT_EQUALS_TO_FIRST ), FIRST, SECOND_NOT_EQUALS_TO_FIRST );
  }

  @Test
  public void testEqualsCommutativityProperty( ) {
    Assert.assertEquals( "Функция equals бина не обладает свойством коммутативности",
        FIRST.equals( SECOND_NOT_EQUALS_TO_FIRST ),
        SECOND_NOT_EQUALS_TO_FIRST.equals( FIRST ) );
  }

  @Test
  public void testEqualsWithNaN( ) {
    ResultBean NaNFirstBean = new ResultBean( Double.NaN, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.NaN, 0, 0, false );
    Assert.assertEquals( "Некорректное сравнение с NaN", NaNFirstBean, NaNSecondBean );
  }

  @Test
  public void testEqualsWithPositiveInfinite( ) {
    ResultBean NaNFirstBean = new ResultBean( Double.POSITIVE_INFINITY, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.POSITIVE_INFINITY, 0, 0, false );
    Assert.assertEquals( "Некорректное сравнение с положительной бесконечностью", NaNFirstBean, NaNSecondBean );
  }

  @Test
  public void testEqualsWithNegativeInfinite( ) {
    ResultBean NaNFirstBean = new ResultBean( Double.NEGATIVE_INFINITY, 0, 0, false );
    ResultBean NaNSecondBean = new ResultBean( Double.NEGATIVE_INFINITY, 0, 0, false );
    Assert.assertEquals( "Некорректное сравнение с отрицательной бесконечностью", NaNFirstBean, NaNSecondBean );
  }
}
