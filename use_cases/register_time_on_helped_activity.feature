Feature: Register time on an activity of which a developemnt worker has helped another development worker with.
Description: Development workers can register time on an activity, which she is not part of, if another development worker is part of the activity and needs help
Actor: A development worker

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Register time on an activity of which a development worker has helped another development worker, which is part of the activity
Given a development worker is assigned the activity
And a different development worker is not assigned the activity
When the other worker inputs 8 hours to the activity together with the development workers initials
Then the other worker has worked 8 hours on the activity

Scenario: Register time on an activity of which a development worker has helped another development worker, which is NOT part of the project
Given a development worker is not assigned the activity
And a different development worker is not assigned the activity
When the other worker inputs 8 hours to the activity together with the development workers initials
Then an error message "Specified user is not assigned to the activity" is presented