# Cloud-native CI/CD pipeline using Jenkins and AWS EKS to build, test, and deploy a RESTful application

This project is a simple Spring Boot web application designed to demonstrate a complete CI/CD pipeline using Jenkins, Docker, EC2, AWS ECR, and Amazon EKS (Elastic Kubernetes Service).

---

## 🔧 Tech Stack

- **Java 21**
- **Spring Boot 3.2**
- **Gradle**
- **Docker**
- **AWS ECR** 
- **AWS EKS**
- **Jenkins** (running on EC2)
- **Kubernetes** in `/k8s`

---

## ⚙️ CI/CD Pipeline Overview

The Jenkins pipeline does the following:

1. **Builds** the Spring Boot app using Gradle
2. **Runs unit tests**
3. **Builds a Docker image**
4. **Pushes the image to ECR**
5. **Deploys the app to EKS**

---

## 🚀 Deployment Targets

- **K8s Deployment/Service**:
    - Located in `/k8s/deployment.yaml` and `/k8s/service.yaml`
    - Deployed to EKS cluster

---

## 📂 Project Structure

```plaintext
.
├── Jenkinsfile             # CI/CD pipeline for Jenkins
├── Dockerfile              # Builds the runtime image
├── build.gradle            # Gradle build script
├── k8s/                    # Kubernetes deployment and service YAMLs
└── src/                    # Java source code
