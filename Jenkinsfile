pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'Select Browser')
        choice(name: 'ENV', choices: ['Dev', 'QA', 'Stage', 'uat', 'PROD'], description: 'Select Environment')
        choice(name: 'HEADLESS', choices: ['true', 'false'], description: 'Run in headless mode?')
        choice(name: 'TEST_SUITE', choices: ['smoke.xml', 'testNG.xml', 'negative.xml'], description: 'Which Test Suite do you want to run?')
    }

    environment {
        MAVEN_OPTS = "-Dlog4j2.debug=true"
        REPORT_BASE = "target/reports"
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs()
                echo "Workspace cleaned successfully"
            }
        }

        stage('Checkout Source') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/pnilava03/AutomationUIAndAPI.git'
                echo "Source checkout completed"
            }
        }

        stage('Validate Environment') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Build / Compile') {
            steps {
                bat 'mvn clean compile -DskipTests'
            }
        }

        stage('Execute Selected Test Suite') {
            steps {
                echo "Executing suite: ${params.TEST_SUITE}"

                bat """
                mvn test ^
                -DtestSuite=${params.TEST_SUITE} ^
                -Dbrowser=${params.BROWSER} ^
                -Denv=${params.ENV} ^
                -Dheadless=${params.HEADLESS}
                """

                bat """
                if not exist "%REPORT_BASE%" mkdir "%REPORT_BASE%"
                if not exist "%REPORT_BASE%\\%TEST_SUITE%" mkdir "%REPORT_BASE%\\%TEST_SUITE%"

                if exist target\\chaintest (
                    xcopy /E /I /Y target\\chaintest "%REPORT_BASE%\\%TEST_SUITE%\\chaintest"
                ) else (
                    echo ChainTest folder not found
                )

                if exist target\\surefire-reports (
                    xcopy /E /I /Y target\\surefire-reports "%REPORT_BASE%\\%TEST_SUITE%\\surefire-reports"
                ) else (
                    echo surefire-reports folder not found
                )
                """
            }

            post {
                always {
                    junit testResults: "target/reports/${params.TEST_SUITE}/surefire-reports/TEST-*.xml", allowEmptyResults: true

                    publishHTML(target: [
                        reportDir: "target/reports/${params.TEST_SUITE}/chaintest",
                        reportFiles: 'Index.html',
                        reportName: "ChainTest Report - ${params.TEST_SUITE}",
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: true
                    ])

                    archiveArtifacts artifacts: "target/reports/${params.TEST_SUITE}/**/*.*", fingerprint: true, allowEmptyArchive: true
                }
            }
        }

        stage('Archive Full Target Folder') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true, allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo "Pipeline executed successfully"
        }
        unstable {
            echo "Pipeline completed with unstable status. Please check test results."
        }
        failure {
            echo "Pipeline failed. Please check console logs."
        }
        always {
            echo "Pipeline execution finished"
        }
    }
}