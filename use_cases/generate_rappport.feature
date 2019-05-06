Feature: Generate a rapport of a project
Beskrivelse: Project leader generates a project development rapport
Aktoer: Project leader

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"

Scenario: Project leader generates a project development rapport from a project of which she is project leader of
When the project leader generates a project development rapport of the project of which the project leader is the project leader of
Then the development rapport is generated

Scenario: Development worker attempts to generate a project development rapport
When a development worker generates a project development rapport of a project
Then an error message "Action for project leader only" is presented