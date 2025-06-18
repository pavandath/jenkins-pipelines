//The input block is used to pause the pipeline and wait for human intervention or approval before proceeding.
//Get manual confirmation before proceeding (like for Production deployment).
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
            steps{
                echo "Depoloying to Stage Environment"
            }
        }
        stage('DeployToProd'){
            options{
                timeout(time:300, unit:'SECONDS')      //The options block allows specifying stage-specific configurations or settings that control the behavior of the pipeline or its stages.
            }
            input {
                message "Do you want to Deploy?"
                ok "yes"
                submitter 'pavan,dath'                  //only pavan & dath users can be able to submit
            }
            
            steps{
                echo "Deploying to Production Environment"
            }
        }
    }
}

//Note even if the administrator dont have in submitter list he can accept the message