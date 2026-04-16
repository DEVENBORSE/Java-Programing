import java.lang.*;

class CountNumFromString{
    public static void main(String [] args){
        String str = new String("abcd1234edfgh5678");
        int count = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9'){
                count++;

            }
            
        }
        System.out.println("no. of .digits:"+count);
    }
}