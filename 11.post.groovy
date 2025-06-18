//The post section defines one or more additional steps that are run upon the completion of a Pipeline’s or stage’s run
//https://www.jenkins.io/doc/book/pipeline/syntax/#post
// you can also run post at stage level or completion of stages

pipeline{
    agent any
    stages{
        stage ('Build'){
            steps{
                echo "Building the application"
            }
        }
    }
    post {
        //Only run this, when the current pipeline or a specific stage has a success
        success{
            echo "post=========================> success is triggered"
        }
        //Only run this, when the current pipeline or a specific stage has a failure
        failure{
              echo "post=========================> failureis triggered"
        }
        //run irrespective success or failure
        always{
            echo "post=========================> always is triggered"
        }
        
    }
}