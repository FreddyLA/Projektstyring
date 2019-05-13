Feature: Creating an activity
	Description: A project leader creates a new project
	Actor: Project leader
	
Scenario: Create an activity
Given a project with the name "Project 1" exists
And a project leader has been selected
When the project leader creates a new activity with the name "Activity"
Then a new activity with the name "Activity" is created

Scenario: Creating an activity without being project leader
Given a project with the name "Project 1" exists
And a project leader has been selected
When a development worker creates an activity for the project
Then an error message "Action for project leader only" is presented

Scenario: Creating an activity without a name
Given a project with the name "Project 1" exists
And a project leader has been selected
When the project leader creates a new activity with the name ""
Then an error message "Can't create a object with no name" is presented
