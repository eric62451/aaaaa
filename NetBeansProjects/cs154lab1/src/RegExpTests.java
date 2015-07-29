/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class RegExpTests {
    public static void a() {
        String leading0s = "(0+1+)+(0*)";
        String leading1s = "(1+0+)+(1*)";
        String regExp = leading0s+"|"+leading1s;
        System.out.println("11000011000110".matches(regExp));
        System.out.println("01000011000110".matches(regExp));
        System.out.println("00011000011000001100111".matches(regExp));
        System.out.println("000000000".matches(regExp));
        System.out.println("110000110001101".matches(regExp));
    }
    
    public static void b(){
        String pattern =  "\\$(0|([1-9][0-9]*)).[0-9][0-9]";
        System.out.println(pattern);
        System.out.println("$0.00".matches(pattern));
        System.out.println("$31.2".matches(pattern));
        System.out.println("$01.22".matches(pattern));
        System.out.println("$30.00".matches(pattern));
        System.out.println("$0.22".matches(pattern));
    }
    
    public static void c(){
        String pattern = "\\-*([1-9][0-9]*.?[0-9]*([a-z](\\^([2-9][0-9]*))?)?)([\\-\\+]([1-9][0-9]*.?[0-9]*([a-z](\\^([2-9][0-9]*))?)?))*";
        System.out.println("3.2x^2".matches(pattern));
        System.out.println("-3x^0".matches(pattern));
        System.out.println("3x^22".matches(pattern));
        System.out.println("3x^1".matches(pattern));
        System.out.println("32x^2".matches(pattern));
        System.out.println("0x^2".matches(pattern));
        System.out.println("3x^2+2z^4".matches(pattern));
        System.out.println("3x^2-10x^2".matches(pattern));
        System.out.println("3x^2-2.5y^10".matches(pattern));
    }
    
    public static void d(){
        
    }
    
    public static void main(String[] args) {
        c();
    }
    
}
