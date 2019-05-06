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
And another developemnt worker is not available in the given timeperiod
When the project leader wants a list of available developers
Then the project leader gets a list of developers, which contains the available development worker
And the list doesn't contain the unavailable developer

Scenario: Project leader want available developers for an activity that doesnt't have a start date
Given the activity doesn't has a start date
When the project leader wants a list of available developers
Then an error message "Activity doesn't have a start/enddate" is presented

Scenario: Project leader wants available developers for an activity that doesnt't have a start date
Given the activity doesn't has a end date
When the project leader wants a list of available developers
Then an error message "Activity doesn't have a start/enddate" is presented

Scenario: Project leader wants avilable developers for an activity, but no developers are available
Given the activity has a start date and end date
And no developers are available in the given time period
Then the list doesn't contain any developers