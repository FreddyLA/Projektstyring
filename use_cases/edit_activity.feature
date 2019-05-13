Feature: Change activity
Description: A project leader edits activies
Actor: Project leader

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Project leader edits an activity's budgettet time
When the project leader changes budgettet time to 10
Then the activity's budgettet time is 10

Scenario: Project leader edits an activity's start time
When the project leader changes the activity's start time
Then the activity's start time has been changed

Scenario: A development worker edits an activity
When a development worker attempts to edit an activity's budgettet time
Then an error message "Action for project leader only" is presented

Scenario: Create an activity with deadline before start time
When the project leader assigns a deadline to the activity that is before the assigned start date
Then an error message "Deadline cannot be before the assigned start date" is presented
