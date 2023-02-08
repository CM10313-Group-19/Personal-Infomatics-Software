import javax.swing.*;

public class Main {

    //make a function that takes 2 integers and returns their highest common factor
    public static int HCF(int a, int b){
        int hcf = 1;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                hcf = i;
            }
        }
        return hcf;
    }

    public static void main(String[] args){

    }
}
