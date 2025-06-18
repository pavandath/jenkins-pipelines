// https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/
// if u want to wantedly fail the pipeline even the code is correct then use error
pipeline{
    agent any
    stages{
        stage ('Build'){
           steps{
            echo "Heloo Jenkins"
            error "THis is a failed build"
           } 

        }
        
    }
}

//retry (if u want to retry for n number of times instead of directly telling failure use retry)

pipeline{
    agent any
    stages{
        stage ('Build'){
           steps{
            retry(3) {
                echo "Heloo Jenkins"                                // retry block
                error "THis is a failed build"
            }
            
            echo "********I retried 3 times**********"              // this message prints after retrying 3 times

           } 

        }
        
    }
}

//timeout ( execute the code with in the determined timeout limit)
pipeline{
    agent any
    stages{
        stage('Build') {
            steps {
            timeout(time:10, unit: 'SECONDS')   //after 10 seconds it is aborted  (NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS)   
            {
                echo "sleep for 60 seconds"
                sleep 60
            }
            }
        }
    }
}