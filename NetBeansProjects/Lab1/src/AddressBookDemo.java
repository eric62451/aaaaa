
import java.util.ArrayList;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class AddressBookDemo {
public static void main(String[] args)
{
   JFileChooser chooser = new JFileChooser();
   int result = chooser.showOpenDialog(null);
   if (result == JFileChooser.APPROVE_OPTION)
   {
       String filename = chooser.getSelectedFile().getPath();
       AddressBook book = new ArrayListAddressBook();
       book.load(filename);
       System.out.println(book.getFirst());
       ArrayListAddressBook b = (ArrayListAddressBook) book;
       ArrayList<Item> array = b.getItems();
       Item other = book.getFirst();
       // System.out.println(book.getNext(book.getFirst()));
       for(int i=0; i<array.size();i++)
       {
           System.out.println(book.getNext(other));
           other = book.getNext(other);
       }
       
       // System.out.println(book.getNext(book.getNext(book.getFirst())));
       System.out.print(book.get("Horstmann","Phone"));
       book.put("Tam", "Email", "Eric.Tam.Sf@live.com");
       book.save();
   }
   
}

}
