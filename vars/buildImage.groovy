#!/usr/bin/env groovy

def call() {
   echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS', usernameVariable: 'USER' )]) {
    sh 'docker build -t soumyarawat03/demo-app:jma2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push soumyarawat03/demo-app:jma2.0'
  }
}

