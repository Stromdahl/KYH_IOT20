package com.company.lecture12;

public class Main {

    public static void main(String[] args) {
        /*
        Hello helloVar = () -> System.out.println("Hello");

        helloVar.sayHello();


         */

        //------------------------------------------------------

        /*
        MyQuad myQuad = (a) -> a*a;
        //System.out.println(myQuad.quad(4));
        //System.out.println(myQuad.quad(8));

         */


        //-----------------------------------------------------

        /*
        MyLambda safeDivideFunction = (a, b) -> b==0? 0 : a / b;

        MyLambda addFunction = (a, b) -> a + b;

        //System.out.println(addFunction.run(2,8));
        //System.out.println(safeDivideFunction.run(2,0));


         */
        //-----------------------------------------------------

        /*
        Weapon weapon = new standardWeapon();
        //weapon.Shoot();
        weapon = new BigWeapon();
        //weapon.Shoot();
         */
        //-----Streams-----------------------------------------

    }

    interface Hello {
        void sayHello();
    }

    interface MyQuad {
        int quad(int a);
    }

    interface MyLambda {
        int run(int x, int y);
    }
}
