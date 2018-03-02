package DataStructures;

/**
 * Created by shivangipatwardhan on 2/20/18.
 */
public class PowerNumber {

    public boolean isPowerNumber(int value){
        // 8 -- 1, 2, 3, 4 : 2 ^ 3 = 8 third root of 8

        double maxValue = Math.sqrt(value);

        for(int i = 2; i < maxValue + 1; i++){

            double rootCalculation = Math.pow((double)value, 1.0/(double)i);
            rootCalculation = Math.round(rootCalculation * 1000000.0) / 1000000.0;
            if(vertifyInteger(rootCalculation)) {
                return true;
            }
        }
        return false;
    }

    private boolean vertifyInteger(double rootCalculation) {
        return rootCalculation == (int) rootCalculation;
    }

}
