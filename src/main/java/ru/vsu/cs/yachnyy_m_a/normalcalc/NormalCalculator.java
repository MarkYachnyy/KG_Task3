package ru.vsu.cs.yachnyy_m_a.normalcalc;

import ru.vsu.cs.yachnyy_m_a.math.Vector3f;
import ru.vsu.cs.yachnyy_m_a.model.Model;
import ru.vsu.cs.yachnyy_m_a.model.Polygon;

import java.util.ArrayList;
import java.util.Vector;

public class NormalCalculator {
    public void RecalculateNormals(Model model) {
        ArrayList<Vector3f> vertices = model.vertices;
        ArrayList<Polygon> polygons = model.polygons;
        model.normals = new ArrayList<>(vertices.size());

        ArrayList<ArrayList<Vector3f>> vertexNormalAccumulator = new ArrayList<>(vertices.size());
        for (int i = 0; i < vertices.size(); i++) {
            vertexNormalAccumulator.add(new ArrayList<>());
        }

        for (int i = 0; i < polygons.size(); i++) {
            Polygon polygon = polygons.get(i);
            int ver1Id = polygon.getVertexIndices().get(0);
            int ver2Id = polygon.getVertexIndices().get(1);
            int ver3Id = polygon.getVertexIndices().get(2);
            Vector3f vec1 = Vector3f.residual(vertices.get(ver2Id - 1), vertices.get(ver1Id - 1));
            Vector3f vec2 = Vector3f.residual(vertices.get(ver3Id - 1), vertices.get(ver1Id - 1));
            Vector3f normal = Vector3f.crossProduct(vec1, vec2).normalized();

            for (Integer verId : polygon.getVertexIndices()) {
                vertexNormalAccumulator.get(verId - 1).add(normal);
            }
        }

        for (ArrayList<Vector3f> polygonsNormals : vertexNormalAccumulator) {
            Vector3f vertexNormal = polygonsNormals.stream().
                    collect(() -> new Vector3f(0, 0, 0), Vector3f::add, Vector3f::add).
                    multiply(1f / polygonsNormals.size());

            model.normals.add(vertexNormal);
        }

        for (Polygon polygon: model.polygons){
            polygon.setNormalIndices(new ArrayList<>(polygon.getVertexIndices()));
        }
    }
}
