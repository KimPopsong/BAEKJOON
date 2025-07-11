import java.util.*;
import java.io.*;

public class Main {
    static int chainNumber, givenWordsNumber;
    static ArrayList<String> chainWords = new ArrayList<>();
    static Set<String> givenWords = new HashSet<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = null;
        chainNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < chainNumber; i++)
        {
            chainWords.add(br.readLine());
        }

        givenWordsNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < givenWordsNumber; i++)
        {
            givenWords.add(br.readLine());
        }

        for (String s : chainWords)
        {
            givenWords.remove(s);
        }

        for (int i = 0; i < chainNumber; i++)
        {
            String s = chainWords.get(i);

            if (s.equals("?"))
            {
                for (String given : givenWords)
                {
                    boolean flag1 = false, flag2 = false;

                    if (i == 0)
                    {
                        flag1 = true;
                    }

                    else
                    {
                        String frontWord = chainWords.get(i - 1);

                        if (frontWord.charAt(frontWord.length() - 1) == given.charAt(0))
                        {
                            flag1 = true;
                        }
                    }

                    if (i == chainNumber - 1)
                    {
                        flag2 = true;
                    }

                    else
                    {
                        String rearWord = chainWords.get(i + 1);

                        if (rearWord.charAt(0) == given.charAt(given.length() - 1))
                        {
                            flag2 = true;
                        }
                    }

                    if (flag1 && flag2)
                    {
                        answer = given;

                        break;
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
