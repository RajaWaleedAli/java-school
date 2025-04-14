package org.example;

public class Calculator {
    public double add(double a, double b){
        return a+b;
    }
    public double sub(double a, double b){
        return a-b;
    }
    public double mul(double a, double b){
        return a*b;
    }
    public double div(double a, double b){
        if(b==0){
            throw new IllegalArgumentException("Division by zero");
        }
        return a/b;
    }
    public double mod(double a, double b){
        if(b==0){
            throw new IllegalArgumentException("Division by zero");
        }
        return a%b;
    }
    public double pow(double a, double b){
        double res=1;
        if(b==0) return 1;
        if(a==0) return 0;
        int intTeil=(int)b;
        double kommaTeil=b-intTeil;
        for(int i = 0; i<intTeil; i++){
            res*=a;
        }
        if(kommaTeil>0){
            res*=exp(ln(a)*kommaTeil);
        }
        return res;
    }
    public static double exp(double x) {
        double sum = 1;
        double term = 1;
        int n = 20; // Genauigkeit

        for (int i = 1; i < n; i++) {
            term *= x / i;
            sum += term;
        }
        return sum;
    }
    public double sqrt(double a, double b){
        double res=0;
        double e= 2.718281828459;
        res= (ln(a)/b);
        return pow(e,res);
    }
    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x muss größer als 0 sein");
        }
        int terms=20;

        double y = (x - 1) / (x + 1);
        double sum = 0.0;

        for (int n = 1; n <= terms; n += 2) {
            sum += (1.0 / n) * pow(y, n);
        }

        return 2 * sum;
    }
}
