

public class PalindromeTester
{
    public static void main(String[] args)
    {
        String[] str = { "racecar",
"RACEcar", // uppercase equals lowercase
"rotator",
"rotor",
"civic",
"Red rum, sir, is murder!",
// punctuation and spaces are neglected
"Rats live on no evil star.",
"Neil, a trap! Sid is part alien!",
"Step on no pets.",
"Dammit, I’m mad!",
"Madam, I’m Adam.",
"Madam, in Eden, I’m Adam.",
"Rise to vote, sir.",
"Never odd or even",
"If I had a hi-fi",
"Yo, banana boy!",
"Do geese see God?",
"No devil lived on.",
"Ah, Satan sees Natasha.",
"A dog, a panic in a pagoda",
"Was it a cat I saw?",
"Was it a car or a cat I saw?",
"No lemons, no melon",
"A dog, a plan, a canal, pagoda",
"A man, a plan, a canal-- Panama!"
};
      for(int i = 0; i<str.length;i++){
          if(new Phrase(str[i]).isPalindrome()) System.out.println(str[i]);
      }
      System.out.print(111);
    }
}