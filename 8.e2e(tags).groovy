pipeline{
    agent any
    stages{
        stage ('Build'){
            steps{
                echo "Building the project"
            }
        }
        stage('CodeAnalysis'){
            steps{
                echo "Running Code Analysis"
            }
        }
        stage('DockerBuildNdPush'){
            steps{
                echo "Building and Pushing the image"
            }
        }
        stage('DeployToDev'){
            steps{
                echo "Deploying to Dev Environment"
            }
        }
        stage('DeployToTest'){
            steps{
                echo "Deploying to Test Environment"
            }
        }
        stage('DeployToStage'){
            when{
                branch 'release/*'
            }
            steps{
                echo "Depoloying to Stage Environment"
            }
        }
        stage('DeployToProd'){
            when{
                //vx.x.x 
                //v1.2 is correct
                //v.1.2 is incorrect
        
                tag pattern: "v\\d{1,2}.\\d{1,2}.\\d{1,2}", comparator: "REGEXP"
            }
            steps{
                echo "Deploying to Production Environment"
            }
        }
    }
}