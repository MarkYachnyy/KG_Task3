package ru.vsu.cs.yachnyy_m_a.math;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector3f {
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Vector3f other) {
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps;
    }

    public static Vector3f sum(Vector3f v1, Vector3f v2) {
        return new Vector3f(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static Vector3f residual(Vector3f v1, Vector3f v2){
        return new Vector3f(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static Vector3f crossProduct(Vector3f v1, Vector3f v2) {
        float x = v1.y * v2.z - v2.y * v1.z;
        float y = v1.z * v2.x - v1.x * v2.z;
        float z = v1.x * v2.y - v1.y * v2.x;
        return new Vector3f(x, y, z);
    }

    public Vector3f multiply(float n) {
        this.x *= n;
        this.y *= n;
        this.z *= n;
        return this;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3f add(Vector3f v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
        return this;
    }

    public Vector3f normalized() {
        float length = this.length();
        return new Vector3f(x / length, y / length, z / length);
    }

    final float eps = 1e-7f;
    float x, y, z;
}