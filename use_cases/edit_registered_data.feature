Feature: Edit previously registered data
Description: Development worker edits previously registered time on an activity
Actor: Development worker

Scenario: Editing previously registred time on an activity
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And the development worker inputs amount of hours worked for the day into the system
And the development worker edits previously added amount of work hours