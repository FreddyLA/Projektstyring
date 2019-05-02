Feature: Generate a rapport of a project
Beskrivelse: Project leader generates a project development rapport
Aktoer: Project leader

Scenario: Project leader generates a project development rapport from a project of which she is project leader of
Given a project has been created
And the project has been worked on
And the project leader generates a project development rapport of the project of which the project leader is the project leader of
Then the generated development rapport is generated

Scenario: Project leader attempts to generate a project development rapport from a project she is not project leader of
Given a project has been created
And the project has been worked on
And the project leader generates a project development rapport of the project of which the project leader is not the project leader of
Then an error message "Only the project leader of the project can generate a development rapport of the project"

Scenario: Development worker attempts to generate a project development rapport
Given a project has been created
And the project has been worked on
And a development worker generates a project development rapport of a project
Then an error message "Only the project leader of the project can generate a development rapport of the project"