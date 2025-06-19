
import com.pavan.builds.Calculator

def call(Map pipelineParams) {
    // an instance of the Calculator class
    Calculator calculator = new Calculator(this)
    pipeline {
        agent any
        environment {
            APPLICATION_NAME = "${pipelineParams.appName}"
        }
        stages {
            stage ('Calculate') {
                steps {
                    script {
                        echo "Calling Calculator Method from src folder"
                        echo "************ Printing the sum of values ************"
                        //calculator.add(2,3)
                        println calculator.add(2,3)
                    }
                }
            }
            stage ('Build') {
                steps {
                    echo "Building the project"
                    echo "************ In Build Stage for ${env.APPLICATION_NAME}  ************"
                    // script {
                    //     calculator.buildApp("${env.APPLICATION_NAME}")
                    // }
                }
            }
            stage ('Test') {
                steps {
                    echo "Testing the project"
                }
            }
            stage ('DevDeploy') {
                steps {
                    echo "Deploying the project to Dev environment"
                }
            }
            stage ('TestDeploy') {
                steps {
                    echo "Deploying the project to Test environment"
                }
            }
            stage ('ProdDeploy') {
                steps {
                    echo "Deploying the project to Prod environment"
                }
            }
        }
    }
}

def cal(firstNumber, secondNumber) {
    return firstNumber + secondNumber
}

// ${variable}
// ${env.VARIABLE}
// ${params.VARIABLE}
// ${pipelineParams.VARIABLE}

