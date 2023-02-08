# Personal-Infomatics-Software
Main repository for the coursework

### Breakdown of repository
<details><summary>View breakdown</summary>
<p>
  
  *note: This repository has been initially setup for java as it's the language that would make most sense for this project*
  
-----------------------------------
  - **ProjectInformation folder**
    - ProjectRequirements text file that has the initial requirements from the specification and space to add additional requirements.
    - MeetingMinutes is a folder containing the minutes taken from each meeting
    - GuideToTheWrittenReport contains condensed information taken from the specification regarding what is expected from the report
    - MarkingScheme is take directly from the specification
    - A pdf copy of the specifcation
---------------------------------
  - **src**
    - main/java contains the java class files that form the program
    - main/resources is the resource folder, e.g. for text files
    - test/java contains the classes that contain unit tests where test cases should be created
-------------------------------------
  - **.github/workflows**
    - Contains the maven.yml folder that controls the continuos integration action that runs the tests in the test folder every time code is pushed to the github
    - Should not need to be changed
--------------------------------------
  - **pom.xml**
    - File required for maven used to automaticly run tests
    - If external libraries are used, they can be added to the project as a dependancy here
-------------------------------------------
  
</p></details>

