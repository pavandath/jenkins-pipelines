//https://www.jenkins.io/doc/book/pipeline/shared-libraries/#defining-shared-libraries
//methods
//jenkins stages

//Define package
package com.pavan.builds

class Calculator {
    def jenkins

    Calculator(jenkins) {
        this.jenkins = jenkins
    }

    def add(a, b) {
        return a + b
    }

    def multiply(a, b) {
        return a * b
    }
}
