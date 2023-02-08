import javax.swing.*;

public class Main {

    //make a function that takes n integers and returns their highest common factor
    public static int hcf(int... numbers){
        int hcf = 1;
        for(int i = 1; i <= numbers[0]; i++){
            boolean isHcf = true;
            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] % i != 0){
                    isHcf = false;
                    break;
                }
            }
            if(isHcf){
                hcf = i;
            }
        }
        return hcf+1;
    }

    public static void main(String[] args){

    }
}
