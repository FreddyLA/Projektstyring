Feature: Register time on an activity of which a developemnt worker has helped another development worker with.
Description: Development workers can register time on an activity, which she is not part of, if another development worker is part of the activity and needs help
Actor: A development worker

Scenario: Register time on an activity of which a development worker has helped another development worker, which is part of the activity
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And a different development worker is assigned the activity
And the worker inputs helping workhours to the activity together with the helped workers initials
Then the system is updated with the given data 

Scenario: Register time on an activity of which a development worker has helped another development worker, which is NOT part of the project
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And a different development worker is not assigned the activity either
And the worker inputs helping workhours to the activity together with the helped workers initials
Then an error message "Helped co-worker is not assigned to the specified activity"