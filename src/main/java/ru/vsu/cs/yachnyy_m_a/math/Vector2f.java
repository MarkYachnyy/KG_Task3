package ru.vsu.cs.yachnyy_m_a.math;

// Это заготовка для собственной библиотеки для работы с линейной алгеброй
public class Vector2f {
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String coordsToStringSplitBySpace() {
        return x + " " + y;
    }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    public boolean equals(Object o) {
        Vector2f v2 = (Vector2f) o;
        return Math.abs(this.x - v2.x) < eps && Math.abs(this.y - v2.y) < eps;
    }

    final float eps = 1e-4f;
    float x, y;
}