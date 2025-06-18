pipeline{
    agent any
    //Global env section, it can be used by all stages
    environment {
        course = "Devops with ${pavan}"
        name = "Pavan"
    }
    stages{
        stage ('Build'){
            // this can be used by only this stage
            environment {
                cloud = 'GCP'
            }
            steps{
                echo "Welcome ${name}"
                echo "Thankyou for enrolling ${course}"
                echo "You are certified in ${cloud}"
            }
        }
    }
}

------Precidence stage----------------------

// The name will be printed as Dath since the stage has highest precidence
pipeline{
    agent any
    //Global env section, it can be used by all stages
    environment {
        course = "Devops with ${pavan}"
        name = "Pavan"
    }
    stages{
        stage ('Build'){
            // this can be used by only this stage
            environment {
                cloud = 'GCP'
                name = 'Dath'
            }
            steps{
                echo "Welcome ${name}"
                echo "Thankyou for enrolling ${course}"
                echo "You are certified in ${cloud}"
            }
        }
    }
}

------------Default environment variables-------------------------

// The name will be printed as Dath since the stage has highest precidence
pipeline{
    agent any
    //Global env section, it can be used by all stages
    environment {
        course = "Devops with ${pavan}"
        name = "Pavan"
    }
    stages{
        stage ('Build'){
            // this can be used by only this stage
            environment {
                cloud = 'GCP'
                name = 'Dath'
            }
            steps{
                echo "Welcome ${name}"
                echo "Thankyou for enrolling ${course}"
                echo "You are certified in ${cloud}"
                echo "My branch is ${env.BRANCH_NAME}"    //to call default variables provided by jenkins we use env.
            }
        }
    }
}

***********************************CREDENTIALS*********************************

pipeline{
    agent any
    environment {
        GITHUB_CREDS = credentials('github_creds')                  //github_creds is the id of github credentials
        SONAR_CRED = credentials('sonar_creds')
    }
    stages{
        stage('Build'){
            steps{
                echo "my github credentials are************"
                echo "My Username is ${GITHUB_CREDS_USR}"
                echo "My Password is ${GITHUB_CREDS_PSW}"
            }
        }
    }
}

***************docker credentials*******************

// make sure you create personal access token in docker account settings since username and password via cli is deprecated
pipeline{
    agent any
    environment{
        DOCKER_CREDS = credentials('docker_token')
        DOCKER_REPO = 'pavandath510/solo-leveling'

    }
    stages{
        stage('Docker Push') {
        steps{
            sh "docker tag  sololeveling:v4 ${DOCKER_REPO}:v1"
            sh "docker login -u ${DOCKER_CREDS_USR} -p ${DOCKER_CREDS_PSW}"
            sh "docker push ${DOCKER_REPO}:v1"
        }
        }
    }
}