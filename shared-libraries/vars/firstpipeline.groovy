import package com.pavan.builds.Calculator;

//define a funtion called 'call' that accepts  a map parameter pipeline parameter
def call(Map PipelineParams){
    //create the instance of a calculator calculator
    Calculator calculator = new calculator(this)

pipeline{
    agent label 'docker-slave'
    //set an environment variable APPLICATION_NAME
    APPLICATION_NAME = ${pipelineparams.appname}   //keep appname as anything
    stages{
        stage ('Build'){
            steps{
                echo "****************Building the stage********************"
                echo "**************Starting the ${env.APPLICATION_NAME}**************"
            }
        }
        stage('calculate'){
            steps{
                script{
                    echo "Calling calculator method from source folder"
                    echo "********PRINTING SUM OF TWO NUMBERS**********"
                    //Call the add method

                }
            }

        }
        stage ('Test'){
            steps{
                echo "Testing the project"
                calculator.add(2,3)
            }
        }
        stage('DevDeploy'){
            steps{
                echo "Deploying the project to dev environment"
                script{
                    newcal.call(4,5)
                }
            }
        }
    }
}
}

def newcal(thirdnumber,fourthnumber){
    return thirdnumber+fourthnumber
}

//variable placeholder
//Local variable : ${variable}
//Env variable : ${env.variable}
//parameters section : ${pipelineparams.variable}