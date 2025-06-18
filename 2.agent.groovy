//agent represnts where to be executed
//agent none
    //when applied at the top level of the pipeline, no global will be allocated
    //Each stage agent will need to have its own agent means 
    // If I mention agent at top level all stages will use that agent only but if I mention none then that means that each stage needs to mention seperately    
//agent any
//agent label ***
pipeline{
   
    agent any                                //agent below is applied at the pipeline level
    stages {                                //Here we write all the stages required for the job 
        stage('build') {                     // Here mention stage name and task to be performed by it similarly mention mutiple 
           steps{
             echo "Hellowelcome to jenkins"
           }
     }

    }
    
}

//pipeline 2

pipeline{
    agent{
        label "docker-slave"            // this is the label of the node not the node name
    }
    stages{
        stage ('build'){
            steps{
                echo "Hello welcome to Jenkins"
                sh "hostname -i"                    //To run shell commands use sh
            }
        }
    }
}

//pipeline 3
pipeline {
    agent none

    stages {
        stage('Build') {
            agent { label 'docker-slave' }

            steps {
                sh "hostname -i"
            }
        }
    }
}

//sripting pipeline in declarative
pipeline{
    agent any
    stages{
        stage ('Build'){
            steps{
                echo "Below is the script command"
                script{
                    def course = 'k8s'

                    if (course == 'k8s')
                    println("Thanks for enrollment")
                    else
                    println("Do enroll for")
                    
                }
            }
        }
    }
}