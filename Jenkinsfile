pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'Select Browser')
        choice(name: 'ENV', choices: ['Dev','QA', 'Stage', 'uat','PROD'], description: 'Select Environment')
        choice(name: 'HEADLESS', choices: ['true', 'false'], description: 'Run in headless mode?')
        choice(name: 'TEST_SUITE', choices: ['smoke.xml', 'testNG.xml','negative.xml'], description: 'Which test Suite You want to run?')
    }

    environment {
        MAVEN_OPTS = "-Dlog4j2.debug=true"
    }

    stages {

        stage('Build') {
            steps {
                echo "Build"
            }
        }

        stage('Run Unit Test') {
            steps {
                echo "Run unit test"
            }
        }

        stage('Deploy to Dev Env') {
            steps {
                echo "Dev Env Deployment done"
            }
        }

        stage('Run Integration Test') {
            steps {
                echo "Run Integration test"
            }
        }

        stage('Deploy to QA Env') {
            steps {
                echo "QA Env Deployment done"
            }
        }

        stage('Clean Workspace') {
            steps {
                cleanWs()
                echo "Clean Workspace"
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
                -DtestSuite=smoke.xml ^
                -Dbrowser=${params.BROWSER} ^
                -Denv=${params.ENV} ^
                -Dheadless=${params.HEADLESS}
                """

                bat """
                if not exist target\\reports\\smoke mkdir target\\reports\\smoke
                xcopy /E /I /Y target\\chaintest target\\reports\\smoke\\chaintest
                """
            }
            post {
                always {
                    publishHTML(target: [
                        reportDir: 'target/reports/smoke/chaintest',
                        reportFiles: 'Index.html',
                        reportName: 'Smoke Report',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])

                    archiveArtifacts artifacts: 'target/reports/smoke/**/*.*', fingerprint: true, allowEmptyArchive: true
                }
            }
        }

        stage('Execute Functional Tests') {
            steps {
                bat """
                mvn test ^
                -DtestSuite=negative.xml ^
                -Dbrowser=${params.BROWSER} ^
                -Denv=${params.ENV} ^
                -Dheadless=${params.HEADLESS}
                """

                bat """
                if not exist target\\reports\\functional mkdir target\\reports\\functional
                xcopy /E /I /Y target\\chaintest target\\reports\\functional\\chaintest
                """
            }
            post {
                always {
                    publishHTML(target: [
                        reportDir: 'target/reports/functional/chaintest',
                        reportFiles: 'Index.html',
                        reportName: 'Functional Report',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])

                    archiveArtifacts artifacts: 'target/reports/functional/**/*.*', fingerprint: true, allowEmptyArchive: true
                }
            }
        }

        stage('Execute Regression Tests') {
            steps {
                bat """
                mvn test ^
                -DtestSuite=testNG.xml ^
                -Dbrowser=${params.BROWSER} ^
                -Denv=${params.ENV} ^
                -Dheadless=${params.HEADLESS}
                """

                bat """
                if not exist target\\reports\\regression mkdir target\\reports\\regression
                xcopy /E /I /Y target\\chaintest target\\reports\\regression\\chaintest
                """
            }
            post {
                always {
                    publishHTML(target: [
                        reportDir: 'target/reports/regression/chaintest',
                        reportFiles: 'Index.html',
                        reportName: 'Regression Report',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])

                    archiveArtifacts artifacts: 'target/reports/regression/**/*.*', fingerprint: true, allowEmptyArchive: true
                }
            }
        }

        stage('Generate Surefire Reports') {
            steps {
                bat 'mvn surefire-report:report'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/**/*.*', fingerprint: true
            }
        }
    }

   post {
       always {
           script {
               if (fileExists('target/surefire-reports')) {
                   junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
               } else {
                   echo 'No JUnit report directory found.'
               }
           }
       }
   }