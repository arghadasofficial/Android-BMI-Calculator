/*
 * Copyright (C) 2017 Argha Das
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package arghadas.bmi;

import java.text.DecimalFormat;

/**
 * @author Argha Das
 */
public class Bmi {

    private static DecimalFormat decimalFormat = new DecimalFormat(".#");
    private double result;
    private String bmi;
    private String status;

    /**
     * Get the BMI from calculation and returns the result in String format
     *
     * @return BMI
     */
    public String getBmi() {
        /**
         * Following code example : bmi = decimalFormat.format(result);
         *
         * if bmi is 23.12345 then remove 2345 and return 23.1 using
         * DecimalFormat class provided by Java
         *
         */
        bmi = decimalFormat.format(result);
        return bmi;
    }

    /**
     * Get the status according to the BMI result and returns the Status in
     * String format
     *
     * @return Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get weight and height in double format and do the calculation for you
     *
     * @param weight - accepts weight in kilograms
     * @param height - accept height in centimeters
     */
    public void calculateBmi(double weight, double height) {
        /**
         * First get weight and height then convert height to meters then
         * multiply the height itself to height and then divide the height with
         * weight then set the actual value to result variable
         */

        //Convert the height from cm to m
        double meters = height / 100;

        //Multiply height by height
        double multiply = meters * meters;

        //divide the height with weight in kg
        double division = weight / multiply;

        //set the value to result variable
        result = division;

        //call checkStatus method for checking Status
        checkStatus();
    }

    /**
     * Private method for checking bmi and returns the status It remains private
     * because we don't need to access this from somewhere else.
     */
    private void checkStatus() {
        /**
         * Check :
         *
         * if BMI is less than 18.5 then set status to Underweight if BMI is
         * greater than 18.5 and less than 25 then set status to Normal if BMI
         * is greater than 25 and less than 30 then set status to Overweight if
         * BMI equals to 30 or greater than 30 then set status to Obese
         */
        if (result < 18.5) {
            status = "Underweight";
        } else if (result > 18.5 && result < 25) {
            status = "Normal";
        } else if (result > 25 && result < 30) {
            status = "Overweight";
        } else if (result == 30 || result > 30) {
            status = "Obese";
        }
    }
}
