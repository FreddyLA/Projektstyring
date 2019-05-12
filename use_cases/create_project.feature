Feature: Creating project
	Description: Testing project creation
	Actors: Development worker
	
Scenario: Create a project
Given a development worker is registered in the system
When a development worker creates a project with the name "New Project"
Then a new project is created with the name "New Project"
And the project is given a unique number for identification.

Scenario: Create a project with the same name as a another project
Given a project with the name "Project 1" exists
When a development worker creates a project with the name "Project 1"
Then an error message "Project with specified name already exists" is presented
