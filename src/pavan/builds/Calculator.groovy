//https://www.jenkins.io/doc/book/pipeline/shared-libraries/#defining-shared-libraries
//methods
//jenkins stages

//Define package
package com.pavan.builds;

//Define calculator class

class Calculator{
    //Define variable to hold the jenkins context
    def jenkins

    //constructor to initialise the calculator  class with jenkins instance
    Calculator(jenkins){
        this.jenkins = jenkins
    } 
    
    //method to perform addition of two numbers
    def add(firstnumber,secondnumber){
        return firstnumber+secondnumber
    }

    //method for mutiply
    def multiply(firstnumber,secondnumber){
        return firstnumber*secondnumber
    }
}