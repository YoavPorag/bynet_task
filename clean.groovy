pipeline {

  agent any

  stages {
    stage('Cleaning ') {
      steps {
        script {
          sh '''
            kubectl delete deployment -n node-app node-app-deployment 
            kubectl delete service -n node-app node-app-service
          '''
        }
      }
    }
  }
}