/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class ObjectLinearSearcher {
    Object[] array;

    public ObjectLinearSearcher(Object[] anArray) {
        array = anArray;
    }

      public int search(Object target){
          for(int i = 0; i<array.length;i++){
              if(array[i].equals(target)) return i;
          }
          return -1;
      }

}
