package com.example.usdiplom.constants;

public class GapMathModels {

    public static String getOtAffiksatsiya() {
        System.out.println("\n\nOt so'z turkumini Affiksatsiya qoidalari bo'yicha algoritmlar");

        String txt = "(↓C(ADC) + $[1,1/h1]C[i] + ↓$[j,1/33]C(A[j]) + ↓C[0]) V " +
                "$[i,1/h3]G[i] + $[j,1/46]C(AG[j]) + ↓C[0]) V " +
                "(($[i,1/h2] P[i] V " +
                "$[j,1/h4]F[j] V " +
                "$[i1,1/h5]M[i1] V " +
                "$[i2,1/h6]N[i2]) + $[i3,1/6]C(A4[i3]) + ↓C[0]),";
//        txt = txt.replace("\n", "");
        txt = txt.replace(" ", "");
        return txt;
    }

    public static String getOtKompozitsiya() {
        System.out.println("\n\nOt so'z turkumini Kompozitsiya qoidalari bo'yicha algoritmlar");
        String txt = "(($[1,1/h1]C[i] + $[j, 1/h1] C[j]) + ↓C[0]) V" +
                " (($[i,1/h2]P[i] $[j,1/h1]C[j] + ↓C[0]) V" +
                " (($[i,1/h4]F[i] + $[j,1/h1]C[j]) + ↓C[0]) V" +
                " (($[i,1/h4]F[i] + $[i,1/h3]G[j]) + ↓C[0]) V" +
                " (($[i,1/h7]Q(N[i]) V" +
                " $[i,1/h1]C[i]) + ($[i, 1/h8]Q(P[j]) V" +
                " S[j,1/b9]Q(X6[j])) + ↓C[0]).";

        txt = txt.replace("\n", "");
        txt = txt.replace(" ", "");
        return txt;
    }

}
