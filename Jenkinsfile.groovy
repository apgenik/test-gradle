pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                script {
                    def longString = "This is a very long string that needs to be displayed on multiple lines in the Jenkins build display name."
                    def wrappedString = longString.split(/(?=\\s)/).inject('') { result, word ->
                        if (result.length() + word.length() > 50) { // Adjust 50 to your desired line length
                            return result + '\\n' + word
                        } else {
                            return result + word
                        }
                    }
                    currentBuild.displayName = wrappedString
                    echo "Display name set to: ${currentBuild.displayName}"
                }
            }
        }
    }
}