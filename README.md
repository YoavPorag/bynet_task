Bynet Devops task
     
Prerequisites: You should have an account for: 
RapidAPI - https://rapidapi.com/studio 
Github/Bitbucket - https://github.com/YoavPorag/8200-node-app 
Dockerhub - https://hub.docker.com/u/yoavporag  
Jenkins,
minikube or other k8s platform
 
Part 1 – Development and Dockerize 
Fork repository:
https://github.com/bynet-devops-training/8200-node-app  to your GitHub   
Create a repository on GitHub and push your app there. 
Create a Dockerfile for your app. 
Upload your Docker image to Dockerhub. 

Part 2 – Devops: CI – CD 
Setup Jenkins on minikube
Create a pipeline in your Jenkins, the pipeline should do the following: 
Pull the docker image from dockerhub 
Deploy the app in Kubernetes with service NodePort  
Create port-forwarding for your app 
Open your browser and check if the application is running. 
Add a change in your app and use tagging to manage the app versions 