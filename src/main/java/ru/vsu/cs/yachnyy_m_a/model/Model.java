package ru.vsu.cs.yachnyy_m_a.model;


import ru.vsu.cs.yachnyy_m_a.math.Vector2f;
import ru.vsu.cs.yachnyy_m_a.math.Vector3f;

import java.util.ArrayList;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

}
