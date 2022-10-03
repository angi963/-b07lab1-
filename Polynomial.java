
import java.io.*;
import java.util.Scanner;
public class Polynomial {

    protected double[] nonzeroCoefficients;
    protected int[] exponents;

    //constructor1
    //It has a no-argument constructor that sets the polynomial to zero
    // (i.e. the corresponding array would be [0])
    //public Setzero(){ -> wrong
    public Polynomial() {
        nonzeroCoefficients = new double[0];
        exponents = new int[0];

    }

    //constructor2
    // takes an array of double as an argument
    // sets the coefficients accordingly
    //this.coefficients -> fields


    public Polynomial(double[] nonzeroCoefficients, int[] exponents) {

        this.nonzeroCoefficients = nonzeroCoefficients;
        this.exponents = exponents;

    }

    // takes one argument of type Polynomial and
    // returns the polynomial
    // resulting from adding the calling object and the argument

    public Polynomial add(Polynomial other) {
//        String templine = "";
//        //先找出所有指数
//        // 先把this.exponents的指数全抄下来
//        for(int i = 0; i < this.exponents.length; i++){
//        templine += this.exponents[i] + "+";
//        }
//
//        //用other里面的指数和this里面的比
//        //如果other里的指数this里面没有，就加进去
//        for(int j = 0; j < other.exponents.length; j++){
//            if exp in this.exponents{
////                templine == templine;
//            }
//            else{
//                templine += exponents[j] + "+";
//            }
//        }
//        //把string里面对的数字用split 分成array
//        String [] tempArray = templine.split("\\+");
//        nonzeroCoefficients=new double[tempArray.length];
//
//        //相加后的指数array找到了
//        for(int i=0; i<tempArray.length; i++) {
//            nonzeroCoefficients[i] = Double.parseDouble(tempArray[i]);
//        }

        double [] new_coe = other.nonzeroCoefficients;
        int [] new_exp = other.exponents;

        return new Polynomial(new_coe, new_exp);


    }




    //takes one argument of type double
    // representing a value of x
    // and evaluates the polynomial accordingly

    public double evaluate(double xValue) {
        double result = 0.0;
        for (int i = 0; i < this.nonzeroCoefficients.length; i++) {
//            for (int j = 0; j < this.exponents.length; j++) {
                result += this.nonzeroCoefficients[i] * Math.pow(xValue, exponents[i]);
            }
        return result;
        }


    public boolean hasRoot(double xValue) {
        return this.evaluate(xValue) == 0.0;
        //if we dont add "this" before the call function
        // it will still automatically return this.evalue(x)
    }

    public void saveToFile(String file) throws IOException {
        FileWriter filewriter = new FileWriter(file);
        String text = "";
        int i,j;

        if (this.exponents[0] == 0 && this.exponents.length == 1) {
            text += this.nonzeroCoefficients[0];
        } else if (this.exponents[0] != 0 && this.exponents.length == 1) {
            text += this.nonzeroCoefficients[0] + "x" + this.exponents[0];
        } else if (this.exponents[0] == 0 && this.exponents.length > 1) {
            text += this.nonzeroCoefficients[0] + "+";
            for (i = 1; i < this.nonzeroCoefficients.length - 1; i++) {
                text += this.nonzeroCoefficients[i] + "x" + this.exponents[i] + "+";
            }
            text += this.nonzeroCoefficients[i] + "x" + this.exponents[i];
        }
        else {
            for (j = 0; j < this.nonzeroCoefficients.length - 1; j++) {
                text += this.nonzeroCoefficients[j] + "x" + this.exponents[j] + "+";
            }
            text += this.nonzeroCoefficients[j] + "x" + this.exponents[j];
        }
        filewriter.write(text);
        filewriter.close();
    }

    public Polynomial(File file) throws IOException{
        //retrieve content in file and put into String text
        //eg: -> 5-3x2+7x8
        Scanner scanner=new Scanner(file);
        String text=scanner.nextLine();
        scanner.close();

        //replace "-" with "+-" so that the line can be divided using "+" as mark
        ////eg: -> 5 + -3x2 + 7x8 -> [5,-3x2,7x8]
        text=text.replace("-","+-");
        String[]terms=text.split("\\+");

        //create an array of double with length equals to the number of divided term
        nonzeroCoefficients=new double[terms.length];
        exponents=new int[terms.length];

        for(int i=0; i<terms.length; i++){
        //split array into array in array
            // -> [5,-3x2,7x8] -> [5, [-3,2],[7,8]]
        String[] temp=terms[i].split("x");
        //take the coefficient out from each sub array
        nonzeroCoefficients[i]=Double.parseDouble(temp[0]);
        //if temp.length ==1, then exponents[i] =0
        //otherwise, exponents[i] = Integer.parseInt(temp[1]);
        exponents[i]=(temp.length==1)?0:Integer.parseInt(temp[1]);

        }
        }

    public Polynomial multiply(Polynomial p2) {
        return p2;
    }
}
