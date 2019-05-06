Feature: Development worker gets hours worked on the day
Description: Worker gets total amount of hours worked on the day
Actors: Development worker

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And a development worker is assigned the activity

Scenario: Worker gets the amount of hours he has worked on the day
Given the development worker inputs 8 hours worked on the activity into the system
And the development worker the next day inputs 5 hours worked on the activity into the system
When the development worker wants to know how many hours he has worked on the day
Then the development worker is told that he has worked 5 hours on the day
