//comments in jenkins 
/* for multi comments*/
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }


}

// you can execute
// groovy can directly execute in sandbox environment i.e, where we write scripting in jenkins it self 
// or
// create a Jenkinsile and save it in scm and connect jenkins to scm
