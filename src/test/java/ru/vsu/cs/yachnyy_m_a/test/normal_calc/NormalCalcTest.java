package ru.vsu.cs.yachnyy_m_a.test.normal_calc;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.yachnyy_m_a.math.Vector2f;
import ru.vsu.cs.yachnyy_m_a.math.Vector3f;
import ru.vsu.cs.yachnyy_m_a.model.Model;
import ru.vsu.cs.yachnyy_m_a.model.Polygon;
import ru.vsu.cs.yachnyy_m_a.normal_calc.NormalCalculator;
import ru.vsu.cs.yachnyy_m_a.obj_io.FileIO;
import ru.vsu.cs.yachnyy_m_a.obj_io.ObjReader;
import ru.vsu.cs.yachnyy_m_a.obj_io.ObjWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class NormalCalcTest {
    @Test
    public void normalForPolygon1() {
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArrayList<Vector3f> vertices = new ArrayList<>(Arrays.asList(new Vector3f(101, -119, 275), new Vector3f(106, -115, 269), new Vector3f(103, -121, 289)));
        Assert.assertEquals(new Vector3f(0.46421355f, -0.86512524f, -0.18990554f), NormalCalculator.calculateNormalForPolygon(polygon, vertices));
    }

    @Test
    public void normalForPolygon1Translated() {
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArrayList<Vector3f> vertices = new ArrayList<>(Arrays.asList(new Vector3f(1, 4, 1), new Vector3f(6, 8, -5), new Vector3f(3, 2, 15)));
        Assert.assertEquals(new Vector3f(0.46421355f, -0.86512524f, -0.18990554f), NormalCalculator.calculateNormalForPolygon(polygon, vertices));
    }

    @Test
    public void normalForPolygon1Scaled() {
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArrayList<Vector3f> vertices = new ArrayList<>(Arrays.asList(new Vector3f(0.0769230769f, 0.3076923077f, 0.0769230769f),
                new Vector3f(0.4615384615f, 0.6153846154f, -0.3846153846f),
                new Vector3f(0.2307692308f, 0.1538461538f, 1.1538461538f)));
        Assert.assertEquals(new Vector3f(0.46421355f, -0.86512524f, -0.18990554f), NormalCalculator.calculateNormalForPolygon(polygon, vertices));
    }

    @Test
    public void normalForPolygon2() {
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(1, 2, 3)));
        ArrayList<Vector3f> vertices = new ArrayList<>(Arrays.asList(new Vector3f(8, 1, 0),
                new Vector3f(0, 0, 0),
                new Vector3f(1163, 0.1538461538f, 0)));
        Assert.assertEquals(new Vector3f(0, 0, 1), NormalCalculator.calculateNormalForPolygon(polygon, vertices));
    }

    @Test
    public void normalForPolygon3() {
        Polygon polygon = new Polygon();
        polygon.setVertexIndices(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        ArrayList<Vector3f> vertices = new ArrayList<>(Arrays.asList(new Vector3f(8, 1, 0),
                new Vector3f(0, 0, 0),
                new Vector3f(1163, 0.1538461538f, 0)));
        Assert.assertEquals(new Vector3f(0, 0, 1), NormalCalculator.calculateNormalForPolygon(polygon, vertices));
    }

    @Test
    public void recalculateNormalsCube() {
        try{
            Model cubeToCalc = ObjReader.read(FileIO.readFileContent("./models/test/cube.obj"));
            Model cubePreCalc = ObjReader.read(FileIO.readFileContent("./models/test/cubeOutput.obj"));
            NormalCalculator.recalculateNormals(cubeToCalc);
            Assert.assertEquals(cubePreCalc, cubeToCalc);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void recalculateNormalsTeapot() {
        try{
            Model teapotToCalc = ObjReader.read(FileIO.readFileContent("./models/test/teapot.obj"));
            Model teapotPreCalc = ObjReader.read(FileIO.readFileContent("./models/test/teapotOutput.obj"));
            NormalCalculator.recalculateNormals(teapotToCalc);
            Assert.assertEquals(teapotToCalc, teapotPreCalc);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
