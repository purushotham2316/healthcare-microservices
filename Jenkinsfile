pipeline {
    agent any

    environment {
        EC2_IP = 'your-ec2-public-ip'
        APP_DIR = '/home/ubuntu/healthcare'
        KEY_PATH = '/home/ubuntu/aws-key.pem'
        USER = 'ubuntu'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/yourusername/healthcare-microservices.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to AWS') {
            steps {
                sh '''
                scp -i $KEY_PATH target/*.jar $USER@$EC2_IP:$APP_DIR
                ssh -i $KEY_PATH $USER@$EC2_IP "nohup java -jar $APP_DIR/*.jar > $APP_DIR/app.log 2>&1 &"
                '''
            }
        }
    }
}
