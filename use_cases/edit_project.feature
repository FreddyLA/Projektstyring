Feature: Creating project
	Description: Testing project creation
	Actors: Development worker
	
Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Set the project start time to before project creation time
When the project leader assigns a start date for the project that is before the project creation date
Then an error message "Project start/end date cannot be before the project creation date" is presented

Scenario: Set the project end time to before project creation time
When the project leader assigns a end date for the project that is before the project creation date
Then an error message "Project start/end date cannot be before the project creation date" is presented