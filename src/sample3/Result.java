package sample3;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
    String pass = "";
    List<Integer> numbers = new ArrayList<Integer>();
    for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        if(Character.isDigit(ch)){
            int num = Character.getNumericValue(ch);
            if(num == 0){
                if(numbers.isEmpty()) {
                	pass += ch;
                }
                else {
                	pass += numbers.get(numbers.size() - 1) + "";
                    numbers.remove(numbers.size() - 1);
                }
            }
            else{
                numbers.add(Integer.valueOf(num));
            }
        }
        else{
            if(Character.isLowerCase(ch)){
                pass += ch;
            }
            else{
            	if(i + 1 >= s.length() || i + 2 >= s.length()) {
            		pass += ch;
            	}
            	else {
            		if(Character.isLowerCase(s.charAt(i + 1)) && s.charAt(i + 2) == '*') {
            			char ch2 = s.charAt(++i);
                        i++;
                        pass += ch2;
                        pass += ch;
            		}
            		else {
            			pass += ch;
            		}
            	}
            }
        }
    }
    return pass;
    }
    
    public static void main(String[] args) {

        String result = Result.decryptPassword("pTo*Ta*O");
        System.out.print(result);
    }
}

