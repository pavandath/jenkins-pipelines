pipeline{
    agent any
    parameters{
        choice(name: 'BuildOnly',
        choices: 'no/nyes',
        description: 'This will only build the application'
        )
        choice(name: 'ScanOnly',
        choices: 'no/nyes',
        description: "This will Scan the Code"
        )
        choice(name: 'dockerPush',
        choices: 'no/nyes',
        description: "This will build and push to docker repo"
        )
        choice(name:'deployToDev',
        choices: 'no/nyes',
        description: 'This will deploy the app to Dev env'
        )
        choice(name:'deployToTest',
        choices: 'no/nyes',
        description: 'This will deploy the app to Test env'
        )
        choice(name:'deployToStage',
        choices: 'no/nyes',
        description: 'This will deploy the app to Stage env'
        )
        choice(name:'deployToProd',
        choices: 'no/nyes',
        description: 'This will deploy the app to Prod env'
        )
    }
    stages{
        stage ('Build'){
            when{
                expression {
                    params.BuildOnly =='yes'
                }
            }
            steps{
                echo "Building the project"
            }
        }
        stage('CodeAnalysis'){
            when {
                expression{
                    params.ScanOnly == 'yes'
                }
            }
            steps{
                echo "Running Code Analysis"
            }
        }
        stage('DockerBuildNdPush'){
            when{
                expression{
                    params.dockerPush == 'yes'
                }
            }
            steps{
                echo "Building and Pushing the image"
            }
        }
        stage('DeployToDev'){
            when{
                expression{
                    params.deployToDev == 'yes'
                }
            }
            steps{
                echo "Deploying to Dev Environment"
            }
        }
        stage('DeployToTest'){
            when{
                expression{
                    params.deployToTest == 'yes'
                }
            }
            steps{
                echo "Deploying to Test Environment"
            }
        }
        stage('DeployToStage'){
            when{
                expression{
                    params.deployToStage == 'yes'
                }
            }
            steps{
                echo "Depoloying to Stage Environment"
            }
        }
        stage('DeployToProd'){
            when {
                allOf{
                    anyOf{
                        expression{
                    params.deployToProd == 'yes'
                    }
                 }
                 anyOf{
                    branch 'production'
                 }
            }
               
            }
            options{
                timeout(time:300, unit:'SECONDS')     
            }
            input {
                message "Do you want to Deploy?"
                ok "yes"
                submitter 'pavan,dath'                 
            }
            
            steps{
                echo "Deploying to Production Environment"
            }
        }
    }
    post{
        success {
            echo "Application has passed all stages and Deployed successfully"
        }
    }

}