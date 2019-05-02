Feature: Change activity
Description: A project leader edits activies
Actor: Project leader

Scenario: Project leader edits an activity
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader edits activity
Then the activity is changed

Scenario: A development worker edits an activity
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And a development worker attempts to edit an activity
Then an error message "Only project leader is allowed to edit activities"

Scenario: The project leader changes the deadline to be before the start time
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"