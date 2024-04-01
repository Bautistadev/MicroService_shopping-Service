pipeline{
    agent any
    tools{
        maven 'M3'
    }
    environment{
      configuration_uri='http://localhost:8888'
      database_username='root'
      database_password='mpkJORDAN'
    }
    stages{
        stage('checkout'){
            steps{
                git branch: 'main', credentialsId: 'bautistadevgithub', url: 'https://github.com/Bautistadev/MicroService_shopping-Service'
            }
        }
        stage('build'){
            steps{
                sh 'mvn clean package -DskipTest=true -f pom.xml -Dmy.env.variable=$configuration_uri -Dmy.env.variable=$database_username -Dmy.env.variable=$database_password'
            }
        }
        stage('test'){
            steps{
                sh 'mvn test -Dmy.env.variable=$configuration_uri -Dmy.env.variable=$database_username -Dmy.env.variable=$database_password'
            }
        }
        stage('docker build'){
           steps{
               script{
                   sh 'echo ${BUILD_NUMBER}'
                   docker.image("bautistadev/shopping_microservice:v${BUILD_NUMBER}")

               }
           }
        }
    }
    post{
        always{
            echo 'Pipeline finalizado'
        }
        success{
            echo 'Ejecucion exitosa !!'
        }
        failure{
            script{
                if(currentBuild.result == 'FAILURE'){
                    echo 'EL STAGE : '+env.STAGE_NAME+ ' HA FALLADO'
                }
            }
        }
    }
}