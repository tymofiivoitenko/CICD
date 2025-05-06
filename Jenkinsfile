pipeline {
    agent any

    tools {
        jdk 'jdk-21'
    }

    environment {
        AWS_REGION = "eu-central-1"
        ECR_REGISTRY = "788133893166.dkr.ecr.eu-central-1.amazonaws.com"
        ECR_REPO = "cicd-app"
        CLUSTER_NAME = "my-cicd-cluster"
        K8S_DEPLOY_PATH = "k8s"
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Docker Build & Push') {
            when {
                branch 'main'
            }
            steps {
                sh """
                aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $ECR_REGISTRY
                docker build -t $ECR_REPO .
                docker tag $ECR_REPO:latest $ECR_REGISTRY/$ECR_REPO:latest
                docker push $ECR_REGISTRY/$ECR_REPO:latest
                """
            }
        }

        stage('Deploy to EKS') {
            when {
                branch 'main'
            }
            steps {
                sh """
                aws eks update-kubeconfig --region $AWS_REGION --name $CLUSTER_NAME
                kubectl apply -f $K8S_DEPLOY_PATH/
                """
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
        }
    }
}
