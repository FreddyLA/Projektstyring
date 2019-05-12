Feature: Creating project
	Description: Testing project creation
	Actors: Development worker
	
Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Project leader changes the project start date
When the project leader changes the project start date
Then the project start date has been changed

Scenario: Project leader changes the project start date
When the project leader changes the project end date
Then the project end date has been changed

Scenario: Set the project start time to before project creation time
When the project leader assigns a start date for the project that is before the project creation date
Then an error message "Project start/end date cannot be before the project creation date" is presented

Scenario: Set the project end time to before project creation time
When the project leader assigns a end date for the project that is before the project creation date
Then an error message "Project start/end date cannot be before the project creation date" is presented

Scenario: Development worker tries to edit a project that does not exist
When a development worker tries to edit a project that does not exist
Then an error message "Project with specified ID does not exist" is presented

Scenario: A development worker that does not exist tries to edit a project
When a development worker that does not exist tries to edit a project
Then an error message "Developer with specified initials does not exist" is presented