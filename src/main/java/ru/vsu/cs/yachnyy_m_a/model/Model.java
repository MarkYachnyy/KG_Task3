package ru.vsu.cs.yachnyy_m_a.model;


import ru.vsu.cs.yachnyy_m_a.math.Vector2f;
import ru.vsu.cs.yachnyy_m_a.math.Vector3f;

import java.util.ArrayList;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public String toString(){
        return  "v: " + vertices + "\n" +
                "vt:" + textureVertices + '\n' +
                "vn:" + normals + '\n' +
                "f:" + polygons;
    }

    @Override
    public boolean equals(Object obj) {
        Model model2 = (Model) obj;
        return model2.vertices.equals(this.vertices)
                &&
        model2.textureVertices.equals(this.textureVertices)
                        &&
                model2.normals.equals(this.normals)
                &&
              model2.polygons.equals(this.polygons);
    }
}
