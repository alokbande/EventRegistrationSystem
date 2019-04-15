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
		stage('Sonar scan execution') {
            steps {
                bat "mvn verify sonar:sonar -Dintegration-tests.skip=true -Dmaven.test.failure.ignore=true"
            }
        }
		stage ('deploy'){
			steps {
				bat '''copy C:\\Users\\sbande\\Desktop\\201\\Jenkins\\slaves\\workspace\\EventRegistrationSystem_Pipeline\\target\\EventRegistrationSystem.war C:\\Users\\sbande\\Desktop\\201\\Jenkins\\Tomcat8\\webapps\\'''
            }
		}
	}
}
