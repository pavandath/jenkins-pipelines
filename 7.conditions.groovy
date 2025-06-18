//when condition (it executes whenever a condition is matched)
pipeline{
    agent any
    environment{
        DEPLOY_TO = 'production'
    }
    stages{
        stage('ProdDeploy'){
            when {
                environment name: 'DEPLOY_TO', value: 'production'   //when name is DEPLOY_TO and it's value matched to production steps will execute
            }
        steps{
            echo "Deploying to production"
        }
        }
    }
}

// if the condition didnot match the build will be success but the output will be
//stage "ProdDeploy" skipped due to when condition

------------ equals condition-------------------------------------------
pipeline{
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages{
        stage('ProdDeploy'){
            when {
                equals expected: "prod", actual: "DEPLOY_TO"  //it skips since it is not equal
            }
            
        steps{
            echo "Deploying to production"
        }
        }
    }
}

---------------------not equals condition----------------------------
pipeline{
    agent any
    environment {
        DEPLOY_TO = 'production'
    }
    stages{
        stage('ProdDeploy'){
            when {
                not{
                    equals expected: "prod", actual: "DEPLOY_TO"  //it executes since it is not equal
                }
            }
            
        steps{
            echo "Deploying to production"
        }
        }
    }
}

--------------------expressions-------------------------------
//remember BRANCH_NAME is a default env available in multi branch pipelines only
pipeline{
    agent any 
    stages{
        stage ('DeploytoDev'){
            steps{
                echo "Deploying to dev environment"
            }
            }
        stage ('DeploytoProd') {
            when{
                //branch expression
            expression {BRANCH_NAME ==~ /(production|staging)/}     // ==~ matches regular expression if the left  expr matches right
            }                                                       // if the branch is either one from both it will run
            steps{
                echo "Deploying to Production"
            }
            
        
        }
    }
}
--------------allOf-------------------------------------
//allOf tells that if all the conditions are matched then execute
pipeline{
    agent any
    environment{
        DEPLOY_TO = 'production'
    }
    stages{
        stage ('DeploytoDev'){
            steps{
                echo "Deploying to dev environment"
            }
            }

        stage ('ProdDeploy'){
            when{
                allOf{
                    branch 'production'
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps{
                echo "Deploying to production"
            }
            }
        }
    
}

---------------------anyOf-----------------------------------------------------
//allOf tells that if even one is matched among all conditions then executes
pipeline{
    agent any
    environment{
        DEPLOY_TO = 'production'
    }
    stages{
        stage ('DeploytoDev'){
            steps{
                echo "Deploying to dev environment"
            }
            }

        stage ('ProdDeploy'){
            when{
                anyOf{
                    branch 'production'
                    environment name: 'DEPLOY_TO', value: 'productionenv'   //this condition is wrong even though it executes
                }
            }
            steps{
                echo "Deploying to production"
            }
            }
        }
    
}