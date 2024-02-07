pipeline{

    agent any

    stages{

        stage('Build Jar'){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Image'){
            steps{
                sh 'docker build -t=jadyjdjady1990/selenium-docker .'
            }
        }

        stage('Push Image'){
            environment{
                // assuming you have stored the credentials with this name
                DOCKER_HUB = credentials('docker-creds')
            }
            steps{
                // There might be a warning.
                sh 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                sh 'docker push jadyjdjady1990/selenium-docker'
            }
        }

    }

    post {
        always {
            sh 'docker logout'
        }
    }

}