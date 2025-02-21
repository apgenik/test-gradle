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
                    }.trim() // Remove leading/trailing whitespace

                    // Use setDescription to set the display name with HTML formatting
                    currentBuild.description = """<div style="white-space: pre-wrap;">${wrappedString}</div>"""
                    currentBuild.displayName = currentBuild.getDisplayName() // Refresh the display name

                    echo "Display name set to: ${currentBuild.displayName}"
                    echo "Description set to: ${currentBuild.description}"
                }
            }
        }
    }
}