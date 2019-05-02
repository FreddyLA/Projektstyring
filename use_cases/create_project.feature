Feature: Creating project
	Description: Testing project creation
	Actors: Development worker
	
Scenario: Opret et projekt
Given a development worker is registered in the system
When a development worker creates a new project with the name "New Project"
Then a new project is created with the name "New Project"
And the project is given a unique number for identification.

Scenario: Opret et projekt med samme navn som et andet projekt
Given a project with the name "Project 1" already exists
And a development worker tries to create a new project with the same name
Then an error message "Project with given name already exists" is presented

Scenario: Opret et projekt med starttidspunkt foer projektoprettelsen
Given a development worker creates a new project
And a project leader has been selected
And the project leader assigns a start date for the project that is before the project creation date
Then an error message "Project start date cannot be before the project creation date" is presented
