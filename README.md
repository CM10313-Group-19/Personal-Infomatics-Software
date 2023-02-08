# Personal-Infomatics-Software
Main repository for the coursework

### Breakdown of repository
<details><summary>View breakdown</summary>
<p>
  
  *note: This repository has been initially setup for java as it's the language that would make most sense for this project as it is robust for object-oriented programming and has a nice GUI library, and the language we have the most recent experience with in POP*
  

---------------------------------
  - **src**
    - main/java contains the java class files that form the program, and is where code should go
    - main/resources is the resource folder, e.g. for text files
    - test/java contains the classes that contain unit tests where test cases should be created
-----------------------------------
  - **ProjectInformation**
    - ProjectRequirements text file that has the initial requirements from the specification and space to add additional requirements.
    - MeetingMinutes is a folder containing the minutes for each meeting, which also contains the date and time of planned meetings, attendance, and topic for discussion which anyone can add to.
    - GuideToTheWrittenReport contains condensed information taken from the specification regarding what is expected from the report
    - MarkingScheme is taken directly from the specification
    - References is a folder initially containing all the references provided in the specification
    - A pdf copy of the specification
-------------------------------------
  - **.github/workflows**
    - Contains the maven.yml folder that controls the continuous integration action that runs the tests in the test folder every time code is pushed to the GitHub
    - Should not need to be changed
--------------------------------------
  - **pom.xml**
    - File required for maven used to automatically  run tests
    - If external libraries are used, they can be added to the project as a dependency  here
-------------------------------------------
  
</p></details>

