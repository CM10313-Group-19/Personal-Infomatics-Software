<details><summary>Overview of Project</summary>
<p>

## Overview of Project:

Purpose of the assignment: MainProgram.Exercise and demonstrate an agile approach to the software development life cycle, with a focus on the process of production rather than functionality of software, reviewing the validity of requirements and designs as the project evolves through its lifecycle.

### The Personal Informatics software system:

The assignment is to research, specify, design, develop and test software for a personal infomatics software system with your target users as current university students, designed to help them with anything that might improve understanding and potentially improving an aspect of their habitual behaviour. Examples include:
  - Daily walking
  - Coffee consumption
  - Mood
  - Screen time
  - Cooking with fresh vegetables <br>
Your PI system should collect more than 1 kind of data, so possible relations between kinds of PI data can be explored. 

The task will involve additional research in the domain of PI, and must involve:
  1. Articles on PI to help chose the types of habits and PI data you will gather
  2. Interviewing potential users (other students) about your PI concept
  3. Comparing existing PI systems that are related to your challenge
You are expected to compare and contrast ideas from these sources. We expect you to make use of the Computer Science subject resources linked from the University of Bath Library at http://www.bath.ac.uk/library/subjects/comp-sci/. You are expected to adjust your understanding of your PI concept as you go from sprint to sprint, with the sprint reviews incorporating additional research members of your group have done in any of the three forms mentioned above.
  
### Following an Agile Lifecycle: Scrum
  ![ScrumDevelopmentLifecycle](https://user-images.githubusercontent.com/65113244/217248421-d1e50e7c-1cee-4d94-98b7-1a59a806c03f.png)
  - Minumum of 3 sprints
  - Use requirements specification to prioritise and select requirements for each sprint.
  - Selected requirements will form your sprint backlog, which can be broken down into tasks for your group members to complete during the sprint.
  - Each sprint should last between 1-3 weeks, and include design, implementation and testing.
  - Hold regular 'scrum' meetings during the sprint to share status and discuss issues.
  - A short informal demonstration should be given to the course tutors and discuss the outocmes of the sprint with respect to its planned backlog and tasks.!

### Programming
  - Programming in this unit is treated as a means to an end, enabling you to experience a test-driven software development lifecycle.
  - Programming ability and code structure will not be assessed as part of this assignment, but you are required to produce a testable software system.
  - You will be implementing your designs, carrying out software testing on your evolving system.
  - You can chose any platform, and any object oriented programming language
  
### 'Tracking Data' for your PI software
  - Your system can make use of any source of PI data
  - e.g. Asking users to manually enter data by responding to questions in a form presented by the UI
  - You may obtain data from sensors, e.g. Arduino components or devices like a Fitbit (using an API)
  - You are not expected to develop working interfaces with existing technologies in order to acquire 'real' data, but are encouraged to do so
  - You are welcome to mock up some tracking data to be used by your PI software, e.g. writing software to automatically generate artificial tracking data, simulating inputs from certain devices or services

  </p>
</details>

# Project Requirements:

When incorporating requirements that have been provided in the initial software requirements specification, you should cite 'Coursework Specification' as their source

### Non-Functional Requirements

<details><summary>Show requirements</summary>
<p>

1. **Software Development Process**
  - [ ] 1.1 Your software process must be consistent with Scrum methodology.
  - [ ] 1.2 Your software development should include at least three sprints. Dependencies: 1.1, 1.3
  - [ ] 1.3 Each sprint should last between 1 and 3 weeks.
    Dependencies: 1.1, 1.2
  - [ ] 1.4 Must regularly review the functional requirement asssociated with envisioned system features.
---------------------------------------------------------------------
2. **Expanding Initial Requirements**
  - [ ] 2.1 Must expand upon all initial requirements, based on your
PI research.
Dependencies: 3.2
  - [ ] 2.2 Must expand upon the initial Functional requirements
and add additional functionality to the system to deliver
features you have chosen to offer.
  - [ ] 2.3 Additional requirements should be established using
appropriate requirements gathering techniques.
Dependencies: 2.1, 2.2
---------------------------------------------------------------------
3. **Background Research**
  - [ ] 3.1 Must read and cite at least three articles in the area of
Personal Informatics, at least one of which must be drawn
from the reference section of this coursework document.
Dependencies: 3.2
  - [ ] 3.2 Should read and cite at least six articles of any kind. 
---------------------------------------------------------------------
4. **Testing**
  - [ ] 4.1 Must adopt a test-driven development approach,
including production of test plans.
  - [ ] 4.2 Must provide evidence of testing (e.g. JUnit output)
  - [ ] 2.2 Functional Requirements
  
    </p>
</details>

### Functional Requirements

<details><summary>Show requirements</summary>
<p>

5. **Viewing and Collecting Tracking Data**
  - #### Initial Requirements:
    - [ ] 5.1 Store data on user activity relevant to the chosen PI
concept (see Section 3 ‘Tracking Data’ of specification for more detail).
Dependencies: 3
      - [ ] 5.1.1 Able to store name of food, calories, and when it was eaten. 
      - [ ] 5.1.2 Optional ability to store protein, carbohydrates and fat data
      - [ ] 5.1.3 Step count for each day
      - [ ] 5.1.4 Additional workout information, e.g. name of excercise, calories burnt, length of workout, distance etc
    - [ ] 5.2 Allow the user to access tracking data that is stored.
      - [ ] 5.2.1 Ability to look at past work out data and historical food data.
    - [ ] 5.3 Permit the user to manually enter any tracking data which
can not be obtained automatically from a tracking device or
service (e.g. allowing the user to enter the number of cups
of coffee consumed each day, or to enter a rating that
represents their mood for the day).
      - [ ] 5.3.1 User enters information like weight, height that can be used to calculate information
 ---------------------------------------------------------------------
 
6. **Identifying Trends and Relationships in PI Data**
  - #### Initial Requirements:
  - [ ] 6.1 Permit a user to compare their data over time (e.g. to see
if they have walked 5% more each day for the last n days,
or if their diet is regularly less vegetable-intensive on a
Monday). 
    - [ ] 6.1.1 Track step count each day over time
    - [ ] 6.1.2 Track other stuff over time
  - [ ] 6.2 Permit a user to compare different kinds of PI data within
a fixed period of time (e.g. to find out if changes in their
mood have followed changes in their diet over the last 14
days).
    - [ ]

---------------------------------------------------------------------

7. **Goals and Achievements**
  - #### Initial Requirements:
  - [ ] 7.1 Permit a user to manage targets (goals) for a tracked
activity.
    - [ ] User can add an exercise target and if they meet they get a visual/audio reward
  - [ ] 7.2 Permit a user to set a daily or weekly goal value for a
particular data variable (e.g. Steps Goal >= 10000,
Productivity Goal >= 60%, Cups of Coffee Goal <= 2).
  - [ ] 7.3 Permit a user to update or change a goal.
    - [ ] Suggested goals will be provided and user can change the goals themselves.
  - [ ] 7.4 Incorporate a feature to motivate the user to achieve their
goals (e.g. scoring points, receiving trophies/ badges,
competing with other users)
    - [ ] 7.4.1 Trophy/badge system will be used.
  - #### Additional Requirements:
      - [ ] ...

</p>
</details>
