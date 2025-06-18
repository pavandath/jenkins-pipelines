pipeline{
    agent { label 'docker-slave'}
    tools {
        maven 'MVN_3.9.9'               //global
    }
    stages {
        stage ('Build') {
            
            steps {
                sh 'mvn --version'
                
            }
        }
        stage ('otherproject') {
            
            tools {
                jdk 'JDK17'       //here maven will run but java version will be 17 here  
            }                       // so tools can be also configured at stage level
            steps {
                sh 'mvn --version'
                
            }
        }
    }
}