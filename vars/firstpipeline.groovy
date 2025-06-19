def call(Map PipelineParams) {
    // Notice: No "import" here - this is correct.
    def calculator = new com.pavan.builds.Calculator(this) // full class path used here

    pipeline {
        agent { label 'docker-slave' }

        environment {
            APPLICATION_NAME = "${PipelineParams.appName}"
        }

        stages {
            stage('Build') {
                steps {
                    echo "Building ${env.APPLICATION_NAME}"
                }
            }

            stage('Calculate') {
                steps {
                    script {
                        def sum = calculator.add(2, 3)
                        echo "Sum: ${sum}"
                    }
                }
            }
        }
    }
}

def newcal(a, b) {
    return a + b
}
