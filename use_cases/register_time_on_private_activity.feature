Feature: Register time on private activity
Description: A development worker can register things like holidays, sickness and courses
Actor: A development worker

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: A development worker registers time on a private 
When a development worker registers the private activity "Vacation"
Then the delopment worker has a private activity "Vacation"

Scenario: A development worker registers time on a private activity, when the development worker is assigned an activity in the time frame
Given a development worker is assigned the activity
And the activity has a start date and end date
When a development worker registers the private activity "Vacation"
Then an error message "Can't register personal activity, when worker has an activity" is presented