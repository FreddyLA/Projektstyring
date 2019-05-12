Feature: Registering time on an activity
Description: Development workers register daily time used on an activity
Actor: Development worker

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: A development worker registers time spend on an activity
Given a development worker is assigned the activity
When the development worker inputs 8 hours worked on the activity into the system
Then the development worker has worked 8 hours on the activity

Scenario: Development worker registers time on an activity of which she is not part of or has helped with
Given a development worker is not assigned the activity
When the development worker inputs 8 hours worked on the activity into the system
Then an error message "Specified user is not assigned to the activity" is presented

Scenario: Development worker registers time on an activity that doesn't excist
When a development worker registers time on activity that doesn't excist
Then an error message "Activity with specified name does not exist" is presented