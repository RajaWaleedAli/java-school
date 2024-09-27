public class WhatDoes {
    static int doesSomething(int a, int b) {

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }
    public static void main(final String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(doesSomething(b, a));
    }
}
