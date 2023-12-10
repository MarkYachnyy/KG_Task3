package ru.vsu.cs.yachnyy_m_a;

import ru.vsu.cs.yachnyy_m_a.math.Vector2f;
import ru.vsu.cs.yachnyy_m_a.math.Vector3f;
import ru.vsu.cs.yachnyy_m_a.model.Model;
import ru.vsu.cs.yachnyy_m_a.normal_calc.NormalCalculator;
import ru.vsu.cs.yachnyy_m_a.obj_io.FileIO;
import ru.vsu.cs.yachnyy_m_a.obj_io.ObjReader;
import ru.vsu.cs.yachnyy_m_a.obj_io.ObjWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try{
            Model cubeToCalc = ObjReader.read(FileIO.readFileContent("./models/test/teapot.obj"));
            NormalCalculator.recalculateNormals(cubeToCalc);
            ObjWriter.write(cubeToCalc, "./models/test/teapotOutput.obj");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
