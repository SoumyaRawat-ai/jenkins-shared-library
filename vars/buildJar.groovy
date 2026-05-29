#!/usr/bin/env groovy

def call() {
    echo "Building Jar file..."
    sh 'mvn package'
}

