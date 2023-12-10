package ru.vsu.cs.yachnyy_m_a.test.math;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.yachnyy_m_a.math.Vector3f;

public class Vector3fTest {
    @Test
    public void sum() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Assert.assertEquals(Vector3f.sum(v1, v2), new Vector3f(5, 7, 9));
    }

    @Test
    public void crossProduct() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(19, 5, 4);
        Assert.assertEquals(Vector3f.crossProduct(v1, v2), new Vector3f(-7, 53, -33));
    }

    @Test
    public void crossProductZero() {
        Vector3f v1 = new Vector3f(8, 4, 12);
        Vector3f v2 = new Vector3f(4, 2, 6);
        Assert.assertEquals(Vector3f.crossProduct(v1, v2), new Vector3f(0, 0, 0));
    }

    @Test
    public void length(){
        Vector3f v = new Vector3f(3, 5, 12);
        Assert.assertTrue(Math.abs(v.length() - 13.341664f) < 1E-7f);
    }

    @Test
    public void normalized(){
        Vector3f v = new Vector3f(4, 5, -1);
    }
}
