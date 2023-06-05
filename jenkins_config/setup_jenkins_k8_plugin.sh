#!/bin/bash

kubectl apply -f namespace.yaml
kubectl apply -f serviceAccount.yaml
kubectl apply -f ingress.yaml