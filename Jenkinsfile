pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'mvn package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'mvn -Dtest=TestMessageBuilder test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '/*.jar', fingerprint: true
            junit 'build/reports/**/*.xml'
        }
    }
}

