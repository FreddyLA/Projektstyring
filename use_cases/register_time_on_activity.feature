Feature: Registering time on an activity
Description: Development workers register daily time used on an activity
Actor: Development worker

Scenario: A development worker registers time spend on an activity
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And the development worker inputs amount of hours worked for the day into the system
Then the system is updated with the given data

Scenario: Development worker registers time on an activity of which she is not part of or has helped with
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And the development worker inputs amount of hours worked for the day into the system
Then an error message "Specified user is not assigned to the activity"