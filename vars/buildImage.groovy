#!/usr/bin/env groovy

def call() {

    echo "Building the Docker image..."

    withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USER',
            passwordVariable: 'PASS'
        )
    ]) {

        sh 'docker build -t soumyarawat03/demo-app:jma2.1 .'

        sh """
            echo \$PASS | docker login -u \$USER --password-stdin
        """

        sh 'docker push soumyarawat03/demo-app:jma2.1'
    }
}

