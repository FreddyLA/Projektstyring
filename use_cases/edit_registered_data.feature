Feature: Edit previously registered data
Description: Development worker edits previously registered time on an activity
Actor: Development worker

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Editing previously registred time on an activity
Given a development worker is assigned the activity
And the development worker inputs 8 hours worked on the activity into the system
When the development worker changes the hours worked on the activity from 8 to 5
Then the development worker's hours on the activity is 5