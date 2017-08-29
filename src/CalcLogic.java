public class CalcLogic {
    double totalCurrent;

    public CalcLogic() {
        totalCurrent = 0;
    }

    /** this method is used to return String
     *
     * @return String
     */
    public String getTotalString() {
        return " "+ totalCurrent;
    }

    /** this method is used to change String to Double number
     *
     * @param s
     * @return String
     */

    public double stringToNum (String s) {
        return Double.parseDouble(s);
    }

    /** give the number to the totalCurrent
     *
     * @param s
     *
     */

    public void setTotal(String s) {
        totalCurrent = stringToNum(s);
    }

    /** Add function
     *
     * @param s
     */

    public void add (String s) {
        totalCurrent = totalCurrent + stringToNum(s);
    }

    /**
     * minus function
     * @param s
     */

    public void sub(String s) {
        totalCurrent = totalCurrent - stringToNum(s);
    }

    /**
     * multiply function
     * @param s
     */

    public void mutiply(String s) {
        totalCurrent = totalCurrent * stringToNum(s);
    }

    /** divide function
     *
     * @param s
     */

    public void divide(String s) {
        totalCurrent = totalCurrent /stringToNum(s);
    }

    /**
     * Positive and Negative function
     * @param s
     */

    public void positveNective(String s) {
        totalCurrent = (double) Math.negateExact((long)stringToNum(s));
    }

    /**
     * percentage function
     * @param s
     */


    public void  percentage(String s) {
        totalCurrent = stringToNum(s) /100.00;
    }

    /**
     * square root function
     * @param s
     */
    public void squareroot (String s) {
        totalCurrent = Math.sqrt(stringToNum(s)) ;
    }
    /**
     * square function
     */
    public void power (String s) {
        totalCurrent = Math.pow(totalCurrent,stringToNum(s));
    }

}

