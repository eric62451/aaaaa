import java.util.ArrayList;

public class SubstringGenerator
{
   private String text;
   private int subNum;
   private int startNum = 0;

   public SubstringGenerator(String text)
   {
      this.text = text;
   }

   public ArrayList<String> getSubstrings()
   {
      ArrayList<String> substrings = new ArrayList<String>();
      subNum = startNum + 1;
      if(subNum>text.length()){
          substrings.add("");
          return substrings;
      }
      while(subNum<=text.length()){
          substrings.add(text.substring(startNum, subNum));
          subNum++;
      }
      startNum++;
      substrings.addAll(getSubstrings());
      startNum=0;
      return substrings;

   }

}