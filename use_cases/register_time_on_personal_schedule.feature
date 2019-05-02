Feature: Registrer tid paa fast aktivitet
Description: En udviklingsmedarbejder kan registrer ting som ferie, sygdom, kurser
Actor: Udviklingsmedarbejder

Scenario: Udviklingsmedarbejder registrerer fast aktivitet i sin tidsplan
Given a development worker inputs firm activity in his schedule
Then the system is updated with development workers registered firm activity
And the development worker cannot be added to an activity in the registered time frame

Scenario: Projektleder tilfoejer en udviklingsmedarbejder til en aktivitet i en allerede registreret fast activitet tidsramme
Given a development worker inputs firm activity in his schedule
And a project leader assigns the development worker to an activity during the firm activity timeframe
Then an error message "Development worker is not available for work on the activity"