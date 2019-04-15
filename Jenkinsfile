pipeline {
    agent {
        label "QA"
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
				bat '''copy C:\\Users\\sbande\\Desktop\\201\\Jenkins\\slaves\\workspace\\EventRegistrationSystem_Pipeline\\target\\EventRegistrationSystem.war C:\\Users\\sbande\\Desktop\\201\\Jenkins\\Tomcat 8.0\\webapps\\'''
            }
		}
	}
}
