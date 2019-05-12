Feature: Manning of activities
Description: Add development workers to an activities
Actor: Project leader

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Project leader adds a development worker to an activity
When the project leader adds a development worker to the activity
Then the development worker has been added to the activity

Scenario: Project leader adds a development worker, who is on 10 activities, who can work on 20 activities, to an activity
Given a development worker has 10 activities
And the development worker can work on 20 activities
When the project leader adds a development worker to the activity
Then the development worker has been added to the activity

Scenario: Project leader attempts to add a development worker, of which is already on 10 activities, to an activity
Given a development worker has 10 activities
When the project leader adds a development worker to the activity
Then an error message "Selected development worker already assigned to 10 activities" is presented

Scenario: A development worker attempts to add another developemnt worker to an activity
When a development worker assigns a new development worker to the activity
Then an error message "Action for project leader only" is presented

Scenario: Project leader adds development worker to the activity, when the development worker has a private activity during the activity
Given the activity has a start date and end date
And a development worker registers the private activity "Vacation"
When the project leader adds a development worker to the activity
Then an error message "Private activity not allowed during work activity" is presented
