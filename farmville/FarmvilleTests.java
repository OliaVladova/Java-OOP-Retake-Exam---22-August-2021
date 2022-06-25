package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Animal coco;
    private Animal kiki;
    private Farm farm;
    @Before
    public void setUp(){
        this.coco = new Animal("Chicken",20);
        this.kiki = new Animal("Horse",100);
        this.farm = new Farm("FarmLand",2);
        this.farm.add(coco);
    }
    @Test
    public void testShouldGetCountCorrectly(){
        int expected = this.farm.getCount();
        Assert.assertEquals(1,expected);
    }
    @Test
    public void testShouldReturnFarmNameCorrectly(){
        String expected = this.farm.getName();
        Assert.assertEquals("FarmLand",expected);
    }
    @Test
    public void testShouldGetCapacityCorrectly(){
        int expected = this.farm.getCapacity();
        Assert.assertEquals(2,expected);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenFarmIsFull(){
       this.farm.add(kiki);
       Animal snake = new Animal("snake",5);
       this.farm.add(snake);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenAnimalExists(){
        this.farm.add(coco);
    }
    @Test
    public void testShouldRemoveCorrectly(){
        this.farm.add(kiki);
        boolean returned =this.farm.remove("Horse");
        Assert.assertTrue(returned);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenFarmCapacityIsZero(){
       Farm farm = new Farm("PlayLand",-1);
    }
    @Test(expected = NullPointerException.class)
    public void testShouldThrowExceptionWhenFarmNameIsZero(){
        Farm farm = new Farm(" ",3);
    }
    @Test
    public void testShouldAddAnimalCorrectly(){
        this.farm.add(kiki);
        int expected = this.farm.getCount();
        Assert.assertEquals(2,expected);
    }
    @Test
    public void testShouldSetNameCorrectly(){
        Farm newFarm = new Farm("SportGround",10);
        String expected = newFarm.getName();
        Assert.assertEquals("SportGround",expected);
    }
    @Test
    public void testShouldSetCapacityCorrectly(){
        Farm newFarm = new Farm("SportGround",10);
        int expected = newFarm.getCapacity();
        Assert.assertEquals(10,expected);
    }
    @Test
    public void testShouldReturnFalse(){
        boolean returned = this.farm.remove("cow");
        Assert.assertFalse(returned);
    }

}
