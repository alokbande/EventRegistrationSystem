node {
   stage ('Initialize') {
            steps {
                bat '''
                    echo "JAVA_HOME = %JAVA_HOME%"
                    echo "M2_HOME = %M2_HOME%"
                '''
            }
   }
   stage('getscm') { 
      git 'https://github.com/alokbande/EventRegistrationSystem.git'
      M2_HOME = tool 'Maven'
   }
   stage('Build') {
      bat(/"${M2_HOME}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
   }
   stage('artifact') {
      archive 'target/*.war'
   }
   stage ('deploy'){
   echo 'deployment started'
       bat '''copy C:\\Program Files (x86)\\Jenkins\\workspace\\EventRegistrationSystem\\target\\*.war F:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\'''
   }
}
