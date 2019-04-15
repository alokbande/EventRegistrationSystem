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
			steps {
				archive 'target/*.war'
            }
			
		}
		stage ('deploy'){
			steps {
				bat '''copy C:\\Program Files (x86)\\Jenkins\\workspace\\EventRegistrationSystem_Pipeline\\target\\*.war C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\'''
            }
		}
	}
}
