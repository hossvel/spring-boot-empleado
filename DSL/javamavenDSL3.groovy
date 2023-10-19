job('JavaMavenAppDSL3') {
    description('Java Maven App con DSL para el curso de Jenkins')
    scm {
        git('https://github.com/hossvel/spring-boot-empleado.git', 'main') { node ->
            node / gitConfigName('hhvelascoa')
            node / gitConfigEmail('hhvelascoa@gmail.com')
        }
    }
    triggers {
        githubPush()
    }
    steps {
        maven {
            mavenInstallation('mavenjenkins')
            goals('-B -DskipTests clean package')
        }
        maven {
            mavenInstallation('mavenjenkins')
            goals('test')
        }
        shell('''
          echo "****Entrega: Desplegando jar la aplicación empleados********" 
          # java -jar "/var/jenkins_home/workspace/JavaMavenAppDSL3/target/spring-boot-empleado-0.0.1-SNAPSHOT.jar"
        ''')
    }
    publishers {
        archiveArtifacts('target/*.jar')
        archiveJunit('target/surefire-reports/*.xml')
        slackNotifier {
            notifyAborted(true)
            notifyEveryFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
        }
    }
}