
import java.util.LinkedList;
import java.util.Queue;

public class PuzzleSolver
{
   public static void main(String[] args)
   {
      Puzzle puzzle = new Puzzle(args[0], args[1], args[2]);
      Queue<Puzzle> q = new LinkedList<Puzzle>();
      q.add(puzzle);
      while (!q.isEmpty())
      {
            Puzzle temp = q.remove();
            if(temp.firstLetter().equals("")){
                if(temp.isSolved()){
                    System.out.println(temp.toString());
                }
            }else{
            for(int i = 0; i<=9; i++){
                if(!temp.contains(i)){
                    q.add(temp.replace(temp.firstLetter(), i));
                }
            }
          }
      }
   }
}