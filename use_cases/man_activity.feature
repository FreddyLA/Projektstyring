Feature: Bemanding af aktivitet
Description: Tilfoej en udviklingsmedarbejder til en aktivitet
Actor: Projektleder

Scenario: Projekt leder tilfoejer udviklingsmedarbejder til aktivitet
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader adds a development worker to an activity
Then the development worker has been added to the activity

Scenario: Projekt leder tilfoejer udviklingsmedarbejder til aktivitet, som allerede er sat paa 10 aktiviteter
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader adds a development worker to an activity which is already assigned 10 activities
Then an error message "Selected development worker already assigned to 10 activities" is presented

Scenario: Udviklingsmedarbejder tilfoejer udviklingsmedarbejder til aktivitet
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And a development worker assigns a new development worker the the activity
Then an error message "Only project leader can add workers to activity" is presented