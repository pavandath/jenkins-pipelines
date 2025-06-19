pipeline{
    agent any
    stages{
        stage('Build') {
            steps{
                echo 'Buildng the Application'
            }
        }
    }
    post{
        always{
            script{
                // mail bcc: '', body: 'Build is success you can deploy now', cc: '', from: '',replyTo:'',subject: 'Jenkins Job status', to: 'pbachala@softility.com'
                def subject = "Job Status is: ${currentBuild.currentResult}"
                def body = "Build number is: ${currentBuild.number}\n" + "status is ${currentBuild.currentResult}" + "Job Url is: ${env.BUILD_URL}"
                mail to:'pbachala@softility.com',
                    subject: subject,
                    body: body
                
            }
        }
    }
}