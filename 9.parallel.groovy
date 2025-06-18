pipeline{
    agent any
    stages{
        stage ('Build'){
            steps{
                echo 'Building the page'
            }
        }
        stage('parllelstages'){
            parallel{
                stage('CodeAnalysis'){
                    steps{
                        echo "Running Code analysis"
                    }
                }
                stage('SecuirtyScan'){
                    steps{
                        echo "Running Security Scan"
                    }
                }
                stage('PerformanceTest'){
                    steps{
                        echo "Running Performance Test"
                    }
                }
            }
        }
    }
}