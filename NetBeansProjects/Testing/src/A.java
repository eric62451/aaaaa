/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class A{

    public A(){

    }

    enum Size{
        SMALL(10), MEDIUM(20), LARGE(30);
        private double value;

        private Size(double value){
            this.value = value;
        }

        public double getValue(){
            return value;
        }


    }

    public static void main(String[] args){
        System.out.println(Size.LARGE.getValue());
    }
}
