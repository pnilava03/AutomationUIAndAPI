pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'Select Browser')
        choice(name: 'ENV', choices: ['Dev','QA', 'Stage', 'uat','PROD'], description: 'Select Environment')
        choice(name: 'HEADLESS', choices: ['true', 'false'], description: 'Run in headless mode?')
        choice(name: 'TEST_SUITE', choices: ['smoke.xml', 'testNG.xml','negative.xml'], description: 'Which test Suite You want to run?')
}

    environment {
        MAVEN_OPTS = "-Xmx1024m"
    }

    stages {

   stage('Build') {
       steps {
      echo("Build ")
                }
           }

    stage('Run Unit Test') {
    steps {
     echo("Run unit test ")
        }
        }

   stage('Deploy to Dev Env') {
    steps {
    echo("Dev Env Deployment done")
    }
    }
    stage('Run Integration Test') {
    steps {
    echo("Run Integration test ")
    }
    }

    stage('Deploy to QA Env') {
        steps {
        echo("QA Env Deployment done")
        }
        }


stage('Clean Workspace') {
steps {
  cleanWs()
  echo("Clean Workspace")
    }
    }

    stage('Checkout Source') {
    steps {
    git branch: 'main',
    url: 'https://github.com/pnilava03/AutomationUIAndAPI.git'
                }
            }


        stage('Validate Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Dependency Install') {
            steps {
                bat 'mvn clean compile'
            }
        }

         stage('Execute Smoke Tests') {
          steps {
         bat """
         mvn test ^
         -DtestSuite="smoke.xml" ^
          -Dbrowser=${params.BROWSER} ^
          -Denv=${params.ENV} ^
          -Dheadless=true
          """
           }
        }

        stage('Execute Functional Tests') {
                            steps {
                                bat """
                                    mvn test ^
                                     -DtestSuite=negative.xml ^
                                    -Dbrowser=${params.BROWSER} ^
                                    -Denv=${params.ENV} ^
                                     -Dheadless=true
                                """
                            }
                        }


          stage('Execute Regression Tests') {
                    steps {
                        bat """

                            mvn test ^
                             -DtestSuite=testNG.xml ^
                            -Dbrowser=${params.BROWSER} ^
                            -Denv=${params.ENV} ^
                             -Dheadless=true
                        """
                    }
                }

        stage('Generate Reports') {
            steps {
                bat 'mvn surefire-report:report'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/**/*.*', fingerprint: true
            }
     }


 stage('Publish ChainTest Report') {
steps {
publishHTML(target: [
 reportDir: 'target/chaintest',
    reportFiles: 'Index.html,Email.html',
     reportName: 'ChainTest Automation Report',
      keepAll: true,
       alwaysLinkToLastBuild: true,
         allowMissing: true
                        ])
                    }
                }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            echo 'Pipeline Execution Completed'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed - Check Logs'
        }
    }
}
