Feature: Project leader can get overview of time usage on project
	Description: A project leader creates a new project
	Actor: Project leader
	
Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And a development worker is assigned the activity
And the development worker inputs 8 hours worked on the activity into the system
	
Scenario: Project leader gets time spent on an activity
Given the project leader creates a new activity with the name "Activity2"
And a development worker inputs 4 hours worked on the activity with the name "Activity2"
When the project leader asks for time spent on the activity with the name "Activity"
Then the project leader is told that 8 hours has been spent on the activity

Scenario: Project leader gets time spent on a project
Given the development worker inputs 4 hours worked on the activity into the system
When the project leader asks for time spent on the project
Then the project leader is told that 12 hours has been spent on the project

Scenario: Project leader gets expected time left on a project
Given the bugettet time on the project is 12 hours
When the project leader asks work remains on the project
Then the project leader is told that 4 hours remain on the project

