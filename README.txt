Building the Test projects

Preconditions:
- IntelliJ or Eclipse is installed

TODO:
1. Open the current folder in a shell (Windows: PowerShell)
2. If gradle wrapper is not properly setup (missing wrapper jar), run the following command:
   .\gradlew wrapper
   (You can check if the jar is missing with the following command)
   ls gradle/wrapper
2. For Eclipse: .\gradlew cleanEclipse eclipse
   For IntelliJ: .\gradlew cleanIdea idea
3. Start your IDE and import the projects