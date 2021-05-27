pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker-compose build'
            }
        }
        stage('Docker Run') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
