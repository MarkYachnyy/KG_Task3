package ru.vsu.cs.yachnyy_m_a.model;

import java.util.ArrayList;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<>();
        textureVertexIndices = new ArrayList<>();
        normalIndices = new ArrayList<>();
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        assert vertexIndices.size() >= 3;
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
//        assert textureVertexIndices.size() >= 3;
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
//        assert normalIndices.size() >= 3;
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }

    public String toString(){
        StringBuilder res = new StringBuilder().append('{');
        for (int i = 0; i < vertexIndices.size(); i++) {
            res.append(vertexIndices.get(i)).append('/').append(textureVertexIndices.size() > 0 ? textureVertexIndices.get(i) : "").append('/').append(normalIndices.size() > 0 ?  normalIndices.get(i) : "").append(' ');
        }
        res.append('}');
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Polygon polygon2 = (Polygon) obj;
        return this.vertexIndices.equals(polygon2.vertexIndices) ;
//                &&
//                this.textureVertexIndices.equals(polygon2.textureVertexIndices) &&
//                this.normalIndices.equals(polygon2.normalIndices);
    }
}
