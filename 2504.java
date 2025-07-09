import java.util.*;
import java.io.*;

public class Main {
    static String brackets;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        brackets = br.readLine();

        boolean flag = true;
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++)
        {
            char b = brackets.charAt(i);

            if (b == '(' || b == '[')  // 추가
            {
                deque.addLast(String.valueOf(b));
            }

            else
            {
                int temp = 0;

                if (b == ')')
                {
                    while (true)
                    {
                        if (deque.isEmpty())
                        {
                            flag = false;

                            break;
                        }

                        else if (deque.peekLast().equals("("))
                        {
                            deque.removeLast();

                            if (temp == 0)
                            {
                                temp += 2;
                            }

                            else
                            {
                                temp *= 2;
                            }

                            deque.addLast(String.valueOf(temp));

                            break;
                        }

                        else if (deque.peekLast().equals("["))
                        {
                            flag = false;

                            break;
                        }

                        else
                        {
                            temp += Integer.parseInt(deque.removeLast());
                        }
                    }
                }

                else
                {
                    while (true)
                    {
                        if (deque.isEmpty())
                        {
                            flag = false;

                            break;
                        }

                        else if (deque.peekLast().equals("["))
                        {
                            deque.removeLast();

                            if (temp == 0)
                            {
                                temp += 3;
                            }

                            else
                            {
                                temp *= 3;
                            }

                            deque.addLast(String.valueOf(temp));

                            break;
                        }

                        else if (deque.peekLast().equals("("))
                        {
                            flag = false;

                            break;
                        }

                        else
                        {
                            temp += Integer.parseInt(deque.removeLast());
                        }
                    }
                }
            }

            if (!flag)
            {
                break;
            }
        }

        if (flag)
        {
            int temp = 0;

            while (!deque.isEmpty())
            {
                if (deque.peekLast().equals("[") || deque.peekLast().equals("(") || deque.peekLast().equals(")") || deque.peekLast().equals("]"))
                {
                    temp = 0;

                    break;
                }

                temp += Integer.parseInt(deque.removeLast());
            }

            System.out.print(temp);
        }

        else
        {
            System.out.print(0);
        }
    }
}
