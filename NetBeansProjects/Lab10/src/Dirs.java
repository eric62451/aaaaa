
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Dirs
{
   public static void main(String[] args) throws IOException
   {
      File dir = new File(args[0]);
      printAllFiles(dir);
   }

   public static void printAllFiles(File dir){
          Stack<File> directories = new Stack<File>();
          File d;
          directories.push(dir);
          while(!directories.isEmpty()){
              d = directories.pop();
              for(File f : d.listFiles())
              {
                  if(f.isDirectory()) directories.push(f);
                  else System.out.println(f);
              }
          }
   }
}