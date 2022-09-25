public class Polynomial{
    //one field representing the coefficients of the polynomial
    // using an array of double
    //field - lower case
    private double[]coefficients;

    //constructor1
    //It has a no-argument constructor that sets the polynomial to zero
    // (i.e. the corresponding array would be [0])
    //public Setzero(){ -> wrong
    public Polynomial(){
        coefficients = new double[0];
    }

    //constructor2
    // takes an array of double as an argument
    // sets the coefficients accordingly
    //this.coefficients -> fields


    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    // takes one argument of type Polynomial and
    // returns the polynomial
    // resulting from adding the calling object and the argument

    //public add(Polynomial){
    public Polynomial add(Polynomial other){
        double[] newCoefficient;
        int len1 = this.coefficients.length;
        int len2 = other.coefficients.length;

        if(len1 > len2)
            newCoefficient = new double[len1];
        else
            newCoefficient = new double[len2];

        for(int i = 0; i < len1; i++)
            newCoefficient[i] += this.coefficients[i];

        for(int i = 0;i<len2;i++)
            newCoefficient[i] += other.coefficients[i];

        return new Polynomial(newCoefficient);
    }
    //takes one argument of type double
    // representing a value of x
    // and evaluates the polynomial accordingly

    public double evaluate(double xValue){
        double result = 0.0;
        for(int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i] * Math.pow(xValue, i);
        }
        return result;
    }

    public boolean hasRoot(double xValue){
        return this.evaluate(xValue) == 0.0;
        //if we dont add "this" before the call function
        // it will still automatically return this.evalue(x)
    }

}
