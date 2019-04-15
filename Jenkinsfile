pipeline {
    agent {
        label "master"
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "JAVA_HOME = %JAVA_HOME%"
                    echo "M2_HOME = %M2_HOME%"
                '''
            }
        }

        stage('clean') {
            steps {
				bat 'mvn clean'
			}
        }
        stage("Unit testing") { 
			steps {
				bat 'mvn test'           
			}			
		}
        stage('package') {
            steps {
				bat 'mvn package'
            }
        }
		stage('artifact') {
			archive 'target/*.war'
		}
		stage ('deploy'){
			echo 'deployment started'
				bat '''copy C:\\Program Files (x86)\\Jenkins\\workspace\\EventRegistrationSystem\\target\\*.war F:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\'''
		}
	}
}
