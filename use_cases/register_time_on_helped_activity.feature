Feature: Registrer tid paa aktivitet, som en udviklingsmedarbejder har hjulpet en anden udviklingsmedarbejder med
Description: Udviklingsmedarbejder kan registrer tid hos en aktivitet, som man ikke er en del af, hvis en anden udviklingsmedarbejder paa aktiviteten soeger om hjaelp
Actor: Udviklingsmedarbejder

Scenario: Registrer tid paa aktivitet, som en udviklingsmedarbejder har hjulpet en anden udviklingsmedarbejder med
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And a different development worker is assigned the activity
And the worker inputs helping workhours to the activity together with the helped workers initials
Then the system is updated with the given data 

Scenario: Registrer tid paa aktivitet, som en udviklingsmedarbejder har hjulpet en anden udviklingsmedarbejder med, som den anden udviklingsmedarbejder ikke er en del af
Given a project has been created
And the project has an activity
And a development worker is not assigned the activity
And a different development worker is not assigned the activity either
And the worker inputs helping workhours to the activity together with the helped workers initials
Then an error message "Helped co-worker is not assigned to the specified activity"