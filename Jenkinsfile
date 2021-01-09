#!groovy
// Check netbook properties
properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }
    triggers { pollSCM('* * * * *') }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("Build service artefact") {
            steps {
                echo '================== Building service artefact =================='
                sh 'mvn clean'
                sh 'mvn install'
            }
        }
        stage("DockerHub login") {
            steps {
                echo '================== DockerHub login =================='
                withCredentials([usernamePassword(credentialsId: 'dockerhub-vladislavduma', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh """
                    docker login -u $USERNAME -p $PASSWORD
                    """
                }
            }
        }
        stage("Build image") {
            steps {
                sh 'docker build -t vladislavduma/inv-stocks-service:latest .'
            }
        }
        stage("Push image to docker registry") {
            steps{
                echo '================== DockerHub Push =================='
                sh "docker push vladislavduma/inv-stocks-service:latest"
            }
        }
        stage("Run image on Backend server") {
            steps{
                echo '================== Running on Backend =================='
                sh 'docker stop inv-stocks-service-prod ||true'
                sh 'docker rm inv-stocks-service-prod ||true'
                sh 'docker run -d --restart unless-stopped --name inv-stocks-service-prod' +
                        ' -e DB_URL=$DB_URL' +
                        ' -e DB_USR=$DB_USR' +
                        ' -e DB_PASSWORD=$DB_PASSWORD' +
                        ' -e DB_SCHEMA=$DB_SCHEMA' +
                        ' vladislavduma/inv-stocks-service:latest'
            }
        }
    }
}