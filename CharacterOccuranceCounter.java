import java .lang.*;

class CharacterOccuranceCounter{
    public static void main(String[] args) {
        String str = "Hello, World!";
        char target = 'l';
        int count = 0;
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i)==target){
                count++;
            }
        }
        System.out.println("number of occurances of 'l':"+count);
    }    
}