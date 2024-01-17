pipeline {
    agent any
    tools {
        maven 'MAVEN'  // Replace with your actual Maven tool name
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build JDK 17 Image') {
            steps {
                script {
                    def jdkImage = docker.build('my-jdk-image:17', '-f Dockerfile.jdk17 .')
                    jdkImage.inside {
                        // You can add additional build steps inside the JDK image if needed
                        sh 'java -version'
                    }
                }
            }
        }
        stage('Deploy Spring Application') {
            steps {
                script {
                    def springImage = docker.build('my-spring-app:latest', '-f Dockerfile.spring .')
                    springImage.inside {
                        // Your deployment steps here
                        sh 'java -jar target/your-application.jar'
                    }
                }
            }
        }
    }
}

