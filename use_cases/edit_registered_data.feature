Feature: Rediger registreret data
Description: Udviklingsmedarbejder retter hvor meget tid der er brugt paa en aktivitet
Actor: Udviklingsmedarbejder

Scenario: Ret i registreret tid
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And the development worker inputs amount of hours worked for the day into the system
And the development worker edits previously added amount of work hours