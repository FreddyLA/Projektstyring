Feature: Manning of activities
Description: Add development workers to an activities
Actor: Project leader

Scenario: Project leader adds a development worker to an activity
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader adds a development worker to an activity
Then the development worker has been added to the activity

Scenario: Project leader attempts to add a development worker, of which is already on 10 activities, to an activity
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader adds a development worker to an activity which is already assigned 10 activities
Then an error message "Selected development worker already assigned to 10 activities" is presented

Scenario: A development worker attempts to add another developemnt worker to an activity
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And a development worker assigns a new development worker the the activity
Then an error message "Only project leader can add workers to activity" is presented