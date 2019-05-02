Feature: Aendring af aktivitet
Description: En projektleder aendrer en aktivitet
Actor: Projektleder

Scenario: Projekt leder aendrer en aktivitet
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader edits activity
Then the activity is changed

Scenario: En udviklingsmedarbejder aendrer en aktivitet
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And a development worker tries to edit an activity
Then an error message "Only project leader is allowed to edit activities"

Scenario: projekt leder aendrer sluttidspunkt til at vaere foer starttidspunkt
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"