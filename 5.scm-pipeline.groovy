pipeline{
    agent any
    stages {
        stage ('Build'){
           steps{
              echo "**************Building the applicatation************"
        }
        }
        stage('sonar'){
            steps{
                echo "***************Scanning the application************"
            }
        }
        stage('Docker'){
            steps{
                echo "**********Building the docker image****************"
            }
        }
    }
}