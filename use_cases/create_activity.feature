Feature: Creating an activity
	Description: A project leader creates a new project
	Actor: Project leader
	
Scenario: Create an activity
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
Then a new activity with the name "Activity" is created

Scenario: Creating an activity without being project leader
Given a project has been created
And a development worker creates an activity for the project
Then an error message "Only project leaders can create activities" is presented

Scenario: Create an activity with deadline before start time
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader assigns a start date to the activity
And the project leader assigns a deadline to the activity that is before the assigned start date
Then an error message "Deadline cannot be before the assigned start date" is presented