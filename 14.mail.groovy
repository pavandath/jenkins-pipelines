pipeline{
    agent any
    stages{
        stage ('Build'){
            steps{
            echo "Building the project"
            }
        }
    }
    post{
        success{
            mail bcc: '', body: 'Build is success you can deploy now', cc: '', from: '',replyTo:'',subject: 'Jenkins Job status', to: 'pbachala@softility.com'
        }
    }
}