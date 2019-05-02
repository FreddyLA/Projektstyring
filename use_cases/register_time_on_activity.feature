Feature: Registrering af tid paa aktivitet
Description: Udviklingsmedarbejder registrer hvor meget tid de har brugt paa en aktivitet
Actor: Udviklingsmedarbejder

Scenario: Udviklingsmedarbejder registrer tid brugt paa en aktivitet
Given a project has been created
And the project has an activity
And a development worker is assigned the activity
And the development worker inputs amount of hours worked for the day into the system
Then the system is updated with the given data

Scenario: Registrer tid paa aktivitet, som udviklingsmedarbejderen ikke er paa, eller hjaelper med
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And the development worker inputs amount of hours worked for the day into the system
Then an error message "Specified user is not assigned to the activity"