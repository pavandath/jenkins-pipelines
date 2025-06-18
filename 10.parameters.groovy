//https://www.jenkins.io/doc/book/pipeline/syntax/#parameters
//The parameters directive provides a list of parameters that a user should provide when triggering the Pipeline.
pipeline{
    agent any
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'TOGGLE', defaultValue: false, description: 'Toggle this value')

        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
    }
    stages{
        stage("ExampleParam"){
            steps{
                echo "Hello ${params.PERSON}"
                echo "Biography is ${params.BIOGRAPHY}"
                echo "Check this ${params.TOGGLE}"
                echo "Select an option ${params.CHOICE}"
                echo "Password entered is ${params.PASSWORD}"
            }
        }
    }
}