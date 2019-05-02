Feature: Register time on personal schedule
Description: A development worker can register things like holidays, sickness and courses
Actor: A development worker

Scenario: A development worker registers time on personal schedule
Given a development worker inputs firm activity in his schedule
Then the system is updated with development workers registered firm activity
And the development worker cannot be added to an activity in the registered time frame

Scenario: A project leader attempts to add a development worker on an activity inside a timeframe that the developemnt worker already has registered personal time on her schedule
Given a development worker inputs firm activity in his schedule
And a project leader assigns the development worker to an activity during the firm activity timeframe
Then an error message "Development worker is not available for work on the activity"