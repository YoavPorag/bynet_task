pipeline {

  agent any

  stages {
    stage('Deploying container to Kubernetes') {
      steps {
        script {
          sh '''
            kubectl apply -f templates/namespace.yaml
            kubectl apply -f templates/deployment.yaml
            kubectl apply -f templates/service.yaml
          '''
        }
      }
    }
    stage('creating port forwarding ') {
      steps {
        script {
          sh '''
            kubectl port-forward -n node-app deployment/node-app-deployment 5000:3000 &
          '''
        }
      }
    }
    stage('testing port forwarding') {
      steps {
        script {
          sh '''
            curl localhost:5000 | cat
          '''
        }
      }
    }
  }
}