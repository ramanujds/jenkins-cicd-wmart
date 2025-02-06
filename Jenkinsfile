pipeline {
    agent any

    tools {
        maven "maven-3.9.9"
    }

    stages {

        stage('Source'){
            steps {
               echo 'Checking out source code from GitHub'
               checkout scmGit(branches: [[name: '*/main']], extensions: [cleanBeforeCheckout()], userRemoteConfigs: [[credentialsId: 'github-cred', url: 'https://github.com/ramanujds/jenkins-cicd-wmart']])
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests'
                sh "mvn test"
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application'
                sh "mvn clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Build Docker Image'){
            steps {
                    echo 'Building the Docker Image'
                    sh "docker build -t ram1uj/wmart-todo-app ."
                  }

        }

    }
}
