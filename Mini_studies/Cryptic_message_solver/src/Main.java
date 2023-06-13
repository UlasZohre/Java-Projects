import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        String str = findMostRepeatedSubstring(line, size);

        int mod = str.length();

        int str_index = 0;

        while(line.contains(str)){
            line = line.replaceAll(str, "");
        }

        char[] char_arr = line.toCharArray();

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < char_arr.length; i++){
            char temp = char_arr[i];

            if (temp == ' '){
                result.append(temp);
            }


            else {
                char keyChar = str.charAt(str_index);
                char res;
                int index = keyChar - 'a' + 1;

                if (temp >= 'a'){

                    res = (char)  (((char) temp + index -'a')%26 + 'a');
                }

                else{
                    res = (char) ((char) (temp + index - 'A')%26 + 'A');
                }


                result.append(res);
                str_index = (str_index +1)%str.length();
            }
        }

        System.out.println(str);
        System.out.println(result);
    }





    public static String findMostRepeatedSubstring(String line, int size) {
        if (line == null || line.length() < size)
            return "";

        Map<String, Integer> substringCounts = new HashMap<>();
        int maxCount = 0;
        String mostRepeatedSubstring = "";

        for (int i = 0; i <= line.length() - size; i++) {
            String substring = line.substring(i, i + size);
            int count = substringCounts.getOrDefault(substring, 0) + 1;
            substringCounts.put(substring, count);

            if (count > maxCount) {
                maxCount = count;
                mostRepeatedSubstring = substring;
            }
        }


        return mostRepeatedSubstring;
    }

    public static boolean compareChars(char c1, char c2){
        int comp = Character.compare(c1, c2);
        if(comp>0){
            return false;
        }else{
            return true;
        }
    }

}