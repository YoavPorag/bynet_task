pipeline {

  agent any

  parameters {
        string(name: 'LABEL',
               defaultValue: 'latest',
               description: 'label for image. use "latest" or "app-change"')
  }
  environment {
    def LABEL = "${params.LABEL}"
  }

  stages {
    stage('Deploying container to Kubernetes') {
      steps {
        script {
          sh 'kubectl apply -f templates/namespace.yaml'

          sh "sed -e 's|REPLACE_TAG|${LABEL}|g' templates/deployment.yaml | kubectl apply -f -"
          
          sh '''
            kubectl apply -f templates/service.yaml
            until curl 192.168.49.2:31000>/dev/null 2>&1; do sleep 2; done
          '''
          
        }
      }
    }
    stage('creating port forwarding ') {
      steps {
        script {
          sh '''
            kubectl port-forward -n node-app deployment/node-app-deployment 5000:3000 &
            until curl localhost:5000>/dev/null 2>&1; do sleep 2; done
            curl localhost:5000 | cat
          '''
        }
      }
    }
  }
}