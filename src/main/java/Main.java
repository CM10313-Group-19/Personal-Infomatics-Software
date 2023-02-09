public class Main {

    //A function that takes n numbers and finds the highest common factor
    public static int HCF(int... numbers){
        int hcf = 1;
        int min = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        for(int i = 1; i <= min; i++){
            boolean isHCF = true;
            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] % i != 0){
                    isHCF = false;
                    break;
                }
            }
            if(isHCF){
                hcf = i;
            }
        }
        return hcf;
    }

    public static void main(String[] args){



    }
}
