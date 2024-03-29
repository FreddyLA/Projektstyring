Feature: Project leader finds available developers for an activity
Description: Project leader gets a list of developers available for an activity
Actors: Project leader

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Project leader gets a list of available developers 
Given the activity has a start date and end date
And a development worker is available in the given timeperiod
And a development worker is not available in the given timeperiod
When the project leader wants a list of available developers for the activity "Activity"
Then the project leader gets a list of developers, which contains the available development worker
And the list doesn't contain the unavailable developer

Scenario: Project leader want available developers for an activity that doesn't exist
When the project leader wants a list of available developers for the activity ""
Then an error message "Activity with specified name does not exist" is presented

Scenario: Project leader want available developers for an activity that doesnt't have a start date
Given the activity doesn't has a start date
When the project leader wants a list of available developers for the activity "Activity"
Then an error message "Activity doesn't have a start/enddate" is presented

Scenario: Project leader wants available developers for an activity that doesnt't have an end date
Given the activity doesn't has a end date
And the activity has a start date
When the project leader wants a list of available developers for the activity "Activity"
Then an error message "Activity doesn't have a start/enddate" is presented