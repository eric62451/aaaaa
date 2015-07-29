import java.util.HashSet;
import java.util.Set;


public class Sequence {
        public static void main(String[] args) {
                System.out.println(lis("abcmnopqzd"));
                System.out.println(lis("almobcdef"));
                System.out.println(lis("axz"));
                System.out.println(lis("bxcxdx"));
                System.out.println(lis("almobcdxef"));
        }

        public static String lis(String s) {
                StringBuilder result = new StringBuilder();
                Set<Integer> invalidIndex = new HashSet<Integer>();
                Set<Integer> otherInvalids = new HashSet<Integer>();

                for(int i = 0; i < s.length()-1; i++) {
                        char c1 = s.charAt(i);
                        char c2 = s.charAt(i+1);
                        if(c1 > c2) { invalidIndex.add(i); }
                }

                if(invalidIndex.isEmpty()) {
                        return s;
                } else {
                        for(int j: invalidIndex) {
                                for(int i = 0; i < j; i++) {
                                        char c = s.charAt(i);

                                        if(c > s.charAt(j+1)) {
                                                otherInvalids.add(i);
                                        }
                                }
                        }
                        invalidIndex.addAll(otherInvalids);

                        for(int i = 0; i < s.length(); i++) {
                                if(!invalidIndex.contains(i)) {
                               result.append(s.charAt(i));
                            }
                        }
                        String str = result.toString();
                        int max = str.length();
                        for(int i: invalidIndex){
                            String temp = lis(s.substring(i));
                            if(temp.length()>max){
                                str = temp;
                                max = temp.length();
                            }
                        }
                        return str;
                }
        }
}